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
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
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
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class FulfillmentGroupImplDiffblueTest {
  @Autowired private FulfillmentGroupImpl fulfillmentGroupImpl;

  /**
   * Test {@link FulfillmentGroupImpl#getDiscreteOrderItems()}.
   *
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getDiscreteOrderItems()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List FulfillmentGroupImpl.getDiscreteOrderItems()"})
  public void testGetDiscreteOrderItems_givenFulfillmentGroupImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(fulfillmentGroupImpl.getDiscreteOrderItems().isEmpty());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getDiscreteOrderItems()}.
   *
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getDiscreteOrderItems()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List FulfillmentGroupImpl.getDiscreteOrderItems()"})
  public void testGetDiscreteOrderItems_thenReturnArrayList() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    fulfillmentGroupImpl.setFulfillmentGroupItems(fulfillmentGroupItems);

    // Act and Assert
    assertEquals(discreteOrderItems, fulfillmentGroupImpl.getDiscreteOrderItems());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getDiscreteOrderItems()}.
   *
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getDiscreteOrderItems()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List FulfillmentGroupImpl.getDiscreteOrderItems()"})
  public void testGetDiscreteOrderItems_thenReturnArrayList2() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    fulfillmentGroupItems.add(new FulfillmentGroupItemImpl());
    fulfillmentGroupItems.add(fulfillmentGroupItemImpl);
    fulfillmentGroupImpl.setFulfillmentGroupItems(fulfillmentGroupItems);

    // Act and Assert
    assertEquals(discreteOrderItems, fulfillmentGroupImpl.getDiscreteOrderItems());
  }

  /**
   * Test {@link FulfillmentGroupImpl#addFulfillmentGroupItem(FulfillmentGroupItem)}.
   *
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupImpl#addFulfillmentGroupItem(FulfillmentGroupItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupImpl.addFulfillmentGroupItem(FulfillmentGroupItem)"})
  public void testAddFulfillmentGroupItem_givenFulfillmentGroupImpl() {
    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItem = new FulfillmentGroupItemImpl();

    // Act
    fulfillmentGroupImpl.addFulfillmentGroupItem(fulfillmentGroupItem);

    // Assert
    List<FulfillmentGroupItem> fulfillmentGroupItems =
        fulfillmentGroupImpl.getFulfillmentGroupItems();
    assertEquals(1, fulfillmentGroupItems.size());
    assertTrue(fulfillmentGroupImpl.getDiscreteOrderItems().isEmpty());
    assertSame(fulfillmentGroupItem, fulfillmentGroupItems.get(0));
  }

  /**
   * Test {@link FulfillmentGroupImpl#addFulfillmentGroupItem(FulfillmentGroupItem)}.
   *
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl} FulfillmentGroupItems is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupImpl#addFulfillmentGroupItem(FulfillmentGroupItem)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupImpl.addFulfillmentGroupItem(FulfillmentGroupItem)"})
  public void testAddFulfillmentGroupItem_givenFulfillmentGroupImplFulfillmentGroupItemsIsNull() {
    // Arrange
    fulfillmentGroupImpl.setFulfillmentGroupItems(null);
    FulfillmentGroupItemImpl fulfillmentGroupItem = new FulfillmentGroupItemImpl();

    // Act
    fulfillmentGroupImpl.addFulfillmentGroupItem(fulfillmentGroupItem);

    // Assert
    List<FulfillmentGroupItem> fulfillmentGroupItems =
        fulfillmentGroupImpl.getFulfillmentGroupItems();
    assertEquals(1, fulfillmentGroupItems.size());
    assertTrue(fulfillmentGroupImpl.getDiscreteOrderItems().isEmpty());
    assertSame(fulfillmentGroupItem, fulfillmentGroupItems.get(0));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Address FulfillmentGroupImpl.getAddress()",
    "List FulfillmentGroupImpl.getCandidateFulfillmentGroupOffers()",
    "String FulfillmentGroupImpl.getDeliveryInstruction()",
    "List FulfillmentGroupImpl.getFulfillmentGroupAdjustments()",
    "List FulfillmentGroupImpl.getFulfillmentGroupFees()",
    "List FulfillmentGroupImpl.getFulfillmentGroupItems()",
    "FulfillmentOption FulfillmentGroupImpl.getFulfillmentOption()",
    "Long FulfillmentGroupImpl.getId()",
    "String FulfillmentGroupImpl.getMethod()",
    "Order FulfillmentGroupImpl.getOrder()",
    "PersonalMessage FulfillmentGroupImpl.getPersonalMessage()",
    "Phone FulfillmentGroupImpl.getPhone()",
    "String FulfillmentGroupImpl.getReferenceNumber()",
    "Integer FulfillmentGroupImpl.getSequence()",
    "String FulfillmentGroupImpl.getService()",
    "List FulfillmentGroupImpl.getTaxes()",
    "boolean FulfillmentGroupImpl.isPrimary()",
    "Boolean FulfillmentGroupImpl.isShippingPriceTaxable()",
    "void FulfillmentGroupImpl.setAddress(Address)",
    "void FulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(List)",
    "void FulfillmentGroupImpl.setDeliveryInstruction(String)",
    "void FulfillmentGroupImpl.setFulfillmentGroupAdjustments(List)",
    "void FulfillmentGroupImpl.setFulfillmentGroupFees(List)",
    "void FulfillmentGroupImpl.setFulfillmentGroupItems(List)",
    "void FulfillmentGroupImpl.setFulfillmentOption(FulfillmentOption)",
    "void FulfillmentGroupImpl.setId(Long)",
    "void FulfillmentGroupImpl.setIsShippingPriceTaxable(Boolean)",
    "void FulfillmentGroupImpl.setMethod(String)",
    "void FulfillmentGroupImpl.setOrder(Order)",
    "void FulfillmentGroupImpl.setPersonalMessage(PersonalMessage)",
    "void FulfillmentGroupImpl.setPhone(Phone)",
    "void FulfillmentGroupImpl.setPrimary(boolean)",
    "void FulfillmentGroupImpl.setReferenceNumber(String)",
    "void FulfillmentGroupImpl.setSequence(Integer)",
    "void FulfillmentGroupImpl.setService(String)",
    "void FulfillmentGroupImpl.setShippingOverride(Boolean)",
    "void FulfillmentGroupImpl.setTaxes(List)"
  })
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
    List<CandidateFulfillmentGroupOffer> actualCandidateFulfillmentGroupOffers =
        fulfillmentGroupImpl.getCandidateFulfillmentGroupOffers();
    String actualDeliveryInstruction = fulfillmentGroupImpl.getDeliveryInstruction();
    List<FulfillmentGroupAdjustment> actualFulfillmentGroupAdjustments =
        fulfillmentGroupImpl.getFulfillmentGroupAdjustments();
    List<FulfillmentGroupFee> actualFulfillmentGroupFees =
        fulfillmentGroupImpl.getFulfillmentGroupFees();
    List<FulfillmentGroupItem> actualFulfillmentGroupItems =
        fulfillmentGroupImpl.getFulfillmentGroupItems();
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

    // Assert
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
   * Test {@link FulfillmentGroupImpl#getRetailFulfillmentPrice()}.
   *
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getRetailFulfillmentPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getRetailFulfillmentPrice()"})
  public void testGetRetailFulfillmentPrice_givenFulfillmentGroupImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(fulfillmentGroupImpl.getRetailFulfillmentPrice());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getRetailFulfillmentPrice()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getRetailFulfillmentPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getRetailFulfillmentPrice()"})
  public void testGetRetailFulfillmentPrice_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(null);
    Money retailFulfillmentPrice = new Money();
    fulfillmentGroupImpl.setRetailFulfillmentPrice(retailFulfillmentPrice);
    fulfillmentGroupImpl.setOrder(order);

    // Act and Assert
    assertEquals(retailFulfillmentPrice, fulfillmentGroupImpl.getRetailFulfillmentPrice());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getRetailFulfillmentPrice()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getRetailFulfillmentPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getRetailFulfillmentPrice()"})
  public void testGetRetailFulfillmentPrice_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(currency);
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setOrder(order);

    // Act
    Money actualRetailFulfillmentPrice = fulfillmentGroupImpl.getRetailFulfillmentPrice();

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualRetailFulfillmentPrice.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
    Money actualAbsResult = actualRetailFulfillmentPrice.abs();
    assertEquals(actualRetailFulfillmentPrice, actualAbsResult);
    Money actualZeroResult = actualRetailFulfillmentPrice.zero();
    assertEquals(actualRetailFulfillmentPrice, actualZeroResult);
  }

  /**
   * Test {@link FulfillmentGroupImpl#setRetailFulfillmentPrice(Money)}.
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#setRetailFulfillmentPrice(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupImpl.setRetailFulfillmentPrice(Money)"})
  public void testSetRetailFulfillmentPrice() {
    // Arrange
    Money retailFulfillmentPrice = new Money();

    // Act
    fulfillmentGroupImpl.setRetailFulfillmentPrice(retailFulfillmentPrice);

    // Assert
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupImpl.retailFulfillmentPrice);
    BigDecimal bigDecimal = fulfillmentGroupImpl.retailFulfillmentPrice;
    Money absResult = retailFulfillmentPrice.abs();
    assertSame(bigDecimal, absResult.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.getAmount());
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = retailFulfillmentPrice.zero();
    Money absResult3 = zeroResult.abs();
    assertSame(bigDecimal, absResult3.abs().getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult2 = absResult.zero();
    assertSame(bigDecimal, zeroResult2.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    assertSame(bigDecimal, zeroResult3.abs().getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, absResult2.zero().getAmount());
    assertSame(bigDecimal, absResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult2.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.zero().getAmount());
  }

  /**
   * Test {@link FulfillmentGroupImpl#setRetailFulfillmentPrice(Money)}.
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#setRetailFulfillmentPrice(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupImpl.setRetailFulfillmentPrice(Money)"})
  public void testSetRetailFulfillmentPrice2() {
    // Arrange and Act
    fulfillmentGroupImpl.setRetailFulfillmentPrice(null);

    // Assert that nothing has changed
    assertNull(fulfillmentGroupImpl.retailFulfillmentPrice);
  }

  /**
   * Test {@link FulfillmentGroupImpl#getRetailShippingPrice()}.
   *
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getRetailShippingPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getRetailShippingPrice()"})
  public void testGetRetailShippingPrice_givenFulfillmentGroupImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(fulfillmentGroupImpl.getRetailShippingPrice());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getRetailShippingPrice()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getRetailShippingPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getRetailShippingPrice()"})
  public void testGetRetailShippingPrice_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(null);
    Money retailFulfillmentPrice = new Money();
    fulfillmentGroupImpl.setRetailFulfillmentPrice(retailFulfillmentPrice);
    fulfillmentGroupImpl.setOrder(order);

    // Act and Assert
    assertEquals(retailFulfillmentPrice, fulfillmentGroupImpl.getRetailShippingPrice());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getRetailShippingPrice()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getRetailShippingPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getRetailShippingPrice()"})
  public void testGetRetailShippingPrice_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(currency);
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setOrder(order);

    // Act
    Money actualRetailShippingPrice = fulfillmentGroupImpl.getRetailShippingPrice();

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualRetailShippingPrice.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
    Money actualAbsResult = actualRetailShippingPrice.abs();
    assertEquals(actualRetailShippingPrice, actualAbsResult);
    Money actualZeroResult = actualRetailShippingPrice.zero();
    assertEquals(actualRetailShippingPrice, actualZeroResult);
  }

  /**
   * Test {@link FulfillmentGroupImpl#setRetailShippingPrice(Money)}.
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#setRetailShippingPrice(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupImpl.setRetailShippingPrice(Money)"})
  public void testSetRetailShippingPrice() {
    // Arrange
    Money retailShippingPrice = new Money();

    // Act
    fulfillmentGroupImpl.setRetailShippingPrice(retailShippingPrice);

    // Assert
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupImpl.retailFulfillmentPrice);
    BigDecimal bigDecimal = fulfillmentGroupImpl.retailFulfillmentPrice;
    Money absResult = retailShippingPrice.abs();
    assertSame(bigDecimal, absResult.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.getAmount());
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = retailShippingPrice.zero();
    Money absResult3 = zeroResult.abs();
    assertSame(bigDecimal, absResult3.abs().getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult2 = absResult.zero();
    assertSame(bigDecimal, zeroResult2.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    assertSame(bigDecimal, zeroResult3.abs().getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, absResult2.zero().getAmount());
    assertSame(bigDecimal, absResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult2.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.zero().getAmount());
  }

  /**
   * Test {@link FulfillmentGroupImpl#setRetailShippingPrice(Money)}.
   *
   * <ul>
   *   <li>Then {@link FulfillmentGroupImpl} {@link FulfillmentGroupImpl#retailFulfillmentPrice} is
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#setRetailShippingPrice(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupImpl.setRetailShippingPrice(Money)"})
  public void testSetRetailShippingPrice_thenFulfillmentGroupImplRetailFulfillmentPriceIsNull() {
    // Arrange and Act
    fulfillmentGroupImpl.setRetailShippingPrice(null);

    // Assert that nothing has changed
    assertNull(fulfillmentGroupImpl.retailFulfillmentPrice);
  }

  /**
   * Test {@link FulfillmentGroupImpl#getType()}.
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FulfillmentType FulfillmentGroupImpl.getType()"})
  public void testGetType() {
    // Arrange, Act and Assert
    assertNull(fulfillmentGroupImpl.getType());
  }

  /**
   * Test {@link FulfillmentGroupImpl#setType(FulfillmentType)}.
   *
   * <ul>
   *   <li>When {@link FulfillmentType#DIGITAL}.
   *   <li>Then {@link FulfillmentGroupImpl} {@link FulfillmentGroupImpl#type} is {@code DIGITAL}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#setType(FulfillmentType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupImpl.setType(FulfillmentType)"})
  public void testSetType_whenDigital_thenFulfillmentGroupImplTypeIsDigital() {
    // Arrange and Act
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);

    // Assert
    assertEquals("DIGITAL", fulfillmentGroupImpl.type);
    assertSame(FulfillmentType.DIGITAL, fulfillmentGroupImpl.getType());
  }

  /**
   * Test {@link FulfillmentGroupImpl#setType(FulfillmentType)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link FulfillmentGroupImpl} {@link FulfillmentGroupImpl#type} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#setType(FulfillmentType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupImpl.setType(FulfillmentType)"})
  public void testSetType_whenNull_thenFulfillmentGroupImplTypeIsNull() {
    // Arrange and Act
    fulfillmentGroupImpl.setType(null);

    // Assert that nothing has changed
    assertNull(fulfillmentGroupImpl.type);
    assertNull(fulfillmentGroupImpl.getType());
  }

  /**
   * Test {@link
   * FulfillmentGroupImpl#addCandidateFulfillmentGroupOffer(CandidateFulfillmentGroupOffer)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupImpl#addCandidateFulfillmentGroupOffer(CandidateFulfillmentGroupOffer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FulfillmentGroupImpl.addCandidateFulfillmentGroupOffer(CandidateFulfillmentGroupOffer)"
  })
  public void testAddCandidateFulfillmentGroupOffer() {
    // Arrange
    CandidateFulfillmentGroupOfferImpl candidateOffer = new CandidateFulfillmentGroupOfferImpl();

    // Act
    fulfillmentGroupImpl.addCandidateFulfillmentGroupOffer(candidateOffer);

    // Assert
    List<CandidateFulfillmentGroupOffer> candidateFulfillmentGroupOffers =
        fulfillmentGroupImpl.getCandidateFulfillmentGroupOffers();
    assertEquals(1, candidateFulfillmentGroupOffers.size());
    assertSame(candidateOffer, candidateFulfillmentGroupOffers.get(0));
  }

  /**
   * Test {@link FulfillmentGroupImpl#removeAllCandidateOffers()}.
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#removeAllCandidateOffers()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupImpl.removeAllCandidateOffers()"})
  public void testRemoveAllCandidateOffers() {
    // Arrange
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(null);

    // Act
    fulfillmentGroupImpl.removeAllCandidateOffers();

    // Assert that nothing has changed
    assertNull(fulfillmentGroupImpl.getCandidateFulfillmentGroupOffers());
  }

  /**
   * Test {@link FulfillmentGroupImpl#removeAllCandidateOffers()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CandidateFulfillmentGroupOfferImpl}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#removeAllCandidateOffers()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupImpl.removeAllCandidateOffers()"})
  public void testRemoveAllCandidateOffers_givenArrayListAddCandidateFulfillmentGroupOfferImpl() {
    // Arrange
    ArrayList<CandidateFulfillmentGroupOffer> candidateOffers = new ArrayList<>();
    candidateOffers.add(new CandidateFulfillmentGroupOfferImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(candidateOffers);

    // Act
    fulfillmentGroupImpl.removeAllCandidateOffers();

    // Assert
    assertTrue(fulfillmentGroupImpl.getCandidateFulfillmentGroupOffers().isEmpty());
  }

  /**
   * Test {@link FulfillmentGroupImpl#removeAllCandidateOffers()}.
   *
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#removeAllCandidateOffers()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupImpl.removeAllCandidateOffers()"})
  public void testRemoveAllCandidateOffers_givenFulfillmentGroupImpl() {
    // Arrange and Act
    fulfillmentGroupImpl.removeAllCandidateOffers();

    // Assert that nothing has changed
    assertTrue(fulfillmentGroupImpl.getCandidateFulfillmentGroupOffers().isEmpty());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getFutureCreditFulfillmentGroupAdjustments()}.
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getFutureCreditFulfillmentGroupAdjustments()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List FulfillmentGroupImpl.getFutureCreditFulfillmentGroupAdjustments()"})
  public void testGetFutureCreditFulfillmentGroupAdjustments() {
    // Arrange
    ArrayList<FulfillmentGroupAdjustment> fulfillmentGroupAdjustments = new ArrayList<>();
    fulfillmentGroupAdjustments.add(new FulfillmentGroupAdjustmentImpl());
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(fulfillmentGroupAdjustments);

    // Act and Assert
    assertTrue(fulfillmentGroupImpl.getFutureCreditFulfillmentGroupAdjustments().isEmpty());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getFutureCreditFulfillmentGroupAdjustments()}.
   *
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getFutureCreditFulfillmentGroupAdjustments()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List FulfillmentGroupImpl.getFutureCreditFulfillmentGroupAdjustments()"})
  public void testGetFutureCreditFulfillmentGroupAdjustments_givenFulfillmentGroupImpl() {
    // Arrange, Act and Assert
    assertTrue(fulfillmentGroupImpl.getFutureCreditFulfillmentGroupAdjustments().isEmpty());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getFutureCreditFulfillmentGroupAdjustments()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getFutureCreditFulfillmentGroupAdjustments()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List FulfillmentGroupImpl.getFutureCreditFulfillmentGroupAdjustments()"})
  public void testGetFutureCreditFulfillmentGroupAdjustments_thenReturnSizeIsOne() {
    // Arrange
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl =
        mock(FulfillmentGroupAdjustmentImpl.class);
    when(fulfillmentGroupAdjustmentImpl.isFutureCredit()).thenReturn(true);

    ArrayList<FulfillmentGroupAdjustment> fulfillmentGroupAdjustments = new ArrayList<>();
    fulfillmentGroupAdjustments.add(fulfillmentGroupAdjustmentImpl);
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(fulfillmentGroupAdjustments);

    // Act
    List<FulfillmentGroupAdjustment> actualFutureCreditFulfillmentGroupAdjustments =
        fulfillmentGroupImpl.getFutureCreditFulfillmentGroupAdjustments();

    // Assert
    verify(fulfillmentGroupAdjustmentImpl).isFutureCredit();
    assertEquals(1, actualFutureCreditFulfillmentGroupAdjustments.size());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getFulfillmentGroupAdjustmentsValue()}.
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getFulfillmentGroupAdjustmentsValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getFulfillmentGroupAdjustmentsValue()"})
  public void testGetFulfillmentGroupAdjustmentsValue() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setOrder(order);

    // Act
    Money actualFulfillmentGroupAdjustmentsValue =
        fulfillmentGroupImpl.getFulfillmentGroupAdjustmentsValue();

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    Currency currency = actualFulfillmentGroupAdjustmentsValue.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(826, currency.getNumericCode());
    Money actualAbsResult = actualFulfillmentGroupAdjustmentsValue.abs();
    assertEquals(actualFulfillmentGroupAdjustmentsValue, actualAbsResult);
    Money actualZeroResult = actualFulfillmentGroupAdjustmentsValue.zero();
    assertEquals(actualFulfillmentGroupAdjustmentsValue, actualZeroResult);
  }

  /**
   * Test {@link FulfillmentGroupImpl#getFulfillmentGroupAdjustmentsValue()}.
   *
   * <ul>
   *   <li>Then calls {@link FulfillmentGroupAdjustmentImpl#isFutureCredit()}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getFulfillmentGroupAdjustmentsValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getFulfillmentGroupAdjustmentsValue()"})
  public void testGetFulfillmentGroupAdjustmentsValue_thenCallsIsFutureCredit() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl =
        mock(FulfillmentGroupAdjustmentImpl.class);
    when(fulfillmentGroupAdjustmentImpl.isFutureCredit()).thenReturn(true);
    doNothing()
        .when(fulfillmentGroupAdjustmentImpl)
        .setFulfillmentGroup(Mockito.<FulfillmentGroup>any());
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(mock(FulfillmentGroup.class));

    ArrayList<FulfillmentGroupAdjustment> fulfillmentGroupAdjustments = new ArrayList<>();
    fulfillmentGroupAdjustments.add(fulfillmentGroupAdjustmentImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(fulfillmentGroupAdjustments);
    fulfillmentGroupImpl.setOrder(order);

    // Act
    Money actualFulfillmentGroupAdjustmentsValue =
        fulfillmentGroupImpl.getFulfillmentGroupAdjustmentsValue();

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(fulfillmentGroupAdjustmentImpl).isFutureCredit();
    verify(fulfillmentGroupAdjustmentImpl).setFulfillmentGroup(isA(FulfillmentGroup.class));
    verify(order).getCurrency();
    Currency currency = actualFulfillmentGroupAdjustmentsValue.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(826, currency.getNumericCode());
    Money actualAbsResult = actualFulfillmentGroupAdjustmentsValue.abs();
    assertEquals(actualFulfillmentGroupAdjustmentsValue, actualAbsResult);
    Money actualZeroResult = actualFulfillmentGroupAdjustmentsValue.zero();
    assertEquals(actualFulfillmentGroupAdjustmentsValue, actualZeroResult);
  }

  /**
   * Test {@link FulfillmentGroupImpl#getFulfillmentGroupAdjustmentsValue()}.
   *
   * <ul>
   *   <li>Then return {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getFulfillmentGroupAdjustmentsValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getFulfillmentGroupAdjustmentsValue()"})
  public void testGetFulfillmentGroupAdjustmentsValue_thenReturnZero() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);

    // Act and Assert
    assertEquals(Money.ZERO, fulfillmentGroupImpl.getFulfillmentGroupAdjustmentsValue());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getFutureCreditFulfillmentGroupAdjustmentsValue()}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupImpl#getFutureCreditFulfillmentGroupAdjustmentsValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Money FulfillmentGroupImpl.getFutureCreditFulfillmentGroupAdjustmentsValue()"
  })
  public void testGetFutureCreditFulfillmentGroupAdjustmentsValue() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setOrder(order);

    // Act
    Money actualFutureCreditFulfillmentGroupAdjustmentsValue =
        fulfillmentGroupImpl.getFutureCreditFulfillmentGroupAdjustmentsValue();

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    Currency currency = actualFutureCreditFulfillmentGroupAdjustmentsValue.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(826, currency.getNumericCode());
    Money actualAbsResult = actualFutureCreditFulfillmentGroupAdjustmentsValue.abs();
    assertEquals(actualFutureCreditFulfillmentGroupAdjustmentsValue, actualAbsResult);
    Money actualZeroResult = actualFutureCreditFulfillmentGroupAdjustmentsValue.zero();
    assertEquals(actualFutureCreditFulfillmentGroupAdjustmentsValue, actualZeroResult);
  }

  /**
   * Test {@link FulfillmentGroupImpl#getFutureCreditFulfillmentGroupAdjustmentsValue()}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupImpl#getFutureCreditFulfillmentGroupAdjustmentsValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Money FulfillmentGroupImpl.getFutureCreditFulfillmentGroupAdjustmentsValue()"
  })
  public void testGetFutureCreditFulfillmentGroupAdjustmentsValue2() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    ArrayList<FulfillmentGroupAdjustment> fulfillmentGroupAdjustments = new ArrayList<>();
    fulfillmentGroupAdjustments.add(new FulfillmentGroupAdjustmentImpl());

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(fulfillmentGroupAdjustments);
    fulfillmentGroupImpl.setOrder(order);

    // Act
    Money actualFutureCreditFulfillmentGroupAdjustmentsValue =
        fulfillmentGroupImpl.getFutureCreditFulfillmentGroupAdjustmentsValue();

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    Currency currency = actualFutureCreditFulfillmentGroupAdjustmentsValue.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(826, currency.getNumericCode());
    Money actualAbsResult = actualFutureCreditFulfillmentGroupAdjustmentsValue.abs();
    assertEquals(actualFutureCreditFulfillmentGroupAdjustmentsValue, actualAbsResult);
    Money actualZeroResult = actualFutureCreditFulfillmentGroupAdjustmentsValue.zero();
    assertEquals(actualFutureCreditFulfillmentGroupAdjustmentsValue, actualZeroResult);
  }

  /**
   * Test {@link FulfillmentGroupImpl#getFutureCreditFulfillmentGroupAdjustmentsValue()}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupImpl#getFutureCreditFulfillmentGroupAdjustmentsValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Money FulfillmentGroupImpl.getFutureCreditFulfillmentGroupAdjustmentsValue()"
  })
  public void testGetFutureCreditFulfillmentGroupAdjustmentsValue3() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl =
        mock(FulfillmentGroupAdjustmentImpl.class);
    when(fulfillmentGroupAdjustmentImpl.isFutureCredit()).thenReturn(true);

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setOrder(NullOrderFactoryImpl.NULL_ORDER);

    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl2 =
        new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl2.setFulfillmentGroup(fulfillmentGroup);
    fulfillmentGroupAdjustmentImpl2.setFutureCredit(true);

    ArrayList<FulfillmentGroupAdjustment> fulfillmentGroupAdjustments = new ArrayList<>();
    fulfillmentGroupAdjustments.add(fulfillmentGroupAdjustmentImpl2);
    fulfillmentGroupAdjustments.add(fulfillmentGroupAdjustmentImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(fulfillmentGroupAdjustments);
    fulfillmentGroupImpl.setOrder(order);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> fulfillmentGroupImpl.getFutureCreditFulfillmentGroupAdjustmentsValue());
    verify(broadleafCurrency).getCurrencyCode();
    verify(fulfillmentGroupAdjustmentImpl).isFutureCredit();
    verify(order).getCurrency();
  }

  /**
   * Test {@link FulfillmentGroupImpl#getFutureCreditFulfillmentGroupAdjustmentsValue()}.
   *
   * <ul>
   *   <li>Then calls {@link FulfillmentGroup#getOrder()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupImpl#getFutureCreditFulfillmentGroupAdjustmentsValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Money FulfillmentGroupImpl.getFutureCreditFulfillmentGroupAdjustmentsValue()"
  })
  public void testGetFutureCreditFulfillmentGroupAdjustmentsValue_thenCallsGetOrder() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl =
        mock(FulfillmentGroupAdjustmentImpl.class);
    when(fulfillmentGroupAdjustmentImpl.isFutureCredit()).thenReturn(true);

    FulfillmentGroup fulfillmentGroup = mock(FulfillmentGroup.class);
    when(fulfillmentGroup.getOrder()).thenReturn(NullOrderFactoryImpl.NULL_ORDER);

    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl2 =
        new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl2.setFulfillmentGroup(fulfillmentGroup);
    fulfillmentGroupAdjustmentImpl2.setFutureCredit(true);

    ArrayList<FulfillmentGroupAdjustment> fulfillmentGroupAdjustments = new ArrayList<>();
    fulfillmentGroupAdjustments.add(fulfillmentGroupAdjustmentImpl2);
    fulfillmentGroupAdjustments.add(fulfillmentGroupAdjustmentImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(fulfillmentGroupAdjustments);
    fulfillmentGroupImpl.setOrder(order);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> fulfillmentGroupImpl.getFutureCreditFulfillmentGroupAdjustmentsValue());
    verify(broadleafCurrency).getCurrencyCode();
    verify(fulfillmentGroupAdjustmentImpl).isFutureCredit();
    verify(fulfillmentGroup).getOrder();
    verify(order).getCurrency();
  }

  /**
   * Test {@link FulfillmentGroupImpl#getFutureCreditFulfillmentGroupAdjustmentsValue()}.
   *
   * <ul>
   *   <li>Then return {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupImpl#getFutureCreditFulfillmentGroupAdjustmentsValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Money FulfillmentGroupImpl.getFutureCreditFulfillmentGroupAdjustmentsValue()"
  })
  public void testGetFutureCreditFulfillmentGroupAdjustmentsValue_thenReturnZero() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);

    // Act and Assert
    assertEquals(
        Money.ZERO, fulfillmentGroupImpl.getFutureCreditFulfillmentGroupAdjustmentsValue());
  }

  /**
   * Test {@link FulfillmentGroupImpl#removeAllAdjustments()}.
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#removeAllAdjustments()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupImpl.removeAllAdjustments()"})
  public void testRemoveAllAdjustments() {
    // Arrange
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(null);

    // Act
    fulfillmentGroupImpl.removeAllAdjustments();

    // Assert that nothing has changed
    assertNull(fulfillmentGroupImpl.getFulfillmentGroupAdjustments());
  }

  /**
   * Test {@link FulfillmentGroupImpl#removeAllAdjustments()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link FulfillmentGroupAdjustmentImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#removeAllAdjustments()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupImpl.removeAllAdjustments()"})
  public void testRemoveAllAdjustments_givenArrayListAddFulfillmentGroupAdjustmentImpl() {
    // Arrange
    ArrayList<FulfillmentGroupAdjustment> fulfillmentGroupAdjustments = new ArrayList<>();
    fulfillmentGroupAdjustments.add(new FulfillmentGroupAdjustmentImpl());
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(fulfillmentGroupAdjustments);

    // Act
    fulfillmentGroupImpl.removeAllAdjustments();

    // Assert
    assertTrue(fulfillmentGroupImpl.getFulfillmentGroupAdjustments().isEmpty());
  }

  /**
   * Test {@link FulfillmentGroupImpl#removeAllAdjustments()}.
   *
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#removeAllAdjustments()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupImpl.removeAllAdjustments()"})
  public void testRemoveAllAdjustments_givenFulfillmentGroupImpl() {
    // Arrange and Act
    fulfillmentGroupImpl.removeAllAdjustments();

    // Assert that nothing has changed
    assertTrue(fulfillmentGroupImpl.getFulfillmentGroupAdjustments().isEmpty());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getSaleFulfillmentPrice()}.
   *
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getSaleFulfillmentPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getSaleFulfillmentPrice()"})
  public void testGetSaleFulfillmentPrice_givenFulfillmentGroupImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(fulfillmentGroupImpl.getSaleFulfillmentPrice());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getSaleFulfillmentPrice()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getSaleFulfillmentPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getSaleFulfillmentPrice()"})
  public void testGetSaleFulfillmentPrice_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(null);
    Money saleFulfillmentPrice = new Money();
    fulfillmentGroupImpl.setSaleFulfillmentPrice(saleFulfillmentPrice);
    fulfillmentGroupImpl.setOrder(order);

    // Act and Assert
    assertEquals(saleFulfillmentPrice, fulfillmentGroupImpl.getSaleFulfillmentPrice());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getSaleFulfillmentPrice()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getSaleFulfillmentPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getSaleFulfillmentPrice()"})
  public void testGetSaleFulfillmentPrice_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(currency);
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setOrder(order);

    // Act
    Money actualSaleFulfillmentPrice = fulfillmentGroupImpl.getSaleFulfillmentPrice();

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualSaleFulfillmentPrice.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
    Money actualAbsResult = actualSaleFulfillmentPrice.abs();
    assertEquals(actualSaleFulfillmentPrice, actualAbsResult);
    Money actualZeroResult = actualSaleFulfillmentPrice.zero();
    assertEquals(actualSaleFulfillmentPrice, actualZeroResult);
  }

  /**
   * Test {@link FulfillmentGroupImpl#setSaleFulfillmentPrice(Money)}.
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#setSaleFulfillmentPrice(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupImpl.setSaleFulfillmentPrice(Money)"})
  public void testSetSaleFulfillmentPrice() {
    // Arrange
    Money saleFulfillmentPrice = new Money();

    // Act
    fulfillmentGroupImpl.setSaleFulfillmentPrice(saleFulfillmentPrice);

    // Assert
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupImpl.saleFulfillmentPrice);
    BigDecimal bigDecimal = fulfillmentGroupImpl.saleFulfillmentPrice;
    Money absResult = saleFulfillmentPrice.abs();
    assertSame(bigDecimal, absResult.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.getAmount());
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = saleFulfillmentPrice.zero();
    Money absResult3 = zeroResult.abs();
    assertSame(bigDecimal, absResult3.abs().getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult2 = absResult.zero();
    assertSame(bigDecimal, zeroResult2.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    assertSame(bigDecimal, zeroResult3.abs().getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, absResult2.zero().getAmount());
    assertSame(bigDecimal, absResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult2.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.zero().getAmount());
  }

  /**
   * Test {@link FulfillmentGroupImpl#setSaleFulfillmentPrice(Money)}.
   *
   * <ul>
   *   <li>Then {@link FulfillmentGroupImpl} {@link FulfillmentGroupImpl#saleFulfillmentPrice} is
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#setSaleFulfillmentPrice(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupImpl.setSaleFulfillmentPrice(Money)"})
  public void testSetSaleFulfillmentPrice_thenFulfillmentGroupImplSaleFulfillmentPriceIsNull() {
    // Arrange and Act
    fulfillmentGroupImpl.setSaleFulfillmentPrice(null);

    // Assert that nothing has changed
    assertNull(fulfillmentGroupImpl.saleFulfillmentPrice);
  }

  /**
   * Test {@link FulfillmentGroupImpl#getSaleShippingPrice()}.
   *
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getSaleShippingPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getSaleShippingPrice()"})
  public void testGetSaleShippingPrice_givenFulfillmentGroupImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(fulfillmentGroupImpl.getSaleShippingPrice());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getSaleShippingPrice()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getSaleShippingPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getSaleShippingPrice()"})
  public void testGetSaleShippingPrice_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(null);
    Money saleFulfillmentPrice = new Money();
    fulfillmentGroupImpl.setSaleFulfillmentPrice(saleFulfillmentPrice);
    fulfillmentGroupImpl.setOrder(order);

    // Act and Assert
    assertEquals(saleFulfillmentPrice, fulfillmentGroupImpl.getSaleShippingPrice());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getSaleShippingPrice()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getSaleShippingPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getSaleShippingPrice()"})
  public void testGetSaleShippingPrice_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(currency);
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setOrder(order);

    // Act
    Money actualSaleShippingPrice = fulfillmentGroupImpl.getSaleShippingPrice();

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualSaleShippingPrice.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
    Money actualAbsResult = actualSaleShippingPrice.abs();
    assertEquals(actualSaleShippingPrice, actualAbsResult);
    Money actualZeroResult = actualSaleShippingPrice.zero();
    assertEquals(actualSaleShippingPrice, actualZeroResult);
  }

  /**
   * Test {@link FulfillmentGroupImpl#setSaleShippingPrice(Money)}.
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#setSaleShippingPrice(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupImpl.setSaleShippingPrice(Money)"})
  public void testSetSaleShippingPrice() {
    // Arrange
    Money saleShippingPrice = new Money();

    // Act
    fulfillmentGroupImpl.setSaleShippingPrice(saleShippingPrice);

    // Assert
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupImpl.saleFulfillmentPrice);
    BigDecimal bigDecimal = fulfillmentGroupImpl.saleFulfillmentPrice;
    Money absResult = saleShippingPrice.abs();
    assertSame(bigDecimal, absResult.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.getAmount());
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = saleShippingPrice.zero();
    Money absResult3 = zeroResult.abs();
    assertSame(bigDecimal, absResult3.abs().getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult2 = absResult.zero();
    assertSame(bigDecimal, zeroResult2.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    assertSame(bigDecimal, zeroResult3.abs().getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, absResult2.zero().getAmount());
    assertSame(bigDecimal, absResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult2.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.zero().getAmount());
  }

  /**
   * Test {@link FulfillmentGroupImpl#setSaleShippingPrice(Money)}.
   *
   * <ul>
   *   <li>Then {@link FulfillmentGroupImpl} {@link FulfillmentGroupImpl#saleFulfillmentPrice} is
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#setSaleShippingPrice(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupImpl.setSaleShippingPrice(Money)"})
  public void testSetSaleShippingPrice_thenFulfillmentGroupImplSaleFulfillmentPriceIsNull() {
    // Arrange and Act
    fulfillmentGroupImpl.setSaleShippingPrice(null);

    // Assert that nothing has changed
    assertNull(fulfillmentGroupImpl.saleFulfillmentPrice);
  }

  /**
   * Test {@link FulfillmentGroupImpl#getFulfillmentPrice()}.
   *
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getFulfillmentPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getFulfillmentPrice()"})
  public void testGetFulfillmentPrice_givenFulfillmentGroupImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(fulfillmentGroupImpl.getFulfillmentPrice());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getFulfillmentPrice()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getFulfillmentPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getFulfillmentPrice()"})
  public void testGetFulfillmentPrice_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(null);
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl.setFulfillmentPrice(fulfillmentPrice);
    fulfillmentGroupImpl.setOrder(order);

    // Act and Assert
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getFulfillmentPrice());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getFulfillmentPrice()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getFulfillmentPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getFulfillmentPrice()"})
  public void testGetFulfillmentPrice_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(currency);
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setOrder(order);

    // Act
    Money actualFulfillmentPrice = fulfillmentGroupImpl.getFulfillmentPrice();

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualFulfillmentPrice.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
    Money actualAbsResult = actualFulfillmentPrice.abs();
    assertEquals(actualFulfillmentPrice, actualAbsResult);
    Money actualZeroResult = actualFulfillmentPrice.zero();
    assertEquals(actualFulfillmentPrice, actualZeroResult);
  }

  /**
   * Test {@link FulfillmentGroupImpl#setFulfillmentPrice(Money)}.
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#setFulfillmentPrice(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupImpl.setFulfillmentPrice(Money)"})
  public void testSetFulfillmentPrice() {
    // Arrange
    Money fulfillmentPrice = new Money();

    // Act
    fulfillmentGroupImpl.setFulfillmentPrice(fulfillmentPrice);

    // Assert
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupImpl.fulfillmentPrice);
    BigDecimal bigDecimal = fulfillmentGroupImpl.fulfillmentPrice;
    Money absResult = fulfillmentPrice.abs();
    assertSame(bigDecimal, absResult.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.getAmount());
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = fulfillmentPrice.zero();
    Money absResult3 = zeroResult.abs();
    assertSame(bigDecimal, absResult3.abs().getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult2 = absResult.zero();
    assertSame(bigDecimal, zeroResult2.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    assertSame(bigDecimal, zeroResult3.abs().getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, absResult2.zero().getAmount());
    assertSame(bigDecimal, absResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult2.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.zero().getAmount());
  }

  /**
   * Test {@link FulfillmentGroupImpl#setFulfillmentPrice(Money)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link FulfillmentGroupImpl} {@link FulfillmentGroupImpl#fulfillmentPrice} is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#setFulfillmentPrice(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupImpl.setFulfillmentPrice(Money)"})
  public void testSetFulfillmentPrice_whenNull_thenFulfillmentGroupImplFulfillmentPriceIsNull() {
    // Arrange and Act
    fulfillmentGroupImpl.setFulfillmentPrice(null);

    // Assert that nothing has changed
    assertNull(fulfillmentGroupImpl.fulfillmentPrice);
  }

  /**
   * Test {@link FulfillmentGroupImpl#getShippingPrice()}.
   *
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getShippingPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getShippingPrice()"})
  public void testGetShippingPrice_givenFulfillmentGroupImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(fulfillmentGroupImpl.getShippingPrice());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getShippingPrice()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getShippingPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getShippingPrice()"})
  public void testGetShippingPrice_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(null);
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl.setFulfillmentPrice(fulfillmentPrice);
    fulfillmentGroupImpl.setOrder(order);

    // Act and Assert
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl.getShippingPrice());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getShippingPrice()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getShippingPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getShippingPrice()"})
  public void testGetShippingPrice_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(currency);
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setOrder(order);

    // Act
    Money actualShippingPrice = fulfillmentGroupImpl.getShippingPrice();

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualShippingPrice.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
    Money actualAbsResult = actualShippingPrice.abs();
    assertEquals(actualShippingPrice, actualAbsResult);
    Money actualZeroResult = actualShippingPrice.zero();
    assertEquals(actualShippingPrice, actualZeroResult);
  }

  /**
   * Test {@link FulfillmentGroupImpl#setShippingPrice(Money)}.
   *
   * <ul>
   *   <li>Then {@link FulfillmentGroupImpl} {@link FulfillmentGroupImpl#fulfillmentPrice} is {@link
   *       BigDecimal#BigDecimal(String)} with {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#setShippingPrice(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupImpl.setShippingPrice(Money)"})
  public void testSetShippingPrice_thenFulfillmentGroupImplFulfillmentPriceIsBigDecimalWith000() {
    // Arrange
    Money shippingPrice = new Money();

    // Act
    fulfillmentGroupImpl.setShippingPrice(shippingPrice);

    // Assert
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupImpl.fulfillmentPrice);
    BigDecimal bigDecimal = fulfillmentGroupImpl.fulfillmentPrice;
    Money absResult = shippingPrice.abs();
    assertSame(bigDecimal, absResult.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.getAmount());
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = shippingPrice.zero();
    Money absResult3 = zeroResult.abs();
    assertSame(bigDecimal, absResult3.abs().getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult2 = absResult.zero();
    assertSame(bigDecimal, zeroResult2.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    assertSame(bigDecimal, zeroResult3.abs().getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, absResult2.zero().getAmount());
    assertSame(bigDecimal, absResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult2.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.zero().getAmount());
  }

  /**
   * Test {@link FulfillmentGroupImpl#setShippingPrice(Money)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link FulfillmentGroupImpl} {@link FulfillmentGroupImpl#fulfillmentPrice} is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#setShippingPrice(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupImpl.setShippingPrice(Money)"})
  public void testSetShippingPrice_whenNull_thenFulfillmentGroupImplFulfillmentPriceIsNull() {
    // Arrange and Act
    fulfillmentGroupImpl.setShippingPrice(null);

    // Assert that nothing has changed
    assertNull(fulfillmentGroupImpl.fulfillmentPrice);
  }

  /**
   * Test {@link FulfillmentGroupImpl#getTotalTax()}.
   *
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getTotalTax()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getTotalTax()"})
  public void testGetTotalTax_givenFulfillmentGroupImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(fulfillmentGroupImpl.getTotalTax());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getTotalTax()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getTotalTax()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getTotalTax()"})
  public void testGetTotalTax_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(null);
    Money totalTax = new Money();
    fulfillmentGroupImpl.setTotalTax(totalTax);
    fulfillmentGroupImpl.setOrder(order);

    // Act and Assert
    assertEquals(totalTax, fulfillmentGroupImpl.getTotalTax());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getTotalTax()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getTotalTax()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getTotalTax()"})
  public void testGetTotalTax_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(currency);
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setOrder(order);

    // Act
    Money actualTotalTax = fulfillmentGroupImpl.getTotalTax();

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualTotalTax.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
    Money actualAbsResult = actualTotalTax.abs();
    assertEquals(actualTotalTax, actualAbsResult);
    Money actualZeroResult = actualTotalTax.zero();
    assertEquals(actualTotalTax, actualZeroResult);
  }

  /**
   * Test {@link FulfillmentGroupImpl#setTotalTax(Money)}.
   *
   * <ul>
   *   <li>When {@link Money#Money()}.
   *   <li>Then {@link FulfillmentGroupImpl} {@link FulfillmentGroupImpl#totalTax} is {@link
   *       BigDecimal#BigDecimal(String)} with {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#setTotalTax(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupImpl.setTotalTax(Money)"})
  public void testSetTotalTax_whenMoney_thenFulfillmentGroupImplTotalTaxIsBigDecimalWith000() {
    // Arrange
    Money totalTax = new Money();

    // Act
    fulfillmentGroupImpl.setTotalTax(totalTax);

    // Assert
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupImpl.totalTax);
    BigDecimal bigDecimal = fulfillmentGroupImpl.totalTax;
    Money absResult = totalTax.abs();
    assertSame(bigDecimal, absResult.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.getAmount());
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = totalTax.zero();
    Money absResult3 = zeroResult.abs();
    assertSame(bigDecimal, absResult3.abs().getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult2 = absResult.zero();
    assertSame(bigDecimal, zeroResult2.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    assertSame(bigDecimal, zeroResult3.abs().getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, absResult2.zero().getAmount());
    assertSame(bigDecimal, absResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult2.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.zero().getAmount());
  }

  /**
   * Test {@link FulfillmentGroupImpl#setTotalTax(Money)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link FulfillmentGroupImpl} {@link FulfillmentGroupImpl#totalTax} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#setTotalTax(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupImpl.setTotalTax(Money)"})
  public void testSetTotalTax_whenNull_thenFulfillmentGroupImplTotalTaxIsNull() {
    // Arrange and Act
    fulfillmentGroupImpl.setTotalTax(null);

    // Assert that nothing has changed
    assertNull(fulfillmentGroupImpl.totalTax);
  }

  /**
   * Test {@link FulfillmentGroupImpl#getTotalItemTax()}.
   *
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getTotalItemTax()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getTotalItemTax()"})
  public void testGetTotalItemTax_givenFulfillmentGroupImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(fulfillmentGroupImpl.getTotalItemTax());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getTotalItemTax()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getTotalItemTax()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getTotalItemTax()"})
  public void testGetTotalItemTax_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(null);
    Money totalItemTax = new Money();
    fulfillmentGroupImpl.setTotalItemTax(totalItemTax);
    fulfillmentGroupImpl.setOrder(order);

    // Act and Assert
    assertEquals(totalItemTax, fulfillmentGroupImpl.getTotalItemTax());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getTotalItemTax()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getTotalItemTax()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getTotalItemTax()"})
  public void testGetTotalItemTax_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(currency);
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setOrder(order);

    // Act
    Money actualTotalItemTax = fulfillmentGroupImpl.getTotalItemTax();

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualTotalItemTax.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
    Money actualAbsResult = actualTotalItemTax.abs();
    assertEquals(actualTotalItemTax, actualAbsResult);
    Money actualZeroResult = actualTotalItemTax.zero();
    assertEquals(actualTotalItemTax, actualZeroResult);
  }

  /**
   * Test {@link FulfillmentGroupImpl#setTotalItemTax(Money)}.
   *
   * <ul>
   *   <li>Then {@link FulfillmentGroupImpl} {@link FulfillmentGroupImpl#totalItemTax} is {@link
   *       BigDecimal#BigDecimal(String)} with {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#setTotalItemTax(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupImpl.setTotalItemTax(Money)"})
  public void testSetTotalItemTax_thenFulfillmentGroupImplTotalItemTaxIsBigDecimalWith000() {
    // Arrange
    Money totalItemTax = new Money();

    // Act
    fulfillmentGroupImpl.setTotalItemTax(totalItemTax);

    // Assert
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupImpl.totalItemTax);
    BigDecimal bigDecimal = fulfillmentGroupImpl.totalItemTax;
    Money absResult = totalItemTax.abs();
    assertSame(bigDecimal, absResult.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.getAmount());
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = totalItemTax.zero();
    Money absResult3 = zeroResult.abs();
    assertSame(bigDecimal, absResult3.abs().getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult2 = absResult.zero();
    assertSame(bigDecimal, zeroResult2.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    assertSame(bigDecimal, zeroResult3.abs().getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, absResult2.zero().getAmount());
    assertSame(bigDecimal, absResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult2.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.zero().getAmount());
  }

  /**
   * Test {@link FulfillmentGroupImpl#setTotalItemTax(Money)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link FulfillmentGroupImpl} {@link FulfillmentGroupImpl#totalItemTax} is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#setTotalItemTax(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupImpl.setTotalItemTax(Money)"})
  public void testSetTotalItemTax_whenNull_thenFulfillmentGroupImplTotalItemTaxIsNull() {
    // Arrange and Act
    fulfillmentGroupImpl.setTotalItemTax(null);

    // Assert that nothing has changed
    assertNull(fulfillmentGroupImpl.totalItemTax);
  }

  /**
   * Test {@link FulfillmentGroupImpl#getTotalFeeTax()}.
   *
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getTotalFeeTax()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getTotalFeeTax()"})
  public void testGetTotalFeeTax_givenFulfillmentGroupImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(fulfillmentGroupImpl.getTotalFeeTax());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getTotalFeeTax()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getTotalFeeTax()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getTotalFeeTax()"})
  public void testGetTotalFeeTax_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(null);
    Money totalFeeTax = new Money();
    fulfillmentGroupImpl.setTotalFeeTax(totalFeeTax);
    fulfillmentGroupImpl.setOrder(order);

    // Act and Assert
    assertEquals(totalFeeTax, fulfillmentGroupImpl.getTotalFeeTax());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getTotalFeeTax()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getTotalFeeTax()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getTotalFeeTax()"})
  public void testGetTotalFeeTax_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(currency);
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setOrder(order);

    // Act
    Money actualTotalFeeTax = fulfillmentGroupImpl.getTotalFeeTax();

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualTotalFeeTax.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
    Money actualAbsResult = actualTotalFeeTax.abs();
    assertEquals(actualTotalFeeTax, actualAbsResult);
    Money actualZeroResult = actualTotalFeeTax.zero();
    assertEquals(actualTotalFeeTax, actualZeroResult);
  }

  /**
   * Test {@link FulfillmentGroupImpl#setTotalFeeTax(Money)}.
   *
   * <ul>
   *   <li>Then {@link FulfillmentGroupImpl} {@link FulfillmentGroupImpl#totalFeeTax} is {@link
   *       BigDecimal#BigDecimal(String)} with {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#setTotalFeeTax(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupImpl.setTotalFeeTax(Money)"})
  public void testSetTotalFeeTax_thenFulfillmentGroupImplTotalFeeTaxIsBigDecimalWith000() {
    // Arrange
    Money totalFeeTax = new Money();

    // Act
    fulfillmentGroupImpl.setTotalFeeTax(totalFeeTax);

    // Assert
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupImpl.totalFeeTax);
    BigDecimal bigDecimal = fulfillmentGroupImpl.totalFeeTax;
    Money absResult = totalFeeTax.abs();
    assertSame(bigDecimal, absResult.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.getAmount());
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = totalFeeTax.zero();
    Money absResult3 = zeroResult.abs();
    assertSame(bigDecimal, absResult3.abs().getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult2 = absResult.zero();
    assertSame(bigDecimal, zeroResult2.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    assertSame(bigDecimal, zeroResult3.abs().getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, absResult2.zero().getAmount());
    assertSame(bigDecimal, absResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult2.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.zero().getAmount());
  }

  /**
   * Test {@link FulfillmentGroupImpl#setTotalFeeTax(Money)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link FulfillmentGroupImpl} {@link FulfillmentGroupImpl#totalFeeTax} is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#setTotalFeeTax(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupImpl.setTotalFeeTax(Money)"})
  public void testSetTotalFeeTax_whenNull_thenFulfillmentGroupImplTotalFeeTaxIsNull() {
    // Arrange and Act
    fulfillmentGroupImpl.setTotalFeeTax(null);

    // Assert that nothing has changed
    assertNull(fulfillmentGroupImpl.totalFeeTax);
  }

  /**
   * Test {@link FulfillmentGroupImpl#getTotalFulfillmentGroupTax()}.
   *
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getTotalFulfillmentGroupTax()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getTotalFulfillmentGroupTax()"})
  public void testGetTotalFulfillmentGroupTax_givenFulfillmentGroupImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(fulfillmentGroupImpl.getTotalFulfillmentGroupTax());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getTotalFulfillmentGroupTax()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getTotalFulfillmentGroupTax()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getTotalFulfillmentGroupTax()"})
  public void testGetTotalFulfillmentGroupTax_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(null);
    Money totalFulfillmentGroupTax = new Money();
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(totalFulfillmentGroupTax);
    fulfillmentGroupImpl.setOrder(order);

    // Act and Assert
    assertEquals(totalFulfillmentGroupTax, fulfillmentGroupImpl.getTotalFulfillmentGroupTax());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getTotalFulfillmentGroupTax()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getTotalFulfillmentGroupTax()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getTotalFulfillmentGroupTax()"})
  public void testGetTotalFulfillmentGroupTax_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(currency);
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setOrder(order);

    // Act
    Money actualTotalFulfillmentGroupTax = fulfillmentGroupImpl.getTotalFulfillmentGroupTax();

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualTotalFulfillmentGroupTax.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
    Money actualAbsResult = actualTotalFulfillmentGroupTax.abs();
    assertEquals(actualTotalFulfillmentGroupTax, actualAbsResult);
    Money actualZeroResult = actualTotalFulfillmentGroupTax.zero();
    assertEquals(actualTotalFulfillmentGroupTax, actualZeroResult);
  }

  /**
   * Test {@link FulfillmentGroupImpl#setTotalFulfillmentGroupTax(Money)}.
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#setTotalFulfillmentGroupTax(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupImpl.setTotalFulfillmentGroupTax(Money)"})
  public void testSetTotalFulfillmentGroupTax() {
    // Arrange
    Money totalFulfillmentGroupTax = new Money();

    // Act
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(totalFulfillmentGroupTax);

    // Assert
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupImpl.totalFulfillmentGroupTax);
    BigDecimal bigDecimal = fulfillmentGroupImpl.totalFulfillmentGroupTax;
    Money absResult = totalFulfillmentGroupTax.abs();
    assertSame(bigDecimal, absResult.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.getAmount());
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = totalFulfillmentGroupTax.zero();
    Money absResult3 = zeroResult.abs();
    assertSame(bigDecimal, absResult3.abs().getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult2 = absResult.zero();
    assertSame(bigDecimal, zeroResult2.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    assertSame(bigDecimal, zeroResult3.abs().getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, absResult2.zero().getAmount());
    assertSame(bigDecimal, absResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult2.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.zero().getAmount());
  }

  /**
   * Test {@link FulfillmentGroupImpl#setTotalFulfillmentGroupTax(Money)}.
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#setTotalFulfillmentGroupTax(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupImpl.setTotalFulfillmentGroupTax(Money)"})
  public void testSetTotalFulfillmentGroupTax2() {
    // Arrange and Act
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(null);

    // Assert that nothing has changed
    assertNull(fulfillmentGroupImpl.totalFulfillmentGroupTax);
  }

  /**
   * Test {@link FulfillmentGroupImpl#getMerchandiseTotal()}.
   *
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getMerchandiseTotal()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getMerchandiseTotal()"})
  public void testGetMerchandiseTotal_givenFulfillmentGroupImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(fulfillmentGroupImpl.getMerchandiseTotal());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getMerchandiseTotal()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getMerchandiseTotal()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getMerchandiseTotal()"})
  public void testGetMerchandiseTotal_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(null);
    Money merchandiseTotal = new Money();
    fulfillmentGroupImpl.setMerchandiseTotal(merchandiseTotal);
    fulfillmentGroupImpl.setOrder(order);

    // Act and Assert
    assertEquals(merchandiseTotal, fulfillmentGroupImpl.getMerchandiseTotal());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getMerchandiseTotal()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getMerchandiseTotal()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getMerchandiseTotal()"})
  public void testGetMerchandiseTotal_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(currency);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setOrder(order);

    // Act
    Money actualMerchandiseTotal = fulfillmentGroupImpl.getMerchandiseTotal();

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualMerchandiseTotal.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
    Money actualAbsResult = actualMerchandiseTotal.abs();
    assertEquals(actualMerchandiseTotal, actualAbsResult);
    Money actualZeroResult = actualMerchandiseTotal.zero();
    assertEquals(actualMerchandiseTotal, actualZeroResult);
  }

  /**
   * Test {@link FulfillmentGroupImpl#setMerchandiseTotal(Money)}.
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#setMerchandiseTotal(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupImpl.setMerchandiseTotal(Money)"})
  public void testSetMerchandiseTotal() {
    // Arrange
    Money merchandiseTotal = new Money();

    // Act
    fulfillmentGroupImpl.setMerchandiseTotal(merchandiseTotal);

    // Assert
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupImpl.merchandiseTotal);
    BigDecimal bigDecimal = fulfillmentGroupImpl.merchandiseTotal;
    Money absResult = merchandiseTotal.abs();
    assertSame(bigDecimal, absResult.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.getAmount());
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = merchandiseTotal.zero();
    Money absResult3 = zeroResult.abs();
    assertSame(bigDecimal, absResult3.abs().getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult2 = absResult.zero();
    assertSame(bigDecimal, zeroResult2.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    assertSame(bigDecimal, zeroResult3.abs().getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, absResult2.zero().getAmount());
    assertSame(bigDecimal, absResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult2.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.zero().getAmount());
  }

  /**
   * Test {@link FulfillmentGroupImpl#setMerchandiseTotal(Money)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link FulfillmentGroupImpl} {@link FulfillmentGroupImpl#merchandiseTotal} is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#setMerchandiseTotal(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupImpl.setMerchandiseTotal(Money)"})
  public void testSetMerchandiseTotal_whenNull_thenFulfillmentGroupImplMerchandiseTotalIsNull() {
    // Arrange and Act
    fulfillmentGroupImpl.setMerchandiseTotal(null);

    // Assert that nothing has changed
    assertNull(fulfillmentGroupImpl.merchandiseTotal);
  }

  /**
   * Test {@link FulfillmentGroupImpl#getTotal()}.
   *
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getTotal()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getTotal()"})
  public void testGetTotal_givenFulfillmentGroupImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(fulfillmentGroupImpl.getTotal());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getTotal()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getTotal()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getTotal()"})
  public void testGetTotal_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(null);
    Money orderTotal = new Money();
    fulfillmentGroupImpl.setTotal(orderTotal);
    fulfillmentGroupImpl.setOrder(order);

    // Act and Assert
    assertEquals(orderTotal, fulfillmentGroupImpl.getTotal());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getTotal()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getTotal()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getTotal()"})
  public void testGetTotal_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(currency);
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setOrder(order);

    // Act
    Money actualTotal = fulfillmentGroupImpl.getTotal();

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualTotal.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
    Money actualAbsResult = actualTotal.abs();
    assertEquals(actualTotal, actualAbsResult);
    Money actualZeroResult = actualTotal.zero();
    assertEquals(actualTotal, actualZeroResult);
  }

  /**
   * Test {@link FulfillmentGroupImpl#setTotal(Money)}.
   *
   * <ul>
   *   <li>When {@link Money#Money()}.
   *   <li>Then {@link FulfillmentGroupImpl} {@link FulfillmentGroupImpl#total} is {@link
   *       BigDecimal#BigDecimal(String)} with {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#setTotal(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupImpl.setTotal(Money)"})
  public void testSetTotal_whenMoney_thenFulfillmentGroupImplTotalIsBigDecimalWith000() {
    // Arrange
    Money orderTotal = new Money();

    // Act
    fulfillmentGroupImpl.setTotal(orderTotal);

    // Assert
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupImpl.total);
    BigDecimal bigDecimal = fulfillmentGroupImpl.total;
    Money absResult = orderTotal.abs();
    assertSame(bigDecimal, absResult.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.getAmount());
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = orderTotal.zero();
    Money absResult3 = zeroResult.abs();
    assertSame(bigDecimal, absResult3.abs().getAmount());
    assertSame(bigDecimal, absResult3.getAmount());
    Money zeroResult2 = absResult.zero();
    assertSame(bigDecimal, zeroResult2.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    assertSame(bigDecimal, zeroResult3.abs().getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, absResult2.zero().getAmount());
    assertSame(bigDecimal, absResult3.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult2.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.zero().getAmount());
  }

  /**
   * Test {@link FulfillmentGroupImpl#setTotal(Money)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link FulfillmentGroupImpl} {@link FulfillmentGroupImpl#total} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#setTotal(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupImpl.setTotal(Money)"})
  public void testSetTotal_whenNull_thenFulfillmentGroupImplTotalIsNull() {
    // Arrange and Act
    fulfillmentGroupImpl.setTotal(null);

    // Assert that nothing has changed
    assertNull(fulfillmentGroupImpl.total);
  }

  /**
   * Test {@link FulfillmentGroupImpl#getStatus()}.
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getStatus()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FulfillmentGroupStatusType FulfillmentGroupImpl.getStatus()"})
  public void testGetStatus() {
    // Arrange, Act and Assert
    assertNull(fulfillmentGroupImpl.getStatus());
  }

  /**
   * Test {@link FulfillmentGroupImpl#setStatus(FulfillmentGroupStatusType)}.
   *
   * <ul>
   *   <li>When {@link FulfillmentGroupStatusType#CANCELLED}.
   *   <li>Then {@link FulfillmentGroupImpl} {@link FulfillmentGroupImpl#status} is {@code
   *       CANCELLED}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#setStatus(FulfillmentGroupStatusType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType)"})
  public void testSetStatus_whenCancelled_thenFulfillmentGroupImplStatusIsCancelled() {
    // Arrange and Act
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);

    // Assert
    assertEquals("CANCELLED", fulfillmentGroupImpl.status);
    assertSame(FulfillmentGroupStatusType.CANCELLED, fulfillmentGroupImpl.getStatus());
  }

  /**
   * Test {@link FulfillmentGroupImpl#addFulfillmentGroupFee(FulfillmentGroupFee)}.
   *
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#addFulfillmentGroupFee(FulfillmentGroupFee)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupImpl.addFulfillmentGroupFee(FulfillmentGroupFee)"})
  public void testAddFulfillmentGroupFee_givenFulfillmentGroupImpl() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFee = new FulfillmentGroupFeeImpl();

    // Act
    fulfillmentGroupImpl.addFulfillmentGroupFee(fulfillmentGroupFee);

    // Assert
    List<FulfillmentGroupFee> fulfillmentGroupFees = fulfillmentGroupImpl.getFulfillmentGroupFees();
    assertEquals(1, fulfillmentGroupFees.size());
    assertSame(fulfillmentGroupFee, fulfillmentGroupFees.get(0));
  }

  /**
   * Test {@link FulfillmentGroupImpl#addFulfillmentGroupFee(FulfillmentGroupFee)}.
   *
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl} FulfillmentGroupFees is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#addFulfillmentGroupFee(FulfillmentGroupFee)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupImpl.addFulfillmentGroupFee(FulfillmentGroupFee)"})
  public void testAddFulfillmentGroupFee_givenFulfillmentGroupImplFulfillmentGroupFeesIsNull() {
    // Arrange
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
   * Test {@link FulfillmentGroupImpl#getCurrencyCode()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@link BroadleafCurrencyImpl}
   *       (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getCurrencyCode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String FulfillmentGroupImpl.getCurrencyCode()"})
  public void testGetCurrencyCode_givenOrderImplCurrencyIsBroadleafCurrencyImpl_thenReturnNull() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(new BroadleafCurrencyImpl());
    fulfillmentGroupImpl.setOrder(order);

    // Act and Assert
    assertNull(fulfillmentGroupImpl.getCurrencyCode());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getCurrencyCode()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getCurrencyCode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String FulfillmentGroupImpl.getCurrencyCode()"})
  public void testGetCurrencyCode_givenOrderImplCurrencyIsNull_thenReturnNull() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(null);
    fulfillmentGroupImpl.setOrder(order);

    // Act and Assert
    assertNull(fulfillmentGroupImpl.getCurrencyCode());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getShippingOverride()}.
   *
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getShippingOverride()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean FulfillmentGroupImpl.getShippingOverride()"})
  public void testGetShippingOverride_givenFulfillmentGroupImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(fulfillmentGroupImpl.getShippingOverride());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getShippingOverride()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#getShippingOverride()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean FulfillmentGroupImpl.getShippingOverride()"})
  public void testGetShippingOverride_thenReturnTrue() {
    // Arrange
    fulfillmentGroupImpl.setShippingOverride(true);

    // Act and Assert
    assertTrue(fulfillmentGroupImpl.getShippingOverride());
  }

  /**
   * Test {@link FulfillmentGroupImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse FulfillmentGroupImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(new FulfillmentGroupImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<FulfillmentGroup> actualCreateOrRetrieveCopyInstanceResult =
        fulfillmentGroupImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link FulfillmentGroupImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse FulfillmentGroupImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(fulfillmentGroupImpl, false);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<FulfillmentGroup> actualCreateOrRetrieveCopyInstanceResult =
        fulfillmentGroupImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link FulfillmentGroupImpl#equals(Object)}, and {@link FulfillmentGroupImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentGroupImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupImpl.equals(Object)",
    "int FulfillmentGroupImpl.hashCode()"
  })
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
    fulfillmentGroupImpl2.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setSequence(1);
    fulfillmentGroupImpl2.setService("Service");
    fulfillmentGroupImpl2.setShippingOverride(true);
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
    assertEquals(fulfillmentGroupImpl.hashCode(), fulfillmentGroupImpl2.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupImpl#equals(Object)}, and {@link FulfillmentGroupImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentGroupImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupImpl.equals(Object)",
    "int FulfillmentGroupImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
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
    fulfillmentGroupImpl2.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setSequence(1);
    fulfillmentGroupImpl2.setService("Service");
    fulfillmentGroupImpl2.setShippingOverride(true);
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
    assertEquals(fulfillmentGroupImpl.hashCode(), fulfillmentGroupImpl2.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupImpl#equals(Object)}, and {@link FulfillmentGroupImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentGroupImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupImpl.equals(Object)",
    "int FulfillmentGroupImpl.hashCode()"
  })
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
    fulfillmentGroupImpl2.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setSequence(1);
    fulfillmentGroupImpl2.setService("Service");
    fulfillmentGroupImpl2.setShippingOverride(true);
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
    assertEquals(fulfillmentGroupImpl.hashCode(), fulfillmentGroupImpl2.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupImpl#equals(Object)}, and {@link FulfillmentGroupImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentGroupImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupImpl.equals(Object)",
    "int FulfillmentGroupImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(null);
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

    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(null);
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
    fulfillmentGroupImpl2.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setSequence(1);
    fulfillmentGroupImpl2.setService("Service");
    fulfillmentGroupImpl2.setShippingOverride(true);
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
    assertEquals(fulfillmentGroupImpl.hashCode(), fulfillmentGroupImpl2.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupImpl#equals(Object)}, and {@link FulfillmentGroupImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentGroupImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupImpl.equals(Object)",
    "int FulfillmentGroupImpl.hashCode()"
  })
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

    // Act and Assert
    assertEquals(fulfillmentGroupImpl, fulfillmentGroupImpl);
    int expectedHashCodeResult = fulfillmentGroupImpl.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentGroupImpl.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupImpl.equals(Object)",
    "int FulfillmentGroupImpl.hashCode()"
  })
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
    fulfillmentGroupImpl2.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setSequence(1);
    fulfillmentGroupImpl2.setService("Service");
    fulfillmentGroupImpl2.setShippingOverride(true);
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
   * Test {@link FulfillmentGroupImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupImpl.equals(Object)",
    "int FulfillmentGroupImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(null);
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
    fulfillmentGroupImpl2.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setSequence(1);
    fulfillmentGroupImpl2.setService("Service");
    fulfillmentGroupImpl2.setShippingOverride(true);
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
   * Test {@link FulfillmentGroupImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupImpl.equals(Object)",
    "int FulfillmentGroupImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
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
    fulfillmentGroupImpl2.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setSequence(1);
    fulfillmentGroupImpl2.setService("Service");
    fulfillmentGroupImpl2.setShippingOverride(true);
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
   * Test {@link FulfillmentGroupImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupImpl.equals(Object)",
    "int FulfillmentGroupImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ArrayList<FulfillmentGroupItem> fulfillmentGroupItems = new ArrayList<>();
    fulfillmentGroupItems.add(new FulfillmentGroupItemImpl());

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupItems(fulfillmentGroupItems);
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
    fulfillmentGroupImpl2.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setSequence(1);
    fulfillmentGroupImpl2.setService("Service");
    fulfillmentGroupImpl2.setShippingOverride(true);
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
   * Test {@link FulfillmentGroupImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupImpl.equals(Object)",
    "int FulfillmentGroupImpl.hashCode()"
  })
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

    // Act and Assert
    assertNotEquals(fulfillmentGroupImpl, null);
  }

  /**
   * Test {@link FulfillmentGroupImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupImpl.equals(Object)",
    "int FulfillmentGroupImpl.hashCode()"
  })
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

    // Act and Assert
    assertNotEquals(fulfillmentGroupImpl, "Different type to FulfillmentGroupImpl");
  }

  /**
   * Test new {@link FulfillmentGroupImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link FulfillmentGroupImpl}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupImpl.<init>()"})
  public void testNewFulfillmentGroupImpl() {
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

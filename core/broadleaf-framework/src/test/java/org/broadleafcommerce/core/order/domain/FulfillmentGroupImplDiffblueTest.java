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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
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
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class FulfillmentGroupImplDiffblueTest {
  @Autowired
  private FulfillmentGroupImpl fulfillmentGroupImpl;

  /**
   * Test {@link FulfillmentGroupImpl#getDiscreteOrderItems()}.
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#getDiscreteOrderItems()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List FulfillmentGroupImpl.getDiscreteOrderItems()"})
  public void testGetDiscreteOrderItems() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.addFulfillmentGroupItem(new FulfillmentGroupItemImpl());

    // Act and Assert
    assertTrue(fulfillmentGroupImpl2.getDiscreteOrderItems().isEmpty());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getDiscreteOrderItems()}.
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#getDiscreteOrderItems()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List FulfillmentGroupImpl.getDiscreteOrderItems()"})
  public void testGetDiscreteOrderItems_givenFulfillmentGroupImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new FulfillmentGroupImpl()).getDiscreteOrderItems().isEmpty());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getDiscreteOrderItems()}.
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#getDiscreteOrderItems()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List FulfillmentGroupImpl.getDiscreteOrderItems()"})
  public void testGetDiscreteOrderItems_thenReturnArrayList() {
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

    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(new AddressImpl());
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupFees(new ArrayList<>());
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
    fulfillmentGroupImpl2.setFulfillmentGroupItems(fulfillmentGroupItems);

    // Act and Assert
    assertEquals(discreteOrderItems, fulfillmentGroupImpl2.getDiscreteOrderItems());
  }

  /**
   * Test {@link FulfillmentGroupImpl#addFulfillmentGroupItem(FulfillmentGroupItem)}.
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#addFulfillmentGroupItem(FulfillmentGroupItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupImpl.addFulfillmentGroupItem(FulfillmentGroupItem)"})
  public void testAddFulfillmentGroupItem_givenFulfillmentGroupImpl() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    FulfillmentGroupItemImpl fulfillmentGroupItem = new FulfillmentGroupItemImpl();

    // Act
    fulfillmentGroupImpl2.addFulfillmentGroupItem(fulfillmentGroupItem);

    // Assert
    List<FulfillmentGroupItem> fulfillmentGroupItems = fulfillmentGroupImpl2.getFulfillmentGroupItems();
    assertEquals(1, fulfillmentGroupItems.size());
    assertTrue(fulfillmentGroupImpl2.getDiscreteOrderItems().isEmpty());
    assertSame(fulfillmentGroupItem, fulfillmentGroupItems.get(0));
  }

  /**
   * Test {@link FulfillmentGroupImpl#addFulfillmentGroupItem(FulfillmentGroupItem)}.
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl} (default constructor) Address is {@link AddressImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#addFulfillmentGroupItem(FulfillmentGroupItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupImpl.addFulfillmentGroupItem(FulfillmentGroupItem)"})
  public void testAddFulfillmentGroupItem_givenFulfillmentGroupImplAddressIsAddressImpl() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(new AddressImpl());
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupFees(new ArrayList<>());
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
    fulfillmentGroupImpl2.setFulfillmentGroupItems(null);
    FulfillmentGroupItemImpl fulfillmentGroupItem = new FulfillmentGroupItemImpl();

    // Act
    fulfillmentGroupImpl2.addFulfillmentGroupItem(fulfillmentGroupItem);

    // Assert
    List<FulfillmentGroupItem> fulfillmentGroupItems = fulfillmentGroupImpl2.getFulfillmentGroupItems();
    assertEquals(1, fulfillmentGroupItems.size());
    assertTrue(fulfillmentGroupImpl2.getDiscreteOrderItems().isEmpty());
    assertSame(fulfillmentGroupItem, fulfillmentGroupItems.get(0));
  }

  /**
   * Test getters and setters.
   * <p>
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Address FulfillmentGroupImpl.getAddress()",
      "List FulfillmentGroupImpl.getCandidateFulfillmentGroupOffers()",
      "String FulfillmentGroupImpl.getDeliveryInstruction()",
      "List FulfillmentGroupImpl.getFulfillmentGroupAdjustments()",
      "List FulfillmentGroupImpl.getFulfillmentGroupFees()", "List FulfillmentGroupImpl.getFulfillmentGroupItems()",
      "FulfillmentOption FulfillmentGroupImpl.getFulfillmentOption()", "Long FulfillmentGroupImpl.getId()",
      "String FulfillmentGroupImpl.getMethod()", "Order FulfillmentGroupImpl.getOrder()",
      "PersonalMessage FulfillmentGroupImpl.getPersonalMessage()", "Phone FulfillmentGroupImpl.getPhone()",
      "String FulfillmentGroupImpl.getReferenceNumber()", "Integer FulfillmentGroupImpl.getSequence()",
      "String FulfillmentGroupImpl.getService()", "List FulfillmentGroupImpl.getTaxes()",
      "boolean FulfillmentGroupImpl.isPrimary()", "Boolean FulfillmentGroupImpl.isShippingPriceTaxable()",
      "void FulfillmentGroupImpl.setAddress(Address)",
      "void FulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(List)",
      "void FulfillmentGroupImpl.setDeliveryInstruction(String)",
      "void FulfillmentGroupImpl.setFulfillmentGroupAdjustments(List)",
      "void FulfillmentGroupImpl.setFulfillmentGroupFees(List)",
      "void FulfillmentGroupImpl.setFulfillmentGroupItems(List)",
      "void FulfillmentGroupImpl.setFulfillmentOption(FulfillmentOption)", "void FulfillmentGroupImpl.setId(Long)",
      "void FulfillmentGroupImpl.setIsShippingPriceTaxable(Boolean)", "void FulfillmentGroupImpl.setMethod(String)",
      "void FulfillmentGroupImpl.setOrder(Order)", "void FulfillmentGroupImpl.setPersonalMessage(PersonalMessage)",
      "void FulfillmentGroupImpl.setPhone(Phone)", "void FulfillmentGroupImpl.setPrimary(boolean)",
      "void FulfillmentGroupImpl.setReferenceNumber(String)", "void FulfillmentGroupImpl.setSequence(Integer)",
      "void FulfillmentGroupImpl.setService(String)", "void FulfillmentGroupImpl.setShippingOverride(Boolean)",
      "void FulfillmentGroupImpl.setTaxes(List)"})
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
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#getRetailFulfillmentPrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getRetailFulfillmentPrice()"})
  public void testGetRetailFulfillmentPrice_givenFulfillmentGroupImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FulfillmentGroupImpl()).getRetailFulfillmentPrice());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getRetailFulfillmentPrice()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#getRetailFulfillmentPrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getRetailFulfillmentPrice()"})
  public void testGetRetailFulfillmentPrice_givenOrderImplCurrencyIsNull_thenReturnMoney() {
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
    order.setTotalTax(new Money());
    order.setCurrency(null);

    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(new AddressImpl());
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl2.setFulfillmentPrice(fulfillmentPrice);
    fulfillmentGroupImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl2.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl2.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl2.setMethod("Fulfillment Method");
    fulfillmentGroupImpl2.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl2.setPhone(new PhoneImpl());
    fulfillmentGroupImpl2.setPrimary(true);
    fulfillmentGroupImpl2.setReferenceNumber("42");
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
    fulfillmentGroupImpl2.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setOrder(order);

    // Act and Assert
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl2.getRetailFulfillmentPrice());
  }

  /**
   * Test {@link FulfillmentGroupImpl#setRetailFulfillmentPrice(Money)}.
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#setRetailFulfillmentPrice(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupImpl.setRetailFulfillmentPrice(Money)"})
  public void testSetRetailFulfillmentPrice() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    Money retailFulfillmentPrice = new Money();

    // Act
    fulfillmentGroupImpl2.setRetailFulfillmentPrice(retailFulfillmentPrice);

    // Assert
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupImpl2.retailFulfillmentPrice);
    BigDecimal bigDecimal = fulfillmentGroupImpl2.retailFulfillmentPrice;
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
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#setRetailFulfillmentPrice(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupImpl.setRetailFulfillmentPrice(Money)"})
  public void testSetRetailFulfillmentPrice2() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(new AddressImpl());
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl2.setFulfillmentPrice(fulfillmentPrice);
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

    // Act
    fulfillmentGroupImpl2.setRetailFulfillmentPrice(null);

    // Assert
    assertNull(fulfillmentGroupImpl2.retailFulfillmentPrice);
    assertNull(fulfillmentGroupImpl2.getRetailFulfillmentPrice());
    assertNull(fulfillmentGroupImpl2.getRetailShippingPrice());
    Money zeroResult = fulfillmentGroupImpl2.getTotalTax().zero();
    Money zeroResult2 = zeroResult.zero();
    Money absResult = zeroResult2.abs();
    assertEquals(fulfillmentPrice, absResult.abs());
    Money zeroResult3 = zeroResult2.zero();
    assertEquals(fulfillmentPrice, zeroResult3.abs());
    assertEquals(fulfillmentPrice, absResult.zero());
    Money zeroResult4 = zeroResult.abs().zero();
    assertEquals(fulfillmentPrice, zeroResult4.zero());
    assertEquals(fulfillmentPrice, zeroResult3.zero());
    BigDecimal bigDecimal = fulfillmentGroupImpl2.totalTax;
    assertSame(bigDecimal, absResult.getAmount());
    assertSame(bigDecimal, zeroResult4.getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getRetailShippingPrice()}.
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#getRetailShippingPrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getRetailShippingPrice()"})
  public void testGetRetailShippingPrice_givenFulfillmentGroupImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FulfillmentGroupImpl()).getRetailShippingPrice());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getRetailShippingPrice()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#getRetailShippingPrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getRetailShippingPrice()"})
  public void testGetRetailShippingPrice_givenOrderImplCurrencyIsNull_thenReturnMoney() {
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
    order.setTotalTax(new Money());
    order.setCurrency(null);

    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(new AddressImpl());
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl2.setFulfillmentPrice(fulfillmentPrice);
    fulfillmentGroupImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl2.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl2.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl2.setMethod("Fulfillment Method");
    fulfillmentGroupImpl2.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl2.setPhone(new PhoneImpl());
    fulfillmentGroupImpl2.setPrimary(true);
    fulfillmentGroupImpl2.setReferenceNumber("42");
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
    fulfillmentGroupImpl2.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setOrder(order);

    // Act and Assert
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl2.getRetailShippingPrice());
  }

  /**
   * Test {@link FulfillmentGroupImpl#setRetailShippingPrice(Money)}.
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#setRetailShippingPrice(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupImpl.setRetailShippingPrice(Money)"})
  public void testSetRetailShippingPrice() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    Money retailShippingPrice = new Money();

    // Act
    fulfillmentGroupImpl2.setRetailShippingPrice(retailShippingPrice);

    // Assert
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupImpl2.retailFulfillmentPrice);
    BigDecimal bigDecimal = fulfillmentGroupImpl2.retailFulfillmentPrice;
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
   * <ul>
   *   <li>Then {@link FulfillmentGroupImpl} (default constructor) {@link FulfillmentGroupImpl#retailFulfillmentPrice} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#setRetailShippingPrice(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupImpl.setRetailShippingPrice(Money)"})
  public void testSetRetailShippingPrice_thenFulfillmentGroupImplRetailFulfillmentPriceIsNull() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(new AddressImpl());
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl2.setFulfillmentPrice(fulfillmentPrice);
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

    // Act
    fulfillmentGroupImpl2.setRetailShippingPrice(null);

    // Assert
    assertNull(fulfillmentGroupImpl2.retailFulfillmentPrice);
    assertNull(fulfillmentGroupImpl2.getRetailFulfillmentPrice());
    assertNull(fulfillmentGroupImpl2.getRetailShippingPrice());
    Money zeroResult = fulfillmentGroupImpl2.getTotalTax().zero();
    Money zeroResult2 = zeroResult.zero();
    Money absResult = zeroResult2.abs();
    assertEquals(fulfillmentPrice, absResult.abs());
    Money zeroResult3 = zeroResult2.zero();
    assertEquals(fulfillmentPrice, zeroResult3.abs());
    assertEquals(fulfillmentPrice, absResult.zero());
    Money zeroResult4 = zeroResult.abs().zero();
    assertEquals(fulfillmentPrice, zeroResult4.zero());
    assertEquals(fulfillmentPrice, zeroResult3.zero());
    BigDecimal bigDecimal = fulfillmentGroupImpl2.totalTax;
    assertSame(bigDecimal, absResult.getAmount());
    assertSame(bigDecimal, zeroResult4.getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getType()}.
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#getType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentType FulfillmentGroupImpl.getType()"})
  public void testGetType() {
    // Arrange, Act and Assert
    assertNull((new FulfillmentGroupImpl()).getType());
  }

  /**
   * Test {@link FulfillmentGroupImpl#setType(FulfillmentType)}.
   * <ul>
   *   <li>Then {@link FulfillmentGroupImpl} (default constructor) {@link FulfillmentGroupImpl#type} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#setType(FulfillmentType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupImpl.setType(FulfillmentType)"})
  public void testSetType_thenFulfillmentGroupImplTypeIsNull() {
    // Arrange
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

    // Act
    fulfillmentGroupImpl2.setType(null);

    // Assert
    assertNull(fulfillmentGroupImpl2.type);
    assertNull(fulfillmentGroupImpl2.getType());
    BigDecimal expectedAmount = fulfillmentGroupImpl2.totalTax;
    assertSame(expectedAmount, fulfillmentGroupImpl2.getTotalTax().zero().abs().zero().getAmount());
  }

  /**
   * Test {@link FulfillmentGroupImpl#setType(FulfillmentType)}.
   * <ul>
   *   <li>When {@link FulfillmentType#DIGITAL}.</li>
   *   <li>Then {@link FulfillmentGroupImpl} (default constructor) {@link FulfillmentGroupImpl#type} is {@code DIGITAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#setType(FulfillmentType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupImpl.setType(FulfillmentType)"})
  public void testSetType_whenDigital_thenFulfillmentGroupImplTypeIsDigital() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    FulfillmentType type = FulfillmentType.DIGITAL;

    // Act
    fulfillmentGroupImpl2.setType(type);

    // Assert
    assertEquals("DIGITAL", fulfillmentGroupImpl2.type);
    FulfillmentType expectedType = type.DIGITAL;
    assertSame(expectedType, fulfillmentGroupImpl2.getType());
  }

  /**
   * Test {@link FulfillmentGroupImpl#addCandidateFulfillmentGroupOffer(CandidateFulfillmentGroupOffer)}.
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#addCandidateFulfillmentGroupOffer(CandidateFulfillmentGroupOffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupImpl.addCandidateFulfillmentGroupOffer(CandidateFulfillmentGroupOffer)"})
  public void testAddCandidateFulfillmentGroupOffer() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    CandidateFulfillmentGroupOfferImpl candidateOffer = new CandidateFulfillmentGroupOfferImpl();

    // Act
    fulfillmentGroupImpl2.addCandidateFulfillmentGroupOffer(candidateOffer);

    // Assert
    List<CandidateFulfillmentGroupOffer> candidateFulfillmentGroupOffers = fulfillmentGroupImpl2
        .getCandidateFulfillmentGroupOffers();
    assertEquals(1, candidateFulfillmentGroupOffers.size());
    assertSame(candidateOffer, candidateFulfillmentGroupOffers.get(0));
  }

  /**
   * Test {@link FulfillmentGroupImpl#removeAllCandidateOffers()}.
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#removeAllCandidateOffers()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupImpl.removeAllCandidateOffers()"})
  public void testRemoveAllCandidateOffers() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(new AddressImpl());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl2.setFulfillmentPrice(fulfillmentPrice);
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
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(null);

    // Act
    fulfillmentGroupImpl2.removeAllCandidateOffers();

    // Assert that nothing has changed
    Money absResult = fulfillmentGroupImpl2.getTotalTax().zero().abs();
    Money absResult2 = absResult.abs();
    assertEquals(fulfillmentPrice, absResult2.abs());
    assertEquals(fulfillmentPrice, absResult.zero().abs());
    assertEquals(fulfillmentPrice, absResult2.zero());
    BigDecimal expectedAmount = fulfillmentGroupImpl2.totalTax;
    assertSame(expectedAmount, absResult2.getAmount());
  }

  /**
   * Test {@link FulfillmentGroupImpl#removeAllCandidateOffers()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CandidateFulfillmentGroupOfferImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#removeAllCandidateOffers()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupImpl.removeAllCandidateOffers()"})
  public void testRemoveAllCandidateOffers_givenArrayListAddCandidateFulfillmentGroupOfferImpl() {
    // Arrange
    ArrayList<CandidateFulfillmentGroupOffer> candidateOffers = new ArrayList<>();
    candidateOffers.add(new CandidateFulfillmentGroupOfferImpl());

    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(new AddressImpl());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl2.setFulfillmentPrice(fulfillmentPrice);
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
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(candidateOffers);

    // Act
    fulfillmentGroupImpl2.removeAllCandidateOffers();

    // Assert
    assertTrue(fulfillmentGroupImpl2.getCandidateFulfillmentGroupOffers().isEmpty());
    Money absResult = fulfillmentGroupImpl2.getTotalTax().zero().abs();
    Money absResult2 = absResult.abs();
    assertEquals(fulfillmentPrice, absResult2.abs());
    assertEquals(fulfillmentPrice, absResult.zero().abs());
    assertEquals(fulfillmentPrice, absResult2.zero());
    BigDecimal expectedAmount = fulfillmentGroupImpl2.totalTax;
    assertSame(expectedAmount, absResult2.getAmount());
  }

  /**
   * Test {@link FulfillmentGroupImpl#removeAllCandidateOffers()}.
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#removeAllCandidateOffers()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupImpl.removeAllCandidateOffers()"})
  public void testRemoveAllCandidateOffers_givenFulfillmentGroupImpl() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();

    // Act
    fulfillmentGroupImpl2.removeAllCandidateOffers();

    // Assert that nothing has changed
    assertTrue(fulfillmentGroupImpl2.getCandidateFulfillmentGroupOffers().isEmpty());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getFutureCreditFulfillmentGroupAdjustments()}.
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#getFutureCreditFulfillmentGroupAdjustments()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List FulfillmentGroupImpl.getFutureCreditFulfillmentGroupAdjustments()"})
  public void testGetFutureCreditFulfillmentGroupAdjustments() {
    // Arrange
    ArrayList<FulfillmentGroupAdjustment> fulfillmentGroupAdjustments = new ArrayList<>();
    fulfillmentGroupAdjustments.add(new FulfillmentGroupAdjustmentImpl());

    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(new AddressImpl());
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
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
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(fulfillmentGroupAdjustments);

    // Act and Assert
    assertTrue(fulfillmentGroupImpl2.getFutureCreditFulfillmentGroupAdjustments().isEmpty());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getFutureCreditFulfillmentGroupAdjustments()}.
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#getFutureCreditFulfillmentGroupAdjustments()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List FulfillmentGroupImpl.getFutureCreditFulfillmentGroupAdjustments()"})
  public void testGetFutureCreditFulfillmentGroupAdjustments_givenFulfillmentGroupImpl() {
    // Arrange, Act and Assert
    assertTrue((new FulfillmentGroupImpl()).getFutureCreditFulfillmentGroupAdjustments().isEmpty());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getFutureCreditFulfillmentGroupAdjustments()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#getFutureCreditFulfillmentGroupAdjustments()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List FulfillmentGroupImpl.getFutureCreditFulfillmentGroupAdjustments()"})
  public void testGetFutureCreditFulfillmentGroupAdjustments_thenReturnSizeIsOne() {
    // Arrange
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl = mock(FulfillmentGroupAdjustmentImpl.class);
    when(fulfillmentGroupAdjustmentImpl.isFutureCredit()).thenReturn(true);

    ArrayList<FulfillmentGroupAdjustment> fulfillmentGroupAdjustments = new ArrayList<>();
    fulfillmentGroupAdjustments.add(fulfillmentGroupAdjustmentImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(new AddressImpl());
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
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
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(fulfillmentGroupAdjustments);

    // Act
    List<FulfillmentGroupAdjustment> actualFutureCreditFulfillmentGroupAdjustments = fulfillmentGroupImpl2
        .getFutureCreditFulfillmentGroupAdjustments();

    // Assert
    verify(fulfillmentGroupAdjustmentImpl).isFutureCredit();
    assertEquals(1, actualFutureCreditFulfillmentGroupAdjustments.size());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getFulfillmentGroupAdjustmentsValue()}.
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#getFulfillmentGroupAdjustmentsValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getFulfillmentGroupAdjustmentsValue()"})
  public void testGetFulfillmentGroupAdjustmentsValue() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);

    // Act
    Money actualFulfillmentGroupAdjustmentsValue = fulfillmentGroupImpl2.getFulfillmentGroupAdjustmentsValue();

    // Assert
    assertEquals(actualFulfillmentGroupAdjustmentsValue.ZERO, actualFulfillmentGroupAdjustmentsValue);
  }

  /**
   * Test {@link FulfillmentGroupImpl#getFulfillmentGroupAdjustmentsValue()}.
   * <ul>
   *   <li>Then calls {@link BroadleafCurrencyImpl#getCurrencyCode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#getFulfillmentGroupAdjustmentsValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getFulfillmentGroupAdjustmentsValue()"})
  public void testGetFulfillmentGroupAdjustmentsValue_thenCallsGetCurrencyCode() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setOrder(order);

    // Act
    Money actualFulfillmentGroupAdjustmentsValue = fulfillmentGroupImpl2.getFulfillmentGroupAdjustmentsValue();

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    assertEquals(actualFulfillmentGroupAdjustmentsValue.ZERO, actualFulfillmentGroupAdjustmentsValue);
  }

  /**
   * Test {@link FulfillmentGroupImpl#getFutureCreditFulfillmentGroupAdjustmentsValue()}.
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#getFutureCreditFulfillmentGroupAdjustmentsValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getFutureCreditFulfillmentGroupAdjustmentsValue()"})
  public void testGetFutureCreditFulfillmentGroupAdjustmentsValue() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);

    // Act
    Money actualFutureCreditFulfillmentGroupAdjustmentsValue = fulfillmentGroupImpl2
        .getFutureCreditFulfillmentGroupAdjustmentsValue();

    // Assert
    assertEquals(actualFutureCreditFulfillmentGroupAdjustmentsValue.ZERO,
        actualFutureCreditFulfillmentGroupAdjustmentsValue);
  }

  /**
   * Test {@link FulfillmentGroupImpl#getFutureCreditFulfillmentGroupAdjustmentsValue()}.
   * <ul>
   *   <li>Then calls {@link BroadleafCurrencyImpl#getCurrencyCode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#getFutureCreditFulfillmentGroupAdjustmentsValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getFutureCreditFulfillmentGroupAdjustmentsValue()"})
  public void testGetFutureCreditFulfillmentGroupAdjustmentsValue_thenCallsGetCurrencyCode() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setOrder(order);

    // Act
    Money actualFutureCreditFulfillmentGroupAdjustmentsValue = fulfillmentGroupImpl2
        .getFutureCreditFulfillmentGroupAdjustmentsValue();

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    assertEquals(actualFutureCreditFulfillmentGroupAdjustmentsValue.ZERO,
        actualFutureCreditFulfillmentGroupAdjustmentsValue);
  }

  /**
   * Test {@link FulfillmentGroupImpl#removeAllAdjustments()}.
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#removeAllAdjustments()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupImpl.removeAllAdjustments()"})
  public void testRemoveAllAdjustments() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(new AddressImpl());
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
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
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(null);

    // Act
    fulfillmentGroupImpl2.removeAllAdjustments();

    // Assert that nothing has changed
    assertNull(fulfillmentGroupImpl2.getFulfillmentGroupAdjustments());
  }

  /**
   * Test {@link FulfillmentGroupImpl#removeAllAdjustments()}.
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#removeAllAdjustments()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupImpl.removeAllAdjustments()"})
  public void testRemoveAllAdjustments2() {
    // Arrange
    ArrayList<FulfillmentGroupAdjustment> fulfillmentGroupAdjustments = new ArrayList<>();
    fulfillmentGroupAdjustments.add(new FulfillmentGroupAdjustmentImpl());

    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(new AddressImpl());
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl2.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl2.setFulfillmentPrice(fulfillmentPrice);
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
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(fulfillmentGroupAdjustments);

    // Act
    fulfillmentGroupImpl2.removeAllAdjustments();

    // Assert
    assertTrue(fulfillmentGroupImpl2.getFulfillmentGroupAdjustments().isEmpty());
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl2.getFulfillmentGroupAdjustmentsValue());
  }

  /**
   * Test {@link FulfillmentGroupImpl#removeAllAdjustments()}.
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#removeAllAdjustments()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupImpl.removeAllAdjustments()"})
  public void testRemoveAllAdjustments_givenFulfillmentGroupImpl() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();

    // Act
    fulfillmentGroupImpl2.removeAllAdjustments();

    // Assert that nothing has changed
    assertTrue(fulfillmentGroupImpl2.getFulfillmentGroupAdjustments().isEmpty());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getSaleFulfillmentPrice()}.
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#getSaleFulfillmentPrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getSaleFulfillmentPrice()"})
  public void testGetSaleFulfillmentPrice_givenFulfillmentGroupImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FulfillmentGroupImpl()).getSaleFulfillmentPrice());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getSaleFulfillmentPrice()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#getSaleFulfillmentPrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getSaleFulfillmentPrice()"})
  public void testGetSaleFulfillmentPrice_givenOrderImplCurrencyIsNull_thenReturnMoney() {
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
    order.setTotalTax(new Money());
    order.setCurrency(null);

    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(new AddressImpl());
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl2.setFulfillmentPrice(fulfillmentPrice);
    fulfillmentGroupImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl2.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl2.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl2.setMethod("Fulfillment Method");
    fulfillmentGroupImpl2.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl2.setPhone(new PhoneImpl());
    fulfillmentGroupImpl2.setPrimary(true);
    fulfillmentGroupImpl2.setReferenceNumber("42");
    fulfillmentGroupImpl2.setRetailFulfillmentPrice(new Money());
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
    fulfillmentGroupImpl2.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setOrder(order);

    // Act and Assert
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl2.getSaleFulfillmentPrice());
  }

  /**
   * Test {@link FulfillmentGroupImpl#setSaleFulfillmentPrice(Money)}.
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#setSaleFulfillmentPrice(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupImpl.setSaleFulfillmentPrice(Money)"})
  public void testSetSaleFulfillmentPrice() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    Money saleFulfillmentPrice = new Money();

    // Act
    fulfillmentGroupImpl2.setSaleFulfillmentPrice(saleFulfillmentPrice);

    // Assert
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupImpl2.saleFulfillmentPrice);
    BigDecimal bigDecimal = fulfillmentGroupImpl2.saleFulfillmentPrice;
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
   * <ul>
   *   <li>Then {@link FulfillmentGroupImpl} (default constructor) {@link FulfillmentGroupImpl#saleFulfillmentPrice} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#setSaleFulfillmentPrice(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupImpl.setSaleFulfillmentPrice(Money)"})
  public void testSetSaleFulfillmentPrice_thenFulfillmentGroupImplSaleFulfillmentPriceIsNull() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(new AddressImpl());
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl2.setFulfillmentPrice(fulfillmentPrice);
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

    // Act
    fulfillmentGroupImpl2.setSaleFulfillmentPrice(null);

    // Assert
    assertNull(fulfillmentGroupImpl2.saleFulfillmentPrice);
    assertNull(fulfillmentGroupImpl2.getSaleFulfillmentPrice());
    assertNull(fulfillmentGroupImpl2.getSaleShippingPrice());
    Money zeroResult = fulfillmentGroupImpl2.getTotalTax().zero();
    Money zeroResult2 = zeroResult.zero();
    Money absResult = zeroResult2.abs();
    assertEquals(fulfillmentPrice, absResult.abs());
    Money zeroResult3 = zeroResult2.zero();
    assertEquals(fulfillmentPrice, zeroResult3.abs());
    assertEquals(fulfillmentPrice, absResult.zero());
    Money zeroResult4 = zeroResult.abs().zero();
    assertEquals(fulfillmentPrice, zeroResult4.zero());
    assertEquals(fulfillmentPrice, zeroResult3.zero());
    BigDecimal bigDecimal = fulfillmentGroupImpl2.totalTax;
    assertSame(bigDecimal, absResult.getAmount());
    assertSame(bigDecimal, zeroResult4.getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getSaleShippingPrice()}.
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#getSaleShippingPrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getSaleShippingPrice()"})
  public void testGetSaleShippingPrice_givenFulfillmentGroupImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FulfillmentGroupImpl()).getSaleShippingPrice());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getSaleShippingPrice()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#getSaleShippingPrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getSaleShippingPrice()"})
  public void testGetSaleShippingPrice_givenOrderImplCurrencyIsNull_thenReturnMoney() {
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
    order.setTotalTax(new Money());
    order.setCurrency(null);

    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(new AddressImpl());
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl2.setFulfillmentPrice(fulfillmentPrice);
    fulfillmentGroupImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl2.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl2.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl2.setMethod("Fulfillment Method");
    fulfillmentGroupImpl2.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl2.setPhone(new PhoneImpl());
    fulfillmentGroupImpl2.setPrimary(true);
    fulfillmentGroupImpl2.setReferenceNumber("42");
    fulfillmentGroupImpl2.setRetailFulfillmentPrice(new Money());
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
    fulfillmentGroupImpl2.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setOrder(order);

    // Act and Assert
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl2.getSaleShippingPrice());
  }

  /**
   * Test {@link FulfillmentGroupImpl#setSaleShippingPrice(Money)}.
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#setSaleShippingPrice(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupImpl.setSaleShippingPrice(Money)"})
  public void testSetSaleShippingPrice() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    Money saleShippingPrice = new Money();

    // Act
    fulfillmentGroupImpl2.setSaleShippingPrice(saleShippingPrice);

    // Assert
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupImpl2.saleFulfillmentPrice);
    BigDecimal bigDecimal = fulfillmentGroupImpl2.saleFulfillmentPrice;
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
   * <ul>
   *   <li>Then {@link FulfillmentGroupImpl} (default constructor) {@link FulfillmentGroupImpl#saleFulfillmentPrice} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#setSaleShippingPrice(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupImpl.setSaleShippingPrice(Money)"})
  public void testSetSaleShippingPrice_thenFulfillmentGroupImplSaleFulfillmentPriceIsNull() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(new AddressImpl());
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl2.setFulfillmentPrice(fulfillmentPrice);
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

    // Act
    fulfillmentGroupImpl2.setSaleShippingPrice(null);

    // Assert
    assertNull(fulfillmentGroupImpl2.saleFulfillmentPrice);
    assertNull(fulfillmentGroupImpl2.getSaleFulfillmentPrice());
    assertNull(fulfillmentGroupImpl2.getSaleShippingPrice());
    Money zeroResult = fulfillmentGroupImpl2.getTotalTax().zero();
    Money zeroResult2 = zeroResult.zero();
    Money absResult = zeroResult2.abs();
    assertEquals(fulfillmentPrice, absResult.abs());
    Money zeroResult3 = zeroResult2.zero();
    assertEquals(fulfillmentPrice, zeroResult3.abs());
    assertEquals(fulfillmentPrice, absResult.zero());
    Money zeroResult4 = zeroResult.abs().zero();
    assertEquals(fulfillmentPrice, zeroResult4.zero());
    assertEquals(fulfillmentPrice, zeroResult3.zero());
    BigDecimal bigDecimal = fulfillmentGroupImpl2.totalTax;
    assertSame(bigDecimal, absResult.getAmount());
    assertSame(bigDecimal, zeroResult4.getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getFulfillmentPrice()}.
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#getFulfillmentPrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getFulfillmentPrice()"})
  public void testGetFulfillmentPrice_givenFulfillmentGroupImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FulfillmentGroupImpl()).getFulfillmentPrice());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getFulfillmentPrice()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#getFulfillmentPrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getFulfillmentPrice()"})
  public void testGetFulfillmentPrice_givenOrderImplCurrencyIsNull_thenReturnMoney() {
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
    order.setTotalTax(new Money());
    order.setCurrency(null);

    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(new AddressImpl());
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl2.setIsShippingPriceTaxable(true);
    Money merchandiseTotal = new Money();
    fulfillmentGroupImpl2.setMerchandiseTotal(merchandiseTotal);
    fulfillmentGroupImpl2.setMethod("Fulfillment Method");
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
    fulfillmentGroupImpl2.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setOrder(order);

    // Act and Assert
    assertEquals(merchandiseTotal, fulfillmentGroupImpl2.getFulfillmentPrice());
  }

  /**
   * Test {@link FulfillmentGroupImpl#setFulfillmentPrice(Money)}.
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#setFulfillmentPrice(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupImpl.setFulfillmentPrice(Money)"})
  public void testSetFulfillmentPrice() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    Money fulfillmentPrice = new Money();

    // Act
    fulfillmentGroupImpl2.setFulfillmentPrice(fulfillmentPrice);

    // Assert
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupImpl2.fulfillmentPrice);
    BigDecimal bigDecimal = fulfillmentGroupImpl2.fulfillmentPrice;
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
   * <ul>
   *   <li>Then {@link FulfillmentGroupImpl} (default constructor) {@link FulfillmentGroupImpl#fulfillmentPrice} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#setFulfillmentPrice(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupImpl.setFulfillmentPrice(Money)"})
  public void testSetFulfillmentPrice_thenFulfillmentGroupImplFulfillmentPriceIsNull() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(new AddressImpl());
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl2.setFulfillmentPrice(fulfillmentPrice);
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

    // Act
    fulfillmentGroupImpl2.setFulfillmentPrice(null);

    // Assert
    assertNull(fulfillmentGroupImpl2.fulfillmentPrice);
    assertNull(fulfillmentGroupImpl2.getFulfillmentPrice());
    assertNull(fulfillmentGroupImpl2.getShippingPrice());
    Money zeroResult = fulfillmentGroupImpl2.getTotalTax().zero();
    Money zeroResult2 = zeroResult.zero();
    Money absResult = zeroResult2.abs();
    assertEquals(fulfillmentPrice, absResult.abs());
    Money zeroResult3 = zeroResult2.zero();
    assertEquals(fulfillmentPrice, zeroResult3.abs());
    assertEquals(fulfillmentPrice, absResult.zero());
    Money zeroResult4 = zeroResult.abs().zero();
    assertEquals(fulfillmentPrice, zeroResult4.zero());
    assertEquals(fulfillmentPrice, zeroResult3.zero());
    BigDecimal bigDecimal = fulfillmentGroupImpl2.totalTax;
    assertSame(bigDecimal, absResult.getAmount());
    assertSame(bigDecimal, zeroResult4.getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getShippingPrice()}.
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#getShippingPrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getShippingPrice()"})
  public void testGetShippingPrice_givenFulfillmentGroupImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FulfillmentGroupImpl()).getShippingPrice());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getShippingPrice()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#getShippingPrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getShippingPrice()"})
  public void testGetShippingPrice_givenOrderImplCurrencyIsNull_thenReturnMoney() {
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
    order.setTotalTax(new Money());
    order.setCurrency(null);

    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(new AddressImpl());
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl2.setIsShippingPriceTaxable(true);
    Money merchandiseTotal = new Money();
    fulfillmentGroupImpl2.setMerchandiseTotal(merchandiseTotal);
    fulfillmentGroupImpl2.setMethod("Fulfillment Method");
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
    fulfillmentGroupImpl2.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl2.setOrder(order);

    // Act and Assert
    assertEquals(merchandiseTotal, fulfillmentGroupImpl2.getShippingPrice());
  }

  /**
   * Test {@link FulfillmentGroupImpl#setShippingPrice(Money)}.
   * <ul>
   *   <li>Then {@link FulfillmentGroupImpl} (default constructor) {@link FulfillmentGroupImpl#fulfillmentPrice} is {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#setShippingPrice(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupImpl.setShippingPrice(Money)"})
  public void testSetShippingPrice_thenFulfillmentGroupImplFulfillmentPriceIsBigDecimalWith000() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    Money shippingPrice = new Money();

    // Act
    fulfillmentGroupImpl2.setShippingPrice(shippingPrice);

    // Assert
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupImpl2.fulfillmentPrice);
    BigDecimal bigDecimal = fulfillmentGroupImpl2.fulfillmentPrice;
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
   * <ul>
   *   <li>Then {@link FulfillmentGroupImpl} (default constructor) {@link FulfillmentGroupImpl#fulfillmentPrice} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#setShippingPrice(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupImpl.setShippingPrice(Money)"})
  public void testSetShippingPrice_thenFulfillmentGroupImplFulfillmentPriceIsNull() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(new AddressImpl());
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl2.setFulfillmentPrice(fulfillmentPrice);
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

    // Act
    fulfillmentGroupImpl2.setShippingPrice(null);

    // Assert
    assertNull(fulfillmentGroupImpl2.fulfillmentPrice);
    assertNull(fulfillmentGroupImpl2.getFulfillmentPrice());
    assertNull(fulfillmentGroupImpl2.getShippingPrice());
    Money zeroResult = fulfillmentGroupImpl2.getTotalTax().zero();
    Money zeroResult2 = zeroResult.zero();
    Money absResult = zeroResult2.abs();
    assertEquals(fulfillmentPrice, absResult.abs());
    Money zeroResult3 = zeroResult2.zero();
    assertEquals(fulfillmentPrice, zeroResult3.abs());
    assertEquals(fulfillmentPrice, absResult.zero());
    Money zeroResult4 = zeroResult.abs().zero();
    assertEquals(fulfillmentPrice, zeroResult4.zero());
    assertEquals(fulfillmentPrice, zeroResult3.zero());
    BigDecimal bigDecimal = fulfillmentGroupImpl2.totalTax;
    assertSame(bigDecimal, absResult.getAmount());
    assertSame(bigDecimal, zeroResult4.getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getTotalTax()}.
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#getTotalTax()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getTotalTax()"})
  public void testGetTotalTax_givenFulfillmentGroupImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FulfillmentGroupImpl()).getTotalTax());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getTotalTax()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#getTotalTax()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getTotalTax()"})
  public void testGetTotalTax_givenOrderImplCurrencyIsNull_thenReturnMoney() {
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
    order.setTotalTax(new Money());
    order.setCurrency(null);

    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(new AddressImpl());
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl2.setFulfillmentPrice(fulfillmentPrice);
    fulfillmentGroupImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl2.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl2.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl2.setMethod("Fulfillment Method");
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
    fulfillmentGroupImpl2.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl2.setTotalTax(new Money());
    fulfillmentGroupImpl2.setOrder(order);

    // Act and Assert
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl2.getTotalTax());
  }

  /**
   * Test {@link FulfillmentGroupImpl#setTotalTax(Money)}.
   * <ul>
   *   <li>Then {@link FulfillmentGroupImpl} (default constructor) {@link FulfillmentGroupImpl#totalTax} is {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#setTotalTax(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupImpl.setTotalTax(Money)"})
  public void testSetTotalTax_thenFulfillmentGroupImplTotalTaxIsBigDecimalWith000() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    Money totalTax = new Money();

    // Act
    fulfillmentGroupImpl2.setTotalTax(totalTax);

    // Assert
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupImpl2.totalTax);
    BigDecimal bigDecimal = fulfillmentGroupImpl2.totalTax;
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
   * <ul>
   *   <li>Then {@link FulfillmentGroupImpl} (default constructor) {@link FulfillmentGroupImpl#totalTax} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#setTotalTax(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupImpl.setTotalTax(Money)"})
  public void testSetTotalTax_thenFulfillmentGroupImplTotalTaxIsNull() {
    // Arrange
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

    // Act
    fulfillmentGroupImpl2.setTotalTax(null);

    // Assert
    assertNull(fulfillmentGroupImpl2.totalTax);
    assertNull(fulfillmentGroupImpl2.getTotalTax());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getTotalItemTax()}.
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#getTotalItemTax()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getTotalItemTax()"})
  public void testGetTotalItemTax_givenFulfillmentGroupImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FulfillmentGroupImpl()).getTotalItemTax());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getTotalItemTax()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#getTotalItemTax()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getTotalItemTax()"})
  public void testGetTotalItemTax_givenOrderImplCurrencyIsNull_thenReturnMoney() {
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
    order.setTotalTax(new Money());
    order.setCurrency(null);

    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(new AddressImpl());
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl2.setFulfillmentPrice(fulfillmentPrice);
    fulfillmentGroupImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl2.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl2.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl2.setMethod("Fulfillment Method");
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
    fulfillmentGroupImpl2.setTotalTax(new Money());
    fulfillmentGroupImpl2.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl2.setTotalItemTax(new Money());
    fulfillmentGroupImpl2.setOrder(order);

    // Act and Assert
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl2.getTotalItemTax());
  }

  /**
   * Test {@link FulfillmentGroupImpl#setTotalItemTax(Money)}.
   * <ul>
   *   <li>Then {@link FulfillmentGroupImpl} (default constructor) {@link FulfillmentGroupImpl#totalItemTax} is {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#setTotalItemTax(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupImpl.setTotalItemTax(Money)"})
  public void testSetTotalItemTax_thenFulfillmentGroupImplTotalItemTaxIsBigDecimalWith000() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    Money totalItemTax = new Money();

    // Act
    fulfillmentGroupImpl2.setTotalItemTax(totalItemTax);

    // Assert
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupImpl2.totalItemTax);
    BigDecimal bigDecimal = fulfillmentGroupImpl2.totalItemTax;
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
   * <ul>
   *   <li>Then {@link FulfillmentGroupImpl} (default constructor) {@link FulfillmentGroupImpl#totalItemTax} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#setTotalItemTax(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupImpl.setTotalItemTax(Money)"})
  public void testSetTotalItemTax_thenFulfillmentGroupImplTotalItemTaxIsNull() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(new AddressImpl());
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl2.setFulfillmentPrice(fulfillmentPrice);
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

    // Act
    fulfillmentGroupImpl2.setTotalItemTax(null);

    // Assert
    assertNull(fulfillmentGroupImpl2.totalItemTax);
    assertNull(fulfillmentGroupImpl2.getTotalItemTax());
    Money zeroResult = fulfillmentGroupImpl2.getTotalTax().zero();
    Money zeroResult2 = zeroResult.zero();
    Money absResult = zeroResult2.abs();
    assertEquals(fulfillmentPrice, absResult.abs());
    Money zeroResult3 = zeroResult2.zero();
    assertEquals(fulfillmentPrice, zeroResult3.abs());
    assertEquals(fulfillmentPrice, absResult.zero());
    Money zeroResult4 = zeroResult.abs().zero();
    assertEquals(fulfillmentPrice, zeroResult4.zero());
    assertEquals(fulfillmentPrice, zeroResult3.zero());
    BigDecimal bigDecimal = fulfillmentGroupImpl2.totalTax;
    assertSame(bigDecimal, absResult.getAmount());
    assertSame(bigDecimal, zeroResult4.getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getTotalFeeTax()}.
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#getTotalFeeTax()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getTotalFeeTax()"})
  public void testGetTotalFeeTax_givenFulfillmentGroupImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FulfillmentGroupImpl()).getTotalFeeTax());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getTotalFeeTax()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#getTotalFeeTax()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getTotalFeeTax()"})
  public void testGetTotalFeeTax_givenOrderImplCurrencyIsNull_thenReturnMoney() {
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
    order.setTotalTax(new Money());
    order.setCurrency(null);

    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(new AddressImpl());
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl2.setFulfillmentPrice(fulfillmentPrice);
    fulfillmentGroupImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl2.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl2.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl2.setMethod("Fulfillment Method");
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
    fulfillmentGroupImpl2.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl2.setTotalItemTax(new Money());
    fulfillmentGroupImpl2.setTotalTax(new Money());
    fulfillmentGroupImpl2.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl2.setTotalFeeTax(new Money());
    fulfillmentGroupImpl2.setOrder(order);

    // Act and Assert
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl2.getTotalFeeTax());
  }

  /**
   * Test {@link FulfillmentGroupImpl#setTotalFeeTax(Money)}.
   * <ul>
   *   <li>Then {@link FulfillmentGroupImpl} (default constructor) {@link FulfillmentGroupImpl#totalFeeTax} is {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#setTotalFeeTax(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupImpl.setTotalFeeTax(Money)"})
  public void testSetTotalFeeTax_thenFulfillmentGroupImplTotalFeeTaxIsBigDecimalWith000() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    Money totalFeeTax = new Money();

    // Act
    fulfillmentGroupImpl2.setTotalFeeTax(totalFeeTax);

    // Assert
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupImpl2.totalFeeTax);
    BigDecimal bigDecimal = fulfillmentGroupImpl2.totalFeeTax;
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
   * <ul>
   *   <li>Then {@link FulfillmentGroupImpl} (default constructor) {@link FulfillmentGroupImpl#totalFeeTax} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#setTotalFeeTax(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupImpl.setTotalFeeTax(Money)"})
  public void testSetTotalFeeTax_thenFulfillmentGroupImplTotalFeeTaxIsNull() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(new AddressImpl());
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl2.setFulfillmentPrice(fulfillmentPrice);
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

    // Act
    fulfillmentGroupImpl2.setTotalFeeTax(null);

    // Assert
    assertNull(fulfillmentGroupImpl2.totalFeeTax);
    assertNull(fulfillmentGroupImpl2.getTotalFeeTax());
    Money zeroResult = fulfillmentGroupImpl2.getTotalTax().zero();
    Money zeroResult2 = zeroResult.zero();
    Money absResult = zeroResult2.abs();
    assertEquals(fulfillmentPrice, absResult.abs());
    Money zeroResult3 = zeroResult2.zero();
    assertEquals(fulfillmentPrice, zeroResult3.abs());
    assertEquals(fulfillmentPrice, absResult.zero());
    Money zeroResult4 = zeroResult.abs().zero();
    assertEquals(fulfillmentPrice, zeroResult4.zero());
    assertEquals(fulfillmentPrice, zeroResult3.zero());
    BigDecimal bigDecimal = fulfillmentGroupImpl2.totalTax;
    assertSame(bigDecimal, absResult.getAmount());
    assertSame(bigDecimal, zeroResult4.getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getTotalFulfillmentGroupTax()}.
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#getTotalFulfillmentGroupTax()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getTotalFulfillmentGroupTax()"})
  public void testGetTotalFulfillmentGroupTax_givenFulfillmentGroupImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FulfillmentGroupImpl()).getTotalFulfillmentGroupTax());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getTotalFulfillmentGroupTax()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#getTotalFulfillmentGroupTax()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getTotalFulfillmentGroupTax()"})
  public void testGetTotalFulfillmentGroupTax_givenOrderImplCurrencyIsNull_thenReturnMoney() {
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
    order.setTotalTax(new Money());
    order.setCurrency(null);

    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(new AddressImpl());
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl2.setFulfillmentPrice(fulfillmentPrice);
    fulfillmentGroupImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl2.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl2.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl2.setMethod("Fulfillment Method");
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
    fulfillmentGroupImpl2.setTotalItemTax(new Money());
    fulfillmentGroupImpl2.setTotalTax(new Money());
    fulfillmentGroupImpl2.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl2.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl2.setOrder(order);

    // Act and Assert
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl2.getTotalFulfillmentGroupTax());
  }

  /**
   * Test {@link FulfillmentGroupImpl#setTotalFulfillmentGroupTax(Money)}.
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#setTotalFulfillmentGroupTax(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupImpl.setTotalFulfillmentGroupTax(Money)"})
  public void testSetTotalFulfillmentGroupTax() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    Money totalFulfillmentGroupTax = new Money();

    // Act
    fulfillmentGroupImpl2.setTotalFulfillmentGroupTax(totalFulfillmentGroupTax);

    // Assert
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupImpl2.totalFulfillmentGroupTax);
    BigDecimal bigDecimal = fulfillmentGroupImpl2.totalFulfillmentGroupTax;
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
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#setTotalFulfillmentGroupTax(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupImpl.setTotalFulfillmentGroupTax(Money)"})
  public void testSetTotalFulfillmentGroupTax2() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(new AddressImpl());
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl2.setFulfillmentPrice(fulfillmentPrice);
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

    // Act
    fulfillmentGroupImpl2.setTotalFulfillmentGroupTax(null);

    // Assert
    assertNull(fulfillmentGroupImpl2.totalFulfillmentGroupTax);
    assertNull(fulfillmentGroupImpl2.getTotalFulfillmentGroupTax());
    Money zeroResult = fulfillmentGroupImpl2.getTotalTax().zero();
    Money zeroResult2 = zeroResult.zero();
    Money absResult = zeroResult2.abs();
    assertEquals(fulfillmentPrice, absResult.abs());
    Money zeroResult3 = zeroResult2.zero();
    assertEquals(fulfillmentPrice, zeroResult3.abs());
    assertEquals(fulfillmentPrice, absResult.zero());
    Money zeroResult4 = zeroResult.abs().zero();
    assertEquals(fulfillmentPrice, zeroResult4.zero());
    assertEquals(fulfillmentPrice, zeroResult3.zero());
    BigDecimal bigDecimal = fulfillmentGroupImpl2.totalTax;
    assertSame(bigDecimal, absResult.getAmount());
    assertSame(bigDecimal, zeroResult4.getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getMerchandiseTotal()}.
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#getMerchandiseTotal()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getMerchandiseTotal()"})
  public void testGetMerchandiseTotal_givenFulfillmentGroupImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FulfillmentGroupImpl()).getMerchandiseTotal());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getMerchandiseTotal()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#getMerchandiseTotal()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getMerchandiseTotal()"})
  public void testGetMerchandiseTotal_givenOrderImplCurrencyIsNull_thenReturnMoney() {
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
    order.setTotalTax(new Money());
    order.setCurrency(null);

    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(new AddressImpl());
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl2.setFulfillmentPrice(fulfillmentPrice);
    fulfillmentGroupImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl2.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl2.setMethod("Fulfillment Method");
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
    fulfillmentGroupImpl2.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl2.setOrder(order);

    // Act and Assert
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl2.getMerchandiseTotal());
  }

  /**
   * Test {@link FulfillmentGroupImpl#setMerchandiseTotal(Money)}.
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#setMerchandiseTotal(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupImpl.setMerchandiseTotal(Money)"})
  public void testSetMerchandiseTotal() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    Money merchandiseTotal = new Money();

    // Act
    fulfillmentGroupImpl2.setMerchandiseTotal(merchandiseTotal);

    // Assert
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupImpl2.merchandiseTotal);
    BigDecimal bigDecimal = fulfillmentGroupImpl2.merchandiseTotal;
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
   * <ul>
   *   <li>Then {@link FulfillmentGroupImpl} (default constructor) {@link FulfillmentGroupImpl#merchandiseTotal} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#setMerchandiseTotal(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupImpl.setMerchandiseTotal(Money)"})
  public void testSetMerchandiseTotal_thenFulfillmentGroupImplMerchandiseTotalIsNull() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(new AddressImpl());
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl2.setFulfillmentPrice(fulfillmentPrice);
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

    // Act
    fulfillmentGroupImpl2.setMerchandiseTotal(null);

    // Assert
    assertNull(fulfillmentGroupImpl2.merchandiseTotal);
    assertNull(fulfillmentGroupImpl2.getMerchandiseTotal());
    Money zeroResult = fulfillmentGroupImpl2.getTotalTax().zero();
    Money zeroResult2 = zeroResult.zero();
    Money absResult = zeroResult2.abs();
    assertEquals(fulfillmentPrice, absResult.abs());
    Money zeroResult3 = zeroResult2.zero();
    assertEquals(fulfillmentPrice, zeroResult3.abs());
    assertEquals(fulfillmentPrice, absResult.zero());
    Money zeroResult4 = zeroResult.abs().zero();
    assertEquals(fulfillmentPrice, zeroResult4.zero());
    assertEquals(fulfillmentPrice, zeroResult3.zero());
    BigDecimal bigDecimal = fulfillmentGroupImpl2.totalTax;
    assertSame(bigDecimal, absResult.getAmount());
    assertSame(bigDecimal, zeroResult4.getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getTotal()}.
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#getTotal()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getTotal()"})
  public void testGetTotal_givenFulfillmentGroupImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FulfillmentGroupImpl()).getTotal());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getTotal()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#getTotal()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupImpl.getTotal()"})
  public void testGetTotal_givenOrderImplCurrencyIsNull_thenReturnMoney() {
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
    order.setTotalTax(new Money());
    order.setCurrency(null);

    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(new AddressImpl());
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl2.setFulfillmentPrice(fulfillmentPrice);
    fulfillmentGroupImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupImpl2.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl2.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl2.setMethod("Fulfillment Method");
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
    fulfillmentGroupImpl2.setTotalFeeTax(new Money());
    fulfillmentGroupImpl2.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl2.setTotalItemTax(new Money());
    fulfillmentGroupImpl2.setTotalTax(new Money());
    fulfillmentGroupImpl2.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl2.setTotal(new Money());
    fulfillmentGroupImpl2.setOrder(order);

    // Act and Assert
    assertEquals(fulfillmentPrice, fulfillmentGroupImpl2.getTotal());
  }

  /**
   * Test {@link FulfillmentGroupImpl#setTotal(Money)}.
   * <ul>
   *   <li>Then {@link FulfillmentGroupImpl} (default constructor) {@link FulfillmentGroupImpl#total} is {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#setTotal(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupImpl.setTotal(Money)"})
  public void testSetTotal_thenFulfillmentGroupImplTotalIsBigDecimalWith000() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    Money orderTotal = new Money();

    // Act
    fulfillmentGroupImpl2.setTotal(orderTotal);

    // Assert
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupImpl2.total);
    BigDecimal bigDecimal = fulfillmentGroupImpl2.total;
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
   * <ul>
   *   <li>Then {@link FulfillmentGroupImpl} (default constructor) {@link FulfillmentGroupImpl#total} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#setTotal(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupImpl.setTotal(Money)"})
  public void testSetTotal_thenFulfillmentGroupImplTotalIsNull() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(new AddressImpl());
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroupImpl2.setFulfillmentOption(new FulfillmentOptionImpl());
    Money fulfillmentPrice = new Money();
    fulfillmentGroupImpl2.setFulfillmentPrice(fulfillmentPrice);
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

    // Act
    fulfillmentGroupImpl2.setTotal(null);

    // Assert
    assertNull(fulfillmentGroupImpl2.total);
    assertNull(fulfillmentGroupImpl2.getTotal());
    Money zeroResult = fulfillmentGroupImpl2.getTotalTax().zero();
    Money zeroResult2 = zeroResult.zero();
    Money absResult = zeroResult2.abs();
    assertEquals(fulfillmentPrice, absResult.abs());
    Money zeroResult3 = zeroResult2.zero();
    assertEquals(fulfillmentPrice, zeroResult3.abs());
    assertEquals(fulfillmentPrice, absResult.zero());
    Money zeroResult4 = zeroResult.abs().zero();
    assertEquals(fulfillmentPrice, zeroResult4.zero());
    assertEquals(fulfillmentPrice, zeroResult3.zero());
    BigDecimal bigDecimal = fulfillmentGroupImpl2.totalTax;
    assertSame(bigDecimal, absResult.getAmount());
    assertSame(bigDecimal, zeroResult4.getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getStatus()}.
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#getStatus()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FulfillmentGroupStatusType FulfillmentGroupImpl.getStatus()"})
  public void testGetStatus() {
    // Arrange, Act and Assert
    assertNull((new FulfillmentGroupImpl()).getStatus());
  }

  /**
   * Test {@link FulfillmentGroupImpl#setStatus(FulfillmentGroupStatusType)}.
   * <ul>
   *   <li>When {@link FulfillmentGroupStatusType#CANCELLED}.</li>
   *   <li>Then {@link FulfillmentGroupImpl} (default constructor) {@link FulfillmentGroupImpl#status} is {@code CANCELLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#setStatus(FulfillmentGroupStatusType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType)"})
  public void testSetStatus_whenCancelled_thenFulfillmentGroupImplStatusIsCancelled() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    FulfillmentGroupStatusType status = FulfillmentGroupStatusType.CANCELLED;

    // Act
    fulfillmentGroupImpl2.setStatus(status);

    // Assert
    assertEquals("CANCELLED", fulfillmentGroupImpl2.status);
    FulfillmentGroupStatusType expectedStatus = status.CANCELLED;
    assertSame(expectedStatus, fulfillmentGroupImpl2.getStatus());
  }

  /**
   * Test {@link FulfillmentGroupImpl#addFulfillmentGroupFee(FulfillmentGroupFee)}.
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#addFulfillmentGroupFee(FulfillmentGroupFee)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupImpl.addFulfillmentGroupFee(FulfillmentGroupFee)"})
  public void testAddFulfillmentGroupFee_givenFulfillmentGroupImpl() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    FulfillmentGroupFeeImpl fulfillmentGroupFee = new FulfillmentGroupFeeImpl();

    // Act
    fulfillmentGroupImpl2.addFulfillmentGroupFee(fulfillmentGroupFee);

    // Assert
    List<FulfillmentGroupFee> fulfillmentGroupFees = fulfillmentGroupImpl2.getFulfillmentGroupFees();
    assertEquals(1, fulfillmentGroupFees.size());
    assertSame(fulfillmentGroupFee, fulfillmentGroupFees.get(0));
  }

  /**
   * Test {@link FulfillmentGroupImpl#addFulfillmentGroupFee(FulfillmentGroupFee)}.
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl} (default constructor) Address is {@link AddressImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#addFulfillmentGroupFee(FulfillmentGroupFee)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupImpl.addFulfillmentGroupFee(FulfillmentGroupFee)"})
  public void testAddFulfillmentGroupFee_givenFulfillmentGroupImplAddressIsAddressImpl() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    fulfillmentGroupImpl2.setAddress(new AddressImpl());
    fulfillmentGroupImpl2.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl2.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl2.setFulfillmentGroupAdjustments(new ArrayList<>());
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
    fulfillmentGroupImpl2.setFulfillmentGroupFees(null);
    FulfillmentGroupFeeImpl fulfillmentGroupFee = new FulfillmentGroupFeeImpl();

    // Act
    fulfillmentGroupImpl2.addFulfillmentGroupFee(fulfillmentGroupFee);

    // Assert
    List<FulfillmentGroupFee> fulfillmentGroupFees = fulfillmentGroupImpl2.getFulfillmentGroupFees();
    assertEquals(1, fulfillmentGroupFees.size());
    assertSame(fulfillmentGroupFee, fulfillmentGroupFees.get(0));
  }

  /**
   * Test {@link FulfillmentGroupImpl#getCurrencyCode()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@link BroadleafCurrencyImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#getCurrencyCode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FulfillmentGroupImpl.getCurrencyCode()"})
  public void testGetCurrencyCode_givenOrderImplCurrencyIsBroadleafCurrencyImpl_thenReturnNull() {
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
    order.setTotalTax(new Money());
    order.setCurrency(new BroadleafCurrencyImpl());

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
    fulfillmentGroupImpl2.setOrder(order);

    // Act and Assert
    assertNull(fulfillmentGroupImpl2.getCurrencyCode());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getCurrencyCode()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#getCurrencyCode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FulfillmentGroupImpl.getCurrencyCode()"})
  public void testGetCurrencyCode_givenOrderImplCurrencyIsNull_thenReturnNull() {
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
    order.setTotalTax(new Money());
    order.setCurrency(null);

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
    fulfillmentGroupImpl2.setOrder(order);

    // Act and Assert
    assertNull(fulfillmentGroupImpl2.getCurrencyCode());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getShippingOverride()}.
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#getShippingOverride()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean FulfillmentGroupImpl.getShippingOverride()"})
  public void testGetShippingOverride_givenFulfillmentGroupImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new FulfillmentGroupImpl()).getShippingOverride());
  }

  /**
   * Test {@link FulfillmentGroupImpl#getShippingOverride()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#getShippingOverride()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean FulfillmentGroupImpl.getShippingOverride()"})
  public void testGetShippingOverride_thenReturnTrue() {
    // Arrange
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
    fulfillmentGroupImpl2.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl2.setTotal(new Money());
    fulfillmentGroupImpl2.setTotalFeeTax(new Money());
    fulfillmentGroupImpl2.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl2.setTotalItemTax(new Money());
    fulfillmentGroupImpl2.setTotalTax(new Money());
    fulfillmentGroupImpl2.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl2.setShippingOverride(true);

    // Act and Assert
    assertTrue(fulfillmentGroupImpl2.getShippingOverride());
  }

  /**
   * Test {@link FulfillmentGroupImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse FulfillmentGroupImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<FulfillmentGroup> actualCreateOrRetrieveCopyInstanceResult = fulfillmentGroupImpl2
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link FulfillmentGroupImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Then Clone return {@link FulfillmentGroupImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse FulfillmentGroupImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance_thenCloneReturnFulfillmentGroupImpl() throws CloneNotSupportedException {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroupImpl2 = new FulfillmentGroupImpl();
    GenericEntityService genericEntityService = mock(GenericEntityService.class);
    when(genericEntityService.getIdentifier(Mockito.<Object>any())).thenReturn(null);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(genericEntityService.getCeilingImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();

    // Act
    CreateResponse<FulfillmentGroup> actualCreateOrRetrieveCopyInstanceResult = fulfillmentGroupImpl2
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    verify(genericEntityService)
        .getCeilingImplClass(eq("org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl"));
    verify(genericEntityService).getIdentifier(isA(Object.class));
    FulfillmentGroup clone = actualCreateOrRetrieveCopyInstanceResult.getClone();
    assertTrue(clone instanceof FulfillmentGroupImpl);
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(fulfillmentGroupImpl2, clone);
  }

  /**
   * Test {@link FulfillmentGroupImpl#cloneTaxDetails(MultiTenantCopyContext, FulfillmentGroup)}.
   * <ul>
   *   <li>Then {@link FulfillmentGroupImpl} (default constructor) Taxes size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#cloneTaxDetails(MultiTenantCopyContext, FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupImpl.cloneTaxDetails(MultiTenantCopyContext, FulfillmentGroup)"})
  public void testCloneTaxDetails_thenFulfillmentGroupImplTaxesSizeIsOne() throws CloneNotSupportedException {
    // Arrange
    TaxDetailImpl taxDetailImpl = mock(TaxDetailImpl.class);
    TaxDetailImpl taxDetailImpl2 = new TaxDetailImpl();
    when(taxDetailImpl.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(taxDetailImpl2, true));

    ArrayList<TaxDetail> taxes = new ArrayList<>();
    taxes.add(taxDetailImpl);

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
    fulfillmentGroupImpl2.setTotal(new Money());
    fulfillmentGroupImpl2.setTotalFeeTax(new Money());
    fulfillmentGroupImpl2.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl2.setTotalItemTax(new Money());
    fulfillmentGroupImpl2.setTotalTax(new Money());
    fulfillmentGroupImpl2.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl2.setTaxes(taxes);
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();
    MultiTenantCopyContext context = new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager());

    FulfillmentGroupImpl cloned = new FulfillmentGroupImpl();

    // Act
    fulfillmentGroupImpl2.cloneTaxDetails(context, cloned);

    // Assert
    verify(taxDetailImpl).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    List<TaxDetail> taxes2 = cloned.getTaxes();
    assertEquals(1, taxes2.size());
    assertSame(taxDetailImpl2, taxes2.get(0));
  }

  /**
   * Test {@link FulfillmentGroupImpl#equals(Object)}, and {@link FulfillmentGroupImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentGroupImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentGroupImpl.equals(Object)", "int FulfillmentGroupImpl.hashCode()"})
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
    int expectedHashCodeResult = fulfillmentGroupImpl.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentGroupImpl2.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupImpl#equals(Object)}, and {@link FulfillmentGroupImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentGroupImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentGroupImpl.equals(Object)", "int FulfillmentGroupImpl.hashCode()"})
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
    int expectedHashCodeResult = fulfillmentGroupImpl.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentGroupImpl2.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupImpl#equals(Object)}, and {@link FulfillmentGroupImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentGroupImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentGroupImpl.equals(Object)", "int FulfillmentGroupImpl.hashCode()"})
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
    int expectedHashCodeResult = fulfillmentGroupImpl.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentGroupImpl2.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupImpl#equals(Object)}, and {@link FulfillmentGroupImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentGroupImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentGroupImpl.equals(Object)", "int FulfillmentGroupImpl.hashCode()"})
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentGroupImpl.equals(Object)", "int FulfillmentGroupImpl.hashCode()"})
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
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentGroupImpl.equals(Object)", "int FulfillmentGroupImpl.hashCode()"})
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
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentGroupImpl.equals(Object)", "int FulfillmentGroupImpl.hashCode()"})
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
   * <p>
   * Method under test: default or parameterless constructor of {@link FulfillmentGroupImpl}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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

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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.service.type.FulfillmentGroupStatusType;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class FulfillmentGroupFeeImplDiffblueTest {
  /**
   * Method under test: {@link FulfillmentGroupFeeImpl#getAmount()}
   */
  @Test
  public void testGetAmount() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new FulfillmentGroupFeeImpl()).getAmount());
  }

  /**
   * Method under test: {@link FulfillmentGroupFeeImpl#getAmount()}
   */
  @Test
  public void testGetAmount2() {
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

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setAddress(new AddressImpl());
    fulfillmentGroup.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroup.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroup.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroup.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroup.setFulfillmentPrice(new Money());
    fulfillmentGroup.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroup.setIsShippingPriceTaxable(true);
    fulfillmentGroup.setMerchandiseTotal(new Money());
    fulfillmentGroup.setMethod("Fulfillment Method");
    fulfillmentGroup.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroup.setPhone(new PhoneImpl());
    fulfillmentGroup.setPrimary(true);
    fulfillmentGroup.setReferenceNumber("42");
    fulfillmentGroup.setRetailFulfillmentPrice(new Money());
    fulfillmentGroup.setRetailShippingPrice(new Money());
    fulfillmentGroup.setSaleFulfillmentPrice(new Money());
    fulfillmentGroup.setSaleShippingPrice(new Money());
    fulfillmentGroup.setSequence(1);
    fulfillmentGroup.setService("Service");
    fulfillmentGroup.setShippingOverride(true);
    fulfillmentGroup.setShippingPrice(new Money());
    fulfillmentGroup.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroup.setTaxes(new ArrayList<>());
    fulfillmentGroup.setTotal(new Money());
    fulfillmentGroup.setTotalFeeTax(new Money());
    fulfillmentGroup.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroup.setTotalItemTax(new Money());
    fulfillmentGroup.setTotalTax(new Money());
    fulfillmentGroup.setType(FulfillmentType.DIGITAL);
    fulfillmentGroup.setOrder(order);

    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl.setName("Name");
    fulfillmentGroupFeeImpl.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl.setTaxable(true);
    fulfillmentGroupFeeImpl.setTaxes(new ArrayList<>());
    Money totalTax = new Money();
    fulfillmentGroupFeeImpl.setTotalTax(totalTax);
    fulfillmentGroupFeeImpl.setAmount(new Money());
    fulfillmentGroupFeeImpl.setFulfillmentGroup(fulfillmentGroup);

    // Act and Assert
    assertEquals(totalTax, fulfillmentGroupFeeImpl.getAmount());
  }

  /**
   * Method under test: {@link FulfillmentGroupFeeImpl#getAmount()}
   */
  @Test
  public void testGetAmount3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl.setAmount(mock(Money.class));

    // Act and Assert
    assertNull(fulfillmentGroupFeeImpl.getAmount());
  }

  /**
   * Method under test: {@link FulfillmentGroupFeeImpl#setAmount(Money)}
   */
  @Test
  public void testSetAmount() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    Money amount = new Money();

    // Act
    fulfillmentGroupFeeImpl.setAmount(amount);

    // Assert
    BigDecimal expectedAmount = new BigDecimal("0.00");
    BigDecimal amount2 = amount.getAmount();
    assertEquals(expectedAmount, amount2);
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupFeeImpl.amount);
    assertEquals(amount, amount.abs());
    assertEquals(amount, amount.zero());
    assertSame(fulfillmentGroupFeeImpl.amount, amount2);
  }

  /**
   * Method under test: {@link FulfillmentGroupFeeImpl#setAmount(Money)}
   */
  @Test
  public void testSetAmount2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();

    // Act
    fulfillmentGroupFeeImpl.setAmount(null);

    // Assert
    assertNull(fulfillmentGroupFeeImpl.amount);
  }

  /**
   * Method under test: {@link FulfillmentGroupFeeImpl#setAmount(Money)}
   */
  @Test
  public void testSetAmount3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();

    // Act
    fulfillmentGroupFeeImpl.setAmount(mock(Money.class));

    // Assert
    assertNull(fulfillmentGroupFeeImpl.amount);
  }

  /**
   * Method under test: {@link FulfillmentGroupFeeImpl#isTaxable()}
   */
  @Test
  public void testIsTaxable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new FulfillmentGroupFeeImpl()).isTaxable());
  }

  /**
   * Method under test: {@link FulfillmentGroupFeeImpl#isTaxable()}
   */
  @Test
  public void testIsTaxable2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl.setAmount(new Money());
    fulfillmentGroupFeeImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl.setName("Name");
    fulfillmentGroupFeeImpl.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl.setTotalTax(new Money());
    fulfillmentGroupFeeImpl.setTaxable(null);

    // Act and Assert
    assertTrue(fulfillmentGroupFeeImpl.isTaxable());
  }

  /**
   * Method under test: {@link FulfillmentGroupFeeImpl#isTaxable()}
   */
  @Test
  public void testIsTaxable3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl.setAmount(mock(Money.class));
    fulfillmentGroupFeeImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl.setName("Name");
    fulfillmentGroupFeeImpl.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl.setTotalTax(new Money());
    fulfillmentGroupFeeImpl.setTaxable(null);

    // Act and Assert
    assertTrue(fulfillmentGroupFeeImpl.isTaxable());
  }

  /**
   * Method under test: {@link FulfillmentGroupFeeImpl#getTotalTax()}
   */
  @Test
  public void testGetTotalTax() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new FulfillmentGroupFeeImpl()).getTotalTax());
  }

  /**
   * Method under test: {@link FulfillmentGroupFeeImpl#getTotalTax()}
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

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setAddress(new AddressImpl());
    fulfillmentGroup.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroup.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroup.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroup.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroup.setFulfillmentPrice(new Money());
    fulfillmentGroup.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroup.setIsShippingPriceTaxable(true);
    fulfillmentGroup.setMerchandiseTotal(new Money());
    fulfillmentGroup.setMethod("Fulfillment Method");
    fulfillmentGroup.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroup.setPhone(new PhoneImpl());
    fulfillmentGroup.setPrimary(true);
    fulfillmentGroup.setReferenceNumber("42");
    fulfillmentGroup.setRetailFulfillmentPrice(new Money());
    fulfillmentGroup.setRetailShippingPrice(new Money());
    fulfillmentGroup.setSaleFulfillmentPrice(new Money());
    fulfillmentGroup.setSaleShippingPrice(new Money());
    fulfillmentGroup.setSequence(1);
    fulfillmentGroup.setService("Service");
    fulfillmentGroup.setShippingOverride(true);
    fulfillmentGroup.setShippingPrice(new Money());
    fulfillmentGroup.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroup.setTaxes(new ArrayList<>());
    fulfillmentGroup.setTotal(new Money());
    fulfillmentGroup.setTotalFeeTax(new Money());
    fulfillmentGroup.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroup.setTotalItemTax(new Money());
    fulfillmentGroup.setTotalTax(new Money());
    fulfillmentGroup.setType(FulfillmentType.DIGITAL);
    fulfillmentGroup.setOrder(order);

    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    Money amount = new Money();
    fulfillmentGroupFeeImpl.setAmount(amount);
    fulfillmentGroupFeeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl.setName("Name");
    fulfillmentGroupFeeImpl.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl.setTaxable(true);
    fulfillmentGroupFeeImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl.setTotalTax(new Money());
    fulfillmentGroupFeeImpl.setFulfillmentGroup(fulfillmentGroup);

    // Act and Assert
    assertEquals(amount, fulfillmentGroupFeeImpl.getTotalTax());
  }

  /**
   * Method under test: {@link FulfillmentGroupFeeImpl#getTotalTax()}
   */
  @Test
  public void testGetTotalTax3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl.setTotalTax(mock(Money.class));

    // Act and Assert
    assertNull(fulfillmentGroupFeeImpl.getTotalTax());
  }

  /**
   * Method under test: {@link FulfillmentGroupFeeImpl#setTotalTax(Money)}
   */
  @Test
  public void testSetTotalTax() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    Money totalTax = new Money();

    // Act
    fulfillmentGroupFeeImpl.setTotalTax(totalTax);

    // Assert
    BigDecimal expectedAmount = new BigDecimal("0.00");
    BigDecimal amount = totalTax.getAmount();
    assertEquals(expectedAmount, amount);
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupFeeImpl.totalTax);
    assertEquals(totalTax, totalTax.abs());
    assertEquals(totalTax, totalTax.zero());
    assertSame(fulfillmentGroupFeeImpl.totalTax, amount);
  }

  /**
   * Method under test: {@link FulfillmentGroupFeeImpl#setTotalTax(Money)}
   */
  @Test
  public void testSetTotalTax2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl.setAmount(new Money());
    fulfillmentGroupFeeImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl.setName("Name");
    fulfillmentGroupFeeImpl.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl.setTaxable(true);
    fulfillmentGroupFeeImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl.setTotalTax(new Money());

    // Act
    fulfillmentGroupFeeImpl.setTotalTax(null);

    // Assert
    assertNull(fulfillmentGroupFeeImpl.totalTax);
    assertNull(fulfillmentGroupFeeImpl.getTotalTax());
  }

  /**
   * Method under test: {@link FulfillmentGroupFeeImpl#setTotalTax(Money)}
   */
  @Test
  public void testSetTotalTax3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();

    // Act
    fulfillmentGroupFeeImpl.setTotalTax(mock(Money.class));

    // Assert
    assertNull(fulfillmentGroupFeeImpl.totalTax);
    assertNull(fulfillmentGroupFeeImpl.getTotalTax());
  }

  /**
   * Method under test: {@link FulfillmentGroupFeeImpl#getCurrencyCode()}
   */
  @Test
  public void testGetCurrencyCode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getCurrencyCode()).thenReturn("GBP");

    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl.setFulfillmentGroup(fulfillmentGroup);

    // Act
    String actualCurrencyCode = fulfillmentGroupFeeImpl.getCurrencyCode();

    // Assert
    verify(fulfillmentGroup).getCurrencyCode();
    assertEquals("GBP", actualCurrencyCode);
  }

  /**
   * Method under test:
   * {@link FulfillmentGroupFeeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<FulfillmentGroupFee> actualCreateOrRetrieveCopyInstanceResult = fulfillmentGroupFeeImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentGroupFeeImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupFeeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl.setAmount(new Money());
    fulfillmentGroupFeeImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl.setName("Name");
    fulfillmentGroupFeeImpl.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl.setTaxable(true);
    fulfillmentGroupFeeImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl.setTotalTax(new Money());

    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl2 = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl2.setAmount(new Money());
    fulfillmentGroupFeeImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl2.setName("Name");
    fulfillmentGroupFeeImpl2.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl2.setTaxable(true);
    fulfillmentGroupFeeImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl2.setTotalTax(new Money());

    // Act and Assert
    assertEquals(fulfillmentGroupFeeImpl, fulfillmentGroupFeeImpl2);
    int expectedHashCodeResult = fulfillmentGroupFeeImpl.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentGroupFeeImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentGroupFeeImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupFeeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl.setAmount(null);
    fulfillmentGroupFeeImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl.setName("Name");
    fulfillmentGroupFeeImpl.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl.setTaxable(true);
    fulfillmentGroupFeeImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl.setTotalTax(new Money());

    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl2 = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl2.setAmount(null);
    fulfillmentGroupFeeImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl2.setName("Name");
    fulfillmentGroupFeeImpl2.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl2.setTaxable(true);
    fulfillmentGroupFeeImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl2.setTotalTax(new Money());

    // Act and Assert
    assertEquals(fulfillmentGroupFeeImpl, fulfillmentGroupFeeImpl2);
    int expectedHashCodeResult = fulfillmentGroupFeeImpl.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentGroupFeeImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentGroupFeeImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupFeeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl.setAmount(new Money());
    fulfillmentGroupFeeImpl.setFulfillmentGroup(null);
    fulfillmentGroupFeeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl.setName("Name");
    fulfillmentGroupFeeImpl.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl.setTaxable(true);
    fulfillmentGroupFeeImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl.setTotalTax(new Money());

    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl2 = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl2.setAmount(new Money());
    fulfillmentGroupFeeImpl2.setFulfillmentGroup(null);
    fulfillmentGroupFeeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl2.setName("Name");
    fulfillmentGroupFeeImpl2.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl2.setTaxable(true);
    fulfillmentGroupFeeImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl2.setTotalTax(new Money());

    // Act and Assert
    assertEquals(fulfillmentGroupFeeImpl, fulfillmentGroupFeeImpl2);
    int expectedHashCodeResult = fulfillmentGroupFeeImpl.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentGroupFeeImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentGroupFeeImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupFeeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl.setAmount(new Money());
    fulfillmentGroupFeeImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl.setName("Name");
    fulfillmentGroupFeeImpl.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl.setTaxable(true);
    fulfillmentGroupFeeImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl.setTotalTax(new Money());

    // Act and Assert
    assertEquals(fulfillmentGroupFeeImpl, fulfillmentGroupFeeImpl);
    int expectedHashCodeResult = fulfillmentGroupFeeImpl.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentGroupFeeImpl.hashCode());
  }

  /**
   * Method under test: {@link FulfillmentGroupFeeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl.setAmount(null);
    fulfillmentGroupFeeImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl.setName("Name");
    fulfillmentGroupFeeImpl.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl.setTaxable(true);
    fulfillmentGroupFeeImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl.setTotalTax(new Money());

    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl2 = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl2.setAmount(new Money());
    fulfillmentGroupFeeImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl2.setName("Name");
    fulfillmentGroupFeeImpl2.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl2.setTaxable(true);
    fulfillmentGroupFeeImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl2.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupFeeImpl, fulfillmentGroupFeeImpl2);
  }

  /**
   * Method under test: {@link FulfillmentGroupFeeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl.setAmount(new Money(10.0d));
    fulfillmentGroupFeeImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl.setName("Name");
    fulfillmentGroupFeeImpl.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl.setTaxable(true);
    fulfillmentGroupFeeImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl.setTotalTax(new Money());

    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl2 = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl2.setAmount(new Money());
    fulfillmentGroupFeeImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl2.setName("Name");
    fulfillmentGroupFeeImpl2.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl2.setTaxable(true);
    fulfillmentGroupFeeImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl2.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupFeeImpl, fulfillmentGroupFeeImpl2);
  }

  /**
   * Method under test: {@link FulfillmentGroupFeeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl.setAmount(mock(Money.class));
    fulfillmentGroupFeeImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl.setName("Name");
    fulfillmentGroupFeeImpl.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl.setTaxable(true);
    fulfillmentGroupFeeImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl.setTotalTax(new Money());

    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl2 = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl2.setAmount(new Money());
    fulfillmentGroupFeeImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl2.setName("Name");
    fulfillmentGroupFeeImpl2.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl2.setTaxable(true);
    fulfillmentGroupFeeImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl2.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupFeeImpl, fulfillmentGroupFeeImpl2);
  }

  /**
   * Method under test: {@link FulfillmentGroupFeeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl.setAmount(new Money());
    fulfillmentGroupFeeImpl.setFulfillmentGroup(null);
    fulfillmentGroupFeeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl.setName("Name");
    fulfillmentGroupFeeImpl.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl.setTaxable(true);
    fulfillmentGroupFeeImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl.setTotalTax(new Money());

    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl2 = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl2.setAmount(new Money());
    fulfillmentGroupFeeImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl2.setName("Name");
    fulfillmentGroupFeeImpl2.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl2.setTaxable(true);
    fulfillmentGroupFeeImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl2.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupFeeImpl, fulfillmentGroupFeeImpl2);
  }

  /**
   * Method under test: {@link FulfillmentGroupFeeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl.setAmount(new Money());
    fulfillmentGroupFeeImpl.setFulfillmentGroup(mock(FulfillmentGroupImpl.class));
    fulfillmentGroupFeeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl.setName("Name");
    fulfillmentGroupFeeImpl.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl.setTaxable(true);
    fulfillmentGroupFeeImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl.setTotalTax(new Money());

    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl2 = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl2.setAmount(new Money());
    fulfillmentGroupFeeImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl2.setName("Name");
    fulfillmentGroupFeeImpl2.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl2.setTaxable(true);
    fulfillmentGroupFeeImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl2.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupFeeImpl, fulfillmentGroupFeeImpl2);
  }

  /**
   * Method under test: {@link FulfillmentGroupFeeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl.setAmount(new Money());
    fulfillmentGroupFeeImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl.setId(2L);
    fulfillmentGroupFeeImpl.setName("Name");
    fulfillmentGroupFeeImpl.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl.setTaxable(true);
    fulfillmentGroupFeeImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl.setTotalTax(new Money());

    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl2 = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl2.setAmount(new Money());
    fulfillmentGroupFeeImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl2.setName("Name");
    fulfillmentGroupFeeImpl2.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl2.setTaxable(true);
    fulfillmentGroupFeeImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl2.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupFeeImpl, fulfillmentGroupFeeImpl2);
  }

  /**
   * Method under test: {@link FulfillmentGroupFeeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl.setAmount(new Money());
    fulfillmentGroupFeeImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl.setId(null);
    fulfillmentGroupFeeImpl.setName("Name");
    fulfillmentGroupFeeImpl.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl.setTaxable(true);
    fulfillmentGroupFeeImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl.setTotalTax(new Money());

    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl2 = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl2.setAmount(new Money());
    fulfillmentGroupFeeImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl2.setName("Name");
    fulfillmentGroupFeeImpl2.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl2.setTaxable(true);
    fulfillmentGroupFeeImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl2.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupFeeImpl, fulfillmentGroupFeeImpl2);
  }

  /**
   * Method under test: {@link FulfillmentGroupFeeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl.setAmount(new Money());
    fulfillmentGroupFeeImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl.setName("Reporting Code");
    fulfillmentGroupFeeImpl.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl.setTaxable(true);
    fulfillmentGroupFeeImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl.setTotalTax(new Money());

    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl2 = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl2.setAmount(new Money());
    fulfillmentGroupFeeImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl2.setName("Name");
    fulfillmentGroupFeeImpl2.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl2.setTaxable(true);
    fulfillmentGroupFeeImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl2.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupFeeImpl, fulfillmentGroupFeeImpl2);
  }

  /**
   * Method under test: {@link FulfillmentGroupFeeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl.setAmount(new Money());
    fulfillmentGroupFeeImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl.setName(null);
    fulfillmentGroupFeeImpl.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl.setTaxable(true);
    fulfillmentGroupFeeImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl.setTotalTax(new Money());

    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl2 = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl2.setAmount(new Money());
    fulfillmentGroupFeeImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl2.setName("Name");
    fulfillmentGroupFeeImpl2.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl2.setTaxable(true);
    fulfillmentGroupFeeImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl2.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupFeeImpl, fulfillmentGroupFeeImpl2);
  }

  /**
   * Method under test: {@link FulfillmentGroupFeeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl.setAmount(new Money());
    fulfillmentGroupFeeImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl.setName("Name");
    fulfillmentGroupFeeImpl.setReportingCode("Name");
    fulfillmentGroupFeeImpl.setTaxable(true);
    fulfillmentGroupFeeImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl.setTotalTax(new Money());

    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl2 = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl2.setAmount(new Money());
    fulfillmentGroupFeeImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl2.setName("Name");
    fulfillmentGroupFeeImpl2.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl2.setTaxable(true);
    fulfillmentGroupFeeImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl2.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupFeeImpl, fulfillmentGroupFeeImpl2);
  }

  /**
   * Method under test: {@link FulfillmentGroupFeeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl.setAmount(new Money());
    fulfillmentGroupFeeImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl.setName("Name");
    fulfillmentGroupFeeImpl.setReportingCode(null);
    fulfillmentGroupFeeImpl.setTaxable(true);
    fulfillmentGroupFeeImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl.setTotalTax(new Money());

    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl2 = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl2.setAmount(new Money());
    fulfillmentGroupFeeImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl2.setName("Name");
    fulfillmentGroupFeeImpl2.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl2.setTaxable(true);
    fulfillmentGroupFeeImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl2.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupFeeImpl, fulfillmentGroupFeeImpl2);
  }

  /**
   * Method under test: {@link FulfillmentGroupFeeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl.setAmount(new Money());
    fulfillmentGroupFeeImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl.setName("Name");
    fulfillmentGroupFeeImpl.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl.setTaxable(true);
    fulfillmentGroupFeeImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupFeeImpl, null);
  }

  /**
   * Method under test: {@link FulfillmentGroupFeeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl.setAmount(new Money());
    fulfillmentGroupFeeImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl.setName("Name");
    fulfillmentGroupFeeImpl.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl.setTaxable(true);
    fulfillmentGroupFeeImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupFeeImpl, "Different type to FulfillmentGroupFeeImpl");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link FulfillmentGroupFeeImpl}
   *   <li>{@link FulfillmentGroupFeeImpl#setFulfillmentGroup(FulfillmentGroup)}
   *   <li>{@link FulfillmentGroupFeeImpl#setId(Long)}
   *   <li>{@link FulfillmentGroupFeeImpl#setName(String)}
   *   <li>{@link FulfillmentGroupFeeImpl#setReportingCode(String)}
   *   <li>{@link FulfillmentGroupFeeImpl#setTaxable(Boolean)}
   *   <li>{@link FulfillmentGroupFeeImpl#setTaxes(List)}
   *   <li>{@link FulfillmentGroupFeeImpl#getFulfillmentGroup()}
   *   <li>{@link FulfillmentGroupFeeImpl#getId()}
   *   <li>{@link FulfillmentGroupFeeImpl#getName()}
   *   <li>{@link FulfillmentGroupFeeImpl#getReportingCode()}
   *   <li>{@link FulfillmentGroupFeeImpl#getTaxes()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    FulfillmentGroupFeeImpl actualFulfillmentGroupFeeImpl = new FulfillmentGroupFeeImpl();
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    actualFulfillmentGroupFeeImpl.setFulfillmentGroup(fulfillmentGroup);
    actualFulfillmentGroupFeeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    actualFulfillmentGroupFeeImpl.setName("Name");
    actualFulfillmentGroupFeeImpl.setReportingCode("Reporting Code");
    actualFulfillmentGroupFeeImpl.setTaxable(true);
    ArrayList<TaxDetail> taxes = new ArrayList<>();
    actualFulfillmentGroupFeeImpl.setTaxes(taxes);
    FulfillmentGroup actualFulfillmentGroup = actualFulfillmentGroupFeeImpl.getFulfillmentGroup();
    Long actualId = actualFulfillmentGroupFeeImpl.getId();
    String actualName = actualFulfillmentGroupFeeImpl.getName();
    String actualReportingCode = actualFulfillmentGroupFeeImpl.getReportingCode();
    List<TaxDetail> actualTaxes = actualFulfillmentGroupFeeImpl.getTaxes();

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertEquals("Reporting Code", actualReportingCode);
    assertTrue(actualTaxes.isEmpty());
    assertEquals(OrderItemQualifierImpl.serialVersionUID, actualId.longValue());
    assertSame(taxes, actualTaxes);
    assertSame(fulfillmentGroup, actualFulfillmentGroup);
  }
}

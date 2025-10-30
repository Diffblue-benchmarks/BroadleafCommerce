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
public class FulfillmentGroupFeeImplDiffblueTest {
  @Autowired
  private FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl;

  /**
   * Test {@link FulfillmentGroupFeeImpl#getAmount()}.
   * <ul>
   *   <li>Given {@link FulfillmentGroupFeeImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupFeeImpl#getAmount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupFeeImpl.getAmount()"})
  public void testGetAmount_givenFulfillmentGroupFeeImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FulfillmentGroupFeeImpl()).getAmount());
  }

  /**
   * Test {@link FulfillmentGroupFeeImpl#getAmount()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupFeeImpl#getAmount()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupFeeImpl.getAmount()"})
  public void testGetAmount_givenOrderImplCurrencyIsNull_thenReturnMoney() {
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

    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl2 = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl2.setName("Name");
    fulfillmentGroupFeeImpl2.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl2.setTaxable(true);
    fulfillmentGroupFeeImpl2.setTaxes(new ArrayList<>());
    Money totalTax = new Money();
    fulfillmentGroupFeeImpl2.setTotalTax(totalTax);
    fulfillmentGroupFeeImpl2.setAmount(new Money());
    fulfillmentGroupFeeImpl2.setFulfillmentGroup(fulfillmentGroup);

    // Act and Assert
    assertEquals(totalTax, fulfillmentGroupFeeImpl2.getAmount());
  }

  /**
   * Test {@link FulfillmentGroupFeeImpl#setAmount(Money)}.
   * <ul>
   *   <li>When {@link Money#Money()}.</li>
   *   <li>Then {@link FulfillmentGroupFeeImpl} (default constructor) {@link FulfillmentGroupFeeImpl#amount} is {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupFeeImpl#setAmount(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupFeeImpl.setAmount(Money)"})
  public void testSetAmount_whenMoney_thenFulfillmentGroupFeeImplAmountIsBigDecimalWith000() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl2 = new FulfillmentGroupFeeImpl();
    Money amount = new Money();

    // Act
    fulfillmentGroupFeeImpl2.setAmount(amount);

    // Assert
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupFeeImpl2.amount);
    BigDecimal bigDecimal = fulfillmentGroupFeeImpl2.amount;
    Money absResult = amount.abs();
    assertSame(bigDecimal, absResult.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.getAmount());
    assertSame(bigDecimal, absResult2.abs().getAmount());
    Money zeroResult = amount.zero();
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
   * Test {@link FulfillmentGroupFeeImpl#setAmount(Money)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link FulfillmentGroupFeeImpl} (default constructor) {@link FulfillmentGroupFeeImpl#amount} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupFeeImpl#setAmount(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupFeeImpl.setAmount(Money)"})
  public void testSetAmount_whenNull_thenFulfillmentGroupFeeImplAmountIsNull() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl2 = new FulfillmentGroupFeeImpl();

    // Act
    fulfillmentGroupFeeImpl2.setAmount(null);

    // Assert that nothing has changed
    assertNull(fulfillmentGroupFeeImpl2.amount);
  }

  /**
   * Test {@link FulfillmentGroupFeeImpl#isTaxable()}.
   * <ul>
   *   <li>Given {@link FulfillmentGroupFeeImpl} (default constructor) Amount is {@link Money#Money()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupFeeImpl#isTaxable()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean FulfillmentGroupFeeImpl.isTaxable()"})
  public void testIsTaxable_givenFulfillmentGroupFeeImplAmountIsMoney_thenReturnTrue() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl2 = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl2.setAmount(new Money());
    fulfillmentGroupFeeImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl2.setName("Name");
    fulfillmentGroupFeeImpl2.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl2.setTotalTax(new Money());
    fulfillmentGroupFeeImpl2.setTaxable(null);

    // Act and Assert
    assertTrue(fulfillmentGroupFeeImpl2.isTaxable());
  }

  /**
   * Test {@link FulfillmentGroupFeeImpl#isTaxable()}.
   * <ul>
   *   <li>Given {@link FulfillmentGroupFeeImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupFeeImpl#isTaxable()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean FulfillmentGroupFeeImpl.isTaxable()"})
  public void testIsTaxable_givenFulfillmentGroupFeeImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new FulfillmentGroupFeeImpl()).isTaxable());
  }

  /**
   * Test {@link FulfillmentGroupFeeImpl#getTotalTax()}.
   * <ul>
   *   <li>Given {@link FulfillmentGroupFeeImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupFeeImpl#getTotalTax()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupFeeImpl.getTotalTax()"})
  public void testGetTotalTax_givenFulfillmentGroupFeeImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FulfillmentGroupFeeImpl()).getTotalTax());
  }

  /**
   * Test {@link FulfillmentGroupFeeImpl#getTotalTax()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupFeeImpl#getTotalTax()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money FulfillmentGroupFeeImpl.getTotalTax()"})
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

    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl2 = new FulfillmentGroupFeeImpl();
    Money amount = new Money();
    fulfillmentGroupFeeImpl2.setAmount(amount);
    fulfillmentGroupFeeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl2.setName("Name");
    fulfillmentGroupFeeImpl2.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl2.setTaxable(true);
    fulfillmentGroupFeeImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl2.setTotalTax(new Money());
    fulfillmentGroupFeeImpl2.setFulfillmentGroup(fulfillmentGroup);

    // Act and Assert
    assertEquals(amount, fulfillmentGroupFeeImpl2.getTotalTax());
  }

  /**
   * Test {@link FulfillmentGroupFeeImpl#setTotalTax(Money)}.
   * <ul>
   *   <li>Then {@link FulfillmentGroupFeeImpl} (default constructor) {@link FulfillmentGroupFeeImpl#totalTax} is {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupFeeImpl#setTotalTax(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupFeeImpl.setTotalTax(Money)"})
  public void testSetTotalTax_thenFulfillmentGroupFeeImplTotalTaxIsBigDecimalWith000() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl2 = new FulfillmentGroupFeeImpl();
    Money totalTax = new Money();

    // Act
    fulfillmentGroupFeeImpl2.setTotalTax(totalTax);

    // Assert
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupFeeImpl2.totalTax);
    BigDecimal bigDecimal = fulfillmentGroupFeeImpl2.totalTax;
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
   * Test {@link FulfillmentGroupFeeImpl#setTotalTax(Money)}.
   * <ul>
   *   <li>Then {@link FulfillmentGroupFeeImpl} (default constructor) {@link FulfillmentGroupFeeImpl#totalTax} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupFeeImpl#setTotalTax(Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupFeeImpl.setTotalTax(Money)"})
  public void testSetTotalTax_thenFulfillmentGroupFeeImplTotalTaxIsNull() {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl2 = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl2.setAmount(new Money());
    fulfillmentGroupFeeImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupFeeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupFeeImpl2.setName("Name");
    fulfillmentGroupFeeImpl2.setReportingCode("Reporting Code");
    fulfillmentGroupFeeImpl2.setTaxable(true);
    fulfillmentGroupFeeImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupFeeImpl2.setTotalTax(new Money());

    // Act
    fulfillmentGroupFeeImpl2.setTotalTax(null);

    // Assert
    assertNull(fulfillmentGroupFeeImpl2.totalTax);
    assertNull(fulfillmentGroupFeeImpl2.getTotalTax());
  }

  /**
   * Test {@link FulfillmentGroupFeeImpl#getCurrencyCode()}.
   * <ul>
   *   <li>Then return {@code GBP}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupFeeImpl#getCurrencyCode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FulfillmentGroupFeeImpl.getCurrencyCode()"})
  public void testGetCurrencyCode_thenReturnGbp() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getCurrencyCode()).thenReturn("GBP");

    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl2 = new FulfillmentGroupFeeImpl();
    fulfillmentGroupFeeImpl2.setFulfillmentGroup(fulfillmentGroup);

    // Act
    String actualCurrencyCode = fulfillmentGroupFeeImpl2.getCurrencyCode();

    // Assert
    verify(fulfillmentGroup).getCurrencyCode();
    assertEquals("GBP", actualCurrencyCode);
  }

  /**
   * Test {@link FulfillmentGroupFeeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test: {@link FulfillmentGroupFeeImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse FulfillmentGroupFeeImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    FulfillmentGroupFeeImpl fulfillmentGroupFeeImpl2 = new FulfillmentGroupFeeImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<FulfillmentGroupFee> actualCreateOrRetrieveCopyInstanceResult = fulfillmentGroupFeeImpl2
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link FulfillmentGroupFeeImpl#equals(Object)}, and {@link FulfillmentGroupFeeImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentGroupFeeImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupFeeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentGroupFeeImpl.equals(Object)", "int FulfillmentGroupFeeImpl.hashCode()"})
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
   * Test {@link FulfillmentGroupFeeImpl#equals(Object)}, and {@link FulfillmentGroupFeeImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentGroupFeeImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupFeeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentGroupFeeImpl.equals(Object)", "int FulfillmentGroupFeeImpl.hashCode()"})
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
   * Test {@link FulfillmentGroupFeeImpl#equals(Object)}, and {@link FulfillmentGroupFeeImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentGroupFeeImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupFeeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentGroupFeeImpl.equals(Object)", "int FulfillmentGroupFeeImpl.hashCode()"})
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
   * Test {@link FulfillmentGroupFeeImpl#equals(Object)}, and {@link FulfillmentGroupFeeImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentGroupFeeImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupFeeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentGroupFeeImpl.equals(Object)", "int FulfillmentGroupFeeImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
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
    fulfillmentGroupFeeImpl2.setId(null);
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
   * Test {@link FulfillmentGroupFeeImpl#equals(Object)}, and {@link FulfillmentGroupFeeImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentGroupFeeImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupFeeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentGroupFeeImpl.equals(Object)", "int FulfillmentGroupFeeImpl.hashCode()"})
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
   * Test {@link FulfillmentGroupFeeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupFeeImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentGroupFeeImpl.equals(Object)", "int FulfillmentGroupFeeImpl.hashCode()"})
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
   * Test {@link FulfillmentGroupFeeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupFeeImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentGroupFeeImpl.equals(Object)", "int FulfillmentGroupFeeImpl.hashCode()"})
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
   * Test {@link FulfillmentGroupFeeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupFeeImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentGroupFeeImpl.equals(Object)", "int FulfillmentGroupFeeImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
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
   * Test {@link FulfillmentGroupFeeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupFeeImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentGroupFeeImpl.equals(Object)", "int FulfillmentGroupFeeImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
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
   * Test {@link FulfillmentGroupFeeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupFeeImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentGroupFeeImpl.equals(Object)", "int FulfillmentGroupFeeImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
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
   * Test {@link FulfillmentGroupFeeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupFeeImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentGroupFeeImpl.equals(Object)", "int FulfillmentGroupFeeImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
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
   * Test {@link FulfillmentGroupFeeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupFeeImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentGroupFeeImpl.equals(Object)", "int FulfillmentGroupFeeImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
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
   * Test {@link FulfillmentGroupFeeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupFeeImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentGroupFeeImpl.equals(Object)", "int FulfillmentGroupFeeImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
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
   * Test {@link FulfillmentGroupFeeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupFeeImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentGroupFeeImpl.equals(Object)", "int FulfillmentGroupFeeImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
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
   * Test {@link FulfillmentGroupFeeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupFeeImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentGroupFeeImpl.equals(Object)", "int FulfillmentGroupFeeImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
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
   * Test {@link FulfillmentGroupFeeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupFeeImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentGroupFeeImpl.equals(Object)", "int FulfillmentGroupFeeImpl.hashCode()"})
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
   * Test {@link FulfillmentGroupFeeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentGroupFeeImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FulfillmentGroupFeeImpl.equals(Object)", "int FulfillmentGroupFeeImpl.hashCode()"})
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
   * Test getters and setters.
   * <p>
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FulfillmentGroupFeeImpl.<init>()",
      "FulfillmentGroup FulfillmentGroupFeeImpl.getFulfillmentGroup()", "Long FulfillmentGroupFeeImpl.getId()",
      "String FulfillmentGroupFeeImpl.getName()", "String FulfillmentGroupFeeImpl.getReportingCode()",
      "List FulfillmentGroupFeeImpl.getTaxes()", "void FulfillmentGroupFeeImpl.setFulfillmentGroup(FulfillmentGroup)",
      "void FulfillmentGroupFeeImpl.setId(Long)", "void FulfillmentGroupFeeImpl.setName(String)",
      "void FulfillmentGroupFeeImpl.setReportingCode(String)", "void FulfillmentGroupFeeImpl.setTaxable(Boolean)",
      "void FulfillmentGroupFeeImpl.setTaxes(List)"})
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

    // Assert
    assertEquals("Name", actualName);
    assertEquals("Reporting Code", actualReportingCode);
    assertTrue(actualTaxes.isEmpty());
    assertEquals(OrderItemQualifierImpl.serialVersionUID, actualId.longValue());
    assertSame(taxes, actualTaxes);
    assertSame(fulfillmentGroup, actualFulfillmentGroup);
  }
}

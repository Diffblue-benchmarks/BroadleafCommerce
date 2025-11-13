package org.broadleafcommerce.core.offer.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
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
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.service.type.OfferAdjustmentType;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentOptionImpl;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.type.FulfillmentGroupStatusType;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class FulfillmentGroupAdjustmentImplDiffblueTest {
  @Autowired private FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl;

  /**
   * Test {@link FulfillmentGroupAdjustmentImpl#init(FulfillmentGroup, Offer, String)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Offer} {@link Offer#getAdjustmentType()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupAdjustmentImpl#init(FulfillmentGroup, Offer,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupAdjustmentImpl.init(FulfillmentGroup, Offer, String)"})
  public void testInit_givenNull_whenOfferGetAdjustmentTypeReturnNull() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    Offer offer = mock(Offer.class);
    when(offer.getAdjustmentType()).thenReturn(null);

    // Act
    fulfillmentGroupAdjustmentImpl.init(fulfillmentGroup, offer, "Just cause");

    // Assert
    verify(offer).getAdjustmentType();
    assertSame(offer, fulfillmentGroupAdjustmentImpl.getOffer());
    assertSame(offer, fulfillmentGroupAdjustmentImpl.deproxiedOffer);
  }

  /**
   * Test {@link FulfillmentGroupAdjustmentImpl#init(FulfillmentGroup, Offer, String)}.
   *
   * <ul>
   *   <li>Given {@link OfferAdjustmentType#OfferAdjustmentType()}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupAdjustmentImpl#init(FulfillmentGroup, Offer,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupAdjustmentImpl.init(FulfillmentGroup, Offer, String)"})
  public void testInit_givenOfferAdjustmentType() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    Offer offer = mock(Offer.class);
    when(offer.getAdjustmentType()).thenReturn(new OfferAdjustmentType());

    // Act
    fulfillmentGroupAdjustmentImpl.init(fulfillmentGroup, offer, "Just cause");

    // Assert
    verify(offer).getAdjustmentType();
    assertSame(offer, fulfillmentGroupAdjustmentImpl.getOffer());
    assertSame(offer, fulfillmentGroupAdjustmentImpl.deproxiedOffer);
  }

  /**
   * Test {@link FulfillmentGroupAdjustmentImpl#init(FulfillmentGroup, Offer, String)}.
   *
   * <ul>
   *   <li>Given {@link OfferAdjustmentType#ORDER_DISCOUNT} Type is {@code Adjustment Type}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupAdjustmentImpl#init(FulfillmentGroup, Offer,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupAdjustmentImpl.init(FulfillmentGroup, Offer, String)"})
  public void testInit_givenOrder_discountTypeIsAdjustmentType() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    OfferAdjustmentType offerAdjustmentType = OfferAdjustmentType.ORDER_DISCOUNT;
    offerAdjustmentType.setType("Adjustment Type");

    Offer offer = mock(Offer.class);
    when(offer.getAdjustmentType()).thenReturn(offerAdjustmentType);

    // Act
    fulfillmentGroupAdjustmentImpl.init(fulfillmentGroup, offer, "Just cause");

    // Assert
    verify(offer).getAdjustmentType();
    assertSame(offer, fulfillmentGroupAdjustmentImpl.getOffer());
    assertSame(offer, fulfillmentGroupAdjustmentImpl.deproxiedOffer);
  }

  /**
   * Test {@link FulfillmentGroupAdjustmentImpl#init(FulfillmentGroup, Offer, String)}.
   *
   * <ul>
   *   <li>Given {@link OfferAdjustmentType#ORDER_DISCOUNT}.
   *   <li>When {@link Offer} {@link Offer#getAdjustmentType()} return {@link
   *       OfferAdjustmentType#ORDER_DISCOUNT}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupAdjustmentImpl#init(FulfillmentGroup, Offer,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupAdjustmentImpl.init(FulfillmentGroup, Offer, String)"})
  public void testInit_givenOrder_discount_whenOfferGetAdjustmentTypeReturnOrder_discount() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    Offer offer = mock(Offer.class);
    when(offer.getAdjustmentType()).thenReturn(OfferAdjustmentType.ORDER_DISCOUNT);

    // Act
    fulfillmentGroupAdjustmentImpl.init(fulfillmentGroup, offer, "Just cause");

    // Assert
    verify(offer).getAdjustmentType();
    assertSame(offer, fulfillmentGroupAdjustmentImpl.getOffer());
    assertSame(offer, fulfillmentGroupAdjustmentImpl.deproxiedOffer);
  }

  /**
   * Test {@link FulfillmentGroupAdjustmentImpl#init(FulfillmentGroup, Offer, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link FulfillmentGroupAdjustmentImpl} Reason is {@code Just cause}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupAdjustmentImpl#init(FulfillmentGroup, Offer,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupAdjustmentImpl.init(FulfillmentGroup, Offer, String)"})
  public void testInit_whenNull_thenFulfillmentGroupAdjustmentImplReasonIsJustCause() {
    // Arrange and Act
    fulfillmentGroupAdjustmentImpl.init(new FulfillmentGroupImpl(), null, "Just cause");

    // Assert
    assertEquals("Just cause", fulfillmentGroupAdjustmentImpl.getReason());
    assertNull(fulfillmentGroupAdjustmentImpl.getOffer());
    assertNull(fulfillmentGroupAdjustmentImpl.deproxiedOffer);
    assertNull(fulfillmentGroupAdjustmentImpl.offer);
    assertFalse(fulfillmentGroupAdjustmentImpl.isFutureCredit());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentGroupAdjustmentImpl#setFulfillmentGroup(FulfillmentGroup)}
   *   <li>{@link FulfillmentGroupAdjustmentImpl#setFutureCredit(Boolean)}
   *   <li>{@link FulfillmentGroupAdjustmentImpl#setId(Long)}
   *   <li>{@link FulfillmentGroupAdjustmentImpl#setReason(String)}
   *   <li>{@link FulfillmentGroupAdjustmentImpl#getFulfillmentGroup()}
   *   <li>{@link FulfillmentGroupAdjustmentImpl#getId()}
   *   <li>{@link FulfillmentGroupAdjustmentImpl#getReason()}
   *   <li>{@link FulfillmentGroupAdjustmentImpl#isFutureCredit()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentGroup FulfillmentGroupAdjustmentImpl.getFulfillmentGroup()",
    "Long FulfillmentGroupAdjustmentImpl.getId()",
    "String FulfillmentGroupAdjustmentImpl.getReason()",
    "Boolean FulfillmentGroupAdjustmentImpl.isFutureCredit()",
    "void FulfillmentGroupAdjustmentImpl.setFulfillmentGroup(FulfillmentGroup)",
    "void FulfillmentGroupAdjustmentImpl.setFutureCredit(Boolean)",
    "void FulfillmentGroupAdjustmentImpl.setId(Long)",
    "void FulfillmentGroupAdjustmentImpl.setReason(String)"
  })
  public void testGettersAndSetters() {
    // Arrange
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl =
        new FulfillmentGroupAdjustmentImpl();
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    // Act
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(fulfillmentGroup);
    fulfillmentGroupAdjustmentImpl.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    fulfillmentGroupAdjustmentImpl.setReason("Just cause");
    FulfillmentGroup actualFulfillmentGroup = fulfillmentGroupAdjustmentImpl.getFulfillmentGroup();
    Long actualId = fulfillmentGroupAdjustmentImpl.getId();
    String actualReason = fulfillmentGroupAdjustmentImpl.getReason();

    // Assert
    assertEquals("Just cause", actualReason);
    assertTrue(fulfillmentGroupAdjustmentImpl.isFutureCredit());
    assertEquals(FulfillmentGroupAdjustmentImpl.serialVersionUID, actualId.longValue());
    assertSame(fulfillmentGroup, actualFulfillmentGroup);
  }

  /**
   * Test {@link FulfillmentGroupAdjustmentImpl#getOffer()}.
   *
   * <p>Method under test: {@link FulfillmentGroupAdjustmentImpl#getOffer()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Offer FulfillmentGroupAdjustmentImpl.getOffer()"})
  public void testGetOffer() {
    // Arrange, Act and Assert
    assertNull(fulfillmentGroupAdjustmentImpl.getOffer());
  }

  /**
   * Test {@link FulfillmentGroupAdjustmentImpl#getValue()}.
   *
   * <ul>
   *   <li>Given {@link Money} {@link Money#getAmount()} return {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupAdjustmentImpl#getValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupAdjustmentImpl.getValue()"})
  public void testGetValue_givenMoneyGetAmountReturnNull_thenReturnNull() {
    // Arrange
    Money value = mock(Money.class);
    when(value.getAmount()).thenReturn(null);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(FulfillmentGroupAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
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
    order.setCurrency(new BroadleafCurrencyImpl());

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setAddress(new AddressImpl());
    fulfillmentGroup.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroup.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroup.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroup.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroup.setFulfillmentPrice(new Money());
    fulfillmentGroup.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    fulfillmentGroup.setIsShippingPriceTaxable(true);
    fulfillmentGroup.setMerchandiseTotal(new Money());
    fulfillmentGroup.setMethod("Fulfillment Method");
    fulfillmentGroup.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroup.setPhone(new PhoneImpl());
    fulfillmentGroup.setPrimary(true);
    fulfillmentGroup.setReferenceNumber("42");
    fulfillmentGroup.setRetailFulfillmentPrice(new Money());
    fulfillmentGroup.setSaleFulfillmentPrice(new Money());
    fulfillmentGroup.setSequence(1);
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
    fulfillmentGroup.setOrder(order);
    fulfillmentGroupAdjustmentImpl.setValue(value);
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(fulfillmentGroup);

    // Act
    Money actualValue = fulfillmentGroupAdjustmentImpl.getValue();

    // Assert
    verify(value).getAmount();
    assertNull(actualValue);
  }

  /**
   * Test {@link FulfillmentGroupAdjustmentImpl#getValue()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupAdjustmentImpl#getValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupAdjustmentImpl.getValue()"})
  public void testGetValue_givenOrderImplCurrencyIsNull_thenReturnMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(FulfillmentGroupAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
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
    fulfillmentGroup.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    fulfillmentGroup.setIsShippingPriceTaxable(true);
    fulfillmentGroup.setMerchandiseTotal(new Money());
    fulfillmentGroup.setMethod("Fulfillment Method");
    fulfillmentGroup.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroup.setPhone(new PhoneImpl());
    fulfillmentGroup.setPrimary(true);
    fulfillmentGroup.setReferenceNumber("42");
    fulfillmentGroup.setRetailFulfillmentPrice(new Money());
    fulfillmentGroup.setSaleFulfillmentPrice(new Money());
    fulfillmentGroup.setSequence(1);
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
    fulfillmentGroup.setOrder(order);
    Money value = new Money();
    fulfillmentGroupAdjustmentImpl.setValue(value);
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(fulfillmentGroup);

    // Act and Assert
    assertEquals(value, fulfillmentGroupAdjustmentImpl.getValue());
  }

  /**
   * Test {@link FulfillmentGroupAdjustmentImpl#getValue()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound Sterling}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupAdjustmentImpl#getValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money FulfillmentGroupAdjustmentImpl.getValue()"})
  public void testGetValue_thenReturnCurrencyDisplayNameIsBritishPoundSterling() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(FulfillmentGroupAdjustmentImpl.serialVersionUID);

    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
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
    order.setCurrency(currency);

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setAddress(new AddressImpl());
    fulfillmentGroup.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroup.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroup.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroup.setFulfillmentGroupItems(new ArrayList<>());
    fulfillmentGroup.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroup.setFulfillmentPrice(new Money());
    fulfillmentGroup.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    fulfillmentGroup.setIsShippingPriceTaxable(true);
    fulfillmentGroup.setMerchandiseTotal(new Money());
    fulfillmentGroup.setMethod("Fulfillment Method");
    fulfillmentGroup.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroup.setPhone(new PhoneImpl());
    fulfillmentGroup.setPrimary(true);
    fulfillmentGroup.setReferenceNumber("42");
    fulfillmentGroup.setRetailFulfillmentPrice(new Money());
    fulfillmentGroup.setSaleFulfillmentPrice(new Money());
    fulfillmentGroup.setSequence(1);
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
    fulfillmentGroup.setOrder(order);
    fulfillmentGroupAdjustmentImpl.setValue(new Money());
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(fulfillmentGroup);

    // Act
    Money actualValue = fulfillmentGroupAdjustmentImpl.getValue();

    // Assert
    verify(currency).getCurrencyCode();
    Currency currency2 = actualValue.getCurrency();
    assertEquals("British Pound Sterling", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.getSymbol());
    assertEquals("GBP", currency2.toString());
    assertEquals(826, currency2.getNumericCode());
    Money actualAbsResult = actualValue.abs();
    assertEquals(actualValue, actualAbsResult);
    Money actualZeroResult = actualValue.zero();
    assertEquals(actualValue, actualZeroResult);
  }

  /**
   * Test {@link FulfillmentGroupAdjustmentImpl#setValue(Money)}.
   *
   * <ul>
   *   <li>Then {@link FulfillmentGroupAdjustmentImpl} {@link FulfillmentGroupAdjustmentImpl#value}
   *       is {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupAdjustmentImpl#setValue(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupAdjustmentImpl.setValue(Money)"})
  public void testSetValue_thenFulfillmentGroupAdjustmentImplValueIsBigDecimalWith000() {
    // Arrange and Act
    fulfillmentGroupAdjustmentImpl.setValue(new Money());

    // Assert that nothing has changed
    assertEquals(new BigDecimal("0.00"), fulfillmentGroupAdjustmentImpl.value);
  }

  /**
   * Test {@link FulfillmentGroupAdjustmentImpl#setValue(Money)}.
   *
   * <ul>
   *   <li>Then {@link FulfillmentGroupAdjustmentImpl} {@link FulfillmentGroupAdjustmentImpl#value}
   *       is {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupAdjustmentImpl#setValue(Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupAdjustmentImpl.setValue(Money)"})
  public void testSetValue_thenFulfillmentGroupAdjustmentImplValueIsBigDecimalWith23() {
    // Arrange
    Money value = mock(Money.class);
    when(value.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    fulfillmentGroupAdjustmentImpl.setValue(value);

    // Assert
    verify(value).getAmount();
    assertEquals(new BigDecimal("2.3"), fulfillmentGroupAdjustmentImpl.value);
  }

  /**
   * Test {@link FulfillmentGroupAdjustmentImpl#getCurrencyCode()}.
   *
   * <ul>
   *   <li>Then return {@code GBP}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupAdjustmentImpl#getCurrencyCode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String FulfillmentGroupAdjustmentImpl.getCurrencyCode()"})
  public void testGetCurrencyCode_thenReturnGbp() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroup.getCurrencyCode()).thenReturn("GBP");

    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl =
        new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(fulfillmentGroup);

    // Act
    String actualCurrencyCode = fulfillmentGroupAdjustmentImpl.getCurrencyCode();

    // Assert
    verify(fulfillmentGroup).getCurrencyCode();
    assertEquals("GBP", actualCurrencyCode);
  }

  /**
   * Test {@link FulfillmentGroupAdjustmentImpl#equals(Object)}, and {@link
   * FulfillmentGroupAdjustmentImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentGroupAdjustmentImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupAdjustmentImpl.equals(Object)",
    "int FulfillmentGroupAdjustmentImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl =
        new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    fulfillmentGroupAdjustmentImpl.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl.setValue(new Money());

    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl2 =
        new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl2.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl2.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    fulfillmentGroupAdjustmentImpl2.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertEquals(fulfillmentGroupAdjustmentImpl, fulfillmentGroupAdjustmentImpl2);
    assertEquals(
        fulfillmentGroupAdjustmentImpl.hashCode(), fulfillmentGroupAdjustmentImpl2.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupAdjustmentImpl#equals(Object)}, and {@link
   * FulfillmentGroupAdjustmentImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentGroupAdjustmentImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupAdjustmentImpl.equals(Object)",
    "int FulfillmentGroupAdjustmentImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl =
        new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl.setId(null);
    fulfillmentGroupAdjustmentImpl.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl.setValue(new Money());

    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl2 =
        new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl2.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl2.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    fulfillmentGroupAdjustmentImpl2.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertEquals(fulfillmentGroupAdjustmentImpl, fulfillmentGroupAdjustmentImpl2);
    assertEquals(
        fulfillmentGroupAdjustmentImpl.hashCode(), fulfillmentGroupAdjustmentImpl2.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupAdjustmentImpl#equals(Object)}, and {@link
   * FulfillmentGroupAdjustmentImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentGroupAdjustmentImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupAdjustmentImpl.equals(Object)",
    "int FulfillmentGroupAdjustmentImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl =
        new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    fulfillmentGroupAdjustmentImpl.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl.setValue(new Money());

    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl2 =
        new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl2.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl2.setId(null);
    fulfillmentGroupAdjustmentImpl2.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertEquals(fulfillmentGroupAdjustmentImpl, fulfillmentGroupAdjustmentImpl2);
    assertEquals(
        fulfillmentGroupAdjustmentImpl.hashCode(), fulfillmentGroupAdjustmentImpl2.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupAdjustmentImpl#equals(Object)}, and {@link
   * FulfillmentGroupAdjustmentImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentGroupAdjustmentImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupAdjustmentImpl.equals(Object)",
    "int FulfillmentGroupAdjustmentImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl =
        new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(null);
    fulfillmentGroupAdjustmentImpl.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl.setId(null);
    fulfillmentGroupAdjustmentImpl.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl.setValue(new Money());

    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl2 =
        new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl2.setFulfillmentGroup(null);
    fulfillmentGroupAdjustmentImpl2.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl2.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    fulfillmentGroupAdjustmentImpl2.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertEquals(fulfillmentGroupAdjustmentImpl, fulfillmentGroupAdjustmentImpl2);
    assertEquals(
        fulfillmentGroupAdjustmentImpl.hashCode(), fulfillmentGroupAdjustmentImpl2.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupAdjustmentImpl#equals(Object)}, and {@link
   * FulfillmentGroupAdjustmentImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentGroupAdjustmentImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupAdjustmentImpl.equals(Object)",
    "int FulfillmentGroupAdjustmentImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl =
        new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl.setId(null);
    fulfillmentGroupAdjustmentImpl.setReason(null);
    fulfillmentGroupAdjustmentImpl.setValue(new Money());

    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl2 =
        new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl2.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl2.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    fulfillmentGroupAdjustmentImpl2.setReason(null);
    fulfillmentGroupAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertEquals(fulfillmentGroupAdjustmentImpl, fulfillmentGroupAdjustmentImpl2);
    assertEquals(
        fulfillmentGroupAdjustmentImpl.hashCode(), fulfillmentGroupAdjustmentImpl2.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupAdjustmentImpl#equals(Object)}, and {@link
   * FulfillmentGroupAdjustmentImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentGroupAdjustmentImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupAdjustmentImpl.equals(Object)",
    "int FulfillmentGroupAdjustmentImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    Money value = mock(Money.class);
    when(value.getAmount()).thenReturn(null);

    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl =
        new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl.setId(null);
    fulfillmentGroupAdjustmentImpl.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl.setValue(value);

    Money value2 = mock(Money.class);
    when(value2.getAmount()).thenReturn(null);

    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl2 =
        new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl2.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl2.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    fulfillmentGroupAdjustmentImpl2.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl2.setValue(value2);

    // Act and Assert
    assertEquals(fulfillmentGroupAdjustmentImpl, fulfillmentGroupAdjustmentImpl2);
    assertEquals(
        fulfillmentGroupAdjustmentImpl.hashCode(), fulfillmentGroupAdjustmentImpl2.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupAdjustmentImpl#equals(Object)}, and {@link
   * FulfillmentGroupAdjustmentImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentGroupAdjustmentImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupAdjustmentImpl.equals(Object)",
    "int FulfillmentGroupAdjustmentImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl =
        new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    fulfillmentGroupAdjustmentImpl.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl.setValue(new Money());

    // Act and Assert
    assertEquals(fulfillmentGroupAdjustmentImpl, fulfillmentGroupAdjustmentImpl);
    int expectedHashCodeResult = fulfillmentGroupAdjustmentImpl.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentGroupAdjustmentImpl.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupAdjustmentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupAdjustmentImpl.equals(Object)",
    "int FulfillmentGroupAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl =
        new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl.setId(2L);
    fulfillmentGroupAdjustmentImpl.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl.setValue(new Money());

    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl2 =
        new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl2.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl2.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    fulfillmentGroupAdjustmentImpl2.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupAdjustmentImpl, fulfillmentGroupAdjustmentImpl2);
  }

  /**
   * Test {@link FulfillmentGroupAdjustmentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupAdjustmentImpl.equals(Object)",
    "int FulfillmentGroupAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl =
        new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(null);
    fulfillmentGroupAdjustmentImpl.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl.setId(null);
    fulfillmentGroupAdjustmentImpl.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl.setValue(new Money());

    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl2 =
        new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl2.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl2.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    fulfillmentGroupAdjustmentImpl2.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupAdjustmentImpl, fulfillmentGroupAdjustmentImpl2);
  }

  /**
   * Test {@link FulfillmentGroupAdjustmentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupAdjustmentImpl.equals(Object)",
    "int FulfillmentGroupAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl =
        new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(mock(FulfillmentGroupImpl.class));
    fulfillmentGroupAdjustmentImpl.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl.setId(null);
    fulfillmentGroupAdjustmentImpl.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl.setValue(new Money());

    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl2 =
        new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl2.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl2.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    fulfillmentGroupAdjustmentImpl2.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupAdjustmentImpl, fulfillmentGroupAdjustmentImpl2);
  }

  /**
   * Test {@link FulfillmentGroupAdjustmentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupAdjustmentImpl.equals(Object)",
    "int FulfillmentGroupAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl =
        new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl.setFutureCredit(false);
    fulfillmentGroupAdjustmentImpl.setId(null);
    fulfillmentGroupAdjustmentImpl.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl.setValue(new Money());

    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl2 =
        new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl2.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl2.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    fulfillmentGroupAdjustmentImpl2.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupAdjustmentImpl, fulfillmentGroupAdjustmentImpl2);
  }

  /**
   * Test {@link FulfillmentGroupAdjustmentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupAdjustmentImpl.equals(Object)",
    "int FulfillmentGroupAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl =
        new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl.setId(null);
    fulfillmentGroupAdjustmentImpl.setReason("Reason");
    fulfillmentGroupAdjustmentImpl.setValue(new Money());

    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl2 =
        new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl2.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl2.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    fulfillmentGroupAdjustmentImpl2.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupAdjustmentImpl, fulfillmentGroupAdjustmentImpl2);
  }

  /**
   * Test {@link FulfillmentGroupAdjustmentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupAdjustmentImpl.equals(Object)",
    "int FulfillmentGroupAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl =
        new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl.setId(null);
    fulfillmentGroupAdjustmentImpl.setReason(null);
    fulfillmentGroupAdjustmentImpl.setValue(new Money());

    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl2 =
        new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl2.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl2.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    fulfillmentGroupAdjustmentImpl2.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupAdjustmentImpl, fulfillmentGroupAdjustmentImpl2);
  }

  /**
   * Test {@link FulfillmentGroupAdjustmentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupAdjustmentImpl.equals(Object)",
    "int FulfillmentGroupAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl =
        new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl.setId(null);
    fulfillmentGroupAdjustmentImpl.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl.setValue(new Money(10.0d));

    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl2 =
        new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl2.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl2.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    fulfillmentGroupAdjustmentImpl2.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupAdjustmentImpl, fulfillmentGroupAdjustmentImpl2);
  }

  /**
   * Test {@link FulfillmentGroupAdjustmentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupAdjustmentImpl.equals(Object)",
    "int FulfillmentGroupAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Money value = mock(Money.class);
    when(value.getAmount()).thenReturn(null);

    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl =
        new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl.setId(null);
    fulfillmentGroupAdjustmentImpl.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl.setValue(value);

    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl2 =
        new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl2.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl2.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    fulfillmentGroupAdjustmentImpl2.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupAdjustmentImpl, fulfillmentGroupAdjustmentImpl2);
  }

  /**
   * Test {@link FulfillmentGroupAdjustmentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupAdjustmentImpl.equals(Object)",
    "int FulfillmentGroupAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl =
        new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    fulfillmentGroupAdjustmentImpl.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl.setValue(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupAdjustmentImpl, null);
  }

  /**
   * Test {@link FulfillmentGroupAdjustmentImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupAdjustmentImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupAdjustmentImpl.equals(Object)",
    "int FulfillmentGroupAdjustmentImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    FulfillmentGroupAdjustmentImpl fulfillmentGroupAdjustmentImpl =
        new FulfillmentGroupAdjustmentImpl();
    fulfillmentGroupAdjustmentImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupAdjustmentImpl.setFutureCredit(true);
    fulfillmentGroupAdjustmentImpl.setId(FulfillmentGroupAdjustmentImpl.serialVersionUID);
    fulfillmentGroupAdjustmentImpl.setReason("Just cause");
    fulfillmentGroupAdjustmentImpl.setValue(new Money());

    // Act and Assert
    assertNotEquals(
        fulfillmentGroupAdjustmentImpl, "Different type to FulfillmentGroupAdjustmentImpl");
  }

  /**
   * Test new {@link FulfillmentGroupAdjustmentImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * FulfillmentGroupAdjustmentImpl}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FulfillmentGroupAdjustmentImpl.<init>()"})
  public void testNewFulfillmentGroupAdjustmentImpl() {
    // Arrange and Act
    FulfillmentGroupAdjustmentImpl actualFulfillmentGroupAdjustmentImpl =
        new FulfillmentGroupAdjustmentImpl();

    // Assert
    assertNull(actualFulfillmentGroupAdjustmentImpl.getId());
    assertNull(actualFulfillmentGroupAdjustmentImpl.getReason());
    assertNull(actualFulfillmentGroupAdjustmentImpl.getOffer());
    assertNull(actualFulfillmentGroupAdjustmentImpl.deproxiedOffer);
    assertNull(actualFulfillmentGroupAdjustmentImpl.offer);
    assertNull(actualFulfillmentGroupAdjustmentImpl.getFulfillmentGroup());
    assertFalse(actualFulfillmentGroupAdjustmentImpl.isFutureCredit());
    assertEquals(new BigDecimal("0.00"), actualFulfillmentGroupAdjustmentImpl.value);
  }
}

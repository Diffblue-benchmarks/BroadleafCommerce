package org.broadleafcommerce.core.order.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
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
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.service.type.FulfillmentGroupStatusType;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
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
public class FulfillmentGroupItemImplDiffblueTest {
  @Autowired private FulfillmentGroupItemImpl fulfillmentGroupItemImpl;

  /**
   * Test {@link FulfillmentGroupItemImpl#clone()}.
   *
   * <ul>
   *   <li>Given {@link FulfillmentGroupItemImpl} (default constructor) FulfillmentGroup is {@link
   *       FulfillmentGroupImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FulfillmentGroupItem FulfillmentGroupItemImpl.clone()"})
  public void testClone_givenFulfillmentGroupItemImplFulfillmentGroupIsFulfillmentGroupImpl() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
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
    orderItem.setId(OrderItemQualifierImpl.serialVersionUID);
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

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    Money proratedOrderAdjustment = new Money();
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(proratedOrderAdjustment);
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl.setTotalTax(new Money());
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setOrderItem(orderItem);

    // Act
    FulfillmentGroupItem actualCloneResult = fulfillmentGroupItemImpl.clone();

    // Assert
    assertTrue(actualCloneResult instanceof FulfillmentGroupItemImpl);
    assertEquals(proratedOrderAdjustment, actualCloneResult.getTotalItemTaxableAmount());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#clone()}.
   *
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is {@code null}.
   *   <li>Then return TotalItemTaxableAmount is {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FulfillmentGroupItem FulfillmentGroupItemImpl.clone()"})
  public void testClone_givenOrderImplCurrencyIsNull_thenReturnTotalItemTaxableAmountIsMoney() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
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
    orderItem.setId(OrderItemQualifierImpl.serialVersionUID);
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
    Money amount = new Money();
    fulfillmentGroupItemImpl.setTotalItemAmount(amount);
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setOrderItem(orderItem);

    // Act
    FulfillmentGroupItem actualCloneResult = fulfillmentGroupItemImpl.clone();

    // Assert
    assertTrue(actualCloneResult instanceof FulfillmentGroupItemImpl);
    assertEquals(amount, actualCloneResult.getTotalItemTaxableAmount());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#clone()}.
   *
   * <ul>
   *   <li>Then OrderItem return {@link BundleOrderItemImpl}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FulfillmentGroupItem FulfillmentGroupItemImpl.clone()"})
  public void testClone_thenOrderItemReturnBundleOrderItemImpl() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
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
    orderItem.setId(OrderItemQualifierImpl.serialVersionUID);
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
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setOrderItem(orderItem);

    // Act
    FulfillmentGroupItem actualCloneResult = fulfillmentGroupItemImpl.clone();

    // Assert
    verify(currency, atLeast(1)).getCurrencyCode();
    assertTrue(actualCloneResult.getOrderItem() instanceof BundleOrderItemImpl);
    assertTrue(actualCloneResult instanceof FulfillmentGroupItemImpl);
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#clone()}.
   *
   * <ul>
   *   <li>Then return {@link FulfillmentGroupItemImpl#totalItemTaxableAmount} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FulfillmentGroupItem FulfillmentGroupItemImpl.clone()"})
  public void testClone_thenReturnTotalItemTaxableAmountIsNull() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
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
    orderItem.setId(OrderItemQualifierImpl.serialVersionUID);
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
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(null);
    fulfillmentGroupItemImpl.setOrderItem(orderItem);

    // Act
    FulfillmentGroupItem actualCloneResult = fulfillmentGroupItemImpl.clone();

    // Assert
    assertTrue(actualCloneResult instanceof FulfillmentGroupItemImpl);
    assertNull(((FulfillmentGroupItemImpl) actualCloneResult).totalItemTaxableAmount);
    assertNull(actualCloneResult.getTotalItemTaxableAmount());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#clone()}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FulfillmentGroupItem FulfillmentGroupItemImpl.clone()"})
  public void testClone_thenThrowRuntimeException() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenThrow(new RuntimeException());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable2);
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
    orderItem.setId(OrderItemQualifierImpl.serialVersionUID);
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
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setOrderItem(orderItem);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> fulfillmentGroupItemImpl.clone());
    verify(currency).getCurrencyCode();
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#equals(Object)}, and {@link
   * FulfillmentGroupItemImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentGroupItemImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupItemImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupItemImpl.equals(Object)",
    "int FulfillmentGroupItemImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl2.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemImpl2.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl2.setQuantity(1);
    fulfillmentGroupItemImpl2.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl2.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalTax(new Money());

    // Act and Assert
    assertEquals(fulfillmentGroupItemImpl, fulfillmentGroupItemImpl2);
    assertEquals(fulfillmentGroupItemImpl.hashCode(), fulfillmentGroupItemImpl2.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#equals(Object)}, and {@link
   * FulfillmentGroupItemImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentGroupItemImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupItemImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupItemImpl.equals(Object)",
    "int FulfillmentGroupItemImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(null);
    fulfillmentGroupItemImpl.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl2.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemImpl2.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl2.setQuantity(1);
    fulfillmentGroupItemImpl2.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl2.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalTax(new Money());

    // Act and Assert
    assertEquals(fulfillmentGroupItemImpl, fulfillmentGroupItemImpl2);
    assertEquals(fulfillmentGroupItemImpl.hashCode(), fulfillmentGroupItemImpl2.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#equals(Object)}, and {@link
   * FulfillmentGroupItemImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentGroupItemImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupItemImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupItemImpl.equals(Object)",
    "int FulfillmentGroupItemImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl2.setId(null);
    fulfillmentGroupItemImpl2.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemImpl2.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl2.setQuantity(1);
    fulfillmentGroupItemImpl2.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl2.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalTax(new Money());

    // Act and Assert
    assertEquals(fulfillmentGroupItemImpl, fulfillmentGroupItemImpl2);
    assertEquals(fulfillmentGroupItemImpl.hashCode(), fulfillmentGroupItemImpl2.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#equals(Object)}, and {@link
   * FulfillmentGroupItemImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentGroupItemImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupItemImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupItemImpl.equals(Object)",
    "int FulfillmentGroupItemImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(null);
    fulfillmentGroupItemImpl.setOrderItem(null);
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl2.setOrderItem(null);
    fulfillmentGroupItemImpl2.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl2.setQuantity(1);
    fulfillmentGroupItemImpl2.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl2.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalTax(new Money());

    // Act and Assert
    assertEquals(fulfillmentGroupItemImpl, fulfillmentGroupItemImpl2);
    assertEquals(fulfillmentGroupItemImpl.hashCode(), fulfillmentGroupItemImpl2.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#equals(Object)}, and {@link
   * FulfillmentGroupItemImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentGroupItemImpl#equals(Object)}
   *   <li>{@link FulfillmentGroupItemImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupItemImpl.equals(Object)",
    "int FulfillmentGroupItemImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());

    // Act and Assert
    assertEquals(fulfillmentGroupItemImpl, fulfillmentGroupItemImpl);
    int expectedHashCodeResult = fulfillmentGroupItemImpl.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentGroupItemImpl.hashCode());
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupItemImpl.equals(Object)",
    "int FulfillmentGroupItemImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(2L);
    fulfillmentGroupItemImpl.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl2.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemImpl2.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl2.setQuantity(1);
    fulfillmentGroupItemImpl2.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl2.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupItemImpl, fulfillmentGroupItemImpl2);
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupItemImpl.equals(Object)",
    "int FulfillmentGroupItemImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(null);
    fulfillmentGroupItemImpl.setOrderItem(new DiscreteOrderItemImpl());
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl2.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemImpl2.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl2.setQuantity(1);
    fulfillmentGroupItemImpl2.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl2.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupItemImpl, fulfillmentGroupItemImpl2);
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupItemImpl.equals(Object)",
    "int FulfillmentGroupItemImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(null);
    fulfillmentGroupItemImpl.setOrderItem(null);
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());

    FulfillmentGroupItemImpl fulfillmentGroupItemImpl2 = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl2.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl2.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemImpl2.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl2.setQuantity(1);
    fulfillmentGroupItemImpl2.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl2.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl2.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl2.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupItemImpl, fulfillmentGroupItemImpl2);
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupItemImpl.equals(Object)",
    "int FulfillmentGroupItemImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupItemImpl, null);
  }

  /**
   * Test {@link FulfillmentGroupItemImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentGroupItemImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupItemImpl.equals(Object)",
    "int FulfillmentGroupItemImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    FulfillmentGroupItemImpl fulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    fulfillmentGroupItemImpl.setFulfillmentGroup(new FulfillmentGroupImpl());
    fulfillmentGroupItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    fulfillmentGroupItemImpl.setOrderItem(new BundleOrderItemImpl());
    fulfillmentGroupItemImpl.setProratedOrderAdjustmentAmount(new Money());
    fulfillmentGroupItemImpl.setQuantity(1);
    fulfillmentGroupItemImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupItemImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupItemImpl.setTotalItemAmount(new Money());
    fulfillmentGroupItemImpl.setTotalItemTaxableAmount(new Money());
    fulfillmentGroupItemImpl.setTotalTax(new Money());

    // Act and Assert
    assertNotEquals(fulfillmentGroupItemImpl, "Different type to FulfillmentGroupItemImpl");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link FulfillmentGroupItemImpl}
   *   <li>{@link FulfillmentGroupItemImpl#setFulfillmentGroup(FulfillmentGroup)}
   *   <li>{@link FulfillmentGroupItemImpl#setId(Long)}
   *   <li>{@link FulfillmentGroupItemImpl#setOrderItem(OrderItem)}
   *   <li>{@link FulfillmentGroupItemImpl#setQuantity(int)}
   *   <li>{@link FulfillmentGroupItemImpl#setTaxes(List)}
   *   <li>{@link FulfillmentGroupItemImpl#getFulfillmentGroup()}
   *   <li>{@link FulfillmentGroupItemImpl#getId()}
   *   <li>{@link FulfillmentGroupItemImpl#getOrderItem()}
   *   <li>{@link FulfillmentGroupItemImpl#getQuantity()}
   *   <li>{@link FulfillmentGroupItemImpl#getTaxes()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FulfillmentGroupItemImpl.<init>()",
    "FulfillmentGroup FulfillmentGroupItemImpl.getFulfillmentGroup()",
    "Long FulfillmentGroupItemImpl.getId()",
    "OrderItem FulfillmentGroupItemImpl.getOrderItem()",
    "int FulfillmentGroupItemImpl.getQuantity()",
    "List FulfillmentGroupItemImpl.getTaxes()",
    "void FulfillmentGroupItemImpl.setFulfillmentGroup(FulfillmentGroup)",
    "void FulfillmentGroupItemImpl.setId(Long)",
    "void FulfillmentGroupItemImpl.setOrderItem(OrderItem)",
    "void FulfillmentGroupItemImpl.setQuantity(int)",
    "void FulfillmentGroupItemImpl.setTaxes(List)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    FulfillmentGroupItemImpl actualFulfillmentGroupItemImpl = new FulfillmentGroupItemImpl();
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    actualFulfillmentGroupItemImpl.setFulfillmentGroup(fulfillmentGroup);
    actualFulfillmentGroupItemImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    actualFulfillmentGroupItemImpl.setOrderItem(orderItem);
    actualFulfillmentGroupItemImpl.setQuantity(1);
    ArrayList<TaxDetail> taxes = new ArrayList<>();
    actualFulfillmentGroupItemImpl.setTaxes(taxes);
    FulfillmentGroup actualFulfillmentGroup = actualFulfillmentGroupItemImpl.getFulfillmentGroup();
    Long actualId = actualFulfillmentGroupItemImpl.getId();
    OrderItem actualOrderItem = actualFulfillmentGroupItemImpl.getOrderItem();
    int actualQuantity = actualFulfillmentGroupItemImpl.getQuantity();
    List<TaxDetail> actualTaxes = actualFulfillmentGroupItemImpl.getTaxes();

    // Assert
    assertEquals(1, actualQuantity);
    assertTrue(actualTaxes.isEmpty());
    assertEquals(OrderItemQualifierImpl.serialVersionUID, actualId.longValue());
    assertSame(taxes, actualTaxes);
    assertSame(orderItem, actualOrderItem);
    assertSame(fulfillmentGroup, actualFulfillmentGroup);
  }
}

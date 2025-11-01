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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.copy.DeferredOperation;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.service.GenericEntityServiceImpl;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.offer.domain.CandidateOrderOffer;
import org.broadleafcommerce.core.offer.domain.CandidateOrderOfferImpl;
import org.broadleafcommerce.core.offer.domain.OfferCode;
import org.broadleafcommerce.core.offer.domain.OfferCodeImpl;
import org.broadleafcommerce.core.order.service.call.ActivityMessageDTO;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.payment.domain.OrderPayment;
import org.broadleafcommerce.core.payment.domain.OrderPaymentImpl;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {NullOrderImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class NullOrderImplDiffblueTest {
  @Autowired
  private NullOrderImpl nullOrderImpl;

  /**
   * Method under test: {@link NullOrderImpl#setId(Long)}
   */
  @Test
  public void testSetId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new NullOrderImpl()).setId(OrderItemQualifierImpl.serialVersionUID));
  }

  /**
   * Method under test: {@link NullOrderImpl#setName(String)}
   */
  @Test
  public void testSetName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> nullOrderImpl.setName("Name"));
  }

  /**
   * Method under test: {@link NullOrderImpl#setAuditable(Auditable)}
   */
  @Test
  public void testSetAuditable() {
    // Arrange
    NullOrderImpl nullOrderImpl = new NullOrderImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderItemQualifierImpl.serialVersionUID);
    auditable.setDateCreated(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderItemQualifierImpl.serialVersionUID);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> nullOrderImpl.setAuditable(auditable));
  }

  /**
   * Method under test: {@link NullOrderImpl#getSubTotal()}
   */
  @Test
  public void testGetSubTotal() {
    // Arrange and Act
    Money actualSubTotal = (new NullOrderImpl()).getSubTotal();

    // Assert
    assertEquals(actualSubTotal.ZERO, actualSubTotal);
  }

  /**
   * Method under test: {@link NullOrderImpl#setSubTotal(Money)}
   */
  @Test
  public void testSetSubTotal() {
    // Arrange
    NullOrderImpl nullOrderImpl = new NullOrderImpl();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> nullOrderImpl.setSubTotal(new Money()));
  }

  /**
   * Method under test: {@link NullOrderImpl#assignOrderItemsFinalPrice()}
   */
  @Test
  public void testAssignOrderItemsFinalPrice() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new NullOrderImpl()).assignOrderItemsFinalPrice());
  }

  /**
   * Method under test: {@link NullOrderImpl#setTotal(Money)}
   */
  @Test
  public void testSetTotal() {
    // Arrange
    NullOrderImpl nullOrderImpl = new NullOrderImpl();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> nullOrderImpl.setTotal(new Money()));
  }

  /**
   * Method under test: {@link NullOrderImpl#setCustomer(Customer)}
   */
  @Test
  public void testSetCustomer() {
    // Arrange
    NullOrderImpl nullOrderImpl = new NullOrderImpl();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> nullOrderImpl.setCustomer(new CustomerImpl()));
  }

  /**
   * Method under test: {@link NullOrderImpl#setStatus(OrderStatus)}
   */
  @Test
  public void testSetStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new NullOrderImpl()).setStatus(OrderStatus.ARCHIVED));
  }

  /**
   * Method under test: {@link NullOrderImpl#setOrderItems(List)}
   */
  @Test
  public void testSetOrderItems() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> nullOrderImpl.setOrderItems(new ArrayList<>()));
  }

  /**
   * Method under test: {@link NullOrderImpl#setOrderItems(List)}
   */
  @Test
  public void testSetOrderItems2() {
    // Arrange
    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> nullOrderImpl.setOrderItems(orderItems));
  }

  /**
   * Method under test: {@link NullOrderImpl#setOrderItems(List)}
   */
  @Test
  public void testSetOrderItems3() {
    // Arrange
    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());
    orderItems.add(new BundleOrderItemImpl());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> nullOrderImpl.setOrderItems(orderItems));
  }

  /**
   * Method under test: {@link NullOrderImpl#addOrderItem(OrderItem)}
   */
  @Test
  public void testAddOrderItem() {
    // Arrange
    NullOrderImpl nullOrderImpl = new NullOrderImpl();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> nullOrderImpl.addOrderItem(new BundleOrderItemImpl()));
  }

  /**
   * Method under test: {@link NullOrderImpl#setFulfillmentGroups(List)}
   */
  @Test
  public void testSetFulfillmentGroups() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> nullOrderImpl.setFulfillmentGroups(new ArrayList<>()));
  }

  /**
   * Method under test: {@link NullOrderImpl#setFulfillmentGroups(List)}
   */
  @Test
  public void testSetFulfillmentGroups2() {
    // Arrange
    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> nullOrderImpl.setFulfillmentGroups(fulfillmentGroups));
  }

  /**
   * Method under test: {@link NullOrderImpl#setFulfillmentGroups(List)}
   */
  @Test
  public void testSetFulfillmentGroups3() {
    // Arrange
    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> nullOrderImpl.setFulfillmentGroups(fulfillmentGroups));
  }

  /**
   * Method under test: {@link NullOrderImpl#setCandidateOrderOffers(List)}
   */
  @Test
  public void testSetCandidateOrderOffers() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> nullOrderImpl.setCandidateOrderOffers(new ArrayList<>()));
  }

  /**
   * Method under test: {@link NullOrderImpl#setCandidateOrderOffers(List)}
   */
  @Test
  public void testSetCandidateOrderOffers2() {
    // Arrange
    ArrayList<CandidateOrderOffer> candidateOrderOffers = new ArrayList<>();
    candidateOrderOffers.add(new CandidateOrderOfferImpl());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> nullOrderImpl.setCandidateOrderOffers(candidateOrderOffers));
  }

  /**
   * Method under test: {@link NullOrderImpl#setCandidateOrderOffers(List)}
   */
  @Test
  public void testSetCandidateOrderOffers3() {
    // Arrange
    ArrayList<CandidateOrderOffer> candidateOrderOffers = new ArrayList<>();
    candidateOrderOffers.add(new CandidateOrderOfferImpl());
    candidateOrderOffers.add(new CandidateOrderOfferImpl());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> nullOrderImpl.setCandidateOrderOffers(candidateOrderOffers));
  }

  /**
   * Method under test: {@link NullOrderImpl#setSubmitDate(Date)}
   */
  @Test
  public void testSetSubmitDate() {
    // Arrange
    NullOrderImpl nullOrderImpl = new NullOrderImpl();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> nullOrderImpl.setSubmitDate(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())));
  }

  /**
   * Method under test: {@link NullOrderImpl#setTotalTax(Money)}
   */
  @Test
  public void testSetTotalTax() {
    // Arrange
    NullOrderImpl nullOrderImpl = new NullOrderImpl();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> nullOrderImpl.setTotalTax(new Money()));
  }

  /**
   * Method under test: {@link NullOrderImpl#setTotalShipping(Money)}
   */
  @Test
  public void testSetTotalShipping() {
    // Arrange
    NullOrderImpl nullOrderImpl = new NullOrderImpl();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> nullOrderImpl.setTotalShipping(new Money()));
  }

  /**
   * Method under test: {@link NullOrderImpl#setPayments(List)}
   */
  @Test
  public void testSetPayments() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> nullOrderImpl.setPayments(new ArrayList<>()));
  }

  /**
   * Method under test: {@link NullOrderImpl#setPayments(List)}
   */
  @Test
  public void testSetPayments2() {
    // Arrange
    ArrayList<OrderPayment> paymentInfos = new ArrayList<>();
    paymentInfos.add(new OrderPaymentImpl());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> nullOrderImpl.setPayments(paymentInfos));
  }

  /**
   * Method under test: {@link NullOrderImpl#setPayments(List)}
   */
  @Test
  public void testSetPayments3() {
    // Arrange
    ArrayList<OrderPayment> paymentInfos = new ArrayList<>();
    paymentInfos.add(new OrderPaymentImpl());
    paymentInfos.add(new OrderPaymentImpl());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> nullOrderImpl.setPayments(paymentInfos));
  }

  /**
   * Method under test: {@link NullOrderImpl#hasCategoryItem(String)}
   */
  @Test
  public void testHasCategoryItem() {
    // Arrange, Act and Assert
    assertFalse(nullOrderImpl.hasCategoryItem("Category Name"));
  }

  /**
   * Method under test: {@link NullOrderImpl#containsSku(Sku)}
   */
  @Test
  public void testContainsSku() {
    // Arrange
    NullOrderImpl nullOrderImpl = new NullOrderImpl();

    // Act and Assert
    assertFalse(nullOrderImpl.containsSku(new SkuImpl()));
  }

  /**
   * Method under test: {@link NullOrderImpl#containsSku(Sku)}
   */
  @Test
  public void testContainsSku2() {
    // Arrange
    NullOrderImpl nullOrderImpl = new NullOrderImpl();

    SkuImpl sku = new SkuImpl();
    sku.setActiveStartDate(mock(Date.class));

    // Act and Assert
    assertFalse(nullOrderImpl.containsSku(sku));
  }

  /**
   * Method under test: {@link NullOrderImpl#setOrderNumber(String)}
   */
  @Test
  public void testSetOrderNumber() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> nullOrderImpl.setOrderNumber("42"));
  }

  /**
   * Method under test: {@link NullOrderImpl#setEmailAddress(String)}
   */
  @Test
  public void testSetEmailAddress() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> nullOrderImpl.setEmailAddress("42 Main St"));
  }

  /**
   * Method under test: {@link NullOrderImpl#setAdditionalOfferInformation(Map)}
   */
  @Test
  public void testSetAdditionalOfferInformation() {
    // Arrange
    NullOrderImpl nullOrderImpl = new NullOrderImpl();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> nullOrderImpl.setAdditionalOfferInformation(new HashMap<>()));
  }

  /**
   * Method under test: {@link NullOrderImpl#updatePrices()}
   */
  @Test
  public void testUpdatePrices() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new NullOrderImpl()).updatePrices());
  }

  /**
   * Method under test: {@link NullOrderImpl#addOfferCode(OfferCode)}
   */
  @Test
  public void testAddOfferCode() {
    // Arrange
    NullOrderImpl nullOrderImpl = new NullOrderImpl();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> nullOrderImpl.addOfferCode(new OfferCodeImpl()));
  }

  /**
   * Method under test: {@link NullOrderImpl#addAddedOfferCode(OfferCode)}
   */
  @Test
  public void testAddAddedOfferCode() {
    // Arrange
    NullOrderImpl nullOrderImpl = new NullOrderImpl();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> nullOrderImpl.addAddedOfferCode(new OfferCodeImpl()));
  }

  /**
   * Method under test: {@link NullOrderImpl#setOrderAttributes(Map)}
   */
  @Test
  public void testSetOrderAttributes() {
    // Arrange
    NullOrderImpl nullOrderImpl = new NullOrderImpl();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> nullOrderImpl.setOrderAttributes(new HashMap<>()));
  }

  /**
   * Method under test: {@link NullOrderImpl#setCurrency(BroadleafCurrency)}
   */
  @Test
  public void testSetCurrency() {
    // Arrange
    NullOrderImpl nullOrderImpl = new NullOrderImpl();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> nullOrderImpl.setCurrency(new BroadleafCurrencyImpl()));
  }

  /**
   * Method under test: {@link NullOrderImpl#calculateSubTotal()}
   */
  @Test
  public void testCalculateSubTotal() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new NullOrderImpl()).calculateSubTotal());
  }

  /**
   * Method under test: {@link NullOrderImpl#setTotalFulfillmentCharges(Money)}
   */
  @Test
  public void testSetTotalFulfillmentCharges() {
    // Arrange
    NullOrderImpl nullOrderImpl = new NullOrderImpl();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> nullOrderImpl.setTotalFulfillmentCharges(new Money()));
  }

  /**
   * Method under test: {@link NullOrderImpl#finalizeItemPrices()}
   */
  @Test
  public void testFinalizeItemPrices() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new NullOrderImpl()).finalizeItemPrices());
  }

  /**
   * Method under test: {@link NullOrderImpl#setOrderMessages(List)}
   */
  @Test
  public void testSetOrderMessages() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> nullOrderImpl.setOrderMessages(new ArrayList<>()));
  }

  /**
   * Method under test: {@link NullOrderImpl#setOrderMessages(List)}
   */
  @Test
  public void testSetOrderMessages2() {
    // Arrange
    ArrayList<ActivityMessageDTO> orderMessages = new ArrayList<>();
    orderMessages.add(new ActivityMessageDTO("NullOrder does not support any modification operations.", 1,
        "Not all who wander are lost"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> nullOrderImpl.setOrderMessages(orderMessages));
  }

  /**
   * Method under test: {@link NullOrderImpl#setOrderMessages(List)}
   */
  @Test
  public void testSetOrderMessages3() {
    // Arrange
    ArrayList<ActivityMessageDTO> orderMessages = new ArrayList<>();
    orderMessages.add(new ActivityMessageDTO("NullOrder does not support any modification operations.", 1,
        "Not all who wander are lost"));
    orderMessages.add(new ActivityMessageDTO("NullOrder does not support any modification operations.", 1,
        "Not all who wander are lost"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> nullOrderImpl.setOrderMessages(orderMessages));
  }

  /**
   * Method under test: {@link NullOrderImpl#getTaxOverride()}
   */
  @Test
  public void testGetTaxOverride() {
    // Arrange, Act and Assert
    assertFalse((new NullOrderImpl()).getTaxOverride());
  }

  /**
   * Method under test: {@link NullOrderImpl#setTaxOverride(Boolean)}
   */
  @Test
  public void testSetTaxOverride() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new NullOrderImpl()).setTaxOverride(true));
  }

  /**
   * Method under test:
   * {@link NullOrderImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    // Act and Assert
    assertNull(nullOrderImpl.createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite,
        toSite, genericEntityService, new MultiTenantCopierExtensionManager())));
  }

  /**
   * Method under test:
   * {@link NullOrderImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    MultiTenantCopyContext context = new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
        genericEntityService, new MultiTenantCopierExtensionManager());
    context.addDeferredOperation(mock(DeferredOperation.class));

    // Act and Assert
    assertNull(nullOrderImpl.createOrRetrieveCopyInstance(context));
  }

  /**
   * Method under test: {@link NullOrderImpl#hasValidationErrors()}
   */
  @Test
  public void testHasValidationErrors() {
    // Arrange, Act and Assert
    assertFalse((new NullOrderImpl()).hasValidationErrors());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link NullOrderImpl}
   *   <li>{@link NullOrderImpl#setLocale(Locale)}
   *   <li>{@link NullOrderImpl#getAddedOfferCodes()}
   *   <li>{@link NullOrderImpl#getAdditionalOfferInformation()}
   *   <li>{@link NullOrderImpl#getAllFutureCreditAdjustments()}
   *   <li>{@link NullOrderImpl#getAuditable()}
   *   <li>{@link NullOrderImpl#getBroadleafAccountId()}
   *   <li>{@link NullOrderImpl#getCandidateOrderOffers()}
   *   <li>{@link NullOrderImpl#getCurrency()}
   *   <li>{@link NullOrderImpl#getCustomer()}
   *   <li>{@link NullOrderImpl#getDiscreteOrderItems()}
   *   <li>{@link NullOrderImpl#getEmailAddress()}
   *   <li>{@link NullOrderImpl#getFulfillmentGroupAdjustmentsValue()}
   *   <li>{@link NullOrderImpl#getFulfillmentGroups()}
   *   <li>{@link NullOrderImpl#getFulfillmentStatus()}
   *   <li>{@link NullOrderImpl#getFutureCreditFulfillmentGroupAdjustmentsValue()}
   *   <li>{@link NullOrderImpl#getFutureCreditItemAdjustmentsValue()}
   *   <li>{@link NullOrderImpl#getFutureCreditOrderAdjustments()}
   *   <li>{@link NullOrderImpl#getFutureCreditOrderAdjustmentsValue()}
   *   <li>{@link NullOrderImpl#getHasOrderAdjustments()}
   *   <li>{@link NullOrderImpl#getId()}
   *   <li>{@link NullOrderImpl#getItemAdjustmentsValue()}
   *   <li>{@link NullOrderImpl#getItemCount()}
   *   <li>{@link NullOrderImpl#getLocale()}
   *   <li>{@link NullOrderImpl#getName()}
   *   <li>{@link NullOrderImpl#getNonDiscreteOrderItems()}
   *   <li>{@link NullOrderImpl#getOrderAdjustments()}
   *   <li>{@link NullOrderImpl#getOrderAdjustmentsValue()}
   *   <li>{@link NullOrderImpl#getOrderAttributes()}
   *   <li>{@link NullOrderImpl#getOrderItems()}
   *   <li>{@link NullOrderImpl#getOrderMessages()}
   *   <li>{@link NullOrderImpl#getOrderNumber()}
   *   <li>{@link NullOrderImpl#getPayments()}
   *   <li>{@link NullOrderImpl#getStatus()}
   *   <li>{@link NullOrderImpl#getSubmitDate()}
   *   <li>{@link NullOrderImpl#getTotal()}
   *   <li>{@link NullOrderImpl#getTotalAdjustmentsValue()}
   *   <li>{@link NullOrderImpl#getTotalAfterAppliedPayments()}
   *   <li>{@link NullOrderImpl#getTotalFulfillmentCharges()}
   *   <li>{@link NullOrderImpl#getTotalFutureCreditAdjustmentsValue()}
   *   <li>{@link NullOrderImpl#getTotalShipping()}
   *   <li>{@link NullOrderImpl#getTotalTax()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    NullOrderImpl actualNullOrderImpl = new NullOrderImpl();
    actualNullOrderImpl.setLocale(new LocaleImpl());
    actualNullOrderImpl.getAddedOfferCodes();
    actualNullOrderImpl.getAdditionalOfferInformation();
    actualNullOrderImpl.getAllFutureCreditAdjustments();
    actualNullOrderImpl.getAuditable();
    actualNullOrderImpl.getBroadleafAccountId();
    actualNullOrderImpl.getCandidateOrderOffers();
    actualNullOrderImpl.getCurrency();
    actualNullOrderImpl.getCustomer();
    actualNullOrderImpl.getDiscreteOrderItems();
    actualNullOrderImpl.getEmailAddress();
    actualNullOrderImpl.getFulfillmentGroupAdjustmentsValue();
    actualNullOrderImpl.getFulfillmentGroups();
    actualNullOrderImpl.getFulfillmentStatus();
    actualNullOrderImpl.getFutureCreditFulfillmentGroupAdjustmentsValue();
    actualNullOrderImpl.getFutureCreditItemAdjustmentsValue();
    actualNullOrderImpl.getFutureCreditOrderAdjustments();
    actualNullOrderImpl.getFutureCreditOrderAdjustmentsValue();
    boolean actualHasOrderAdjustments = actualNullOrderImpl.getHasOrderAdjustments();
    actualNullOrderImpl.getId();
    actualNullOrderImpl.getItemAdjustmentsValue();
    int actualItemCount = actualNullOrderImpl.getItemCount();
    actualNullOrderImpl.getLocale();
    actualNullOrderImpl.getName();
    actualNullOrderImpl.getNonDiscreteOrderItems();
    actualNullOrderImpl.getOrderAdjustments();
    Money actualOrderAdjustmentsValue = actualNullOrderImpl.getOrderAdjustmentsValue();
    actualNullOrderImpl.getOrderAttributes();
    actualNullOrderImpl.getOrderItems();
    actualNullOrderImpl.getOrderMessages();
    actualNullOrderImpl.getOrderNumber();
    actualNullOrderImpl.getPayments();
    actualNullOrderImpl.getStatus();
    actualNullOrderImpl.getSubmitDate();
    actualNullOrderImpl.getTotal();
    actualNullOrderImpl.getTotalAdjustmentsValue();
    actualNullOrderImpl.getTotalAfterAppliedPayments();
    actualNullOrderImpl.getTotalFulfillmentCharges();
    actualNullOrderImpl.getTotalFutureCreditAdjustmentsValue();
    actualNullOrderImpl.getTotalShipping();
    actualNullOrderImpl.getTotalTax();

    // Assert that nothing has changed
    assertEquals(0, actualItemCount);
    assertFalse(actualHasOrderAdjustments);
    assertSame(actualOrderAdjustmentsValue.ZERO, actualOrderAdjustmentsValue);
  }
}

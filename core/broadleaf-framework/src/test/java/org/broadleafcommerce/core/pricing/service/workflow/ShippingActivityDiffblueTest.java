/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
package org.broadleafcommerce.core.pricing.service.workflow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.pricing.service.ShippingService;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;

public class ShippingActivityDiffblueTest {
  /**
   * Test {@link ShippingActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor).</li>
   *   <li>Then return SeedData Auditable CreatedBy is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ShippingActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_givenOrderImpl_thenReturnSeedDataAuditableCreatedByIsNull() throws Exception {
    // Arrange
    ShippingActivity shippingActivity = new ShippingActivity();

    DefaultProcessContextImpl<Order> context = new DefaultProcessContextImpl<>();
    context.setSeedData(new OrderImpl());

    // Act
    ProcessContext<Order> actualExecuteResult = shippingActivity.execute((ProcessContext<Order>) context);

    // Assert
    Order seedData = actualExecuteResult.getSeedData();
    assertTrue(seedData instanceof OrderImpl);
    assertTrue(actualExecuteResult instanceof DefaultProcessContextImpl);
    Auditable auditable = seedData.getAuditable();
    assertNull(auditable.getCreatedBy());
    assertNull(auditable.getUpdatedBy());
    assertNull(seedData.getId());
    assertNull(seedData.getEmailAddress());
    assertNull(seedData.getName());
    assertNull(seedData.getOrderNumber());
    assertNull(((OrderImpl) seedData).getCurrencyCode());
    assertNull(auditable.getDateCreated());
    assertNull(auditable.getDateUpdated());
    assertNull(seedData.getSubmitDate());
    assertNull(seedData.getCurrency());
    assertNull(seedData.getLocale());
    assertNull(seedData.getSubTotal());
    assertNull(seedData.getTotal());
    assertNull(seedData.getTotalAfterAppliedPayments());
    assertNull(seedData.getTotalTax());
    assertNull(seedData.getStatus());
    assertNull(seedData.getCustomer());
    assertFalse(seedData.getTaxOverride());
    Money fulfillmentGroupAdjustmentsValue = seedData.getFulfillmentGroupAdjustmentsValue();
    assertEquals(fulfillmentGroupAdjustmentsValue, fulfillmentGroupAdjustmentsValue.abs());
    assertEquals(fulfillmentGroupAdjustmentsValue, fulfillmentGroupAdjustmentsValue.zero());
    assertEquals(fulfillmentGroupAdjustmentsValue, seedData.getFutureCreditFulfillmentGroupAdjustmentsValue());
    assertEquals(fulfillmentGroupAdjustmentsValue, seedData.getFutureCreditItemAdjustmentsValue());
    assertEquals(fulfillmentGroupAdjustmentsValue, seedData.getFutureCreditOrderAdjustmentsValue());
    assertEquals(fulfillmentGroupAdjustmentsValue, seedData.getItemAdjustmentsValue());
    assertEquals(fulfillmentGroupAdjustmentsValue, seedData.getOrderAdjustmentsValue());
    assertEquals(fulfillmentGroupAdjustmentsValue, seedData.getTotalAdjustmentsValue());
    assertEquals(fulfillmentGroupAdjustmentsValue, seedData.getTotalFulfillmentCharges());
    assertEquals(fulfillmentGroupAdjustmentsValue, seedData.getTotalFutureCreditAdjustmentsValue());
    assertEquals(fulfillmentGroupAdjustmentsValue, seedData.getTotalShipping());
  }

  /**
   * Test {@link ShippingActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Then return SeedData EmailAddress is {@code 42 Main St}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ShippingActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_thenReturnSeedDataEmailAddressIs42MainSt() throws Exception {
    // Arrange
    ShippingActivity shippingActivity = new ShippingActivity();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(currency);
    CustomerImpl customer = new CustomerImpl();
    orderImpl.setCustomer(customer);
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    LocaleImpl locale = new LocaleImpl();
    orderImpl.setLocale(locale);
    orderImpl.setName("ThreadLocalManager.notify.orphans");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    Money subTotal = new Money();
    orderImpl.setSubTotal(subTotal);
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalShipping(new Money());
    orderImpl.setTotalTax(new Money());

    DefaultProcessContextImpl<Order> context = new DefaultProcessContextImpl<>();
    context.setSeedData(orderImpl);

    // Act
    ProcessContext<Order> actualExecuteResult = shippingActivity.execute((ProcessContext<Order>) context);

    // Assert
    verify(currency).getCurrencyCode();
    Order seedData = actualExecuteResult.getSeedData();
    assertTrue(seedData instanceof OrderImpl);
    assertTrue(actualExecuteResult instanceof DefaultProcessContextImpl);
    assertEquals("42 Main St", seedData.getEmailAddress());
    assertEquals("42", seedData.getOrderNumber());
    assertEquals("42", ((OrderImpl) seedData).getMainEntityName());
    OrderStatus status = seedData.getStatus();
    assertEquals("ARCHIVED", status.getType());
    assertEquals("Archived", status.getFriendlyType());
    assertEquals("GBP", ((OrderImpl) seedData).getCurrencyCode());
    assertEquals("ThreadLocalManager.notify.orphans", seedData.getName());
    assertEquals(1L, seedData.getId().longValue());
    assertFalse(status.isEditable());
    assertTrue(seedData.getTaxOverride());
    assertEquals(subTotal, seedData.getFulfillmentGroupAdjustmentsValue());
    assertEquals(subTotal, seedData.getFutureCreditFulfillmentGroupAdjustmentsValue());
    assertEquals(subTotal, seedData.getFutureCreditItemAdjustmentsValue());
    assertEquals(subTotal, seedData.getFutureCreditOrderAdjustmentsValue());
    assertEquals(subTotal, seedData.getItemAdjustmentsValue());
    assertEquals(subTotal, seedData.getOrderAdjustmentsValue());
    assertEquals(subTotal, seedData.getSubTotal());
    assertEquals(subTotal, seedData.getTotal());
    assertEquals(subTotal, seedData.getTotalAdjustmentsValue());
    assertEquals(subTotal, seedData.getTotalAfterAppliedPayments());
    assertEquals(subTotal, seedData.getTotalFulfillmentCharges());
    assertEquals(subTotal, seedData.getTotalFutureCreditAdjustmentsValue());
    assertEquals(subTotal, seedData.getTotalShipping());
    assertEquals(subTotal, seedData.getTotalTax());
    assertSame(auditable, seedData.getAuditable());
    assertSame(locale, seedData.getLocale());
    assertSame(customer, seedData.getCustomer());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ShippingActivity}
   *   <li>{@link ShippingActivity#setShippingService(ShippingService)}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ShippingActivity actualShippingActivity = new ShippingActivity();
    actualShippingActivity.setShippingService(mock(ShippingService.class));

    // Assert
    assertNull(actualShippingActivity.getBeanName());
    assertNull(actualShippingActivity.getRollbackRegion());
    assertNull(actualShippingActivity.getStateConfiguration());
    assertNull(actualShippingActivity.getErrorHandler());
    assertNull(actualShippingActivity.getRollbackHandler());
    assertFalse(actualShippingActivity.getAutomaticallyRegisterRollbackHandler());
    assertEquals(Integer.MAX_VALUE, actualShippingActivity.getOrder());
  }
}

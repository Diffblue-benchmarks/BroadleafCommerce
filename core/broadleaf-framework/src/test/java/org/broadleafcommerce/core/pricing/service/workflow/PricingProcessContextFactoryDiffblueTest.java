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

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.broadleafcommerce.core.workflow.WorkflowException;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;

public class PricingProcessContextFactoryDiffblueTest {
  /**
   * Test {@link PricingProcessContextFactory#createContext(Order)} with
   * {@code Order}.
   * <ul>
   *   <li>Then return SeedData is {@link OrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PricingProcessContextFactory#createContext(Order)}
   */
  @Test
  public void testCreateContextWithOrder_thenReturnSeedDataIsOrderImpl() throws WorkflowException {
    // Arrange
    PricingProcessContextFactory pricingProcessContextFactory = new PricingProcessContextFactory();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(mock(java.sql.Date.class));
    auditable.setDateUpdated(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl seedData = new OrderImpl();
    seedData.setAdditionalOfferInformation(new HashMap<>());
    seedData.setAuditable(auditable);
    seedData.setCandidateOrderOffers(new ArrayList<>());
    seedData.setCurrency(new BroadleafCurrencyImpl());
    seedData.setCustomer(new CustomerImpl());
    seedData.setEmailAddress("42 Main St");
    seedData.setFulfillmentGroups(new ArrayList<>());
    seedData.setId(1L);
    seedData.setLocale(new LocaleImpl());
    seedData.setName("Name");
    seedData.setOrderAttributes(new HashMap<>());
    seedData.setOrderItems(new ArrayList<>());
    seedData.setOrderMessages(new ArrayList<>());
    seedData.setOrderNumber("42");
    seedData.setPayments(new ArrayList<>());
    seedData.setStatus(OrderStatus.ARCHIVED);
    seedData.setSubTotal(new Money());
    seedData
        .setSubmitDate(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    seedData.setTaxOverride(true);
    seedData.setTotal(new Money());
    seedData.setTotalFulfillmentCharges(new Money());
    seedData.setTotalShipping(new Money());
    seedData.setTotalTax(new Money());

    // Act
    ProcessContext<Order> actualCreateContextResult = pricingProcessContextFactory.createContext(seedData);

    // Assert
    assertTrue(actualCreateContextResult instanceof DefaultProcessContextImpl);
    assertSame(seedData, actualCreateContextResult.getSeedData());
  }

  /**
   * Test {@link PricingProcessContextFactory#createContext(Order)} with
   * {@code Order}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return SeedData is {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PricingProcessContextFactory#createContext(Order)}
   */
  @Test
  public void testCreateContextWithOrder_whenNullOrderImpl_thenReturnSeedDataIsNullOrderImpl()
      throws WorkflowException {
    // Arrange
    PricingProcessContextFactory pricingProcessContextFactory = new PricingProcessContextFactory();
    NullOrderImpl seedData = new NullOrderImpl();

    // Act
    ProcessContext<Order> actualCreateContextResult = pricingProcessContextFactory.createContext(seedData);

    // Assert
    assertTrue(actualCreateContextResult instanceof DefaultProcessContextImpl);
    assertSame(seedData, actualCreateContextResult.getSeedData());
  }
}

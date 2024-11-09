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
package org.broadleafcommerce.core.order.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AbstractOrderDaoExtensionHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractOrderDaoExtensionHandlerDiffblueTest {
  @Autowired
  private AbstractOrderDaoExtensionHandler abstractOrderDaoExtensionHandler;

  /**
   * Test
   * {@link AbstractOrderDaoExtensionHandler#attachAdditionalDataToNewCart(Customer, Order)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractOrderDaoExtensionHandler#attachAdditionalDataToNewCart(Customer, Order)}
   */
  @Test
  public void testAttachAdditionalDataToNewCart_givenAuditableCreatedByIsOne() {
    // Arrange
    AbstractOrderDaoExtensionHandler abstractOrderDaoExtensionHandler = new AbstractOrderDaoExtensionHandler();
    CustomerImpl customer = new CustomerImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(mock(java.sql.Date.class));
    auditable.setDateUpdated(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl cart = new OrderImpl();
    cart.setAdditionalOfferInformation(new HashMap<>());
    cart.setAuditable(auditable);
    cart.setCandidateOrderOffers(new ArrayList<>());
    cart.setCurrency(new BroadleafCurrencyImpl());
    cart.setCustomer(new CustomerImpl());
    cart.setEmailAddress("42 Main St");
    cart.setFulfillmentGroups(new ArrayList<>());
    cart.setId(1L);
    cart.setLocale(new LocaleImpl());
    cart.setName("Name");
    cart.setOrderAttributes(new HashMap<>());
    cart.setOrderItems(new ArrayList<>());
    cart.setOrderMessages(new ArrayList<>());
    cart.setOrderNumber("42");
    cart.setPayments(new ArrayList<>());
    cart.setStatus(OrderStatus.ARCHIVED);
    cart.setSubTotal(new Money());
    cart.setSubmitDate(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    cart.setTaxOverride(true);
    cart.setTotal(new Money());
    cart.setTotalFulfillmentCharges(new Money());
    cart.setTotalShipping(new Money());
    cart.setTotalTax(new Money());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractOrderDaoExtensionHandler.attachAdditionalDataToNewCart(customer, cart));
  }

  /**
   * Test
   * {@link AbstractOrderDaoExtensionHandler#attachAdditionalDataToNewCart(Customer, Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractOrderDaoExtensionHandler#attachAdditionalDataToNewCart(Customer, Order)}
   */
  @Test
  public void testAttachAdditionalDataToNewCart_whenNullOrderImpl() {
    // Arrange
    AbstractOrderDaoExtensionHandler abstractOrderDaoExtensionHandler = new AbstractOrderDaoExtensionHandler();
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractOrderDaoExtensionHandler.attachAdditionalDataToNewCart(customer, new NullOrderImpl()));
  }

  /**
   * Test
   * {@link AbstractOrderDaoExtensionHandler#processPostSaveNewCart(Customer, Order)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractOrderDaoExtensionHandler#processPostSaveNewCart(Customer, Order)}
   */
  @Test
  public void testProcessPostSaveNewCart_givenAuditableCreatedByIsOne() {
    // Arrange
    AbstractOrderDaoExtensionHandler abstractOrderDaoExtensionHandler = new AbstractOrderDaoExtensionHandler();
    CustomerImpl customer = new CustomerImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(mock(java.sql.Date.class));
    auditable.setDateUpdated(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl cart = new OrderImpl();
    cart.setAdditionalOfferInformation(new HashMap<>());
    cart.setAuditable(auditable);
    cart.setCandidateOrderOffers(new ArrayList<>());
    cart.setCurrency(new BroadleafCurrencyImpl());
    cart.setCustomer(new CustomerImpl());
    cart.setEmailAddress("42 Main St");
    cart.setFulfillmentGroups(new ArrayList<>());
    cart.setId(1L);
    cart.setLocale(new LocaleImpl());
    cart.setName("Name");
    cart.setOrderAttributes(new HashMap<>());
    cart.setOrderItems(new ArrayList<>());
    cart.setOrderMessages(new ArrayList<>());
    cart.setOrderNumber("42");
    cart.setPayments(new ArrayList<>());
    cart.setStatus(OrderStatus.ARCHIVED);
    cart.setSubTotal(new Money());
    cart.setSubmitDate(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    cart.setTaxOverride(true);
    cart.setTotal(new Money());
    cart.setTotalFulfillmentCharges(new Money());
    cart.setTotalShipping(new Money());
    cart.setTotalTax(new Money());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractOrderDaoExtensionHandler.processPostSaveNewCart(customer, cart));
  }

  /**
   * Test
   * {@link AbstractOrderDaoExtensionHandler#processPostSaveNewCart(Customer, Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractOrderDaoExtensionHandler#processPostSaveNewCart(Customer, Order)}
   */
  @Test
  public void testProcessPostSaveNewCart_whenNullOrderImpl() {
    // Arrange
    AbstractOrderDaoExtensionHandler abstractOrderDaoExtensionHandler = new AbstractOrderDaoExtensionHandler();
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractOrderDaoExtensionHandler.processPostSaveNewCart(customer, new NullOrderImpl()));
  }

  /**
   * Test
   * {@link AbstractOrderDaoExtensionHandler#applyAdditionalOrderLookupFilter(Customer, String, List)}.
   * <ul>
   *   <li>Given {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractOrderDaoExtensionHandler#applyAdditionalOrderLookupFilter(Customer, String, List)}
   */
  @Test
  public void testApplyAdditionalOrderLookupFilter_givenNullOrderImpl() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    ArrayList<Order> orders = new ArrayList<>();
    orders.add(new NullOrderImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractOrderDaoExtensionHandler.applyAdditionalOrderLookupFilter(customer, "Name", orders));
  }

  /**
   * Test
   * {@link AbstractOrderDaoExtensionHandler#applyAdditionalOrderLookupFilter(Customer, String, List)}.
   * <ul>
   *   <li>Given {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractOrderDaoExtensionHandler#applyAdditionalOrderLookupFilter(Customer, String, List)}
   */
  @Test
  public void testApplyAdditionalOrderLookupFilter_givenNullOrderImpl2() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    ArrayList<Order> orders = new ArrayList<>();
    orders.add(new NullOrderImpl());
    orders.add(new NullOrderImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractOrderDaoExtensionHandler.applyAdditionalOrderLookupFilter(customer, "Name", orders));
  }

  /**
   * Test
   * {@link AbstractOrderDaoExtensionHandler#applyAdditionalOrderLookupFilter(Customer, String, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractOrderDaoExtensionHandler#applyAdditionalOrderLookupFilter(Customer, String, List)}
   */
  @Test
  public void testApplyAdditionalOrderLookupFilter_whenArrayList() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractOrderDaoExtensionHandler.applyAdditionalOrderLookupFilter(customer, "Name", new ArrayList<>()));
  }

  /**
   * Test
   * {@link AbstractOrderDaoExtensionHandler#applyAdditionalOrderLookupFilter(Customer, String, List)}.
   * <ul>
   *   <li>When {@link CustomerImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractOrderDaoExtensionHandler#applyAdditionalOrderLookupFilter(Customer, String, List)}
   */
  @Test
  public void testApplyAdditionalOrderLookupFilter_whenCustomerImpl() {
    // Arrange
    CustomerImpl customer = mock(CustomerImpl.class);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractOrderDaoExtensionHandler.applyAdditionalOrderLookupFilter(customer, "Name", new ArrayList<>()));
  }

  /**
   * Test new {@link AbstractOrderDaoExtensionHandler} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AbstractOrderDaoExtensionHandler}
   */
  @Test
  public void testNewAbstractOrderDaoExtensionHandler() {
    // Arrange and Act
    AbstractOrderDaoExtensionHandler actualAbstractOrderDaoExtensionHandler = new AbstractOrderDaoExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractOrderDaoExtensionHandler.getPriority());
    assertTrue(actualAbstractOrderDaoExtensionHandler.isEnabled());
  }
}

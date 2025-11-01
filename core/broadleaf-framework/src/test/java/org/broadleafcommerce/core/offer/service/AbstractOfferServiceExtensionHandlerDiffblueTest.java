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
package org.broadleafcommerce.core.offer.service;

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
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferCode;
import org.broadleafcommerce.core.offer.domain.OfferCodeImpl;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
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

@ContextConfiguration(classes = {AbstractOfferServiceExtensionHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractOfferServiceExtensionHandlerDiffblueTest {
  @Autowired
  private AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler;

  /**
   * Method under test:
   * {@link AbstractOfferServiceExtensionHandler#applyAdditionalFilters(List, Order)}
   */
  @Test
  public void testApplyAdditionalFilters() {
    // Arrange
    ArrayList<Offer> offers = new ArrayList<>();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractOfferServiceExtensionHandler.applyAdditionalFilters(offers, new NullOrderImpl()));
  }

  /**
   * Method under test:
   * {@link AbstractOfferServiceExtensionHandler#applyAdditionalFilters(List, Order)}
   */
  @Test
  public void testApplyAdditionalFilters2() {
    // Arrange
    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractOfferServiceExtensionHandler.applyAdditionalFilters(offers, new NullOrderImpl()));
  }

  /**
   * Method under test:
   * {@link AbstractOfferServiceExtensionHandler#applyAdditionalFilters(List, Order)}
   */
  @Test
  public void testApplyAdditionalFilters3() {
    // Arrange
    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());
    offers.add(new OfferImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractOfferServiceExtensionHandler.applyAdditionalFilters(offers, new NullOrderImpl()));
  }

  /**
   * Method under test:
   * {@link AbstractOfferServiceExtensionHandler#applyAdditionalFilters(List, Order)}
   */
  @Test
  public void testApplyAdditionalFilters4() {
    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractOfferServiceExtensionHandler.applyAdditionalFilters(new ArrayList<>(), mock(NullOrderImpl.class)));
  }

  /**
   * Method under test:
   * {@link AbstractOfferServiceExtensionHandler#buildOfferCodeListForCustomer(Customer, List)}
   */
  @Test
  public void testBuildOfferCodeListForCustomer() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractOfferServiceExtensionHandler.buildOfferCodeListForCustomer(customer, new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link AbstractOfferServiceExtensionHandler#buildOfferCodeListForCustomer(Customer, List)}
   */
  @Test
  public void testBuildOfferCodeListForCustomer2() {
    // Arrange
    CustomerImpl customer = mock(CustomerImpl.class);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractOfferServiceExtensionHandler.buildOfferCodeListForCustomer(customer, new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link AbstractOfferServiceExtensionHandler#buildOfferCodeListForCustomer(Customer, List)}
   */
  @Test
  public void testBuildOfferCodeListForCustomer3() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    ArrayList<OfferCode> offerCodes = new ArrayList<>();
    offerCodes.add(new OfferCodeImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractOfferServiceExtensionHandler.buildOfferCodeListForCustomer(customer, offerCodes));
  }

  /**
   * Method under test:
   * {@link AbstractOfferServiceExtensionHandler#buildOfferCodeListForCustomer(Customer, List)}
   */
  @Test
  public void testBuildOfferCodeListForCustomer4() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();

    ArrayList<OfferCode> offerCodes = new ArrayList<>();
    offerCodes.add(new OfferCodeImpl());
    offerCodes.add(new OfferCodeImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractOfferServiceExtensionHandler.buildOfferCodeListForCustomer(customer, offerCodes));
  }

  /**
   * Method under test:
   * {@link AbstractOfferServiceExtensionHandler#addAdditionalOffersForCode(List, OfferCode)}
   */
  @Test
  public void testAddAdditionalOffersForCode() {
    // Arrange
    ArrayList<Offer> offers = new ArrayList<>();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractOfferServiceExtensionHandler.addAdditionalOffersForCode(offers, new OfferCodeImpl()));
  }

  /**
   * Method under test:
   * {@link AbstractOfferServiceExtensionHandler#addAdditionalOffersForCode(List, OfferCode)}
   */
  @Test
  public void testAddAdditionalOffersForCode2() {
    // Arrange
    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractOfferServiceExtensionHandler.addAdditionalOffersForCode(offers, new OfferCodeImpl()));
  }

  /**
   * Method under test:
   * {@link AbstractOfferServiceExtensionHandler#addAdditionalOffersForCode(List, OfferCode)}
   */
  @Test
  public void testAddAdditionalOffersForCode3() {
    // Arrange
    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());
    offers.add(new OfferImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractOfferServiceExtensionHandler.addAdditionalOffersForCode(offers, new OfferCodeImpl()));
  }

  /**
   * Method under test:
   * {@link AbstractOfferServiceExtensionHandler#addAdditionalOffersForCode(List, OfferCode)}
   */
  @Test
  public void testAddAdditionalOffersForCode4() {
    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractOfferServiceExtensionHandler.addAdditionalOffersForCode(new ArrayList<>(), mock(OfferCodeImpl.class)));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link AbstractOfferServiceExtensionHandler}
   */
  @Test
  public void testNewAbstractOfferServiceExtensionHandler() {
    // Arrange and Act
    AbstractOfferServiceExtensionHandler actualAbstractOfferServiceExtensionHandler = new AbstractOfferServiceExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractOfferServiceExtensionHandler.getPriority());
    assertTrue(actualAbstractOfferServiceExtensionHandler.isEnabled());
  }

  /**
   * Method under test:
   * {@link AbstractOfferServiceExtensionHandler#removeOfferCodeFromOrder(OfferCode, Order)}
   */
  @Test
  public void testRemoveOfferCodeFromOrder() {
    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler = new AbstractOfferServiceExtensionHandler();
    OfferCodeImpl offerCode = new OfferCodeImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractOfferServiceExtensionHandler.removeOfferCodeFromOrder(offerCode, new NullOrderImpl()));
  }

  /**
   * Method under test:
   * {@link AbstractOfferServiceExtensionHandler#removeOfferCodeFromOrder(OfferCode, Order)}
   */
  @Test
  public void testRemoveOfferCodeFromOrder2() {
    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler = new AbstractOfferServiceExtensionHandler();
    OfferCodeImpl offerCode = new OfferCodeImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(mock(java.sql.Date.class));
    auditable.setDateUpdated(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order
        .setSubmitDate(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractOfferServiceExtensionHandler.removeOfferCodeFromOrder(offerCode, order));
  }
}

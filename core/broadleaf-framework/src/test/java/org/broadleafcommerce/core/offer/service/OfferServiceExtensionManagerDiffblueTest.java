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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferCode;
import org.broadleafcommerce.core.offer.domain.OfferCodeImpl;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class OfferServiceExtensionManagerDiffblueTest {
  /**
   * Method under test:
   * {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}
   */
  @Test
  public void testApplyAdditionalFilters() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    ArrayList<Offer> offers = new ArrayList<>();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.applyAdditionalFilters(offers, new NullOrderImpl()));
  }

  /**
   * Method under test:
   * {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}
   */
  @Test
  public void testApplyAdditionalFilters2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    ArrayList<Offer> offers2 = new ArrayList<>();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.applyAdditionalFilters(offers2, new NullOrderImpl()));
  }

  /**
   * Method under test:
   * {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}
   */
  @Test
  public void testApplyAdditionalFilters3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(new AbstractOfferServiceExtensionHandler());
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    ArrayList<Offer> offers2 = new ArrayList<>();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.applyAdditionalFilters(offers2, new NullOrderImpl()));
  }

  /**
   * Method under test:
   * {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}
   */
  @Test
  public void testApplyAdditionalFilters4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.applyAdditionalFilters(offers, new NullOrderImpl()));
  }

  /**
   * Method under test:
   * {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}
   */
  @Test
  public void testApplyAdditionalFilters5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());
    offers.add(new OfferImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.applyAdditionalFilters(offers, new NullOrderImpl()));
  }

  /**
   * Method under test:
   * {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}
   */
  @Test
  public void testApplyAdditionalFilters6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.applyAdditionalFilters(new ArrayList<>(), mock(NullOrderImpl.class)));
  }

  /**
   * Method under test:
   * {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}
   */
  @Test
  public void testApplyAdditionalFilters7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(new OfferServiceExtensionManager());
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    ArrayList<Offer> offers2 = new ArrayList<>();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.applyAdditionalFilters(offers2, new NullOrderImpl()));
  }

  /**
   * Method under test:
   * {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}
   */
  @Test
  public void testApplyAdditionalFilters8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler = mock(
        AbstractOfferServiceExtensionHandler.class);
    when(abstractOfferServiceExtensionHandler.addAdditionalOffersForCode(Mockito.<List<Offer>>any(),
        Mockito.<OfferCode>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractOfferServiceExtensionHandler.applyAdditionalFilters(Mockito.<List<Offer>>any(), Mockito.<Order>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractOfferServiceExtensionHandler.isEnabled()).thenReturn(true);

    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(abstractOfferServiceExtensionHandler);
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    ArrayList<Offer> offers2 = new ArrayList<>();

    // Act
    ExtensionResultStatusType actualApplyAdditionalFiltersResult = offerServiceExtensionManager
        .applyAdditionalFilters(offers2, new NullOrderImpl());

    // Assert
    verify(abstractOfferServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(abstractOfferServiceExtensionHandler).addAdditionalOffersForCode(isA(List.class), isA(OfferCode.class));
    verify(abstractOfferServiceExtensionHandler).applyAdditionalFilters(isA(List.class), isA(Order.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualApplyAdditionalFiltersResult);
  }

  /**
   * Method under test:
   * {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}
   */
  @Test
  public void testApplyAdditionalFilters9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler = mock(
        AbstractOfferServiceExtensionHandler.class);
    when(abstractOfferServiceExtensionHandler.addAdditionalOffersForCode(Mockito.<List<Offer>>any(),
        Mockito.<OfferCode>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractOfferServiceExtensionHandler.applyAdditionalFilters(Mockito.<List<Offer>>any(), Mockito.<Order>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(abstractOfferServiceExtensionHandler.isEnabled()).thenReturn(true);

    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(abstractOfferServiceExtensionHandler);
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    ArrayList<Offer> offers2 = new ArrayList<>();

    // Act
    ExtensionResultStatusType actualApplyAdditionalFiltersResult = offerServiceExtensionManager
        .applyAdditionalFilters(offers2, new NullOrderImpl());

    // Assert
    verify(abstractOfferServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(abstractOfferServiceExtensionHandler).addAdditionalOffersForCode(isA(List.class), isA(OfferCode.class));
    verify(abstractOfferServiceExtensionHandler).applyAdditionalFilters(isA(List.class), isA(Order.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualApplyAdditionalFiltersResult);
  }

  /**
   * Method under test:
   * {@link OfferServiceExtensionManager#applyAdditionalFilters(List, Order)}
   */
  @Test
  public void testApplyAdditionalFilters10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler = mock(
        AbstractOfferServiceExtensionHandler.class);
    when(abstractOfferServiceExtensionHandler.isEnabled()).thenReturn(false);

    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(abstractOfferServiceExtensionHandler);
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    ArrayList<Offer> offers2 = new ArrayList<>();

    // Act
    ExtensionResultStatusType actualApplyAdditionalFiltersResult = offerServiceExtensionManager
        .applyAdditionalFilters(offers2, new NullOrderImpl());

    // Assert
    verify(abstractOfferServiceExtensionHandler, atLeast(1)).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualApplyAdditionalFiltersResult);
  }

  /**
   * Method under test:
   * {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}
   */
  @Test
  public void testBuildOfferCodeListForCustomer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.buildOfferCodeListForCustomer(customer, new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}
   */
  @Test
  public void testBuildOfferCodeListForCustomer2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.buildOfferCodeListForCustomer(customer, new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}
   */
  @Test
  public void testBuildOfferCodeListForCustomer3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(new AbstractOfferServiceExtensionHandler());
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.buildOfferCodeListForCustomer(customer, new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}
   */
  @Test
  public void testBuildOfferCodeListForCustomer4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    CustomerImpl customer = mock(CustomerImpl.class);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.buildOfferCodeListForCustomer(customer, new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}
   */
  @Test
  public void testBuildOfferCodeListForCustomer5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    CustomerImpl customer = new CustomerImpl();

    ArrayList<OfferCode> offerCodes = new ArrayList<>();
    offerCodes.add(new OfferCodeImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.buildOfferCodeListForCustomer(customer, offerCodes));
  }

  /**
   * Method under test:
   * {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}
   */
  @Test
  public void testBuildOfferCodeListForCustomer6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    CustomerImpl customer = new CustomerImpl();

    ArrayList<OfferCode> offerCodes = new ArrayList<>();
    offerCodes.add(new OfferCodeImpl());
    offerCodes.add(new OfferCodeImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.buildOfferCodeListForCustomer(customer, offerCodes));
  }

  /**
   * Method under test:
   * {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}
   */
  @Test
  public void testBuildOfferCodeListForCustomer7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(new OfferServiceExtensionManager());
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.buildOfferCodeListForCustomer(customer, new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}
   */
  @Test
  public void testBuildOfferCodeListForCustomer8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler = mock(
        AbstractOfferServiceExtensionHandler.class);
    when(abstractOfferServiceExtensionHandler.addAdditionalOffersForCode(Mockito.<List<Offer>>any(),
        Mockito.<OfferCode>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractOfferServiceExtensionHandler.buildOfferCodeListForCustomer(Mockito.<Customer>any(),
        Mockito.<List<OfferCode>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractOfferServiceExtensionHandler.isEnabled()).thenReturn(true);

    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(abstractOfferServiceExtensionHandler);
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    CustomerImpl customer = new CustomerImpl();

    // Act
    ExtensionResultStatusType actualBuildOfferCodeListForCustomerResult = offerServiceExtensionManager
        .buildOfferCodeListForCustomer(customer, new ArrayList<>());

    // Assert
    verify(abstractOfferServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(abstractOfferServiceExtensionHandler).addAdditionalOffersForCode(isA(List.class), isA(OfferCode.class));
    verify(abstractOfferServiceExtensionHandler).buildOfferCodeListForCustomer(isA(Customer.class), isA(List.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualBuildOfferCodeListForCustomerResult);
  }

  /**
   * Method under test:
   * {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}
   */
  @Test
  public void testBuildOfferCodeListForCustomer9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler = mock(
        AbstractOfferServiceExtensionHandler.class);
    when(abstractOfferServiceExtensionHandler.addAdditionalOffersForCode(Mockito.<List<Offer>>any(),
        Mockito.<OfferCode>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractOfferServiceExtensionHandler.buildOfferCodeListForCustomer(Mockito.<Customer>any(),
        Mockito.<List<OfferCode>>any())).thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(abstractOfferServiceExtensionHandler.isEnabled()).thenReturn(true);

    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(abstractOfferServiceExtensionHandler);
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    CustomerImpl customer = new CustomerImpl();

    // Act
    ExtensionResultStatusType actualBuildOfferCodeListForCustomerResult = offerServiceExtensionManager
        .buildOfferCodeListForCustomer(customer, new ArrayList<>());

    // Assert
    verify(abstractOfferServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(abstractOfferServiceExtensionHandler).addAdditionalOffersForCode(isA(List.class), isA(OfferCode.class));
    verify(abstractOfferServiceExtensionHandler).buildOfferCodeListForCustomer(isA(Customer.class), isA(List.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualBuildOfferCodeListForCustomerResult);
  }

  /**
   * Method under test:
   * {@link OfferServiceExtensionManager#buildOfferCodeListForCustomer(Customer, List)}
   */
  @Test
  public void testBuildOfferCodeListForCustomer10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler = mock(
        AbstractOfferServiceExtensionHandler.class);
    when(abstractOfferServiceExtensionHandler.isEnabled()).thenReturn(false);

    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(abstractOfferServiceExtensionHandler);
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    CustomerImpl customer = new CustomerImpl();

    // Act
    ExtensionResultStatusType actualBuildOfferCodeListForCustomerResult = offerServiceExtensionManager
        .buildOfferCodeListForCustomer(customer, new ArrayList<>());

    // Assert
    verify(abstractOfferServiceExtensionHandler, atLeast(1)).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualBuildOfferCodeListForCustomerResult);
  }

  /**
   * Method under test:
   * {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List, OfferCode)}
   */
  @Test
  public void testAddAdditionalOffersForCode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    ArrayList<Offer> offers = new ArrayList<>();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl()));
  }

  /**
   * Method under test:
   * {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List, OfferCode)}
   */
  @Test
  public void testAddAdditionalOffersForCode2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    ArrayList<Offer> offers2 = new ArrayList<>();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.addAdditionalOffersForCode(offers2, new OfferCodeImpl()));
  }

  /**
   * Method under test:
   * {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List, OfferCode)}
   */
  @Test
  public void testAddAdditionalOffersForCode3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(new AbstractOfferServiceExtensionHandler());
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    ArrayList<Offer> offers2 = new ArrayList<>();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.addAdditionalOffersForCode(offers2, new OfferCodeImpl()));
  }

  /**
   * Method under test:
   * {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List, OfferCode)}
   */
  @Test
  public void testAddAdditionalOffersForCode4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl()));
  }

  /**
   * Method under test:
   * {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List, OfferCode)}
   */
  @Test
  public void testAddAdditionalOffersForCode5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();

    ArrayList<Offer> offers = new ArrayList<>();
    offers.add(new OfferImpl());
    offers.add(new OfferImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl()));
  }

  /**
   * Method under test:
   * {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List, OfferCode)}
   */
  @Test
  public void testAddAdditionalOffersForCode6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.addAdditionalOffersForCode(new ArrayList<>(), mock(OfferCodeImpl.class)));
  }

  /**
   * Method under test:
   * {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List, OfferCode)}
   */
  @Test
  public void testAddAdditionalOffersForCode7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(new OfferServiceExtensionManager());
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    ArrayList<Offer> offers2 = new ArrayList<>();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.addAdditionalOffersForCode(offers2, new OfferCodeImpl()));
  }

  /**
   * Method under test:
   * {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List, OfferCode)}
   */
  @Test
  public void testAddAdditionalOffersForCode8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler = mock(
        AbstractOfferServiceExtensionHandler.class);
    when(abstractOfferServiceExtensionHandler.addAdditionalOffersForCode(Mockito.<List<Offer>>any(),
        Mockito.<OfferCode>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractOfferServiceExtensionHandler.isEnabled()).thenReturn(true);

    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(abstractOfferServiceExtensionHandler);
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    ArrayList<Offer> offers2 = new ArrayList<>();

    // Act
    ExtensionResultStatusType actualAddAdditionalOffersForCodeResult = offerServiceExtensionManager
        .addAdditionalOffersForCode(offers2, new OfferCodeImpl());

    // Assert
    verify(abstractOfferServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(abstractOfferServiceExtensionHandler, atLeast(1)).addAdditionalOffersForCode(isA(List.class),
        isA(OfferCode.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualAddAdditionalOffersForCodeResult);
  }

  /**
   * Method under test:
   * {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List, OfferCode)}
   */
  @Test
  public void testAddAdditionalOffersForCode9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler = mock(
        AbstractOfferServiceExtensionHandler.class);
    when(abstractOfferServiceExtensionHandler.addAdditionalOffersForCode(Mockito.<List<Offer>>any(),
        Mockito.<OfferCode>any())).thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(abstractOfferServiceExtensionHandler.isEnabled()).thenReturn(true);

    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(abstractOfferServiceExtensionHandler);
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    ArrayList<Offer> offers2 = new ArrayList<>();

    // Act
    ExtensionResultStatusType actualAddAdditionalOffersForCodeResult = offerServiceExtensionManager
        .addAdditionalOffersForCode(offers2, new OfferCodeImpl());

    // Assert
    verify(abstractOfferServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(abstractOfferServiceExtensionHandler, atLeast(1)).addAdditionalOffersForCode(isA(List.class),
        isA(OfferCode.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualAddAdditionalOffersForCodeResult);
  }

  /**
   * Method under test:
   * {@link OfferServiceExtensionManager#addAdditionalOffersForCode(List, OfferCode)}
   */
  @Test
  public void testAddAdditionalOffersForCode10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler = mock(
        AbstractOfferServiceExtensionHandler.class);
    when(abstractOfferServiceExtensionHandler.isEnabled()).thenReturn(false);

    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(abstractOfferServiceExtensionHandler);
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    ArrayList<Offer> offers2 = new ArrayList<>();

    // Act
    ExtensionResultStatusType actualAddAdditionalOffersForCodeResult = offerServiceExtensionManager
        .addAdditionalOffersForCode(offers2, new OfferCodeImpl());

    // Assert
    verify(abstractOfferServiceExtensionHandler, atLeast(1)).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualAddAdditionalOffersForCodeResult);
  }

  /**
   * Method under test:
   * {@link OfferServiceExtensionManager#removeOfferCodeFromOrder(OfferCode, Order)}
   */
  @Test
  public void testRemoveOfferCodeFromOrder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    OfferCodeImpl offerCode = new OfferCodeImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.removeOfferCodeFromOrder(offerCode, new NullOrderImpl()));
  }

  /**
   * Method under test:
   * {@link OfferServiceExtensionManager#removeOfferCodeFromOrder(OfferCode, Order)}
   */
  @Test
  public void testRemoveOfferCodeFromOrder2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    OfferCodeImpl offerCode = new OfferCodeImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.removeOfferCodeFromOrder(offerCode, new NullOrderImpl()));
  }

  /**
   * Method under test:
   * {@link OfferServiceExtensionManager#removeOfferCodeFromOrder(OfferCode, Order)}
   */
  @Test
  public void testRemoveOfferCodeFromOrder3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(new AbstractOfferServiceExtensionHandler());
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    OfferCodeImpl offerCode = new OfferCodeImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.removeOfferCodeFromOrder(offerCode, new NullOrderImpl()));
  }

  /**
   * Method under test:
   * {@link OfferServiceExtensionManager#removeOfferCodeFromOrder(OfferCode, Order)}
   */
  @Test
  public void testRemoveOfferCodeFromOrder4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    OfferCodeImpl offerCode = mock(OfferCodeImpl.class);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.removeOfferCodeFromOrder(offerCode, new NullOrderImpl()));
  }

  /**
   * Method under test:
   * {@link OfferServiceExtensionManager#removeOfferCodeFromOrder(OfferCode, Order)}
   */
  @Test
  public void testRemoveOfferCodeFromOrder5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(new OfferServiceExtensionManager());
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    OfferCodeImpl offerCode = new OfferCodeImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        offerServiceExtensionManager.removeOfferCodeFromOrder(offerCode, new NullOrderImpl()));
  }

  /**
   * Method under test:
   * {@link OfferServiceExtensionManager#removeOfferCodeFromOrder(OfferCode, Order)}
   */
  @Test
  public void testRemoveOfferCodeFromOrder6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler = mock(
        AbstractOfferServiceExtensionHandler.class);
    when(abstractOfferServiceExtensionHandler.addAdditionalOffersForCode(Mockito.<List<Offer>>any(),
        Mockito.<OfferCode>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractOfferServiceExtensionHandler.removeOfferCodeFromOrder(Mockito.<OfferCode>any(), Mockito.<Order>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractOfferServiceExtensionHandler.isEnabled()).thenReturn(true);

    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(abstractOfferServiceExtensionHandler);
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    OfferCodeImpl offerCode = new OfferCodeImpl();

    // Act
    ExtensionResultStatusType actualRemoveOfferCodeFromOrderResult = offerServiceExtensionManager
        .removeOfferCodeFromOrder(offerCode, new NullOrderImpl());

    // Assert
    verify(abstractOfferServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(abstractOfferServiceExtensionHandler).addAdditionalOffersForCode(isA(List.class), isA(OfferCode.class));
    verify(abstractOfferServiceExtensionHandler).removeOfferCodeFromOrder(isA(OfferCode.class), isA(Order.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualRemoveOfferCodeFromOrderResult);
  }

  /**
   * Method under test:
   * {@link OfferServiceExtensionManager#removeOfferCodeFromOrder(OfferCode, Order)}
   */
  @Test
  public void testRemoveOfferCodeFromOrder7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler = mock(
        AbstractOfferServiceExtensionHandler.class);
    when(abstractOfferServiceExtensionHandler.addAdditionalOffersForCode(Mockito.<List<Offer>>any(),
        Mockito.<OfferCode>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractOfferServiceExtensionHandler.removeOfferCodeFromOrder(Mockito.<OfferCode>any(), Mockito.<Order>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(abstractOfferServiceExtensionHandler.isEnabled()).thenReturn(true);

    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(abstractOfferServiceExtensionHandler);
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    OfferCodeImpl offerCode = new OfferCodeImpl();

    // Act
    ExtensionResultStatusType actualRemoveOfferCodeFromOrderResult = offerServiceExtensionManager
        .removeOfferCodeFromOrder(offerCode, new NullOrderImpl());

    // Assert
    verify(abstractOfferServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(abstractOfferServiceExtensionHandler).addAdditionalOffersForCode(isA(List.class), isA(OfferCode.class));
    verify(abstractOfferServiceExtensionHandler).removeOfferCodeFromOrder(isA(OfferCode.class), isA(Order.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualRemoveOfferCodeFromOrderResult);
  }

  /**
   * Method under test:
   * {@link OfferServiceExtensionManager#removeOfferCodeFromOrder(OfferCode, Order)}
   */
  @Test
  public void testRemoveOfferCodeFromOrder8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AbstractOfferServiceExtensionHandler abstractOfferServiceExtensionHandler = mock(
        AbstractOfferServiceExtensionHandler.class);
    when(abstractOfferServiceExtensionHandler.isEnabled()).thenReturn(false);

    OfferServiceExtensionManager offerServiceExtensionManager = new OfferServiceExtensionManager();
    offerServiceExtensionManager.registerHandler(abstractOfferServiceExtensionHandler);
    ArrayList<Offer> offers = new ArrayList<>();
    offerServiceExtensionManager.addAdditionalOffersForCode(offers, new OfferCodeImpl());
    OfferCodeImpl offerCode = new OfferCodeImpl();

    // Act
    ExtensionResultStatusType actualRemoveOfferCodeFromOrderResult = offerServiceExtensionManager
        .removeOfferCodeFromOrder(offerCode, new NullOrderImpl());

    // Assert
    verify(abstractOfferServiceExtensionHandler, atLeast(1)).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualRemoveOfferCodeFromOrderResult);
  }

  /**
   * Method under test: {@link OfferServiceExtensionManager#isEnabled()}
   */
  @Test
  public void testIsEnabled() {
    // Arrange, Act and Assert
    assertTrue((new OfferServiceExtensionManager()).isEnabled());
  }
}

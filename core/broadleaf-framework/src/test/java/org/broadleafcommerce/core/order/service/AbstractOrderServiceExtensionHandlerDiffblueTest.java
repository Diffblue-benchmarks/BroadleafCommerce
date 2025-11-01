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
package org.broadleafcommerce.core.order.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.OfferCode;
import org.broadleafcommerce.core.offer.domain.OfferCodeImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;

public class AbstractOrderServiceExtensionHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link AbstractOrderServiceExtensionHandler#attachAdditionalDataToNewNamedCart(Customer, Order)}
   */
  @Test
  public void testAttachAdditionalDataToNewNamedCart() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = new CartMessageOrderItemServiceExtensionHandler();
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        cartMessageOrderItemServiceExtensionHandler.attachAdditionalDataToNewNamedCart(customer, new NullOrderImpl()));
  }

  /**
   * Method under test:
   * {@link AbstractOrderServiceExtensionHandler#attachAdditionalDataToNewNamedCart(Customer, Order)}
   */
  @Test
  public void testAttachAdditionalDataToNewNamedCart2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = new CartMessageOrderItemServiceExtensionHandler();
    CustomerImpl customer = mock(CustomerImpl.class);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        cartMessageOrderItemServiceExtensionHandler.attachAdditionalDataToNewNamedCart(customer, new NullOrderImpl()));
  }

  /**
   * Method under test:
   * {@link AbstractOrderServiceExtensionHandler#preValidateCartOperation(Order, ExtensionResultHolder)}
   */
  @Test
  public void testPreValidateCartOperation() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = new CartMessageOrderItemServiceExtensionHandler();
    NullOrderImpl cart = new NullOrderImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        cartMessageOrderItemServiceExtensionHandler.preValidateCartOperation(cart, erh));
  }

  /**
   * Method under test:
   * {@link AbstractOrderServiceExtensionHandler#preValidateCartOperation(Order, ExtensionResultHolder)}
   */
  @Test
  public void testPreValidateCartOperation2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = new CartMessageOrderItemServiceExtensionHandler();
    NullOrderImpl cart = mock(NullOrderImpl.class);

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        cartMessageOrderItemServiceExtensionHandler.preValidateCartOperation(cart, erh));
  }

  /**
   * Method under test:
   * {@link AbstractOrderServiceExtensionHandler#preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO, ExtensionResultHolder)}
   */
  @Test
  public void testPreValidateUpdateQuantityOperation() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = new CartMessageOrderItemServiceExtensionHandler();
    NullOrderImpl cart = new NullOrderImpl();
    OrderItemRequestDTO dto = new OrderItemRequestDTO();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        cartMessageOrderItemServiceExtensionHandler.preValidateUpdateQuantityOperation(cart, dto, erh));
  }

  /**
   * Method under test:
   * {@link AbstractOrderServiceExtensionHandler#preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO, ExtensionResultHolder)}
   */
  @Test
  public void testPreValidateUpdateQuantityOperation2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = new CartMessageOrderItemServiceExtensionHandler();
    NullOrderImpl cart = mock(NullOrderImpl.class);
    OrderItemRequestDTO dto = new OrderItemRequestDTO();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        cartMessageOrderItemServiceExtensionHandler.preValidateUpdateQuantityOperation(cart, dto, erh));
  }

  /**
   * Method under test:
   * {@link AbstractOrderServiceExtensionHandler#attachAdditionalDataToOrder(Order, boolean)}
   */
  @Test
  public void testAttachAdditionalDataToOrder() {
    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = new CartMessageOrderItemServiceExtensionHandler();

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
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE,
        cartMessageOrderItemServiceExtensionHandler.attachAdditionalDataToOrder(order, true));
  }

  /**
   * Method under test:
   * {@link AbstractOrderServiceExtensionHandler#addOfferCodes(Order, List, boolean)}
   */
  @Test
  public void testAddOfferCodes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = new CartMessageOrderItemServiceExtensionHandler();
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        cartMessageOrderItemServiceExtensionHandler.addOfferCodes(order, new ArrayList<>(), true));
  }

  /**
   * Method under test:
   * {@link AbstractOrderServiceExtensionHandler#addOfferCodes(Order, List, boolean)}
   */
  @Test
  public void testAddOfferCodes2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = new CartMessageOrderItemServiceExtensionHandler();
    NullOrderImpl order = mock(NullOrderImpl.class);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        cartMessageOrderItemServiceExtensionHandler.addOfferCodes(order, new ArrayList<>(), true));
  }

  /**
   * Method under test:
   * {@link AbstractOrderServiceExtensionHandler#addOfferCodes(Order, List, boolean)}
   */
  @Test
  public void testAddOfferCodes3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = new CartMessageOrderItemServiceExtensionHandler();
    NullOrderImpl order = new NullOrderImpl();

    ArrayList<OfferCode> offerCodes = new ArrayList<>();
    offerCodes.add(new OfferCodeImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        cartMessageOrderItemServiceExtensionHandler.addOfferCodes(order, offerCodes, true));
  }

  /**
   * Method under test:
   * {@link AbstractOrderServiceExtensionHandler#addOfferCodes(Order, List, boolean)}
   */
  @Test
  public void testAddOfferCodes4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = new CartMessageOrderItemServiceExtensionHandler();
    NullOrderImpl order = new NullOrderImpl();

    ArrayList<OfferCode> offerCodes = new ArrayList<>();
    offerCodes.add(new OfferCodeImpl());
    offerCodes.add(new OfferCodeImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        cartMessageOrderItemServiceExtensionHandler.addOfferCodes(order, offerCodes, true));
  }

  /**
   * Method under test:
   * {@link AbstractOrderServiceExtensionHandler#findCartForCustomerWithEnhancements(Customer, ExtensionResultHolder)}
   */
  @Test
  public void testFindCartForCustomerWithEnhancements() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = new CartMessageOrderItemServiceExtensionHandler();
    CustomerImpl customer = new CustomerImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        cartMessageOrderItemServiceExtensionHandler.findCartForCustomerWithEnhancements(customer, erh));
  }

  /**
   * Method under test:
   * {@link AbstractOrderServiceExtensionHandler#findCartForCustomerWithEnhancements(Customer, ExtensionResultHolder)}
   */
  @Test
  public void testFindCartForCustomerWithEnhancements2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = new CartMessageOrderItemServiceExtensionHandler();
    CustomerImpl customer = mock(CustomerImpl.class);

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        cartMessageOrderItemServiceExtensionHandler.findCartForCustomerWithEnhancements(customer, erh));
  }

  /**
   * Method under test:
   * {@link AbstractOrderServiceExtensionHandler#findCartForCustomerWithEnhancements(Customer, Order, ExtensionResultHolder)}
   */
  @Test
  public void testFindCartForCustomerWithEnhancements3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = new CartMessageOrderItemServiceExtensionHandler();
    CustomerImpl customer = new CustomerImpl();
    NullOrderImpl candidateCart = new NullOrderImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        cartMessageOrderItemServiceExtensionHandler.findCartForCustomerWithEnhancements(customer, candidateCart, erh));
  }

  /**
   * Method under test:
   * {@link AbstractOrderServiceExtensionHandler#findCartForCustomerWithEnhancements(Customer, Order, ExtensionResultHolder)}
   */
  @Test
  public void testFindCartForCustomerWithEnhancements4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = new CartMessageOrderItemServiceExtensionHandler();
    CustomerImpl customer = mock(CustomerImpl.class);
    NullOrderImpl candidateCart = new NullOrderImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        cartMessageOrderItemServiceExtensionHandler.findCartForCustomerWithEnhancements(customer, candidateCart, erh));
  }
}

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
   * Test
   * {@link AbstractOrderServiceExtensionHandler#attachAdditionalDataToNewNamedCart(Customer, Order)}.
   * <ul>
   *   <li>When {@link CustomerImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractOrderServiceExtensionHandler#attachAdditionalDataToNewNamedCart(Customer, Order)}
   */
  @Test
  public void testAttachAdditionalDataToNewNamedCart_whenCustomerImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = new CartMessageOrderItemServiceExtensionHandler();
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        cartMessageOrderItemServiceExtensionHandler.attachAdditionalDataToNewNamedCart(customer, new NullOrderImpl()));
  }

  /**
   * Test
   * {@link AbstractOrderServiceExtensionHandler#attachAdditionalDataToNewNamedCart(Customer, Order)}.
   * <ul>
   *   <li>When {@link CustomerImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractOrderServiceExtensionHandler#attachAdditionalDataToNewNamedCart(Customer, Order)}
   */
  @Test
  public void testAttachAdditionalDataToNewNamedCart_whenCustomerImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = new CartMessageOrderItemServiceExtensionHandler();
    CustomerImpl customer = mock(CustomerImpl.class);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        cartMessageOrderItemServiceExtensionHandler.attachAdditionalDataToNewNamedCart(customer, new NullOrderImpl()));
  }

  /**
   * Test
   * {@link AbstractOrderServiceExtensionHandler#preValidateCartOperation(Order, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractOrderServiceExtensionHandler#preValidateCartOperation(Order, ExtensionResultHolder)}
   */
  @Test
  public void testPreValidateCartOperation_whenNullOrderImpl() {
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
   * Test
   * {@link AbstractOrderServiceExtensionHandler#preValidateCartOperation(Order, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link NullOrderImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractOrderServiceExtensionHandler#preValidateCartOperation(Order, ExtensionResultHolder)}
   */
  @Test
  public void testPreValidateCartOperation_whenNullOrderImpl2() {
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
   * Test
   * {@link AbstractOrderServiceExtensionHandler#preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractOrderServiceExtensionHandler#preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO, ExtensionResultHolder)}
   */
  @Test
  public void testPreValidateUpdateQuantityOperation_whenNullOrderImpl() {
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
   * Test
   * {@link AbstractOrderServiceExtensionHandler#preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link NullOrderImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractOrderServiceExtensionHandler#preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO, ExtensionResultHolder)}
   */
  @Test
  public void testPreValidateUpdateQuantityOperation_whenNullOrderImpl2() {
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
   * Test
   * {@link AbstractOrderServiceExtensionHandler#attachAdditionalDataToOrder(Order, boolean)}.
   * <ul>
   *   <li>Then return {@code HANDLED_CONTINUE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractOrderServiceExtensionHandler#attachAdditionalDataToOrder(Order, boolean)}
   */
  @Test
  public void testAttachAdditionalDataToOrder_thenReturnHandledContinue() {
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
   * Test
   * {@link AbstractOrderServiceExtensionHandler#addOfferCodes(Order, List, boolean)}.
   * <ul>
   *   <li>Given {@link OfferCodeImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link OfferCodeImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractOrderServiceExtensionHandler#addOfferCodes(Order, List, boolean)}
   */
  @Test
  public void testAddOfferCodes_givenOfferCodeImpl_whenArrayListAddOfferCodeImpl() {
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
   * Test
   * {@link AbstractOrderServiceExtensionHandler#addOfferCodes(Order, List, boolean)}.
   * <ul>
   *   <li>Given {@link OfferCodeImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link OfferCodeImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractOrderServiceExtensionHandler#addOfferCodes(Order, List, boolean)}
   */
  @Test
  public void testAddOfferCodes_givenOfferCodeImpl_whenArrayListAddOfferCodeImpl2() {
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
   * Test
   * {@link AbstractOrderServiceExtensionHandler#addOfferCodes(Order, List, boolean)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractOrderServiceExtensionHandler#addOfferCodes(Order, List, boolean)}
   */
  @Test
  public void testAddOfferCodes_whenArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = new CartMessageOrderItemServiceExtensionHandler();
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        cartMessageOrderItemServiceExtensionHandler.addOfferCodes(order, new ArrayList<>(), true));
  }

  /**
   * Test
   * {@link AbstractOrderServiceExtensionHandler#addOfferCodes(Order, List, boolean)}.
   * <ul>
   *   <li>When {@link NullOrderImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractOrderServiceExtensionHandler#addOfferCodes(Order, List, boolean)}
   */
  @Test
  public void testAddOfferCodes_whenNullOrderImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = new CartMessageOrderItemServiceExtensionHandler();
    NullOrderImpl order = mock(NullOrderImpl.class);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        cartMessageOrderItemServiceExtensionHandler.addOfferCodes(order, new ArrayList<>(), true));
  }

  /**
   * Test
   * {@link AbstractOrderServiceExtensionHandler#findCartForCustomerWithEnhancements(Customer, Order, ExtensionResultHolder)}
   * with {@code customer}, {@code candidateCart}, {@code erh}.
   * <p>
   * Method under test:
   * {@link AbstractOrderServiceExtensionHandler#findCartForCustomerWithEnhancements(Customer, Order, ExtensionResultHolder)}
   */
  @Test
  public void testFindCartForCustomerWithEnhancementsWithCustomerCandidateCartErh() {
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
   * Test
   * {@link AbstractOrderServiceExtensionHandler#findCartForCustomerWithEnhancements(Customer, Order, ExtensionResultHolder)}
   * with {@code customer}, {@code candidateCart}, {@code erh}.
   * <p>
   * Method under test:
   * {@link AbstractOrderServiceExtensionHandler#findCartForCustomerWithEnhancements(Customer, Order, ExtensionResultHolder)}
   */
  @Test
  public void testFindCartForCustomerWithEnhancementsWithCustomerCandidateCartErh2() {
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

  /**
   * Test
   * {@link AbstractOrderServiceExtensionHandler#findCartForCustomerWithEnhancements(Customer, ExtensionResultHolder)}
   * with {@code customer}, {@code erh}.
   * <ul>
   *   <li>When {@link CustomerImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractOrderServiceExtensionHandler#findCartForCustomerWithEnhancements(Customer, ExtensionResultHolder)}
   */
  @Test
  public void testFindCartForCustomerWithEnhancementsWithCustomerErh_whenCustomerImpl() {
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
   * Test
   * {@link AbstractOrderServiceExtensionHandler#findCartForCustomerWithEnhancements(Customer, ExtensionResultHolder)}
   * with {@code customer}, {@code erh}.
   * <ul>
   *   <li>When {@link CustomerImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractOrderServiceExtensionHandler#findCartForCustomerWithEnhancements(Customer, ExtensionResultHolder)}
   */
  @Test
  public void testFindCartForCustomerWithEnhancementsWithCustomerErh_whenCustomerImpl2() {
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
}

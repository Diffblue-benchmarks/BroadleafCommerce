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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.core.offer.domain.OfferCode;
import org.broadleafcommerce.core.offer.domain.OfferCodeImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AbstractOrderServiceExtensionHandlerDiffblueTest {
  /**
   * Test {@link AbstractOrderServiceExtensionHandler#attachAdditionalDataToNewNamedCart(Customer,
   * Order)}.
   *
   * <p>Method under test: {@link
   * AbstractOrderServiceExtensionHandler#attachAdditionalDataToNewNamedCart(Customer, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractOrderServiceExtensionHandler.attachAdditionalDataToNewNamedCart(Customer, Order)"
  })
  public void testAttachAdditionalDataToNewNamedCart() {
    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler =
        new CartMessageOrderItemServiceExtensionHandler();
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        cartMessageOrderItemServiceExtensionHandler.attachAdditionalDataToNewNamedCart(
            customer, new NullOrderImpl()));
  }

  /**
   * Test {@link AbstractOrderServiceExtensionHandler#preValidateCartOperation(Order,
   * ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link
   * AbstractOrderServiceExtensionHandler#preValidateCartOperation(Order, ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractOrderServiceExtensionHandler.preValidateCartOperation(Order, ExtensionResultHolder)"
  })
  public void testPreValidateCartOperation() {
    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler =
        new CartMessageOrderItemServiceExtensionHandler();
    NullOrderImpl cart = new NullOrderImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        cartMessageOrderItemServiceExtensionHandler.preValidateCartOperation(cart, erh));
  }

  /**
   * Test {@link AbstractOrderServiceExtensionHandler#preValidateUpdateQuantityOperation(Order,
   * OrderItemRequestDTO, ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link
   * AbstractOrderServiceExtensionHandler#preValidateUpdateQuantityOperation(Order,
   * OrderItemRequestDTO, ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractOrderServiceExtensionHandler.preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO, ExtensionResultHolder)"
  })
  public void testPreValidateUpdateQuantityOperation() {
    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler =
        new CartMessageOrderItemServiceExtensionHandler();
    NullOrderImpl cart = new NullOrderImpl();
    OrderItemRequestDTO dto = new OrderItemRequestDTO();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        cartMessageOrderItemServiceExtensionHandler.preValidateUpdateQuantityOperation(
            cart, dto, erh));
  }

  /**
   * Test {@link AbstractOrderServiceExtensionHandler#addOfferCodes(Order, List, boolean)}.
   *
   * <ul>
   *   <li>Given {@link OfferCodeImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link OfferCodeImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AbstractOrderServiceExtensionHandler#addOfferCodes(Order, List,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractOrderServiceExtensionHandler.addOfferCodes(Order, List, boolean)"
  })
  public void testAddOfferCodes_givenOfferCodeImpl_whenArrayListAddOfferCodeImpl() {
    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler =
        new CartMessageOrderItemServiceExtensionHandler();
    NullOrderImpl order = new NullOrderImpl();

    ArrayList<OfferCode> offerCodes = new ArrayList<>();
    offerCodes.add(new OfferCodeImpl());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        cartMessageOrderItemServiceExtensionHandler.addOfferCodes(order, offerCodes, true));
  }

  /**
   * Test {@link AbstractOrderServiceExtensionHandler#addOfferCodes(Order, List, boolean)}.
   *
   * <ul>
   *   <li>Given {@link OfferCodeImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link OfferCodeImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AbstractOrderServiceExtensionHandler#addOfferCodes(Order, List,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractOrderServiceExtensionHandler.addOfferCodes(Order, List, boolean)"
  })
  public void testAddOfferCodes_givenOfferCodeImpl_whenArrayListAddOfferCodeImpl2() {
    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler =
        new CartMessageOrderItemServiceExtensionHandler();
    NullOrderImpl order = new NullOrderImpl();

    ArrayList<OfferCode> offerCodes = new ArrayList<>();
    offerCodes.add(new OfferCodeImpl());
    offerCodes.add(new OfferCodeImpl());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        cartMessageOrderItemServiceExtensionHandler.addOfferCodes(order, offerCodes, true));
  }

  /**
   * Test {@link AbstractOrderServiceExtensionHandler#addOfferCodes(Order, List, boolean)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractOrderServiceExtensionHandler#addOfferCodes(Order, List,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractOrderServiceExtensionHandler.addOfferCodes(Order, List, boolean)"
  })
  public void testAddOfferCodes_whenArrayList() {
    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler =
        new CartMessageOrderItemServiceExtensionHandler();
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        cartMessageOrderItemServiceExtensionHandler.addOfferCodes(order, new ArrayList<>(), true));
  }

  /**
   * Test {@link AbstractOrderServiceExtensionHandler#findCartForCustomerWithEnhancements(Customer,
   * Order, ExtensionResultHolder)} with {@code customer}, {@code candidateCart}, {@code erh}.
   *
   * <p>Method under test: {@link
   * AbstractOrderServiceExtensionHandler#findCartForCustomerWithEnhancements(Customer, Order,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractOrderServiceExtensionHandler.findCartForCustomerWithEnhancements(Customer, Order, ExtensionResultHolder)"
  })
  public void testFindCartForCustomerWithEnhancementsWithCustomerCandidateCartErh() {
    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler =
        new CartMessageOrderItemServiceExtensionHandler();
    CustomerImpl customer = new CustomerImpl();
    NullOrderImpl candidateCart = new NullOrderImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        cartMessageOrderItemServiceExtensionHandler.findCartForCustomerWithEnhancements(
            customer, candidateCart, erh));
  }

  /**
   * Test {@link AbstractOrderServiceExtensionHandler#findCartForCustomerWithEnhancements(Customer,
   * ExtensionResultHolder)} with {@code customer}, {@code erh}.
   *
   * <p>Method under test: {@link
   * AbstractOrderServiceExtensionHandler#findCartForCustomerWithEnhancements(Customer,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractOrderServiceExtensionHandler.findCartForCustomerWithEnhancements(Customer, ExtensionResultHolder)"
  })
  public void testFindCartForCustomerWithEnhancementsWithCustomerErh() {
    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler =
        new CartMessageOrderItemServiceExtensionHandler();
    CustomerImpl customer = new CustomerImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        cartMessageOrderItemServiceExtensionHandler.findCartForCustomerWithEnhancements(
            customer, erh));
  }
}

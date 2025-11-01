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
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.mockito.Mockito;

public class OrderServiceExtensionManagerDiffblueTest {
  /**
   * Method under test: {@link OrderServiceExtensionManager#continueOnHandled()}
   */
  @Test
  public void testContinueOnHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new OrderServiceExtensionManager()).continueOnHandled());
  }

  /**
   * Method under test: {@link OrderServiceExtensionManager#continueOnHandled()}
   */
  @Test
  public void testContinueOnHandled2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    NullOrderImpl order = mock(NullOrderImpl.class);
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);

    // Act and Assert
    assertTrue(orderServiceExtensionManager.continueOnHandled());
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#attachAdditionalDataToNewNamedCart(Customer, Order)}
   */
  @Test
  public void testAttachAdditionalDataToNewNamedCart() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.attachAdditionalDataToNewNamedCart(customer, new NullOrderImpl()));
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#attachAdditionalDataToNewNamedCart(Customer, Order)}
   */
  @Test
  public void testAttachAdditionalDataToNewNamedCart2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.attachAdditionalDataToNewNamedCart(customer, new NullOrderImpl()));
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#attachAdditionalDataToNewNamedCart(Customer, Order)}
   */
  @Test
  public void testAttachAdditionalDataToNewNamedCart3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(new CartMessageOrderItemServiceExtensionHandler());
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.attachAdditionalDataToNewNamedCart(customer, new NullOrderImpl()));
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#attachAdditionalDataToNewNamedCart(Customer, Order)}
   */
  @Test
  public void testAttachAdditionalDataToNewNamedCart4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    CustomerImpl customer = mock(CustomerImpl.class);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.attachAdditionalDataToNewNamedCart(customer, new NullOrderImpl()));
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#attachAdditionalDataToNewNamedCart(Customer, Order)}
   */
  @Test
  public void testAttachAdditionalDataToNewNamedCart5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(new OrderServiceExtensionManager());
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.attachAdditionalDataToNewNamedCart(customer, new NullOrderImpl()));
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#attachAdditionalDataToNewNamedCart(Customer, Order)}
   */
  @Test
  public void testAttachAdditionalDataToNewNamedCart6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = mock(
        CartMessageOrderItemServiceExtensionHandler.class);
    when(cartMessageOrderItemServiceExtensionHandler.addOfferCodes(Mockito.<Order>any(), Mockito.<List<OfferCode>>any(),
        anyBoolean())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(cartMessageOrderItemServiceExtensionHandler.attachAdditionalDataToNewNamedCart(Mockito.<Customer>any(),
        Mockito.<Order>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(cartMessageOrderItemServiceExtensionHandler.isEnabled()).thenReturn(true);

    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(cartMessageOrderItemServiceExtensionHandler);
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    CustomerImpl customer = new CustomerImpl();

    // Act
    ExtensionResultStatusType actualAttachAdditionalDataToNewNamedCartResult = orderServiceExtensionManager
        .attachAdditionalDataToNewNamedCart(customer, new NullOrderImpl());

    // Assert
    verify(cartMessageOrderItemServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(cartMessageOrderItemServiceExtensionHandler).addOfferCodes(isA(Order.class), isA(List.class), eq(true));
    verify(cartMessageOrderItemServiceExtensionHandler).attachAdditionalDataToNewNamedCart(isA(Customer.class),
        isA(Order.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualAttachAdditionalDataToNewNamedCartResult);
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#attachAdditionalDataToNewNamedCart(Customer, Order)}
   */
  @Test
  public void testAttachAdditionalDataToNewNamedCart7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = mock(
        CartMessageOrderItemServiceExtensionHandler.class);
    when(cartMessageOrderItemServiceExtensionHandler.addOfferCodes(Mockito.<Order>any(), Mockito.<List<OfferCode>>any(),
        anyBoolean())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(cartMessageOrderItemServiceExtensionHandler.attachAdditionalDataToNewNamedCart(Mockito.<Customer>any(),
        Mockito.<Order>any())).thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(cartMessageOrderItemServiceExtensionHandler.isEnabled()).thenReturn(true);

    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(cartMessageOrderItemServiceExtensionHandler);
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    CustomerImpl customer = new CustomerImpl();

    // Act
    ExtensionResultStatusType actualAttachAdditionalDataToNewNamedCartResult = orderServiceExtensionManager
        .attachAdditionalDataToNewNamedCart(customer, new NullOrderImpl());

    // Assert
    verify(cartMessageOrderItemServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(cartMessageOrderItemServiceExtensionHandler).addOfferCodes(isA(Order.class), isA(List.class), eq(true));
    verify(cartMessageOrderItemServiceExtensionHandler).attachAdditionalDataToNewNamedCart(isA(Customer.class),
        isA(Order.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualAttachAdditionalDataToNewNamedCartResult);
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#attachAdditionalDataToNewNamedCart(Customer, Order)}
   */
  @Test
  public void testAttachAdditionalDataToNewNamedCart8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = mock(
        CartMessageOrderItemServiceExtensionHandler.class);
    when(cartMessageOrderItemServiceExtensionHandler.isEnabled()).thenReturn(false);

    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(cartMessageOrderItemServiceExtensionHandler);
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    CustomerImpl customer = new CustomerImpl();

    // Act
    ExtensionResultStatusType actualAttachAdditionalDataToNewNamedCartResult = orderServiceExtensionManager
        .attachAdditionalDataToNewNamedCart(customer, new NullOrderImpl());

    // Assert
    verify(cartMessageOrderItemServiceExtensionHandler, atLeast(1)).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualAttachAdditionalDataToNewNamedCartResult);
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#preValidateCartOperation(Order, ExtensionResultHolder)}
   */
  @Test
  public void testPreValidateCartOperation() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    NullOrderImpl cart = new NullOrderImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.preValidateCartOperation(cart, erh));
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#preValidateCartOperation(Order, ExtensionResultHolder)}
   */
  @Test
  public void testPreValidateCartOperation2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    NullOrderImpl cart = new NullOrderImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.preValidateCartOperation(cart, erh));
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#preValidateCartOperation(Order, ExtensionResultHolder)}
   */
  @Test
  public void testPreValidateCartOperation3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(new CartMessageOrderItemServiceExtensionHandler());
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    NullOrderImpl cart = new NullOrderImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.preValidateCartOperation(cart, erh));
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#preValidateCartOperation(Order, ExtensionResultHolder)}
   */
  @Test
  public void testPreValidateCartOperation4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    NullOrderImpl cart = mock(NullOrderImpl.class);

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.preValidateCartOperation(cart, erh));
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#preValidateCartOperation(Order, ExtensionResultHolder)}
   */
  @Test
  public void testPreValidateCartOperation5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(new OrderServiceExtensionManager());
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    NullOrderImpl cart = new NullOrderImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.preValidateCartOperation(cart, erh));
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#preValidateCartOperation(Order, ExtensionResultHolder)}
   */
  @Test
  public void testPreValidateCartOperation6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = mock(
        CartMessageOrderItemServiceExtensionHandler.class);
    when(cartMessageOrderItemServiceExtensionHandler.addOfferCodes(Mockito.<Order>any(), Mockito.<List<OfferCode>>any(),
        anyBoolean())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(cartMessageOrderItemServiceExtensionHandler.preValidateCartOperation(Mockito.<Order>any(),
        Mockito.<ExtensionResultHolder<Object>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(cartMessageOrderItemServiceExtensionHandler.isEnabled()).thenReturn(true);

    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(cartMessageOrderItemServiceExtensionHandler);
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    NullOrderImpl cart = new NullOrderImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualPreValidateCartOperationResult = orderServiceExtensionManager
        .preValidateCartOperation(cart, erh);

    // Assert
    verify(cartMessageOrderItemServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(cartMessageOrderItemServiceExtensionHandler).addOfferCodes(isA(Order.class), isA(List.class), eq(true));
    verify(cartMessageOrderItemServiceExtensionHandler).preValidateCartOperation(isA(Order.class),
        isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualPreValidateCartOperationResult);
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#preValidateCartOperation(Order, ExtensionResultHolder)}
   */
  @Test
  public void testPreValidateCartOperation7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = mock(
        CartMessageOrderItemServiceExtensionHandler.class);
    when(cartMessageOrderItemServiceExtensionHandler.addOfferCodes(Mockito.<Order>any(), Mockito.<List<OfferCode>>any(),
        anyBoolean())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(cartMessageOrderItemServiceExtensionHandler.preValidateCartOperation(Mockito.<Order>any(),
        Mockito.<ExtensionResultHolder<Object>>any())).thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(cartMessageOrderItemServiceExtensionHandler.isEnabled()).thenReturn(true);

    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(cartMessageOrderItemServiceExtensionHandler);
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    NullOrderImpl cart = new NullOrderImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualPreValidateCartOperationResult = orderServiceExtensionManager
        .preValidateCartOperation(cart, erh);

    // Assert
    verify(cartMessageOrderItemServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(cartMessageOrderItemServiceExtensionHandler).addOfferCodes(isA(Order.class), isA(List.class), eq(true));
    verify(cartMessageOrderItemServiceExtensionHandler).preValidateCartOperation(isA(Order.class),
        isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualPreValidateCartOperationResult);
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#preValidateCartOperation(Order, ExtensionResultHolder)}
   */
  @Test
  public void testPreValidateCartOperation8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = mock(
        CartMessageOrderItemServiceExtensionHandler.class);
    when(cartMessageOrderItemServiceExtensionHandler.isEnabled()).thenReturn(false);

    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(cartMessageOrderItemServiceExtensionHandler);
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    NullOrderImpl cart = new NullOrderImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualPreValidateCartOperationResult = orderServiceExtensionManager
        .preValidateCartOperation(cart, erh);

    // Assert
    verify(cartMessageOrderItemServiceExtensionHandler, atLeast(1)).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualPreValidateCartOperationResult);
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO, ExtensionResultHolder)}
   */
  @Test
  public void testPreValidateUpdateQuantityOperation() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    NullOrderImpl cart = new NullOrderImpl();
    OrderItemRequestDTO dto = new OrderItemRequestDTO();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.preValidateUpdateQuantityOperation(cart, dto, erh));
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO, ExtensionResultHolder)}
   */
  @Test
  public void testPreValidateUpdateQuantityOperation2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    NullOrderImpl cart = new NullOrderImpl();
    OrderItemRequestDTO dto = new OrderItemRequestDTO();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.preValidateUpdateQuantityOperation(cart, dto, erh));
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO, ExtensionResultHolder)}
   */
  @Test
  public void testPreValidateUpdateQuantityOperation3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(new CartMessageOrderItemServiceExtensionHandler());
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    NullOrderImpl cart = new NullOrderImpl();
    OrderItemRequestDTO dto = new OrderItemRequestDTO();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.preValidateUpdateQuantityOperation(cart, dto, erh));
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO, ExtensionResultHolder)}
   */
  @Test
  public void testPreValidateUpdateQuantityOperation4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    NullOrderImpl cart = mock(NullOrderImpl.class);
    OrderItemRequestDTO dto = new OrderItemRequestDTO();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.preValidateUpdateQuantityOperation(cart, dto, erh));
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO, ExtensionResultHolder)}
   */
  @Test
  public void testPreValidateUpdateQuantityOperation5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(new OrderServiceExtensionManager());
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    NullOrderImpl cart = new NullOrderImpl();
    OrderItemRequestDTO dto = new OrderItemRequestDTO();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.preValidateUpdateQuantityOperation(cart, dto, erh));
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO, ExtensionResultHolder)}
   */
  @Test
  public void testPreValidateUpdateQuantityOperation6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = mock(
        CartMessageOrderItemServiceExtensionHandler.class);
    when(cartMessageOrderItemServiceExtensionHandler.addOfferCodes(Mockito.<Order>any(), Mockito.<List<OfferCode>>any(),
        anyBoolean())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(cartMessageOrderItemServiceExtensionHandler.preValidateUpdateQuantityOperation(Mockito.<Order>any(),
        Mockito.<OrderItemRequestDTO>any(), Mockito.<ExtensionResultHolder<Object>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(cartMessageOrderItemServiceExtensionHandler.isEnabled()).thenReturn(true);

    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(cartMessageOrderItemServiceExtensionHandler);
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    NullOrderImpl cart = new NullOrderImpl();
    OrderItemRequestDTO dto = new OrderItemRequestDTO();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualPreValidateUpdateQuantityOperationResult = orderServiceExtensionManager
        .preValidateUpdateQuantityOperation(cart, dto, erh);

    // Assert
    verify(cartMessageOrderItemServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(cartMessageOrderItemServiceExtensionHandler).addOfferCodes(isA(Order.class), isA(List.class), eq(true));
    verify(cartMessageOrderItemServiceExtensionHandler).preValidateUpdateQuantityOperation(isA(Order.class),
        isA(OrderItemRequestDTO.class), isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualPreValidateUpdateQuantityOperationResult);
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO, ExtensionResultHolder)}
   */
  @Test
  public void testPreValidateUpdateQuantityOperation7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = mock(
        CartMessageOrderItemServiceExtensionHandler.class);
    when(cartMessageOrderItemServiceExtensionHandler.addOfferCodes(Mockito.<Order>any(), Mockito.<List<OfferCode>>any(),
        anyBoolean())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(cartMessageOrderItemServiceExtensionHandler.preValidateUpdateQuantityOperation(Mockito.<Order>any(),
        Mockito.<OrderItemRequestDTO>any(), Mockito.<ExtensionResultHolder<Object>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(cartMessageOrderItemServiceExtensionHandler.isEnabled()).thenReturn(true);

    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(cartMessageOrderItemServiceExtensionHandler);
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    NullOrderImpl cart = new NullOrderImpl();
    OrderItemRequestDTO dto = new OrderItemRequestDTO();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualPreValidateUpdateQuantityOperationResult = orderServiceExtensionManager
        .preValidateUpdateQuantityOperation(cart, dto, erh);

    // Assert
    verify(cartMessageOrderItemServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(cartMessageOrderItemServiceExtensionHandler).addOfferCodes(isA(Order.class), isA(List.class), eq(true));
    verify(cartMessageOrderItemServiceExtensionHandler).preValidateUpdateQuantityOperation(isA(Order.class),
        isA(OrderItemRequestDTO.class), isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualPreValidateUpdateQuantityOperationResult);
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#preValidateUpdateQuantityOperation(Order, OrderItemRequestDTO, ExtensionResultHolder)}
   */
  @Test
  public void testPreValidateUpdateQuantityOperation8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = mock(
        CartMessageOrderItemServiceExtensionHandler.class);
    when(cartMessageOrderItemServiceExtensionHandler.isEnabled()).thenReturn(false);

    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(cartMessageOrderItemServiceExtensionHandler);
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    NullOrderImpl cart = new NullOrderImpl();
    OrderItemRequestDTO dto = new OrderItemRequestDTO();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualPreValidateUpdateQuantityOperationResult = orderServiceExtensionManager
        .preValidateUpdateQuantityOperation(cart, dto, erh);

    // Assert
    verify(cartMessageOrderItemServiceExtensionHandler, atLeast(1)).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualPreValidateUpdateQuantityOperationResult);
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#attachAdditionalDataToOrder(Order, boolean)}
   */
  @Test
  public void testAttachAdditionalDataToOrder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.attachAdditionalDataToOrder(new NullOrderImpl(), true));
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#attachAdditionalDataToOrder(Order, boolean)}
   */
  @Test
  public void testAttachAdditionalDataToOrder2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.attachAdditionalDataToOrder(new NullOrderImpl(), true));
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#attachAdditionalDataToOrder(Order, boolean)}
   */
  @Test
  public void testAttachAdditionalDataToOrder3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        (new OrderServiceExtensionManager()).attachAdditionalDataToOrder(mock(NullOrderImpl.class), true));
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#attachAdditionalDataToOrder(Order, boolean)}
   */
  @Test
  public void testAttachAdditionalDataToOrder4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(new OrderServiceExtensionManager());
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.attachAdditionalDataToOrder(new NullOrderImpl(), true));
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#attachAdditionalDataToOrder(Order, boolean)}
   */
  @Test
  public void testAttachAdditionalDataToOrder5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = mock(
        CartMessageOrderItemServiceExtensionHandler.class);
    when(cartMessageOrderItemServiceExtensionHandler.addOfferCodes(Mockito.<Order>any(), Mockito.<List<OfferCode>>any(),
        anyBoolean())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(cartMessageOrderItemServiceExtensionHandler.attachAdditionalDataToOrder(Mockito.<Order>any(), anyBoolean()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(cartMessageOrderItemServiceExtensionHandler.isEnabled()).thenReturn(true);

    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(cartMessageOrderItemServiceExtensionHandler);
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);

    // Act
    ExtensionResultStatusType actualAttachAdditionalDataToOrderResult = orderServiceExtensionManager
        .attachAdditionalDataToOrder(new NullOrderImpl(), true);

    // Assert
    verify(cartMessageOrderItemServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(cartMessageOrderItemServiceExtensionHandler).addOfferCodes(isA(Order.class), isA(List.class), eq(true));
    verify(cartMessageOrderItemServiceExtensionHandler).attachAdditionalDataToOrder(isA(Order.class), eq(true));
    assertEquals(ExtensionResultStatusType.HANDLED, actualAttachAdditionalDataToOrderResult);
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#attachAdditionalDataToOrder(Order, boolean)}
   */
  @Test
  public void testAttachAdditionalDataToOrder6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = mock(
        CartMessageOrderItemServiceExtensionHandler.class);
    when(cartMessageOrderItemServiceExtensionHandler.addOfferCodes(Mockito.<Order>any(), Mockito.<List<OfferCode>>any(),
        anyBoolean())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(cartMessageOrderItemServiceExtensionHandler.attachAdditionalDataToOrder(Mockito.<Order>any(), anyBoolean()))
        .thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(cartMessageOrderItemServiceExtensionHandler.isEnabled()).thenReturn(true);

    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(cartMessageOrderItemServiceExtensionHandler);
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);

    // Act
    ExtensionResultStatusType actualAttachAdditionalDataToOrderResult = orderServiceExtensionManager
        .attachAdditionalDataToOrder(new NullOrderImpl(), true);

    // Assert
    verify(cartMessageOrderItemServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(cartMessageOrderItemServiceExtensionHandler).addOfferCodes(isA(Order.class), isA(List.class), eq(true));
    verify(cartMessageOrderItemServiceExtensionHandler).attachAdditionalDataToOrder(isA(Order.class), eq(true));
    assertEquals(ExtensionResultStatusType.HANDLED, actualAttachAdditionalDataToOrderResult);
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#attachAdditionalDataToOrder(Order, boolean)}
   */
  @Test
  public void testAttachAdditionalDataToOrder7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = mock(
        CartMessageOrderItemServiceExtensionHandler.class);
    when(cartMessageOrderItemServiceExtensionHandler.isEnabled()).thenReturn(false);

    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(cartMessageOrderItemServiceExtensionHandler);
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);

    // Act
    ExtensionResultStatusType actualAttachAdditionalDataToOrderResult = orderServiceExtensionManager
        .attachAdditionalDataToOrder(new NullOrderImpl(), true);

    // Assert
    verify(cartMessageOrderItemServiceExtensionHandler, atLeast(1)).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualAttachAdditionalDataToOrderResult);
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#addOfferCodes(Order, List, boolean)}
   */
  @Test
  public void testAddOfferCodes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true));
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#addOfferCodes(Order, List, boolean)}
   */
  @Test
  public void testAddOfferCodes2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    NullOrderImpl order2 = new NullOrderImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.addOfferCodes(order2, new ArrayList<>(), true));
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#addOfferCodes(Order, List, boolean)}
   */
  @Test
  public void testAddOfferCodes3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(new CartMessageOrderItemServiceExtensionHandler());
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    NullOrderImpl order2 = new NullOrderImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.addOfferCodes(order2, new ArrayList<>(), true));
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#addOfferCodes(Order, List, boolean)}
   */
  @Test
  public void testAddOfferCodes4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    NullOrderImpl order = mock(NullOrderImpl.class);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true));
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#addOfferCodes(Order, List, boolean)}
   */
  @Test
  public void testAddOfferCodes5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    NullOrderImpl order = new NullOrderImpl();

    ArrayList<OfferCode> offerCodes = new ArrayList<>();
    offerCodes.add(new OfferCodeImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.addOfferCodes(order, offerCodes, true));
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#addOfferCodes(Order, List, boolean)}
   */
  @Test
  public void testAddOfferCodes6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    NullOrderImpl order = new NullOrderImpl();

    ArrayList<OfferCode> offerCodes = new ArrayList<>();
    offerCodes.add(new OfferCodeImpl());
    offerCodes.add(new OfferCodeImpl());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.addOfferCodes(order, offerCodes, true));
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#addOfferCodes(Order, List, boolean)}
   */
  @Test
  public void testAddOfferCodes7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(new OrderServiceExtensionManager());
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    NullOrderImpl order2 = new NullOrderImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.addOfferCodes(order2, new ArrayList<>(), true));
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#addOfferCodes(Order, List, boolean)}
   */
  @Test
  public void testAddOfferCodes8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = mock(
        CartMessageOrderItemServiceExtensionHandler.class);
    when(cartMessageOrderItemServiceExtensionHandler.addOfferCodes(Mockito.<Order>any(), Mockito.<List<OfferCode>>any(),
        anyBoolean())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(cartMessageOrderItemServiceExtensionHandler.isEnabled()).thenReturn(true);

    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(cartMessageOrderItemServiceExtensionHandler);
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    NullOrderImpl order2 = new NullOrderImpl();

    // Act
    ExtensionResultStatusType actualAddOfferCodesResult = orderServiceExtensionManager.addOfferCodes(order2,
        new ArrayList<>(), true);

    // Assert
    verify(cartMessageOrderItemServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(cartMessageOrderItemServiceExtensionHandler, atLeast(1)).addOfferCodes(Mockito.<Order>any(), isA(List.class),
        eq(true));
    assertEquals(ExtensionResultStatusType.HANDLED, actualAddOfferCodesResult);
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#addOfferCodes(Order, List, boolean)}
   */
  @Test
  public void testAddOfferCodes9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = mock(
        CartMessageOrderItemServiceExtensionHandler.class);
    when(cartMessageOrderItemServiceExtensionHandler.addOfferCodes(Mockito.<Order>any(), Mockito.<List<OfferCode>>any(),
        anyBoolean())).thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(cartMessageOrderItemServiceExtensionHandler.isEnabled()).thenReturn(true);

    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(cartMessageOrderItemServiceExtensionHandler);
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    NullOrderImpl order2 = new NullOrderImpl();

    // Act
    ExtensionResultStatusType actualAddOfferCodesResult = orderServiceExtensionManager.addOfferCodes(order2,
        new ArrayList<>(), true);

    // Assert
    verify(cartMessageOrderItemServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(cartMessageOrderItemServiceExtensionHandler, atLeast(1)).addOfferCodes(Mockito.<Order>any(), isA(List.class),
        eq(true));
    assertEquals(ExtensionResultStatusType.HANDLED, actualAddOfferCodesResult);
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#addOfferCodes(Order, List, boolean)}
   */
  @Test
  public void testAddOfferCodes10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = mock(
        CartMessageOrderItemServiceExtensionHandler.class);
    when(cartMessageOrderItemServiceExtensionHandler.isEnabled()).thenReturn(false);

    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(cartMessageOrderItemServiceExtensionHandler);
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    NullOrderImpl order2 = new NullOrderImpl();

    // Act
    ExtensionResultStatusType actualAddOfferCodesResult = orderServiceExtensionManager.addOfferCodes(order2,
        new ArrayList<>(), true);

    // Assert
    verify(cartMessageOrderItemServiceExtensionHandler, atLeast(1)).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualAddOfferCodesResult);
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, ExtensionResultHolder)}
   */
  @Test
  public void testFindCartForCustomerWithEnhancements() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    CustomerImpl customer = new CustomerImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.findCartForCustomerWithEnhancements(customer, erh));
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, ExtensionResultHolder)}
   */
  @Test
  public void testFindCartForCustomerWithEnhancements2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    CustomerImpl customer = new CustomerImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.findCartForCustomerWithEnhancements(customer, erh));
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, ExtensionResultHolder)}
   */
  @Test
  public void testFindCartForCustomerWithEnhancements3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(new CartMessageOrderItemServiceExtensionHandler());
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    CustomerImpl customer = new CustomerImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.findCartForCustomerWithEnhancements(customer, erh));
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, ExtensionResultHolder)}
   */
  @Test
  public void testFindCartForCustomerWithEnhancements4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    CustomerImpl customer = mock(CustomerImpl.class);

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.findCartForCustomerWithEnhancements(customer, erh));
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, ExtensionResultHolder)}
   */
  @Test
  public void testFindCartForCustomerWithEnhancements5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(new OrderServiceExtensionManager());
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    CustomerImpl customer = new CustomerImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.findCartForCustomerWithEnhancements(customer, erh));
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, ExtensionResultHolder)}
   */
  @Test
  public void testFindCartForCustomerWithEnhancements6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = mock(
        CartMessageOrderItemServiceExtensionHandler.class);
    when(cartMessageOrderItemServiceExtensionHandler.addOfferCodes(Mockito.<Order>any(), Mockito.<List<OfferCode>>any(),
        anyBoolean())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(cartMessageOrderItemServiceExtensionHandler.findCartForCustomerWithEnhancements(Mockito.<Customer>any(),
        Mockito.<ExtensionResultHolder<Object>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(cartMessageOrderItemServiceExtensionHandler.isEnabled()).thenReturn(true);

    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(cartMessageOrderItemServiceExtensionHandler);
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    CustomerImpl customer = new CustomerImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualFindCartForCustomerWithEnhancementsResult = orderServiceExtensionManager
        .findCartForCustomerWithEnhancements(customer, erh);

    // Assert
    verify(cartMessageOrderItemServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(cartMessageOrderItemServiceExtensionHandler).addOfferCodes(isA(Order.class), isA(List.class), eq(true));
    verify(cartMessageOrderItemServiceExtensionHandler).findCartForCustomerWithEnhancements(isA(Customer.class),
        isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualFindCartForCustomerWithEnhancementsResult);
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, ExtensionResultHolder)}
   */
  @Test
  public void testFindCartForCustomerWithEnhancements7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = mock(
        CartMessageOrderItemServiceExtensionHandler.class);
    when(cartMessageOrderItemServiceExtensionHandler.addOfferCodes(Mockito.<Order>any(), Mockito.<List<OfferCode>>any(),
        anyBoolean())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(cartMessageOrderItemServiceExtensionHandler.findCartForCustomerWithEnhancements(Mockito.<Customer>any(),
        Mockito.<ExtensionResultHolder<Object>>any())).thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(cartMessageOrderItemServiceExtensionHandler.isEnabled()).thenReturn(true);

    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(cartMessageOrderItemServiceExtensionHandler);
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    CustomerImpl customer = new CustomerImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualFindCartForCustomerWithEnhancementsResult = orderServiceExtensionManager
        .findCartForCustomerWithEnhancements(customer, erh);

    // Assert
    verify(cartMessageOrderItemServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(cartMessageOrderItemServiceExtensionHandler).addOfferCodes(isA(Order.class), isA(List.class), eq(true));
    verify(cartMessageOrderItemServiceExtensionHandler).findCartForCustomerWithEnhancements(isA(Customer.class),
        isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualFindCartForCustomerWithEnhancementsResult);
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, ExtensionResultHolder)}
   */
  @Test
  public void testFindCartForCustomerWithEnhancements8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = mock(
        CartMessageOrderItemServiceExtensionHandler.class);
    when(cartMessageOrderItemServiceExtensionHandler.isEnabled()).thenReturn(false);

    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(cartMessageOrderItemServiceExtensionHandler);
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    CustomerImpl customer = new CustomerImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualFindCartForCustomerWithEnhancementsResult = orderServiceExtensionManager
        .findCartForCustomerWithEnhancements(customer, erh);

    // Assert
    verify(cartMessageOrderItemServiceExtensionHandler, atLeast(1)).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualFindCartForCustomerWithEnhancementsResult);
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, Order, ExtensionResultHolder)}
   */
  @Test
  public void testFindCartForCustomerWithEnhancements9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    CustomerImpl customer = new CustomerImpl();
    NullOrderImpl candidateCart = new NullOrderImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.findCartForCustomerWithEnhancements(customer, candidateCart, erh));
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, Order, ExtensionResultHolder)}
   */
  @Test
  public void testFindCartForCustomerWithEnhancements10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    CustomerImpl customer = new CustomerImpl();
    NullOrderImpl candidateCart = new NullOrderImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.findCartForCustomerWithEnhancements(customer, candidateCart, erh));
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, Order, ExtensionResultHolder)}
   */
  @Test
  public void testFindCartForCustomerWithEnhancements11() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(new CartMessageOrderItemServiceExtensionHandler());
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    CustomerImpl customer = new CustomerImpl();
    NullOrderImpl candidateCart = new NullOrderImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.findCartForCustomerWithEnhancements(customer, candidateCart, erh));
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, Order, ExtensionResultHolder)}
   */
  @Test
  public void testFindCartForCustomerWithEnhancements12() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    CustomerImpl customer = mock(CustomerImpl.class);
    NullOrderImpl candidateCart = new NullOrderImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.findCartForCustomerWithEnhancements(customer, candidateCart, erh));
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, Order, ExtensionResultHolder)}
   */
  @Test
  public void testFindCartForCustomerWithEnhancements13() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(new OrderServiceExtensionManager());
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    CustomerImpl customer = new CustomerImpl();
    NullOrderImpl candidateCart = new NullOrderImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        orderServiceExtensionManager.findCartForCustomerWithEnhancements(customer, candidateCart, erh));
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, Order, ExtensionResultHolder)}
   */
  @Test
  public void testFindCartForCustomerWithEnhancements14() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = mock(
        CartMessageOrderItemServiceExtensionHandler.class);
    when(cartMessageOrderItemServiceExtensionHandler.addOfferCodes(Mockito.<Order>any(), Mockito.<List<OfferCode>>any(),
        anyBoolean())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(cartMessageOrderItemServiceExtensionHandler.findCartForCustomerWithEnhancements(Mockito.<Customer>any(),
        Mockito.<Order>any(), Mockito.<ExtensionResultHolder<Object>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(cartMessageOrderItemServiceExtensionHandler.isEnabled()).thenReturn(true);

    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(cartMessageOrderItemServiceExtensionHandler);
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    CustomerImpl customer = new CustomerImpl();
    NullOrderImpl candidateCart = new NullOrderImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualFindCartForCustomerWithEnhancementsResult = orderServiceExtensionManager
        .findCartForCustomerWithEnhancements(customer, candidateCart, erh);

    // Assert
    verify(cartMessageOrderItemServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(cartMessageOrderItemServiceExtensionHandler).addOfferCodes(isA(Order.class), isA(List.class), eq(true));
    verify(cartMessageOrderItemServiceExtensionHandler).findCartForCustomerWithEnhancements(isA(Customer.class),
        isA(Order.class), isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualFindCartForCustomerWithEnhancementsResult);
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, Order, ExtensionResultHolder)}
   */
  @Test
  public void testFindCartForCustomerWithEnhancements15() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = mock(
        CartMessageOrderItemServiceExtensionHandler.class);
    when(cartMessageOrderItemServiceExtensionHandler.addOfferCodes(Mockito.<Order>any(), Mockito.<List<OfferCode>>any(),
        anyBoolean())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(cartMessageOrderItemServiceExtensionHandler.findCartForCustomerWithEnhancements(Mockito.<Customer>any(),
        Mockito.<Order>any(), Mockito.<ExtensionResultHolder<Object>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(cartMessageOrderItemServiceExtensionHandler.isEnabled()).thenReturn(true);

    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(cartMessageOrderItemServiceExtensionHandler);
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    CustomerImpl customer = new CustomerImpl();
    NullOrderImpl candidateCart = new NullOrderImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualFindCartForCustomerWithEnhancementsResult = orderServiceExtensionManager
        .findCartForCustomerWithEnhancements(customer, candidateCart, erh);

    // Assert
    verify(cartMessageOrderItemServiceExtensionHandler, atLeast(1)).isEnabled();
    verify(cartMessageOrderItemServiceExtensionHandler).addOfferCodes(isA(Order.class), isA(List.class), eq(true));
    verify(cartMessageOrderItemServiceExtensionHandler).findCartForCustomerWithEnhancements(isA(Customer.class),
        isA(Order.class), isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualFindCartForCustomerWithEnhancementsResult);
  }

  /**
   * Method under test:
   * {@link OrderServiceExtensionManager#findCartForCustomerWithEnhancements(Customer, Order, ExtensionResultHolder)}
   */
  @Test
  public void testFindCartForCustomerWithEnhancements16() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartMessageOrderItemServiceExtensionHandler cartMessageOrderItemServiceExtensionHandler = mock(
        CartMessageOrderItemServiceExtensionHandler.class);
    when(cartMessageOrderItemServiceExtensionHandler.isEnabled()).thenReturn(false);

    OrderServiceExtensionManager orderServiceExtensionManager = new OrderServiceExtensionManager();
    orderServiceExtensionManager.registerHandler(cartMessageOrderItemServiceExtensionHandler);
    NullOrderImpl order = new NullOrderImpl();
    orderServiceExtensionManager.addOfferCodes(order, new ArrayList<>(), true);
    CustomerImpl customer = new CustomerImpl();
    NullOrderImpl candidateCart = new NullOrderImpl();

    ExtensionResultHolder erh = new ExtensionResultHolder();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualFindCartForCustomerWithEnhancementsResult = orderServiceExtensionManager
        .findCartForCustomerWithEnhancements(customer, candidateCart, erh);

    // Assert
    verify(cartMessageOrderItemServiceExtensionHandler, atLeast(1)).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualFindCartForCustomerWithEnhancementsResult);
  }

  /**
   * Method under test: {@link OrderServiceExtensionManager#isEnabled()}
   */
  @Test
  public void testIsEnabled() {
    // Arrange, Act and Assert
    assertTrue((new OrderServiceExtensionManager()).isEnabled());
  }
}

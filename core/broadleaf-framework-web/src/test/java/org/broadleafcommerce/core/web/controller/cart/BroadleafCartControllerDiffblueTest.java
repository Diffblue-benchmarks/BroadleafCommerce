/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.controller.cart;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.service.call.ConfigurableOrderItemRequest;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

class BroadleafCartControllerDiffblueTest {
  /**
   * Method under test:
   * {@link BroadleafCartController#cart(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  void testCart() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCartController broadleafCartController = new BroadleafCartController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertEquals("cart/cart", broadleafCartController.cart(request, response, new ConcurrentModel()));
  }

  /**
   * Method under test:
   * {@link BroadleafCartController#cart(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  void testCart2() throws PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCartController broadleafCartController = new BroadleafCartController();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(new MockHttpServletRequest(),
        mock(Environment.class), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertEquals("cart/cart", broadleafCartController.cart(request, response, new ConcurrentModel()));
  }

  /**
   * Method under test:
   * {@link BroadleafCartController#isUpdateRequest(HttpServletRequest)}
   */
  @Test
  void testIsUpdateRequest() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCartController broadleafCartController = new BroadleafCartController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act and Assert
    assertFalse(broadleafCartController.isUpdateRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));
  }

  /**
   * Method under test:
   * {@link BroadleafCartController#isUpdateRequest(HttpServletRequest)}
   */
  @Test
  void testIsUpdateRequest2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCartController broadleafCartController = new BroadleafCartController();
    new NumberFormatException("isUpdateRequest");
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act and Assert
    assertFalse(broadleafCartController.isUpdateRequest(new SearchRequestWrapper(
        new HttpServletRequestWrapper(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"isUpdateRequest"}))))));
  }

  /**
   * Method under test:
   * {@link BroadleafCartController#isUpdateRequest(HttpServletRequest)}
   */
  @Test
  void testIsUpdateRequest3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCartController broadleafCartController = new BroadleafCartController();
    new NumberFormatException("isUpdateRequest");
    DefaultMultipartHttpServletRequest servletRequest = mock(DefaultMultipartHttpServletRequest.class);
    when(servletRequest.getParameter(Mockito.<String>any())).thenReturn("https://example.org/example");

    // Act
    boolean actualIsUpdateRequestResult = broadleafCartController
        .isUpdateRequest(new SearchRequestWrapper(servletRequest));

    // Assert
    verify(servletRequest, atLeast(1)).getParameter(eq("isUpdateRequest"));
    assertFalse(actualIsUpdateRequestResult);
  }

  /**
   * Method under test:
   * {@link BroadleafCartController#addPromo(HttpServletRequest, HttpServletResponse, Model, String)}
   */
  @Test
  void testAddPromo() throws IOException, PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCartController broadleafCartController = new BroadleafCartController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    XssRequestWrapper servletRequest2 = new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
        new String[]{"White List Param Names"});

    SearchRequestWrapper request = new SearchRequestWrapper(servletRequest2);
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualAddPromoResult = broadleafCartController.addPromo(request, response, model, "Customer Offer");

    // Assert
    assertEquals(1, model.size());
    assertEquals("Invalid Cart", model.get("exception"));
    assertEquals("cart/cart", actualAddPromoResult);
    assertTrue(request.getTrailerFields().isEmpty());
    assertSame(servletRequest2, request.getRequest());
  }

  /**
   * Method under test:
   * {@link BroadleafCartController#addPromo(HttpServletRequest, HttpServletResponse, Model, String)}
   */
  @Test
  void testAddPromo2() throws IOException, PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCartController broadleafCartController = new BroadleafCartController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper servletRequest2 = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"ThreadLocalManager.notify.orphans"}));
    XssRequestWrapper servletRequest3 = new XssRequestWrapper(servletRequest2, new StandardReactiveWebEnvironment(),
        new String[]{"White List Param Names"});

    SearchRequestWrapper request = new SearchRequestWrapper(servletRequest3);
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualAddPromoResult = broadleafCartController.addPromo(request, response, model, "Customer Offer");

    // Assert
    assertEquals(1, model.size());
    assertEquals("Invalid Cart", model.get("exception"));
    assertEquals("cart/cart", actualAddPromoResult);
    assertTrue(request.getTrailerFields().isEmpty());
    assertSame(servletRequest3, request.getRequest());
  }

  /**
   * Method under test:
   * {@link BroadleafCartController#addPromo(HttpServletRequest, HttpServletResponse, Model, String)}
   */
  @Test
  void testAddPromo3() throws IOException, PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCartController broadleafCartController = new BroadleafCartController();
    XssRequestWrapper servletRequest = new XssRequestWrapper(new MockHttpServletRequest(), mock(Environment.class),
        new String[]{"White List Param Names"});

    SearchRequestWrapper request = new SearchRequestWrapper(servletRequest);
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualAddPromoResult = broadleafCartController.addPromo(request, response, model, "Customer Offer");

    // Assert
    assertEquals(1, model.size());
    assertEquals("Invalid Cart", model.get("exception"));
    assertEquals("cart/cart", actualAddPromoResult);
    assertTrue(request.getTrailerFields().isEmpty());
    assertSame(servletRequest, request.getRequest());
  }

  /**
   * Method under test:
   * {@link BroadleafCartController#addPromo(HttpServletRequest, HttpServletResponse, Model, String)}
   */
  @Test
  void testAddPromo4() throws IOException, PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCartController broadleafCartController = new BroadleafCartController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    XssRequestWrapper servletRequest2 = new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
        new String[]{"blcAjax"});

    SearchRequestWrapper request = new SearchRequestWrapper(servletRequest2);
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualAddPromoResult = broadleafCartController.addPromo(request, response, model, "Customer Offer");

    // Assert
    assertEquals(1, model.size());
    assertEquals("Invalid Cart", model.get("exception"));
    assertEquals("cart/cart", actualAddPromoResult);
    assertTrue(request.getTrailerFields().isEmpty());
    assertSame(servletRequest2, request.getRequest());
  }

  /**
   * Method under test:
   * {@link BroadleafCartController#addPromo(HttpServletRequest, HttpServletResponse, Model, String)}
   */
  @Test
  void testAddPromo5() throws IOException, PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCartController broadleafCartController = new BroadleafCartController();
    MockMultipartHttpServletRequest servletRequest = new MockMultipartHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(servletRequest);
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualAddPromoResult = broadleafCartController.addPromo(request, response, model, "Customer Offer");

    // Assert
    assertEquals(1, model.size());
    assertEquals("Invalid Cart", model.get("exception"));
    assertEquals("cart/cart", actualAddPromoResult);
    assertTrue(request.getTrailerFields().isEmpty());
    assertSame(servletRequest, request.getRequest());
  }

  /**
   * Method under test:
   * {@link BroadleafCartController#isCheckoutContext(HttpServletRequest)}
   */
  @Test
  void testIsCheckoutContext() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCartController broadleafCartController = new BroadleafCartController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act and Assert
    assertFalse(broadleafCartController.isCheckoutContext(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));
  }

  /**
   * Method under test:
   * {@link BroadleafCartController#isCheckoutContext(HttpServletRequest)}
   */
  @Test
  void testIsCheckoutContext2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCartController broadleafCartController = new BroadleafCartController();
    new NumberFormatException("isCheckoutContext");
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act and Assert
    assertFalse(broadleafCartController.isCheckoutContext(new SearchRequestWrapper(
        new HttpServletRequestWrapper(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"isCheckoutContext"}))))));
  }

  /**
   * Method under test:
   * {@link BroadleafCartController#isSafeToAdd(ConfigurableOrderItemRequest)}
   */
  @Test
  void testIsSafeToAdd() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCartController broadleafCartController = new BroadleafCartController();

    ConfigurableOrderItemRequest itemRequest = new ConfigurableOrderItemRequest();
    itemRequest.setAdditionalAttributes(new HashMap<>());
    itemRequest.setCategoryId(1L);
    itemRequest.setChildOrderItems(new ArrayList<>());
    itemRequest.setDiscountsAllowed(true);
    itemRequest.setDisplayPrice(new Money());
    itemRequest.setExpandable(true);
    itemRequest.setFirstExpandable(true);
    itemRequest.setHasConfigurationError(true);
    itemRequest.setHasOverridenPrice(true);
    itemRequest.setIsMultiSelect(true);
    itemRequest.setItemAttributes(new HashMap<>());
    itemRequest.setLastExpandable(true);
    itemRequest.setMaxQuantity(3);
    itemRequest.setMinQuantity(1);
    itemRequest.setOrderItemId(1L);
    itemRequest.setOrderItemIndex(1);
    itemRequest.setOverrideRetailPrice(new Money());
    itemRequest.setOverrideSalePrice(new Money());
    itemRequest.setParentOrderItemId(1L);
    itemRequest.setPricingModelType("Pricing Model Type");
    itemRequest.setProductChoices(new ArrayList<>());
    itemRequest.setProductId(1L);
    itemRequest.setQuantity(1);
    itemRequest.setSkuId(1L);

    // Act and Assert
    assertFalse(broadleafCartController.isSafeToAdd(itemRequest));
  }

  /**
   * Method under test:
   * {@link BroadleafCartController#isSafeToAdd(ConfigurableOrderItemRequest)}
   */
  @Test
  void testIsSafeToAdd2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCartController broadleafCartController = new BroadleafCartController();
    ConfigurableOrderItemRequest itemRequest = mock(ConfigurableOrderItemRequest.class);
    when(itemRequest.setCategoryId(Mockito.<Long>any())).thenReturn(new OrderItemRequestDTO());
    when(itemRequest.setItemAttributes(Mockito.<Map<String, String>>any())).thenReturn(new OrderItemRequestDTO());
    when(itemRequest.setOrderItemId(Mockito.<Long>any())).thenReturn(new OrderItemRequestDTO());
    when(itemRequest.setProductId(Mockito.<Long>any())).thenReturn(new OrderItemRequestDTO());
    when(itemRequest.setQuantity(Mockito.<Integer>any())).thenReturn(new OrderItemRequestDTO());
    when(itemRequest.setSkuId(Mockito.<Long>any())).thenReturn(new OrderItemRequestDTO());
    doNothing().when(itemRequest).setDiscountsAllowed(Mockito.<Boolean>any());
    doNothing().when(itemRequest).setDisplayPrice(Mockito.<Money>any());
    doNothing().when(itemRequest).setExpandable(anyBoolean());
    doNothing().when(itemRequest).setFirstExpandable(anyBoolean());
    doNothing().when(itemRequest).setHasConfigurationError(Mockito.<Boolean>any());
    doNothing().when(itemRequest).setHasOverridenPrice(Mockito.<Boolean>any());
    doNothing().when(itemRequest).setIsMultiSelect(Mockito.<Boolean>any());
    doNothing().when(itemRequest).setLastExpandable(anyBoolean());
    doNothing().when(itemRequest).setMaxQuantity(Mockito.<Integer>any());
    doNothing().when(itemRequest).setMinQuantity(Mockito.<Integer>any());
    doNothing().when(itemRequest).setOrderItemIndex(Mockito.<Integer>any());
    doNothing().when(itemRequest).setPricingModelType(Mockito.<String>any());
    doNothing().when(itemRequest).setProductChoices(Mockito.<List<ConfigurableOrderItemRequest>>any());
    doNothing().when(itemRequest).setAdditionalAttributes(Mockito.<Map<String, String>>any());
    doNothing().when(itemRequest).setChildOrderItems(Mockito.<List<OrderItemRequestDTO>>any());
    doNothing().when(itemRequest).setOverrideRetailPrice(Mockito.<Money>any());
    doNothing().when(itemRequest).setOverrideSalePrice(Mockito.<Money>any());
    doNothing().when(itemRequest).setParentOrderItemId(Mockito.<Long>any());
    itemRequest.setAdditionalAttributes(new HashMap<>());
    itemRequest.setCategoryId(1L);
    itemRequest.setChildOrderItems(new ArrayList<>());
    itemRequest.setDiscountsAllowed(true);
    itemRequest.setDisplayPrice(new Money());
    itemRequest.setExpandable(true);
    itemRequest.setFirstExpandable(true);
    itemRequest.setHasConfigurationError(true);
    itemRequest.setHasOverridenPrice(true);
    itemRequest.setIsMultiSelect(true);
    itemRequest.setItemAttributes(new HashMap<>());
    itemRequest.setLastExpandable(true);
    itemRequest.setMaxQuantity(3);
    itemRequest.setMinQuantity(1);
    itemRequest.setOrderItemId(1L);
    itemRequest.setOrderItemIndex(1);
    itemRequest.setOverrideRetailPrice(new Money());
    itemRequest.setOverrideSalePrice(new Money());
    itemRequest.setParentOrderItemId(1L);
    itemRequest.setPricingModelType("Pricing Model Type");
    itemRequest.setProductChoices(new ArrayList<>());
    itemRequest.setProductId(1L);
    itemRequest.setQuantity(1);
    itemRequest.setSkuId(1L);

    // Act
    boolean actualIsSafeToAddResult = broadleafCartController.isSafeToAdd(itemRequest);

    // Assert
    verify(itemRequest).setDiscountsAllowed(eq(true));
    verify(itemRequest).setDisplayPrice(isA(Money.class));
    verify(itemRequest).setExpandable(eq(true));
    verify(itemRequest).setFirstExpandable(eq(true));
    verify(itemRequest).setHasConfigurationError(eq(true));
    verify(itemRequest).setHasOverridenPrice(eq(true));
    verify(itemRequest).setIsMultiSelect(eq(true));
    verify(itemRequest).setLastExpandable(eq(true));
    verify(itemRequest).setMaxQuantity(eq(3));
    verify(itemRequest).setMinQuantity(eq(1));
    verify(itemRequest).setOrderItemIndex(eq(1));
    verify(itemRequest).setPricingModelType(eq("Pricing Model Type"));
    verify(itemRequest).setProductChoices(isA(List.class));
    verify(itemRequest).setAdditionalAttributes(isA(Map.class));
    verify(itemRequest).setCategoryId(eq(1L));
    verify(itemRequest).setChildOrderItems(isA(List.class));
    verify(itemRequest).setItemAttributes(isA(Map.class));
    verify(itemRequest).setOrderItemId(eq(1L));
    verify(itemRequest).setOverrideRetailPrice(isA(Money.class));
    verify(itemRequest).setOverrideSalePrice(isA(Money.class));
    verify(itemRequest).setParentOrderItemId(eq(1L));
    verify(itemRequest).setProductId(eq(1L));
    verify(itemRequest).setQuantity(eq(1));
    verify(itemRequest).setSkuId(eq(1L));
    assertFalse(actualIsSafeToAddResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link BroadleafCartController}
   *   <li>{@link BroadleafCartController#getCartPageRedirect()}
   *   <li>{@link BroadleafCartController#getCartView()}
   *   <li>{@link BroadleafCartController#getCheckoutView()}
   *   <li>{@link BroadleafCartController#getConfigurePageRedirect()}
   *   <li>{@link BroadleafCartController#getConfigureView()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    BroadleafCartController actualBroadleafCartController = new BroadleafCartController();
    String actualCartPageRedirect = actualBroadleafCartController.getCartPageRedirect();
    String actualCartView = actualBroadleafCartController.getCartView();
    String actualCheckoutView = actualBroadleafCartController.getCheckoutView();
    String actualConfigurePageRedirect = actualBroadleafCartController.getConfigurePageRedirect();

    // Assert
    assertEquals("cart/cart", actualCartView);
    assertEquals("checkout/checkout", actualCheckoutView);
    assertEquals("configure/partials/configure", actualBroadleafCartController.getConfigureView());
    assertEquals("redirect:/cart", actualCartPageRedirect);
    assertEquals("redirect:/cart/configure", actualConfigurePageRedirect);
  }
}

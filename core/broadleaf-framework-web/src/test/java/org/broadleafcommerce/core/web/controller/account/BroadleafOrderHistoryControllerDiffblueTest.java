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
package org.broadleafcommerce.core.web.controller.account;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.broadleafcommerce.core.web.service.OrderHistoryService;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

@ExtendWith(MockitoExtension.class)
class BroadleafOrderHistoryControllerDiffblueTest {
  @InjectMocks
  private BroadleafOrderHistoryController broadleafOrderHistoryController;

  @Mock
  private OrderHistoryService orderHistoryService;

  @Mock
  private OrderService orderService;

  /**
   * Test {@link BroadleafOrderHistoryController#viewOrderHistory(HttpServletRequest, Model)}.
   * <p>
   * Method under test: {@link BroadleafOrderHistoryController#viewOrderHistory(HttpServletRequest, Model)}
   */
  @Test
  @DisplayName("Test viewOrderHistory(HttpServletRequest, Model)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BroadleafOrderHistoryController.viewOrderHistory(HttpServletRequest, Model)"})
  void testViewOrderHistory() {
    // Arrange
    ArrayList<Order> orderList = new ArrayList<>();
    when(orderService.findOrdersForCustomer(Mockito.<Customer>any(), Mockito.<OrderStatus>any())).thenReturn(orderList);
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualViewOrderHistoryResult = broadleafOrderHistoryController.viewOrderHistory(request, model);

    // Assert
    verify(orderService).findOrdersForCustomer(isNull(), isA(OrderStatus.class));
    assertEquals(1, model.size());
    Object getResult = model.get("orders");
    assertTrue(getResult instanceof List);
    assertEquals("account/orderHistory", actualViewOrderHistoryResult);
    assertTrue(((List<Object>) getResult).isEmpty());
    assertSame(orderList, getResult);
  }

  /**
   * Test {@link BroadleafOrderHistoryController#viewOrderDetails(HttpServletRequest, Model, String)}.
   * <ul>
   *   <li>Then {@link ConcurrentModel#ConcurrentModel()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafOrderHistoryController#viewOrderDetails(HttpServletRequest, Model, String)}
   */
  @Test
  @DisplayName("Test viewOrderDetails(HttpServletRequest, Model, String); then ConcurrentModel() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BroadleafOrderHistoryController.viewOrderDetails(HttpServletRequest, Model, String)"})
  void testViewOrderDetails_thenConcurrentModelSizeIsOne() {
    // Arrange
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderHistoryService.getOrderDetails(Mockito.<String>any())).thenReturn(nullOrderImpl);
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualViewOrderDetailsResult = broadleafOrderHistoryController.viewOrderDetails(request, model, "42");

    // Assert
    verify(orderHistoryService).getOrderDetails(eq("42"));
    assertEquals(1, model.size());
    Object getResult = model.get("order");
    assertTrue(getResult instanceof NullOrderImpl);
    assertEquals("account/partials/orderDetails", actualViewOrderDetailsResult);
    assertSame(nullOrderImpl, getResult);
  }

  /**
   * Test {@link BroadleafOrderHistoryController#validateCustomerOwnedData(Order)}.
   * <p>
   * Method under test: {@link BroadleafOrderHistoryController#validateCustomerOwnedData(Order)}
   */
  @Test
  @DisplayName("Test validateCustomerOwnedData(Order)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafOrderHistoryController.validateCustomerOwnedData(Order)"})
  void testValidateCustomerOwnedData() throws SecurityException {
    // Arrange
    doNothing().when(orderHistoryService).validateCustomerOwnedData(Mockito.<Order>any());

    // Act
    broadleafOrderHistoryController.validateCustomerOwnedData(new NullOrderImpl());

    // Assert
    verify(orderHistoryService).validateCustomerOwnedData(isA(Order.class));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link BroadleafOrderHistoryController}
   *   <li>{@link BroadleafOrderHistoryController#getOrderDetailsRedirectView()}
   *   <li>{@link BroadleafOrderHistoryController#getOrderDetailsView()}
   *   <li>{@link BroadleafOrderHistoryController#getOrderHistoryView()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafOrderHistoryController.<init>()",
      "String BroadleafOrderHistoryController.getOrderDetailsRedirectView()",
      "String BroadleafOrderHistoryController.getOrderDetailsView()",
      "String BroadleafOrderHistoryController.getOrderHistoryView()"})
  void testGettersAndSetters() {
    // Arrange and Act
    BroadleafOrderHistoryController actualBroadleafOrderHistoryController = new BroadleafOrderHistoryController();
    String actualOrderDetailsRedirectView = actualBroadleafOrderHistoryController.getOrderDetailsRedirectView();
    String actualOrderDetailsView = actualBroadleafOrderHistoryController.getOrderDetailsView();

    // Assert
    assertEquals("account/orderHistory", actualBroadleafOrderHistoryController.getOrderHistoryView());
    assertEquals("account/partials/orderDetails", actualOrderDetailsRedirectView);
    assertEquals("account/partials/orderDetails", actualOrderDetailsView);
  }
}

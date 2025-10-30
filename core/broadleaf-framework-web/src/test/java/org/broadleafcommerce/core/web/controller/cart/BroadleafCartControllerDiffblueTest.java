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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.service.CatalogService;
import org.broadleafcommerce.core.offer.domain.OfferCode;
import org.broadleafcommerce.core.offer.domain.OfferCodeImpl;
import org.broadleafcommerce.core.offer.service.OfferService;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.service.OrderItemService;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.order.service.call.ConfigurableOrderItemRequest;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
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
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

@ExtendWith(MockitoExtension.class)
class BroadleafCartControllerDiffblueTest {
  @InjectMocks
  private BroadleafCartController broadleafCartController;

  @Mock
  private CatalogService catalogService;

  @Mock
  private OrderItemService orderItemService;

  @Mock
  private OrderService orderService;

  @Mock
  private OfferService offerService;

  /**
   * Test {@link BroadleafCartController#cart(HttpServletRequest, HttpServletResponse, Model)}.
   * <p>
   * Method under test: {@link BroadleafCartController#cart(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @DisplayName("Test cart(HttpServletRequest, HttpServletResponse, Model)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BroadleafCartController.cart(HttpServletRequest, HttpServletResponse, Model)"})
  void testCart() throws PricingException {
    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertEquals("cart/cart", broadleafCartController.cart(request, response, new ConcurrentModel()));
  }

  /**
   * Test {@link BroadleafCartController#updateAddRequestQuantities(OrderItemRequestDTO, Long)}.
   * <ul>
   *   <li>Given {@link OrderItemService} {@link OrderItemService#readOrderItemById(Long)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafCartController#updateAddRequestQuantities(OrderItemRequestDTO, Long)}
   */
  @Test
  @DisplayName("Test updateAddRequestQuantities(OrderItemRequestDTO, Long); given OrderItemService readOrderItemById(Long) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafCartController.updateAddRequestQuantities(OrderItemRequestDTO, Long)"})
  void testUpdateAddRequestQuantities_givenOrderItemServiceReadOrderItemByIdReturnNull() {
    // Arrange
    when(orderItemService.readOrderItemById(Mockito.<Long>any())).thenReturn(null);

    // Act
    broadleafCartController.updateAddRequestQuantities(new OrderItemRequestDTO(), 1L);

    // Assert that nothing has changed
    verify(orderItemService).readOrderItemById(eq(1L));
  }

  /**
   * Test {@link BroadleafCartController#updateAddRequestQuantities(OrderItemRequestDTO, Long)}.
   * <ul>
   *   <li>Then {@link OrderItemRequestDTO#OrderItemRequestDTO()} ChildOrderItems size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafCartController#updateAddRequestQuantities(OrderItemRequestDTO, Long)}
   */
  @Test
  @DisplayName("Test updateAddRequestQuantities(OrderItemRequestDTO, Long); then OrderItemRequestDTO() ChildOrderItems size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafCartController.updateAddRequestQuantities(OrderItemRequestDTO, Long)"})
  void testUpdateAddRequestQuantities_thenOrderItemRequestDTOChildOrderItemsSizeIsOne() {
    // Arrange
    when(orderItemService.readOrderItemById(Mockito.<Long>any())).thenReturn(new BundleOrderItemImpl());

    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    orderItemRequestDTO.setQuantity(1);

    ArrayList<OrderItemRequestDTO> childOrderItems = new ArrayList<>();
    childOrderItems.add(orderItemRequestDTO);

    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO();
    itemRequest.setChildOrderItems(childOrderItems);

    // Act
    broadleafCartController.updateAddRequestQuantities(itemRequest, 1L);

    // Assert
    verify(orderItemService).readOrderItemById(eq(1L));
    assertEquals(0, itemRequest.getQuantity().intValue());
    List<OrderItemRequestDTO> childOrderItems2 = itemRequest.getChildOrderItems();
    assertEquals(1, childOrderItems2.size());
    assertEquals(0, childOrderItems2.get(0).getQuantity().intValue());
  }

  /**
   * Test {@link BroadleafCartController#updateAddRequestQuantities(OrderItemRequestDTO, Long)}.
   * <ul>
   *   <li>Then {@link OrderItemRequestDTO#OrderItemRequestDTO()} Quantity intValue is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafCartController#updateAddRequestQuantities(OrderItemRequestDTO, Long)}
   */
  @Test
  @DisplayName("Test updateAddRequestQuantities(OrderItemRequestDTO, Long); then OrderItemRequestDTO() Quantity intValue is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafCartController.updateAddRequestQuantities(OrderItemRequestDTO, Long)"})
  void testUpdateAddRequestQuantities_thenOrderItemRequestDTOQuantityIntValueIsZero() {
    // Arrange
    when(orderItemService.readOrderItemById(Mockito.<Long>any())).thenReturn(new BundleOrderItemImpl());
    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO();

    // Act
    broadleafCartController.updateAddRequestQuantities(itemRequest, 1L);

    // Assert
    verify(orderItemService).readOrderItemById(eq(1L));
    assertEquals(0, itemRequest.getQuantity().intValue());
  }

  /**
   * Test {@link BroadleafCartController#updateAddRequestQuantities(OrderItemRequestDTO, Long)}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafCartController#updateAddRequestQuantities(OrderItemRequestDTO, Long)}
   */
  @Test
  @DisplayName("Test updateAddRequestQuantities(OrderItemRequestDTO, Long); then throw NumberFormatException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafCartController.updateAddRequestQuantities(OrderItemRequestDTO, Long)"})
  void testUpdateAddRequestQuantities_thenThrowNumberFormatException() {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getQuantity()).thenThrow(new NumberFormatException("foo"));
    when(orderItemService.readOrderItemById(Mockito.<Long>any())).thenReturn(bundleOrderItemImpl);

    // Act and Assert
    assertThrows(NumberFormatException.class,
        () -> broadleafCartController.updateAddRequestQuantities(new OrderItemRequestDTO(), 1L));
    verify(bundleOrderItemImpl).getQuantity();
    verify(orderItemService).readOrderItemById(eq(1L));
  }

  /**
   * Test {@link BroadleafCartController#isUpdateRequest(HttpServletRequest)}.
   * <p>
   * Method under test: {@link BroadleafCartController#isUpdateRequest(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test isUpdateRequest(HttpServletRequest)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BroadleafCartController.isUpdateRequest(HttpServletRequest)"})
  void testIsUpdateRequest() {
    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act and Assert
    assertFalse(broadleafCartController.isUpdateRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));
  }

  /**
   * Test {@link BroadleafCartController#isUpdateRequest(HttpServletRequest)}.
   * <p>
   * Method under test: {@link BroadleafCartController#isUpdateRequest(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test isUpdateRequest(HttpServletRequest)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BroadleafCartController.isUpdateRequest(HttpServletRequest)"})
  void testIsUpdateRequest2() {
    // Arrange
    SessionlessHttpServletRequestWrapper servletRequest = mock(SessionlessHttpServletRequestWrapper.class);
    when(servletRequest.getParameter(Mockito.<String>any())).thenReturn("Parameter");

    // Act
    boolean actualIsUpdateRequestResult = broadleafCartController
        .isUpdateRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})));

    // Assert
    verify(servletRequest, atLeast(1)).getParameter(eq("isUpdateRequest"));
    assertFalse(actualIsUpdateRequestResult);
  }

  /**
   * Test {@link BroadleafCartController#isUpdateRequest(HttpServletRequest)}.
   * <p>
   * Method under test: {@link BroadleafCartController#isUpdateRequest(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test isUpdateRequest(HttpServletRequest)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BroadleafCartController.isUpdateRequest(HttpServletRequest)"})
  void testIsUpdateRequest3() {
    // Arrange
    SessionlessHttpServletRequestWrapper servletRequest = mock(SessionlessHttpServletRequestWrapper.class);
    when(servletRequest.getParameter(Mockito.<String>any())).thenReturn("Parameter");

    // Act
    boolean actualIsUpdateRequestResult = broadleafCartController.isUpdateRequest(new SearchRequestWrapper(
        new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(), new String[]{"isUpdateRequest"})));

    // Assert
    verify(servletRequest, atLeast(1)).getParameter(eq("isUpdateRequest"));
    assertFalse(actualIsUpdateRequestResult);
  }

  /**
   * Test {@link BroadleafCartController#isUpdateRequest(HttpServletRequest)}.
   * <p>
   * Method under test: {@link BroadleafCartController#isUpdateRequest(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test isUpdateRequest(HttpServletRequest)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BroadleafCartController.isUpdateRequest(HttpServletRequest)"})
  void testIsUpdateRequest4() {
    // Arrange
    SessionlessHttpServletRequestWrapper servletRequest = mock(SessionlessHttpServletRequestWrapper.class);

    XssRequestWrapper servletRequest2 = new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
        new String[]{"White List Param Names"});
    MockHttpServletRequest servletRequest3 = new MockHttpServletRequest();
    servletRequest2.setRequest(new SearchRequestWrapper(
        new XssRequestWrapper(servletRequest3, new StandardReactiveWebEnvironment(), new String[]{"U"})));

    // Act and Assert
    assertFalse(broadleafCartController.isUpdateRequest(new SearchRequestWrapper(servletRequest2)));
  }

  /**
   * Test {@link BroadleafCartController#configure(HttpServletRequest, HttpServletResponse, Model, Long)}.
   * <p>
   * Method under test: {@link BroadleafCartController#configure(HttpServletRequest, HttpServletResponse, Model, Long)}
   */
  @Test
  @DisplayName("Test configure(HttpServletRequest, HttpServletResponse, Model, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BroadleafCartController.configure(HttpServletRequest, HttpServletResponse, Model, Long)"})
  void testConfigure() throws Exception {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());

    ConfigurableOrderItemRequest configurableOrderItemRequest = new ConfigurableOrderItemRequest();
    configurableOrderItemRequest.setAdditionalAttributes(new HashMap<>());
    configurableOrderItemRequest.setCategoryId(1L);
    configurableOrderItemRequest.setChildOrderItems(new ArrayList<>());
    configurableOrderItemRequest.setDiscountsAllowed(true);
    configurableOrderItemRequest.setDisplayPrice(new Money());
    configurableOrderItemRequest.setExpandable(true);
    configurableOrderItemRequest.setFirstExpandable(true);
    configurableOrderItemRequest.setHasConfigurationError(true);
    configurableOrderItemRequest.setHasOverridenPrice(true);
    configurableOrderItemRequest.setIsMultiSelect(true);
    configurableOrderItemRequest.setItemAttributes(new HashMap<>());
    configurableOrderItemRequest.setLastExpandable(true);
    configurableOrderItemRequest.setMaxQuantity(3);
    configurableOrderItemRequest.setMinQuantity(1);
    configurableOrderItemRequest.setOrderItemId(1L);
    configurableOrderItemRequest.setOrderItemIndex(1);
    configurableOrderItemRequest.setOverrideRetailPrice(new Money());
    configurableOrderItemRequest.setOverrideSalePrice(new Money());
    configurableOrderItemRequest.setParentOrderItemId(1L);
    configurableOrderItemRequest.setPricingModelType("Pricing Model Type");
    configurableOrderItemRequest.setProductChoices(new ArrayList<>());
    configurableOrderItemRequest.setProductId(1L);
    configurableOrderItemRequest.setQuantity(1);
    configurableOrderItemRequest.setSkuId(1L);
    when(orderItemService.findAllProductsInRequest(Mockito.<ConfigurableOrderItemRequest>any()))
        .thenReturn(new HashSet<>());
    when(orderItemService.createConfigurableOrderItemRequestFromProduct(Mockito.<Product>any()))
        .thenReturn(configurableOrderItemRequest);
    doNothing().when(orderItemService).modifyOrderItemRequest(Mockito.<ConfigurableOrderItemRequest>any());
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(
        new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(), new String[]{"blcAjax"}));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    broadleafCartController.configure(request, response, model, 1L);

    // Assert
    verify(catalogService).findProductById(eq(1L));
    verify(orderItemService).createConfigurableOrderItemRequestFromProduct(isA(Product.class));
    verify(orderItemService).findAllProductsInRequest(isA(ConfigurableOrderItemRequest.class));
    verify(orderItemService).modifyOrderItemRequest(isA(ConfigurableOrderItemRequest.class));
    assertEquals(3, model.size());
    assertTrue(model.get("baseItem") instanceof ConfigurableOrderItemRequest);
    assertTrue(model.containsKey("blcAllDisplayedProducts"));
    assertTrue(model.containsKey("isUpdateRequest"));
  }

  /**
   * Test {@link BroadleafCartController#configure(HttpServletRequest, HttpServletResponse, Model, Long)}.
   * <ul>
   *   <li>Then {@link ConcurrentModel#ConcurrentModel()} {@code baseItem} {@link ConfigurableOrderItemRequest}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafCartController#configure(HttpServletRequest, HttpServletResponse, Model, Long)}
   */
  @Test
  @DisplayName("Test configure(HttpServletRequest, HttpServletResponse, Model, Long); then ConcurrentModel() 'baseItem' ConfigurableOrderItemRequest")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BroadleafCartController.configure(HttpServletRequest, HttpServletResponse, Model, Long)"})
  void testConfigure_thenConcurrentModelBaseItemConfigurableOrderItemRequest() throws Exception {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());

    ConfigurableOrderItemRequest configurableOrderItemRequest = new ConfigurableOrderItemRequest();
    configurableOrderItemRequest.setAdditionalAttributes(new HashMap<>());
    configurableOrderItemRequest.setCategoryId(1L);
    configurableOrderItemRequest.setChildOrderItems(new ArrayList<>());
    configurableOrderItemRequest.setDiscountsAllowed(true);
    configurableOrderItemRequest.setDisplayPrice(new Money());
    configurableOrderItemRequest.setExpandable(true);
    configurableOrderItemRequest.setFirstExpandable(true);
    configurableOrderItemRequest.setHasConfigurationError(true);
    configurableOrderItemRequest.setHasOverridenPrice(true);
    configurableOrderItemRequest.setIsMultiSelect(true);
    configurableOrderItemRequest.setItemAttributes(new HashMap<>());
    configurableOrderItemRequest.setLastExpandable(true);
    configurableOrderItemRequest.setMaxQuantity(3);
    configurableOrderItemRequest.setMinQuantity(1);
    configurableOrderItemRequest.setOrderItemId(1L);
    configurableOrderItemRequest.setOrderItemIndex(1);
    configurableOrderItemRequest.setOverrideRetailPrice(new Money());
    configurableOrderItemRequest.setOverrideSalePrice(new Money());
    configurableOrderItemRequest.setParentOrderItemId(1L);
    configurableOrderItemRequest.setPricingModelType("Pricing Model Type");
    configurableOrderItemRequest.setProductChoices(new ArrayList<>());
    configurableOrderItemRequest.setProductId(1L);
    configurableOrderItemRequest.setQuantity(1);
    configurableOrderItemRequest.setSkuId(1L);
    when(orderItemService.findAllProductsInRequest(Mockito.<ConfigurableOrderItemRequest>any()))
        .thenReturn(new HashSet<>());
    when(orderItemService.createConfigurableOrderItemRequestFromProduct(Mockito.<Product>any()))
        .thenReturn(configurableOrderItemRequest);
    doNothing().when(orderItemService).modifyOrderItemRequest(Mockito.<ConfigurableOrderItemRequest>any());
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    broadleafCartController.configure(request, response, model, 1L);

    // Assert
    verify(catalogService).findProductById(eq(1L));
    verify(orderItemService).createConfigurableOrderItemRequestFromProduct(isA(Product.class));
    verify(orderItemService).findAllProductsInRequest(isA(ConfigurableOrderItemRequest.class));
    verify(orderItemService).modifyOrderItemRequest(isA(ConfigurableOrderItemRequest.class));
    assertEquals(3, model.size());
    assertTrue(model.get("baseItem") instanceof ConfigurableOrderItemRequest);
    assertTrue(model.containsKey("blcAllDisplayedProducts"));
    assertTrue(model.containsKey("isUpdateRequest"));
  }

  /**
   * Test {@link BroadleafCartController#configure(HttpServletRequest, HttpServletResponse, Model, Long)}.
   * <ul>
   *   <li>Then {@link ConcurrentModel#ConcurrentModel()} {@code blcAllDisplayedProducts} {@link Set}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafCartController#configure(HttpServletRequest, HttpServletResponse, Model, Long)}
   */
  @Test
  @DisplayName("Test configure(HttpServletRequest, HttpServletResponse, Model, Long); then ConcurrentModel() 'blcAllDisplayedProducts' Set")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BroadleafCartController.configure(HttpServletRequest, HttpServletResponse, Model, Long)"})
  void testConfigure_thenConcurrentModelBlcAllDisplayedProductsSet() throws Exception {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());

    ConfigurableOrderItemRequest configurableOrderItemRequest = new ConfigurableOrderItemRequest();
    configurableOrderItemRequest.setAdditionalAttributes(new HashMap<>());
    configurableOrderItemRequest.setCategoryId(1L);
    configurableOrderItemRequest.setChildOrderItems(new ArrayList<>());
    configurableOrderItemRequest.setDiscountsAllowed(true);
    configurableOrderItemRequest.setDisplayPrice(new Money());
    configurableOrderItemRequest.setExpandable(true);
    configurableOrderItemRequest.setFirstExpandable(true);
    configurableOrderItemRequest.setHasConfigurationError(true);
    configurableOrderItemRequest.setHasOverridenPrice(true);
    configurableOrderItemRequest.setIsMultiSelect(true);
    configurableOrderItemRequest.setItemAttributes(new HashMap<>());
    configurableOrderItemRequest.setLastExpandable(true);
    configurableOrderItemRequest.setMaxQuantity(3);
    configurableOrderItemRequest.setMinQuantity(1);
    configurableOrderItemRequest.setOrderItemId(1L);
    configurableOrderItemRequest.setOrderItemIndex(1);
    configurableOrderItemRequest.setOverrideRetailPrice(new Money());
    configurableOrderItemRequest.setOverrideSalePrice(new Money());
    configurableOrderItemRequest.setParentOrderItemId(1L);
    configurableOrderItemRequest.setPricingModelType("Pricing Model Type");
    configurableOrderItemRequest.setProductChoices(new ArrayList<>());
    configurableOrderItemRequest.setProductId(1L);
    configurableOrderItemRequest.setQuantity(1);
    configurableOrderItemRequest.setSkuId(1L);
    HashSet<Product> productSet = new HashSet<>();
    when(orderItemService.findAllProductsInRequest(Mockito.<ConfigurableOrderItemRequest>any())).thenReturn(productSet);
    when(orderItemService.createConfigurableOrderItemRequestFromProduct(Mockito.<Product>any()))
        .thenReturn(configurableOrderItemRequest);
    doNothing().when(orderItemService).modifyOrderItemRequest(Mockito.<ConfigurableOrderItemRequest>any());
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    HttpServletRequestWrapper servletRequest2 = new HttpServletRequestWrapper(new SearchRequestWrapper(
        new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(), new String[]{"baseItem"})));
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest2,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualConfigureResult = broadleafCartController.configure(request, response, model, 1L);

    // Assert
    verify(catalogService).findProductById(eq(1L));
    verify(orderItemService).createConfigurableOrderItemRequestFromProduct(isA(Product.class));
    verify(orderItemService).findAllProductsInRequest(isA(ConfigurableOrderItemRequest.class));
    verify(orderItemService).modifyOrderItemRequest(isA(ConfigurableOrderItemRequest.class));
    assertEquals(3, model.size());
    Object getResult = model.get("blcAllDisplayedProducts");
    assertTrue(getResult instanceof Set);
    assertEquals("redirect:/cart/configure", actualConfigureResult);
    assertTrue(((Set<Object>) getResult).isEmpty());
    assertTrue((Boolean) model.get("isUpdateRequest"));
    assertSame(productSet, getResult);
    assertSame(configurableOrderItemRequest, model.get("baseItem"));
  }

  /**
   * Test {@link BroadleafCartController#configure(HttpServletRequest, HttpServletResponse, Model, Long)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafCartController#configure(HttpServletRequest, HttpServletResponse, Model, Long)}
   */
  @Test
  @DisplayName("Test configure(HttpServletRequest, HttpServletResponse, Model, Long); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BroadleafCartController.configure(HttpServletRequest, HttpServletResponse, Model, Long)"})
  void testConfigure_thenThrowIllegalArgumentException() throws Exception {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    when(orderItemService.createConfigurableOrderItemRequestFromProduct(Mockito.<Product>any()))
        .thenThrow(new IllegalArgumentException("baseItem"));
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> broadleafCartController.configure(request, response, new ConcurrentModel(), 1L));
    verify(catalogService).findProductById(eq(1L));
    verify(orderItemService).createConfigurableOrderItemRequestFromProduct(isA(Product.class));
  }

  /**
   * Test {@link BroadleafCartController#reconfigure(HttpServletRequest, HttpServletResponse, Model, Long)}.
   * <p>
   * Method under test: {@link BroadleafCartController#reconfigure(HttpServletRequest, HttpServletResponse, Model, Long)}
   */
  @Test
  @DisplayName("Test reconfigure(HttpServletRequest, HttpServletResponse, Model, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafCartController.reconfigure(HttpServletRequest, HttpServletResponse, Model, Long)"})
  void testReconfigure() throws Exception {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getQuantity()).thenReturn(1);
    when(discreteOrderItemImpl.getProduct()).thenReturn(new ProductBundleImpl());

    ConfigurableOrderItemRequest configurableOrderItemRequest = new ConfigurableOrderItemRequest();
    configurableOrderItemRequest.setAdditionalAttributes(new HashMap<>());
    configurableOrderItemRequest.setCategoryId(1L);
    configurableOrderItemRequest.setChildOrderItems(new ArrayList<>());
    configurableOrderItemRequest.setDiscountsAllowed(true);
    configurableOrderItemRequest.setDisplayPrice(new Money());
    configurableOrderItemRequest.setExpandable(true);
    configurableOrderItemRequest.setFirstExpandable(true);
    configurableOrderItemRequest.setHasConfigurationError(true);
    configurableOrderItemRequest.setHasOverridenPrice(true);
    configurableOrderItemRequest.setIsMultiSelect(true);
    configurableOrderItemRequest.setItemAttributes(new HashMap<>());
    configurableOrderItemRequest.setLastExpandable(true);
    configurableOrderItemRequest.setMaxQuantity(3);
    configurableOrderItemRequest.setMinQuantity(1);
    configurableOrderItemRequest.setOrderItemId(1L);
    configurableOrderItemRequest.setOrderItemIndex(1);
    configurableOrderItemRequest.setOverrideRetailPrice(new Money());
    configurableOrderItemRequest.setOverrideSalePrice(new Money());
    configurableOrderItemRequest.setParentOrderItemId(1L);
    configurableOrderItemRequest.setPricingModelType("Pricing Model Type");
    configurableOrderItemRequest.setProductChoices(new ArrayList<>());
    configurableOrderItemRequest.setProductId(1L);
    configurableOrderItemRequest.setQuantity(1);
    configurableOrderItemRequest.setSkuId(1L);
    when(orderItemService.findAllProductsInRequest(Mockito.<ConfigurableOrderItemRequest>any()))
        .thenReturn(new HashSet<>());
    when(orderItemService.createConfigurableOrderItemRequestFromProduct(Mockito.<Product>any()))
        .thenReturn(configurableOrderItemRequest);
    doNothing().when(orderItemService)
        .mergeOrderItemRequest(Mockito.<ConfigurableOrderItemRequest>any(), Mockito.<OrderItem>any());
    doNothing().when(orderItemService).modifyOrderItemRequest(Mockito.<ConfigurableOrderItemRequest>any());
    when(orderItemService.readOrderItemById(Mockito.<Long>any())).thenReturn(discreteOrderItemImpl);
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(
        new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(), new String[]{"blcAjax"}));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    broadleafCartController.reconfigure(request, response, model, 1L);

    // Assert
    verify(catalogService).findProductById(isNull());
    verify(discreteOrderItemImpl).getProduct();
    verify(discreteOrderItemImpl).getQuantity();
    verify(orderItemService).createConfigurableOrderItemRequestFromProduct(isA(Product.class));
    verify(orderItemService).findAllProductsInRequest(isA(ConfigurableOrderItemRequest.class));
    verify(orderItemService).mergeOrderItemRequest(isA(ConfigurableOrderItemRequest.class), isA(OrderItem.class));
    verify(orderItemService).modifyOrderItemRequest(isA(ConfigurableOrderItemRequest.class));
    verify(orderItemService).readOrderItemById(eq(1L));
    assertEquals(4, model.size());
    assertTrue(model.get("baseItem") instanceof ConfigurableOrderItemRequest);
    assertTrue(model.containsKey("blcAllDisplayedProducts"));
    assertTrue(model.containsKey("isUpdateRequest"));
    assertTrue(model.containsKey("originalOrderItem"));
  }

  /**
   * Test {@link BroadleafCartController#reconfigure(HttpServletRequest, HttpServletResponse, Model, Long)}.
   * <ul>
   *   <li>Then {@link ConcurrentModel#ConcurrentModel()} {@code baseItem} {@link ConfigurableOrderItemRequest}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafCartController#reconfigure(HttpServletRequest, HttpServletResponse, Model, Long)}
   */
  @Test
  @DisplayName("Test reconfigure(HttpServletRequest, HttpServletResponse, Model, Long); then ConcurrentModel() 'baseItem' ConfigurableOrderItemRequest")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafCartController.reconfigure(HttpServletRequest, HttpServletResponse, Model, Long)"})
  void testReconfigure_thenConcurrentModelBaseItemConfigurableOrderItemRequest() throws Exception {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getQuantity()).thenReturn(1);
    when(discreteOrderItemImpl.getProduct()).thenReturn(new ProductBundleImpl());

    ConfigurableOrderItemRequest configurableOrderItemRequest = new ConfigurableOrderItemRequest();
    configurableOrderItemRequest.setAdditionalAttributes(new HashMap<>());
    configurableOrderItemRequest.setCategoryId(1L);
    configurableOrderItemRequest.setChildOrderItems(new ArrayList<>());
    configurableOrderItemRequest.setDiscountsAllowed(true);
    configurableOrderItemRequest.setDisplayPrice(new Money());
    configurableOrderItemRequest.setExpandable(true);
    configurableOrderItemRequest.setFirstExpandable(true);
    configurableOrderItemRequest.setHasConfigurationError(true);
    configurableOrderItemRequest.setHasOverridenPrice(true);
    configurableOrderItemRequest.setIsMultiSelect(true);
    configurableOrderItemRequest.setItemAttributes(new HashMap<>());
    configurableOrderItemRequest.setLastExpandable(true);
    configurableOrderItemRequest.setMaxQuantity(3);
    configurableOrderItemRequest.setMinQuantity(1);
    configurableOrderItemRequest.setOrderItemId(1L);
    configurableOrderItemRequest.setOrderItemIndex(1);
    configurableOrderItemRequest.setOverrideRetailPrice(new Money());
    configurableOrderItemRequest.setOverrideSalePrice(new Money());
    configurableOrderItemRequest.setParentOrderItemId(1L);
    configurableOrderItemRequest.setPricingModelType("Pricing Model Type");
    configurableOrderItemRequest.setProductChoices(new ArrayList<>());
    configurableOrderItemRequest.setProductId(1L);
    configurableOrderItemRequest.setQuantity(1);
    configurableOrderItemRequest.setSkuId(1L);
    when(orderItemService.findAllProductsInRequest(Mockito.<ConfigurableOrderItemRequest>any()))
        .thenReturn(new HashSet<>());
    when(orderItemService.createConfigurableOrderItemRequestFromProduct(Mockito.<Product>any()))
        .thenReturn(configurableOrderItemRequest);
    doNothing().when(orderItemService)
        .mergeOrderItemRequest(Mockito.<ConfigurableOrderItemRequest>any(), Mockito.<OrderItem>any());
    doNothing().when(orderItemService).modifyOrderItemRequest(Mockito.<ConfigurableOrderItemRequest>any());
    when(orderItemService.readOrderItemById(Mockito.<Long>any())).thenReturn(discreteOrderItemImpl);
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    broadleafCartController.reconfigure(request, response, model, 1L);

    // Assert
    verify(catalogService).findProductById(isNull());
    verify(discreteOrderItemImpl).getProduct();
    verify(discreteOrderItemImpl).getQuantity();
    verify(orderItemService).createConfigurableOrderItemRequestFromProduct(isA(Product.class));
    verify(orderItemService).findAllProductsInRequest(isA(ConfigurableOrderItemRequest.class));
    verify(orderItemService).mergeOrderItemRequest(isA(ConfigurableOrderItemRequest.class), isA(OrderItem.class));
    verify(orderItemService).modifyOrderItemRequest(isA(ConfigurableOrderItemRequest.class));
    verify(orderItemService).readOrderItemById(eq(1L));
    assertEquals(4, model.size());
    assertTrue(model.get("baseItem") instanceof ConfigurableOrderItemRequest);
    assertTrue(model.containsKey("blcAllDisplayedProducts"));
    assertTrue(model.containsKey("isUpdateRequest"));
    assertTrue(model.containsKey("originalOrderItem"));
  }

  /**
   * Test {@link BroadleafCartController#reconfigure(HttpServletRequest, HttpServletResponse, Model, Long)}.
   * <ul>
   *   <li>Then {@link ConcurrentModel#ConcurrentModel()} {@code blcAllDisplayedProducts} {@link Set}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafCartController#reconfigure(HttpServletRequest, HttpServletResponse, Model, Long)}
   */
  @Test
  @DisplayName("Test reconfigure(HttpServletRequest, HttpServletResponse, Model, Long); then ConcurrentModel() 'blcAllDisplayedProducts' Set")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafCartController.reconfigure(HttpServletRequest, HttpServletResponse, Model, Long)"})
  void testReconfigure_thenConcurrentModelBlcAllDisplayedProductsSet() throws Exception {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getQuantity()).thenReturn(1);
    when(discreteOrderItemImpl.getProduct()).thenReturn(new ProductBundleImpl());

    ConfigurableOrderItemRequest configurableOrderItemRequest = new ConfigurableOrderItemRequest();
    configurableOrderItemRequest.setAdditionalAttributes(new HashMap<>());
    configurableOrderItemRequest.setCategoryId(1L);
    configurableOrderItemRequest.setChildOrderItems(new ArrayList<>());
    configurableOrderItemRequest.setDiscountsAllowed(true);
    configurableOrderItemRequest.setDisplayPrice(new Money());
    configurableOrderItemRequest.setExpandable(true);
    configurableOrderItemRequest.setFirstExpandable(true);
    configurableOrderItemRequest.setHasConfigurationError(true);
    configurableOrderItemRequest.setHasOverridenPrice(true);
    configurableOrderItemRequest.setIsMultiSelect(true);
    configurableOrderItemRequest.setItemAttributes(new HashMap<>());
    configurableOrderItemRequest.setLastExpandable(true);
    configurableOrderItemRequest.setMaxQuantity(3);
    configurableOrderItemRequest.setMinQuantity(1);
    configurableOrderItemRequest.setOrderItemId(1L);
    configurableOrderItemRequest.setOrderItemIndex(1);
    configurableOrderItemRequest.setOverrideRetailPrice(new Money());
    configurableOrderItemRequest.setOverrideSalePrice(new Money());
    configurableOrderItemRequest.setParentOrderItemId(1L);
    configurableOrderItemRequest.setPricingModelType("Pricing Model Type");
    configurableOrderItemRequest.setProductChoices(new ArrayList<>());
    configurableOrderItemRequest.setProductId(1L);
    configurableOrderItemRequest.setQuantity(1);
    configurableOrderItemRequest.setSkuId(1L);
    HashSet<Product> productSet = new HashSet<>();
    when(orderItemService.findAllProductsInRequest(Mockito.<ConfigurableOrderItemRequest>any())).thenReturn(productSet);
    when(orderItemService.createConfigurableOrderItemRequestFromProduct(Mockito.<Product>any()))
        .thenReturn(configurableOrderItemRequest);
    doNothing().when(orderItemService)
        .mergeOrderItemRequest(Mockito.<ConfigurableOrderItemRequest>any(), Mockito.<OrderItem>any());
    doNothing().when(orderItemService).modifyOrderItemRequest(Mockito.<ConfigurableOrderItemRequest>any());
    when(orderItemService.readOrderItemById(Mockito.<Long>any())).thenReturn(discreteOrderItemImpl);
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper servletRequest2 = new SearchRequestWrapper(
        new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(), new String[]{"baseItem"}));
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest2,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualReconfigureResult = broadleafCartController.reconfigure(request, response, model, 1L);

    // Assert
    verify(catalogService).findProductById(isNull());
    verify(discreteOrderItemImpl).getProduct();
    verify(discreteOrderItemImpl).getQuantity();
    verify(orderItemService).createConfigurableOrderItemRequestFromProduct(isA(Product.class));
    verify(orderItemService).findAllProductsInRequest(isA(ConfigurableOrderItemRequest.class));
    verify(orderItemService).mergeOrderItemRequest(isA(ConfigurableOrderItemRequest.class), isA(OrderItem.class));
    verify(orderItemService).modifyOrderItemRequest(isA(ConfigurableOrderItemRequest.class));
    verify(orderItemService).readOrderItemById(eq(1L));
    assertEquals(4, model.size());
    Object getResult = model.get("blcAllDisplayedProducts");
    assertTrue(getResult instanceof Set);
    assertEquals("redirect:/cart/configure", actualReconfigureResult);
    assertEquals(1L, ((Long) model.get("originalOrderItem")).longValue());
    assertTrue(((Set<Object>) getResult).isEmpty());
    assertTrue((Boolean) model.get("isUpdateRequest"));
    assertSame(productSet, getResult);
    assertSame(configurableOrderItemRequest, model.get("baseItem"));
  }

  /**
   * Test {@link BroadleafCartController#reconfigure(HttpServletRequest, HttpServletResponse, Model, Long)}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafCartController#reconfigure(HttpServletRequest, HttpServletResponse, Model, Long)}
   */
  @Test
  @DisplayName("Test reconfigure(HttpServletRequest, HttpServletResponse, Model, Long); then throw NumberFormatException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafCartController.reconfigure(HttpServletRequest, HttpServletResponse, Model, Long)"})
  void testReconfigure_thenThrowNumberFormatException() throws Exception {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getQuantity()).thenThrow(new NumberFormatException("foo"));
    when(discreteOrderItemImpl.getProduct()).thenReturn(new ProductBundleImpl());

    ConfigurableOrderItemRequest configurableOrderItemRequest = new ConfigurableOrderItemRequest();
    configurableOrderItemRequest.setAdditionalAttributes(new HashMap<>());
    configurableOrderItemRequest.setCategoryId(1L);
    configurableOrderItemRequest.setChildOrderItems(new ArrayList<>());
    configurableOrderItemRequest.setDiscountsAllowed(true);
    configurableOrderItemRequest.setDisplayPrice(new Money());
    configurableOrderItemRequest.setExpandable(true);
    configurableOrderItemRequest.setFirstExpandable(true);
    configurableOrderItemRequest.setHasConfigurationError(true);
    configurableOrderItemRequest.setHasOverridenPrice(true);
    configurableOrderItemRequest.setIsMultiSelect(true);
    configurableOrderItemRequest.setItemAttributes(new HashMap<>());
    configurableOrderItemRequest.setLastExpandable(true);
    configurableOrderItemRequest.setMaxQuantity(3);
    configurableOrderItemRequest.setMinQuantity(1);
    configurableOrderItemRequest.setOrderItemId(1L);
    configurableOrderItemRequest.setOrderItemIndex(1);
    configurableOrderItemRequest.setOverrideRetailPrice(new Money());
    configurableOrderItemRequest.setOverrideSalePrice(new Money());
    configurableOrderItemRequest.setParentOrderItemId(1L);
    configurableOrderItemRequest.setPricingModelType("Pricing Model Type");
    configurableOrderItemRequest.setProductChoices(new ArrayList<>());
    configurableOrderItemRequest.setProductId(1L);
    configurableOrderItemRequest.setQuantity(1);
    configurableOrderItemRequest.setSkuId(1L);
    when(orderItemService.createConfigurableOrderItemRequestFromProduct(Mockito.<Product>any()))
        .thenReturn(configurableOrderItemRequest);
    doNothing().when(orderItemService)
        .mergeOrderItemRequest(Mockito.<ConfigurableOrderItemRequest>any(), Mockito.<OrderItem>any());
    doNothing().when(orderItemService).modifyOrderItemRequest(Mockito.<ConfigurableOrderItemRequest>any());
    when(orderItemService.readOrderItemById(Mockito.<Long>any())).thenReturn(discreteOrderItemImpl);
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertThrows(NumberFormatException.class,
        () -> broadleafCartController.reconfigure(request, response, new ConcurrentModel(), 1L));
    verify(catalogService).findProductById(isNull());
    verify(discreteOrderItemImpl).getProduct();
    verify(discreteOrderItemImpl).getQuantity();
    verify(orderItemService).createConfigurableOrderItemRequestFromProduct(isA(Product.class));
    verify(orderItemService).mergeOrderItemRequest(isA(ConfigurableOrderItemRequest.class), isA(OrderItem.class));
    verify(orderItemService).modifyOrderItemRequest(isA(ConfigurableOrderItemRequest.class));
    verify(orderItemService).readOrderItemById(eq(1L));
  }

  /**
   * Test {@link BroadleafCartController#empty(HttpServletRequest, HttpServletResponse, Model)}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafCartController#empty(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @DisplayName("Test empty(HttpServletRequest, HttpServletResponse, Model); then throw NumberFormatException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BroadleafCartController.empty(HttpServletRequest, HttpServletResponse, Model)"})
  void testEmpty_thenThrowNumberFormatException() throws PricingException {
    // Arrange
    doThrow(new NumberFormatException("ThreadLocalManager.notify.orphans")).when(orderService)
        .cancelOrder(Mockito.<Order>any());
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertThrows(NumberFormatException.class,
        () -> broadleafCartController.empty(request, response, new ConcurrentModel()));
    verify(orderService).cancelOrder(isNull());
  }

  /**
   * Test {@link BroadleafCartController#addPromo(HttpServletRequest, HttpServletResponse, Model, String)}.
   * <p>
   * Method under test: {@link BroadleafCartController#addPromo(HttpServletRequest, HttpServletResponse, Model, String)}
   */
  @Test
  @DisplayName("Test addPromo(HttpServletRequest, HttpServletResponse, Model, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BroadleafCartController.addPromo(HttpServletRequest, HttpServletResponse, Model, String)"})
  void testAddPromo() throws IOException, PricingException {
    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualAddPromoResult = broadleafCartController.addPromo(request, response, model, "Customer Offer");

    // Assert
    assertEquals(1, model.size());
    assertEquals("Invalid Cart", model.get("exception"));
    assertEquals("cart/cart", actualAddPromoResult);
  }

  /**
   * Test {@link BroadleafCartController#addPromo(HttpServletRequest, HttpServletResponse, Model, String)}.
   * <p>
   * Method under test: {@link BroadleafCartController#addPromo(HttpServletRequest, HttpServletResponse, Model, String)}
   */
  @Test
  @DisplayName("Test addPromo(HttpServletRequest, HttpServletResponse, Model, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BroadleafCartController.addPromo(HttpServletRequest, HttpServletResponse, Model, String)"})
  void testAddPromo2() throws IOException, PricingException {
    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper servletRequest2 = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"ThreadLocalManager.notify.orphans"}));
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest2,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualAddPromoResult = broadleafCartController.addPromo(request, response, model, "Customer Offer");

    // Assert
    assertEquals(1, model.size());
    assertEquals("Invalid Cart", model.get("exception"));
    assertEquals("cart/cart", actualAddPromoResult);
  }

  /**
   * Test {@link BroadleafCartController#addPromo(HttpServletRequest, HttpServletResponse, Model, String)}.
   * <p>
   * Method under test: {@link BroadleafCartController#addPromo(HttpServletRequest, HttpServletResponse, Model, String)}
   */
  @Test
  @DisplayName("Test addPromo(HttpServletRequest, HttpServletResponse, Model, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BroadleafCartController.addPromo(HttpServletRequest, HttpServletResponse, Model, String)"})
  void testAddPromo3() throws IOException, PricingException {
    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(
        new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(), new String[]{"blcAjax"}));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualAddPromoResult = broadleafCartController.addPromo(request, response, model, "Customer Offer");

    // Assert
    assertEquals(1, model.size());
    assertEquals("Invalid Cart", model.get("exception"));
    assertEquals("cart/cart", actualAddPromoResult);
  }

  /**
   * Test {@link BroadleafCartController#addPromo(HttpServletRequest, HttpServletResponse, Model, String)}.
   * <p>
   * Method under test: {@link BroadleafCartController#addPromo(HttpServletRequest, HttpServletResponse, Model, String)}
   */
  @Test
  @DisplayName("Test addPromo(HttpServletRequest, HttpServletResponse, Model, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BroadleafCartController.addPromo(HttpServletRequest, HttpServletResponse, Model, String)"})
  void testAddPromo4() throws IOException, PricingException {
    // Arrange
    SearchRequestWrapper request = new SearchRequestWrapper(new MockMultipartHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualAddPromoResult = broadleafCartController.addPromo(request, response, model, "Customer Offer");

    // Assert
    ServletRequest request2 = request.getRequest();
    assertTrue(request2 instanceof MockMultipartHttpServletRequest);
    assertEquals(1, model.size());
    assertEquals("Invalid Cart", model.get("exception"));
    assertEquals("cart/cart", actualAddPromoResult);
    assertTrue(((MockMultipartHttpServletRequest) request2).getMultiFileMap().isEmpty());
  }

  /**
   * Test {@link BroadleafCartController#isCheckoutContext(HttpServletRequest)}.
   * <p>
   * Method under test: {@link BroadleafCartController#isCheckoutContext(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test isCheckoutContext(HttpServletRequest)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BroadleafCartController.isCheckoutContext(HttpServletRequest)"})
  void testIsCheckoutContext() {
    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act and Assert
    assertFalse(broadleafCartController.isCheckoutContext(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));
  }

  /**
   * Test {@link BroadleafCartController#isCheckoutContext(HttpServletRequest)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafCartController#isCheckoutContext(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test isCheckoutContext(HttpServletRequest); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BroadleafCartController.isCheckoutContext(HttpServletRequest)"})
  void testIsCheckoutContext_thenReturnFalse() {
    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act and Assert
    assertFalse(broadleafCartController.isCheckoutContext(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"isCheckoutContext"}))));
  }

  /**
   * Test {@link BroadleafCartController#removePromo(HttpServletRequest, HttpServletResponse, Model, Long)}.
   * <p>
   * Method under test: {@link BroadleafCartController#removePromo(HttpServletRequest, HttpServletResponse, Model, Long)}
   */
  @Test
  @DisplayName("Test removePromo(HttpServletRequest, HttpServletResponse, Model, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafCartController.removePromo(HttpServletRequest, HttpServletResponse, Model, Long)"})
  void testRemovePromo() throws IOException, PricingException {
    // Arrange
    when(offerService.findOfferCodeById(Mockito.<Long>any())).thenReturn(new OfferCodeImpl());
    when(orderService.removeOfferCode(Mockito.<Order>any(), Mockito.<OfferCode>any(), anyBoolean()))
        .thenReturn(new NullOrderImpl());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(new NullOrderImpl());
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    String actualRemovePromoResult = broadleafCartController.removePromo(request, response, new ConcurrentModel(), 1L);

    // Assert
    verify(offerService).findOfferCodeById(eq(1L));
    verify(orderService).removeOfferCode(isNull(), isA(OfferCode.class), eq(false));
    verify(orderService).save(isNull(), eq(true));
    assertEquals("redirect:/cart", actualRemovePromoResult);
  }

  /**
   * Test {@link BroadleafCartController#removePromo(HttpServletRequest, HttpServletResponse, Model, Long)}.
   * <p>
   * Method under test: {@link BroadleafCartController#removePromo(HttpServletRequest, HttpServletResponse, Model, Long)}
   */
  @Test
  @DisplayName("Test removePromo(HttpServletRequest, HttpServletResponse, Model, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafCartController.removePromo(HttpServletRequest, HttpServletResponse, Model, Long)"})
  void testRemovePromo2() throws IOException, PricingException {
    // Arrange
    when(offerService.findOfferCodeById(Mockito.<Long>any())).thenReturn(new OfferCodeImpl());
    when(orderService.removeOfferCode(Mockito.<Order>any(), Mockito.<OfferCode>any(), anyBoolean()))
        .thenReturn(new NullOrderImpl());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(new NullOrderImpl());
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper servletRequest2 = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"ThreadLocalManager.notify.orphans"}));
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest2,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    String actualRemovePromoResult = broadleafCartController.removePromo(request, response, new ConcurrentModel(), 1L);

    // Assert
    verify(offerService).findOfferCodeById(eq(1L));
    verify(orderService).removeOfferCode(isNull(), isA(OfferCode.class), eq(false));
    verify(orderService).save(isNull(), eq(true));
    assertEquals("redirect:/cart", actualRemovePromoResult);
  }

  /**
   * Test {@link BroadleafCartController#removePromo(HttpServletRequest, HttpServletResponse, Model, Long)}.
   * <p>
   * Method under test: {@link BroadleafCartController#removePromo(HttpServletRequest, HttpServletResponse, Model, Long)}
   */
  @Test
  @DisplayName("Test removePromo(HttpServletRequest, HttpServletResponse, Model, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafCartController.removePromo(HttpServletRequest, HttpServletResponse, Model, Long)"})
  void testRemovePromo3() throws IOException, PricingException {
    // Arrange
    when(offerService.findOfferCodeById(Mockito.<Long>any())).thenReturn(new OfferCodeImpl());
    when(orderService.removeOfferCode(Mockito.<Order>any(), Mockito.<OfferCode>any(), anyBoolean()))
        .thenReturn(new NullOrderImpl());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(new NullOrderImpl());
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(
        new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(), new String[]{"isCheckoutContext"}));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    String actualRemovePromoResult = broadleafCartController.removePromo(request, response, new ConcurrentModel(), 1L);

    // Assert
    verify(offerService).findOfferCodeById(eq(1L));
    verify(orderService).removeOfferCode(isNull(), isA(OfferCode.class), eq(false));
    verify(orderService).save(isNull(), eq(true));
    assertEquals("redirect:/cart", actualRemovePromoResult);
  }

  /**
   * Test {@link BroadleafCartController#removePromo(HttpServletRequest, HttpServletResponse, Model, Long)}.
   * <p>
   * Method under test: {@link BroadleafCartController#removePromo(HttpServletRequest, HttpServletResponse, Model, Long)}
   */
  @Test
  @DisplayName("Test removePromo(HttpServletRequest, HttpServletResponse, Model, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafCartController.removePromo(HttpServletRequest, HttpServletResponse, Model, Long)"})
  void testRemovePromo4() throws IOException, PricingException {
    // Arrange
    when(offerService.findOfferCodeById(Mockito.<Long>any())).thenReturn(new OfferCodeImpl());
    when(orderService.removeOfferCode(Mockito.<Order>any(), Mockito.<OfferCode>any(), anyBoolean()))
        .thenReturn(new NullOrderImpl());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(new NullOrderImpl());
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(
        new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(), new String[]{"blcAjax"}));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    String actualRemovePromoResult = broadleafCartController.removePromo(request, response, new ConcurrentModel(), 1L);

    // Assert
    verify(offerService).findOfferCodeById(eq(1L));
    verify(orderService).removeOfferCode(isNull(), isA(OfferCode.class), eq(false));
    verify(orderService).save(isNull(), eq(true));
    assertEquals("redirect:/cart", actualRemovePromoResult);
  }

  /**
   * Test {@link BroadleafCartController#removePromo(HttpServletRequest, HttpServletResponse, Model, Long)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafCartController#removePromo(HttpServletRequest, HttpServletResponse, Model, Long)}
   */
  @Test
  @DisplayName("Test removePromo(HttpServletRequest, HttpServletResponse, Model, Long); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafCartController.removePromo(HttpServletRequest, HttpServletResponse, Model, Long)"})
  void testRemovePromo_thenThrowIllegalArgumentException() throws IOException, PricingException {
    // Arrange
    when(offerService.findOfferCodeById(Mockito.<Long>any())).thenReturn(new OfferCodeImpl());
    when(orderService.removeOfferCode(Mockito.<Order>any(), Mockito.<OfferCode>any(), anyBoolean()))
        .thenThrow(new IllegalArgumentException("ThreadLocalManager.notify.orphans"));
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> broadleafCartController.removePromo(request, response, new ConcurrentModel(), 1L));
    verify(offerService).findOfferCodeById(eq(1L));
    verify(orderService).removeOfferCode(isNull(), isA(OfferCode.class), eq(false));
  }

  /**
   * Test {@link BroadleafCartController#isSafeToAdd(ConfigurableOrderItemRequest)}.
   * <p>
   * Method under test: {@link BroadleafCartController#isSafeToAdd(ConfigurableOrderItemRequest)}
   */
  @Test
  @DisplayName("Test isSafeToAdd(ConfigurableOrderItemRequest)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BroadleafCartController.isSafeToAdd(ConfigurableOrderItemRequest)"})
  void testIsSafeToAdd() {
    // Arrange
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
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafCartController.<init>()", "String BroadleafCartController.getCartPageRedirect()",
      "String BroadleafCartController.getCartView()", "String BroadleafCartController.getCheckoutView()",
      "String BroadleafCartController.getConfigurePageRedirect()", "String BroadleafCartController.getConfigureView()"})
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

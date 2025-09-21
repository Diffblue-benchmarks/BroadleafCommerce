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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
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
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ExtendWith(MockitoExtension.class)
class BroadleafCartControllerDiffblueTest {
  @InjectMocks private BroadleafCartController broadleafCartController;

  @Mock private CatalogService catalogService;

  @Mock private OfferService offerService;

  @Mock private OrderItemService orderItemService;

  @Mock private OrderService orderService;

  /**
   * Test {@link BroadleafCartController#cart(HttpServletRequest, HttpServletResponse, Model)}.
   *
   * <p>Method under test: {@link BroadleafCartController#cart(HttpServletRequest,
   * HttpServletResponse, Model)}
   */
  @Test
  @DisplayName("Test cart(HttpServletRequest, HttpServletResponse, Model)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCartController.cart(HttpServletRequest, HttpServletResponse, Model)"
  })
  void testCart() throws PricingException {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertEquals(
        "cart/cart", broadleafCartController.cart(request, response, new ConcurrentModel()));
  }

  /**
   * Test {@link BroadleafCartController#updateAddRequestQuantities(OrderItemRequestDTO, Long)}.
   *
   * <p>Method under test: {@link
   * BroadleafCartController#updateAddRequestQuantities(OrderItemRequestDTO, Long)}
   */
  @Test
  @DisplayName("Test updateAddRequestQuantities(OrderItemRequestDTO, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafCartController.updateAddRequestQuantities(OrderItemRequestDTO, Long)"
  })
  void testUpdateAddRequestQuantities() {
    // Arrange
    when(orderItemService.readOrderItemById(Mockito.<Long>any()))
        .thenThrow(new NumberFormatException());

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> broadleafCartController.updateAddRequestQuantities(new OrderItemRequestDTO(), 1L));
    verify(orderItemService).readOrderItemById(1L);
  }

  /**
   * Test {@link BroadleafCartController#updateAddRequestQuantities(OrderItemRequestDTO, Long)}.
   *
   * <p>Method under test: {@link
   * BroadleafCartController#updateAddRequestQuantities(OrderItemRequestDTO, Long)}
   */
  @Test
  @DisplayName("Test updateAddRequestQuantities(OrderItemRequestDTO, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafCartController.updateAddRequestQuantities(OrderItemRequestDTO, Long)"
  })
  void testUpdateAddRequestQuantities2() {
    // Arrange
    when(orderItemService.readOrderItemById(Mockito.<Long>any()))
        .thenReturn(new BundleOrderItemImpl());

    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    orderItemRequestDTO.setQuantity(1);

    ArrayList<OrderItemRequestDTO> childOrderItems = new ArrayList<>();
    childOrderItems.add(orderItemRequestDTO);

    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO(1L, 1);
    itemRequest.setChildOrderItems(childOrderItems);

    // Act
    broadleafCartController.updateAddRequestQuantities(itemRequest, 1L);

    // Assert
    verify(orderItemService).readOrderItemById(1L);
    assertEquals(0, itemRequest.getQuantity().intValue());
    List<OrderItemRequestDTO> childOrderItems2 = itemRequest.getChildOrderItems();
    assertEquals(1, childOrderItems2.size());
    assertEquals(0, childOrderItems2.get(0).getQuantity().intValue());
  }

  /**
   * Test {@link BroadleafCartController#updateAddRequestQuantities(OrderItemRequestDTO, Long)}.
   *
   * <ul>
   *   <li>Given {@link OrderItemService} {@link OrderItemService#readOrderItemById(Long)} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafCartController#updateAddRequestQuantities(OrderItemRequestDTO, Long)}
   */
  @Test
  @DisplayName(
      "Test updateAddRequestQuantities(OrderItemRequestDTO, Long); given OrderItemService readOrderItemById(Long) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafCartController.updateAddRequestQuantities(OrderItemRequestDTO, Long)"
  })
  void testUpdateAddRequestQuantities_givenOrderItemServiceReadOrderItemByIdReturnNull() {
    // Arrange
    when(orderItemService.readOrderItemById(Mockito.<Long>any())).thenReturn(null);

    // Act
    broadleafCartController.updateAddRequestQuantities(new OrderItemRequestDTO(), 1L);

    // Assert that nothing has changed
    verify(orderItemService).readOrderItemById(1L);
  }

  /**
   * Test {@link BroadleafCartController#updateAddRequestQuantities(OrderItemRequestDTO, Long)}.
   *
   * <ul>
   *   <li>Then calls {@link BundleOrderItemImpl#getQuantity()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafCartController#updateAddRequestQuantities(OrderItemRequestDTO, Long)}
   */
  @Test
  @DisplayName(
      "Test updateAddRequestQuantities(OrderItemRequestDTO, Long); then calls getQuantity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafCartController.updateAddRequestQuantities(OrderItemRequestDTO, Long)"
  })
  void testUpdateAddRequestQuantities_thenCallsGetQuantity() {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getQuantity()).thenThrow(new NumberFormatException());
    when(orderItemService.readOrderItemById(Mockito.<Long>any())).thenReturn(bundleOrderItemImpl);

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> broadleafCartController.updateAddRequestQuantities(new OrderItemRequestDTO(), 1L));
    verify(bundleOrderItemImpl).getQuantity();
    verify(orderItemService).readOrderItemById(1L);
  }

  /**
   * Test {@link BroadleafCartController#updateAddRequestQuantities(OrderItemRequestDTO, Long)}.
   *
   * <ul>
   *   <li>Then {@link OrderItemRequestDTO#OrderItemRequestDTO()} Quantity intValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafCartController#updateAddRequestQuantities(OrderItemRequestDTO, Long)}
   */
  @Test
  @DisplayName(
      "Test updateAddRequestQuantities(OrderItemRequestDTO, Long); then OrderItemRequestDTO() Quantity intValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafCartController.updateAddRequestQuantities(OrderItemRequestDTO, Long)"
  })
  void testUpdateAddRequestQuantities_thenOrderItemRequestDTOQuantityIntValueIsZero() {
    // Arrange
    when(orderItemService.readOrderItemById(Mockito.<Long>any()))
        .thenReturn(new BundleOrderItemImpl());
    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO();

    // Act
    broadleafCartController.updateAddRequestQuantities(itemRequest, 1L);

    // Assert
    verify(orderItemService).readOrderItemById(1L);
    assertEquals(0, itemRequest.getQuantity().intValue());
  }

  /**
   * Test {@link BroadleafCartController#isUpdateRequest(HttpServletRequest)}.
   *
   * <p>Method under test: {@link BroadleafCartController#isUpdateRequest(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test isUpdateRequest(HttpServletRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafCartController.isUpdateRequest(HttpServletRequest)"})
  void testIsUpdateRequest() {
    // Arrange
    HttpServletRequestWrapper servletRequest =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    XssRequestWrapper request =
        new XssRequestWrapper(
            servletRequest, new StandardReactiveWebEnvironment(), new String[] {});

    // Act and Assert
    assertFalse(broadleafCartController.isUpdateRequest(new HttpServletRequestWrapper(request)));
  }

  /**
   * Test {@link BroadleafCartController#isUpdateRequest(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Given {@code https://example.org/example}.
   *   <li>Then calls {@link DefaultMultipartHttpServletRequest#getParameter(String)}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCartController#isUpdateRequest(HttpServletRequest)}
   */
  @Test
  @DisplayName(
      "Test isUpdateRequest(HttpServletRequest); given 'https://example.org/example'; then calls getParameter(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafCartController.isUpdateRequest(HttpServletRequest)"})
  void testIsUpdateRequest_givenHttpsExampleOrgExample_thenCallsGetParameter() {
    // Arrange
    DefaultMultipartHttpServletRequest servletRequest =
        mock(DefaultMultipartHttpServletRequest.class);
    when(servletRequest.getParameter(Mockito.<String>any()))
        .thenReturn("https://example.org/example");
    SearchRequestWrapper request = new SearchRequestWrapper(servletRequest);

    // Act
    boolean actualIsUpdateRequestResult =
        broadleafCartController.isUpdateRequest(new HttpServletRequestWrapper(request));

    // Assert
    verify(servletRequest, atLeast(1)).getParameter("isUpdateRequest");
    assertFalse(actualIsUpdateRequestResult);
  }

  /**
   * Test {@link BroadleafCartController#isUpdateRequest(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Given {@code isUpdateRequest}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCartController#isUpdateRequest(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test isUpdateRequest(HttpServletRequest); given 'isUpdateRequest'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafCartController.isUpdateRequest(HttpServletRequest)"})
  void testIsUpdateRequest_givenIsUpdateRequest() {
    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    servletRequest.addParameter("isUpdateRequest", "42");
    HttpServletRequestWrapper servletRequest2 =
        new HttpServletRequestWrapper(new SearchRequestWrapper(servletRequest));
    XssRequestWrapper request =
        new XssRequestWrapper(
            servletRequest2, new StandardReactiveWebEnvironment(), new String[] {});

    // Act and Assert
    assertFalse(broadleafCartController.isUpdateRequest(new HttpServletRequestWrapper(request)));
  }

  /**
   * Test {@link BroadleafCartController#isUpdateRequest(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCartController#isUpdateRequest(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test isUpdateRequest(HttpServletRequest); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafCartController.isUpdateRequest(HttpServletRequest)"})
  void testIsUpdateRequest_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        broadleafCartController.isUpdateRequest(
            new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()))));
  }

  /**
   * Test {@link BroadleafCartController#configure(HttpServletRequest, HttpServletResponse, Model,
   * Long)}.
   *
   * <p>Method under test: {@link BroadleafCartController#configure(HttpServletRequest,
   * HttpServletResponse, Model, Long)}
   */
  @Test
  @DisplayName("Test configure(HttpServletRequest, HttpServletResponse, Model, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCartController.configure(HttpServletRequest, HttpServletResponse, Model, Long)"
  })
  void testConfigure() throws Exception {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    when(orderItemService.createConfigurableOrderItemRequestFromProduct(Mockito.<Product>any()))
        .thenThrow(new NumberFormatException());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> broadleafCartController.configure(request, response, new ConcurrentModel(), 1L));
    verify(catalogService).findProductById(1L);
    verify(orderItemService).createConfigurableOrderItemRequestFromProduct(isA(Product.class));
  }

  /**
   * Test {@link BroadleafCartController#configure(HttpServletRequest, HttpServletResponse, Model,
   * Long)}.
   *
   * <ul>
   *   <li>Given {@link CatalogService} {@link CatalogService#findProductById(Long)} throw {@link
   *       NumberFormatException#NumberFormatException()}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCartController#configure(HttpServletRequest,
   * HttpServletResponse, Model, Long)}
   */
  @Test
  @DisplayName(
      "Test configure(HttpServletRequest, HttpServletResponse, Model, Long); given CatalogService findProductById(Long) throw NumberFormatException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCartController.configure(HttpServletRequest, HttpServletResponse, Model, Long)"
  })
  void testConfigure_givenCatalogServiceFindProductByIdThrowNumberFormatException()
      throws Exception {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any()))
        .thenThrow(new NumberFormatException());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> broadleafCartController.configure(request, response, new ConcurrentModel(), 1L));
    verify(catalogService).findProductById(1L);
  }

  /**
   * Test {@link BroadleafCartController#configure(HttpServletRequest, HttpServletResponse, Model,
   * Long)}.
   *
   * <ul>
   *   <li>Then {@link ConcurrentModel#ConcurrentModel()} {@code baseItem} {@link
   *       ConfigurableOrderItemRequest}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCartController#configure(HttpServletRequest,
   * HttpServletResponse, Model, Long)}
   */
  @Test
  @DisplayName(
      "Test configure(HttpServletRequest, HttpServletResponse, Model, Long); then ConcurrentModel() 'baseItem' ConfigurableOrderItemRequest")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCartController.configure(HttpServletRequest, HttpServletResponse, Model, Long)"
  })
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
    configurableOrderItemRequest.setProduct(new ProductBundleImpl());
    configurableOrderItemRequest.setProductChoices(new ArrayList<>());
    configurableOrderItemRequest.setProductId(1L);
    configurableOrderItemRequest.setQuantity(1);
    configurableOrderItemRequest.setSku(new SkuImpl());
    configurableOrderItemRequest.setSkuId(1L);
    when(orderItemService.findAllProductsInRequest(Mockito.<ConfigurableOrderItemRequest>any()))
        .thenReturn(new HashSet<>());
    when(orderItemService.createConfigurableOrderItemRequestFromProduct(Mockito.<Product>any()))
        .thenReturn(configurableOrderItemRequest);
    doNothing()
        .when(orderItemService)
        .modifyOrderItemRequest(Mockito.<ConfigurableOrderItemRequest>any());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    broadleafCartController.configure(request, response, model, 1L);

    // Assert
    verify(catalogService).findProductById(1L);
    verify(orderItemService).createConfigurableOrderItemRequestFromProduct(isA(Product.class));
    verify(orderItemService).findAllProductsInRequest(isA(ConfigurableOrderItemRequest.class));
    verify(orderItemService).modifyOrderItemRequest(isA(ConfigurableOrderItemRequest.class));
    assertEquals(3, model.size());
    assertTrue(model.get("baseItem") instanceof ConfigurableOrderItemRequest);
    assertTrue(model.containsKey("blcAllDisplayedProducts"));
    assertTrue(model.containsKey("isUpdateRequest"));
  }

  /**
   * Test {@link BroadleafCartController#configure(HttpServletRequest, HttpServletResponse, Model,
   * Long)}.
   *
   * <ul>
   *   <li>Then {@link ConcurrentModel#ConcurrentModel()} {@code baseItem} Product {@link
   *       ProductBundleImpl}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCartController#configure(HttpServletRequest,
   * HttpServletResponse, Model, Long)}
   */
  @Test
  @DisplayName(
      "Test configure(HttpServletRequest, HttpServletResponse, Model, Long); then ConcurrentModel() 'baseItem' Product ProductBundleImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCartController.configure(HttpServletRequest, HttpServletResponse, Model, Long)"
  })
  void testConfigure_thenConcurrentModelBaseItemProductProductBundleImpl() throws Exception {
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
    configurableOrderItemRequest.setProduct(new ProductBundleImpl());
    configurableOrderItemRequest.setProductChoices(new ArrayList<>());
    configurableOrderItemRequest.setProductId(1L);
    configurableOrderItemRequest.setQuantity(1);
    configurableOrderItemRequest.setSku(new SkuImpl());
    configurableOrderItemRequest.setSkuId(1L);
    when(orderItemService.findAllProductsInRequest(Mockito.<ConfigurableOrderItemRequest>any()))
        .thenReturn(new HashSet<>());
    when(orderItemService.createConfigurableOrderItemRequestFromProduct(Mockito.<Product>any()))
        .thenReturn(configurableOrderItemRequest);
    doNothing()
        .when(orderItemService)
        .modifyOrderItemRequest(Mockito.<ConfigurableOrderItemRequest>any());
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    String[] whiteListParamNames = new String[] {"baseItem"};

    XssRequestWrapper request =
        new XssRequestWrapper(
            servletRequest, new StandardReactiveWebEnvironment(), whiteListParamNames);
    SearchRequestWrapper servletRequest2 =
        new SearchRequestWrapper(new HttpServletRequestWrapper(request));
    SearchRequestWrapper request2 = new SearchRequestWrapper(servletRequest2);
    HttpServletRequestWrapper request3 = new HttpServletRequestWrapper(request2);
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    broadleafCartController.configure(request3, response, model, 1L);

    // Assert
    verify(catalogService).findProductById(1L);
    verify(orderItemService).createConfigurableOrderItemRequestFromProduct(isA(Product.class));
    verify(orderItemService).findAllProductsInRequest(isA(ConfigurableOrderItemRequest.class));
    verify(orderItemService).modifyOrderItemRequest(isA(ConfigurableOrderItemRequest.class));
    assertEquals(3, model.size());
    Object getResult = model.get("baseItem");
    assertTrue(
        ((ConfigurableOrderItemRequest) getResult).getProduct() instanceof ProductBundleImpl);
    assertTrue(getResult instanceof ConfigurableOrderItemRequest);
    assertTrue(model.containsKey("blcAllDisplayedProducts"));
    assertTrue(model.containsKey("isUpdateRequest"));
  }

  /**
   * Test {@link BroadleafCartController#configure(HttpServletRequest, HttpServletResponse, Model,
   * Long)}.
   *
   * <ul>
   *   <li>Then {@link ConcurrentModel#ConcurrentModel()} {@code blcAllDisplayedProducts} {@link
   *       Set}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCartController#configure(HttpServletRequest,
   * HttpServletResponse, Model, Long)}
   */
  @Test
  @DisplayName(
      "Test configure(HttpServletRequest, HttpServletResponse, Model, Long); then ConcurrentModel() 'blcAllDisplayedProducts' Set")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCartController.configure(HttpServletRequest, HttpServletResponse, Model, Long)"
  })
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
    configurableOrderItemRequest.setProduct(new ProductBundleImpl());
    configurableOrderItemRequest.setProductChoices(new ArrayList<>());
    configurableOrderItemRequest.setProductId(1L);
    configurableOrderItemRequest.setQuantity(1);
    configurableOrderItemRequest.setSku(new SkuImpl());
    configurableOrderItemRequest.setSkuId(1L);
    HashSet<Product> productSet = new HashSet<>();
    when(orderItemService.findAllProductsInRequest(Mockito.<ConfigurableOrderItemRequest>any()))
        .thenReturn(productSet);
    when(orderItemService.createConfigurableOrderItemRequestFromProduct(Mockito.<Product>any()))
        .thenReturn(configurableOrderItemRequest);
    doNothing()
        .when(orderItemService)
        .modifyOrderItemRequest(Mockito.<ConfigurableOrderItemRequest>any());
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    String[] whiteListParamNames = new String[] {"baseItem"};

    XssRequestWrapper request =
        new XssRequestWrapper(
            servletRequest, new StandardReactiveWebEnvironment(), whiteListParamNames);
    SearchRequestWrapper servletRequest2 =
        new SearchRequestWrapper(new HttpServletRequestWrapper(request));
    String[] whiteListParamNames2 = new String[] {"baseItem"};

    XssRequestWrapper request2 =
        new XssRequestWrapper(
            servletRequest2, new StandardReactiveWebEnvironment(), whiteListParamNames2);
    SearchRequestWrapper servletRequest3 =
        new SearchRequestWrapper(new HttpServletRequestWrapper(request2));
    SearchRequestWrapper request3 = new SearchRequestWrapper(servletRequest3);
    HttpServletRequestWrapper request4 = new HttpServletRequestWrapper(request3);
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualConfigureResult = broadleafCartController.configure(request4, response, model, 1L);

    // Assert
    verify(catalogService).findProductById(1L);
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
   * Test {@link BroadleafCartController#reconfigure(HttpServletRequest, HttpServletResponse, Model,
   * Long)}.
   *
   * <p>Method under test: {@link BroadleafCartController#reconfigure(HttpServletRequest,
   * HttpServletResponse, Model, Long)}
   */
  @Test
  @DisplayName("Test reconfigure(HttpServletRequest, HttpServletResponse, Model, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCartController.reconfigure(HttpServletRequest, HttpServletResponse, Model, Long)"
  })
  void testReconfigure() throws Exception {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getProduct()).thenReturn(new ProductBundleImpl());
    when(orderItemService.createConfigurableOrderItemRequestFromProduct(Mockito.<Product>any()))
        .thenThrow(new NumberFormatException());
    when(orderItemService.readOrderItemById(Mockito.<Long>any())).thenReturn(discreteOrderItemImpl);
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> broadleafCartController.reconfigure(request, response, new ConcurrentModel(), 1L));
    verify(catalogService).findProductById(isNull());
    verify(discreteOrderItemImpl).getProduct();
    verify(orderItemService).createConfigurableOrderItemRequestFromProduct(isA(Product.class));
    verify(orderItemService).readOrderItemById(1L);
  }

  /**
   * Test {@link BroadleafCartController#reconfigure(HttpServletRequest, HttpServletResponse, Model,
   * Long)}.
   *
   * <p>Method under test: {@link BroadleafCartController#reconfigure(HttpServletRequest,
   * HttpServletResponse, Model, Long)}
   */
  @Test
  @DisplayName("Test reconfigure(HttpServletRequest, HttpServletResponse, Model, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCartController.reconfigure(HttpServletRequest, HttpServletResponse, Model, Long)"
  })
  void testReconfigure2() throws Exception {
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
    configurableOrderItemRequest.setProduct(new ProductBundleImpl());
    configurableOrderItemRequest.setProductChoices(new ArrayList<>());
    configurableOrderItemRequest.setProductId(1L);
    configurableOrderItemRequest.setQuantity(1);
    configurableOrderItemRequest.setSku(new SkuImpl());
    configurableOrderItemRequest.setSkuId(1L);
    when(orderItemService.findAllProductsInRequest(Mockito.<ConfigurableOrderItemRequest>any()))
        .thenThrow(new NumberFormatException());
    when(orderItemService.createConfigurableOrderItemRequestFromProduct(Mockito.<Product>any()))
        .thenReturn(configurableOrderItemRequest);
    doNothing()
        .when(orderItemService)
        .mergeOrderItemRequest(
            Mockito.<ConfigurableOrderItemRequest>any(), Mockito.<OrderItem>any());
    doNothing()
        .when(orderItemService)
        .modifyOrderItemRequest(Mockito.<ConfigurableOrderItemRequest>any());
    when(orderItemService.readOrderItemById(Mockito.<Long>any())).thenReturn(discreteOrderItemImpl);
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> broadleafCartController.reconfigure(request, response, new ConcurrentModel(), 1L));
    verify(catalogService).findProductById(isNull());
    verify(discreteOrderItemImpl).getProduct();
    verify(discreteOrderItemImpl).getQuantity();
    verify(orderItemService).createConfigurableOrderItemRequestFromProduct(isA(Product.class));
    verify(orderItemService).findAllProductsInRequest(isA(ConfigurableOrderItemRequest.class));
    verify(orderItemService)
        .mergeOrderItemRequest(isA(ConfigurableOrderItemRequest.class), isA(OrderItem.class));
    verify(orderItemService).modifyOrderItemRequest(isA(ConfigurableOrderItemRequest.class));
    verify(orderItemService).readOrderItemById(1L);
  }

  /**
   * Test {@link BroadleafCartController#reconfigure(HttpServletRequest, HttpServletResponse, Model,
   * Long)}.
   *
   * <ul>
   *   <li>Given {@link CatalogService} {@link CatalogService#findProductById(Long)} throw {@link
   *       NumberFormatException#NumberFormatException()}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCartController#reconfigure(HttpServletRequest,
   * HttpServletResponse, Model, Long)}
   */
  @Test
  @DisplayName(
      "Test reconfigure(HttpServletRequest, HttpServletResponse, Model, Long); given CatalogService findProductById(Long) throw NumberFormatException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCartController.reconfigure(HttpServletRequest, HttpServletResponse, Model, Long)"
  })
  void testReconfigure_givenCatalogServiceFindProductByIdThrowNumberFormatException()
      throws Exception {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any()))
        .thenThrow(new NumberFormatException());

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getProduct()).thenReturn(new ProductBundleImpl());
    when(orderItemService.readOrderItemById(Mockito.<Long>any())).thenReturn(discreteOrderItemImpl);
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> broadleafCartController.reconfigure(request, response, new ConcurrentModel(), 1L));
    verify(catalogService).findProductById(isNull());
    verify(discreteOrderItemImpl).getProduct();
    verify(orderItemService).readOrderItemById(1L);
  }

  /**
   * Test {@link BroadleafCartController#reconfigure(HttpServletRequest, HttpServletResponse, Model,
   * Long)}.
   *
   * <ul>
   *   <li>Given {@link OrderItemService} {@link OrderItemService#readOrderItemById(Long)} throw
   *       {@link NumberFormatException#NumberFormatException()}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCartController#reconfigure(HttpServletRequest,
   * HttpServletResponse, Model, Long)}
   */
  @Test
  @DisplayName(
      "Test reconfigure(HttpServletRequest, HttpServletResponse, Model, Long); given OrderItemService readOrderItemById(Long) throw NumberFormatException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCartController.reconfigure(HttpServletRequest, HttpServletResponse, Model, Long)"
  })
  void testReconfigure_givenOrderItemServiceReadOrderItemByIdThrowNumberFormatException()
      throws Exception {
    // Arrange
    when(orderItemService.readOrderItemById(Mockito.<Long>any()))
        .thenThrow(new NumberFormatException());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> broadleafCartController.reconfigure(request, response, new ConcurrentModel(), 1L));
    verify(orderItemService).readOrderItemById(1L);
  }

  /**
   * Test {@link BroadleafCartController#reconfigure(HttpServletRequest, HttpServletResponse, Model,
   * Long)}.
   *
   * <ul>
   *   <li>Then {@link ConcurrentModel#ConcurrentModel()} {@code baseItem} {@link
   *       ConfigurableOrderItemRequest}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCartController#reconfigure(HttpServletRequest,
   * HttpServletResponse, Model, Long)}
   */
  @Test
  @DisplayName(
      "Test reconfigure(HttpServletRequest, HttpServletResponse, Model, Long); then ConcurrentModel() 'baseItem' ConfigurableOrderItemRequest")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCartController.reconfigure(HttpServletRequest, HttpServletResponse, Model, Long)"
  })
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
    configurableOrderItemRequest.setProduct(new ProductBundleImpl());
    configurableOrderItemRequest.setProductChoices(new ArrayList<>());
    configurableOrderItemRequest.setProductId(1L);
    configurableOrderItemRequest.setQuantity(1);
    configurableOrderItemRequest.setSku(new SkuImpl());
    configurableOrderItemRequest.setSkuId(1L);
    when(orderItemService.findAllProductsInRequest(Mockito.<ConfigurableOrderItemRequest>any()))
        .thenReturn(new HashSet<>());
    when(orderItemService.createConfigurableOrderItemRequestFromProduct(Mockito.<Product>any()))
        .thenReturn(configurableOrderItemRequest);
    doNothing()
        .when(orderItemService)
        .mergeOrderItemRequest(
            Mockito.<ConfigurableOrderItemRequest>any(), Mockito.<OrderItem>any());
    doNothing()
        .when(orderItemService)
        .modifyOrderItemRequest(Mockito.<ConfigurableOrderItemRequest>any());
    when(orderItemService.readOrderItemById(Mockito.<Long>any())).thenReturn(discreteOrderItemImpl);
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
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
    verify(orderItemService)
        .mergeOrderItemRequest(isA(ConfigurableOrderItemRequest.class), isA(OrderItem.class));
    verify(orderItemService).modifyOrderItemRequest(isA(ConfigurableOrderItemRequest.class));
    verify(orderItemService).readOrderItemById(1L);
    assertEquals(4, model.size());
    assertTrue(model.get("baseItem") instanceof ConfigurableOrderItemRequest);
    assertTrue(model.containsKey("blcAllDisplayedProducts"));
    assertTrue(model.containsKey("isUpdateRequest"));
    assertTrue(model.containsKey("originalOrderItem"));
  }

  /**
   * Test {@link BroadleafCartController#reconfigure(HttpServletRequest, HttpServletResponse, Model,
   * Long)}.
   *
   * <ul>
   *   <li>Then {@link ConcurrentModel#ConcurrentModel()} {@code blcAllDisplayedProducts} {@link
   *       Set}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCartController#reconfigure(HttpServletRequest,
   * HttpServletResponse, Model, Long)}
   */
  @Test
  @DisplayName(
      "Test reconfigure(HttpServletRequest, HttpServletResponse, Model, Long); then ConcurrentModel() 'blcAllDisplayedProducts' Set")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCartController.reconfigure(HttpServletRequest, HttpServletResponse, Model, Long)"
  })
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
    configurableOrderItemRequest.setProduct(new ProductBundleImpl());
    configurableOrderItemRequest.setProductChoices(new ArrayList<>());
    configurableOrderItemRequest.setProductId(1L);
    configurableOrderItemRequest.setQuantity(1);
    configurableOrderItemRequest.setSku(new SkuImpl());
    configurableOrderItemRequest.setSkuId(1L);
    HashSet<Product> productSet = new HashSet<>();
    when(orderItemService.findAllProductsInRequest(Mockito.<ConfigurableOrderItemRequest>any()))
        .thenReturn(productSet);
    when(orderItemService.createConfigurableOrderItemRequestFromProduct(Mockito.<Product>any()))
        .thenReturn(configurableOrderItemRequest);
    doNothing()
        .when(orderItemService)
        .mergeOrderItemRequest(
            Mockito.<ConfigurableOrderItemRequest>any(), Mockito.<OrderItem>any());
    doNothing()
        .when(orderItemService)
        .modifyOrderItemRequest(Mockito.<ConfigurableOrderItemRequest>any());
    when(orderItemService.readOrderItemById(Mockito.<Long>any())).thenReturn(discreteOrderItemImpl);
    HttpServletRequestWrapper servletRequest =
        new HttpServletRequestWrapper(new MockHttpServletRequest());
    String[] whiteListParamNames = new String[] {"baseItem"};

    XssRequestWrapper servletRequest2 =
        new XssRequestWrapper(
            servletRequest, new StandardReactiveWebEnvironment(), whiteListParamNames);
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(servletRequest2));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualReconfigureResult =
        broadleafCartController.reconfigure(request, response, model, 1L);

    // Assert
    verify(catalogService).findProductById(isNull());
    verify(discreteOrderItemImpl).getProduct();
    verify(discreteOrderItemImpl).getQuantity();
    verify(orderItemService).createConfigurableOrderItemRequestFromProduct(isA(Product.class));
    verify(orderItemService).findAllProductsInRequest(isA(ConfigurableOrderItemRequest.class));
    verify(orderItemService)
        .mergeOrderItemRequest(isA(ConfigurableOrderItemRequest.class), isA(OrderItem.class));
    verify(orderItemService).modifyOrderItemRequest(isA(ConfigurableOrderItemRequest.class));
    verify(orderItemService).readOrderItemById(1L);
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
   * Test {@link BroadleafCartController#empty(HttpServletRequest, HttpServletResponse, Model)}.
   *
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCartController#empty(HttpServletRequest,
   * HttpServletResponse, Model)}
   */
  @Test
  @DisplayName(
      "Test empty(HttpServletRequest, HttpServletResponse, Model); then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCartController.empty(HttpServletRequest, HttpServletResponse, Model)"
  })
  void testEmpty_thenThrowNumberFormatException() throws PricingException {
    // Arrange
    doThrow(new NumberFormatException()).when(orderService).cancelOrder(Mockito.<Order>any());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> broadleafCartController.empty(request, response, new ConcurrentModel()));
    verify(orderService).cancelOrder(isNull());
  }

  /**
   * Test {@link BroadleafCartController#addPromo(HttpServletRequest, HttpServletResponse, Model,
   * String)}.
   *
   * <ul>
   *   <li>When {@link HttpServletRequestWrapper#HttpServletRequestWrapper(HttpServletRequest)} with
   *       request is {@link MockHttpServletRequest#MockHttpServletRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCartController#addPromo(HttpServletRequest,
   * HttpServletResponse, Model, String)}
   */
  @Test
  @DisplayName(
      "Test addPromo(HttpServletRequest, HttpServletResponse, Model, String); when HttpServletRequestWrapper(HttpServletRequest) with request is MockHttpServletRequest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCartController.addPromo(HttpServletRequest, HttpServletResponse, Model, String)"
  })
  void testAddPromo_whenHttpServletRequestWrapperWithRequestIsMockHttpServletRequest()
      throws IOException, PricingException {
    // Arrange
    HttpServletRequestWrapper servletRequest =
        new HttpServletRequestWrapper(new MockHttpServletRequest());
    String[] whiteListParamNames = new String[] {"Invalid Cart"};

    XssRequestWrapper servletRequest2 =
        new XssRequestWrapper(
            servletRequest, new StandardReactiveWebEnvironment(), whiteListParamNames);
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(servletRequest2));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualAddPromoResult =
        broadleafCartController.addPromo(request, response, model, "Customer Offer");

    // Assert
    assertEquals(1, model.size());
    assertEquals("Invalid Cart", model.get("exception"));
    assertEquals("cart/cart", actualAddPromoResult);
  }

  /**
   * Test {@link BroadleafCartController#addPromo(HttpServletRequest, HttpServletResponse, Model,
   * String)}.
   *
   * <ul>
   *   <li>When {@link HttpServletRequestWrapper#HttpServletRequestWrapper(HttpServletRequest)} with
   *       request is {@link XssRequestWrapper#XssRequestWrapper(HttpServletRequest, Environment,
   *       String[])}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCartController#addPromo(HttpServletRequest,
   * HttpServletResponse, Model, String)}
   */
  @Test
  @DisplayName(
      "Test addPromo(HttpServletRequest, HttpServletResponse, Model, String); when HttpServletRequestWrapper(HttpServletRequest) with request is XssRequestWrapper(HttpServletRequest, Environment, String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCartController.addPromo(HttpServletRequest, HttpServletResponse, Model, String)"
  })
  void testAddPromo_whenHttpServletRequestWrapperWithRequestIsXssRequestWrapper()
      throws IOException, PricingException {
    // Arrange
    HttpServletRequestWrapper servletRequest =
        new HttpServletRequestWrapper(new MockHttpServletRequest());
    String[] whiteListParamNames = new String[] {"Invalid Cart"};

    XssRequestWrapper request =
        new XssRequestWrapper(
            servletRequest, new StandardReactiveWebEnvironment(), whiteListParamNames);
    HttpServletRequestWrapper servletRequest2 = new HttpServletRequestWrapper(request);
    String[] whiteListParamNames2 = new String[] {"Invalid Cart"};

    XssRequestWrapper servletRequest3 =
        new XssRequestWrapper(
            servletRequest2, new StandardReactiveWebEnvironment(), whiteListParamNames2);
    HttpServletRequestWrapper request2 =
        new HttpServletRequestWrapper(new SearchRequestWrapper(servletRequest3));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualAddPromoResult =
        broadleafCartController.addPromo(request2, response, model, "Customer Offer");

    // Assert
    assertEquals(1, model.size());
    assertEquals("Invalid Cart", model.get("exception"));
    assertEquals("cart/cart", actualAddPromoResult);
  }

  /**
   * Test {@link BroadleafCartController#addPromo(HttpServletRequest, HttpServletResponse, Model,
   * String)}.
   *
   * <ul>
   *   <li>When {@link SearchRequestWrapper#SearchRequestWrapper(HttpServletRequest)} with
   *       servletRequest is {@link MockHttpServletRequest#MockHttpServletRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCartController#addPromo(HttpServletRequest,
   * HttpServletResponse, Model, String)}
   */
  @Test
  @DisplayName(
      "Test addPromo(HttpServletRequest, HttpServletResponse, Model, String); when SearchRequestWrapper(HttpServletRequest) with servletRequest is MockHttpServletRequest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCartController.addPromo(HttpServletRequest, HttpServletResponse, Model, String)"
  })
  void testAddPromo_whenSearchRequestWrapperWithServletRequestIsMockHttpServletRequest()
      throws IOException, PricingException {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualAddPromoResult =
        broadleafCartController.addPromo(request, response, model, "Customer Offer");

    // Assert
    assertEquals(1, model.size());
    assertEquals("Invalid Cart", model.get("exception"));
    assertEquals("cart/cart", actualAddPromoResult);
  }

  /**
   * Test {@link BroadleafCartController#isCheckoutContext(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCartController#isCheckoutContext(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test isCheckoutContext(HttpServletRequest); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafCartController.isCheckoutContext(HttpServletRequest)"})
  void testIsCheckoutContext_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        broadleafCartController.isCheckoutContext(
            new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()))));
  }

  /**
   * Test {@link BroadleafCartController#removePromo(HttpServletRequest, HttpServletResponse, Model,
   * Long)}.
   *
   * <p>Method under test: {@link BroadleafCartController#removePromo(HttpServletRequest,
   * HttpServletResponse, Model, Long)}
   */
  @Test
  @DisplayName("Test removePromo(HttpServletRequest, HttpServletResponse, Model, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCartController.removePromo(HttpServletRequest, HttpServletResponse, Model, Long)"
  })
  void testRemovePromo() throws IOException, PricingException {
    // Arrange
    when(offerService.findOfferCodeById(Mockito.<Long>any())).thenReturn(new OfferCodeImpl());
    when(orderService.removeOfferCode(Mockito.<Order>any(), Mockito.<OfferCode>any(), anyBoolean()))
        .thenReturn(new NullOrderImpl());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any()))
        .thenReturn(new NullOrderImpl());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    String actualRemovePromoResult =
        broadleafCartController.removePromo(request, response, new ConcurrentModel(), 1L);

    // Assert
    verify(offerService).findOfferCodeById(1L);
    verify(orderService).removeOfferCode(isNull(), isA(OfferCode.class), eq(false));
    verify(orderService).save(isNull(), eq(true));
    assertEquals("redirect:/cart", actualRemovePromoResult);
  }

  /**
   * Test {@link BroadleafCartController#removePromo(HttpServletRequest, HttpServletResponse, Model,
   * Long)}.
   *
   * <p>Method under test: {@link BroadleafCartController#removePromo(HttpServletRequest,
   * HttpServletResponse, Model, Long)}
   */
  @Test
  @DisplayName("Test removePromo(HttpServletRequest, HttpServletResponse, Model, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCartController.removePromo(HttpServletRequest, HttpServletResponse, Model, Long)"
  })
  void testRemovePromo2() throws IOException, PricingException {
    // Arrange
    when(offerService.findOfferCodeById(Mockito.<Long>any())).thenReturn(new OfferCodeImpl());
    when(orderService.removeOfferCode(Mockito.<Order>any(), Mockito.<OfferCode>any(), anyBoolean()))
        .thenReturn(new NullOrderImpl());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any()))
        .thenReturn(new NullOrderImpl());
    HttpServletRequestWrapper servletRequest =
        new HttpServletRequestWrapper(new MockHttpServletRequest());
    String[] whiteListParamNames = new String[] {"isCheckoutContext"};

    XssRequestWrapper servletRequest2 =
        new XssRequestWrapper(
            servletRequest, new StandardReactiveWebEnvironment(), whiteListParamNames);
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(servletRequest2));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    String actualRemovePromoResult =
        broadleafCartController.removePromo(request, response, new ConcurrentModel(), 1L);

    // Assert
    verify(offerService).findOfferCodeById(1L);
    verify(orderService).removeOfferCode(isNull(), isA(OfferCode.class), eq(false));
    verify(orderService).save(isNull(), eq(true));
    assertEquals("redirect:/cart", actualRemovePromoResult);
  }

  /**
   * Test {@link BroadleafCartController#removePromo(HttpServletRequest, HttpServletResponse, Model,
   * Long)}.
   *
   * <p>Method under test: {@link BroadleafCartController#removePromo(HttpServletRequest,
   * HttpServletResponse, Model, Long)}
   */
  @Test
  @DisplayName("Test removePromo(HttpServletRequest, HttpServletResponse, Model, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCartController.removePromo(HttpServletRequest, HttpServletResponse, Model, Long)"
  })
  void testRemovePromo3() throws IOException, PricingException {
    // Arrange
    when(offerService.findOfferCodeById(Mockito.<Long>any())).thenReturn(new OfferCodeImpl());
    when(orderService.removeOfferCode(Mockito.<Order>any(), Mockito.<OfferCode>any(), anyBoolean()))
        .thenReturn(new NullOrderImpl());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any()))
        .thenReturn(new NullOrderImpl());
    HttpServletRequestWrapper servletRequest =
        new HttpServletRequestWrapper(new MockHttpServletRequest());
    XssRequestWrapper servletRequest2 =
        new XssRequestWrapper(
            servletRequest, new StandardReactiveWebEnvironment(), new String[] {});
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(servletRequest2));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    String actualRemovePromoResult =
        broadleafCartController.removePromo(request, response, new ConcurrentModel(), 1L);

    // Assert
    verify(offerService).findOfferCodeById(1L);
    verify(orderService).removeOfferCode(isNull(), isA(OfferCode.class), eq(false));
    verify(orderService).save(isNull(), eq(true));
    assertEquals("redirect:/cart", actualRemovePromoResult);
  }

  /**
   * Test {@link BroadleafCartController#removePromo(HttpServletRequest, HttpServletResponse, Model,
   * Long)}.
   *
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCartController#removePromo(HttpServletRequest,
   * HttpServletResponse, Model, Long)}
   */
  @Test
  @DisplayName(
      "Test removePromo(HttpServletRequest, HttpServletResponse, Model, Long); then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCartController.removePromo(HttpServletRequest, HttpServletResponse, Model, Long)"
  })
  void testRemovePromo_thenThrowNumberFormatException() throws IOException, PricingException {
    // Arrange
    when(offerService.findOfferCodeById(Mockito.<Long>any()))
        .thenThrow(new NumberFormatException());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> broadleafCartController.removePromo(request, response, new ConcurrentModel(), 1L));
    verify(offerService).findOfferCodeById(1L);
  }

  /**
   * Test {@link BroadleafCartController#removePromo(HttpServletRequest, HttpServletResponse, Model,
   * Long)}.
   *
   * <ul>
   *   <li>Then throw {@link PricingException}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCartController#removePromo(HttpServletRequest,
   * HttpServletResponse, Model, Long)}
   */
  @Test
  @DisplayName(
      "Test removePromo(HttpServletRequest, HttpServletResponse, Model, Long); then throw PricingException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCartController.removePromo(HttpServletRequest, HttpServletResponse, Model, Long)"
  })
  void testRemovePromo_thenThrowPricingException() throws IOException, PricingException {
    // Arrange
    when(offerService.findOfferCodeById(Mockito.<Long>any())).thenReturn(new OfferCodeImpl());
    when(orderService.removeOfferCode(Mockito.<Order>any(), Mockito.<OfferCode>any(), anyBoolean()))
        .thenThrow(new PricingException("An error occurred"));
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertThrows(
        PricingException.class,
        () -> broadleafCartController.removePromo(request, response, new ConcurrentModel(), 1L));
    verify(offerService).findOfferCodeById(1L);
    verify(orderService).removeOfferCode(isNull(), isA(OfferCode.class), eq(false));
  }

  /**
   * Test {@link BroadleafCartController#removePromo(HttpServletRequest, HttpServletResponse, Model,
   * Long)}.
   *
   * <ul>
   *   <li>When {@link HttpServletRequestWrapper#HttpServletRequestWrapper(HttpServletRequest)} with
   *       request is {@link XssRequestWrapper#XssRequestWrapper(HttpServletRequest, Environment,
   *       String[])}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCartController#removePromo(HttpServletRequest,
   * HttpServletResponse, Model, Long)}
   */
  @Test
  @DisplayName(
      "Test removePromo(HttpServletRequest, HttpServletResponse, Model, Long); when HttpServletRequestWrapper(HttpServletRequest) with request is XssRequestWrapper(HttpServletRequest, Environment, String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCartController.removePromo(HttpServletRequest, HttpServletResponse, Model, Long)"
  })
  void testRemovePromo_whenHttpServletRequestWrapperWithRequestIsXssRequestWrapper()
      throws IOException, PricingException {
    // Arrange
    when(offerService.findOfferCodeById(Mockito.<Long>any())).thenReturn(new OfferCodeImpl());
    when(orderService.removeOfferCode(Mockito.<Order>any(), Mockito.<OfferCode>any(), anyBoolean()))
        .thenReturn(new NullOrderImpl());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any()))
        .thenReturn(new NullOrderImpl());
    HttpServletRequestWrapper servletRequest =
        new HttpServletRequestWrapper(new MockHttpServletRequest());
    String[] whiteListParamNames = new String[] {"isCheckoutContext"};

    XssRequestWrapper request =
        new XssRequestWrapper(
            servletRequest, new StandardReactiveWebEnvironment(), whiteListParamNames);
    HttpServletRequestWrapper servletRequest2 = new HttpServletRequestWrapper(request);
    String[] whiteListParamNames2 = new String[] {"isCheckoutContext"};

    XssRequestWrapper servletRequest3 =
        new XssRequestWrapper(
            servletRequest2, new StandardReactiveWebEnvironment(), whiteListParamNames2);
    HttpServletRequestWrapper request2 =
        new HttpServletRequestWrapper(new SearchRequestWrapper(servletRequest3));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    String actualRemovePromoResult =
        broadleafCartController.removePromo(request2, response, new ConcurrentModel(), 1L);

    // Assert
    verify(offerService).findOfferCodeById(1L);
    verify(orderService).removeOfferCode(isNull(), isA(OfferCode.class), eq(false));
    verify(orderService).save(isNull(), eq(true));
    assertEquals("redirect:/cart", actualRemovePromoResult);
  }

  /**
   * Test {@link BroadleafCartController#isSafeToAdd(ConfigurableOrderItemRequest)}.
   *
   * <p>Method under test: {@link BroadleafCartController#isSafeToAdd(ConfigurableOrderItemRequest)}
   */
  @Test
  @DisplayName("Test isSafeToAdd(ConfigurableOrderItemRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    itemRequest.setProduct(new ProductBundleImpl());
    itemRequest.setProductChoices(new ArrayList<>());
    itemRequest.setProductId(1L);
    itemRequest.setQuantity(1);
    itemRequest.setSku(new SkuImpl());
    itemRequest.setSkuId(1L);

    // Act and Assert
    assertFalse(broadleafCartController.isSafeToAdd(itemRequest));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafCartController.<init>()",
    "String BroadleafCartController.getCartPageRedirect()",
    "String BroadleafCartController.getCartView()",
    "String BroadleafCartController.getCheckoutView()",
    "String BroadleafCartController.getConfigurePageRedirect()",
    "String BroadleafCartController.getConfigureView()"
  })
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

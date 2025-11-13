package org.broadleafcommerce.core.web.controller.cart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
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
import org.broadleafcommerce.core.order.service.call.NonDiscreteOrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

@RunWith(MockitoJUnitRunner.class)
public class BroadleafCartControllerDiffblueTest {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCartController.cart(HttpServletRequest, HttpServletResponse, Model)"
  })
  public void testCart() throws PricingException {
    // Arrange
    BroadleafCartController broadleafCartController = new BroadleafCartController();
    MockHttpServletRequest request = new MockHttpServletRequest();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafCartController.updateAddRequestQuantities(OrderItemRequestDTO, Long)"
  })
  public void testUpdateAddRequestQuantities() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafCartController.updateAddRequestQuantities(OrderItemRequestDTO, Long)"
  })
  public void testUpdateAddRequestQuantities2() {
    // Arrange
    when(orderItemService.readOrderItemById(Mockito.<Long>any()))
        .thenReturn(new BundleOrderItemImpl());

    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    orderItemRequestDTO.setQuantity(1);

    ArrayList<OrderItemRequestDTO> childOrderItems = new ArrayList<>();
    childOrderItems.add(orderItemRequestDTO);

    NonDiscreteOrderItemRequestDTO itemRequest =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafCartController.updateAddRequestQuantities(OrderItemRequestDTO, Long)"
  })
  public void testUpdateAddRequestQuantities_givenOrderItemServiceReadOrderItemByIdReturnNull() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafCartController.updateAddRequestQuantities(OrderItemRequestDTO, Long)"
  })
  public void testUpdateAddRequestQuantities_thenCallsGetQuantity() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafCartController.updateAddRequestQuantities(OrderItemRequestDTO, Long)"
  })
  public void testUpdateAddRequestQuantities_thenOrderItemRequestDTOQuantityIntValueIsZero() {
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
   * <ul>
   *   <li>Given {@link Boolean#FALSE} toString.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCartController#isUpdateRequest(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafCartController.isUpdateRequest(HttpServletRequest)"})
  public void testIsUpdateRequest_givenFalseToString() {
    // Arrange
    BroadleafCartController broadleafCartController = new BroadleafCartController();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("isUpdateRequest", Boolean.FALSE.toString());

    // Act and Assert
    assertFalse(broadleafCartController.isUpdateRequest(request));
  }

  /**
   * Test {@link BroadleafCartController#isUpdateRequest(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Given {@link Boolean#TRUE} toString.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCartController#isUpdateRequest(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafCartController.isUpdateRequest(HttpServletRequest)"})
  public void testIsUpdateRequest_givenTrueToString_thenReturnTrue() {
    // Arrange
    BroadleafCartController broadleafCartController = new BroadleafCartController();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("isUpdateRequest", Boolean.TRUE.toString());

    // Act and Assert
    assertTrue(broadleafCartController.isUpdateRequest(request));
  }

  /**
   * Test {@link BroadleafCartController#isUpdateRequest(HttpServletRequest)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCartController#isUpdateRequest(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafCartController.isUpdateRequest(HttpServletRequest)"})
  public void testIsUpdateRequest_whenMockHttpServletRequest_thenReturnFalse() {
    // Arrange
    BroadleafCartController broadleafCartController = new BroadleafCartController();

    // Act and Assert
    assertFalse(broadleafCartController.isUpdateRequest(new MockHttpServletRequest()));
  }

  /**
   * Test {@link BroadleafCartController#configure(HttpServletRequest, HttpServletResponse, Model,
   * Long)}.
   *
   * <p>Method under test: {@link BroadleafCartController#configure(HttpServletRequest,
   * HttpServletResponse, Model, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCartController.configure(HttpServletRequest, HttpServletResponse, Model, Long)"
  })
  public void testConfigure() throws Exception {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    when(orderItemService.createConfigurableOrderItemRequestFromProduct(Mockito.<Product>any()))
        .thenThrow(new NumberFormatException());
    MockHttpServletRequest request = new MockHttpServletRequest();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCartController.configure(HttpServletRequest, HttpServletResponse, Model, Long)"
  })
  public void testConfigure_givenCatalogServiceFindProductByIdThrowNumberFormatException()
      throws Exception {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any()))
        .thenThrow(new NumberFormatException());
    MockHttpServletRequest request = new MockHttpServletRequest();
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
   *   <li>Then {@link ConcurrentModel#ConcurrentModel()} size is three.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCartController#configure(HttpServletRequest,
   * HttpServletResponse, Model, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCartController.configure(HttpServletRequest, HttpServletResponse, Model, Long)"
  })
  public void testConfigure_thenConcurrentModelSizeIsThree() throws Exception {
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
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualConfigureResult = broadleafCartController.configure(request, response, model, 1L);

    // Assert
    verify(catalogService).findProductById(1L);
    verify(orderItemService).createConfigurableOrderItemRequestFromProduct(isA(Product.class));
    verify(orderItemService).findAllProductsInRequest(isA(ConfigurableOrderItemRequest.class));
    verify(orderItemService).modifyOrderItemRequest(isA(ConfigurableOrderItemRequest.class));
    assertEquals(3, model.size());
    Object getResult = model.get("blcAllDisplayedProducts");
    assertTrue(getResult instanceof Set);
    Object getResult2 = model.get("baseItem");
    assertTrue(getResult2 instanceof ConfigurableOrderItemRequest);
    assertEquals("redirect:/cart/configure", actualConfigureResult);
    assertTrue(((Set<Object>) getResult).isEmpty());
    assertTrue((Boolean) model.get("isUpdateRequest"));
    assertSame(productSet, getResult);
    assertSame(configurableOrderItemRequest, getResult2);
  }

  /**
   * Test {@link BroadleafCartController#reconfigure(HttpServletRequest, HttpServletResponse, Model,
   * Long)}.
   *
   * <p>Method under test: {@link BroadleafCartController#reconfigure(HttpServletRequest,
   * HttpServletResponse, Model, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCartController.reconfigure(HttpServletRequest, HttpServletResponse, Model, Long)"
  })
  public void testReconfigure() throws Exception {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getProduct()).thenReturn(new ProductBundleImpl());
    when(orderItemService.createConfigurableOrderItemRequestFromProduct(Mockito.<Product>any()))
        .thenThrow(new NumberFormatException());
    when(orderItemService.readOrderItemById(Mockito.<Long>any())).thenReturn(discreteOrderItemImpl);
    MockHttpServletRequest request = new MockHttpServletRequest();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCartController.reconfigure(HttpServletRequest, HttpServletResponse, Model, Long)"
  })
  public void testReconfigure2() throws Exception {
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
    MockHttpServletRequest request = new MockHttpServletRequest();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCartController.reconfigure(HttpServletRequest, HttpServletResponse, Model, Long)"
  })
  public void testReconfigure_givenCatalogServiceFindProductByIdThrowNumberFormatException()
      throws Exception {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any()))
        .thenThrow(new NumberFormatException());

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getProduct()).thenReturn(new ProductBundleImpl());
    when(orderItemService.readOrderItemById(Mockito.<Long>any())).thenReturn(discreteOrderItemImpl);
    MockHttpServletRequest request = new MockHttpServletRequest();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCartController.reconfigure(HttpServletRequest, HttpServletResponse, Model, Long)"
  })
  public void testReconfigure_givenOrderItemServiceReadOrderItemByIdThrowNumberFormatException()
      throws Exception {
    // Arrange
    when(orderItemService.readOrderItemById(Mockito.<Long>any()))
        .thenThrow(new NumberFormatException());
    MockHttpServletRequest request = new MockHttpServletRequest();
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
   *   <li>Then {@link ConcurrentModel#ConcurrentModel()} size is four.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCartController#reconfigure(HttpServletRequest,
   * HttpServletResponse, Model, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCartController.reconfigure(HttpServletRequest, HttpServletResponse, Model, Long)"
  })
  public void testReconfigure_thenConcurrentModelSizeIsFour() throws Exception {
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
    MockHttpServletRequest request = new MockHttpServletRequest();
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
    Object getResult2 = model.get("baseItem");
    assertTrue(getResult2 instanceof ConfigurableOrderItemRequest);
    assertEquals("redirect:/cart/configure", actualReconfigureResult);
    assertEquals(1L, ((Long) model.get("originalOrderItem")).longValue());
    assertTrue(((Set<Object>) getResult).isEmpty());
    assertTrue((Boolean) model.get("isUpdateRequest"));
    assertSame(productSet, getResult);
    assertSame(configurableOrderItemRequest, getResult2);
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCartController.empty(HttpServletRequest, HttpServletResponse, Model)"
  })
  public void testEmpty_thenThrowNumberFormatException() throws PricingException {
    // Arrange
    doThrow(new NumberFormatException()).when(orderService).cancelOrder(Mockito.<Order>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
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
   * <p>Method under test: {@link BroadleafCartController#addPromo(HttpServletRequest,
   * HttpServletResponse, Model, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCartController.addPromo(HttpServletRequest, HttpServletResponse, Model, String)"
  })
  public void testAddPromo() throws IOException, PricingException {
    // Arrange
    BroadleafCartController broadleafCartController = new BroadleafCartController();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("blcAjax", Boolean.TRUE.toString());
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act and Assert
    assertEquals(
        "cart/cart", broadleafCartController.addPromo(request, response, model, "Customer Offer"));
    assertEquals(1, model.size());
    assertEquals(
        "{\"promoAdded\":false,\"exception\":\"Invalid Cart\"}", model.get("blcextradata"));
  }

  /**
   * Test {@link BroadleafCartController#addPromo(HttpServletRequest, HttpServletResponse, Model,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link Boolean#FALSE} toString.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCartController#addPromo(HttpServletRequest,
   * HttpServletResponse, Model, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCartController.addPromo(HttpServletRequest, HttpServletResponse, Model, String)"
  })
  public void testAddPromo_givenFalseToString() throws IOException, PricingException {
    // Arrange
    BroadleafCartController broadleafCartController = new BroadleafCartController();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("isCheckoutContext", Boolean.FALSE.toString());
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
   *   <li>Then return {@code checkout/checkout}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCartController#addPromo(HttpServletRequest,
   * HttpServletResponse, Model, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCartController.addPromo(HttpServletRequest, HttpServletResponse, Model, String)"
  })
  public void testAddPromo_thenReturnCheckoutCheckout() throws IOException, PricingException {
    // Arrange
    BroadleafCartController broadleafCartController = new BroadleafCartController();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("isCheckoutContext", Boolean.TRUE.toString());
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualAddPromoResult =
        broadleafCartController.addPromo(request, response, model, "Customer Offer");

    // Assert
    assertEquals(1, model.size());
    assertEquals("Invalid Cart", model.get("exception"));
    assertEquals("checkout/checkout", actualAddPromoResult);
  }

  /**
   * Test {@link BroadleafCartController#isCheckoutContext(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Given {@code isCheckoutContext}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCartController#isCheckoutContext(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafCartController.isCheckoutContext(HttpServletRequest)"})
  public void testIsCheckoutContext_givenIsCheckoutContext_thenReturnTrue() {
    // Arrange
    BroadleafCartController broadleafCartController = new BroadleafCartController();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("isCheckoutContext", Boolean.TRUE.toString());

    // Act and Assert
    assertTrue(broadleafCartController.isCheckoutContext(request));
  }

  /**
   * Test {@link BroadleafCartController#isCheckoutContext(HttpServletRequest)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCartController#isCheckoutContext(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafCartController.isCheckoutContext(HttpServletRequest)"})
  public void testIsCheckoutContext_whenMockHttpServletRequest_thenReturnFalse() {
    // Arrange
    BroadleafCartController broadleafCartController = new BroadleafCartController();

    // Act and Assert
    assertFalse(broadleafCartController.isCheckoutContext(new MockHttpServletRequest()));
  }

  /**
   * Test {@link BroadleafCartController#removePromo(HttpServletRequest, HttpServletResponse, Model,
   * Long)}.
   *
   * <ul>
   *   <li>Given {@code isCheckoutContext}.
   *   <li>Then return {@code checkout/checkout}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCartController#removePromo(HttpServletRequest,
   * HttpServletResponse, Model, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCartController.removePromo(HttpServletRequest, HttpServletResponse, Model, Long)"
  })
  public void testRemovePromo_givenIsCheckoutContext_thenReturnCheckoutCheckout()
      throws IOException, PricingException {
    // Arrange
    when(offerService.findOfferCodeById(Mockito.<Long>any())).thenReturn(new OfferCodeImpl());
    when(orderService.removeOfferCode(Mockito.<Order>any(), Mockito.<OfferCode>any(), anyBoolean()))
        .thenReturn(new NullOrderImpl());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any()))
        .thenReturn(new NullOrderImpl());

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("isCheckoutContext", Boolean.TRUE.toString());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    String actualRemovePromoResult =
        broadleafCartController.removePromo(request, response, new ConcurrentModel(), 1L);

    // Assert
    verify(offerService).findOfferCodeById(1L);
    verify(orderService).removeOfferCode(isNull(), isA(OfferCode.class), eq(false));
    verify(orderService).save(isNull(), eq(true));
    assertEquals("checkout/checkout", actualRemovePromoResult);
  }

  /**
   * Test {@link BroadleafCartController#removePromo(HttpServletRequest, HttpServletResponse, Model,
   * Long)}.
   *
   * <ul>
   *   <li>Then return {@code redirect:/cart}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCartController#removePromo(HttpServletRequest,
   * HttpServletResponse, Model, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCartController.removePromo(HttpServletRequest, HttpServletResponse, Model, Long)"
  })
  public void testRemovePromo_thenReturnRedirectCart() throws IOException, PricingException {
    // Arrange
    when(offerService.findOfferCodeById(Mockito.<Long>any())).thenReturn(new OfferCodeImpl());
    when(orderService.removeOfferCode(Mockito.<Order>any(), Mockito.<OfferCode>any(), anyBoolean()))
        .thenReturn(new NullOrderImpl());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any()))
        .thenReturn(new NullOrderImpl());
    MockHttpServletRequest request = new MockHttpServletRequest();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCartController.removePromo(HttpServletRequest, HttpServletResponse, Model, Long)"
  })
  public void testRemovePromo_thenThrowNumberFormatException()
      throws IOException, PricingException {
    // Arrange
    when(offerService.findOfferCodeById(Mockito.<Long>any()))
        .thenThrow(new NumberFormatException());
    MockHttpServletRequest request = new MockHttpServletRequest();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafCartController.removePromo(HttpServletRequest, HttpServletResponse, Model, Long)"
  })
  public void testRemovePromo_thenThrowPricingException() throws IOException, PricingException {
    // Arrange
    when(offerService.findOfferCodeById(Mockito.<Long>any())).thenReturn(new OfferCodeImpl());
    when(orderService.removeOfferCode(Mockito.<Order>any(), Mockito.<OfferCode>any(), anyBoolean()))
        .thenThrow(new PricingException());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertThrows(
        PricingException.class,
        () -> broadleafCartController.removePromo(request, response, new ConcurrentModel(), 1L));
    verify(offerService).findOfferCodeById(1L);
    verify(orderService).removeOfferCode(isNull(), isA(OfferCode.class), eq(false));
  }

  /**
   * Test {@link BroadleafCartController#isSafeToAdd(ConfigurableOrderItemRequest)}.
   *
   * <p>Method under test: {@link BroadleafCartController#isSafeToAdd(ConfigurableOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafCartController.isSafeToAdd(ConfigurableOrderItemRequest)"})
  public void testIsSafeToAdd() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafCartController.<init>()",
    "String BroadleafCartController.getCartPageRedirect()",
    "String BroadleafCartController.getCartView()",
    "String BroadleafCartController.getCheckoutView()",
    "String BroadleafCartController.getConfigurePageRedirect()",
    "String BroadleafCartController.getConfigureView()"
  })
  public void testGettersAndSetters() {
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

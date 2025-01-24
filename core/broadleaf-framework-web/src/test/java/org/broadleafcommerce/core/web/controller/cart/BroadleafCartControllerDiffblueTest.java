package org.broadleafcommerce.core.web.controller.cart;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.service.CatalogService;
import org.broadleafcommerce.core.offer.service.OfferService;
import org.broadleafcommerce.core.order.service.OrderItemService;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.order.service.call.AddToCartItem;
import org.broadleafcommerce.core.order.service.call.ConfigurableOrderItemRequest;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.exception.AddToCartException;
import org.broadleafcommerce.core.order.service.exception.IllegalCartOperationException;
import org.broadleafcommerce.core.order.service.exception.RemoveFromCartException;
import org.broadleafcommerce.core.order.service.exception.UpdateCartException;
import org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOService;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.broadleafcommerce.core.web.service.UpdateCartService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ContextConfiguration(classes = {BroadleafCartController.class})
@ExtendWith(SpringExtension.class)
class BroadleafCartControllerDiffblueTest {
  @Autowired
  private BroadleafCartController broadleafCartController;

  @MockBean
  private CatalogService catalogService;

  @MockBean
  private OfferService offerService;

  @MockBean
  private OrderItemService orderItemService;

  @MockBean
  private OrderService orderService;

  @MockBean
  private OrderToPaymentRequestDTOService orderToPaymentRequestDTOService;

  @MockBean
  private UpdateCartService updateCartService;

  /**
   * Test
   * {@link BroadleafCartController#cart(HttpServletRequest, HttpServletResponse, Model)}.
   * <p>
   * Method under test:
   * {@link BroadleafCartController#cart(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @DisplayName("Test cart(HttpServletRequest, HttpServletResponse, Model)")
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
   * Test
   * {@link BroadleafCartController#cart(HttpServletRequest, HttpServletResponse, Model)}.
   * <p>
   * Method under test:
   * {@link BroadleafCartController#cart(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @DisplayName("Test cart(HttpServletRequest, HttpServletResponse, Model)")
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
   * Test
   * {@link BroadleafCartController#cart(HttpServletRequest, HttpServletResponse, Model)}.
   * <p>
   * Method under test:
   * {@link BroadleafCartController#cart(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @DisplayName("Test cart(HttpServletRequest, HttpServletResponse, Model)")
  @Disabled("TODO: Complete this test")
  void testCart3() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.cart;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.cart.BroadleafCartController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass14 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.cart.BroadleafCartController broadleafCartController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.service.CatalogService catalogService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderService orderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOService orderToPaymentRequestDTOService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.web.service.UpdateCartService updateCartService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafCartController.cart(request, response, new ConcurrentModel());
  }

  /**
   * Test
   * {@link BroadleafCartController#add(HttpServletRequest, HttpServletResponse, Model, OrderItemRequestDTO)}.
   * <p>
   * Method under test:
   * {@link BroadleafCartController#add(HttpServletRequest, HttpServletResponse, Model, OrderItemRequestDTO)}
   */
  @Test
  @DisplayName("Test add(HttpServletRequest, HttpServletResponse, Model, OrderItemRequestDTO)")
  @Disabled("TODO: Complete this test")
  void testAdd()
      throws IOException, IllegalArgumentException, AddToCartException, RemoveFromCartException, PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.cart;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.cart.BroadleafCartController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass10 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.cart.BroadleafCartController broadleafCartController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.service.CatalogService catalogService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderService orderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOService orderToPaymentRequestDTOService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.web.service.UpdateCartService updateCartService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    broadleafCartController.add(request, response, model, new OrderItemRequestDTO());
  }

  /**
   * Test
   * {@link BroadleafCartController#updateAddRequestQuantities(OrderItemRequestDTO, Long)}.
   * <p>
   * Method under test:
   * {@link BroadleafCartController#updateAddRequestQuantities(OrderItemRequestDTO, Long)}
   */
  @Test
  @DisplayName("Test updateAddRequestQuantities(OrderItemRequestDTO, Long)")
  @Disabled("TODO: Complete this test")
  void testUpdateAddRequestQuantities() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.cart;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.cart.BroadleafCartController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass24 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.cart.BroadleafCartController broadleafCartController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.service.CatalogService catalogService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderService orderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOService orderToPaymentRequestDTOService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.web.service.UpdateCartService updateCartService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    broadleafCartController.updateAddRequestQuantities(new OrderItemRequestDTO(), 1L);
  }

  /**
   * Test {@link BroadleafCartController#isUpdateRequest(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link BroadleafCartController#isUpdateRequest(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test isUpdateRequest(HttpServletRequest)")
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
   * Test {@link BroadleafCartController#isUpdateRequest(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link BroadleafCartController#isUpdateRequest(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test isUpdateRequest(HttpServletRequest)")
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
   * Test {@link BroadleafCartController#isUpdateRequest(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link BroadleafCartController#isUpdateRequest(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test isUpdateRequest(HttpServletRequest)")
  @Disabled("TODO: Complete this test")
  void testIsUpdateRequest3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.cart;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.cart.BroadleafCartController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass20 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.cart.BroadleafCartController broadleafCartController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.service.CatalogService catalogService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderService orderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOService orderToPaymentRequestDTOService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.web.service.UpdateCartService updateCartService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    broadleafCartController.isUpdateRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})));
  }

  /**
   * Test {@link BroadleafCartController#isUpdateRequest(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@code https://example.org/example}.</li>
   *   <li>Then calls
   * {@link DefaultMultipartHttpServletRequest#getParameter(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafCartController#isUpdateRequest(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test isUpdateRequest(HttpServletRequest); given 'https://example.org/example'; then calls getParameter(String)")
  void testIsUpdateRequest_givenHttpsExampleOrgExample_thenCallsGetParameter() {
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
   * Test
   * {@link BroadleafCartController#addWithPriceOverride(HttpServletRequest, HttpServletResponse, Model, AddToCartItem)}
   * with {@code HttpServletRequest}, {@code HttpServletResponse}, {@code Model},
   * {@code AddToCartItem}.
   * <p>
   * Method under test:
   * {@link BroadleafCartController#addWithPriceOverride(HttpServletRequest, HttpServletResponse, Model, AddToCartItem)}
   */
  @Test
  @DisplayName("Test addWithPriceOverride(HttpServletRequest, HttpServletResponse, Model, AddToCartItem) with 'HttpServletRequest', 'HttpServletResponse', 'Model', 'AddToCartItem'")
  @Disabled("TODO: Complete this test")
  void testAddWithPriceOverrideWithHttpServletRequestHttpServletResponseModelAddToCartItem()
      throws IOException, AddToCartException, PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.cart;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.cart.BroadleafCartController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass12 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.cart.BroadleafCartController broadleafCartController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.service.CatalogService catalogService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderService orderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOService orderToPaymentRequestDTOService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.web.service.UpdateCartService updateCartService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    broadleafCartController.addWithPriceOverride(request, response, model, new AddToCartItem());
  }

  /**
   * Test
   * {@link BroadleafCartController#addWithPriceOverride(HttpServletRequest, HttpServletResponse, Model, OrderItemRequestDTO)}
   * with {@code HttpServletRequest}, {@code HttpServletResponse}, {@code Model},
   * {@code OrderItemRequestDTO}.
   * <p>
   * Method under test:
   * {@link BroadleafCartController#addWithPriceOverride(HttpServletRequest, HttpServletResponse, Model, OrderItemRequestDTO)}
   */
  @Test
  @DisplayName("Test addWithPriceOverride(HttpServletRequest, HttpServletResponse, Model, OrderItemRequestDTO) with 'HttpServletRequest', 'HttpServletResponse', 'Model', 'OrderItemRequestDTO'")
  @Disabled("TODO: Complete this test")
  void testAddWithPriceOverrideWithHttpServletRequestHttpServletResponseModelOrderItemRequestDTO()
      throws IOException, AddToCartException, PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.cart;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.cart.BroadleafCartController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass13 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.cart.BroadleafCartController broadleafCartController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.service.CatalogService catalogService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderService orderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOService orderToPaymentRequestDTOService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.web.service.UpdateCartService updateCartService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    broadleafCartController.addWithPriceOverride(request, response, model, new OrderItemRequestDTO());
  }

  /**
   * Test
   * {@link BroadleafCartController#configure(HttpServletRequest, HttpServletResponse, Model, Long)}.
   * <p>
   * Method under test:
   * {@link BroadleafCartController#configure(HttpServletRequest, HttpServletResponse, Model, Long)}
   */
  @Test
  @DisplayName("Test configure(HttpServletRequest, HttpServletResponse, Model, Long)")
  @Disabled("TODO: Complete this test")
  void testConfigure() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.cart;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.cart.BroadleafCartController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass15 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.cart.BroadleafCartController broadleafCartController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.service.CatalogService catalogService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderService orderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOService orderToPaymentRequestDTOService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.web.service.UpdateCartService updateCartService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafCartController.configure(request, response, new ConcurrentModel(), 1L);
  }

  /**
   * Test
   * {@link BroadleafCartController#reconfigure(HttpServletRequest, HttpServletResponse, Model, Long)}.
   * <p>
   * Method under test:
   * {@link BroadleafCartController#reconfigure(HttpServletRequest, HttpServletResponse, Model, Long)}
   */
  @Test
  @DisplayName("Test reconfigure(HttpServletRequest, HttpServletResponse, Model, Long)")
  @Disabled("TODO: Complete this test")
  void testReconfigure() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.cart;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.cart.BroadleafCartController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass21 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.cart.BroadleafCartController broadleafCartController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.service.CatalogService catalogService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderService orderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOService orderToPaymentRequestDTOService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.web.service.UpdateCartService updateCartService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafCartController.reconfigure(request, response, new ConcurrentModel(), 1L);
  }

  /**
   * Test
   * {@link BroadleafCartController#updateQuantity(HttpServletRequest, HttpServletResponse, Model, AddToCartItem)}
   * with {@code HttpServletRequest}, {@code HttpServletResponse}, {@code Model},
   * {@code AddToCartItem}.
   * <p>
   * Method under test:
   * {@link BroadleafCartController#updateQuantity(HttpServletRequest, HttpServletResponse, Model, AddToCartItem)}
   */
  @Test
  @DisplayName("Test updateQuantity(HttpServletRequest, HttpServletResponse, Model, AddToCartItem) with 'HttpServletRequest', 'HttpServletResponse', 'Model', 'AddToCartItem'")
  @Disabled("TODO: Complete this test")
  void testUpdateQuantityWithHttpServletRequestHttpServletResponseModelAddToCartItem()
      throws IOException, RemoveFromCartException, UpdateCartException, PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.cart;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.cart.BroadleafCartController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass25 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.cart.BroadleafCartController broadleafCartController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.service.CatalogService catalogService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderService orderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOService orderToPaymentRequestDTOService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.web.service.UpdateCartService updateCartService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    broadleafCartController.updateQuantity(request, response, model, new AddToCartItem());
  }

  /**
   * Test
   * {@link BroadleafCartController#updateQuantity(HttpServletRequest, HttpServletResponse, Model, OrderItemRequestDTO)}
   * with {@code HttpServletRequest}, {@code HttpServletResponse}, {@code Model},
   * {@code OrderItemRequestDTO}.
   * <p>
   * Method under test:
   * {@link BroadleafCartController#updateQuantity(HttpServletRequest, HttpServletResponse, Model, OrderItemRequestDTO)}
   */
  @Test
  @DisplayName("Test updateQuantity(HttpServletRequest, HttpServletResponse, Model, OrderItemRequestDTO) with 'HttpServletRequest', 'HttpServletResponse', 'Model', 'OrderItemRequestDTO'")
  @Disabled("TODO: Complete this test")
  void testUpdateQuantityWithHttpServletRequestHttpServletResponseModelOrderItemRequestDTO()
      throws IOException, RemoveFromCartException, UpdateCartException, PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.cart;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.cart.BroadleafCartController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass26 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.cart.BroadleafCartController broadleafCartController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.service.CatalogService catalogService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderService orderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOService orderToPaymentRequestDTOService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.web.service.UpdateCartService updateCartService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    broadleafCartController.updateQuantity(request, response, model, new OrderItemRequestDTO());
  }

  /**
   * Test
   * {@link BroadleafCartController#remove(HttpServletRequest, HttpServletResponse, Model, OrderItemRequestDTO)}.
   * <p>
   * Method under test:
   * {@link BroadleafCartController#remove(HttpServletRequest, HttpServletResponse, Model, OrderItemRequestDTO)}
   */
  @Test
  @DisplayName("Test remove(HttpServletRequest, HttpServletResponse, Model, OrderItemRequestDTO)")
  @Disabled("TODO: Complete this test")
  void testRemove() throws IOException, RemoveFromCartException, PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.cart;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.cart.BroadleafCartController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass22 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.cart.BroadleafCartController broadleafCartController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.service.CatalogService catalogService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderService orderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOService orderToPaymentRequestDTOService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.web.service.UpdateCartService updateCartService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    broadleafCartController.remove(request, response, model, new OrderItemRequestDTO());
  }

  /**
   * Test
   * {@link BroadleafCartController#empty(HttpServletRequest, HttpServletResponse, Model)}.
   * <p>
   * Method under test:
   * {@link BroadleafCartController#empty(HttpServletRequest, HttpServletResponse, Model)}
   */
  @Test
  @DisplayName("Test empty(HttpServletRequest, HttpServletResponse, Model)")
  @Disabled("TODO: Complete this test")
  void testEmpty() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.cart;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.cart.BroadleafCartController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass16 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.cart.BroadleafCartController broadleafCartController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.service.CatalogService catalogService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderService orderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOService orderToPaymentRequestDTOService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.web.service.UpdateCartService updateCartService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafCartController.empty(request, response, new ConcurrentModel());
  }

  /**
   * Test
   * {@link BroadleafCartController#addPromo(HttpServletRequest, HttpServletResponse, Model, String)}.
   * <p>
   * Method under test:
   * {@link BroadleafCartController#addPromo(HttpServletRequest, HttpServletResponse, Model, String)}
   */
  @Test
  @DisplayName("Test addPromo(HttpServletRequest, HttpServletResponse, Model, String)")
  void testAddPromo() throws IOException, PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCartController broadleafCartController = new BroadleafCartController();
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
   * Test
   * {@link BroadleafCartController#addPromo(HttpServletRequest, HttpServletResponse, Model, String)}.
   * <p>
   * Method under test:
   * {@link BroadleafCartController#addPromo(HttpServletRequest, HttpServletResponse, Model, String)}
   */
  @Test
  @DisplayName("Test addPromo(HttpServletRequest, HttpServletResponse, Model, String)")
  void testAddPromo2() throws IOException, PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCartController broadleafCartController = new BroadleafCartController();
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
   * Test
   * {@link BroadleafCartController#addPromo(HttpServletRequest, HttpServletResponse, Model, String)}.
   * <p>
   * Method under test:
   * {@link BroadleafCartController#addPromo(HttpServletRequest, HttpServletResponse, Model, String)}
   */
  @Test
  @DisplayName("Test addPromo(HttpServletRequest, HttpServletResponse, Model, String)")
  void testAddPromo3() throws IOException, PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCartController broadleafCartController = new BroadleafCartController();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(new MockHttpServletRequest(),
        mock(Environment.class), new String[]{"White List Param Names"}));
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
   * Test
   * {@link BroadleafCartController#addPromo(HttpServletRequest, HttpServletResponse, Model, String)}.
   * <p>
   * Method under test:
   * {@link BroadleafCartController#addPromo(HttpServletRequest, HttpServletResponse, Model, String)}
   */
  @Test
  @DisplayName("Test addPromo(HttpServletRequest, HttpServletResponse, Model, String)")
  void testAddPromo4() throws IOException, PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCartController broadleafCartController = new BroadleafCartController();
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
   * Test
   * {@link BroadleafCartController#addPromo(HttpServletRequest, HttpServletResponse, Model, String)}.
   * <p>
   * Method under test:
   * {@link BroadleafCartController#addPromo(HttpServletRequest, HttpServletResponse, Model, String)}
   */
  @Test
  @DisplayName("Test addPromo(HttpServletRequest, HttpServletResponse, Model, String)")
  void testAddPromo5() throws IOException, PricingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCartController broadleafCartController = new BroadleafCartController();
    SearchRequestWrapper request = new SearchRequestWrapper(new MockMultipartHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafCartController.addPromo(request, response, new ConcurrentModel(), "Customer Offer");

    // Assert
    ServletRequest request2 = request.getRequest();
    assertTrue(request2 instanceof MockMultipartHttpServletRequest);
    assertTrue(((MockMultipartHttpServletRequest) request2).getMultiFileMap().isEmpty());
  }

  /**
   * Test
   * {@link BroadleafCartController#addPromo(HttpServletRequest, HttpServletResponse, Model, String)}.
   * <p>
   * Method under test:
   * {@link BroadleafCartController#addPromo(HttpServletRequest, HttpServletResponse, Model, String)}
   */
  @Test
  @DisplayName("Test addPromo(HttpServletRequest, HttpServletResponse, Model, String)")
  @Disabled("TODO: Complete this test")
  void testAddPromo6() throws IOException, PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.cart;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.cart.BroadleafCartController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass11 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.cart.BroadleafCartController broadleafCartController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.service.CatalogService catalogService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderService orderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOService orderToPaymentRequestDTOService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.web.service.UpdateCartService updateCartService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafCartController.addPromo(request, response, new ConcurrentModel(), "Customer Offer");
  }

  /**
   * Test {@link BroadleafCartController#isCheckoutContext(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link BroadleafCartController#isCheckoutContext(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test isCheckoutContext(HttpServletRequest)")
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
   * Test {@link BroadleafCartController#isCheckoutContext(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link BroadleafCartController#isCheckoutContext(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test isCheckoutContext(HttpServletRequest)")
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
   * Test {@link BroadleafCartController#isCheckoutContext(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link BroadleafCartController#isCheckoutContext(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test isCheckoutContext(HttpServletRequest)")
  @Disabled("TODO: Complete this test")
  void testIsCheckoutContext3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.cart;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.cart.BroadleafCartController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass18 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.cart.BroadleafCartController broadleafCartController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.service.CatalogService catalogService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderService orderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOService orderToPaymentRequestDTOService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.web.service.UpdateCartService updateCartService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    broadleafCartController.isCheckoutContext(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})));
  }

  /**
   * Test
   * {@link BroadleafCartController#removePromo(HttpServletRequest, HttpServletResponse, Model, Long)}.
   * <p>
   * Method under test:
   * {@link BroadleafCartController#removePromo(HttpServletRequest, HttpServletResponse, Model, Long)}
   */
  @Test
  @DisplayName("Test removePromo(HttpServletRequest, HttpServletResponse, Model, Long)")
  @Disabled("TODO: Complete this test")
  void testRemovePromo() throws IOException, PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.cart;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.cart.BroadleafCartController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass23 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.cart.BroadleafCartController broadleafCartController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.service.CatalogService catalogService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderService orderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOService orderToPaymentRequestDTOService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.web.service.UpdateCartService updateCartService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafCartController.removePromo(request, response, new ConcurrentModel(), 1L);
  }

  /**
   * Test
   * {@link BroadleafCartController#handleIllegalCartOpException(IllegalCartOperationException)}.
   * <p>
   * Method under test:
   * {@link BroadleafCartController#handleIllegalCartOpException(IllegalCartOperationException)}
   */
  @Test
  @DisplayName("Test handleIllegalCartOpException(IllegalCartOperationException)")
  @Disabled("TODO: Complete this test")
  void testHandleIllegalCartOpException() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.cart;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.cart.BroadleafCartController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass17 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.cart.BroadleafCartController broadleafCartController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.service.CatalogService catalogService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderService orderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOService orderToPaymentRequestDTOService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.web.service.UpdateCartService updateCartService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    broadleafCartController.handleIllegalCartOpException(null);
  }

  /**
   * Test
   * {@link BroadleafCartController#isSafeToAdd(ConfigurableOrderItemRequest)}.
   * <p>
   * Method under test:
   * {@link BroadleafCartController#isSafeToAdd(ConfigurableOrderItemRequest)}
   */
  @Test
  @DisplayName("Test isSafeToAdd(ConfigurableOrderItemRequest)")
  @Disabled("TODO: Complete this test")
  void testIsSafeToAdd() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.cart;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.cart.BroadleafCartController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass19 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.cart.BroadleafCartController broadleafCartController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.service.CatalogService catalogService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.offer.service.OfferService offerService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderItemService orderItemService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderService orderService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOService orderToPaymentRequestDTOService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.web.service.UpdateCartService updateCartService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

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

    // Act
    broadleafCartController.isSafeToAdd(itemRequest);
  }

  /**
   * Test
   * {@link BroadleafCartController#isSafeToAdd(ConfigurableOrderItemRequest)}.
   * <ul>
   *   <li>Given {@link OrderItemRequestDTO#OrderItemRequestDTO()}.</li>
   *   <li>Then calls
   * {@link ConfigurableOrderItemRequest#setDiscountsAllowed(Boolean)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafCartController#isSafeToAdd(ConfigurableOrderItemRequest)}
   */
  @Test
  @DisplayName("Test isSafeToAdd(ConfigurableOrderItemRequest); given OrderItemRequestDTO(); then calls setDiscountsAllowed(Boolean)")
  void testIsSafeToAdd_givenOrderItemRequestDTO_thenCallsSetDiscountsAllowed() {
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
   * Test
   * {@link BroadleafCartController#isSafeToAdd(ConfigurableOrderItemRequest)}.
   * <ul>
   *   <li>When {@link ConfigurableOrderItemRequest} (default constructor)
   * AdditionalAttributes is {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafCartController#isSafeToAdd(ConfigurableOrderItemRequest)}
   */
  @Test
  @DisplayName("Test isSafeToAdd(ConfigurableOrderItemRequest); when ConfigurableOrderItemRequest (default constructor) AdditionalAttributes is HashMap()")
  void testIsSafeToAdd_whenConfigurableOrderItemRequestAdditionalAttributesIsHashMap() {
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

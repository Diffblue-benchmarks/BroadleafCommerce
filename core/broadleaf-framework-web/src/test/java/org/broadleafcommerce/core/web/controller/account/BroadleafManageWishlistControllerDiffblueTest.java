package org.broadleafcommerce.core.web.controller.account;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.exception.AddToCartException;
import org.broadleafcommerce.core.order.service.exception.RemoveFromCartException;
import org.broadleafcommerce.core.order.service.exception.UpdateCartException;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

class BroadleafManageWishlistControllerDiffblueTest {
  /**
   * Test
   * {@link BroadleafManageWishlistController#add(HttpServletRequest, HttpServletResponse, Model, OrderItemRequestDTO, String)}.
   * <ul>
   *   <li>When {@link ConcurrentModel#ConcurrentModel()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafManageWishlistController#add(HttpServletRequest, HttpServletResponse, Model, OrderItemRequestDTO, String)}
   */
  @Test
  @DisplayName("Test add(HttpServletRequest, HttpServletResponse, Model, OrderItemRequestDTO, String); when ConcurrentModel()")
  @Disabled("TODO: Complete this test")
  void testAdd_whenConcurrentModel() throws IOException, AddToCartException, PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.web.BroadleafRequestCustomerResolverImpl.getRequestCustomerResolver(BroadleafRequestCustomerResolverImpl.java:79)
    //       at org.broadleafcommerce.profile.web.core.CustomerState.getCustomer(CustomerState.java:39)
    //       at org.broadleafcommerce.core.web.controller.account.BroadleafManageWishlistController.add(BroadleafManageWishlistController.java:64)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    BroadleafManageWishlistController broadleafManageWishlistController = new BroadleafManageWishlistController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    broadleafManageWishlistController.add(request, response, model, new OrderItemRequestDTO(), "Wishlist Name");
  }

  /**
   * Test
   * {@link BroadleafManageWishlistController#viewWishlist(HttpServletRequest, HttpServletResponse, Model, String)}.
   * <ul>
   *   <li>When {@link ConcurrentModel#ConcurrentModel()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafManageWishlistController#viewWishlist(HttpServletRequest, HttpServletResponse, Model, String)}
   */
  @Test
  @DisplayName("Test viewWishlist(HttpServletRequest, HttpServletResponse, Model, String); when ConcurrentModel()")
  @Disabled("TODO: Complete this test")
  void testViewWishlist_whenConcurrentModel() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.web.controller.account.BroadleafManageWishlistController.viewWishlist(BroadleafManageWishlistController.java:78)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    BroadleafManageWishlistController broadleafManageWishlistController = new BroadleafManageWishlistController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafManageWishlistController.viewWishlist(request, response, new ConcurrentModel(), "Wishlist Name");
  }

  /**
   * Test
   * {@link BroadleafManageWishlistController#updateQuantityInWishlist(HttpServletRequest, HttpServletResponse, Model, String, OrderItemRequestDTO)}.
   * <ul>
   *   <li>When {@link ConcurrentModel#ConcurrentModel()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafManageWishlistController#updateQuantityInWishlist(HttpServletRequest, HttpServletResponse, Model, String, OrderItemRequestDTO)}
   */
  @Test
  @DisplayName("Test updateQuantityInWishlist(HttpServletRequest, HttpServletResponse, Model, String, OrderItemRequestDTO); when ConcurrentModel()")
  @Disabled("TODO: Complete this test")
  void testUpdateQuantityInWishlist_whenConcurrentModel()
      throws IOException, RemoveFromCartException, UpdateCartException, PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.web.controller.account.BroadleafManageWishlistController.updateQuantityInWishlist(BroadleafManageWishlistController.java:85)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    BroadleafManageWishlistController broadleafManageWishlistController = new BroadleafManageWishlistController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    broadleafManageWishlistController.updateQuantityInWishlist(request, response, model, "Wishlist Name",
        new OrderItemRequestDTO());
  }

  /**
   * Test
   * {@link BroadleafManageWishlistController#removeItemFromWishlist(HttpServletRequest, HttpServletResponse, Model, String, Long)}.
   * <ul>
   *   <li>When {@link ConcurrentModel#ConcurrentModel()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafManageWishlistController#removeItemFromWishlist(HttpServletRequest, HttpServletResponse, Model, String, Long)}
   */
  @Test
  @DisplayName("Test removeItemFromWishlist(HttpServletRequest, HttpServletResponse, Model, String, Long); when ConcurrentModel()")
  @Disabled("TODO: Complete this test")
  void testRemoveItemFromWishlist_whenConcurrentModel() throws RemoveFromCartException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.web.controller.account.BroadleafManageWishlistController.removeItemFromWishlist(BroadleafManageWishlistController.java:96)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    BroadleafManageWishlistController broadleafManageWishlistController = new BroadleafManageWishlistController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafManageWishlistController.removeItemFromWishlist(request, response, new ConcurrentModel(), "Wishlist Name",
        1L);
  }

  /**
   * Test
   * {@link BroadleafManageWishlistController#moveItemToCart(HttpServletRequest, HttpServletResponse, Model, String, Long)}.
   * <ul>
   *   <li>When {@link ConcurrentModel#ConcurrentModel()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafManageWishlistController#moveItemToCart(HttpServletRequest, HttpServletResponse, Model, String, Long)}
   */
  @Test
  @DisplayName("Test moveItemToCart(HttpServletRequest, HttpServletResponse, Model, String, Long); when ConcurrentModel()")
  @Disabled("TODO: Complete this test")
  void testMoveItemToCart_whenConcurrentModel() throws AddToCartException, RemoveFromCartException, PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.web.controller.account.BroadleafManageWishlistController.moveItemToCart(BroadleafManageWishlistController.java:106)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    BroadleafManageWishlistController broadleafManageWishlistController = new BroadleafManageWishlistController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafManageWishlistController.moveItemToCart(request, response, new ConcurrentModel(), "Wishlist Name", 1L);
  }

  /**
   * Test
   * {@link BroadleafManageWishlistController#moveListToCart(HttpServletRequest, HttpServletResponse, Model, String)}.
   * <ul>
   *   <li>When {@link ConcurrentModel#ConcurrentModel()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafManageWishlistController#moveListToCart(HttpServletRequest, HttpServletResponse, Model, String)}
   */
  @Test
  @DisplayName("Test moveListToCart(HttpServletRequest, HttpServletResponse, Model, String); when ConcurrentModel()")
  @Disabled("TODO: Complete this test")
  void testMoveListToCart_whenConcurrentModel() throws AddToCartException, RemoveFromCartException, PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.web.controller.account.BroadleafManageWishlistController.moveListToCart(BroadleafManageWishlistController.java:136)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    BroadleafManageWishlistController broadleafManageWishlistController = new BroadleafManageWishlistController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafManageWishlistController.moveListToCart(request, response, new ConcurrentModel(), "Wishlist Name");
  }

  /**
   * Test {@link BroadleafManageWishlistController#isWishlistValid(Order)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) DateCreated is
   * {@link java.sql.Date}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafManageWishlistController#isWishlistValid(Order)}
   */
  @Test
  @DisplayName("Test isWishlistValid(Order); given Auditable (default constructor) DateCreated is Date; then return 'true'")
  void testIsWishlistValid_givenAuditableDateCreatedIsDate_thenReturnTrue() {
    // Arrange
    BroadleafManageWishlistController broadleafManageWishlistController = new BroadleafManageWishlistController();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(mock(java.sql.Date.class));
    auditable.setDateUpdated(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl wishlist = new OrderImpl();
    wishlist.setAdditionalOfferInformation(new HashMap<>());
    wishlist.setAuditable(auditable);
    wishlist.setCandidateOrderOffers(new ArrayList<>());
    wishlist.setCurrency(new BroadleafCurrencyImpl());
    wishlist.setCustomer(new CustomerImpl());
    wishlist.setEmailAddress("42 Main St");
    wishlist.setFulfillmentGroups(new ArrayList<>());
    wishlist.setId(1L);
    wishlist.setLocale(new LocaleImpl());
    wishlist.setName("Name");
    wishlist.setOrderAttributes(new HashMap<>());
    wishlist.setOrderItems(new ArrayList<>());
    wishlist.setOrderMessages(new ArrayList<>());
    wishlist.setOrderNumber("42");
    wishlist.setPayments(new ArrayList<>());
    wishlist.setStatus(new OrderStatus("Type", "Friendly Type"));
    wishlist.setSubTotal(new Money());
    wishlist
        .setSubmitDate(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    wishlist.setTaxOverride(true);
    wishlist.setTotal(new Money());
    wishlist.setTotalFulfillmentCharges(new Money());
    wishlist.setTotalShipping(new Money());
    wishlist.setTotalTax(new Money());

    // Act and Assert
    assertTrue(broadleafManageWishlistController.isWishlistValid(wishlist));
  }

  /**
   * Test {@link BroadleafManageWishlistController#isWishlistValid(Order)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafManageWishlistController#isWishlistValid(Order)}
   */
  @Test
  @DisplayName("Test isWishlistValid(Order); then return 'true'")
  void testIsWishlistValid_thenReturnTrue() {
    // Arrange
    BroadleafManageWishlistController broadleafManageWishlistController = new BroadleafManageWishlistController();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl wishlist = new OrderImpl();
    wishlist.setAdditionalOfferInformation(new HashMap<>());
    wishlist.setAuditable(auditable);
    wishlist.setCandidateOrderOffers(new ArrayList<>());
    wishlist.setCurrency(new BroadleafCurrencyImpl());
    wishlist.setCustomer(new CustomerImpl());
    wishlist.setEmailAddress("42 Main St");
    wishlist.setFulfillmentGroups(new ArrayList<>());
    wishlist.setId(1L);
    wishlist.setLocale(new LocaleImpl());
    wishlist.setName("Name");
    wishlist.setOrderAttributes(new HashMap<>());
    wishlist.setOrderItems(new ArrayList<>());
    wishlist.setOrderMessages(new ArrayList<>());
    wishlist.setOrderNumber("42");
    wishlist.setPayments(new ArrayList<>());
    wishlist.setStatus(new OrderStatus("Type", "Friendly Type"));
    wishlist.setSubTotal(new Money());
    wishlist.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    wishlist.setTaxOverride(true);
    wishlist.setTotal(new Money());
    wishlist.setTotalFulfillmentCharges(new Money());
    wishlist.setTotalShipping(new Money());
    wishlist.setTotalTax(new Money());

    // Act and Assert
    assertTrue(broadleafManageWishlistController.isWishlistValid(wishlist));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link BroadleafManageWishlistController}
   *   <li>{@link BroadleafManageWishlistController#getAccountWishlistRedirect()}
   *   <li>{@link BroadleafManageWishlistController#getAccountWishlistView()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    BroadleafManageWishlistController actualBroadleafManageWishlistController = new BroadleafManageWishlistController();
    String actualAccountWishlistRedirect = actualBroadleafManageWishlistController.getAccountWishlistRedirect();

    // Assert
    assertEquals("account/manageWishlist", actualBroadleafManageWishlistController.getAccountWishlistView());
    assertEquals("redirect:/account/wishlist", actualAccountWishlistRedirect);
  }
}

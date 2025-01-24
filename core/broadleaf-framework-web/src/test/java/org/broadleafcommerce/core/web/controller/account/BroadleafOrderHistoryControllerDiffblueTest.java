package org.broadleafcommerce.core.web.controller.account;

import static org.junit.jupiter.api.Assertions.assertEquals;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.core.catalog.service.CatalogService;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.broadleafcommerce.core.web.service.OrderHistoryService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

@ContextConfiguration(classes = {BroadleafOrderHistoryController.class})
@ExtendWith(SpringExtension.class)
class BroadleafOrderHistoryControllerDiffblueTest {
  @Autowired
  private BroadleafOrderHistoryController broadleafOrderHistoryController;

  @MockBean
  private CatalogService catalogService;

  @MockBean
  private OrderHistoryService orderHistoryService;

  @MockBean
  private OrderService orderService;

  /**
   * Test
   * {@link BroadleafOrderHistoryController#viewOrderHistory(HttpServletRequest, Model)}.
   * <p>
   * Method under test:
   * {@link BroadleafOrderHistoryController#viewOrderHistory(HttpServletRequest, Model)}
   */
  @Test
  @DisplayName("Test viewOrderHistory(HttpServletRequest, Model)")
  @Disabled("TODO: Complete this test")
  void testViewOrderHistory() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.account;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.account.BroadleafOrderHistoryController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.account.BroadleafOrderHistoryController broadleafOrderHistoryController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.service.CatalogService catalogService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.web.service.OrderHistoryService orderHistoryService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderService orderService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act
    broadleafOrderHistoryController.viewOrderHistory(request, new ConcurrentModel());
  }

  /**
   * Test
   * {@link BroadleafOrderHistoryController#viewOrderDetails(HttpServletRequest, Model, String)}.
   * <p>
   * Method under test:
   * {@link BroadleafOrderHistoryController#viewOrderDetails(HttpServletRequest, Model, String)}
   */
  @Test
  @DisplayName("Test viewOrderDetails(HttpServletRequest, Model, String)")
  @Disabled("TODO: Complete this test")
  void testViewOrderDetails() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.account;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.account.BroadleafOrderHistoryController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.account.BroadleafOrderHistoryController broadleafOrderHistoryController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.service.CatalogService catalogService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.web.service.OrderHistoryService orderHistoryService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderService orderService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act
    broadleafOrderHistoryController.viewOrderDetails(request, new ConcurrentModel(), "42");
  }

  /**
   * Test
   * {@link BroadleafOrderHistoryController#validateCustomerOwnedData(Order)}.
   * <p>
   * Method under test:
   * {@link BroadleafOrderHistoryController#validateCustomerOwnedData(Order)}
   */
  @Test
  @DisplayName("Test validateCustomerOwnedData(Order)")
  @Disabled("TODO: Complete this test")
  void testValidateCustomerOwnedData() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.account;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.web.controller.account.BroadleafOrderHistoryController.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass0 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.account.BroadleafOrderHistoryController broadleafOrderHistoryController;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.service.CatalogService catalogService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.web.service.OrderHistoryService orderHistoryService;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.order.service.OrderService orderService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    broadleafOrderHistoryController.validateCustomerOwnedData(new NullOrderImpl());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link BroadleafOrderHistoryController}
   *   <li>{@link BroadleafOrderHistoryController#getOrderDetailsRedirectView()}
   *   <li>{@link BroadleafOrderHistoryController#getOrderDetailsView()}
   *   <li>{@link BroadleafOrderHistoryController#getOrderHistoryView()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
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

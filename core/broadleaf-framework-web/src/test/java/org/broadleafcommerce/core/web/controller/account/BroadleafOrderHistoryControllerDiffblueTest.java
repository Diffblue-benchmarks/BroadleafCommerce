package org.broadleafcommerce.core.web.controller.account;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.web.service.OrderHistoryService;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

@RunWith(MockitoJUnitRunner.class)
public class BroadleafOrderHistoryControllerDiffblueTest {
  @InjectMocks private BroadleafOrderHistoryController broadleafOrderHistoryController;

  @Mock private OrderHistoryService orderHistoryService;

  @Mock private OrderService orderService;

  /**
   * Test {@link BroadleafOrderHistoryController#viewOrderHistory(HttpServletRequest, Model)}.
   *
   * <p>Method under test: {@link
   * BroadleafOrderHistoryController#viewOrderHistory(HttpServletRequest, Model)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafOrderHistoryController.viewOrderHistory(HttpServletRequest, Model)"
  })
  public void testViewOrderHistory() {
    // Arrange
    ArrayList<Order> orderList = new ArrayList<>();
    when(orderService.findOrdersForCustomer(Mockito.<Customer>any(), Mockito.<OrderStatus>any()))
        .thenReturn(orderList);
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualViewOrderHistoryResult =
        broadleafOrderHistoryController.viewOrderHistory(request, model);

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
   * Test {@link BroadleafOrderHistoryController#viewOrderDetails(HttpServletRequest, Model,
   * String)}.
   *
   * <p>Method under test: {@link
   * BroadleafOrderHistoryController#viewOrderDetails(HttpServletRequest, Model, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafOrderHistoryController.viewOrderDetails(HttpServletRequest, Model, String)"
  })
  public void testViewOrderDetails() {
    // Arrange
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderHistoryService.getOrderDetails(Mockito.<String>any())).thenReturn(nullOrderImpl);
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualViewOrderDetailsResult =
        broadleafOrderHistoryController.viewOrderDetails(request, model, "42");

    // Assert
    verify(orderHistoryService).getOrderDetails("42");
    assertEquals(1, model.size());
    Object getResult = model.get("order");
    assertTrue(getResult instanceof NullOrderImpl);
    assertEquals("account/partials/orderDetails", actualViewOrderDetailsResult);
    assertSame(nullOrderImpl, getResult);
  }

  /**
   * Test {@link BroadleafOrderHistoryController#validateCustomerOwnedData(Order)}.
   *
   * <p>Method under test: {@link BroadleafOrderHistoryController#validateCustomerOwnedData(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafOrderHistoryController.validateCustomerOwnedData(Order)"})
  public void testValidateCustomerOwnedData() throws SecurityException {
    // Arrange
    doNothing().when(orderHistoryService).validateCustomerOwnedData(Mockito.<Order>any());

    // Act
    broadleafOrderHistoryController.validateCustomerOwnedData(new NullOrderImpl());

    // Assert
    verify(orderHistoryService).validateCustomerOwnedData(isA(Order.class));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link BroadleafOrderHistoryController}
   *   <li>{@link BroadleafOrderHistoryController#getOrderDetailsRedirectView()}
   *   <li>{@link BroadleafOrderHistoryController#getOrderDetailsView()}
   *   <li>{@link BroadleafOrderHistoryController#getOrderHistoryView()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafOrderHistoryController.<init>()",
    "String BroadleafOrderHistoryController.getOrderDetailsRedirectView()",
    "String BroadleafOrderHistoryController.getOrderDetailsView()",
    "String BroadleafOrderHistoryController.getOrderHistoryView()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    BroadleafOrderHistoryController actualBroadleafOrderHistoryController =
        new BroadleafOrderHistoryController();
    String actualOrderDetailsRedirectView =
        actualBroadleafOrderHistoryController.getOrderDetailsRedirectView();
    String actualOrderDetailsView = actualBroadleafOrderHistoryController.getOrderDetailsView();

    // Assert
    assertEquals(
        "account/orderHistory", actualBroadleafOrderHistoryController.getOrderHistoryView());
    assertEquals("account/partials/orderDetails", actualOrderDetailsRedirectView);
    assertEquals("account/partials/orderDetails", actualOrderDetailsView);
  }
}

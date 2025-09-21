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
package org.broadleafcommerce.core.web.controller.catalog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.template.TemplateType;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.service.OrderItemService;
import org.broadleafcommerce.core.web.controller.catalog.BroadleafProductController.ResourceNotFoundException;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

@ExtendWith(MockitoExtension.class)
class BroadleafProductControllerDiffblueTest {
  @InjectMocks private BroadleafProductController broadleafProductController;

  @Mock private OrderItemService orderItemService;

  /**
   * Test {@link BroadleafProductController#handleRequest(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then throw {@link ResourceNotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafProductController#handleRequest(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @DisplayName(
      "Test handleRequest(HttpServletRequest, HttpServletResponse); then throw ResourceNotFoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.web.servlet.ModelAndView BroadleafProductController.handleRequest(HttpServletRequest, HttpServletResponse)"
  })
  void testHandleRequest_thenThrowResourceNotFoundException() throws Exception {
    // Arrange
    when(orderItemService.createConfigurableOrderItemRequestFromProduct(Mockito.<Product>any()))
        .thenThrow(new BroadleafProductController().new ResourceNotFoundException());

    MockHttpServletRequest servletRequest = mock(MockHttpServletRequest.class);
    doNothing().when(servletRequest).setAttribute(Mockito.<String>any(), Mockito.<Object>any());
    doNothing().when(servletRequest).setCharacterEncoding(Mockito.<String>any());
    when(servletRequest.getAttribute(Mockito.<String>any())).thenReturn(new ProductBundleImpl());
    doNothing().when(servletRequest).addParameter(Mockito.<String>any(), Mockito.<String>any());
    servletRequest.addParameter("https://example.org/example", "https://example.org/example");

    SearchRequestWrapper request = new SearchRequestWrapper(servletRequest);
    request.setAttribute("currentProduct", "42");
    request.setCharacterEncoding("currentProduct");
    HttpServletRequestWrapper request2 = new HttpServletRequestWrapper(request);

    // Act and Assert
    assertThrows(
        ResourceNotFoundException.class,
        () -> broadleafProductController.handleRequest(request2, new MockHttpServletResponse()));
    verify(orderItemService).createConfigurableOrderItemRequestFromProduct(isA(Product.class));
    verify(servletRequest)
        .addParameter("https://example.org/example", "https://example.org/example");
    verify(servletRequest).getAttribute("currentProduct");
    verify(servletRequest).setAttribute(eq("currentProduct"), isA(Object.class));
    verify(servletRequest).setCharacterEncoding("currentProduct");
  }

  /**
   * Test {@link BroadleafProductController#orderItemBelongsToCurrentCustomer(OrderItem)}.
   *
   * <ul>
   *   <li>Given {@link NullOrderImpl} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafProductController#orderItemBelongsToCurrentCustomer(OrderItem)}
   */
  @Test
  @DisplayName(
      "Test orderItemBelongsToCurrentCustomer(OrderItem); given NullOrderImpl (default constructor); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafProductController.orderItemBelongsToCurrentCustomer(OrderItem)"
  })
  void testOrderItemBelongsToCurrentCustomer_givenNullOrderImpl_thenReturnTrue() {
    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setOrder(new NullOrderImpl());

    // Act and Assert
    assertTrue(broadleafProductController.orderItemBelongsToCurrentCustomer(orderItem));
  }

  /**
   * Test {@link BroadleafProductController#orderItemBelongsToCurrentCustomer(OrderItem)}.
   *
   * <ul>
   *   <li>Then calls {@link Order#getCustomer()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafProductController#orderItemBelongsToCurrentCustomer(OrderItem)}
   */
  @Test
  @DisplayName("Test orderItemBelongsToCurrentCustomer(OrderItem); then calls getCustomer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafProductController.orderItemBelongsToCurrentCustomer(OrderItem)"
  })
  void testOrderItemBelongsToCurrentCustomer_thenCallsGetCustomer() {
    // Arrange
    Order order = mock(Order.class);
    when(order.getCustomer()).thenReturn(new CustomerImpl());

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setOrder(order);

    // Act
    boolean actualOrderItemBelongsToCurrentCustomerResult =
        broadleafProductController.orderItemBelongsToCurrentCustomer(orderItem);

    // Assert
    verify(order).getCustomer();
    assertFalse(actualOrderItemBelongsToCurrentCustomerResult);
  }

  /**
   * Test {@link BroadleafProductController#orderItemBelongsToCurrentCustomer(OrderItem)}.
   *
   * <ul>
   *   <li>Then throw {@link ResourceNotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafProductController#orderItemBelongsToCurrentCustomer(OrderItem)}
   */
  @Test
  @DisplayName(
      "Test orderItemBelongsToCurrentCustomer(OrderItem); then throw ResourceNotFoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafProductController.orderItemBelongsToCurrentCustomer(OrderItem)"
  })
  void testOrderItemBelongsToCurrentCustomer_thenThrowResourceNotFoundException() {
    // Arrange
    OrderItem orderItem = mock(OrderItem.class);
    when(orderItem.getOrder())
        .thenThrow(new BroadleafProductController().new ResourceNotFoundException());

    // Act and Assert
    assertThrows(
        ResourceNotFoundException.class,
        () -> broadleafProductController.orderItemBelongsToCurrentCustomer(orderItem));
    verify(orderItem).getOrder();
  }

  /**
   * Test {@link BroadleafProductController#orderItemBelongsToCurrentCustomer(OrderItem)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafProductController#orderItemBelongsToCurrentCustomer(OrderItem)}
   */
  @Test
  @DisplayName(
      "Test orderItemBelongsToCurrentCustomer(OrderItem); when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafProductController.orderItemBelongsToCurrentCustomer(OrderItem)"
  })
  void testOrderItemBelongsToCurrentCustomer_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(broadleafProductController.orderItemBelongsToCurrentCustomer(null));
  }

  /**
   * Test {@link BroadleafProductController#getTemplateType(HttpServletRequest)}.
   *
   * <p>Method under test: {@link BroadleafProductController#getTemplateType(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getTemplateType(HttpServletRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TemplateType BroadleafProductController.getTemplateType(HttpServletRequest)"})
  void testGetTemplateType() {
    // Arrange, Act and Assert
    assertSame(
        TemplateType.PRODUCT,
        broadleafProductController.getTemplateType(
            new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()))));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link BroadleafProductController}
   *   <li>{@link BroadleafProductController#setDefaultProductView(String)}
   *   <li>{@link BroadleafProductController#getDefaultProductView()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafProductController.<init>()",
    "String BroadleafProductController.getDefaultProductView()",
    "void BroadleafProductController.setDefaultProductView(String)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    BroadleafProductController actualBroadleafProductController = new BroadleafProductController();
    actualBroadleafProductController.setDefaultProductView("Default Product View");

    // Assert
    assertEquals("Default Product View", actualBroadleafProductController.getDefaultProductView());
  }

  /**
   * Test ResourceNotFoundException {@link
   * ResourceNotFoundException#ResourceNotFoundException(BroadleafProductController)}.
   *
   * <p>Method under test: {@link
   * ResourceNotFoundException#ResourceNotFoundException(BroadleafProductController)}
   */
  @Test
  @DisplayName(
      "Test ResourceNotFoundException new ResourceNotFoundException(BroadleafProductController)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceNotFoundException.<init>(BroadleafProductController)"})
  void testResourceNotFoundExceptionNewResourceNotFoundException() {
    // Arrange and Act
    ResourceNotFoundException actualResourceNotFoundException =
        new BroadleafProductController().new ResourceNotFoundException();

    // Assert
    assertNull(actualResourceNotFoundException.getMessage());
    assertNull(actualResourceNotFoundException.getCause());
    assertEquals(0, actualResourceNotFoundException.getSuppressed().length);
  }
}

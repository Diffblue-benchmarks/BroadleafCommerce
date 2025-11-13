package org.broadleafcommerce.core.web.controller.catalog;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.template.TemplateType;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.web.controller.catalog.BroadleafProductController.ResourceNotFoundException;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.mock.web.MockHttpServletRequest;

public class BroadleafProductControllerDiffblueTest {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafProductController.orderItemBelongsToCurrentCustomer(OrderItem)"
  })
  public void testOrderItemBelongsToCurrentCustomer_givenNullOrderImpl_thenReturnTrue() {
    // Arrange
    BroadleafProductController broadleafProductController = new BroadleafProductController();

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafProductController.orderItemBelongsToCurrentCustomer(OrderItem)"
  })
  public void testOrderItemBelongsToCurrentCustomer_thenCallsGetCustomer() {
    // Arrange
    BroadleafProductController broadleafProductController = new BroadleafProductController();

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafProductController.orderItemBelongsToCurrentCustomer(OrderItem)"
  })
  public void testOrderItemBelongsToCurrentCustomer_thenThrowResourceNotFoundException() {
    // Arrange
    BroadleafProductController broadleafProductController = new BroadleafProductController();

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafProductController.orderItemBelongsToCurrentCustomer(OrderItem)"
  })
  public void testOrderItemBelongsToCurrentCustomer_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new BroadleafProductController().orderItemBelongsToCurrentCustomer(null));
  }

  /**
   * Test {@link BroadleafProductController#getTemplateType(HttpServletRequest)}.
   *
   * <p>Method under test: {@link BroadleafProductController#getTemplateType(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TemplateType BroadleafProductController.getTemplateType(HttpServletRequest)"})
  public void testGetTemplateType() {
    // Arrange
    BroadleafProductController broadleafProductController = new BroadleafProductController();

    // Act and Assert
    assertSame(
        TemplateType.PRODUCT,
        broadleafProductController.getTemplateType(new MockHttpServletRequest()));
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafProductController.<init>()",
    "String BroadleafProductController.getDefaultProductView()",
    "void BroadleafProductController.setDefaultProductView(String)"
  })
  public void testGettersAndSetters() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceNotFoundException.<init>(BroadleafProductController)"})
  public void testResourceNotFoundExceptionNewResourceNotFoundException() {
    // Arrange and Act
    ResourceNotFoundException actualResourceNotFoundException =
        new BroadleafProductController().new ResourceNotFoundException();

    // Assert
    assertNull(actualResourceNotFoundException.getMessage());
    assertNull(actualResourceNotFoundException.getCause());
    assertEquals(0, actualResourceNotFoundException.getSuppressed().length);
  }
}

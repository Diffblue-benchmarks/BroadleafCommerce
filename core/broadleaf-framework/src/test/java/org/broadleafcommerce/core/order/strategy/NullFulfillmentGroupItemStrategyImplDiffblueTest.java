package org.broadleafcommerce.core.order.strategy;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItem;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.service.FulfillmentGroupService;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.workflow.CartOperationRequest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class NullFulfillmentGroupItemStrategyImplDiffblueTest {
  @Mock private FulfillmentGroupService fulfillmentGroupService;

  @InjectMocks private NullFulfillmentGroupItemStrategyImpl nullFulfillmentGroupItemStrategyImpl;

  /**
   * Test {@link NullFulfillmentGroupItemStrategyImpl#onItemAdded(CartOperationRequest)}.
   *
   * <p>Method under test: {@link
   * NullFulfillmentGroupItemStrategyImpl#onItemAdded(CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CartOperationRequest NullFulfillmentGroupItemStrategyImpl.onItemAdded(CartOperationRequest)"
  })
  public void testOnItemAdded() {
    // Arrange
    NullFulfillmentGroupItemStrategyImpl nullFulfillmentGroupItemStrategyImpl =
        new NullFulfillmentGroupItemStrategyImpl();
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act
    CartOperationRequest actualOnItemAddedResult =
        nullFulfillmentGroupItemStrategyImpl.onItemAdded(request);

    // Assert
    assertSame(request, actualOnItemAddedResult);
  }

  /**
   * Test {@link NullFulfillmentGroupItemStrategyImpl#onItemUpdated(CartOperationRequest)}.
   *
   * <p>Method under test: {@link
   * NullFulfillmentGroupItemStrategyImpl#onItemUpdated(CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CartOperationRequest NullFulfillmentGroupItemStrategyImpl.onItemUpdated(CartOperationRequest)"
  })
  public void testOnItemUpdated() {
    // Arrange
    NullFulfillmentGroupItemStrategyImpl nullFulfillmentGroupItemStrategyImpl =
        new NullFulfillmentGroupItemStrategyImpl();
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act
    CartOperationRequest actualOnItemUpdatedResult =
        nullFulfillmentGroupItemStrategyImpl.onItemUpdated(request);

    // Assert
    assertSame(request, actualOnItemUpdatedResult);
  }

  /**
   * Test {@link NullFulfillmentGroupItemStrategyImpl#onItemRemoved(CartOperationRequest)}.
   *
   * <p>Method under test: {@link
   * NullFulfillmentGroupItemStrategyImpl#onItemRemoved(CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CartOperationRequest NullFulfillmentGroupItemStrategyImpl.onItemRemoved(CartOperationRequest)"
  })
  public void testOnItemRemoved() {
    // Arrange
    NullFulfillmentGroupItemStrategyImpl nullFulfillmentGroupItemStrategyImpl =
        new NullFulfillmentGroupItemStrategyImpl();
    NullOrderImpl order = new NullOrderImpl();

    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    request.setOrderItem(new BundleOrderItemImpl());

    // Act
    CartOperationRequest actualOnItemRemovedResult =
        nullFulfillmentGroupItemStrategyImpl.onItemRemoved(request);

    // Assert
    assertSame(request, actualOnItemRemovedResult);
  }

  /**
   * Test {@link NullFulfillmentGroupItemStrategyImpl#onItemRemoved(CartOperationRequest)}.
   *
   * <ul>
   *   <li>Then AddedOrderItem return {@link BundleOrderItemImpl}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NullFulfillmentGroupItemStrategyImpl#onItemRemoved(CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CartOperationRequest NullFulfillmentGroupItemStrategyImpl.onItemRemoved(CartOperationRequest)"
  })
  public void testOnItemRemoved_thenAddedOrderItemReturnBundleOrderItemImpl() {
    // Arrange
    when(fulfillmentGroupService.getFulfillmentGroupItemsForOrderItem(
            Mockito.<Order>any(), Mockito.<OrderItem>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<DiscreteOrderItem> discreteOrderItems = new ArrayList<>();
    discreteOrderItems.add(new DiscreteOrderItemImpl());

    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setDiscreteOrderItems(discreteOrderItems);
    NullOrderImpl order = new NullOrderImpl();

    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    request.setOrderItem(orderItem);

    // Act
    CartOperationRequest actualOnItemRemovedResult =
        nullFulfillmentGroupItemStrategyImpl.onItemRemoved(request);

    // Assert
    verify(fulfillmentGroupService)
        .getFulfillmentGroupItemsForOrderItem(isA(Order.class), isA(OrderItem.class));
    OrderItem addedOrderItem = actualOnItemRemovedResult.getAddedOrderItem();
    assertTrue(addedOrderItem instanceof BundleOrderItemImpl);
    assertSame(discreteOrderItems, ((BundleOrderItemImpl) addedOrderItem).getDiscreteOrderItems());
    assertSame(discreteOrderItems, ((BundleOrderItemImpl) addedOrderItem).getOrderItems());
  }

  /**
   * Test {@link NullFulfillmentGroupItemStrategyImpl#onItemRemoved(CartOperationRequest)}.
   *
   * <ul>
   *   <li>Then Order return {@link NullOrderImpl}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NullFulfillmentGroupItemStrategyImpl#onItemRemoved(CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CartOperationRequest NullFulfillmentGroupItemStrategyImpl.onItemRemoved(CartOperationRequest)"
  })
  public void testOnItemRemoved_thenOrderReturnNullOrderImpl() {
    // Arrange
    when(fulfillmentGroupService.getFulfillmentGroupItemsForOrderItem(
            Mockito.<Order>any(), Mockito.<OrderItem>any()))
        .thenReturn(new ArrayList<>());
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act
    CartOperationRequest actualOnItemRemovedResult =
        nullFulfillmentGroupItemStrategyImpl.onItemRemoved(request);

    // Assert
    verify(fulfillmentGroupService)
        .getFulfillmentGroupItemsForOrderItem(isA(Order.class), isNull());
    assertTrue(actualOnItemRemovedResult.getOrder() instanceof NullOrderImpl);
    assertNull(actualOnItemRemovedResult.getAddedOrderItem());
    assertNull(actualOnItemRemovedResult.getOrderItem());
  }

  /**
   * Test {@link NullFulfillmentGroupItemStrategyImpl#verify(CartOperationRequest)}.
   *
   * <p>Method under test: {@link NullFulfillmentGroupItemStrategyImpl#verify(CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CartOperationRequest NullFulfillmentGroupItemStrategyImpl.verify(CartOperationRequest)"
  })
  public void testVerify() {
    // Arrange
    NullFulfillmentGroupItemStrategyImpl nullFulfillmentGroupItemStrategyImpl =
        new NullFulfillmentGroupItemStrategyImpl();
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act
    CartOperationRequest actualVerifyResult = nullFulfillmentGroupItemStrategyImpl.verify(request);

    // Assert
    assertSame(request, actualVerifyResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link NullFulfillmentGroupItemStrategyImpl}
   *   <li>{@link NullFulfillmentGroupItemStrategyImpl#isRemoveEmptyFulfillmentGroups()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NullFulfillmentGroupItemStrategyImpl.<init>()",
    "boolean NullFulfillmentGroupItemStrategyImpl.isRemoveEmptyFulfillmentGroups()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertFalse(new NullFulfillmentGroupItemStrategyImpl().isRemoveEmptyFulfillmentGroups());
  }
}

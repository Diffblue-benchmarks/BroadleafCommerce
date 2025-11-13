package org.broadleafcommerce.core.order.service.call;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OrderItemRequestDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderItemRequest#OrderItemRequest()}
   *   <li>{@link OrderItemRequest#setItemName(String)}
   *   <li>{@link OrderItemRequest#getItemName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderItemRequest.<init>()",
    "String OrderItemRequest.getItemName()",
    "void OrderItemRequest.setItemName(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    OrderItemRequest actualOrderItemRequest = new OrderItemRequest();
    actualOrderItemRequest.setItemName("Item Name");

    // Assert
    assertEquals("Item Name", actualOrderItemRequest.getItemName());
    assertNull(actualOrderItemRequest.getRetailPriceOverride());
    assertNull(actualOrderItemRequest.getSalePriceOverride());
    assertNull(actualOrderItemRequest.getCategory());
    assertNull(actualOrderItemRequest.getProduct());
    assertNull(actualOrderItemRequest.getSku());
    assertNull(actualOrderItemRequest.getOrder());
    assertNull(actualOrderItemRequest.getPersonalMessage());
    assertEquals(0, actualOrderItemRequest.getQuantity());
    assertTrue(actualOrderItemRequest.getAdditionalAttributes().isEmpty());
    assertTrue(actualOrderItemRequest.getItemAttributes().isEmpty());
  }

  /**
   * Test {@link OrderItemRequest#OrderItemRequest(AbstractOrderItemRequest)}.
   *
   * <ul>
   *   <li>When {@link DiscreteOrderItemRequest#DiscreteOrderItemRequest()}.
   *   <li>Then return ItemName is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemRequest#OrderItemRequest(AbstractOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderItemRequest.<init>(AbstractOrderItemRequest)"})
  public void testNewOrderItemRequest_whenDiscreteOrderItemRequest_thenReturnItemNameIsNull() {
    // Arrange and Act
    OrderItemRequest actualOrderItemRequest = new OrderItemRequest(new DiscreteOrderItemRequest());

    // Assert
    assertNull(actualOrderItemRequest.getItemName());
    assertNull(actualOrderItemRequest.getRetailPriceOverride());
    assertNull(actualOrderItemRequest.getSalePriceOverride());
    assertNull(actualOrderItemRequest.getCategory());
    assertNull(actualOrderItemRequest.getProduct());
    assertNull(actualOrderItemRequest.getSku());
    assertNull(actualOrderItemRequest.getOrder());
    assertNull(actualOrderItemRequest.getPersonalMessage());
    assertEquals(0, actualOrderItemRequest.getQuantity());
    assertTrue(actualOrderItemRequest.getAdditionalAttributes().isEmpty());
    assertTrue(actualOrderItemRequest.getItemAttributes().isEmpty());
  }

  /**
   * Test {@link OrderItemRequest#clone()}.
   *
   * <p>Method under test: {@link OrderItemRequest#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItemRequest OrderItemRequest.clone()"})
  public void testClone() {
    // Arrange
    OrderItemRequest orderItemRequest = new OrderItemRequest();

    // Act
    OrderItemRequest actualCloneResult = orderItemRequest.clone();

    // Assert
    assertEquals(orderItemRequest, actualCloneResult);
  }
}

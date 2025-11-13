package org.broadleafcommerce.core.order.service.call;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.core.order.domain.BundleOrderItem;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemFeePrice;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DiscreteOrderItemRequestDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DiscreteOrderItemRequest#DiscreteOrderItemRequest()}
   *   <li>{@link DiscreteOrderItemRequest#setBundleOrderItem(BundleOrderItem)}
   *   <li>{@link DiscreteOrderItemRequest#setDiscreteOrderItemFeePrices(List)}
   *   <li>{@link DiscreteOrderItemRequest#getBundleOrderItem()}
   *   <li>{@link DiscreteOrderItemRequest#getDiscreteOrderItemFeePrices()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DiscreteOrderItemRequest.<init>()",
    "BundleOrderItem DiscreteOrderItemRequest.getBundleOrderItem()",
    "List DiscreteOrderItemRequest.getDiscreteOrderItemFeePrices()",
    "void DiscreteOrderItemRequest.setBundleOrderItem(BundleOrderItem)",
    "void DiscreteOrderItemRequest.setDiscreteOrderItemFeePrices(List)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    DiscreteOrderItemRequest actualDiscreteOrderItemRequest = new DiscreteOrderItemRequest();
    BundleOrderItemImpl bundleOrderItem = new BundleOrderItemImpl();
    actualDiscreteOrderItemRequest.setBundleOrderItem(bundleOrderItem);
    ArrayList<DiscreteOrderItemFeePrice> discreteOrderItemFeePrices = new ArrayList<>();
    actualDiscreteOrderItemRequest.setDiscreteOrderItemFeePrices(discreteOrderItemFeePrices);
    BundleOrderItem actualBundleOrderItem = actualDiscreteOrderItemRequest.getBundleOrderItem();
    List<DiscreteOrderItemFeePrice> actualDiscreteOrderItemFeePrices =
        actualDiscreteOrderItemRequest.getDiscreteOrderItemFeePrices();

    // Assert
    assertNull(actualDiscreteOrderItemRequest.getRetailPriceOverride());
    assertNull(actualDiscreteOrderItemRequest.getSalePriceOverride());
    assertNull(actualDiscreteOrderItemRequest.getCategory());
    assertNull(actualDiscreteOrderItemRequest.getProduct());
    assertNull(actualDiscreteOrderItemRequest.getSku());
    assertNull(actualDiscreteOrderItemRequest.getOrder());
    assertNull(actualDiscreteOrderItemRequest.getPersonalMessage());
    assertEquals(0, actualDiscreteOrderItemRequest.getQuantity());
    assertTrue(actualDiscreteOrderItemFeePrices.isEmpty());
    assertTrue(actualDiscreteOrderItemRequest.getAdditionalAttributes().isEmpty());
    assertTrue(actualDiscreteOrderItemRequest.getItemAttributes().isEmpty());
    assertSame(discreteOrderItemFeePrices, actualDiscreteOrderItemFeePrices);
    assertSame(bundleOrderItem, actualBundleOrderItem);
  }

  /**
   * Test {@link DiscreteOrderItemRequest#DiscreteOrderItemRequest(AbstractOrderItemRequest)}.
   *
   * <ul>
   *   <li>Then return {@link DiscreteOrderItemRequest#DiscreteOrderItemRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DiscreteOrderItemRequest#DiscreteOrderItemRequest(AbstractOrderItemRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DiscreteOrderItemRequest.<init>(AbstractOrderItemRequest)"})
  public void testNewDiscreteOrderItemRequest_thenReturnDiscreteOrderItemRequest() {
    // Arrange
    DiscreteOrderItemRequest request = new DiscreteOrderItemRequest();

    // Act
    DiscreteOrderItemRequest actualDiscreteOrderItemRequest = new DiscreteOrderItemRequest(request);

    // Assert
    assertEquals(request, actualDiscreteOrderItemRequest);
  }

  /**
   * Test {@link DiscreteOrderItemRequest#clone()}.
   *
   * <p>Method under test: {@link DiscreteOrderItemRequest#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DiscreteOrderItemRequest DiscreteOrderItemRequest.clone()"})
  public void testClone() {
    // Arrange
    DiscreteOrderItemRequest discreteOrderItemRequest = new DiscreteOrderItemRequest();

    // Act
    DiscreteOrderItemRequest actualCloneResult = discreteOrderItemRequest.clone();

    // Assert
    assertEquals(discreteOrderItemRequest, actualCloneResult);
  }
}

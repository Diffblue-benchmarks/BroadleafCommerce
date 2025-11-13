package org.broadleafcommerce.core.order.service.call;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AddToCartItemDiffblueTest {
  /**
   * Test new {@link AddToCartItem} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link AddToCartItem}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AddToCartItem.<init>()"})
  public void testNewAddToCartItem() {
    // Arrange and Act
    AddToCartItem actualAddToCartItem = new AddToCartItem();

    // Assert
    assertNull(actualAddToCartItem.getQuantity());
    assertNull(actualAddToCartItem.getCategoryId());
    assertNull(actualAddToCartItem.getOrderItemId());
    assertNull(actualAddToCartItem.getParentOrderItemId());
    assertNull(actualAddToCartItem.getProductId());
    assertNull(actualAddToCartItem.getSkuId());
    assertNull(actualAddToCartItem.getOverrideRetailPrice());
    assertNull(actualAddToCartItem.getOverrideSalePrice());
    assertTrue(actualAddToCartItem.getChildOrderItems().isEmpty());
    assertTrue(actualAddToCartItem.getAdditionalAttributes().isEmpty());
    assertTrue(actualAddToCartItem.getItemAttributes().isEmpty());
  }
}

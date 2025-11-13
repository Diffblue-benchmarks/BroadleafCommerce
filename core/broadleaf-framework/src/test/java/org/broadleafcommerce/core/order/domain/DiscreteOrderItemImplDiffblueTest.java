package org.broadleafcommerce.core.order.domain;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.SkuBundleItem;
import org.broadleafcommerce.core.catalog.domain.SkuBundleItemImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DiscreteOrderItemImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DiscreteOrderItemImpl#setAdditionalAttributes(Map)}
   *   <li>{@link DiscreteOrderItemImpl#setDiscreteOrderItemFeePrices(List)}
   *   <li>{@link DiscreteOrderItemImpl#setProduct(Product)}
   *   <li>{@link DiscreteOrderItemImpl#setSkuBundleItem(SkuBundleItem)}
   *   <li>{@link DiscreteOrderItemImpl#getAdditionalAttributes()}
   *   <li>{@link DiscreteOrderItemImpl#getBundleOrderItem()}
   *   <li>{@link DiscreteOrderItemImpl#getDiscreteOrderItemFeePrices()}
   *   <li>{@link DiscreteOrderItemImpl#getSkuBundleItem()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map DiscreteOrderItemImpl.getAdditionalAttributes()",
    "BundleOrderItem DiscreteOrderItemImpl.getBundleOrderItem()",
    "List DiscreteOrderItemImpl.getDiscreteOrderItemFeePrices()",
    "SkuBundleItem DiscreteOrderItemImpl.getSkuBundleItem()",
    "void DiscreteOrderItemImpl.setAdditionalAttributes(Map)",
    "void DiscreteOrderItemImpl.setDiscreteOrderItemFeePrices(List)",
    "void DiscreteOrderItemImpl.setProduct(Product)",
    "void DiscreteOrderItemImpl.setSkuBundleItem(SkuBundleItem)"
  })
  public void testGettersAndSetters() {
    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
    HashMap<String, String> additionalAttributes = new HashMap<>();

    // Act
    discreteOrderItemImpl.setAdditionalAttributes(additionalAttributes);
    ArrayList<DiscreteOrderItemFeePrice> discreteOrderItemFeePrices = new ArrayList<>();
    discreteOrderItemImpl.setDiscreteOrderItemFeePrices(discreteOrderItemFeePrices);
    discreteOrderItemImpl.setProduct(new ProductBundleImpl());
    SkuBundleItemImpl SkuBundleItem = new SkuBundleItemImpl();
    discreteOrderItemImpl.setSkuBundleItem(SkuBundleItem);
    Map<String, String> actualAdditionalAttributes =
        discreteOrderItemImpl.getAdditionalAttributes();
    BundleOrderItem actualBundleOrderItem = discreteOrderItemImpl.getBundleOrderItem();
    List<DiscreteOrderItemFeePrice> actualDiscreteOrderItemFeePrices =
        discreteOrderItemImpl.getDiscreteOrderItemFeePrices();
    SkuBundleItem actualSkuBundleItem = discreteOrderItemImpl.getSkuBundleItem();

    // Assert
    assertNull(actualBundleOrderItem);
    assertTrue(actualDiscreteOrderItemFeePrices.isEmpty());
    assertTrue(actualAdditionalAttributes.isEmpty());
    assertSame(discreteOrderItemFeePrices, actualDiscreteOrderItemFeePrices);
    assertSame(additionalAttributes, actualAdditionalAttributes);
    assertSame(SkuBundleItem, actualSkuBundleItem);
  }
}

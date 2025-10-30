/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.order.domain;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
   * <p>
   * Methods under test:
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map DiscreteOrderItemImpl.getAdditionalAttributes()",
      "BundleOrderItem DiscreteOrderItemImpl.getBundleOrderItem()",
      "List DiscreteOrderItemImpl.getDiscreteOrderItemFeePrices()",
      "SkuBundleItem DiscreteOrderItemImpl.getSkuBundleItem()",
      "void DiscreteOrderItemImpl.setAdditionalAttributes(Map)",
      "void DiscreteOrderItemImpl.setDiscreteOrderItemFeePrices(List)",
      "void DiscreteOrderItemImpl.setProduct(Product)", "void DiscreteOrderItemImpl.setSkuBundleItem(SkuBundleItem)"})
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
    Map<String, String> actualAdditionalAttributes = discreteOrderItemImpl.getAdditionalAttributes();
    BundleOrderItem actualBundleOrderItem = discreteOrderItemImpl.getBundleOrderItem();
    List<DiscreteOrderItemFeePrice> actualDiscreteOrderItemFeePrices = discreteOrderItemImpl
        .getDiscreteOrderItemFeePrices();
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

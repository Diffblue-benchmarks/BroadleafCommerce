/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
package org.broadleafcommerce.core.order.service.call;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class AddToCartItemDiffblueTest {
  /**
   * Test new {@link AddToCartItem} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AddToCartItem}
   */
  @Test
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

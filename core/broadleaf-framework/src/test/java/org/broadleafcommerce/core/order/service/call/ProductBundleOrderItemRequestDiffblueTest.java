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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.ProductBundle;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.junit.Test;

public class ProductBundleOrderItemRequestDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ProductBundleOrderItemRequest}
   *   <li>{@link ProductBundleOrderItemRequest#setCategory(Category)}
   *   <li>{@link ProductBundleOrderItemRequest#setItemAttributes(Map)}
   *   <li>{@link ProductBundleOrderItemRequest#setName(String)}
   *   <li>{@link ProductBundleOrderItemRequest#setOrder(Order)}
   *   <li>{@link ProductBundleOrderItemRequest#setProductBundle(ProductBundle)}
   *   <li>{@link ProductBundleOrderItemRequest#setQuantity(int)}
   *   <li>{@link ProductBundleOrderItemRequest#setRetailPriceOverride(Money)}
   *   <li>{@link ProductBundleOrderItemRequest#setSalePriceOverride(Money)}
   *   <li>{@link ProductBundleOrderItemRequest#setSku(Sku)}
   *   <li>{@link ProductBundleOrderItemRequest#getCategory()}
   *   <li>{@link ProductBundleOrderItemRequest#getItemAttributes()}
   *   <li>{@link ProductBundleOrderItemRequest#getName()}
   *   <li>{@link ProductBundleOrderItemRequest#getOrder()}
   *   <li>{@link ProductBundleOrderItemRequest#getProductBundle()}
   *   <li>{@link ProductBundleOrderItemRequest#getQuantity()}
   *   <li>{@link ProductBundleOrderItemRequest#getRetailPriceOverride()}
   *   <li>{@link ProductBundleOrderItemRequest#getSalePriceOverride()}
   *   <li>{@link ProductBundleOrderItemRequest#getSku()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ProductBundleOrderItemRequest actualProductBundleOrderItemRequest = new ProductBundleOrderItemRequest();
    CategoryImpl category = new CategoryImpl();
    ProductBundleOrderItemRequest actualSetCategoryResult = actualProductBundleOrderItemRequest.setCategory(category);
    HashMap<String, String> itemAttributes = new HashMap<>();
    ProductBundleOrderItemRequest actualSetItemAttributesResult = actualProductBundleOrderItemRequest
        .setItemAttributes(itemAttributes);
    ProductBundleOrderItemRequest actualSetNameResult = actualProductBundleOrderItemRequest.setName("Name");
    NullOrderImpl order = new NullOrderImpl();
    ProductBundleOrderItemRequest actualSetOrderResult = actualProductBundleOrderItemRequest.setOrder(order);
    ProductBundleImpl productBundle = new ProductBundleImpl();
    ProductBundleOrderItemRequest actualSetProductBundleResult = actualProductBundleOrderItemRequest
        .setProductBundle(productBundle);
    ProductBundleOrderItemRequest actualSetQuantityResult = actualProductBundleOrderItemRequest.setQuantity(1);
    Money retailPriceOverride = new Money();
    actualProductBundleOrderItemRequest.setRetailPriceOverride(retailPriceOverride);
    Money salePriceOverride = new Money();
    actualProductBundleOrderItemRequest.setSalePriceOverride(salePriceOverride);
    SkuImpl sku = new SkuImpl();
    ProductBundleOrderItemRequest actualSetSkuResult = actualProductBundleOrderItemRequest.setSku(sku);
    Category actualCategory = actualProductBundleOrderItemRequest.getCategory();
    Map<String, String> actualItemAttributes = actualProductBundleOrderItemRequest.getItemAttributes();
    String actualName = actualProductBundleOrderItemRequest.getName();
    Order actualOrder = actualProductBundleOrderItemRequest.getOrder();
    ProductBundle actualProductBundle = actualProductBundleOrderItemRequest.getProductBundle();
    int actualQuantity = actualProductBundleOrderItemRequest.getQuantity();
    Money actualRetailPriceOverride = actualProductBundleOrderItemRequest.getRetailPriceOverride();
    Money actualSalePriceOverride = actualProductBundleOrderItemRequest.getSalePriceOverride();
    Sku actualSku = actualProductBundleOrderItemRequest.getSku();

    // Assert that nothing has changed
    assertTrue(actualProductBundle instanceof ProductBundleImpl);
    assertTrue(actualSku instanceof SkuImpl);
    assertEquals("Name", actualName);
    assertEquals(1, actualQuantity);
    assertTrue(actualItemAttributes.isEmpty());
    assertSame(itemAttributes, actualItemAttributes);
    assertSame(retailPriceOverride, actualRetailPriceOverride);
    assertSame(salePriceOverride, actualSalePriceOverride);
    assertSame(category, actualCategory);
    assertSame(productBundle, actualProductBundle);
    assertSame(sku, actualSku);
    assertSame(order, actualOrder);
    assertSame(actualProductBundleOrderItemRequest, actualSetCategoryResult);
    assertSame(actualProductBundleOrderItemRequest, actualSetItemAttributesResult);
    assertSame(actualProductBundleOrderItemRequest, actualSetNameResult);
    assertSame(actualProductBundleOrderItemRequest, actualSetOrderResult);
    assertSame(actualProductBundleOrderItemRequest, actualSetProductBundleResult);
    assertSame(actualProductBundleOrderItemRequest, actualSetQuantityResult);
    assertSame(actualProductBundleOrderItemRequest, actualSetSkuResult);
  }
}

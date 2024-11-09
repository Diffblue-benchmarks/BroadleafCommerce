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
package org.broadleafcommerce.core.catalog.domain.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import org.broadleafcommerce.core.catalog.domain.ProductOptionValue;
import org.broadleafcommerce.core.catalog.domain.ProductOptionValueImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.junit.Test;

public class AssignedProductOptionDTODiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link AssignedProductOptionDTO#AssignedProductOptionDTO(Long, String, ProductOptionValue, Sku)}
   *   <li>{@link AssignedProductOptionDTO#setProductId(Long)}
   *   <li>{@link AssignedProductOptionDTO#setProductOptionAttrName(String)}
   *   <li>
   * {@link AssignedProductOptionDTO#setProductOptionValue(ProductOptionValue)}
   *   <li>{@link AssignedProductOptionDTO#setSku(Sku)}
   *   <li>{@link AssignedProductOptionDTO#getProductId()}
   *   <li>{@link AssignedProductOptionDTO#getProductOptionAttrName()}
   *   <li>{@link AssignedProductOptionDTO#getProductOptionValue()}
   *   <li>{@link AssignedProductOptionDTO#getSku()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ProductOptionValueImpl productOptionValue = new ProductOptionValueImpl();

    // Act
    AssignedProductOptionDTO actualAssignedProductOptionDTO = new AssignedProductOptionDTO(1L,
        "Product Option Attr Name", productOptionValue, new SkuImpl());
    actualAssignedProductOptionDTO.setProductId(1L);
    actualAssignedProductOptionDTO.setProductOptionAttrName("Product Option Attr Name");
    ProductOptionValueImpl productOptionValue2 = new ProductOptionValueImpl();
    actualAssignedProductOptionDTO.setProductOptionValue(productOptionValue2);
    SkuImpl sku = new SkuImpl();
    actualAssignedProductOptionDTO.setSku(sku);
    Long actualProductId = actualAssignedProductOptionDTO.getProductId();
    String actualProductOptionAttrName = actualAssignedProductOptionDTO.getProductOptionAttrName();
    ProductOptionValue actualProductOptionValue = actualAssignedProductOptionDTO.getProductOptionValue();
    Sku actualSku = actualAssignedProductOptionDTO.getSku();

    // Assert that nothing has changed
    assertEquals("Product Option Attr Name", actualProductOptionAttrName);
    assertEquals(1L, actualProductId.longValue());
    assertSame(productOptionValue2, actualProductOptionValue);
    assertSame(sku, actualSku);
  }
}

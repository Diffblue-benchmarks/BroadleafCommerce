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
package org.broadleafcommerce.core.order.service.workflow.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.exception.RequiredAttributeNotProvidedException;
import org.broadleafcommerce.core.workflow.ActivityMessages;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.junit.Test;

public class OrderItemRequestValidationServiceImplDiffblueTest {
  /**
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#determineProduct(OrderItemRequestDTO)}
   */
  @Test
  public void testDetermineProduct() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl = new OrderItemRequestValidationServiceImpl();

    // Act and Assert
    assertNull(orderItemRequestValidationServiceImpl.determineProduct(new OrderItemRequestDTO()));
  }

  /**
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#canSellDefaultSku(Product)}
   */
  @Test
  public void testCanSellDefaultSku() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl = new OrderItemRequestValidationServiceImpl();

    // Act and Assert
    assertTrue(orderItemRequestValidationServiceImpl.canSellDefaultSku(new ProductBundleImpl()));
  }

  /**
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#canSellDefaultSku(Product)}
   */
  @Test
  public void testCanSellDefaultSku2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl = new OrderItemRequestValidationServiceImpl();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getAdditionalSkus()).thenReturn(new ArrayList<>());

    // Act
    boolean actualCanSellDefaultSkuResult = orderItemRequestValidationServiceImpl.canSellDefaultSku(product);

    // Assert
    verify(product).getAdditionalSkus();
    assertTrue(actualCanSellDefaultSkuResult);
  }

  /**
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#canSellDefaultSku(Product)}
   */
  @Test
  public void testCanSellDefaultSku3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl = new OrderItemRequestValidationServiceImpl();

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(new SkuImpl());
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getCanSellWithoutOptions()).thenReturn(true);
    when(product.getAdditionalSkus()).thenReturn(skuList);

    // Act
    boolean actualCanSellDefaultSkuResult = orderItemRequestValidationServiceImpl.canSellDefaultSku(product);

    // Assert
    verify(product).getAdditionalSkus();
    verify(product).getCanSellWithoutOptions();
    assertTrue(actualCanSellDefaultSkuResult);
  }

  /**
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#canSellDefaultSku(Product)}
   */
  @Test
  public void testCanSellDefaultSku4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl = new OrderItemRequestValidationServiceImpl();

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(new SkuImpl());
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getCanSellWithoutOptions()).thenReturn(false);
    when(product.getAdditionalSkus()).thenReturn(skuList);

    // Act
    boolean actualCanSellDefaultSkuResult = orderItemRequestValidationServiceImpl.canSellDefaultSku(product);

    // Assert
    verify(product).getAdditionalSkus();
    verify(product).getCanSellWithoutOptions();
    assertFalse(actualCanSellDefaultSkuResult);
  }

  /**
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map)}
   */
  @Test
  public void testFindMatchingSku() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl = new OrderItemRequestValidationServiceImpl();
    ProductBundleImpl product = new ProductBundleImpl();

    // Act and Assert
    assertNull(orderItemRequestValidationServiceImpl.findMatchingSku(product, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map)}
   */
  @Test
  public void testFindMatchingSku2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl = new OrderItemRequestValidationServiceImpl();

    // Act and Assert
    assertNull(orderItemRequestValidationServiceImpl.findMatchingSku(null, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map)}
   */
  @Test
  public void testFindMatchingSku3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl = new OrderItemRequestValidationServiceImpl();
    ProductBundleImpl product = mock(ProductBundleImpl.class);

    // Act and Assert
    assertNull(orderItemRequestValidationServiceImpl.findMatchingSku(product, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map, ActivityMessages)}
   */
  @Test
  public void testFindMatchingSku4() throws RequiredAttributeNotProvidedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl = new OrderItemRequestValidationServiceImpl();
    ProductBundleImpl product = new ProductBundleImpl();
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act and Assert
    assertNull(orderItemRequestValidationServiceImpl.findMatchingSku(product, attributeValues,
        new DefaultProcessContextImpl<>()));
  }

  /**
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map, ActivityMessages)}
   */
  @Test
  public void testFindMatchingSku5() throws RequiredAttributeNotProvidedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl = new OrderItemRequestValidationServiceImpl();
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act and Assert
    assertNull(orderItemRequestValidationServiceImpl.findMatchingSku(null, attributeValues,
        new DefaultProcessContextImpl<>()));
  }

  /**
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map, ActivityMessages)}
   */
  @Test
  public void testFindMatchingSku6() throws RequiredAttributeNotProvidedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl = new OrderItemRequestValidationServiceImpl();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getProductOptionXrefs()).thenReturn(new ArrayList<>());
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act
    Sku actualFindMatchingSkuResult = orderItemRequestValidationServiceImpl.findMatchingSku(product, attributeValues,
        new DefaultProcessContextImpl<>());

    // Assert
    verify(product).getProductOptionXrefs();
    assertNull(actualFindMatchingSkuResult);
  }

  /**
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#shouldValidateWithException(boolean, boolean, String, boolean)}
   */
  @Test
  public void testShouldValidateWithException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new OrderItemRequestValidationServiceImpl()).shouldValidateWithException(true, true, "0123456789ABCDEF",
        true));
    assertFalse((new OrderItemRequestValidationServiceImpl()).shouldValidateWithException(false, false, null, false));
    assertTrue((new OrderItemRequestValidationServiceImpl()).shouldValidateWithException(false, false,
        "0123456789ABCDEF", false));
    assertFalse((new OrderItemRequestValidationServiceImpl()).shouldValidateWithException(true, false,
        "0123456789ABCDEF", true));
    assertFalse((new OrderItemRequestValidationServiceImpl()).shouldValidateWithException(false, false, "", false));
  }
}

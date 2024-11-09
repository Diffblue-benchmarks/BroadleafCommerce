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
   * Test
   * {@link OrderItemRequestValidationServiceImpl#determineProduct(OrderItemRequestDTO)}.
   * <ul>
   *   <li>When {@link OrderItemRequestDTO#OrderItemRequestDTO()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#determineProduct(OrderItemRequestDTO)}
   */
  @Test
  public void testDetermineProduct_whenOrderItemRequestDTO_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl = new OrderItemRequestValidationServiceImpl();

    // Act and Assert
    assertNull(orderItemRequestValidationServiceImpl.determineProduct(new OrderItemRequestDTO()));
  }

  /**
   * Test
   * {@link OrderItemRequestValidationServiceImpl#canSellDefaultSku(Product)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#canSellDefaultSku(Product)}
   */
  @Test
  public void testCanSellDefaultSku_givenArrayList_thenReturnTrue() {
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
   * Test
   * {@link OrderItemRequestValidationServiceImpl#canSellDefaultSku(Product)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#canSellDefaultSku(Product)}
   */
  @Test
  public void testCanSellDefaultSku_givenFalse_thenReturnFalse() {
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
   * Test
   * {@link OrderItemRequestValidationServiceImpl#canSellDefaultSku(Product)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#canSellDefaultSku(Product)}
   */
  @Test
  public void testCanSellDefaultSku_givenTrue() {
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
   * Test
   * {@link OrderItemRequestValidationServiceImpl#canSellDefaultSku(Product)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#canSellDefaultSku(Product)}
   */
  @Test
  public void testCanSellDefaultSku_whenProductBundleImpl_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl = new OrderItemRequestValidationServiceImpl();

    // Act and Assert
    assertTrue(orderItemRequestValidationServiceImpl.canSellDefaultSku(new ProductBundleImpl()));
  }

  /**
   * Test
   * {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map)}
   * with {@code product}, {@code attributeValuesForSku}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map)}
   */
  @Test
  public void testFindMatchingSkuWithProductAttributeValuesForSku_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl = new OrderItemRequestValidationServiceImpl();

    // Act and Assert
    assertNull(orderItemRequestValidationServiceImpl.findMatchingSku(null, new HashMap<>()));
  }

  /**
   * Test
   * {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map)}
   * with {@code product}, {@code attributeValuesForSku}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map)}
   */
  @Test
  public void testFindMatchingSkuWithProductAttributeValuesForSku_whenProductBundleImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl = new OrderItemRequestValidationServiceImpl();
    ProductBundleImpl product = new ProductBundleImpl();

    // Act and Assert
    assertNull(orderItemRequestValidationServiceImpl.findMatchingSku(product, new HashMap<>()));
  }

  /**
   * Test
   * {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map)}
   * with {@code product}, {@code attributeValuesForSku}.
   * <ul>
   *   <li>When {@link ProductBundleImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map)}
   */
  @Test
  public void testFindMatchingSkuWithProductAttributeValuesForSku_whenProductBundleImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl = new OrderItemRequestValidationServiceImpl();
    ProductBundleImpl product = mock(ProductBundleImpl.class);

    // Act and Assert
    assertNull(orderItemRequestValidationServiceImpl.findMatchingSku(product, new HashMap<>()));
  }

  /**
   * Test
   * {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map, ActivityMessages)}
   * with {@code product}, {@code attributeValues}, {@code messages}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map, ActivityMessages)}
   */
  @Test
  public void testFindMatchingSkuWithProductAttributeValuesMessages_givenArrayList()
      throws RequiredAttributeNotProvidedException {
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
   * Test
   * {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map, ActivityMessages)}
   * with {@code product}, {@code attributeValues}, {@code messages}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map, ActivityMessages)}
   */
  @Test
  public void testFindMatchingSkuWithProductAttributeValuesMessages_whenNull_thenReturnNull()
      throws RequiredAttributeNotProvidedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl = new OrderItemRequestValidationServiceImpl();
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act and Assert
    assertNull(orderItemRequestValidationServiceImpl.findMatchingSku(null, attributeValues,
        new DefaultProcessContextImpl<>()));
  }

  /**
   * Test
   * {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map, ActivityMessages)}
   * with {@code product}, {@code attributeValues}, {@code messages}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map, ActivityMessages)}
   */
  @Test
  public void testFindMatchingSkuWithProductAttributeValuesMessages_whenProductBundleImpl()
      throws RequiredAttributeNotProvidedException {
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
   * Test
   * {@link OrderItemRequestValidationServiceImpl#shouldValidateWithException(boolean, boolean, String, boolean)}.
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#shouldValidateWithException(boolean, boolean, String, boolean)}
   */
  @Test
  public void testShouldValidateWithException_when0123456789abcdef_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new OrderItemRequestValidationServiceImpl()).shouldValidateWithException(false, false,
        "0123456789ABCDEF", false));
  }

  /**
   * Test
   * {@link OrderItemRequestValidationServiceImpl#shouldValidateWithException(boolean, boolean, String, boolean)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#shouldValidateWithException(boolean, boolean, String, boolean)}
   */
  @Test
  public void testShouldValidateWithException_whenEmptyString_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new OrderItemRequestValidationServiceImpl()).shouldValidateWithException(false, false, "", false));
  }

  /**
   * Test
   * {@link OrderItemRequestValidationServiceImpl#shouldValidateWithException(boolean, boolean, String, boolean)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#shouldValidateWithException(boolean, boolean, String, boolean)}
   */
  @Test
  public void testShouldValidateWithException_whenNull_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new OrderItemRequestValidationServiceImpl()).shouldValidateWithException(false, false, null, false));
  }

  /**
   * Test
   * {@link OrderItemRequestValidationServiceImpl#shouldValidateWithException(boolean, boolean, String, boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#shouldValidateWithException(boolean, boolean, String, boolean)}
   */
  @Test
  public void testShouldValidateWithException_whenTrue_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new OrderItemRequestValidationServiceImpl()).shouldValidateWithException(true, false,
        "0123456789ABCDEF", true));
  }

  /**
   * Test
   * {@link OrderItemRequestValidationServiceImpl#shouldValidateWithException(boolean, boolean, String, boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderItemRequestValidationServiceImpl#shouldValidateWithException(boolean, boolean, String, boolean)}
   */
  @Test
  public void testShouldValidateWithException_whenTrue_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new OrderItemRequestValidationServiceImpl()).shouldValidateWithException(true, true, "0123456789ABCDEF",
        true));
  }
}

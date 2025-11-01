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
package org.broadleafcommerce.core.order.service.workflow.add;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.currency.domain.NullBroadleafCurrency;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.service.call.AddToCartItem;
import org.broadleafcommerce.core.order.service.call.NonDiscreteOrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.exception.RequiredAttributeNotProvidedException;
import org.broadleafcommerce.core.order.service.workflow.CartOperationRequest;
import org.broadleafcommerce.core.workflow.ActivityMessages;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.broadleafcommerce.core.workflow.state.RollbackHandler;
import org.junit.Test;

public class ValidateAddRequestActivityDiffblueTest {
  /**
   * Method under test: {@link ValidateAddRequestActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    ProcessContext<CartOperationRequest> context = mock(ProcessContext.class);
    when(context.stopProcess()).thenReturn(true);
    NullOrderImpl order = new NullOrderImpl();
    when(context.getSeedData()).thenReturn(new CartOperationRequest(order, new OrderItemRequestDTO(), true));

    // Act
    ProcessContext<CartOperationRequest> actualExecuteResult = validateAddRequestActivity.execute(context);

    // Assert
    verify(context).getSeedData();
    verify(context).stopProcess();
    assertSame(context, actualExecuteResult);
  }

  /**
   * Method under test: {@link ValidateAddRequestActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute2() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    ProcessContext<CartOperationRequest> context = mock(ProcessContext.class);
    when(context.stopProcess()).thenThrow(new IllegalArgumentException("foo"));
    NullOrderImpl order = new NullOrderImpl();
    when(context.getSeedData()).thenReturn(new CartOperationRequest(order, new OrderItemRequestDTO(), true));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> validateAddRequestActivity.execute(context));
    verify(context).getSeedData();
    verify(context).stopProcess();
  }

  /**
   * Method under test: {@link ValidateAddRequestActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute3() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO();
    itemRequest.setQuantity(0);
    CartOperationRequest cartOperationRequest = new CartOperationRequest(new NullOrderImpl(), itemRequest, true);

    ProcessContext<CartOperationRequest> context = mock(ProcessContext.class);
    when(context.stopProcess()).thenReturn(true);
    when(context.getSeedData()).thenReturn(cartOperationRequest);

    // Act
    ProcessContext<CartOperationRequest> actualExecuteResult = validateAddRequestActivity.execute(context);

    // Assert
    verify(context).getSeedData();
    verify(context).stopProcess();
    assertSame(context, actualExecuteResult);
  }

  /**
   * Method under test: {@link ValidateAddRequestActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute4() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO();
    itemRequest.setQuantity(-1);
    ProcessContext<CartOperationRequest> context = mock(ProcessContext.class);
    when(context.getSeedData()).thenReturn(new CartOperationRequest(new NullOrderImpl(), itemRequest, true));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> validateAddRequestActivity.execute(context));
    verify(context).getSeedData();
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#validate(ProcessContext)}
   */
  @Test
  public void testValidate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    ProcessContext<CartOperationRequest> context = mock(ProcessContext.class);
    when(context.stopProcess()).thenReturn(true);
    NullOrderImpl order = new NullOrderImpl();
    when(context.getSeedData()).thenReturn(new CartOperationRequest(order, new OrderItemRequestDTO(), true));

    // Act
    ProcessContext<CartOperationRequest> actualValidateResult = validateAddRequestActivity.validate(context);

    // Assert
    verify(context).getSeedData();
    verify(context).stopProcess();
    assertSame(context, actualValidateResult);
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#validate(ProcessContext)}
   */
  @Test
  public void testValidate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    ProcessContext<CartOperationRequest> context = mock(ProcessContext.class);
    when(context.stopProcess()).thenThrow(new IllegalArgumentException("foo"));
    NullOrderImpl order = new NullOrderImpl();
    when(context.getSeedData()).thenReturn(new CartOperationRequest(order, new OrderItemRequestDTO(), true));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> validateAddRequestActivity.validate(context));
    verify(context).getSeedData();
    verify(context).stopProcess();
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#validate(ProcessContext)}
   */
  @Test
  public void testValidate3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO();
    itemRequest.setQuantity(0);
    CartOperationRequest cartOperationRequest = new CartOperationRequest(new NullOrderImpl(), itemRequest, true);

    ProcessContext<CartOperationRequest> context = mock(ProcessContext.class);
    when(context.stopProcess()).thenReturn(true);
    when(context.getSeedData()).thenReturn(cartOperationRequest);

    // Act
    ProcessContext<CartOperationRequest> actualValidateResult = validateAddRequestActivity.validate(context);

    // Assert
    verify(context).getSeedData();
    verify(context).stopProcess();
    assertSame(context, actualValidateResult);
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#validate(ProcessContext)}
   */
  @Test
  public void testValidate4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO();
    itemRequest.setQuantity(-1);
    ProcessContext<CartOperationRequest> context = mock(ProcessContext.class);
    when(context.getSeedData()).thenReturn(new CartOperationRequest(new NullOrderImpl(), itemRequest, true));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> validateAddRequestActivity.validate(context));
    verify(context).getSeedData();
  }

  /**
   * Method under test: {@link ValidateAddRequestActivity#hasQuantity(Integer)}
   */
  @Test
  public void testHasQuantity() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ValidateAddRequestActivity()).hasQuantity(2));
    assertFalse((new ValidateAddRequestActivity()).hasQuantity(null));
    assertFalse((new ValidateAddRequestActivity()).hasQuantity(0));
  }

  /**
   * Method under test: {@link ValidateAddRequestActivity#hasQuantity(Integer)}
   */
  @Test
  public void testHasQuantity2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    validateAddRequestActivity.setRollbackHandler(mock(RollbackHandler.class));

    // Act and Assert
    assertTrue(validateAddRequestActivity.hasQuantity(2));
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#determineProduct(OrderItemRequestDTO)}
   */
  @Test
  public void testDetermineProduct() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    // Act and Assert
    assertNull(validateAddRequestActivity.determineProduct(new OrderItemRequestDTO()));
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#canSellDefaultSku(Product)}
   */
  @Test
  public void testCanSellDefaultSku() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    // Act and Assert
    assertTrue(validateAddRequestActivity.canSellDefaultSku(new ProductBundleImpl()));
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#canSellDefaultSku(Product)}
   */
  @Test
  public void testCanSellDefaultSku2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getAdditionalSkus()).thenReturn(new ArrayList<>());

    // Act
    boolean actualCanSellDefaultSkuResult = validateAddRequestActivity.canSellDefaultSku(product);

    // Assert
    verify(product).getAdditionalSkus();
    assertTrue(actualCanSellDefaultSkuResult);
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#canSellDefaultSku(Product)}
   */
  @Test
  public void testCanSellDefaultSku3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(new SkuImpl());
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getCanSellWithoutOptions()).thenReturn(true);
    when(product.getAdditionalSkus()).thenReturn(skuList);

    // Act
    boolean actualCanSellDefaultSkuResult = validateAddRequestActivity.canSellDefaultSku(product);

    // Assert
    verify(product).getAdditionalSkus();
    verify(product).getCanSellWithoutOptions();
    assertTrue(actualCanSellDefaultSkuResult);
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#canSellDefaultSku(Product)}
   */
  @Test
  public void testCanSellDefaultSku4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(new SkuImpl());
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getCanSellWithoutOptions()).thenReturn(false);
    when(product.getAdditionalSkus()).thenReturn(skuList);

    // Act
    boolean actualCanSellDefaultSkuResult = validateAddRequestActivity.canSellDefaultSku(product);

    // Assert
    verify(product).getAdditionalSkus();
    verify(product).getCanSellWithoutOptions();
    assertFalse(actualCanSellDefaultSkuResult);
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#findMatchingSku(Product, Map)}
   */
  @Test
  public void testFindMatchingSku() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    ProductBundleImpl product = new ProductBundleImpl();

    // Act and Assert
    assertNull(validateAddRequestActivity.findMatchingSku(product, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#findMatchingSku(Product, Map)}
   */
  @Test
  public void testFindMatchingSku2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    ProductBundleImpl product = mock(ProductBundleImpl.class);

    // Act and Assert
    assertNull(validateAddRequestActivity.findMatchingSku(product, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#findMatchingSku(Product, Map, ActivityMessages)}
   */
  @Test
  public void testFindMatchingSku3() throws RequiredAttributeNotProvidedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    ProductBundleImpl product = new ProductBundleImpl();
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act and Assert
    assertNull(validateAddRequestActivity.findMatchingSku(product, attributeValues, new DefaultProcessContextImpl<>()));
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#findMatchingSku(Product, Map, ActivityMessages)}
   */
  @Test
  public void testFindMatchingSku4() throws RequiredAttributeNotProvidedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act and Assert
    assertNull(validateAddRequestActivity.findMatchingSku(null, attributeValues, new DefaultProcessContextImpl<>()));
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#findMatchingSku(Product, Map, ActivityMessages)}
   */
  @Test
  public void testFindMatchingSku5() throws RequiredAttributeNotProvidedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getProductOptionXrefs()).thenReturn(new ArrayList<>());
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act
    Sku actualFindMatchingSkuResult = validateAddRequestActivity.findMatchingSku(product, attributeValues,
        new DefaultProcessContextImpl<>());

    // Assert
    verify(product).getProductOptionXrefs();
    assertNull(actualFindMatchingSkuResult);
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#shouldValidateWithException(boolean, boolean, String, boolean)}
   */
  @Test
  public void testShouldValidateWithException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ValidateAddRequestActivity()).shouldValidateWithException(true, true, "0123456789ABCDEF", true));
    assertFalse((new ValidateAddRequestActivity()).shouldValidateWithException(false, false, null, false));
    assertTrue((new ValidateAddRequestActivity()).shouldValidateWithException(false, false, "0123456789ABCDEF", false));
    assertFalse((new ValidateAddRequestActivity()).shouldValidateWithException(true, false, "0123456789ABCDEF", true));
    assertFalse((new ValidateAddRequestActivity()).shouldValidateWithException(false, false, "", false));
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#shouldValidateWithException(boolean, boolean, String, boolean)}
   */
  @Test
  public void testShouldValidateWithException2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    validateAddRequestActivity.setRollbackHandler(mock(RollbackHandler.class));

    // Act and Assert
    assertTrue(validateAddRequestActivity.shouldValidateWithException(true, true, "0123456789ABCDEF", true));
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)}
   */
  @Test
  public void testAddSkuToCart() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    SkuImpl sku = new SkuImpl();
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    ProductBundleImpl product = new ProductBundleImpl();
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> validateAddRequestActivity.addSkuToCart(sku, orderItemRequestDTO,
        product, new CartOperationRequest(order, new OrderItemRequestDTO(), true)));
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)}
   */
  @Test
  public void testAddSkuToCart2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    NonDiscreteOrderItemRequestDTO orderItemRequestDTO = new NonDiscreteOrderItemRequestDTO();
    orderItemRequestDTO.setItemName(null);
    orderItemRequestDTO.setOverrideRetailPrice(null);
    orderItemRequestDTO.setOverrideSalePrice(null);
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> validateAddRequestActivity.addSkuToCart(null,
        orderItemRequestDTO, null, new CartOperationRequest(order, new OrderItemRequestDTO(), true)));
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)}
   */
  @Test
  public void testAddSkuToCart3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    NonDiscreteOrderItemRequestDTO orderItemRequestDTO = new NonDiscreteOrderItemRequestDTO();
    orderItemRequestDTO.setItemName("Order Item Request DTO");
    orderItemRequestDTO.setOverrideRetailPrice(null);
    orderItemRequestDTO.setOverrideSalePrice(null);
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> validateAddRequestActivity.addSkuToCart(null,
        orderItemRequestDTO, null, new CartOperationRequest(order, new OrderItemRequestDTO(), true)));
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)}
   */
  @Test
  public void testAddSkuToCart4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    ProductBundleImpl product = new ProductBundleImpl();
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> validateAddRequestActivity.addSkuToCart(null,
        orderItemRequestDTO, product, new CartOperationRequest(order, new OrderItemRequestDTO(), true)));
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)}
   */
  @Test
  public void testAddSkuToCart5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    Sku sku = mock(Sku.class);
    when(sku.isActive()).thenReturn(true);
    when(sku.getId()).thenReturn(1L);
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    ProductBundleImpl product = new ProductBundleImpl();
    NullOrderImpl order = new NullOrderImpl();

    // Act
    validateAddRequestActivity.addSkuToCart(sku, orderItemRequestDTO, product,
        new CartOperationRequest(order, new OrderItemRequestDTO(), true));

    // Assert
    verify(sku).getId();
    verify(sku).isActive();
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)}
   */
  @Test
  public void testAddSkuToCart6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    Sku sku = mock(Sku.class);
    when(sku.isActive()).thenThrow(new RequiredAttributeNotProvidedException("The requested skuId ("));

    NonDiscreteOrderItemRequestDTO orderItemRequestDTO = new NonDiscreteOrderItemRequestDTO();
    orderItemRequestDTO.setItemName(null);
    orderItemRequestDTO.setOverrideRetailPrice(null);
    orderItemRequestDTO.setOverrideSalePrice(null);
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertThrows(RequiredAttributeNotProvidedException.class, () -> validateAddRequestActivity.addSkuToCart(sku,
        orderItemRequestDTO, null, new CartOperationRequest(order, new OrderItemRequestDTO(), true)));
    verify(sku).isActive();
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)}
   */
  @Test
  public void testAddSkuToCart7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    NonDiscreteOrderItemRequestDTO orderItemRequestDTO = new NonDiscreteOrderItemRequestDTO();
    orderItemRequestDTO.setItemName("");
    orderItemRequestDTO.setOverrideRetailPrice(null);
    orderItemRequestDTO.setOverrideSalePrice(null);
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> validateAddRequestActivity.addSkuToCart(null,
        orderItemRequestDTO, null, new CartOperationRequest(order, new OrderItemRequestDTO(), true)));
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#hasSkuOrIsNonDiscreteOI(Sku, OrderItemRequestDTO)}
   */
  @Test
  public void testHasSkuOrIsNonDiscreteOI() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    SkuImpl sku = new SkuImpl();

    // Act and Assert
    assertTrue(validateAddRequestActivity.hasSkuOrIsNonDiscreteOI(sku, new OrderItemRequestDTO()));
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#hasSkuOrIsNonDiscreteOI(Sku, OrderItemRequestDTO)}
   */
  @Test
  public void testHasSkuOrIsNonDiscreteOI2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    // Act and Assert
    assertTrue(validateAddRequestActivity.hasSkuOrIsNonDiscreteOI(null, new NonDiscreteOrderItemRequestDTO()));
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#hasSkuOrIsNonDiscreteOI(Sku, OrderItemRequestDTO)}
   */
  @Test
  public void testHasSkuOrIsNonDiscreteOI3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    // Act and Assert
    assertFalse(validateAddRequestActivity.hasSkuOrIsNonDiscreteOI(null, new OrderItemRequestDTO()));
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#hasSkuOrIsNonDiscreteOI(Sku, OrderItemRequestDTO)}
   */
  @Test
  public void testHasSkuOrIsNonDiscreteOI4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    SkuImpl sku = mock(SkuImpl.class);

    // Act and Assert
    assertTrue(validateAddRequestActivity.hasSkuOrIsNonDiscreteOI(sku, new OrderItemRequestDTO()));
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#handleIfNoSku(OrderItemRequestDTO, Product)}
   */
  @Test
  public void testHandleIfNoSku() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> validateAddRequestActivity.handleIfNoSku(orderItemRequestDTO, new ProductBundleImpl()));
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#handleIfNoSku(OrderItemRequestDTO, Product)}
   */
  @Test
  public void testHandleIfNoSku2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> validateAddRequestActivity.handleIfNoSku(new OrderItemRequestDTO(), null));
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#handleIfNoSku(OrderItemRequestDTO, Product)}
   */
  @Test
  public void testHandleIfNoSku3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("Could not find SKU for : productId: ", "Could not find SKU for : productId: ");
    AddToCartItem orderItemRequestDTO = mock(AddToCartItem.class);
    when(orderItemRequestDTO.getSkuId()).thenReturn(1L);
    when(orderItemRequestDTO.getItemAttributes()).thenReturn(stringStringMap);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> validateAddRequestActivity.handleIfNoSku(orderItemRequestDTO, new ProductBundleImpl()));
    verify(orderItemRequestDTO).getItemAttributes();
    verify(orderItemRequestDTO).getSkuId();
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#handleIfNoSku(OrderItemRequestDTO, Product)}
   */
  @Test
  public void testHandleIfNoSku4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    AddToCartItem orderItemRequestDTO = mock(AddToCartItem.class);
    when(orderItemRequestDTO.getItemAttributes()).thenReturn(new HashMap<>());
    Product product = mock(Product.class);
    when(product.getId()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> validateAddRequestActivity.handleIfNoSku(orderItemRequestDTO, product));
    verify(product).getId();
    verify(orderItemRequestDTO).getItemAttributes();
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#handleIfNonDiscreteOI(OrderItemRequestDTO)}
   */
  @Test
  public void testHandleIfNonDiscreteOI() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    NonDiscreteOrderItemRequestDTO orderItemRequestDTO = new NonDiscreteOrderItemRequestDTO();
    orderItemRequestDTO.setItemName(null);
    orderItemRequestDTO.setOverrideRetailPrice(null);
    orderItemRequestDTO.setOverrideSalePrice(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> validateAddRequestActivity.handleIfNonDiscreteOI(orderItemRequestDTO));
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#handleIfNonDiscreteOI(OrderItemRequestDTO)}
   */
  @Test
  public void testHandleIfNonDiscreteOI2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    NonDiscreteOrderItemRequestDTO orderItemRequestDTO = new NonDiscreteOrderItemRequestDTO();
    orderItemRequestDTO.setItemName("Order Item Request DTO");
    orderItemRequestDTO.setOverrideRetailPrice(null);
    orderItemRequestDTO.setOverrideSalePrice(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> validateAddRequestActivity.handleIfNonDiscreteOI(orderItemRequestDTO));
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#handleIfNonDiscreteOI(OrderItemRequestDTO)}
   */
  @Test
  public void testHandleIfNonDiscreteOI3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    NonDiscreteOrderItemRequestDTO orderItemRequestDTO = mock(NonDiscreteOrderItemRequestDTO.class);
    when(orderItemRequestDTO.getOverrideRetailPrice()).thenReturn(new Money());
    when(orderItemRequestDTO.getItemName()).thenReturn("Item Name");

    // Act
    validateAddRequestActivity.handleIfNonDiscreteOI(orderItemRequestDTO);

    // Assert
    verify(orderItemRequestDTO).getItemName();
    verify(orderItemRequestDTO).getOverrideRetailPrice();
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#handleIfNonDiscreteOI(OrderItemRequestDTO)}
   */
  @Test
  public void testHandleIfNonDiscreteOI4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    NonDiscreteOrderItemRequestDTO orderItemRequestDTO = mock(NonDiscreteOrderItemRequestDTO.class);
    when(orderItemRequestDTO.getItemName()).thenReturn("");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> validateAddRequestActivity.handleIfNonDiscreteOI(orderItemRequestDTO));
    verify(orderItemRequestDTO).getItemName();
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#hasPrice(NonDiscreteOrderItemRequestDTO)}
   */
  @Test
  public void testHasPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    // Act and Assert
    assertFalse(validateAddRequestActivity.hasPrice(new NonDiscreteOrderItemRequestDTO()));
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#hasPrice(NonDiscreteOrderItemRequestDTO)}
   */
  @Test
  public void testHasPrice2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    NonDiscreteOrderItemRequestDTO ndr = new NonDiscreteOrderItemRequestDTO();
    ndr.setOverrideRetailPrice(null);
    ndr.setOverrideSalePrice(new Money());

    // Act and Assert
    assertTrue(validateAddRequestActivity.hasPrice(ndr));
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#hasPrice(NonDiscreteOrderItemRequestDTO)}
   */
  @Test
  public void testHasPrice3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    NonDiscreteOrderItemRequestDTO ndr = new NonDiscreteOrderItemRequestDTO();
    ndr.setOverrideRetailPrice(new Money());
    ndr.setOverrideSalePrice(null);

    // Act and Assert
    assertTrue(validateAddRequestActivity.hasPrice(ndr));
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#hasPrice(NonDiscreteOrderItemRequestDTO)}
   */
  @Test
  public void testHasPrice4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    NonDiscreteOrderItemRequestDTO ndr = mock(NonDiscreteOrderItemRequestDTO.class);
    when(ndr.getOverrideRetailPrice()).thenReturn(new Money());

    // Act
    boolean actualHasPriceResult = validateAddRequestActivity.hasPrice(ndr);

    // Assert
    verify(ndr).getOverrideRetailPrice();
    assertTrue(actualHasPriceResult);
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)}
   */
  @Test
  public void testHasSameCurrency() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act and Assert
    assertTrue(validateAddRequestActivity.hasSameCurrency(orderItemRequestDTO, request, new SkuImpl()));
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)}
   */
  @Test
  public void testHasSameCurrency2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    NonDiscreteOrderItemRequestDTO orderItemRequestDTO = new NonDiscreteOrderItemRequestDTO();
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act and Assert
    assertTrue(validateAddRequestActivity.hasSameCurrency(orderItemRequestDTO, request, new SkuImpl()));
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)}
   */
  @Test
  public void testHasSameCurrency3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    NonDiscreteOrderItemRequestDTO orderItemRequestDTO = mock(NonDiscreteOrderItemRequestDTO.class);
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act and Assert
    assertTrue(validateAddRequestActivity.hasSameCurrency(orderItemRequestDTO, request, new SkuImpl()));
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)}
   */
  @Test
  public void testHasSameCurrency4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertTrue(validateAddRequestActivity.hasSameCurrency(orderItemRequestDTO,
        new CartOperationRequest(order, new OrderItemRequestDTO(), true), null));
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)}
   */
  @Test
  public void testHasSameCurrency5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    Sku sku = mock(Sku.class);
    when(sku.getCurrency()).thenReturn(new BroadleafCurrencyImpl());

    // Act
    boolean actualHasSameCurrencyResult = validateAddRequestActivity.hasSameCurrency(orderItemRequestDTO, request, sku);

    // Assert
    verify(sku).getCurrency();
    assertTrue(actualHasSameCurrencyResult);
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)}
   */
  @Test
  public void testHasSameCurrency6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    Sku sku = mock(Sku.class);
    when(sku.getCurrency()).thenReturn(new BroadleafCurrencyImpl());

    // Act
    boolean actualHasSameCurrencyResult = validateAddRequestActivity.hasSameCurrency(orderItemRequestDTO, request, sku);

    // Assert
    verify(sku, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getCurrency();
    assertTrue(actualHasSameCurrencyResult);
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)}
   */
  @Test
  public void testHasSameCurrency7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(new NullBroadleafCurrency());
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    Sku sku = mock(Sku.class);
    when(sku.getCurrency()).thenReturn(new BroadleafCurrencyImpl());

    // Act
    boolean actualHasSameCurrencyResult = validateAddRequestActivity.hasSameCurrency(orderItemRequestDTO, request, sku);

    // Assert
    verify(sku, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getCurrency();
    assertFalse(actualHasSameCurrencyResult);
  }

  /**
   * Method under test:
   * {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)}
   */
  @Test
  public void testHasSameCurrency8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenThrow(new IllegalArgumentException("foo"));
    Sku sku = mock(Sku.class);
    when(sku.getCurrency()).thenReturn(broadleafCurrencyImpl);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> validateAddRequestActivity.hasSameCurrency(orderItemRequestDTO, request, sku));
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(sku, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getCurrency();
  }
}

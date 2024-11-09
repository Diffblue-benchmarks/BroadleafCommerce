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
   * Test {@link ValidateAddRequestActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)}
   * with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_givenIllegalArgumentExceptionWithFoo() throws Exception {
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
   * Test {@link ValidateAddRequestActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link OrderItemRequestDTO#OrderItemRequestDTO()} Quantity is minus
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_givenOrderItemRequestDTOQuantityIsMinusOne() throws Exception {
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
   * Test {@link ValidateAddRequestActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link OrderItemRequestDTO#OrderItemRequestDTO()} Quantity is
   * zero.</li>
   *   <li>Then return {@link ProcessContext}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_givenOrderItemRequestDTOQuantityIsZero_thenReturnProcessContext() throws Exception {
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
   * Test {@link ValidateAddRequestActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then return {@link ProcessContext}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_givenTrue_thenReturnProcessContext() throws Exception {
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
   * Test {@link ValidateAddRequestActivity#validate(ProcessContext)}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)}
   * with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#validate(ProcessContext)}
   */
  @Test
  public void testValidate_givenIllegalArgumentExceptionWithFoo() {
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
   * Test {@link ValidateAddRequestActivity#validate(ProcessContext)}.
   * <ul>
   *   <li>Given {@link OrderItemRequestDTO#OrderItemRequestDTO()} Quantity is minus
   * one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#validate(ProcessContext)}
   */
  @Test
  public void testValidate_givenOrderItemRequestDTOQuantityIsMinusOne() {
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
   * Test {@link ValidateAddRequestActivity#validate(ProcessContext)}.
   * <ul>
   *   <li>Given {@link OrderItemRequestDTO#OrderItemRequestDTO()} Quantity is
   * zero.</li>
   *   <li>Then return {@link ProcessContext}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#validate(ProcessContext)}
   */
  @Test
  public void testValidate_givenOrderItemRequestDTOQuantityIsZero_thenReturnProcessContext() {
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
   * Test {@link ValidateAddRequestActivity#validate(ProcessContext)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then return {@link ProcessContext}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#validate(ProcessContext)}
   */
  @Test
  public void testValidate_givenTrue_thenReturnProcessContext() {
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
   * Test {@link ValidateAddRequestActivity#hasQuantity(Integer)}.
   * <ul>
   *   <li>Given {@link ValidateAddRequestActivity} (default constructor)
   * RollbackHandler is {@link RollbackHandler}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#hasQuantity(Integer)}
   */
  @Test
  public void testHasQuantity_givenValidateAddRequestActivityRollbackHandlerIsRollbackHandler() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    validateAddRequestActivity.setRollbackHandler(mock(RollbackHandler.class));

    // Act and Assert
    assertTrue(validateAddRequestActivity.hasQuantity(2));
  }

  /**
   * Test {@link ValidateAddRequestActivity#hasQuantity(Integer)}.
   * <ul>
   *   <li>Given {@link ValidateAddRequestActivity} (default constructor).</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#hasQuantity(Integer)}
   */
  @Test
  public void testHasQuantity_givenValidateAddRequestActivity_whenNull_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ValidateAddRequestActivity()).hasQuantity(null));
  }

  /**
   * Test {@link ValidateAddRequestActivity#hasQuantity(Integer)}.
   * <ul>
   *   <li>Given {@link ValidateAddRequestActivity} (default constructor).</li>
   *   <li>When two.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#hasQuantity(Integer)}
   */
  @Test
  public void testHasQuantity_givenValidateAddRequestActivity_whenTwo_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ValidateAddRequestActivity()).hasQuantity(2));
  }

  /**
   * Test {@link ValidateAddRequestActivity#hasQuantity(Integer)}.
   * <ul>
   *   <li>Given {@link ValidateAddRequestActivity} (default constructor).</li>
   *   <li>When zero.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#hasQuantity(Integer)}
   */
  @Test
  public void testHasQuantity_givenValidateAddRequestActivity_whenZero_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ValidateAddRequestActivity()).hasQuantity(0));
  }

  /**
   * Test
   * {@link ValidateAddRequestActivity#determineProduct(OrderItemRequestDTO)}.
   * <ul>
   *   <li>When {@link OrderItemRequestDTO#OrderItemRequestDTO()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#determineProduct(OrderItemRequestDTO)}
   */
  @Test
  public void testDetermineProduct_whenOrderItemRequestDTO_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    // Act and Assert
    assertNull(validateAddRequestActivity.determineProduct(new OrderItemRequestDTO()));
  }

  /**
   * Test {@link ValidateAddRequestActivity#canSellDefaultSku(Product)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#canSellDefaultSku(Product)}
   */
  @Test
  public void testCanSellDefaultSku_givenArrayList_thenReturnTrue() {
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
   * Test {@link ValidateAddRequestActivity#canSellDefaultSku(Product)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#canSellDefaultSku(Product)}
   */
  @Test
  public void testCanSellDefaultSku_givenFalse_thenReturnFalse() {
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
   * Test {@link ValidateAddRequestActivity#canSellDefaultSku(Product)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#canSellDefaultSku(Product)}
   */
  @Test
  public void testCanSellDefaultSku_givenTrue() {
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
   * Test {@link ValidateAddRequestActivity#canSellDefaultSku(Product)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#canSellDefaultSku(Product)}
   */
  @Test
  public void testCanSellDefaultSku_whenProductBundleImpl_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    // Act and Assert
    assertTrue(validateAddRequestActivity.canSellDefaultSku(new ProductBundleImpl()));
  }

  /**
   * Test {@link ValidateAddRequestActivity#findMatchingSku(Product, Map)} with
   * {@code product}, {@code attributeValuesForSku}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#findMatchingSku(Product, Map)}
   */
  @Test
  public void testFindMatchingSkuWithProductAttributeValuesForSku_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    ProductBundleImpl product = new ProductBundleImpl();

    // Act and Assert
    assertNull(validateAddRequestActivity.findMatchingSku(product, new HashMap<>()));
  }

  /**
   * Test {@link ValidateAddRequestActivity#findMatchingSku(Product, Map)} with
   * {@code product}, {@code attributeValuesForSku}.
   * <ul>
   *   <li>When {@link ProductBundleImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#findMatchingSku(Product, Map)}
   */
  @Test
  public void testFindMatchingSkuWithProductAttributeValuesForSku_whenProductBundleImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    ProductBundleImpl product = mock(ProductBundleImpl.class);

    // Act and Assert
    assertNull(validateAddRequestActivity.findMatchingSku(product, new HashMap<>()));
  }

  /**
   * Test
   * {@link ValidateAddRequestActivity#findMatchingSku(Product, Map, ActivityMessages)}
   * with {@code product}, {@code attributeValues}, {@code messages}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#findMatchingSku(Product, Map, ActivityMessages)}
   */
  @Test
  public void testFindMatchingSkuWithProductAttributeValuesMessages_givenArrayList()
      throws RequiredAttributeNotProvidedException {
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
   * Test
   * {@link ValidateAddRequestActivity#findMatchingSku(Product, Map, ActivityMessages)}
   * with {@code product}, {@code attributeValues}, {@code messages}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#findMatchingSku(Product, Map, ActivityMessages)}
   */
  @Test
  public void testFindMatchingSkuWithProductAttributeValuesMessages_whenNull_thenReturnNull()
      throws RequiredAttributeNotProvidedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act and Assert
    assertNull(validateAddRequestActivity.findMatchingSku(null, attributeValues, new DefaultProcessContextImpl<>()));
  }

  /**
   * Test
   * {@link ValidateAddRequestActivity#findMatchingSku(Product, Map, ActivityMessages)}
   * with {@code product}, {@code attributeValues}, {@code messages}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#findMatchingSku(Product, Map, ActivityMessages)}
   */
  @Test
  public void testFindMatchingSkuWithProductAttributeValuesMessages_whenProductBundleImpl()
      throws RequiredAttributeNotProvidedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    ProductBundleImpl product = new ProductBundleImpl();
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act and Assert
    assertNull(validateAddRequestActivity.findMatchingSku(product, attributeValues, new DefaultProcessContextImpl<>()));
  }

  /**
   * Test
   * {@link ValidateAddRequestActivity#shouldValidateWithException(boolean, boolean, String, boolean)}.
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#shouldValidateWithException(boolean, boolean, String, boolean)}
   */
  @Test
  public void testShouldValidateWithException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    validateAddRequestActivity.setRollbackHandler(mock(RollbackHandler.class));

    // Act and Assert
    assertTrue(validateAddRequestActivity.shouldValidateWithException(true, true, "0123456789ABCDEF", true));
  }

  /**
   * Test
   * {@link ValidateAddRequestActivity#shouldValidateWithException(boolean, boolean, String, boolean)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#shouldValidateWithException(boolean, boolean, String, boolean)}
   */
  @Test
  public void testShouldValidateWithException_whenEmptyString_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ValidateAddRequestActivity()).shouldValidateWithException(false, false, "", false));
  }

  /**
   * Test
   * {@link ValidateAddRequestActivity#shouldValidateWithException(boolean, boolean, String, boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#shouldValidateWithException(boolean, boolean, String, boolean)}
   */
  @Test
  public void testShouldValidateWithException_whenFalse_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ValidateAddRequestActivity()).shouldValidateWithException(false, false, "0123456789ABCDEF", false));
  }

  /**
   * Test
   * {@link ValidateAddRequestActivity#shouldValidateWithException(boolean, boolean, String, boolean)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#shouldValidateWithException(boolean, boolean, String, boolean)}
   */
  @Test
  public void testShouldValidateWithException_whenNull_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ValidateAddRequestActivity()).shouldValidateWithException(false, false, null, false));
  }

  /**
   * Test
   * {@link ValidateAddRequestActivity#shouldValidateWithException(boolean, boolean, String, boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#shouldValidateWithException(boolean, boolean, String, boolean)}
   */
  @Test
  public void testShouldValidateWithException_whenTrue_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ValidateAddRequestActivity()).shouldValidateWithException(true, false, "0123456789ABCDEF", true));
  }

  /**
   * Test
   * {@link ValidateAddRequestActivity#shouldValidateWithException(boolean, boolean, String, boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#shouldValidateWithException(boolean, boolean, String, boolean)}
   */
  @Test
  public void testShouldValidateWithException_whenTrue_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ValidateAddRequestActivity()).shouldValidateWithException(true, true, "0123456789ABCDEF", true));
  }

  /**
   * Test
   * {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)}
   */
  @Test
  public void testAddSkuToCart_givenEmptyString() {
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
   * Test
   * {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)}.
   * <ul>
   *   <li>Given {@code Order Item Request DTO}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)}
   */
  @Test
  public void testAddSkuToCart_givenOrderItemRequestDto() {
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
   * Test
   * {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link Sku} {@link Sku#isActive()} return {@code true}.</li>
   *   <li>Then calls {@link Sku#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)}
   */
  @Test
  public void testAddSkuToCart_givenTrue_whenSkuIsActiveReturnTrue_thenCallsGetId() {
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
   * Test
   * {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)}.
   * <ul>
   *   <li>Then throw {@link RequiredAttributeNotProvidedException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)}
   */
  @Test
  public void testAddSkuToCart_thenThrowRequiredAttributeNotProvidedException() {
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
   * Test
   * {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)}.
   * <ul>
   *   <li>When
   * {@link NonDiscreteOrderItemRequestDTO#NonDiscreteOrderItemRequestDTO()}
   * ItemName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)}
   */
  @Test
  public void testAddSkuToCart_whenNonDiscreteOrderItemRequestDTOItemNameIsNull() {
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
   * Test
   * {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)}.
   * <ul>
   *   <li>When {@link OrderItemRequestDTO#OrderItemRequestDTO()}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)}
   */
  @Test
  public void testAddSkuToCart_whenOrderItemRequestDTO_thenThrowIllegalArgumentException() {
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
   * Test
   * {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)}.
   * <ul>
   *   <li>When {@link SkuImpl} (default constructor).</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)}
   */
  @Test
  public void testAddSkuToCart_whenSkuImpl_thenThrowIllegalArgumentException() {
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
   * Test
   * {@link ValidateAddRequestActivity#hasSkuOrIsNonDiscreteOI(Sku, OrderItemRequestDTO)}.
   * <ul>
   *   <li>When
   * {@link NonDiscreteOrderItemRequestDTO#NonDiscreteOrderItemRequestDTO()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#hasSkuOrIsNonDiscreteOI(Sku, OrderItemRequestDTO)}
   */
  @Test
  public void testHasSkuOrIsNonDiscreteOI_whenNonDiscreteOrderItemRequestDTO_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    // Act and Assert
    assertTrue(validateAddRequestActivity.hasSkuOrIsNonDiscreteOI(null, new NonDiscreteOrderItemRequestDTO()));
  }

  /**
   * Test
   * {@link ValidateAddRequestActivity#hasSkuOrIsNonDiscreteOI(Sku, OrderItemRequestDTO)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#hasSkuOrIsNonDiscreteOI(Sku, OrderItemRequestDTO)}
   */
  @Test
  public void testHasSkuOrIsNonDiscreteOI_whenNull_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    // Act and Assert
    assertFalse(validateAddRequestActivity.hasSkuOrIsNonDiscreteOI(null, new OrderItemRequestDTO()));
  }

  /**
   * Test
   * {@link ValidateAddRequestActivity#hasSkuOrIsNonDiscreteOI(Sku, OrderItemRequestDTO)}.
   * <ul>
   *   <li>When {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#hasSkuOrIsNonDiscreteOI(Sku, OrderItemRequestDTO)}
   */
  @Test
  public void testHasSkuOrIsNonDiscreteOI_whenSkuImpl_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    SkuImpl sku = new SkuImpl();

    // Act and Assert
    assertTrue(validateAddRequestActivity.hasSkuOrIsNonDiscreteOI(sku, new OrderItemRequestDTO()));
  }

  /**
   * Test
   * {@link ValidateAddRequestActivity#hasSkuOrIsNonDiscreteOI(Sku, OrderItemRequestDTO)}.
   * <ul>
   *   <li>When {@link SkuImpl}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#hasSkuOrIsNonDiscreteOI(Sku, OrderItemRequestDTO)}
   */
  @Test
  public void testHasSkuOrIsNonDiscreteOI_whenSkuImpl_thenReturnTrue2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    SkuImpl sku = mock(SkuImpl.class);

    // Act and Assert
    assertTrue(validateAddRequestActivity.hasSkuOrIsNonDiscreteOI(sku, new OrderItemRequestDTO()));
  }

  /**
   * Test
   * {@link ValidateAddRequestActivity#handleIfNoSku(OrderItemRequestDTO, Product)}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)}
   * with {@code foo}.</li>
   *   <li>Then calls {@link Product#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#handleIfNoSku(OrderItemRequestDTO, Product)}
   */
  @Test
  public void testHandleIfNoSku_givenIllegalArgumentExceptionWithFoo_thenCallsGetId() {
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
   * Test
   * {@link ValidateAddRequestActivity#handleIfNoSku(OrderItemRequestDTO, Product)}.
   * <ul>
   *   <li>Then calls {@link OrderItemRequestDTO#getSkuId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#handleIfNoSku(OrderItemRequestDTO, Product)}
   */
  @Test
  public void testHandleIfNoSku_thenCallsGetSkuId() {
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
   * Test
   * {@link ValidateAddRequestActivity#handleIfNoSku(OrderItemRequestDTO, Product)}.
   * <ul>
   *   <li>When {@link OrderItemRequestDTO#OrderItemRequestDTO()}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#handleIfNoSku(OrderItemRequestDTO, Product)}
   */
  @Test
  public void testHandleIfNoSku_whenOrderItemRequestDTO_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> validateAddRequestActivity.handleIfNoSku(orderItemRequestDTO, new ProductBundleImpl()));
  }

  /**
   * Test
   * {@link ValidateAddRequestActivity#handleIfNoSku(OrderItemRequestDTO, Product)}.
   * <ul>
   *   <li>When {@link OrderItemRequestDTO#OrderItemRequestDTO()}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#handleIfNoSku(OrderItemRequestDTO, Product)}
   */
  @Test
  public void testHandleIfNoSku_whenOrderItemRequestDTO_thenThrowIllegalArgumentException2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> validateAddRequestActivity.handleIfNoSku(new OrderItemRequestDTO(), null));
  }

  /**
   * Test
   * {@link ValidateAddRequestActivity#handleIfNonDiscreteOI(OrderItemRequestDTO)}.
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#handleIfNonDiscreteOI(OrderItemRequestDTO)}
   */
  @Test
  public void testHandleIfNonDiscreteOI() {
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
   * Test
   * {@link ValidateAddRequestActivity#handleIfNonDiscreteOI(OrderItemRequestDTO)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#handleIfNonDiscreteOI(OrderItemRequestDTO)}
   */
  @Test
  public void testHandleIfNonDiscreteOI_givenEmptyString() {
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
   * Test
   * {@link ValidateAddRequestActivity#handleIfNonDiscreteOI(OrderItemRequestDTO)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#handleIfNonDiscreteOI(OrderItemRequestDTO)}
   */
  @Test
  public void testHandleIfNonDiscreteOI_thenThrowIllegalArgumentException() {
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
   * Test
   * {@link ValidateAddRequestActivity#handleIfNonDiscreteOI(OrderItemRequestDTO)}.
   * <ul>
   *   <li>When
   * {@link NonDiscreteOrderItemRequestDTO#NonDiscreteOrderItemRequestDTO()}
   * ItemName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#handleIfNonDiscreteOI(OrderItemRequestDTO)}
   */
  @Test
  public void testHandleIfNonDiscreteOI_whenNonDiscreteOrderItemRequestDTOItemNameIsNull() {
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
   * Test
   * {@link ValidateAddRequestActivity#hasPrice(NonDiscreteOrderItemRequestDTO)}.
   * <ul>
   *   <li>Then calls {@link OrderItemRequestDTO#getOverrideRetailPrice()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#hasPrice(NonDiscreteOrderItemRequestDTO)}
   */
  @Test
  public void testHasPrice_thenCallsGetOverrideRetailPrice() {
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
   * Test
   * {@link ValidateAddRequestActivity#hasPrice(NonDiscreteOrderItemRequestDTO)}.
   * <ul>
   *   <li>When
   * {@link NonDiscreteOrderItemRequestDTO#NonDiscreteOrderItemRequestDTO()}
   * OverrideRetailPrice is {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#hasPrice(NonDiscreteOrderItemRequestDTO)}
   */
  @Test
  public void testHasPrice_whenNonDiscreteOrderItemRequestDTOOverrideRetailPriceIsMoney() {
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
   * Test
   * {@link ValidateAddRequestActivity#hasPrice(NonDiscreteOrderItemRequestDTO)}.
   * <ul>
   *   <li>When
   * {@link NonDiscreteOrderItemRequestDTO#NonDiscreteOrderItemRequestDTO()}
   * OverrideRetailPrice is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#hasPrice(NonDiscreteOrderItemRequestDTO)}
   */
  @Test
  public void testHasPrice_whenNonDiscreteOrderItemRequestDTOOverrideRetailPriceIsNull() {
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
   * Test
   * {@link ValidateAddRequestActivity#hasPrice(NonDiscreteOrderItemRequestDTO)}.
   * <ul>
   *   <li>When
   * {@link NonDiscreteOrderItemRequestDTO#NonDiscreteOrderItemRequestDTO()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#hasPrice(NonDiscreteOrderItemRequestDTO)}
   */
  @Test
  public void testHasPrice_whenNonDiscreteOrderItemRequestDTO_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();

    // Act and Assert
    assertFalse(validateAddRequestActivity.hasPrice(new NonDiscreteOrderItemRequestDTO()));
  }

  /**
   * Test
   * {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)}.
   * <ul>
   *   <li>Given {@link NullBroadleafCurrency} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)}
   */
  @Test
  public void testHasSameCurrency_givenNullBroadleafCurrency_thenReturnFalse() {
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
   * Test
   * {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)}.
   * <ul>
   *   <li>Then calls {@link Sku#getCurrency()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)}
   */
  @Test
  public void testHasSameCurrency_thenCallsGetCurrency() {
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
   * Test
   * {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)}
   */
  @Test
  public void testHasSameCurrency_thenThrowIllegalArgumentException() {
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

  /**
   * Test
   * {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)}.
   * <ul>
   *   <li>When
   * {@link NonDiscreteOrderItemRequestDTO#NonDiscreteOrderItemRequestDTO()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)}
   */
  @Test
  public void testHasSameCurrency_whenNonDiscreteOrderItemRequestDTO_thenReturnTrue() {
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
   * Test
   * {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)}.
   * <ul>
   *   <li>When {@link NonDiscreteOrderItemRequestDTO}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)}
   */
  @Test
  public void testHasSameCurrency_whenNonDiscreteOrderItemRequestDTO_thenReturnTrue2() {
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
   * Test
   * {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)}
   */
  @Test
  public void testHasSameCurrency_whenNull_thenReturnTrue() {
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
   * Test
   * {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)}.
   * <ul>
   *   <li>When {@link Order} {@link Order#getCurrency()} return
   * {@link BroadleafCurrencyImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)}
   */
  @Test
  public void testHasSameCurrency_whenOrderGetCurrencyReturnBroadleafCurrencyImpl() {
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
   * Test
   * {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)}.
   * <ul>
   *   <li>When {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)}
   */
  @Test
  public void testHasSameCurrency_whenSkuImpl_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAddRequestActivity validateAddRequestActivity = new ValidateAddRequestActivity();
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act and Assert
    assertTrue(validateAddRequestActivity.hasSameCurrency(orderItemRequestDTO, request, new SkuImpl()));
  }
}

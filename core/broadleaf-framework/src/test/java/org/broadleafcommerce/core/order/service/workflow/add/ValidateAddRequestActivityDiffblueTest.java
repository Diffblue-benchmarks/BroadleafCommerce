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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.currency.domain.NullBroadleafCurrency;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.sandbox.SandBoxHelper;
import org.broadleafcommerce.common.sandbox.SandBoxHelper.OriginalIdResponse;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.catalog.service.CatalogService;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.service.OrderItemService;
import org.broadleafcommerce.core.order.service.ProductOptionValidationService;
import org.broadleafcommerce.core.order.service.call.AddToCartItem;
import org.broadleafcommerce.core.order.service.call.NonDiscreteOrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.exception.RequiredAttributeNotProvidedException;
import org.broadleafcommerce.core.order.service.workflow.CartOperationRequest;
import org.broadleafcommerce.core.order.service.workflow.add.extension.ValidateAddRequestActivityExtensionHandler;
import org.broadleafcommerce.core.order.service.workflow.add.extension.ValidateAddRequestActivityExtensionManager;
import org.broadleafcommerce.core.order.service.workflow.service.OrderItemRequestValidationService;
import org.broadleafcommerce.core.workflow.ActivityMessages;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ValidateAddRequestActivityDiffblueTest {
  @InjectMocks
  private ValidateAddRequestActivity validateAddRequestActivity;

  @Mock
  private CatalogService catalogService;

  @Mock
  private ValidateAddRequestActivityExtensionManager validateAddRequestActivityExtensionManager;

  @Mock
  private OrderItemRequestValidationService orderItemRequestValidationService;

  @Mock
  private SandBoxHelper sandBoxHelper;

  @Mock
  private ProductOptionValidationService productOptionValidationService;

  @Mock
  private OrderItemService orderItemService;

  /**
   * Test {@link ValidateAddRequestActivity#execute(ProcessContext)}.
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.execute(ProcessContext)"})
  public void testExecute() throws Exception {
    // Arrange
    ValidateAddRequestActivityExtensionHandler validateAddRequestActivityExtensionHandler = mock(
        ValidateAddRequestActivityExtensionHandler.class);
    when(validateAddRequestActivityExtensionHandler.validate(Mockito.<CartOperationRequest>any(),
        Mockito.<ExtensionResultHolder<Exception>>any())).thenThrow(new IllegalArgumentException("foo"));
    when(validateAddRequestActivityExtensionManager.getProxy()).thenReturn(validateAddRequestActivityExtensionHandler);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> validateAddRequestActivity.execute(new DefaultProcessContextImpl<>()));
    verify(validateAddRequestActivityExtensionManager, atLeast(1)).getProxy();
    verify(validateAddRequestActivityExtensionHandler).validate(isNull(), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link ValidateAddRequestActivity#execute(ProcessContext)}.
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.execute(ProcessContext)"})
  public void testExecute2() throws Exception {
    // Arrange
    ValidateAddRequestActivityExtensionHandler validateAddRequestActivityExtensionHandler = mock(
        ValidateAddRequestActivityExtensionHandler.class);
    when(validateAddRequestActivityExtensionHandler.validate(Mockito.<CartOperationRequest>any(),
        Mockito.<ExtensionResultHolder<Exception>>any())).thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(validateAddRequestActivityExtensionManager.getProxy()).thenReturn(validateAddRequestActivityExtensionHandler);
    ProcessContext<CartOperationRequest> context = mock(ProcessContext.class);
    when(context.stopProcess()).thenReturn(true);
    NullOrderImpl order = new NullOrderImpl();
    when(context.getSeedData()).thenReturn(new CartOperationRequest(order, new OrderItemRequestDTO(), true));

    // Act
    ProcessContext<CartOperationRequest> actualExecuteResult = validateAddRequestActivity.execute(context);

    // Assert
    verify(validateAddRequestActivityExtensionManager, atLeast(1)).getProxy();
    verify(validateAddRequestActivityExtensionHandler).validate(isA(CartOperationRequest.class),
        isA(ExtensionResultHolder.class));
    verify(context, atLeast(1)).getSeedData();
    verify(context).stopProcess();
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link ValidateAddRequestActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link CatalogService} {@link CatalogService#findProductById(Long)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.execute(ProcessContext)"})
  public void testExecute_givenCatalogServiceFindProductByIdReturnNull() throws Exception {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(null);
    ValidateAddRequestActivityExtensionHandler validateAddRequestActivityExtensionHandler = mock(
        ValidateAddRequestActivityExtensionHandler.class);
    when(validateAddRequestActivityExtensionHandler.validate(Mockito.<CartOperationRequest>any(),
        Mockito.<ExtensionResultHolder<Exception>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(validateAddRequestActivityExtensionManager.getProxy()).thenReturn(validateAddRequestActivityExtensionHandler);
    when(orderItemRequestValidationService.satisfiesMinQuantityCondition(Mockito.<OrderItemRequestDTO>any(),
        Mockito.<ProcessContext<CartOperationRequest>>any())).thenReturn(true);

    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO(1L, 2);
    itemRequest.setQuantity(2);
    ProcessContext<CartOperationRequest> context = mock(ProcessContext.class);
    when(context.getSeedData()).thenReturn(new CartOperationRequest(new NullOrderImpl(), itemRequest, true));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> validateAddRequestActivity.execute(context));
    verify(validateAddRequestActivityExtensionManager, atLeast(1)).getProxy();
    verify(catalogService).findProductById(eq(1L));
    verify(validateAddRequestActivityExtensionHandler).validate(isA(CartOperationRequest.class),
        isA(ExtensionResultHolder.class));
    verify(orderItemRequestValidationService).satisfiesMinQuantityCondition(isA(OrderItemRequestDTO.class),
        isA(ProcessContext.class));
    verify(context, atLeast(1)).getSeedData();
  }

  /**
   * Test {@link ValidateAddRequestActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.execute(ProcessContext)"})
  public void testExecute_givenIllegalArgumentExceptionWithFoo() throws Exception {
    // Arrange
    ValidateAddRequestActivityExtensionHandler validateAddRequestActivityExtensionHandler = mock(
        ValidateAddRequestActivityExtensionHandler.class);
    when(validateAddRequestActivityExtensionHandler.validate(Mockito.<CartOperationRequest>any(),
        Mockito.<ExtensionResultHolder<Exception>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(validateAddRequestActivityExtensionManager.getProxy()).thenReturn(validateAddRequestActivityExtensionHandler);
    ProcessContext<CartOperationRequest> context = mock(ProcessContext.class);
    when(context.stopProcess()).thenThrow(new IllegalArgumentException("foo"));
    NullOrderImpl order = new NullOrderImpl();
    when(context.getSeedData()).thenReturn(new CartOperationRequest(order, new OrderItemRequestDTO(), true));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> validateAddRequestActivity.execute(context));
    verify(validateAddRequestActivityExtensionManager, atLeast(1)).getProxy();
    verify(validateAddRequestActivityExtensionHandler).validate(isA(CartOperationRequest.class),
        isA(ExtensionResultHolder.class));
    verify(context, atLeast(1)).getSeedData();
    verify(context).stopProcess();
  }

  /**
   * Test {@link ValidateAddRequestActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link OrderItemRequestDTO#OrderItemRequestDTO()} Quantity is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.execute(ProcessContext)"})
  public void testExecute_givenOrderItemRequestDTOQuantityIsTwo() throws Exception {
    // Arrange
    ValidateAddRequestActivityExtensionHandler validateAddRequestActivityExtensionHandler = mock(
        ValidateAddRequestActivityExtensionHandler.class);
    when(validateAddRequestActivityExtensionHandler.validate(Mockito.<CartOperationRequest>any(),
        Mockito.<ExtensionResultHolder<Exception>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(validateAddRequestActivityExtensionManager.getProxy()).thenReturn(validateAddRequestActivityExtensionHandler);
    when(orderItemRequestValidationService.satisfiesMinQuantityCondition(Mockito.<OrderItemRequestDTO>any(),
        Mockito.<ProcessContext<CartOperationRequest>>any())).thenReturn(true);

    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO();
    itemRequest.setQuantity(2);
    ProcessContext<CartOperationRequest> context = mock(ProcessContext.class);
    when(context.getSeedData()).thenReturn(new CartOperationRequest(null, itemRequest, true));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> validateAddRequestActivity.execute(context));
    verify(validateAddRequestActivityExtensionManager, atLeast(1)).getProxy();
    verify(validateAddRequestActivityExtensionHandler).validate(isA(CartOperationRequest.class),
        isA(ExtensionResultHolder.class));
    verify(orderItemRequestValidationService).satisfiesMinQuantityCondition(isA(OrderItemRequestDTO.class),
        isA(ProcessContext.class));
    verify(context, atLeast(1)).getSeedData();
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.execute(ProcessContext)"})
  public void testExecute_givenTrue_thenReturnProcessContext() throws Exception {
    // Arrange
    ValidateAddRequestActivityExtensionHandler validateAddRequestActivityExtensionHandler = mock(
        ValidateAddRequestActivityExtensionHandler.class);
    when(validateAddRequestActivityExtensionHandler.validate(Mockito.<CartOperationRequest>any(),
        Mockito.<ExtensionResultHolder<Exception>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(validateAddRequestActivityExtensionManager.getProxy()).thenReturn(validateAddRequestActivityExtensionHandler);
    ProcessContext<CartOperationRequest> context = mock(ProcessContext.class);
    when(context.stopProcess()).thenReturn(true);
    NullOrderImpl order = new NullOrderImpl();
    when(context.getSeedData()).thenReturn(new CartOperationRequest(order, new OrderItemRequestDTO(), true));

    // Act
    ProcessContext<CartOperationRequest> actualExecuteResult = validateAddRequestActivity.execute(context);

    // Assert
    verify(validateAddRequestActivityExtensionManager, atLeast(1)).getProxy();
    verify(validateAddRequestActivityExtensionHandler).validate(isA(CartOperationRequest.class),
        isA(ExtensionResultHolder.class));
    verify(context, atLeast(1)).getSeedData();
    verify(context).stopProcess();
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link ValidateAddRequestActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Then calls {@link SandBoxHelper#getOriginalId(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.execute(ProcessContext)"})
  public void testExecute_thenCallsGetOriginalId() throws Exception {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    ValidateAddRequestActivityExtensionHandler validateAddRequestActivityExtensionHandler = mock(
        ValidateAddRequestActivityExtensionHandler.class);
    when(validateAddRequestActivityExtensionHandler.validate(Mockito.<CartOperationRequest>any(),
        Mockito.<ExtensionResultHolder<Exception>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(validateAddRequestActivityExtensionManager.getProxy()).thenReturn(validateAddRequestActivityExtensionHandler);
    when(orderItemRequestValidationService.satisfiesMinQuantityCondition(Mockito.<OrderItemRequestDTO>any(),
        Mockito.<ProcessContext<CartOperationRequest>>any())).thenReturn(true);
    when(sandBoxHelper.getOriginalId(Mockito.<Object>any()))
        .thenThrow(new RequiredAttributeNotProvidedException("Attribute Name"));

    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO(1L, 2);
    itemRequest.setQuantity(2);
    ProcessContext<CartOperationRequest> context = mock(ProcessContext.class);
    when(context.getSeedData()).thenReturn(new CartOperationRequest(new NullOrderImpl(), itemRequest, true));

    // Act and Assert
    assertThrows(RequiredAttributeNotProvidedException.class, () -> validateAddRequestActivity.execute(context));
    verify(validateAddRequestActivityExtensionManager, atLeast(1)).getProxy();
    verify(sandBoxHelper).getOriginalId(isA(Object.class));
    verify(catalogService).findProductById(eq(1L));
    verify(validateAddRequestActivityExtensionHandler).validate(isA(CartOperationRequest.class),
        isA(ExtensionResultHolder.class));
    verify(orderItemRequestValidationService).satisfiesMinQuantityCondition(isA(OrderItemRequestDTO.class),
        isA(ProcessContext.class));
    verify(context, atLeast(1)).getSeedData();
  }

  /**
   * Test {@link ValidateAddRequestActivity#validate(ProcessContext)}.
   * <ul>
   *   <li>Given {@link CatalogService} {@link CatalogService#findProductById(Long)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#validate(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.validate(ProcessContext)"})
  public void testValidate_givenCatalogServiceFindProductByIdReturnNull() {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(null);
    when(orderItemRequestValidationService.satisfiesMinQuantityCondition(Mockito.<OrderItemRequestDTO>any(),
        Mockito.<ProcessContext<CartOperationRequest>>any())).thenReturn(true);

    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO(1L, 12);
    itemRequest.setQuantity(12);
    ProcessContext<CartOperationRequest> context = mock(ProcessContext.class);
    when(context.getSeedData()).thenReturn(new CartOperationRequest(new NullOrderImpl(), itemRequest, true));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> validateAddRequestActivity.validate(context));
    verify(catalogService).findProductById(eq(1L));
    verify(orderItemRequestValidationService).satisfiesMinQuantityCondition(isA(OrderItemRequestDTO.class),
        isA(ProcessContext.class));
    verify(context).getSeedData();
  }

  /**
   * Test {@link ValidateAddRequestActivity#validate(ProcessContext)}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#validate(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.validate(ProcessContext)"})
  public void testValidate_givenIllegalArgumentExceptionWithFoo() {
    // Arrange
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
   *   <li>Given {@link OrderItemRequestDTO#OrderItemRequestDTO()} Quantity is twelve.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#validate(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.validate(ProcessContext)"})
  public void testValidate_givenOrderItemRequestDTOQuantityIsTwelve() {
    // Arrange
    when(orderItemRequestValidationService.satisfiesMinQuantityCondition(Mockito.<OrderItemRequestDTO>any(),
        Mockito.<ProcessContext<CartOperationRequest>>any())).thenReturn(true);

    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO();
    itemRequest.setQuantity(12);
    ProcessContext<CartOperationRequest> context = mock(ProcessContext.class);
    when(context.getSeedData()).thenReturn(new CartOperationRequest(null, itemRequest, true));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> validateAddRequestActivity.validate(context));
    verify(orderItemRequestValidationService).satisfiesMinQuantityCondition(isA(OrderItemRequestDTO.class),
        isA(ProcessContext.class));
    verify(context).getSeedData();
  }

  /**
   * Test {@link ValidateAddRequestActivity#validate(ProcessContext)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then return {@link ProcessContext}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#validate(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.validate(ProcessContext)"})
  public void testValidate_givenTrue_thenReturnProcessContext() {
    // Arrange
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
   * Test {@link ValidateAddRequestActivity#validate(ProcessContext)}.
   * <ul>
   *   <li>Then calls {@link CartOperationRequest#getItemRequest()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#validate(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.validate(ProcessContext)"})
  public void testValidate_thenCallsGetItemRequest() {
    // Arrange
    when(orderItemRequestValidationService.satisfiesMinQuantityCondition(Mockito.<OrderItemRequestDTO>any(),
        Mockito.<ProcessContext<CartOperationRequest>>any())).thenReturn(false);
    when(orderItemRequestValidationService.getMinQuantity(Mockito.<OrderItemRequestDTO>any(),
        Mockito.<ProcessContext<CartOperationRequest>>any())).thenReturn(1);
    OriginalIdResponse originalIdResponse = mock(OriginalIdResponse.class);
    doNothing().when(originalIdResponse).setOriginalId(Mockito.<Long>any());
    doNothing().when(originalIdResponse).setRecordFound(anyBoolean());
    originalIdResponse.setOriginalId(1L);
    originalIdResponse.setRecordFound(true);
    AddToCartItem addToCartItem = mock(AddToCartItem.class);
    when(addToCartItem.getProductId()).thenThrow(new RequiredAttributeNotProvidedException("Attribute Name"));
    when(addToCartItem.getQuantity()).thenReturn(1);
    CartOperationRequest cartOperationRequest = mock(CartOperationRequest.class);
    when(cartOperationRequest.getItemRequest()).thenReturn(addToCartItem);
    ProcessContext<CartOperationRequest> context = mock(ProcessContext.class);
    when(context.getSeedData()).thenReturn(cartOperationRequest);

    // Act and Assert
    assertThrows(RequiredAttributeNotProvidedException.class, () -> validateAddRequestActivity.validate(context));
    verify(originalIdResponse).setOriginalId(eq(1L));
    verify(originalIdResponse).setRecordFound(eq(true));
    verify(addToCartItem).getProductId();
    verify(addToCartItem).getQuantity();
    verify(cartOperationRequest).getItemRequest();
    verify(orderItemRequestValidationService).getMinQuantity(isA(OrderItemRequestDTO.class), isA(ProcessContext.class));
    verify(orderItemRequestValidationService).satisfiesMinQuantityCondition(isA(OrderItemRequestDTO.class),
        isA(ProcessContext.class));
    verify(context).getSeedData();
  }

  /**
   * Test {@link ValidateAddRequestActivity#validate(ProcessContext)}.
   * <ul>
   *   <li>Then calls {@link SandBoxHelper#getOriginalId(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#validate(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext ValidateAddRequestActivity.validate(ProcessContext)"})
  public void testValidate_thenCallsGetOriginalId() {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    when(orderItemRequestValidationService.satisfiesMinQuantityCondition(Mockito.<OrderItemRequestDTO>any(),
        Mockito.<ProcessContext<CartOperationRequest>>any())).thenReturn(true);
    when(sandBoxHelper.getOriginalId(Mockito.<Object>any()))
        .thenThrow(new RequiredAttributeNotProvidedException("Attribute Name"));

    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO(1L, 12);
    itemRequest.setQuantity(12);
    ProcessContext<CartOperationRequest> context = mock(ProcessContext.class);
    when(context.getSeedData()).thenReturn(new CartOperationRequest(new NullOrderImpl(), itemRequest, true));

    // Act and Assert
    assertThrows(RequiredAttributeNotProvidedException.class, () -> validateAddRequestActivity.validate(context));
    verify(sandBoxHelper).getOriginalId(isA(Object.class));
    verify(catalogService).findProductById(eq(1L));
    verify(orderItemRequestValidationService).satisfiesMinQuantityCondition(isA(OrderItemRequestDTO.class),
        isA(ProcessContext.class));
    verify(context).getSeedData();
  }

  /**
   * Test {@link ValidateAddRequestActivity#validateIfProductIsProdRecord(Product)}.
   * <ul>
   *   <li>Given {@link SandBoxHelper} {@link SandBoxHelper#getOriginalId(Object)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#validateIfProductIsProdRecord(Product)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ValidateAddRequestActivity.validateIfProductIsProdRecord(Product)"})
  public void testValidateIfProductIsProdRecord_givenSandBoxHelperGetOriginalIdReturnNull() {
    // Arrange
    when(sandBoxHelper.getOriginalId(Mockito.<Object>any())).thenReturn(null);

    // Act
    validateAddRequestActivity.validateIfProductIsProdRecord(new ProductBundleImpl());

    // Assert
    verify(sandBoxHelper).getOriginalId(isA(Object.class));
  }

  /**
   * Test {@link ValidateAddRequestActivity#validateIfProductIsProdRecord(Product)}.
   * <ul>
   *   <li>Then calls {@link SandBoxHelper#getProductionOriginalId(Class, Long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#validateIfProductIsProdRecord(Product)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ValidateAddRequestActivity.validateIfProductIsProdRecord(Product)"})
  public void testValidateIfProductIsProdRecord_thenCallsGetProductionOriginalId() {
    // Arrange
    OriginalIdResponse originalIdResponse = new OriginalIdResponse();
    originalIdResponse.setOriginalId(1L);
    originalIdResponse.setRecordFound(true);
    when(sandBoxHelper.getOriginalId(Mockito.<Object>any())).thenReturn(1L);
    when(sandBoxHelper.getProductionOriginalId(Mockito.<Class<Object>>any(), Mockito.<Long>any()))
        .thenReturn(originalIdResponse);

    // Act
    validateAddRequestActivity.validateIfProductIsProdRecord(new ProductBundleImpl());

    // Assert
    verify(sandBoxHelper).getOriginalId(isA(Object.class));
    verify(sandBoxHelper).getProductionOriginalId(isA(Class.class), isNull());
  }

  /**
   * Test {@link ValidateAddRequestActivity#validateIfProductIsProdRecord(Product)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#validateIfProductIsProdRecord(Product)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ValidateAddRequestActivity.validateIfProductIsProdRecord(Product)"})
  public void testValidateIfProductIsProdRecord_thenThrowIllegalArgumentException() {
    // Arrange
    OriginalIdResponse originalIdResponse = new OriginalIdResponse();
    originalIdResponse.setOriginalId(1L);
    originalIdResponse.setRecordFound(true);
    when(sandBoxHelper.getOriginalId(Mockito.<Object>any())).thenReturn(0L);
    when(sandBoxHelper.getProductionOriginalId(Mockito.<Class<Object>>any(), Mockito.<Long>any()))
        .thenReturn(originalIdResponse);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> validateAddRequestActivity.validateIfProductIsProdRecord(new ProductBundleImpl()));
    verify(sandBoxHelper).getOriginalId(isA(Object.class));
    verify(sandBoxHelper).getProductionOriginalId(isA(Class.class), isNull());
  }

  /**
   * Test {@link ValidateAddRequestActivity#hasQuantity(Integer)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#hasQuantity(Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ValidateAddRequestActivity.hasQuantity(Integer)"})
  public void testHasQuantity_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(validateAddRequestActivity.hasQuantity(null));
  }

  /**
   * Test {@link ValidateAddRequestActivity#hasQuantity(Integer)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#hasQuantity(Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ValidateAddRequestActivity.hasQuantity(Integer)"})
  public void testHasQuantity_whenTwo_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(validateAddRequestActivity.hasQuantity(2));
  }

  /**
   * Test {@link ValidateAddRequestActivity#hasQuantity(Integer)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#hasQuantity(Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ValidateAddRequestActivity.hasQuantity(Integer)"})
  public void testHasQuantity_whenZero_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(validateAddRequestActivity.hasQuantity(0));
  }

  /**
   * Test {@link ValidateAddRequestActivity#determineProduct(OrderItemRequestDTO)}.
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#determineProduct(OrderItemRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Product ValidateAddRequestActivity.determineProduct(OrderItemRequestDTO)"})
  public void testDetermineProduct() {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenThrow(
        new IllegalArgumentException("Product was specified but no matching product was found with the productId ("));

    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    orderItemRequestDTO.setProductId(1L);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> validateAddRequestActivity.determineProduct(orderItemRequestDTO));
    verify(catalogService).findProductById(eq(1L));
  }

  /**
   * Test {@link ValidateAddRequestActivity#determineProduct(OrderItemRequestDTO)}.
   * <ul>
   *   <li>Given {@link CatalogService} {@link CatalogService#findProductById(Long)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#determineProduct(OrderItemRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Product ValidateAddRequestActivity.determineProduct(OrderItemRequestDTO)"})
  public void testDetermineProduct_givenCatalogServiceFindProductByIdReturnNull() {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(null);

    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    orderItemRequestDTO.setProductId(1L);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> validateAddRequestActivity.determineProduct(orderItemRequestDTO));
    verify(catalogService).findProductById(eq(1L));
  }

  /**
   * Test {@link ValidateAddRequestActivity#determineProduct(OrderItemRequestDTO)}.
   * <ul>
   *   <li>Then return {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#determineProduct(OrderItemRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Product ValidateAddRequestActivity.determineProduct(OrderItemRequestDTO)"})
  public void testDetermineProduct_thenReturnProductBundleImpl() {
    // Arrange
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);

    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    orderItemRequestDTO.setProductId(1L);

    // Act
    Product actualDetermineProductResult = validateAddRequestActivity.determineProduct(orderItemRequestDTO);

    // Assert
    verify(catalogService).findProductById(eq(1L));
    assertSame(productBundleImpl, actualDetermineProductResult);
  }

  /**
   * Test {@link ValidateAddRequestActivity#determineProduct(OrderItemRequestDTO)}.
   * <ul>
   *   <li>When {@link OrderItemRequestDTO#OrderItemRequestDTO()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#determineProduct(OrderItemRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Product ValidateAddRequestActivity.determineProduct(OrderItemRequestDTO)"})
  public void testDetermineProduct_whenOrderItemRequestDTO_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(validateAddRequestActivity.determineProduct(new OrderItemRequestDTO()));
  }

  /**
   * Test {@link ValidateAddRequestActivity#determineSku(Product, Long, Map, ActivityMessages)}.
   * <ul>
   *   <li>Given {@link CatalogService} {@link CatalogService#findSkuById(Long)} return {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#determineSku(Product, Long, Map, ActivityMessages)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku ValidateAddRequestActivity.determineSku(Product, Long, Map, ActivityMessages)"})
  public void testDetermineSku_givenCatalogServiceFindSkuByIdReturnNull_thenReturnNull()
      throws RequiredAttributeNotProvidedException {
    // Arrange
    when(catalogService.findSkuById(Mockito.<Long>any())).thenReturn(null);
    ProductBundleImpl product = new ProductBundleImpl();
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act
    Sku actualDetermineSkuResult = validateAddRequestActivity.determineSku(product, 1L, attributeValues,
        new DefaultProcessContextImpl<>());

    // Assert
    verify(catalogService).findSkuById(eq(1L));
    assertNull(actualDetermineSkuResult);
  }

  /**
   * Test {@link ValidateAddRequestActivity#determineSku(Product, Long, Map, ActivityMessages)}.
   * <ul>
   *   <li>Given {@link CatalogService} {@link CatalogService#findSkuById(Long)} return {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@link SkuImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#determineSku(Product, Long, Map, ActivityMessages)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku ValidateAddRequestActivity.determineSku(Product, Long, Map, ActivityMessages)"})
  public void testDetermineSku_givenCatalogServiceFindSkuByIdReturnSkuImpl_thenReturnSkuImpl()
      throws RequiredAttributeNotProvidedException {
    // Arrange
    when(catalogService.findSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());
    ProductBundleImpl product = new ProductBundleImpl();
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act
    Sku actualDetermineSkuResult = validateAddRequestActivity.determineSku(product, 1L, attributeValues,
        new DefaultProcessContextImpl<>());

    // Assert
    verify(catalogService).findSkuById(eq(1L));
    assertTrue(actualDetermineSkuResult instanceof SkuImpl);
    Money margin = actualDetermineSkuResult.getMargin();
    assertEquals(margin, margin.abs());
    assertEquals(margin, margin.zero());
  }

  /**
   * Test {@link ValidateAddRequestActivity#determineSku(Product, Long, Map, ActivityMessages)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link SkuImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#determineSku(Product, Long, Map, ActivityMessages)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku ValidateAddRequestActivity.determineSku(Product, Long, Map, ActivityMessages)"})
  public void testDetermineSku_whenNull_thenReturnSkuImpl() throws RequiredAttributeNotProvidedException {
    // Arrange
    when(catalogService.findSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act
    Sku actualDetermineSkuResult = validateAddRequestActivity.determineSku(null, 1L, attributeValues,
        new DefaultProcessContextImpl<>());

    // Assert
    verify(catalogService).findSkuById(eq(1L));
    assertTrue(actualDetermineSkuResult instanceof SkuImpl);
    Money margin = actualDetermineSkuResult.getMargin();
    assertEquals(margin, margin.abs());
    assertEquals(margin, margin.zero());
  }

  /**
   * Test {@link ValidateAddRequestActivity#canSellDefaultSku(Product)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#canSellDefaultSku(Product)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ValidateAddRequestActivity.canSellDefaultSku(Product)"})
  public void testCanSellDefaultSku_whenProductBundleImpl_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(validateAddRequestActivity.canSellDefaultSku(new ProductBundleImpl()));
  }

  /**
   * Test {@link ValidateAddRequestActivity#findMatchingSku(Product, Map)} with {@code product}, {@code attributeValuesForSku}.
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#findMatchingSku(Product, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku ValidateAddRequestActivity.findMatchingSku(Product, Map)"})
  public void testFindMatchingSkuWithProductAttributeValuesForSku() {
    // Arrange
    when(catalogService.findSkuById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException("foo"));

    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(1L);
    when(productOptionValidationService.findSkuIdsForProductOptionValues(Mockito.<Long>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<List<Long>>any())).thenReturn(resultLongList);
    ProductBundleImpl product = new ProductBundleImpl();

    HashMap<String, String> attributeValuesForSku = new HashMap<>();
    attributeValuesForSku.put("foo", "foo");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> validateAddRequestActivity.findMatchingSku(product, attributeValuesForSku));
    verify(catalogService).findSkuById(eq(1L));
    verify(productOptionValidationService).findSkuIdsForProductOptionValues(isNull(), eq("foo"), eq("foo"),
        isA(List.class));
  }

  /**
   * Test {@link ValidateAddRequestActivity#findMatchingSku(Product, Map)} with {@code product}, {@code attributeValuesForSku}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#findMatchingSku(Product, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku ValidateAddRequestActivity.findMatchingSku(Product, Map)"})
  public void testFindMatchingSkuWithProductAttributeValuesForSku_thenReturnNull() {
    // Arrange
    when(productOptionValidationService.findSkuIdsForProductOptionValues(Mockito.<Long>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<List<Long>>any())).thenReturn(new ArrayList<>());
    ProductBundleImpl product = new ProductBundleImpl();

    HashMap<String, String> attributeValuesForSku = new HashMap<>();
    attributeValuesForSku.put("foo", "foo");

    // Act
    Sku actualFindMatchingSkuResult = validateAddRequestActivity.findMatchingSku(product, attributeValuesForSku);

    // Assert
    verify(productOptionValidationService).findSkuIdsForProductOptionValues(isNull(), eq("foo"), eq("foo"),
        isA(List.class));
    assertNull(actualFindMatchingSkuResult);
  }

  /**
   * Test {@link ValidateAddRequestActivity#findMatchingSku(Product, Map)} with {@code product}, {@code attributeValuesForSku}.
   * <ul>
   *   <li>Then return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#findMatchingSku(Product, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku ValidateAddRequestActivity.findMatchingSku(Product, Map)"})
  public void testFindMatchingSkuWithProductAttributeValuesForSku_thenReturnSkuImpl() {
    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    when(catalogService.findSkuById(Mockito.<Long>any())).thenReturn(skuImpl);

    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(1L);
    when(productOptionValidationService.findSkuIdsForProductOptionValues(Mockito.<Long>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<List<Long>>any())).thenReturn(resultLongList);
    ProductBundleImpl product = new ProductBundleImpl();

    HashMap<String, String> attributeValuesForSku = new HashMap<>();
    attributeValuesForSku.put("foo", "foo");

    // Act
    Sku actualFindMatchingSkuResult = validateAddRequestActivity.findMatchingSku(product, attributeValuesForSku);

    // Assert
    verify(catalogService).findSkuById(eq(1L));
    verify(productOptionValidationService).findSkuIdsForProductOptionValues(isNull(), eq("foo"), eq("foo"),
        isA(List.class));
    assertSame(skuImpl, actualFindMatchingSkuResult);
  }

  /**
   * Test {@link ValidateAddRequestActivity#findMatchingSku(Product, Map)} with {@code product}, {@code attributeValuesForSku}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#findMatchingSku(Product, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku ValidateAddRequestActivity.findMatchingSku(Product, Map)"})
  public void testFindMatchingSkuWithProductAttributeValuesForSku_whenHashMap_thenReturnNull() {
    // Arrange
    ProductBundleImpl product = new ProductBundleImpl();

    // Act and Assert
    assertNull(validateAddRequestActivity.findMatchingSku(product, new HashMap<>()));
  }

  /**
   * Test {@link ValidateAddRequestActivity#findMatchingSku(Product, Map, ActivityMessages)} with {@code product}, {@code attributeValues}, {@code messages}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#findMatchingSku(Product, Map, ActivityMessages)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku ValidateAddRequestActivity.findMatchingSku(Product, Map, ActivityMessages)"})
  public void testFindMatchingSkuWithProductAttributeValuesMessages_whenNull_thenReturnNull()
      throws RequiredAttributeNotProvidedException {
    // Arrange
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act and Assert
    assertNull(validateAddRequestActivity.findMatchingSku(null, attributeValues, new DefaultProcessContextImpl<>()));
  }

  /**
   * Test {@link ValidateAddRequestActivity#findMatchingSku(Product, Map, ActivityMessages)} with {@code product}, {@code attributeValues}, {@code messages}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#findMatchingSku(Product, Map, ActivityMessages)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku ValidateAddRequestActivity.findMatchingSku(Product, Map, ActivityMessages)"})
  public void testFindMatchingSkuWithProductAttributeValuesMessages_whenProductBundleImpl()
      throws RequiredAttributeNotProvidedException {
    // Arrange
    ProductBundleImpl product = new ProductBundleImpl();
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act and Assert
    assertNull(validateAddRequestActivity.findMatchingSku(product, attributeValues, new DefaultProcessContextImpl<>()));
  }

  /**
   * Test {@link ValidateAddRequestActivity#shouldValidateWithException(boolean, boolean, String, boolean)}.
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#shouldValidateWithException(boolean, boolean, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean ValidateAddRequestActivity.shouldValidateWithException(boolean, boolean, String, boolean)"})
  public void testShouldValidateWithException_when0123456789abcdef_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(validateAddRequestActivity.shouldValidateWithException(false, false, "0123456789ABCDEF", false));
  }

  /**
   * Test {@link ValidateAddRequestActivity#shouldValidateWithException(boolean, boolean, String, boolean)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#shouldValidateWithException(boolean, boolean, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean ValidateAddRequestActivity.shouldValidateWithException(boolean, boolean, String, boolean)"})
  public void testShouldValidateWithException_whenEmptyString_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(validateAddRequestActivity.shouldValidateWithException(false, false, "", false));
  }

  /**
   * Test {@link ValidateAddRequestActivity#shouldValidateWithException(boolean, boolean, String, boolean)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#shouldValidateWithException(boolean, boolean, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean ValidateAddRequestActivity.shouldValidateWithException(boolean, boolean, String, boolean)"})
  public void testShouldValidateWithException_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(validateAddRequestActivity.shouldValidateWithException(false, false, null, false));
  }

  /**
   * Test {@link ValidateAddRequestActivity#shouldValidateWithException(boolean, boolean, String, boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#shouldValidateWithException(boolean, boolean, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean ValidateAddRequestActivity.shouldValidateWithException(boolean, boolean, String, boolean)"})
  public void testShouldValidateWithException_whenTrue_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(validateAddRequestActivity.shouldValidateWithException(true, false, "0123456789ABCDEF", true));
  }

  /**
   * Test {@link ValidateAddRequestActivity#shouldValidateWithException(boolean, boolean, String, boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#shouldValidateWithException(boolean, boolean, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean ValidateAddRequestActivity.shouldValidateWithException(boolean, boolean, String, boolean)"})
  public void testShouldValidateWithException_whenTrue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(validateAddRequestActivity.shouldValidateWithException(true, true, "0123456789ABCDEF", true));
  }

  /**
   * Test {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)}.
   * <ul>
   *   <li>Given {@code Order Item Request DTO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ValidateAddRequestActivity.addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)"})
  public void testAddSkuToCart_givenOrderItemRequestDto() {
    // Arrange
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
   * Test {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link Sku} {@link Sku#isActive()} return {@code true}.</li>
   *   <li>Then calls {@link Sku#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ValidateAddRequestActivity.addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)"})
  public void testAddSkuToCart_givenTrue_whenSkuIsActiveReturnTrue_thenCallsGetId() {
    // Arrange
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
   * Test {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)}.
   * <ul>
   *   <li>Then throw {@link RequiredAttributeNotProvidedException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ValidateAddRequestActivity.addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)"})
  public void testAddSkuToCart_thenThrowRequiredAttributeNotProvidedException() {
    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.isActive()).thenThrow(new RequiredAttributeNotProvidedException("Attribute Name"));

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
   * Test {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)}.
   * <ul>
   *   <li>When {@link NonDiscreteOrderItemRequestDTO#NonDiscreteOrderItemRequestDTO()} ItemName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ValidateAddRequestActivity.addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)"})
  public void testAddSkuToCart_whenNonDiscreteOrderItemRequestDTOItemNameIsNull() {
    // Arrange
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
   * Test {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)}.
   * <ul>
   *   <li>When {@link OrderItemRequestDTO#OrderItemRequestDTO()}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ValidateAddRequestActivity.addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)"})
  public void testAddSkuToCart_whenOrderItemRequestDTO_thenThrowIllegalArgumentException() {
    // Arrange
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    ProductBundleImpl product = new ProductBundleImpl();
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> validateAddRequestActivity.addSkuToCart(null,
        orderItemRequestDTO, product, new CartOperationRequest(order, new OrderItemRequestDTO(), true)));
  }

  /**
   * Test {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)}.
   * <ul>
   *   <li>When {@link SkuImpl} (default constructor).</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ValidateAddRequestActivity.addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)"})
  public void testAddSkuToCart_whenSkuImpl_thenThrowIllegalArgumentException() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    ProductBundleImpl product = new ProductBundleImpl();
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> validateAddRequestActivity.addSkuToCart(sku, orderItemRequestDTO,
        product, new CartOperationRequest(order, new OrderItemRequestDTO(), true)));
  }

  /**
   * Test {@link ValidateAddRequestActivity#hasSkuOrIsNonDiscreteOI(Sku, OrderItemRequestDTO)}.
   * <ul>
   *   <li>When {@link NonDiscreteOrderItemRequestDTO#NonDiscreteOrderItemRequestDTO()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#hasSkuOrIsNonDiscreteOI(Sku, OrderItemRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ValidateAddRequestActivity.hasSkuOrIsNonDiscreteOI(Sku, OrderItemRequestDTO)"})
  public void testHasSkuOrIsNonDiscreteOI_whenNonDiscreteOrderItemRequestDTO_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(validateAddRequestActivity.hasSkuOrIsNonDiscreteOI(null, new NonDiscreteOrderItemRequestDTO()));
  }

  /**
   * Test {@link ValidateAddRequestActivity#hasSkuOrIsNonDiscreteOI(Sku, OrderItemRequestDTO)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#hasSkuOrIsNonDiscreteOI(Sku, OrderItemRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ValidateAddRequestActivity.hasSkuOrIsNonDiscreteOI(Sku, OrderItemRequestDTO)"})
  public void testHasSkuOrIsNonDiscreteOI_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(validateAddRequestActivity.hasSkuOrIsNonDiscreteOI(null, new OrderItemRequestDTO()));
  }

  /**
   * Test {@link ValidateAddRequestActivity#hasSkuOrIsNonDiscreteOI(Sku, OrderItemRequestDTO)}.
   * <ul>
   *   <li>When {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#hasSkuOrIsNonDiscreteOI(Sku, OrderItemRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ValidateAddRequestActivity.hasSkuOrIsNonDiscreteOI(Sku, OrderItemRequestDTO)"})
  public void testHasSkuOrIsNonDiscreteOI_whenSkuImpl_thenReturnTrue() {
    // Arrange
    SkuImpl sku = new SkuImpl();

    // Act and Assert
    assertTrue(validateAddRequestActivity.hasSkuOrIsNonDiscreteOI(sku, new OrderItemRequestDTO()));
  }

  /**
   * Test {@link ValidateAddRequestActivity#handleIfNoSku(OrderItemRequestDTO, Product)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#handleIfNoSku(OrderItemRequestDTO, Product)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ValidateAddRequestActivity.handleIfNoSku(OrderItemRequestDTO, Product)"})
  public void testHandleIfNoSku_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> validateAddRequestActivity.handleIfNoSku(new OrderItemRequestDTO(), null));
  }

  /**
   * Test {@link ValidateAddRequestActivity#handleIfNoSku(OrderItemRequestDTO, Product)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#handleIfNoSku(OrderItemRequestDTO, Product)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ValidateAddRequestActivity.handleIfNoSku(OrderItemRequestDTO, Product)"})
  public void testHandleIfNoSku_whenProductBundleImpl_thenThrowIllegalArgumentException() {
    // Arrange
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> validateAddRequestActivity.handleIfNoSku(orderItemRequestDTO, new ProductBundleImpl()));
  }

  /**
   * Test {@link ValidateAddRequestActivity#handleIfNonDiscreteOI(OrderItemRequestDTO)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#handleIfNonDiscreteOI(OrderItemRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ValidateAddRequestActivity.handleIfNonDiscreteOI(OrderItemRequestDTO)"})
  public void testHandleIfNonDiscreteOI_givenEmptyString() {
    // Arrange
    NonDiscreteOrderItemRequestDTO orderItemRequestDTO = new NonDiscreteOrderItemRequestDTO();
    orderItemRequestDTO.setItemName("");
    orderItemRequestDTO.setOverrideRetailPrice(null);
    orderItemRequestDTO.setOverrideSalePrice(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> validateAddRequestActivity.handleIfNonDiscreteOI(orderItemRequestDTO));
  }

  /**
   * Test {@link ValidateAddRequestActivity#handleIfNonDiscreteOI(OrderItemRequestDTO)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#handleIfNonDiscreteOI(OrderItemRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ValidateAddRequestActivity.handleIfNonDiscreteOI(OrderItemRequestDTO)"})
  public void testHandleIfNonDiscreteOI_thenThrowIllegalArgumentException() {
    // Arrange
    NonDiscreteOrderItemRequestDTO orderItemRequestDTO = new NonDiscreteOrderItemRequestDTO();
    orderItemRequestDTO.setItemName("Order Item Request DTO");
    orderItemRequestDTO.setOverrideRetailPrice(null);
    orderItemRequestDTO.setOverrideSalePrice(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> validateAddRequestActivity.handleIfNonDiscreteOI(orderItemRequestDTO));
  }

  /**
   * Test {@link ValidateAddRequestActivity#handleIfNonDiscreteOI(OrderItemRequestDTO)}.
   * <ul>
   *   <li>When {@link NonDiscreteOrderItemRequestDTO#NonDiscreteOrderItemRequestDTO()} ItemName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#handleIfNonDiscreteOI(OrderItemRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ValidateAddRequestActivity.handleIfNonDiscreteOI(OrderItemRequestDTO)"})
  public void testHandleIfNonDiscreteOI_whenNonDiscreteOrderItemRequestDTOItemNameIsNull() {
    // Arrange
    NonDiscreteOrderItemRequestDTO orderItemRequestDTO = new NonDiscreteOrderItemRequestDTO();
    orderItemRequestDTO.setItemName(null);
    orderItemRequestDTO.setOverrideRetailPrice(null);
    orderItemRequestDTO.setOverrideSalePrice(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> validateAddRequestActivity.handleIfNonDiscreteOI(orderItemRequestDTO));
  }

  /**
   * Test {@link ValidateAddRequestActivity#hasPrice(NonDiscreteOrderItemRequestDTO)}.
   * <ul>
   *   <li>When {@link NonDiscreteOrderItemRequestDTO#NonDiscreteOrderItemRequestDTO()} OverrideRetailPrice is {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#hasPrice(NonDiscreteOrderItemRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ValidateAddRequestActivity.hasPrice(NonDiscreteOrderItemRequestDTO)"})
  public void testHasPrice_whenNonDiscreteOrderItemRequestDTOOverrideRetailPriceIsMoney() {
    // Arrange
    NonDiscreteOrderItemRequestDTO ndr = new NonDiscreteOrderItemRequestDTO();
    ndr.setOverrideRetailPrice(new Money());
    ndr.setOverrideSalePrice(null);

    // Act and Assert
    assertTrue(validateAddRequestActivity.hasPrice(ndr));
  }

  /**
   * Test {@link ValidateAddRequestActivity#hasPrice(NonDiscreteOrderItemRequestDTO)}.
   * <ul>
   *   <li>When {@link NonDiscreteOrderItemRequestDTO#NonDiscreteOrderItemRequestDTO()} OverrideRetailPrice is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#hasPrice(NonDiscreteOrderItemRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ValidateAddRequestActivity.hasPrice(NonDiscreteOrderItemRequestDTO)"})
  public void testHasPrice_whenNonDiscreteOrderItemRequestDTOOverrideRetailPriceIsNull() {
    // Arrange
    NonDiscreteOrderItemRequestDTO ndr = new NonDiscreteOrderItemRequestDTO();
    ndr.setOverrideRetailPrice(null);
    ndr.setOverrideSalePrice(new Money());

    // Act and Assert
    assertTrue(validateAddRequestActivity.hasPrice(ndr));
  }

  /**
   * Test {@link ValidateAddRequestActivity#hasPrice(NonDiscreteOrderItemRequestDTO)}.
   * <ul>
   *   <li>When {@link NonDiscreteOrderItemRequestDTO#NonDiscreteOrderItemRequestDTO()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#hasPrice(NonDiscreteOrderItemRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ValidateAddRequestActivity.hasPrice(NonDiscreteOrderItemRequestDTO)"})
  public void testHasPrice_whenNonDiscreteOrderItemRequestDTO_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(validateAddRequestActivity.hasPrice(new NonDiscreteOrderItemRequestDTO()));
  }

  /**
   * Test {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)}.
   * <ul>
   *   <li>Given {@link NullBroadleafCurrency} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean ValidateAddRequestActivity.hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)"})
  public void testHasSameCurrency_givenNullBroadleafCurrency_thenReturnFalse() {
    // Arrange
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
   * Test {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)}.
   * <ul>
   *   <li>Then calls {@link Sku#getCurrency()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean ValidateAddRequestActivity.hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)"})
  public void testHasSameCurrency_thenCallsGetCurrency() {
    // Arrange
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
   * Test {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean ValidateAddRequestActivity.hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)"})
  public void testHasSameCurrency_thenThrowIllegalArgumentException() {
    // Arrange
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
   * Test {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)}.
   * <ul>
   *   <li>When {@link NonDiscreteOrderItemRequestDTO#NonDiscreteOrderItemRequestDTO()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean ValidateAddRequestActivity.hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)"})
  public void testHasSameCurrency_whenNonDiscreteOrderItemRequestDTO_thenReturnTrue() {
    // Arrange
    NonDiscreteOrderItemRequestDTO orderItemRequestDTO = new NonDiscreteOrderItemRequestDTO();
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act and Assert
    assertTrue(validateAddRequestActivity.hasSameCurrency(orderItemRequestDTO, request, new SkuImpl()));
  }

  /**
   * Test {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean ValidateAddRequestActivity.hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)"})
  public void testHasSameCurrency_whenNull_thenReturnTrue() {
    // Arrange
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    NullOrderImpl order = new NullOrderImpl();

    // Act and Assert
    assertTrue(validateAddRequestActivity.hasSameCurrency(orderItemRequestDTO,
        new CartOperationRequest(order, new OrderItemRequestDTO(), true), null));
  }

  /**
   * Test {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)}.
   * <ul>
   *   <li>When {@link Order} {@link Order#getCurrency()} return {@link BroadleafCurrencyImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean ValidateAddRequestActivity.hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)"})
  public void testHasSameCurrency_whenOrderGetCurrencyReturnBroadleafCurrencyImpl() {
    // Arrange
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
   * Test {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)}.
   * <ul>
   *   <li>When {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean ValidateAddRequestActivity.hasSameCurrency(OrderItemRequestDTO, CartOperationRequest, Sku)"})
  public void testHasSameCurrency_whenSkuImpl_thenReturnTrue() {
    // Arrange
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act and Assert
    assertTrue(validateAddRequestActivity.hasSameCurrency(orderItemRequestDTO, request, new SkuImpl()));
  }

  /**
   * Test {@link ValidateAddRequestActivity#validateIfParentOrderItemExists(OrderItemRequestDTO)}.
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#validateIfParentOrderItemExists(OrderItemRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ValidateAddRequestActivity.validateIfParentOrderItemExists(OrderItemRequestDTO)"})
  public void testValidateIfParentOrderItemExists() {
    // Arrange
    when(orderItemService.readOrderItemById(Mockito.<Long>any())).thenReturn(new BundleOrderItemImpl());

    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    orderItemRequestDTO.setParentOrderItemId(1L);

    // Act
    validateAddRequestActivity.validateIfParentOrderItemExists(orderItemRequestDTO);

    // Assert
    verify(orderItemService).readOrderItemById(eq(1L));
  }

  /**
   * Test {@link ValidateAddRequestActivity#validateIfParentOrderItemExists(OrderItemRequestDTO)}.
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#validateIfParentOrderItemExists(OrderItemRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ValidateAddRequestActivity.validateIfParentOrderItemExists(OrderItemRequestDTO)"})
  public void testValidateIfParentOrderItemExists2() {
    // Arrange
    when(orderItemService.readOrderItemById(Mockito.<Long>any())).thenReturn(null);

    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    orderItemRequestDTO.setParentOrderItemId(1L);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> validateAddRequestActivity.validateIfParentOrderItemExists(orderItemRequestDTO));
    verify(orderItemService).readOrderItemById(eq(1L));
  }

  /**
   * Test {@link ValidateAddRequestActivity#validateIfParentOrderItemExists(OrderItemRequestDTO)}.
   * <p>
   * Method under test: {@link ValidateAddRequestActivity#validateIfParentOrderItemExists(OrderItemRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ValidateAddRequestActivity.validateIfParentOrderItemExists(OrderItemRequestDTO)"})
  public void testValidateIfParentOrderItemExists3() {
    // Arrange
    when(orderItemService.readOrderItemById(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException("Could not find parent order item by the given id ("));

    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    orderItemRequestDTO.setParentOrderItemId(1L);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> validateAddRequestActivity.validateIfParentOrderItemExists(orderItemRequestDTO));
    verify(orderItemService).readOrderItemById(eq(1L));
  }
}

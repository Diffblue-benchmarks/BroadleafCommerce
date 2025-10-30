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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.catalog.service.CatalogService;
import org.broadleafcommerce.core.order.service.ProductOptionValidationService;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.exception.RequiredAttributeNotProvidedException;
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
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertyResolver;

@RunWith(MockitoJUnitRunner.class)
public class OrderItemRequestValidationServiceImplDiffblueTest {
  @InjectMocks
  private OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl;

  @Mock
  private CatalogService catalogService;

  @Mock
  private Environment environment;

  @Mock
  private ProductOptionValidationService productOptionValidationService;

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#satisfiesMinQuantityCondition(OrderItemRequestDTO, ProcessContext)}.
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#satisfiesMinQuantityCondition(OrderItemRequestDTO, ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean OrderItemRequestValidationServiceImpl.satisfiesMinQuantityCondition(OrderItemRequestDTO, ProcessContext)"})
  public void testSatisfiesMinQuantityCondition() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new IllegalArgumentException("enable.sku.minOrderQuantity.field"));
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> orderItemRequestValidationServiceImpl
        .satisfiesMinQuantityCondition(orderItemRequestDTO, new DefaultProcessContextImpl<>()));
    verify(environment).getProperty(eq("enable.sku.minOrderQuantity.field"), isA(Class.class), isA(Object.class));
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#satisfiesMinQuantityCondition(OrderItemRequestDTO, ProcessContext)}.
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#satisfiesMinQuantityCondition(OrderItemRequestDTO, ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean OrderItemRequestValidationServiceImpl.satisfiesMinQuantityCondition(OrderItemRequestDTO, ProcessContext)"})
  public void testSatisfiesMinQuantityCondition2() {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(true);
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO(1L, 1);

    // Act
    boolean actualSatisfiesMinQuantityConditionResult = orderItemRequestValidationServiceImpl
        .satisfiesMinQuantityCondition(orderItemRequestDTO, new DefaultProcessContextImpl<>());

    // Assert
    verify(catalogService).findProductById(eq(1L));
    verify(environment, atLeast(1)).getProperty(Mockito.<String>any(), isA(Class.class), isA(Object.class));
    assertTrue(actualSatisfiesMinQuantityConditionResult);
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#satisfiesMinQuantityCondition(OrderItemRequestDTO, ProcessContext)}.
   * <ul>
   *   <li>Given {@link CatalogService} {@link CatalogService#findProductById(Long)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#satisfiesMinQuantityCondition(OrderItemRequestDTO, ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean OrderItemRequestValidationServiceImpl.satisfiesMinQuantityCondition(OrderItemRequestDTO, ProcessContext)"})
  public void testSatisfiesMinQuantityCondition_givenCatalogServiceFindProductByIdReturnNull() {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(null);
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(true);
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO(1L, 1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> orderItemRequestValidationServiceImpl
        .satisfiesMinQuantityCondition(orderItemRequestDTO, new DefaultProcessContextImpl<>()));
    verify(catalogService).findProductById(eq(1L));
    verify(environment).getProperty(eq("enable.sku.minOrderQuantity.field"), isA(Class.class), isA(Object.class));
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#satisfiesMinQuantityCondition(OrderItemRequestDTO, ProcessContext)}.
   * <ul>
   *   <li>Given {@link Environment} {@link PropertyResolver#getProperty(String, Class, Object)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#satisfiesMinQuantityCondition(OrderItemRequestDTO, ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean OrderItemRequestValidationServiceImpl.satisfiesMinQuantityCondition(OrderItemRequestDTO, ProcessContext)"})
  public void testSatisfiesMinQuantityCondition_givenEnvironmentGetPropertyReturnFalse() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(false);
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();

    // Act
    boolean actualSatisfiesMinQuantityConditionResult = orderItemRequestValidationServiceImpl
        .satisfiesMinQuantityCondition(orderItemRequestDTO, new DefaultProcessContextImpl<>());

    // Assert
    verify(environment).getProperty(eq("enable.sku.minOrderQuantity.field"), isA(Class.class), isA(Object.class));
    assertTrue(actualSatisfiesMinQuantityConditionResult);
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#satisfiesMinQuantityCondition(OrderItemRequestDTO, ProcessContext)}.
   * <ul>
   *   <li>Then calls {@link CatalogService#findSkuById(Long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#satisfiesMinQuantityCondition(OrderItemRequestDTO, ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean OrderItemRequestValidationServiceImpl.satisfiesMinQuantityCondition(OrderItemRequestDTO, ProcessContext)"})
  public void testSatisfiesMinQuantityCondition_thenCallsFindSkuById() {
    // Arrange
    when(catalogService.findSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(mock(Product.class));
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(true);
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO(1L, 1L, 1);

    // Act
    boolean actualSatisfiesMinQuantityConditionResult = orderItemRequestValidationServiceImpl
        .satisfiesMinQuantityCondition(orderItemRequestDTO, new DefaultProcessContextImpl<>());

    // Assert
    verify(catalogService).findProductById(eq(1L));
    verify(catalogService).findSkuById(eq(1L));
    verify(environment, atLeast(1)).getProperty(Mockito.<String>any(), isA(Class.class), isA(Object.class));
    assertTrue(actualSatisfiesMinQuantityConditionResult);
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#satisfiesMinQuantityCondition(OrderItemRequestDTO, ProcessContext)}.
   * <ul>
   *   <li>Then throw {@link RequiredAttributeNotProvidedException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#satisfiesMinQuantityCondition(OrderItemRequestDTO, ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean OrderItemRequestValidationServiceImpl.satisfiesMinQuantityCondition(OrderItemRequestDTO, ProcessContext)"})
  public void testSatisfiesMinQuantityCondition_thenThrowRequiredAttributeNotProvidedException() {
    // Arrange
    Product product = mock(Product.class);
    when(product.getAdditionalSkus()).thenThrow(new RequiredAttributeNotProvidedException("Attribute Name"));
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(product);
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(true);
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO(1L, 1);

    // Act and Assert
    assertThrows(RequiredAttributeNotProvidedException.class, () -> orderItemRequestValidationServiceImpl
        .satisfiesMinQuantityCondition(orderItemRequestDTO, new DefaultProcessContextImpl<>()));
    verify(product).getAdditionalSkus();
    verify(catalogService).findProductById(eq(1L));
    verify(environment, atLeast(1)).getProperty(Mockito.<String>any(), isA(Class.class), isA(Object.class));
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#satisfiesMinQuantityCondition(OrderItemRequestDTO, ProcessContext)}.
   * <ul>
   *   <li>When {@link OrderItemRequestDTO#OrderItemRequestDTO()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#satisfiesMinQuantityCondition(OrderItemRequestDTO, ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean OrderItemRequestValidationServiceImpl.satisfiesMinQuantityCondition(OrderItemRequestDTO, ProcessContext)"})
  public void testSatisfiesMinQuantityCondition_whenOrderItemRequestDTO_thenReturnTrue() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(true);
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();

    // Act
    boolean actualSatisfiesMinQuantityConditionResult = orderItemRequestValidationServiceImpl
        .satisfiesMinQuantityCondition(orderItemRequestDTO, new DefaultProcessContextImpl<>());

    // Assert
    verify(environment, atLeast(1)).getProperty(Mockito.<String>any(), isA(Class.class), isA(Object.class));
    assertTrue(actualSatisfiesMinQuantityConditionResult);
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#getMinQuantity(OrderItemRequestDTO, ProcessContext)}.
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#getMinQuantity(OrderItemRequestDTO, ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Integer OrderItemRequestValidationServiceImpl.getMinQuantity(OrderItemRequestDTO, ProcessContext)"})
  public void testGetMinQuantity() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new IllegalArgumentException("enable.sku.minOrderQuantity.field"));
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> orderItemRequestValidationServiceImpl
        .getMinQuantity(orderItemRequestDTO, new DefaultProcessContextImpl<>()));
    verify(environment).getProperty(eq("enable.sku.minOrderQuantity.field"), isA(Class.class), isA(Object.class));
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#getMinQuantity(OrderItemRequestDTO, ProcessContext)}.
   * <ul>
   *   <li>Given {@link CatalogService} {@link CatalogService#findProductById(Long)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#getMinQuantity(OrderItemRequestDTO, ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Integer OrderItemRequestValidationServiceImpl.getMinQuantity(OrderItemRequestDTO, ProcessContext)"})
  public void testGetMinQuantity_givenCatalogServiceFindProductByIdReturnNull() {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(null);
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(true);
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO(1L, 1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> orderItemRequestValidationServiceImpl
        .getMinQuantity(orderItemRequestDTO, new DefaultProcessContextImpl<>()));
    verify(catalogService).findProductById(eq(1L));
    verify(environment).getProperty(eq("enable.sku.minOrderQuantity.field"), isA(Class.class), isA(Object.class));
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#getMinQuantity(OrderItemRequestDTO, ProcessContext)}.
   * <ul>
   *   <li>Given {@link CatalogService} {@link CatalogService#findProductById(Long)} return {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#getMinQuantity(OrderItemRequestDTO, ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Integer OrderItemRequestValidationServiceImpl.getMinQuantity(OrderItemRequestDTO, ProcessContext)"})
  public void testGetMinQuantity_givenCatalogServiceFindProductByIdReturnProductBundleImpl() {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(true);
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO(1L, 1);

    // Act
    Integer actualMinQuantity = orderItemRequestValidationServiceImpl.getMinQuantity(orderItemRequestDTO,
        new DefaultProcessContextImpl<>());

    // Assert
    verify(catalogService).findProductById(eq(1L));
    verify(environment, atLeast(1)).getProperty(Mockito.<String>any(), isA(Class.class), isA(Object.class));
    assertEquals(1, actualMinQuantity.intValue());
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#getMinQuantity(OrderItemRequestDTO, ProcessContext)}.
   * <ul>
   *   <li>Given {@link Environment} {@link PropertyResolver#getProperty(String, Class, Object)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#getMinQuantity(OrderItemRequestDTO, ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Integer OrderItemRequestValidationServiceImpl.getMinQuantity(OrderItemRequestDTO, ProcessContext)"})
  public void testGetMinQuantity_givenEnvironmentGetPropertyReturnFalse() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(false);
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();

    // Act
    Integer actualMinQuantity = orderItemRequestValidationServiceImpl.getMinQuantity(orderItemRequestDTO,
        new DefaultProcessContextImpl<>());

    // Assert
    verify(environment).getProperty(eq("enable.sku.minOrderQuantity.field"), isA(Class.class), isA(Object.class));
    assertEquals(1, actualMinQuantity.intValue());
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#getMinQuantity(OrderItemRequestDTO, ProcessContext)}.
   * <ul>
   *   <li>Then calls {@link CatalogService#findSkuById(Long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#getMinQuantity(OrderItemRequestDTO, ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Integer OrderItemRequestValidationServiceImpl.getMinQuantity(OrderItemRequestDTO, ProcessContext)"})
  public void testGetMinQuantity_thenCallsFindSkuById() {
    // Arrange
    when(catalogService.findSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(mock(Product.class));
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(true);
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO(1L, 1L, 1);

    // Act
    Integer actualMinQuantity = orderItemRequestValidationServiceImpl.getMinQuantity(orderItemRequestDTO,
        new DefaultProcessContextImpl<>());

    // Assert
    verify(catalogService).findProductById(eq(1L));
    verify(catalogService).findSkuById(eq(1L));
    verify(environment, atLeast(1)).getProperty(Mockito.<String>any(), isA(Class.class), isA(Object.class));
    assertEquals(1, actualMinQuantity.intValue());
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#getMinQuantity(OrderItemRequestDTO, ProcessContext)}.
   * <ul>
   *   <li>Then throw {@link RequiredAttributeNotProvidedException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#getMinQuantity(OrderItemRequestDTO, ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Integer OrderItemRequestValidationServiceImpl.getMinQuantity(OrderItemRequestDTO, ProcessContext)"})
  public void testGetMinQuantity_thenThrowRequiredAttributeNotProvidedException() {
    // Arrange
    Product product = mock(Product.class);
    when(product.getAdditionalSkus()).thenThrow(new RequiredAttributeNotProvidedException("Attribute Name"));
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(product);
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(true);
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO(1L, 1);

    // Act and Assert
    assertThrows(RequiredAttributeNotProvidedException.class, () -> orderItemRequestValidationServiceImpl
        .getMinQuantity(orderItemRequestDTO, new DefaultProcessContextImpl<>()));
    verify(product).getAdditionalSkus();
    verify(catalogService).findProductById(eq(1L));
    verify(environment, atLeast(1)).getProperty(Mockito.<String>any(), isA(Class.class), isA(Object.class));
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#getMinQuantity(OrderItemRequestDTO, ProcessContext)}.
   * <ul>
   *   <li>When {@link OrderItemRequestDTO#OrderItemRequestDTO()}.</li>
   *   <li>Then return intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#getMinQuantity(OrderItemRequestDTO, ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Integer OrderItemRequestValidationServiceImpl.getMinQuantity(OrderItemRequestDTO, ProcessContext)"})
  public void testGetMinQuantity_whenOrderItemRequestDTO_thenReturnIntValueIsOne() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(true);
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();

    // Act
    Integer actualMinQuantity = orderItemRequestValidationServiceImpl.getMinQuantity(orderItemRequestDTO,
        new DefaultProcessContextImpl<>());

    // Assert
    verify(environment, atLeast(1)).getProperty(Mockito.<String>any(), isA(Class.class), isA(Object.class));
    assertEquals(1, actualMinQuantity.intValue());
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#determineProduct(OrderItemRequestDTO)}.
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#determineProduct(OrderItemRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Product OrderItemRequestValidationServiceImpl.determineProduct(OrderItemRequestDTO)"})
  public void testDetermineProduct() {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenThrow(
        new IllegalArgumentException("Product was specified but no matching product was found with the productId ("));

    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    orderItemRequestDTO.setProductId(1L);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> orderItemRequestValidationServiceImpl.determineProduct(orderItemRequestDTO));
    verify(catalogService).findProductById(eq(1L));
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#determineProduct(OrderItemRequestDTO)}.
   * <ul>
   *   <li>Given {@link CatalogService} {@link CatalogService#findProductById(Long)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#determineProduct(OrderItemRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Product OrderItemRequestValidationServiceImpl.determineProduct(OrderItemRequestDTO)"})
  public void testDetermineProduct_givenCatalogServiceFindProductByIdReturnNull() {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(null);

    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    orderItemRequestDTO.setProductId(1L);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> orderItemRequestValidationServiceImpl.determineProduct(orderItemRequestDTO));
    verify(catalogService).findProductById(eq(1L));
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#determineProduct(OrderItemRequestDTO)}.
   * <ul>
   *   <li>Then return {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#determineProduct(OrderItemRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Product OrderItemRequestValidationServiceImpl.determineProduct(OrderItemRequestDTO)"})
  public void testDetermineProduct_thenReturnProductBundleImpl() {
    // Arrange
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);

    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    orderItemRequestDTO.setProductId(1L);

    // Act
    Product actualDetermineProductResult = orderItemRequestValidationServiceImpl.determineProduct(orderItemRequestDTO);

    // Assert
    verify(catalogService).findProductById(eq(1L));
    assertSame(productBundleImpl, actualDetermineProductResult);
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#determineProduct(OrderItemRequestDTO)}.
   * <ul>
   *   <li>When {@link OrderItemRequestDTO#OrderItemRequestDTO()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#determineProduct(OrderItemRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Product OrderItemRequestValidationServiceImpl.determineProduct(OrderItemRequestDTO)"})
  public void testDetermineProduct_whenOrderItemRequestDTO_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(orderItemRequestValidationServiceImpl.determineProduct(new OrderItemRequestDTO()));
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#determineSku(OrderItemRequestDTO, ActivityMessages)} with {@code orderItemRequestDTO}, {@code messages}.
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#determineSku(OrderItemRequestDTO, ActivityMessages)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku OrderItemRequestValidationServiceImpl.determineSku(OrderItemRequestDTO, ActivityMessages)"})
  public void testDetermineSkuWithOrderItemRequestDTOMessages() throws RequiredAttributeNotProvidedException {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(false);
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();

    // Act
    Sku actualDetermineSkuResult = orderItemRequestValidationServiceImpl.determineSku(orderItemRequestDTO,
        new DefaultProcessContextImpl<>());

    // Assert
    verify(environment).getProperty(eq("solr.index.use.sku"), isA(Class.class), isA(Object.class));
    assertNull(actualDetermineSkuResult);
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#determineSku(OrderItemRequestDTO, ActivityMessages)} with {@code orderItemRequestDTO}, {@code messages}.
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#determineSku(OrderItemRequestDTO, ActivityMessages)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku OrderItemRequestValidationServiceImpl.determineSku(OrderItemRequestDTO, ActivityMessages)"})
  public void testDetermineSkuWithOrderItemRequestDTOMessages2() throws RequiredAttributeNotProvidedException {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(null);
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO(1L, 1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> orderItemRequestValidationServiceImpl
        .determineSku(orderItemRequestDTO, new DefaultProcessContextImpl<>()));
    verify(catalogService).findProductById(eq(1L));
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#determineSku(OrderItemRequestDTO, ActivityMessages)} with {@code orderItemRequestDTO}, {@code messages}.
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#determineSku(OrderItemRequestDTO, ActivityMessages)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku OrderItemRequestValidationServiceImpl.determineSku(OrderItemRequestDTO, ActivityMessages)"})
  public void testDetermineSkuWithOrderItemRequestDTOMessages3() throws RequiredAttributeNotProvidedException {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(true);
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO(1L, 1);

    // Act
    Sku actualDetermineSkuResult = orderItemRequestValidationServiceImpl.determineSku(orderItemRequestDTO,
        new DefaultProcessContextImpl<>());

    // Assert
    verify(catalogService).findProductById(eq(1L));
    verify(environment).getProperty(eq("solr.index.use.sku"), isA(Class.class), isA(Object.class));
    assertNull(actualDetermineSkuResult);
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#determineSku(OrderItemRequestDTO, ActivityMessages)} with {@code orderItemRequestDTO}, {@code messages}.
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#determineSku(OrderItemRequestDTO, ActivityMessages)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku OrderItemRequestValidationServiceImpl.determineSku(OrderItemRequestDTO, ActivityMessages)"})
  public void testDetermineSkuWithOrderItemRequestDTOMessages4() throws RequiredAttributeNotProvidedException {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(false);
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO(1L, 1);

    // Act
    Sku actualDetermineSkuResult = orderItemRequestValidationServiceImpl.determineSku(orderItemRequestDTO,
        new DefaultProcessContextImpl<>());

    // Assert
    verify(catalogService).findProductById(eq(1L));
    verify(environment).getProperty(eq("solr.index.use.sku"), isA(Class.class), isA(Object.class));
    assertNull(actualDetermineSkuResult);
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#determineSku(OrderItemRequestDTO, ActivityMessages)} with {@code orderItemRequestDTO}, {@code messages}.
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#determineSku(OrderItemRequestDTO, ActivityMessages)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku OrderItemRequestValidationServiceImpl.determineSku(OrderItemRequestDTO, ActivityMessages)"})
  public void testDetermineSkuWithOrderItemRequestDTOMessages5() throws RequiredAttributeNotProvidedException {
    // Arrange
    when(catalogService.findSkuById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException("solr.index.use.sku"));
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(true);
    OrderItemRequestDTO orderItemRequestDTO = mock(OrderItemRequestDTO.class);
    when(orderItemRequestDTO.getProductId()).thenReturn(1L);
    when(orderItemRequestDTO.getSkuId()).thenReturn(1L);
    when(orderItemRequestDTO.getItemAttributes()).thenReturn(new HashMap<>());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> orderItemRequestValidationServiceImpl
        .determineSku(orderItemRequestDTO, new DefaultProcessContextImpl<>()));
    verify(catalogService).findProductById(eq(1L));
    verify(catalogService).findSkuById(eq(1L));
    verify(orderItemRequestDTO).getItemAttributes();
    verify(orderItemRequestDTO, atLeast(1)).getProductId();
    verify(orderItemRequestDTO).getSkuId();
    verify(environment).getProperty(eq("solr.index.use.sku"), isA(Class.class), isA(Object.class));
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#determineSku(OrderItemRequestDTO, ActivityMessages)} with {@code orderItemRequestDTO}, {@code messages}.
   * <ul>
   *   <li>Then return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#determineSku(OrderItemRequestDTO, ActivityMessages)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku OrderItemRequestValidationServiceImpl.determineSku(OrderItemRequestDTO, ActivityMessages)"})
  public void testDetermineSkuWithOrderItemRequestDTOMessages_thenReturnSkuImpl()
      throws RequiredAttributeNotProvidedException {
    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    when(catalogService.findSkuById(Mockito.<Long>any())).thenReturn(skuImpl);
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(true);
    OrderItemRequestDTO orderItemRequestDTO = mock(OrderItemRequestDTO.class);
    when(orderItemRequestDTO.getProductId()).thenReturn(1L);
    when(orderItemRequestDTO.getSkuId()).thenReturn(1L);
    when(orderItemRequestDTO.getItemAttributes()).thenReturn(new HashMap<>());

    // Act
    Sku actualDetermineSkuResult = orderItemRequestValidationServiceImpl.determineSku(orderItemRequestDTO,
        new DefaultProcessContextImpl<>());

    // Assert
    verify(catalogService).findProductById(eq(1L));
    verify(catalogService).findSkuById(eq(1L));
    verify(orderItemRequestDTO).getItemAttributes();
    verify(orderItemRequestDTO, atLeast(1)).getProductId();
    verify(orderItemRequestDTO).getSkuId();
    verify(environment).getProperty(eq("solr.index.use.sku"), isA(Class.class), isA(Object.class));
    assertSame(skuImpl, actualDetermineSkuResult);
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#determineSku(OrderItemRequestDTO, ActivityMessages)} with {@code orderItemRequestDTO}, {@code messages}.
   * <ul>
   *   <li>When {@link OrderItemRequestDTO#OrderItemRequestDTO()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#determineSku(OrderItemRequestDTO, ActivityMessages)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku OrderItemRequestValidationServiceImpl.determineSku(OrderItemRequestDTO, ActivityMessages)"})
  public void testDetermineSkuWithOrderItemRequestDTOMessages_whenOrderItemRequestDTO()
      throws RequiredAttributeNotProvidedException {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(true);
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();

    // Act
    Sku actualDetermineSkuResult = orderItemRequestValidationServiceImpl.determineSku(orderItemRequestDTO,
        new DefaultProcessContextImpl<>());

    // Assert
    verify(environment).getProperty(eq("solr.index.use.sku"), isA(Class.class), isA(Object.class));
    assertNull(actualDetermineSkuResult);
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#determineSku(Product, Long, Map, ActivityMessages)} with {@code product}, {@code skuId}, {@code attributeValues}, {@code messages}.
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#determineSku(Product, Long, Map, ActivityMessages)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku OrderItemRequestValidationServiceImpl.determineSku(Product, Long, Map, ActivityMessages)"})
  public void testDetermineSkuWithProductSkuIdAttributeValuesMessages() throws RequiredAttributeNotProvidedException {
    // Arrange
    when(catalogService.findSkuById(Mockito.<Long>any())).thenReturn(null);
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(true);
    ProductBundleImpl product = new ProductBundleImpl();
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act
    Sku actualDetermineSkuResult = orderItemRequestValidationServiceImpl.determineSku(product, 1L, attributeValues,
        new DefaultProcessContextImpl<>());

    // Assert
    verify(catalogService).findSkuById(eq(1L));
    verify(environment).getProperty(eq("solr.index.use.sku"), isA(Class.class), isA(Object.class));
    assertNull(actualDetermineSkuResult);
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#determineSku(Product, Long, Map, ActivityMessages)} with {@code product}, {@code skuId}, {@code attributeValues}, {@code messages}.
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#determineSku(Product, Long, Map, ActivityMessages)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku OrderItemRequestValidationServiceImpl.determineSku(Product, Long, Map, ActivityMessages)"})
  public void testDetermineSkuWithProductSkuIdAttributeValuesMessages2() throws RequiredAttributeNotProvidedException {
    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    when(catalogService.findSkuById(Mockito.<Long>any())).thenReturn(skuImpl);
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(false);
    ProductBundleImpl product = new ProductBundleImpl();
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act
    Sku actualDetermineSkuResult = orderItemRequestValidationServiceImpl.determineSku(product, 1L, attributeValues,
        new DefaultProcessContextImpl<>());

    // Assert
    verify(catalogService).findSkuById(eq(1L));
    verify(environment).getProperty(eq("solr.index.use.sku"), isA(Class.class), isA(Object.class));
    assertSame(skuImpl, actualDetermineSkuResult);
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#determineSku(Product, Long, Map, ActivityMessages)} with {@code product}, {@code skuId}, {@code attributeValues}, {@code messages}.
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#determineSku(Product, Long, Map, ActivityMessages)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku OrderItemRequestValidationServiceImpl.determineSku(Product, Long, Map, ActivityMessages)"})
  public void testDetermineSkuWithProductSkuIdAttributeValuesMessages3() throws RequiredAttributeNotProvidedException {
    // Arrange
    when(catalogService.findSkuById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException("solr.index.use.sku"));
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(true);
    ProductBundleImpl product = new ProductBundleImpl();
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> orderItemRequestValidationServiceImpl.determineSku(product, 1L,
        attributeValues, new DefaultProcessContextImpl<>()));
    verify(catalogService).findSkuById(eq(1L));
    verify(environment).getProperty(eq("solr.index.use.sku"), isA(Class.class), isA(Object.class));
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#determineSku(Product, Long, Map, ActivityMessages)} with {@code product}, {@code skuId}, {@code attributeValues}, {@code messages}.
   * <ul>
   *   <li>Then return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#determineSku(Product, Long, Map, ActivityMessages)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku OrderItemRequestValidationServiceImpl.determineSku(Product, Long, Map, ActivityMessages)"})
  public void testDetermineSkuWithProductSkuIdAttributeValuesMessages_thenReturnSkuImpl()
      throws RequiredAttributeNotProvidedException {
    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    when(catalogService.findSkuById(Mockito.<Long>any())).thenReturn(skuImpl);
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(true);
    ProductBundleImpl product = new ProductBundleImpl();
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act
    Sku actualDetermineSkuResult = orderItemRequestValidationServiceImpl.determineSku(product, 1L, attributeValues,
        new DefaultProcessContextImpl<>());

    // Assert
    verify(catalogService).findSkuById(eq(1L));
    verify(environment).getProperty(eq("solr.index.use.sku"), isA(Class.class), isA(Object.class));
    assertSame(skuImpl, actualDetermineSkuResult);
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#determineSku(Product, Long, Map, ActivityMessages)} with {@code product}, {@code skuId}, {@code attributeValues}, {@code messages}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#determineSku(Product, Long, Map, ActivityMessages)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku OrderItemRequestValidationServiceImpl.determineSku(Product, Long, Map, ActivityMessages)"})
  public void testDetermineSkuWithProductSkuIdAttributeValuesMessages_whenNull_thenReturnNull()
      throws RequiredAttributeNotProvidedException {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(true);
    ProductBundleImpl product = new ProductBundleImpl();
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act
    Sku actualDetermineSkuResult = orderItemRequestValidationServiceImpl.determineSku(product, null, attributeValues,
        new DefaultProcessContextImpl<>());

    // Assert
    verify(environment).getProperty(eq("solr.index.use.sku"), isA(Class.class), isA(Object.class));
    assertNull(actualDetermineSkuResult);
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#canSellDefaultSku(Product)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#canSellDefaultSku(Product)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemRequestValidationServiceImpl.canSellDefaultSku(Product)"})
  public void testCanSellDefaultSku_whenProductBundleImpl_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(orderItemRequestValidationServiceImpl.canSellDefaultSku(new ProductBundleImpl()));
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map)} with {@code product}, {@code attributeValuesForSku}.
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku OrderItemRequestValidationServiceImpl.findMatchingSku(Product, Map)"})
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
        () -> orderItemRequestValidationServiceImpl.findMatchingSku(product, attributeValuesForSku));
    verify(catalogService).findSkuById(eq(1L));
    verify(productOptionValidationService).findSkuIdsForProductOptionValues(isNull(), eq("foo"), eq("foo"),
        isA(List.class));
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map)} with {@code product}, {@code attributeValuesForSku}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku OrderItemRequestValidationServiceImpl.findMatchingSku(Product, Map)"})
  public void testFindMatchingSkuWithProductAttributeValuesForSku_thenReturnNull() {
    // Arrange
    when(productOptionValidationService.findSkuIdsForProductOptionValues(Mockito.<Long>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<List<Long>>any())).thenReturn(new ArrayList<>());
    ProductBundleImpl product = new ProductBundleImpl();

    HashMap<String, String> attributeValuesForSku = new HashMap<>();
    attributeValuesForSku.put("foo", "foo");

    // Act
    Sku actualFindMatchingSkuResult = orderItemRequestValidationServiceImpl.findMatchingSku(product,
        attributeValuesForSku);

    // Assert
    verify(productOptionValidationService).findSkuIdsForProductOptionValues(isNull(), eq("foo"), eq("foo"),
        isA(List.class));
    assertNull(actualFindMatchingSkuResult);
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map)} with {@code product}, {@code attributeValuesForSku}.
   * <ul>
   *   <li>Then return {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku OrderItemRequestValidationServiceImpl.findMatchingSku(Product, Map)"})
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
    Sku actualFindMatchingSkuResult = orderItemRequestValidationServiceImpl.findMatchingSku(product,
        attributeValuesForSku);

    // Assert
    verify(catalogService).findSkuById(eq(1L));
    verify(productOptionValidationService).findSkuIdsForProductOptionValues(isNull(), eq("foo"), eq("foo"),
        isA(List.class));
    assertSame(skuImpl, actualFindMatchingSkuResult);
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map)} with {@code product}, {@code attributeValuesForSku}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku OrderItemRequestValidationServiceImpl.findMatchingSku(Product, Map)"})
  public void testFindMatchingSkuWithProductAttributeValuesForSku_whenHashMap_thenReturnNull() {
    // Arrange
    ProductBundleImpl product = new ProductBundleImpl();

    // Act and Assert
    assertNull(orderItemRequestValidationServiceImpl.findMatchingSku(product, new HashMap<>()));
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map, ActivityMessages)} with {@code product}, {@code attributeValues}, {@code messages}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map, ActivityMessages)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku OrderItemRequestValidationServiceImpl.findMatchingSku(Product, Map, ActivityMessages)"})
  public void testFindMatchingSkuWithProductAttributeValuesMessages_whenNull_thenReturnNull()
      throws RequiredAttributeNotProvidedException {
    // Arrange
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act and Assert
    assertNull(orderItemRequestValidationServiceImpl.findMatchingSku(null, attributeValues,
        new DefaultProcessContextImpl<>()));
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map, ActivityMessages)} with {@code product}, {@code attributeValues}, {@code messages}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map, ActivityMessages)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Sku OrderItemRequestValidationServiceImpl.findMatchingSku(Product, Map, ActivityMessages)"})
  public void testFindMatchingSkuWithProductAttributeValuesMessages_whenProductBundleImpl()
      throws RequiredAttributeNotProvidedException {
    // Arrange
    ProductBundleImpl product = new ProductBundleImpl();
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act and Assert
    assertNull(orderItemRequestValidationServiceImpl.findMatchingSku(product, attributeValues,
        new DefaultProcessContextImpl<>()));
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#shouldValidateWithException(boolean, boolean, String, boolean)}.
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#shouldValidateWithException(boolean, boolean, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean OrderItemRequestValidationServiceImpl.shouldValidateWithException(boolean, boolean, String, boolean)"})
  public void testShouldValidateWithException_when0123456789abcdef_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        orderItemRequestValidationServiceImpl.shouldValidateWithException(false, false, "0123456789ABCDEF", false));
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#shouldValidateWithException(boolean, boolean, String, boolean)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#shouldValidateWithException(boolean, boolean, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean OrderItemRequestValidationServiceImpl.shouldValidateWithException(boolean, boolean, String, boolean)"})
  public void testShouldValidateWithException_whenEmptyString_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(orderItemRequestValidationServiceImpl.shouldValidateWithException(false, false, "", false));
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#shouldValidateWithException(boolean, boolean, String, boolean)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#shouldValidateWithException(boolean, boolean, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean OrderItemRequestValidationServiceImpl.shouldValidateWithException(boolean, boolean, String, boolean)"})
  public void testShouldValidateWithException_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(orderItemRequestValidationServiceImpl.shouldValidateWithException(false, false, null, false));
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#shouldValidateWithException(boolean, boolean, String, boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#shouldValidateWithException(boolean, boolean, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean OrderItemRequestValidationServiceImpl.shouldValidateWithException(boolean, boolean, String, boolean)"})
  public void testShouldValidateWithException_whenTrue_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        orderItemRequestValidationServiceImpl.shouldValidateWithException(true, false, "0123456789ABCDEF", true));
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#shouldValidateWithException(boolean, boolean, String, boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#shouldValidateWithException(boolean, boolean, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean OrderItemRequestValidationServiceImpl.shouldValidateWithException(boolean, boolean, String, boolean)"})
  public void testShouldValidateWithException_whenTrue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(orderItemRequestValidationServiceImpl.shouldValidateWithException(true, true, "0123456789ABCDEF", true));
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#minOrderQuantityCheckIsEnabled()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#minOrderQuantityCheckIsEnabled()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemRequestValidationServiceImpl.minOrderQuantityCheckIsEnabled()"})
  public void testMinOrderQuantityCheckIsEnabled_thenReturnFalse() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(false);

    // Act
    boolean actualMinOrderQuantityCheckIsEnabledResult = orderItemRequestValidationServiceImpl
        .minOrderQuantityCheckIsEnabled();

    // Assert
    verify(environment).getProperty(eq("enable.sku.minOrderQuantity.field"), isA(Class.class), isA(Object.class));
    assertFalse(actualMinOrderQuantityCheckIsEnabledResult);
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#minOrderQuantityCheckIsEnabled()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#minOrderQuantityCheckIsEnabled()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemRequestValidationServiceImpl.minOrderQuantityCheckIsEnabled()"})
  public void testMinOrderQuantityCheckIsEnabled_thenReturnTrue() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(true);

    // Act
    boolean actualMinOrderQuantityCheckIsEnabledResult = orderItemRequestValidationServiceImpl
        .minOrderQuantityCheckIsEnabled();

    // Assert
    verify(environment).getProperty(eq("enable.sku.minOrderQuantity.field"), isA(Class.class), isA(Object.class));
    assertTrue(actualMinOrderQuantityCheckIsEnabledResult);
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#minOrderQuantityCheckIsEnabled()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#minOrderQuantityCheckIsEnabled()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemRequestValidationServiceImpl.minOrderQuantityCheckIsEnabled()"})
  public void testMinOrderQuantityCheckIsEnabled_thenThrowIllegalArgumentException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new IllegalArgumentException("enable.sku.minOrderQuantity.field"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> orderItemRequestValidationServiceImpl.minOrderQuantityCheckIsEnabled());
    verify(environment).getProperty(eq("enable.sku.minOrderQuantity.field"), isA(Class.class), isA(Object.class));
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#shouldUseSku()}.
   * <ul>
   *   <li>Given {@link Environment} {@link PropertyResolver#getProperty(String, Class, Object)} return {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#shouldUseSku()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemRequestValidationServiceImpl.shouldUseSku()"})
  public void testShouldUseSku_givenEnvironmentGetPropertyReturnFalse_thenReturnFalse() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(false);

    // Act
    boolean actualShouldUseSkuResult = orderItemRequestValidationServiceImpl.shouldUseSku();

    // Assert
    verify(environment).getProperty(eq("solr.index.use.sku"), isA(Class.class), isA(Object.class));
    assertFalse(actualShouldUseSkuResult);
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#shouldUseSku()}.
   * <ul>
   *   <li>Given {@link Environment} {@link PropertyResolver#getProperty(String, Class, Object)} return {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#shouldUseSku()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemRequestValidationServiceImpl.shouldUseSku()"})
  public void testShouldUseSku_givenEnvironmentGetPropertyReturnTrue_thenReturnTrue() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenReturn(true);

    // Act
    boolean actualShouldUseSkuResult = orderItemRequestValidationServiceImpl.shouldUseSku();

    // Assert
    verify(environment).getProperty(eq("solr.index.use.sku"), isA(Class.class), isA(Object.class));
    assertTrue(actualShouldUseSkuResult);
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#shouldUseSku()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemRequestValidationServiceImpl#shouldUseSku()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemRequestValidationServiceImpl.shouldUseSku()"})
  public void testShouldUseSku_thenThrowIllegalArgumentException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Object>>any(), Mockito.<Object>any()))
        .thenThrow(new IllegalArgumentException("solr.index.use.sku"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> orderItemRequestValidationServiceImpl.shouldUseSku());
    verify(environment).getProperty(eq("solr.index.use.sku"), isA(Class.class), isA(Object.class));
  }
}

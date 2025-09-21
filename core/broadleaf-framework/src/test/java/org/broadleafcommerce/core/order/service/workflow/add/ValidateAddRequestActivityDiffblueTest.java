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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.catalog.service.CatalogService;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.service.call.NonDiscreteOrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.exception.RequiredAttributeNotProvidedException;
import org.broadleafcommerce.core.order.service.workflow.CartOperationRequest;
import org.broadleafcommerce.core.workflow.ActivityMessages;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ValidateAddRequestActivityDiffblueTest {
  @Mock private CatalogService catalogService;

  @InjectMocks private ValidateAddRequestActivity validateAddRequestActivity;

  /**
   * Test {@link ValidateAddRequestActivity#determineProduct(OrderItemRequestDTO)}.
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#determineProduct(OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Product ValidateAddRequestActivity.determineProduct(OrderItemRequestDTO)"})
  public void testDetermineProduct() {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());

    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO(1L, 1);
    orderItemRequestDTO.setProductId(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> validateAddRequestActivity.determineProduct(orderItemRequestDTO));
    verify(catalogService).findProductById(1L);
  }

  /**
   * Test {@link ValidateAddRequestActivity#determineProduct(OrderItemRequestDTO)}.
   *
   * <ul>
   *   <li>Given {@link CatalogService} {@link CatalogService#findProductById(Long)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#determineProduct(OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Product ValidateAddRequestActivity.determineProduct(OrderItemRequestDTO)"})
  public void testDetermineProduct_givenCatalogServiceFindProductByIdReturnNull() {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(null);

    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO(1L, 1);
    orderItemRequestDTO.setProductId(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> validateAddRequestActivity.determineProduct(orderItemRequestDTO));
    verify(catalogService).findProductById(1L);
  }

  /**
   * Test {@link ValidateAddRequestActivity#determineProduct(OrderItemRequestDTO)}.
   *
   * <ul>
   *   <li>Then return {@link ProductBundleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#determineProduct(OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Product ValidateAddRequestActivity.determineProduct(OrderItemRequestDTO)"})
  public void testDetermineProduct_thenReturnProductBundleImpl() {
    // Arrange
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);

    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO(1L, 1);
    orderItemRequestDTO.setProductId(1L);

    // Act
    Product actualDetermineProductResult =
        validateAddRequestActivity.determineProduct(orderItemRequestDTO);

    // Assert
    verify(catalogService).findProductById(1L);
    assertSame(productBundleImpl, actualDetermineProductResult);
  }

  /**
   * Test {@link ValidateAddRequestActivity#determineProduct(OrderItemRequestDTO)}.
   *
   * <ul>
   *   <li>When {@link OrderItemRequestDTO#OrderItemRequestDTO()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#determineProduct(OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Product ValidateAddRequestActivity.determineProduct(OrderItemRequestDTO)"})
  public void testDetermineProduct_whenOrderItemRequestDTO_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(validateAddRequestActivity.determineProduct(new OrderItemRequestDTO()));
  }

  /**
   * Test {@link ValidateAddRequestActivity#determineSku(Product, Long, Map, ActivityMessages)}.
   *
   * <ul>
   *   <li>Given {@link CatalogService} {@link CatalogService#findSkuById(Long)} return {@link
   *       SkuImpl} (default constructor).
   *   <li>Then return {@link SkuImpl}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#determineSku(Product, Long, Map,
   * ActivityMessages)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Sku ValidateAddRequestActivity.determineSku(Product, Long, Map, ActivityMessages)"
  })
  public void testDetermineSku_givenCatalogServiceFindSkuByIdReturnSkuImpl_thenReturnSkuImpl()
      throws RequiredAttributeNotProvidedException {
    // Arrange
    when(catalogService.findSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());
    ProductBundleImpl product = new ProductBundleImpl();
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act
    Sku actualDetermineSkuResult =
        validateAddRequestActivity.determineSku(
            product, 1L, attributeValues, new DefaultProcessContextImpl<>());

    // Assert
    verify(catalogService).findSkuById(1L);
    assertTrue(actualDetermineSkuResult instanceof SkuImpl);
    Money margin = actualDetermineSkuResult.getMargin();
    Money actualAbsResult = margin.abs();
    assertEquals(margin, actualAbsResult);
    Money actualZeroResult = margin.zero();
    assertEquals(margin, actualZeroResult);
  }

  /**
   * Test {@link ValidateAddRequestActivity#determineSku(Product, Long, Map, ActivityMessages)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#determineSku(Product, Long, Map,
   * ActivityMessages)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Sku ValidateAddRequestActivity.determineSku(Product, Long, Map, ActivityMessages)"
  })
  public void testDetermineSku_thenThrowIllegalArgumentException()
      throws RequiredAttributeNotProvidedException {
    // Arrange
    when(catalogService.findSkuById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException());
    ProductBundleImpl product = new ProductBundleImpl();
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            validateAddRequestActivity.determineSku(
                product, 1L, attributeValues, new DefaultProcessContextImpl<>()));
    verify(catalogService).findSkuById(1L);
  }

  /**
   * Test {@link ValidateAddRequestActivity#determineSku(Product, Long, Map, ActivityMessages)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link SkuImpl}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#determineSku(Product, Long, Map,
   * ActivityMessages)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Sku ValidateAddRequestActivity.determineSku(Product, Long, Map, ActivityMessages)"
  })
  public void testDetermineSku_whenNull_thenReturnSkuImpl()
      throws RequiredAttributeNotProvidedException {
    // Arrange
    when(catalogService.findSkuById(Mockito.<Long>any())).thenReturn(new SkuImpl());
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act
    Sku actualDetermineSkuResult =
        validateAddRequestActivity.determineSku(
            null, 1L, attributeValues, new DefaultProcessContextImpl<>());

    // Assert
    verify(catalogService).findSkuById(1L);
    assertTrue(actualDetermineSkuResult instanceof SkuImpl);
    Money margin = actualDetermineSkuResult.getMargin();
    Money actualAbsResult = margin.abs();
    assertEquals(margin, actualAbsResult);
    Money actualZeroResult = margin.zero();
    assertEquals(margin, actualZeroResult);
  }

  /**
   * Test {@link ValidateAddRequestActivity#canSellDefaultSku(Product)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#canSellDefaultSku(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ValidateAddRequestActivity.canSellDefaultSku(Product)"})
  public void testCanSellDefaultSku_givenFalse_thenReturnFalse() {
    // Arrange
    LinkedList<Sku> skuList = new LinkedList<>();
    skuList.add(new SkuImpl());

    Product product = mock(Product.class);
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
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Product} {@link Product#getAdditionalSkus()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#canSellDefaultSku(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ValidateAddRequestActivity.canSellDefaultSku(Product)"})
  public void testCanSellDefaultSku_givenNull_whenProductGetAdditionalSkusReturnNull() {
    // Arrange
    Product product = mock(Product.class);
    when(product.getAdditionalSkus()).thenReturn(null);

    // Act
    boolean actualCanSellDefaultSkuResult = validateAddRequestActivity.canSellDefaultSku(product);

    // Assert
    verify(product).getAdditionalSkus();
    assertTrue(actualCanSellDefaultSkuResult);
  }

  /**
   * Test {@link ValidateAddRequestActivity#canSellDefaultSku(Product)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link Product} {@link Product#getCanSellWithoutOptions()} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#canSellDefaultSku(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ValidateAddRequestActivity.canSellDefaultSku(Product)"})
  public void testCanSellDefaultSku_givenTrue_whenProductGetCanSellWithoutOptionsReturnTrue() {
    // Arrange
    LinkedList<Sku> skuList = new LinkedList<>();
    skuList.add(new SkuImpl());

    Product product = mock(Product.class);
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
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#canSellDefaultSku(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ValidateAddRequestActivity.canSellDefaultSku(Product)"})
  public void testCanSellDefaultSku_thenThrowIllegalArgumentException() {
    // Arrange
    LinkedList<Sku> skuList = new LinkedList<>();
    skuList.add(new SkuImpl());

    Product product = mock(Product.class);
    when(product.getCanSellWithoutOptions()).thenThrow(new IllegalArgumentException());
    when(product.getAdditionalSkus()).thenReturn(skuList);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> validateAddRequestActivity.canSellDefaultSku(product));
    verify(product).getAdditionalSkus();
    verify(product).getCanSellWithoutOptions();
  }

  /**
   * Test {@link ValidateAddRequestActivity#canSellDefaultSku(Product)}.
   *
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#canSellDefaultSku(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ValidateAddRequestActivity.canSellDefaultSku(Product)"})
  public void testCanSellDefaultSku_whenProductBundleImpl_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(validateAddRequestActivity.canSellDefaultSku(new ProductBundleImpl()));
  }

  /**
   * Test {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product,
   * CartOperationRequest)}.
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO,
   * Product, CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ValidateAddRequestActivity.addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)"
  })
  public void testAddSkuToCart() {
    // Arrange
    NonDiscreteOrderItemRequestDTO orderItemRequestDTO =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    orderItemRequestDTO.setItemName(null);
    orderItemRequestDTO.setOverrideRetailPrice(null);
    orderItemRequestDTO.setOverrideSalePrice(null);
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> validateAddRequestActivity.addSkuToCart(null, orderItemRequestDTO, null, request));
  }

  /**
   * Test {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product,
   * CartOperationRequest)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO,
   * Product, CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ValidateAddRequestActivity.addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)"
  })
  public void testAddSkuToCart_givenEmptyString() {
    // Arrange
    NonDiscreteOrderItemRequestDTO orderItemRequestDTO =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    orderItemRequestDTO.setItemName("");
    orderItemRequestDTO.setOverrideRetailPrice(null);
    orderItemRequestDTO.setOverrideSalePrice(null);
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> validateAddRequestActivity.addSkuToCart(null, orderItemRequestDTO, null, request));
  }

  /**
   * Test {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product,
   * CartOperationRequest)}.
   *
   * <ul>
   *   <li>Given {@code Order Item Request DTO}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO,
   * Product, CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ValidateAddRequestActivity.addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)"
  })
  public void testAddSkuToCart_givenOrderItemRequestDto() {
    // Arrange
    NonDiscreteOrderItemRequestDTO orderItemRequestDTO =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    orderItemRequestDTO.setItemName("Order Item Request DTO");
    orderItemRequestDTO.setOverrideRetailPrice(null);
    orderItemRequestDTO.setOverrideSalePrice(null);
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> validateAddRequestActivity.addSkuToCart(null, orderItemRequestDTO, null, request));
  }

  /**
   * Test {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product,
   * CartOperationRequest)}.
   *
   * <ul>
   *   <li>Given space.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO,
   * Product, CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ValidateAddRequestActivity.addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)"
  })
  public void testAddSkuToCart_givenSpace() {
    // Arrange
    NonDiscreteOrderItemRequestDTO orderItemRequestDTO =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    orderItemRequestDTO.setItemName(" ");
    orderItemRequestDTO.setOverrideRetailPrice(null);
    orderItemRequestDTO.setOverrideSalePrice(null);
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> validateAddRequestActivity.addSkuToCart(null, orderItemRequestDTO, null, request));
  }

  /**
   * Test {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product,
   * CartOperationRequest)}.
   *
   * <ul>
   *   <li>When {@link OrderItemRequestDTO#OrderItemRequestDTO()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO,
   * Product, CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ValidateAddRequestActivity.addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)"
  })
  public void testAddSkuToCart_whenOrderItemRequestDTO_thenThrowIllegalArgumentException() {
    // Arrange
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    ProductBundleImpl product = new ProductBundleImpl();
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> validateAddRequestActivity.addSkuToCart(null, orderItemRequestDTO, product, request));
  }

  /**
   * Test {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO, Product,
   * CartOperationRequest)}.
   *
   * <ul>
   *   <li>When {@link SkuImpl} (default constructor).
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAddRequestActivity#addSkuToCart(Sku, OrderItemRequestDTO,
   * Product, CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ValidateAddRequestActivity.addSkuToCart(Sku, OrderItemRequestDTO, Product, CartOperationRequest)"
  })
  public void testAddSkuToCart_whenSkuImpl_thenThrowIllegalArgumentException() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    ProductBundleImpl product = new ProductBundleImpl();
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest request = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> validateAddRequestActivity.addSkuToCart(sku, orderItemRequestDTO, product, request));
  }
}

package org.broadleafcommerce.core.order.service.workflow.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.ProductOption;
import org.broadleafcommerce.core.catalog.domain.ProductOptionImpl;
import org.broadleafcommerce.core.catalog.domain.ProductOptionXref;
import org.broadleafcommerce.core.catalog.domain.ProductOptionXrefImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.catalog.service.CatalogService;
import org.broadleafcommerce.core.order.service.ProductOptionValidationService;
import org.broadleafcommerce.core.order.service.call.NonDiscreteOrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.exception.RequiredAttributeNotProvidedException;
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
public class OrderItemRequestValidationServiceImplDiffblueTest {
  @Mock private CatalogService catalogService;

  @InjectMocks private OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl;

  @Mock private ProductOptionValidationService productOptionValidationService;

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#determineProduct(OrderItemRequestDTO)}.
   *
   * <p>Method under test: {@link
   * OrderItemRequestValidationServiceImpl#determineProduct(OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Product OrderItemRequestValidationServiceImpl.determineProduct(OrderItemRequestDTO)"
  })
  public void testDetermineProduct() {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());

    NonDiscreteOrderItemRequestDTO orderItemRequestDTO =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    orderItemRequestDTO.setProductId(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> orderItemRequestValidationServiceImpl.determineProduct(orderItemRequestDTO));
    verify(catalogService).findProductById(1L);
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#determineProduct(OrderItemRequestDTO)}.
   *
   * <ul>
   *   <li>Given {@link CatalogService} {@link CatalogService#findProductById(Long)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderItemRequestValidationServiceImpl#determineProduct(OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Product OrderItemRequestValidationServiceImpl.determineProduct(OrderItemRequestDTO)"
  })
  public void testDetermineProduct_givenCatalogServiceFindProductByIdReturnNull() {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(null);

    NonDiscreteOrderItemRequestDTO orderItemRequestDTO =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    orderItemRequestDTO.setProductId(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> orderItemRequestValidationServiceImpl.determineProduct(orderItemRequestDTO));
    verify(catalogService).findProductById(1L);
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#determineProduct(OrderItemRequestDTO)}.
   *
   * <ul>
   *   <li>Given {@link OrderItemRequestValidationServiceImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderItemRequestValidationServiceImpl#determineProduct(OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Product OrderItemRequestValidationServiceImpl.determineProduct(OrderItemRequestDTO)"
  })
  public void testDetermineProduct_givenOrderItemRequestValidationServiceImpl_thenReturnNull() {
    // Arrange
    OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl =
        new OrderItemRequestValidationServiceImpl();

    // Act and Assert
    assertNull(orderItemRequestValidationServiceImpl.determineProduct(new OrderItemRequestDTO()));
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#determineProduct(OrderItemRequestDTO)}.
   *
   * <ul>
   *   <li>Then return {@link ProductBundleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderItemRequestValidationServiceImpl#determineProduct(OrderItemRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Product OrderItemRequestValidationServiceImpl.determineProduct(OrderItemRequestDTO)"
  })
  public void testDetermineProduct_thenReturnProductBundleImpl() {
    // Arrange
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(productBundleImpl);

    NonDiscreteOrderItemRequestDTO orderItemRequestDTO =
        new NonDiscreteOrderItemRequestDTO("Item Name", 1, new Money());
    orderItemRequestDTO.setProductId(1L);

    // Act
    Product actualDetermineProductResult =
        orderItemRequestValidationServiceImpl.determineProduct(orderItemRequestDTO);

    // Assert
    verify(catalogService).findProductById(1L);
    assertSame(productBundleImpl, actualDetermineProductResult);
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#determineSku(OrderItemRequestDTO,
   * ActivityMessages)} with {@code orderItemRequestDTO}, {@code messages}.
   *
   * <p>Method under test: {@link
   * OrderItemRequestValidationServiceImpl#determineSku(OrderItemRequestDTO, ActivityMessages)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Sku OrderItemRequestValidationServiceImpl.determineSku(OrderItemRequestDTO, ActivityMessages)"
  })
  public void testDetermineSkuWithOrderItemRequestDTOMessages()
      throws RequiredAttributeNotProvidedException {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO(1L, 1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            orderItemRequestValidationServiceImpl.determineSku(
                orderItemRequestDTO, new DefaultProcessContextImpl<>()));
    verify(catalogService).findProductById(1L);
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#determineSku(OrderItemRequestDTO,
   * ActivityMessages)} with {@code orderItemRequestDTO}, {@code messages}.
   *
   * <p>Method under test: {@link
   * OrderItemRequestValidationServiceImpl#determineSku(OrderItemRequestDTO, ActivityMessages)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Sku OrderItemRequestValidationServiceImpl.determineSku(OrderItemRequestDTO, ActivityMessages)"
  })
  public void testDetermineSkuWithOrderItemRequestDTOMessages2()
      throws RequiredAttributeNotProvidedException {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(null);
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO(1L, 1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            orderItemRequestValidationServiceImpl.determineSku(
                orderItemRequestDTO, new DefaultProcessContextImpl<>()));
    verify(catalogService).findProductById(1L);
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#canSellDefaultSku(Product)}.
   *
   * <ul>
   *   <li>Given {@link OrderItemRequestValidationServiceImpl} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemRequestValidationServiceImpl#canSellDefaultSku(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemRequestValidationServiceImpl.canSellDefaultSku(Product)"})
  public void testCanSellDefaultSku_givenOrderItemRequestValidationServiceImpl_thenReturnTrue() {
    // Arrange
    OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl =
        new OrderItemRequestValidationServiceImpl();

    // Act and Assert
    assertTrue(orderItemRequestValidationServiceImpl.canSellDefaultSku(new ProductBundleImpl()));
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map)} with {@code
   * product}, {@code attributeValuesForSku}.
   *
   * <p>Method under test: {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product,
   * Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Sku OrderItemRequestValidationServiceImpl.findMatchingSku(Product, Map)"})
  public void testFindMatchingSkuWithProductAttributeValuesForSku() {
    // Arrange
    OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl =
        new OrderItemRequestValidationServiceImpl();
    ProductBundleImpl product = new ProductBundleImpl();

    // Act and Assert
    assertNull(orderItemRequestValidationServiceImpl.findMatchingSku(product, new HashMap<>()));
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map)} with {@code
   * product}, {@code attributeValuesForSku}.
   *
   * <p>Method under test: {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product,
   * Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Sku OrderItemRequestValidationServiceImpl.findMatchingSku(Product, Map)"})
  public void testFindMatchingSkuWithProductAttributeValuesForSku2() {
    // Arrange
    when(productOptionValidationService.findSkuIdsForProductOptionValues(
            Mockito.<Long>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<Long>>any()))
        .thenThrow(new IllegalArgumentException());
    ProductBundleImpl product = new ProductBundleImpl();

    HashMap<String, String> attributeValuesForSku = new HashMap<>();
    attributeValuesForSku.put("foo", "foo");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            orderItemRequestValidationServiceImpl.findMatchingSku(product, attributeValuesForSku));
    verify(productOptionValidationService)
        .findSkuIdsForProductOptionValues(isNull(), eq("foo"), eq("foo"), isA(List.class));
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map)} with {@code
   * product}, {@code attributeValuesForSku}.
   *
   * <p>Method under test: {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product,
   * Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Sku OrderItemRequestValidationServiceImpl.findMatchingSku(Product, Map)"})
  public void testFindMatchingSkuWithProductAttributeValuesForSku3() {
    // Arrange
    when(catalogService.findSkuById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException());

    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(1L);
    when(productOptionValidationService.findSkuIdsForProductOptionValues(
            Mockito.<Long>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(resultLongList);
    ProductBundleImpl product = new ProductBundleImpl();

    HashMap<String, String> attributeValuesForSku = new HashMap<>();
    attributeValuesForSku.put("foo", "foo");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            orderItemRequestValidationServiceImpl.findMatchingSku(product, attributeValuesForSku));
    verify(catalogService).findSkuById(1L);
    verify(productOptionValidationService)
        .findSkuIdsForProductOptionValues(isNull(), eq("foo"), eq("foo"), isA(List.class));
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map)} with {@code
   * product}, {@code attributeValuesForSku}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product,
   * Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Sku OrderItemRequestValidationServiceImpl.findMatchingSku(Product, Map)"})
  public void testFindMatchingSkuWithProductAttributeValuesForSku_thenReturnNull() {
    // Arrange
    when(productOptionValidationService.findSkuIdsForProductOptionValues(
            Mockito.<Long>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(new ArrayList<>());
    ProductBundleImpl product = new ProductBundleImpl();

    HashMap<String, String> attributeValuesForSku = new HashMap<>();
    attributeValuesForSku.put("foo", "foo");

    // Act
    Sku actualFindMatchingSkuResult =
        orderItemRequestValidationServiceImpl.findMatchingSku(product, attributeValuesForSku);

    // Assert
    verify(productOptionValidationService)
        .findSkuIdsForProductOptionValues(isNull(), eq("foo"), eq("foo"), isA(List.class));
    assertNull(actualFindMatchingSkuResult);
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map)} with {@code
   * product}, {@code attributeValuesForSku}.
   *
   * <ul>
   *   <li>Then return {@link SkuImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product,
   * Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Sku OrderItemRequestValidationServiceImpl.findMatchingSku(Product, Map)"})
  public void testFindMatchingSkuWithProductAttributeValuesForSku_thenReturnSkuImpl() {
    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    when(catalogService.findSkuById(Mockito.<Long>any())).thenReturn(skuImpl);

    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(1L);
    when(productOptionValidationService.findSkuIdsForProductOptionValues(
            Mockito.<Long>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(resultLongList);
    ProductBundleImpl product = new ProductBundleImpl();

    HashMap<String, String> attributeValuesForSku = new HashMap<>();
    attributeValuesForSku.put("foo", "foo");

    // Act
    Sku actualFindMatchingSkuResult =
        orderItemRequestValidationServiceImpl.findMatchingSku(product, attributeValuesForSku);

    // Assert
    verify(catalogService).findSkuById(1L);
    verify(productOptionValidationService)
        .findSkuIdsForProductOptionValues(isNull(), eq("foo"), eq("foo"), isA(List.class));
    assertSame(skuImpl, actualFindMatchingSkuResult);
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map,
   * ActivityMessages)} with {@code product}, {@code attributeValues}, {@code messages}.
   *
   * <p>Method under test: {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product,
   * Map, ActivityMessages)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Sku OrderItemRequestValidationServiceImpl.findMatchingSku(Product, Map, ActivityMessages)"
  })
  public void testFindMatchingSkuWithProductAttributeValuesMessages()
      throws RequiredAttributeNotProvidedException {
    // Arrange
    when(productOptionValidationService.hasProductOptionValidationStrategy(
            Mockito.<ProductOption>any()))
        .thenThrow(new IllegalArgumentException());

    ProductOptionImpl productOptionImpl = mock(ProductOptionImpl.class);
    when(productOptionImpl.getRequired()).thenReturn(true);
    when(productOptionImpl.getAttributeName()).thenReturn("Attribute Name");

    ProductOptionXrefImpl productOptionXrefImpl = mock(ProductOptionXrefImpl.class);
    when(productOptionXrefImpl.getProductOption()).thenReturn(productOptionImpl);

    ArrayList<ProductOptionXref> productOptions = new ArrayList<>();
    productOptions.add(productOptionXrefImpl);

    ProductBundleImpl product = new ProductBundleImpl();
    product.setProductOptionXrefs(productOptions);
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            orderItemRequestValidationServiceImpl.findMatchingSku(
                product, attributeValues, new DefaultProcessContextImpl<>()));
    verify(productOptionImpl).getAttributeName();
    verify(productOptionImpl).getRequired();
    verify(productOptionXrefImpl).getProductOption();
    verify(productOptionValidationService)
        .hasProductOptionValidationStrategy(isA(ProductOption.class));
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map,
   * ActivityMessages)} with {@code product}, {@code attributeValues}, {@code messages}.
   *
   * <p>Method under test: {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product,
   * Map, ActivityMessages)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Sku OrderItemRequestValidationServiceImpl.findMatchingSku(Product, Map, ActivityMessages)"
  })
  public void testFindMatchingSkuWithProductAttributeValuesMessages2()
      throws RequiredAttributeNotProvidedException {
    // Arrange
    when(catalogService.findSkuById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException());

    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(1L);
    when(productOptionValidationService.hasProductOptionValidationStrategy(
            Mockito.<ProductOption>any()))
        .thenReturn(true);
    when(productOptionValidationService.isAddOrNoneType(Mockito.<ProductOption>any()))
        .thenReturn(true);
    when(productOptionValidationService.validate(
            Mockito.<ProductOption>any(), Mockito.<String>any()))
        .thenReturn(true);
    when(productOptionValidationService.findSkuIdsForProductOptionValues(
            Mockito.<Long>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(resultLongList);

    ProductOptionImpl productOptionImpl = mock(ProductOptionImpl.class);
    when(productOptionImpl.getRequired()).thenReturn(true);
    when(productOptionImpl.getUseInSkuGeneration()).thenReturn(true);
    when(productOptionImpl.getAttributeName()).thenReturn("Attribute Name");

    ProductOptionXrefImpl productOptionXrefImpl = mock(ProductOptionXrefImpl.class);
    when(productOptionXrefImpl.getProductOption()).thenReturn(productOptionImpl);

    ArrayList<ProductOptionXref> productOptions = new ArrayList<>();
    productOptions.add(productOptionXrefImpl);

    ProductBundleImpl product = new ProductBundleImpl();
    product.setProductOptionXrefs(productOptions);
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            orderItemRequestValidationServiceImpl.findMatchingSku(
                product, attributeValues, new DefaultProcessContextImpl<>()));
    verify(productOptionImpl).getAttributeName();
    verify(productOptionImpl).getRequired();
    verify(productOptionImpl).getUseInSkuGeneration();
    verify(productOptionXrefImpl).getProductOption();
    verify(catalogService).findSkuById(1L);
    verify(productOptionValidationService)
        .findSkuIdsForProductOptionValues(
            isNull(), eq("Attribute Name"), isNull(), isA(List.class));
    verify(productOptionValidationService)
        .hasProductOptionValidationStrategy(isA(ProductOption.class));
    verify(productOptionValidationService).isAddOrNoneType(isA(ProductOption.class));
    verify(productOptionValidationService).validate(isA(ProductOption.class), isNull());
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map,
   * ActivityMessages)} with {@code product}, {@code attributeValues}, {@code messages}.
   *
   * <p>Method under test: {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product,
   * Map, ActivityMessages)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Sku OrderItemRequestValidationServiceImpl.findMatchingSku(Product, Map, ActivityMessages)"
  })
  public void testFindMatchingSkuWithProductAttributeValuesMessages3()
      throws RequiredAttributeNotProvidedException {
    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    when(catalogService.findSkuById(Mockito.<Long>any())).thenReturn(skuImpl);

    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(1L);
    when(productOptionValidationService.hasProductOptionValidationStrategy(
            Mockito.<ProductOption>any()))
        .thenReturn(false);
    when(productOptionValidationService.isAddOrNoneType(Mockito.<ProductOption>any()))
        .thenReturn(true);
    when(productOptionValidationService.validate(
            Mockito.<ProductOption>any(), Mockito.<String>any()))
        .thenReturn(true);
    when(productOptionValidationService.findSkuIdsForProductOptionValues(
            Mockito.<Long>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(resultLongList);

    ProductOptionImpl productOptionImpl = mock(ProductOptionImpl.class);
    when(productOptionImpl.getRequired()).thenReturn(true);
    when(productOptionImpl.getUseInSkuGeneration()).thenReturn(true);
    when(productOptionImpl.getAttributeName()).thenReturn("Attribute Name");

    ProductOptionXrefImpl productOptionXrefImpl = mock(ProductOptionXrefImpl.class);
    when(productOptionXrefImpl.getProductOption()).thenReturn(productOptionImpl);

    ArrayList<ProductOptionXref> productOptions = new ArrayList<>();
    productOptions.add(productOptionXrefImpl);

    ProductBundleImpl product = new ProductBundleImpl();
    product.setProductOptionXrefs(productOptions);
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act
    Sku actualFindMatchingSkuResult =
        orderItemRequestValidationServiceImpl.findMatchingSku(
            product, attributeValues, new DefaultProcessContextImpl<>());

    // Assert
    verify(productOptionImpl).getAttributeName();
    verify(productOptionImpl).getRequired();
    verify(productOptionImpl).getUseInSkuGeneration();
    verify(productOptionXrefImpl).getProductOption();
    verify(catalogService).findSkuById(1L);
    verify(productOptionValidationService)
        .findSkuIdsForProductOptionValues(
            isNull(), eq("Attribute Name"), isNull(), isA(List.class));
    verify(productOptionValidationService)
        .hasProductOptionValidationStrategy(isA(ProductOption.class));
    verify(productOptionValidationService).isAddOrNoneType(isA(ProductOption.class));
    verify(productOptionValidationService).validate(isA(ProductOption.class), isNull());
    assertSame(skuImpl, actualFindMatchingSkuResult);
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map,
   * ActivityMessages)} with {@code product}, {@code attributeValues}, {@code messages}.
   *
   * <p>Method under test: {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product,
   * Map, ActivityMessages)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Sku OrderItemRequestValidationServiceImpl.findMatchingSku(Product, Map, ActivityMessages)"
  })
  public void testFindMatchingSkuWithProductAttributeValuesMessages4()
      throws RequiredAttributeNotProvidedException {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(productOptionValidationService)
        .validateWithoutException(
            Mockito.<ProductOption>any(), Mockito.<String>any(), Mockito.<ActivityMessages>any());
    when(productOptionValidationService.hasProductOptionValidationStrategy(
            Mockito.<ProductOption>any()))
        .thenReturn(true);
    when(productOptionValidationService.isAddOrNoneType(Mockito.<ProductOption>any()))
        .thenReturn(false);

    ProductOptionImpl productOptionImpl = mock(ProductOptionImpl.class);
    when(productOptionImpl.getRequired()).thenReturn(true);
    when(productOptionImpl.getAttributeName()).thenReturn("Attribute Name");

    ProductOptionXrefImpl productOptionXrefImpl = mock(ProductOptionXrefImpl.class);
    when(productOptionXrefImpl.getProductOption()).thenReturn(productOptionImpl);

    ArrayList<ProductOptionXref> productOptions = new ArrayList<>();
    productOptions.add(productOptionXrefImpl);

    ProductBundleImpl product = new ProductBundleImpl();
    product.setProductOptionXrefs(productOptions);
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            orderItemRequestValidationServiceImpl.findMatchingSku(
                product, attributeValues, new DefaultProcessContextImpl<>()));
    verify(productOptionImpl).getAttributeName();
    verify(productOptionImpl).getRequired();
    verify(productOptionXrefImpl).getProductOption();
    verify(productOptionValidationService)
        .hasProductOptionValidationStrategy(isA(ProductOption.class));
    verify(productOptionValidationService).isAddOrNoneType(isA(ProductOption.class));
    verify(productOptionValidationService)
        .validateWithoutException(isA(ProductOption.class), isNull(), isA(ActivityMessages.class));
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map,
   * ActivityMessages)} with {@code product}, {@code attributeValues}, {@code messages}.
   *
   * <p>Method under test: {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product,
   * Map, ActivityMessages)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Sku OrderItemRequestValidationServiceImpl.findMatchingSku(Product, Map, ActivityMessages)"
  })
  public void testFindMatchingSkuWithProductAttributeValuesMessages5()
      throws RequiredAttributeNotProvidedException {
    // Arrange
    doNothing()
        .when(productOptionValidationService)
        .validateWithoutException(
            Mockito.<ProductOption>any(), Mockito.<String>any(), Mockito.<ActivityMessages>any());
    when(productOptionValidationService.hasProductOptionValidationStrategy(
            Mockito.<ProductOption>any()))
        .thenReturn(true);
    when(productOptionValidationService.isAddOrNoneType(Mockito.<ProductOption>any()))
        .thenReturn(false);

    ProductOptionImpl productOptionImpl = mock(ProductOptionImpl.class);
    when(productOptionImpl.getRequired()).thenReturn(true);
    when(productOptionImpl.getUseInSkuGeneration()).thenReturn(false);
    when(productOptionImpl.getAttributeName()).thenReturn("Attribute Name");

    ProductOptionXrefImpl productOptionXrefImpl = mock(ProductOptionXrefImpl.class);
    when(productOptionXrefImpl.getProductOption()).thenReturn(productOptionImpl);

    ArrayList<ProductOptionXref> productOptions = new ArrayList<>();
    productOptions.add(productOptionXrefImpl);

    ProductBundleImpl product = new ProductBundleImpl();
    product.setProductOptionXrefs(productOptions);
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act
    Sku actualFindMatchingSkuResult =
        orderItemRequestValidationServiceImpl.findMatchingSku(
            product, attributeValues, new DefaultProcessContextImpl<>());

    // Assert
    verify(productOptionImpl).getAttributeName();
    verify(productOptionImpl).getRequired();
    verify(productOptionImpl).getUseInSkuGeneration();
    verify(productOptionXrefImpl).getProductOption();
    verify(productOptionValidationService)
        .hasProductOptionValidationStrategy(isA(ProductOption.class));
    verify(productOptionValidationService).isAddOrNoneType(isA(ProductOption.class));
    verify(productOptionValidationService)
        .validateWithoutException(isA(ProductOption.class), isNull(), isA(ActivityMessages.class));
    assertNull(actualFindMatchingSkuResult);
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map,
   * ActivityMessages)} with {@code product}, {@code attributeValues}, {@code messages}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product,
   * Map, ActivityMessages)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Sku OrderItemRequestValidationServiceImpl.findMatchingSku(Product, Map, ActivityMessages)"
  })
  public void testFindMatchingSkuWithProductAttributeValuesMessages_thenReturnNull()
      throws RequiredAttributeNotProvidedException {
    // Arrange
    when(productOptionValidationService.hasProductOptionValidationStrategy(
            Mockito.<ProductOption>any()))
        .thenReturn(true);
    when(productOptionValidationService.isAddOrNoneType(Mockito.<ProductOption>any()))
        .thenReturn(true);
    when(productOptionValidationService.validate(
            Mockito.<ProductOption>any(), Mockito.<String>any()))
        .thenReturn(true);
    when(productOptionValidationService.findSkuIdsForProductOptionValues(
            Mockito.<Long>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(new ArrayList<>());

    ProductOptionImpl productOptionImpl = mock(ProductOptionImpl.class);
    when(productOptionImpl.getRequired()).thenReturn(true);
    when(productOptionImpl.getUseInSkuGeneration()).thenReturn(true);
    when(productOptionImpl.getAttributeName()).thenReturn("Attribute Name");

    ProductOptionXrefImpl productOptionXrefImpl = mock(ProductOptionXrefImpl.class);
    when(productOptionXrefImpl.getProductOption()).thenReturn(productOptionImpl);

    ArrayList<ProductOptionXref> productOptions = new ArrayList<>();
    productOptions.add(productOptionXrefImpl);

    ProductBundleImpl product = new ProductBundleImpl();
    product.setProductOptionXrefs(productOptions);
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act
    Sku actualFindMatchingSkuResult =
        orderItemRequestValidationServiceImpl.findMatchingSku(
            product, attributeValues, new DefaultProcessContextImpl<>());

    // Assert
    verify(productOptionImpl).getAttributeName();
    verify(productOptionImpl).getRequired();
    verify(productOptionImpl).getUseInSkuGeneration();
    verify(productOptionXrefImpl).getProductOption();
    verify(productOptionValidationService)
        .findSkuIdsForProductOptionValues(
            isNull(), eq("Attribute Name"), isNull(), isA(List.class));
    verify(productOptionValidationService)
        .hasProductOptionValidationStrategy(isA(ProductOption.class));
    verify(productOptionValidationService).isAddOrNoneType(isA(ProductOption.class));
    verify(productOptionValidationService).validate(isA(ProductOption.class), isNull());
    assertNull(actualFindMatchingSkuResult);
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map,
   * ActivityMessages)} with {@code product}, {@code attributeValues}, {@code messages}.
   *
   * <ul>
   *   <li>Then return {@link SkuImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product,
   * Map, ActivityMessages)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Sku OrderItemRequestValidationServiceImpl.findMatchingSku(Product, Map, ActivityMessages)"
  })
  public void testFindMatchingSkuWithProductAttributeValuesMessages_thenReturnSkuImpl()
      throws RequiredAttributeNotProvidedException {
    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    when(catalogService.findSkuById(Mockito.<Long>any())).thenReturn(skuImpl);

    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(1L);
    when(productOptionValidationService.hasProductOptionValidationStrategy(
            Mockito.<ProductOption>any()))
        .thenReturn(true);
    when(productOptionValidationService.isAddOrNoneType(Mockito.<ProductOption>any()))
        .thenReturn(true);
    when(productOptionValidationService.validate(
            Mockito.<ProductOption>any(), Mockito.<String>any()))
        .thenReturn(true);
    when(productOptionValidationService.findSkuIdsForProductOptionValues(
            Mockito.<Long>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(resultLongList);

    ProductOptionImpl productOptionImpl = mock(ProductOptionImpl.class);
    when(productOptionImpl.getRequired()).thenReturn(true);
    when(productOptionImpl.getUseInSkuGeneration()).thenReturn(true);
    when(productOptionImpl.getAttributeName()).thenReturn("Attribute Name");

    ProductOptionXrefImpl productOptionXrefImpl = mock(ProductOptionXrefImpl.class);
    when(productOptionXrefImpl.getProductOption()).thenReturn(productOptionImpl);

    ArrayList<ProductOptionXref> productOptions = new ArrayList<>();
    productOptions.add(productOptionXrefImpl);

    ProductBundleImpl product = new ProductBundleImpl();
    product.setProductOptionXrefs(productOptions);
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act
    Sku actualFindMatchingSkuResult =
        orderItemRequestValidationServiceImpl.findMatchingSku(
            product, attributeValues, new DefaultProcessContextImpl<>());

    // Assert
    verify(productOptionImpl).getAttributeName();
    verify(productOptionImpl).getRequired();
    verify(productOptionImpl).getUseInSkuGeneration();
    verify(productOptionXrefImpl).getProductOption();
    verify(catalogService).findSkuById(1L);
    verify(productOptionValidationService)
        .findSkuIdsForProductOptionValues(
            isNull(), eq("Attribute Name"), isNull(), isA(List.class));
    verify(productOptionValidationService)
        .hasProductOptionValidationStrategy(isA(ProductOption.class));
    verify(productOptionValidationService).isAddOrNoneType(isA(ProductOption.class));
    verify(productOptionValidationService).validate(isA(ProductOption.class), isNull());
    assertSame(skuImpl, actualFindMatchingSkuResult);
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map,
   * ActivityMessages)} with {@code product}, {@code attributeValues}, {@code messages}.
   *
   * <ul>
   *   <li>Then return {@link SkuImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product,
   * Map, ActivityMessages)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Sku OrderItemRequestValidationServiceImpl.findMatchingSku(Product, Map, ActivityMessages)"
  })
  public void testFindMatchingSkuWithProductAttributeValuesMessages_thenReturnSkuImpl2()
      throws RequiredAttributeNotProvidedException {
    // Arrange
    SkuImpl skuImpl = new SkuImpl();
    when(catalogService.findSkuById(Mockito.<Long>any())).thenReturn(skuImpl);

    ArrayList<Long> resultLongList = new ArrayList<>();
    resultLongList.add(1L);
    doNothing()
        .when(productOptionValidationService)
        .validateWithoutException(
            Mockito.<ProductOption>any(), Mockito.<String>any(), Mockito.<ActivityMessages>any());
    when(productOptionValidationService.hasProductOptionValidationStrategy(
            Mockito.<ProductOption>any()))
        .thenReturn(true);
    when(productOptionValidationService.isAddOrNoneType(Mockito.<ProductOption>any()))
        .thenReturn(false);
    when(productOptionValidationService.findSkuIdsForProductOptionValues(
            Mockito.<Long>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<List<Long>>any()))
        .thenReturn(resultLongList);

    ProductOptionImpl productOptionImpl = mock(ProductOptionImpl.class);
    when(productOptionImpl.getRequired()).thenReturn(true);
    when(productOptionImpl.getUseInSkuGeneration()).thenReturn(true);
    when(productOptionImpl.getAttributeName()).thenReturn("Attribute Name");

    ProductOptionXrefImpl productOptionXrefImpl = mock(ProductOptionXrefImpl.class);
    when(productOptionXrefImpl.getProductOption()).thenReturn(productOptionImpl);

    ArrayList<ProductOptionXref> productOptions = new ArrayList<>();
    productOptions.add(productOptionXrefImpl);

    ProductBundleImpl product = new ProductBundleImpl();
    product.setProductOptionXrefs(productOptions);
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act
    Sku actualFindMatchingSkuResult =
        orderItemRequestValidationServiceImpl.findMatchingSku(
            product, attributeValues, new DefaultProcessContextImpl<>());

    // Assert
    verify(productOptionImpl).getAttributeName();
    verify(productOptionImpl).getRequired();
    verify(productOptionImpl).getUseInSkuGeneration();
    verify(productOptionXrefImpl).getProductOption();
    verify(catalogService).findSkuById(1L);
    verify(productOptionValidationService)
        .findSkuIdsForProductOptionValues(
            isNull(), eq("Attribute Name"), isNull(), isA(List.class));
    verify(productOptionValidationService)
        .hasProductOptionValidationStrategy(isA(ProductOption.class));
    verify(productOptionValidationService).isAddOrNoneType(isA(ProductOption.class));
    verify(productOptionValidationService)
        .validateWithoutException(isA(ProductOption.class), isNull(), isA(ActivityMessages.class));
    assertSame(skuImpl, actualFindMatchingSkuResult);
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map,
   * ActivityMessages)} with {@code product}, {@code attributeValues}, {@code messages}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product,
   * Map, ActivityMessages)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Sku OrderItemRequestValidationServiceImpl.findMatchingSku(Product, Map, ActivityMessages)"
  })
  public void testFindMatchingSkuWithProductAttributeValuesMessages_whenNull()
      throws RequiredAttributeNotProvidedException {
    // Arrange
    OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl =
        new OrderItemRequestValidationServiceImpl();
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act and Assert
    assertNull(
        orderItemRequestValidationServiceImpl.findMatchingSku(
            null, attributeValues, new DefaultProcessContextImpl<>()));
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product, Map,
   * ActivityMessages)} with {@code product}, {@code attributeValues}, {@code messages}.
   *
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderItemRequestValidationServiceImpl#findMatchingSku(Product,
   * Map, ActivityMessages)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Sku OrderItemRequestValidationServiceImpl.findMatchingSku(Product, Map, ActivityMessages)"
  })
  public void testFindMatchingSkuWithProductAttributeValuesMessages_whenProductBundleImpl()
      throws RequiredAttributeNotProvidedException {
    // Arrange
    OrderItemRequestValidationServiceImpl orderItemRequestValidationServiceImpl =
        new OrderItemRequestValidationServiceImpl();
    ProductBundleImpl product = new ProductBundleImpl();
    HashMap<String, String> attributeValues = new HashMap<>();

    // Act and Assert
    assertNull(
        orderItemRequestValidationServiceImpl.findMatchingSku(
            product, attributeValues, new DefaultProcessContextImpl<>()));
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#shouldValidateWithException(boolean, boolean,
   * String, boolean)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderItemRequestValidationServiceImpl#shouldValidateWithException(boolean, boolean, String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemRequestValidationServiceImpl.shouldValidateWithException(boolean, boolean, String, boolean)"
  })
  public void testShouldValidateWithException_whenEmptyString_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        new OrderItemRequestValidationServiceImpl()
            .shouldValidateWithException(false, false, "", false));
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#shouldValidateWithException(boolean, boolean,
   * String, boolean)}.
   *
   * <ul>
   *   <li>When {@code not empty}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderItemRequestValidationServiceImpl#shouldValidateWithException(boolean, boolean, String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemRequestValidationServiceImpl.shouldValidateWithException(boolean, boolean, String, boolean)"
  })
  public void testShouldValidateWithException_whenNotEmpty_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new OrderItemRequestValidationServiceImpl()
            .shouldValidateWithException(false, false, "not empty", false));
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#shouldValidateWithException(boolean, boolean,
   * String, boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderItemRequestValidationServiceImpl#shouldValidateWithException(boolean, boolean, String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemRequestValidationServiceImpl.shouldValidateWithException(boolean, boolean, String, boolean)"
  })
  public void testShouldValidateWithException_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        new OrderItemRequestValidationServiceImpl()
            .shouldValidateWithException(false, false, null, false));
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#shouldValidateWithException(boolean, boolean,
   * String, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderItemRequestValidationServiceImpl#shouldValidateWithException(boolean, boolean, String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemRequestValidationServiceImpl.shouldValidateWithException(boolean, boolean, String, boolean)"
  })
  public void testShouldValidateWithException_whenTrue_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        new OrderItemRequestValidationServiceImpl()
            .shouldValidateWithException(true, false, "0123456789ABCDEF", true));
  }

  /**
   * Test {@link OrderItemRequestValidationServiceImpl#shouldValidateWithException(boolean, boolean,
   * String, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderItemRequestValidationServiceImpl#shouldValidateWithException(boolean, boolean, String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemRequestValidationServiceImpl.shouldValidateWithException(boolean, boolean, String, boolean)"
  })
  public void testShouldValidateWithException_whenTrue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new OrderItemRequestValidationServiceImpl()
            .shouldValidateWithException(true, true, "0123456789ABCDEF", true));
  }
}

package org.broadleafcommerce.core.web.processor;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.catalog.service.CatalogService;
import org.broadleafcommerce.core.web.processor.ProductOptionsProcessor.ProductOptionDTO;
import org.broadleafcommerce.core.web.processor.ProductOptionsProcessor.ProductOptionPricingDTO;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProductOptionsProcessorDiffblueTest {
  @Mock private CatalogService catalogService;

  @InjectMocks private ProductOptionsProcessor productOptionsProcessor;

  @Mock private ProductOptionsProcessorExtensionManager productOptionsProcessorExtensionManager;

  /**
   * Test {@link ProductOptionsProcessor#getName()}.
   *
   * <p>Method under test: {@link ProductOptionsProcessor#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductOptionsProcessor.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("product_options", new ProductOptionsProcessor().getName());
  }

  /**
   * Test {@link ProductOptionsProcessor#getPrecedence()}.
   *
   * <p>Method under test: {@link ProductOptionsProcessor#getPrecedence()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ProductOptionsProcessor.getPrecedence()"})
  public void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(10000, new ProductOptionsProcessor().getPrecedence());
  }

  /**
   * Test {@link ProductOptionsProcessor#populateModelVariables(String, Map,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionsProcessor#populateModelVariables(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map ProductOptionsProcessor.populateModelVariables(String, Map, BroadleafTemplateContext)"
  })
  public void testPopulateModelVariables_thenReturnEmpty() {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(null);
    HashMap<String, String> tagAttributes = new HashMap<>();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(1L);

    // Act
    Map<String, Object> actualPopulateModelVariablesResult =
        productOptionsProcessor.populateModelVariables("Tag Name", tagAttributes, context);

    // Assert
    verify(catalogService).findProductById(1L);
    verify(context).parseExpression(null);
    assertTrue(actualPopulateModelVariablesResult.isEmpty());
  }

  /**
   * Test {@link ProductOptionsProcessor#populateModelVariables(String, Map,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionsProcessor#populateModelVariables(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map ProductOptionsProcessor.populateModelVariables(String, Map, BroadleafTemplateContext)"
  })
  public void testPopulateModelVariables_thenReturnSizeIsTwo() {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    HashMap<String, String> tagAttributes = new HashMap<>();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(1L);

    // Act
    Map<String, Object> actualPopulateModelVariablesResult =
        productOptionsProcessor.populateModelVariables("Tag Name", tagAttributes, context);

    // Assert
    verify(catalogService).findProductById(1L);
    verify(context).parseExpression(null);
    assertEquals(2, actualPopulateModelVariablesResult.size());
    assertEquals("[]", actualPopulateModelVariablesResult.get("allProductOptions"));
    assertEquals("[]", actualPopulateModelVariablesResult.get("skuPricing"));
  }

  /**
   * Test {@link ProductOptionsProcessor#addProductOptionPricingToModel(Map, Product,
   * BroadleafTemplateContext, Map)}.
   *
   * <p>Method under test: {@link ProductOptionsProcessor#addProductOptionPricingToModel(Map,
   * Product, BroadleafTemplateContext, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductOptionsProcessor.addProductOptionPricingToModel(Map, Product, BroadleafTemplateContext, Map)"
  })
  public void testAddProductOptionPricingToModel() {
    // Arrange
    ProductOptionsProcessor productOptionsProcessor = new ProductOptionsProcessor();
    HashMap<String, Object> newModelVars = new HashMap<>();
    ProductBundleImpl product = new ProductBundleImpl();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);

    // Act
    productOptionsProcessor.addProductOptionPricingToModel(
        newModelVars, product, context, new HashMap<>());

    // Assert
    assertEquals(1, newModelVars.size());
    assertEquals("[]", newModelVars.get("skuPricing"));
  }

  /**
   * Test {@link ProductOptionsProcessor#addProductOptionPricingToModel(Map, Product,
   * BroadleafTemplateContext, Map)}.
   *
   * <p>Method under test: {@link ProductOptionsProcessor#addProductOptionPricingToModel(Map,
   * Product, BroadleafTemplateContext, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductOptionsProcessor.addProductOptionPricingToModel(Map, Product, BroadleafTemplateContext, Map)"
  })
  public void testAddProductOptionPricingToModel2() {
    // Arrange
    ProductOptionsProcessor productOptionsProcessor = new ProductOptionsProcessor();
    HashMap<String, Object> newModelVars = new HashMap<>();

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(new SkuImpl());

    Product product = mock(Product.class);
    when(product.getSkus()).thenReturn(skuList);
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);

    // Act
    productOptionsProcessor.addProductOptionPricingToModel(
        newModelVars, product, context, new HashMap<>());

    // Assert
    verify(product).getSkus();
    assertEquals(1, newModelVars.size());
    assertEquals(
        "[{\"price\":\"Not Available\",\"onSale\":false}]", newModelVars.get("skuPricing"));
  }

  /**
   * Test {@link ProductOptionsProcessor#addProductOptionPricingToModel(Map, Product,
   * BroadleafTemplateContext, Map)}.
   *
   * <p>Method under test: {@link ProductOptionsProcessor#addProductOptionPricingToModel(Map,
   * Product, BroadleafTemplateContext, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductOptionsProcessor.addProductOptionPricingToModel(Map, Product, BroadleafTemplateContext, Map)"
  })
  public void testAddProductOptionPricingToModel3() {
    // Arrange
    ProductOptionsProcessor productOptionsProcessor = new ProductOptionsProcessor();
    HashMap<String, Object> newModelVars = new HashMap<>();

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.isOnSale()).thenReturn(true);
    when(skuImpl.getProductOptionValueXrefs()).thenReturn(new HashSet<>());
    when(skuImpl.getPrice()).thenReturn(new Money());
    when(skuImpl.getRetailPrice()).thenReturn(new Money());
    when(skuImpl.getSalePrice()).thenReturn(new Money());

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(skuImpl);

    Product product = mock(Product.class);
    when(product.getSkus()).thenReturn(skuList);
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);

    // Act
    productOptionsProcessor.addProductOptionPricingToModel(
        newModelVars, product, context, new HashMap<>());

    // Assert
    verify(product).getSkus();
    verify(skuImpl).getPrice();
    verify(skuImpl).getProductOptionValueXrefs();
    verify(skuImpl, atLeast(1)).getRetailPrice();
    verify(skuImpl, atLeast(1)).getSalePrice();
    verify(skuImpl).isOnSale();
    assertEquals(1, newModelVars.size());
    assertEquals(
        "[{\"price\":\"USD0.00\",\"retailPrice\":\"USD0.00\",\"salePrice\":\"USD0.00\",\"onSale\":true}]",
        newModelVars.get("skuPricing"));
  }

  /**
   * Test {@link ProductOptionsProcessor#addProductOptionPricingToModel(Map, Product,
   * BroadleafTemplateContext, Map)}.
   *
   * <ul>
   *   <li>Then calls {@link ProductOptionsProcessorExtensionManager#getProxy()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionsProcessor#addProductOptionPricingToModel(Map,
   * Product, BroadleafTemplateContext, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductOptionsProcessor.addProductOptionPricingToModel(Map, Product, BroadleafTemplateContext, Map)"
  })
  public void testAddProductOptionPricingToModel_thenCallsGetProxy() {
    // Arrange
    ProductOptionsProcessorExtensionHandler productOptionsProcessorExtensionHandler =
        mock(ProductOptionsProcessorExtensionHandler.class);
    when(productOptionsProcessorExtensionHandler.modifyPriceForOverrides(
            Mockito.<Sku>any(),
            Mockito.<ExtensionResultHolder<Money>>any(),
            Mockito.<BroadleafTemplateContext>any(),
            Mockito.<Map<String, String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(productOptionsProcessorExtensionManager.getProxy())
        .thenReturn(productOptionsProcessorExtensionHandler);
    HashMap<String, Object> newModelVars = new HashMap<>();

    ArrayList<Sku> skuList = new ArrayList<>();
    skuList.add(new SkuImpl());

    Product product = mock(Product.class);
    when(product.getSkus()).thenReturn(skuList);
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);

    // Act
    productOptionsProcessor.addProductOptionPricingToModel(
        newModelVars, product, context, new HashMap<>());

    // Assert
    verify(productOptionsProcessorExtensionManager).getProxy();
    verify(product).getSkus();
    verify(productOptionsProcessorExtensionHandler)
        .modifyPriceForOverrides(
            isA(Sku.class),
            isA(ExtensionResultHolder.class),
            isA(BroadleafTemplateContext.class),
            isA(Map.class));
    assertEquals(1, newModelVars.size());
    assertEquals(
        "[{\"price\":\"Not Available\",\"onSale\":false}]", newModelVars.get("skuPricing"));
  }

  /**
   * Test {@link ProductOptionsProcessor#createPricingDto(Sku, List, Map,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return SelectedOptions is array of {@link Long} with one.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionsProcessor#createPricingDto(Sku, List, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProductOptionPricingDTO ProductOptionsProcessor.createPricingDto(Sku, List, Map, BroadleafTemplateContext)"
  })
  public void testCreatePricingDto_givenOne_thenReturnSelectedOptionsIsArrayOfLongWithOne() {
    // Arrange
    ProductOptionsProcessor productOptionsProcessor = new ProductOptionsProcessor();
    SkuImpl sku = new SkuImpl();

    ArrayList<Long> productOptionValueIds = new ArrayList<>();
    productOptionValueIds.add(1L);

    // Act
    ProductOptionPricingDTO actualCreatePricingDtoResult =
        productOptionsProcessor.createPricingDto(
            sku, productOptionValueIds, new HashMap<>(), mock(BroadleafTemplateContext.class));

    // Assert
    assertEquals("Not Available", actualCreatePricingDtoResult.getPrice());
    assertNull(actualCreatePricingDtoResult.getRetailPrice());
    assertNull(actualCreatePricingDtoResult.getSalePrice());
    assertArrayEquals(new Long[] {1L}, actualCreatePricingDtoResult.getSelectedOptions());
  }

  /**
   * Test {@link ProductOptionsProcessor#createPricingDto(Sku, List, Map,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link Sku} {@link Sku#getPrice()} return {@link Money#Money()}.
   *   <li>Then return OnSale.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionsProcessor#createPricingDto(Sku, List, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProductOptionPricingDTO ProductOptionsProcessor.createPricingDto(Sku, List, Map, BroadleafTemplateContext)"
  })
  public void testCreatePricingDto_givenTrue_whenSkuGetPriceReturnMoney_thenReturnOnSale() {
    // Arrange
    ProductOptionsProcessor productOptionsProcessor = new ProductOptionsProcessor();

    Sku sku = mock(Sku.class);
    when(sku.isOnSale()).thenReturn(true);
    when(sku.getPrice()).thenReturn(new Money());
    when(sku.getRetailPrice()).thenReturn(new Money());
    when(sku.getSalePrice()).thenReturn(new Money());
    ArrayList<Long> productOptionValueIds = new ArrayList<>();

    // Act
    ProductOptionPricingDTO actualCreatePricingDtoResult =
        productOptionsProcessor.createPricingDto(
            sku, productOptionValueIds, new HashMap<>(), mock(BroadleafTemplateContext.class));

    // Assert
    verify(sku).getPrice();
    verify(sku, atLeast(1)).getRetailPrice();
    verify(sku, atLeast(1)).getSalePrice();
    verify(sku).isOnSale();
    assertEquals("USD0.00", actualCreatePricingDtoResult.getPrice());
    assertEquals("USD0.00", actualCreatePricingDtoResult.getRetailPrice());
    assertEquals("USD0.00", actualCreatePricingDtoResult.getSalePrice());
    assertTrue(actualCreatePricingDtoResult.isOnSale());
  }

  /**
   * Test {@link ProductOptionsProcessor#createPricingDto(Sku, List, Map,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then calls {@link ProductOptionsProcessorExtensionManager#getProxy()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionsProcessor#createPricingDto(Sku, List, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProductOptionPricingDTO ProductOptionsProcessor.createPricingDto(Sku, List, Map, BroadleafTemplateContext)"
  })
  public void testCreatePricingDto_thenCallsGetProxy() {
    // Arrange
    ProductOptionsProcessorExtensionHandler productOptionsProcessorExtensionHandler =
        mock(ProductOptionsProcessorExtensionHandler.class);
    when(productOptionsProcessorExtensionHandler.modifyPriceForOverrides(
            Mockito.<Sku>any(),
            Mockito.<ExtensionResultHolder<Money>>any(),
            Mockito.<BroadleafTemplateContext>any(),
            Mockito.<Map<String, String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(productOptionsProcessorExtensionManager.getProxy())
        .thenReturn(productOptionsProcessorExtensionHandler);
    SkuImpl sku = new SkuImpl();
    ArrayList<Long> productOptionValueIds = new ArrayList<>();

    // Act
    ProductOptionPricingDTO actualCreatePricingDtoResult =
        productOptionsProcessor.createPricingDto(
            sku, productOptionValueIds, new HashMap<>(), mock(BroadleafTemplateContext.class));

    // Assert
    verify(productOptionsProcessorExtensionManager).getProxy();
    verify(productOptionsProcessorExtensionHandler)
        .modifyPriceForOverrides(
            isA(Sku.class),
            isA(ExtensionResultHolder.class),
            isA(BroadleafTemplateContext.class),
            isA(Map.class));
    assertEquals("Not Available", actualCreatePricingDtoResult.getPrice());
    assertNull(actualCreatePricingDtoResult.getRetailPrice());
    assertNull(actualCreatePricingDtoResult.getSalePrice());
    assertEquals(0, actualCreatePricingDtoResult.getSelectedOptions().length);
  }

  /**
   * Test {@link ProductOptionsProcessor#createPricingDto(Sku, List, Map,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return SelectedOptions is array of {@link Long} with zero and one.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionsProcessor#createPricingDto(Sku, List, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProductOptionPricingDTO ProductOptionsProcessor.createPricingDto(Sku, List, Map, BroadleafTemplateContext)"
  })
  public void testCreatePricingDto_thenReturnSelectedOptionsIsArrayOfLongWithZeroAndOne() {
    // Arrange
    ProductOptionsProcessor productOptionsProcessor = new ProductOptionsProcessor();
    SkuImpl sku = new SkuImpl();

    ArrayList<Long> productOptionValueIds = new ArrayList<>();
    productOptionValueIds.add(0L);
    productOptionValueIds.add(1L);

    // Act
    ProductOptionPricingDTO actualCreatePricingDtoResult =
        productOptionsProcessor.createPricingDto(
            sku, productOptionValueIds, new HashMap<>(), mock(BroadleafTemplateContext.class));

    // Assert
    assertEquals("Not Available", actualCreatePricingDtoResult.getPrice());
    assertNull(actualCreatePricingDtoResult.getRetailPrice());
    assertNull(actualCreatePricingDtoResult.getSalePrice());
    assertArrayEquals(new Long[] {0L, 1L}, actualCreatePricingDtoResult.getSelectedOptions());
  }

  /**
   * Test {@link ProductOptionsProcessor#createPricingDto(Sku, List, Map,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>When {@link SkuImpl} (default constructor) RetailPrice is {@link Money#Money()}.
   *   <li>Then return Price is {@code USD0.00}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionsProcessor#createPricingDto(Sku, List, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProductOptionPricingDTO ProductOptionsProcessor.createPricingDto(Sku, List, Map, BroadleafTemplateContext)"
  })
  public void testCreatePricingDto_whenSkuImplRetailPriceIsMoney_thenReturnPriceIsUsd000() {
    // Arrange
    ProductOptionsProcessor productOptionsProcessor = new ProductOptionsProcessor();

    SkuImpl sku = new SkuImpl();
    sku.setRetailPrice(new Money());
    ArrayList<Long> productOptionValueIds = new ArrayList<>();

    // Act
    ProductOptionPricingDTO actualCreatePricingDtoResult =
        productOptionsProcessor.createPricingDto(
            sku, productOptionValueIds, new HashMap<>(), mock(BroadleafTemplateContext.class));

    // Assert
    assertEquals("USD0.00", actualCreatePricingDtoResult.getPrice());
    assertEquals("USD0.00", actualCreatePricingDtoResult.getRetailPrice());
    assertNull(actualCreatePricingDtoResult.getSalePrice());
    assertEquals(0, actualCreatePricingDtoResult.getSelectedOptions().length);
  }

  /**
   * Test {@link ProductOptionsProcessor#createPricingDto(Sku, List, Map,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>When {@link SkuImpl} (default constructor) SalePrice is {@link Money#Money()}.
   *   <li>Then return SalePrice is {@code USD0.00}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionsProcessor#createPricingDto(Sku, List, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProductOptionPricingDTO ProductOptionsProcessor.createPricingDto(Sku, List, Map, BroadleafTemplateContext)"
  })
  public void testCreatePricingDto_whenSkuImplSalePriceIsMoney_thenReturnSalePriceIsUsd000() {
    // Arrange
    ProductOptionsProcessor productOptionsProcessor = new ProductOptionsProcessor();

    SkuImpl sku = new SkuImpl();
    sku.setSalePrice(new Money());
    ArrayList<Long> productOptionValueIds = new ArrayList<>();

    // Act
    ProductOptionPricingDTO actualCreatePricingDtoResult =
        productOptionsProcessor.createPricingDto(
            sku, productOptionValueIds, new HashMap<>(), mock(BroadleafTemplateContext.class));

    // Assert
    assertEquals("Not Available", actualCreatePricingDtoResult.getPrice());
    assertEquals("USD0.00", actualCreatePricingDtoResult.getSalePrice());
    assertNull(actualCreatePricingDtoResult.getRetailPrice());
    assertEquals(0, actualCreatePricingDtoResult.getSelectedOptions().length);
  }

  /**
   * Test {@link ProductOptionsProcessor#createPricingDto(Sku, List, Map,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>When {@link SkuImpl} (default constructor).
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionsProcessor#createPricingDto(Sku, List, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProductOptionPricingDTO ProductOptionsProcessor.createPricingDto(Sku, List, Map, BroadleafTemplateContext)"
  })
  public void testCreatePricingDto_whenSkuImpl_thenReturnArrayLengthIsZero() {
    // Arrange
    ProductOptionsProcessor productOptionsProcessor = new ProductOptionsProcessor();
    SkuImpl sku = new SkuImpl();
    ArrayList<Long> productOptionValueIds = new ArrayList<>();

    // Act
    ProductOptionPricingDTO actualCreatePricingDtoResult =
        productOptionsProcessor.createPricingDto(
            sku, productOptionValueIds, new HashMap<>(), mock(BroadleafTemplateContext.class));

    // Assert
    assertEquals("Not Available", actualCreatePricingDtoResult.getPrice());
    assertNull(actualCreatePricingDtoResult.getRetailPrice());
    assertNull(actualCreatePricingDtoResult.getSalePrice());
    assertEquals(0, actualCreatePricingDtoResult.getSelectedOptions().length);
  }

  /**
   * Test {@link ProductOptionsProcessor#addAllProductOptionsToModel(Map, Product)}.
   *
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionsProcessor#addAllProductOptionsToModel(Map, Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProductOptionsProcessor.addAllProductOptionsToModel(Map, Product)"})
  public void testAddAllProductOptionsToModel_thenHashMapSizeIsOne() {
    // Arrange
    ProductOptionsProcessor productOptionsProcessor = new ProductOptionsProcessor();
    HashMap<String, Object> newModelVars = new HashMap<>();

    // Act
    productOptionsProcessor.addAllProductOptionsToModel(newModelVars, new ProductBundleImpl());

    // Assert
    assertEquals(1, newModelVars.size());
    assertEquals("[]", newModelVars.get("allProductOptions"));
  }

  /**
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}, and {@link
   * ProductOptionDTO#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductOptionDTO#equals(Object)}
   *   <li>{@link ProductOptionDTO#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductOptionDTO.equals(Object)", "int ProductOptionDTO.hashCode()"})
  public void testProductOptionDTOEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProductOptionDTO productOptionDTO = new ProductOptionsProcessor().new ProductOptionDTO();
    ProductOptionDTO productOptionDTO2 = new ProductOptionsProcessor().new ProductOptionDTO();

    // Act and Assert
    assertEquals(productOptionDTO, productOptionDTO2);
    assertEquals(productOptionDTO.hashCode(), productOptionDTO2.hashCode());
  }

  /**
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}, and {@link
   * ProductOptionDTO#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductOptionDTO#equals(Object)}
   *   <li>{@link ProductOptionDTO#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductOptionDTO.equals(Object)", "int ProductOptionDTO.hashCode()"})
  public void testProductOptionDTOEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ProductOptionDTO productOptionDTO = new ProductOptionsProcessor().new ProductOptionDTO();
    productOptionDTO.setId(1L);

    ProductOptionDTO productOptionDTO2 = new ProductOptionsProcessor().new ProductOptionDTO();
    productOptionDTO2.setId(1L);

    // Act and Assert
    assertEquals(productOptionDTO, productOptionDTO2);
    assertEquals(productOptionDTO.hashCode(), productOptionDTO2.hashCode());
  }

  /**
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}, and {@link
   * ProductOptionDTO#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductOptionDTO#equals(Object)}
   *   <li>{@link ProductOptionDTO#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductOptionDTO.equals(Object)", "int ProductOptionDTO.hashCode()"})
  public void testProductOptionDTOEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ProductOptionDTO productOptionDTO = new ProductOptionsProcessor().new ProductOptionDTO();
    productOptionDTO.setType("Type");

    ProductOptionDTO productOptionDTO2 = new ProductOptionsProcessor().new ProductOptionDTO();
    productOptionDTO2.setType("Type");

    // Act and Assert
    assertEquals(productOptionDTO, productOptionDTO2);
    assertEquals(productOptionDTO.hashCode(), productOptionDTO2.hashCode());
  }

  /**
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}, and {@link
   * ProductOptionDTO#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductOptionDTO#equals(Object)}
   *   <li>{@link ProductOptionDTO#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductOptionDTO.equals(Object)", "int ProductOptionDTO.hashCode()"})
  public void testProductOptionDTOEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    ProductOptionDTO productOptionDTO = new ProductOptionsProcessor().new ProductOptionDTO();
    productOptionDTO.setValues(new HashMap<>());

    ProductOptionDTO productOptionDTO2 = new ProductOptionsProcessor().new ProductOptionDTO();
    productOptionDTO2.setValues(new HashMap<>());

    // Act and Assert
    assertEquals(productOptionDTO, productOptionDTO2);
    assertEquals(productOptionDTO.hashCode(), productOptionDTO2.hashCode());
  }

  /**
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}, and {@link
   * ProductOptionDTO#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductOptionDTO#equals(Object)}
   *   <li>{@link ProductOptionDTO#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductOptionDTO.equals(Object)", "int ProductOptionDTO.hashCode()"})
  public void testProductOptionDTOEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    ProductOptionDTO productOptionDTO = new ProductOptionsProcessor().new ProductOptionDTO();
    productOptionDTO.setSelectedValue("42");

    ProductOptionDTO productOptionDTO2 = new ProductOptionsProcessor().new ProductOptionDTO();
    productOptionDTO2.setSelectedValue("42");

    // Act and Assert
    assertEquals(productOptionDTO, productOptionDTO2);
    assertEquals(productOptionDTO.hashCode(), productOptionDTO2.hashCode());
  }

  /**
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}, and {@link
   * ProductOptionDTO#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductOptionDTO#equals(Object)}
   *   <li>{@link ProductOptionDTO#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductOptionDTO.equals(Object)", "int ProductOptionDTO.hashCode()"})
  public void testProductOptionDTOEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    ProductOptionDTO productOptionDTO = new ProductOptionsProcessor().new ProductOptionDTO();
    productOptionDTO.setPriceAdjustments(new HashMap<>());

    ProductOptionDTO productOptionDTO2 = new ProductOptionsProcessor().new ProductOptionDTO();
    productOptionDTO2.setPriceAdjustments(new HashMap<>());

    // Act and Assert
    assertEquals(productOptionDTO, productOptionDTO2);
    assertEquals(productOptionDTO.hashCode(), productOptionDTO2.hashCode());
  }

  /**
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}, and {@link
   * ProductOptionDTO#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductOptionDTO#equals(Object)}
   *   <li>{@link ProductOptionDTO#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductOptionDTO.equals(Object)", "int ProductOptionDTO.hashCode()"})
  public void testProductOptionDTOEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProductOptionDTO productOptionDTO = new ProductOptionsProcessor().new ProductOptionDTO();

    // Act and Assert
    assertEquals(productOptionDTO, productOptionDTO);
    int expectedHashCodeResult = productOptionDTO.hashCode();
    assertEquals(expectedHashCodeResult, productOptionDTO.hashCode());
  }

  /**
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionDTO#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductOptionDTO.equals(Object)", "int ProductOptionDTO.hashCode()"})
  public void testProductOptionDTOEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ProductOptionsProcessor().new ProductOptionDTO(), 1);
  }

  /**
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionDTO#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductOptionDTO.equals(Object)", "int ProductOptionDTO.hashCode()"})
  public void testProductOptionDTOEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ProductOptionDTO productOptionDTO = new ProductOptionsProcessor().new ProductOptionDTO();
    productOptionDTO.setId(1L);

    // Act and Assert
    assertNotEquals(productOptionDTO, new ProductOptionsProcessor().new ProductOptionDTO());
  }

  /**
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionDTO#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductOptionDTO.equals(Object)", "int ProductOptionDTO.hashCode()"})
  public void testProductOptionDTOEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ProductOptionDTO productOptionDTO = new ProductOptionsProcessor().new ProductOptionDTO();
    productOptionDTO.setType("Type");

    // Act and Assert
    assertNotEquals(productOptionDTO, new ProductOptionsProcessor().new ProductOptionDTO());
  }

  /**
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionDTO#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductOptionDTO.equals(Object)", "int ProductOptionDTO.hashCode()"})
  public void testProductOptionDTOEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ProductOptionDTO productOptionDTO = new ProductOptionsProcessor().new ProductOptionDTO();
    productOptionDTO.setValues(new HashMap<>());

    // Act and Assert
    assertNotEquals(productOptionDTO, new ProductOptionsProcessor().new ProductOptionDTO());
  }

  /**
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionDTO#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductOptionDTO.equals(Object)", "int ProductOptionDTO.hashCode()"})
  public void testProductOptionDTOEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ProductOptionDTO productOptionDTO = new ProductOptionsProcessor().new ProductOptionDTO();
    productOptionDTO.setSelectedValue("42");

    // Act and Assert
    assertNotEquals(productOptionDTO, new ProductOptionsProcessor().new ProductOptionDTO());
  }

  /**
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionDTO#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductOptionDTO.equals(Object)", "int ProductOptionDTO.hashCode()"})
  public void testProductOptionDTOEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ProductOptionDTO productOptionDTO = new ProductOptionsProcessor().new ProductOptionDTO();
    productOptionDTO.setPriceAdjustments(new HashMap<>());

    // Act and Assert
    assertNotEquals(productOptionDTO, new ProductOptionsProcessor().new ProductOptionDTO());
  }

  /**
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionDTO#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductOptionDTO.equals(Object)", "int ProductOptionDTO.hashCode()"})
  public void testProductOptionDTOEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ProductOptionDTO productOptionDTO = new ProductOptionsProcessor().new ProductOptionDTO();

    ProductOptionDTO productOptionDTO2 = new ProductOptionsProcessor().new ProductOptionDTO();
    productOptionDTO2.setId(1L);

    // Act and Assert
    assertNotEquals(productOptionDTO, productOptionDTO2);
  }

  /**
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionDTO#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductOptionDTO.equals(Object)", "int ProductOptionDTO.hashCode()"})
  public void testProductOptionDTOEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ProductOptionDTO productOptionDTO = new ProductOptionsProcessor().new ProductOptionDTO();

    ProductOptionDTO productOptionDTO2 = new ProductOptionsProcessor().new ProductOptionDTO();
    productOptionDTO2.setType("Type");

    // Act and Assert
    assertNotEquals(productOptionDTO, productOptionDTO2);
  }

  /**
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionDTO#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductOptionDTO.equals(Object)", "int ProductOptionDTO.hashCode()"})
  public void testProductOptionDTOEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ProductOptionDTO productOptionDTO = new ProductOptionsProcessor().new ProductOptionDTO();

    ProductOptionDTO productOptionDTO2 = new ProductOptionsProcessor().new ProductOptionDTO();
    productOptionDTO2.setValues(new HashMap<>());

    // Act and Assert
    assertNotEquals(productOptionDTO, productOptionDTO2);
  }

  /**
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionDTO#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductOptionDTO.equals(Object)", "int ProductOptionDTO.hashCode()"})
  public void testProductOptionDTOEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ProductOptionDTO productOptionDTO = new ProductOptionsProcessor().new ProductOptionDTO();

    ProductOptionDTO productOptionDTO2 = new ProductOptionsProcessor().new ProductOptionDTO();
    productOptionDTO2.setSelectedValue("42");

    // Act and Assert
    assertNotEquals(productOptionDTO, productOptionDTO2);
  }

  /**
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionDTO#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductOptionDTO.equals(Object)", "int ProductOptionDTO.hashCode()"})
  public void testProductOptionDTOEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    ProductOptionDTO productOptionDTO = new ProductOptionsProcessor().new ProductOptionDTO();

    ProductOptionDTO productOptionDTO2 = new ProductOptionsProcessor().new ProductOptionDTO();
    productOptionDTO2.setPriceAdjustments(new HashMap<>());

    // Act and Assert
    assertNotEquals(productOptionDTO, productOptionDTO2);
  }

  /**
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionDTO#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductOptionDTO.equals(Object)", "int ProductOptionDTO.hashCode()"})
  public void testProductOptionDTOEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ProductOptionsProcessor().new ProductOptionDTO(), null);
  }

  /**
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionDTO#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductOptionDTO.equals(Object)", "int ProductOptionDTO.hashCode()"})
  public void testProductOptionDTOEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ProductOptionsProcessor().new ProductOptionDTO(), "Different type to ProductOptionDTO");
  }

  /**
   * Test ProductOptionDTO getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductOptionDTO#ProductOptionDTO(ProductOptionsProcessor)}
   *   <li>{@link ProductOptionDTO#setId(Long)}
   *   <li>{@link ProductOptionDTO#setPriceAdjustments(Map)}
   *   <li>{@link ProductOptionDTO#setSelectedValue(String)}
   *   <li>{@link ProductOptionDTO#setType(String)}
   *   <li>{@link ProductOptionDTO#setValues(Map)}
   *   <li>{@link ProductOptionDTO#getId()}
   *   <li>{@link ProductOptionDTO#getPriceAdjustments()}
   *   <li>{@link ProductOptionDTO#getSelectedValue()}
   *   <li>{@link ProductOptionDTO#getType()}
   *   <li>{@link ProductOptionDTO#getValues()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductOptionDTO.<init>(ProductOptionsProcessor)",
    "Long ProductOptionDTO.getId()",
    "Map ProductOptionDTO.getPriceAdjustments()",
    "String ProductOptionDTO.getSelectedValue()",
    "String ProductOptionDTO.getType()",
    "Map ProductOptionDTO.getValues()",
    "void ProductOptionDTO.setId(Long)",
    "void ProductOptionDTO.setPriceAdjustments(Map)",
    "void ProductOptionDTO.setSelectedValue(String)",
    "void ProductOptionDTO.setType(String)",
    "void ProductOptionDTO.setValues(Map)"
  })
  public void testProductOptionDTOGettersAndSetters() {
    // Arrange and Act
    ProductOptionDTO actualProductOptionDTO = new ProductOptionsProcessor().new ProductOptionDTO();
    actualProductOptionDTO.setId(1L);
    HashMap<Long, Double> priceAdjustments = new HashMap<>();
    actualProductOptionDTO.setPriceAdjustments(priceAdjustments);
    actualProductOptionDTO.setSelectedValue("42");
    actualProductOptionDTO.setType("Type");
    HashMap<Long, String> values = new HashMap<>();
    actualProductOptionDTO.setValues(values);
    Long actualId = actualProductOptionDTO.getId();
    Map<Long, Double> actualPriceAdjustments = actualProductOptionDTO.getPriceAdjustments();
    String actualSelectedValue = actualProductOptionDTO.getSelectedValue();
    String actualType = actualProductOptionDTO.getType();
    Map<Long, String> actualValues = actualProductOptionDTO.getValues();

    // Assert
    assertEquals("42", actualSelectedValue);
    assertEquals("Type", actualType);
    assertEquals(1L, actualId.longValue());
    assertTrue(actualPriceAdjustments.isEmpty());
    assertTrue(actualValues.isEmpty());
    assertSame(priceAdjustments, actualPriceAdjustments);
    assertSame(values, actualValues);
  }

  /**
   * Test ProductOptionPricingDTO {@link ProductOptionPricingDTO#equals(Object)}, and {@link
   * ProductOptionPricingDTO#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductOptionPricingDTO#equals(Object)}
   *   <li>{@link ProductOptionPricingDTO#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionPricingDTO.equals(Object)",
    "int ProductOptionPricingDTO.hashCode()"
  })
  public void testProductOptionPricingDTOEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProductOptionPricingDTO productOptionPricingDTO =
        new ProductOptionsProcessor().new ProductOptionPricingDTO();
    ProductOptionPricingDTO productOptionPricingDTO2 =
        new ProductOptionsProcessor().new ProductOptionPricingDTO();

    // Act and Assert
    assertEquals(productOptionPricingDTO, productOptionPricingDTO2);
    assertEquals(productOptionPricingDTO.hashCode(), productOptionPricingDTO2.hashCode());
  }

  /**
   * Test ProductOptionPricingDTO {@link ProductOptionPricingDTO#equals(Object)}, and {@link
   * ProductOptionPricingDTO#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductOptionPricingDTO#equals(Object)}
   *   <li>{@link ProductOptionPricingDTO#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionPricingDTO.equals(Object)",
    "int ProductOptionPricingDTO.hashCode()"
  })
  public void testProductOptionPricingDTOEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProductOptionPricingDTO productOptionPricingDTO =
        new ProductOptionsProcessor().new ProductOptionPricingDTO();

    // Act and Assert
    assertEquals(productOptionPricingDTO, productOptionPricingDTO);
    int expectedHashCodeResult = productOptionPricingDTO.hashCode();
    assertEquals(expectedHashCodeResult, productOptionPricingDTO.hashCode());
  }

  /**
   * Test ProductOptionPricingDTO {@link ProductOptionPricingDTO#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionPricingDTO#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionPricingDTO.equals(Object)",
    "int ProductOptionPricingDTO.hashCode()"
  })
  public void testProductOptionPricingDTOEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ProductOptionPricingDTO productOptionPricingDTO =
        new ProductOptionsProcessor().new ProductOptionPricingDTO();
    productOptionPricingDTO.setPrice("Price");

    // Act and Assert
    assertNotEquals(
        productOptionPricingDTO, new ProductOptionsProcessor().new ProductOptionPricingDTO());
  }

  /**
   * Test ProductOptionPricingDTO {@link ProductOptionPricingDTO#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionPricingDTO#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionPricingDTO.equals(Object)",
    "int ProductOptionPricingDTO.hashCode()"
  })
  public void testProductOptionPricingDTOEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ProductOptionsProcessor().new ProductOptionPricingDTO(), null);
  }

  /**
   * Test ProductOptionPricingDTO {@link ProductOptionPricingDTO#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionPricingDTO#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionPricingDTO.equals(Object)",
    "int ProductOptionPricingDTO.hashCode()"
  })
  public void testProductOptionPricingDTOEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ProductOptionsProcessor().new ProductOptionPricingDTO(),
        "Different type to ProductOptionPricingDTO");
  }

  /**
   * Test ProductOptionPricingDTO getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductOptionPricingDTO#ProductOptionPricingDTO(ProductOptionsProcessor)}
   *   <li>{@link ProductOptionPricingDTO#setOnSale(boolean)}
   *   <li>{@link ProductOptionPricingDTO#setPrice(String)}
   *   <li>{@link ProductOptionPricingDTO#setRetailPrice(String)}
   *   <li>{@link ProductOptionPricingDTO#setSalePrice(String)}
   *   <li>{@link ProductOptionPricingDTO#setSelectedOptions(Long[])}
   *   <li>{@link ProductOptionPricingDTO#getPrice()}
   *   <li>{@link ProductOptionPricingDTO#getRetailPrice()}
   *   <li>{@link ProductOptionPricingDTO#getSalePrice()}
   *   <li>{@link ProductOptionPricingDTO#getSelectedOptions()}
   *   <li>{@link ProductOptionPricingDTO#isOnSale()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductOptionPricingDTO.<init>(ProductOptionsProcessor)",
    "String ProductOptionPricingDTO.getPrice()",
    "String ProductOptionPricingDTO.getRetailPrice()",
    "String ProductOptionPricingDTO.getSalePrice()",
    "Long[] ProductOptionPricingDTO.getSelectedOptions()",
    "boolean ProductOptionPricingDTO.isOnSale()",
    "void ProductOptionPricingDTO.setOnSale(boolean)",
    "void ProductOptionPricingDTO.setPrice(String)",
    "void ProductOptionPricingDTO.setRetailPrice(String)",
    "void ProductOptionPricingDTO.setSalePrice(String)",
    "void ProductOptionPricingDTO.setSelectedOptions(Long[])"
  })
  public void testProductOptionPricingDTOGettersAndSetters() {
    // Arrange and Act
    ProductOptionPricingDTO actualProductOptionPricingDTO =
        new ProductOptionsProcessor().new ProductOptionPricingDTO();
    actualProductOptionPricingDTO.setOnSale(true);
    actualProductOptionPricingDTO.setPrice("Price");
    actualProductOptionPricingDTO.setRetailPrice("Retail Price");
    actualProductOptionPricingDTO.setSalePrice("Sale Price");
    Long[] skuOptions = new Long[] {1L};
    actualProductOptionPricingDTO.setSelectedOptions(skuOptions);
    String actualPrice = actualProductOptionPricingDTO.getPrice();
    String actualRetailPrice = actualProductOptionPricingDTO.getRetailPrice();
    String actualSalePrice = actualProductOptionPricingDTO.getSalePrice();
    Long[] actualSelectedOptions = actualProductOptionPricingDTO.getSelectedOptions();

    // Assert
    assertEquals("Price", actualPrice);
    assertEquals("Retail Price", actualRetailPrice);
    assertEquals("Sale Price", actualSalePrice);
    assertTrue(actualProductOptionPricingDTO.isOnSale());
    assertSame(skuOptions, actualSelectedOptions);
    assertArrayEquals(new Long[] {1L}, actualSelectedOptions);
  }

  /**
   * Test {@link ProductOptionsProcessor#writeJSONToModel(Map, String, Object)}.
   *
   * <ul>
   *   <li>Given {@link ProductOptionsProcessor}.
   *   <li>Then {@link HashMap#HashMap()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionsProcessor#writeJSONToModel(Map, String, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProductOptionsProcessor.writeJSONToModel(Map, String, Object)"})
  public void testWriteJSONToModel_givenProductOptionsProcessor_thenHashMapSizeIsTwo() {
    // Arrange
    HashMap<String, Object> newModelVars = new HashMap<>();
    newModelVars.put("42", "42");
    newModelVars.put("foo", "42");

    HashMap<Object, Object> objectObjectMap = new HashMap<>();
    objectObjectMap.put(null, "42");

    // Act
    productOptionsProcessor.writeJSONToModel(newModelVars, "Model Key", objectObjectMap);

    // Assert that nothing has changed
    assertEquals(2, newModelVars.size());
    assertTrue(newModelVars.containsKey("42"));
    assertTrue(newModelVars.containsKey("foo"));
  }

  /**
   * Test {@link ProductOptionsProcessor#writeJSONToModel(Map, String, Object)}.
   *
   * <ul>
   *   <li>Given {@link ProductOptionsProcessor} (default constructor).
   *   <li>When {@code 42}.
   *   <li>Then {@link HashMap#HashMap()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionsProcessor#writeJSONToModel(Map, String, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProductOptionsProcessor.writeJSONToModel(Map, String, Object)"})
  public void testWriteJSONToModel_givenProductOptionsProcessor_when42_thenHashMapSizeIsOne() {
    // Arrange
    ProductOptionsProcessor productOptionsProcessor = new ProductOptionsProcessor();
    HashMap<String, Object> newModelVars = new HashMap<>();

    // Act
    productOptionsProcessor.writeJSONToModel(newModelVars, "Model Key", "42");

    // Assert
    assertEquals(1, newModelVars.size());
    assertEquals("\"42\"", newModelVars.get("Model Key"));
  }

  /**
   * Test {@link ProductOptionsProcessor#writeJSONToModel(Map, String, Object)}.
   *
   * <ul>
   *   <li>Given {@link ProductOptionsProcessor} (default constructor).
   *   <li>When Default.
   *   <li>Then {@link HashMap#HashMap()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionsProcessor#writeJSONToModel(Map, String, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProductOptionsProcessor.writeJSONToModel(Map, String, Object)"})
  public void testWriteJSONToModel_givenProductOptionsProcessor_whenDefault_thenHashMapEmpty() {
    // Arrange
    ProductOptionsProcessor productOptionsProcessor = new ProductOptionsProcessor();
    HashMap<String, Object> newModelVars = new HashMap<>();

    // Act
    productOptionsProcessor.writeJSONToModel(newModelVars, "Model Key", FileSystems.getDefault());

    // Assert that nothing has changed
    assertTrue(newModelVars.isEmpty());
  }
}

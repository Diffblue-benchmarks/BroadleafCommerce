/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.processor;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProductOptionsProcessorDiffblueTest {
  @Mock
  private CatalogService catalogService;

  @InjectMocks
  private ProductOptionsProcessor productOptionsProcessor;

  @Mock
  private ProductOptionsProcessorExtensionManager productOptionsProcessorExtensionManager;

  /**
   * Test {@link ProductOptionsProcessor#getName()}.
   * <p>
   * Method under test: {@link ProductOptionsProcessor#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ProductOptionsProcessor.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("product_options", (new ProductOptionsProcessor()).getName());
  }

  /**
   * Test {@link ProductOptionsProcessor#getPrecedence()}.
   * <p>
   * Method under test: {@link ProductOptionsProcessor#getPrecedence()}
   */
  @Test
  @DisplayName("Test getPrecedence()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ProductOptionsProcessor.getPrecedence()"})
  void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(10000, productOptionsProcessor.getPrecedence());
  }

  /**
   * Test {@link ProductOptionsProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}.
   * <p>
   * Method under test: {@link ProductOptionsProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test populateModelVariables(String, Map, BroadleafTemplateContext)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map ProductOptionsProcessor.populateModelVariables(String, Map, BroadleafTemplateContext)"})
  void testPopulateModelVariables() {
    // Arrange
    when(catalogService.findProductById(Mockito.<Long>any())).thenReturn(new ProductBundleImpl());
    HashMap<String, String> tagAttributes = new HashMap<>();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(1L);

    // Act
    Map<String, Object> actualPopulateModelVariablesResult = productOptionsProcessor.populateModelVariables("Tag Name",
        tagAttributes, context);

    // Assert
    verify(catalogService).findProductById(eq(1L));
    verify(context).parseExpression(isNull());
    assertEquals(2, actualPopulateModelVariablesResult.size());
    assertEquals("[]", actualPopulateModelVariablesResult.get("allProductOptions"));
    assertEquals("[]", actualPopulateModelVariablesResult.get("skuPricing"));
  }

  /**
   * Test {@link ProductOptionsProcessor#addProductOptionPricingToModel(Map, Product, BroadleafTemplateContext, Map)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then {@link HashMap#HashMap()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionsProcessor#addProductOptionPricingToModel(Map, Product, BroadleafTemplateContext, Map)}
   */
  @Test
  @DisplayName("Test addProductOptionPricingToModel(Map, Product, BroadleafTemplateContext, Map); when ProductBundleImpl (default constructor); then HashMap() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void ProductOptionsProcessor.addProductOptionPricingToModel(Map, Product, BroadleafTemplateContext, Map)"})
  void testAddProductOptionPricingToModel_whenProductBundleImpl_thenHashMapSizeIsOne() {
    // Arrange
    HashMap<String, Object> newModelVars = new HashMap<>();
    ProductBundleImpl product = new ProductBundleImpl();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);

    // Act
    productOptionsProcessor.addProductOptionPricingToModel(newModelVars, product, context, new HashMap<>());

    // Assert
    assertEquals(1, newModelVars.size());
    assertEquals("[]", newModelVars.get("skuPricing"));
  }

  /**
   * Test {@link ProductOptionsProcessor#createPricingDto(Sku, List, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@link Money#Money()}.</li>
   *   <li>When {@link Sku} {@link Sku#getPrice()} return {@link Money#Money()}.</li>
   *   <li>Then return Price is {@code £0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionsProcessor#createPricingDto(Sku, List, Map, BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test createPricingDto(Sku, List, Map, BroadleafTemplateContext); given Money(); when Sku getPrice() return Money(); then return Price is '£0.00'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ProductOptionPricingDTO ProductOptionsProcessor.createPricingDto(Sku, List, Map, BroadleafTemplateContext)"})
  void testCreatePricingDto_givenMoney_whenSkuGetPriceReturnMoney_thenReturnPriceIs000() {
    // Arrange
    ProductOptionsProcessorExtensionHandler productOptionsProcessorExtensionHandler = mock(
        ProductOptionsProcessorExtensionHandler.class);
    when(productOptionsProcessorExtensionHandler.modifyPriceForOverrides(Mockito.<Sku>any(),
        Mockito.<ExtensionResultHolder<Money>>any(), Mockito.<BroadleafTemplateContext>any(),
        Mockito.<Map<String, String>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(productOptionsProcessorExtensionManager.getProxy()).thenReturn(productOptionsProcessorExtensionHandler);
    Sku sku = mock(Sku.class);
    when(sku.isOnSale()).thenReturn(true);
    when(sku.getPrice()).thenReturn(new Money());
    when(sku.getRetailPrice()).thenReturn(new Money());
    when(sku.getSalePrice()).thenReturn(new Money());
    ArrayList<Long> productOptionValueIds = new ArrayList<>();

    // Act
    ProductOptionPricingDTO actualCreatePricingDtoResult = productOptionsProcessor.createPricingDto(sku,
        productOptionValueIds, new HashMap<>(), mock(BroadleafTemplateContext.class));

    // Assert
    verify(productOptionsProcessorExtensionManager).getProxy();
    verify(sku).getPrice();
    verify(sku, atLeast(1)).getRetailPrice();
    verify(sku, atLeast(1)).getSalePrice();
    verify(sku).isOnSale();
    verify(productOptionsProcessorExtensionHandler).modifyPriceForOverrides(isA(Sku.class),
        isA(ExtensionResultHolder.class), isA(BroadleafTemplateContext.class), isA(Map.class));
    assertEquals("£0.00", actualCreatePricingDtoResult.getPrice());
    assertEquals("£0.00", actualCreatePricingDtoResult.getRetailPrice());
    assertEquals("£0.00", actualCreatePricingDtoResult.getSalePrice());
    assertTrue(actualCreatePricingDtoResult.isOnSale());
  }

  /**
   * Test {@link ProductOptionsProcessor#createPricingDto(Sku, List, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@link ProductOptionsProcessor} (default constructor).</li>
   *   <li>Then return Price is {@code Not Available}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionsProcessor#createPricingDto(Sku, List, Map, BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test createPricingDto(Sku, List, Map, BroadleafTemplateContext); given ProductOptionsProcessor (default constructor); then return Price is 'Not Available'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ProductOptionPricingDTO ProductOptionsProcessor.createPricingDto(Sku, List, Map, BroadleafTemplateContext)"})
  void testCreatePricingDto_givenProductOptionsProcessor_thenReturnPriceIsNotAvailable() {
    // Arrange
    ProductOptionsProcessor productOptionsProcessor = new ProductOptionsProcessor();
    SkuImpl sku = new SkuImpl();
    ArrayList<Long> productOptionValueIds = new ArrayList<>();

    // Act
    ProductOptionPricingDTO actualCreatePricingDtoResult = productOptionsProcessor.createPricingDto(sku,
        productOptionValueIds, new HashMap<>(), mock(BroadleafTemplateContext.class));

    // Assert
    assertEquals("Not Available", actualCreatePricingDtoResult.getPrice());
    assertNull(actualCreatePricingDtoResult.getRetailPrice());
    assertNull(actualCreatePricingDtoResult.getSalePrice());
    assertFalse(actualCreatePricingDtoResult.isOnSale());
  }

  /**
   * Test {@link ProductOptionsProcessor#createPricingDto(Sku, List, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>When {@link SkuImpl} (default constructor).</li>
   *   <li>Then return Price is {@code Not Available}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionsProcessor#createPricingDto(Sku, List, Map, BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test createPricingDto(Sku, List, Map, BroadleafTemplateContext); when SkuImpl (default constructor); then return Price is 'Not Available'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ProductOptionPricingDTO ProductOptionsProcessor.createPricingDto(Sku, List, Map, BroadleafTemplateContext)"})
  void testCreatePricingDto_whenSkuImpl_thenReturnPriceIsNotAvailable() {
    // Arrange
    ProductOptionsProcessorExtensionHandler productOptionsProcessorExtensionHandler = mock(
        ProductOptionsProcessorExtensionHandler.class);
    when(productOptionsProcessorExtensionHandler.modifyPriceForOverrides(Mockito.<Sku>any(),
        Mockito.<ExtensionResultHolder<Money>>any(), Mockito.<BroadleafTemplateContext>any(),
        Mockito.<Map<String, String>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(productOptionsProcessorExtensionManager.getProxy()).thenReturn(productOptionsProcessorExtensionHandler);
    SkuImpl sku = new SkuImpl();
    ArrayList<Long> productOptionValueIds = new ArrayList<>();

    // Act
    ProductOptionPricingDTO actualCreatePricingDtoResult = productOptionsProcessor.createPricingDto(sku,
        productOptionValueIds, new HashMap<>(), mock(BroadleafTemplateContext.class));

    // Assert
    verify(productOptionsProcessorExtensionManager).getProxy();
    verify(productOptionsProcessorExtensionHandler).modifyPriceForOverrides(isA(Sku.class),
        isA(ExtensionResultHolder.class), isA(BroadleafTemplateContext.class), isA(Map.class));
    assertEquals("Not Available", actualCreatePricingDtoResult.getPrice());
    assertNull(actualCreatePricingDtoResult.getRetailPrice());
    assertNull(actualCreatePricingDtoResult.getSalePrice());
    assertFalse(actualCreatePricingDtoResult.isOnSale());
  }

  /**
   * Test {@link ProductOptionsProcessor#addAllProductOptionsToModel(Map, Product)}.
   * <ul>
   *   <li>Given {@code allProductOptions}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionsProcessor#addAllProductOptionsToModel(Map, Product)}
   */
  @Test
  @DisplayName("Test addAllProductOptionsToModel(Map, Product); given 'allProductOptions'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ProductOptionsProcessor.addAllProductOptionsToModel(Map, Product)"})
  void testAddAllProductOptionsToModel_givenAllProductOptions() {
    // Arrange
    HashMap<String, Object> newModelVars = new HashMap<>();
    newModelVars.put("allProductOptions", "42");

    // Act
    productOptionsProcessor.addAllProductOptionsToModel(newModelVars, new ProductBundleImpl());

    // Assert
    assertEquals(1, newModelVars.size());
    assertEquals("[]", newModelVars.get("allProductOptions"));
  }

  /**
   * Test {@link ProductOptionsProcessor#addAllProductOptionsToModel(Map, Product)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link HashMap#HashMap()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionsProcessor#addAllProductOptionsToModel(Map, Product)}
   */
  @Test
  @DisplayName("Test addAllProductOptionsToModel(Map, Product); when HashMap(); then HashMap() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ProductOptionsProcessor.addAllProductOptionsToModel(Map, Product)"})
  void testAddAllProductOptionsToModel_whenHashMap_thenHashMapSizeIsOne() {
    // Arrange
    HashMap<String, Object> newModelVars = new HashMap<>();

    // Act
    productOptionsProcessor.addAllProductOptionsToModel(newModelVars, new ProductBundleImpl());

    // Assert
    assertEquals(1, newModelVars.size());
    assertEquals("[]", newModelVars.get("allProductOptions"));
  }

  /**
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}, and {@link ProductOptionDTO#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionDTO#equals(Object)}
   *   <li>{@link ProductOptionDTO#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProductOptionDTO equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProductOptionDTO.equals(Object)", "int ProductOptionDTO.hashCode()"})
  void testProductOptionDTOEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProductOptionDTO productOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();
    ProductOptionDTO productOptionDTO2 = (new ProductOptionsProcessor()).new ProductOptionDTO();

    // Act and Assert
    assertEquals(productOptionDTO, productOptionDTO2);
    int expectedHashCodeResult = productOptionDTO.hashCode();
    assertEquals(expectedHashCodeResult, productOptionDTO2.hashCode());
  }

  /**
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}, and {@link ProductOptionDTO#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionDTO#equals(Object)}
   *   <li>{@link ProductOptionDTO#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProductOptionDTO equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProductOptionDTO.equals(Object)", "int ProductOptionDTO.hashCode()"})
  void testProductOptionDTOEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ProductOptionDTO productOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();
    productOptionDTO.setId(1L);

    ProductOptionDTO productOptionDTO2 = (new ProductOptionsProcessor()).new ProductOptionDTO();
    productOptionDTO2.setId(1L);

    // Act and Assert
    assertEquals(productOptionDTO, productOptionDTO2);
    int expectedHashCodeResult = productOptionDTO.hashCode();
    assertEquals(expectedHashCodeResult, productOptionDTO2.hashCode());
  }

  /**
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}, and {@link ProductOptionDTO#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionDTO#equals(Object)}
   *   <li>{@link ProductOptionDTO#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProductOptionDTO equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProductOptionDTO.equals(Object)", "int ProductOptionDTO.hashCode()"})
  void testProductOptionDTOEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ProductOptionDTO productOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();
    productOptionDTO.setType("Type");

    ProductOptionDTO productOptionDTO2 = (new ProductOptionsProcessor()).new ProductOptionDTO();
    productOptionDTO2.setType("Type");

    // Act and Assert
    assertEquals(productOptionDTO, productOptionDTO2);
    int expectedHashCodeResult = productOptionDTO.hashCode();
    assertEquals(expectedHashCodeResult, productOptionDTO2.hashCode());
  }

  /**
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}, and {@link ProductOptionDTO#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionDTO#equals(Object)}
   *   <li>{@link ProductOptionDTO#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProductOptionDTO equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProductOptionDTO.equals(Object)", "int ProductOptionDTO.hashCode()"})
  void testProductOptionDTOEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    ProductOptionDTO productOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();
    productOptionDTO.setValues(new HashMap<>());

    ProductOptionDTO productOptionDTO2 = (new ProductOptionsProcessor()).new ProductOptionDTO();
    productOptionDTO2.setValues(new HashMap<>());

    // Act and Assert
    assertEquals(productOptionDTO, productOptionDTO2);
    int expectedHashCodeResult = productOptionDTO.hashCode();
    assertEquals(expectedHashCodeResult, productOptionDTO2.hashCode());
  }

  /**
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}, and {@link ProductOptionDTO#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionDTO#equals(Object)}
   *   <li>{@link ProductOptionDTO#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProductOptionDTO equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProductOptionDTO.equals(Object)", "int ProductOptionDTO.hashCode()"})
  void testProductOptionDTOEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    ProductOptionDTO productOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();
    productOptionDTO.setSelectedValue("42");

    ProductOptionDTO productOptionDTO2 = (new ProductOptionsProcessor()).new ProductOptionDTO();
    productOptionDTO2.setSelectedValue("42");

    // Act and Assert
    assertEquals(productOptionDTO, productOptionDTO2);
    int expectedHashCodeResult = productOptionDTO.hashCode();
    assertEquals(expectedHashCodeResult, productOptionDTO2.hashCode());
  }

  /**
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}, and {@link ProductOptionDTO#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionDTO#equals(Object)}
   *   <li>{@link ProductOptionDTO#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProductOptionDTO equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProductOptionDTO.equals(Object)", "int ProductOptionDTO.hashCode()"})
  void testProductOptionDTOEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    ProductOptionDTO productOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();
    productOptionDTO.setPriceAdjustments(new HashMap<>());

    ProductOptionDTO productOptionDTO2 = (new ProductOptionsProcessor()).new ProductOptionDTO();
    productOptionDTO2.setPriceAdjustments(new HashMap<>());

    // Act and Assert
    assertEquals(productOptionDTO, productOptionDTO2);
    int expectedHashCodeResult = productOptionDTO.hashCode();
    assertEquals(expectedHashCodeResult, productOptionDTO2.hashCode());
  }

  /**
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}, and {@link ProductOptionDTO#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionDTO#equals(Object)}
   *   <li>{@link ProductOptionDTO#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProductOptionDTO equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProductOptionDTO.equals(Object)", "int ProductOptionDTO.hashCode()"})
  void testProductOptionDTOEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProductOptionDTO productOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();

    // Act and Assert
    assertEquals(productOptionDTO, productOptionDTO);
    int expectedHashCodeResult = productOptionDTO.hashCode();
    assertEquals(expectedHashCodeResult, productOptionDTO.hashCode());
  }

  /**
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionDTO#equals(Object)}
   */
  @Test
  @DisplayName("Test ProductOptionDTO equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProductOptionDTO.equals(Object)", "int ProductOptionDTO.hashCode()"})
  void testProductOptionDTOEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals((new ProductOptionsProcessor()).new ProductOptionDTO(), 1);
  }

  /**
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionDTO#equals(Object)}
   */
  @Test
  @DisplayName("Test ProductOptionDTO equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProductOptionDTO.equals(Object)", "int ProductOptionDTO.hashCode()"})
  void testProductOptionDTOEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ProductOptionDTO productOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();
    productOptionDTO.setId(1L);

    // Act and Assert
    assertNotEquals(productOptionDTO, (new ProductOptionsProcessor()).new ProductOptionDTO());
  }

  /**
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionDTO#equals(Object)}
   */
  @Test
  @DisplayName("Test ProductOptionDTO equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProductOptionDTO.equals(Object)", "int ProductOptionDTO.hashCode()"})
  void testProductOptionDTOEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ProductOptionDTO productOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();
    productOptionDTO.setType("Type");

    // Act and Assert
    assertNotEquals(productOptionDTO, (new ProductOptionsProcessor()).new ProductOptionDTO());
  }

  /**
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionDTO#equals(Object)}
   */
  @Test
  @DisplayName("Test ProductOptionDTO equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProductOptionDTO.equals(Object)", "int ProductOptionDTO.hashCode()"})
  void testProductOptionDTOEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ProductOptionDTO productOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();
    productOptionDTO.setValues(new HashMap<>());

    // Act and Assert
    assertNotEquals(productOptionDTO, (new ProductOptionsProcessor()).new ProductOptionDTO());
  }

  /**
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionDTO#equals(Object)}
   */
  @Test
  @DisplayName("Test ProductOptionDTO equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProductOptionDTO.equals(Object)", "int ProductOptionDTO.hashCode()"})
  void testProductOptionDTOEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ProductOptionDTO productOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();
    productOptionDTO.setSelectedValue("42");

    // Act and Assert
    assertNotEquals(productOptionDTO, (new ProductOptionsProcessor()).new ProductOptionDTO());
  }

  /**
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionDTO#equals(Object)}
   */
  @Test
  @DisplayName("Test ProductOptionDTO equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProductOptionDTO.equals(Object)", "int ProductOptionDTO.hashCode()"})
  void testProductOptionDTOEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ProductOptionDTO productOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();
    productOptionDTO.setPriceAdjustments(new HashMap<>());

    // Act and Assert
    assertNotEquals(productOptionDTO, (new ProductOptionsProcessor()).new ProductOptionDTO());
  }

  /**
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionDTO#equals(Object)}
   */
  @Test
  @DisplayName("Test ProductOptionDTO equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProductOptionDTO.equals(Object)", "int ProductOptionDTO.hashCode()"})
  void testProductOptionDTOEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ProductOptionDTO productOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();

    ProductOptionDTO productOptionDTO2 = (new ProductOptionsProcessor()).new ProductOptionDTO();
    productOptionDTO2.setId(1L);

    // Act and Assert
    assertNotEquals(productOptionDTO, productOptionDTO2);
  }

  /**
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionDTO#equals(Object)}
   */
  @Test
  @DisplayName("Test ProductOptionDTO equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProductOptionDTO.equals(Object)", "int ProductOptionDTO.hashCode()"})
  void testProductOptionDTOEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ProductOptionDTO productOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();

    ProductOptionDTO productOptionDTO2 = (new ProductOptionsProcessor()).new ProductOptionDTO();
    productOptionDTO2.setType("Type");

    // Act and Assert
    assertNotEquals(productOptionDTO, productOptionDTO2);
  }

  /**
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionDTO#equals(Object)}
   */
  @Test
  @DisplayName("Test ProductOptionDTO equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProductOptionDTO.equals(Object)", "int ProductOptionDTO.hashCode()"})
  void testProductOptionDTOEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ProductOptionDTO productOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();

    ProductOptionDTO productOptionDTO2 = (new ProductOptionsProcessor()).new ProductOptionDTO();
    productOptionDTO2.setValues(new HashMap<>());

    // Act and Assert
    assertNotEquals(productOptionDTO, productOptionDTO2);
  }

  /**
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionDTO#equals(Object)}
   */
  @Test
  @DisplayName("Test ProductOptionDTO equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProductOptionDTO.equals(Object)", "int ProductOptionDTO.hashCode()"})
  void testProductOptionDTOEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ProductOptionDTO productOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();

    ProductOptionDTO productOptionDTO2 = (new ProductOptionsProcessor()).new ProductOptionDTO();
    productOptionDTO2.setSelectedValue("42");

    // Act and Assert
    assertNotEquals(productOptionDTO, productOptionDTO2);
  }

  /**
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionDTO#equals(Object)}
   */
  @Test
  @DisplayName("Test ProductOptionDTO equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProductOptionDTO.equals(Object)", "int ProductOptionDTO.hashCode()"})
  void testProductOptionDTOEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    ProductOptionDTO productOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();

    ProductOptionDTO productOptionDTO2 = (new ProductOptionsProcessor()).new ProductOptionDTO();
    productOptionDTO2.setPriceAdjustments(new HashMap<>());

    // Act and Assert
    assertNotEquals(productOptionDTO, productOptionDTO2);
  }

  /**
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionDTO#equals(Object)}
   */
  @Test
  @DisplayName("Test ProductOptionDTO equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProductOptionDTO.equals(Object)", "int ProductOptionDTO.hashCode()"})
  void testProductOptionDTOEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals((new ProductOptionsProcessor()).new ProductOptionDTO(), null);
  }

  /**
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionDTO#equals(Object)}
   */
  @Test
  @DisplayName("Test ProductOptionDTO equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProductOptionDTO.equals(Object)", "int ProductOptionDTO.hashCode()"})
  void testProductOptionDTOEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals((new ProductOptionsProcessor()).new ProductOptionDTO(), "Different type to ProductOptionDTO");
  }

  /**
   * Test ProductOptionDTO getters and setters.
   * <p>
   * Methods under test:
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
  @DisplayName("Test ProductOptionDTO getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ProductOptionDTO.<init>(ProductOptionsProcessor)", "Long ProductOptionDTO.getId()",
      "Map ProductOptionDTO.getPriceAdjustments()", "String ProductOptionDTO.getSelectedValue()",
      "String ProductOptionDTO.getType()", "Map ProductOptionDTO.getValues()", "void ProductOptionDTO.setId(Long)",
      "void ProductOptionDTO.setPriceAdjustments(Map)", "void ProductOptionDTO.setSelectedValue(String)",
      "void ProductOptionDTO.setType(String)", "void ProductOptionDTO.setValues(Map)"})
  void testProductOptionDTOGettersAndSetters() {
    // Arrange and Act
    ProductOptionDTO actualProductOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();
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
   * Test ProductOptionPricingDTO {@link ProductOptionPricingDTO#equals(Object)}, and {@link ProductOptionPricingDTO#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionPricingDTO#equals(Object)}
   *   <li>{@link ProductOptionPricingDTO#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProductOptionPricingDTO equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProductOptionPricingDTO.equals(Object)", "int ProductOptionPricingDTO.hashCode()"})
  void testProductOptionPricingDTOEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProductOptionPricingDTO productOptionPricingDTO = (new ProductOptionsProcessor()).new ProductOptionPricingDTO();
    ProductOptionPricingDTO productOptionPricingDTO2 = (new ProductOptionsProcessor()).new ProductOptionPricingDTO();

    // Act and Assert
    assertEquals(productOptionPricingDTO, productOptionPricingDTO2);
    int expectedHashCodeResult = productOptionPricingDTO.hashCode();
    assertEquals(expectedHashCodeResult, productOptionPricingDTO2.hashCode());
  }

  /**
   * Test ProductOptionPricingDTO {@link ProductOptionPricingDTO#equals(Object)}, and {@link ProductOptionPricingDTO#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionPricingDTO#equals(Object)}
   *   <li>{@link ProductOptionPricingDTO#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProductOptionPricingDTO equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProductOptionPricingDTO.equals(Object)", "int ProductOptionPricingDTO.hashCode()"})
  void testProductOptionPricingDTOEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProductOptionPricingDTO productOptionPricingDTO = (new ProductOptionsProcessor()).new ProductOptionPricingDTO();

    // Act and Assert
    assertEquals(productOptionPricingDTO, productOptionPricingDTO);
    int expectedHashCodeResult = productOptionPricingDTO.hashCode();
    assertEquals(expectedHashCodeResult, productOptionPricingDTO.hashCode());
  }

  /**
   * Test ProductOptionPricingDTO {@link ProductOptionPricingDTO#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionPricingDTO#equals(Object)}
   */
  @Test
  @DisplayName("Test ProductOptionPricingDTO equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProductOptionPricingDTO.equals(Object)", "int ProductOptionPricingDTO.hashCode()"})
  void testProductOptionPricingDTOEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ProductOptionPricingDTO productOptionPricingDTO = (new ProductOptionsProcessor()).new ProductOptionPricingDTO();
    productOptionPricingDTO.setPrice("Price");

    // Act and Assert
    assertNotEquals(productOptionPricingDTO, (new ProductOptionsProcessor()).new ProductOptionPricingDTO());
  }

  /**
   * Test ProductOptionPricingDTO {@link ProductOptionPricingDTO#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionPricingDTO#equals(Object)}
   */
  @Test
  @DisplayName("Test ProductOptionPricingDTO equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProductOptionPricingDTO.equals(Object)", "int ProductOptionPricingDTO.hashCode()"})
  void testProductOptionPricingDTOEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals((new ProductOptionsProcessor()).new ProductOptionPricingDTO(), null);
  }

  /**
   * Test ProductOptionPricingDTO {@link ProductOptionPricingDTO#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionPricingDTO#equals(Object)}
   */
  @Test
  @DisplayName("Test ProductOptionPricingDTO equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ProductOptionPricingDTO.equals(Object)", "int ProductOptionPricingDTO.hashCode()"})
  void testProductOptionPricingDTOEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals((new ProductOptionsProcessor()).new ProductOptionPricingDTO(),
        "Different type to ProductOptionPricingDTO");
  }

  /**
   * Test ProductOptionPricingDTO getters and setters.
   * <p>
   * Methods under test:
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
  @DisplayName("Test ProductOptionPricingDTO getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ProductOptionPricingDTO.<init>(ProductOptionsProcessor)",
      "String ProductOptionPricingDTO.getPrice()", "String ProductOptionPricingDTO.getRetailPrice()",
      "String ProductOptionPricingDTO.getSalePrice()", "Long[] ProductOptionPricingDTO.getSelectedOptions()",
      "boolean ProductOptionPricingDTO.isOnSale()", "void ProductOptionPricingDTO.setOnSale(boolean)",
      "void ProductOptionPricingDTO.setPrice(String)", "void ProductOptionPricingDTO.setRetailPrice(String)",
      "void ProductOptionPricingDTO.setSalePrice(String)", "void ProductOptionPricingDTO.setSelectedOptions(Long[])"})
  void testProductOptionPricingDTOGettersAndSetters() {
    // Arrange and Act
    ProductOptionPricingDTO actualProductOptionPricingDTO = (new ProductOptionsProcessor()).new ProductOptionPricingDTO();
    actualProductOptionPricingDTO.setOnSale(true);
    actualProductOptionPricingDTO.setPrice("Price");
    actualProductOptionPricingDTO.setRetailPrice("Retail Price");
    actualProductOptionPricingDTO.setSalePrice("Sale Price");
    Long[] skuOptions = new Long[]{1L};
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
    assertArrayEquals(new Long[]{1L}, actualSelectedOptions);
  }

  /**
   * Test {@link ProductOptionsProcessor#writeJSONToModel(Map, String, Object)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code 42} is {@code 42}.</li>
   *   <li>Then {@link HashMap#HashMap()} size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionsProcessor#writeJSONToModel(Map, String, Object)}
   */
  @Test
  @DisplayName("Test writeJSONToModel(Map, String, Object); given '42'; when HashMap() '42' is '42'; then HashMap() size is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ProductOptionsProcessor.writeJSONToModel(Map, String, Object)"})
  void testWriteJSONToModel_given42_whenHashMap42Is42_thenHashMapSizeIsThree() {
    // Arrange
    HashMap<String, Object> newModelVars = new HashMap<>();
    newModelVars.put("42", "42");
    newModelVars.put("foo", "42");

    // Act
    productOptionsProcessor.writeJSONToModel(newModelVars, "Model Key", "42");

    // Assert
    assertEquals(3, newModelVars.size());
    assertEquals("\"42\"", newModelVars.get("Model Key"));
    assertTrue(newModelVars.containsKey("42"));
    assertTrue(newModelVars.containsKey("foo"));
  }

  /**
   * Test {@link ProductOptionsProcessor#writeJSONToModel(Map, String, Object)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code 42}.</li>
   *   <li>Then {@link HashMap#HashMap()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionsProcessor#writeJSONToModel(Map, String, Object)}
   */
  @Test
  @DisplayName("Test writeJSONToModel(Map, String, Object); given 'foo'; when HashMap() 'foo' is '42'; then HashMap() size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ProductOptionsProcessor.writeJSONToModel(Map, String, Object)"})
  void testWriteJSONToModel_givenFoo_whenHashMapFooIs42_thenHashMapSizeIsTwo() {
    // Arrange
    HashMap<String, Object> newModelVars = new HashMap<>();
    newModelVars.put("foo", "42");

    // Act
    productOptionsProcessor.writeJSONToModel(newModelVars, "Model Key", "42");

    // Assert
    assertEquals(2, newModelVars.size());
    assertEquals("\"42\"", newModelVars.get("Model Key"));
    assertTrue(newModelVars.containsKey("foo"));
  }

  /**
   * Test {@link ProductOptionsProcessor#writeJSONToModel(Map, String, Object)}.
   * <ul>
   *   <li>When {@code 19088743}.</li>
   *   <li>Then {@link HashMap#HashMap()} {@code Model Key} is {@code 19088743}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionsProcessor#writeJSONToModel(Map, String, Object)}
   */
  @Test
  @DisplayName("Test writeJSONToModel(Map, String, Object); when '19088743'; then HashMap() 'Model Key' is '19088743'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ProductOptionsProcessor.writeJSONToModel(Map, String, Object)"})
  void testWriteJSONToModel_when19088743_thenHashMapModelKeyIs19088743() {
    // Arrange
    HashMap<String, Object> newModelVars = new HashMap<>();

    // Act
    productOptionsProcessor.writeJSONToModel(newModelVars, "Model Key", 19088743);

    // Assert
    assertEquals(1, newModelVars.size());
    assertEquals("19088743", newModelVars.get("Model Key"));
  }

  /**
   * Test {@link ProductOptionsProcessor#writeJSONToModel(Map, String, Object)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link HashMap#HashMap()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionsProcessor#writeJSONToModel(Map, String, Object)}
   */
  @Test
  @DisplayName("Test writeJSONToModel(Map, String, Object); when HashMap(); then HashMap() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ProductOptionsProcessor.writeJSONToModel(Map, String, Object)"})
  void testWriteJSONToModel_whenHashMap_thenHashMapSizeIsOne() {
    // Arrange
    HashMap<String, Object> newModelVars = new HashMap<>();

    // Act
    productOptionsProcessor.writeJSONToModel(newModelVars, "Model Key", "42");

    // Assert
    assertEquals(1, newModelVars.size());
    assertEquals("\"42\"", newModelVars.get("Model Key"));
  }

  /**
   * Test {@link ProductOptionsProcessor#writeJSONToModel(Map, String, Object)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link HashMap#HashMap()} {@code Model Key} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionsProcessor#writeJSONToModel(Map, String, Object)}
   */
  @Test
  @DisplayName("Test writeJSONToModel(Map, String, Object); when 'null'; then HashMap() 'Model Key' is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ProductOptionsProcessor.writeJSONToModel(Map, String, Object)"})
  void testWriteJSONToModel_whenNull_thenHashMapModelKeyIsNull() {
    // Arrange
    HashMap<String, Object> newModelVars = new HashMap<>();

    // Act
    productOptionsProcessor.writeJSONToModel(newModelVars, "Model Key", null);

    // Assert
    assertEquals(1, newModelVars.size());
    assertEquals("null", newModelVars.get("Model Key"));
  }
}

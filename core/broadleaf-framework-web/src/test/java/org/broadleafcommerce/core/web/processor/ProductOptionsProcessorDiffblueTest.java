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
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.jupiter.api.Test;

class ProductOptionsProcessorDiffblueTest {
  /**
   * Method under test: {@link ProductOptionsProcessor#getName()}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("product_options", (new ProductOptionsProcessor()).getName());
  }

  /**
   * Method under test: {@link ProductOptionsProcessor#getPrecedence()}
   */
  @Test
  void testGetPrecedence() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(10000, (new ProductOptionsProcessor()).getPrecedence());
  }

  /**
   * Method under test: {@link ProductOptionsProcessor#getPrecedence()}
   */
  @Test
  void testGetPrecedence2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionsProcessor productOptionsProcessor = new ProductOptionsProcessor();
    HashMap<String, Object> newModelVars = new HashMap<>();
    ProductBundleImpl product = new ProductBundleImpl();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    productOptionsProcessor.addProductOptionPricingToModel(newModelVars, product, context, new HashMap<>());

    // Act and Assert
    assertEquals(10000, productOptionsProcessor.getPrecedence());
  }

  /**
   * Method under test:
   * {@link ProductOptionsProcessor#addProductOptionPricingToModel(Map, Product, BroadleafTemplateContext, Map)}
   */
  @Test
  void testAddProductOptionPricingToModel() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionsProcessor productOptionsProcessor = new ProductOptionsProcessor();
    HashMap<String, Object> newModelVars = new HashMap<>();
    ProductBundleImpl product = new ProductBundleImpl();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);

    // Act
    productOptionsProcessor.addProductOptionPricingToModel(newModelVars, product, context, new HashMap<>());

    // Assert
    assertEquals(1, newModelVars.size());
    assertEquals("[]", newModelVars.get("skuPricing"));
    assertTrue(product.getMultiValueProductAttributes().isEmpty());
    assertTrue(product.getProductAttributes().isEmpty());
    assertTrue(product.getProductOptionValuesMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link ProductOptionsProcessor#createPricingDto(Sku, List, Map, BroadleafTemplateContext)}
   */
  @Test
  void testCreatePricingDto() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionsProcessor productOptionsProcessor = new ProductOptionsProcessor();
    SkuImpl sku = new SkuImpl();
    ArrayList<Long> productOptionValueIds = new ArrayList<>();

    // Act
    ProductOptionsProcessor.ProductOptionPricingDTO actualCreatePricingDtoResult = productOptionsProcessor
        .createPricingDto(sku, productOptionValueIds, new HashMap<>(), mock(BroadleafTemplateContext.class));

    // Assert
    assertEquals("Not Available", actualCreatePricingDtoResult.getPrice());
    assertNull(actualCreatePricingDtoResult.getRetailPrice());
    assertNull(actualCreatePricingDtoResult.getSalePrice());
    assertEquals(0, actualCreatePricingDtoResult.getSelectedOptions().length);
    assertFalse(actualCreatePricingDtoResult.isOnSale());
  }

  /**
   * Method under test:
   * {@link ProductOptionsProcessor#createPricingDto(Sku, List, Map, BroadleafTemplateContext)}
   */
  @Test
  void testCreatePricingDto2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionsProcessor productOptionsProcessor = new ProductOptionsProcessor();
    Sku sku = mock(Sku.class);
    when(sku.isOnSale()).thenReturn(true);
    when(sku.getPrice()).thenReturn(new Money());
    when(sku.getRetailPrice()).thenReturn(new Money());
    when(sku.getSalePrice()).thenReturn(new Money());
    ArrayList<Long> productOptionValueIds = new ArrayList<>();

    // Act
    ProductOptionsProcessor.ProductOptionPricingDTO actualCreatePricingDtoResult = productOptionsProcessor
        .createPricingDto(sku, productOptionValueIds, new HashMap<>(), mock(BroadleafTemplateContext.class));

    // Assert
    verify(sku).getPrice();
    verify(sku, atLeast(1)).getRetailPrice();
    verify(sku, atLeast(1)).getSalePrice();
    verify(sku).isOnSale();
    assertEquals("$0.00", actualCreatePricingDtoResult.getPrice());
    assertEquals("$0.00", actualCreatePricingDtoResult.getRetailPrice());
    assertEquals("$0.00", actualCreatePricingDtoResult.getSalePrice());
    assertEquals(0, actualCreatePricingDtoResult.getSelectedOptions().length);
    assertTrue(actualCreatePricingDtoResult.isOnSale());
  }

  /**
   * Method under test:
   * {@link ProductOptionsProcessor#addAllProductOptionsToModel(Map, Product)}
   */
  @Test
  void testAddAllProductOptionsToModel() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionsProcessor productOptionsProcessor = new ProductOptionsProcessor();
    HashMap<String, Object> newModelVars = new HashMap<>();
    ProductBundleImpl product = new ProductBundleImpl();

    // Act
    productOptionsProcessor.addAllProductOptionsToModel(newModelVars, product);

    // Assert
    assertEquals(1, newModelVars.size());
    assertEquals("[]", newModelVars.get("allProductOptions"));
    assertTrue(product.getProductOptionValuesMap().isEmpty());
  }

  /**
   * Method under test:
   * {@link ProductOptionsProcessor#addAllProductOptionsToModel(Map, Product)}
   */
  @Test
  void testAddAllProductOptionsToModel2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionsProcessor productOptionsProcessor = new ProductOptionsProcessor();
    HashMap<String, Object> newModelVars = new HashMap<>();
    ProductBundleImpl product = new ProductBundleImpl();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    productOptionsProcessor.addProductOptionPricingToModel(newModelVars, product, context, new HashMap<>());
    HashMap<String, Object> newModelVars2 = new HashMap<>();
    ProductBundleImpl product2 = new ProductBundleImpl();

    // Act
    productOptionsProcessor.addAllProductOptionsToModel(newModelVars2, product2);

    // Assert
    assertEquals(1, newModelVars2.size());
    assertEquals("[]", newModelVars2.get("allProductOptions"));
    assertEquals(product, product2);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionsProcessor.ProductOptionDTO#equals(Object)}
   *   <li>{@link ProductOptionsProcessor.ProductOptionDTO#hashCode()}
   * </ul>
   */
  @Test
  void testProductOptionDTOEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProductOptionsProcessor.ProductOptionDTO productOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();
    ProductOptionsProcessor.ProductOptionDTO productOptionDTO2 = (new ProductOptionsProcessor()).new ProductOptionDTO();

    // Act and Assert
    assertEquals(productOptionDTO, productOptionDTO2);
    int expectedHashCodeResult = productOptionDTO.hashCode();
    assertEquals(expectedHashCodeResult, productOptionDTO2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionsProcessor.ProductOptionDTO#equals(Object)}
   *   <li>{@link ProductOptionsProcessor.ProductOptionDTO#hashCode()}
   * </ul>
   */
  @Test
  void testProductOptionDTOEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ProductOptionsProcessor productOptionsProcessor = new ProductOptionsProcessor();
    HashMap<String, Object> newModelVars = new HashMap<>();
    ProductBundleImpl product = new ProductBundleImpl();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    productOptionsProcessor.addProductOptionPricingToModel(newModelVars, product, context, new HashMap<>());
    ProductOptionsProcessor.ProductOptionDTO productOptionDTO = productOptionsProcessor.new ProductOptionDTO();
    ProductOptionsProcessor.ProductOptionDTO productOptionDTO2 = (new ProductOptionsProcessor()).new ProductOptionDTO();

    // Act and Assert
    assertEquals(productOptionDTO, productOptionDTO2);
    int expectedHashCodeResult = productOptionDTO.hashCode();
    assertEquals(expectedHashCodeResult, productOptionDTO2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionsProcessor.ProductOptionDTO#equals(Object)}
   *   <li>{@link ProductOptionsProcessor.ProductOptionDTO#hashCode()}
   * </ul>
   */
  @Test
  void testProductOptionDTOEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ProductOptionsProcessor.ProductOptionDTO productOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();
    productOptionDTO.setId(1L);

    ProductOptionsProcessor.ProductOptionDTO productOptionDTO2 = (new ProductOptionsProcessor()).new ProductOptionDTO();
    productOptionDTO2.setId(1L);

    // Act and Assert
    assertEquals(productOptionDTO, productOptionDTO2);
    int expectedHashCodeResult = productOptionDTO.hashCode();
    assertEquals(expectedHashCodeResult, productOptionDTO2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionsProcessor.ProductOptionDTO#equals(Object)}
   *   <li>{@link ProductOptionsProcessor.ProductOptionDTO#hashCode()}
   * </ul>
   */
  @Test
  void testProductOptionDTOEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    ProductOptionsProcessor.ProductOptionDTO productOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();
    productOptionDTO.setType("Type");

    ProductOptionsProcessor.ProductOptionDTO productOptionDTO2 = (new ProductOptionsProcessor()).new ProductOptionDTO();
    productOptionDTO2.setType("Type");

    // Act and Assert
    assertEquals(productOptionDTO, productOptionDTO2);
    int expectedHashCodeResult = productOptionDTO.hashCode();
    assertEquals(expectedHashCodeResult, productOptionDTO2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionsProcessor.ProductOptionDTO#equals(Object)}
   *   <li>{@link ProductOptionsProcessor.ProductOptionDTO#hashCode()}
   * </ul>
   */
  @Test
  void testProductOptionDTOEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    ProductOptionsProcessor.ProductOptionDTO productOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();
    productOptionDTO.setValues(new HashMap<>());

    ProductOptionsProcessor.ProductOptionDTO productOptionDTO2 = (new ProductOptionsProcessor()).new ProductOptionDTO();
    productOptionDTO2.setValues(new HashMap<>());

    // Act and Assert
    assertEquals(productOptionDTO, productOptionDTO2);
    int expectedHashCodeResult = productOptionDTO.hashCode();
    assertEquals(expectedHashCodeResult, productOptionDTO2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionsProcessor.ProductOptionDTO#equals(Object)}
   *   <li>{@link ProductOptionsProcessor.ProductOptionDTO#hashCode()}
   * </ul>
   */
  @Test
  void testProductOptionDTOEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    ProductOptionsProcessor.ProductOptionDTO productOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();
    productOptionDTO.setSelectedValue("42");

    ProductOptionsProcessor.ProductOptionDTO productOptionDTO2 = (new ProductOptionsProcessor()).new ProductOptionDTO();
    productOptionDTO2.setSelectedValue("42");

    // Act and Assert
    assertEquals(productOptionDTO, productOptionDTO2);
    int expectedHashCodeResult = productOptionDTO.hashCode();
    assertEquals(expectedHashCodeResult, productOptionDTO2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionsProcessor.ProductOptionDTO#equals(Object)}
   *   <li>{@link ProductOptionsProcessor.ProductOptionDTO#hashCode()}
   * </ul>
   */
  @Test
  void testProductOptionDTOEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual7() {
    // Arrange
    ProductOptionsProcessor.ProductOptionDTO productOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();
    productOptionDTO.setPriceAdjustments(new HashMap<>());

    ProductOptionsProcessor.ProductOptionDTO productOptionDTO2 = (new ProductOptionsProcessor()).new ProductOptionDTO();
    productOptionDTO2.setPriceAdjustments(new HashMap<>());

    // Act and Assert
    assertEquals(productOptionDTO, productOptionDTO2);
    int expectedHashCodeResult = productOptionDTO.hashCode();
    assertEquals(expectedHashCodeResult, productOptionDTO2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionsProcessor.ProductOptionDTO#equals(Object)}
   *   <li>{@link ProductOptionsProcessor.ProductOptionDTO#hashCode()}
   * </ul>
   */
  @Test
  void testProductOptionDTOEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProductOptionsProcessor.ProductOptionDTO productOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();

    // Act and Assert
    assertEquals(productOptionDTO, productOptionDTO);
    int expectedHashCodeResult = productOptionDTO.hashCode();
    assertEquals(expectedHashCodeResult, productOptionDTO.hashCode());
  }

  /**
   * Method under test:
   * {@link ProductOptionsProcessor.ProductOptionDTO#equals(Object)}
   */
  @Test
  void testProductOptionDTOEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals((new ProductOptionsProcessor()).new ProductOptionDTO(), 1);
  }

  /**
   * Method under test:
   * {@link ProductOptionsProcessor.ProductOptionDTO#equals(Object)}
   */
  @Test
  void testProductOptionDTOEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ProductOptionsProcessor.ProductOptionDTO productOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();
    productOptionDTO.setId(1L);

    // Act and Assert
    assertNotEquals(productOptionDTO, (new ProductOptionsProcessor()).new ProductOptionDTO());
  }

  /**
   * Method under test:
   * {@link ProductOptionsProcessor.ProductOptionDTO#equals(Object)}
   */
  @Test
  void testProductOptionDTOEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ProductOptionsProcessor.ProductOptionDTO productOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();
    productOptionDTO.setType("Type");

    // Act and Assert
    assertNotEquals(productOptionDTO, (new ProductOptionsProcessor()).new ProductOptionDTO());
  }

  /**
   * Method under test:
   * {@link ProductOptionsProcessor.ProductOptionDTO#equals(Object)}
   */
  @Test
  void testProductOptionDTOEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ProductOptionsProcessor.ProductOptionDTO productOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();
    productOptionDTO.setValues(new HashMap<>());

    // Act and Assert
    assertNotEquals(productOptionDTO, (new ProductOptionsProcessor()).new ProductOptionDTO());
  }

  /**
   * Method under test:
   * {@link ProductOptionsProcessor.ProductOptionDTO#equals(Object)}
   */
  @Test
  void testProductOptionDTOEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ProductOptionsProcessor.ProductOptionDTO productOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();
    productOptionDTO.setSelectedValue("42");

    // Act and Assert
    assertNotEquals(productOptionDTO, (new ProductOptionsProcessor()).new ProductOptionDTO());
  }

  /**
   * Method under test:
   * {@link ProductOptionsProcessor.ProductOptionDTO#equals(Object)}
   */
  @Test
  void testProductOptionDTOEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ProductOptionsProcessor.ProductOptionDTO productOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();
    productOptionDTO.setPriceAdjustments(new HashMap<>());

    // Act and Assert
    assertNotEquals(productOptionDTO, (new ProductOptionsProcessor()).new ProductOptionDTO());
  }

  /**
   * Method under test:
   * {@link ProductOptionsProcessor.ProductOptionDTO#equals(Object)}
   */
  @Test
  void testProductOptionDTOEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ProductOptionsProcessor.ProductOptionDTO productOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();

    ProductOptionsProcessor.ProductOptionDTO productOptionDTO2 = (new ProductOptionsProcessor()).new ProductOptionDTO();
    productOptionDTO2.setId(1L);

    // Act and Assert
    assertNotEquals(productOptionDTO, productOptionDTO2);
  }

  /**
   * Method under test:
   * {@link ProductOptionsProcessor.ProductOptionDTO#equals(Object)}
   */
  @Test
  void testProductOptionDTOEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ProductOptionsProcessor.ProductOptionDTO productOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();

    ProductOptionsProcessor.ProductOptionDTO productOptionDTO2 = (new ProductOptionsProcessor()).new ProductOptionDTO();
    productOptionDTO2.setType("Type");

    // Act and Assert
    assertNotEquals(productOptionDTO, productOptionDTO2);
  }

  /**
   * Method under test:
   * {@link ProductOptionsProcessor.ProductOptionDTO#equals(Object)}
   */
  @Test
  void testProductOptionDTOEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ProductOptionsProcessor.ProductOptionDTO productOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();

    ProductOptionsProcessor.ProductOptionDTO productOptionDTO2 = (new ProductOptionsProcessor()).new ProductOptionDTO();
    productOptionDTO2.setValues(new HashMap<>());

    // Act and Assert
    assertNotEquals(productOptionDTO, productOptionDTO2);
  }

  /**
   * Method under test:
   * {@link ProductOptionsProcessor.ProductOptionDTO#equals(Object)}
   */
  @Test
  void testProductOptionDTOEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ProductOptionsProcessor.ProductOptionDTO productOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();

    ProductOptionsProcessor.ProductOptionDTO productOptionDTO2 = (new ProductOptionsProcessor()).new ProductOptionDTO();
    productOptionDTO2.setSelectedValue("42");

    // Act and Assert
    assertNotEquals(productOptionDTO, productOptionDTO2);
  }

  /**
   * Method under test:
   * {@link ProductOptionsProcessor.ProductOptionDTO#equals(Object)}
   */
  @Test
  void testProductOptionDTOEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    ProductOptionsProcessor.ProductOptionDTO productOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();

    ProductOptionsProcessor.ProductOptionDTO productOptionDTO2 = (new ProductOptionsProcessor()).new ProductOptionDTO();
    productOptionDTO2.setPriceAdjustments(new HashMap<>());

    // Act and Assert
    assertNotEquals(productOptionDTO, productOptionDTO2);
  }

  /**
   * Method under test:
   * {@link ProductOptionsProcessor.ProductOptionDTO#equals(Object)}
   */
  @Test
  void testProductOptionDTOEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals((new ProductOptionsProcessor()).new ProductOptionDTO(), null);
  }

  /**
   * Method under test:
   * {@link ProductOptionsProcessor.ProductOptionDTO#equals(Object)}
   */
  @Test
  void testProductOptionDTOEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals((new ProductOptionsProcessor()).new ProductOptionDTO(), "Different type to ProductOptionDTO");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ProductOptionsProcessor.ProductOptionDTO#ProductOptionDTO(ProductOptionsProcessor)}
   *   <li>{@link ProductOptionsProcessor.ProductOptionDTO#setId(Long)}
   *   <li>{@link ProductOptionsProcessor.ProductOptionDTO#setPriceAdjustments(Map)}
   *   <li>{@link ProductOptionsProcessor.ProductOptionDTO#setSelectedValue(String)}
   *   <li>{@link ProductOptionsProcessor.ProductOptionDTO#setType(String)}
   *   <li>{@link ProductOptionsProcessor.ProductOptionDTO#setValues(Map)}
   *   <li>{@link ProductOptionsProcessor.ProductOptionDTO#getId()}
   *   <li>{@link ProductOptionsProcessor.ProductOptionDTO#getPriceAdjustments()}
   *   <li>{@link ProductOptionsProcessor.ProductOptionDTO#getSelectedValue()}
   *   <li>{@link ProductOptionsProcessor.ProductOptionDTO#getType()}
   *   <li>{@link ProductOptionsProcessor.ProductOptionDTO#getValues()}
   * </ul>
   */
  @Test
  void testProductOptionDTOGettersAndSetters() {
    // Arrange and Act
    ProductOptionsProcessor.ProductOptionDTO actualProductOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();
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

    // Assert that nothing has changed
    assertEquals("42", actualSelectedValue);
    assertEquals("Type", actualType);
    assertEquals(1L, actualId.longValue());
    assertTrue(actualPriceAdjustments.isEmpty());
    assertTrue(actualValues.isEmpty());
    assertSame(priceAdjustments, actualPriceAdjustments);
    assertSame(values, actualValues);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionsProcessor.ProductOptionPricingDTO#equals(Object)}
   *   <li>{@link ProductOptionsProcessor.ProductOptionPricingDTO#hashCode()}
   * </ul>
   */
  @Test
  void testProductOptionPricingDTOEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProductOptionsProcessor.ProductOptionPricingDTO productOptionPricingDTO = (new ProductOptionsProcessor()).new ProductOptionPricingDTO();
    ProductOptionsProcessor.ProductOptionPricingDTO productOptionPricingDTO2 = (new ProductOptionsProcessor()).new ProductOptionPricingDTO();

    // Act and Assert
    assertEquals(productOptionPricingDTO, productOptionPricingDTO2);
    int expectedHashCodeResult = productOptionPricingDTO.hashCode();
    assertEquals(expectedHashCodeResult, productOptionPricingDTO2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionsProcessor.ProductOptionPricingDTO#equals(Object)}
   *   <li>{@link ProductOptionsProcessor.ProductOptionPricingDTO#hashCode()}
   * </ul>
   */
  @Test
  void testProductOptionPricingDTOEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ProductOptionsProcessor productOptionsProcessor = new ProductOptionsProcessor();
    HashMap<String, Object> newModelVars = new HashMap<>();
    ProductBundleImpl product = new ProductBundleImpl();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    productOptionsProcessor.addProductOptionPricingToModel(newModelVars, product, context, new HashMap<>());
    ProductOptionsProcessor.ProductOptionPricingDTO productOptionPricingDTO = productOptionsProcessor.new ProductOptionPricingDTO();
    ProductOptionsProcessor.ProductOptionPricingDTO productOptionPricingDTO2 = (new ProductOptionsProcessor()).new ProductOptionPricingDTO();

    // Act and Assert
    assertEquals(productOptionPricingDTO, productOptionPricingDTO2);
    int expectedHashCodeResult = productOptionPricingDTO.hashCode();
    assertEquals(expectedHashCodeResult, productOptionPricingDTO2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionsProcessor.ProductOptionPricingDTO#equals(Object)}
   *   <li>{@link ProductOptionsProcessor.ProductOptionPricingDTO#hashCode()}
   * </ul>
   */
  @Test
  void testProductOptionPricingDTOEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProductOptionsProcessor.ProductOptionPricingDTO productOptionPricingDTO = (new ProductOptionsProcessor()).new ProductOptionPricingDTO();

    // Act and Assert
    assertEquals(productOptionPricingDTO, productOptionPricingDTO);
    int expectedHashCodeResult = productOptionPricingDTO.hashCode();
    assertEquals(expectedHashCodeResult, productOptionPricingDTO.hashCode());
  }

  /**
   * Method under test:
   * {@link ProductOptionsProcessor.ProductOptionPricingDTO#equals(Object)}
   */
  @Test
  void testProductOptionPricingDTOEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ProductOptionsProcessor.ProductOptionPricingDTO productOptionPricingDTO = (new ProductOptionsProcessor()).new ProductOptionPricingDTO();
    productOptionPricingDTO.setPrice("Price");

    // Act and Assert
    assertNotEquals(productOptionPricingDTO, (new ProductOptionsProcessor()).new ProductOptionPricingDTO());
  }

  /**
   * Method under test:
   * {@link ProductOptionsProcessor.ProductOptionPricingDTO#equals(Object)}
   */
  @Test
  void testProductOptionPricingDTOEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals((new ProductOptionsProcessor()).new ProductOptionPricingDTO(), null);
  }

  /**
   * Method under test:
   * {@link ProductOptionsProcessor.ProductOptionPricingDTO#equals(Object)}
   */
  @Test
  void testProductOptionPricingDTOEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals((new ProductOptionsProcessor()).new ProductOptionPricingDTO(),
        "Different type to ProductOptionPricingDTO");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ProductOptionsProcessor.ProductOptionPricingDTO#ProductOptionPricingDTO(ProductOptionsProcessor)}
   *   <li>
   * {@link ProductOptionsProcessor.ProductOptionPricingDTO#setOnSale(boolean)}
   *   <li>{@link ProductOptionsProcessor.ProductOptionPricingDTO#setPrice(String)}
   *   <li>
   * {@link ProductOptionsProcessor.ProductOptionPricingDTO#setRetailPrice(String)}
   *   <li>
   * {@link ProductOptionsProcessor.ProductOptionPricingDTO#setSalePrice(String)}
   *   <li>
   * {@link ProductOptionsProcessor.ProductOptionPricingDTO#setSelectedOptions(Long[])}
   *   <li>{@link ProductOptionsProcessor.ProductOptionPricingDTO#getPrice()}
   *   <li>{@link ProductOptionsProcessor.ProductOptionPricingDTO#getRetailPrice()}
   *   <li>{@link ProductOptionsProcessor.ProductOptionPricingDTO#getSalePrice()}
   *   <li>
   * {@link ProductOptionsProcessor.ProductOptionPricingDTO#getSelectedOptions()}
   *   <li>{@link ProductOptionsProcessor.ProductOptionPricingDTO#isOnSale()}
   * </ul>
   */
  @Test
  void testProductOptionPricingDTOGettersAndSetters() {
    // Arrange and Act
    ProductOptionsProcessor.ProductOptionPricingDTO actualProductOptionPricingDTO = (new ProductOptionsProcessor()).new ProductOptionPricingDTO();
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

    // Assert that nothing has changed
    assertEquals("Price", actualPrice);
    assertEquals("Retail Price", actualRetailPrice);
    assertEquals("Sale Price", actualSalePrice);
    assertTrue(actualProductOptionPricingDTO.isOnSale());
    assertSame(skuOptions, actualSelectedOptions);
    assertArrayEquals(new Long[]{1L}, actualSelectedOptions);
  }

  /**
   * Method under test:
   * {@link ProductOptionsProcessor#writeJSONToModel(Map, String, Object)}
   */
  @Test
  void testWriteJSONToModel() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test:
   * {@link ProductOptionsProcessor#writeJSONToModel(Map, String, Object)}
   */
  @Test
  void testWriteJSONToModel2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionsProcessor productOptionsProcessor = new ProductOptionsProcessor();
    HashMap<String, Object> newModelVars = new HashMap<>();

    // Act
    productOptionsProcessor.writeJSONToModel(newModelVars, "Model Key", null);

    // Assert
    assertEquals(1, newModelVars.size());
    assertEquals("null", newModelVars.get("Model Key"));
  }

  /**
   * Method under test:
   * {@link ProductOptionsProcessor#writeJSONToModel(Map, String, Object)}
   */
  @Test
  void testWriteJSONToModel3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionsProcessor productOptionsProcessor = new ProductOptionsProcessor();
    HashMap<String, Object> newModelVars = new HashMap<>();
    ProductBundleImpl product = new ProductBundleImpl();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    productOptionsProcessor.addProductOptionPricingToModel(newModelVars, product, context, new HashMap<>());
    HashMap<String, Object> newModelVars2 = new HashMap<>();

    // Act
    productOptionsProcessor.writeJSONToModel(newModelVars2, "Model Key", "42");

    // Assert
    assertEquals(1, newModelVars2.size());
    assertEquals("\"42\"", newModelVars2.get("Model Key"));
  }

  /**
   * Method under test:
   * {@link ProductOptionsProcessor#writeJSONToModel(Map, String, Object)}
   */
  @Test
  void testWriteJSONToModel4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionsProcessor productOptionsProcessor = new ProductOptionsProcessor();

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
   * Method under test:
   * {@link ProductOptionsProcessor#writeJSONToModel(Map, String, Object)}
   */
  @Test
  void testWriteJSONToModel5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionsProcessor productOptionsProcessor = new ProductOptionsProcessor();
    HashMap<String, Object> newModelVars = new HashMap<>();

    // Act
    productOptionsProcessor.writeJSONToModel(newModelVars, "Model Key", 19088743);

    // Assert
    assertEquals(1, newModelVars.size());
    assertEquals("19088743", newModelVars.get("Model Key"));
  }
}

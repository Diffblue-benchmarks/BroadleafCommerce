/*-
 * #%L
 * BroadleafCommerce Framework Web
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
import org.broadleafcommerce.core.web.processor.ProductOptionsProcessor.ProductOptionDTO;
import org.broadleafcommerce.core.web.processor.ProductOptionsProcessor.ProductOptionPricingDTO;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductOptionsProcessorDiffblueTest {
  /**
   * Test {@link ProductOptionsProcessor#getName()}.
   * <p>
   * Method under test: {@link ProductOptionsProcessor#getName()}
   */
  @Test
  @DisplayName("Test getName()")
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
  void testGetPrecedence() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(10000, (new ProductOptionsProcessor()).getPrecedence());
  }

  /**
   * Test {@link ProductOptionsProcessor#getPrecedence()}.
   * <p>
   * Method under test: {@link ProductOptionsProcessor#getPrecedence()}
   */
  @Test
  @DisplayName("Test getPrecedence()")
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
   * Test
   * {@link ProductOptionsProcessor#addProductOptionPricingToModel(Map, Product, BroadleafTemplateContext, Map)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then {@link HashMap#HashMap()} size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionsProcessor#addProductOptionPricingToModel(Map, Product, BroadleafTemplateContext, Map)}
   */
  @Test
  @DisplayName("Test addProductOptionPricingToModel(Map, Product, BroadleafTemplateContext, Map); when ProductBundleImpl (default constructor); then HashMap() size is one")
  void testAddProductOptionPricingToModel_whenProductBundleImpl_thenHashMapSizeIsOne() {
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
  }

  /**
   * Test
   * {@link ProductOptionsProcessor#createPricingDto(Sku, List, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>Given {@link Money#Money()}.</li>
   *   <li>When {@link Sku} {@link Sku#getPrice()} return
   * {@link Money#Money()}.</li>
   *   <li>Then return Price is {@code £0.00}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionsProcessor#createPricingDto(Sku, List, Map, BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test createPricingDto(Sku, List, Map, BroadleafTemplateContext); given Money(); when Sku getPrice() return Money(); then return Price is '£0.00'")
  void testCreatePricingDto_givenMoney_whenSkuGetPriceReturnMoney_thenReturnPriceIs000() {
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
    assertEquals("£0.00", actualCreatePricingDtoResult.getPrice());
    assertEquals("£0.00", actualCreatePricingDtoResult.getRetailPrice());
    assertEquals("£0.00", actualCreatePricingDtoResult.getSalePrice());
    assertTrue(actualCreatePricingDtoResult.isOnSale());
  }

  /**
   * Test
   * {@link ProductOptionsProcessor#createPricingDto(Sku, List, Map, BroadleafTemplateContext)}.
   * <ul>
   *   <li>When {@link SkuImpl} (default constructor).</li>
   *   <li>Then return Price is {@code Not Available}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionsProcessor#createPricingDto(Sku, List, Map, BroadleafTemplateContext)}
   */
  @Test
  @DisplayName("Test createPricingDto(Sku, List, Map, BroadleafTemplateContext); when SkuImpl (default constructor); then return Price is 'Not Available'")
  void testCreatePricingDto_whenSkuImpl_thenReturnPriceIsNotAvailable() {
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
    assertFalse(actualCreatePricingDtoResult.isOnSale());
  }

  /**
   * Test
   * {@link ProductOptionsProcessor#addAllProductOptionsToModel(Map, Product)}.
   * <p>
   * Method under test:
   * {@link ProductOptionsProcessor#addAllProductOptionsToModel(Map, Product)}
   */
  @Test
  @DisplayName("Test addAllProductOptionsToModel(Map, Product)")
  void testAddAllProductOptionsToModel() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionsProcessor productOptionsProcessor = new ProductOptionsProcessor();
    HashMap<String, Object> newModelVars = new HashMap<>();
    ProductBundleImpl product = new ProductBundleImpl();
    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    productOptionsProcessor.addProductOptionPricingToModel(newModelVars, product, context, new HashMap<>());
    HashMap<String, Object> newModelVars2 = new HashMap<>();

    // Act
    productOptionsProcessor.addAllProductOptionsToModel(newModelVars2, new ProductBundleImpl());

    // Assert
    assertEquals(1, newModelVars2.size());
    assertEquals("[]", newModelVars2.get("allProductOptions"));
  }

  /**
   * Test
   * {@link ProductOptionsProcessor#addAllProductOptionsToModel(Map, Product)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then {@link HashMap#HashMap()} size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionsProcessor#addAllProductOptionsToModel(Map, Product)}
   */
  @Test
  @DisplayName("Test addAllProductOptionsToModel(Map, Product); when ProductBundleImpl (default constructor); then HashMap() size is one")
  void testAddAllProductOptionsToModel_whenProductBundleImpl_thenHashMapSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}, and
   * {@link ProductOptionDTO#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionsProcessor.ProductOptionDTO#equals(Object)}
   *   <li>{@link ProductOptionsProcessor.ProductOptionDTO#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProductOptionDTO equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}, and
   * {@link ProductOptionDTO#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionsProcessor.ProductOptionDTO#equals(Object)}
   *   <li>{@link ProductOptionsProcessor.ProductOptionDTO#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProductOptionDTO equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}, and
   * {@link ProductOptionDTO#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionsProcessor.ProductOptionDTO#equals(Object)}
   *   <li>{@link ProductOptionsProcessor.ProductOptionDTO#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProductOptionDTO equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}, and
   * {@link ProductOptionDTO#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionsProcessor.ProductOptionDTO#equals(Object)}
   *   <li>{@link ProductOptionsProcessor.ProductOptionDTO#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProductOptionDTO equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}, and
   * {@link ProductOptionDTO#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionsProcessor.ProductOptionDTO#equals(Object)}
   *   <li>{@link ProductOptionsProcessor.ProductOptionDTO#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProductOptionDTO equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}, and
   * {@link ProductOptionDTO#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionsProcessor.ProductOptionDTO#equals(Object)}
   *   <li>{@link ProductOptionsProcessor.ProductOptionDTO#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProductOptionDTO equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}, and
   * {@link ProductOptionDTO#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionsProcessor.ProductOptionDTO#equals(Object)}
   *   <li>{@link ProductOptionsProcessor.ProductOptionDTO#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProductOptionDTO equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test ProductOptionDTO {@link ProductOptionDTO#equals(Object)}, and
   * {@link ProductOptionDTO#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionsProcessor.ProductOptionDTO#equals(Object)}
   *   <li>{@link ProductOptionsProcessor.ProductOptionDTO#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProductOptionDTO equals(Object), and hashCode(); when other is same; then return equal")
  void testProductOptionDTOEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProductOptionsProcessor.ProductOptionDTO productOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();

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
   * Method under test:
   * {@link ProductOptionsProcessor.ProductOptionDTO#equals(Object)}
   */
  @Test
  @DisplayName("Test ProductOptionDTO equals(Object); when other is different; then return not equal")
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
   * Method under test:
   * {@link ProductOptionsProcessor.ProductOptionDTO#equals(Object)}
   */
  @Test
  @DisplayName("Test ProductOptionDTO equals(Object); when other is different; then return not equal")
  void testProductOptionDTOEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ProductOptionsProcessor.ProductOptionDTO productOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();
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
   * Method under test:
   * {@link ProductOptionsProcessor.ProductOptionDTO#equals(Object)}
   */
  @Test
  @DisplayName("Test ProductOptionDTO equals(Object); when other is different; then return not equal")
  void testProductOptionDTOEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ProductOptionsProcessor.ProductOptionDTO productOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();
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
   * Method under test:
   * {@link ProductOptionsProcessor.ProductOptionDTO#equals(Object)}
   */
  @Test
  @DisplayName("Test ProductOptionDTO equals(Object); when other is different; then return not equal")
  void testProductOptionDTOEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ProductOptionsProcessor.ProductOptionDTO productOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();
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
   * Method under test:
   * {@link ProductOptionsProcessor.ProductOptionDTO#equals(Object)}
   */
  @Test
  @DisplayName("Test ProductOptionDTO equals(Object); when other is different; then return not equal")
  void testProductOptionDTOEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ProductOptionsProcessor.ProductOptionDTO productOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();
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
   * Method under test:
   * {@link ProductOptionsProcessor.ProductOptionDTO#equals(Object)}
   */
  @Test
  @DisplayName("Test ProductOptionDTO equals(Object); when other is different; then return not equal")
  void testProductOptionDTOEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ProductOptionsProcessor.ProductOptionDTO productOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();
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
   * Method under test:
   * {@link ProductOptionsProcessor.ProductOptionDTO#equals(Object)}
   */
  @Test
  @DisplayName("Test ProductOptionDTO equals(Object); when other is different; then return not equal")
  void testProductOptionDTOEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ProductOptionsProcessor.ProductOptionDTO productOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();

    ProductOptionsProcessor.ProductOptionDTO productOptionDTO2 = (new ProductOptionsProcessor()).new ProductOptionDTO();
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
   * Method under test:
   * {@link ProductOptionsProcessor.ProductOptionDTO#equals(Object)}
   */
  @Test
  @DisplayName("Test ProductOptionDTO equals(Object); when other is different; then return not equal")
  void testProductOptionDTOEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ProductOptionsProcessor.ProductOptionDTO productOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();

    ProductOptionsProcessor.ProductOptionDTO productOptionDTO2 = (new ProductOptionsProcessor()).new ProductOptionDTO();
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
   * Method under test:
   * {@link ProductOptionsProcessor.ProductOptionDTO#equals(Object)}
   */
  @Test
  @DisplayName("Test ProductOptionDTO equals(Object); when other is different; then return not equal")
  void testProductOptionDTOEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ProductOptionsProcessor.ProductOptionDTO productOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();

    ProductOptionsProcessor.ProductOptionDTO productOptionDTO2 = (new ProductOptionsProcessor()).new ProductOptionDTO();
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
   * Method under test:
   * {@link ProductOptionsProcessor.ProductOptionDTO#equals(Object)}
   */
  @Test
  @DisplayName("Test ProductOptionDTO equals(Object); when other is different; then return not equal")
  void testProductOptionDTOEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ProductOptionsProcessor.ProductOptionDTO productOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();

    ProductOptionsProcessor.ProductOptionDTO productOptionDTO2 = (new ProductOptionsProcessor()).new ProductOptionDTO();
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
   * Method under test:
   * {@link ProductOptionsProcessor.ProductOptionDTO#equals(Object)}
   */
  @Test
  @DisplayName("Test ProductOptionDTO equals(Object); when other is different; then return not equal")
  void testProductOptionDTOEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    ProductOptionsProcessor.ProductOptionDTO productOptionDTO = (new ProductOptionsProcessor()).new ProductOptionDTO();

    ProductOptionsProcessor.ProductOptionDTO productOptionDTO2 = (new ProductOptionsProcessor()).new ProductOptionDTO();
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
   * Method under test:
   * {@link ProductOptionsProcessor.ProductOptionDTO#equals(Object)}
   */
  @Test
  @DisplayName("Test ProductOptionDTO equals(Object); when other is 'null'; then return not equal")
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
   * Method under test:
   * {@link ProductOptionsProcessor.ProductOptionDTO#equals(Object)}
   */
  @Test
  @DisplayName("Test ProductOptionDTO equals(Object); when other is wrong type; then return not equal")
  void testProductOptionDTOEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals((new ProductOptionsProcessor()).new ProductOptionDTO(), "Different type to ProductOptionDTO");
  }

  /**
   * Test ProductOptionDTO getters and setters.
   * <p>
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
  @DisplayName("Test ProductOptionDTO getters and setters")
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
   * Test ProductOptionPricingDTO {@link ProductOptionPricingDTO#equals(Object)},
   * and {@link ProductOptionPricingDTO#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionsProcessor.ProductOptionPricingDTO#equals(Object)}
   *   <li>{@link ProductOptionsProcessor.ProductOptionPricingDTO#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProductOptionPricingDTO equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test ProductOptionPricingDTO {@link ProductOptionPricingDTO#equals(Object)},
   * and {@link ProductOptionPricingDTO#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionsProcessor.ProductOptionPricingDTO#equals(Object)}
   *   <li>{@link ProductOptionsProcessor.ProductOptionPricingDTO#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProductOptionPricingDTO equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test ProductOptionPricingDTO {@link ProductOptionPricingDTO#equals(Object)},
   * and {@link ProductOptionPricingDTO#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionsProcessor.ProductOptionPricingDTO#equals(Object)}
   *   <li>{@link ProductOptionsProcessor.ProductOptionPricingDTO#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ProductOptionPricingDTO equals(Object), and hashCode(); when other is same; then return equal")
  void testProductOptionPricingDTOEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProductOptionsProcessor.ProductOptionPricingDTO productOptionPricingDTO = (new ProductOptionsProcessor()).new ProductOptionPricingDTO();

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
   * Method under test:
   * {@link ProductOptionsProcessor.ProductOptionPricingDTO#equals(Object)}
   */
  @Test
  @DisplayName("Test ProductOptionPricingDTO equals(Object); when other is different; then return not equal")
  void testProductOptionPricingDTOEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ProductOptionsProcessor.ProductOptionPricingDTO productOptionPricingDTO = (new ProductOptionsProcessor()).new ProductOptionPricingDTO();
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
   * Method under test:
   * {@link ProductOptionsProcessor.ProductOptionPricingDTO#equals(Object)}
   */
  @Test
  @DisplayName("Test ProductOptionPricingDTO equals(Object); when other is 'null'; then return not equal")
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
   * Method under test:
   * {@link ProductOptionsProcessor.ProductOptionPricingDTO#equals(Object)}
   */
  @Test
  @DisplayName("Test ProductOptionPricingDTO equals(Object); when other is wrong type; then return not equal")
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
  @DisplayName("Test ProductOptionPricingDTO getters and setters")
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
   * Test {@link ProductOptionsProcessor#writeJSONToModel(Map, String, Object)}.
   * <p>
   * Method under test:
   * {@link ProductOptionsProcessor#writeJSONToModel(Map, String, Object)}
   */
  @Test
  @DisplayName("Test writeJSONToModel(Map, String, Object)")
  void testWriteJSONToModel() {
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
   * Test {@link ProductOptionsProcessor#writeJSONToModel(Map, String, Object)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code 42}.</li>
   *   <li>Then {@link HashMap#HashMap()} size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionsProcessor#writeJSONToModel(Map, String, Object)}
   */
  @Test
  @DisplayName("Test writeJSONToModel(Map, String, Object); given 'foo'; when HashMap() 'foo' is '42'; then HashMap() size is two")
  void testWriteJSONToModel_givenFoo_whenHashMapFooIs42_thenHashMapSizeIsTwo() {
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
   * Test {@link ProductOptionsProcessor#writeJSONToModel(Map, String, Object)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then {@link HashMap#HashMap()} {@code Model Key} is {@code "42"}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionsProcessor#writeJSONToModel(Map, String, Object)}
   */
  @Test
  @DisplayName("Test writeJSONToModel(Map, String, Object); when '42'; then HashMap() 'Model Key' is '\"42\"'")
  void testWriteJSONToModel_when42_thenHashMapModelKeyIs42() {
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
   * Test {@link ProductOptionsProcessor#writeJSONToModel(Map, String, Object)}.
   * <ul>
   *   <li>When {@code 19088743}.</li>
   *   <li>Then {@link HashMap#HashMap()} {@code Model Key} is
   * {@code 19088743}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionsProcessor#writeJSONToModel(Map, String, Object)}
   */
  @Test
  @DisplayName("Test writeJSONToModel(Map, String, Object); when '19088743'; then HashMap() 'Model Key' is '19088743'")
  void testWriteJSONToModel_when19088743_thenHashMapModelKeyIs19088743() {
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

  /**
   * Test {@link ProductOptionsProcessor#writeJSONToModel(Map, String, Object)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link HashMap#HashMap()} {@code Model Key} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionsProcessor#writeJSONToModel(Map, String, Object)}
   */
  @Test
  @DisplayName("Test writeJSONToModel(Map, String, Object); when 'null'; then HashMap() 'Model Key' is 'null'")
  void testWriteJSONToModel_whenNull_thenHashMapModelKeyIsNull() {
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
}

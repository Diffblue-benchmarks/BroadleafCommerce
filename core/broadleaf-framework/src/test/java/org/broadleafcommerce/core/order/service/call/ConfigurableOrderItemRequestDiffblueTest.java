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
package org.broadleafcommerce.core.order.service.call;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.junit.Test;

public class ConfigurableOrderItemRequestDiffblueTest {
  /**
   * Test {@link ConfigurableOrderItemRequest#setProduct(Product)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then {@link ConfigurableOrderItemRequest} (default constructor) ProductId
   * longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigurableOrderItemRequest#setProduct(Product)}
   */
  @Test
  public void testSetProduct_givenOne_thenConfigurableOrderItemRequestProductIdLongValueIsOne() {
    // Arrange
    ConfigurableOrderItemRequest configurableOrderItemRequest = new ConfigurableOrderItemRequest();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getId()).thenReturn(1L);

    // Act
    configurableOrderItemRequest.setProduct(product);

    // Assert
    verify(product).getId();
    assertEquals(1L, configurableOrderItemRequest.getProductId().longValue());
    assertSame(product, configurableOrderItemRequest.getProduct());
  }

  /**
   * Test {@link ConfigurableOrderItemRequest#setSku(Sku)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then {@link ConfigurableOrderItemRequest} (default constructor) SkuId
   * longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigurableOrderItemRequest#setSku(Sku)}
   */
  @Test
  public void testSetSku_givenOne_thenConfigurableOrderItemRequestSkuIdLongValueIsOne() {
    // Arrange
    ConfigurableOrderItemRequest configurableOrderItemRequest = new ConfigurableOrderItemRequest();
    SkuImpl sku = mock(SkuImpl.class);
    when(sku.getId()).thenReturn(1L);

    // Act
    configurableOrderItemRequest.setSku(sku);

    // Assert
    verify(sku).getId();
    assertEquals(1L, configurableOrderItemRequest.getSkuId().longValue());
    assertSame(sku, configurableOrderItemRequest.getSku());
  }

  /**
   * Test {@link ConfigurableOrderItemRequest#getIsMultiSelect()}.
   * <ul>
   *   <li>Given {@link ConfigurableOrderItemRequest} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigurableOrderItemRequest#getIsMultiSelect()}
   */
  @Test
  public void testGetIsMultiSelect_givenConfigurableOrderItemRequest_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new ConfigurableOrderItemRequest()).getIsMultiSelect());
  }

  /**
   * Test {@link ConfigurableOrderItemRequest#getIsMultiSelect()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigurableOrderItemRequest#getIsMultiSelect()}
   */
  @Test
  public void testGetIsMultiSelect_givenHashMapComputeIfPresentFooAndBiFunction_thenReturnTrue() {
    // Arrange
    HashMap<String, String> additionalAttributes = new HashMap<>();
    additionalAttributes.computeIfPresent("foo", mock(BiFunction.class));

    ConfigurableOrderItemRequest configurableOrderItemRequest = new ConfigurableOrderItemRequest();
    configurableOrderItemRequest.setAdditionalAttributes(additionalAttributes);
    configurableOrderItemRequest.setCategoryId(1L);
    configurableOrderItemRequest.setChildOrderItems(new ArrayList<>());
    configurableOrderItemRequest.setDiscountsAllowed(true);
    configurableOrderItemRequest.setDisplayPrice(new Money());
    configurableOrderItemRequest.setExpandable(true);
    configurableOrderItemRequest.setFirstExpandable(true);
    configurableOrderItemRequest.setHasConfigurationError(true);
    configurableOrderItemRequest.setHasOverridenPrice(true);
    configurableOrderItemRequest.setItemAttributes(new HashMap<>());
    configurableOrderItemRequest.setLastExpandable(true);
    configurableOrderItemRequest.setMaxQuantity(3);
    configurableOrderItemRequest.setMinQuantity(1);
    configurableOrderItemRequest.setOrderItemId(1L);
    configurableOrderItemRequest.setOrderItemIndex(1);
    configurableOrderItemRequest.setOverrideRetailPrice(new Money());
    configurableOrderItemRequest.setOverrideSalePrice(new Money());
    configurableOrderItemRequest.setParentOrderItemId(1L);
    configurableOrderItemRequest.setPricingModelType("Pricing Model Type");
    configurableOrderItemRequest.setProductChoices(new ArrayList<>());
    configurableOrderItemRequest.setProductId(1L);
    configurableOrderItemRequest.setQuantity(1);
    configurableOrderItemRequest.setSkuId(1L);
    configurableOrderItemRequest.setIsMultiSelect(true);

    // Act and Assert
    assertTrue(configurableOrderItemRequest.getIsMultiSelect());
  }

  /**
   * Test {@link ConfigurableOrderItemRequest#getIsMultiSelect()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigurableOrderItemRequest#getIsMultiSelect()}
   */
  @Test
  public void testGetIsMultiSelect_thenReturnTrue() {
    // Arrange
    ConfigurableOrderItemRequest configurableOrderItemRequest = new ConfigurableOrderItemRequest();
    configurableOrderItemRequest.setAdditionalAttributes(new HashMap<>());
    configurableOrderItemRequest.setCategoryId(1L);
    configurableOrderItemRequest.setChildOrderItems(new ArrayList<>());
    configurableOrderItemRequest.setDiscountsAllowed(true);
    configurableOrderItemRequest.setDisplayPrice(new Money());
    configurableOrderItemRequest.setExpandable(true);
    configurableOrderItemRequest.setFirstExpandable(true);
    configurableOrderItemRequest.setHasConfigurationError(true);
    configurableOrderItemRequest.setHasOverridenPrice(true);
    configurableOrderItemRequest.setItemAttributes(new HashMap<>());
    configurableOrderItemRequest.setLastExpandable(true);
    configurableOrderItemRequest.setMaxQuantity(3);
    configurableOrderItemRequest.setMinQuantity(1);
    configurableOrderItemRequest.setOrderItemId(1L);
    configurableOrderItemRequest.setOrderItemIndex(1);
    configurableOrderItemRequest.setOverrideRetailPrice(new Money());
    configurableOrderItemRequest.setOverrideSalePrice(new Money());
    configurableOrderItemRequest.setParentOrderItemId(1L);
    configurableOrderItemRequest.setPricingModelType("Pricing Model Type");
    configurableOrderItemRequest.setProductChoices(new ArrayList<>());
    configurableOrderItemRequest.setProductId(1L);
    configurableOrderItemRequest.setQuantity(1);
    configurableOrderItemRequest.setSkuId(1L);
    configurableOrderItemRequest.setIsMultiSelect(true);

    // Act and Assert
    assertTrue(configurableOrderItemRequest.getIsMultiSelect());
  }

  /**
   * Test {@link ConfigurableOrderItemRequest#getQuantity()}.
   * <ul>
   *   <li>Given {@link ConfigurableOrderItemRequest} (default constructor)
   * MinQuantity is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigurableOrderItemRequest#getQuantity()}
   */
  @Test
  public void testGetQuantity_givenConfigurableOrderItemRequestMinQuantityIsOne() {
    // Arrange
    ConfigurableOrderItemRequest configurableOrderItemRequest = new ConfigurableOrderItemRequest();
    configurableOrderItemRequest.setAdditionalAttributes(new HashMap<>());
    configurableOrderItemRequest.setCategoryId(1L);
    configurableOrderItemRequest.setChildOrderItems(new ArrayList<>());
    configurableOrderItemRequest.setDiscountsAllowed(true);
    configurableOrderItemRequest.setDisplayPrice(new Money());
    configurableOrderItemRequest.setExpandable(true);
    configurableOrderItemRequest.setFirstExpandable(true);
    configurableOrderItemRequest.setHasConfigurationError(true);
    configurableOrderItemRequest.setHasOverridenPrice(true);
    configurableOrderItemRequest.setIsMultiSelect(true);
    configurableOrderItemRequest.setItemAttributes(new HashMap<>());
    configurableOrderItemRequest.setLastExpandable(true);
    configurableOrderItemRequest.setMaxQuantity(3);
    configurableOrderItemRequest.setMinQuantity(1);
    configurableOrderItemRequest.setOrderItemId(1L);
    configurableOrderItemRequest.setOrderItemIndex(1);
    configurableOrderItemRequest.setOverrideRetailPrice(new Money());
    configurableOrderItemRequest.setOverrideSalePrice(new Money());
    configurableOrderItemRequest.setParentOrderItemId(1L);
    configurableOrderItemRequest.setPricingModelType("Pricing Model Type");
    configurableOrderItemRequest.setProductChoices(new ArrayList<>());
    configurableOrderItemRequest.setProductId(1L);
    configurableOrderItemRequest.setSkuId(1L);
    configurableOrderItemRequest.setQuantity(null);

    // Act and Assert
    assertEquals(1, configurableOrderItemRequest.getQuantity().intValue());
  }

  /**
   * Test {@link ConfigurableOrderItemRequest#getQuantity()}.
   * <ul>
   *   <li>Given {@link ConfigurableOrderItemRequest} (default constructor) Quantity
   * is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigurableOrderItemRequest#getQuantity()}
   */
  @Test
  public void testGetQuantity_givenConfigurableOrderItemRequestQuantityIsOne() {
    // Arrange
    ConfigurableOrderItemRequest configurableOrderItemRequest = new ConfigurableOrderItemRequest();
    configurableOrderItemRequest.setAdditionalAttributes(new HashMap<>());
    configurableOrderItemRequest.setCategoryId(1L);
    configurableOrderItemRequest.setChildOrderItems(new ArrayList<>());
    configurableOrderItemRequest.setDiscountsAllowed(true);
    configurableOrderItemRequest.setDisplayPrice(new Money());
    configurableOrderItemRequest.setExpandable(true);
    configurableOrderItemRequest.setFirstExpandable(true);
    configurableOrderItemRequest.setHasConfigurationError(true);
    configurableOrderItemRequest.setHasOverridenPrice(true);
    configurableOrderItemRequest.setIsMultiSelect(true);
    configurableOrderItemRequest.setItemAttributes(new HashMap<>());
    configurableOrderItemRequest.setLastExpandable(true);
    configurableOrderItemRequest.setMaxQuantity(3);
    configurableOrderItemRequest.setOrderItemId(1L);
    configurableOrderItemRequest.setOrderItemIndex(1);
    configurableOrderItemRequest.setOverrideRetailPrice(new Money());
    configurableOrderItemRequest.setOverrideSalePrice(new Money());
    configurableOrderItemRequest.setParentOrderItemId(1L);
    configurableOrderItemRequest.setPricingModelType("Pricing Model Type");
    configurableOrderItemRequest.setProductChoices(new ArrayList<>());
    configurableOrderItemRequest.setProductId(1L);
    configurableOrderItemRequest.setQuantity(1);
    configurableOrderItemRequest.setSkuId(1L);
    configurableOrderItemRequest.setMinQuantity(null);

    // Act and Assert
    assertEquals(1, configurableOrderItemRequest.getQuantity().intValue());
  }

  /**
   * Test {@link ConfigurableOrderItemRequest#getQuantity()}.
   * <ul>
   *   <li>Given {@link ConfigurableOrderItemRequest} (default constructor).</li>
   *   <li>Then return intValue is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigurableOrderItemRequest#getQuantity()}
   */
  @Test
  public void testGetQuantity_givenConfigurableOrderItemRequest_thenReturnIntValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new ConfigurableOrderItemRequest()).getQuantity().intValue());
  }

  /**
   * Test {@link ConfigurableOrderItemRequest#getMinQuantity()}.
   * <ul>
   *   <li>Given {@link ConfigurableOrderItemRequest} (default constructor).</li>
   *   <li>Then return intValue is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigurableOrderItemRequest#getMinQuantity()}
   */
  @Test
  public void testGetMinQuantity_givenConfigurableOrderItemRequest_thenReturnIntValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new ConfigurableOrderItemRequest()).getMinQuantity().intValue());
  }

  /**
   * Test {@link ConfigurableOrderItemRequest#getMinQuantity()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigurableOrderItemRequest#getMinQuantity()}
   */
  @Test
  public void testGetMinQuantity_givenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    HashMap<String, String> additionalAttributes = new HashMap<>();
    additionalAttributes.computeIfPresent("foo", mock(BiFunction.class));

    ConfigurableOrderItemRequest configurableOrderItemRequest = new ConfigurableOrderItemRequest();
    configurableOrderItemRequest.setAdditionalAttributes(additionalAttributes);
    configurableOrderItemRequest.setCategoryId(1L);
    configurableOrderItemRequest.setChildOrderItems(new ArrayList<>());
    configurableOrderItemRequest.setDiscountsAllowed(true);
    configurableOrderItemRequest.setDisplayPrice(new Money());
    configurableOrderItemRequest.setExpandable(true);
    configurableOrderItemRequest.setFirstExpandable(true);
    configurableOrderItemRequest.setHasConfigurationError(true);
    configurableOrderItemRequest.setHasOverridenPrice(true);
    configurableOrderItemRequest.setIsMultiSelect(true);
    configurableOrderItemRequest.setItemAttributes(new HashMap<>());
    configurableOrderItemRequest.setLastExpandable(true);
    configurableOrderItemRequest.setMaxQuantity(3);
    configurableOrderItemRequest.setOrderItemId(1L);
    configurableOrderItemRequest.setOrderItemIndex(1);
    configurableOrderItemRequest.setOverrideRetailPrice(new Money());
    configurableOrderItemRequest.setOverrideSalePrice(new Money());
    configurableOrderItemRequest.setParentOrderItemId(1L);
    configurableOrderItemRequest.setPricingModelType("Pricing Model Type");
    configurableOrderItemRequest.setProductChoices(new ArrayList<>());
    configurableOrderItemRequest.setProductId(1L);
    configurableOrderItemRequest.setQuantity(1);
    configurableOrderItemRequest.setSkuId(1L);
    configurableOrderItemRequest.setMinQuantity(1);

    // Act and Assert
    assertEquals(1, configurableOrderItemRequest.getMinQuantity().intValue());
  }

  /**
   * Test {@link ConfigurableOrderItemRequest#getMinQuantity()}.
   * <ul>
   *   <li>Then return intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigurableOrderItemRequest#getMinQuantity()}
   */
  @Test
  public void testGetMinQuantity_thenReturnIntValueIsOne() {
    // Arrange
    ConfigurableOrderItemRequest configurableOrderItemRequest = new ConfigurableOrderItemRequest();
    configurableOrderItemRequest.setAdditionalAttributes(new HashMap<>());
    configurableOrderItemRequest.setCategoryId(1L);
    configurableOrderItemRequest.setChildOrderItems(new ArrayList<>());
    configurableOrderItemRequest.setDiscountsAllowed(true);
    configurableOrderItemRequest.setDisplayPrice(new Money());
    configurableOrderItemRequest.setExpandable(true);
    configurableOrderItemRequest.setFirstExpandable(true);
    configurableOrderItemRequest.setHasConfigurationError(true);
    configurableOrderItemRequest.setHasOverridenPrice(true);
    configurableOrderItemRequest.setIsMultiSelect(true);
    configurableOrderItemRequest.setItemAttributes(new HashMap<>());
    configurableOrderItemRequest.setLastExpandable(true);
    configurableOrderItemRequest.setMaxQuantity(3);
    configurableOrderItemRequest.setOrderItemId(1L);
    configurableOrderItemRequest.setOrderItemIndex(1);
    configurableOrderItemRequest.setOverrideRetailPrice(new Money());
    configurableOrderItemRequest.setOverrideSalePrice(new Money());
    configurableOrderItemRequest.setParentOrderItemId(1L);
    configurableOrderItemRequest.setPricingModelType("Pricing Model Type");
    configurableOrderItemRequest.setProductChoices(new ArrayList<>());
    configurableOrderItemRequest.setProductId(1L);
    configurableOrderItemRequest.setQuantity(1);
    configurableOrderItemRequest.setSkuId(1L);
    configurableOrderItemRequest.setMinQuantity(1);

    // Act and Assert
    assertEquals(1, configurableOrderItemRequest.getMinQuantity().intValue());
  }

  /**
   * Test {@link ConfigurableOrderItemRequest#getHasOverridenPrice()}.
   * <ul>
   *   <li>Given {@link ConfigurableOrderItemRequest} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConfigurableOrderItemRequest#getHasOverridenPrice()}
   */
  @Test
  public void testGetHasOverridenPrice_givenConfigurableOrderItemRequest_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new ConfigurableOrderItemRequest()).getHasOverridenPrice());
  }

  /**
   * Test {@link ConfigurableOrderItemRequest#getHasOverridenPrice()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConfigurableOrderItemRequest#getHasOverridenPrice()}
   */
  @Test
  public void testGetHasOverridenPrice_givenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    HashMap<String, String> additionalAttributes = new HashMap<>();
    additionalAttributes.computeIfPresent("foo", mock(BiFunction.class));

    ConfigurableOrderItemRequest configurableOrderItemRequest = new ConfigurableOrderItemRequest();
    configurableOrderItemRequest.setAdditionalAttributes(additionalAttributes);
    configurableOrderItemRequest.setCategoryId(1L);
    configurableOrderItemRequest.setChildOrderItems(new ArrayList<>());
    configurableOrderItemRequest.setDiscountsAllowed(true);
    configurableOrderItemRequest.setDisplayPrice(new Money());
    configurableOrderItemRequest.setExpandable(true);
    configurableOrderItemRequest.setFirstExpandable(true);
    configurableOrderItemRequest.setHasConfigurationError(true);
    configurableOrderItemRequest.setIsMultiSelect(true);
    configurableOrderItemRequest.setItemAttributes(new HashMap<>());
    configurableOrderItemRequest.setLastExpandable(true);
    configurableOrderItemRequest.setMaxQuantity(3);
    configurableOrderItemRequest.setMinQuantity(1);
    configurableOrderItemRequest.setOrderItemId(1L);
    configurableOrderItemRequest.setOrderItemIndex(1);
    configurableOrderItemRequest.setOverrideRetailPrice(new Money());
    configurableOrderItemRequest.setOverrideSalePrice(new Money());
    configurableOrderItemRequest.setParentOrderItemId(1L);
    configurableOrderItemRequest.setPricingModelType("Pricing Model Type");
    configurableOrderItemRequest.setProductChoices(new ArrayList<>());
    configurableOrderItemRequest.setProductId(1L);
    configurableOrderItemRequest.setQuantity(1);
    configurableOrderItemRequest.setSkuId(1L);
    configurableOrderItemRequest.setHasOverridenPrice(true);

    // Act and Assert
    assertTrue(configurableOrderItemRequest.getHasOverridenPrice());
  }

  /**
   * Test {@link ConfigurableOrderItemRequest#getHasOverridenPrice()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConfigurableOrderItemRequest#getHasOverridenPrice()}
   */
  @Test
  public void testGetHasOverridenPrice_thenReturnTrue() {
    // Arrange
    ConfigurableOrderItemRequest configurableOrderItemRequest = new ConfigurableOrderItemRequest();
    configurableOrderItemRequest.setAdditionalAttributes(new HashMap<>());
    configurableOrderItemRequest.setCategoryId(1L);
    configurableOrderItemRequest.setChildOrderItems(new ArrayList<>());
    configurableOrderItemRequest.setDiscountsAllowed(true);
    configurableOrderItemRequest.setDisplayPrice(new Money());
    configurableOrderItemRequest.setExpandable(true);
    configurableOrderItemRequest.setFirstExpandable(true);
    configurableOrderItemRequest.setHasConfigurationError(true);
    configurableOrderItemRequest.setIsMultiSelect(true);
    configurableOrderItemRequest.setItemAttributes(new HashMap<>());
    configurableOrderItemRequest.setLastExpandable(true);
    configurableOrderItemRequest.setMaxQuantity(3);
    configurableOrderItemRequest.setMinQuantity(1);
    configurableOrderItemRequest.setOrderItemId(1L);
    configurableOrderItemRequest.setOrderItemIndex(1);
    configurableOrderItemRequest.setOverrideRetailPrice(new Money());
    configurableOrderItemRequest.setOverrideSalePrice(new Money());
    configurableOrderItemRequest.setParentOrderItemId(1L);
    configurableOrderItemRequest.setPricingModelType("Pricing Model Type");
    configurableOrderItemRequest.setProductChoices(new ArrayList<>());
    configurableOrderItemRequest.setProductId(1L);
    configurableOrderItemRequest.setQuantity(1);
    configurableOrderItemRequest.setSkuId(1L);
    configurableOrderItemRequest.setHasOverridenPrice(true);

    // Act and Assert
    assertTrue(configurableOrderItemRequest.getHasOverridenPrice());
  }

  /**
   * Test {@link ConfigurableOrderItemRequest#getHasConfigurationError()}.
   * <ul>
   *   <li>Given {@link ConfigurableOrderItemRequest} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConfigurableOrderItemRequest#getHasConfigurationError()}
   */
  @Test
  public void testGetHasConfigurationError_givenConfigurableOrderItemRequest_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new ConfigurableOrderItemRequest()).getHasConfigurationError());
  }

  /**
   * Test {@link ConfigurableOrderItemRequest#getHasConfigurationError()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConfigurableOrderItemRequest#getHasConfigurationError()}
   */
  @Test
  public void testGetHasConfigurationError_givenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    HashMap<String, String> additionalAttributes = new HashMap<>();
    additionalAttributes.computeIfPresent("foo", mock(BiFunction.class));

    ConfigurableOrderItemRequest configurableOrderItemRequest = new ConfigurableOrderItemRequest();
    configurableOrderItemRequest.setAdditionalAttributes(additionalAttributes);
    configurableOrderItemRequest.setCategoryId(1L);
    configurableOrderItemRequest.setChildOrderItems(new ArrayList<>());
    configurableOrderItemRequest.setDiscountsAllowed(true);
    configurableOrderItemRequest.setDisplayPrice(new Money());
    configurableOrderItemRequest.setExpandable(true);
    configurableOrderItemRequest.setFirstExpandable(true);
    configurableOrderItemRequest.setHasOverridenPrice(true);
    configurableOrderItemRequest.setIsMultiSelect(true);
    configurableOrderItemRequest.setItemAttributes(new HashMap<>());
    configurableOrderItemRequest.setLastExpandable(true);
    configurableOrderItemRequest.setMaxQuantity(3);
    configurableOrderItemRequest.setMinQuantity(1);
    configurableOrderItemRequest.setOrderItemId(1L);
    configurableOrderItemRequest.setOrderItemIndex(1);
    configurableOrderItemRequest.setOverrideRetailPrice(new Money());
    configurableOrderItemRequest.setOverrideSalePrice(new Money());
    configurableOrderItemRequest.setParentOrderItemId(1L);
    configurableOrderItemRequest.setPricingModelType("Pricing Model Type");
    configurableOrderItemRequest.setProductChoices(new ArrayList<>());
    configurableOrderItemRequest.setProductId(1L);
    configurableOrderItemRequest.setQuantity(1);
    configurableOrderItemRequest.setSkuId(1L);
    configurableOrderItemRequest.setHasConfigurationError(true);

    // Act and Assert
    assertTrue(configurableOrderItemRequest.getHasConfigurationError());
  }

  /**
   * Test {@link ConfigurableOrderItemRequest#getHasConfigurationError()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConfigurableOrderItemRequest#getHasConfigurationError()}
   */
  @Test
  public void testGetHasConfigurationError_thenReturnTrue() {
    // Arrange
    ConfigurableOrderItemRequest configurableOrderItemRequest = new ConfigurableOrderItemRequest();
    configurableOrderItemRequest.setAdditionalAttributes(new HashMap<>());
    configurableOrderItemRequest.setCategoryId(1L);
    configurableOrderItemRequest.setChildOrderItems(new ArrayList<>());
    configurableOrderItemRequest.setDiscountsAllowed(true);
    configurableOrderItemRequest.setDisplayPrice(new Money());
    configurableOrderItemRequest.setExpandable(true);
    configurableOrderItemRequest.setFirstExpandable(true);
    configurableOrderItemRequest.setHasOverridenPrice(true);
    configurableOrderItemRequest.setIsMultiSelect(true);
    configurableOrderItemRequest.setItemAttributes(new HashMap<>());
    configurableOrderItemRequest.setLastExpandable(true);
    configurableOrderItemRequest.setMaxQuantity(3);
    configurableOrderItemRequest.setMinQuantity(1);
    configurableOrderItemRequest.setOrderItemId(1L);
    configurableOrderItemRequest.setOrderItemIndex(1);
    configurableOrderItemRequest.setOverrideRetailPrice(new Money());
    configurableOrderItemRequest.setOverrideSalePrice(new Money());
    configurableOrderItemRequest.setParentOrderItemId(1L);
    configurableOrderItemRequest.setPricingModelType("Pricing Model Type");
    configurableOrderItemRequest.setProductChoices(new ArrayList<>());
    configurableOrderItemRequest.setProductId(1L);
    configurableOrderItemRequest.setQuantity(1);
    configurableOrderItemRequest.setSkuId(1L);
    configurableOrderItemRequest.setHasConfigurationError(true);

    // Act and Assert
    assertTrue(configurableOrderItemRequest.getHasConfigurationError());
  }

  /**
   * Test {@link ConfigurableOrderItemRequest#getDiscountsAllowed()}.
   * <ul>
   *   <li>Given {@link ConfigurableOrderItemRequest} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigurableOrderItemRequest#getDiscountsAllowed()}
   */
  @Test
  public void testGetDiscountsAllowed_givenConfigurableOrderItemRequest_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new ConfigurableOrderItemRequest()).getDiscountsAllowed());
  }

  /**
   * Test {@link ConfigurableOrderItemRequest#getDiscountsAllowed()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigurableOrderItemRequest#getDiscountsAllowed()}
   */
  @Test
  public void testGetDiscountsAllowed_givenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    HashMap<String, String> additionalAttributes = new HashMap<>();
    additionalAttributes.computeIfPresent("foo", mock(BiFunction.class));

    ConfigurableOrderItemRequest configurableOrderItemRequest = new ConfigurableOrderItemRequest();
    configurableOrderItemRequest.setAdditionalAttributes(additionalAttributes);
    configurableOrderItemRequest.setCategoryId(1L);
    configurableOrderItemRequest.setChildOrderItems(new ArrayList<>());
    configurableOrderItemRequest.setDisplayPrice(new Money());
    configurableOrderItemRequest.setExpandable(true);
    configurableOrderItemRequest.setFirstExpandable(true);
    configurableOrderItemRequest.setHasConfigurationError(true);
    configurableOrderItemRequest.setHasOverridenPrice(true);
    configurableOrderItemRequest.setIsMultiSelect(true);
    configurableOrderItemRequest.setItemAttributes(new HashMap<>());
    configurableOrderItemRequest.setLastExpandable(true);
    configurableOrderItemRequest.setMaxQuantity(3);
    configurableOrderItemRequest.setMinQuantity(1);
    configurableOrderItemRequest.setOrderItemId(1L);
    configurableOrderItemRequest.setOrderItemIndex(1);
    configurableOrderItemRequest.setOverrideRetailPrice(new Money());
    configurableOrderItemRequest.setOverrideSalePrice(new Money());
    configurableOrderItemRequest.setParentOrderItemId(1L);
    configurableOrderItemRequest.setPricingModelType("Pricing Model Type");
    configurableOrderItemRequest.setProductChoices(new ArrayList<>());
    configurableOrderItemRequest.setProductId(1L);
    configurableOrderItemRequest.setQuantity(1);
    configurableOrderItemRequest.setSkuId(1L);
    configurableOrderItemRequest.setDiscountsAllowed(true);

    // Act and Assert
    assertTrue(configurableOrderItemRequest.getDiscountsAllowed());
  }

  /**
   * Test {@link ConfigurableOrderItemRequest#getDiscountsAllowed()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConfigurableOrderItemRequest#getDiscountsAllowed()}
   */
  @Test
  public void testGetDiscountsAllowed_thenReturnTrue() {
    // Arrange
    ConfigurableOrderItemRequest configurableOrderItemRequest = new ConfigurableOrderItemRequest();
    configurableOrderItemRequest.setAdditionalAttributes(new HashMap<>());
    configurableOrderItemRequest.setCategoryId(1L);
    configurableOrderItemRequest.setChildOrderItems(new ArrayList<>());
    configurableOrderItemRequest.setDisplayPrice(new Money());
    configurableOrderItemRequest.setExpandable(true);
    configurableOrderItemRequest.setFirstExpandable(true);
    configurableOrderItemRequest.setHasConfigurationError(true);
    configurableOrderItemRequest.setHasOverridenPrice(true);
    configurableOrderItemRequest.setIsMultiSelect(true);
    configurableOrderItemRequest.setItemAttributes(new HashMap<>());
    configurableOrderItemRequest.setLastExpandable(true);
    configurableOrderItemRequest.setMaxQuantity(3);
    configurableOrderItemRequest.setMinQuantity(1);
    configurableOrderItemRequest.setOrderItemId(1L);
    configurableOrderItemRequest.setOrderItemIndex(1);
    configurableOrderItemRequest.setOverrideRetailPrice(new Money());
    configurableOrderItemRequest.setOverrideSalePrice(new Money());
    configurableOrderItemRequest.setParentOrderItemId(1L);
    configurableOrderItemRequest.setPricingModelType("Pricing Model Type");
    configurableOrderItemRequest.setProductChoices(new ArrayList<>());
    configurableOrderItemRequest.setProductId(1L);
    configurableOrderItemRequest.setQuantity(1);
    configurableOrderItemRequest.setSkuId(1L);
    configurableOrderItemRequest.setDiscountsAllowed(true);

    // Act and Assert
    assertTrue(configurableOrderItemRequest.getDiscountsAllowed());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ConfigurableOrderItemRequest}
   *   <li>{@link ConfigurableOrderItemRequest#setDiscountsAllowed(Boolean)}
   *   <li>{@link ConfigurableOrderItemRequest#setDisplayPrice(Money)}
   *   <li>{@link ConfigurableOrderItemRequest#setExpandable(boolean)}
   *   <li>{@link ConfigurableOrderItemRequest#setFirstExpandable(boolean)}
   *   <li>{@link ConfigurableOrderItemRequest#setHasConfigurationError(Boolean)}
   *   <li>{@link ConfigurableOrderItemRequest#setHasOverridenPrice(Boolean)}
   *   <li>{@link ConfigurableOrderItemRequest#setIsMultiSelect(Boolean)}
   *   <li>{@link ConfigurableOrderItemRequest#setLastExpandable(boolean)}
   *   <li>{@link ConfigurableOrderItemRequest#setMaxQuantity(Integer)}
   *   <li>{@link ConfigurableOrderItemRequest#setMinQuantity(Integer)}
   *   <li>{@link ConfigurableOrderItemRequest#setOrderItemIndex(Integer)}
   *   <li>{@link ConfigurableOrderItemRequest#setPricingModelType(String)}
   *   <li>{@link ConfigurableOrderItemRequest#setProductChoices(List)}
   *   <li>{@link ConfigurableOrderItemRequest#getDisplayPrice()}
   *   <li>{@link ConfigurableOrderItemRequest#getMaxQuantity()}
   *   <li>{@link ConfigurableOrderItemRequest#getOrderItemIndex()}
   *   <li>{@link ConfigurableOrderItemRequest#getPricingModelType()}
   *   <li>{@link ConfigurableOrderItemRequest#getProduct()}
   *   <li>{@link ConfigurableOrderItemRequest#getProductChoices()}
   *   <li>{@link ConfigurableOrderItemRequest#getSku()}
   *   <li>{@link ConfigurableOrderItemRequest#isExpandable()}
   *   <li>{@link ConfigurableOrderItemRequest#isFirstExpandable()}
   *   <li>{@link ConfigurableOrderItemRequest#isLastExpandable()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ConfigurableOrderItemRequest actualConfigurableOrderItemRequest = new ConfigurableOrderItemRequest();
    actualConfigurableOrderItemRequest.setDiscountsAllowed(true);
    Money displayPrice = new Money();
    actualConfigurableOrderItemRequest.setDisplayPrice(displayPrice);
    actualConfigurableOrderItemRequest.setExpandable(true);
    actualConfigurableOrderItemRequest.setFirstExpandable(true);
    actualConfigurableOrderItemRequest.setHasConfigurationError(true);
    actualConfigurableOrderItemRequest.setHasOverridenPrice(true);
    actualConfigurableOrderItemRequest.setIsMultiSelect(true);
    actualConfigurableOrderItemRequest.setLastExpandable(true);
    actualConfigurableOrderItemRequest.setMaxQuantity(3);
    actualConfigurableOrderItemRequest.setMinQuantity(1);
    actualConfigurableOrderItemRequest.setOrderItemIndex(1);
    actualConfigurableOrderItemRequest.setPricingModelType("Pricing Model Type");
    ArrayList<ConfigurableOrderItemRequest> productChoices = new ArrayList<>();
    actualConfigurableOrderItemRequest.setProductChoices(productChoices);
    Money actualDisplayPrice = actualConfigurableOrderItemRequest.getDisplayPrice();
    Integer actualMaxQuantity = actualConfigurableOrderItemRequest.getMaxQuantity();
    Integer actualOrderItemIndex = actualConfigurableOrderItemRequest.getOrderItemIndex();
    String actualPricingModelType = actualConfigurableOrderItemRequest.getPricingModelType();
    actualConfigurableOrderItemRequest.getProduct();
    List<ConfigurableOrderItemRequest> actualProductChoices = actualConfigurableOrderItemRequest.getProductChoices();
    actualConfigurableOrderItemRequest.getSku();
    boolean actualIsExpandableResult = actualConfigurableOrderItemRequest.isExpandable();
    boolean actualIsFirstExpandableResult = actualConfigurableOrderItemRequest.isFirstExpandable();
    boolean actualIsLastExpandableResult = actualConfigurableOrderItemRequest.isLastExpandable();

    // Assert that nothing has changed
    assertEquals("Pricing Model Type", actualPricingModelType);
    assertEquals(1, actualOrderItemIndex.intValue());
    assertEquals(1, actualConfigurableOrderItemRequest.getQuantity().intValue());
    assertEquals(1, actualConfigurableOrderItemRequest.minQuantity.intValue());
    assertEquals(3, actualMaxQuantity.intValue());
    assertTrue(actualConfigurableOrderItemRequest.getChildOrderItems().isEmpty());
    assertTrue(actualConfigurableOrderItemRequest.getAdditionalAttributes().isEmpty());
    assertTrue(actualConfigurableOrderItemRequest.getItemAttributes().isEmpty());
    assertTrue(actualIsExpandableResult);
    assertTrue(actualIsFirstExpandableResult);
    assertTrue(actualIsLastExpandableResult);
    assertSame(productChoices, actualProductChoices);
    assertSame(displayPrice, actualDisplayPrice);
  }
}

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
package org.broadleafcommerce.core.catalog.service.dynamic;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.ProductOption;
import org.broadleafcommerce.core.catalog.domain.ProductOptionImpl;
import org.broadleafcommerce.core.catalog.domain.ProductOptionValueImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuBundleItem;
import org.broadleafcommerce.core.catalog.domain.SkuBundleItemImpl;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.catalog.domain.pricing.SkuPriceWrapper;
import org.junit.Test;
import org.mockito.Mockito;

public class DefaultDynamicSkuPricingServiceImplDiffblueTest {
  /**
   * Test {@link DefaultDynamicSkuPricingServiceImpl#getSkuPrices(Sku, HashMap)}
   * with {@code sku}, {@code skuPricingConsiderations}.
   * <ul>
   *   <li>Then return Price is {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultDynamicSkuPricingServiceImpl#getSkuPrices(Sku, HashMap)}
   */
  @Test
  public void testGetSkuPricesWithSkuSkuPricingConsiderations_thenReturnPriceIsMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultDynamicSkuPricingServiceImpl defaultDynamicSkuPricingServiceImpl = new DefaultDynamicSkuPricingServiceImpl();
    Sku sku = mock(Sku.class);
    Money money = new Money();
    when(sku.getProductOptionValueAdjustments()).thenReturn(money);
    Money money2 = new Money();
    when(sku.getRetailPrice()).thenReturn(money2);
    Money money3 = new Money();
    when(sku.getSalePrice()).thenReturn(money3);

    // Act
    DynamicSkuPrices actualSkuPrices = defaultDynamicSkuPricingServiceImpl.getSkuPrices(sku, new HashMap());

    // Assert
    verify(sku).getProductOptionValueAdjustments();
    verify(sku).getRetailPrice();
    verify(sku).getSalePrice();
    assertSame(money3, actualSkuPrices.getPrice());
    assertSame(money, actualSkuPrices.getPriceAdjustment());
    assertSame(money2, actualSkuPrices.getRetailPrice());
    assertSame(money3, actualSkuPrices.getSalePrice());
  }

  /**
   * Test {@link DefaultDynamicSkuPricingServiceImpl#getSkuPrices(Sku, HashMap)}
   * with {@code sku}, {@code skuPricingConsiderations}.
   * <ul>
   *   <li>Then return Price is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultDynamicSkuPricingServiceImpl#getSkuPrices(Sku, HashMap)}
   */
  @Test
  public void testGetSkuPricesWithSkuSkuPricingConsiderations_thenReturnPriceIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultDynamicSkuPricingServiceImpl defaultDynamicSkuPricingServiceImpl = new DefaultDynamicSkuPricingServiceImpl();
    SkuImpl sku = new SkuImpl();

    // Act
    DynamicSkuPrices actualSkuPrices = defaultDynamicSkuPricingServiceImpl.getSkuPrices(sku, new HashMap());

    // Assert
    assertNull(actualSkuPrices.getPrice());
    assertNull(actualSkuPrices.getPriceAdjustment());
    assertNull(actualSkuPrices.getRetailPrice());
    assertNull(actualSkuPrices.getSalePrice());
  }

  /**
   * Test
   * {@link DefaultDynamicSkuPricingServiceImpl#getSkuPrices(SkuPriceWrapper, HashMap)}
   * with {@code skuWrapper}, {@code skuPricingConsiderations}.
   * <ul>
   *   <li>Then calls {@link SkuPriceWrapper#getTargetSku()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultDynamicSkuPricingServiceImpl#getSkuPrices(SkuPriceWrapper, HashMap)}
   */
  @Test
  public void testGetSkuPricesWithSkuWrapperSkuPricingConsiderations_thenCallsGetTargetSku() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultDynamicSkuPricingServiceImpl defaultDynamicSkuPricingServiceImpl = new DefaultDynamicSkuPricingServiceImpl();
    SkuPriceWrapper skuWrapper = mock(SkuPriceWrapper.class);
    when(skuWrapper.getTargetSku()).thenReturn(new SkuImpl());

    // Act
    DynamicSkuPrices actualSkuPrices = defaultDynamicSkuPricingServiceImpl.getSkuPrices(skuWrapper, new HashMap());

    // Assert
    verify(skuWrapper).getTargetSku();
    assertNull(actualSkuPrices.didOverride);
    assertNull(actualSkuPrices.getPrice());
    assertNull(actualSkuPrices.getPriceAdjustment());
    assertNull(actualSkuPrices.getRetailPrice());
    assertNull(actualSkuPrices.getSalePrice());
    assertFalse(actualSkuPrices.getDidOverride());
  }

  /**
   * Test
   * {@link DefaultDynamicSkuPricingServiceImpl#getSkuPrices(SkuPriceWrapper, HashMap)}
   * with {@code skuWrapper}, {@code skuPricingConsiderations}.
   * <ul>
   *   <li>When {@link SkuPriceWrapper#SkuPriceWrapper()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultDynamicSkuPricingServiceImpl#getSkuPrices(SkuPriceWrapper, HashMap)}
   */
  @Test
  public void testGetSkuPricesWithSkuWrapperSkuPricingConsiderations_whenSkuPriceWrapper() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultDynamicSkuPricingServiceImpl defaultDynamicSkuPricingServiceImpl = new DefaultDynamicSkuPricingServiceImpl();
    SkuPriceWrapper skuWrapper = new SkuPriceWrapper();

    // Act
    DynamicSkuPrices actualSkuPrices = defaultDynamicSkuPricingServiceImpl.getSkuPrices(skuWrapper, new HashMap());

    // Assert
    assertNull(actualSkuPrices.didOverride);
    assertNull(actualSkuPrices.getPrice());
    assertNull(actualSkuPrices.getPriceAdjustment());
    assertNull(actualSkuPrices.getRetailPrice());
    assertNull(actualSkuPrices.getSalePrice());
    assertFalse(actualSkuPrices.getDidOverride());
  }

  /**
   * Test
   * {@link DefaultDynamicSkuPricingServiceImpl#getSkuBundleItemPrice(SkuBundleItem, HashMap)}.
   * <ul>
   *   <li>Given {@link Money#Money()}.</li>
   *   <li>Then return Price is {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultDynamicSkuPricingServiceImpl#getSkuBundleItemPrice(SkuBundleItem, HashMap)}
   */
  @Test
  public void testGetSkuBundleItemPrice_givenMoney_thenReturnPriceIsMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultDynamicSkuPricingServiceImpl defaultDynamicSkuPricingServiceImpl = new DefaultDynamicSkuPricingServiceImpl();
    SkuBundleItemImpl skuBundleItem = mock(SkuBundleItemImpl.class);
    Money money = new Money();
    when(skuBundleItem.getSalePrice()).thenReturn(money);

    // Act
    DynamicSkuPrices actualSkuBundleItemPrice = defaultDynamicSkuPricingServiceImpl.getSkuBundleItemPrice(skuBundleItem,
        new HashMap());

    // Assert
    verify(skuBundleItem).getSalePrice();
    assertSame(money, actualSkuBundleItemPrice.getPrice());
    assertSame(money, actualSkuBundleItemPrice.getSalePrice());
  }

  /**
   * Test
   * {@link DefaultDynamicSkuPricingServiceImpl#getSkuBundleItemPrice(SkuBundleItem, HashMap)}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@link DynamicSkuPrices#didOverride} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultDynamicSkuPricingServiceImpl#getSkuBundleItemPrice(SkuBundleItem, HashMap)}
   */
  @Test
  public void testGetSkuBundleItemPrice_givenSkuImpl_thenReturnDidOverrideIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultDynamicSkuPricingServiceImpl defaultDynamicSkuPricingServiceImpl = new DefaultDynamicSkuPricingServiceImpl();

    SkuBundleItemImpl skuBundleItem = new SkuBundleItemImpl();
    skuBundleItem.setSku(new SkuImpl());

    // Act
    DynamicSkuPrices actualSkuBundleItemPrice = defaultDynamicSkuPricingServiceImpl.getSkuBundleItemPrice(skuBundleItem,
        new HashMap());

    // Assert
    assertNull(actualSkuBundleItemPrice.didOverride);
    assertNull(actualSkuBundleItemPrice.getPrice());
    assertNull(actualSkuBundleItemPrice.getPriceAdjustment());
    assertNull(actualSkuBundleItemPrice.getRetailPrice());
    assertNull(actualSkuBundleItemPrice.getSalePrice());
    assertFalse(actualSkuBundleItemPrice.getDidOverride());
  }

  /**
   * Test
   * {@link DefaultDynamicSkuPricingServiceImpl#getPriceAdjustment(ProductOptionValueImpl, Money, HashMap)}.
   * <ul>
   *   <li>Then calls {@link ProductOptionValueImpl#setAttributeValue(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultDynamicSkuPricingServiceImpl#getPriceAdjustment(ProductOptionValueImpl, Money, HashMap)}
   */
  @Test
  public void testGetPriceAdjustment_thenCallsSetAttributeValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultDynamicSkuPricingServiceImpl defaultDynamicSkuPricingServiceImpl = new DefaultDynamicSkuPricingServiceImpl();
    ProductOptionValueImpl productOptionValueImpl = mock(ProductOptionValueImpl.class);
    doNothing().when(productOptionValueImpl).setAttributeValue(Mockito.<String>any());
    doNothing().when(productOptionValueImpl).setDisplayOrder(Mockito.<Long>any());
    doNothing().when(productOptionValueImpl).setId(Mockito.<Long>any());
    doNothing().when(productOptionValueImpl).setPriceAdjustment(Mockito.<Money>any());
    doNothing().when(productOptionValueImpl).setProductOption(Mockito.<ProductOption>any());
    productOptionValueImpl.setAttributeValue("42");
    productOptionValueImpl.setDisplayOrder(1L);
    productOptionValueImpl.setId(1L);
    productOptionValueImpl.setPriceAdjustment(new Money());
    productOptionValueImpl.setProductOption(new ProductOptionImpl());
    Money priceAdjustment = new Money();

    // Act
    defaultDynamicSkuPricingServiceImpl.getPriceAdjustment(productOptionValueImpl, priceAdjustment, new HashMap());

    // Assert
    verify(productOptionValueImpl).setAttributeValue(eq("42"));
    verify(productOptionValueImpl).setDisplayOrder(eq(1L));
    verify(productOptionValueImpl).setId(eq(1L));
    verify(productOptionValueImpl).setPriceAdjustment(isA(Money.class));
    verify(productOptionValueImpl).setProductOption(isA(ProductOption.class));
  }
}

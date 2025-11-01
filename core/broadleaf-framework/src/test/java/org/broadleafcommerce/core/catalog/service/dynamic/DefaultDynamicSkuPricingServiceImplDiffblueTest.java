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
   * Method under test:
   * {@link DefaultDynamicSkuPricingServiceImpl#getSkuPrices(Sku, HashMap)}
   */
  @Test
  public void testGetSkuPrices() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultDynamicSkuPricingServiceImpl defaultDynamicSkuPricingServiceImpl = new DefaultDynamicSkuPricingServiceImpl();
    SkuImpl sku = new SkuImpl();

    // Act
    DynamicSkuPrices actualSkuPrices = defaultDynamicSkuPricingServiceImpl.getSkuPrices(sku, new HashMap());

    // Assert
    assertNull(actualSkuPrices.didOverride);
    assertNull(actualSkuPrices.getPrice());
    assertNull(actualSkuPrices.getPriceAdjustment());
    assertNull(actualSkuPrices.getRetailPrice());
    assertNull(actualSkuPrices.getSalePrice());
    assertFalse(actualSkuPrices.getDidOverride());
  }

  /**
   * Method under test:
   * {@link DefaultDynamicSkuPricingServiceImpl#getSkuPrices(Sku, HashMap)}
   */
  @Test
  public void testGetSkuPrices2() {
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
    assertNull(actualSkuPrices.didOverride);
    assertFalse(actualSkuPrices.getDidOverride());
    assertSame(money3, actualSkuPrices.getPrice());
    assertSame(money, actualSkuPrices.getPriceAdjustment());
    assertSame(money2, actualSkuPrices.getRetailPrice());
    assertSame(money3, actualSkuPrices.getSalePrice());
  }

  /**
   * Method under test:
   * {@link DefaultDynamicSkuPricingServiceImpl#getSkuPrices(SkuPriceWrapper, HashMap)}
   */
  @Test
  public void testGetSkuPrices3() {
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
   * Method under test:
   * {@link DefaultDynamicSkuPricingServiceImpl#getSkuPrices(SkuPriceWrapper, HashMap)}
   */
  @Test
  public void testGetSkuPrices4() {
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
   * Method under test:
   * {@link DefaultDynamicSkuPricingServiceImpl#getSkuBundleItemPrice(SkuBundleItem, HashMap)}
   */
  @Test
  public void testGetSkuBundleItemPrice() {
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
   * Method under test:
   * {@link DefaultDynamicSkuPricingServiceImpl#getSkuBundleItemPrice(SkuBundleItem, HashMap)}
   */
  @Test
  public void testGetSkuBundleItemPrice2() {
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
    assertNull(actualSkuBundleItemPrice.didOverride);
    assertNull(actualSkuBundleItemPrice.getPriceAdjustment());
    assertNull(actualSkuBundleItemPrice.getRetailPrice());
    assertFalse(actualSkuBundleItemPrice.getDidOverride());
    assertSame(money, actualSkuBundleItemPrice.getPrice());
    assertSame(money, actualSkuBundleItemPrice.getSalePrice());
  }

  /**
   * Method under test:
   * {@link DefaultDynamicSkuPricingServiceImpl#getPriceAdjustment(ProductOptionValueImpl, Money, HashMap)}
   */
  @Test
  public void testGetPriceAdjustment() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultDynamicSkuPricingServiceImpl defaultDynamicSkuPricingServiceImpl = new DefaultDynamicSkuPricingServiceImpl();

    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValueImpl.setAttributeValue("42");
    productOptionValueImpl.setDisplayOrder(1L);
    productOptionValueImpl.setId(1L);
    productOptionValueImpl.setPriceAdjustment(new Money());
    productOptionValueImpl.setProductOption(new ProductOptionImpl());
    Money priceAdjustment = new Money();

    // Act
    DynamicSkuPrices actualPriceAdjustment = defaultDynamicSkuPricingServiceImpl
        .getPriceAdjustment(productOptionValueImpl, priceAdjustment, new HashMap());

    // Assert
    assertNull(actualPriceAdjustment.didOverride);
    assertNull(actualPriceAdjustment.getPrice());
    assertNull(actualPriceAdjustment.getRetailPrice());
    assertNull(actualPriceAdjustment.getSalePrice());
    assertFalse(actualPriceAdjustment.getDidOverride());
    assertSame(priceAdjustment, actualPriceAdjustment.getPriceAdjustment());
  }

  /**
   * Method under test:
   * {@link DefaultDynamicSkuPricingServiceImpl#getPriceAdjustment(ProductOptionValueImpl, Money, HashMap)}
   */
  @Test
  public void testGetPriceAdjustment2() {
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
    DynamicSkuPrices actualPriceAdjustment = defaultDynamicSkuPricingServiceImpl
        .getPriceAdjustment(productOptionValueImpl, priceAdjustment, new HashMap());

    // Assert
    verify(productOptionValueImpl).setAttributeValue(eq("42"));
    verify(productOptionValueImpl).setDisplayOrder(eq(1L));
    verify(productOptionValueImpl).setId(eq(1L));
    verify(productOptionValueImpl).setPriceAdjustment(isA(Money.class));
    verify(productOptionValueImpl).setProductOption(isA(ProductOption.class));
    assertNull(actualPriceAdjustment.didOverride);
    assertNull(actualPriceAdjustment.getPrice());
    assertNull(actualPriceAdjustment.getRetailPrice());
    assertNull(actualPriceAdjustment.getSalePrice());
    assertFalse(actualPriceAdjustment.getDidOverride());
    assertSame(priceAdjustment, actualPriceAdjustment.getPriceAdjustment());
  }
}

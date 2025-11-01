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
package org.broadleafcommerce.core.catalog.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.media.domain.Media;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.persistence.ArchiveStatus;
import org.broadleafcommerce.core.catalog.service.dynamic.DynamicSkuPrices;
import org.junit.Test;
import org.mockito.Mockito;

public class SkuBundleItemImplDiffblueTest {
  /**
   * Method under test:
   * {@link SkuBundleItemImpl#getDynamicSalePrice(Sku, BigDecimal)}
   */
  @Test
  public void testGetDynamicSalePrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    SkuImpl sku = new SkuImpl();

    // Act
    Money actualDynamicSalePrice = skuBundleItemImpl.getDynamicSalePrice(sku, new BigDecimal("2.3"));

    // Assert
    Currency currency = actualDynamicSalePrice.getCurrency();
    assertEquals("$", currency.getSymbol());
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.toString());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(840, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("2.30");
    assertEquals(expectedAmount, actualDynamicSalePrice.getAmount());
    assertEquals(actualDynamicSalePrice, actualDynamicSalePrice.abs());
    Money expectedZeroResult = actualDynamicSalePrice.ZERO;
    assertEquals(expectedZeroResult, actualDynamicSalePrice.zero());
  }

  /**
   * Method under test:
   * {@link SkuBundleItemImpl#getDynamicSalePrice(Sku, BigDecimal)}
   */
  @Test
  public void testGetDynamicSalePrice2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    Sku sku = mock(Sku.class);

    // Act
    Money actualDynamicSalePrice = skuBundleItemImpl.getDynamicSalePrice(sku, new BigDecimal("2.3"));

    // Assert
    Currency currency = actualDynamicSalePrice.getCurrency();
    assertEquals("$", currency.getSymbol());
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.toString());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(840, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("2.30");
    assertEquals(expectedAmount, actualDynamicSalePrice.getAmount());
    assertEquals(actualDynamicSalePrice, actualDynamicSalePrice.abs());
    Money expectedZeroResult = actualDynamicSalePrice.ZERO;
    assertEquals(expectedZeroResult, actualDynamicSalePrice.zero());
  }

  /**
   * Method under test:
   * {@link SkuBundleItemImpl#getDynamicSalePrice(Sku, BigDecimal)}
   */
  @Test
  public void testGetDynamicSalePrice3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();

    // Act and Assert
    assertNull(skuBundleItemImpl.getDynamicSalePrice(new SkuImpl(), null));
  }

  /**
   * Method under test:
   * {@link SkuBundleItemImpl#getDynamicSalePrice(Sku, BigDecimal)}
   */
  @Test
  public void testGetDynamicSalePrice4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    Money salePrice = new Money();
    skuBundleItemImpl.setSalePrice(salePrice);
    SkuImpl sku = new SkuImpl();

    // Act
    Money actualDynamicSalePrice = skuBundleItemImpl.getDynamicSalePrice(sku, new BigDecimal("2.3"));

    // Assert
    Currency currency = actualDynamicSalePrice.getCurrency();
    assertEquals("$", currency.getSymbol());
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.toString());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(840, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("2.30");
    assertEquals(expectedAmount, actualDynamicSalePrice.getAmount());
    assertEquals(salePrice, actualDynamicSalePrice.zero());
    assertEquals(actualDynamicSalePrice, actualDynamicSalePrice.abs());
  }

  /**
   * Method under test: {@link SkuBundleItemImpl#setSalePrice(Money)}
   */
  @Test
  public void testSetSalePrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    Money salePrice = new Money();

    // Act
    skuBundleItemImpl.setSalePrice(salePrice);

    // Assert
    assertNull(skuBundleItemImpl.bundle);
    BigDecimal expectedAmount = new BigDecimal("0.00");
    BigDecimal amount = salePrice.getAmount();
    assertEquals(expectedAmount, amount);
    assertEquals(new BigDecimal("0.00"), skuBundleItemImpl.itemSalePrice);
    assertEquals(salePrice, salePrice.abs());
    assertEquals(salePrice, salePrice.zero());
    assertSame(skuBundleItemImpl.itemSalePrice, amount);
  }

  /**
   * Method under test: {@link SkuBundleItemImpl#setSalePrice(Money)}
   */
  @Test
  public void testSetSalePrice2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    ProductBundleImpl bundle = new ProductBundleImpl();
    skuBundleItemImpl.setBundle(bundle);
    skuBundleItemImpl.setId(1L);
    skuBundleItemImpl.setQuantity(1);
    skuBundleItemImpl.setSalePrice(new Money());
    skuBundleItemImpl.setSequence(new BigDecimal("2.3"));
    skuBundleItemImpl.setSku(new SkuImpl());

    // Act
    skuBundleItemImpl.setSalePrice(null);

    // Assert
    assertTrue(skuBundleItemImpl.bundle instanceof ProductBundleImpl);
    assertNull(skuBundleItemImpl.itemSalePrice);
    assertNull(skuBundleItemImpl.getSalePrice());
    assertSame(bundle, skuBundleItemImpl.getBundle());
  }

  /**
   * Method under test: {@link SkuBundleItemImpl#setSalePrice(Money)}
   */
  @Test
  public void testSetSalePrice3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    Money salePrice = mock(Money.class);
    when(salePrice.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    skuBundleItemImpl.setSalePrice(salePrice);

    // Assert
    verify(salePrice).getAmount();
    assertNull(skuBundleItemImpl.bundle);
    assertEquals(new BigDecimal("2.3"), skuBundleItemImpl.itemSalePrice);
  }

  /**
   * Method under test: {@link SkuBundleItemImpl#getSalePrice()}
   */
  @Test
  public void testGetSalePrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    SkuImpl sku = new SkuImpl();
    skuBundleItemImpl.setSku(sku);

    // Act
    Money actualSalePrice = skuBundleItemImpl.getSalePrice();

    // Assert
    Sku sku2 = skuBundleItemImpl.getSku();
    assertTrue(sku2 instanceof SkuImpl);
    Sku sku3 = skuBundleItemImpl.deproxiedSku;
    assertTrue(sku3 instanceof SkuImpl);
    assertNull(sku3.getTaxable());
    assertNull(((SkuImpl) sku3).isMachineSortable);
    assertNull(((SkuImpl) sku3).available);
    assertNull(((SkuImpl) sku3).discountable);
    assertNull(((SkuImpl) sku3).taxable);
    assertNull(sku3.getId());
    assertNull(sku3.getDescription());
    assertNull(sku3.getDisplayTemplate());
    assertNull(sku3.getExternalId());
    assertNull(sku3.getLongDescription());
    assertNull(sku3.getName());
    assertNull(sku3.getTaxCode());
    assertNull(sku3.getUpc());
    assertNull(sku3.getUrlKey());
    assertNull(((SkuImpl) sku3).description);
    assertNull(((SkuImpl) sku3).fulfillmentType);
    assertNull(((SkuImpl) sku3).inventoryType);
    assertNull(((SkuImpl) sku3).longDescription);
    assertNull(((SkuImpl) sku3).name);
    assertNull(((SkuImpl) sku3).taxCode);
    assertNull(((SkuImpl) sku3).cost);
    assertNull(((SkuImpl) sku3).retailPrice);
    assertNull(((SkuImpl) sku3).salePrice);
    assertNull(sku3.getActiveEndDate());
    assertNull(sku3.getActiveStartDate());
    assertNull(((SkuImpl) sku3).activeEndDate);
    assertNull(((SkuImpl) sku3).activeStartDate);
    assertNull(sku3.getCurrency());
    assertNull(((SkuImpl) sku3).currency);
    assertNull(sku3.getPrimarySkuMedia());
    assertNull(sku3.getBaseRetailPrice());
    assertNull(sku3.getBaseSalePrice());
    assertNull(sku3.getCost());
    assertNull(sku3.getListPrice());
    assertNull(sku3.getPrice());
    assertNull(sku3.getProductOptionValueAdjustments());
    assertNull(sku3.getRetailPrice());
    assertNull(sku3.getSalePrice());
    assertNull(actualSalePrice);
    assertNull(((SkuImpl) sku3).getRetailPriceInternal());
    DynamicSkuPrices priceData = sku3.getPriceData();
    assertNull(priceData.getPrice());
    assertNull(priceData.getPriceAdjustment());
    assertNull(priceData.getRetailPrice());
    assertNull(priceData.getSalePrice());
    assertNull(sku3.getDefaultProduct());
    assertNull(sku3.getProduct());
    assertNull(((SkuImpl) sku3).product);
    assertNull(sku3.getInventoryType());
    assertNull(sku3.getFulfillmentType());
    assertEquals(0, sku3.getQuantityAvailable().intValue());
    assertFalse(sku3.getIsMachineSortable());
    assertFalse(sku3.hasRetailPrice());
    assertFalse(sku3.hasSalePrice());
    assertFalse(((SkuImpl) sku3).getDiscountable());
    assertFalse(((SkuImpl) sku3).hasDefaultSku());
    assertFalse(priceData.getDidOverride());
    assertTrue(sku3.getProductOptionValues().isEmpty());
    assertTrue(sku3.getMultiValueSkuAttributes().isEmpty());
    assertTrue(sku3.getSkuAttributes().isEmpty());
    assertTrue(sku3.getSkuMedia().isEmpty());
    assertTrue(sku3.getProductOptionValuesCollection().isEmpty());
    assertTrue(sku3.getAvailable());
    assertSame(sku, sku2);
    Dimension dimension = sku.dimension;
    assertSame(dimension, sku3.getDimension());
    assertSame(dimension, ((SkuImpl) sku3).dimension);
    assertSame(sku.legacyProductOptionValues, ((SkuImpl) sku3).legacyProductOptionValues);
    assertSame(sku.legacySkuMedia, ((SkuImpl) sku3).legacySkuMedia);
    assertSame(sku.skuAttributes, ((SkuImpl) sku3).skuAttributes);
    Map<String, SkuMediaXref> stringSkuMediaXrefMap = sku.skuMedia;
    assertSame(stringSkuMediaXrefMap, sku3.getSkuMediaXref());
    assertSame(stringSkuMediaXrefMap, sku3.getSkuMediaXrefIgnoreDefaultSku());
    assertSame(stringSkuMediaXrefMap, ((SkuImpl) sku3).skuMedia);
    Weight weight = sku.weight;
    assertSame(weight, sku3.getWeight());
    assertSame(weight, ((SkuImpl) sku3).weight);
  }

  /**
   * Method under test: {@link SkuBundleItemImpl#getSalePrice()}
   */
  @Test
  public void testGetSalePrice2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Money money = new Money();
    when(sku.getSalePrice()).thenReturn(money);

    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    skuBundleItemImpl.setSku(sku);

    // Act
    Money actualSalePrice = skuBundleItemImpl.getSalePrice();

    // Assert
    verify(sku).getId();
    verify(sku).getSalePrice();
    assertSame(money, actualSalePrice);
  }

  /**
   * Method under test: {@link SkuBundleItemImpl#getSalePrice()}
   */
  @Test
  public void testGetSalePrice3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);

    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    Money salePrice = new Money();
    skuBundleItemImpl.setSalePrice(salePrice);
    skuBundleItemImpl.setSku(sku);

    // Act
    Money actualSalePrice = skuBundleItemImpl.getSalePrice();

    // Assert
    verify(sku).getId();
    assertEquals(salePrice, actualSalePrice);
  }

  /**
   * Method under test: {@link SkuBundleItemImpl#getRetailPrice()}
   */
  @Test
  public void testGetRetailPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    SkuImpl sku = new SkuImpl();
    skuBundleItemImpl.setSku(sku);

    // Act
    Money actualRetailPrice = skuBundleItemImpl.getRetailPrice();

    // Assert
    Sku sku2 = skuBundleItemImpl.getSku();
    assertTrue(sku2 instanceof SkuImpl);
    Sku sku3 = skuBundleItemImpl.deproxiedSku;
    assertTrue(sku3 instanceof SkuImpl);
    assertNull(sku3.getTaxable());
    assertNull(((SkuImpl) sku3).isMachineSortable);
    assertNull(((SkuImpl) sku3).available);
    assertNull(((SkuImpl) sku3).discountable);
    assertNull(((SkuImpl) sku3).taxable);
    assertNull(sku3.getId());
    assertNull(sku3.getDescription());
    assertNull(sku3.getDisplayTemplate());
    assertNull(sku3.getExternalId());
    assertNull(sku3.getLongDescription());
    assertNull(sku3.getName());
    assertNull(sku3.getTaxCode());
    assertNull(sku3.getUpc());
    assertNull(sku3.getUrlKey());
    assertNull(((SkuImpl) sku3).description);
    assertNull(((SkuImpl) sku3).fulfillmentType);
    assertNull(((SkuImpl) sku3).inventoryType);
    assertNull(((SkuImpl) sku3).longDescription);
    assertNull(((SkuImpl) sku3).name);
    assertNull(((SkuImpl) sku3).taxCode);
    assertNull(((SkuImpl) sku3).cost);
    assertNull(((SkuImpl) sku3).retailPrice);
    assertNull(((SkuImpl) sku3).salePrice);
    assertNull(sku3.getActiveEndDate());
    assertNull(sku3.getActiveStartDate());
    assertNull(((SkuImpl) sku3).activeEndDate);
    assertNull(((SkuImpl) sku3).activeStartDate);
    assertNull(sku3.getCurrency());
    assertNull(((SkuImpl) sku3).currency);
    assertNull(sku3.getPrimarySkuMedia());
    assertNull(sku3.getBaseRetailPrice());
    assertNull(sku3.getBaseSalePrice());
    assertNull(sku3.getCost());
    assertNull(sku3.getListPrice());
    assertNull(sku3.getPrice());
    assertNull(sku3.getProductOptionValueAdjustments());
    assertNull(sku3.getRetailPrice());
    assertNull(sku3.getSalePrice());
    assertNull(actualRetailPrice);
    assertNull(((SkuImpl) sku3).getRetailPriceInternal());
    DynamicSkuPrices priceData = sku3.getPriceData();
    assertNull(priceData.getPrice());
    assertNull(priceData.getPriceAdjustment());
    assertNull(priceData.getRetailPrice());
    assertNull(priceData.getSalePrice());
    assertNull(sku3.getDefaultProduct());
    assertNull(sku3.getProduct());
    assertNull(((SkuImpl) sku3).product);
    assertNull(sku3.getInventoryType());
    assertNull(sku3.getFulfillmentType());
    assertEquals(0, sku3.getQuantityAvailable().intValue());
    assertFalse(sku3.getIsMachineSortable());
    assertFalse(sku3.hasRetailPrice());
    assertFalse(sku3.hasSalePrice());
    assertFalse(((SkuImpl) sku3).getDiscountable());
    assertFalse(((SkuImpl) sku3).hasDefaultSku());
    assertFalse(priceData.getDidOverride());
    assertTrue(sku3.getProductOptionValues().isEmpty());
    assertTrue(sku3.getMultiValueSkuAttributes().isEmpty());
    assertTrue(sku3.getSkuAttributes().isEmpty());
    assertTrue(sku3.getSkuMedia().isEmpty());
    assertTrue(sku3.getProductOptionValuesCollection().isEmpty());
    assertTrue(sku3.getAvailable());
    assertSame(sku, sku2);
    Dimension dimension = sku.dimension;
    assertSame(dimension, sku3.getDimension());
    assertSame(dimension, ((SkuImpl) sku3).dimension);
    assertSame(sku.legacyProductOptionValues, ((SkuImpl) sku3).legacyProductOptionValues);
    assertSame(sku.legacySkuMedia, ((SkuImpl) sku3).legacySkuMedia);
    assertSame(sku.skuAttributes, ((SkuImpl) sku3).skuAttributes);
    Map<String, SkuMediaXref> stringSkuMediaXrefMap = sku.skuMedia;
    assertSame(stringSkuMediaXrefMap, sku3.getSkuMediaXref());
    assertSame(stringSkuMediaXrefMap, sku3.getSkuMediaXrefIgnoreDefaultSku());
    assertSame(stringSkuMediaXrefMap, ((SkuImpl) sku3).skuMedia);
    Weight weight = sku.weight;
    assertSame(weight, sku3.getWeight());
    assertSame(weight, ((SkuImpl) sku3).weight);
  }

  /**
   * Method under test: {@link SkuBundleItemImpl#getRetailPrice()}
   */
  @Test
  public void testGetRetailPrice2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    Money money = new Money();
    when(sku.getRetailPrice()).thenReturn(money);

    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    skuBundleItemImpl.setSku(sku);

    // Act
    Money actualRetailPrice = skuBundleItemImpl.getRetailPrice();

    // Assert
    verify(sku).getId();
    verify(sku).getRetailPrice();
    assertSame(money, actualRetailPrice);
  }

  /**
   * Method under test: {@link SkuBundleItemImpl#getBundle()}
   */
  @Test
  public void testGetBundle() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    ProductBundleImpl bundle = new ProductBundleImpl();
    skuBundleItemImpl.setBundle(bundle);

    // Act
    ProductBundle actualBundle = skuBundleItemImpl.getBundle();

    // Assert
    ProductBundle productBundle = skuBundleItemImpl.bundle;
    assertTrue(productBundle instanceof ProductBundleImpl);
    ProductBundle productBundle2 = skuBundleItemImpl.deproxiedBundle;
    assertTrue(productBundle2 instanceof ProductBundleImpl);
    assertSame(bundle, actualBundle);
    ArchiveStatus archiveStatus = ((ProductImpl) actualBundle).archiveStatus;
    assertSame(archiveStatus, ((ProductBundleImpl) productBundle).archiveStatus);
    assertSame(archiveStatus, ((ProductBundleImpl) productBundle2).archiveStatus);
    List<ProductAttribute> productAttributeList = ((ProductImpl) actualBundle).productAttributes;
    assertSame(productAttributeList, ((ProductBundleImpl) productBundle).productAttributes);
    assertSame(productAttributeList, ((ProductBundleImpl) productBundle2).productAttributes);
    Map<String, Set<String>> stringSetMap = ((ProductImpl) actualBundle).productOptionMap;
    assertSame(stringSetMap, ((ProductBundleImpl) productBundle).productOptionMap);
    assertSame(stringSetMap, ((ProductBundleImpl) productBundle2).productOptionMap);
    List<ProductOptionXref> productOptionXrefList = ((ProductImpl) actualBundle).productOptions;
    assertSame(productOptionXrefList, ((ProductBundleImpl) productBundle).productOptions);
    assertSame(productOptionXrefList, ((ProductBundleImpl) productBundle2).productOptions);
    List<Sku> skuList = ((ProductImpl) actualBundle).skus;
    assertSame(skuList, ((ProductBundleImpl) productBundle).skus);
    assertSame(skuList, ((ProductBundleImpl) productBundle2).skus);
  }

  /**
   * Method under test: {@link SkuBundleItemImpl#getBundle()}
   */
  @Test
  public void testGetBundle2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundle bundle = mock(ProductBundle.class);
    when(bundle.getId()).thenReturn(1L);

    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    skuBundleItemImpl.setBundle(bundle);

    // Act
    ProductBundle actualBundle = skuBundleItemImpl.getBundle();

    // Assert
    verify(bundle).getId();
    assertSame(skuBundleItemImpl.deproxiedBundle, actualBundle);
  }

  /**
   * Method under test: {@link SkuBundleItemImpl#getSku()}
   */
  @Test
  public void testGetSku() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    SkuImpl sku = new SkuImpl();
    skuBundleItemImpl.setSku(sku);

    // Act
    Sku actualSku = skuBundleItemImpl.getSku();

    // Assert
    Sku sku2 = skuBundleItemImpl.deproxiedSku;
    assertTrue(sku2 instanceof SkuImpl);
    Sku sku3 = skuBundleItemImpl.sku;
    assertTrue(sku3 instanceof SkuImpl);
    assertSame(sku, actualSku);
    Dimension dimension = ((SkuImpl) actualSku).dimension;
    assertSame(dimension, ((SkuImpl) sku2).dimension);
    assertSame(dimension, ((SkuImpl) sku3).dimension);
    Set<ProductOptionValue> productOptionValueSet = ((SkuImpl) actualSku).legacyProductOptionValues;
    assertSame(productOptionValueSet, ((SkuImpl) sku2).legacyProductOptionValues);
    assertSame(productOptionValueSet, ((SkuImpl) sku3).legacyProductOptionValues);
    Map<String, Media> stringMediaMap = ((SkuImpl) actualSku).legacySkuMedia;
    assertSame(stringMediaMap, ((SkuImpl) sku2).legacySkuMedia);
    assertSame(stringMediaMap, ((SkuImpl) sku3).legacySkuMedia);
    List<SkuAttribute> skuAttributeList = ((SkuImpl) actualSku).skuAttributes;
    assertSame(skuAttributeList, ((SkuImpl) sku2).skuAttributes);
    assertSame(skuAttributeList, ((SkuImpl) sku3).skuAttributes);
    Map<String, SkuMediaXref> stringSkuMediaXrefMap = ((SkuImpl) actualSku).skuMedia;
    assertSame(stringSkuMediaXrefMap, ((SkuImpl) sku2).skuMedia);
    assertSame(stringSkuMediaXrefMap, ((SkuImpl) sku3).skuMedia);
    Weight weight = ((SkuImpl) actualSku).weight;
    assertSame(weight, ((SkuImpl) sku2).weight);
    assertSame(weight, ((SkuImpl) sku3).weight);
  }

  /**
   * Method under test: {@link SkuBundleItemImpl#getSku()}
   */
  @Test
  public void testGetSku2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);

    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    skuBundleItemImpl.setSku(sku);

    // Act
    Sku actualSku = skuBundleItemImpl.getSku();

    // Assert
    verify(sku).getId();
    assertSame(skuBundleItemImpl.sku, actualSku);
  }

  /**
   * Method under test: {@link SkuBundleItemImpl#clearDynamicPrices()}
   */
  @Test
  public void testClearDynamicPrices() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    SkuImpl sku = new SkuImpl();
    skuBundleItemImpl.setSku(sku);

    // Act
    skuBundleItemImpl.clearDynamicPrices();

    // Assert
    Sku sku2 = skuBundleItemImpl.getSku();
    assertTrue(sku2 instanceof SkuImpl);
    Sku sku3 = skuBundleItemImpl.deproxiedSku;
    assertTrue(sku3 instanceof SkuImpl);
    assertNull(sku3.getTaxable());
    assertNull(((SkuImpl) sku3).isMachineSortable);
    assertNull(((SkuImpl) sku3).available);
    assertNull(((SkuImpl) sku3).discountable);
    assertNull(((SkuImpl) sku3).taxable);
    assertNull(sku3.getId());
    assertNull(sku3.getDescription());
    assertNull(sku3.getDisplayTemplate());
    assertNull(sku3.getExternalId());
    assertNull(sku3.getLongDescription());
    assertNull(sku3.getName());
    assertNull(sku3.getTaxCode());
    assertNull(sku3.getUpc());
    assertNull(sku3.getUrlKey());
    assertNull(((SkuImpl) sku3).description);
    assertNull(((SkuImpl) sku3).fulfillmentType);
    assertNull(((SkuImpl) sku3).inventoryType);
    assertNull(((SkuImpl) sku3).longDescription);
    assertNull(((SkuImpl) sku3).name);
    assertNull(((SkuImpl) sku3).taxCode);
    assertNull(((SkuImpl) sku3).cost);
    assertNull(((SkuImpl) sku3).retailPrice);
    assertNull(((SkuImpl) sku3).salePrice);
    assertNull(sku3.getActiveEndDate());
    assertNull(sku3.getActiveStartDate());
    assertNull(((SkuImpl) sku3).activeEndDate);
    assertNull(((SkuImpl) sku3).activeStartDate);
    assertNull(sku3.getCurrency());
    assertNull(((SkuImpl) sku3).currency);
    assertNull(sku3.getPrimarySkuMedia());
    assertNull(sku3.getBaseRetailPrice());
    assertNull(sku3.getBaseSalePrice());
    assertNull(sku3.getCost());
    assertNull(sku3.getListPrice());
    assertNull(sku3.getPrice());
    assertNull(sku3.getProductOptionValueAdjustments());
    assertNull(sku3.getRetailPrice());
    assertNull(sku3.getSalePrice());
    assertNull(((SkuImpl) sku3).getRetailPriceInternal());
    DynamicSkuPrices priceData = sku3.getPriceData();
    assertNull(priceData.getPrice());
    assertNull(priceData.getPriceAdjustment());
    assertNull(priceData.getRetailPrice());
    assertNull(priceData.getSalePrice());
    assertNull(sku3.getDefaultProduct());
    assertNull(sku3.getProduct());
    assertNull(((SkuImpl) sku3).product);
    assertNull(sku3.getInventoryType());
    assertNull(sku3.getFulfillmentType());
    assertEquals(0, sku3.getQuantityAvailable().intValue());
    assertFalse(sku3.getIsMachineSortable());
    assertFalse(sku3.hasRetailPrice());
    assertFalse(sku3.hasSalePrice());
    assertFalse(((SkuImpl) sku3).getDiscountable());
    assertFalse(((SkuImpl) sku3).hasDefaultSku());
    assertFalse(priceData.getDidOverride());
    assertTrue(sku3.getProductOptionValues().isEmpty());
    assertTrue(sku3.getMultiValueSkuAttributes().isEmpty());
    assertTrue(sku3.getSkuAttributes().isEmpty());
    assertTrue(sku3.getSkuMedia().isEmpty());
    assertTrue(sku3.getProductOptionValuesCollection().isEmpty());
    assertTrue(sku3.getAvailable());
    assertSame(sku, sku2);
    Dimension dimension = sku.dimension;
    assertSame(dimension, sku3.getDimension());
    assertSame(dimension, ((SkuImpl) sku3).dimension);
    assertSame(sku.legacyProductOptionValues, ((SkuImpl) sku3).legacyProductOptionValues);
    assertSame(sku.legacySkuMedia, ((SkuImpl) sku3).legacySkuMedia);
    assertSame(sku.skuAttributes, ((SkuImpl) sku3).skuAttributes);
    Map<String, SkuMediaXref> stringSkuMediaXrefMap = sku.skuMedia;
    assertSame(stringSkuMediaXrefMap, sku3.getSkuMediaXref());
    assertSame(stringSkuMediaXrefMap, sku3.getSkuMediaXrefIgnoreDefaultSku());
    assertSame(stringSkuMediaXrefMap, ((SkuImpl) sku3).skuMedia);
    Weight weight = sku.weight;
    assertSame(weight, sku3.getWeight());
    assertSame(weight, ((SkuImpl) sku3).weight);
  }

  /**
   * Method under test: {@link SkuBundleItemImpl#clearDynamicPrices()}
   */
  @Test
  public void testClearDynamicPrices2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Sku sku = mock(Sku.class);
    when(sku.getId()).thenReturn(1L);
    doNothing().when(sku).clearDynamicPrices();

    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    skuBundleItemImpl.setSku(sku);

    // Act
    skuBundleItemImpl.clearDynamicPrices();

    // Assert
    verify(sku).clearDynamicPrices();
    verify(sku).getId();
    Sku expectedSku = skuBundleItemImpl.sku;
    assertSame(expectedSku, skuBundleItemImpl.getSku());
  }

  /**
   * Method under test: {@link SkuBundleItemImpl#clearDynamicPrices()}
   */
  @Test
  public void testClearDynamicPrices3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl sku = new SkuImpl();
    Money salePrice = new Money();
    sku.setSalePrice(salePrice);

    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    skuBundleItemImpl.setSku(sku);

    // Act
    skuBundleItemImpl.clearDynamicPrices();

    // Assert
    Sku sku2 = skuBundleItemImpl.getSku();
    assertTrue(sku2 instanceof SkuImpl);
    Sku sku3 = skuBundleItemImpl.deproxiedSku;
    assertTrue(sku3 instanceof SkuImpl);
    assertNull(sku3.getTaxable());
    assertNull(((SkuImpl) sku3).isMachineSortable);
    assertNull(((SkuImpl) sku3).available);
    assertNull(((SkuImpl) sku3).discountable);
    assertNull(((SkuImpl) sku3).taxable);
    assertNull(sku3.getId());
    assertNull(sku3.getDescription());
    assertNull(sku3.getDisplayTemplate());
    assertNull(sku3.getExternalId());
    assertNull(sku3.getLongDescription());
    assertNull(sku3.getName());
    assertNull(sku3.getTaxCode());
    assertNull(sku3.getUpc());
    assertNull(sku3.getUrlKey());
    assertNull(((SkuImpl) sku3).description);
    assertNull(((SkuImpl) sku3).fulfillmentType);
    assertNull(((SkuImpl) sku3).inventoryType);
    assertNull(((SkuImpl) sku3).longDescription);
    assertNull(((SkuImpl) sku3).name);
    assertNull(((SkuImpl) sku3).taxCode);
    assertNull(((SkuImpl) sku3).cost);
    assertNull(((SkuImpl) sku3).retailPrice);
    assertNull(sku3.getActiveEndDate());
    assertNull(sku3.getActiveStartDate());
    assertNull(((SkuImpl) sku3).activeEndDate);
    assertNull(((SkuImpl) sku3).activeStartDate);
    assertNull(sku3.getCurrency());
    assertNull(((SkuImpl) sku3).currency);
    assertNull(sku3.getPrimarySkuMedia());
    assertNull(sku3.getBaseRetailPrice());
    assertNull(sku3.getCost());
    assertNull(sku3.getListPrice());
    assertNull(sku3.getPrice());
    assertNull(sku3.getProductOptionValueAdjustments());
    assertNull(sku3.getRetailPrice());
    assertNull(((SkuImpl) sku3).getRetailPriceInternal());
    DynamicSkuPrices priceData = sku3.getPriceData();
    assertNull(priceData.getPriceAdjustment());
    assertNull(priceData.getRetailPrice());
    assertNull(sku3.getDefaultProduct());
    assertNull(sku3.getProduct());
    assertNull(((SkuImpl) sku3).product);
    assertNull(sku3.getInventoryType());
    assertNull(sku3.getFulfillmentType());
    assertEquals(0, sku3.getQuantityAvailable().intValue());
    assertFalse(sku3.getIsMachineSortable());
    assertFalse(sku3.hasRetailPrice());
    assertFalse(((SkuImpl) sku3).getDiscountable());
    assertFalse(((SkuImpl) sku3).hasDefaultSku());
    assertFalse(priceData.getDidOverride());
    assertTrue(sku3.getProductOptionValues().isEmpty());
    assertTrue(sku3.getMultiValueSkuAttributes().isEmpty());
    assertTrue(sku3.getSkuAttributes().isEmpty());
    assertTrue(sku3.getSkuMedia().isEmpty());
    assertTrue(sku3.getProductOptionValuesCollection().isEmpty());
    assertTrue(sku3.getAvailable());
    assertTrue(sku3.hasSalePrice());
    assertEquals(salePrice, sku3.getBaseSalePrice());
    assertEquals(salePrice, sku3.getSalePrice());
    Money price = priceData.getPrice();
    assertEquals(salePrice, price);
    assertSame(sku, sku2);
    assertSame(price, priceData.getSalePrice());
    Money expectedMargin = salePrice.ZERO;
    assertSame(expectedMargin, sku3.getMargin());
    Dimension dimension = sku.dimension;
    assertSame(dimension, sku3.getDimension());
    assertSame(dimension, ((SkuImpl) sku3).dimension);
    assertSame(sku.legacyProductOptionValues, ((SkuImpl) sku3).legacyProductOptionValues);
    assertSame(sku.legacySkuMedia, ((SkuImpl) sku3).legacySkuMedia);
    assertSame(sku.salePrice, ((SkuImpl) sku3).salePrice);
    assertSame(sku.skuAttributes, ((SkuImpl) sku3).skuAttributes);
    Map<String, SkuMediaXref> stringSkuMediaXrefMap = sku.skuMedia;
    assertSame(stringSkuMediaXrefMap, sku3.getSkuMediaXref());
    assertSame(stringSkuMediaXrefMap, sku3.getSkuMediaXrefIgnoreDefaultSku());
    assertSame(stringSkuMediaXrefMap, ((SkuImpl) sku3).skuMedia);
    Weight weight = sku.weight;
    assertSame(weight, sku3.getWeight());
    assertSame(weight, ((SkuImpl) sku3).weight);
  }

  /**
   * Method under test:
   * {@link SkuBundleItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<SkuBundleItem> actualCreateOrRetrieveCopyInstanceResult = skuBundleItemImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SkuBundleItemImpl#equals(Object)}
   *   <li>{@link SkuBundleItemImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    skuBundleItemImpl.setBundle(new ProductBundleImpl());
    skuBundleItemImpl.setId(1L);
    skuBundleItemImpl.setQuantity(1);
    skuBundleItemImpl.setSalePrice(new Money());
    skuBundleItemImpl.setSequence(new BigDecimal("2.3"));
    skuBundleItemImpl.setSku(new SkuImpl());

    SkuBundleItemImpl skuBundleItemImpl2 = new SkuBundleItemImpl();
    skuBundleItemImpl2.setBundle(new ProductBundleImpl());
    skuBundleItemImpl2.setId(1L);
    skuBundleItemImpl2.setQuantity(1);
    skuBundleItemImpl2.setSalePrice(new Money());
    skuBundleItemImpl2.setSequence(new BigDecimal("2.3"));
    skuBundleItemImpl2.setSku(new SkuImpl());

    // Act and Assert
    assertEquals(skuBundleItemImpl, skuBundleItemImpl2);
    int expectedHashCodeResult = skuBundleItemImpl.hashCode();
    assertEquals(expectedHashCodeResult, skuBundleItemImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SkuBundleItemImpl#equals(Object)}
   *   <li>{@link SkuBundleItemImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    skuBundleItemImpl.setBundle(mock(ProductBundle.class));
    skuBundleItemImpl.setId(1L);
    skuBundleItemImpl.setQuantity(1);
    skuBundleItemImpl.setSalePrice(new Money());
    skuBundleItemImpl.setSequence(new BigDecimal("2.3"));
    skuBundleItemImpl.setSku(new SkuImpl());

    SkuBundleItemImpl skuBundleItemImpl2 = new SkuBundleItemImpl();
    skuBundleItemImpl2.setBundle(new ProductBundleImpl());
    skuBundleItemImpl2.setId(1L);
    skuBundleItemImpl2.setQuantity(1);
    skuBundleItemImpl2.setSalePrice(new Money());
    skuBundleItemImpl2.setSequence(new BigDecimal("2.3"));
    skuBundleItemImpl2.setSku(new SkuImpl());

    // Act and Assert
    assertEquals(skuBundleItemImpl, skuBundleItemImpl2);
    int expectedHashCodeResult = skuBundleItemImpl.hashCode();
    assertEquals(expectedHashCodeResult, skuBundleItemImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SkuBundleItemImpl#equals(Object)}
   *   <li>{@link SkuBundleItemImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    skuBundleItemImpl.setBundle(new ProductBundleImpl());
    skuBundleItemImpl.setId(1L);
    skuBundleItemImpl.setQuantity(1);
    skuBundleItemImpl.setSalePrice(new Money());
    skuBundleItemImpl.setSequence(new BigDecimal("2.3"));
    skuBundleItemImpl.setSku(new SkuImpl());

    // Act and Assert
    assertEquals(skuBundleItemImpl, skuBundleItemImpl);
    int expectedHashCodeResult = skuBundleItemImpl.hashCode();
    assertEquals(expectedHashCodeResult, skuBundleItemImpl.hashCode());
  }

  /**
   * Method under test: {@link SkuBundleItemImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    skuBundleItemImpl.setBundle(new ProductBundleImpl());
    skuBundleItemImpl.setId(2L);
    skuBundleItemImpl.setQuantity(1);
    skuBundleItemImpl.setSalePrice(new Money());
    skuBundleItemImpl.setSequence(new BigDecimal("2.3"));
    skuBundleItemImpl.setSku(new SkuImpl());

    SkuBundleItemImpl skuBundleItemImpl2 = new SkuBundleItemImpl();
    skuBundleItemImpl2.setBundle(new ProductBundleImpl());
    skuBundleItemImpl2.setId(1L);
    skuBundleItemImpl2.setQuantity(1);
    skuBundleItemImpl2.setSalePrice(new Money());
    skuBundleItemImpl2.setSequence(new BigDecimal("2.3"));
    skuBundleItemImpl2.setSku(new SkuImpl());

    // Act and Assert
    assertNotEquals(skuBundleItemImpl, skuBundleItemImpl2);
  }

  /**
   * Method under test: {@link SkuBundleItemImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    skuBundleItemImpl.setBundle(new ProductBundleImpl());
    skuBundleItemImpl.setId(1L);
    skuBundleItemImpl.setQuantity(1);
    skuBundleItemImpl.setSalePrice(new Money());
    skuBundleItemImpl.setSequence(new BigDecimal("2.3"));
    skuBundleItemImpl.setSku(new SkuImpl());

    // Act and Assert
    assertNotEquals(skuBundleItemImpl, null);
  }

  /**
   * Method under test: {@link SkuBundleItemImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    skuBundleItemImpl.setBundle(new ProductBundleImpl());
    skuBundleItemImpl.setId(1L);
    skuBundleItemImpl.setQuantity(1);
    skuBundleItemImpl.setSalePrice(new Money());
    skuBundleItemImpl.setSequence(new BigDecimal("2.3"));
    skuBundleItemImpl.setSku(new SkuImpl());

    // Act and Assert
    assertNotEquals(skuBundleItemImpl, "Different type to SkuBundleItemImpl");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SkuBundleItemImpl}
   *   <li>{@link SkuBundleItemImpl#setBundle(ProductBundle)}
   *   <li>{@link SkuBundleItemImpl#setId(Long)}
   *   <li>{@link SkuBundleItemImpl#setQuantity(Integer)}
   *   <li>{@link SkuBundleItemImpl#setSequence(BigDecimal)}
   *   <li>{@link SkuBundleItemImpl#setSku(Sku)}
   *   <li>{@link SkuBundleItemImpl#getId()}
   *   <li>{@link SkuBundleItemImpl#getQuantity()}
   *   <li>{@link SkuBundleItemImpl#getSequence()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SkuBundleItemImpl actualSkuBundleItemImpl = new SkuBundleItemImpl();
    actualSkuBundleItemImpl.setBundle(new ProductBundleImpl());
    actualSkuBundleItemImpl.setId(1L);
    actualSkuBundleItemImpl.setQuantity(1);
    BigDecimal sequence = new BigDecimal("2.3");
    actualSkuBundleItemImpl.setSequence(sequence);
    actualSkuBundleItemImpl.setSku(new SkuImpl());
    Long actualId = actualSkuBundleItemImpl.getId();
    Integer actualQuantity = actualSkuBundleItemImpl.getQuantity();
    BigDecimal actualSequence = actualSkuBundleItemImpl.getSequence();

    // Assert that nothing has changed
    assertEquals(1, actualQuantity.intValue());
    assertEquals(1L, actualId.longValue());
    assertEquals(new BigDecimal("2.3"), actualSequence);
    assertSame(sequence, actualSequence);
  }
}

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
   * Test {@link SkuBundleItemImpl#getDynamicSalePrice(Sku, BigDecimal)}.
   * <ul>
   *   <li>Given {@link SkuBundleItemImpl} (default constructor).</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuBundleItemImpl#getDynamicSalePrice(Sku, BigDecimal)}
   */
  @Test
  public void testGetDynamicSalePrice_givenSkuBundleItemImpl_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();

    // Act and Assert
    assertNull(skuBundleItemImpl.getDynamicSalePrice(new SkuImpl(), null));
  }

  /**
   * Test {@link SkuBundleItemImpl#getDynamicSalePrice(Sku, BigDecimal)}.
   * <ul>
   *   <li>Given {@link SkuBundleItemImpl} (default constructor).</li>
   *   <li>When {@link Sku}.</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuBundleItemImpl#getDynamicSalePrice(Sku, BigDecimal)}
   */
  @Test
  public void testGetDynamicSalePrice_givenSkuBundleItemImpl_whenSku_thenReturnZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    Sku sku = mock(Sku.class);

    // Act
    Money actualDynamicSalePrice = skuBundleItemImpl.getDynamicSalePrice(sku, new BigDecimal("2.3"));

    // Assert
    assertEquals(actualDynamicSalePrice, actualDynamicSalePrice.abs());
    Money expectedZeroResult = actualDynamicSalePrice.ZERO;
    assertEquals(expectedZeroResult, actualDynamicSalePrice.zero());
  }

  /**
   * Test {@link SkuBundleItemImpl#getDynamicSalePrice(Sku, BigDecimal)}.
   * <ul>
   *   <li>Then return abs abs abs abs abs abs abs zero is
   * {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuBundleItemImpl#getDynamicSalePrice(Sku, BigDecimal)}
   */
  @Test
  public void testGetDynamicSalePrice_thenReturnAbsAbsAbsAbsAbsAbsAbsZeroIsMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    Money salePrice = new Money();
    skuBundleItemImpl.setSalePrice(salePrice);
    SkuImpl sku = new SkuImpl();

    // Act
    Money actualDynamicSalePrice = skuBundleItemImpl.getDynamicSalePrice(sku, new BigDecimal("2.3"));

    // Assert
    Money absResult = actualDynamicSalePrice.abs();
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    Money absResult6 = absResult5.abs();
    assertEquals(salePrice, absResult6.abs().zero());
    assertEquals(salePrice, absResult6.zero());
    assertEquals(salePrice, absResult5.zero());
    assertEquals(salePrice, absResult4.zero());
    assertEquals(salePrice, absResult3.zero());
    assertEquals(salePrice, absResult2.zero());
    assertEquals(salePrice, absResult.zero());
    assertEquals(salePrice, actualDynamicSalePrice.zero());
  }

  /**
   * Test {@link SkuBundleItemImpl#getDynamicSalePrice(Sku, BigDecimal)}.
   * <ul>
   *   <li>Then return abs abs abs abs abs abs abs zero is {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuBundleItemImpl#getDynamicSalePrice(Sku, BigDecimal)}
   */
  @Test
  public void testGetDynamicSalePrice_thenReturnAbsAbsAbsAbsAbsAbsAbsZeroIsZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    SkuImpl sku = new SkuImpl();

    // Act
    Money actualDynamicSalePrice = skuBundleItemImpl.getDynamicSalePrice(sku, new BigDecimal("2.3"));

    // Assert
    Money money = actualDynamicSalePrice.ZERO;
    Money absResult = actualDynamicSalePrice.abs();
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    Money absResult6 = absResult5.abs();
    assertEquals(money, absResult6.abs().zero());
    assertEquals(money, absResult6.zero());
    assertEquals(money, absResult5.zero());
    assertEquals(money, absResult4.zero());
    assertEquals(money, absResult3.zero());
    assertEquals(money, absResult2.zero());
    assertEquals(money, absResult.zero());
    assertEquals(money, actualDynamicSalePrice.zero());
  }

  /**
   * Test {@link SkuBundleItemImpl#setSalePrice(Money)}.
   * <ul>
   *   <li>Then {@link SkuBundleItemImpl} (default constructor) Bundle
   * {@link ProductBundleImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuBundleItemImpl#setSalePrice(Money)}
   */
  @Test
  public void testSetSalePrice_thenSkuBundleItemImplBundleProductBundleImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    skuBundleItemImpl.setBundle(new ProductBundleImpl());
    skuBundleItemImpl.setId(1L);
    skuBundleItemImpl.setQuantity(1);
    Money salePrice = new Money();
    skuBundleItemImpl.setSalePrice(salePrice);
    skuBundleItemImpl.setSequence(new BigDecimal("2.3"));
    skuBundleItemImpl.setSku(new SkuImpl());

    // Act
    skuBundleItemImpl.setSalePrice(null);

    // Assert
    ProductBundle bundle = skuBundleItemImpl.getBundle();
    assertTrue(bundle instanceof ProductBundleImpl);
    ProductBundle productBundle = skuBundleItemImpl.bundle;
    assertTrue(productBundle instanceof ProductBundleImpl);
    Money bundleItemsRetailPrice = bundle.getBundleItemsRetailPrice();
    Currency currency = bundleItemsRetailPrice.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertNull(skuBundleItemImpl.itemSalePrice);
    assertNull(skuBundleItemImpl.getSalePrice());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedPotentialSavings = new BigDecimal("0.00");
    BigDecimal potentialSavings = bundle.getPotentialSavings();
    assertEquals(expectedPotentialSavings, potentialSavings);
    Money absResult = bundleItemsRetailPrice.abs();
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    Money absResult6 = absResult5.abs();
    assertEquals(salePrice, absResult6.abs());
    Money zeroResult = bundleItemsRetailPrice.zero();
    Money absResult7 = zeroResult.abs();
    Money absResult8 = absResult7.abs();
    Money absResult9 = absResult8.abs();
    Money absResult10 = absResult9.abs();
    assertEquals(salePrice, absResult10.abs());
    Money zeroResult2 = absResult2.zero();
    Money absResult11 = zeroResult2.abs();
    Money absResult12 = absResult11.abs();
    Money absResult13 = absResult12.abs();
    assertEquals(salePrice, absResult13.abs());
    Money zeroResult3 = absResult.zero();
    Money absResult14 = zeroResult3.abs();
    Money absResult15 = absResult14.abs();
    Money absResult16 = absResult15.abs();
    assertEquals(salePrice, absResult16.abs());
    Money zeroResult4 = zeroResult.zero();
    Money absResult17 = zeroResult4.abs();
    Money absResult18 = absResult17.abs();
    Money absResult19 = absResult18.abs();
    assertEquals(salePrice, absResult19.abs());
    Money zeroResult5 = absResult3.zero();
    Money absResult20 = zeroResult5.abs();
    Money absResult21 = absResult20.abs();
    assertEquals(salePrice, absResult21.abs());
    Money zeroResult6 = absResult7.zero();
    Money absResult22 = zeroResult6.abs();
    Money absResult23 = absResult22.abs();
    assertEquals(salePrice, absResult23.abs());
    Money zeroResult7 = zeroResult2.zero();
    Money absResult24 = zeroResult7.abs();
    Money absResult25 = absResult24.abs();
    assertEquals(salePrice, absResult25.abs());
    Money zeroResult8 = zeroResult3.zero();
    Money absResult26 = zeroResult8.abs();
    Money absResult27 = absResult26.abs();
    assertEquals(salePrice, absResult27.abs());
    Money zeroResult9 = zeroResult4.zero();
    Money absResult28 = zeroResult9.abs();
    Money absResult29 = absResult28.abs();
    assertEquals(salePrice, absResult29.abs());
    Money zeroResult10 = absResult4.zero();
    Money absResult30 = zeroResult10.abs();
    assertEquals(salePrice, absResult30.abs());
    Money zeroResult11 = absResult8.zero();
    Money absResult31 = zeroResult11.abs();
    assertEquals(salePrice, absResult31.abs());
    Money zeroResult12 = absResult11.zero();
    Money absResult32 = zeroResult12.abs();
    assertEquals(salePrice, absResult32.abs());
    Money zeroResult13 = absResult14.zero();
    Money absResult33 = zeroResult13.abs();
    assertEquals(salePrice, absResult33.abs());
    Money zeroResult14 = absResult17.zero();
    Money absResult34 = zeroResult14.abs();
    assertEquals(salePrice, absResult34.abs());
    Money zeroResult15 = zeroResult5.zero();
    Money absResult35 = zeroResult15.abs();
    assertEquals(salePrice, absResult35.abs());
    Money zeroResult16 = zeroResult6.zero();
    Money absResult36 = zeroResult16.abs();
    assertEquals(salePrice, absResult36.abs());
    Money zeroResult17 = zeroResult7.zero();
    Money absResult37 = zeroResult17.abs();
    assertEquals(salePrice, absResult37.abs());
    Money zeroResult18 = zeroResult8.zero();
    Money absResult38 = zeroResult18.abs();
    assertEquals(salePrice, absResult38.abs());
    Money zeroResult19 = zeroResult9.zero();
    Money absResult39 = zeroResult19.abs();
    assertEquals(salePrice, absResult39.abs());
    Money zeroResult20 = absResult5.zero();
    assertEquals(salePrice, zeroResult20.abs());
    Money zeroResult21 = absResult9.zero();
    assertEquals(salePrice, zeroResult21.abs());
    Money zeroResult22 = absResult12.zero();
    assertEquals(salePrice, zeroResult22.abs());
    Money zeroResult23 = absResult15.zero();
    assertEquals(salePrice, zeroResult23.abs());
    Money zeroResult24 = absResult18.zero();
    assertEquals(salePrice, zeroResult24.abs());
    Money zeroResult25 = absResult20.zero();
    assertEquals(salePrice, zeroResult25.abs());
    Money zeroResult26 = absResult22.zero();
    assertEquals(salePrice, zeroResult26.abs());
    Money zeroResult27 = absResult24.zero();
    assertEquals(salePrice, zeroResult27.abs());
    Money zeroResult28 = absResult26.zero();
    assertEquals(salePrice, zeroResult28.abs());
    Money zeroResult29 = absResult28.zero();
    assertEquals(salePrice, zeroResult29.abs());
    Money zeroResult30 = zeroResult10.zero();
    assertEquals(salePrice, zeroResult30.abs());
    Money zeroResult31 = zeroResult11.zero();
    assertEquals(salePrice, zeroResult31.abs());
    Money zeroResult32 = zeroResult12.zero();
    assertEquals(salePrice, zeroResult32.abs());
    Money zeroResult33 = zeroResult13.zero();
    assertEquals(salePrice, zeroResult33.abs());
    Money zeroResult34 = zeroResult14.zero();
    assertEquals(salePrice, zeroResult34.abs());
    Money zeroResult35 = zeroResult15.zero();
    assertEquals(salePrice, zeroResult35.abs());
    Money zeroResult36 = zeroResult16.zero();
    assertEquals(salePrice, zeroResult36.abs());
    Money zeroResult37 = zeroResult18.zero();
    assertEquals(salePrice, zeroResult37.abs());
    Money zeroResult38 = zeroResult19.zero();
    assertEquals(salePrice, zeroResult38.abs());
    assertEquals(salePrice, absResult6.zero());
    assertEquals(salePrice, absResult10.zero());
    assertEquals(salePrice, absResult13.zero());
    assertEquals(salePrice, absResult16.zero());
    assertEquals(salePrice, absResult19.zero());
    assertEquals(salePrice, absResult21.zero());
    assertEquals(salePrice, absResult23.zero());
    assertEquals(salePrice, absResult25.zero());
    assertEquals(salePrice, absResult27.zero());
    assertEquals(salePrice, absResult29.zero());
    assertEquals(salePrice, absResult30.zero());
    assertEquals(salePrice, absResult31.zero());
    assertEquals(salePrice, absResult32.zero());
    assertEquals(salePrice, absResult33.zero());
    assertEquals(salePrice, absResult34.zero());
    assertEquals(salePrice, absResult35.zero());
    assertEquals(salePrice, absResult36.zero());
    assertEquals(salePrice, absResult37.zero());
    assertEquals(salePrice, absResult38.zero());
    assertEquals(salePrice, absResult39.zero());
    assertEquals(salePrice, zeroResult20.zero());
    assertEquals(salePrice, zeroResult21.zero());
    assertEquals(salePrice, zeroResult22.zero());
    assertEquals(salePrice, zeroResult23.zero());
    assertEquals(salePrice, zeroResult24.zero());
    assertEquals(salePrice, zeroResult25.zero());
    assertEquals(salePrice, zeroResult26.zero());
    assertEquals(salePrice, zeroResult27.zero());
    assertEquals(salePrice, zeroResult28.zero());
    assertEquals(salePrice, zeroResult29.zero());
    assertEquals(salePrice, zeroResult30.zero());
    assertEquals(salePrice, zeroResult31.zero());
    assertEquals(salePrice, zeroResult32.zero());
    assertEquals(salePrice, zeroResult33.zero());
    assertEquals(salePrice, zeroResult34.zero());
    assertEquals(salePrice, zeroResult35.zero());
    assertEquals(salePrice, zeroResult17.zero());
    assertEquals(salePrice, zeroResult36.zero());
    assertEquals(salePrice, zeroResult37.zero());
    assertEquals(salePrice, zeroResult38.zero());
    assertSame(currency, absResult6.getCurrency());
    assertSame(currency, absResult5.getCurrency());
    assertSame(currency, absResult10.getCurrency());
    assertSame(currency, absResult4.getCurrency());
    assertSame(currency, absResult13.getCurrency());
    assertSame(currency, absResult16.getCurrency());
    assertSame(currency, absResult19.getCurrency());
    assertSame(currency, absResult9.getCurrency());
    assertSame(currency, absResult3.getCurrency());
    assertSame(currency, absResult21.getCurrency());
    assertSame(currency, absResult12.getCurrency());
    assertSame(currency, absResult23.getCurrency());
    assertSame(currency, absResult15.getCurrency());
    assertSame(currency, absResult25.getCurrency());
    assertSame(currency, absResult27.getCurrency());
    assertSame(currency, absResult29.getCurrency());
    assertSame(currency, absResult18.getCurrency());
    assertSame(currency, absResult8.getCurrency());
    assertSame(currency, absResult2.getCurrency());
    assertSame(currency, absResult30.getCurrency());
    assertSame(currency, absResult20.getCurrency());
    assertSame(currency, absResult31.getCurrency());
    assertSame(currency, absResult11.getCurrency());
    assertSame(currency, absResult32.getCurrency());
    assertSame(currency, absResult33.getCurrency());
    assertSame(currency, absResult34.getCurrency());
    assertSame(currency, absResult22.getCurrency());
    assertSame(currency, absResult14.getCurrency());
    assertSame(currency, absResult35.getCurrency());
    assertSame(currency, absResult24.getCurrency());
    assertSame(currency, absResult36.getCurrency());
    assertSame(currency, absResult26.getCurrency());
    assertSame(currency, absResult37.getCurrency());
    assertSame(currency, absResult38.getCurrency());
    assertSame(currency, absResult39.getCurrency());
    assertSame(currency, absResult28.getCurrency());
    assertSame(currency, absResult17.getCurrency());
    assertSame(currency, absResult7.getCurrency());
    assertSame(currency, absResult.getCurrency());
    assertSame(currency, zeroResult20.getCurrency());
    assertSame(currency, zeroResult10.getCurrency());
    assertSame(currency, zeroResult21.getCurrency());
    assertSame(currency, zeroResult5.getCurrency());
    assertSame(currency, zeroResult22.getCurrency());
    assertSame(currency, zeroResult23.getCurrency());
    assertSame(currency, zeroResult24.getCurrency());
    assertSame(currency, zeroResult11.getCurrency());
    assertSame(currency, zeroResult2.getCurrency());
    assertSame(currency, zeroResult25.getCurrency());
    assertSame(currency, zeroResult12.getCurrency());
    assertSame(currency, zeroResult26.getCurrency());
    assertSame(currency, zeroResult13.getCurrency());
    assertSame(currency, zeroResult27.getCurrency());
    assertSame(currency, zeroResult28.getCurrency());
    assertSame(currency, zeroResult29.getCurrency());
    assertSame(currency, zeroResult14.getCurrency());
    assertSame(currency, zeroResult6.getCurrency());
    assertSame(currency, zeroResult3.getCurrency());
    assertSame(currency, zeroResult30.getCurrency());
    assertSame(currency, zeroResult15.getCurrency());
    assertSame(currency, zeroResult31.getCurrency());
    assertSame(currency, zeroResult7.getCurrency());
    assertSame(currency, zeroResult32.getCurrency());
    assertSame(currency, zeroResult33.getCurrency());
    assertSame(currency, zeroResult34.getCurrency());
    assertSame(currency, zeroResult16.getCurrency());
    assertSame(currency, zeroResult8.getCurrency());
    assertSame(currency, zeroResult35.getCurrency());
    assertSame(currency, zeroResult17.getCurrency());
    assertSame(currency, zeroResult36.getCurrency());
    assertSame(currency, zeroResult18.getCurrency());
    assertSame(currency, zeroResult37.getCurrency());
    assertSame(currency, zeroResult38.getCurrency());
    assertSame(currency, zeroResult19.getCurrency());
    assertSame(currency, zeroResult9.getCurrency());
    assertSame(currency, zeroResult4.getCurrency());
    assertSame(currency, zeroResult.getCurrency());
    assertSame(potentialSavings, absResult6.getAmount());
    assertSame(potentialSavings, absResult5.getAmount());
    assertSame(potentialSavings, absResult10.getAmount());
    assertSame(potentialSavings, absResult4.getAmount());
    assertSame(potentialSavings, absResult13.getAmount());
    assertSame(potentialSavings, absResult16.getAmount());
    assertSame(potentialSavings, absResult19.getAmount());
    assertSame(potentialSavings, absResult9.getAmount());
    assertSame(potentialSavings, absResult3.getAmount());
    assertSame(potentialSavings, absResult21.getAmount());
    assertSame(potentialSavings, absResult12.getAmount());
    assertSame(potentialSavings, absResult23.getAmount());
    assertSame(potentialSavings, absResult15.getAmount());
    assertSame(potentialSavings, absResult25.getAmount());
    assertSame(potentialSavings, absResult27.getAmount());
    assertSame(potentialSavings, absResult29.getAmount());
    assertSame(potentialSavings, absResult18.getAmount());
    assertSame(potentialSavings, absResult8.getAmount());
    assertSame(potentialSavings, absResult2.getAmount());
    assertSame(potentialSavings, absResult30.getAmount());
    assertSame(potentialSavings, absResult20.getAmount());
    assertSame(potentialSavings, absResult31.getAmount());
    assertSame(potentialSavings, absResult11.getAmount());
    assertSame(potentialSavings, absResult32.getAmount());
    assertSame(potentialSavings, absResult33.getAmount());
    assertSame(potentialSavings, absResult34.getAmount());
    assertSame(potentialSavings, absResult22.getAmount());
    assertSame(potentialSavings, absResult14.getAmount());
    assertSame(potentialSavings, absResult35.getAmount());
    assertSame(potentialSavings, absResult24.getAmount());
    assertSame(potentialSavings, absResult36.getAmount());
    assertSame(potentialSavings, absResult26.getAmount());
    assertSame(potentialSavings, absResult37.getAmount());
    assertSame(potentialSavings, absResult38.getAmount());
    assertSame(potentialSavings, absResult39.getAmount());
    assertSame(potentialSavings, absResult28.getAmount());
    assertSame(potentialSavings, absResult17.getAmount());
    assertSame(potentialSavings, absResult7.getAmount());
    assertSame(potentialSavings, absResult.getAmount());
    assertSame(potentialSavings, zeroResult20.getAmount());
    assertSame(potentialSavings, zeroResult10.getAmount());
    assertSame(potentialSavings, zeroResult21.getAmount());
    assertSame(potentialSavings, zeroResult5.getAmount());
    assertSame(potentialSavings, zeroResult22.getAmount());
    assertSame(potentialSavings, zeroResult23.getAmount());
    assertSame(potentialSavings, zeroResult24.getAmount());
    assertSame(potentialSavings, zeroResult11.getAmount());
    assertSame(potentialSavings, zeroResult2.getAmount());
    assertSame(potentialSavings, zeroResult25.getAmount());
    assertSame(potentialSavings, zeroResult12.getAmount());
    assertSame(potentialSavings, zeroResult26.getAmount());
    assertSame(potentialSavings, zeroResult13.getAmount());
    assertSame(potentialSavings, zeroResult27.getAmount());
    assertSame(potentialSavings, zeroResult28.getAmount());
    assertSame(potentialSavings, zeroResult29.getAmount());
    assertSame(potentialSavings, zeroResult14.getAmount());
    assertSame(potentialSavings, zeroResult6.getAmount());
    assertSame(potentialSavings, zeroResult3.getAmount());
    assertSame(potentialSavings, zeroResult30.getAmount());
    assertSame(potentialSavings, zeroResult15.getAmount());
    assertSame(potentialSavings, zeroResult31.getAmount());
    assertSame(potentialSavings, zeroResult7.getAmount());
    assertSame(potentialSavings, zeroResult32.getAmount());
    assertSame(potentialSavings, zeroResult33.getAmount());
    assertSame(potentialSavings, zeroResult34.getAmount());
    assertSame(potentialSavings, zeroResult16.getAmount());
    assertSame(potentialSavings, zeroResult8.getAmount());
    assertSame(potentialSavings, zeroResult35.getAmount());
    assertSame(potentialSavings, zeroResult17.getAmount());
    assertSame(potentialSavings, zeroResult36.getAmount());
    assertSame(potentialSavings, zeroResult18.getAmount());
    assertSame(potentialSavings, zeroResult37.getAmount());
    assertSame(potentialSavings, zeroResult38.getAmount());
    assertSame(potentialSavings, zeroResult19.getAmount());
    assertSame(potentialSavings, zeroResult9.getAmount());
    assertSame(potentialSavings, zeroResult4.getAmount());
    assertSame(potentialSavings, zeroResult.getAmount());
    assertSame(potentialSavings, bundleItemsRetailPrice.getAmount());
    assertSame(potentialSavings, productBundle.getPotentialSavings());
  }

  /**
   * Test {@link SkuBundleItemImpl#setSalePrice(Money)}.
   * <ul>
   *   <li>Then {@link SkuBundleItemImpl} (default constructor)
   * {@link SkuBundleItemImpl#itemSalePrice} is
   * {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuBundleItemImpl#setSalePrice(Money)}
   */
  @Test
  public void testSetSalePrice_thenSkuBundleItemImplItemSalePriceIsBigDecimalWith23() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    Money salePrice = mock(Money.class);
    when(salePrice.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    skuBundleItemImpl.setSalePrice(salePrice);

    // Assert
    verify(salePrice).getAmount();
    assertEquals(new BigDecimal("2.3"), skuBundleItemImpl.itemSalePrice);
  }

  /**
   * Test {@link SkuBundleItemImpl#setSalePrice(Money)}.
   * <ul>
   *   <li>When {@link Money#Money()}.</li>
   *   <li>Then {@link SkuBundleItemImpl} (default constructor)
   * {@link SkuBundleItemImpl#itemSalePrice} is
   * {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuBundleItemImpl#setSalePrice(Money)}
   */
  @Test
  public void testSetSalePrice_whenMoney_thenSkuBundleItemImplItemSalePriceIsBigDecimalWith000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    Money salePrice = new Money();

    // Act
    skuBundleItemImpl.setSalePrice(salePrice);

    // Assert
    assertEquals(new BigDecimal("0.00"), skuBundleItemImpl.itemSalePrice);
    BigDecimal bigDecimal = skuBundleItemImpl.itemSalePrice;
    Money absResult = salePrice.abs();
    assertSame(bigDecimal, absResult.getAmount());
    Money absResult2 = absResult.abs();
    assertSame(bigDecimal, absResult2.getAmount());
    Money absResult3 = absResult2.abs();
    assertSame(bigDecimal, absResult3.getAmount());
    Money absResult4 = absResult3.abs();
    assertSame(bigDecimal, absResult4.getAmount());
    Money absResult5 = absResult4.abs();
    assertSame(bigDecimal, absResult5.getAmount());
    Money absResult6 = absResult5.abs();
    assertSame(bigDecimal, absResult6.getAmount());
    assertSame(bigDecimal, absResult6.abs().getAmount());
    Money zeroResult = salePrice.zero();
    Money absResult7 = zeroResult.abs();
    Money absResult8 = absResult7.abs();
    Money absResult9 = absResult8.abs();
    Money absResult10 = absResult9.abs();
    Money absResult11 = absResult10.abs();
    assertSame(bigDecimal, absResult11.abs().getAmount());
    assertSame(bigDecimal, absResult11.getAmount());
    Money zeroResult2 = absResult.zero();
    Money absResult12 = zeroResult2.abs();
    Money absResult13 = absResult12.abs();
    Money absResult14 = absResult13.abs();
    Money absResult15 = absResult14.abs();
    assertSame(bigDecimal, absResult15.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    Money absResult16 = zeroResult3.abs();
    Money absResult17 = absResult16.abs();
    Money absResult18 = absResult17.abs();
    Money absResult19 = absResult18.abs();
    assertSame(bigDecimal, absResult19.abs().getAmount());
    assertSame(bigDecimal, absResult10.getAmount());
    assertSame(bigDecimal, absResult15.getAmount());
    Money zeroResult4 = absResult2.zero();
    Money absResult20 = zeroResult4.abs();
    Money absResult21 = absResult20.abs();
    Money absResult22 = absResult21.abs();
    assertSame(bigDecimal, absResult22.abs().getAmount());
    Money zeroResult5 = absResult7.zero();
    Money absResult23 = zeroResult5.abs();
    Money absResult24 = absResult23.abs();
    Money absResult25 = absResult24.abs();
    assertSame(bigDecimal, absResult25.abs().getAmount());
    assertSame(bigDecimal, absResult19.getAmount());
    Money zeroResult6 = zeroResult2.zero();
    Money absResult26 = zeroResult6.abs();
    Money absResult27 = absResult26.abs();
    Money absResult28 = absResult27.abs();
    assertSame(bigDecimal, absResult28.abs().getAmount());
    Money zeroResult7 = zeroResult3.zero();
    Money absResult29 = zeroResult7.abs();
    Money absResult30 = absResult29.abs();
    Money absResult31 = absResult30.abs();
    assertSame(bigDecimal, absResult31.abs().getAmount());
    assertSame(bigDecimal, absResult9.getAmount());
    assertSame(bigDecimal, absResult14.getAmount());
    assertSame(bigDecimal, absResult22.getAmount());
    Money zeroResult8 = absResult3.zero();
    Money absResult32 = zeroResult8.abs();
    Money absResult33 = absResult32.abs();
    assertSame(bigDecimal, absResult33.abs().getAmount());
    Money zeroResult9 = absResult8.zero();
    Money absResult34 = zeroResult9.abs();
    Money absResult35 = absResult34.abs();
    assertSame(bigDecimal, absResult35.abs().getAmount());
    assertSame(bigDecimal, absResult25.getAmount());
    Money zeroResult10 = absResult12.zero();
    Money absResult36 = zeroResult10.abs();
    Money absResult37 = absResult36.abs();
    assertSame(bigDecimal, absResult37.abs().getAmount());
    Money zeroResult11 = absResult16.zero();
    Money absResult38 = zeroResult11.abs();
    Money absResult39 = absResult38.abs();
    assertSame(bigDecimal, absResult39.abs().getAmount());
    assertSame(bigDecimal, absResult18.getAmount());
    assertSame(bigDecimal, absResult28.getAmount());
    Money zeroResult12 = zeroResult4.zero();
    Money absResult40 = zeroResult12.abs();
    Money absResult41 = absResult40.abs();
    assertSame(bigDecimal, absResult41.abs().getAmount());
    Money zeroResult13 = zeroResult5.zero();
    Money absResult42 = zeroResult13.abs();
    Money absResult43 = absResult42.abs();
    assertSame(bigDecimal, absResult43.abs().getAmount());
    assertSame(bigDecimal, absResult31.getAmount());
    Money zeroResult14 = zeroResult6.zero();
    Money absResult44 = zeroResult14.abs();
    Money absResult45 = absResult44.abs();
    assertSame(bigDecimal, absResult45.abs().getAmount());
    Money zeroResult15 = zeroResult7.zero();
    Money absResult46 = zeroResult15.abs();
    Money absResult47 = absResult46.abs();
    assertSame(bigDecimal, absResult47.abs().getAmount());
    assertSame(bigDecimal, absResult8.getAmount());
    assertSame(bigDecimal, absResult13.getAmount());
    assertSame(bigDecimal, absResult21.getAmount());
    assertSame(bigDecimal, absResult33.getAmount());
    Money zeroResult16 = absResult4.zero();
    Money absResult48 = zeroResult16.abs();
    assertSame(bigDecimal, absResult48.abs().getAmount());
    Money zeroResult17 = absResult9.zero();
    Money absResult49 = zeroResult17.abs();
    assertSame(bigDecimal, absResult49.abs().getAmount());
    assertSame(bigDecimal, absResult35.getAmount());
    Money zeroResult18 = absResult13.zero();
    Money absResult50 = zeroResult18.abs();
    assertSame(bigDecimal, absResult50.abs().getAmount());
    Money zeroResult19 = absResult17.zero();
    Money absResult51 = zeroResult19.abs();
    assertSame(bigDecimal, absResult51.abs().getAmount());
    assertSame(bigDecimal, absResult24.getAmount());
    assertSame(bigDecimal, absResult37.getAmount());
    Money zeroResult20 = absResult20.zero();
    Money absResult52 = zeroResult20.abs();
    assertSame(bigDecimal, absResult52.abs().getAmount());
    Money zeroResult21 = absResult23.zero();
    Money absResult53 = zeroResult21.abs();
    assertSame(bigDecimal, absResult53.abs().getAmount());
    assertSame(bigDecimal, absResult39.getAmount());
    Money zeroResult22 = absResult26.zero();
    Money absResult54 = zeroResult22.abs();
    assertSame(bigDecimal, absResult54.abs().getAmount());
    Money zeroResult23 = absResult29.zero();
    Money absResult55 = zeroResult23.abs();
    assertSame(bigDecimal, absResult55.abs().getAmount());
    assertSame(bigDecimal, absResult17.getAmount());
    assertSame(bigDecimal, absResult27.getAmount());
    assertSame(bigDecimal, absResult41.getAmount());
    Money zeroResult24 = zeroResult8.zero();
    Money absResult56 = zeroResult24.abs();
    assertSame(bigDecimal, absResult56.abs().getAmount());
    Money zeroResult25 = zeroResult9.zero();
    Money absResult57 = zeroResult25.abs();
    assertSame(bigDecimal, absResult57.abs().getAmount());
    assertSame(bigDecimal, absResult43.getAmount());
    Money zeroResult26 = zeroResult10.zero();
    Money absResult58 = zeroResult26.abs();
    assertSame(bigDecimal, absResult58.abs().getAmount());
    Money zeroResult27 = zeroResult11.zero();
    Money absResult59 = zeroResult27.abs();
    assertSame(bigDecimal, absResult59.abs().getAmount());
    assertSame(bigDecimal, absResult30.getAmount());
    assertSame(bigDecimal, absResult45.getAmount());
    Money zeroResult28 = zeroResult12.zero();
    Money absResult60 = zeroResult28.abs();
    assertSame(bigDecimal, absResult60.abs().getAmount());
    Money zeroResult29 = zeroResult13.zero();
    Money absResult61 = zeroResult29.abs();
    assertSame(bigDecimal, absResult61.abs().getAmount());
    assertSame(bigDecimal, absResult47.getAmount());
    Money zeroResult30 = zeroResult14.zero();
    Money absResult62 = zeroResult30.abs();
    assertSame(bigDecimal, absResult62.abs().getAmount());
    assertSame(bigDecimal, absResult7.getAmount());
    assertSame(bigDecimal, absResult12.getAmount());
    assertSame(bigDecimal, absResult20.getAmount());
    assertSame(bigDecimal, absResult32.getAmount());
    assertSame(bigDecimal, absResult48.getAmount());
    Money zeroResult31 = absResult5.zero();
    assertSame(bigDecimal, zeroResult31.abs().getAmount());
    Money zeroResult32 = absResult10.zero();
    assertSame(bigDecimal, zeroResult32.abs().getAmount());
    assertSame(bigDecimal, absResult49.getAmount());
    Money zeroResult33 = absResult14.zero();
    assertSame(bigDecimal, zeroResult33.abs().getAmount());
    Money zeroResult34 = absResult18.zero();
    assertSame(bigDecimal, zeroResult34.abs().getAmount());
    assertSame(bigDecimal, absResult34.getAmount());
    assertSame(bigDecimal, absResult50.getAmount());
    Money zeroResult35 = absResult21.zero();
    assertSame(bigDecimal, zeroResult35.abs().getAmount());
    Money zeroResult36 = absResult24.zero();
    assertSame(bigDecimal, zeroResult36.abs().getAmount());
    assertSame(bigDecimal, absResult51.getAmount());
    Money zeroResult37 = absResult27.zero();
    assertSame(bigDecimal, zeroResult37.abs().getAmount());
    Money zeroResult38 = absResult30.zero();
    assertSame(bigDecimal, zeroResult38.abs().getAmount());
    assertSame(bigDecimal, absResult23.getAmount());
    assertSame(bigDecimal, absResult36.getAmount());
    assertSame(bigDecimal, absResult52.getAmount());
    Money zeroResult39 = absResult32.zero();
    assertSame(bigDecimal, zeroResult39.abs().getAmount());
    Money zeroResult40 = absResult34.zero();
    assertSame(bigDecimal, zeroResult40.abs().getAmount());
    assertSame(bigDecimal, absResult53.getAmount());
    Money zeroResult41 = absResult36.zero();
    assertSame(bigDecimal, zeroResult41.abs().getAmount());
    Money zeroResult42 = absResult38.zero();
    assertSame(bigDecimal, zeroResult42.abs().getAmount());
    assertSame(bigDecimal, absResult38.getAmount());
    assertSame(bigDecimal, absResult54.getAmount());
    Money zeroResult43 = absResult40.zero();
    assertSame(bigDecimal, zeroResult43.abs().getAmount());
    Money zeroResult44 = absResult42.zero();
    assertSame(bigDecimal, zeroResult44.abs().getAmount());
    assertSame(bigDecimal, absResult55.getAmount());
    Money zeroResult45 = absResult44.zero();
    assertSame(bigDecimal, zeroResult45.abs().getAmount());
    assertSame(bigDecimal, absResult16.getAmount());
    assertSame(bigDecimal, absResult26.getAmount());
    assertSame(bigDecimal, absResult40.getAmount());
    assertSame(bigDecimal, absResult56.getAmount());
    Money zeroResult46 = zeroResult16.zero();
    assertSame(bigDecimal, zeroResult46.abs().getAmount());
    Money zeroResult47 = zeroResult17.zero();
    assertSame(bigDecimal, zeroResult47.abs().getAmount());
    assertSame(bigDecimal, absResult57.getAmount());
    Money zeroResult48 = zeroResult18.zero();
    assertSame(bigDecimal, zeroResult48.abs().getAmount());
    Money zeroResult49 = zeroResult19.zero();
    assertSame(bigDecimal, zeroResult49.abs().getAmount());
    assertSame(bigDecimal, absResult42.getAmount());
    assertSame(bigDecimal, absResult58.getAmount());
    Money zeroResult50 = zeroResult20.zero();
    assertSame(bigDecimal, zeroResult50.abs().getAmount());
    Money zeroResult51 = zeroResult21.zero();
    assertSame(bigDecimal, zeroResult51.abs().getAmount());
    assertSame(bigDecimal, absResult59.getAmount());
    Money zeroResult52 = zeroResult22.zero();
    assertSame(bigDecimal, zeroResult52.abs().getAmount());
    Money zeroResult53 = zeroResult23.zero();
    assertSame(bigDecimal, zeroResult53.abs().getAmount());
    assertSame(bigDecimal, absResult29.getAmount());
    assertSame(bigDecimal, absResult44.getAmount());
    assertSame(bigDecimal, absResult60.getAmount());
    Money zeroResult54 = zeroResult24.zero();
    assertSame(bigDecimal, zeroResult54.abs().getAmount());
    Money zeroResult55 = zeroResult25.zero();
    assertSame(bigDecimal, zeroResult55.abs().getAmount());
    assertSame(bigDecimal, absResult61.getAmount());
    Money zeroResult56 = zeroResult26.zero();
    assertSame(bigDecimal, zeroResult56.abs().getAmount());
    Money zeroResult57 = zeroResult27.zero();
    assertSame(bigDecimal, zeroResult57.abs().getAmount());
    assertSame(bigDecimal, absResult46.getAmount());
    assertSame(bigDecimal, absResult62.getAmount());
    Money zeroResult58 = zeroResult28.zero();
    assertSame(bigDecimal, zeroResult58.abs().getAmount());
    Money zeroResult59 = zeroResult29.zero();
    assertSame(bigDecimal, zeroResult59.abs().getAmount());
    Money zeroResult60 = zeroResult15.zero();
    assertSame(bigDecimal, zeroResult60.abs().getAmount());
    Money zeroResult61 = zeroResult30.zero();
    assertSame(bigDecimal, zeroResult61.abs().getAmount());
    assertSame(bigDecimal, zeroResult.getAmount());
    assertSame(bigDecimal, zeroResult2.getAmount());
    assertSame(bigDecimal, zeroResult4.getAmount());
    assertSame(bigDecimal, zeroResult8.getAmount());
    assertSame(bigDecimal, zeroResult16.getAmount());
    assertSame(bigDecimal, zeroResult31.getAmount());
    assertSame(bigDecimal, absResult6.zero().getAmount());
    assertSame(bigDecimal, absResult11.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.getAmount());
    assertSame(bigDecimal, absResult15.zero().getAmount());
    assertSame(bigDecimal, absResult19.zero().getAmount());
    assertSame(bigDecimal, zeroResult17.getAmount());
    assertSame(bigDecimal, zeroResult33.getAmount());
    assertSame(bigDecimal, absResult22.zero().getAmount());
    assertSame(bigDecimal, absResult25.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.getAmount());
    assertSame(bigDecimal, absResult28.zero().getAmount());
    assertSame(bigDecimal, absResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult9.getAmount());
    assertSame(bigDecimal, zeroResult18.getAmount());
    assertSame(bigDecimal, zeroResult35.getAmount());
    assertSame(bigDecimal, absResult33.zero().getAmount());
    assertSame(bigDecimal, absResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.getAmount());
    assertSame(bigDecimal, absResult37.zero().getAmount());
    assertSame(bigDecimal, absResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult19.getAmount());
    assertSame(bigDecimal, zeroResult37.getAmount());
    assertSame(bigDecimal, absResult41.zero().getAmount());
    assertSame(bigDecimal, absResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.getAmount());
    assertSame(bigDecimal, absResult45.zero().getAmount());
    assertSame(bigDecimal, absResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult5.getAmount());
    assertSame(bigDecimal, zeroResult10.getAmount());
    assertSame(bigDecimal, zeroResult20.getAmount());
    assertSame(bigDecimal, zeroResult39.getAmount());
    assertSame(bigDecimal, absResult48.zero().getAmount());
    assertSame(bigDecimal, absResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.getAmount());
    assertSame(bigDecimal, absResult50.zero().getAmount());
    assertSame(bigDecimal, absResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult21.getAmount());
    assertSame(bigDecimal, zeroResult41.getAmount());
    assertSame(bigDecimal, absResult52.zero().getAmount());
    assertSame(bigDecimal, absResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.getAmount());
    assertSame(bigDecimal, absResult54.zero().getAmount());
    assertSame(bigDecimal, absResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult11.getAmount());
    assertSame(bigDecimal, zeroResult22.getAmount());
    assertSame(bigDecimal, zeroResult43.getAmount());
    assertSame(bigDecimal, absResult56.zero().getAmount());
    assertSame(bigDecimal, absResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.getAmount());
    assertSame(bigDecimal, absResult58.zero().getAmount());
    assertSame(bigDecimal, absResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult23.getAmount());
    assertSame(bigDecimal, zeroResult45.getAmount());
    assertSame(bigDecimal, absResult60.zero().getAmount());
    assertSame(bigDecimal, absResult61.zero().getAmount());
    assertSame(bigDecimal, absResult46.zero().getAmount());
    assertSame(bigDecimal, absResult62.zero().getAmount());
    assertSame(bigDecimal, zeroResult3.getAmount());
    assertSame(bigDecimal, zeroResult6.getAmount());
    assertSame(bigDecimal, zeroResult12.getAmount());
    assertSame(bigDecimal, zeroResult24.getAmount());
    assertSame(bigDecimal, zeroResult46.getAmount());
    assertSame(bigDecimal, zeroResult31.zero().getAmount());
    assertSame(bigDecimal, zeroResult32.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.getAmount());
    assertSame(bigDecimal, zeroResult33.zero().getAmount());
    assertSame(bigDecimal, zeroResult34.zero().getAmount());
    assertSame(bigDecimal, zeroResult25.getAmount());
    assertSame(bigDecimal, zeroResult48.getAmount());
    assertSame(bigDecimal, zeroResult35.zero().getAmount());
    assertSame(bigDecimal, zeroResult36.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.getAmount());
    assertSame(bigDecimal, zeroResult37.zero().getAmount());
    assertSame(bigDecimal, zeroResult38.zero().getAmount());
    assertSame(bigDecimal, zeroResult13.getAmount());
    assertSame(bigDecimal, zeroResult26.getAmount());
    assertSame(bigDecimal, zeroResult50.getAmount());
    assertSame(bigDecimal, zeroResult39.zero().getAmount());
    assertSame(bigDecimal, zeroResult40.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.getAmount());
    assertSame(bigDecimal, zeroResult41.zero().getAmount());
    assertSame(bigDecimal, zeroResult42.zero().getAmount());
    assertSame(bigDecimal, zeroResult27.getAmount());
    assertSame(bigDecimal, zeroResult52.getAmount());
    assertSame(bigDecimal, zeroResult43.zero().getAmount());
    assertSame(bigDecimal, zeroResult44.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.getAmount());
    assertSame(bigDecimal, zeroResult45.zero().getAmount());
    assertSame(bigDecimal, zeroResult7.getAmount());
    assertSame(bigDecimal, zeroResult14.getAmount());
    assertSame(bigDecimal, zeroResult28.getAmount());
    assertSame(bigDecimal, zeroResult54.getAmount());
    assertSame(bigDecimal, zeroResult46.zero().getAmount());
    assertSame(bigDecimal, zeroResult47.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.getAmount());
    assertSame(bigDecimal, zeroResult48.zero().getAmount());
    assertSame(bigDecimal, zeroResult49.zero().getAmount());
    assertSame(bigDecimal, zeroResult29.getAmount());
    assertSame(bigDecimal, zeroResult56.getAmount());
    assertSame(bigDecimal, zeroResult50.zero().getAmount());
    assertSame(bigDecimal, zeroResult51.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.getAmount());
    assertSame(bigDecimal, zeroResult52.zero().getAmount());
    assertSame(bigDecimal, zeroResult53.zero().getAmount());
    assertSame(bigDecimal, zeroResult15.getAmount());
    assertSame(bigDecimal, zeroResult30.getAmount());
    assertSame(bigDecimal, zeroResult58.getAmount());
    assertSame(bigDecimal, zeroResult54.zero().getAmount());
    assertSame(bigDecimal, zeroResult55.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.getAmount());
    assertSame(bigDecimal, zeroResult56.zero().getAmount());
    assertSame(bigDecimal, zeroResult57.zero().getAmount());
    assertSame(bigDecimal, zeroResult60.getAmount());
    assertSame(bigDecimal, zeroResult61.getAmount());
    assertSame(bigDecimal, zeroResult58.zero().getAmount());
    assertSame(bigDecimal, zeroResult59.zero().getAmount());
    assertSame(bigDecimal, zeroResult60.zero().getAmount());
    assertSame(bigDecimal, zeroResult61.zero().getAmount());
  }

  /**
   * Test {@link SkuBundleItemImpl#getSalePrice()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getId()} return one.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuBundleItemImpl#getSalePrice()}
   */
  @Test
  public void testGetSalePrice_givenSkuGetIdReturnOne_thenReturnMoney() {
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
   * Test {@link SkuBundleItemImpl#getSalePrice()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getSalePrice()} return
   * {@link Money#Money()}.</li>
   *   <li>Then calls {@link Sku#getSalePrice()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuBundleItemImpl#getSalePrice()}
   */
  @Test
  public void testGetSalePrice_givenSkuGetSalePriceReturnMoney_thenCallsGetSalePrice() {
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
   * Test {@link SkuBundleItemImpl#getSalePrice()}.
   * <ul>
   *   <li>Then {@link SkuBundleItemImpl} (default constructor) Sku
   * {@link SkuImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuBundleItemImpl#getSalePrice()}
   */
  @Test
  public void testGetSalePrice_thenSkuBundleItemImplSkuSkuImpl() {
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
   * Test {@link SkuBundleItemImpl#getRetailPrice()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getId()} return one.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuBundleItemImpl#getRetailPrice()}
   */
  @Test
  public void testGetRetailPrice_givenSkuGetIdReturnOne_thenReturnMoney() {
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
   * Test {@link SkuBundleItemImpl#getRetailPrice()}.
   * <ul>
   *   <li>Then {@link SkuBundleItemImpl} (default constructor) Sku
   * {@link SkuImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuBundleItemImpl#getRetailPrice()}
   */
  @Test
  public void testGetRetailPrice_thenSkuBundleItemImplSkuSkuImpl() {
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
   * Test {@link SkuBundleItemImpl#getBundle()}.
   * <ul>
   *   <li>Then return {@link SkuBundleItemImpl} (default constructor)
   * {@link SkuBundleItemImpl#deproxiedBundle}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuBundleItemImpl#getBundle()}
   */
  @Test
  public void testGetBundle_thenReturnSkuBundleItemImplDeproxiedBundle() {
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
   * Test {@link SkuBundleItemImpl#getBundle()}.
   * <ul>
   *   <li>Then {@link SkuBundleItemImpl} (default constructor)
   * {@link SkuBundleItemImpl#bundle} {@link ProductBundleImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuBundleItemImpl#getBundle()}
   */
  @Test
  public void testGetBundle_thenSkuBundleItemImplBundleProductBundleImpl() {
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
   * Test {@link SkuBundleItemImpl#getSku()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getId()} return one.</li>
   *   <li>Then return {@link SkuBundleItemImpl} (default constructor)
   * {@link SkuBundleItemImpl#sku}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuBundleItemImpl#getSku()}
   */
  @Test
  public void testGetSku_givenSkuGetIdReturnOne_thenReturnSkuBundleItemImplSku() {
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
   * Test {@link SkuBundleItemImpl#getSku()}.
   * <ul>
   *   <li>Then {@link SkuBundleItemImpl} (default constructor)
   * {@link SkuBundleItemImpl#deproxiedSku} {@link SkuImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuBundleItemImpl#getSku()}
   */
  @Test
  public void testGetSku_thenSkuBundleItemImplDeproxiedSkuSkuImpl() {
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
   * Test {@link SkuBundleItemImpl#clearDynamicPrices()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getId()} return one.</li>
   *   <li>Then {@link SkuBundleItemImpl} (default constructor)
   * {@link SkuBundleItemImpl#sku}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuBundleItemImpl#clearDynamicPrices()}
   */
  @Test
  public void testClearDynamicPrices_givenSkuGetIdReturnOne_thenSkuBundleItemImplSku() {
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
   * Test {@link SkuBundleItemImpl#clearDynamicPrices()}.
   * <ul>
   *   <li>Then {@link SkuBundleItemImpl} (default constructor)
   * {@link SkuBundleItemImpl#deproxiedSku} hasSalePrice.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuBundleItemImpl#clearDynamicPrices()}
   */
  @Test
  public void testClearDynamicPrices_thenSkuBundleItemImplDeproxiedSkuHasSalePrice() {
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
    Sku sku2 = skuBundleItemImpl.deproxiedSku;
    assertTrue(sku2 instanceof SkuImpl);
    assertTrue(sku2.hasSalePrice());
    assertEquals(salePrice, sku2.getBaseSalePrice());
    assertEquals(salePrice, sku2.getSalePrice());
    DynamicSkuPrices priceData = sku2.getPriceData();
    Money price = priceData.getPrice();
    assertEquals(salePrice, price);
    assertSame(price, priceData.getSalePrice());
    Money expectedMargin = salePrice.ZERO;
    assertSame(expectedMargin, sku2.getMargin());
    assertSame(sku.salePrice, ((SkuImpl) sku2).salePrice);
  }

  /**
   * Test {@link SkuBundleItemImpl#clearDynamicPrices()}.
   * <ul>
   *   <li>Then {@link SkuBundleItemImpl} (default constructor)
   * {@link SkuBundleItemImpl#deproxiedSku} {@link SkuImpl#salePrice} is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuBundleItemImpl#clearDynamicPrices()}
   */
  @Test
  public void testClearDynamicPrices_thenSkuBundleItemImplDeproxiedSkuSalePriceIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    skuBundleItemImpl.setSku(new SkuImpl());

    // Act
    skuBundleItemImpl.clearDynamicPrices();

    // Assert
    Sku sku = skuBundleItemImpl.deproxiedSku;
    assertTrue(sku instanceof SkuImpl);
    assertNull(((SkuImpl) sku).salePrice);
    assertNull(sku.getBaseSalePrice());
    assertNull(sku.getSalePrice());
    DynamicSkuPrices priceData = sku.getPriceData();
    assertNull(priceData.getPrice());
    assertNull(priceData.getSalePrice());
    assertFalse(sku.hasSalePrice());
  }

  /**
   * Test
   * {@link SkuBundleItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
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
   * Test {@link SkuBundleItemImpl#equals(Object)}, and
   * {@link SkuBundleItemImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link SkuBundleItemImpl#equals(Object)}, and
   * {@link SkuBundleItemImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link SkuBundleItemImpl#equals(Object)}, and
   * {@link SkuBundleItemImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link SkuBundleItemImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link SkuBundleItemImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link SkuBundleItemImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test getters and setters.
   * <p>
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

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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Currency;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.junit.Test;

public class DefaultDynamicSkuPricingInvocationHandlerDiffblueTest {
  /**
   * Test
   * {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(BigDecimal)}.
   * <p>
   * Method under test:
   * {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(BigDecimal)}
   */
  @Test
  public void testNewDefaultDynamicSkuPricingInvocationHandler() {
    // Arrange and Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        new BigDecimal("2.3"));

    // Assert
    assertTrue(actualDefaultDynamicSkuPricingInvocationHandler.delegate instanceof SkuImpl);
    Money money = actualDefaultDynamicSkuPricingInvocationHandler.salePrice;
    Currency currency = money.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money zeroResult = money.zero();
    assertEquals(expectedAmount, zeroResult.getAmount());
    BigDecimal expectedAmount2 = new BigDecimal("2.30");
    assertEquals(expectedAmount2, money.getAmount());
    assertEquals(zeroResult.zero(), zeroResult.zero());
    assertEquals(zeroResult, zeroResult.abs());
    Money expectedAbsResult = actualDefaultDynamicSkuPricingInvocationHandler.salePrice;
    assertEquals(expectedAbsResult, money.abs());
    assertSame(currency, zeroResult.getCurrency());
    Sku expectedUnwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertSame(expectedUnwrapResult, actualDefaultDynamicSkuPricingInvocationHandler.unwrap());
  }

  /**
   * Test
   * {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku, BigDecimal)}.
   * <p>
   * Method under test:
   * {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku, BigDecimal)}
   */
  @Test
  public void testNewDefaultDynamicSkuPricingInvocationHandler2() {
    // Arrange
    SkuImpl sku = new SkuImpl();

    // Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        sku, new BigDecimal("2.3"));

    // Assert
    Sku unwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.unwrap();
    assertTrue(unwrapResult instanceof SkuImpl);
    Money money = actualDefaultDynamicSkuPricingInvocationHandler.salePrice;
    Money zeroResult = money.zero();
    Money zeroResult2 = zeroResult.zero();
    Money absResult = money.abs();
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    Money absResult6 = absResult5.abs();
    assertEquals(zeroResult2, absResult6.zero());
    assertEquals(zeroResult2, absResult5.zero());
    assertEquals(zeroResult2, absResult4.zero());
    assertEquals(zeroResult2, absResult3.zero());
    assertEquals(zeroResult2, absResult2.zero());
    assertEquals(zeroResult2, absResult.zero());
    assertEquals(zeroResult2, zeroResult2);
    assertEquals(zeroResult2, unwrapResult.getMargin());
    assertEquals(zeroResult, zeroResult.abs());
    Money expectedAbsResult = actualDefaultDynamicSkuPricingInvocationHandler.salePrice;
    assertEquals(expectedAbsResult, absResult6.abs());
  }

  /**
   * Test
   * {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku, Money)}.
   * <p>
   * Method under test:
   * {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku, Money)}
   */
  @Test
  public void testNewDefaultDynamicSkuPricingInvocationHandler3() {
    // Arrange
    SkuImpl sku = new SkuImpl();

    // Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        sku, new Money());

    // Assert
    Sku unwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.unwrap();
    assertTrue(unwrapResult instanceof SkuImpl);
    Money money = actualDefaultDynamicSkuPricingInvocationHandler.salePrice;
    Money money2 = actualDefaultDynamicSkuPricingInvocationHandler.retailPrice;
    assertEquals(money, money2.abs());
    Money money3 = actualDefaultDynamicSkuPricingInvocationHandler.salePrice;
    assertEquals(money, money3.abs());
    assertEquals(money, money2.zero());
    assertEquals(money, money3.zero());
    assertEquals(money, unwrapResult.getMargin());
  }

  /**
   * Test
   * {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku)}.
   * <ul>
   *   <li>Given {@link Date}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku)}
   */
  @Test
  public void testNewDefaultDynamicSkuPricingInvocationHandler_givenDate() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    sku.setActiveStartDate(mock(Date.class));

    // Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        sku);

    // Assert
    Sku unwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.unwrap();
    assertTrue(unwrapResult instanceof SkuImpl);
    Sku sku2 = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertTrue(sku2 instanceof SkuImpl);
    Money margin = unwrapResult.getMargin();
    Currency currency = margin.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertNull(unwrapResult.getPriceData().getPrice());
    assertNull(sku2.getPriceData().getPrice());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    assertEquals(expectedAmount, margin.getAmount());
    assertEquals(margin, margin.abs());
    assertEquals(margin, margin.zero());
  }

  /**
   * Test
   * {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku, Money)}.
   * <ul>
   *   <li>Given {@link Date}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku, Money)}
   */
  @Test
  public void testNewDefaultDynamicSkuPricingInvocationHandler_givenDate2() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    sku.setActiveStartDate(mock(Date.class));

    // Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        sku, new Money());

    // Assert
    Sku unwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.unwrap();
    assertTrue(unwrapResult instanceof SkuImpl);
    assertTrue(actualDefaultDynamicSkuPricingInvocationHandler.delegate instanceof SkuImpl);
    Money money = actualDefaultDynamicSkuPricingInvocationHandler.salePrice;
    Money money2 = actualDefaultDynamicSkuPricingInvocationHandler.retailPrice;
    assertEquals(money, money2.abs());
    Money money3 = actualDefaultDynamicSkuPricingInvocationHandler.salePrice;
    assertEquals(money, money3.abs());
    assertEquals(money, money2.zero());
    assertEquals(money, money3.zero());
    assertEquals(money, unwrapResult.getMargin());
  }

  /**
   * Test
   * {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku, Money)}.
   * <ul>
   *   <li>Then return {@link DefaultDynamicSkuPricingInvocationHandler#retailPrice}
   * is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku, Money)}
   */
  @Test
  public void testNewDefaultDynamicSkuPricingInvocationHandler_thenReturnRetailPriceIsNull() {
    // Arrange and Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        new SkuImpl(), (Money) null);

    // Assert
    assertTrue(actualDefaultDynamicSkuPricingInvocationHandler.delegate instanceof SkuImpl);
    assertNull(actualDefaultDynamicSkuPricingInvocationHandler.retailPrice);
    assertNull(actualDefaultDynamicSkuPricingInvocationHandler.salePrice);
    Sku expectedUnwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertSame(expectedUnwrapResult, actualDefaultDynamicSkuPricingInvocationHandler.unwrap());
  }

  /**
   * Test
   * {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(BigDecimal)}.
   * <ul>
   *   <li>Then return {@link DefaultDynamicSkuPricingInvocationHandler#salePrice}
   * is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(BigDecimal)}
   */
  @Test
  public void testNewDefaultDynamicSkuPricingInvocationHandler_thenReturnSalePriceIsNull() {
    // Arrange and Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        (BigDecimal) null);

    // Assert
    assertTrue(actualDefaultDynamicSkuPricingInvocationHandler.delegate instanceof SkuImpl);
    assertNull(actualDefaultDynamicSkuPricingInvocationHandler.salePrice);
    Sku expectedUnwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertSame(expectedUnwrapResult, actualDefaultDynamicSkuPricingInvocationHandler.unwrap());
  }

  /**
   * Test
   * {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku, BigDecimal)}.
   * <ul>
   *   <li>Then return {@link DefaultDynamicSkuPricingInvocationHandler#salePrice}
   * is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku, BigDecimal)}
   */
  @Test
  public void testNewDefaultDynamicSkuPricingInvocationHandler_thenReturnSalePriceIsNull2() {
    // Arrange and Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        new SkuImpl(), (BigDecimal) null);

    // Assert
    assertTrue(actualDefaultDynamicSkuPricingInvocationHandler.delegate instanceof SkuImpl);
    assertNull(actualDefaultDynamicSkuPricingInvocationHandler.salePrice);
    Sku expectedUnwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertSame(expectedUnwrapResult, actualDefaultDynamicSkuPricingInvocationHandler.unwrap());
  }

  /**
   * Test
   * {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku)}.
   * <ul>
   *   <li>Then return unwrap hasRetailPrice.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku)}
   */
  @Test
  public void testNewDefaultDynamicSkuPricingInvocationHandler_thenReturnUnwrapHasRetailPrice() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    Money retailPrice = new Money();
    sku.setRetailPrice(retailPrice);

    // Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        sku);

    // Assert
    Sku unwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.unwrap();
    assertTrue(unwrapResult instanceof SkuImpl);
    Sku sku2 = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertTrue(sku2 instanceof SkuImpl);
    assertTrue(unwrapResult.hasRetailPrice());
    assertTrue(sku2.hasRetailPrice());
    assertEquals(retailPrice, unwrapResult.getBaseRetailPrice());
    assertEquals(retailPrice, sku2.getBaseRetailPrice());
    assertEquals(retailPrice, unwrapResult.getListPrice());
    assertEquals(retailPrice, sku2.getListPrice());
    assertEquals(retailPrice, unwrapResult.getPrice());
    assertEquals(retailPrice, sku2.getPrice());
    assertEquals(retailPrice, unwrapResult.getRetailPrice());
    assertEquals(retailPrice, sku2.getRetailPrice());
    assertEquals(retailPrice, actualDefaultDynamicSkuPricingInvocationHandler.retailPrice);
    DynamicSkuPrices priceData = unwrapResult.getPriceData();
    Money expectedRetailPrice = priceData.getPrice();
    assertSame(expectedRetailPrice, priceData.getRetailPrice());
    DynamicSkuPrices priceData2 = sku2.getPriceData();
    Money expectedRetailPrice2 = priceData2.getPrice();
    assertSame(expectedRetailPrice2, priceData2.getRetailPrice());
  }

  /**
   * Test
   * {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku, BigDecimal)}.
   * <ul>
   *   <li>Then return unwrap hasRetailPrice.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku, BigDecimal)}
   */
  @Test
  public void testNewDefaultDynamicSkuPricingInvocationHandler_thenReturnUnwrapHasRetailPrice2() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    Money retailPrice = new Money();
    sku.setRetailPrice(retailPrice);

    // Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        sku, new BigDecimal("2.3"));

    // Assert
    Sku unwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.unwrap();
    assertTrue(unwrapResult instanceof SkuImpl);
    Sku sku2 = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertTrue(sku2 instanceof SkuImpl);
    assertTrue(unwrapResult.hasRetailPrice());
    assertTrue(sku2.hasRetailPrice());
    assertEquals(retailPrice, unwrapResult.getBaseRetailPrice());
    assertEquals(retailPrice, sku2.getBaseRetailPrice());
    assertEquals(retailPrice, unwrapResult.getListPrice());
    assertEquals(retailPrice, sku2.getListPrice());
    assertEquals(retailPrice, unwrapResult.getPrice());
    assertEquals(retailPrice, sku2.getPrice());
    assertEquals(retailPrice, unwrapResult.getRetailPrice());
    assertEquals(retailPrice, sku2.getRetailPrice());
    assertEquals(retailPrice, actualDefaultDynamicSkuPricingInvocationHandler.retailPrice);
    DynamicSkuPrices priceData = unwrapResult.getPriceData();
    Money expectedRetailPrice = priceData.getPrice();
    assertSame(expectedRetailPrice, priceData.getRetailPrice());
    DynamicSkuPrices priceData2 = sku2.getPriceData();
    Money expectedRetailPrice2 = priceData2.getPrice();
    assertSame(expectedRetailPrice2, priceData2.getRetailPrice());
  }

  /**
   * Test
   * {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku, Money)}.
   * <ul>
   *   <li>Then return unwrap hasRetailPrice.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku, Money)}
   */
  @Test
  public void testNewDefaultDynamicSkuPricingInvocationHandler_thenReturnUnwrapHasRetailPrice3() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    Money retailPrice = new Money();
    sku.setRetailPrice(retailPrice);

    // Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        sku, new Money());

    // Assert
    Sku unwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.unwrap();
    assertTrue(unwrapResult instanceof SkuImpl);
    Sku sku2 = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertTrue(sku2 instanceof SkuImpl);
    assertTrue(unwrapResult.hasRetailPrice());
    assertTrue(sku2.hasRetailPrice());
    assertEquals(retailPrice, unwrapResult.getBaseRetailPrice());
    assertEquals(retailPrice, sku2.getBaseRetailPrice());
    assertEquals(retailPrice, unwrapResult.getListPrice());
    assertEquals(retailPrice, sku2.getListPrice());
    assertEquals(retailPrice, unwrapResult.getPrice());
    assertEquals(retailPrice, sku2.getPrice());
    assertEquals(retailPrice, unwrapResult.getRetailPrice());
    assertEquals(retailPrice, sku2.getRetailPrice());
  }

  /**
   * Test
   * {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku)}.
   * <ul>
   *   <li>Then return unwrap hasSalePrice.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku)}
   */
  @Test
  public void testNewDefaultDynamicSkuPricingInvocationHandler_thenReturnUnwrapHasSalePrice() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    Money salePrice = new Money();
    sku.setSalePrice(salePrice);

    // Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        sku);

    // Assert
    Sku unwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.unwrap();
    assertTrue(unwrapResult instanceof SkuImpl);
    Sku sku2 = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertTrue(sku2 instanceof SkuImpl);
    assertTrue(unwrapResult.hasSalePrice());
    assertTrue(sku2.hasSalePrice());
    Money margin = unwrapResult.getMargin();
    Money absResult = margin.abs();
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    assertEquals(salePrice, absResult4.abs());
    Money zeroResult = margin.zero();
    Money absResult5 = zeroResult.abs();
    Money absResult6 = absResult5.abs();
    Money absResult7 = absResult6.abs();
    assertEquals(salePrice, absResult7.abs());
    DynamicSkuPrices priceData = unwrapResult.getPriceData();
    Money price = priceData.getPrice();
    Money absResult8 = price.abs();
    Money absResult9 = absResult8.abs();
    Money absResult10 = absResult9.abs();
    assertEquals(salePrice, absResult10.abs());
    Money zeroResult2 = absResult.zero();
    Money absResult11 = zeroResult2.abs();
    Money absResult12 = absResult11.abs();
    assertEquals(salePrice, absResult12.abs());
    Money zeroResult3 = zeroResult.zero();
    Money absResult13 = zeroResult3.abs();
    Money absResult14 = absResult13.abs();
    assertEquals(salePrice, absResult14.abs());
    Money zeroResult4 = price.zero();
    Money absResult15 = zeroResult4.abs();
    Money absResult16 = absResult15.abs();
    assertEquals(salePrice, absResult16.abs());
    Money zeroResult5 = absResult2.zero();
    Money absResult17 = zeroResult5.abs();
    assertEquals(salePrice, absResult17.abs());
    Money zeroResult6 = absResult5.zero();
    Money absResult18 = zeroResult6.abs();
    assertEquals(salePrice, absResult18.abs());
    Money zeroResult7 = absResult8.zero();
    Money absResult19 = zeroResult7.abs();
    assertEquals(salePrice, absResult19.abs());
    Money zeroResult8 = zeroResult2.zero();
    Money absResult20 = zeroResult8.abs();
    assertEquals(salePrice, absResult20.abs());
    Money zeroResult9 = zeroResult3.zero();
    Money absResult21 = zeroResult9.abs();
    assertEquals(salePrice, absResult21.abs());
    Money zeroResult10 = zeroResult4.zero();
    Money absResult22 = zeroResult10.abs();
    assertEquals(salePrice, absResult22.abs());
    Money zeroResult11 = absResult3.zero();
    assertEquals(salePrice, zeroResult11.abs());
    Money zeroResult12 = absResult6.zero();
    assertEquals(salePrice, zeroResult12.abs());
    Money zeroResult13 = absResult9.zero();
    assertEquals(salePrice, zeroResult13.abs());
    Money zeroResult14 = absResult11.zero();
    assertEquals(salePrice, zeroResult14.abs());
    Money zeroResult15 = absResult13.zero();
    assertEquals(salePrice, zeroResult15.abs());
    Money zeroResult16 = absResult15.zero();
    assertEquals(salePrice, zeroResult16.abs());
    Money zeroResult17 = zeroResult5.zero();
    assertEquals(salePrice, zeroResult17.abs());
    Money zeroResult18 = zeroResult6.zero();
    assertEquals(salePrice, zeroResult18.abs());
    Money zeroResult19 = zeroResult7.zero();
    assertEquals(salePrice, zeroResult19.abs());
    Money zeroResult20 = zeroResult8.zero();
    assertEquals(salePrice, zeroResult20.abs());
    Money zeroResult21 = zeroResult9.zero();
    assertEquals(salePrice, zeroResult21.abs());
    Money zeroResult22 = zeroResult10.zero();
    assertEquals(salePrice, zeroResult22.abs());
    assertEquals(salePrice, absResult4.zero());
    assertEquals(salePrice, absResult7.zero());
    assertEquals(salePrice, absResult10.zero());
    assertEquals(salePrice, absResult12.zero());
    assertEquals(salePrice, absResult14.zero());
    assertEquals(salePrice, absResult16.zero());
    assertEquals(salePrice, absResult17.zero());
    assertEquals(salePrice, absResult18.zero());
    assertEquals(salePrice, absResult19.zero());
    assertEquals(salePrice, absResult20.zero());
    assertEquals(salePrice, absResult21.zero());
    assertEquals(salePrice, absResult22.zero());
    assertEquals(salePrice, zeroResult11.zero());
    assertEquals(salePrice, zeroResult12.zero());
    assertEquals(salePrice, zeroResult13.zero());
    assertEquals(salePrice, zeroResult14.zero());
    assertEquals(salePrice, zeroResult15.zero());
    assertEquals(salePrice, zeroResult16.zero());
    assertEquals(salePrice, zeroResult17.zero());
    assertEquals(salePrice, zeroResult18.zero());
    assertEquals(salePrice, zeroResult19.zero());
    assertEquals(salePrice, zeroResult20.zero());
    assertEquals(salePrice, zeroResult21.zero());
    assertEquals(salePrice, zeroResult22.zero());
    assertEquals(salePrice, unwrapResult.getBaseSalePrice());
    assertEquals(salePrice, sku2.getBaseSalePrice());
    assertEquals(salePrice, unwrapResult.getSalePrice());
    assertEquals(salePrice, sku2.getSalePrice());
    assertEquals(salePrice, actualDefaultDynamicSkuPricingInvocationHandler.salePrice);
    assertSame(price, priceData.getSalePrice());
    DynamicSkuPrices priceData2 = sku2.getPriceData();
    Money expectedSalePrice = priceData2.getPrice();
    assertSame(expectedSalePrice, priceData2.getSalePrice());
  }

  /**
   * Test
   * {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku, BigDecimal)}.
   * <ul>
   *   <li>Then return unwrap hasSalePrice.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku, BigDecimal)}
   */
  @Test
  public void testNewDefaultDynamicSkuPricingInvocationHandler_thenReturnUnwrapHasSalePrice2() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    Money salePrice = new Money();
    sku.setSalePrice(salePrice);

    // Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        sku, new BigDecimal("2.3"));

    // Assert
    Sku unwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.unwrap();
    assertTrue(unwrapResult instanceof SkuImpl);
    Sku sku2 = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertTrue(sku2 instanceof SkuImpl);
    assertTrue(unwrapResult.hasSalePrice());
    assertTrue(sku2.hasSalePrice());
    Money money = actualDefaultDynamicSkuPricingInvocationHandler.salePrice;
    Money zeroResult = money.zero();
    Money absResult = zeroResult.abs();
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    assertEquals(salePrice, absResult4.abs());
    Money margin = unwrapResult.getMargin();
    Money absResult5 = margin.abs();
    Money absResult6 = absResult5.abs();
    Money absResult7 = absResult6.abs();
    Money absResult8 = absResult7.abs();
    assertEquals(salePrice, absResult8.abs());
    Money absResult9 = money.abs();
    Money zeroResult2 = absResult9.zero();
    Money absResult10 = zeroResult2.abs();
    Money absResult11 = absResult10.abs();
    Money absResult12 = absResult11.abs();
    assertEquals(salePrice, absResult12.abs());
    Money zeroResult3 = zeroResult.zero();
    Money absResult13 = zeroResult3.abs();
    Money absResult14 = absResult13.abs();
    Money absResult15 = absResult14.abs();
    assertEquals(salePrice, absResult15.abs());
    Money zeroResult4 = margin.zero();
    Money absResult16 = zeroResult4.abs();
    Money absResult17 = absResult16.abs();
    Money absResult18 = absResult17.abs();
    assertEquals(salePrice, absResult18.abs());
    DynamicSkuPrices priceData = unwrapResult.getPriceData();
    Money price = priceData.getPrice();
    Money absResult19 = price.abs();
    Money absResult20 = absResult19.abs();
    Money absResult21 = absResult20.abs();
    assertEquals(salePrice, absResult21.abs());
    Money absResult22 = absResult9.abs();
    Money zeroResult5 = absResult22.zero();
    Money absResult23 = zeroResult5.abs();
    Money absResult24 = absResult23.abs();
    assertEquals(salePrice, absResult24.abs());
    Money zeroResult6 = absResult.zero();
    Money absResult25 = zeroResult6.abs();
    Money absResult26 = absResult25.abs();
    assertEquals(salePrice, absResult26.abs());
    Money zeroResult7 = absResult5.zero();
    Money absResult27 = zeroResult7.abs();
    Money absResult28 = absResult27.abs();
    assertEquals(salePrice, absResult28.abs());
    Money zeroResult8 = zeroResult2.zero();
    Money absResult29 = zeroResult8.abs();
    Money absResult30 = absResult29.abs();
    assertEquals(salePrice, absResult30.abs());
    Money zeroResult9 = zeroResult3.zero();
    Money absResult31 = zeroResult9.abs();
    Money absResult32 = absResult31.abs();
    assertEquals(salePrice, absResult32.abs());
    Money zeroResult10 = zeroResult4.zero();
    Money absResult33 = zeroResult10.abs();
    Money absResult34 = absResult33.abs();
    assertEquals(salePrice, absResult34.abs());
    Money zeroResult11 = price.zero();
    Money absResult35 = zeroResult11.abs();
    Money absResult36 = absResult35.abs();
    assertEquals(salePrice, absResult36.abs());
    Money absResult37 = absResult22.abs();
    Money zeroResult12 = absResult37.zero();
    Money absResult38 = zeroResult12.abs();
    assertEquals(salePrice, absResult38.abs());
    Money zeroResult13 = absResult2.zero();
    Money absResult39 = zeroResult13.abs();
    assertEquals(salePrice, absResult39.abs());
    Money zeroResult14 = absResult6.zero();
    Money absResult40 = zeroResult14.abs();
    assertEquals(salePrice, absResult40.abs());
    Money zeroResult15 = absResult10.zero();
    Money absResult41 = zeroResult15.abs();
    assertEquals(salePrice, absResult41.abs());
    Money zeroResult16 = absResult13.zero();
    Money absResult42 = zeroResult16.abs();
    assertEquals(salePrice, absResult42.abs());
    Money zeroResult17 = absResult16.zero();
    Money absResult43 = zeroResult17.abs();
    assertEquals(salePrice, absResult43.abs());
    Money zeroResult18 = absResult19.zero();
    Money absResult44 = zeroResult18.abs();
    assertEquals(salePrice, absResult44.abs());
    Money zeroResult19 = zeroResult5.zero();
    Money absResult45 = zeroResult19.abs();
    assertEquals(salePrice, absResult45.abs());
    Money zeroResult20 = zeroResult6.zero();
    Money absResult46 = zeroResult20.abs();
    assertEquals(salePrice, absResult46.abs());
    Money zeroResult21 = zeroResult7.zero();
    Money absResult47 = zeroResult21.abs();
    assertEquals(salePrice, absResult47.abs());
    Money zeroResult22 = zeroResult8.zero();
    Money absResult48 = zeroResult22.abs();
    assertEquals(salePrice, absResult48.abs());
    Money zeroResult23 = zeroResult9.zero();
    Money absResult49 = zeroResult23.abs();
    assertEquals(salePrice, absResult49.abs());
    Money zeroResult24 = zeroResult10.zero();
    Money absResult50 = zeroResult24.abs();
    assertEquals(salePrice, absResult50.abs());
    Money zeroResult25 = zeroResult11.zero();
    Money absResult51 = zeroResult25.abs();
    assertEquals(salePrice, absResult51.abs());
    Money absResult52 = absResult37.abs();
    Money zeroResult26 = absResult52.zero();
    assertEquals(salePrice, zeroResult26.abs());
    Money zeroResult27 = absResult3.zero();
    assertEquals(salePrice, zeroResult27.abs());
    Money zeroResult28 = absResult7.zero();
    assertEquals(salePrice, zeroResult28.abs());
    Money zeroResult29 = absResult11.zero();
    assertEquals(salePrice, zeroResult29.abs());
    Money zeroResult30 = absResult14.zero();
    assertEquals(salePrice, zeroResult30.abs());
    Money zeroResult31 = absResult17.zero();
    assertEquals(salePrice, zeroResult31.abs());
    Money zeroResult32 = absResult20.zero();
    assertEquals(salePrice, zeroResult32.abs());
    Money zeroResult33 = absResult23.zero();
    assertEquals(salePrice, zeroResult33.abs());
    Money zeroResult34 = absResult25.zero();
    assertEquals(salePrice, zeroResult34.abs());
    Money zeroResult35 = absResult27.zero();
    assertEquals(salePrice, zeroResult35.abs());
    Money zeroResult36 = absResult29.zero();
    assertEquals(salePrice, zeroResult36.abs());
    Money zeroResult37 = absResult31.zero();
    assertEquals(salePrice, zeroResult37.abs());
    Money zeroResult38 = absResult33.zero();
    assertEquals(salePrice, zeroResult38.abs());
    Money zeroResult39 = absResult35.zero();
    assertEquals(salePrice, zeroResult39.abs());
    Money zeroResult40 = zeroResult12.zero();
    assertEquals(salePrice, zeroResult40.abs());
    Money zeroResult41 = zeroResult13.zero();
    assertEquals(salePrice, zeroResult41.abs());
    Money zeroResult42 = zeroResult14.zero();
    assertEquals(salePrice, zeroResult42.abs());
    Money zeroResult43 = zeroResult15.zero();
    assertEquals(salePrice, zeroResult43.abs());
    Money zeroResult44 = zeroResult16.zero();
    assertEquals(salePrice, zeroResult44.abs());
    Money zeroResult45 = zeroResult17.zero();
    assertEquals(salePrice, zeroResult45.abs());
    Money zeroResult46 = zeroResult18.zero();
    assertEquals(salePrice, zeroResult46.abs());
    Money zeroResult47 = zeroResult19.zero();
    assertEquals(salePrice, zeroResult47.abs());
    Money zeroResult48 = zeroResult20.zero();
    assertEquals(salePrice, zeroResult48.abs());
    Money zeroResult49 = zeroResult21.zero();
    assertEquals(salePrice, zeroResult49.abs());
    Money zeroResult50 = zeroResult22.zero();
    assertEquals(salePrice, zeroResult50.abs());
    Money zeroResult51 = zeroResult23.zero();
    assertEquals(salePrice, zeroResult51.abs());
    Money zeroResult52 = zeroResult24.zero();
    assertEquals(salePrice, zeroResult52.abs());
    Money zeroResult53 = zeroResult25.zero();
    assertEquals(salePrice, zeroResult53.abs());
    assertEquals(salePrice, absResult52.abs().zero());
    assertEquals(salePrice, absResult4.zero());
    assertEquals(salePrice, absResult8.zero());
    assertEquals(salePrice, absResult12.zero());
    assertEquals(salePrice, absResult15.zero());
    assertEquals(salePrice, absResult18.zero());
    assertEquals(salePrice, absResult21.zero());
    assertEquals(salePrice, absResult24.zero());
    assertEquals(salePrice, absResult26.zero());
    assertEquals(salePrice, absResult28.zero());
    assertEquals(salePrice, absResult30.zero());
    assertEquals(salePrice, absResult32.zero());
    assertEquals(salePrice, absResult34.zero());
    assertEquals(salePrice, absResult36.zero());
    assertEquals(salePrice, absResult38.zero());
    assertEquals(salePrice, absResult39.zero());
    assertEquals(salePrice, absResult40.zero());
    assertEquals(salePrice, absResult41.zero());
    assertEquals(salePrice, absResult42.zero());
    assertEquals(salePrice, absResult43.zero());
    assertEquals(salePrice, absResult44.zero());
    assertEquals(salePrice, absResult45.zero());
    assertEquals(salePrice, absResult46.zero());
    assertEquals(salePrice, absResult47.zero());
    assertEquals(salePrice, absResult48.zero());
    assertEquals(salePrice, absResult49.zero());
    assertEquals(salePrice, absResult50.zero());
    assertEquals(salePrice, absResult51.zero());
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
    assertEquals(salePrice, zeroResult36.zero());
    assertEquals(salePrice, zeroResult37.zero());
    assertEquals(salePrice, zeroResult38.zero());
    assertEquals(salePrice, zeroResult39.zero());
    assertEquals(salePrice, zeroResult40.zero());
    assertEquals(salePrice, zeroResult41.zero());
    assertEquals(salePrice, zeroResult42.zero());
    assertEquals(salePrice, zeroResult43.zero());
    assertEquals(salePrice, zeroResult44.zero());
    assertEquals(salePrice, zeroResult45.zero());
    assertEquals(salePrice, zeroResult46.zero());
    assertEquals(salePrice, zeroResult47.zero());
    assertEquals(salePrice, zeroResult48.zero());
    assertEquals(salePrice, zeroResult49.zero());
    assertEquals(salePrice, zeroResult50.zero());
    assertEquals(salePrice, zeroResult51.zero());
    assertEquals(salePrice, zeroResult52.zero());
    assertEquals(salePrice, zeroResult53.zero());
    assertEquals(salePrice, unwrapResult.getBaseSalePrice());
    assertEquals(salePrice, sku2.getBaseSalePrice());
    assertEquals(salePrice, unwrapResult.getSalePrice());
    assertEquals(salePrice, sku2.getSalePrice());
    assertSame(price, priceData.getSalePrice());
    DynamicSkuPrices priceData2 = sku2.getPriceData();
    Money expectedSalePrice = priceData2.getPrice();
    assertSame(expectedSalePrice, priceData2.getSalePrice());
  }

  /**
   * Test
   * {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku, Money)}.
   * <ul>
   *   <li>Then return unwrap hasSalePrice.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku, Money)}
   */
  @Test
  public void testNewDefaultDynamicSkuPricingInvocationHandler_thenReturnUnwrapHasSalePrice3() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    Money salePrice = new Money();
    sku.setSalePrice(salePrice);

    // Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        sku, new Money());

    // Assert
    Sku unwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.unwrap();
    assertTrue(unwrapResult instanceof SkuImpl);
    Sku sku2 = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertTrue(sku2 instanceof SkuImpl);
    assertTrue(unwrapResult.hasSalePrice());
    assertTrue(sku2.hasSalePrice());
    assertEquals(salePrice, unwrapResult.getBaseSalePrice());
    assertEquals(salePrice, sku2.getBaseSalePrice());
    assertEquals(salePrice, unwrapResult.getSalePrice());
    assertEquals(salePrice, sku2.getSalePrice());
  }

  /**
   * Test
   * {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku)}.
   * <ul>
   *   <li>When {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultDynamicSkuPricingInvocationHandler#DefaultDynamicSkuPricingInvocationHandler(Sku)}
   */
  @Test
  public void testNewDefaultDynamicSkuPricingInvocationHandler_whenSkuImpl() {
    // Arrange and Act
    DefaultDynamicSkuPricingInvocationHandler actualDefaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        new SkuImpl());

    // Assert
    Sku unwrapResult = actualDefaultDynamicSkuPricingInvocationHandler.unwrap();
    assertTrue(unwrapResult instanceof SkuImpl);
    Sku sku = actualDefaultDynamicSkuPricingInvocationHandler.delegate;
    assertTrue(sku instanceof SkuImpl);
    Money margin = unwrapResult.getMargin();
    Currency currency = margin.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertNull(unwrapResult.getPriceData().getPrice());
    assertNull(sku.getPriceData().getPrice());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    assertEquals(expectedAmount, margin.getAmount());
    assertEquals(margin, margin.abs());
    assertEquals(margin, margin.zero());
  }

  /**
   * Test {@link DefaultDynamicSkuPricingInvocationHandler#unwrap()}.
   * <p>
   * Method under test: {@link DefaultDynamicSkuPricingInvocationHandler#unwrap()}
   */
  @Test
  public void testUnwrap() {
    // Arrange
    DefaultDynamicSkuPricingInvocationHandler defaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        new BigDecimal("2.3"));

    // Act and Assert
    assertSame(defaultDynamicSkuPricingInvocationHandler.delegate, defaultDynamicSkuPricingInvocationHandler.unwrap());
  }

  /**
   * Test {@link DefaultDynamicSkuPricingInvocationHandler#reset()}.
   * <p>
   * Method under test: {@link DefaultDynamicSkuPricingInvocationHandler#reset()}
   */
  @Test
  public void testReset() {
    // Arrange
    DefaultDynamicSkuPricingInvocationHandler defaultDynamicSkuPricingInvocationHandler = new DefaultDynamicSkuPricingInvocationHandler(
        new BigDecimal("2.3"));

    // Act
    defaultDynamicSkuPricingInvocationHandler.reset();

    // Assert
    assertNull(defaultDynamicSkuPricingInvocationHandler.salePrice);
    assertNull(defaultDynamicSkuPricingInvocationHandler.unwrap());
    assertNull(defaultDynamicSkuPricingInvocationHandler.delegate);
  }
}

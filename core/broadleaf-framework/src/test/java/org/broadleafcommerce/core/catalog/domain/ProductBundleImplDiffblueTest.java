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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.service.type.ProductBundlePricingModelType;
import org.broadleafcommerce.core.search.domain.FieldEntity;
import org.junit.Test;
import org.mockito.Mockito;

public class ProductBundleImplDiffblueTest {
  /**
   * Test {@link ProductBundleImpl#isOnSale()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor) PricingModel is
   * {@link ProductBundlePricingModelType#ITEM_SUM}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale_givenProductBundleImplPricingModelIsItem_sum_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setPricingModel(ProductBundlePricingModelType.ITEM_SUM);

    // Act and Assert
    assertFalse(productBundleImpl.isOnSale());
  }

  /**
   * Test {@link ProductBundleImpl#isOnSale()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale_givenProductBundleImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ProductBundleImpl()).isOnSale());
  }

  /**
   * Test {@link ProductBundleImpl#isOnSale()}.
   * <ul>
   *   <li>Given {@link ProductBundlePricingModelType}
   * {@link ProductBundlePricingModelType#getType()} return {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale_givenProductBundlePricingModelTypeGetTypeReturnType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundlePricingModelType pricingModel = mock(ProductBundlePricingModelType.class);
    when(pricingModel.getType()).thenReturn("Type");

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setPricingModel(pricingModel);

    // Act
    boolean actualIsOnSaleResult = productBundleImpl.isOnSale();

    // Assert
    verify(pricingModel).getType();
    assertFalse(actualIsOnSaleResult);
  }

  /**
   * Test {@link ProductBundleImpl#isOnSale()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is
   * {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then calls {@link ProductBundlePricingModelType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale_givenSkuImplProductIsProductBundleImpl_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundlePricingModelType pricingModel = mock(ProductBundlePricingModelType.class);
    when(pricingModel.getType()).thenReturn("BUNDLE");

    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setProduct(new ProductBundleImpl());

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setDefaultSku(defaultSku);
    productBundleImpl.setPricingModel(pricingModel);

    // Act
    boolean actualIsOnSaleResult = productBundleImpl.isOnSale();

    // Assert
    verify(pricingModel).getType();
    assertFalse(actualIsOnSaleResult);
  }

  /**
   * Test {@link ProductBundleImpl#isOnSale()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) RetailPrice is
   * {@link Money#Money()}.</li>
   *   <li>Then calls {@link ProductBundlePricingModelType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale_givenSkuImplRetailPriceIsMoney_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundlePricingModelType pricingModel = mock(ProductBundlePricingModelType.class);
    when(pricingModel.getType()).thenReturn("BUNDLE");

    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setRetailPrice(new Money());

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setDefaultSku(defaultSku);
    productBundleImpl.setPricingModel(pricingModel);

    // Act
    boolean actualIsOnSaleResult = productBundleImpl.isOnSale();

    // Assert
    verify(pricingModel).getType();
    assertFalse(actualIsOnSaleResult);
  }

  /**
   * Test {@link ProductBundleImpl#isOnSale()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) RetailPrice is
   * {@link Money#Money()}.</li>
   *   <li>Then calls {@link ProductBundlePricingModelType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale_givenSkuImplRetailPriceIsMoney_thenCallsGetType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundlePricingModelType pricingModel = mock(ProductBundlePricingModelType.class);
    when(pricingModel.getType()).thenReturn("BUNDLE");

    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setRetailPrice(new Money());
    defaultSku.setSalePrice(new Money(10.0d));

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setDefaultSku(defaultSku);
    productBundleImpl.setPricingModel(pricingModel);

    // Act
    boolean actualIsOnSaleResult = productBundleImpl.isOnSale();

    // Assert
    verify(pricingModel).getType();
    assertFalse(actualIsOnSaleResult);
  }

  /**
   * Test {@link ProductBundleImpl#isOnSale()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money#Money(double)} with amount is {@code -0.5}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale_givenSkuImplSalePriceIsMoneyWithAmountIs05_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundlePricingModelType pricingModel = mock(ProductBundlePricingModelType.class);
    when(pricingModel.getType()).thenReturn("BUNDLE");

    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setRetailPrice(new Money());
    defaultSku.setSalePrice(new Money(-0.5d));

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setDefaultSku(defaultSku);
    productBundleImpl.setPricingModel(pricingModel);

    // Act
    boolean actualIsOnSaleResult = productBundleImpl.isOnSale();

    // Assert
    verify(pricingModel).getType();
    assertTrue(actualIsOnSaleResult);
  }

  /**
   * Test {@link ProductBundleImpl#isOnSale()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is
   * {@link Money#Money()}.</li>
   *   <li>Then calls {@link ProductBundlePricingModelType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale_givenSkuImplSalePriceIsMoney_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundlePricingModelType pricingModel = mock(ProductBundlePricingModelType.class);
    when(pricingModel.getType()).thenReturn("BUNDLE");

    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setSalePrice(new Money());

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setDefaultSku(defaultSku);
    productBundleImpl.setPricingModel(pricingModel);

    // Act
    boolean actualIsOnSaleResult = productBundleImpl.isOnSale();

    // Assert
    verify(pricingModel).getType();
    assertFalse(actualIsOnSaleResult);
  }

  /**
   * Test {@link ProductBundleImpl#isOnSale()}.
   * <ul>
   *   <li>Then calls {@link ProductBundlePricingModelType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundlePricingModelType pricingModel = mock(ProductBundlePricingModelType.class);
    when(pricingModel.getType()).thenReturn("BUNDLE");

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setDefaultSku(new SkuImpl());
    productBundleImpl.setPricingModel(pricingModel);

    // Act
    boolean actualIsOnSaleResult = productBundleImpl.isOnSale();

    // Assert
    verify(pricingModel).getType();
    assertFalse(actualIsOnSaleResult);
  }

  /**
   * Test {@link ProductBundleImpl#getPricingModel()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getPricingModel()}
   */
  @Test
  public void testGetPricingModel_givenProductBundleImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ProductBundleImpl()).getPricingModel());
  }

  /**
   * Test
   * {@link ProductBundleImpl#setPricingModel(ProductBundlePricingModelType)}.
   * <ul>
   *   <li>When {@link ProductBundlePricingModelType#BUNDLE}.</li>
   *   <li>Then {@link ProductBundleImpl} (default constructor)
   * {@link ProductBundleImpl#pricingModel} is {@code BUNDLE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductBundleImpl#setPricingModel(ProductBundlePricingModelType)}
   */
  @Test
  public void testSetPricingModel_whenBundle_thenProductBundleImplPricingModelIsBundle() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    ProductBundlePricingModelType pricingModel = ProductBundlePricingModelType.BUNDLE;

    // Act
    productBundleImpl.setPricingModel(pricingModel);

    // Assert
    assertEquals("BUNDLE", productBundleImpl.pricingModel);
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money bundleItemsRetailPrice = productBundleImpl.getBundleItemsRetailPrice();
    BigDecimal amount = bundleItemsRetailPrice.getAmount();
    assertEquals(expectedAmount, amount);
    Money absResult = bundleItemsRetailPrice.abs();
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    Money absResult6 = absResult5.abs();
    assertSame(amount, absResult6.abs().getAmount());
    Money zeroResult = bundleItemsRetailPrice.zero();
    Money absResult7 = zeroResult.abs();
    Money absResult8 = absResult7.abs();
    Money absResult9 = absResult8.abs();
    Money absResult10 = absResult9.abs();
    Money absResult11 = absResult10.abs();
    assertSame(amount, absResult11.abs().getAmount());
    assertSame(amount, absResult6.getAmount());
    Money zeroResult2 = absResult.zero();
    Money absResult12 = zeroResult2.abs();
    Money absResult13 = absResult12.abs();
    Money absResult14 = absResult13.abs();
    Money absResult15 = absResult14.abs();
    assertSame(amount, absResult15.abs().getAmount());
    Money zeroResult3 = zeroResult.zero();
    Money absResult16 = zeroResult3.abs();
    Money absResult17 = absResult16.abs();
    Money absResult18 = absResult17.abs();
    Money absResult19 = absResult18.abs();
    assertSame(amount, absResult19.abs().getAmount());
    assertSame(amount, absResult11.getAmount());
    assertSame(amount, absResult5.getAmount());
    Money zeroResult4 = absResult2.zero();
    Money absResult20 = zeroResult4.abs();
    Money absResult21 = absResult20.abs();
    Money absResult22 = absResult21.abs();
    assertSame(amount, absResult22.abs().getAmount());
    Money zeroResult5 = absResult7.zero();
    Money absResult23 = zeroResult5.abs();
    Money absResult24 = absResult23.abs();
    Money absResult25 = absResult24.abs();
    assertSame(amount, absResult25.abs().getAmount());
    assertSame(amount, absResult15.getAmount());
    Money zeroResult6 = zeroResult2.zero();
    Money absResult26 = zeroResult6.abs();
    Money absResult27 = absResult26.abs();
    Money absResult28 = absResult27.abs();
    assertSame(amount, absResult28.abs().getAmount());
    assertSame(amount, absResult19.getAmount());
    assertSame(amount, absResult10.getAmount());
    assertSame(amount, absResult4.getAmount());
    Money zeroResult7 = absResult3.zero();
    Money absResult29 = zeroResult7.abs();
    Money absResult30 = absResult29.abs();
    assertSame(amount, absResult30.abs().getAmount());
    Money zeroResult8 = absResult8.zero();
    Money absResult31 = zeroResult8.abs();
    Money absResult32 = absResult31.abs();
    assertSame(amount, absResult32.abs().getAmount());
    assertSame(amount, absResult22.getAmount());
    Money zeroResult9 = absResult12.zero();
    Money absResult33 = zeroResult9.abs();
    Money absResult34 = absResult33.abs();
    assertSame(amount, absResult34.abs().getAmount());
    assertSame(amount, absResult25.getAmount());
    assertSame(amount, absResult14.getAmount());
    Money zeroResult10 = zeroResult4.zero();
    Money absResult35 = zeroResult10.abs();
    Money absResult36 = absResult35.abs();
    assertSame(amount, absResult36.abs().getAmount());
    Money zeroResult11 = zeroResult5.zero();
    Money absResult37 = zeroResult11.abs();
    Money absResult38 = absResult37.abs();
    assertSame(amount, absResult38.abs().getAmount());
    assertSame(amount, absResult28.getAmount());
    Money zeroResult12 = zeroResult6.zero();
    Money absResult39 = zeroResult12.abs();
    Money absResult40 = absResult39.abs();
    assertSame(amount, absResult40.abs().getAmount());
    Money zeroResult13 = zeroResult3.zero();
    Money absResult41 = zeroResult13.abs();
    Money absResult42 = absResult41.abs();
    assertSame(amount, absResult42.abs().getAmount());
    assertSame(amount, absResult18.getAmount());
    assertSame(amount, absResult9.getAmount());
    assertSame(amount, absResult3.getAmount());
    Money zeroResult14 = absResult4.zero();
    Money absResult43 = zeroResult14.abs();
    assertSame(amount, absResult43.abs().getAmount());
    Money zeroResult15 = absResult9.zero();
    Money absResult44 = zeroResult15.abs();
    assertSame(amount, absResult44.abs().getAmount());
    assertSame(amount, absResult30.getAmount());
    Money zeroResult16 = absResult13.zero();
    Money absResult45 = zeroResult16.abs();
    assertSame(amount, absResult45.abs().getAmount());
    assertSame(amount, absResult32.getAmount());
    assertSame(amount, absResult21.getAmount());
    Money zeroResult17 = absResult20.zero();
    Money absResult46 = zeroResult17.abs();
    assertSame(amount, absResult46.abs().getAmount());
    Money zeroResult18 = absResult23.zero();
    Money absResult47 = zeroResult18.abs();
    assertSame(amount, absResult47.abs().getAmount());
    assertSame(amount, absResult34.getAmount());
    Money zeroResult19 = absResult26.zero();
    Money absResult48 = zeroResult19.abs();
    assertSame(amount, absResult48.abs().getAmount());
    Money zeroResult20 = absResult16.zero();
    Money absResult49 = zeroResult20.abs();
    assertSame(amount, absResult49.abs().getAmount());
    assertSame(amount, absResult24.getAmount());
    assertSame(amount, absResult13.getAmount());
    Money zeroResult21 = zeroResult7.zero();
    Money absResult50 = zeroResult21.abs();
    assertSame(amount, absResult50.abs().getAmount());
    Money zeroResult22 = zeroResult8.zero();
    Money absResult51 = zeroResult22.abs();
    assertSame(amount, absResult51.abs().getAmount());
    assertSame(amount, absResult36.getAmount());
    Money zeroResult23 = zeroResult9.zero();
    Money absResult52 = zeroResult23.abs();
    assertSame(amount, absResult52.abs().getAmount());
    assertSame(amount, absResult38.getAmount());
    assertSame(amount, absResult27.getAmount());
    Money zeroResult24 = zeroResult10.zero();
    Money absResult53 = zeroResult24.abs();
    assertSame(amount, absResult53.abs().getAmount());
    Money zeroResult25 = zeroResult11.zero();
    Money absResult54 = zeroResult25.abs();
    assertSame(amount, absResult54.abs().getAmount());
    assertSame(amount, absResult40.getAmount());
    Money zeroResult26 = zeroResult12.zero();
    Money absResult55 = zeroResult26.abs();
    assertSame(amount, absResult55.abs().getAmount());
    Money zeroResult27 = zeroResult13.zero();
    Money absResult56 = zeroResult27.abs();
    assertSame(amount, absResult56.abs().getAmount());
    assertSame(amount, absResult42.getAmount());
    assertSame(amount, absResult17.getAmount());
    assertSame(amount, absResult8.getAmount());
    assertSame(amount, absResult2.getAmount());
    Money zeroResult28 = absResult5.zero();
    assertSame(amount, zeroResult28.abs().getAmount());
    Money zeroResult29 = absResult10.zero();
    assertSame(amount, zeroResult29.abs().getAmount());
    assertSame(amount, absResult43.getAmount());
    Money zeroResult30 = absResult14.zero();
    assertSame(amount, zeroResult30.abs().getAmount());
    assertSame(amount, absResult44.getAmount());
    assertSame(amount, absResult29.getAmount());
    Money zeroResult31 = absResult21.zero();
    assertSame(amount, zeroResult31.abs().getAmount());
    Money zeroResult32 = absResult24.zero();
    assertSame(amount, zeroResult32.abs().getAmount());
    assertSame(amount, absResult45.getAmount());
    Money zeroResult33 = absResult27.zero();
    assertSame(amount, zeroResult33.abs().getAmount());
    Money zeroResult34 = absResult17.zero();
    assertSame(amount, zeroResult34.abs().getAmount());
    assertSame(amount, absResult31.getAmount());
    assertSame(amount, absResult20.getAmount());
    Money zeroResult35 = absResult29.zero();
    assertSame(amount, zeroResult35.abs().getAmount());
    Money zeroResult36 = absResult31.zero();
    assertSame(amount, zeroResult36.abs().getAmount());
    assertSame(amount, absResult46.getAmount());
    Money zeroResult37 = absResult33.zero();
    assertSame(amount, zeroResult37.abs().getAmount());
    assertSame(amount, absResult47.getAmount());
    assertSame(amount, absResult33.getAmount());
    Money zeroResult38 = absResult35.zero();
    assertSame(amount, zeroResult38.abs().getAmount());
    Money zeroResult39 = absResult37.zero();
    assertSame(amount, zeroResult39.abs().getAmount());
    assertSame(amount, absResult48.getAmount());
    Money zeroResult40 = absResult39.zero();
    assertSame(amount, zeroResult40.abs().getAmount());
    Money zeroResult41 = absResult41.zero();
    assertSame(amount, zeroResult41.abs().getAmount());
    assertSame(amount, absResult49.getAmount());
    assertSame(amount, absResult23.getAmount());
    assertSame(amount, absResult12.getAmount());
    Money zeroResult42 = zeroResult14.zero();
    assertSame(amount, zeroResult42.abs().getAmount());
    Money zeroResult43 = zeroResult15.zero();
    assertSame(amount, zeroResult43.abs().getAmount());
    assertSame(amount, absResult50.getAmount());
    Money zeroResult44 = zeroResult16.zero();
    assertSame(amount, zeroResult44.abs().getAmount());
    assertSame(amount, absResult51.getAmount());
    assertSame(amount, absResult35.getAmount());
    Money zeroResult45 = zeroResult17.zero();
    assertSame(amount, zeroResult45.abs().getAmount());
    Money zeroResult46 = zeroResult18.zero();
    assertSame(amount, zeroResult46.abs().getAmount());
    assertSame(amount, absResult52.getAmount());
    Money zeroResult47 = zeroResult19.zero();
    assertSame(amount, zeroResult47.abs().getAmount());
    Money zeroResult48 = zeroResult20.zero();
    assertSame(amount, zeroResult48.abs().getAmount());
    assertSame(amount, absResult37.getAmount());
    assertSame(amount, absResult26.getAmount());
    Money zeroResult49 = zeroResult21.zero();
    assertSame(amount, zeroResult49.abs().getAmount());
    Money zeroResult50 = zeroResult22.zero();
    assertSame(amount, zeroResult50.abs().getAmount());
    assertSame(amount, absResult53.getAmount());
    Money zeroResult51 = zeroResult23.zero();
    assertSame(amount, zeroResult51.abs().getAmount());
    assertSame(amount, absResult54.getAmount());
    assertSame(amount, absResult39.getAmount());
    Money zeroResult52 = zeroResult24.zero();
    assertSame(amount, zeroResult52.abs().getAmount());
    Money zeroResult53 = zeroResult25.zero();
    assertSame(amount, zeroResult53.abs().getAmount());
    assertSame(amount, absResult55.getAmount());
    Money zeroResult54 = zeroResult26.zero();
    assertSame(amount, zeroResult54.abs().getAmount());
    Money zeroResult55 = zeroResult27.zero();
    assertSame(amount, zeroResult55.abs().getAmount());
    assertSame(amount, absResult56.getAmount());
    assertSame(amount, absResult41.getAmount());
    assertSame(amount, absResult16.getAmount());
    assertSame(amount, absResult7.getAmount());
    assertSame(amount, absResult.getAmount());
    assertSame(amount, absResult6.zero().getAmount());
    assertSame(amount, absResult11.zero().getAmount());
    assertSame(amount, zeroResult28.getAmount());
    assertSame(amount, absResult15.zero().getAmount());
    assertSame(amount, zeroResult29.getAmount());
    assertSame(amount, zeroResult14.getAmount());
    assertSame(amount, absResult22.zero().getAmount());
    assertSame(amount, absResult25.zero().getAmount());
    assertSame(amount, zeroResult30.getAmount());
    assertSame(amount, absResult28.zero().getAmount());
    assertSame(amount, absResult18.zero().getAmount());
    assertSame(amount, zeroResult15.getAmount());
    assertSame(amount, zeroResult7.getAmount());
    assertSame(amount, absResult30.zero().getAmount());
    assertSame(amount, absResult32.zero().getAmount());
    assertSame(amount, zeroResult31.getAmount());
    assertSame(amount, absResult34.zero().getAmount());
    assertSame(amount, zeroResult32.getAmount());
    assertSame(amount, zeroResult16.getAmount());
    assertSame(amount, absResult36.zero().getAmount());
    assertSame(amount, absResult38.zero().getAmount());
    assertSame(amount, zeroResult33.getAmount());
    assertSame(amount, absResult40.zero().getAmount());
    assertSame(amount, absResult42.zero().getAmount());
    assertSame(amount, zeroResult34.getAmount());
    assertSame(amount, zeroResult8.getAmount());
    assertSame(amount, zeroResult4.getAmount());
    assertSame(amount, absResult43.zero().getAmount());
    assertSame(amount, absResult44.zero().getAmount());
    assertSame(amount, zeroResult35.getAmount());
    assertSame(amount, absResult45.zero().getAmount());
    assertSame(amount, zeroResult36.getAmount());
    assertSame(amount, zeroResult17.getAmount());
    assertSame(amount, absResult46.zero().getAmount());
    assertSame(amount, absResult47.zero().getAmount());
    assertSame(amount, zeroResult37.getAmount());
    assertSame(amount, absResult48.zero().getAmount());
    assertSame(amount, absResult49.zero().getAmount());
    assertSame(amount, zeroResult18.getAmount());
    assertSame(amount, zeroResult9.getAmount());
    assertSame(amount, absResult50.zero().getAmount());
    assertSame(amount, absResult51.zero().getAmount());
    assertSame(amount, zeroResult38.getAmount());
    assertSame(amount, absResult52.zero().getAmount());
    assertSame(amount, zeroResult39.getAmount());
    assertSame(amount, zeroResult19.getAmount());
    assertSame(amount, absResult53.zero().getAmount());
    assertSame(amount, absResult54.zero().getAmount());
    assertSame(amount, zeroResult40.getAmount());
    assertSame(amount, absResult55.zero().getAmount());
    assertSame(amount, absResult56.zero().getAmount());
    assertSame(amount, zeroResult41.getAmount());
    assertSame(amount, zeroResult20.getAmount());
    assertSame(amount, zeroResult5.getAmount());
    assertSame(amount, zeroResult2.getAmount());
    assertSame(amount, zeroResult28.zero().getAmount());
    assertSame(amount, zeroResult29.zero().getAmount());
    assertSame(amount, zeroResult42.getAmount());
    assertSame(amount, zeroResult30.zero().getAmount());
    assertSame(amount, zeroResult43.getAmount());
    assertSame(amount, zeroResult21.getAmount());
    assertSame(amount, zeroResult31.zero().getAmount());
    assertSame(amount, zeroResult32.zero().getAmount());
    assertSame(amount, zeroResult44.getAmount());
    assertSame(amount, zeroResult33.zero().getAmount());
    assertSame(amount, zeroResult34.zero().getAmount());
    assertSame(amount, zeroResult22.getAmount());
    assertSame(amount, zeroResult10.getAmount());
    assertSame(amount, zeroResult35.zero().getAmount());
    assertSame(amount, zeroResult36.zero().getAmount());
    assertSame(amount, zeroResult45.getAmount());
    assertSame(amount, zeroResult37.zero().getAmount());
    assertSame(amount, zeroResult46.getAmount());
    assertSame(amount, zeroResult23.getAmount());
    assertSame(amount, zeroResult38.zero().getAmount());
    assertSame(amount, zeroResult39.zero().getAmount());
    assertSame(amount, zeroResult47.getAmount());
    assertSame(amount, zeroResult40.zero().getAmount());
    assertSame(amount, zeroResult41.zero().getAmount());
    assertSame(amount, zeroResult48.getAmount());
    assertSame(amount, zeroResult11.getAmount());
    assertSame(amount, zeroResult6.getAmount());
    assertSame(amount, zeroResult42.zero().getAmount());
    assertSame(amount, zeroResult43.zero().getAmount());
    assertSame(amount, zeroResult49.getAmount());
    assertSame(amount, zeroResult44.zero().getAmount());
    assertSame(amount, zeroResult50.getAmount());
    assertSame(amount, zeroResult24.getAmount());
    assertSame(amount, zeroResult45.zero().getAmount());
    assertSame(amount, zeroResult46.zero().getAmount());
    assertSame(amount, zeroResult51.getAmount());
    assertSame(amount, zeroResult47.zero().getAmount());
    assertSame(amount, zeroResult48.zero().getAmount());
    assertSame(amount, zeroResult25.getAmount());
    assertSame(amount, zeroResult12.getAmount());
    assertSame(amount, zeroResult49.zero().getAmount());
    assertSame(amount, zeroResult50.zero().getAmount());
    assertSame(amount, zeroResult52.getAmount());
    assertSame(amount, zeroResult51.zero().getAmount());
    assertSame(amount, zeroResult53.getAmount());
    assertSame(amount, zeroResult26.getAmount());
    assertSame(amount, zeroResult52.zero().getAmount());
    assertSame(amount, zeroResult53.zero().getAmount());
    assertSame(amount, zeroResult54.getAmount());
    assertSame(amount, zeroResult54.zero().getAmount());
    assertSame(amount, zeroResult55.zero().getAmount());
    assertSame(amount, zeroResult55.getAmount());
    assertSame(amount, zeroResult27.getAmount());
    assertSame(amount, zeroResult13.getAmount());
    assertSame(amount, zeroResult3.getAmount());
    assertSame(amount, zeroResult.getAmount());
    ProductBundlePricingModelType expectedPricingModel = pricingModel.BUNDLE;
    assertSame(expectedPricingModel, productBundleImpl.getPricingModel());
  }

  /**
   * Test
   * {@link ProductBundleImpl#setPricingModel(ProductBundlePricingModelType)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link ProductBundleImpl} (default constructor)
   * {@link ProductBundleImpl#pricingModel} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductBundleImpl#setPricingModel(ProductBundlePricingModelType)}
   */
  @Test
  public void testSetPricingModel_whenNull_thenProductBundleImplPricingModelIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();

    // Act
    productBundleImpl.setPricingModel(null);

    // Assert
    assertNull(productBundleImpl.pricingModel);
    assertNull(productBundleImpl.getPricingModel());
  }

  /**
   * Test {@link ProductBundleImpl#getRetailPrice()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor) PricingModel is
   * {@link ProductBundlePricingModelType#ITEM_SUM}.</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getRetailPrice()}
   */
  @Test
  public void testGetRetailPrice_givenProductBundleImplPricingModelIsItem_sum_thenReturnZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setPricingModel(ProductBundlePricingModelType.ITEM_SUM);

    // Act
    Money actualRetailPrice = productBundleImpl.getRetailPrice();

    // Assert
    assertSame(actualRetailPrice.ZERO, actualRetailPrice);
  }

  /**
   * Test {@link ProductBundleImpl#getRetailPrice()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getRetailPrice()}
   */
  @Test
  public void testGetRetailPrice_givenProductBundleImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ProductBundleImpl()).getRetailPrice());
  }

  /**
   * Test {@link ProductBundleImpl#getRetailPrice()}.
   * <ul>
   *   <li>Given {@link ProductBundlePricingModelType}
   * {@link ProductBundlePricingModelType#getType()} return {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getRetailPrice()}
   */
  @Test
  public void testGetRetailPrice_givenProductBundlePricingModelTypeGetTypeReturnType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundlePricingModelType pricingModel = mock(ProductBundlePricingModelType.class);
    when(pricingModel.getType()).thenReturn("Type");

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setPricingModel(pricingModel);

    // Act
    Money actualRetailPrice = productBundleImpl.getRetailPrice();

    // Assert
    verify(pricingModel).getType();
    assertNull(actualRetailPrice);
  }

  /**
   * Test {@link ProductBundleImpl#getRetailPrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is
   * {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getRetailPrice()}
   */
  @Test
  public void testGetRetailPrice_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundlePricingModelType pricingModel = mock(ProductBundlePricingModelType.class);
    when(pricingModel.getType()).thenReturn("BUNDLE");

    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setProduct(new ProductBundleImpl());

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setDefaultSku(defaultSku);
    productBundleImpl.setPricingModel(pricingModel);

    // Act
    Money actualRetailPrice = productBundleImpl.getRetailPrice();

    // Assert
    verify(pricingModel).getType();
    assertNull(actualRetailPrice);
  }

  /**
   * Test {@link ProductBundleImpl#getRetailPrice()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getRetailPrice()}
   */
  @Test
  public void testGetRetailPrice_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundlePricingModelType pricingModel = mock(ProductBundlePricingModelType.class);
    when(pricingModel.getType()).thenReturn("BUNDLE");

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setDefaultSku(new SkuImpl());
    productBundleImpl.setPricingModel(pricingModel);

    // Act
    Money actualRetailPrice = productBundleImpl.getRetailPrice();

    // Assert
    verify(pricingModel).getType();
    assertNull(actualRetailPrice);
  }

  /**
   * Test {@link ProductBundleImpl#getSalePrice()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor) PricingModel is
   * {@link ProductBundlePricingModelType#ITEM_SUM}.</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getSalePrice()}
   */
  @Test
  public void testGetSalePrice_givenProductBundleImplPricingModelIsItem_sum_thenReturnZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setPricingModel(ProductBundlePricingModelType.ITEM_SUM);

    // Act
    Money actualSalePrice = productBundleImpl.getSalePrice();

    // Assert
    assertSame(actualSalePrice.ZERO, actualSalePrice);
  }

  /**
   * Test {@link ProductBundleImpl#getSalePrice()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getSalePrice()}
   */
  @Test
  public void testGetSalePrice_givenProductBundleImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ProductBundleImpl()).getSalePrice());
  }

  /**
   * Test {@link ProductBundleImpl#getSalePrice()}.
   * <ul>
   *   <li>Given {@link ProductBundlePricingModelType}
   * {@link ProductBundlePricingModelType#getType()} return {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getSalePrice()}
   */
  @Test
  public void testGetSalePrice_givenProductBundlePricingModelTypeGetTypeReturnType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundlePricingModelType pricingModel = mock(ProductBundlePricingModelType.class);
    when(pricingModel.getType()).thenReturn("Type");

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setPricingModel(pricingModel);

    // Act
    Money actualSalePrice = productBundleImpl.getSalePrice();

    // Assert
    verify(pricingModel).getType();
    assertNull(actualSalePrice);
  }

  /**
   * Test {@link ProductBundleImpl#getSalePrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is
   * {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getSalePrice()}
   */
  @Test
  public void testGetSalePrice_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundlePricingModelType pricingModel = mock(ProductBundlePricingModelType.class);
    when(pricingModel.getType()).thenReturn("BUNDLE");

    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setProduct(new ProductBundleImpl());

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setDefaultSku(defaultSku);
    productBundleImpl.setPricingModel(pricingModel);

    // Act
    Money actualSalePrice = productBundleImpl.getSalePrice();

    // Assert
    verify(pricingModel).getType();
    assertNull(actualSalePrice);
  }

  /**
   * Test {@link ProductBundleImpl#getSalePrice()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getSalePrice()}
   */
  @Test
  public void testGetSalePrice_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundlePricingModelType pricingModel = mock(ProductBundlePricingModelType.class);
    when(pricingModel.getType()).thenReturn("BUNDLE");

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setDefaultSku(new SkuImpl());
    productBundleImpl.setPricingModel(pricingModel);

    // Act
    Money actualSalePrice = productBundleImpl.getSalePrice();

    // Assert
    verify(pricingModel).getType();
    assertNull(actualSalePrice);
  }

  /**
   * Test {@link ProductBundleImpl#getBundleItemsRetailPrice()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getBundleItemsRetailPrice()}
   */
  @Test
  public void testGetBundleItemsRetailPrice_givenProductBundleImpl_thenReturnZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Money actualBundleItemsRetailPrice = (new ProductBundleImpl()).getBundleItemsRetailPrice();

    // Assert
    assertSame(actualBundleItemsRetailPrice.ZERO, actualBundleItemsRetailPrice);
  }

  /**
   * Test {@link ProductBundleImpl#getBundleItemsRetailPrice()}.
   * <ul>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getBundleItemsRetailPrice()}
   */
  @Test
  public void testGetBundleItemsRetailPrice_thenReturnZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundlePricingModelType pricingModel = mock(ProductBundlePricingModelType.class);
    when(pricingModel.getType()).thenReturn("Type");

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setPricingModel(pricingModel);

    // Act
    Money actualBundleItemsRetailPrice = productBundleImpl.getBundleItemsRetailPrice();

    // Assert
    verify(pricingModel).getType();
    assertSame(actualBundleItemsRetailPrice.ZERO, actualBundleItemsRetailPrice);
  }

  /**
   * Test {@link ProductBundleImpl#getBundleItemsSalePrice()}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#multiply(int)} return
   * {@link Money#Money()}.</li>
   *   <li>Then calls {@link Money#multiply(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getBundleItemsSalePrice()}
   */
  @Test
  public void testGetBundleItemsSalePrice_givenMoneyMultiplyReturnMoney_thenCallsMultiply() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundlePricingModelType pricingModel = mock(ProductBundlePricingModelType.class);
    when(pricingModel.getType()).thenReturn("Type");
    Money money = mock(Money.class);
    when(money.multiply(anyInt())).thenReturn(new Money());
    SkuBundleItemImpl skuBundleItemImpl = mock(SkuBundleItemImpl.class);
    when(skuBundleItemImpl.getQuantity()).thenReturn(1);
    when(skuBundleItemImpl.getSalePrice()).thenReturn(money);
    doNothing().when(skuBundleItemImpl).setSku(Mockito.<Sku>any());
    skuBundleItemImpl.setSku(mock(Sku.class));

    ArrayList<SkuBundleItem> skuBundleItems = new ArrayList<>();
    skuBundleItems.add(skuBundleItemImpl);

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setSkuBundleItems(skuBundleItems);
    productBundleImpl.setPricingModel(pricingModel);
    Money expectedBundleItemsSalePrice = new Money();

    // Act
    Money actualBundleItemsSalePrice = productBundleImpl.getBundleItemsSalePrice();

    // Assert
    verify(money).multiply(eq(1));
    verify(skuBundleItemImpl).getQuantity();
    verify(skuBundleItemImpl, atLeast(1)).getSalePrice();
    verify(skuBundleItemImpl).setSku(isA(Sku.class));
    verify(pricingModel).getType();
    assertEquals(expectedBundleItemsSalePrice, actualBundleItemsSalePrice);
  }

  /**
   * Test {@link ProductBundleImpl#getBundleItemsSalePrice()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getBundleItemsSalePrice()}
   */
  @Test
  public void testGetBundleItemsSalePrice_givenProductBundleImpl_thenReturnZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Money actualBundleItemsSalePrice = (new ProductBundleImpl()).getBundleItemsSalePrice();

    // Assert
    assertSame(actualBundleItemsSalePrice.ZERO, actualBundleItemsSalePrice);
  }

  /**
   * Test {@link ProductBundleImpl#getBundleItemsSalePrice()}.
   * <ul>
   *   <li>Given {@link SkuBundleItemImpl} {@link SkuBundleItemImpl#getSalePrice()}
   * return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getBundleItemsSalePrice()}
   */
  @Test
  public void testGetBundleItemsSalePrice_givenSkuBundleItemImplGetSalePriceReturnMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundlePricingModelType pricingModel = mock(ProductBundlePricingModelType.class);
    when(pricingModel.getType()).thenReturn("Type");
    SkuBundleItemImpl skuBundleItemImpl = mock(SkuBundleItemImpl.class);
    when(skuBundleItemImpl.getQuantity()).thenReturn(1);
    when(skuBundleItemImpl.getSalePrice()).thenReturn(new Money());
    doNothing().when(skuBundleItemImpl).setSku(Mockito.<Sku>any());
    skuBundleItemImpl.setSku(mock(Sku.class));

    ArrayList<SkuBundleItem> skuBundleItems = new ArrayList<>();
    skuBundleItems.add(skuBundleItemImpl);

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setSkuBundleItems(skuBundleItems);
    productBundleImpl.setPricingModel(pricingModel);
    Money expectedBundleItemsSalePrice = new Money();

    // Act
    Money actualBundleItemsSalePrice = productBundleImpl.getBundleItemsSalePrice();

    // Assert
    verify(skuBundleItemImpl).getQuantity();
    verify(skuBundleItemImpl, atLeast(1)).getSalePrice();
    verify(skuBundleItemImpl).setSku(isA(Sku.class));
    verify(pricingModel).getType();
    assertEquals(expectedBundleItemsSalePrice, actualBundleItemsSalePrice);
  }

  /**
   * Test {@link ProductBundleImpl#getBundleItemsSalePrice()}.
   * <ul>
   *   <li>Then calls {@link SkuBundleItemImpl#getRetailPrice()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getBundleItemsSalePrice()}
   */
  @Test
  public void testGetBundleItemsSalePrice_thenCallsGetRetailPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundlePricingModelType pricingModel = mock(ProductBundlePricingModelType.class);
    when(pricingModel.getType()).thenReturn("Type");
    SkuBundleItemImpl skuBundleItemImpl = mock(SkuBundleItemImpl.class);
    when(skuBundleItemImpl.getQuantity()).thenReturn(1);
    Money money = new Money();
    when(skuBundleItemImpl.getRetailPrice()).thenReturn(money);
    when(skuBundleItemImpl.getSalePrice()).thenReturn(null);
    doNothing().when(skuBundleItemImpl).setSku(Mockito.<Sku>any());
    skuBundleItemImpl.setSku(mock(Sku.class));

    ArrayList<SkuBundleItem> skuBundleItems = new ArrayList<>();
    skuBundleItems.add(skuBundleItemImpl);

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setSkuBundleItems(skuBundleItems);
    productBundleImpl.setPricingModel(pricingModel);

    // Act
    Money actualBundleItemsSalePrice = productBundleImpl.getBundleItemsSalePrice();

    // Assert
    verify(skuBundleItemImpl).getQuantity();
    verify(skuBundleItemImpl).getRetailPrice();
    verify(skuBundleItemImpl).getSalePrice();
    verify(skuBundleItemImpl).setSku(isA(Sku.class));
    verify(pricingModel).getType();
    assertEquals(money, actualBundleItemsSalePrice);
  }

  /**
   * Test {@link ProductBundleImpl#getBundleItemsSalePrice()}.
   * <ul>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getBundleItemsSalePrice()}
   */
  @Test
  public void testGetBundleItemsSalePrice_thenReturnZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundlePricingModelType pricingModel = mock(ProductBundlePricingModelType.class);
    when(pricingModel.getType()).thenReturn("Type");

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setPricingModel(pricingModel);

    // Act
    Money actualBundleItemsSalePrice = productBundleImpl.getBundleItemsSalePrice();

    // Assert
    verify(pricingModel).getType();
    assertSame(actualBundleItemsSalePrice.ZERO, actualBundleItemsSalePrice);
  }

  /**
   * Test {@link ProductBundleImpl#clearDynamicPrices()}.
   * <ul>
   *   <li>Given {@link SkuBundleItemImpl} (default constructor) Sku is
   * {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#clearDynamicPrices()}
   */
  @Test
  public void testClearDynamicPrices_givenSkuBundleItemImplSkuIsSkuImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl defaultSku = mock(SkuImpl.class);
    doNothing().when(defaultSku).clearDynamicPrices();
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    skuBundleItemImpl.setSku(new SkuImpl());

    ArrayList<SkuBundleItem> skuBundleItems = new ArrayList<>();
    skuBundleItems.add(skuBundleItemImpl);

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setSkuBundleItems(skuBundleItems);
    productBundleImpl.setDefaultSku(defaultSku);

    // Act
    productBundleImpl.clearDynamicPrices();

    // Assert
    verify(defaultSku).clearDynamicPrices();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
  }

  /**
   * Test {@link ProductBundleImpl#clearDynamicPrices()}.
   * <ul>
   *   <li>Then calls {@link SkuImpl#clearDynamicPrices()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#clearDynamicPrices()}
   */
  @Test
  public void testClearDynamicPrices_thenCallsClearDynamicPrices() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuImpl defaultSku = mock(SkuImpl.class);
    doNothing().when(defaultSku).clearDynamicPrices();
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setDefaultSku(defaultSku);

    // Act
    productBundleImpl.clearDynamicPrices();

    // Assert
    verify(defaultSku).clearDynamicPrices();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
  }

  /**
   * Test {@link ProductBundleImpl#getAutoBundle()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getAutoBundle()}
   */
  @Test
  public void testGetAutoBundle_givenProductBundleImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ProductBundleImpl()).getAutoBundle());
  }

  /**
   * Test {@link ProductBundleImpl#getAutoBundle()}.
   * <ul>
   *   <li>Then calls {@link ProductBundlePricingModelType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getAutoBundle()}
   */
  @Test
  public void testGetAutoBundle_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundlePricingModelType pricingModel = mock(ProductBundlePricingModelType.class);
    when(pricingModel.getType()).thenReturn("Type");

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setPricingModel(pricingModel);

    // Act
    Boolean actualAutoBundle = productBundleImpl.getAutoBundle();

    // Assert
    verify(pricingModel).getType();
    assertFalse(actualAutoBundle);
  }

  /**
   * Test {@link ProductBundleImpl#getItemsPromotable()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor) ItemsPromotable is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getItemsPromotable()}
   */
  @Test
  public void testGetItemsPromotable_givenProductBundleImplItemsPromotableIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setItemsPromotable(null);

    // Act and Assert
    assertFalse(productBundleImpl.getItemsPromotable());
  }

  /**
   * Test {@link ProductBundleImpl#getItemsPromotable()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getItemsPromotable()}
   */
  @Test
  public void testGetItemsPromotable_givenProductBundleImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ProductBundleImpl()).getItemsPromotable());
  }

  /**
   * Test {@link ProductBundleImpl#getItemsPromotable()}.
   * <ul>
   *   <li>Then calls {@link ProductBundlePricingModelType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getItemsPromotable()}
   */
  @Test
  public void testGetItemsPromotable_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundlePricingModelType pricingModel = mock(ProductBundlePricingModelType.class);
    when(pricingModel.getType()).thenReturn("Type");

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setPricingModel(pricingModel);

    // Act
    Boolean actualItemsPromotable = productBundleImpl.getItemsPromotable();

    // Assert
    verify(pricingModel).getType();
    assertFalse(actualItemsPromotable);
  }

  /**
   * Test {@link ProductBundleImpl#getItemsPromotable()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getItemsPromotable()}
   */
  @Test
  public void testGetItemsPromotable_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setItemsPromotable(true);

    // Act and Assert
    assertTrue(productBundleImpl.getItemsPromotable());
  }

  /**
   * Test {@link ProductBundleImpl#getBundlePromotable()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor) BundlePromotable is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getBundlePromotable()}
   */
  @Test
  public void testGetBundlePromotable_givenProductBundleImplBundlePromotableIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setBundlePromotable(null);

    // Act and Assert
    assertFalse(productBundleImpl.getBundlePromotable());
  }

  /**
   * Test {@link ProductBundleImpl#getBundlePromotable()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getBundlePromotable()}
   */
  @Test
  public void testGetBundlePromotable_givenProductBundleImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ProductBundleImpl()).getBundlePromotable());
  }

  /**
   * Test {@link ProductBundleImpl#getBundlePromotable()}.
   * <ul>
   *   <li>Then calls {@link ProductBundlePricingModelType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getBundlePromotable()}
   */
  @Test
  public void testGetBundlePromotable_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundlePricingModelType pricingModel = mock(ProductBundlePricingModelType.class);
    when(pricingModel.getType()).thenReturn("Type");

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setPricingModel(pricingModel);

    // Act
    Boolean actualBundlePromotable = productBundleImpl.getBundlePromotable();

    // Assert
    verify(pricingModel).getType();
    assertFalse(actualBundlePromotable);
  }

  /**
   * Test {@link ProductBundleImpl#getBundlePromotable()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getBundlePromotable()}
   */
  @Test
  public void testGetBundlePromotable_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setBundlePromotable(true);

    // Act and Assert
    assertTrue(productBundleImpl.getBundlePromotable());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductBundleImpl#setBundlePromotable(Boolean)}
   *   <li>{@link ProductBundleImpl#setItemsPromotable(Boolean)}
   *   <li>{@link ProductBundleImpl#setPriority(Integer)}
   *   <li>{@link ProductBundleImpl#setSkuBundleItems(List)}
   *   <li>{@link ProductBundleImpl#setAutoBundle(Boolean)}
   *   <li>{@link ProductBundleImpl#getPriority()}
   *   <li>{@link ProductBundleImpl#getSkuBundleItems()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();

    // Act
    productBundleImpl.setBundlePromotable(true);
    productBundleImpl.setItemsPromotable(true);
    productBundleImpl.setPriority(1);
    ArrayList<SkuBundleItem> skuBundleItems = new ArrayList<>();
    productBundleImpl.setSkuBundleItems(skuBundleItems);
    productBundleImpl.setAutoBundle(true);
    Integer actualPriority = productBundleImpl.getPriority();
    List<SkuBundleItem> actualSkuBundleItems = productBundleImpl.getSkuBundleItems();

    // Assert that nothing has changed
    assertEquals(1, actualPriority.intValue());
    assertTrue(actualSkuBundleItems.isEmpty());
    assertSame(skuBundleItems, actualSkuBundleItems);
  }

  /**
   * Test {@link ProductBundleImpl#getPotentialSavings()}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#multiply(int)} return
   * {@link Money#Money()}.</li>
   *   <li>Then calls {@link Money#multiply(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getPotentialSavings()}
   */
  @Test
  public void testGetPotentialSavings_givenMoneyMultiplyReturnMoney_thenCallsMultiply() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundlePricingModelType pricingModel = mock(ProductBundlePricingModelType.class);
    when(pricingModel.getType()).thenReturn("ITEM_SUM");
    Money money = mock(Money.class);
    when(money.multiply(anyInt())).thenReturn(new Money());
    SkuBundleItemImpl skuBundleItemImpl = mock(SkuBundleItemImpl.class);
    when(skuBundleItemImpl.getQuantity()).thenReturn(1);
    when(skuBundleItemImpl.getSalePrice()).thenReturn(money);
    when(skuBundleItemImpl.getSku()).thenReturn(new SkuImpl());

    ArrayList<SkuBundleItem> skuBundleItems = new ArrayList<>();
    skuBundleItems.add(skuBundleItemImpl);

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setSkuBundleItems(skuBundleItems);
    productBundleImpl.setPricingModel(pricingModel);

    // Act
    BigDecimal actualPotentialSavings = productBundleImpl.getPotentialSavings();

    // Assert
    verify(money).multiply(eq(1));
    verify(skuBundleItemImpl).getQuantity();
    verify(skuBundleItemImpl, atLeast(1)).getSalePrice();
    verify(skuBundleItemImpl).getSku();
    verify(pricingModel).getType();
    assertEquals(new BigDecimal("0.00"), actualPotentialSavings);
  }

  /**
   * Test {@link ProductBundleImpl#getPotentialSavings()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getPotentialSavings()}
   */
  @Test
  public void testGetPotentialSavings_givenProductBundleImpl_thenReturnBigDecimalWith000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    BigDecimal actualPotentialSavings = (new ProductBundleImpl()).getPotentialSavings();

    // Assert
    assertEquals(new BigDecimal("0.00"), actualPotentialSavings);
  }

  /**
   * Test {@link ProductBundleImpl#getPotentialSavings()}.
   * <ul>
   *   <li>Given {@link ProductBundlePricingModelType}
   * {@link ProductBundlePricingModelType#getType()} return {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getPotentialSavings()}
   */
  @Test
  public void testGetPotentialSavings_givenProductBundlePricingModelTypeGetTypeReturnType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundlePricingModelType pricingModel = mock(ProductBundlePricingModelType.class);
    when(pricingModel.getType()).thenReturn("Type");

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setPricingModel(pricingModel);

    // Act
    BigDecimal actualPotentialSavings = productBundleImpl.getPotentialSavings();

    // Assert
    verify(pricingModel).getType();
    assertEquals(new BigDecimal("0.00"), actualPotentialSavings);
  }

  /**
   * Test {@link ProductBundleImpl#getPotentialSavings()}.
   * <ul>
   *   <li>Given {@link SkuBundleItemImpl} {@link SkuBundleItemImpl#getSku()} return
   * {@code null}.</li>
   *   <li>Then calls {@link SkuBundleItemImpl#getSku()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getPotentialSavings()}
   */
  @Test
  public void testGetPotentialSavings_givenSkuBundleItemImplGetSkuReturnNull_thenCallsGetSku() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundlePricingModelType pricingModel = mock(ProductBundlePricingModelType.class);
    when(pricingModel.getType()).thenReturn("Type");
    SkuBundleItemImpl skuBundleItemImpl = mock(SkuBundleItemImpl.class);
    when(skuBundleItemImpl.getSku()).thenReturn(null);

    ArrayList<SkuBundleItem> skuBundleItems = new ArrayList<>();
    skuBundleItems.add(skuBundleItemImpl);

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setSkuBundleItems(skuBundleItems);
    productBundleImpl.setPricingModel(pricingModel);

    // Act
    BigDecimal actualPotentialSavings = productBundleImpl.getPotentialSavings();

    // Assert
    verify(skuBundleItemImpl).getSku();
    verify(pricingModel).getType();
    assertEquals(new BigDecimal("0.00"), actualPotentialSavings);
  }

  /**
   * Test {@link ProductBundleImpl#getPotentialSavings()}.
   * <ul>
   *   <li>Given {@link SkuBundleItemImpl} (default constructor) Sku is
   * {@link SkuImpl} (default constructor).</li>
   *   <li>Then calls {@link ProductBundlePricingModelType#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getPotentialSavings()}
   */
  @Test
  public void testGetPotentialSavings_givenSkuBundleItemImplSkuIsSkuImpl_thenCallsGetType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundlePricingModelType pricingModel = mock(ProductBundlePricingModelType.class);
    when(pricingModel.getType()).thenReturn("Type");

    SkuBundleItemImpl skuBundleItemImpl = new SkuBundleItemImpl();
    skuBundleItemImpl.setSku(new SkuImpl());

    ArrayList<SkuBundleItem> skuBundleItems = new ArrayList<>();
    skuBundleItems.add(skuBundleItemImpl);

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setSkuBundleItems(skuBundleItems);
    productBundleImpl.setPricingModel(pricingModel);

    // Act
    BigDecimal actualPotentialSavings = productBundleImpl.getPotentialSavings();

    // Assert
    verify(pricingModel).getType();
    assertEquals(new BigDecimal("0.00"), actualPotentialSavings);
  }

  /**
   * Test {@link ProductBundleImpl#getPotentialSavings()}.
   * <ul>
   *   <li>Then calls {@link SkuBundleItemImpl#getQuantity()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getPotentialSavings()}
   */
  @Test
  public void testGetPotentialSavings_thenCallsGetQuantity() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundlePricingModelType pricingModel = mock(ProductBundlePricingModelType.class);
    when(pricingModel.getType()).thenReturn("ITEM_SUM");
    SkuBundleItemImpl skuBundleItemImpl = mock(SkuBundleItemImpl.class);
    when(skuBundleItemImpl.getQuantity()).thenReturn(1);
    when(skuBundleItemImpl.getSalePrice()).thenReturn(new Money());
    when(skuBundleItemImpl.getSku()).thenReturn(new SkuImpl());

    ArrayList<SkuBundleItem> skuBundleItems = new ArrayList<>();
    skuBundleItems.add(skuBundleItemImpl);

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setSkuBundleItems(skuBundleItems);
    productBundleImpl.setPricingModel(pricingModel);

    // Act
    BigDecimal actualPotentialSavings = productBundleImpl.getPotentialSavings();

    // Assert
    verify(skuBundleItemImpl).getQuantity();
    verify(skuBundleItemImpl, atLeast(1)).getSalePrice();
    verify(skuBundleItemImpl).getSku();
    verify(pricingModel).getType();
    assertEquals(new BigDecimal("0.00"), actualPotentialSavings);
  }

  /**
   * Test {@link ProductBundleImpl#getPotentialSavings()}.
   * <ul>
   *   <li>Then calls {@link SkuBundleItemImpl#getRetailPrice()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getPotentialSavings()}
   */
  @Test
  public void testGetPotentialSavings_thenCallsGetRetailPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundlePricingModelType pricingModel = mock(ProductBundlePricingModelType.class);
    when(pricingModel.getType()).thenReturn("ITEM_SUM");
    SkuBundleItemImpl skuBundleItemImpl = mock(SkuBundleItemImpl.class);
    when(skuBundleItemImpl.getQuantity()).thenReturn(1);
    when(skuBundleItemImpl.getRetailPrice()).thenReturn(new Money());
    when(skuBundleItemImpl.getSalePrice()).thenReturn(null);
    when(skuBundleItemImpl.getSku()).thenReturn(new SkuImpl());

    ArrayList<SkuBundleItem> skuBundleItems = new ArrayList<>();
    skuBundleItems.add(skuBundleItemImpl);

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setSkuBundleItems(skuBundleItems);
    productBundleImpl.setPricingModel(pricingModel);

    // Act
    BigDecimal actualPotentialSavings = productBundleImpl.getPotentialSavings();

    // Assert
    verify(skuBundleItemImpl).getQuantity();
    verify(skuBundleItemImpl).getRetailPrice();
    verify(skuBundleItemImpl).getSalePrice();
    verify(skuBundleItemImpl).getSku();
    verify(pricingModel).getType();
    assertEquals(new BigDecimal("0.00"), actualPotentialSavings);
  }

  /**
   * Test
   * {@link ProductBundleImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link ProductBundleImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.getCopyHints()).thenReturn(new HashMap<>());
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<ProductBundle> actualCreateOrRetrieveCopyInstanceResult = productBundleImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(context).getCopyHints();
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link ProductBundleImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code PROPAGATION} is
   * {@code PROPAGATION}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductBundleImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_givenHashMapPropagationIsPropagation()
      throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("PROPAGATION", "PROPAGATION");
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.getCopyHints()).thenReturn(stringStringMap);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<ProductBundle> actualCreateOrRetrieveCopyInstanceResult = productBundleImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(context, atLeast(1)).getCopyHints();
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test new {@link ProductBundleImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link ProductBundleImpl}
   */
  @Test
  public void testNewProductBundleImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    ProductBundleImpl actualProductBundleImpl = new ProductBundleImpl();

    // Assert
    Money bundleItemsRetailPrice = actualProductBundleImpl.getBundleItemsRetailPrice();
    Currency currency = bundleItemsRetailPrice.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    FieldEntity fieldEntityType = actualProductBundleImpl.getFieldEntityType();
    List<String> allLookupTypes = fieldEntityType.getAllLookupTypes();
    assertEquals(1, allLookupTypes.size());
    assertEquals("PRODUCT", allLookupTypes.get(0));
    assertEquals("PRODUCT", fieldEntityType.getType());
    assertEquals("Product", fieldEntityType.getFriendlyType());
    assertEquals("£", currency.getSymbol());
    assertEquals('N', actualProductBundleImpl.archiveStatus.getArchived().charValue());
    assertEquals('N', actualProductBundleImpl.getArchived().charValue());
    assertNull(actualProductBundleImpl.getId());
    assertNull(actualProductBundleImpl.getCanonicalUrl());
    assertNull(actualProductBundleImpl.getDisplayTemplate());
    assertNull(actualProductBundleImpl.getGeneratedUrl());
    assertNull(actualProductBundleImpl.getLocation());
    assertNull(actualProductBundleImpl.getManufacturer());
    assertNull(actualProductBundleImpl.getMetaDescription());
    assertNull(actualProductBundleImpl.getMetaTitle());
    assertNull(actualProductBundleImpl.getModel());
    assertNull(actualProductBundleImpl.getPromoMessage());
    assertNull(actualProductBundleImpl.getUrl());
    assertNull(actualProductBundleImpl.pricingModel);
    assertNull(actualProductBundleImpl.url);
    assertNull(actualProductBundleImpl.urlKey);
    assertNull(actualProductBundleImpl.getRetailPrice());
    assertNull(actualProductBundleImpl.getSalePrice());
    assertNull(actualProductBundleImpl.getPrice());
    assertNull(actualProductBundleImpl.getRetailPriceInternal());
    assertNull(actualProductBundleImpl.getSalePriceInternal());
    assertNull(actualProductBundleImpl.getCategory());
    assertNull(actualProductBundleImpl.getDefaultCategory());
    assertNull(actualProductBundleImpl.defaultCategory);
    List<Sku> allSellableSkus = actualProductBundleImpl.getAllSellableSkus();
    assertEquals(1, allSellableSkus.size());
    assertNull(allSellableSkus.get(0));
    assertNull(actualProductBundleImpl.getDefaultSku());
    assertNull(actualProductBundleImpl.getPricingModel());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    assertEquals(99, actualProductBundleImpl.getPriority().intValue());
    assertFalse(actualProductBundleImpl.getAutoBundle());
    assertFalse(actualProductBundleImpl.getBundlePromotable());
    assertFalse(actualProductBundleImpl.getItemsPromotable());
    assertFalse(actualProductBundleImpl.isOnSale());
    assertFalse(actualProductBundleImpl.getCanSellWithoutOptions());
    assertFalse(actualProductBundleImpl.getOverrideGeneratedUrl());
    assertFalse(actualProductBundleImpl.hasRetailPrice());
    assertFalse(actualProductBundleImpl.autoBundle);
    assertFalse(actualProductBundleImpl.bundlePromotable);
    assertFalse(actualProductBundleImpl.itemsPromotable);
    assertFalse(actualProductBundleImpl.canSellWithoutOptions);
    assertFalse(actualProductBundleImpl.isFeaturedProduct);
    assertFalse(actualProductBundleImpl.overrideGeneratedUrl);
    assertTrue(actualProductBundleImpl.getSkuBundleItems().isEmpty());
    assertTrue(actualProductBundleImpl.getAdditionalSkus().isEmpty());
    assertTrue(actualProductBundleImpl.getAllParentCategories().isEmpty());
    assertTrue(actualProductBundleImpl.getAllParentCategoryIds().isEmpty());
    assertTrue(actualProductBundleImpl.getAllParentCategoryXrefs().isEmpty());
    List<RelatedProduct> crossSaleProducts = actualProductBundleImpl.getCrossSaleProducts();
    assertTrue(crossSaleProducts.isEmpty());
    List<RelatedProduct> cumulativeUpSaleProducts = actualProductBundleImpl.getCumulativeUpSaleProducts();
    assertTrue(cumulativeUpSaleProducts.isEmpty());
    assertTrue(actualProductBundleImpl.getParentCategoryHierarchyIds().isEmpty());
    assertTrue(actualProductBundleImpl.getProductOptionXrefs().isEmpty());
    assertTrue(actualProductBundleImpl.getProductOptions().isEmpty());
    assertTrue(actualProductBundleImpl.getSkus().isEmpty());
    assertTrue(fieldEntityType.getAdditionalLookupTypes().isEmpty());
    assertTrue(actualProductBundleImpl.productAttributes.isEmpty());
    assertTrue(actualProductBundleImpl.productOptions.isEmpty());
    assertTrue(actualProductBundleImpl.skus.isEmpty());
    assertTrue(actualProductBundleImpl.getMultiValueProductAttributes().isEmpty());
    assertTrue(actualProductBundleImpl.getProductAttributes().isEmpty());
    Map<String, Set<String>> productOptionValuesMap = actualProductBundleImpl.getProductOptionValuesMap();
    assertTrue(productOptionValuesMap.isEmpty());
    BigDecimal expectedPotentialSavings = new BigDecimal("0.00");
    BigDecimal potentialSavings = actualProductBundleImpl.getPotentialSavings();
    assertEquals(expectedPotentialSavings, potentialSavings);
    assertEquals(bundleItemsRetailPrice, bundleItemsRetailPrice.abs());
    assertEquals(bundleItemsRetailPrice, bundleItemsRetailPrice.zero());
    assertEquals(allSellableSkus, actualProductBundleImpl.getAllSkus());
    assertSame(bundleItemsRetailPrice, actualProductBundleImpl.getBundleItemsSalePrice());
    assertSame(potentialSavings, bundleItemsRetailPrice.getAmount());
    assertSame(crossSaleProducts, actualProductBundleImpl.getCumulativeCrossSaleProducts());
    assertSame(cumulativeUpSaleProducts, actualProductBundleImpl.getUpSaleProducts());
    assertSame(productOptionValuesMap, actualProductBundleImpl.productOptionMap);
  }
}

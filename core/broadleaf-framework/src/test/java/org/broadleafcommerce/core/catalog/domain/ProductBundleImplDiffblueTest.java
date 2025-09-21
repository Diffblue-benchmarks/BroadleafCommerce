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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.core.catalog.service.type.ProductBundlePricingModelType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductBundleImplDiffblueTest {
  @Autowired private ProductBundleImpl productBundleImpl;

  /**
   * Test {@link ProductBundleImpl#isOnSale()}.
   *
   * <ul>
   *   <li>Given {@link ProductBundleImpl}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleImpl#isOnSale()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductBundleImpl.isOnSale()"})
  public void testIsOnSale_givenProductBundleImpl() {
    // Arrange, Act and Assert
    assertFalse(productBundleImpl.isOnSale());
  }

  /**
   * Test {@link ProductBundleImpl#isOnSale()}.
   *
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor) PricingModel is {@link
   *       ProductBundlePricingModelType#ITEM_SUM}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleImpl#isOnSale()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductBundleImpl.isOnSale()"})
  public void testIsOnSale_givenProductBundleImplPricingModelIsItem_sum() {
    // Arrange
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setPricingModel(ProductBundlePricingModelType.ITEM_SUM);

    // Act and Assert
    assertFalse(productBundleImpl.isOnSale());
  }

  /**
   * Test {@link ProductBundleImpl#isOnSale()}.
   *
   * <ul>
   *   <li>Given {@link ProductBundlePricingModelType} {@link
   *       ProductBundlePricingModelType#getType()} return {@code BUNDLE}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleImpl#isOnSale()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductBundleImpl.isOnSale()"})
  public void testIsOnSale_givenProductBundlePricingModelTypeGetTypeReturnBundle() {
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
   * Test {@link ProductBundleImpl#isOnSale()}.
   *
   * <ul>
   *   <li>Given {@link ProductBundlePricingModelType} {@link
   *       ProductBundlePricingModelType#getType()} return {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleImpl#isOnSale()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductBundleImpl.isOnSale()"})
  public void testIsOnSale_givenProductBundlePricingModelTypeGetTypeReturnType() {
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
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default
   *       constructor).
   *   <li>Then calls {@link ProductBundlePricingModelType#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleImpl#isOnSale()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductBundleImpl.isOnSale()"})
  public void testIsOnSale_givenSkuImplProductIsProductBundleImpl_thenCallsGetType() {
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
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default
   *       constructor).
   *   <li>Then calls {@link ProductBundlePricingModelType#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleImpl#isOnSale()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductBundleImpl.isOnSale()"})
  public void testIsOnSale_givenSkuImplProductIsProductBundleImpl_thenCallsGetType2() {
    // Arrange
    ProductBundlePricingModelType pricingModel = mock(ProductBundlePricingModelType.class);
    when(pricingModel.getType()).thenReturn("BUNDLE");

    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setProduct(new ProductBundleImpl());
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
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) RetailPrice is {@link Money#Money()}.
   *   <li>Then calls {@link ProductBundlePricingModelType#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleImpl#isOnSale()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductBundleImpl.isOnSale()"})
  public void testIsOnSale_givenSkuImplRetailPriceIsMoney_thenCallsGetType() {
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
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is {@link Money#Money(double)} with
   *       amount is ten.
   *   <li>Then calls {@link ProductBundlePricingModelType#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleImpl#isOnSale()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductBundleImpl.isOnSale()"})
  public void testIsOnSale_givenSkuImplSalePriceIsMoneyWithAmountIsTen_thenCallsGetType() {
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
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is {@link Money#Money()}.
   *   <li>Then calls {@link ProductBundlePricingModelType#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleImpl#isOnSale()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductBundleImpl.isOnSale()"})
  public void testIsOnSale_givenSkuImplSalePriceIsMoney_thenCallsGetType() {
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
   * Test {@link ProductBundleImpl#getPricingModel()}.
   *
   * <p>Method under test: {@link ProductBundleImpl#getPricingModel()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProductBundlePricingModelType ProductBundleImpl.getPricingModel()"})
  public void testGetPricingModel() {
    // Arrange, Act and Assert
    assertNull(productBundleImpl.getPricingModel());
  }

  /**
   * Test {@link ProductBundleImpl#setPricingModel(ProductBundlePricingModelType)}.
   *
   * <ul>
   *   <li>When {@link ProductBundlePricingModelType#BUNDLE}.
   *   <li>Then {@link ProductBundleImpl} {@link ProductBundleImpl#pricingModel} is {@code BUNDLE}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleImpl#setPricingModel(ProductBundlePricingModelType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProductBundleImpl.setPricingModel(ProductBundlePricingModelType)"})
  public void testSetPricingModel_whenBundle_thenProductBundleImplPricingModelIsBundle() {
    // Arrange and Act
    productBundleImpl.setPricingModel(ProductBundlePricingModelType.BUNDLE);

    // Assert
    assertEquals("BUNDLE", productBundleImpl.pricingModel);
    assertEquals(new BigDecimal("0.00"), productBundleImpl.getBundleItemsRetailPrice().getAmount());
    assertSame(ProductBundlePricingModelType.BUNDLE, productBundleImpl.getPricingModel());
  }

  /**
   * Test {@link ProductBundleImpl#setPricingModel(ProductBundlePricingModelType)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link ProductBundleImpl} {@link ProductBundleImpl#pricingModel} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleImpl#setPricingModel(ProductBundlePricingModelType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProductBundleImpl.setPricingModel(ProductBundlePricingModelType)"})
  public void testSetPricingModel_whenNull_thenProductBundleImplPricingModelIsNull() {
    // Arrange and Act
    productBundleImpl.setPricingModel(null);

    // Assert that nothing has changed
    assertNull(productBundleImpl.pricingModel);
    assertNull(productBundleImpl.getPricingModel());
  }

  /**
   * Test {@link ProductBundleImpl#getRetailPrice()}.
   *
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor) PricingModel is {@link
   *       ProductBundlePricingModelType#ITEM_SUM}.
   *   <li>Then return {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleImpl#getRetailPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money ProductBundleImpl.getRetailPrice()"})
  public void testGetRetailPrice_givenProductBundleImplPricingModelIsItem_sum_thenReturnZero() {
    // Arrange
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setPricingModel(ProductBundlePricingModelType.ITEM_SUM);

    // Act and Assert
    assertSame(Money.ZERO, productBundleImpl.getRetailPrice());
  }

  /**
   * Test {@link ProductBundleImpl#getRetailPrice()}.
   *
   * <ul>
   *   <li>Given {@link ProductBundleImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleImpl#getRetailPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money ProductBundleImpl.getRetailPrice()"})
  public void testGetRetailPrice_givenProductBundleImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(productBundleImpl.getRetailPrice());
  }

  /**
   * Test {@link ProductBundleImpl#getRetailPrice()}.
   *
   * <ul>
   *   <li>Given {@link ProductBundlePricingModelType} {@link
   *       ProductBundlePricingModelType#getType()} return {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleImpl#getRetailPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money ProductBundleImpl.getRetailPrice()"})
  public void testGetRetailPrice_givenProductBundlePricingModelTypeGetTypeReturnType() {
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
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default
   *       constructor).
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleImpl#getRetailPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money ProductBundleImpl.getRetailPrice()"})
  public void testGetRetailPrice_givenSkuImplProductIsProductBundleImpl_thenReturnMoney() {
    // Arrange
    ProductBundlePricingModelType pricingModel = mock(ProductBundlePricingModelType.class);
    when(pricingModel.getType()).thenReturn("BUNDLE");

    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setProduct(new ProductBundleImpl());
    Money retailPrice = new Money();
    defaultSku.setRetailPrice(retailPrice);

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setDefaultSku(defaultSku);
    productBundleImpl.setPricingModel(pricingModel);

    // Act
    Money actualRetailPrice = productBundleImpl.getRetailPrice();

    // Assert
    verify(pricingModel).getType();
    assertEquals(retailPrice, actualRetailPrice);
  }

  /**
   * Test {@link ProductBundleImpl#getRetailPrice()}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default
   *       constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleImpl#getRetailPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money ProductBundleImpl.getRetailPrice()"})
  public void testGetRetailPrice_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
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
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) RetailPrice is {@link Money#Money()}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleImpl#getRetailPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money ProductBundleImpl.getRetailPrice()"})
  public void testGetRetailPrice_givenSkuImplRetailPriceIsMoney_thenReturnMoney() {
    // Arrange
    ProductBundlePricingModelType pricingModel = mock(ProductBundlePricingModelType.class);
    when(pricingModel.getType()).thenReturn("BUNDLE");

    SkuImpl defaultSku = new SkuImpl();
    Money retailPrice = new Money();
    defaultSku.setRetailPrice(retailPrice);

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setDefaultSku(defaultSku);
    productBundleImpl.setPricingModel(pricingModel);

    // Act
    Money actualRetailPrice = productBundleImpl.getRetailPrice();

    // Assert
    verify(pricingModel).getType();
    assertEquals(retailPrice, actualRetailPrice);
  }

  /**
   * Test {@link ProductBundleImpl#getRetailPrice()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleImpl#getRetailPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money ProductBundleImpl.getRetailPrice()"})
  public void testGetRetailPrice_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    ProductBundlePricingModelType pricingModel = mock(ProductBundlePricingModelType.class);
    when(pricingModel.getType()).thenReturn("BUNDLE");

    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setCurrency(currency);
    defaultSku.setRetailPrice(new Money());

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setDefaultSku(defaultSku);
    productBundleImpl.setPricingModel(pricingModel);

    // Act
    Money actualRetailPrice = productBundleImpl.getRetailPrice();

    // Assert
    verify(currency).getCurrencyCode();
    verify(pricingModel).getType();
    Currency currency2 = actualRetailPrice.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
  }

  /**
   * Test {@link ProductBundleImpl#getRetailPrice()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleImpl#getRetailPrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money ProductBundleImpl.getRetailPrice()"})
  public void testGetRetailPrice_thenReturnNull() {
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
   *
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor) PricingModel is {@link
   *       ProductBundlePricingModelType#ITEM_SUM}.
   *   <li>Then return {@link Money#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleImpl#getSalePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money ProductBundleImpl.getSalePrice()"})
  public void testGetSalePrice_givenProductBundleImplPricingModelIsItem_sum_thenReturnZero() {
    // Arrange
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setPricingModel(ProductBundlePricingModelType.ITEM_SUM);

    // Act and Assert
    assertSame(Money.ZERO, productBundleImpl.getSalePrice());
  }

  /**
   * Test {@link ProductBundleImpl#getSalePrice()}.
   *
   * <ul>
   *   <li>Given {@link ProductBundleImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleImpl#getSalePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money ProductBundleImpl.getSalePrice()"})
  public void testGetSalePrice_givenProductBundleImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(productBundleImpl.getSalePrice());
  }

  /**
   * Test {@link ProductBundleImpl#getSalePrice()}.
   *
   * <ul>
   *   <li>Given {@link ProductBundlePricingModelType} {@link
   *       ProductBundlePricingModelType#getType()} return {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleImpl#getSalePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money ProductBundleImpl.getSalePrice()"})
  public void testGetSalePrice_givenProductBundlePricingModelTypeGetTypeReturnType() {
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
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default
   *       constructor).
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleImpl#getSalePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money ProductBundleImpl.getSalePrice()"})
  public void testGetSalePrice_givenSkuImplProductIsProductBundleImpl_thenReturnMoney() {
    // Arrange
    ProductBundlePricingModelType pricingModel = mock(ProductBundlePricingModelType.class);
    when(pricingModel.getType()).thenReturn("BUNDLE");

    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setProduct(new ProductBundleImpl());
    Money salePrice = new Money();
    defaultSku.setSalePrice(salePrice);

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setDefaultSku(defaultSku);
    productBundleImpl.setPricingModel(pricingModel);

    // Act
    Money actualSalePrice = productBundleImpl.getSalePrice();

    // Assert
    verify(pricingModel).getType();
    assertEquals(salePrice, actualSalePrice);
  }

  /**
   * Test {@link ProductBundleImpl#getSalePrice()}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default
   *       constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleImpl#getSalePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money ProductBundleImpl.getSalePrice()"})
  public void testGetSalePrice_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
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
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is {@link Money#Money()}.
   *   <li>Then return {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleImpl#getSalePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money ProductBundleImpl.getSalePrice()"})
  public void testGetSalePrice_givenSkuImplSalePriceIsMoney_thenReturnMoney() {
    // Arrange
    ProductBundlePricingModelType pricingModel = mock(ProductBundlePricingModelType.class);
    when(pricingModel.getType()).thenReturn("BUNDLE");

    SkuImpl defaultSku = new SkuImpl();
    Money salePrice = new Money();
    defaultSku.setSalePrice(salePrice);

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setDefaultSku(defaultSku);
    productBundleImpl.setPricingModel(pricingModel);

    // Act
    Money actualSalePrice = productBundleImpl.getSalePrice();

    // Assert
    verify(pricingModel).getType();
    assertEquals(salePrice, actualSalePrice);
  }

  /**
   * Test {@link ProductBundleImpl#getSalePrice()}.
   *
   * <ul>
   *   <li>Then return Currency DisplayName is {@code British Pound}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleImpl#getSalePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money ProductBundleImpl.getSalePrice()"})
  public void testGetSalePrice_thenReturnCurrencyDisplayNameIsBritishPound() {
    // Arrange
    ProductBundlePricingModelType pricingModel = mock(ProductBundlePricingModelType.class);
    when(pricingModel.getType()).thenReturn("BUNDLE");

    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setCurrency(currency);
    defaultSku.setSalePrice(new Money());

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setDefaultSku(defaultSku);
    productBundleImpl.setPricingModel(pricingModel);

    // Act
    Money actualSalePrice = productBundleImpl.getSalePrice();

    // Assert
    verify(currency).getCurrencyCode();
    verify(pricingModel).getType();
    Currency currency2 = actualSalePrice.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(826, currency2.getNumericCode());
  }

  /**
   * Test {@link ProductBundleImpl#getSalePrice()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleImpl#getSalePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money ProductBundleImpl.getSalePrice()"})
  public void testGetSalePrice_thenReturnNull() {
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
   * Test {@link ProductBundleImpl#getBundleItemsSalePrice()}.
   *
   * <ul>
   *   <li>Given {@link Money} {@link Money#multiply(int)} return {@link Money#Money()}.
   *   <li>Then calls {@link Money#multiply(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleImpl#getBundleItemsSalePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money ProductBundleImpl.getBundleItemsSalePrice()"})
  public void testGetBundleItemsSalePrice_givenMoneyMultiplyReturnMoney_thenCallsMultiply() {
    // Arrange
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
    Money expectedBundleItemsSalePrice = new Money();

    // Act
    Money actualBundleItemsSalePrice = productBundleImpl.getBundleItemsSalePrice();

    // Assert
    verify(money).multiply(1);
    verify(skuBundleItemImpl).getQuantity();
    verify(skuBundleItemImpl, atLeast(1)).getSalePrice();
    verify(skuBundleItemImpl).setSku(isA(Sku.class));
    assertEquals(expectedBundleItemsSalePrice, actualBundleItemsSalePrice);
  }

  /**
   * Test {@link ProductBundleImpl#getBundleItemsSalePrice()}.
   *
   * <ul>
   *   <li>Given {@link SkuBundleItemImpl} {@link SkuBundleItemImpl#getSalePrice()} return {@link
   *       Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleImpl#getBundleItemsSalePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money ProductBundleImpl.getBundleItemsSalePrice()"})
  public void testGetBundleItemsSalePrice_givenSkuBundleItemImplGetSalePriceReturnMoney() {
    // Arrange
    SkuBundleItemImpl skuBundleItemImpl = mock(SkuBundleItemImpl.class);
    when(skuBundleItemImpl.getQuantity()).thenReturn(1);
    when(skuBundleItemImpl.getSalePrice()).thenReturn(new Money());
    doNothing().when(skuBundleItemImpl).setSku(Mockito.<Sku>any());
    skuBundleItemImpl.setSku(mock(Sku.class));

    ArrayList<SkuBundleItem> skuBundleItems = new ArrayList<>();
    skuBundleItems.add(skuBundleItemImpl);

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setSkuBundleItems(skuBundleItems);
    Money expectedBundleItemsSalePrice = new Money();

    // Act
    Money actualBundleItemsSalePrice = productBundleImpl.getBundleItemsSalePrice();

    // Assert
    verify(skuBundleItemImpl).getQuantity();
    verify(skuBundleItemImpl, atLeast(1)).getSalePrice();
    verify(skuBundleItemImpl).setSku(isA(Sku.class));
    assertEquals(expectedBundleItemsSalePrice, actualBundleItemsSalePrice);
  }

  /**
   * Test {@link ProductBundleImpl#getBundleItemsSalePrice()}.
   *
   * <ul>
   *   <li>Then calls {@link SkuBundleItemImpl#getRetailPrice()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleImpl#getBundleItemsSalePrice()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Money ProductBundleImpl.getBundleItemsSalePrice()"})
  public void testGetBundleItemsSalePrice_thenCallsGetRetailPrice() {
    // Arrange
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

    // Act
    Money actualBundleItemsSalePrice = productBundleImpl.getBundleItemsSalePrice();

    // Assert
    verify(skuBundleItemImpl).getQuantity();
    verify(skuBundleItemImpl).getRetailPrice();
    verify(skuBundleItemImpl).getSalePrice();
    verify(skuBundleItemImpl).setSku(isA(Sku.class));
    assertEquals(money, actualBundleItemsSalePrice);
  }

  /**
   * Test {@link ProductBundleImpl#getAutoBundle()}.
   *
   * <p>Method under test: {@link ProductBundleImpl#getAutoBundle()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ProductBundleImpl.getAutoBundle()"})
  public void testGetAutoBundle() {
    // Arrange, Act and Assert
    assertFalse(productBundleImpl.getAutoBundle());
  }

  /**
   * Test {@link ProductBundleImpl#getItemsPromotable()}.
   *
   * <ul>
   *   <li>Given {@link ProductBundleImpl} ItemsPromotable is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleImpl#getItemsPromotable()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ProductBundleImpl.getItemsPromotable()"})
  public void testGetItemsPromotable_givenProductBundleImplItemsPromotableIsNull() {
    // Arrange
    productBundleImpl.setItemsPromotable(null);

    // Act and Assert
    assertFalse(productBundleImpl.getItemsPromotable());
  }

  /**
   * Test {@link ProductBundleImpl#getItemsPromotable()}.
   *
   * <ul>
   *   <li>Given {@link ProductBundleImpl}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleImpl#getItemsPromotable()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ProductBundleImpl.getItemsPromotable()"})
  public void testGetItemsPromotable_givenProductBundleImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(productBundleImpl.getItemsPromotable());
  }

  /**
   * Test {@link ProductBundleImpl#getItemsPromotable()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleImpl#getItemsPromotable()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ProductBundleImpl.getItemsPromotable()"})
  public void testGetItemsPromotable_thenReturnTrue() {
    // Arrange
    productBundleImpl.setItemsPromotable(true);

    // Act and Assert
    assertTrue(productBundleImpl.getItemsPromotable());
  }

  /**
   * Test {@link ProductBundleImpl#getBundlePromotable()}.
   *
   * <ul>
   *   <li>Given {@link ProductBundleImpl} BundlePromotable is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleImpl#getBundlePromotable()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ProductBundleImpl.getBundlePromotable()"})
  public void testGetBundlePromotable_givenProductBundleImplBundlePromotableIsNull() {
    // Arrange
    productBundleImpl.setBundlePromotable(null);

    // Act and Assert
    assertFalse(productBundleImpl.getBundlePromotable());
  }

  /**
   * Test {@link ProductBundleImpl#getBundlePromotable()}.
   *
   * <ul>
   *   <li>Given {@link ProductBundleImpl}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleImpl#getBundlePromotable()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ProductBundleImpl.getBundlePromotable()"})
  public void testGetBundlePromotable_givenProductBundleImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(productBundleImpl.getBundlePromotable());
  }

  /**
   * Test {@link ProductBundleImpl#getBundlePromotable()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleImpl#getBundlePromotable()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ProductBundleImpl.getBundlePromotable()"})
  public void testGetBundlePromotable_thenReturnTrue() {
    // Arrange
    productBundleImpl.setBundlePromotable(true);

    // Act and Assert
    assertTrue(productBundleImpl.getBundlePromotable());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Integer ProductBundleImpl.getPriority()",
    "List ProductBundleImpl.getSkuBundleItems()",
    "void ProductBundleImpl.setAutoBundle(Boolean)",
    "void ProductBundleImpl.setBundlePromotable(Boolean)",
    "void ProductBundleImpl.setItemsPromotable(Boolean)",
    "void ProductBundleImpl.setPriority(Integer)",
    "void ProductBundleImpl.setSkuBundleItems(List)"
  })
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

    // Assert
    assertEquals(1, actualPriority.intValue());
    assertTrue(actualSkuBundleItems.isEmpty());
    assertSame(skuBundleItems, actualSkuBundleItems);
  }

  /**
   * Test {@link ProductBundleImpl#getPotentialSavings()}.
   *
   * <ul>
   *   <li>Given {@link ProductBundleImpl}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleImpl#getPotentialSavings()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal ProductBundleImpl.getPotentialSavings()"})
  public void testGetPotentialSavings_givenProductBundleImpl() {
    // Arrange and Act
    BigDecimal actualPotentialSavings = productBundleImpl.getPotentialSavings();

    // Assert
    assertEquals(new BigDecimal("0.00"), actualPotentialSavings);
  }

  /**
   * Test {@link ProductBundleImpl#getPotentialSavings()}.
   *
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor) PricingModel is {@link
   *       ProductBundlePricingModelType#BUNDLE}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleImpl#getPotentialSavings()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal ProductBundleImpl.getPotentialSavings()"})
  public void testGetPotentialSavings_givenProductBundleImplPricingModelIsBundle() {
    // Arrange
    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setSalePrice(new Money());

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setDefaultSku(defaultSku);
    productBundleImpl.setPricingModel(ProductBundlePricingModelType.BUNDLE);

    // Act
    BigDecimal actualPotentialSavings = productBundleImpl.getPotentialSavings();

    // Assert
    assertEquals(new BigDecimal("0.00"), actualPotentialSavings);
  }

  /**
   * Test {@link ProductBundleImpl#getPotentialSavings()}.
   *
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor) PricingModel is {@link
   *       ProductBundlePricingModelType#ITEM_SUM}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleImpl#getPotentialSavings()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal ProductBundleImpl.getPotentialSavings()"})
  public void testGetPotentialSavings_givenProductBundleImplPricingModelIsItem_sum() {
    // Arrange
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setPricingModel(ProductBundlePricingModelType.ITEM_SUM);

    // Act
    BigDecimal actualPotentialSavings = productBundleImpl.getPotentialSavings();

    // Assert
    assertEquals(new BigDecimal("0.00"), actualPotentialSavings);
  }

  /**
   * Test {@link ProductBundleImpl#getPotentialSavings()}.
   *
   * <ul>
   *   <li>Given {@link SkuBundleItemImpl} {@link SkuBundleItemImpl#getSalePrice()} return {@link
   *       Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleImpl#getPotentialSavings()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal ProductBundleImpl.getPotentialSavings()"})
  public void testGetPotentialSavings_givenSkuBundleItemImplGetSalePriceReturnMoney() {
    // Arrange
    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setCurrency(mock(BroadleafCurrency.class));
    defaultSku.setSalePrice(new Money());

    SkuBundleItemImpl skuBundleItemImpl = mock(SkuBundleItemImpl.class);
    when(skuBundleItemImpl.getQuantity()).thenReturn(1);
    when(skuBundleItemImpl.getSalePrice()).thenReturn(new Money());
    when(skuBundleItemImpl.getSku()).thenReturn(new SkuImpl());

    ArrayList<SkuBundleItem> skuBundleItems = new ArrayList<>();
    skuBundleItems.add(skuBundleItemImpl);

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setSkuBundleItems(skuBundleItems);
    productBundleImpl.setDefaultSku(defaultSku);
    productBundleImpl.setPricingModel(ProductBundlePricingModelType.ITEM_SUM);

    // Act
    BigDecimal actualPotentialSavings = productBundleImpl.getPotentialSavings();

    // Assert
    verify(skuBundleItemImpl).getQuantity();
    verify(skuBundleItemImpl, atLeast(1)).getSalePrice();
    verify(skuBundleItemImpl).getSku();
    assertEquals(new BigDecimal("0.00"), actualPotentialSavings);
  }

  /**
   * Test {@link ProductBundleImpl#getPotentialSavings()}.
   *
   * <ul>
   *   <li>Given {@link SkuBundleItemImpl} {@link SkuBundleItemImpl#getSalePrice()} return {@link
   *       Money}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleImpl#getPotentialSavings()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal ProductBundleImpl.getPotentialSavings()"})
  public void testGetPotentialSavings_givenSkuBundleItemImplGetSalePriceReturnMoney2() {
    // Arrange
    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setCurrency(mock(BroadleafCurrency.class));
    defaultSku.setSalePrice(new Money());

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
    productBundleImpl.setDefaultSku(defaultSku);
    productBundleImpl.setPricingModel(ProductBundlePricingModelType.ITEM_SUM);

    // Act
    BigDecimal actualPotentialSavings = productBundleImpl.getPotentialSavings();

    // Assert
    verify(money).multiply(1);
    verify(skuBundleItemImpl).getQuantity();
    verify(skuBundleItemImpl, atLeast(1)).getSalePrice();
    verify(skuBundleItemImpl).getSku();
    assertEquals(new BigDecimal("0.00"), actualPotentialSavings);
  }

  /**
   * Test {@link ProductBundleImpl#getPotentialSavings()}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleImpl#getPotentialSavings()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal ProductBundleImpl.getPotentialSavings()"})
  public void testGetPotentialSavings_givenSkuImplProductIsProductBundleImpl() {
    // Arrange
    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setProduct(new ProductBundleImpl());
    defaultSku.setSalePrice(new Money());

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setDefaultSku(defaultSku);
    productBundleImpl.setPricingModel(ProductBundlePricingModelType.BUNDLE);

    // Act
    BigDecimal actualPotentialSavings = productBundleImpl.getPotentialSavings();

    // Assert
    assertEquals(new BigDecimal("0.00"), actualPotentialSavings);
  }

  /**
   * Test {@link ProductBundleImpl#getPotentialSavings()}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) RetailPrice is {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleImpl#getPotentialSavings()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal ProductBundleImpl.getPotentialSavings()"})
  public void testGetPotentialSavings_givenSkuImplRetailPriceIsMoney() {
    // Arrange
    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setRetailPrice(new Money());

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setDefaultSku(defaultSku);
    productBundleImpl.setPricingModel(ProductBundlePricingModelType.BUNDLE);

    // Act
    BigDecimal actualPotentialSavings = productBundleImpl.getPotentialSavings();

    // Assert
    assertEquals(new BigDecimal("0.00"), actualPotentialSavings);
  }

  /**
   * Test {@link ProductBundleImpl#getPotentialSavings()}.
   *
   * <ul>
   *   <li>Then calls {@link BroadleafCurrency#getCurrencyCode()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleImpl#getPotentialSavings()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal ProductBundleImpl.getPotentialSavings()"})
  public void testGetPotentialSavings_thenCallsGetCurrencyCode() {
    // Arrange
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("USD");

    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setCurrency(currency);
    defaultSku.setSalePrice(new Money());

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setDefaultSku(defaultSku);
    productBundleImpl.setPricingModel(ProductBundlePricingModelType.BUNDLE);

    // Act
    BigDecimal actualPotentialSavings = productBundleImpl.getPotentialSavings();

    // Assert
    verify(currency, atLeast(1)).getCurrencyCode();
    assertEquals(new BigDecimal("0.00"), actualPotentialSavings);
  }

  /**
   * Test {@link ProductBundleImpl#getPotentialSavings()}.
   *
   * <ul>
   *   <li>Then calls {@link SkuBundleItemImpl#getRetailPrice()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleImpl#getPotentialSavings()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal ProductBundleImpl.getPotentialSavings()"})
  public void testGetPotentialSavings_thenCallsGetRetailPrice() {
    // Arrange
    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setCurrency(mock(BroadleafCurrency.class));
    defaultSku.setSalePrice(new Money());

    SkuBundleItemImpl skuBundleItemImpl = mock(SkuBundleItemImpl.class);
    when(skuBundleItemImpl.getQuantity()).thenReturn(1);
    when(skuBundleItemImpl.getRetailPrice()).thenReturn(new Money());
    when(skuBundleItemImpl.getSalePrice()).thenReturn(null);
    when(skuBundleItemImpl.getSku()).thenReturn(new SkuImpl());

    ArrayList<SkuBundleItem> skuBundleItems = new ArrayList<>();
    skuBundleItems.add(skuBundleItemImpl);

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setSkuBundleItems(skuBundleItems);
    productBundleImpl.setDefaultSku(defaultSku);
    productBundleImpl.setPricingModel(ProductBundlePricingModelType.ITEM_SUM);

    // Act
    BigDecimal actualPotentialSavings = productBundleImpl.getPotentialSavings();

    // Assert
    verify(skuBundleItemImpl).getQuantity();
    verify(skuBundleItemImpl).getRetailPrice();
    verify(skuBundleItemImpl).getSalePrice();
    verify(skuBundleItemImpl).getSku();
    assertEquals(new BigDecimal("0.00"), actualPotentialSavings);
  }

  /**
   * Test {@link ProductBundleImpl#getPotentialSavings()}.
   *
   * <ul>
   *   <li>Then calls {@link SkuImpl#getRetailPrice()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductBundleImpl#getPotentialSavings()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal ProductBundleImpl.getPotentialSavings()"})
  public void testGetPotentialSavings_thenCallsGetRetailPrice2() {
    // Arrange
    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setCurrency(mock(BroadleafCurrency.class));
    defaultSku.setSalePrice(new Money());

    Money money = mock(Money.class);
    when(money.multiply(anyInt())).thenReturn(new Money());

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getRetailPrice()).thenReturn(money);

    SkuBundleItemImpl skuBundleItemImpl = mock(SkuBundleItemImpl.class);
    when(skuBundleItemImpl.getQuantity()).thenReturn(1);
    when(skuBundleItemImpl.getSku()).thenReturn(skuImpl);

    ArrayList<SkuBundleItem> skuBundleItems = new ArrayList<>();
    skuBundleItems.add(skuBundleItemImpl);

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setSkuBundleItems(skuBundleItems);
    productBundleImpl.setDefaultSku(defaultSku);
    productBundleImpl.setPricingModel(
        new ProductBundlePricingModelType("currency.default", "currency.default"));

    // Act
    BigDecimal actualPotentialSavings = productBundleImpl.getPotentialSavings();

    // Assert
    verify(money).multiply(1);
    verify(skuBundleItemImpl).getQuantity();
    verify(skuBundleItemImpl).getSku();
    verify(skuImpl, atLeast(1)).getRetailPrice();
    assertEquals(new BigDecimal("0.00"), actualPotentialSavings);
  }

  /**
   * Test {@link ProductBundleImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * ProductBundleImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse ProductBundleImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("PROPAGATION", null);
    stringStringMap.put("MANUAL_DUPLICATION", "Copy Hints");

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.getCopyHints()).thenReturn(stringStringMap);
    CreateResponse<Object> createResponse = new CreateResponse<>(new ProductBundleImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<ProductBundle> actualCreateOrRetrieveCopyInstanceResult =
        productBundleImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(context).getCopyHints();
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link ProductBundleImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * ProductBundleImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse ProductBundleImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("PROPAGATION", "Copy Hints");
    stringStringMap.put("MANUAL_DUPLICATION", "Copy Hints");

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.getCopyHints()).thenReturn(stringStringMap);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<ProductBundle> actualCreateOrRetrieveCopyInstanceResult =
        productBundleImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(context, atLeast(1)).getCopyHints();
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link ProductBundleImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * ProductBundleImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse ProductBundleImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance3() throws CloneNotSupportedException {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("PROPAGATION", null);
    stringStringMap.put("MANUAL_DUPLICATION", "Copy Hints");

    CatalogImpl catalogImpl = mock(CatalogImpl.class);
    when(catalogImpl.getId()).thenReturn(1L);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.getFromCatalog()).thenReturn(new CatalogImpl());
    when(context.getToCatalog()).thenReturn(catalogImpl);
    when(context.getCopyHints()).thenReturn(stringStringMap);
    CreateResponse<Object> createResponse = new CreateResponse<>(productBundleImpl, false);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<ProductBundle> actualCreateOrRetrieveCopyInstanceResult =
        productBundleImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(context).getCopyHints();
    verify(context, atLeast(1)).getFromCatalog();
    verify(context, atLeast(1)).getToCatalog();
    verify(catalogImpl, atLeast(1)).getId();
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link ProductBundleImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * ProductBundleImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse ProductBundleImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance4() throws CloneNotSupportedException {
    // Arrange
    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("PROPAGATION", null);
    stringStringMap.put("MANUAL_DUPLICATION", "Copy Hints");

    CatalogImpl catalogImpl = mock(CatalogImpl.class);
    when(catalogImpl.getId()).thenReturn(1L);

    CatalogImpl catalogImpl2 = mock(CatalogImpl.class);
    when(catalogImpl2.getId()).thenReturn(1L);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.getFromCatalog()).thenReturn(catalogImpl2);
    when(context.getToCatalog()).thenReturn(catalogImpl);
    when(context.getCopyHints()).thenReturn(stringStringMap);
    CreateResponse<Object> createResponse = new CreateResponse<>(productBundleImpl, false);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<ProductBundle> actualCreateOrRetrieveCopyInstanceResult =
        productBundleImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(context).getCopyHints();
    verify(context, atLeast(1)).getFromCatalog();
    verify(context, atLeast(1)).getToCatalog();
    verify(catalogImpl2, atLeast(1)).getId();
    verify(catalogImpl, atLeast(1)).getId();
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link ProductBundleImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * ProductBundleImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse ProductBundleImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance5() throws CloneNotSupportedException {
    // Arrange
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setDefaultCategory(new CategoryImpl());

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("PROPAGATION", null);
    stringStringMap.put("MANUAL_DUPLICATION", "Copy Hints");

    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(new ProductBundleImpl());

    CatalogImpl catalogImpl = mock(CatalogImpl.class);
    when(catalogImpl.getId()).thenReturn(1L);

    CatalogImpl catalogImpl2 = mock(CatalogImpl.class);
    when(catalogImpl2.getId()).thenReturn(1L);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.getFromCatalog()).thenReturn(catalogImpl2);
    when(context.getToCatalog()).thenReturn(catalogImpl);
    when(context.getCopyHints()).thenReturn(stringStringMap);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    productBundleImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(createResponse, atLeast(1)).getClone();
    verify(createResponse, atLeast(1)).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(context, atLeast(1)).getCopyHints();
    verify(context, atLeast(1)).getFromCatalog();
    verify(context, atLeast(1)).getToCatalog();
    verify(catalogImpl2, atLeast(1)).getId();
    verify(catalogImpl, atLeast(1)).getId();
  }

  /**
   * Test {@link ProductBundleImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * ProductBundleImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse ProductBundleImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance6() throws CloneNotSupportedException {
    // Arrange
    SkuImpl defaultSku = mock(SkuImpl.class);
    when(defaultSku.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(new SkuImpl(), true));
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setDefaultSku(defaultSku);

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("PROPAGATION", null);
    stringStringMap.put("MANUAL_DUPLICATION", "Copy Hints");

    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(new ProductBundleImpl());

    CatalogImpl catalogImpl = mock(CatalogImpl.class);
    when(catalogImpl.getId()).thenReturn(1L);

    CatalogImpl catalogImpl2 = mock(CatalogImpl.class);
    when(catalogImpl2.getId()).thenReturn(1L);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.getFromCatalog()).thenReturn(catalogImpl2);
    when(context.getToCatalog()).thenReturn(catalogImpl);
    when(context.getCopyHints()).thenReturn(stringStringMap);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    productBundleImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(createResponse, atLeast(1)).getClone();
    verify(createResponse, atLeast(1)).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(context).getCopyHints();
    verify(context, atLeast(1)).getFromCatalog();
    verify(context, atLeast(1)).getToCatalog();
    verify(catalogImpl2, atLeast(1)).getId();
    verify(catalogImpl, atLeast(1)).getId();
    verify(defaultSku).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    verify(defaultSku).setDefaultProduct(isA(Product.class));
  }

  /**
   * Test {@link ProductBundleImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link
   * ProductBundleImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse ProductBundleImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance7() throws CloneNotSupportedException {
    // Arrange
    SkuImpl defaultSku = mock(SkuImpl.class);
    when(defaultSku.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenReturn(new CreateResponse<>(null, true));
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setDefaultSku(defaultSku);

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("PROPAGATION", null);
    stringStringMap.put("MANUAL_DUPLICATION", "Copy Hints");

    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(new ProductBundleImpl());

    CatalogImpl catalogImpl = mock(CatalogImpl.class);
    when(catalogImpl.getId()).thenReturn(1L);

    CatalogImpl catalogImpl2 = mock(CatalogImpl.class);
    when(catalogImpl2.getId()).thenReturn(1L);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.getFromCatalog()).thenReturn(catalogImpl2);
    when(context.getToCatalog()).thenReturn(catalogImpl);
    when(context.getCopyHints()).thenReturn(stringStringMap);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    productBundleImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(createResponse, atLeast(1)).getClone();
    verify(createResponse, atLeast(1)).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(context).getCopyHints();
    verify(context, atLeast(1)).getFromCatalog();
    verify(context, atLeast(1)).getToCatalog();
    verify(catalogImpl2, atLeast(1)).getId();
    verify(catalogImpl, atLeast(1)).getId();
    verify(defaultSku).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    verify(defaultSku).setDefaultProduct(isA(Product.class));
  }

  /**
   * Test {@link ProductBundleImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor) PricingModel is {@link
   *       ProductBundlePricingModelType#BUNDLE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductBundleImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse ProductBundleImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_givenProductBundleImplPricingModelIsBundle()
      throws CloneNotSupportedException {
    // Arrange
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setPricingModel(ProductBundlePricingModelType.BUNDLE);

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("PROPAGATION", null);
    stringStringMap.put("MANUAL_DUPLICATION", "Copy Hints");

    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(new ProductBundleImpl());

    CatalogImpl catalogImpl = mock(CatalogImpl.class);
    when(catalogImpl.getId()).thenReturn(1L);

    CatalogImpl catalogImpl2 = mock(CatalogImpl.class);
    when(catalogImpl2.getId()).thenReturn(1L);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.getFromCatalog()).thenReturn(catalogImpl2);
    when(context.getToCatalog()).thenReturn(catalogImpl);
    when(context.getCopyHints()).thenReturn(stringStringMap);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    productBundleImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(createResponse, atLeast(1)).getClone();
    verify(createResponse, atLeast(1)).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(context).getCopyHints();
    verify(context, atLeast(1)).getFromCatalog();
    verify(context, atLeast(1)).getToCatalog();
    verify(catalogImpl2, atLeast(1)).getId();
    verify(catalogImpl, atLeast(1)).getId();
  }

  /**
   * Test {@link ProductBundleImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Then throw {@link CloneNotSupportedException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductBundleImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse ProductBundleImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_thenThrowCloneNotSupportedException()
      throws CloneNotSupportedException {
    // Arrange
    SkuImpl defaultSku = mock(SkuImpl.class);
    when(defaultSku.createOrRetrieveCopyInstance(Mockito.<MultiTenantCopyContext>any()))
        .thenThrow(new CloneNotSupportedException());
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setDefaultSku(defaultSku);

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("PROPAGATION", null);
    stringStringMap.put("MANUAL_DUPLICATION", "Copy Hints");

    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(new ProductBundleImpl());

    CatalogImpl catalogImpl = mock(CatalogImpl.class);
    when(catalogImpl.getId()).thenReturn(1L);

    CatalogImpl catalogImpl2 = mock(CatalogImpl.class);
    when(catalogImpl2.getId()).thenReturn(1L);

    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.getFromCatalog()).thenReturn(catalogImpl2);
    when(context.getToCatalog()).thenReturn(catalogImpl);
    when(context.getCopyHints()).thenReturn(stringStringMap);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act and Assert
    assertThrows(
        CloneNotSupportedException.class,
        () -> productBundleImpl.createOrRetrieveCopyInstance(context));
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(context).getCopyHints();
    verify(context).getFromCatalog();
    verify(context).getToCatalog();
    verify(catalogImpl2).getId();
    verify(catalogImpl).getId();
    verify(defaultSku).createOrRetrieveCopyInstance(isA(MultiTenantCopyContext.class));
    verify(defaultSku).setDefaultProduct(isA(Product.class));
  }

  /**
   * Test new {@link ProductBundleImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link ProductBundleImpl}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProductBundleImpl.<init>()"})
  public void testNewProductBundleImpl() {
    // Arrange and Act
    ProductBundleImpl actualProductBundleImpl = new ProductBundleImpl();

    // Assert
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
    assertNull(actualProductBundleImpl.getDefaultSku());
    assertNull(actualProductBundleImpl.getPricingModel());
    List<Sku> allSellableSkus = actualProductBundleImpl.getAllSellableSkus();
    assertEquals(1, allSellableSkus.size());
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
    List<RelatedProduct> cumulativeUpSaleProducts =
        actualProductBundleImpl.getCumulativeUpSaleProducts();
    assertTrue(cumulativeUpSaleProducts.isEmpty());
    assertTrue(actualProductBundleImpl.getParentCategoryHierarchyIds().isEmpty());
    assertTrue(actualProductBundleImpl.getProductOptionXrefs().isEmpty());
    assertTrue(actualProductBundleImpl.getProductOptions().isEmpty());
    assertTrue(actualProductBundleImpl.getSkus().isEmpty());
    assertTrue(actualProductBundleImpl.productAttributes.isEmpty());
    assertTrue(actualProductBundleImpl.productOptions.isEmpty());
    assertTrue(actualProductBundleImpl.skus.isEmpty());
    assertTrue(actualProductBundleImpl.getMultiValueProductAttributes().isEmpty());
    assertTrue(actualProductBundleImpl.getProductAttributes().isEmpty());
    Map<String, Set<String>> productOptionValuesMap =
        actualProductBundleImpl.getProductOptionValuesMap();
    assertTrue(productOptionValuesMap.isEmpty());
    assertEquals(new BigDecimal("0.00"), actualProductBundleImpl.getPotentialSavings());
    assertEquals(allSellableSkus, actualProductBundleImpl.getAllSkus());
    assertSame(crossSaleProducts, actualProductBundleImpl.getCumulativeCrossSaleProducts());
    assertSame(cumulativeUpSaleProducts, actualProductBundleImpl.getUpSaleProducts());
    assertSame(productOptionValuesMap, actualProductBundleImpl.productOptionMap);
  }
}

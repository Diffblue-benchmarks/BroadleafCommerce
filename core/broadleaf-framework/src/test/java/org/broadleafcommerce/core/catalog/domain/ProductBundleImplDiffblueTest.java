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
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.money.Money;
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
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class ProductBundleImplDiffblueTest {
  @Autowired
  private ProductBundleImpl productBundleImpl;

  /**
   * Test {@link ProductBundleImpl#isOnSale()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor) DefaultSku is {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#isOnSale()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProductBundleImpl.isOnSale()"})
  public void testIsOnSale_givenProductBundleImplDefaultSkuIsSkuImpl_thenReturnFalse() {
    // Arrange
    ProductBundleImpl productBundleImpl2 = new ProductBundleImpl();
    productBundleImpl2.setDefaultSku(new SkuImpl());
    productBundleImpl2.setPricingModel(ProductBundlePricingModelType.BUNDLE);

    // Act and Assert
    assertFalse(productBundleImpl2.isOnSale());
  }

  /**
   * Test {@link ProductBundleImpl#isOnSale()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor) PricingModel is {@link ProductBundlePricingModelType#ITEM_SUM}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#isOnSale()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProductBundleImpl.isOnSale()"})
  public void testIsOnSale_givenProductBundleImplPricingModelIsItem_sum_thenReturnFalse() {
    // Arrange
    ProductBundleImpl productBundleImpl2 = new ProductBundleImpl();
    productBundleImpl2.setPricingModel(ProductBundlePricingModelType.ITEM_SUM);

    // Act and Assert
    assertFalse(productBundleImpl2.isOnSale());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProductBundleImpl.isOnSale()"})
  public void testIsOnSale_givenProductBundleImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new ProductBundleImpl()).isOnSale());
  }

  /**
   * Test {@link ProductBundleImpl#isOnSale()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#isOnSale()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProductBundleImpl.isOnSale()"})
  public void testIsOnSale_givenSkuImplProductIsProductBundleImpl_thenReturnFalse() {
    // Arrange
    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setProduct(new ProductBundleImpl());

    ProductBundleImpl productBundleImpl2 = new ProductBundleImpl();
    productBundleImpl2.setDefaultSku(defaultSku);
    productBundleImpl2.setPricingModel(ProductBundlePricingModelType.BUNDLE);

    // Act and Assert
    assertFalse(productBundleImpl2.isOnSale());
  }

  /**
   * Test {@link ProductBundleImpl#isOnSale()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) RetailPrice is {@link Money#Money()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#isOnSale()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProductBundleImpl.isOnSale()"})
  public void testIsOnSale_givenSkuImplRetailPriceIsMoney_thenReturnFalse() {
    // Arrange
    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setRetailPrice(new Money());

    ProductBundleImpl productBundleImpl2 = new ProductBundleImpl();
    productBundleImpl2.setDefaultSku(defaultSku);
    productBundleImpl2.setPricingModel(ProductBundlePricingModelType.BUNDLE);

    // Act and Assert
    assertFalse(productBundleImpl2.isOnSale());
  }

  /**
   * Test {@link ProductBundleImpl#isOnSale()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) RetailPrice is {@link Money#Money()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#isOnSale()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProductBundleImpl.isOnSale()"})
  public void testIsOnSale_givenSkuImplRetailPriceIsMoney_thenReturnFalse2() {
    // Arrange
    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setRetailPrice(new Money());
    defaultSku.setSalePrice(new Money(10.0d));

    ProductBundleImpl productBundleImpl2 = new ProductBundleImpl();
    productBundleImpl2.setDefaultSku(defaultSku);
    productBundleImpl2.setPricingModel(ProductBundlePricingModelType.BUNDLE);

    // Act and Assert
    assertFalse(productBundleImpl2.isOnSale());
  }

  /**
   * Test {@link ProductBundleImpl#isOnSale()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) SalePrice is {@link Money#Money()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#isOnSale()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProductBundleImpl.isOnSale()"})
  public void testIsOnSale_givenSkuImplSalePriceIsMoney_thenReturnFalse() {
    // Arrange
    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setSalePrice(new Money());

    ProductBundleImpl productBundleImpl2 = new ProductBundleImpl();
    productBundleImpl2.setDefaultSku(defaultSku);
    productBundleImpl2.setPricingModel(ProductBundlePricingModelType.BUNDLE);

    // Act and Assert
    assertFalse(productBundleImpl2.isOnSale());
  }

  /**
   * Test {@link ProductBundleImpl#getPricingModel()}.
   * <p>
   * Method under test: {@link ProductBundleImpl#getPricingModel()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProductBundlePricingModelType ProductBundleImpl.getPricingModel()"})
  public void testGetPricingModel() {
    // Arrange, Act and Assert
    assertNull((new ProductBundleImpl()).getPricingModel());
  }

  /**
   * Test {@link ProductBundleImpl#setPricingModel(ProductBundlePricingModelType)}.
   * <ul>
   *   <li>When {@link ProductBundlePricingModelType#BUNDLE}.</li>
   *   <li>Then {@link ProductBundleImpl} (default constructor) {@link ProductBundleImpl#pricingModel} is {@code BUNDLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#setPricingModel(ProductBundlePricingModelType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProductBundleImpl.setPricingModel(ProductBundlePricingModelType)"})
  public void testSetPricingModel_whenBundle_thenProductBundleImplPricingModelIsBundle() {
    // Arrange
    ProductBundleImpl productBundleImpl2 = new ProductBundleImpl();
    ProductBundlePricingModelType pricingModel = ProductBundlePricingModelType.BUNDLE;

    // Act
    productBundleImpl2.setPricingModel(pricingModel);

    // Assert
    assertEquals("BUNDLE", productBundleImpl2.pricingModel);
    BigDecimal expectedAmount = new BigDecimal("0.00");
    assertEquals(expectedAmount, productBundleImpl2.getBundleItemsRetailPrice().getAmount());
    ProductBundlePricingModelType expectedPricingModel = pricingModel.BUNDLE;
    assertSame(expectedPricingModel, productBundleImpl2.getPricingModel());
  }

  /**
   * Test {@link ProductBundleImpl#setPricingModel(ProductBundlePricingModelType)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link ProductBundleImpl} (default constructor) {@link ProductBundleImpl#pricingModel} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#setPricingModel(ProductBundlePricingModelType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProductBundleImpl.setPricingModel(ProductBundlePricingModelType)"})
  public void testSetPricingModel_whenNull_thenProductBundleImplPricingModelIsNull() {
    // Arrange
    ProductBundleImpl productBundleImpl2 = new ProductBundleImpl();

    // Act
    productBundleImpl2.setPricingModel(null);

    // Assert that nothing has changed
    assertNull(productBundleImpl2.pricingModel);
    assertNull(productBundleImpl2.getPricingModel());
  }

  /**
   * Test {@link ProductBundleImpl#getRetailPrice()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor) DefaultSku is {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getRetailPrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money ProductBundleImpl.getRetailPrice()"})
  public void testGetRetailPrice_givenProductBundleImplDefaultSkuIsSkuImpl_thenReturnNull() {
    // Arrange
    ProductBundleImpl productBundleImpl2 = new ProductBundleImpl();
    productBundleImpl2.setDefaultSku(new SkuImpl());
    productBundleImpl2.setPricingModel(ProductBundlePricingModelType.BUNDLE);

    // Act and Assert
    assertNull(productBundleImpl2.getRetailPrice());
  }

  /**
   * Test {@link ProductBundleImpl#getRetailPrice()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor) PricingModel is {@link ProductBundlePricingModelType#ITEM_SUM}.</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getRetailPrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money ProductBundleImpl.getRetailPrice()"})
  public void testGetRetailPrice_givenProductBundleImplPricingModelIsItem_sum_thenReturnZero() {
    // Arrange
    ProductBundleImpl productBundleImpl2 = new ProductBundleImpl();
    productBundleImpl2.setPricingModel(ProductBundlePricingModelType.ITEM_SUM);

    // Act
    Money actualRetailPrice = productBundleImpl2.getRetailPrice();

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money ProductBundleImpl.getRetailPrice()"})
  public void testGetRetailPrice_givenProductBundleImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new ProductBundleImpl()).getRetailPrice());
  }

  /**
   * Test {@link ProductBundleImpl#getRetailPrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getRetailPrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money ProductBundleImpl.getRetailPrice()"})
  public void testGetRetailPrice_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    // Arrange
    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setProduct(new ProductBundleImpl());

    ProductBundleImpl productBundleImpl2 = new ProductBundleImpl();
    productBundleImpl2.setDefaultSku(defaultSku);
    productBundleImpl2.setPricingModel(ProductBundlePricingModelType.BUNDLE);

    // Act and Assert
    assertNull(productBundleImpl2.getRetailPrice());
  }

  /**
   * Test {@link ProductBundleImpl#getSalePrice()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor) DefaultSku is {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getSalePrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money ProductBundleImpl.getSalePrice()"})
  public void testGetSalePrice_givenProductBundleImplDefaultSkuIsSkuImpl_thenReturnNull() {
    // Arrange
    ProductBundleImpl productBundleImpl2 = new ProductBundleImpl();
    productBundleImpl2.setDefaultSku(new SkuImpl());
    productBundleImpl2.setPricingModel(ProductBundlePricingModelType.BUNDLE);

    // Act and Assert
    assertNull(productBundleImpl2.getSalePrice());
  }

  /**
   * Test {@link ProductBundleImpl#getSalePrice()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor) PricingModel is {@link ProductBundlePricingModelType#ITEM_SUM}.</li>
   *   <li>Then return {@link Money#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getSalePrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money ProductBundleImpl.getSalePrice()"})
  public void testGetSalePrice_givenProductBundleImplPricingModelIsItem_sum_thenReturnZero() {
    // Arrange
    ProductBundleImpl productBundleImpl2 = new ProductBundleImpl();
    productBundleImpl2.setPricingModel(ProductBundlePricingModelType.ITEM_SUM);

    // Act
    Money actualSalePrice = productBundleImpl2.getSalePrice();

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money ProductBundleImpl.getSalePrice()"})
  public void testGetSalePrice_givenProductBundleImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new ProductBundleImpl()).getSalePrice());
  }

  /**
   * Test {@link ProductBundleImpl#getSalePrice()}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor) Product is {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getSalePrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money ProductBundleImpl.getSalePrice()"})
  public void testGetSalePrice_givenSkuImplProductIsProductBundleImpl_thenReturnNull() {
    // Arrange
    SkuImpl defaultSku = new SkuImpl();
    defaultSku.setProduct(new ProductBundleImpl());

    ProductBundleImpl productBundleImpl2 = new ProductBundleImpl();
    productBundleImpl2.setDefaultSku(defaultSku);
    productBundleImpl2.setPricingModel(ProductBundlePricingModelType.BUNDLE);

    // Act and Assert
    assertNull(productBundleImpl2.getSalePrice());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money ProductBundleImpl.getBundleItemsRetailPrice()"})
  public void testGetBundleItemsRetailPrice_givenProductBundleImpl_thenReturnZero() {
    // Arrange and Act
    Money actualBundleItemsRetailPrice = (new ProductBundleImpl()).getBundleItemsRetailPrice();

    // Assert
    assertSame(actualBundleItemsRetailPrice.ZERO, actualBundleItemsRetailPrice);
  }

  /**
   * Test {@link ProductBundleImpl#getBundleItemsSalePrice()}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#multiply(int)} return {@link Money#Money()}.</li>
   *   <li>Then calls {@link Money#multiply(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getBundleItemsSalePrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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

    ProductBundleImpl productBundleImpl2 = new ProductBundleImpl();
    productBundleImpl2.setSkuBundleItems(skuBundleItems);
    Money expectedBundleItemsSalePrice = new Money();

    // Act
    Money actualBundleItemsSalePrice = productBundleImpl2.getBundleItemsSalePrice();

    // Assert
    verify(money).multiply(eq(1));
    verify(skuBundleItemImpl).getQuantity();
    verify(skuBundleItemImpl, atLeast(1)).getSalePrice();
    verify(skuBundleItemImpl).setSku(isA(Sku.class));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Money ProductBundleImpl.getBundleItemsSalePrice()"})
  public void testGetBundleItemsSalePrice_givenProductBundleImpl_thenReturnZero() {
    // Arrange and Act
    Money actualBundleItemsSalePrice = (new ProductBundleImpl()).getBundleItemsSalePrice();

    // Assert
    assertSame(actualBundleItemsSalePrice.ZERO, actualBundleItemsSalePrice);
  }

  /**
   * Test {@link ProductBundleImpl#getBundleItemsSalePrice()}.
   * <ul>
   *   <li>Given {@link SkuBundleItemImpl} {@link SkuBundleItemImpl#getSalePrice()} return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getBundleItemsSalePrice()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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

    ProductBundleImpl productBundleImpl2 = new ProductBundleImpl();
    productBundleImpl2.setSkuBundleItems(skuBundleItems);
    Money expectedBundleItemsSalePrice = new Money();

    // Act
    Money actualBundleItemsSalePrice = productBundleImpl2.getBundleItemsSalePrice();

    // Assert
    verify(skuBundleItemImpl).getQuantity();
    verify(skuBundleItemImpl, atLeast(1)).getSalePrice();
    verify(skuBundleItemImpl).setSku(isA(Sku.class));
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
  @Category(MaintainedByDiffblue.class)
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

    ProductBundleImpl productBundleImpl2 = new ProductBundleImpl();
    productBundleImpl2.setSkuBundleItems(skuBundleItems);

    // Act
    Money actualBundleItemsSalePrice = productBundleImpl2.getBundleItemsSalePrice();

    // Assert
    verify(skuBundleItemImpl).getQuantity();
    verify(skuBundleItemImpl).getRetailPrice();
    verify(skuBundleItemImpl).getSalePrice();
    verify(skuBundleItemImpl).setSku(isA(Sku.class));
    assertEquals(money, actualBundleItemsSalePrice);
  }

  /**
   * Test {@link ProductBundleImpl#getAutoBundle()}.
   * <p>
   * Method under test: {@link ProductBundleImpl#getAutoBundle()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean ProductBundleImpl.getAutoBundle()"})
  public void testGetAutoBundle() {
    // Arrange, Act and Assert
    assertFalse((new ProductBundleImpl()).getAutoBundle());
  }

  /**
   * Test {@link ProductBundleImpl#getItemsPromotable()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor) ItemsPromotable is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getItemsPromotable()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean ProductBundleImpl.getItemsPromotable()"})
  public void testGetItemsPromotable_givenProductBundleImplItemsPromotableIsNull() {
    // Arrange
    ProductBundleImpl productBundleImpl2 = new ProductBundleImpl();
    productBundleImpl2.setItemsPromotable(null);

    // Act and Assert
    assertFalse(productBundleImpl2.getItemsPromotable());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean ProductBundleImpl.getItemsPromotable()"})
  public void testGetItemsPromotable_givenProductBundleImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new ProductBundleImpl()).getItemsPromotable());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean ProductBundleImpl.getItemsPromotable()"})
  public void testGetItemsPromotable_thenReturnTrue() {
    // Arrange
    ProductBundleImpl productBundleImpl2 = new ProductBundleImpl();
    productBundleImpl2.setItemsPromotable(true);

    // Act and Assert
    assertTrue(productBundleImpl2.getItemsPromotable());
  }

  /**
   * Test {@link ProductBundleImpl#getBundlePromotable()}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor) BundlePromotable is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getBundlePromotable()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean ProductBundleImpl.getBundlePromotable()"})
  public void testGetBundlePromotable_givenProductBundleImplBundlePromotableIsNull() {
    // Arrange
    ProductBundleImpl productBundleImpl2 = new ProductBundleImpl();
    productBundleImpl2.setBundlePromotable(null);

    // Act and Assert
    assertFalse(productBundleImpl2.getBundlePromotable());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean ProductBundleImpl.getBundlePromotable()"})
  public void testGetBundlePromotable_givenProductBundleImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new ProductBundleImpl()).getBundlePromotable());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean ProductBundleImpl.getBundlePromotable()"})
  public void testGetBundlePromotable_thenReturnTrue() {
    // Arrange
    ProductBundleImpl productBundleImpl2 = new ProductBundleImpl();
    productBundleImpl2.setBundlePromotable(true);

    // Act and Assert
    assertTrue(productBundleImpl2.getBundlePromotable());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer ProductBundleImpl.getPriority()", "List ProductBundleImpl.getSkuBundleItems()",
      "void ProductBundleImpl.setAutoBundle(Boolean)", "void ProductBundleImpl.setBundlePromotable(Boolean)",
      "void ProductBundleImpl.setItemsPromotable(Boolean)", "void ProductBundleImpl.setPriority(Integer)",
      "void ProductBundleImpl.setSkuBundleItems(List)"})
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
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getPotentialSavings()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BigDecimal ProductBundleImpl.getPotentialSavings()"})
  public void testGetPotentialSavings_givenProductBundleImpl_thenReturnBigDecimalWith000() {
    // Arrange and Act
    BigDecimal actualPotentialSavings = (new ProductBundleImpl()).getPotentialSavings();

    // Assert
    assertEquals(new BigDecimal("0.00"), actualPotentialSavings);
  }

  /**
   * Test {@link ProductBundleImpl#getPotentialSavings()}.
   * <ul>
   *   <li>Given {@link Sku} {@link Sku#getSalePrice()} return {@link Money#Money()}.</li>
   *   <li>Then calls {@link Sku#getSalePrice()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#getPotentialSavings()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BigDecimal ProductBundleImpl.getPotentialSavings()"})
  public void testGetPotentialSavings_givenSkuGetSalePriceReturnMoney_thenCallsGetSalePrice() {
    // Arrange
    Sku defaultSku = mock(Sku.class);
    when(defaultSku.getSalePrice()).thenReturn(new Money());
    doNothing().when(defaultSku).setDefaultProduct(Mockito.<Product>any());

    ProductBundleImpl productBundleImpl2 = new ProductBundleImpl();
    productBundleImpl2.setDefaultSku(defaultSku);
    productBundleImpl2.setPricingModel(ProductBundlePricingModelType.BUNDLE);

    // Act
    BigDecimal actualPotentialSavings = productBundleImpl2.getPotentialSavings();

    // Assert
    verify(defaultSku, atLeast(1)).getSalePrice();
    verify(defaultSku).setDefaultProduct(isA(Product.class));
    assertEquals(new BigDecimal("0.00"), actualPotentialSavings);
  }

  /**
   * Test {@link ProductBundleImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test: {@link ProductBundleImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse ProductBundleImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    ProductBundleImpl productBundleImpl2 = new ProductBundleImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.getCopyHints()).thenReturn(new HashMap<>());
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<ProductBundle> actualCreateOrRetrieveCopyInstanceResult = productBundleImpl2
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(context).getCopyHints();
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link ProductBundleImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code PROPAGATION} is {@code PROPAGATION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundleImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse ProductBundleImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance_givenHashMapPropagationIsPropagation()
      throws CloneNotSupportedException {
    // Arrange
    ProductBundleImpl productBundleImpl2 = new ProductBundleImpl();

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("PROPAGATION", "PROPAGATION");
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.getCopyHints()).thenReturn(stringStringMap);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<ProductBundle> actualCreateOrRetrieveCopyInstanceResult = productBundleImpl2
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(context, atLeast(1)).getCopyHints();
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test new {@link ProductBundleImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link ProductBundleImpl}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    List<RelatedProduct> cumulativeUpSaleProducts = actualProductBundleImpl.getCumulativeUpSaleProducts();
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
    Map<String, Set<String>> productOptionValuesMap = actualProductBundleImpl.getProductOptionValuesMap();
    assertTrue(productOptionValuesMap.isEmpty());
    BigDecimal expectedPotentialSavings = new BigDecimal("0.00");
    assertEquals(expectedPotentialSavings, actualProductBundleImpl.getPotentialSavings());
    assertEquals(allSellableSkus, actualProductBundleImpl.getAllSkus());
    assertSame(crossSaleProducts, actualProductBundleImpl.getCumulativeCrossSaleProducts());
    assertSame(cumulativeUpSaleProducts, actualProductBundleImpl.getUpSaleProducts());
    assertSame(productOptionValuesMap, actualProductBundleImpl.productOptionMap);
  }
}

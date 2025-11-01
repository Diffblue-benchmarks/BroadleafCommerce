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
   * Method under test: {@link ProductBundleImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ProductBundleImpl()).isOnSale());
  }

  /**
   * Method under test: {@link ProductBundleImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setPricingModel(ProductBundlePricingModelType.ITEM_SUM);

    // Act and Assert
    assertFalse(productBundleImpl.isOnSale());
  }

  /**
   * Method under test: {@link ProductBundleImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale3() {
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
   * Method under test: {@link ProductBundleImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale4() {
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
   * Method under test: {@link ProductBundleImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale5() {
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
   * Method under test: {@link ProductBundleImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale6() {
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
   * Method under test: {@link ProductBundleImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale7() {
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
   * Method under test: {@link ProductBundleImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale8() {
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
   * Method under test: {@link ProductBundleImpl#isOnSale()}
   */
  @Test
  public void testIsOnSale9() {
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
   * Method under test: {@link ProductBundleImpl#getPricingModel()}
   */
  @Test
  public void testGetPricingModel() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ProductBundleImpl()).getPricingModel());
  }

  /**
   * Method under test:
   * {@link ProductBundleImpl#setPricingModel(ProductBundlePricingModelType)}
   */
  @Test
  public void testSetPricingModel() {
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
    assertEquals(expectedAmount, bundleItemsRetailPrice.getAmount());
    assertEquals(bundleItemsRetailPrice, bundleItemsRetailPrice.abs());
    assertEquals(bundleItemsRetailPrice, bundleItemsRetailPrice.zero());
    ProductBundlePricingModelType expectedPricingModel = pricingModel.BUNDLE;
    assertSame(expectedPricingModel, productBundleImpl.getPricingModel());
  }

  /**
   * Method under test:
   * {@link ProductBundleImpl#setPricingModel(ProductBundlePricingModelType)}
   */
  @Test
  public void testSetPricingModel2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();

    // Act
    productBundleImpl.setPricingModel(null);

    // Assert
    assertNull(productBundleImpl.pricingModel);
    assertNull(productBundleImpl.getPricingModel());
    Money bundleItemsRetailPrice = productBundleImpl.getBundleItemsRetailPrice();
    assertEquals(bundleItemsRetailPrice, bundleItemsRetailPrice.abs());
    assertEquals(bundleItemsRetailPrice, bundleItemsRetailPrice.zero());
  }

  /**
   * Method under test: {@link ProductBundleImpl#getRetailPrice()}
   */
  @Test
  public void testGetRetailPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ProductBundleImpl()).getRetailPrice());
  }

  /**
   * Method under test: {@link ProductBundleImpl#getRetailPrice()}
   */
  @Test
  public void testGetRetailPrice2() {
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
   * Method under test: {@link ProductBundleImpl#getRetailPrice()}
   */
  @Test
  public void testGetRetailPrice3() {
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
   * Method under test: {@link ProductBundleImpl#getRetailPrice()}
   */
  @Test
  public void testGetRetailPrice4() {
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
   * Method under test: {@link ProductBundleImpl#getSalePrice()}
   */
  @Test
  public void testGetSalePrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new ProductBundleImpl()).getSalePrice());
  }

  /**
   * Method under test: {@link ProductBundleImpl#getSalePrice()}
   */
  @Test
  public void testGetSalePrice2() {
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
   * Method under test: {@link ProductBundleImpl#getSalePrice()}
   */
  @Test
  public void testGetSalePrice3() {
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
   * Method under test: {@link ProductBundleImpl#getSalePrice()}
   */
  @Test
  public void testGetSalePrice4() {
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
   * Method under test: {@link ProductBundleImpl#clearDynamicPrices()}
   */
  @Test
  public void testClearDynamicPrices() {
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
   * Method under test: {@link ProductBundleImpl#clearDynamicPrices()}
   */
  @Test
  public void testClearDynamicPrices2() {
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
   * Method under test: {@link ProductBundleImpl#getAutoBundle()}
   */
  @Test
  public void testGetAutoBundle() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ProductBundleImpl()).getAutoBundle());
  }

  /**
   * Method under test: {@link ProductBundleImpl#getAutoBundle()}
   */
  @Test
  public void testGetAutoBundle2() {
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
   * Method under test: {@link ProductBundleImpl#getItemsPromotable()}
   */
  @Test
  public void testGetItemsPromotable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ProductBundleImpl()).getItemsPromotable());
  }

  /**
   * Method under test: {@link ProductBundleImpl#getItemsPromotable()}
   */
  @Test
  public void testGetItemsPromotable2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setItemsPromotable(true);

    // Act and Assert
    assertTrue(productBundleImpl.getItemsPromotable());
  }

  /**
   * Method under test: {@link ProductBundleImpl#getItemsPromotable()}
   */
  @Test
  public void testGetItemsPromotable3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setItemsPromotable(null);

    // Act and Assert
    assertFalse(productBundleImpl.getItemsPromotable());
  }

  /**
   * Method under test: {@link ProductBundleImpl#getItemsPromotable()}
   */
  @Test
  public void testGetItemsPromotable4() {
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
   * Method under test: {@link ProductBundleImpl#getBundlePromotable()}
   */
  @Test
  public void testGetBundlePromotable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ProductBundleImpl()).getBundlePromotable());
  }

  /**
   * Method under test: {@link ProductBundleImpl#getBundlePromotable()}
   */
  @Test
  public void testGetBundlePromotable2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setBundlePromotable(true);

    // Act and Assert
    assertTrue(productBundleImpl.getBundlePromotable());
  }

  /**
   * Method under test: {@link ProductBundleImpl#getBundlePromotable()}
   */
  @Test
  public void testGetBundlePromotable3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductBundleImpl productBundleImpl = new ProductBundleImpl();
    productBundleImpl.setBundlePromotable(null);

    // Act and Assert
    assertFalse(productBundleImpl.getBundlePromotable());
  }

  /**
   * Method under test: {@link ProductBundleImpl#getBundlePromotable()}
   */
  @Test
  public void testGetBundlePromotable4() {
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
   * Method under test: {@link ProductBundleImpl#getPotentialSavings()}
   */
  @Test
  public void testGetPotentialSavings() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    BigDecimal actualPotentialSavings = (new ProductBundleImpl()).getPotentialSavings();

    // Assert
    assertEquals(new BigDecimal("0.00"), actualPotentialSavings);
  }

  /**
   * Method under test: {@link ProductBundleImpl#getPotentialSavings()}
   */
  @Test
  public void testGetPotentialSavings2() {
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
   * Method under test: {@link ProductBundleImpl#getPotentialSavings()}
   */
  @Test
  public void testGetPotentialSavings3() {
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
   * Method under test: {@link ProductBundleImpl#getPotentialSavings()}
   */
  @Test
  public void testGetPotentialSavings4() {
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
   * Method under test: {@link ProductBundleImpl#getPotentialSavings()}
   */
  @Test
  public void testGetPotentialSavings5() {
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
   * Method under test: {@link ProductBundleImpl#getPotentialSavings()}
   */
  @Test
  public void testGetPotentialSavings6() {
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
   * Method under test: {@link ProductBundleImpl#getPotentialSavings()}
   */
  @Test
  public void testGetPotentialSavings7() {
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
   * Method under test:
   * {@link ProductBundleImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
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
    assertEquals("$", currency.getSymbol());
    FieldEntity fieldEntityType = actualProductBundleImpl.getFieldEntityType();
    List<String> allLookupTypes = fieldEntityType.getAllLookupTypes();
    assertEquals(1, allLookupTypes.size());
    assertEquals("PRODUCT", allLookupTypes.get(0));
    assertEquals("PRODUCT", fieldEntityType.getType());
    assertEquals("Product", fieldEntityType.getFriendlyType());
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.toString());
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
    List<Sku> allSkus = actualProductBundleImpl.getAllSkus();
    assertEquals(1, allSkus.size());
    assertNull(allSkus.get(0));
    assertNull(actualProductBundleImpl.getDefaultSku());
    assertNull(actualProductBundleImpl.getPricingModel());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(840, currency.getNumericCode());
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
    assertSame(bundleItemsRetailPrice, actualProductBundleImpl.getBundleItemsSalePrice());
    assertSame(potentialSavings, bundleItemsRetailPrice.getAmount());
    assertSame(crossSaleProducts, actualProductBundleImpl.getCumulativeCrossSaleProducts());
    assertSame(cumulativeUpSaleProducts, actualProductBundleImpl.getUpSaleProducts());
    assertSame(productOptionValuesMap, actualProductBundleImpl.productOptionMap);
  }
}

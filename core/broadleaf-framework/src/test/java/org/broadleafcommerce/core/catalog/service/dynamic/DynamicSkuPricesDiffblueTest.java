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
import static org.junit.Assert.assertTrue;
import org.broadleafcommerce.common.money.Money;
import org.junit.Test;

public class DynamicSkuPricesDiffblueTest {
  /**
   * Method under test: {@link DynamicSkuPrices#getPriceForQuantity(long)}
   */
  @Test
  public void testGetPriceForQuantity() {
    // Arrange, Act and Assert
    assertNull((new DynamicSkuPrices()).getPriceForQuantity(1L));
  }

  /**
   * Method under test: {@link DynamicSkuPrices#getPriceForQuantity(long)}
   */
  @Test
  public void testGetPriceForQuantity2() {
    // Arrange
    DynamicSkuPrices dynamicSkuPrices = new DynamicSkuPrices();
    dynamicSkuPrices.setDidOverride(true);
    dynamicSkuPrices.setPriceAdjustment(new Money());
    Money salePrice = new Money();
    dynamicSkuPrices.setSalePrice(salePrice);
    dynamicSkuPrices.setRetailPrice(null);

    // Act and Assert
    assertSame(salePrice, dynamicSkuPrices.getPriceForQuantity(1L));
  }

  /**
   * Method under test: {@link DynamicSkuPrices#getPriceForQuantity(long)}
   */
  @Test
  public void testGetPriceForQuantity3() {
    // Arrange
    DynamicSkuPrices dynamicSkuPrices = new DynamicSkuPrices();
    dynamicSkuPrices.setDidOverride(true);
    dynamicSkuPrices.setPriceAdjustment(new Money());
    Money salePrice = new Money();
    dynamicSkuPrices.setSalePrice(salePrice);
    dynamicSkuPrices.setRetailPrice(new Money());

    // Act and Assert
    assertSame(salePrice, dynamicSkuPrices.getPriceForQuantity(1L));
  }

  /**
   * Method under test: {@link DynamicSkuPrices#getPriceForQuantity(long)}
   */
  @Test
  public void testGetPriceForQuantity4() {
    // Arrange
    DynamicSkuPrices dynamicSkuPrices = new DynamicSkuPrices();
    dynamicSkuPrices.setDidOverride(true);
    dynamicSkuPrices.setPriceAdjustment(new Money());
    dynamicSkuPrices.setSalePrice(new Money(10.0d));
    Money retailPrice = new Money();
    dynamicSkuPrices.setRetailPrice(retailPrice);

    // Act and Assert
    assertSame(retailPrice, dynamicSkuPrices.getPriceForQuantity(1L));
  }

  /**
   * Method under test: {@link DynamicSkuPrices#getPrice()}
   */
  @Test
  public void testGetPrice() {
    // Arrange, Act and Assert
    assertNull((new DynamicSkuPrices()).getPrice());
  }

  /**
   * Method under test: {@link DynamicSkuPrices#getPrice()}
   */
  @Test
  public void testGetPrice2() {
    // Arrange
    DynamicSkuPrices dynamicSkuPrices = new DynamicSkuPrices();
    dynamicSkuPrices.setDidOverride(true);
    dynamicSkuPrices.setPriceAdjustment(new Money());
    Money salePrice = new Money();
    dynamicSkuPrices.setSalePrice(salePrice);
    dynamicSkuPrices.setRetailPrice(null);

    // Act and Assert
    assertSame(salePrice, dynamicSkuPrices.getPrice());
  }

  /**
   * Method under test: {@link DynamicSkuPrices#getPrice()}
   */
  @Test
  public void testGetPrice3() {
    // Arrange
    DynamicSkuPrices dynamicSkuPrices = new DynamicSkuPrices();
    dynamicSkuPrices.setDidOverride(true);
    dynamicSkuPrices.setPriceAdjustment(new Money());
    Money salePrice = new Money();
    dynamicSkuPrices.setSalePrice(salePrice);
    dynamicSkuPrices.setRetailPrice(new Money());

    // Act and Assert
    assertSame(salePrice, dynamicSkuPrices.getPrice());
  }

  /**
   * Method under test: {@link DynamicSkuPrices#getPrice()}
   */
  @Test
  public void testGetPrice4() {
    // Arrange
    DynamicSkuPrices dynamicSkuPrices = new DynamicSkuPrices();
    dynamicSkuPrices.setDidOverride(true);
    dynamicSkuPrices.setPriceAdjustment(new Money());
    dynamicSkuPrices.setSalePrice(new Money(10.0d));
    Money retailPrice = new Money();
    dynamicSkuPrices.setRetailPrice(retailPrice);

    // Act and Assert
    assertSame(retailPrice, dynamicSkuPrices.getPrice());
  }

  /**
   * Method under test: {@link DynamicSkuPrices#getDidOverride()}
   */
  @Test
  public void testGetDidOverride() {
    // Arrange, Act and Assert
    assertFalse((new DynamicSkuPrices()).getDidOverride());
  }

  /**
   * Method under test: {@link DynamicSkuPrices#getDidOverride()}
   */
  @Test
  public void testGetDidOverride2() {
    // Arrange
    DynamicSkuPrices dynamicSkuPrices = new DynamicSkuPrices();
    dynamicSkuPrices.setPriceAdjustment(new Money());
    dynamicSkuPrices.setRetailPrice(new Money());
    dynamicSkuPrices.setSalePrice(new Money());
    dynamicSkuPrices.setDidOverride(true);

    // Act and Assert
    assertTrue(dynamicSkuPrices.getDidOverride());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DynamicSkuPrices}
   *   <li>{@link DynamicSkuPrices#setDidOverride(Boolean)}
   *   <li>{@link DynamicSkuPrices#setPriceAdjustment(Money)}
   *   <li>{@link DynamicSkuPrices#setRetailPrice(Money)}
   *   <li>{@link DynamicSkuPrices#setSalePrice(Money)}
   *   <li>{@link DynamicSkuPrices#getPriceAdjustment()}
   *   <li>{@link DynamicSkuPrices#getRetailPrice()}
   *   <li>{@link DynamicSkuPrices#getSalePrice()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    DynamicSkuPrices actualDynamicSkuPrices = new DynamicSkuPrices();
    actualDynamicSkuPrices.setDidOverride(true);
    Money priceAdjustment = new Money();
    actualDynamicSkuPrices.setPriceAdjustment(priceAdjustment);
    Money retailPrice = new Money();
    actualDynamicSkuPrices.setRetailPrice(retailPrice);
    Money salePrice = new Money();
    actualDynamicSkuPrices.setSalePrice(salePrice);
    Money actualPriceAdjustment = actualDynamicSkuPrices.getPriceAdjustment();
    Money actualRetailPrice = actualDynamicSkuPrices.getRetailPrice();

    // Assert that nothing has changed
    assertSame(priceAdjustment, actualPriceAdjustment);
    assertSame(retailPrice, actualRetailPrice);
    assertSame(salePrice, actualDynamicSkuPrices.getSalePrice());
  }
}

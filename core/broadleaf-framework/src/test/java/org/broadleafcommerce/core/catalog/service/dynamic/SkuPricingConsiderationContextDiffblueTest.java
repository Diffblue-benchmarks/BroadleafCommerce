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
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.sql.Date;
import java.util.Map;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.junit.Test;

public class SkuPricingConsiderationContextDiffblueTest {
  /**
   * Method under test:
   * {@link SkuPricingConsiderationContext#getSkuPricingConsiderationContext()}
   */
  @Test
  public void testGetSkuPricingConsiderationContext() {
    // Arrange, Act and Assert
    assertNull(SkuPricingConsiderationContext.getSkuPricingConsiderationContext());
  }

  /**
   * Method under test:
   * {@link SkuPricingConsiderationContext#getSkuPricingService()}
   */
  @Test
  public void testGetSkuPricingService() {
    // Arrange, Act and Assert
    assertNull(SkuPricingConsiderationContext.getSkuPricingService());
  }

  /**
   * Method under test:
   * {@link SkuPricingConsiderationContext#isPricingConsiderationActive()}
   */
  @Test
  public void testIsPricingConsiderationActive() {
    // Arrange, Act and Assert
    assertFalse(SkuPricingConsiderationContext.isPricingConsiderationActive());
  }

  /**
   * Method under test: {@link SkuPricingConsiderationContext#hasDynamicPricing()}
   */
  @Test
  public void testHasDynamicPricing() {
    // Arrange, Act and Assert
    assertFalse(SkuPricingConsiderationContext.hasDynamicPricing());
  }

  /**
   * Method under test: {@link SkuPricingConsiderationContext#getThreadCache()}
   */
  @Test
  public void testGetThreadCache() {
    // Arrange and Act
    Map<Long, DynamicSkuPrices> actualThreadCache = SkuPricingConsiderationContext.getThreadCache();

    // Assert
    assertTrue(actualThreadCache.isEmpty());
  }

  /**
   * Method under test:
   * {@link SkuPricingConsiderationContext#getDynamicSkuPrices(Sku)}
   */
  @Test
  public void testGetDynamicSkuPrices() {
    // Arrange, Act and Assert
    assertNull(SkuPricingConsiderationContext.getDynamicSkuPrices(new SkuImpl()));
  }

  /**
   * Method under test:
   * {@link SkuPricingConsiderationContext#getDynamicSkuPrices(Sku)}
   */
  @Test
  public void testGetDynamicSkuPrices2() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    sku.setSalePrice(new Money());

    // Act and Assert
    assertNull(SkuPricingConsiderationContext.getDynamicSkuPrices(sku));
  }

  /**
   * Method under test:
   * {@link SkuPricingConsiderationContext#getDynamicSkuPrices(Sku)}
   */
  @Test
  public void testGetDynamicSkuPrices3() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    sku.setActiveStartDate(mock(Date.class));

    // Act and Assert
    assertNull(SkuPricingConsiderationContext.getDynamicSkuPrices(sku));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link SkuPricingConsiderationContext}
   */
  @Test
  public void testNewSkuPricingConsiderationContext() {
    // Arrange and Act
    SkuPricingConsiderationContext actualSkuPricingConsiderationContext = new SkuPricingConsiderationContext();

    // Assert
    assertNull(actualSkuPricingConsiderationContext.considerations);
    assertNull(actualSkuPricingConsiderationContext.pricingService);
    assertFalse(actualSkuPricingConsiderationContext.isActive);
    assertTrue(actualSkuPricingConsiderationContext.pricesBySku.isEmpty());
  }
}

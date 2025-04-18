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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SkuPricingConsiderationContextDiffblueTest {
  /**
   * Test {@link SkuPricingConsiderationContext#getSkuPricingConsiderationContext()}.
   * <p>
   * Method under test: {@link SkuPricingConsiderationContext#getSkuPricingConsiderationContext()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.HashMap SkuPricingConsiderationContext.getSkuPricingConsiderationContext()"})
  public void testGetSkuPricingConsiderationContext() {
    // Arrange, Act and Assert
    assertNull(SkuPricingConsiderationContext.getSkuPricingConsiderationContext());
  }

  /**
   * Test {@link SkuPricingConsiderationContext#getSkuPricingService()}.
   * <p>
   * Method under test: {@link SkuPricingConsiderationContext#getSkuPricingService()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.core.catalog.service.dynamic.DynamicSkuPricingService SkuPricingConsiderationContext.getSkuPricingService()"})
  public void testGetSkuPricingService() {
    // Arrange, Act and Assert
    assertNull(SkuPricingConsiderationContext.getSkuPricingService());
  }

  /**
   * Test {@link SkuPricingConsiderationContext#isPricingConsiderationActive()}.
   * <p>
   * Method under test: {@link SkuPricingConsiderationContext#isPricingConsiderationActive()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuPricingConsiderationContext.isPricingConsiderationActive()"})
  public void testIsPricingConsiderationActive() {
    // Arrange, Act and Assert
    assertFalse(SkuPricingConsiderationContext.isPricingConsiderationActive());
  }

  /**
   * Test {@link SkuPricingConsiderationContext#hasDynamicPricing()}.
   * <p>
   * Method under test: {@link SkuPricingConsiderationContext#hasDynamicPricing()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SkuPricingConsiderationContext.hasDynamicPricing()"})
  public void testHasDynamicPricing() {
    // Arrange, Act and Assert
    assertFalse(SkuPricingConsiderationContext.hasDynamicPricing());
  }

  /**
   * Test {@link SkuPricingConsiderationContext#getThreadCache()}.
   * <p>
   * Method under test: {@link SkuPricingConsiderationContext#getThreadCache()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map SkuPricingConsiderationContext.getThreadCache()"})
  public void testGetThreadCache() {
    // Arrange and Act
    Map<Long, DynamicSkuPrices> actualThreadCache = SkuPricingConsiderationContext.getThreadCache();

    // Assert
    assertTrue(actualThreadCache.isEmpty());
  }

  /**
   * Test {@link SkuPricingConsiderationContext#getDynamicSkuPrices(Sku)}.
   * <ul>
   *   <li>Given {@link Money#Money()}.</li>
   *   <li>When {@link SkuImpl} (default constructor) SalePrice is {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuPricingConsiderationContext#getDynamicSkuPrices(Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DynamicSkuPrices SkuPricingConsiderationContext.getDynamicSkuPrices(Sku)"})
  public void testGetDynamicSkuPrices_givenMoney_whenSkuImplSalePriceIsMoney() {
    // Arrange
    SkuImpl sku = new SkuImpl();
    sku.setSalePrice(new Money());

    // Act and Assert
    assertNull(SkuPricingConsiderationContext.getDynamicSkuPrices(sku));
  }

  /**
   * Test {@link SkuPricingConsiderationContext#getDynamicSkuPrices(Sku)}.
   * <ul>
   *   <li>When {@link SkuImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuPricingConsiderationContext#getDynamicSkuPrices(Sku)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DynamicSkuPrices SkuPricingConsiderationContext.getDynamicSkuPrices(Sku)"})
  public void testGetDynamicSkuPrices_whenSkuImpl() {
    // Arrange, Act and Assert
    assertNull(SkuPricingConsiderationContext.getDynamicSkuPrices(new SkuImpl()));
  }

  /**
   * Test new {@link SkuPricingConsiderationContext} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link SkuPricingConsiderationContext}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SkuPricingConsiderationContext.<init>()"})
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

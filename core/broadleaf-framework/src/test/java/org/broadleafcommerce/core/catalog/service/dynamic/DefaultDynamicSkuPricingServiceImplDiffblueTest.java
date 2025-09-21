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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.ProductOptionImpl;
import org.broadleafcommerce.core.catalog.domain.ProductOptionValueImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuBundleItem;
import org.broadleafcommerce.core.catalog.domain.SkuBundleItemImpl;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.catalog.domain.pricing.SkuPriceWrapper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {DefaultDynamicSkuPricingServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultDynamicSkuPricingServiceImplDiffblueTest {
  @Autowired private DefaultDynamicSkuPricingServiceImpl defaultDynamicSkuPricingServiceImpl;

  /**
   * Test {@link DefaultDynamicSkuPricingServiceImpl#getSkuPrices(Sku, HashMap)} with {@code sku},
   * {@code skuPricingConsiderations}.
   *
   * <ul>
   *   <li>Then return {@link DynamicSkuPrices#didOverride} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultDynamicSkuPricingServiceImpl#getSkuPrices(Sku, HashMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DynamicSkuPrices DefaultDynamicSkuPricingServiceImpl.getSkuPrices(Sku, HashMap)"
  })
  public void testGetSkuPricesWithSkuSkuPricingConsiderations_thenReturnDidOverrideIsNull() {
    // Arrange
    SkuImpl sku = new SkuImpl();

    // Act
    DynamicSkuPrices actualSkuPrices =
        defaultDynamicSkuPricingServiceImpl.getSkuPrices(sku, new HashMap());

    // Assert
    assertNull(actualSkuPrices.didOverride);
    assertNull(actualSkuPrices.getPrice());
    assertNull(actualSkuPrices.getPriceAdjustment());
    assertNull(actualSkuPrices.getRetailPrice());
    assertNull(actualSkuPrices.getSalePrice());
    assertFalse(actualSkuPrices.getDidOverride());
  }

  /**
   * Test {@link DefaultDynamicSkuPricingServiceImpl#getSkuPrices(SkuPriceWrapper, HashMap)} with
   * {@code skuWrapper}, {@code skuPricingConsiderations}.
   *
   * <p>Method under test: {@link DefaultDynamicSkuPricingServiceImpl#getSkuPrices(SkuPriceWrapper,
   * HashMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DynamicSkuPrices DefaultDynamicSkuPricingServiceImpl.getSkuPrices(SkuPriceWrapper, HashMap)"
  })
  public void testGetSkuPricesWithSkuWrapperSkuPricingConsiderations() {
    // Arrange
    SkuPriceWrapper skuWrapper = new SkuPriceWrapper();

    // Act
    DynamicSkuPrices actualSkuPrices =
        defaultDynamicSkuPricingServiceImpl.getSkuPrices(skuWrapper, new HashMap());

    // Assert
    assertNull(actualSkuPrices.didOverride);
    assertNull(actualSkuPrices.getPrice());
    assertNull(actualSkuPrices.getPriceAdjustment());
    assertNull(actualSkuPrices.getRetailPrice());
    assertNull(actualSkuPrices.getSalePrice());
    assertFalse(actualSkuPrices.getDidOverride());
  }

  /**
   * Test {@link DefaultDynamicSkuPricingServiceImpl#getSkuBundleItemPrice(SkuBundleItem, HashMap)}.
   *
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).
   *   <li>Then return {@link DynamicSkuPrices#didOverride} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultDynamicSkuPricingServiceImpl#getSkuBundleItemPrice(SkuBundleItem, HashMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DynamicSkuPrices DefaultDynamicSkuPricingServiceImpl.getSkuBundleItemPrice(SkuBundleItem, HashMap)"
  })
  public void testGetSkuBundleItemPrice_givenSkuImpl_thenReturnDidOverrideIsNull() {
    // Arrange
    SkuBundleItemImpl skuBundleItem = new SkuBundleItemImpl();
    skuBundleItem.setSku(new SkuImpl());

    // Act
    DynamicSkuPrices actualSkuBundleItemPrice =
        defaultDynamicSkuPricingServiceImpl.getSkuBundleItemPrice(skuBundleItem, new HashMap());

    // Assert
    assertNull(actualSkuBundleItemPrice.didOverride);
    assertNull(actualSkuBundleItemPrice.getPrice());
    assertNull(actualSkuBundleItemPrice.getPriceAdjustment());
    assertNull(actualSkuBundleItemPrice.getRetailPrice());
    assertNull(actualSkuBundleItemPrice.getSalePrice());
    assertFalse(actualSkuBundleItemPrice.getDidOverride());
  }

  /**
   * Test {@link DefaultDynamicSkuPricingServiceImpl#getPriceAdjustment(ProductOptionValueImpl,
   * Money, HashMap)}.
   *
   * <p>Method under test: {@link
   * DefaultDynamicSkuPricingServiceImpl#getPriceAdjustment(ProductOptionValueImpl, Money, HashMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DynamicSkuPrices DefaultDynamicSkuPricingServiceImpl.getPriceAdjustment(ProductOptionValueImpl, Money, HashMap)"
  })
  public void testGetPriceAdjustment() {
    // Arrange
    ProductOptionValueImpl productOptionValueImpl = new ProductOptionValueImpl();
    productOptionValueImpl.setAttributeValue("42");
    productOptionValueImpl.setDisplayOrder(1L);
    productOptionValueImpl.setId(1L);
    productOptionValueImpl.setPriceAdjustment(new Money());
    productOptionValueImpl.setProductOption(new ProductOptionImpl());
    Money priceAdjustment = new Money();

    // Act
    DynamicSkuPrices actualPriceAdjustment =
        defaultDynamicSkuPricingServiceImpl.getPriceAdjustment(
            productOptionValueImpl, priceAdjustment, new HashMap());

    // Assert
    assertNull(actualPriceAdjustment.didOverride);
    assertNull(actualPriceAdjustment.getPrice());
    assertNull(actualPriceAdjustment.getRetailPrice());
    assertNull(actualPriceAdjustment.getSalePrice());
    assertFalse(actualPriceAdjustment.getDidOverride());
    assertSame(priceAdjustment, actualPriceAdjustment.getPriceAdjustment());
  }
}

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
package org.broadleafcommerce.core.catalog.domain.pricing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.util.WeightUnitOfMeasureType;
import org.broadleafcommerce.core.catalog.domain.Dimension;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.catalog.domain.SkuMediaXref;
import org.broadleafcommerce.core.catalog.domain.Weight;
import org.broadleafcommerce.core.catalog.service.dynamic.DynamicSkuPrices;
import org.broadleafcommerce.core.search.domain.FieldEntity;
import org.junit.Test;

public class SkuPriceWrapperDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SkuPriceWrapper#SkuPriceWrapper(Sku)}
   *   <li>{@link SkuPriceWrapper#setTargetSku(Sku)}
   *   <li>{@link SkuPriceWrapper#getTargetSku()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SkuPriceWrapper actualSkuPriceWrapper = new SkuPriceWrapper(new SkuImpl());
    SkuImpl targetSku = new SkuImpl();
    actualSkuPriceWrapper.setTargetSku(targetSku);

    // Assert that nothing has changed
    assertSame(targetSku, actualSkuPriceWrapper.getTargetSku());
  }

  /**
   * Test {@link SkuPriceWrapper#SkuPriceWrapper()}.
   * <p>
   * Method under test: {@link SkuPriceWrapper#SkuPriceWrapper()}
   */
  @Test
  public void testNewSkuPriceWrapper() {
    // Arrange, Act and Assert
    Sku targetSku = (new SkuPriceWrapper()).getTargetSku();
    assertTrue(targetSku instanceof SkuImpl);
    Money margin = targetSku.getMargin();
    Currency currency = margin.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    Weight weight = targetSku.getWeight();
    WeightUnitOfMeasureType weightUnitOfMeasure = weight.getWeightUnitOfMeasure();
    assertEquals("Friendly Type", weightUnitOfMeasure.getFriendlyType());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    FieldEntity fieldEntityType = targetSku.getFieldEntityType();
    List<String> allLookupTypes = fieldEntityType.getAllLookupTypes();
    assertEquals(1, allLookupTypes.size());
    assertEquals("SKU", allLookupTypes.get(0));
    assertEquals("SKU", fieldEntityType.getType());
    assertEquals("Sku", fieldEntityType.getFriendlyType());
    assertEquals("£", currency.getSymbol());
    Dimension dimension = targetSku.getDimension();
    assertEquals("nullHxnullWxnullD\"", dimension.getDimensionString());
    assertNull(targetSku.getTaxable());
    assertNull(targetSku.getId());
    assertNull(weightUnitOfMeasure.getType());
    assertNull(targetSku.getDescription());
    assertNull(targetSku.getDisplayTemplate());
    assertNull(targetSku.getExternalId());
    assertNull(targetSku.getLongDescription());
    assertNull(targetSku.getName());
    assertNull(targetSku.getTaxCode());
    assertNull(targetSku.getUpc());
    assertNull(targetSku.getUrlKey());
    assertNull(dimension.getDepth());
    assertNull(dimension.getGirth());
    assertNull(dimension.getHeight());
    assertNull(dimension.getWidth());
    assertNull(weight.getWeight());
    assertNull(targetSku.getActiveEndDate());
    assertNull(targetSku.getActiveStartDate());
    assertNull(targetSku.getCurrency());
    assertNull(targetSku.getPrimarySkuMedia());
    assertNull(targetSku.getBaseRetailPrice());
    assertNull(targetSku.getBaseSalePrice());
    assertNull(targetSku.getCost());
    assertNull(targetSku.getListPrice());
    assertNull(targetSku.getPrice());
    assertNull(targetSku.getProductOptionValueAdjustments());
    assertNull(targetSku.getRetailPrice());
    assertNull(targetSku.getSalePrice());
    DynamicSkuPrices priceData = targetSku.getPriceData();
    assertNull(priceData.getPrice());
    assertNull(priceData.getPriceAdjustment());
    assertNull(priceData.getRetailPrice());
    assertNull(priceData.getSalePrice());
    assertNull(dimension.getDimensionUnitOfMeasure());
    assertNull(dimension.getContainer());
    assertNull(dimension.getSize());
    assertNull(targetSku.getDefaultProduct());
    assertNull(targetSku.getProduct());
    assertNull(targetSku.getInventoryType());
    assertNull(targetSku.getFulfillmentType());
    assertEquals(0, targetSku.getQuantityAvailable().intValue());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    assertFalse(targetSku.getIsMachineSortable());
    assertFalse(targetSku.hasRetailPrice());
    assertFalse(targetSku.hasSalePrice());
    assertFalse(((SkuImpl) targetSku).getDiscountable());
    assertFalse(priceData.getDidOverride());
    assertTrue(targetSku.getExcludedFulfillmentOptions().isEmpty());
    assertTrue(targetSku.getFees().isEmpty());
    assertTrue(targetSku.getProductOptionValues().isEmpty());
    assertTrue(fieldEntityType.getAdditionalLookupTypes().isEmpty());
    assertTrue(targetSku.getFulfillmentFlatRates().isEmpty());
    assertTrue(targetSku.getMultiValueSkuAttributes().isEmpty());
    assertTrue(targetSku.getSkuAttributes().isEmpty());
    assertTrue(targetSku.getSkuMedia().isEmpty());
    Map<String, SkuMediaXref> skuMediaXref = targetSku.getSkuMediaXref();
    assertTrue(skuMediaXref.isEmpty());
    assertTrue(targetSku.getProductOptionValueXrefs().isEmpty());
    assertTrue(targetSku.getProductOptionValuesCollection().isEmpty());
    assertTrue(targetSku.getAvailable());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    assertEquals(expectedAmount, margin.getAmount());
    assertEquals(margin, margin.abs());
    assertEquals(margin, margin.zero());
    assertSame(skuMediaXref, targetSku.getSkuMediaXrefIgnoreDefaultSku());
  }
}

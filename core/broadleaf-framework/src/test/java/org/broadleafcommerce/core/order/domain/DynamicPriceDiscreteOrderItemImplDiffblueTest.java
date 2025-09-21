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
package org.broadleafcommerce.core.order.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class DynamicPriceDiscreteOrderItemImplDiffblueTest {
  @Autowired private DynamicPriceDiscreteOrderItemImpl dynamicPriceDiscreteOrderItemImpl;

  /**
   * Test {@link DynamicPriceDiscreteOrderItemImpl#updateSaleAndRetailPrices()}.
   *
   * <p>Method under test: {@link DynamicPriceDiscreteOrderItemImpl#updateSaleAndRetailPrices()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DynamicPriceDiscreteOrderItemImpl.updateSaleAndRetailPrices()"})
  public void testUpdateSaleAndRetailPrices() {
    // Arrange, Act and Assert
    assertFalse(dynamicPriceDiscreteOrderItemImpl.updateSaleAndRetailPrices());
  }

  /**
   * Test new {@link DynamicPriceDiscreteOrderItemImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * DynamicPriceDiscreteOrderItemImpl}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DynamicPriceDiscreteOrderItemImpl.<init>()"})
  public void testNewDynamicPriceDiscreteOrderItemImpl() {
    // Arrange and Act
    DynamicPriceDiscreteOrderItemImpl actualDynamicPriceDiscreteOrderItemImpl =
        new DynamicPriceDiscreteOrderItemImpl();

    // Assert
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.discountsAllowed);
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.hasValidationError);
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.itemTaxable);
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.retailPriceOverride);
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.salePriceOverride);
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.getId());
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.orderItemType);
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.baseRetailPrice);
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.baseSalePrice);
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.price);
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.retailPrice);
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.salePrice);
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.totalTax);
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.getCartMessages());
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.getBaseRetailPrice());
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.getBaseSalePrice());
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.getAdjustmentValue());
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.getAverageAdjustmentValue());
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.getAveragePrice());
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.getPrice());
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.getRetailPrice());
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.getSalePrice());
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.getCategory());
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.category);
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.deproxiedCategory);
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.getProduct());
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.deproxiedProduct);
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.product);
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.getSku());
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.deproxiedSku);
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.sku);
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.getSkuBundleItem());
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.getBundleOrderItem());
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.getGiftWrapOrderItem());
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.giftWrapOrderItem);
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.getOrder());
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.getParentOrderItem());
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.getPersonalMessage());
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.getOrderItemType());
    assertEquals(0, actualDynamicPriceDiscreteOrderItemImpl.getQuantity());
    assertFalse(actualDynamicPriceDiscreteOrderItemImpl.getHasValidationError());
    assertFalse(actualDynamicPriceDiscreteOrderItemImpl.getIsDiscounted());
    assertFalse(actualDynamicPriceDiscreteOrderItemImpl.getIsOnSale());
    assertFalse(actualDynamicPriceDiscreteOrderItemImpl.isChildOrderItem());
    assertTrue(actualDynamicPriceDiscreteOrderItemImpl.getDiscreteOrderItemFeePrices().isEmpty());
    assertTrue(actualDynamicPriceDiscreteOrderItemImpl.getCandidateItemOffers().isEmpty());
    assertTrue(actualDynamicPriceDiscreteOrderItemImpl.getChildOrderItems().isEmpty());
    assertTrue(actualDynamicPriceDiscreteOrderItemImpl.getOrderItemAdjustments().isEmpty());
    assertTrue(actualDynamicPriceDiscreteOrderItemImpl.getOrderItemPriceDetails().isEmpty());
    assertTrue(actualDynamicPriceDiscreteOrderItemImpl.getOrderItemQualifiers().isEmpty());
    assertTrue(actualDynamicPriceDiscreteOrderItemImpl.getProratedOrderItemAdjustments().isEmpty());
    assertTrue(actualDynamicPriceDiscreteOrderItemImpl.getAdditionalAttributes().isEmpty());
    assertTrue(actualDynamicPriceDiscreteOrderItemImpl.getOrderItemAttributes().isEmpty());
  }
}

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
package org.broadleafcommerce.core.order.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.offer.domain.CandidateItemOfferImpl;
import org.junit.Test;

public class DynamicPriceDiscreteOrderItemImplDiffblueTest {
  /**
   * Test {@link DynamicPriceDiscreteOrderItemImpl#setSku(Sku)}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>Then {@link DynamicPriceDiscreteOrderItemImpl} (default constructor) Name
   * is {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicPriceDiscreteOrderItemImpl#setSku(Sku)}
   */
  @Test
  public void testSetSku_givenName_thenDynamicPriceDiscreteOrderItemImplNameIsName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicPriceDiscreteOrderItemImpl dynamicPriceDiscreteOrderItemImpl = new DynamicPriceDiscreteOrderItemImpl();
    Sku sku = mock(Sku.class);
    when(sku.getName()).thenReturn("Name");

    // Act
    dynamicPriceDiscreteOrderItemImpl.setSku(sku);

    // Assert
    verify(sku).getName();
    assertEquals("Name", dynamicPriceDiscreteOrderItemImpl.getName());
    assertEquals("Name", dynamicPriceDiscreteOrderItemImpl.getMainEntityName());
    assertFalse(dynamicPriceDiscreteOrderItemImpl.isSkuActive());
    assertSame(sku, dynamicPriceDiscreteOrderItemImpl.getSku());
    assertSame(sku, dynamicPriceDiscreteOrderItemImpl.deproxiedSku);
  }

  /**
   * Test {@link DynamicPriceDiscreteOrderItemImpl#updateSaleAndRetailPrices()}.
   * <p>
   * Method under test:
   * {@link DynamicPriceDiscreteOrderItemImpl#updateSaleAndRetailPrices()}
   */
  @Test
  public void testUpdateSaleAndRetailPrices() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicPriceDiscreteOrderItemImpl dynamicPriceDiscreteOrderItemImpl = new DynamicPriceDiscreteOrderItemImpl();
    dynamicPriceDiscreteOrderItemImpl.addCandidateItemOffer(mock(CandidateItemOfferImpl.class));

    // Act and Assert
    assertFalse(dynamicPriceDiscreteOrderItemImpl.updateSaleAndRetailPrices());
  }

  /**
   * Test {@link DynamicPriceDiscreteOrderItemImpl#updateSaleAndRetailPrices()}.
   * <ul>
   *   <li>Given {@link DynamicPriceDiscreteOrderItemImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicPriceDiscreteOrderItemImpl#updateSaleAndRetailPrices()}
   */
  @Test
  public void testUpdateSaleAndRetailPrices_givenDynamicPriceDiscreteOrderItemImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new DynamicPriceDiscreteOrderItemImpl()).updateSaleAndRetailPrices());
  }

  /**
   * Test new {@link DynamicPriceDiscreteOrderItemImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link DynamicPriceDiscreteOrderItemImpl}
   */
  @Test
  public void testNewDynamicPriceDiscreteOrderItemImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    DynamicPriceDiscreteOrderItemImpl actualDynamicPriceDiscreteOrderItemImpl = new DynamicPriceDiscreteOrderItemImpl();

    // Assert
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.discountsAllowed);
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.hasValidationError);
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.itemTaxable);
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.retailPriceOverride);
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.salePriceOverride);
    Auditable auditable = actualDynamicPriceDiscreteOrderItemImpl.getAuditable();
    assertNull(auditable.getCreatedBy());
    assertNull(auditable.getUpdatedBy());
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.getId());
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.orderItemType);
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.baseRetailPrice);
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.baseSalePrice);
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.price);
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.retailPrice);
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.salePrice);
    assertNull(actualDynamicPriceDiscreteOrderItemImpl.totalTax);
    assertNull(auditable.getDateCreated());
    assertNull(auditable.getDateUpdated());
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

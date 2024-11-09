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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.junit.Test;
import org.mockito.Mockito;

public class GiftWrapOrderItemImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GiftWrapOrderItemImpl#setWrappedItems(List)}
   *   <li>{@link GiftWrapOrderItemImpl#getWrappedItems()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    GiftWrapOrderItemImpl giftWrapOrderItemImpl = new GiftWrapOrderItemImpl();
    ArrayList<OrderItem> wrappedItems = new ArrayList<>();

    // Act
    giftWrapOrderItemImpl.setWrappedItems(wrappedItems);
    List<OrderItem> actualWrappedItems = giftWrapOrderItemImpl.getWrappedItems();

    // Assert that nothing has changed
    assertTrue(actualWrappedItems.isEmpty());
    assertSame(wrappedItems, actualWrappedItems);
  }

  /**
   * Test
   * {@link GiftWrapOrderItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link GiftWrapOrderItemImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    GiftWrapOrderItemImpl giftWrapOrderItemImpl = new GiftWrapOrderItemImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<DiscreteOrderItem> actualCreateOrRetrieveCopyInstanceResult = giftWrapOrderItemImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test new {@link GiftWrapOrderItemImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link GiftWrapOrderItemImpl}
   */
  @Test
  public void testNewGiftWrapOrderItemImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    GiftWrapOrderItemImpl actualGiftWrapOrderItemImpl = new GiftWrapOrderItemImpl();

    // Assert
    assertNull(actualGiftWrapOrderItemImpl.discountsAllowed);
    assertNull(actualGiftWrapOrderItemImpl.hasValidationError);
    assertNull(actualGiftWrapOrderItemImpl.itemTaxable);
    assertNull(actualGiftWrapOrderItemImpl.retailPriceOverride);
    assertNull(actualGiftWrapOrderItemImpl.salePriceOverride);
    Auditable auditable = actualGiftWrapOrderItemImpl.getAuditable();
    assertNull(auditable.getCreatedBy());
    assertNull(auditable.getUpdatedBy());
    assertNull(actualGiftWrapOrderItemImpl.getId());
    assertNull(actualGiftWrapOrderItemImpl.orderItemType);
    assertNull(actualGiftWrapOrderItemImpl.baseRetailPrice);
    assertNull(actualGiftWrapOrderItemImpl.baseSalePrice);
    assertNull(actualGiftWrapOrderItemImpl.price);
    assertNull(actualGiftWrapOrderItemImpl.retailPrice);
    assertNull(actualGiftWrapOrderItemImpl.salePrice);
    assertNull(actualGiftWrapOrderItemImpl.totalTax);
    assertNull(auditable.getDateCreated());
    assertNull(auditable.getDateUpdated());
    assertNull(actualGiftWrapOrderItemImpl.getCartMessages());
    assertNull(actualGiftWrapOrderItemImpl.getBaseRetailPrice());
    assertNull(actualGiftWrapOrderItemImpl.getBaseSalePrice());
    assertNull(actualGiftWrapOrderItemImpl.getAdjustmentValue());
    assertNull(actualGiftWrapOrderItemImpl.getAverageAdjustmentValue());
    assertNull(actualGiftWrapOrderItemImpl.getAveragePrice());
    assertNull(actualGiftWrapOrderItemImpl.getPrice());
    assertNull(actualGiftWrapOrderItemImpl.getCategory());
    assertNull(actualGiftWrapOrderItemImpl.category);
    assertNull(actualGiftWrapOrderItemImpl.deproxiedCategory);
    assertNull(actualGiftWrapOrderItemImpl.getProduct());
    assertNull(actualGiftWrapOrderItemImpl.deproxiedProduct);
    assertNull(actualGiftWrapOrderItemImpl.product);
    assertNull(actualGiftWrapOrderItemImpl.getSku());
    assertNull(actualGiftWrapOrderItemImpl.deproxiedSku);
    assertNull(actualGiftWrapOrderItemImpl.sku);
    assertNull(actualGiftWrapOrderItemImpl.getSkuBundleItem());
    assertNull(actualGiftWrapOrderItemImpl.getBundleOrderItem());
    assertNull(actualGiftWrapOrderItemImpl.getGiftWrapOrderItem());
    assertNull(actualGiftWrapOrderItemImpl.giftWrapOrderItem);
    assertNull(actualGiftWrapOrderItemImpl.getOrder());
    assertNull(actualGiftWrapOrderItemImpl.getParentOrderItem());
    assertNull(actualGiftWrapOrderItemImpl.getPersonalMessage());
    assertNull(actualGiftWrapOrderItemImpl.getOrderItemType());
    assertEquals(0, actualGiftWrapOrderItemImpl.getQuantity());
    assertFalse(actualGiftWrapOrderItemImpl.getHasValidationError());
    assertFalse(actualGiftWrapOrderItemImpl.getIsDiscounted());
    assertFalse(actualGiftWrapOrderItemImpl.isChildOrderItem());
    assertTrue(actualGiftWrapOrderItemImpl.getDiscreteOrderItemFeePrices().isEmpty());
    assertTrue(actualGiftWrapOrderItemImpl.getWrappedItems().isEmpty());
    assertTrue(actualGiftWrapOrderItemImpl.getCandidateItemOffers().isEmpty());
    assertTrue(actualGiftWrapOrderItemImpl.getChildOrderItems().isEmpty());
    assertTrue(actualGiftWrapOrderItemImpl.getOrderItemAdjustments().isEmpty());
    assertTrue(actualGiftWrapOrderItemImpl.getOrderItemPriceDetails().isEmpty());
    assertTrue(actualGiftWrapOrderItemImpl.getOrderItemQualifiers().isEmpty());
    assertTrue(actualGiftWrapOrderItemImpl.getProratedOrderItemAdjustments().isEmpty());
    assertTrue(actualGiftWrapOrderItemImpl.getAdditionalAttributes().isEmpty());
    assertTrue(actualGiftWrapOrderItemImpl.getOrderItemAttributes().isEmpty());
  }
}

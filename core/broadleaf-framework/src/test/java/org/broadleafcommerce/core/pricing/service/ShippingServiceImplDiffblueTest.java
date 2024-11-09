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
package org.broadleafcommerce.core.pricing.service;

import static org.junit.Assert.assertSame;
import org.broadleafcommerce.common.vendor.service.exception.FulfillmentPriceException;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.pricing.service.module.BandedShippingModule;
import org.broadleafcommerce.core.pricing.service.module.ShippingModule;
import org.junit.Test;

public class ShippingServiceImplDiffblueTest {
  /**
   * Test
   * {@link ShippingServiceImpl#calculateShippingForFulfillmentGroup(FulfillmentGroup)}.
   * <ul>
   *   <li>Then return {@link FulfillmentGroupImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ShippingServiceImpl#calculateShippingForFulfillmentGroup(FulfillmentGroup)}
   */
  @Test
  public void testCalculateShippingForFulfillmentGroup_thenReturnFulfillmentGroupImpl()
      throws FulfillmentPriceException {
    // Arrange
    ShippingServiceImpl shippingServiceImpl = new ShippingServiceImpl();
    shippingServiceImpl.setShippingModule(new BandedShippingModule());
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();

    // Act and Assert
    assertSame(fulfillmentGroup, shippingServiceImpl.calculateShippingForFulfillmentGroup(fulfillmentGroup));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ShippingServiceImpl}
   *   <li>{@link ShippingServiceImpl#setShippingModule(ShippingModule)}
   *   <li>{@link ShippingServiceImpl#getShippingModule()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ShippingServiceImpl actualShippingServiceImpl = new ShippingServiceImpl();
    BandedShippingModule shippingModule = new BandedShippingModule();
    actualShippingServiceImpl.setShippingModule(shippingModule);

    // Assert that nothing has changed
    assertSame(shippingModule, actualShippingServiceImpl.getShippingModule());
  }
}

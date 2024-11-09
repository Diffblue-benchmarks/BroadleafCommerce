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
package org.broadleafcommerce.core.order.fulfillment.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import java.math.BigDecimal;
import org.broadleafcommerce.core.order.service.type.FulfillmentBandResultAmountType;
import org.junit.Test;

public class FulfillmentPriceBandImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FulfillmentPriceBandImpl#setId(Long)}
   *   <li>{@link FulfillmentPriceBandImpl#setOption(BandedPriceFulfillmentOption)}
   *   <li>{@link FulfillmentPriceBandImpl#setRetailPriceMinimumAmount(BigDecimal)}
   *   <li>{@link FulfillmentPriceBandImpl#getId()}
   *   <li>{@link FulfillmentPriceBandImpl#getOption()}
   *   <li>{@link FulfillmentPriceBandImpl#getRetailPriceMinimumAmount()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    FulfillmentPriceBandImpl fulfillmentPriceBandImpl = new FulfillmentPriceBandImpl();

    // Act
    fulfillmentPriceBandImpl.setId(1L);
    BandedPriceFulfillmentOptionImpl option = new BandedPriceFulfillmentOptionImpl();
    fulfillmentPriceBandImpl.setOption(option);
    BigDecimal retailPriceMinimumAmount = new BigDecimal("2.3");
    fulfillmentPriceBandImpl.setRetailPriceMinimumAmount(retailPriceMinimumAmount);
    Long actualId = fulfillmentPriceBandImpl.getId();
    BandedPriceFulfillmentOption actualOption = fulfillmentPriceBandImpl.getOption();
    BigDecimal actualRetailPriceMinimumAmount = fulfillmentPriceBandImpl.getRetailPriceMinimumAmount();

    // Assert that nothing has changed
    assertEquals(1L, actualId.longValue());
    assertEquals(new BigDecimal("2.3"), actualRetailPriceMinimumAmount);
    assertSame(retailPriceMinimumAmount, actualRetailPriceMinimumAmount);
    assertSame(option, actualOption);
  }

  /**
   * Test new {@link FulfillmentPriceBandImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link FulfillmentPriceBandImpl}
   */
  @Test
  public void testNewFulfillmentPriceBandImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    FulfillmentPriceBandImpl actualFulfillmentPriceBandImpl = new FulfillmentPriceBandImpl();

    // Assert
    FulfillmentBandResultAmountType resultAmountType = actualFulfillmentPriceBandImpl.getResultAmountType();
    assertEquals("RATE", resultAmountType.getType());
    assertEquals("RATE", actualFulfillmentPriceBandImpl.resultAmountType);
    assertEquals("Rate", resultAmountType.getFriendlyType());
    assertNull(actualFulfillmentPriceBandImpl.getId());
    assertNull(actualFulfillmentPriceBandImpl.getResultAmount());
    assertNull(actualFulfillmentPriceBandImpl.getRetailPriceMinimumAmount());
    assertNull(actualFulfillmentPriceBandImpl.getOption());
  }
}

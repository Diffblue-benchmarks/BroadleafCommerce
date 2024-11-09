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
package org.broadleafcommerce.core.pricing.service.fulfillment.provider;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.FulfillmentOption;
import org.junit.Test;

public class FulfillmentEstimationResponseDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link FulfillmentEstimationResponse}
   *   <li>{@link FulfillmentEstimationResponse#setFulfillmentOptionPrices(Map)}
   *   <li>{@link FulfillmentEstimationResponse#getFulfillmentOptionPrices()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    FulfillmentEstimationResponse actualFulfillmentEstimationResponse = new FulfillmentEstimationResponse();
    HashMap<FulfillmentOption, Money> fulfillmentOptionPrices = new HashMap<>();
    actualFulfillmentEstimationResponse.setFulfillmentOptionPrices(fulfillmentOptionPrices);
    Map<? extends FulfillmentOption, Money> actualFulfillmentOptionPrices = actualFulfillmentEstimationResponse
        .getFulfillmentOptionPrices();

    // Assert that nothing has changed
    assertTrue(actualFulfillmentOptionPrices.isEmpty());
    assertSame(fulfillmentOptionPrices, actualFulfillmentOptionPrices);
  }
}

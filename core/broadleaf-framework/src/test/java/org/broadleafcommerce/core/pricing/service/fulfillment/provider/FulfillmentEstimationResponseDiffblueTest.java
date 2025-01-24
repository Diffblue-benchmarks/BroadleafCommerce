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

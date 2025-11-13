package org.broadleafcommerce.core.pricing.service.fulfillment.provider;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.FulfillmentOption;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FulfillmentEstimationResponseDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link FulfillmentEstimationResponse}
   *   <li>{@link FulfillmentEstimationResponse#setFulfillmentOptionPrices(Map)}
   *   <li>{@link FulfillmentEstimationResponse#getFulfillmentOptionPrices()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FulfillmentEstimationResponse.<init>()",
    "Map FulfillmentEstimationResponse.getFulfillmentOptionPrices()",
    "void FulfillmentEstimationResponse.setFulfillmentOptionPrices(Map)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    FulfillmentEstimationResponse actualFulfillmentEstimationResponse =
        new FulfillmentEstimationResponse();
    HashMap<FulfillmentOption, Money> fulfillmentOptionPrices = new HashMap<>();
    actualFulfillmentEstimationResponse.setFulfillmentOptionPrices(fulfillmentOptionPrices);
    Map<? extends FulfillmentOption, Money> actualFulfillmentOptionPrices =
        actualFulfillmentEstimationResponse.getFulfillmentOptionPrices();

    // Assert
    assertTrue(actualFulfillmentOptionPrices.isEmpty());
    assertSame(fulfillmentOptionPrices, actualFulfillmentOptionPrices);
  }
}

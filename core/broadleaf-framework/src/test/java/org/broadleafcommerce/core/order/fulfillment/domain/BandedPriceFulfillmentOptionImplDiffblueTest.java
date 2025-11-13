package org.broadleafcommerce.core.order.fulfillment.domain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BandedPriceFulfillmentOptionImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link BandedPriceFulfillmentOptionImpl}
   *   <li>{@link BandedPriceFulfillmentOptionImpl#setBands(List)}
   *   <li>{@link BandedPriceFulfillmentOptionImpl#getBands()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BandedPriceFulfillmentOptionImpl.<init>()",
    "List BandedPriceFulfillmentOptionImpl.getBands()",
    "void BandedPriceFulfillmentOptionImpl.setBands(List)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    BandedPriceFulfillmentOptionImpl actualBandedPriceFulfillmentOptionImpl =
        new BandedPriceFulfillmentOptionImpl();
    ArrayList<FulfillmentPriceBand> bands = new ArrayList<>();
    actualBandedPriceFulfillmentOptionImpl.setBands(bands);
    List<FulfillmentPriceBand> actualBands = actualBandedPriceFulfillmentOptionImpl.getBands();

    // Assert
    assertNull(actualBandedPriceFulfillmentOptionImpl.getId());
    assertNull(actualBandedPriceFulfillmentOptionImpl.getTaxCode());
    assertFalse(actualBandedPriceFulfillmentOptionImpl.getTaxable());
    assertTrue(actualBands.isEmpty());
    assertTrue(actualBandedPriceFulfillmentOptionImpl.getUseFlatRates());
    assertSame(bands, actualBands);
  }
}

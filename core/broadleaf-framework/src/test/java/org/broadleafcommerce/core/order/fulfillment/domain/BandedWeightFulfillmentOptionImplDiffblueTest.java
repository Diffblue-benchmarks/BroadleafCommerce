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

public class BandedWeightFulfillmentOptionImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link BandedWeightFulfillmentOptionImpl}
   *   <li>{@link BandedWeightFulfillmentOptionImpl#setBands(List)}
   *   <li>{@link BandedWeightFulfillmentOptionImpl#getBands()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BandedWeightFulfillmentOptionImpl.<init>()",
    "List BandedWeightFulfillmentOptionImpl.getBands()",
    "void BandedWeightFulfillmentOptionImpl.setBands(List)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    BandedWeightFulfillmentOptionImpl actualBandedWeightFulfillmentOptionImpl =
        new BandedWeightFulfillmentOptionImpl();
    ArrayList<FulfillmentWeightBand> bands = new ArrayList<>();
    actualBandedWeightFulfillmentOptionImpl.setBands(bands);
    List<FulfillmentWeightBand> actualBands = actualBandedWeightFulfillmentOptionImpl.getBands();

    // Assert
    assertNull(actualBandedWeightFulfillmentOptionImpl.getId());
    assertNull(actualBandedWeightFulfillmentOptionImpl.getTaxCode());
    assertFalse(actualBandedWeightFulfillmentOptionImpl.getTaxable());
    assertTrue(actualBands.isEmpty());
    assertTrue(actualBandedWeightFulfillmentOptionImpl.getUseFlatRates());
    assertSame(bands, actualBands);
  }
}

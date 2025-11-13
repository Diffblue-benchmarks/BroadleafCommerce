package org.broadleafcommerce.core.offer.service.workflow;

import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferCode;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class RecordOfferUsageActivityDiffblueTest {
  /**
   * Test {@link RecordOfferUsageActivity#saveOfferIds(Set, Map, Order)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RecordOfferUsageActivity#saveOfferIds(Set, Map, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List RecordOfferUsageActivity.saveOfferIds(Set, Map, Order)"})
  public void testSaveOfferIds_thenReturnEmpty() {
    // Arrange
    RecordOfferUsageActivity recordOfferUsageActivity =
        new RecordOfferUsageActivity(new RecordOfferUsageRollbackHandler());
    HashSet<Offer> offers = new HashSet<>();
    HashMap<Offer, OfferCode> offerToCodeMapping = new HashMap<>();

    // Act and Assert
    assertTrue(
        recordOfferUsageActivity
            .saveOfferIds(offers, offerToCodeMapping, new NullOrderImpl())
            .isEmpty());
  }
}

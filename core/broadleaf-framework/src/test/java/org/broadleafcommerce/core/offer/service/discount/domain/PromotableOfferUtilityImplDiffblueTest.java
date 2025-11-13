package org.broadleafcommerce.core.offer.service.discount.domain;

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {PromotableOfferUtilityImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PromotableOfferUtilityImplDiffblueTest {
  @Autowired private PromotableOfferUtilityImpl promotableOfferUtilityImpl;

  /**
   * Test {@link PromotableOfferUtilityImpl#determineOfferUnitValue(Offer, Integer)}.
   *
   * <ul>
   *   <li>When {@link OfferImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PromotableOfferUtilityImpl#determineOfferUnitValue(Offer,
   * Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.math.BigDecimal PromotableOfferUtilityImpl.determineOfferUnitValue(Offer, Integer)"
  })
  public void testDetermineOfferUnitValue_whenOfferImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(promotableOfferUtilityImpl.determineOfferUnitValue(new OfferImpl(), 1));
  }
}

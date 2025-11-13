package org.broadleafcommerce.core.offer.service.processor;

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

@ContextConfiguration(classes = {OfferTimeZoneProcessorImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class OfferTimeZoneProcessorImplDiffblueTest {
  @Autowired private OfferTimeZoneProcessorImpl offerTimeZoneProcessorImpl;

  /**
   * Test {@link OfferTimeZoneProcessorImpl#getTimeZone(Offer)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OfferTimeZoneProcessorImpl#getTimeZone(Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.TimeZone OfferTimeZoneProcessorImpl.getTimeZone(Offer)"})
  public void testGetTimeZone_whenNull() {
    // Arrange, Act and Assert
    assertNull(offerTimeZoneProcessorImpl.getTimeZone(null));
  }

  /**
   * Test {@link OfferTimeZoneProcessorImpl#getTimeZone(Offer)}.
   *
   * <ul>
   *   <li>When {@link OfferImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OfferTimeZoneProcessorImpl#getTimeZone(Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.TimeZone OfferTimeZoneProcessorImpl.getTimeZone(Offer)"})
  public void testGetTimeZone_whenOfferImpl() {
    // Arrange, Act and Assert
    assertNull(offerTimeZoneProcessorImpl.getTimeZone(new OfferImpl()));
  }
}

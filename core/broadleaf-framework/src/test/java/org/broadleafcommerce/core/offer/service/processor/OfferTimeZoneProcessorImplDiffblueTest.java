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
package org.broadleafcommerce.core.offer.service.processor;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.junit.Test;

public class OfferTimeZoneProcessorImplDiffblueTest {
  /**
   * Test {@link OfferTimeZoneProcessorImpl#getTimeZone(Offer)}.
   * <ul>
   *   <li>Given {@link Money#Money()}.</li>
   *   <li>When {@link OfferImpl} (default constructor) QualifyingItemSubTotal is
   * {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferTimeZoneProcessorImpl#getTimeZone(Offer)}
   */
  @Test
  public void testGetTimeZone_givenMoney_whenOfferImplQualifyingItemSubTotalIsMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferTimeZoneProcessorImpl offerTimeZoneProcessorImpl = new OfferTimeZoneProcessorImpl();

    OfferImpl offer = new OfferImpl();
    offer.setQualifyingItemSubTotal(new Money());

    // Act and Assert
    assertNull(offerTimeZoneProcessorImpl.getTimeZone(offer));
  }

  /**
   * Test {@link OfferTimeZoneProcessorImpl#getTimeZone(Offer)}.
   * <ul>
   *   <li>When {@link Offer}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferTimeZoneProcessorImpl#getTimeZone(Offer)}
   */
  @Test
  public void testGetTimeZone_whenOffer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OfferTimeZoneProcessorImpl()).getTimeZone(mock(Offer.class)));
  }

  /**
   * Test {@link OfferTimeZoneProcessorImpl#getTimeZone(Offer)}.
   * <ul>
   *   <li>When {@link OfferImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferTimeZoneProcessorImpl#getTimeZone(Offer)}
   */
  @Test
  public void testGetTimeZone_whenOfferImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferTimeZoneProcessorImpl offerTimeZoneProcessorImpl = new OfferTimeZoneProcessorImpl();

    // Act and Assert
    assertNull(offerTimeZoneProcessorImpl.getTimeZone(new OfferImpl()));
  }
}

/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.money.Money;
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
  @Autowired
  private OfferTimeZoneProcessorImpl offerTimeZoneProcessorImpl;

  /**
   * Test {@link OfferTimeZoneProcessorImpl#getTimeZone(Offer)}.
   * <ul>
   *   <li>Given {@link Money#Money()}.</li>
   *   <li>When {@link OfferImpl} (default constructor) QualifyingItemSubTotal is {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OfferTimeZoneProcessorImpl#getTimeZone(Offer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.TimeZone OfferTimeZoneProcessorImpl.getTimeZone(Offer)"})
  public void testGetTimeZone_givenMoney_whenOfferImplQualifyingItemSubTotalIsMoney() {
    // Arrange
    OfferImpl offer = new OfferImpl();
    offer.setQualifyingItemSubTotal(new Money());

    // Act and Assert
    assertNull(offerTimeZoneProcessorImpl.getTimeZone(offer));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.TimeZone OfferTimeZoneProcessorImpl.getTimeZone(Offer)"})
  public void testGetTimeZone_whenOfferImpl() {
    // Arrange, Act and Assert
    assertNull(offerTimeZoneProcessorImpl.getTimeZone(new OfferImpl()));
  }
}

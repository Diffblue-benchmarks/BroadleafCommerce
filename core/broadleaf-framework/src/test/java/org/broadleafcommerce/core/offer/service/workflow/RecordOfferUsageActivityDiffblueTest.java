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
package org.broadleafcommerce.core.offer.service.workflow;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferCode;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.junit.Test;

public class RecordOfferUsageActivityDiffblueTest {
  /**
   * Test {@link RecordOfferUsageActivity#saveOfferIds(Set, Map, Order)}.
   * <p>
   * Method under test:
   * {@link RecordOfferUsageActivity#saveOfferIds(Set, Map, Order)}
   */
  @Test
  public void testSaveOfferIds() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RecordOfferUsageActivity recordOfferUsageActivity = new RecordOfferUsageActivity(
        mock(RecordOfferUsageRollbackHandler.class));
    HashSet<Offer> offers = new HashSet<>();
    HashMap<Offer, OfferCode> offerToCodeMapping = new HashMap<>();

    // Act and Assert
    assertTrue(recordOfferUsageActivity.saveOfferIds(offers, offerToCodeMapping, new NullOrderImpl()).isEmpty());
  }

  /**
   * Test {@link RecordOfferUsageActivity#saveOfferIds(Set, Map, Order)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RecordOfferUsageActivity#saveOfferIds(Set, Map, Order)}
   */
  @Test
  public void testSaveOfferIds_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RecordOfferUsageActivity recordOfferUsageActivity = new RecordOfferUsageActivity(
        new RecordOfferUsageRollbackHandler());
    HashSet<Offer> offers = new HashSet<>();
    HashMap<Offer, OfferCode> offerToCodeMapping = new HashMap<>();

    // Act and Assert
    assertTrue(recordOfferUsageActivity.saveOfferIds(offers, offerToCodeMapping, new NullOrderImpl()).isEmpty());
  }
}

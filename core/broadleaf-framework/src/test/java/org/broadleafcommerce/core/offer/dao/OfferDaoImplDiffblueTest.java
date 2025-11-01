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
package org.broadleafcommerce.core.offer.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class OfferDaoImplDiffblueTest {
  /**
   * Method under test:
   * {@link OfferDaoImpl#getCurrentDateAfterFactoringInDateResolution()}
   */
  @Test
  public void testGetCurrentDateAfterFactoringInDateResolution() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OfferDaoImpl offerDaoImpl = new OfferDaoImpl();
    offerDaoImpl.setCurrentDateResolution(1L);

    // Act and Assert
    assertSame(offerDaoImpl.cachedDate, offerDaoImpl.getCurrentDateAfterFactoringInDateResolution());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link OfferDaoImpl#setCurrentDateResolution(Long)}
   *   <li>{@link OfferDaoImpl#getCurrentDateResolution()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    OfferDaoImpl offerDaoImpl = new OfferDaoImpl();

    // Act
    offerDaoImpl.setCurrentDateResolution(1L);

    // Assert that nothing has changed
    assertEquals(1L, offerDaoImpl.getCurrentDateResolution().longValue());
  }
}

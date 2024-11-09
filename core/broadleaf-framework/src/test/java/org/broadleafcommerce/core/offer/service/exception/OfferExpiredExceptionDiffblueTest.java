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
package org.broadleafcommerce.core.offer.service.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {OfferExpiredException.class, String.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class OfferExpiredExceptionDiffblueTest {
  @Autowired
  private OfferExpiredException offerExpiredException;

  /**
   * Test {@link OfferExpiredException#OfferExpiredException(String)}.
   * <p>
   * Method under test:
   * {@link OfferExpiredException#OfferExpiredException(String)}
   */
  @Test
  public void testNewOfferExpiredException() {
    // Arrange and Act
    OfferExpiredException actualOfferExpiredException = new OfferExpiredException("String");

    // Assert
    assertEquals("String", actualOfferExpiredException.getLocalizedMessage());
    assertEquals("String", actualOfferExpiredException.getMessage());
    assertEquals("String", actualOfferExpiredException.getRootCauseMessage());
    assertNull(actualOfferExpiredException.getCause());
    assertNull(actualOfferExpiredException.getCheckoutResponse());
    assertEquals(0, actualOfferExpiredException.getSuppressed().length);
    assertSame(actualOfferExpiredException, actualOfferExpiredException.getRootCause());
  }
}

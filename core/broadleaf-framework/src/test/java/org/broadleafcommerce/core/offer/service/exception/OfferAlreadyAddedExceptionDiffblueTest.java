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
package org.broadleafcommerce.core.offer.service.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {OfferAlreadyAddedException.class, String.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class OfferAlreadyAddedExceptionDiffblueTest {
  @Autowired private OfferAlreadyAddedException offerAlreadyAddedException;

  /**
   * Test {@link OfferAlreadyAddedException#OfferAlreadyAddedException(String)}.
   *
   * <p>Method under test: {@link OfferAlreadyAddedException#OfferAlreadyAddedException(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OfferAlreadyAddedException.<init>(String)"})
  public void testNewOfferAlreadyAddedException() {
    // Arrange and Act
    OfferAlreadyAddedException actualOfferAlreadyAddedException =
        new OfferAlreadyAddedException("String");

    // Assert
    assertEquals("String", actualOfferAlreadyAddedException.getLocalizedMessage());
    assertEquals("String", actualOfferAlreadyAddedException.getMessage());
    assertEquals("String", actualOfferAlreadyAddedException.getRootCauseMessage());
    assertNull(actualOfferAlreadyAddedException.getCause());
    assertNull(actualOfferAlreadyAddedException.getCheckoutResponse());
    assertEquals(0, actualOfferAlreadyAddedException.getSuppressed().length);
    Throwable actualRootCause = actualOfferAlreadyAddedException.getRootCause();
    assertSame(actualOfferAlreadyAddedException, actualRootCause);
  }
}

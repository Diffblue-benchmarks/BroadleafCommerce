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
package org.broadleafcommerce.core.rating.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;

public class RatingDetailImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link RatingDetailImpl}
   *   <li>{@link RatingDetailImpl#setCustomer(Customer)}
   *   <li>{@link RatingDetailImpl#setId(Long)}
   *   <li>{@link RatingDetailImpl#setRating(Double)}
   *   <li>{@link RatingDetailImpl#setRatingSubmittedDate(Date)}
   *   <li>{@link RatingDetailImpl#setRatingSummary(RatingSummary)}
   *   <li>{@link RatingDetailImpl#getCustomer()}
   *   <li>{@link RatingDetailImpl#getId()}
   *   <li>{@link RatingDetailImpl#getRating()}
   *   <li>{@link RatingDetailImpl#getRatingSubmittedDate()}
   *   <li>{@link RatingDetailImpl#getRatingSummary()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    RatingDetailImpl actualRatingDetailImpl = new RatingDetailImpl();
    CustomerImpl customer = new CustomerImpl();
    actualRatingDetailImpl.setCustomer(customer);
    actualRatingDetailImpl.setId(1L);
    actualRatingDetailImpl.setRating(10.0d);
    Date ratingSubmittedDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualRatingDetailImpl.setRatingSubmittedDate(ratingSubmittedDate);
    RatingSummaryImpl ratingSummary = new RatingSummaryImpl();
    actualRatingDetailImpl.setRatingSummary(ratingSummary);
    Customer actualCustomer = actualRatingDetailImpl.getCustomer();
    Long actualId = actualRatingDetailImpl.getId();
    Double actualRating = actualRatingDetailImpl.getRating();
    Date actualRatingSubmittedDate = actualRatingDetailImpl.getRatingSubmittedDate();
    RatingSummary actualRatingSummary = actualRatingDetailImpl.getRatingSummary();

    // Assert that nothing has changed
    assertEquals(10.0d, actualRating.doubleValue(), 0.0);
    assertEquals(1L, actualId.longValue());
    assertSame(ratingSummary, actualRatingSummary);
    assertSame(customer, actualCustomer);
    assertSame(ratingSubmittedDate, actualRatingSubmittedDate);
  }
}

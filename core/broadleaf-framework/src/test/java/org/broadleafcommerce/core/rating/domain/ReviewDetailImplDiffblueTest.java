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
package org.broadleafcommerce.core.rating.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import org.broadleafcommerce.core.rating.service.type.ReviewStatusType;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;

public class ReviewDetailImplDiffblueTest {
  /**
   * Method under test: {@link ReviewDetailImpl#getStatus()}
   */
  @Test
  public void testGetStatus() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    ReviewStatusType actualStatus = (new ReviewDetailImpl()).getStatus();

    // Assert
    assertNull(actualStatus.getFriendlyType());
    assertNull(actualStatus.getType());
  }

  /**
   * Method under test: {@link ReviewDetailImpl#getStatus()}
   */
  @Test
  public void testGetStatus2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerImpl customer = mock(CustomerImpl.class);
    Date reivewSubmittedDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    RatingDetailImpl ratingDetail = new RatingDetailImpl();

    // Act
    ReviewStatusType actualStatus = (new ReviewDetailImpl(customer, reivewSubmittedDate, ratingDetail, "Review Text",
        new RatingSummaryImpl())).getStatus();

    // Assert
    assertEquals(actualStatus.PENDING, actualStatus);
  }

  /**
   * Method under test: {@link ReviewDetailImpl#getReviewFeedback()}
   */
  @Test
  public void testGetReviewFeedback() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ReviewDetailImpl()).getReviewFeedback().isEmpty());
  }

  /**
   * Method under test: {@link ReviewDetailImpl#getReviewFeedback()}
   */
  @Test
  public void testGetReviewFeedback2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerImpl customer = new CustomerImpl();
    Date reivewSubmittedDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    RatingDetailImpl ratingDetail = new RatingDetailImpl();
    ReviewDetailImpl reviewDetailImpl = new ReviewDetailImpl(customer, reivewSubmittedDate, ratingDetail, "Review Text",
        new RatingSummaryImpl());

    // Act
    List<ReviewFeedback> actualReviewFeedback = reviewDetailImpl.getReviewFeedback();

    // Assert
    assertTrue(actualReviewFeedback.isEmpty());
    assertSame(reviewDetailImpl.reviewFeedback, actualReviewFeedback);
  }

  /**
   * Method under test: {@link ReviewDetailImpl#getReviewFeedback()}
   */
  @Test
  public void testGetReviewFeedback3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerImpl customer = mock(CustomerImpl.class);
    Date reivewSubmittedDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    RatingDetailImpl ratingDetail = new RatingDetailImpl();
    ReviewDetailImpl reviewDetailImpl = new ReviewDetailImpl(customer, reivewSubmittedDate, ratingDetail, "Review Text",
        new RatingSummaryImpl());

    // Act
    List<ReviewFeedback> actualReviewFeedback = reviewDetailImpl.getReviewFeedback();

    // Assert
    assertTrue(actualReviewFeedback.isEmpty());
    assertSame(reviewDetailImpl.reviewFeedback, actualReviewFeedback);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ReviewDetailImpl#ReviewDetailImpl()}
   *   <li>{@link ReviewDetailImpl#setReviewText(String)}
   *   <li>{@link ReviewDetailImpl#getCustomer()}
   *   <li>{@link ReviewDetailImpl#getId()}
   *   <li>{@link ReviewDetailImpl#getRatingDetail()}
   *   <li>{@link ReviewDetailImpl#getRatingSummary()}
   *   <li>{@link ReviewDetailImpl#getReviewSubmittedDate()}
   *   <li>{@link ReviewDetailImpl#getReviewText()}
   *   <li>{@link ReviewDetailImpl#helpfulCount()}
   *   <li>{@link ReviewDetailImpl#notHelpfulCount()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ReviewDetailImpl actualReviewDetailImpl = new ReviewDetailImpl();
    actualReviewDetailImpl.setReviewText("Review Text");
    actualReviewDetailImpl.getCustomer();
    actualReviewDetailImpl.getId();
    actualReviewDetailImpl.getRatingDetail();
    actualReviewDetailImpl.getRatingSummary();
    actualReviewDetailImpl.getReviewSubmittedDate();
    String actualReviewText = actualReviewDetailImpl.getReviewText();
    actualReviewDetailImpl.helpfulCount();
    actualReviewDetailImpl.notHelpfulCount();

    // Assert that nothing has changed
    assertEquals("Review Text", actualReviewText);
  }

  /**
   * Method under test:
   * {@link ReviewDetailImpl#ReviewDetailImpl(Customer, Date, RatingDetail, String, RatingSummary)}
   */
  @Test
  public void testNewReviewDetailImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerImpl customer = new CustomerImpl();
    Date reivewSubmittedDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    RatingDetailImpl ratingDetail = new RatingDetailImpl();
    RatingSummaryImpl ratingSummary = new RatingSummaryImpl();

    // Act
    ReviewDetailImpl actualReviewDetailImpl = new ReviewDetailImpl(customer, reivewSubmittedDate, ratingDetail,
        "Review Text", ratingSummary);

    // Assert
    ReviewStatusType status = actualReviewDetailImpl.getStatus();
    assertEquals("PENDING", status.getFriendlyType());
    assertEquals("PENDING", status.getType());
    assertEquals("PENDING", actualReviewDetailImpl.reviewStatus);
    assertEquals("Review Text", actualReviewDetailImpl.getReviewText());
    assertNull(actualReviewDetailImpl.getId());
    assertEquals(0, actualReviewDetailImpl.helpfulCount().intValue());
    assertEquals(0, actualReviewDetailImpl.notHelpfulCount().intValue());
    assertEquals(0, actualReviewDetailImpl.helpfulCount.intValue());
    assertEquals(0, actualReviewDetailImpl.notHelpfulCount.intValue());
    List<ReviewFeedback> reviewFeedback = actualReviewDetailImpl.getReviewFeedback();
    assertTrue(reviewFeedback.isEmpty());
    assertTrue(actualReviewDetailImpl.reviewFeedback.isEmpty());
    assertSame(ratingDetail, actualReviewDetailImpl.getRatingDetail());
    assertSame(ratingSummary, actualReviewDetailImpl.getRatingSummary());
    assertSame(customer, actualReviewDetailImpl.getCustomer());
    assertSame(reivewSubmittedDate, actualReviewDetailImpl.getReviewSubmittedDate());
    assertSame(actualReviewDetailImpl.reviewFeedback, reviewFeedback);
  }

  /**
   * Method under test:
   * {@link ReviewDetailImpl#ReviewDetailImpl(Customer, Date, RatingDetail, String, RatingSummary)}
   */
  @Test
  public void testNewReviewDetailImpl2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerImpl customer = mock(CustomerImpl.class);
    Date reivewSubmittedDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    RatingDetailImpl ratingDetail = new RatingDetailImpl();
    RatingSummaryImpl ratingSummary = new RatingSummaryImpl();

    // Act
    ReviewDetailImpl actualReviewDetailImpl = new ReviewDetailImpl(customer, reivewSubmittedDate, ratingDetail,
        "Review Text", ratingSummary);

    // Assert
    ReviewStatusType status = actualReviewDetailImpl.getStatus();
    assertEquals("PENDING", status.getFriendlyType());
    assertEquals("PENDING", status.getType());
    assertEquals("PENDING", actualReviewDetailImpl.reviewStatus);
    assertEquals("Review Text", actualReviewDetailImpl.getReviewText());
    assertNull(actualReviewDetailImpl.getId());
    assertEquals(0, actualReviewDetailImpl.helpfulCount().intValue());
    assertEquals(0, actualReviewDetailImpl.notHelpfulCount().intValue());
    assertEquals(0, actualReviewDetailImpl.helpfulCount.intValue());
    assertEquals(0, actualReviewDetailImpl.notHelpfulCount.intValue());
    List<ReviewFeedback> reviewFeedback = actualReviewDetailImpl.getReviewFeedback();
    assertTrue(reviewFeedback.isEmpty());
    assertTrue(actualReviewDetailImpl.reviewFeedback.isEmpty());
    assertSame(ratingDetail, actualReviewDetailImpl.getRatingDetail());
    assertSame(ratingSummary, actualReviewDetailImpl.getRatingSummary());
    assertSame(reivewSubmittedDate, actualReviewDetailImpl.getReviewSubmittedDate());
    assertSame(actualReviewDetailImpl.reviewFeedback, reviewFeedback);
    assertSame(customer, actualReviewDetailImpl.getCustomer());
  }
}

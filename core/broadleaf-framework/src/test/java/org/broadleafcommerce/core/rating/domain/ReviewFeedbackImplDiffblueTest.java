package org.broadleafcommerce.core.rating.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;

public class ReviewFeedbackImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ReviewFeedbackImpl}
   *   <li>{@link ReviewFeedbackImpl#setCustomer(Customer)}
   *   <li>{@link ReviewFeedbackImpl#setId(Long)}
   *   <li>{@link ReviewFeedbackImpl#setIsHelpful(Boolean)}
   *   <li>{@link ReviewFeedbackImpl#setReviewDetail(ReviewDetail)}
   *   <li>{@link ReviewFeedbackImpl#getCustomer()}
   *   <li>{@link ReviewFeedbackImpl#getId()}
   *   <li>{@link ReviewFeedbackImpl#getIsHelpful()}
   *   <li>{@link ReviewFeedbackImpl#getReviewDetail()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ReviewFeedbackImpl actualReviewFeedbackImpl = new ReviewFeedbackImpl();
    CustomerImpl customer = new CustomerImpl();
    actualReviewFeedbackImpl.setCustomer(customer);
    actualReviewFeedbackImpl.setId(1L);
    actualReviewFeedbackImpl.setIsHelpful(true);
    ReviewDetailImpl reviewDetail = new ReviewDetailImpl();
    actualReviewFeedbackImpl.setReviewDetail(reviewDetail);
    Customer actualCustomer = actualReviewFeedbackImpl.getCustomer();
    Long actualId = actualReviewFeedbackImpl.getId();
    Boolean actualIsHelpful = actualReviewFeedbackImpl.getIsHelpful();
    ReviewDetail actualReviewDetail = actualReviewFeedbackImpl.getReviewDetail();

    // Assert that nothing has changed
    assertEquals(1L, actualId.longValue());
    assertTrue(actualIsHelpful);
    assertSame(reviewDetail, actualReviewDetail);
    assertSame(customer, actualCustomer);
  }
}

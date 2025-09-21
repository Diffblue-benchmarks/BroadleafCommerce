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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ReviewFeedbackImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ReviewFeedbackImpl.<init>()",
    "Customer ReviewFeedbackImpl.getCustomer()",
    "Long ReviewFeedbackImpl.getId()",
    "Boolean ReviewFeedbackImpl.getIsHelpful()",
    "ReviewDetail ReviewFeedbackImpl.getReviewDetail()",
    "void ReviewFeedbackImpl.setCustomer(Customer)",
    "void ReviewFeedbackImpl.setId(Long)",
    "void ReviewFeedbackImpl.setIsHelpful(Boolean)",
    "void ReviewFeedbackImpl.setReviewDetail(ReviewDetail)"
  })
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

    // Assert
    assertEquals(1L, actualId.longValue());
    assertTrue(actualIsHelpful);
    assertSame(reviewDetail, actualReviewDetail);
    assertSame(customer, actualCustomer);
  }
}

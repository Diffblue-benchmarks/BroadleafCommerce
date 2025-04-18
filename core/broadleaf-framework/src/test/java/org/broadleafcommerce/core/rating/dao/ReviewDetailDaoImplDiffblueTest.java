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
package org.broadleafcommerce.core.rating.dao;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.persistence.NoResultException;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.core.rating.domain.ReviewDetail;
import org.broadleafcommerce.core.rating.domain.ReviewDetailImpl;
import org.broadleafcommerce.core.rating.domain.ReviewFeedback;
import org.broadleafcommerce.core.rating.domain.ReviewFeedbackImpl;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ReviewDetailDaoImplDiffblueTest {
  @Mock
  private EntityConfiguration entityConfiguration;

  @InjectMocks
  private ReviewDetailDaoImpl reviewDetailDaoImpl;

  /**
   * Test {@link ReviewDetailDaoImpl#create()}.
   * <ul>
   *   <li>Then return {@link ReviewDetailImpl#ReviewDetailImpl()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReviewDetailDaoImpl#create()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReviewDetail ReviewDetailDaoImpl.create()"})
  public void testCreate_thenReturnReviewDetailImpl() {
    // Arrange
    ReviewDetailImpl reviewDetailImpl = new ReviewDetailImpl();
    reviewDetailImpl.setReviewText("Review Text");
    when(entityConfiguration.createEntityInstance(Mockito.<String>any())).thenReturn(reviewDetailImpl);

    // Act
    ReviewDetail actualCreateResult = reviewDetailDaoImpl.create();

    // Assert
    verify(entityConfiguration).createEntityInstance(eq("org.broadleafcommerce.core.rating.domain.ReviewDetail"));
    assertSame(reviewDetailImpl, actualCreateResult);
  }

  /**
   * Test {@link ReviewDetailDaoImpl#create()}.
   * <ul>
   *   <li>Then throw {@link NoResultException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReviewDetailDaoImpl#create()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReviewDetail ReviewDetailDaoImpl.create()"})
  public void testCreate_thenThrowNoResultException() {
    // Arrange
    when(entityConfiguration.createEntityInstance(Mockito.<String>any()))
        .thenThrow(new NoResultException("An error occurred"));

    // Act and Assert
    assertThrows(NoResultException.class, () -> reviewDetailDaoImpl.create());
    verify(entityConfiguration).createEntityInstance(eq("org.broadleafcommerce.core.rating.domain.ReviewDetail"));
  }

  /**
   * Test {@link ReviewDetailDaoImpl#createFeedback()}.
   * <ul>
   *   <li>Then return {@link ReviewFeedbackImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ReviewDetailDaoImpl#createFeedback()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReviewFeedback ReviewDetailDaoImpl.createFeedback()"})
  public void testCreateFeedback_thenReturnReviewFeedbackImpl() {
    // Arrange
    ReviewFeedbackImpl reviewFeedbackImpl = new ReviewFeedbackImpl();
    reviewFeedbackImpl.setCustomer(new CustomerImpl());
    reviewFeedbackImpl.setId(1L);
    reviewFeedbackImpl.setIsHelpful(true);
    reviewFeedbackImpl.setReviewDetail(new ReviewDetailImpl());
    when(entityConfiguration.createEntityInstance(Mockito.<String>any())).thenReturn(reviewFeedbackImpl);

    // Act
    ReviewFeedback actualCreateFeedbackResult = reviewDetailDaoImpl.createFeedback();

    // Assert
    verify(entityConfiguration).createEntityInstance(eq("org.broadleafcommerce.core.rating.domain.ReviewFeedback"));
    assertSame(reviewFeedbackImpl, actualCreateFeedbackResult);
  }

  /**
   * Test {@link ReviewDetailDaoImpl#createFeedback()}.
   * <ul>
   *   <li>Then throw {@link NoResultException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReviewDetailDaoImpl#createFeedback()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReviewFeedback ReviewDetailDaoImpl.createFeedback()"})
  public void testCreateFeedback_thenThrowNoResultException() {
    // Arrange
    when(entityConfiguration.createEntityInstance(Mockito.<String>any()))
        .thenThrow(new NoResultException("An error occurred"));

    // Act and Assert
    assertThrows(NoResultException.class, () -> reviewDetailDaoImpl.createFeedback());
    verify(entityConfiguration).createEntityInstance(eq("org.broadleafcommerce.core.rating.domain.ReviewFeedback"));
  }
}

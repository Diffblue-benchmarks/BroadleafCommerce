package org.broadleafcommerce.core.rating.dao;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @Mock private EntityConfiguration entityConfiguration;

  @InjectMocks private ReviewDetailDaoImpl reviewDetailDaoImpl;

  /**
   * Test {@link ReviewDetailDaoImpl#create()}.
   *
   * <ul>
   *   <li>Then return {@link ReviewDetailImpl#ReviewDetailImpl()}.
   * </ul>
   *
   * <p>Method under test: {@link ReviewDetailDaoImpl#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReviewDetail ReviewDetailDaoImpl.create()"})
  public void testCreate_thenReturnReviewDetailImpl() {
    // Arrange
    ReviewDetailImpl reviewDetailImpl = new ReviewDetailImpl();
    reviewDetailImpl.setReviewText("Review Text");
    when(entityConfiguration.createEntityInstance(Mockito.<String>any()))
        .thenReturn(reviewDetailImpl);

    // Act
    ReviewDetail actualCreateResult = reviewDetailDaoImpl.create();

    // Assert
    verify(entityConfiguration)
        .createEntityInstance("org.broadleafcommerce.core.rating.domain.ReviewDetail");
    assertSame(reviewDetailImpl, actualCreateResult);
  }

  /**
   * Test {@link ReviewDetailDaoImpl#create()}.
   *
   * <ul>
   *   <li>Then throw {@link NoResultException}.
   * </ul>
   *
   * <p>Method under test: {@link ReviewDetailDaoImpl#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReviewDetail ReviewDetailDaoImpl.create()"})
  public void testCreate_thenThrowNoResultException() {
    // Arrange
    when(entityConfiguration.createEntityInstance(Mockito.<String>any()))
        .thenThrow(new NoResultException());

    // Act and Assert
    assertThrows(NoResultException.class, () -> reviewDetailDaoImpl.create());
    verify(entityConfiguration)
        .createEntityInstance("org.broadleafcommerce.core.rating.domain.ReviewDetail");
  }

  /**
   * Test {@link ReviewDetailDaoImpl#createFeedback()}.
   *
   * <ul>
   *   <li>Then return {@link ReviewFeedbackImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ReviewDetailDaoImpl#createFeedback()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReviewFeedback ReviewDetailDaoImpl.createFeedback()"})
  public void testCreateFeedback_thenReturnReviewFeedbackImpl() {
    // Arrange
    ReviewFeedbackImpl reviewFeedbackImpl = new ReviewFeedbackImpl();
    reviewFeedbackImpl.setCustomer(new CustomerImpl());
    reviewFeedbackImpl.setId(1L);
    reviewFeedbackImpl.setIsHelpful(true);
    reviewFeedbackImpl.setReviewDetail(new ReviewDetailImpl());
    when(entityConfiguration.createEntityInstance(Mockito.<String>any()))
        .thenReturn(reviewFeedbackImpl);

    // Act
    ReviewFeedback actualCreateFeedbackResult = reviewDetailDaoImpl.createFeedback();

    // Assert
    verify(entityConfiguration)
        .createEntityInstance("org.broadleafcommerce.core.rating.domain.ReviewFeedback");
    assertSame(reviewFeedbackImpl, actualCreateFeedbackResult);
  }

  /**
   * Test {@link ReviewDetailDaoImpl#createFeedback()}.
   *
   * <ul>
   *   <li>Then throw {@link NoResultException}.
   * </ul>
   *
   * <p>Method under test: {@link ReviewDetailDaoImpl#createFeedback()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReviewFeedback ReviewDetailDaoImpl.createFeedback()"})
  public void testCreateFeedback_thenThrowNoResultException() {
    // Arrange
    when(entityConfiguration.createEntityInstance(Mockito.<String>any()))
        .thenThrow(new NoResultException());

    // Act and Assert
    assertThrows(NoResultException.class, () -> reviewDetailDaoImpl.createFeedback());
    verify(entityConfiguration)
        .createEntityInstance("org.broadleafcommerce.core.rating.domain.ReviewFeedback");
  }
}

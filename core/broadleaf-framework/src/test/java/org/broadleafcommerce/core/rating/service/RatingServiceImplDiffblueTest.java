package org.broadleafcommerce.core.rating.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.core.rating.dao.RatingSummaryDao;
import org.broadleafcommerce.core.rating.dao.ReviewDetailDao;
import org.broadleafcommerce.core.rating.domain.RatingDetailImpl;
import org.broadleafcommerce.core.rating.domain.RatingSummary;
import org.broadleafcommerce.core.rating.domain.RatingSummaryImpl;
import org.broadleafcommerce.core.rating.domain.ReviewDetail;
import org.broadleafcommerce.core.rating.domain.ReviewDetailImpl;
import org.broadleafcommerce.core.rating.domain.ReviewFeedbackImpl;
import org.broadleafcommerce.core.rating.service.type.RatingSortType;
import org.broadleafcommerce.core.rating.service.type.RatingType;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RatingServiceImplDiffblueTest {
  @InjectMocks private RatingServiceImpl ratingServiceImpl;

  @Mock private RatingSummaryDao ratingSummaryDao;

  @Mock private ReviewDetailDao reviewDetailDao;

  /**
   * Test {@link RatingServiceImpl#deleteRatingSummary(RatingSummary)}.
   *
   * <p>Method under test: {@link RatingServiceImpl#deleteRatingSummary(RatingSummary)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RatingServiceImpl.deleteRatingSummary(RatingSummary)"})
  public void testDeleteRatingSummary() {
    // Arrange
    doNothing().when(ratingSummaryDao).deleteRatingSummary(Mockito.<RatingSummary>any());

    // Act
    ratingServiceImpl.deleteRatingSummary(new RatingSummaryImpl());

    // Assert
    verify(ratingSummaryDao).deleteRatingSummary(isA(RatingSummary.class));
  }

  /**
   * Test {@link RatingServiceImpl#markReviewHelpful(Long, Customer, Boolean)}.
   *
   * <p>Method under test: {@link RatingServiceImpl#markReviewHelpful(Long, Customer, Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RatingServiceImpl.markReviewHelpful(Long, Customer, Boolean)"})
  public void testMarkReviewHelpful() {
    // Arrange
    when(reviewDetailDao.saveReviewDetail(Mockito.<ReviewDetail>any()))
        .thenReturn(new ReviewDetailImpl());
    when(reviewDetailDao.createFeedback()).thenReturn(new ReviewFeedbackImpl());
    when(reviewDetailDao.readReviewDetailById(Mockito.<Long>any()))
        .thenReturn(new ReviewDetailImpl());

    // Act
    ratingServiceImpl.markReviewHelpful(1L, new CustomerImpl(), true);

    // Assert
    verify(reviewDetailDao).createFeedback();
    verify(reviewDetailDao).readReviewDetailById(1L);
    verify(reviewDetailDao).saveReviewDetail(isA(ReviewDetail.class));
  }

  /**
   * Test {@link RatingServiceImpl#markReviewHelpful(Long, Customer, Boolean)}.
   *
   * <p>Method under test: {@link RatingServiceImpl#markReviewHelpful(Long, Customer, Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RatingServiceImpl.markReviewHelpful(Long, Customer, Boolean)"})
  public void testMarkReviewHelpful2() {
    // Arrange
    when(reviewDetailDao.saveReviewDetail(Mockito.<ReviewDetail>any()))
        .thenReturn(new ReviewDetailImpl());
    when(reviewDetailDao.createFeedback()).thenReturn(new ReviewFeedbackImpl());
    CustomerImpl customer = new CustomerImpl();
    Date reivewSubmittedDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    RatingDetailImpl ratingDetail = new RatingDetailImpl();

    ReviewDetailImpl reviewDetailImpl =
        new ReviewDetailImpl(
            customer, reivewSubmittedDate, ratingDetail, "Review Text", new RatingSummaryImpl());
    when(reviewDetailDao.readReviewDetailById(Mockito.<Long>any())).thenReturn(reviewDetailImpl);

    // Act
    ratingServiceImpl.markReviewHelpful(1L, new CustomerImpl(), true);

    // Assert
    verify(reviewDetailDao).createFeedback();
    verify(reviewDetailDao).readReviewDetailById(1L);
    verify(reviewDetailDao).saveReviewDetail(isA(ReviewDetail.class));
  }

  /**
   * Test {@link RatingServiceImpl#markReviewHelpful(Long, Customer, Boolean)}.
   *
   * <ul>
   *   <li>Given {@link ReviewDetailDao} {@link ReviewDetailDao#readReviewDetailById(Long)} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RatingServiceImpl#markReviewHelpful(Long, Customer, Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RatingServiceImpl.markReviewHelpful(Long, Customer, Boolean)"})
  public void testMarkReviewHelpful_givenReviewDetailDaoReadReviewDetailByIdReturnNull() {
    // Arrange
    when(reviewDetailDao.readReviewDetailById(Mockito.<Long>any())).thenReturn(null);

    // Act
    ratingServiceImpl.markReviewHelpful(1L, new CustomerImpl(), true);

    // Assert
    verify(reviewDetailDao).readReviewDetailById(1L);
  }

  /**
   * Test {@link RatingServiceImpl#markReviewHelpful(Long, Customer, Boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link ReviewDetailImpl#getReviewFeedback()}.
   * </ul>
   *
   * <p>Method under test: {@link RatingServiceImpl#markReviewHelpful(Long, Customer, Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RatingServiceImpl.markReviewHelpful(Long, Customer, Boolean)"})
  public void testMarkReviewHelpful_thenCallsGetReviewFeedback() {
    // Arrange
    ReviewDetailImpl reviewDetailImpl = mock(ReviewDetailImpl.class);
    when(reviewDetailImpl.getReviewFeedback()).thenReturn(new ArrayList<>());
    when(reviewDetailDao.saveReviewDetail(Mockito.<ReviewDetail>any()))
        .thenReturn(new ReviewDetailImpl());
    when(reviewDetailDao.createFeedback()).thenReturn(new ReviewFeedbackImpl());
    when(reviewDetailDao.readReviewDetailById(Mockito.<Long>any())).thenReturn(reviewDetailImpl);

    // Act
    ratingServiceImpl.markReviewHelpful(1L, new CustomerImpl(), true);

    // Assert
    verify(reviewDetailDao).createFeedback();
    verify(reviewDetailDao).readReviewDetailById(1L);
    verify(reviewDetailDao).saveReviewDetail(isA(ReviewDetail.class));
    verify(reviewDetailImpl).getReviewFeedback();
  }

  /**
   * Test {@link RatingServiceImpl#rateItem(String, RatingType, Customer, Double)}.
   *
   * <ul>
   *   <li>Given {@link RatingSummaryDao} {@link RatingSummaryDao#readRating(Long, Long)} return
   *       {@code null}.
   *   <li>Then calls {@link RatingSummaryDao#createDetail(RatingSummary, Double, Date, Customer)}.
   * </ul>
   *
   * <p>Method under test: {@link RatingServiceImpl#rateItem(String, RatingType, Customer, Double)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RatingServiceImpl.rateItem(String, RatingType, Customer, Double)"})
  public void testRateItem_givenRatingSummaryDaoReadRatingReturnNull_thenCallsCreateDetail() {
    // Arrange
    when(ratingSummaryDao.saveRatingSummary(Mockito.<RatingSummary>any()))
        .thenReturn(new RatingSummaryImpl());
    when(ratingSummaryDao.createDetail(
            Mockito.<RatingSummary>any(),
            Mockito.<Double>any(),
            Mockito.<Date>any(),
            Mockito.<Customer>any()))
        .thenReturn(new RatingDetailImpl());
    when(ratingSummaryDao.readRating(Mockito.<Long>any(), Mockito.<Long>any())).thenReturn(null);
    when(ratingSummaryDao.readRatingSummary(Mockito.<String>any(), Mockito.<RatingType>any()))
        .thenReturn(new RatingSummaryImpl());

    // Act
    ratingServiceImpl.rateItem("42", RatingType.PRODUCT, new CustomerImpl(), 10.0d);

    // Assert
    verify(ratingSummaryDao)
        .createDetail(isA(RatingSummary.class), eq(10.0d), isA(Date.class), isA(Customer.class));
    verify(ratingSummaryDao).readRating(isNull(), isNull());
    verify(ratingSummaryDao).readRatingSummary(eq("42"), isA(RatingType.class));
    verify(ratingSummaryDao).saveRatingSummary(isA(RatingSummary.class));
  }

  /**
   * Test {@link RatingServiceImpl#rateItem(String, RatingType, Customer, Double)}.
   *
   * <ul>
   *   <li>Then calls {@link RatingSummaryDao#createSummary(String, RatingType)}.
   * </ul>
   *
   * <p>Method under test: {@link RatingServiceImpl#rateItem(String, RatingType, Customer, Double)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RatingServiceImpl.rateItem(String, RatingType, Customer, Double)"})
  public void testRateItem_thenCallsCreateSummary() {
    // Arrange
    when(ratingSummaryDao.saveRatingSummary(Mockito.<RatingSummary>any()))
        .thenReturn(new RatingSummaryImpl());
    when(ratingSummaryDao.readRating(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(new RatingDetailImpl());
    when(ratingSummaryDao.createSummary(Mockito.<String>any(), Mockito.<RatingType>any()))
        .thenReturn(new RatingSummaryImpl());
    when(ratingSummaryDao.readRatingSummary(Mockito.<String>any(), Mockito.<RatingType>any()))
        .thenReturn(null);

    // Act
    ratingServiceImpl.rateItem("42", RatingType.PRODUCT, new CustomerImpl(), 10.0d);

    // Assert
    verify(ratingSummaryDao).createSummary(eq("42"), isA(RatingType.class));
    verify(ratingSummaryDao).readRating(isNull(), isNull());
    verify(ratingSummaryDao).readRatingSummary(eq("42"), isA(RatingType.class));
    verify(ratingSummaryDao).saveRatingSummary(isA(RatingSummary.class));
  }

  /**
   * Test {@link RatingServiceImpl#rateItem(String, RatingType, Customer, Double)}.
   *
   * <ul>
   *   <li>Then calls {@link RatingSummaryDao#readRating(Long, Long)}.
   * </ul>
   *
   * <p>Method under test: {@link RatingServiceImpl#rateItem(String, RatingType, Customer, Double)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void RatingServiceImpl.rateItem(String, RatingType, Customer, Double)"})
  public void testRateItem_thenCallsReadRating() {
    // Arrange
    when(ratingSummaryDao.saveRatingSummary(Mockito.<RatingSummary>any()))
        .thenReturn(new RatingSummaryImpl());
    when(ratingSummaryDao.readRating(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(new RatingDetailImpl());
    when(ratingSummaryDao.readRatingSummary(Mockito.<String>any(), Mockito.<RatingType>any()))
        .thenReturn(new RatingSummaryImpl());

    // Act
    ratingServiceImpl.rateItem("42", RatingType.PRODUCT, new CustomerImpl(), 10.0d);

    // Assert
    verify(ratingSummaryDao).readRating(isNull(), isNull());
    verify(ratingSummaryDao).readRatingSummary(eq("42"), isA(RatingType.class));
    verify(ratingSummaryDao).saveRatingSummary(isA(RatingSummary.class));
  }

  /**
   * Test {@link RatingServiceImpl#readRatingSummary(String, RatingType)}.
   *
   * <p>Method under test: {@link RatingServiceImpl#readRatingSummary(String, RatingType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RatingSummary RatingServiceImpl.readRatingSummary(String, RatingType)"})
  public void testReadRatingSummary() {
    // Arrange
    RatingSummaryImpl ratingSummaryImpl = new RatingSummaryImpl();
    when(ratingSummaryDao.readRatingSummary(Mockito.<String>any(), Mockito.<RatingType>any()))
        .thenReturn(ratingSummaryImpl);

    // Act
    RatingSummary actualReadRatingSummaryResult =
        ratingServiceImpl.readRatingSummary("42", RatingType.PRODUCT);

    // Assert
    verify(ratingSummaryDao).readRatingSummary(eq("42"), isA(RatingType.class));
    assertSame(ratingSummaryImpl, actualReadRatingSummaryResult);
  }

  /**
   * Test {@link RatingServiceImpl#readRatingSummaries(List, RatingType)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RatingServiceImpl#readRatingSummaries(List, RatingType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map RatingServiceImpl.readRatingSummaries(List, RatingType)"})
  public void testReadRatingSummaries_given42_whenArrayListAdd42_thenReturnEmpty() {
    // Arrange
    when(ratingSummaryDao.readRatingSummaries(
            Mockito.<List<String>>any(), Mockito.<RatingType>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<String> itemIds = new ArrayList<>();
    itemIds.add("42");
    itemIds.add("foo");

    // Act
    Map<String, RatingSummary> actualReadRatingSummariesResult =
        ratingServiceImpl.readRatingSummaries(itemIds, RatingType.PRODUCT);

    // Assert
    verify(ratingSummaryDao).readRatingSummaries(isA(List.class), isA(RatingType.class));
    assertTrue(actualReadRatingSummariesResult.isEmpty());
  }

  /**
   * Test {@link RatingServiceImpl#readRatingSummaries(List, RatingType)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link RatingSummaryImpl} (default constructor).
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link RatingServiceImpl#readRatingSummaries(List, RatingType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map RatingServiceImpl.readRatingSummaries(List, RatingType)"})
  public void testReadRatingSummaries_givenArrayListAddRatingSummaryImpl_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<RatingSummary> ratingSummaryList = new ArrayList<>();
    RatingSummaryImpl ratingSummaryImpl = new RatingSummaryImpl();
    ratingSummaryList.add(ratingSummaryImpl);
    when(ratingSummaryDao.readRatingSummaries(
            Mockito.<List<String>>any(), Mockito.<RatingType>any()))
        .thenReturn(ratingSummaryList);

    // Act
    Map<String, RatingSummary> actualReadRatingSummariesResult =
        ratingServiceImpl.readRatingSummaries(new ArrayList<>(), RatingType.PRODUCT);

    // Assert
    verify(ratingSummaryDao).readRatingSummaries(isA(List.class), isA(RatingType.class));
    assertEquals(1, actualReadRatingSummariesResult.size());
    assertSame(ratingSummaryImpl, actualReadRatingSummariesResult.get(null));
  }

  /**
   * Test {@link RatingServiceImpl#readRatingSummaries(List, RatingType)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RatingServiceImpl#readRatingSummaries(List, RatingType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map RatingServiceImpl.readRatingSummaries(List, RatingType)"})
  public void testReadRatingSummaries_givenFoo_whenArrayListAddFoo_thenReturnEmpty() {
    // Arrange
    when(ratingSummaryDao.readRatingSummaries(
            Mockito.<List<String>>any(), Mockito.<RatingType>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<String> itemIds = new ArrayList<>();
    itemIds.add("foo");

    // Act
    Map<String, RatingSummary> actualReadRatingSummariesResult =
        ratingServiceImpl.readRatingSummaries(itemIds, RatingType.PRODUCT);

    // Assert
    verify(ratingSummaryDao).readRatingSummaries(isA(List.class), isA(RatingType.class));
    assertTrue(actualReadRatingSummariesResult.isEmpty());
  }

  /**
   * Test {@link RatingServiceImpl#readRatingSummaries(List, RatingType)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RatingServiceImpl#readRatingSummaries(List, RatingType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map RatingServiceImpl.readRatingSummaries(List, RatingType)"})
  public void testReadRatingSummaries_whenArrayList_thenReturnEmpty() {
    // Arrange
    when(ratingSummaryDao.readRatingSummaries(
            Mockito.<List<String>>any(), Mockito.<RatingType>any()))
        .thenReturn(new ArrayList<>());

    // Act
    Map<String, RatingSummary> actualReadRatingSummariesResult =
        ratingServiceImpl.readRatingSummaries(new ArrayList<>(), RatingType.PRODUCT);

    // Assert
    verify(ratingSummaryDao).readRatingSummaries(isA(List.class), isA(RatingType.class));
    assertTrue(actualReadRatingSummariesResult.isEmpty());
  }

  /**
   * Test {@link RatingServiceImpl#readReviews(String, RatingType, int, int, RatingSortType)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ReviewDetailImpl#ReviewDetailImpl()}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link RatingServiceImpl#readReviews(String, RatingType, int, int,
   * RatingSortType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RatingServiceImpl.readReviews(String, RatingType, int, int, RatingSortType)"
  })
  public void testReadReviews_givenArrayListAddReviewDetailImpl_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<ReviewDetail> reviewDetailList = new ArrayList<>();
    reviewDetailList.add(new ReviewDetailImpl());
    ReviewDetailImpl reviewDetailImpl = new ReviewDetailImpl();
    reviewDetailList.add(reviewDetailImpl);

    RatingSummaryImpl ratingSummaryImpl = mock(RatingSummaryImpl.class);
    when(ratingSummaryImpl.getReviews()).thenReturn(reviewDetailList);
    when(ratingSummaryDao.readRatingSummary(Mockito.<String>any(), Mockito.<RatingType>any()))
        .thenReturn(ratingSummaryImpl);

    // Act
    List<ReviewDetail> actualReadReviewsResult =
        ratingServiceImpl.readReviews("42", RatingType.PRODUCT, 1, 1, RatingSortType.DEFAULT);

    // Assert
    verify(ratingSummaryDao).readRatingSummary(eq("42"), isA(RatingType.class));
    verify(ratingSummaryImpl).getReviews();
    assertEquals(1, actualReadReviewsResult.size());
    assertSame(reviewDetailImpl, actualReadReviewsResult.get(0));
  }

  /**
   * Test {@link RatingServiceImpl#readReviews(String, RatingType, int, int, RatingSortType)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ReviewDetailImpl#ReviewDetailImpl()}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link RatingServiceImpl#readReviews(String, RatingType, int, int,
   * RatingSortType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RatingServiceImpl.readReviews(String, RatingType, int, int, RatingSortType)"
  })
  public void testReadReviews_givenArrayListAddReviewDetailImpl_thenReturnSizeIsOne2() {
    // Arrange
    ArrayList<ReviewDetail> reviewDetailList = new ArrayList<>();
    reviewDetailList.add(new ReviewDetailImpl());
    ReviewDetailImpl reviewDetailImpl = new ReviewDetailImpl();
    reviewDetailList.add(reviewDetailImpl);
    reviewDetailList.add(new ReviewDetailImpl());

    RatingSummaryImpl ratingSummaryImpl = mock(RatingSummaryImpl.class);
    when(ratingSummaryImpl.getReviews()).thenReturn(reviewDetailList);
    when(ratingSummaryDao.readRatingSummary(Mockito.<String>any(), Mockito.<RatingType>any()))
        .thenReturn(ratingSummaryImpl);

    // Act
    List<ReviewDetail> actualReadReviewsResult =
        ratingServiceImpl.readReviews("42", RatingType.PRODUCT, 1, 1, RatingSortType.DEFAULT);

    // Assert
    verify(ratingSummaryDao).readRatingSummary(eq("42"), isA(RatingType.class));
    verify(ratingSummaryImpl).getReviews();
    assertEquals(1, actualReadReviewsResult.size());
    assertSame(reviewDetailImpl, actualReadReviewsResult.get(0));
  }

  /**
   * Test {@link RatingServiceImpl#readReviews(String, RatingType, int, int, RatingSortType)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ReviewDetailImpl#ReviewDetailImpl()}.
   *   <li>When {@link RatingSortType#DEFAULT}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RatingServiceImpl#readReviews(String, RatingType, int, int,
   * RatingSortType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RatingServiceImpl.readReviews(String, RatingType, int, int, RatingSortType)"
  })
  public void testReadReviews_givenArrayListAddReviewDetailImpl_whenDefault_thenReturnEmpty() {
    // Arrange
    ArrayList<ReviewDetail> reviewDetailList = new ArrayList<>();
    reviewDetailList.add(new ReviewDetailImpl());

    RatingSummaryImpl ratingSummaryImpl = mock(RatingSummaryImpl.class);
    when(ratingSummaryImpl.getReviews()).thenReturn(reviewDetailList);
    when(ratingSummaryDao.readRatingSummary(Mockito.<String>any(), Mockito.<RatingType>any()))
        .thenReturn(ratingSummaryImpl);

    // Act
    List<ReviewDetail> actualReadReviewsResult =
        ratingServiceImpl.readReviews("42", RatingType.PRODUCT, 1, 1, RatingSortType.DEFAULT);

    // Assert
    verify(ratingSummaryDao).readRatingSummary(eq("42"), isA(RatingType.class));
    verify(ratingSummaryImpl).getReviews();
    assertTrue(actualReadReviewsResult.isEmpty());
  }

  /**
   * Test {@link RatingServiceImpl#readReviews(String, RatingType, int, int, RatingSortType)}.
   *
   * <ul>
   *   <li>Given {@link RatingSummaryDao} {@link RatingSummaryDao#readRatingSummary(String,
   *       RatingType)} return {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RatingServiceImpl#readReviews(String, RatingType, int, int,
   * RatingSortType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RatingServiceImpl.readReviews(String, RatingType, int, int, RatingSortType)"
  })
  public void testReadReviews_givenRatingSummaryDaoReadRatingSummaryReturnNull_thenReturnEmpty() {
    // Arrange
    when(ratingSummaryDao.readRatingSummary(Mockito.<String>any(), Mockito.<RatingType>any()))
        .thenReturn(null);

    // Act
    List<ReviewDetail> actualReadReviewsResult =
        ratingServiceImpl.readReviews("42", RatingType.PRODUCT, 1, 1, RatingSortType.DEFAULT);

    // Assert
    verify(ratingSummaryDao).readRatingSummary(eq("42"), isA(RatingType.class));
    assertTrue(actualReadReviewsResult.isEmpty());
  }

  /**
   * Test {@link RatingServiceImpl#readReviews(String, RatingType, int, int, RatingSortType)}.
   *
   * <ul>
   *   <li>Given {@link RatingSummaryDao} {@link RatingSummaryDao#readRatingSummary(String,
   *       RatingType)} return {@link RatingSummaryImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link RatingServiceImpl#readReviews(String, RatingType, int, int,
   * RatingSortType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RatingServiceImpl.readReviews(String, RatingType, int, int, RatingSortType)"
  })
  public void testReadReviews_givenRatingSummaryDaoReadRatingSummaryReturnRatingSummaryImpl() {
    // Arrange
    when(ratingSummaryDao.readRatingSummary(Mockito.<String>any(), Mockito.<RatingType>any()))
        .thenReturn(new RatingSummaryImpl());

    // Act
    List<ReviewDetail> actualReadReviewsResult =
        ratingServiceImpl.readReviews("42", RatingType.PRODUCT, 1, 1, RatingSortType.DEFAULT);

    // Assert
    verify(ratingSummaryDao).readRatingSummary(eq("42"), isA(RatingType.class));
    assertTrue(actualReadReviewsResult.isEmpty());
  }

  /**
   * Test {@link RatingServiceImpl#readReviews(String, RatingType, int, int, RatingSortType)}.
   *
   * <ul>
   *   <li>Given {@link RatingSummaryImpl} {@link RatingSummaryImpl#getReviews()} return {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RatingServiceImpl#readReviews(String, RatingType, int, int,
   * RatingSortType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RatingServiceImpl.readReviews(String, RatingType, int, int, RatingSortType)"
  })
  public void testReadReviews_givenRatingSummaryImplGetReviewsReturnArrayList_thenReturnEmpty() {
    // Arrange
    RatingSummaryImpl ratingSummaryImpl = mock(RatingSummaryImpl.class);
    when(ratingSummaryImpl.getReviews()).thenReturn(new ArrayList<>());
    when(ratingSummaryDao.readRatingSummary(Mockito.<String>any(), Mockito.<RatingType>any()))
        .thenReturn(ratingSummaryImpl);

    // Act
    List<ReviewDetail> actualReadReviewsResult =
        ratingServiceImpl.readReviews("42", RatingType.PRODUCT, 1, 1, RatingSortType.DEFAULT);

    // Assert
    verify(ratingSummaryDao).readRatingSummary(eq("42"), isA(RatingType.class));
    verify(ratingSummaryImpl).getReviews();
    assertTrue(actualReadReviewsResult.isEmpty());
  }

  /**
   * Test {@link RatingServiceImpl#readReviews(String, RatingType, int, int, RatingSortType)}.
   *
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link RatingServiceImpl#readReviews(String, RatingType, int, int,
   * RatingSortType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RatingServiceImpl.readReviews(String, RatingType, int, int, RatingSortType)"
  })
  public void testReadReviews_thenReturnArrayList() {
    // Arrange
    ReviewDetailImpl reviewDetailImpl = mock(ReviewDetailImpl.class);
    when(reviewDetailImpl.getReviewSubmittedDate())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    ArrayList<ReviewDetail> reviewDetailList = new ArrayList<>();
    reviewDetailList.add(reviewDetailImpl);
    CustomerImpl customer = new CustomerImpl();
    Date reivewSubmittedDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    RatingDetailImpl ratingDetail = new RatingDetailImpl();

    ReviewDetailImpl reviewDetailImpl2 =
        new ReviewDetailImpl(
            customer,
            reivewSubmittedDate,
            ratingDetail,
            "reviewSubmittedDate",
            new RatingSummaryImpl());
    reviewDetailList.add(reviewDetailImpl2);

    RatingSummaryImpl ratingSummaryImpl = mock(RatingSummaryImpl.class);
    when(ratingSummaryImpl.getReviews()).thenReturn(reviewDetailList);
    when(ratingSummaryDao.readRatingSummary(Mockito.<String>any(), Mockito.<RatingType>any()))
        .thenReturn(ratingSummaryImpl);

    // Act
    List<ReviewDetail> actualReadReviewsResult =
        ratingServiceImpl.readReviews("42", RatingType.PRODUCT, 0, 1, RatingSortType.DEFAULT);

    // Assert
    verify(ratingSummaryDao).readRatingSummary(eq("42"), isA(RatingType.class));
    verify(ratingSummaryImpl).getReviews();
    verify(reviewDetailImpl).getReviewSubmittedDate();
    assertEquals(reviewDetailList, actualReadReviewsResult);
  }

  /**
   * Test {@link RatingServiceImpl#readReviews(String, RatingType, int, int, RatingSortType)}.
   *
   * <ul>
   *   <li>When {@link RatingSortType#MOST_HELPFUL}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link RatingServiceImpl#readReviews(String, RatingType, int, int,
   * RatingSortType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List RatingServiceImpl.readReviews(String, RatingType, int, int, RatingSortType)"
  })
  public void testReadReviews_whenMost_helpful_thenReturnEmpty() {
    // Arrange
    RatingSummaryImpl ratingSummaryImpl = mock(RatingSummaryImpl.class);
    when(ratingSummaryImpl.getReviews()).thenReturn(new ArrayList<>());
    when(ratingSummaryDao.readRatingSummary(Mockito.<String>any(), Mockito.<RatingType>any()))
        .thenReturn(ratingSummaryImpl);

    // Act
    List<ReviewDetail> actualReadReviewsResult =
        ratingServiceImpl.readReviews("42", RatingType.PRODUCT, 1, 1, RatingSortType.MOST_HELPFUL);

    // Assert
    verify(ratingSummaryDao).readRatingSummary(eq("42"), isA(RatingType.class));
    verify(ratingSummaryImpl).getReviews();
    assertTrue(actualReadReviewsResult.isEmpty());
  }

  /**
   * Test {@link RatingServiceImpl#saveRatingSummary(RatingSummary)}.
   *
   * <p>Method under test: {@link RatingServiceImpl#saveRatingSummary(RatingSummary)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RatingSummary RatingServiceImpl.saveRatingSummary(RatingSummary)"})
  public void testSaveRatingSummary() {
    // Arrange
    RatingSummaryImpl ratingSummaryImpl = new RatingSummaryImpl();
    when(ratingSummaryDao.saveRatingSummary(Mockito.<RatingSummary>any()))
        .thenReturn(ratingSummaryImpl);

    // Act
    RatingSummary actualSaveRatingSummaryResult =
        ratingServiceImpl.saveRatingSummary(new RatingSummaryImpl());

    // Assert
    verify(ratingSummaryDao).saveRatingSummary(isA(RatingSummary.class));
    assertSame(ratingSummaryImpl, actualSaveRatingSummaryResult);
  }

  /**
   * Test {@link RatingServiceImpl#reviewItem(String, RatingType, Customer, Double, String)}.
   *
   * <ul>
   *   <li>Then calls {@link RatingSummaryDao#createDetail(RatingSummary, Double, Date, Customer)}.
   * </ul>
   *
   * <p>Method under test: {@link RatingServiceImpl#reviewItem(String, RatingType, Customer, Double,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RatingServiceImpl.reviewItem(String, RatingType, Customer, Double, String)"
  })
  public void testReviewItem_thenCallsCreateDetail() {
    // Arrange
    when(ratingSummaryDao.createDetail(
            Mockito.<RatingSummary>any(),
            Mockito.<Double>any(),
            Mockito.<Date>any(),
            Mockito.<Customer>any()))
        .thenReturn(new RatingDetailImpl());
    when(ratingSummaryDao.saveRatingSummary(Mockito.<RatingSummary>any()))
        .thenReturn(new RatingSummaryImpl());
    when(ratingSummaryDao.readRatingSummary(Mockito.<String>any(), Mockito.<RatingType>any()))
        .thenReturn(new RatingSummaryImpl());

    // Act
    ratingServiceImpl.reviewItem(
        "42", RatingType.PRODUCT, new CustomerImpl(), 10.0d, "Review Text");

    // Assert
    verify(ratingSummaryDao)
        .createDetail(isA(RatingSummary.class), eq(10.0d), isA(Date.class), isA(Customer.class));
    verify(ratingSummaryDao).readRatingSummary(eq("42"), isA(RatingType.class));
    verify(ratingSummaryDao).saveRatingSummary(isA(RatingSummary.class));
  }

  /**
   * Test {@link RatingServiceImpl#reviewItem(String, RatingType, Customer, Double, String)}.
   *
   * <ul>
   *   <li>Then calls {@link RatingSummaryDao#createSummary(String, RatingType)}.
   * </ul>
   *
   * <p>Method under test: {@link RatingServiceImpl#reviewItem(String, RatingType, Customer, Double,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RatingServiceImpl.reviewItem(String, RatingType, Customer, Double, String)"
  })
  public void testReviewItem_thenCallsCreateSummary() {
    // Arrange
    when(ratingSummaryDao.createDetail(
            Mockito.<RatingSummary>any(),
            Mockito.<Double>any(),
            Mockito.<Date>any(),
            Mockito.<Customer>any()))
        .thenReturn(new RatingDetailImpl());
    when(ratingSummaryDao.saveRatingSummary(Mockito.<RatingSummary>any()))
        .thenReturn(new RatingSummaryImpl());
    when(ratingSummaryDao.createSummary(Mockito.<String>any(), Mockito.<RatingType>any()))
        .thenReturn(new RatingSummaryImpl());
    when(ratingSummaryDao.readRatingSummary(Mockito.<String>any(), Mockito.<RatingType>any()))
        .thenReturn(null);

    // Act
    ratingServiceImpl.reviewItem(
        "42", RatingType.PRODUCT, new CustomerImpl(), 10.0d, "Review Text");

    // Assert
    verify(ratingSummaryDao)
        .createDetail(isA(RatingSummary.class), eq(10.0d), isA(Date.class), isA(Customer.class));
    verify(ratingSummaryDao).createSummary(eq("42"), isA(RatingType.class));
    verify(ratingSummaryDao).readRatingSummary(eq("42"), isA(RatingType.class));
    verify(ratingSummaryDao).saveRatingSummary(isA(RatingSummary.class));
  }

  /**
   * Test {@link RatingServiceImpl#reviewItem(String, RatingType, Customer, Double, String)}.
   *
   * <ul>
   *   <li>Then calls {@link RatingSummaryDao#readRating(Long, Long)}.
   * </ul>
   *
   * <p>Method under test: {@link RatingServiceImpl#reviewItem(String, RatingType, Customer, Double,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RatingServiceImpl.reviewItem(String, RatingType, Customer, Double, String)"
  })
  public void testReviewItem_thenCallsReadRating() {
    // Arrange
    RatingSummaryImpl ratingSummaryImpl = new RatingSummaryImpl();
    ratingSummaryImpl.setId(1L);
    when(ratingSummaryDao.readRating(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(new RatingDetailImpl());
    when(ratingSummaryDao.readReview(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(new ReviewDetailImpl());
    when(ratingSummaryDao.saveRatingSummary(Mockito.<RatingSummary>any()))
        .thenReturn(new RatingSummaryImpl());
    when(ratingSummaryDao.readRatingSummary(Mockito.<String>any(), Mockito.<RatingType>any()))
        .thenReturn(ratingSummaryImpl);

    // Act
    ratingServiceImpl.reviewItem(
        "42", RatingType.PRODUCT, new CustomerImpl(), 10.0d, "Review Text");

    // Assert
    verify(ratingSummaryDao).readRating(isNull(), eq(1L));
    verify(ratingSummaryDao).readRatingSummary(eq("42"), isA(RatingType.class));
    verify(ratingSummaryDao).readReview(isNull(), eq(1L));
    verify(ratingSummaryDao).saveRatingSummary(isA(RatingSummary.class));
  }

  /**
   * Test {@link RatingServiceImpl#reviewItem(String, RatingType, Customer, Double, String)}.
   *
   * <ul>
   *   <li>Then calls {@link ReviewDetailImpl#setReviewText(String)}.
   * </ul>
   *
   * <p>Method under test: {@link RatingServiceImpl#reviewItem(String, RatingType, Customer, Double,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RatingServiceImpl.reviewItem(String, RatingType, Customer, Double, String)"
  })
  public void testReviewItem_thenCallsSetReviewText() {
    // Arrange
    RatingSummaryImpl ratingSummaryImpl = new RatingSummaryImpl();
    ratingSummaryImpl.setId(1L);

    ReviewDetailImpl reviewDetailImpl = mock(ReviewDetailImpl.class);
    doNothing().when(reviewDetailImpl).setReviewText(Mockito.<String>any());
    when(ratingSummaryDao.readRating(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(new RatingDetailImpl());
    when(ratingSummaryDao.readReview(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(reviewDetailImpl);
    when(ratingSummaryDao.saveRatingSummary(Mockito.<RatingSummary>any()))
        .thenReturn(new RatingSummaryImpl());
    when(ratingSummaryDao.readRatingSummary(Mockito.<String>any(), Mockito.<RatingType>any()))
        .thenReturn(ratingSummaryImpl);

    // Act
    ratingServiceImpl.reviewItem(
        "42", RatingType.PRODUCT, new CustomerImpl(), 10.0d, "Review Text");

    // Assert
    verify(ratingSummaryDao).readRating(isNull(), eq(1L));
    verify(ratingSummaryDao).readRatingSummary(eq("42"), isA(RatingType.class));
    verify(ratingSummaryDao).readReview(isNull(), eq(1L));
    verify(ratingSummaryDao).saveRatingSummary(isA(RatingSummary.class));
    verify(reviewDetailImpl).setReviewText("Review Text");
  }

  /**
   * Test {@link RatingServiceImpl#readReviewByCustomerAndItem(Customer, String)}.
   *
   * <p>Method under test: {@link RatingServiceImpl#readReviewByCustomerAndItem(Customer, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReviewDetail RatingServiceImpl.readReviewByCustomerAndItem(Customer, String)"
  })
  public void testReadReviewByCustomerAndItem() {
    // Arrange
    ReviewDetailImpl reviewDetailImpl = new ReviewDetailImpl();
    when(reviewDetailDao.readReviewByCustomerAndItem(
            Mockito.<Customer>any(), Mockito.<String>any()))
        .thenReturn(reviewDetailImpl);

    // Act
    ReviewDetail actualReadReviewByCustomerAndItemResult =
        ratingServiceImpl.readReviewByCustomerAndItem(new CustomerImpl(), "42");

    // Assert
    verify(reviewDetailDao).readReviewByCustomerAndItem(isA(Customer.class), eq("42"));
    assertSame(reviewDetailImpl, actualReadReviewByCustomerAndItemResult);
  }
}

package org.broadleafcommerce.core.rating.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.broadleafcommerce.core.rating.service.type.ReviewStatusType;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ReviewDetailImplDiffblueTest {
  @Autowired private ReviewDetailImpl reviewDetailImpl;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ReviewDetailImpl.<init>()",
    "Customer ReviewDetailImpl.getCustomer()",
    "Long ReviewDetailImpl.getId()",
    "RatingDetail ReviewDetailImpl.getRatingDetail()",
    "RatingSummary ReviewDetailImpl.getRatingSummary()",
    "Date ReviewDetailImpl.getReviewSubmittedDate()",
    "String ReviewDetailImpl.getReviewText()",
    "Integer ReviewDetailImpl.helpfulCount()",
    "Integer ReviewDetailImpl.notHelpfulCount()",
    "void ReviewDetailImpl.setReviewText(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ReviewDetailImpl actualReviewDetailImpl = new ReviewDetailImpl();
    actualReviewDetailImpl.setReviewText("Review Text");
    Customer actualCustomer = actualReviewDetailImpl.getCustomer();
    Long actualId = actualReviewDetailImpl.getId();
    RatingDetail actualRatingDetail = actualReviewDetailImpl.getRatingDetail();
    RatingSummary actualRatingSummary = actualReviewDetailImpl.getRatingSummary();
    Date actualReviewSubmittedDate = actualReviewDetailImpl.getReviewSubmittedDate();
    String actualReviewText = actualReviewDetailImpl.getReviewText();
    Integer actualHelpfulCountResult = actualReviewDetailImpl.helpfulCount();

    // Assert
    assertEquals("Review Text", actualReviewText);
    assertNull(actualHelpfulCountResult);
    assertNull(actualReviewDetailImpl.notHelpfulCount());
    assertNull(actualId);
    assertNull(actualReviewSubmittedDate);
    assertNull(actualRatingDetail);
    assertNull(actualRatingSummary);
    assertNull(actualCustomer);
  }

  /**
   * Test {@link ReviewDetailImpl#ReviewDetailImpl(Customer, Date, RatingDetail, String,
   * RatingSummary)}.
   *
   * <p>Method under test: {@link ReviewDetailImpl#ReviewDetailImpl(Customer, Date, RatingDetail,
   * String, RatingSummary)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ReviewDetailImpl.<init>(Customer, Date, RatingDetail, String, RatingSummary)"
  })
  public void testNewReviewDetailImpl() {
    // Arrange
    CustomerImpl customer = new CustomerImpl();
    Date reivewSubmittedDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    RatingDetailImpl ratingDetail = new RatingDetailImpl();
    RatingSummaryImpl ratingSummary = new RatingSummaryImpl();

    // Act
    ReviewDetailImpl actualReviewDetailImpl =
        new ReviewDetailImpl(
            customer, reivewSubmittedDate, ratingDetail, "Review Text", ratingSummary);

    // Assert
    RatingDetail ratingDetail2 = actualReviewDetailImpl.getRatingDetail();
    assertTrue(ratingDetail2 instanceof RatingDetailImpl);
    RatingSummary ratingSummary2 = actualReviewDetailImpl.getRatingSummary();
    assertTrue(ratingSummary2 instanceof RatingSummaryImpl);
    Customer customer2 = actualReviewDetailImpl.getCustomer();
    assertTrue(customer2 instanceof CustomerImpl);
    assertEquals("PENDING", actualReviewDetailImpl.reviewStatus);
    assertEquals("Review Text", actualReviewDetailImpl.getReviewText());
    assertNull(actualReviewDetailImpl.getId());
    assertEquals(0, actualReviewDetailImpl.helpfulCount().intValue());
    assertEquals(0, actualReviewDetailImpl.notHelpfulCount().intValue());
    assertEquals(0, actualReviewDetailImpl.helpfulCount.intValue());
    assertEquals(0, actualReviewDetailImpl.notHelpfulCount.intValue());
    assertTrue(actualReviewDetailImpl.getReviewFeedback().isEmpty());
    assertTrue(actualReviewDetailImpl.reviewFeedback.isEmpty());
    assertSame(ratingDetail, ratingDetail2);
    assertSame(ratingSummary, ratingSummary2);
    assertSame(customer, customer2);
  }

  /**
   * Test {@link ReviewDetailImpl#getStatus()}.
   *
   * <p>Method under test: {@link ReviewDetailImpl#getStatus()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReviewStatusType ReviewDetailImpl.getStatus()"})
  public void testGetStatus() {
    // Arrange and Act
    ReviewStatusType actualStatus = reviewDetailImpl.getStatus();

    // Assert
    assertNull(actualStatus.getFriendlyType());
    assertNull(actualStatus.getType());
  }

  /**
   * Test {@link ReviewDetailImpl#getReviewFeedback()}.
   *
   * <p>Method under test: {@link ReviewDetailImpl#getReviewFeedback()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List ReviewDetailImpl.getReviewFeedback()"})
  public void testGetReviewFeedback() {
    // Arrange, Act and Assert
    assertTrue(reviewDetailImpl.getReviewFeedback().isEmpty());
  }
}

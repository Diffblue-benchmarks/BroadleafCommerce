package org.broadleafcommerce.core.rating.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.broadleafcommerce.core.rating.service.type.ReviewStatusType;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ReviewDetailImplDiffblueTest {
  @Autowired
  private ReviewDetailImpl reviewDetailImpl;

  /**
   * Test getters and setters.
   * <p>
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
   * Test
   * {@link ReviewDetailImpl#ReviewDetailImpl(Customer, Date, RatingDetail, String, RatingSummary)}.
   * <p>
   * Method under test:
   * {@link ReviewDetailImpl#ReviewDetailImpl(Customer, Date, RatingDetail, String, RatingSummary)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNewReviewDetailImpl() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.rating.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3954 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.rating.domain.ReviewDetailImpl reviewDetailImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CustomerImpl customer = new CustomerImpl();
    Date reivewSubmittedDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    RatingDetailImpl ratingDetail = new RatingDetailImpl();

    // Act
    new ReviewDetailImpl(customer, reivewSubmittedDate, ratingDetail, "Review Text", new RatingSummaryImpl());

  }

  /**
   * Test
   * {@link ReviewDetailImpl#ReviewDetailImpl(Customer, Date, RatingDetail, String, RatingSummary)}.
   * <ul>
   *   <li>Then RatingSummary return {@link RatingSummaryImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ReviewDetailImpl#ReviewDetailImpl(Customer, Date, RatingDetail, String, RatingSummary)}
   */
  @Test
  public void testNewReviewDetailImpl_thenRatingSummaryReturnRatingSummaryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerImpl customer = new CustomerImpl();
    Date reivewSubmittedDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    RatingDetailImpl ratingDetail = new RatingDetailImpl();

    // Act
    ReviewDetailImpl actualReviewDetailImpl = new ReviewDetailImpl(customer, reivewSubmittedDate, ratingDetail,
        "Review Text", new RatingSummaryImpl());

    // Assert
    assertTrue(actualReviewDetailImpl.getRatingSummary() instanceof RatingSummaryImpl);
    assertSame(customer, actualReviewDetailImpl.getCustomer());
  }

  /**
   * Test
   * {@link ReviewDetailImpl#ReviewDetailImpl(Customer, Date, RatingDetail, String, RatingSummary)}.
   * <ul>
   *   <li>When {@link CustomerImpl}.</li>
   *   <li>Then return Status FriendlyType is {@code PENDING}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ReviewDetailImpl#ReviewDetailImpl(Customer, Date, RatingDetail, String, RatingSummary)}
   */
  @Test
  public void testNewReviewDetailImpl_whenCustomerImpl_thenReturnStatusFriendlyTypeIsPending() {
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
    assertTrue(actualReviewDetailImpl.getReviewFeedback().isEmpty());
    assertTrue(actualReviewDetailImpl.reviewFeedback.isEmpty());
    assertSame(ratingDetail, actualReviewDetailImpl.getRatingDetail());
    assertSame(ratingSummary, actualReviewDetailImpl.getRatingSummary());
    assertSame(customer, actualReviewDetailImpl.getCustomer());
  }

  /**
   * Test {@link ReviewDetailImpl#getStatus()}.
   * <p>
   * Method under test: {@link ReviewDetailImpl#getStatus()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetStatus() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.rating.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3988 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.rating.domain.ReviewDetailImpl reviewDetailImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ReviewDetailImpl()).getStatus();
  }

  /**
   * Test {@link ReviewDetailImpl#getStatus()}.
   * <ul>
   *   <li>Given {@link ReviewDetailImpl#ReviewDetailImpl()}.</li>
   *   <li>Then return FriendlyType is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReviewDetailImpl#getStatus()}
   */
  @Test
  public void testGetStatus_givenReviewDetailImpl_thenReturnFriendlyTypeIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    ReviewStatusType actualStatus = (new ReviewDetailImpl()).getStatus();

    // Assert
    assertNull(actualStatus.getFriendlyType());
    assertNull(actualStatus.getType());
  }

  /**
   * Test {@link ReviewDetailImpl#getStatus()}.
   * <ul>
   *   <li>Then return {@link ReviewStatusType#PENDING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReviewDetailImpl#getStatus()}
   */
  @Test
  public void testGetStatus_thenReturnPending() {
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
   * Test {@link ReviewDetailImpl#getReviewFeedback()}.
   * <p>
   * Method under test: {@link ReviewDetailImpl#getReviewFeedback()}
   */
  @Test
  public void testGetReviewFeedback() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerImpl customer = new CustomerImpl();
    Date reivewSubmittedDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    RatingDetailImpl ratingDetail = new RatingDetailImpl();

    // Act and Assert
    assertTrue(
        (new ReviewDetailImpl(customer, reivewSubmittedDate, ratingDetail, "Review Text", new RatingSummaryImpl()))
            .getReviewFeedback()
            .isEmpty());
  }

  /**
   * Test {@link ReviewDetailImpl#getReviewFeedback()}.
   * <p>
   * Method under test: {@link ReviewDetailImpl#getReviewFeedback()}
   */
  @Test
  public void testGetReviewFeedback2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerImpl customer = mock(CustomerImpl.class);
    Date reivewSubmittedDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    RatingDetailImpl ratingDetail = new RatingDetailImpl();

    // Act and Assert
    assertTrue(
        (new ReviewDetailImpl(customer, reivewSubmittedDate, ratingDetail, "Review Text", new RatingSummaryImpl()))
            .getReviewFeedback()
            .isEmpty());
  }

  /**
   * Test {@link ReviewDetailImpl#getReviewFeedback()}.
   * <p>
   * Method under test: {@link ReviewDetailImpl#getReviewFeedback()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetReviewFeedback3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.rating.domain;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3984 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.rating.domain.ReviewDetailImpl reviewDetailImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ReviewDetailImpl()).getReviewFeedback();
  }

  /**
   * Test {@link ReviewDetailImpl#getReviewFeedback()}.
   * <ul>
   *   <li>Given {@link ReviewDetailImpl#ReviewDetailImpl()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReviewDetailImpl#getReviewFeedback()}
   */
  @Test
  public void testGetReviewFeedback_givenReviewDetailImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ReviewDetailImpl()).getReviewFeedback().isEmpty());
  }
}

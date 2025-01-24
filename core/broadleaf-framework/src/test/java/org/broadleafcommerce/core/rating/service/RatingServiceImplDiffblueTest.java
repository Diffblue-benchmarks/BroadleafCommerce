package org.broadleafcommerce.core.rating.service;

import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.core.rating.domain.RatingSummary;
import org.broadleafcommerce.core.rating.domain.RatingSummaryImpl;
import org.broadleafcommerce.core.rating.service.type.RatingSortType;
import org.broadleafcommerce.core.rating.service.type.RatingType;
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
public class RatingServiceImplDiffblueTest {
  @Autowired
  private RatingServiceImpl ratingServiceImpl;

  /**
   * Test {@link RatingServiceImpl#deleteRatingSummary(RatingSummary)}.
   * <p>
   * Method under test:
   * {@link RatingServiceImpl#deleteRatingSummary(RatingSummary)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDeleteRatingSummary() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.rating.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3992 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.rating.service.RatingServiceImpl ratingServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RatingServiceImpl ratingServiceImpl2 = new RatingServiceImpl();

    // Act
    ratingServiceImpl2.deleteRatingSummary(new RatingSummaryImpl());
  }

  /**
   * Test {@link RatingServiceImpl#markReviewHelpful(Long, Customer, Boolean)}.
   * <p>
   * Method under test:
   * {@link RatingServiceImpl#markReviewHelpful(Long, Customer, Boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testMarkReviewHelpful() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.rating.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4003 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.rating.service.RatingServiceImpl ratingServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RatingServiceImpl ratingServiceImpl2 = new RatingServiceImpl();

    // Act
    ratingServiceImpl2.markReviewHelpful(1L, new CustomerImpl(), true);
  }

  /**
   * Test
   * {@link RatingServiceImpl#rateItem(String, RatingType, Customer, Double)}.
   * <p>
   * Method under test:
   * {@link RatingServiceImpl#rateItem(String, RatingType, Customer, Double)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRateItem() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.rating.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4033 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.rating.service.RatingServiceImpl ratingServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RatingServiceImpl ratingServiceImpl2 = new RatingServiceImpl();

    // Act
    ratingServiceImpl2.rateItem("42", RatingType.PRODUCT, new CustomerImpl(), 10.0d);
  }

  /**
   * Test {@link RatingServiceImpl#readRatingSummary(String, RatingType)}.
   * <p>
   * Method under test:
   * {@link RatingServiceImpl#readRatingSummary(String, RatingType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadRatingSummary() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.rating.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4073 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.rating.service.RatingServiceImpl ratingServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new RatingServiceImpl()).readRatingSummary("42", RatingType.PRODUCT);
  }

  /**
   * Test {@link RatingServiceImpl#readRatingSummaries(List, RatingType)}.
   * <p>
   * Method under test:
   * {@link RatingServiceImpl#readRatingSummaries(List, RatingType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadRatingSummaries() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.rating.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4063 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.rating.service.RatingServiceImpl ratingServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RatingServiceImpl ratingServiceImpl2 = new RatingServiceImpl();

    // Act
    ratingServiceImpl2.readRatingSummaries(new ArrayList<>(), RatingType.PRODUCT);
  }

  /**
   * Test
   * {@link RatingServiceImpl#readReviews(String, RatingType, int, int, RatingSortType)}.
   * <p>
   * Method under test:
   * {@link RatingServiceImpl#readReviews(String, RatingType, int, int, RatingSortType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadReviews() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.rating.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4114 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.rating.service.RatingServiceImpl ratingServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new RatingServiceImpl()).readReviews("42", RatingType.PRODUCT, 1, 1, RatingSortType.DEFAULT);
  }

  /**
   * Test {@link RatingServiceImpl#saveRatingSummary(RatingSummary)}.
   * <p>
   * Method under test: {@link RatingServiceImpl#saveRatingSummary(RatingSummary)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSaveRatingSummary() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.rating.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4168 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.rating.service.RatingServiceImpl ratingServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RatingServiceImpl ratingServiceImpl2 = new RatingServiceImpl();

    // Act
    ratingServiceImpl2.saveRatingSummary(new RatingSummaryImpl());
  }

  /**
   * Test
   * {@link RatingServiceImpl#reviewItem(String, RatingType, Customer, Double, String)}.
   * <p>
   * Method under test:
   * {@link RatingServiceImpl#reviewItem(String, RatingType, Customer, Double, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReviewItem() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.rating.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4138 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.rating.service.RatingServiceImpl ratingServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RatingServiceImpl ratingServiceImpl2 = new RatingServiceImpl();

    // Act
    ratingServiceImpl2.reviewItem("42", RatingType.PRODUCT, new CustomerImpl(), 10.0d, "Review Text");
  }

  /**
   * Test {@link RatingServiceImpl#readReviewByCustomerAndItem(Customer, String)}.
   * <p>
   * Method under test:
   * {@link RatingServiceImpl#readReviewByCustomerAndItem(Customer, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadReviewByCustomerAndItem() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.rating.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4084 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.rating.service.RatingServiceImpl ratingServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RatingServiceImpl ratingServiceImpl2 = new RatingServiceImpl();

    // Act
    ratingServiceImpl2.readReviewByCustomerAndItem(new CustomerImpl(), "42");
  }
}

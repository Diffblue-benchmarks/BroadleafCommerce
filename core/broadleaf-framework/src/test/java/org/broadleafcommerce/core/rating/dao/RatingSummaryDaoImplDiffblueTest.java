package org.broadleafcommerce.core.rating.dao;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.broadleafcommerce.core.rating.domain.RatingSummary;
import org.broadleafcommerce.core.rating.domain.RatingSummaryImpl;
import org.broadleafcommerce.core.rating.service.type.RatingType;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class RatingSummaryDaoImplDiffblueTest {
  @Autowired
  private RatingSummaryDaoImpl ratingSummaryDaoImpl;

  /**
   * Test {@link RatingSummaryDaoImpl#createSummary()}.
   * <p>
   * Method under test: {@link RatingSummaryDaoImpl#createSummary()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateSummary() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.rating.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3731 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.rating.dao.RatingSummaryDaoImpl ratingSummaryDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new RatingSummaryDaoImpl()).createSummary();
  }

  /**
   * Test {@link RatingSummaryDaoImpl#createSummary(String, RatingType)} with
   * {@code String}, {@code RatingType}.
   * <p>
   * Method under test:
   * {@link RatingSummaryDaoImpl#createSummary(String, RatingType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateSummaryWithStringRatingType() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.rating.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3733 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.rating.dao.RatingSummaryDaoImpl ratingSummaryDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new RatingSummaryDaoImpl()).createSummary("42", RatingType.PRODUCT);
  }

  /**
   * Test {@link RatingSummaryDaoImpl#createDetail()}.
   * <p>
   * Method under test: {@link RatingSummaryDaoImpl#createDetail()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateDetail() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.rating.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3699 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.rating.dao.RatingSummaryDaoImpl ratingSummaryDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new RatingSummaryDaoImpl()).createDetail();
  }

  /**
   * Test
   * {@link RatingSummaryDaoImpl#createDetail(RatingSummary, Double, Date, Customer)}
   * with {@code RatingSummary}, {@code Double}, {@code Date}, {@code Customer}.
   * <p>
   * Method under test:
   * {@link RatingSummaryDaoImpl#createDetail(RatingSummary, Double, Date, Customer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateDetailWithRatingSummaryDoubleDateCustomer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.rating.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3701 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.rating.dao.RatingSummaryDaoImpl ratingSummaryDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RatingSummaryDaoImpl ratingSummaryDaoImpl2 = new RatingSummaryDaoImpl();
    RatingSummaryImpl ratingSummary = new RatingSummaryImpl();
    Date submittedDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    ratingSummaryDaoImpl2.createDetail(ratingSummary, 10.0d, submittedDate, new CustomerImpl());
  }

  /**
   * Test {@link RatingSummaryDaoImpl#deleteRatingSummary(RatingSummary)}.
   * <p>
   * Method under test:
   * {@link RatingSummaryDaoImpl#deleteRatingSummary(RatingSummary)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDeleteRatingSummary() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.rating.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3742 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.rating.dao.RatingSummaryDaoImpl ratingSummaryDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RatingSummaryDaoImpl ratingSummaryDaoImpl2 = new RatingSummaryDaoImpl();

    // Act
    ratingSummaryDaoImpl2.deleteRatingSummary(new RatingSummaryImpl());
  }

  /**
   * Test {@link RatingSummaryDaoImpl#saveRatingSummary(RatingSummary)}.
   * <p>
   * Method under test:
   * {@link RatingSummaryDaoImpl#saveRatingSummary(RatingSummary)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSaveRatingSummary() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.rating.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3834 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.rating.dao.RatingSummaryDaoImpl ratingSummaryDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RatingSummaryDaoImpl ratingSummaryDaoImpl2 = new RatingSummaryDaoImpl();

    // Act
    ratingSummaryDaoImpl2.saveRatingSummary(new RatingSummaryImpl());
  }

  /**
   * Test {@link RatingSummaryDaoImpl#readRatingSummaries(List, RatingType)}.
   * <p>
   * Method under test:
   * {@link RatingSummaryDaoImpl#readRatingSummaries(List, RatingType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadRatingSummaries() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.rating.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3784 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.rating.dao.RatingSummaryDaoImpl ratingSummaryDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    RatingSummaryDaoImpl ratingSummaryDaoImpl2 = new RatingSummaryDaoImpl();

    // Act
    ratingSummaryDaoImpl2.readRatingSummaries(new ArrayList<>(), RatingType.PRODUCT);
  }

  /**
   * Test {@link RatingSummaryDaoImpl#readRatingSummary(String, RatingType)}.
   * <p>
   * Method under test:
   * {@link RatingSummaryDaoImpl#readRatingSummary(String, RatingType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadRatingSummary() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.rating.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3795 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.rating.dao.RatingSummaryDaoImpl ratingSummaryDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new RatingSummaryDaoImpl()).readRatingSummary("42", RatingType.PRODUCT);
  }

  /**
   * Test {@link RatingSummaryDaoImpl#readRating(Long, Long)}.
   * <p>
   * Method under test: {@link RatingSummaryDaoImpl#readRating(Long, Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadRating() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.rating.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3754 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.rating.dao.RatingSummaryDaoImpl ratingSummaryDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new RatingSummaryDaoImpl()).readRating(1L, 1L);
  }

  /**
   * Test {@link RatingSummaryDaoImpl#readReview(Long, Long)}.
   * <p>
   * Method under test: {@link RatingSummaryDaoImpl#readReview(Long, Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadReview() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.rating.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3804 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.rating.dao.RatingSummaryDaoImpl ratingSummaryDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new RatingSummaryDaoImpl()).readReview(1L, 1L);
  }
}

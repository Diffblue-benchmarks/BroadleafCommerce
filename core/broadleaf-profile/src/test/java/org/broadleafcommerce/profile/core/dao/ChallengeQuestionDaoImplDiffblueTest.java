package org.broadleafcommerce.profile.core.dao;

import org.broadleafcommerce.profile.core.domain.ChallengeQuestion;
import org.broadleafcommerce.profile.core.domain.ChallengeQuestionImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml",
    "/bl-profile-applicationContext-persistence.xml", "/bl-profile-applicationContext.xml",
    "/blc-config/admin/framework/bl-profile-applicationContext.xml",
    "/blc-config/site/framework/bl-profile-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class ChallengeQuestionDaoImplDiffblueTest {
  @Autowired
  private ChallengeQuestionDaoImpl challengeQuestionDaoImpl;

  /**
   * Test {@link ChallengeQuestionDaoImpl#readChallengeQuestions()}.
   * <p>
   * Method under test: {@link ChallengeQuestionDaoImpl#readChallengeQuestions()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadChallengeQuestions() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass107 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.dao.ChallengeQuestionDaoImpl challengeQuestionDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ChallengeQuestionDaoImpl()).readChallengeQuestions();
  }

  /**
   * Test {@link ChallengeQuestionDaoImpl#readChallengeQuestionById(long)}.
   * <p>
   * Method under test:
   * {@link ChallengeQuestionDaoImpl#readChallengeQuestionById(long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadChallengeQuestionById() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass92 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.dao.ChallengeQuestionDaoImpl challengeQuestionDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ChallengeQuestionDaoImpl()).readChallengeQuestionById(1L);
  }

  /**
   * Test
   * {@link ChallengeQuestionDaoImpl#saveChallengeQuestion(ChallengeQuestion)}.
   * <p>
   * Method under test:
   * {@link ChallengeQuestionDaoImpl#saveChallengeQuestion(ChallengeQuestion)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSaveChallengeQuestion() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass108 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.dao.ChallengeQuestionDaoImpl challengeQuestionDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ChallengeQuestionDaoImpl challengeQuestionDaoImpl2 = new ChallengeQuestionDaoImpl();

    // Act
    challengeQuestionDaoImpl2.saveChallengeQuestion(new ChallengeQuestionImpl());
  }
}

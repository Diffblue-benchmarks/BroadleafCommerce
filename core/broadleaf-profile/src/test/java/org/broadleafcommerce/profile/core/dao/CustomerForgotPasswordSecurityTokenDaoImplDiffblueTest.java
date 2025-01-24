package org.broadleafcommerce.profile.core.dao;

import org.broadleafcommerce.profile.core.domain.CustomerForgotPasswordSecurityToken;
import org.broadleafcommerce.profile.core.domain.CustomerForgotPasswordSecurityTokenImpl;
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
public class CustomerForgotPasswordSecurityTokenDaoImplDiffblueTest {
  @Autowired
  private CustomerForgotPasswordSecurityTokenDaoImpl customerForgotPasswordSecurityTokenDaoImpl;

  /**
   * Test {@link CustomerForgotPasswordSecurityTokenDaoImpl#readToken(String)}.
   * <p>
   * Method under test:
   * {@link CustomerForgotPasswordSecurityTokenDaoImpl#readToken(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadToken() {
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
    //   public class DiffblueFakeClass2233 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.dao.CustomerForgotPasswordSecurityTokenDaoImpl customerForgotPasswordSecurityTokenDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CustomerForgotPasswordSecurityTokenDaoImpl()).readToken("ABC123");
  }

  /**
   * Test
   * {@link CustomerForgotPasswordSecurityTokenDaoImpl#readUnusedTokensByCustomerId(Long)}.
   * <p>
   * Method under test:
   * {@link CustomerForgotPasswordSecurityTokenDaoImpl#readUnusedTokensByCustomerId(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadUnusedTokensByCustomerId() {
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
    //   public class DiffblueFakeClass2389 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.dao.CustomerForgotPasswordSecurityTokenDaoImpl customerForgotPasswordSecurityTokenDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CustomerForgotPasswordSecurityTokenDaoImpl()).readUnusedTokensByCustomerId(1L);
  }

  /**
   * Test
   * {@link CustomerForgotPasswordSecurityTokenDaoImpl#saveToken(CustomerForgotPasswordSecurityToken)}.
   * <p>
   * Method under test:
   * {@link CustomerForgotPasswordSecurityTokenDaoImpl#saveToken(CustomerForgotPasswordSecurityToken)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSaveToken() {
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
    //   public class DiffblueFakeClass2404 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.dao.CustomerForgotPasswordSecurityTokenDaoImpl customerForgotPasswordSecurityTokenDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CustomerForgotPasswordSecurityTokenDaoImpl customerForgotPasswordSecurityTokenDaoImpl2 = new CustomerForgotPasswordSecurityTokenDaoImpl();

    // Act
    customerForgotPasswordSecurityTokenDaoImpl2.saveToken(new CustomerForgotPasswordSecurityTokenImpl());
  }
}

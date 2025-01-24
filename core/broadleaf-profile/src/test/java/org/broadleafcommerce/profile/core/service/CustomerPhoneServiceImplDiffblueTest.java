package org.broadleafcommerce.profile.core.service;

import org.broadleafcommerce.profile.core.domain.CustomerPhone;
import org.broadleafcommerce.profile.core.domain.CustomerPhoneImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml",
    "/bl-profile-applicationContext-persistence.xml", "/bl-profile-applicationContext.xml",
    "/blc-config/admin/framework/bl-profile-applicationContext.xml",
    "/blc-config/site/framework/bl-profile-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerPhoneServiceImplDiffblueTest {
  @Autowired
  private CustomerPhoneServiceImpl customerPhoneServiceImpl;

  /**
   * Test {@link CustomerPhoneServiceImpl#saveCustomerPhone(CustomerPhone)}.
   * <p>
   * Method under test:
   * {@link CustomerPhoneServiceImpl#saveCustomerPhone(CustomerPhone)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSaveCustomerPhone() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1468 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.service.CustomerPhoneServiceImpl customerPhoneServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CustomerPhoneServiceImpl customerPhoneServiceImpl2 = new CustomerPhoneServiceImpl();

    // Act
    customerPhoneServiceImpl2.saveCustomerPhone(new CustomerPhoneImpl());
  }

  /**
   * Test
   * {@link CustomerPhoneServiceImpl#readActiveCustomerPhonesByCustomerId(Long)}.
   * <p>
   * Method under test:
   * {@link CustomerPhoneServiceImpl#readActiveCustomerPhonesByCustomerId(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadActiveCustomerPhonesByCustomerId() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1423 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.service.CustomerPhoneServiceImpl customerPhoneServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CustomerPhoneServiceImpl()).readActiveCustomerPhonesByCustomerId(1L);
  }

  /**
   * Test {@link CustomerPhoneServiceImpl#readCustomerPhoneById(Long)}.
   * <p>
   * Method under test:
   * {@link CustomerPhoneServiceImpl#readCustomerPhoneById(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadCustomerPhoneById() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1453 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.service.CustomerPhoneServiceImpl customerPhoneServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CustomerPhoneServiceImpl()).readCustomerPhoneById(1L);
  }

  /**
   * Test {@link CustomerPhoneServiceImpl#makeCustomerPhoneDefault(Long, Long)}.
   * <p>
   * Method under test:
   * {@link CustomerPhoneServiceImpl#makeCustomerPhoneDefault(Long, Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testMakeCustomerPhoneDefault() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1394 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.service.CustomerPhoneServiceImpl customerPhoneServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CustomerPhoneServiceImpl()).makeCustomerPhoneDefault(1L, 1L);
  }

  /**
   * Test {@link CustomerPhoneServiceImpl#deleteCustomerPhoneById(Long)}.
   * <p>
   * Method under test:
   * {@link CustomerPhoneServiceImpl#deleteCustomerPhoneById(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDeleteCustomerPhoneById() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1364 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.service.CustomerPhoneServiceImpl customerPhoneServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CustomerPhoneServiceImpl()).deleteCustomerPhoneById(1L);
  }

  /**
   * Test {@link CustomerPhoneServiceImpl#findDefaultCustomerPhone(Long)}.
   * <p>
   * Method under test:
   * {@link CustomerPhoneServiceImpl#findDefaultCustomerPhone(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindDefaultCustomerPhone() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1379 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.service.CustomerPhoneServiceImpl customerPhoneServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CustomerPhoneServiceImpl()).findDefaultCustomerPhone(1L);
  }

  /**
   * Test
   * {@link CustomerPhoneServiceImpl#readAllCustomerPhonesByCustomerId(Long)}.
   * <p>
   * Method under test:
   * {@link CustomerPhoneServiceImpl#readAllCustomerPhonesByCustomerId(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadAllCustomerPhonesByCustomerId() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1438 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.service.CustomerPhoneServiceImpl customerPhoneServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CustomerPhoneServiceImpl()).readAllCustomerPhonesByCustomerId(1L);
  }

  /**
   * Test {@link CustomerPhoneServiceImpl#create()}.
   * <p>
   * Method under test: {@link CustomerPhoneServiceImpl#create()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreate() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1363 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.service.CustomerPhoneServiceImpl customerPhoneServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CustomerPhoneServiceImpl()).create();
  }
}

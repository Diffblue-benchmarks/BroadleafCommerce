package org.broadleafcommerce.profile.core.service;

import static org.junit.Assert.assertNull;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.domain.CustomerPayment;
import org.broadleafcommerce.profile.core.domain.CustomerPaymentImpl;
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
public class CustomerPaymentServiceImplDiffblueTest {
  @Autowired
  private CustomerPaymentServiceImpl customerPaymentServiceImpl;

  /**
   * Test {@link CustomerPaymentServiceImpl#saveCustomerPayment(CustomerPayment)}.
   * <p>
   * Method under test:
   * {@link CustomerPaymentServiceImpl#saveCustomerPayment(CustomerPayment)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSaveCustomerPayment() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1335 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.service.CustomerPaymentServiceImpl customerPaymentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CustomerPaymentServiceImpl customerPaymentServiceImpl2 = new CustomerPaymentServiceImpl();

    // Act
    customerPaymentServiceImpl2.saveCustomerPayment(new CustomerPaymentImpl());
  }

  /**
   * Test
   * {@link CustomerPaymentServiceImpl#readCustomerPaymentsByCustomerId(Long)}.
   * <p>
   * Method under test:
   * {@link CustomerPaymentServiceImpl#readCustomerPaymentsByCustomerId(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadCustomerPaymentsByCustomerId() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1320 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.service.CustomerPaymentServiceImpl customerPaymentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CustomerPaymentServiceImpl()).readCustomerPaymentsByCustomerId(1L);
  }

  /**
   * Test {@link CustomerPaymentServiceImpl#readCustomerPaymentById(Long)}.
   * <p>
   * Method under test:
   * {@link CustomerPaymentServiceImpl#readCustomerPaymentById(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadCustomerPaymentById() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1220 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.service.CustomerPaymentServiceImpl customerPaymentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CustomerPaymentServiceImpl()).readCustomerPaymentById(1L);
  }

  /**
   * Test {@link CustomerPaymentServiceImpl#readCustomerPaymentByToken(String)}.
   * <p>
   * Method under test:
   * {@link CustomerPaymentServiceImpl#readCustomerPaymentByToken(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadCustomerPaymentByToken() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1235 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.service.CustomerPaymentServiceImpl customerPaymentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CustomerPaymentServiceImpl()).readCustomerPaymentByToken("ABC123");
  }

  /**
   * Test {@link CustomerPaymentServiceImpl#deleteCustomerPaymentById(Long)}.
   * <p>
   * Method under test:
   * {@link CustomerPaymentServiceImpl#deleteCustomerPaymentById(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDeleteCustomerPaymentById() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1051 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.service.CustomerPaymentServiceImpl customerPaymentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CustomerPaymentServiceImpl()).deleteCustomerPaymentById(1L);
  }

  /**
   * Test {@link CustomerPaymentServiceImpl#deleteCustomerPaymentByToken(String)}.
   * <p>
   * Method under test:
   * {@link CustomerPaymentServiceImpl#deleteCustomerPaymentByToken(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDeleteCustomerPaymentByToken() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1066 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.service.CustomerPaymentServiceImpl customerPaymentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CustomerPaymentServiceImpl()).deleteCustomerPaymentByToken("ABC123");
  }

  /**
   * Test {@link CustomerPaymentServiceImpl#create()}.
   * <p>
   * Method under test: {@link CustomerPaymentServiceImpl#create()}
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
    //   public class DiffblueFakeClass1050 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.service.CustomerPaymentServiceImpl customerPaymentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CustomerPaymentServiceImpl()).create();
  }

  /**
   * Test
   * {@link CustomerPaymentServiceImpl#findDefaultPaymentForCustomer(Customer)}.
   * <p>
   * Method under test:
   * {@link CustomerPaymentServiceImpl#findDefaultPaymentForCustomer(Customer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindDefaultPaymentForCustomer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1192 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.service.CustomerPaymentServiceImpl customerPaymentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CustomerPaymentServiceImpl customerPaymentServiceImpl2 = new CustomerPaymentServiceImpl();

    // Act
    customerPaymentServiceImpl2.findDefaultPaymentForCustomer(new CustomerImpl());
  }

  /**
   * Test
   * {@link CustomerPaymentServiceImpl#findDefaultPaymentForCustomer(Customer)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerPaymentServiceImpl#findDefaultPaymentForCustomer(Customer)}
   */
  @Test
  public void testFindDefaultPaymentForCustomer_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CustomerPaymentServiceImpl()).findDefaultPaymentForCustomer(null));
  }

  /**
   * Test {@link CustomerPaymentServiceImpl#setAsDefaultPayment(CustomerPayment)}.
   * <p>
   * Method under test:
   * {@link CustomerPaymentServiceImpl#setAsDefaultPayment(CustomerPayment)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetAsDefaultPayment() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1349 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.service.CustomerPaymentServiceImpl customerPaymentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CustomerPaymentServiceImpl customerPaymentServiceImpl2 = new CustomerPaymentServiceImpl();

    // Act
    customerPaymentServiceImpl2.setAsDefaultPayment(new CustomerPaymentImpl());
  }

  /**
   * Test {@link CustomerPaymentServiceImpl#clearDefaultPaymentStatus(Customer)}.
   * <p>
   * Method under test:
   * {@link CustomerPaymentServiceImpl#clearDefaultPaymentStatus(Customer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testClearDefaultPaymentStatus() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1022 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.service.CustomerPaymentServiceImpl customerPaymentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CustomerPaymentServiceImpl customerPaymentServiceImpl2 = new CustomerPaymentServiceImpl();

    // Act
    customerPaymentServiceImpl2.clearDefaultPaymentStatus(new CustomerImpl());
  }

  /**
   * Test
   * {@link CustomerPaymentServiceImpl#deleteCustomerPaymentFromCustomer(Customer, CustomerPayment)}.
   * <p>
   * Method under test:
   * {@link CustomerPaymentServiceImpl#deleteCustomerPaymentFromCustomer(Customer, CustomerPayment)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDeleteCustomerPaymentFromCustomer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.core.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml","/bl-profile-applicationContext-persistence.xml","/bl-profile-applicationContext.xml","/blc-config/admin/framework/bl-profile-applicationContext.xml","/blc-config/site/framework/bl-profile-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1151 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.core.service.CustomerPaymentServiceImpl customerPaymentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CustomerPaymentServiceImpl customerPaymentServiceImpl2 = new CustomerPaymentServiceImpl();
    CustomerImpl customer = new CustomerImpl();

    // Act
    customerPaymentServiceImpl2.deleteCustomerPaymentFromCustomer(customer, new CustomerPaymentImpl());
  }
}

package org.broadleafcommerce.profile.web.core.expression;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.profile.core.domain.CustomerPayment;
import org.broadleafcommerce.profile.core.domain.CustomerPaymentImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(locations = {"/bl-profile-web-applicationContext.xml",
    "/blc-config/admin/framework/bl-profile-web-applicationContext.xml",
    "/blc-config/site/bl-profile-web-applicationContext-servlet.xml",
    "/blc-config/site/framework/bl-profile-web-applicationContext.xml"})
@ExtendWith(SpringExtension.class)
class CustomerVariableExpressionDiffblueTest {
  @Autowired
  private CustomerVariableExpression customerVariableExpression;

  /**
   * Test {@link CustomerVariableExpression#getName()}.
   * <p>
   * Method under test: {@link CustomerVariableExpression#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("customer", (new CustomerVariableExpression()).getName());
  }

  /**
   * Test {@link CustomerVariableExpression#getCurrent()}.
   * <p>
   * Method under test: {@link CustomerVariableExpression#getCurrent()}
   */
  @Test
  @DisplayName("Test getCurrent()")
  void testGetCurrent() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CustomerVariableExpression()).getCurrent());
  }

  /**
   * Test {@link CustomerVariableExpression#getCurrent()}.
   * <p>
   * Method under test: {@link CustomerVariableExpression#getCurrent()}
   */
  @Test
  @DisplayName("Test getCurrent()")
  @Disabled("TODO: Complete this test")
  void testGetCurrent2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.web.core.expression;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-web-applicationContext.xml","/blc-config/admin/framework/bl-profile-web-applicationContext.xml","/blc-config/site/bl-profile-web-applicationContext-servlet.xml","/blc-config/site/framework/bl-profile-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass909 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.web.core.expression.CustomerVariableExpression customerVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CustomerVariableExpression()).getCurrent();
  }

  /**
   * Test {@link CustomerVariableExpression#getCustomerAddresses()}.
   * <p>
   * Method under test: {@link CustomerVariableExpression#getCustomerAddresses()}
   */
  @Test
  @DisplayName("Test getCustomerAddresses()")
  @Disabled("TODO: Complete this test")
  void testGetCustomerAddresses() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.web.core.expression;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-web-applicationContext.xml","/blc-config/admin/framework/bl-profile-web-applicationContext.xml","/blc-config/site/bl-profile-web-applicationContext-servlet.xml","/blc-config/site/framework/bl-profile-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass910 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.web.core.expression.CustomerVariableExpression customerVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CustomerVariableExpression()).getCustomerAddresses();
  }

  /**
   * Test {@link CustomerVariableExpression#savedPaymentsAreEnabled()}.
   * <p>
   * Method under test:
   * {@link CustomerVariableExpression#savedPaymentsAreEnabled()}
   */
  @Test
  @DisplayName("Test savedPaymentsAreEnabled()")
  @Disabled("TODO: Complete this test")
  void testSavedPaymentsAreEnabled() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.web.core.expression;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-web-applicationContext.xml","/blc-config/admin/framework/bl-profile-web-applicationContext.xml","/blc-config/site/bl-profile-web-applicationContext-servlet.xml","/blc-config/site/framework/bl-profile-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass912 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.web.core.expression.CustomerVariableExpression customerVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CustomerVariableExpression()).savedPaymentsAreEnabled();
  }

  /**
   * Test {@link CustomerVariableExpression#getCustomerPayments()}.
   * <p>
   * Method under test: {@link CustomerVariableExpression#getCustomerPayments()}
   */
  @Test
  @DisplayName("Test getCustomerPayments()")
  @Disabled("TODO: Complete this test")
  void testGetCustomerPayments() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.web.core.expression;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-web-applicationContext.xml","/blc-config/admin/framework/bl-profile-web-applicationContext.xml","/blc-config/site/bl-profile-web-applicationContext-servlet.xml","/blc-config/site/framework/bl-profile-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass911 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.web.core.expression.CustomerVariableExpression customerVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CustomerVariableExpression()).getCustomerPayments();
  }

  /**
   * Test {@link CustomerVariableExpression#sortCustomerPaymentsByDefault(List)}.
   * <p>
   * Method under test:
   * {@link CustomerVariableExpression#sortCustomerPaymentsByDefault(List)}
   */
  @Test
  @DisplayName("Test sortCustomerPaymentsByDefault(List)")
  @Disabled("TODO: Complete this test")
  void testSortCustomerPaymentsByDefault() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.profile.web.core.expression;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-profile-web-applicationContext.xml","/blc-config/admin/framework/bl-profile-web-applicationContext.xml","/blc-config/site/bl-profile-web-applicationContext-servlet.xml","/blc-config/site/framework/bl-profile-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass913 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.profile.web.core.expression.CustomerVariableExpression customerVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CustomerVariableExpression customerVariableExpression2 = new CustomerVariableExpression();

    // Act
    customerVariableExpression2.sortCustomerPaymentsByDefault(new ArrayList<>());
  }

  /**
   * Test {@link CustomerVariableExpression#sortCustomerPaymentsByDefault(List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerVariableExpression#sortCustomerPaymentsByDefault(List)}
   */
  @Test
  @DisplayName("Test sortCustomerPaymentsByDefault(List); then ArrayList() size is three")
  void testSortCustomerPaymentsByDefault_thenArrayListSizeIsThree() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerVariableExpression customerVariableExpression = new CustomerVariableExpression();

    ArrayList<CustomerPayment> savedPayments = new ArrayList<>();
    savedPayments.add(new CustomerPaymentImpl());
    CustomerPaymentImpl customerPaymentImpl = new CustomerPaymentImpl();
    savedPayments.add(customerPaymentImpl);
    savedPayments.add(new CustomerPaymentImpl());

    // Act
    customerVariableExpression.sortCustomerPaymentsByDefault(savedPayments);

    // Assert
    assertEquals(3, savedPayments.size());
    assertSame(customerPaymentImpl, savedPayments.get(1));
  }

  /**
   * Test {@link CustomerVariableExpression#sortCustomerPaymentsByDefault(List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerVariableExpression#sortCustomerPaymentsByDefault(List)}
   */
  @Test
  @DisplayName("Test sortCustomerPaymentsByDefault(List); then ArrayList() size is three")
  void testSortCustomerPaymentsByDefault_thenArrayListSizeIsThree2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerVariableExpression customerVariableExpression = new CustomerVariableExpression();
    CustomerPaymentImpl customerPaymentImpl = mock(CustomerPaymentImpl.class);
    when(customerPaymentImpl.isDefault()).thenReturn(true);

    ArrayList<CustomerPayment> savedPayments = new ArrayList<>();
    CustomerPaymentImpl customerPaymentImpl2 = new CustomerPaymentImpl();
    savedPayments.add(customerPaymentImpl2);
    savedPayments.add(customerPaymentImpl);
    savedPayments.add(new CustomerPaymentImpl());

    // Act
    customerVariableExpression.sortCustomerPaymentsByDefault(savedPayments);

    // Assert
    verify(customerPaymentImpl, atLeast(1)).isDefault();
    assertEquals(3, savedPayments.size());
    assertSame(customerPaymentImpl2, savedPayments.get(1));
  }

  /**
   * Test {@link CustomerVariableExpression#sortCustomerPaymentsByDefault(List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerVariableExpression#sortCustomerPaymentsByDefault(List)}
   */
  @Test
  @DisplayName("Test sortCustomerPaymentsByDefault(List); then ArrayList() size is two")
  void testSortCustomerPaymentsByDefault_thenArrayListSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerVariableExpression customerVariableExpression = new CustomerVariableExpression();

    ArrayList<CustomerPayment> savedPayments = new ArrayList<>();
    savedPayments.add(new CustomerPaymentImpl());
    CustomerPaymentImpl customerPaymentImpl = new CustomerPaymentImpl();
    savedPayments.add(customerPaymentImpl);

    // Act
    customerVariableExpression.sortCustomerPaymentsByDefault(savedPayments);

    // Assert
    assertEquals(2, savedPayments.size());
    assertSame(customerPaymentImpl, savedPayments.get(1));
  }

  /**
   * Test {@link CustomerVariableExpression#sortCustomerPaymentsByDefault(List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerVariableExpression#sortCustomerPaymentsByDefault(List)}
   */
  @Test
  @DisplayName("Test sortCustomerPaymentsByDefault(List); then ArrayList() size is two")
  void testSortCustomerPaymentsByDefault_thenArrayListSizeIsTwo2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerVariableExpression customerVariableExpression = new CustomerVariableExpression();
    CustomerPaymentImpl customerPaymentImpl = mock(CustomerPaymentImpl.class);
    when(customerPaymentImpl.isDefault()).thenReturn(true);

    ArrayList<CustomerPayment> savedPayments = new ArrayList<>();
    savedPayments.add(customerPaymentImpl);
    CustomerPaymentImpl customerPaymentImpl2 = new CustomerPaymentImpl();
    savedPayments.add(customerPaymentImpl2);

    // Act
    customerVariableExpression.sortCustomerPaymentsByDefault(savedPayments);

    // Assert
    verify(customerPaymentImpl).isDefault();
    assertEquals(2, savedPayments.size());
    assertSame(customerPaymentImpl2, savedPayments.get(1));
  }
}

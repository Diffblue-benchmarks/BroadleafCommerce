package org.broadleafcommerce.core.checkout.service.workflow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.payment.PaymentGatewayType;
import org.broadleafcommerce.common.payment.PaymentType;
import org.broadleafcommerce.common.payment.dto.PaymentResponseDTO;
import org.broadleafcommerce.core.payment.domain.PaymentTransaction;
import org.broadleafcommerce.core.payment.domain.PaymentTransactionImpl;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
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
public class ValidateAndConfirmPaymentActivityDiffblueTest {
  @Autowired
  private ValidateAndConfirmPaymentActivity validateAndConfirmPaymentActivity;

  /**
   * Test {@link ValidateAndConfirmPaymentActivity#execute(ProcessContext)}.
   * <p>
   * Method under test:
   * {@link ValidateAndConfirmPaymentActivity#execute(ProcessContext)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testExecute() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.checkout.service.workflow;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1479 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.checkout.service.workflow.ValidateAndConfirmPaymentActivity validateAndConfirmPaymentActivity;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ValidateAndConfirmPaymentActivity validateAndConfirmPaymentActivity2 = new ValidateAndConfirmPaymentActivity(
        new ConfirmPaymentsRollbackHandler());

    // Act
    validateAndConfirmPaymentActivity2.execute((ProcessContext<CheckoutSeed>) new DefaultProcessContextImpl<>());
  }

  /**
   * Test
   * {@link ValidateAndConfirmPaymentActivity#handleUnsuccessfulTransactions(List, ProcessContext)}.
   * <p>
   * Method under test:
   * {@link ValidateAndConfirmPaymentActivity#handleUnsuccessfulTransactions(List, ProcessContext)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testHandleUnsuccessfulTransactions() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.checkout.service.workflow;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1495 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.checkout.service.workflow.ValidateAndConfirmPaymentActivity validateAndConfirmPaymentActivity;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ValidateAndConfirmPaymentActivity validateAndConfirmPaymentActivity2 = new ValidateAndConfirmPaymentActivity(
        new ConfirmPaymentsRollbackHandler());
    ArrayList<ValidateAndConfirmPaymentActivity.ResponseTransactionPair> failedTransactions = new ArrayList<>();

    // Act
    validateAndConfirmPaymentActivity2.handleUnsuccessfulTransactions(failedTransactions,
        new DefaultProcessContextImpl<>());
  }

  /**
   * Test ResponseTransactionPair getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ValidateAndConfirmPaymentActivity.ResponseTransactionPair#ResponseTransactionPair(ValidateAndConfirmPaymentActivity, PaymentResponseDTO, Long)}
   *   <li>
   * {@link ValidateAndConfirmPaymentActivity.ResponseTransactionPair#getResponseDTO()}
   *   <li>
   * {@link ValidateAndConfirmPaymentActivity.ResponseTransactionPair#getTransactionId()}
   * </ul>
   */
  @Test
  public void testResponseTransactionPairGettersAndSetters() {
    // Arrange
    ValidateAndConfirmPaymentActivity validateAndConfirmPaymentActivity = new ValidateAndConfirmPaymentActivity(
        new ConfirmPaymentsRollbackHandler());
    PaymentType paymentType = new PaymentType("Type", "Friendly Type");

    PaymentResponseDTO responseDTO = new PaymentResponseDTO(paymentType,
        new PaymentGatewayType("Type", "Friendly Type"));

    // Act
    ValidateAndConfirmPaymentActivity.ResponseTransactionPair actualResponseTransactionPair = validateAndConfirmPaymentActivity.new ResponseTransactionPair(
        responseDTO, 1L);
    PaymentResponseDTO actualResponseDTO = actualResponseTransactionPair.getResponseDTO();

    // Assert
    assertEquals(1L, actualResponseTransactionPair.getTransactionId().longValue());
    assertSame(responseDTO, actualResponseDTO);
  }

  /**
   * Test ResponseTransactionPair getters and setters.
   * <ul>
   *   <li>Then return TransactionId is {@code null}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ValidateAndConfirmPaymentActivity.ResponseTransactionPair#ResponseTransactionPair(ValidateAndConfirmPaymentActivity)}
   *   <li>
   * {@link ValidateAndConfirmPaymentActivity.ResponseTransactionPair#getResponseDTO()}
   *   <li>
   * {@link ValidateAndConfirmPaymentActivity.ResponseTransactionPair#getTransactionId()}
   * </ul>
   */
  @Test
  public void testResponseTransactionPairGettersAndSetters_thenReturnTransactionIdIsNull() {
    // Arrange and Act
    ValidateAndConfirmPaymentActivity.ResponseTransactionPair actualResponseTransactionPair = (new ValidateAndConfirmPaymentActivity(
        new ConfirmPaymentsRollbackHandler())).new ResponseTransactionPair();
    PaymentResponseDTO actualResponseDTO = actualResponseTransactionPair.getResponseDTO();

    // Assert
    assertNull(actualResponseTransactionPair.getTransactionId());
    assertNull(actualResponseDTO);
  }

  /**
   * Test
   * {@link ValidateAndConfirmPaymentActivity#shouldRollbackFailedTransaction(ResponseTransactionPair)}.
   * <p>
   * Method under test:
   * {@link ValidateAndConfirmPaymentActivity#shouldRollbackFailedTransaction(ValidateAndConfirmPaymentActivity.ResponseTransactionPair)}
   */
  @Test
  public void testShouldRollbackFailedTransaction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAndConfirmPaymentActivity validateAndConfirmPaymentActivity = new ValidateAndConfirmPaymentActivity(
        new ConfirmPaymentsRollbackHandler());

    // Act and Assert
    assertFalse(validateAndConfirmPaymentActivity.shouldRollbackFailedTransaction(
        (new ValidateAndConfirmPaymentActivity(new ConfirmPaymentsRollbackHandler())).new ResponseTransactionPair()));
  }

  /**
   * Test
   * {@link ValidateAndConfirmPaymentActivity#shouldRollbackFailedTransaction(ResponseTransactionPair)}.
   * <p>
   * Method under test:
   * {@link ValidateAndConfirmPaymentActivity#shouldRollbackFailedTransaction(ValidateAndConfirmPaymentActivity.ResponseTransactionPair)}
   */
  @Test
  public void testShouldRollbackFailedTransaction2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAndConfirmPaymentActivity validateAndConfirmPaymentActivity = new ValidateAndConfirmPaymentActivity(
        mock(ConfirmPaymentsRollbackHandler.class));

    // Act and Assert
    assertFalse(validateAndConfirmPaymentActivity.shouldRollbackFailedTransaction(
        (new ValidateAndConfirmPaymentActivity(new ConfirmPaymentsRollbackHandler())).new ResponseTransactionPair()));
  }

  /**
   * Test
   * {@link ValidateAndConfirmPaymentActivity#shouldRollbackFailedTransaction(ResponseTransactionPair)}.
   * <p>
   * Method under test:
   * {@link ValidateAndConfirmPaymentActivity#shouldRollbackFailedTransaction(ValidateAndConfirmPaymentActivity.ResponseTransactionPair)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testShouldRollbackFailedTransaction3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.checkout.service.workflow;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1515 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.checkout.service.workflow.ValidateAndConfirmPaymentActivity validateAndConfirmPaymentActivity;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ValidateAndConfirmPaymentActivity validateAndConfirmPaymentActivity2 = new ValidateAndConfirmPaymentActivity(
        new ConfirmPaymentsRollbackHandler());

    // Act
    validateAndConfirmPaymentActivity2.shouldRollbackFailedTransaction(
        (new ValidateAndConfirmPaymentActivity(new ConfirmPaymentsRollbackHandler())).new ResponseTransactionPair());
  }

  /**
   * Test
   * {@link ValidateAndConfirmPaymentActivity#createCustomerPaymentToken(PaymentTransaction)}.
   * <p>
   * Method under test:
   * {@link ValidateAndConfirmPaymentActivity#createCustomerPaymentToken(PaymentTransaction)}
   */
  @Test
  public void testCreateCustomerPaymentToken() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAndConfirmPaymentActivity validateAndConfirmPaymentActivity = new ValidateAndConfirmPaymentActivity(
        mock(ConfirmPaymentsRollbackHandler.class));

    // Act and Assert
    assertNull(validateAndConfirmPaymentActivity.createCustomerPaymentToken(new PaymentTransactionImpl()));
  }

  /**
   * Test
   * {@link ValidateAndConfirmPaymentActivity#createCustomerPaymentToken(PaymentTransaction)}.
   * <p>
   * Method under test:
   * {@link ValidateAndConfirmPaymentActivity#createCustomerPaymentToken(PaymentTransaction)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateCustomerPaymentToken2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.checkout.service.workflow;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1452 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.checkout.service.workflow.ValidateAndConfirmPaymentActivity validateAndConfirmPaymentActivity;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ValidateAndConfirmPaymentActivity validateAndConfirmPaymentActivity2 = new ValidateAndConfirmPaymentActivity(
        new ConfirmPaymentsRollbackHandler());

    // Act
    validateAndConfirmPaymentActivity2.createCustomerPaymentToken(new PaymentTransactionImpl());
  }

  /**
   * Test
   * {@link ValidateAndConfirmPaymentActivity#createCustomerPaymentToken(PaymentTransaction)}.
   * <ul>
   *   <li>When {@link PaymentTransactionImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateAndConfirmPaymentActivity#createCustomerPaymentToken(PaymentTransaction)}
   */
  @Test
  public void testCreateCustomerPaymentToken_whenPaymentTransactionImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateAndConfirmPaymentActivity validateAndConfirmPaymentActivity = new ValidateAndConfirmPaymentActivity(
        new ConfirmPaymentsRollbackHandler());

    // Act and Assert
    assertNull(validateAndConfirmPaymentActivity.createCustomerPaymentToken(new PaymentTransactionImpl()));
  }
}

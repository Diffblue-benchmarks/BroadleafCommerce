package org.broadleafcommerce.core.payment.service;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.payment.PaymentType;
import org.broadleafcommerce.core.payment.domain.secure.Referenced;
import org.broadleafcommerce.core.workflow.WorkflowException;
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
public class SecureOrderPaymentServiceImplDiffblueTest {
  @Autowired
  private SecureOrderPaymentServiceImpl secureOrderPaymentServiceImpl;

  /**
   * Test {@link SecureOrderPaymentServiceImpl#save(Referenced)}.
   * <p>
   * Method under test: {@link SecureOrderPaymentServiceImpl#save(Referenced)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSave() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2896 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.payment.service.SecureOrderPaymentServiceImpl secureOrderPaymentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SecureOrderPaymentServiceImpl()).save(mock(Referenced.class));
  }

  /**
   * Test {@link SecureOrderPaymentServiceImpl#create(PaymentType)}.
   * <p>
   * Method under test: {@link SecureOrderPaymentServiceImpl#create(PaymentType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreate() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2814 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.payment.service.SecureOrderPaymentServiceImpl secureOrderPaymentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SecureOrderPaymentServiceImpl secureOrderPaymentServiceImpl2 = new SecureOrderPaymentServiceImpl();

    // Act
    secureOrderPaymentServiceImpl2.create(new PaymentType("Type", "Friendly Type"));
  }

  /**
   * Test {@link SecureOrderPaymentServiceImpl#create(PaymentType)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then calls {@link PaymentType#isCreditCardType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecureOrderPaymentServiceImpl#create(PaymentType)}
   */
  @Test
  public void testCreate_givenFalse_thenCallsIsCreditCardType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SecureOrderPaymentServiceImpl secureOrderPaymentServiceImpl = new SecureOrderPaymentServiceImpl();
    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.isCreditCardType()).thenReturn(false);

    // Act
    Referenced actualCreateResult = secureOrderPaymentServiceImpl.create(paymentType);

    // Assert
    verify(paymentType).isCreditCardType();
    assertNull(actualCreateResult);
  }

  /**
   * Test {@link SecureOrderPaymentServiceImpl#create(PaymentType)}.
   * <ul>
   *   <li>When {@link PaymentType#PaymentType(String, String)} with {@code Type}
   * and {@code Friendly Type}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecureOrderPaymentServiceImpl#create(PaymentType)}
   */
  @Test
  public void testCreate_whenPaymentTypeWithTypeAndFriendlyType_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SecureOrderPaymentServiceImpl secureOrderPaymentServiceImpl = new SecureOrderPaymentServiceImpl();

    // Act and Assert
    assertNull(secureOrderPaymentServiceImpl.create(new PaymentType("Type", "Friendly Type")));
  }

  /**
   * Test {@link SecureOrderPaymentServiceImpl#create(PaymentType)}.
   * <ul>
   *   <li>When {@link PaymentType#PaymentType()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SecureOrderPaymentServiceImpl#create(PaymentType)}
   */
  @Test
  public void testCreate_whenPaymentType_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SecureOrderPaymentServiceImpl secureOrderPaymentServiceImpl = new SecureOrderPaymentServiceImpl();

    // Act and Assert
    assertNull(secureOrderPaymentServiceImpl.create(new PaymentType()));
  }

  /**
   * Test
   * {@link SecureOrderPaymentServiceImpl#findSecurePaymentInfo(String, PaymentType)}.
   * <p>
   * Method under test:
   * {@link SecureOrderPaymentServiceImpl#findSecurePaymentInfo(String, PaymentType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindSecurePaymentInfo() throws WorkflowException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2881 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.payment.service.SecureOrderPaymentServiceImpl secureOrderPaymentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SecureOrderPaymentServiceImpl secureOrderPaymentServiceImpl2 = new SecureOrderPaymentServiceImpl();

    // Act
    secureOrderPaymentServiceImpl2.findSecurePaymentInfo("42", new PaymentType("Type", "Friendly Type"));
  }

  /**
   * Test
   * {@link SecureOrderPaymentServiceImpl#findSecurePaymentInfo(String, PaymentType)}.
   * <ul>
   *   <li>When {@link PaymentType#PaymentType(String, String)} with {@code Type}
   * and {@code Friendly Type}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SecureOrderPaymentServiceImpl#findSecurePaymentInfo(String, PaymentType)}
   */
  @Test
  public void testFindSecurePaymentInfo_whenPaymentTypeWithTypeAndFriendlyType_thenReturnNull()
      throws WorkflowException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SecureOrderPaymentServiceImpl secureOrderPaymentServiceImpl = new SecureOrderPaymentServiceImpl();

    // Act and Assert
    assertNull(secureOrderPaymentServiceImpl.findSecurePaymentInfo("42", new PaymentType("Type", "Friendly Type")));
  }

  /**
   * Test
   * {@link SecureOrderPaymentServiceImpl#findAndRemoveSecurePaymentInfo(String, PaymentType)}.
   * <p>
   * Method under test:
   * {@link SecureOrderPaymentServiceImpl#findAndRemoveSecurePaymentInfo(String, PaymentType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindAndRemoveSecurePaymentInfo() throws WorkflowException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2824 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.payment.service.SecureOrderPaymentServiceImpl secureOrderPaymentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SecureOrderPaymentServiceImpl secureOrderPaymentServiceImpl2 = new SecureOrderPaymentServiceImpl();

    // Act
    secureOrderPaymentServiceImpl2.findAndRemoveSecurePaymentInfo("42", new PaymentType("Type", "Friendly Type"));
  }

  /**
   * Test {@link SecureOrderPaymentServiceImpl#remove(Referenced)}.
   * <p>
   * Method under test: {@link SecureOrderPaymentServiceImpl#remove(Referenced)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemove() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2895 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.payment.service.SecureOrderPaymentServiceImpl secureOrderPaymentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SecureOrderPaymentServiceImpl()).remove(mock(Referenced.class));
  }

  /**
   * Test {@link SecureOrderPaymentServiceImpl#findBankAccountInfo(String)}.
   * <p>
   * Method under test:
   * {@link SecureOrderPaymentServiceImpl#findBankAccountInfo(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindBankAccountInfo() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2836 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.payment.service.SecureOrderPaymentServiceImpl secureOrderPaymentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SecureOrderPaymentServiceImpl()).findBankAccountInfo("42");
  }

  /**
   * Test {@link SecureOrderPaymentServiceImpl#findCreditCardInfo(String)}.
   * <p>
   * Method under test:
   * {@link SecureOrderPaymentServiceImpl#findCreditCardInfo(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindCreditCardInfo() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2851 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.payment.service.SecureOrderPaymentServiceImpl secureOrderPaymentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SecureOrderPaymentServiceImpl()).findCreditCardInfo("42");
  }

  /**
   * Test {@link SecureOrderPaymentServiceImpl#findGiftCardInfo(String)}.
   * <p>
   * Method under test:
   * {@link SecureOrderPaymentServiceImpl#findGiftCardInfo(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindGiftCardInfo() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2866 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.payment.service.SecureOrderPaymentServiceImpl secureOrderPaymentServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SecureOrderPaymentServiceImpl()).findGiftCardInfo("42");
  }
}

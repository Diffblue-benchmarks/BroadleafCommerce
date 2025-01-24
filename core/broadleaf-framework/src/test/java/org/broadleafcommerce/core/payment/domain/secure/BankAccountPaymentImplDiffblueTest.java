package org.broadleafcommerce.core.payment.domain.secure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.encryption.EncryptionModule;
import org.broadleafcommerce.common.encryption.PassthroughEncryptionModule;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class BankAccountPaymentImplDiffblueTest {
  @Autowired
  private BankAccountPaymentImpl bankAccountPaymentImpl;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link BankAccountPaymentImpl}
   *   <li>{@link BankAccountPaymentImpl#setEncryptionModule(EncryptionModule)}
   *   <li>{@link BankAccountPaymentImpl#setId(Long)}
   *   <li>{@link BankAccountPaymentImpl#setReferenceNumber(String)}
   *   <li>{@link BankAccountPaymentImpl#getEncryptionModule()}
   *   <li>{@link BankAccountPaymentImpl#getId()}
   *   <li>{@link BankAccountPaymentImpl#getReferenceNumber()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    BankAccountPaymentImpl actualBankAccountPaymentImpl = new BankAccountPaymentImpl();
    PassthroughEncryptionModule encryptionModule = new PassthroughEncryptionModule();
    actualBankAccountPaymentImpl.setEncryptionModule(encryptionModule);
    actualBankAccountPaymentImpl.setId(1L);
    actualBankAccountPaymentImpl.setReferenceNumber("42");
    EncryptionModule actualEncryptionModule = actualBankAccountPaymentImpl.getEncryptionModule();
    Long actualId = actualBankAccountPaymentImpl.getId();

    // Assert that nothing has changed
    assertTrue(actualEncryptionModule instanceof PassthroughEncryptionModule);
    assertEquals("42", actualBankAccountPaymentImpl.getReferenceNumber());
    assertEquals(1L, actualId.longValue());
    assertSame(encryptionModule, actualEncryptionModule);
  }

  /**
   * Test {@link BankAccountPaymentImpl#getAccountNumber()}.
   * <p>
   * Method under test: {@link BankAccountPaymentImpl#getAccountNumber()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetAccountNumber() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.payment.domain.secure;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1554 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.payment.domain.secure.BankAccountPaymentImpl bankAccountPaymentImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new BankAccountPaymentImpl()).getAccountNumber();
  }

  /**
   * Test {@link BankAccountPaymentImpl#getAccountNumber()}.
   * <ul>
   *   <li>Then return {@code Decrypt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BankAccountPaymentImpl#getAccountNumber()}
   */
  @Test
  public void testGetAccountNumber_thenReturnDecrypt() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PassthroughEncryptionModule encryptionModule = mock(PassthroughEncryptionModule.class);
    when(encryptionModule.decrypt(Mockito.<String>any())).thenReturn("Decrypt");

    BankAccountPaymentImpl bankAccountPaymentImpl = new BankAccountPaymentImpl();
    bankAccountPaymentImpl.setEncryptionModule(encryptionModule);

    // Act
    String actualAccountNumber = bankAccountPaymentImpl.getAccountNumber();

    // Assert
    verify(encryptionModule).decrypt(isNull());
    assertEquals("Decrypt", actualAccountNumber);
  }

  /**
   * Test {@link BankAccountPaymentImpl#getAccountNumber()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BankAccountPaymentImpl#getAccountNumber()}
   */
  @Test
  public void testGetAccountNumber_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BankAccountPaymentImpl bankAccountPaymentImpl = new BankAccountPaymentImpl();
    bankAccountPaymentImpl.setEncryptionModule(new PassthroughEncryptionModule());

    // Act and Assert
    assertNull(bankAccountPaymentImpl.getAccountNumber());
  }

  /**
   * Test {@link BankAccountPaymentImpl#setAccountNumber(String)}.
   * <p>
   * Method under test: {@link BankAccountPaymentImpl#setAccountNumber(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetAccountNumber() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.payment.domain.secure;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1568 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.payment.domain.secure.BankAccountPaymentImpl bankAccountPaymentImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new BankAccountPaymentImpl()).setAccountNumber("42");
  }

  /**
   * Test {@link BankAccountPaymentImpl#setAccountNumber(String)}.
   * <ul>
   *   <li>Then {@link BankAccountPaymentImpl#BankAccountPaymentImpl()}
   * AccountNumber is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BankAccountPaymentImpl#setAccountNumber(String)}
   */
  @Test
  public void testSetAccountNumber_thenBankAccountPaymentImplAccountNumberIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BankAccountPaymentImpl bankAccountPaymentImpl = new BankAccountPaymentImpl();
    bankAccountPaymentImpl.setEncryptionModule(new PassthroughEncryptionModule());

    // Act
    bankAccountPaymentImpl.setAccountNumber("42");

    // Assert
    assertEquals("42", bankAccountPaymentImpl.getAccountNumber());
    assertEquals("42", bankAccountPaymentImpl.accountNumber);
  }

  /**
   * Test {@link BankAccountPaymentImpl#setAccountNumber(String)}.
   * <ul>
   *   <li>Then {@link BankAccountPaymentImpl#BankAccountPaymentImpl()}
   * {@link BankAccountPaymentImpl#accountNumber} is {@code Encrypt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BankAccountPaymentImpl#setAccountNumber(String)}
   */
  @Test
  public void testSetAccountNumber_thenBankAccountPaymentImplAccountNumberIsEncrypt() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PassthroughEncryptionModule encryptionModule = mock(PassthroughEncryptionModule.class);
    when(encryptionModule.encrypt(Mockito.<String>any())).thenReturn("Encrypt");

    BankAccountPaymentImpl bankAccountPaymentImpl = new BankAccountPaymentImpl();
    bankAccountPaymentImpl.setEncryptionModule(encryptionModule);

    // Act
    bankAccountPaymentImpl.setAccountNumber("42");

    // Assert
    verify(encryptionModule).encrypt(eq("42"));
    assertEquals("Encrypt", bankAccountPaymentImpl.accountNumber);
    assertNull(bankAccountPaymentImpl.getAccountNumber());
  }

  /**
   * Test {@link BankAccountPaymentImpl#getRoutingNumber()}.
   * <p>
   * Method under test: {@link BankAccountPaymentImpl#getRoutingNumber()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetRoutingNumber() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.payment.domain.secure;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1561 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.payment.domain.secure.BankAccountPaymentImpl bankAccountPaymentImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new BankAccountPaymentImpl()).getRoutingNumber();
  }

  /**
   * Test {@link BankAccountPaymentImpl#getRoutingNumber()}.
   * <ul>
   *   <li>Then return {@code Decrypt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BankAccountPaymentImpl#getRoutingNumber()}
   */
  @Test
  public void testGetRoutingNumber_thenReturnDecrypt() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PassthroughEncryptionModule encryptionModule = mock(PassthroughEncryptionModule.class);
    when(encryptionModule.decrypt(Mockito.<String>any())).thenReturn("Decrypt");

    BankAccountPaymentImpl bankAccountPaymentImpl = new BankAccountPaymentImpl();
    bankAccountPaymentImpl.setEncryptionModule(encryptionModule);

    // Act
    String actualRoutingNumber = bankAccountPaymentImpl.getRoutingNumber();

    // Assert
    verify(encryptionModule).decrypt(isNull());
    assertEquals("Decrypt", actualRoutingNumber);
  }

  /**
   * Test {@link BankAccountPaymentImpl#getRoutingNumber()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BankAccountPaymentImpl#getRoutingNumber()}
   */
  @Test
  public void testGetRoutingNumber_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BankAccountPaymentImpl bankAccountPaymentImpl = new BankAccountPaymentImpl();
    bankAccountPaymentImpl.setEncryptionModule(new PassthroughEncryptionModule());

    // Act and Assert
    assertNull(bankAccountPaymentImpl.getRoutingNumber());
  }

  /**
   * Test {@link BankAccountPaymentImpl#setRoutingNumber(String)}.
   * <p>
   * Method under test: {@link BankAccountPaymentImpl#setRoutingNumber(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetRoutingNumber() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.payment.domain.secure;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1598 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.payment.domain.secure.BankAccountPaymentImpl bankAccountPaymentImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new BankAccountPaymentImpl()).setRoutingNumber("42");
  }

  /**
   * Test {@link BankAccountPaymentImpl#setRoutingNumber(String)}.
   * <ul>
   *   <li>Then {@link BankAccountPaymentImpl#BankAccountPaymentImpl()}
   * RoutingNumber is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BankAccountPaymentImpl#setRoutingNumber(String)}
   */
  @Test
  public void testSetRoutingNumber_thenBankAccountPaymentImplRoutingNumberIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BankAccountPaymentImpl bankAccountPaymentImpl = new BankAccountPaymentImpl();
    bankAccountPaymentImpl.setEncryptionModule(new PassthroughEncryptionModule());

    // Act
    bankAccountPaymentImpl.setRoutingNumber("42");

    // Assert
    assertEquals("42", bankAccountPaymentImpl.getRoutingNumber());
    assertEquals("42", bankAccountPaymentImpl.routingNumber);
  }

  /**
   * Test {@link BankAccountPaymentImpl#setRoutingNumber(String)}.
   * <ul>
   *   <li>Then {@link BankAccountPaymentImpl#BankAccountPaymentImpl()}
   * {@link BankAccountPaymentImpl#routingNumber} is {@code Encrypt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BankAccountPaymentImpl#setRoutingNumber(String)}
   */
  @Test
  public void testSetRoutingNumber_thenBankAccountPaymentImplRoutingNumberIsEncrypt() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PassthroughEncryptionModule encryptionModule = mock(PassthroughEncryptionModule.class);
    when(encryptionModule.encrypt(Mockito.<String>any())).thenReturn("Encrypt");

    BankAccountPaymentImpl bankAccountPaymentImpl = new BankAccountPaymentImpl();
    bankAccountPaymentImpl.setEncryptionModule(encryptionModule);

    // Act
    bankAccountPaymentImpl.setRoutingNumber("42");

    // Assert
    verify(encryptionModule).encrypt(eq("42"));
    assertEquals("Encrypt", bankAccountPaymentImpl.routingNumber);
    assertNull(bankAccountPaymentImpl.getRoutingNumber());
  }

  /**
   * Test {@link BankAccountPaymentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   * </ul>
   * <p>
   * Method under test: {@link BankAccountPaymentImpl#equals(Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testEquals_whenOtherIsDifferent() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.payment.domain.secure.BankAccountPaymentImpl.setAccountNumber(BankAccountPaymentImpl.java:109)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    BankAccountPaymentImpl bankAccountPaymentImpl = new BankAccountPaymentImpl();
    bankAccountPaymentImpl.setAccountNumber("42");
    bankAccountPaymentImpl.setEncryptionModule(new PassthroughEncryptionModule());
    bankAccountPaymentImpl.setId(1L);
    bankAccountPaymentImpl.setReferenceNumber("42");
    bankAccountPaymentImpl.setRoutingNumber("42");

    BankAccountPaymentImpl bankAccountPaymentImpl2 = new BankAccountPaymentImpl();
    bankAccountPaymentImpl2.setAccountNumber("42");
    bankAccountPaymentImpl2.setEncryptionModule(new PassthroughEncryptionModule());
    bankAccountPaymentImpl2.setId(1L);
    bankAccountPaymentImpl2.setReferenceNumber("42");
    bankAccountPaymentImpl2.setRoutingNumber("42");

    // Act
    bankAccountPaymentImpl.equals(bankAccountPaymentImpl2);
  }

  /**
   * Test {@link BankAccountPaymentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BankAccountPaymentImpl#equals(Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testEquals_whenOtherIsNull() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BankAccountPaymentImpl bankAccountPaymentImpl = new BankAccountPaymentImpl();
    bankAccountPaymentImpl.setAccountNumber("42");
    bankAccountPaymentImpl.setEncryptionModule(new PassthroughEncryptionModule());
    bankAccountPaymentImpl.setId(1L);
    bankAccountPaymentImpl.setReferenceNumber("42");
    bankAccountPaymentImpl.setRoutingNumber("42");

    // Act
    bankAccountPaymentImpl.equals(null);
  }

  /**
   * Test {@link BankAccountPaymentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is same.</li>
   * </ul>
   * <p>
   * Method under test: {@link BankAccountPaymentImpl#equals(Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testEquals_whenOtherIsSame() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BankAccountPaymentImpl bankAccountPaymentImpl = new BankAccountPaymentImpl();
    bankAccountPaymentImpl.setAccountNumber("42");
    bankAccountPaymentImpl.setEncryptionModule(new PassthroughEncryptionModule());
    bankAccountPaymentImpl.setId(1L);
    bankAccountPaymentImpl.setReferenceNumber("42");
    bankAccountPaymentImpl.setRoutingNumber("42");

    // Act
    bankAccountPaymentImpl.equals(bankAccountPaymentImpl);
  }

  /**
   * Test {@link BankAccountPaymentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   * </ul>
   * <p>
   * Method under test: {@link BankAccountPaymentImpl#equals(Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testEquals_whenOtherIsWrongType() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BankAccountPaymentImpl bankAccountPaymentImpl = new BankAccountPaymentImpl();
    bankAccountPaymentImpl.setAccountNumber("42");
    bankAccountPaymentImpl.setEncryptionModule(new PassthroughEncryptionModule());
    bankAccountPaymentImpl.setId(1L);
    bankAccountPaymentImpl.setReferenceNumber("42");
    bankAccountPaymentImpl.setRoutingNumber("42");

    // Act
    bankAccountPaymentImpl.equals("Different type to BankAccountPaymentImpl");
  }
}

package org.broadleafcommerce.core.payment.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import org.broadleafcommerce.common.payment.PaymentGatewayType;
import org.broadleafcommerce.common.payment.PaymentType;
import org.broadleafcommerce.common.payment.dto.AddressDTO;
import org.broadleafcommerce.common.payment.dto.CreditCardDTO;
import org.broadleafcommerce.common.payment.dto.PaymentResponseDTO;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.payment.domain.OrderPayment;
import org.broadleafcommerce.core.payment.domain.OrderPaymentImpl;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.CustomerPayment;
import org.broadleafcommerce.profile.core.domain.CustomerPaymentImpl;
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
public class PaymentResponseDTOToEntityServiceImplDiffblueTest {
  @Autowired
  private PaymentResponseDTOToEntityServiceImpl paymentResponseDTOToEntityServiceImpl;

  /**
   * Test
   * {@link PaymentResponseDTOToEntityServiceImpl#populateBillingInfo(PaymentResponseDTO, OrderPayment, Address, boolean)}.
   * <p>
   * Method under test:
   * {@link PaymentResponseDTOToEntityServiceImpl#populateBillingInfo(PaymentResponseDTO, OrderPayment, Address, boolean)}
   */
  @Test
  public void testPopulateBillingInfo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentResponseDTOToEntityServiceImpl paymentResponseDTOToEntityServiceImpl = new PaymentResponseDTOToEntityServiceImpl();
    PaymentType paymentType = mock(PaymentType.class);
    PaymentResponseDTO responseDTO = new PaymentResponseDTO(paymentType,
        new PaymentGatewayType("Type", "Friendly Type"));

    OrderPaymentImpl payment = new OrderPaymentImpl();
    AddressImpl tempBillingAddress = new AddressImpl();

    // Act
    paymentResponseDTOToEntityServiceImpl.populateBillingInfo(responseDTO, payment, tempBillingAddress, true);

    // Assert
    assertSame(tempBillingAddress, payment.getBillingAddress());
  }

  /**
   * Test
   * {@link PaymentResponseDTOToEntityServiceImpl#populateBillingInfo(PaymentResponseDTO, OrderPayment, Address, boolean)}.
   * <p>
   * Method under test:
   * {@link PaymentResponseDTOToEntityServiceImpl#populateBillingInfo(PaymentResponseDTO, OrderPayment, Address, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPopulateBillingInfo2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2724 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.payment.service.PaymentResponseDTOToEntityServiceImpl paymentResponseDTOToEntityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PaymentResponseDTOToEntityServiceImpl paymentResponseDTOToEntityServiceImpl2 = new PaymentResponseDTOToEntityServiceImpl();
    PaymentType paymentType = new PaymentType("Type", "Friendly Type");

    PaymentResponseDTO responseDTO = new PaymentResponseDTO(paymentType,
        new PaymentGatewayType("Type", "Friendly Type"));

    OrderPaymentImpl payment = new OrderPaymentImpl();

    // Act
    paymentResponseDTOToEntityServiceImpl2.populateBillingInfo(responseDTO, payment, new AddressImpl(), true);
  }

  /**
   * Test
   * {@link PaymentResponseDTOToEntityServiceImpl#populateBillingInfo(PaymentResponseDTO, OrderPayment, Address, boolean)}.
   * <ul>
   *   <li>Given {@link AddressDTO#AddressDTO()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentResponseDTOToEntityServiceImpl#populateBillingInfo(PaymentResponseDTO, OrderPayment, Address, boolean)}
   */
  @Test
  public void testPopulateBillingInfo_givenAddressDTO() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentResponseDTOToEntityServiceImpl paymentResponseDTOToEntityServiceImpl = new PaymentResponseDTOToEntityServiceImpl();
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getBillTo()).thenReturn(new AddressDTO<>());
    OrderPaymentImpl payment = new OrderPaymentImpl();
    AddressImpl tempBillingAddress = new AddressImpl();

    // Act
    paymentResponseDTOToEntityServiceImpl.populateBillingInfo(responseDTO, payment, tempBillingAddress, true);

    // Assert
    verify(responseDTO, atLeast(1)).getBillTo();
    assertSame(tempBillingAddress, payment.getBillingAddress());
  }

  /**
   * Test
   * {@link PaymentResponseDTOToEntityServiceImpl#populateBillingInfo(PaymentResponseDTO, OrderPayment, Address, boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then calls {@link AddressDTO#addressPopulated()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentResponseDTOToEntityServiceImpl#populateBillingInfo(PaymentResponseDTO, OrderPayment, Address, boolean)}
   */
  @Test
  public void testPopulateBillingInfo_whenFalse_thenCallsAddressPopulated() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentResponseDTOToEntityServiceImpl paymentResponseDTOToEntityServiceImpl = new PaymentResponseDTOToEntityServiceImpl();
    AddressDTO<PaymentResponseDTO> addressDTO = mock(AddressDTO.class);
    when(addressDTO.addressPopulated()).thenReturn(true);
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getBillTo()).thenReturn(addressDTO);
    OrderPaymentImpl payment = new OrderPaymentImpl();
    AddressImpl tempBillingAddress = new AddressImpl();

    // Act
    paymentResponseDTOToEntityServiceImpl.populateBillingInfo(responseDTO, payment, tempBillingAddress, false);

    // Assert
    verify(addressDTO).addressPopulated();
    verify(responseDTO, atLeast(1)).getBillTo();
    assertSame(tempBillingAddress, payment.getBillingAddress());
  }

  /**
   * Test
   * {@link PaymentResponseDTOToEntityServiceImpl#populateBillingInfo(PaymentResponseDTO, OrderPayment, Address, boolean)}.
   * <ul>
   *   <li>When {@link PaymentType#PaymentType(String, String)} with {@code Type}
   * and {@code Friendly Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentResponseDTOToEntityServiceImpl#populateBillingInfo(PaymentResponseDTO, OrderPayment, Address, boolean)}
   */
  @Test
  public void testPopulateBillingInfo_whenPaymentTypeWithTypeAndFriendlyType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentResponseDTOToEntityServiceImpl paymentResponseDTOToEntityServiceImpl = new PaymentResponseDTOToEntityServiceImpl();
    PaymentType paymentType = new PaymentType("Type", "Friendly Type");

    PaymentResponseDTO responseDTO = new PaymentResponseDTO(paymentType,
        new PaymentGatewayType("Type", "Friendly Type"));

    OrderPaymentImpl payment = new OrderPaymentImpl();
    AddressImpl tempBillingAddress = new AddressImpl();

    // Act
    paymentResponseDTOToEntityServiceImpl.populateBillingInfo(responseDTO, payment, tempBillingAddress, true);

    // Assert
    assertSame(tempBillingAddress, payment.getBillingAddress());
  }

  /**
   * Test
   * {@link PaymentResponseDTOToEntityServiceImpl#populateShippingInfo(PaymentResponseDTO, Order)}.
   * <p>
   * Method under test:
   * {@link PaymentResponseDTOToEntityServiceImpl#populateShippingInfo(PaymentResponseDTO, Order)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPopulateShippingInfo() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2784 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.payment.service.PaymentResponseDTOToEntityServiceImpl paymentResponseDTOToEntityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PaymentResponseDTOToEntityServiceImpl paymentResponseDTOToEntityServiceImpl2 = new PaymentResponseDTOToEntityServiceImpl();
    PaymentType paymentType = new PaymentType("Type", "Friendly Type");

    PaymentResponseDTO responseDTO = new PaymentResponseDTO(paymentType,
        new PaymentGatewayType("Type", "Friendly Type"));

    // Act
    paymentResponseDTOToEntityServiceImpl2.populateShippingInfo(responseDTO, new NullOrderImpl());
  }

  /**
   * Test
   * {@link PaymentResponseDTOToEntityServiceImpl#populateAddressInfo(AddressDTO, Address)}.
   * <p>
   * Method under test:
   * {@link PaymentResponseDTOToEntityServiceImpl#populateAddressInfo(AddressDTO, Address)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPopulateAddressInfo() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2694 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.payment.service.PaymentResponseDTOToEntityServiceImpl paymentResponseDTOToEntityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PaymentResponseDTOToEntityServiceImpl paymentResponseDTOToEntityServiceImpl2 = new PaymentResponseDTOToEntityServiceImpl();
    AddressDTO<PaymentResponseDTO> dto = new AddressDTO<>();

    // Act
    paymentResponseDTOToEntityServiceImpl2.populateAddressInfo(dto, new AddressImpl());
  }

  /**
   * Test
   * {@link PaymentResponseDTOToEntityServiceImpl#populateCustomerPaymentToken(PaymentResponseDTO, CustomerPayment)}.
   * <p>
   * Method under test:
   * {@link PaymentResponseDTOToEntityServiceImpl#populateCustomerPaymentToken(PaymentResponseDTO, CustomerPayment)}
   */
  @Test
  public void testPopulateCustomerPaymentToken() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentResponseDTOToEntityServiceImpl paymentResponseDTOToEntityServiceImpl = new PaymentResponseDTOToEntityServiceImpl();
    PaymentType paymentType = mock(PaymentType.class);
    PaymentResponseDTO responseDTO = new PaymentResponseDTO(paymentType,
        new PaymentGatewayType("Type", "Friendly Type"));

    CustomerPaymentImpl customerPayment = new CustomerPaymentImpl();

    // Act
    paymentResponseDTOToEntityServiceImpl.populateCustomerPaymentToken(responseDTO, customerPayment);

    // Assert that nothing has changed
    assertNull(customerPayment.getPaymentToken());
  }

  /**
   * Test
   * {@link PaymentResponseDTOToEntityServiceImpl#populateCustomerPaymentToken(PaymentResponseDTO, CustomerPayment)}.
   * <p>
   * Method under test:
   * {@link PaymentResponseDTOToEntityServiceImpl#populateCustomerPaymentToken(PaymentResponseDTO, CustomerPayment)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPopulateCustomerPaymentToken2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2754 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.payment.service.PaymentResponseDTOToEntityServiceImpl paymentResponseDTOToEntityServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PaymentResponseDTOToEntityServiceImpl paymentResponseDTOToEntityServiceImpl2 = new PaymentResponseDTOToEntityServiceImpl();
    PaymentType paymentType = new PaymentType("Type", "Friendly Type");

    PaymentResponseDTO responseDTO = new PaymentResponseDTO(paymentType,
        new PaymentGatewayType("Type", "Friendly Type"));

    // Act
    paymentResponseDTOToEntityServiceImpl2.populateCustomerPaymentToken(responseDTO, new CustomerPaymentImpl());
  }

  /**
   * Test
   * {@link PaymentResponseDTOToEntityServiceImpl#populateCustomerPaymentToken(PaymentResponseDTO, CustomerPayment)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then calls {@link PaymentResponseDTO#getCreditCard()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentResponseDTOToEntityServiceImpl#populateCustomerPaymentToken(PaymentResponseDTO, CustomerPayment)}
   */
  @Test
  public void testPopulateCustomerPaymentToken_givenNull_thenCallsGetCreditCard() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentResponseDTOToEntityServiceImpl paymentResponseDTOToEntityServiceImpl = new PaymentResponseDTOToEntityServiceImpl();
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getPaymentToken()).thenReturn(null);
    when(responseDTO.getResponseMap()).thenReturn(new HashMap<>());
    when(responseDTO.getCreditCard()).thenReturn(new CreditCardDTO<>());
    CustomerPaymentImpl customerPayment = new CustomerPaymentImpl();

    // Act
    paymentResponseDTOToEntityServiceImpl.populateCustomerPaymentToken(responseDTO, customerPayment);

    // Assert
    verify(responseDTO, atLeast(1)).getCreditCard();
    verify(responseDTO).getPaymentToken();
    verify(responseDTO).getResponseMap();
    assertNull(customerPayment.getPaymentToken());
  }

  /**
   * Test
   * {@link PaymentResponseDTOToEntityServiceImpl#populateCustomerPaymentToken(PaymentResponseDTO, CustomerPayment)}.
   * <ul>
   *   <li>Then {@link CustomerPaymentImpl} (default constructor) PaymentToken is
   * {@code ABC123}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentResponseDTOToEntityServiceImpl#populateCustomerPaymentToken(PaymentResponseDTO, CustomerPayment)}
   */
  @Test
  public void testPopulateCustomerPaymentToken_thenCustomerPaymentImplPaymentTokenIsAbc123() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentResponseDTOToEntityServiceImpl paymentResponseDTOToEntityServiceImpl = new PaymentResponseDTOToEntityServiceImpl();
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getPaymentToken()).thenReturn("ABC123");
    CustomerPaymentImpl customerPayment = new CustomerPaymentImpl();

    // Act
    paymentResponseDTOToEntityServiceImpl.populateCustomerPaymentToken(responseDTO, customerPayment);

    // Assert
    verify(responseDTO, atLeast(1)).getPaymentToken();
    assertEquals("ABC123", customerPayment.getPaymentToken());
  }

  /**
   * Test
   * {@link PaymentResponseDTOToEntityServiceImpl#populateCustomerPaymentToken(PaymentResponseDTO, CustomerPayment)}.
   * <ul>
   *   <li>When {@link PaymentType#PaymentType(String, String)} with {@code Type}
   * and {@code Friendly Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentResponseDTOToEntityServiceImpl#populateCustomerPaymentToken(PaymentResponseDTO, CustomerPayment)}
   */
  @Test
  public void testPopulateCustomerPaymentToken_whenPaymentTypeWithTypeAndFriendlyType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentResponseDTOToEntityServiceImpl paymentResponseDTOToEntityServiceImpl = new PaymentResponseDTOToEntityServiceImpl();
    PaymentType paymentType = new PaymentType("Type", "Friendly Type");

    PaymentResponseDTO responseDTO = new PaymentResponseDTO(paymentType,
        new PaymentGatewayType("Type", "Friendly Type"));

    CustomerPaymentImpl customerPayment = new CustomerPaymentImpl();

    // Act
    paymentResponseDTOToEntityServiceImpl.populateCustomerPaymentToken(responseDTO, customerPayment);

    // Assert that nothing has changed
    assertNull(customerPayment.getPaymentToken());
  }
}

/*-
 * #%L
 * BroadleafCommerce Profile
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.profile.core.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.payment.PaymentGatewayType;
import org.broadleafcommerce.common.payment.PaymentType;
import org.junit.Test;
import org.mockito.Mockito;

public class CustomerPaymentImplDiffblueTest {
  /**
   * Test {@link CustomerPaymentImpl#getPaymentType()}.
   * <ul>
   *   <li>Given {@link PaymentType} {@link PaymentType#getType()} return
   * {@code Type}.</li>
   *   <li>Then return {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerPaymentImpl#getPaymentType()}
   */
  @Test
  public void testGetPaymentType_givenPaymentTypeGetTypeReturnType_thenReturnType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.getType()).thenReturn("Type");

    CustomerPaymentImpl customerPaymentImpl = new CustomerPaymentImpl();
    customerPaymentImpl.setPaymentType(paymentType);

    // Act
    PaymentType actualPaymentType = customerPaymentImpl.getPaymentType();

    // Assert
    verify(paymentType).getType();
    assertEquals("Friendly Type", actualPaymentType.getFriendlyType());
    assertEquals("Type", actualPaymentType.getType());
    assertFalse(actualPaymentType.getIsFinalPayment());
    assertFalse(actualPaymentType.isCreditCardType());
  }

  /**
   * Test {@link CustomerPaymentImpl#getPaymentType()}.
   * <ul>
   *   <li>Then return {@link PaymentType#PaymentType(String, String)} with
   * {@code Type} and {@code Friendly Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerPaymentImpl#getPaymentType()}
   */
  @Test
  public void testGetPaymentType_thenReturnPaymentTypeWithTypeAndFriendlyType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerPaymentImpl customerPaymentImpl = new CustomerPaymentImpl();
    PaymentType paymentType = new PaymentType("Type", "Friendly Type");

    customerPaymentImpl.setPaymentType(paymentType);

    // Act and Assert
    assertEquals(paymentType, customerPaymentImpl.getPaymentType());
  }

  /**
   * Test {@link CustomerPaymentImpl#setPaymentType(PaymentType)}.
   * <p>
   * Method under test: {@link CustomerPaymentImpl#setPaymentType(PaymentType)}
   */
  @Test
  public void testSetPaymentType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerPaymentImpl customerPaymentImpl = new CustomerPaymentImpl();
    PaymentType paymentType = new PaymentType("Type", "Friendly Type");

    // Act
    customerPaymentImpl.setPaymentType(paymentType);

    // Assert
    assertEquals("Type", customerPaymentImpl.paymentType);
    assertEquals(paymentType, customerPaymentImpl.getPaymentType());
  }

  /**
   * Test {@link CustomerPaymentImpl#setPaymentType(PaymentType)}.
   * <ul>
   *   <li>Given {@code Type}.</li>
   *   <li>Then {@link CustomerPaymentImpl} (default constructor) PaymentType Type
   * is {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerPaymentImpl#setPaymentType(PaymentType)}
   */
  @Test
  public void testSetPaymentType_givenType_thenCustomerPaymentImplPaymentTypeTypeIsType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerPaymentImpl customerPaymentImpl = new CustomerPaymentImpl();
    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.getType()).thenReturn("Type");

    // Act
    customerPaymentImpl.setPaymentType(paymentType);

    // Assert
    verify(paymentType).getType();
    assertEquals("Type", customerPaymentImpl.getPaymentType().getType());
    assertEquals("Type", customerPaymentImpl.paymentType);
  }

  /**
   * Test {@link CustomerPaymentImpl#getPaymentGatewayType()}.
   * <ul>
   *   <li>Given {@link CustomerPaymentImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerPaymentImpl#getPaymentGatewayType()}
   */
  @Test
  public void testGetPaymentGatewayType_givenCustomerPaymentImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CustomerPaymentImpl()).getPaymentGatewayType());
  }

  /**
   * Test {@link CustomerPaymentImpl#getPaymentGatewayType()}.
   * <ul>
   *   <li>Given {@link CustomerPaymentImpl} (default constructor) Customer is
   * {@link CustomerImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerPaymentImpl#getPaymentGatewayType()}
   */
  @Test
  public void testGetPaymentGatewayType_givenCustomerPaymentImplCustomerIsCustomerImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerPaymentImpl customerPaymentImpl = new CustomerPaymentImpl();
    customerPaymentImpl.setCustomer(mock(CustomerImpl.class));

    // Act and Assert
    assertNull(customerPaymentImpl.getPaymentGatewayType());
  }

  /**
   * Test {@link CustomerPaymentImpl#setPaymentGatewayType(PaymentGatewayType)}.
   * <p>
   * Method under test:
   * {@link CustomerPaymentImpl#setPaymentGatewayType(PaymentGatewayType)}
   */
  @Test
  public void testSetPaymentGatewayType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerPaymentImpl customerPaymentImpl = new CustomerPaymentImpl();
    PaymentGatewayType paymentGatewayType = new PaymentGatewayType("Type", "Friendly Type");

    // Act
    customerPaymentImpl.setPaymentGatewayType(paymentGatewayType);

    // Assert
    assertEquals("Type", customerPaymentImpl.paymentGatewayType);
    assertEquals(paymentGatewayType, customerPaymentImpl.getPaymentGatewayType());
  }

  /**
   * Test {@link CustomerPaymentImpl#setPaymentGatewayType(PaymentGatewayType)}.
   * <ul>
   *   <li>Then {@link CustomerPaymentImpl} (default constructor) PaymentGatewayType
   * Type is {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerPaymentImpl#setPaymentGatewayType(PaymentGatewayType)}
   */
  @Test
  public void testSetPaymentGatewayType_thenCustomerPaymentImplPaymentGatewayTypeTypeIsType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerPaymentImpl customerPaymentImpl = new CustomerPaymentImpl();
    PaymentGatewayType paymentGatewayType = mock(PaymentGatewayType.class);
    when(paymentGatewayType.getType()).thenReturn("Type");

    // Act
    customerPaymentImpl.setPaymentGatewayType(paymentGatewayType);

    // Assert
    verify(paymentGatewayType).getType();
    assertEquals("Type", customerPaymentImpl.getPaymentGatewayType().getType());
    assertEquals("Type", customerPaymentImpl.paymentGatewayType);
  }

  /**
   * Test
   * {@link CustomerPaymentImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link CustomerPaymentImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerPaymentImpl customerPaymentImpl = new CustomerPaymentImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<CustomerPayment> actualCreateOrRetrieveCopyInstanceResult = customerPaymentImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CustomerPaymentImpl}
   *   <li>{@link CustomerPaymentImpl#setAdditionalFields(Map)}
   *   <li>{@link CustomerPaymentImpl#setBillingAddress(Address)}
   *   <li>{@link CustomerPaymentImpl#setCustomer(Customer)}
   *   <li>{@link CustomerPaymentImpl#setId(Long)}
   *   <li>{@link CustomerPaymentImpl#setIsDefault(boolean)}
   *   <li>{@link CustomerPaymentImpl#setPaymentToken(String)}
   *   <li>{@link CustomerPaymentImpl#getAdditionalFields()}
   *   <li>{@link CustomerPaymentImpl#getBillingAddress()}
   *   <li>{@link CustomerPaymentImpl#getCustomer()}
   *   <li>{@link CustomerPaymentImpl#getId()}
   *   <li>{@link CustomerPaymentImpl#getPaymentToken()}
   *   <li>{@link CustomerPaymentImpl#isDefault()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    CustomerPaymentImpl actualCustomerPaymentImpl = new CustomerPaymentImpl();
    HashMap<String, String> additionalFields = new HashMap<>();
    actualCustomerPaymentImpl.setAdditionalFields(additionalFields);
    AddressImpl billingAddress = new AddressImpl();
    actualCustomerPaymentImpl.setBillingAddress(billingAddress);
    CustomerImpl customer = new CustomerImpl();
    actualCustomerPaymentImpl.setCustomer(customer);
    actualCustomerPaymentImpl.setId(1L);
    actualCustomerPaymentImpl.setIsDefault(true);
    actualCustomerPaymentImpl.setPaymentToken("ABC123");
    Map<String, String> actualAdditionalFields = actualCustomerPaymentImpl.getAdditionalFields();
    Address actualBillingAddress = actualCustomerPaymentImpl.getBillingAddress();
    Customer actualCustomer = actualCustomerPaymentImpl.getCustomer();
    Long actualId = actualCustomerPaymentImpl.getId();
    String actualPaymentToken = actualCustomerPaymentImpl.getPaymentToken();
    boolean actualIsDefaultResult = actualCustomerPaymentImpl.isDefault();

    // Assert that nothing has changed
    assertEquals("ABC123", actualPaymentToken);
    assertEquals(1L, actualId.longValue());
    assertTrue(actualAdditionalFields.isEmpty());
    assertTrue(actualIsDefaultResult);
    assertSame(additionalFields, actualAdditionalFields);
    assertSame(billingAddress, actualBillingAddress);
    assertSame(customer, actualCustomer);
  }
}

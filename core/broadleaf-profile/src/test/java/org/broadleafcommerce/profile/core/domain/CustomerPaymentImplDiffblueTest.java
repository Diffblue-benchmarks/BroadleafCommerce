/*-
 * #%L
 * BroadleafCommerce Profile
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.payment.PaymentGatewayType;
import org.broadleafcommerce.common.payment.PaymentType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-profile-applicationContext-entity.xml"})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerPaymentImplDiffblueTest {
  @Autowired private CustomerPaymentImpl customerPaymentImpl;

  /**
   * Test {@link CustomerPaymentImpl#getPaymentType()}.
   *
   * <p>Method under test: {@link CustomerPaymentImpl#getPaymentType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PaymentType CustomerPaymentImpl.getPaymentType()"})
  public void testGetPaymentType() {
    // Arrange, Act and Assert
    assertNull(customerPaymentImpl.getPaymentType());
  }

  /**
   * Test {@link CustomerPaymentImpl#setPaymentType(PaymentType)}.
   *
   * <p>Method under test: {@link CustomerPaymentImpl#setPaymentType(PaymentType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerPaymentImpl.setPaymentType(PaymentType)"})
  public void testSetPaymentType() {
    // Arrange
    PaymentType paymentType = new PaymentType("Type", "Friendly Type");

    // Act
    customerPaymentImpl.setPaymentType(paymentType);

    // Assert
    assertEquals("Type", customerPaymentImpl.paymentType);
    assertEquals(paymentType, customerPaymentImpl.getPaymentType());
  }

  /**
   * Test {@link CustomerPaymentImpl#setPaymentType(PaymentType)}.
   *
   * <ul>
   *   <li>Given {@code Type}.
   *   <li>Then {@link CustomerPaymentImpl} PaymentType Type is {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerPaymentImpl#setPaymentType(PaymentType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerPaymentImpl.setPaymentType(PaymentType)"})
  public void testSetPaymentType_givenType_thenCustomerPaymentImplPaymentTypeTypeIsType() {
    // Arrange
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
   *
   * <p>Method under test: {@link CustomerPaymentImpl#getPaymentGatewayType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PaymentGatewayType CustomerPaymentImpl.getPaymentGatewayType()"})
  public void testGetPaymentGatewayType() {
    // Arrange, Act and Assert
    assertNull(customerPaymentImpl.getPaymentGatewayType());
  }

  /**
   * Test {@link CustomerPaymentImpl#setPaymentGatewayType(PaymentGatewayType)}.
   *
   * <p>Method under test: {@link CustomerPaymentImpl#setPaymentGatewayType(PaymentGatewayType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerPaymentImpl.setPaymentGatewayType(PaymentGatewayType)"})
  public void testSetPaymentGatewayType() {
    // Arrange
    PaymentGatewayType paymentGatewayType = new PaymentGatewayType("Type", "Friendly Type");

    // Act
    customerPaymentImpl.setPaymentGatewayType(paymentGatewayType);

    // Assert
    assertEquals("Type", customerPaymentImpl.paymentGatewayType);
    assertEquals(paymentGatewayType, customerPaymentImpl.getPaymentGatewayType());
  }

  /**
   * Test {@link CustomerPaymentImpl#setPaymentGatewayType(PaymentGatewayType)}.
   *
   * <ul>
   *   <li>Then {@link CustomerPaymentImpl} PaymentGatewayType Type is {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerPaymentImpl#setPaymentGatewayType(PaymentGatewayType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerPaymentImpl.setPaymentGatewayType(PaymentGatewayType)"})
  public void testSetPaymentGatewayType_thenCustomerPaymentImplPaymentGatewayTypeTypeIsType() {
    // Arrange
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
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CustomerPaymentImpl.<init>()",
    "Map CustomerPaymentImpl.getAdditionalFields()",
    "Address CustomerPaymentImpl.getBillingAddress()",
    "Customer CustomerPaymentImpl.getCustomer()",
    "Long CustomerPaymentImpl.getId()",
    "String CustomerPaymentImpl.getPaymentToken()",
    "boolean CustomerPaymentImpl.isDefault()",
    "void CustomerPaymentImpl.setAdditionalFields(Map)",
    "void CustomerPaymentImpl.setBillingAddress(Address)",
    "void CustomerPaymentImpl.setCustomer(Customer)",
    "void CustomerPaymentImpl.setId(Long)",
    "void CustomerPaymentImpl.setIsDefault(boolean)",
    "void CustomerPaymentImpl.setPaymentToken(String)"
  })
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

    // Assert
    assertEquals("ABC123", actualPaymentToken);
    assertEquals(1L, actualId.longValue());
    assertTrue(actualAdditionalFields.isEmpty());
    assertTrue(actualIsDefaultResult);
    assertSame(additionalFields, actualAdditionalFields);
    assertSame(billingAddress, actualBillingAddress);
    assertSame(customer, actualCustomer);
  }
}

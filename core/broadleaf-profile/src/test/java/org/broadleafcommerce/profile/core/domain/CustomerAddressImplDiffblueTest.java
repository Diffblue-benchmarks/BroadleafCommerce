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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.junit.Test;
import org.mockito.Mockito;

public class CustomerAddressImplDiffblueTest {
  /**
   * Method under test: {@link CustomerAddressImpl#toString()}
   */
  @Test
  public void testToString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    customerAddressImpl.setAddress(new AddressImpl());
    customerAddressImpl.setCustomer(new CustomerImpl());
    customerAddressImpl.setId(1L);
    customerAddressImpl.setAddressName(null);

    // Act and Assert
    assertEquals("null - null", customerAddressImpl.toString());
  }

  /**
   * Method under test: {@link CustomerAddressImpl#toString()}
   */
  @Test
  public void testToString2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    customerAddressImpl.setAddress(new AddressImpl());
    customerAddressImpl.setCustomer(new CustomerImpl());
    customerAddressImpl.setId(1L);
    customerAddressImpl.setAddressName("foo");

    // Act and Assert
    assertEquals("foo", customerAddressImpl.toString());
  }

  /**
   * Method under test: {@link CustomerAddressImpl#toString()}
   */
  @Test
  public void testToString3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AddressImpl address = mock(AddressImpl.class);
    when(address.getAddressLine1()).thenReturn("42 Main St");
    when(address.getFirstName()).thenReturn("Jane");

    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    customerAddressImpl.setAddress(address);
    customerAddressImpl.setCustomer(new CustomerImpl());
    customerAddressImpl.setId(1L);
    customerAddressImpl.setAddressName(null);

    // Act
    String actualToStringResult = customerAddressImpl.toString();

    // Assert
    verify(address).getAddressLine1();
    verify(address).getFirstName();
    assertEquals("Jane - 42 Main St", actualToStringResult);
  }

  /**
   * Method under test: {@link CustomerAddressImpl#getArchived()}
   */
  @Test
  public void testGetArchived() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals('N', (new CustomerAddressImpl()).getArchived().charValue());
  }

  /**
   * Method under test: {@link CustomerAddressImpl#getArchived()}
   */
  @Test
  public void testGetArchived2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    customerAddressImpl.setCustomer(mock(CustomerImpl.class));

    // Act and Assert
    assertEquals('N', customerAddressImpl.getArchived().charValue());
  }

  /**
   * Method under test: {@link CustomerAddressImpl#setArchived(Character)}
   */
  @Test
  public void testSetArchived() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();

    // Act
    customerAddressImpl.setArchived('A');

    // Assert
    assertEquals('A', customerAddressImpl.archiveStatus.getArchived().charValue());
    assertEquals('A', customerAddressImpl.getArchived().charValue());
  }

  /**
   * Method under test: {@link CustomerAddressImpl#setArchived(Character)}
   */
  @Test
  public void testSetArchived2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    customerAddressImpl.setCustomer(mock(CustomerImpl.class));

    // Act
    customerAddressImpl.setArchived('A');

    // Assert
    assertEquals('A', customerAddressImpl.archiveStatus.getArchived().charValue());
    assertEquals('A', customerAddressImpl.getArchived().charValue());
  }

  /**
   * Method under test: {@link CustomerAddressImpl#isActive()}
   */
  @Test
  public void testIsActive() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new CustomerAddressImpl()).isActive());
  }

  /**
   * Method under test: {@link CustomerAddressImpl#isActive()}
   */
  @Test
  public void testIsActive2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    customerAddressImpl.setArchived('Y');

    // Act and Assert
    assertFalse(customerAddressImpl.isActive());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerAddressImpl#equals(Object)}
   *   <li>{@link CustomerAddressImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    customerAddressImpl.setAddress(new AddressImpl());
    customerAddressImpl.setAddressName("42 Main St");
    customerAddressImpl.setCustomer(new CustomerImpl());
    customerAddressImpl.setId(1L);

    CustomerAddressImpl customerAddressImpl2 = new CustomerAddressImpl();
    customerAddressImpl2.setAddress(new AddressImpl());
    customerAddressImpl2.setAddressName("42 Main St");
    customerAddressImpl2.setCustomer(new CustomerImpl());
    customerAddressImpl2.setId(1L);

    // Act and Assert
    assertEquals(customerAddressImpl, customerAddressImpl2);
    int expectedHashCodeResult = customerAddressImpl.hashCode();
    assertEquals(expectedHashCodeResult, customerAddressImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerAddressImpl#equals(Object)}
   *   <li>{@link CustomerAddressImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    customerAddressImpl.setAddress(mock(Address.class));
    customerAddressImpl.setAddressName("42 Main St");
    customerAddressImpl.setCustomer(new CustomerImpl());
    customerAddressImpl.setId(1L);

    CustomerAddressImpl customerAddressImpl2 = new CustomerAddressImpl();
    customerAddressImpl2.setAddress(new AddressImpl());
    customerAddressImpl2.setAddressName("42 Main St");
    customerAddressImpl2.setCustomer(new CustomerImpl());
    customerAddressImpl2.setId(1L);

    // Act and Assert
    assertEquals(customerAddressImpl, customerAddressImpl2);
    int notExpectedHashCodeResult = customerAddressImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, customerAddressImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerAddressImpl#equals(Object)}
   *   <li>{@link CustomerAddressImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    customerAddressImpl.setAddress(new AddressImpl());
    customerAddressImpl.setAddressName("42 Main St");
    customerAddressImpl.setCustomer(new CustomerImpl());
    customerAddressImpl.setId(null);

    CustomerAddressImpl customerAddressImpl2 = new CustomerAddressImpl();
    customerAddressImpl2.setAddress(new AddressImpl());
    customerAddressImpl2.setAddressName("42 Main St");
    customerAddressImpl2.setCustomer(new CustomerImpl());
    customerAddressImpl2.setId(1L);

    // Act and Assert
    assertEquals(customerAddressImpl, customerAddressImpl2);
    int expectedHashCodeResult = customerAddressImpl.hashCode();
    assertEquals(expectedHashCodeResult, customerAddressImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerAddressImpl#equals(Object)}
   *   <li>{@link CustomerAddressImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    customerAddressImpl.setAddress(new AddressImpl());
    customerAddressImpl.setAddressName("42 Main St");
    customerAddressImpl.setCustomer(new CustomerImpl());
    customerAddressImpl.setId(1L);

    CustomerAddressImpl customerAddressImpl2 = new CustomerAddressImpl();
    customerAddressImpl2.setAddress(new AddressImpl());
    customerAddressImpl2.setAddressName("42 Main St");
    customerAddressImpl2.setCustomer(new CustomerImpl());
    customerAddressImpl2.setId(null);

    // Act and Assert
    assertEquals(customerAddressImpl, customerAddressImpl2);
    int expectedHashCodeResult = customerAddressImpl.hashCode();
    assertEquals(expectedHashCodeResult, customerAddressImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerAddressImpl#equals(Object)}
   *   <li>{@link CustomerAddressImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    customerAddressImpl.setAddress(new AddressImpl());
    customerAddressImpl.setAddressName("42 Main St");
    customerAddressImpl.setCustomer(new CustomerImpl());
    customerAddressImpl.setId(1L);

    // Act and Assert
    assertEquals(customerAddressImpl, customerAddressImpl);
    int expectedHashCodeResult = customerAddressImpl.hashCode();
    assertEquals(expectedHashCodeResult, customerAddressImpl.hashCode());
  }

  /**
   * Method under test:
   * {@link CustomerAddressImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<CustomerAddress> actualCreateOrRetrieveCopyInstanceResult = customerAddressImpl
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Method under test: {@link CustomerAddressImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    customerAddressImpl.setAddress(new AddressImpl());
    customerAddressImpl.setAddressName("42 Main St");
    customerAddressImpl.setCustomer(new CustomerImpl());
    customerAddressImpl.setId(2L);

    CustomerAddressImpl customerAddressImpl2 = new CustomerAddressImpl();
    customerAddressImpl2.setAddress(new AddressImpl());
    customerAddressImpl2.setAddressName("42 Main St");
    customerAddressImpl2.setCustomer(new CustomerImpl());
    customerAddressImpl2.setId(1L);

    // Act and Assert
    assertNotEquals(customerAddressImpl, customerAddressImpl2);
  }

  /**
   * Method under test: {@link CustomerAddressImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    customerAddressImpl.setAddress(mock(Address.class));
    customerAddressImpl.setAddressName("42 Main St");
    customerAddressImpl.setCustomer(new CustomerImpl());
    customerAddressImpl.setId(null);

    CustomerAddressImpl customerAddressImpl2 = new CustomerAddressImpl();
    customerAddressImpl2.setAddress(new AddressImpl());
    customerAddressImpl2.setAddressName("42 Main St");
    customerAddressImpl2.setCustomer(new CustomerImpl());
    customerAddressImpl2.setId(1L);

    // Act and Assert
    assertNotEquals(customerAddressImpl, customerAddressImpl2);
  }

  /**
   * Method under test: {@link CustomerAddressImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    customerAddressImpl.setAddress(null);
    customerAddressImpl.setAddressName("42 Main St");
    customerAddressImpl.setCustomer(new CustomerImpl());
    customerAddressImpl.setId(null);

    CustomerAddressImpl customerAddressImpl2 = new CustomerAddressImpl();
    customerAddressImpl2.setAddress(new AddressImpl());
    customerAddressImpl2.setAddressName("42 Main St");
    customerAddressImpl2.setCustomer(new CustomerImpl());
    customerAddressImpl2.setId(1L);

    // Act and Assert
    assertNotEquals(customerAddressImpl, customerAddressImpl2);
  }

  /**
   * Method under test: {@link CustomerAddressImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    customerAddressImpl.setAddress(new AddressImpl());
    customerAddressImpl.setAddressName("17 High St");
    customerAddressImpl.setCustomer(new CustomerImpl());
    customerAddressImpl.setId(null);

    CustomerAddressImpl customerAddressImpl2 = new CustomerAddressImpl();
    customerAddressImpl2.setAddress(new AddressImpl());
    customerAddressImpl2.setAddressName("42 Main St");
    customerAddressImpl2.setCustomer(new CustomerImpl());
    customerAddressImpl2.setId(1L);

    // Act and Assert
    assertNotEquals(customerAddressImpl, customerAddressImpl2);
  }

  /**
   * Method under test: {@link CustomerAddressImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    customerAddressImpl.setAddress(new AddressImpl());
    customerAddressImpl.setAddressName(null);
    customerAddressImpl.setCustomer(new CustomerImpl());
    customerAddressImpl.setId(null);

    CustomerAddressImpl customerAddressImpl2 = new CustomerAddressImpl();
    customerAddressImpl2.setAddress(new AddressImpl());
    customerAddressImpl2.setAddressName("42 Main St");
    customerAddressImpl2.setCustomer(new CustomerImpl());
    customerAddressImpl2.setId(1L);

    // Act and Assert
    assertNotEquals(customerAddressImpl, customerAddressImpl2);
  }

  /**
   * Method under test: {@link CustomerAddressImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    customerAddressImpl.setAddress(new AddressImpl());
    customerAddressImpl.setAddressName("42 Main St");
    customerAddressImpl.setCustomer(null);
    customerAddressImpl.setId(null);

    CustomerAddressImpl customerAddressImpl2 = new CustomerAddressImpl();
    customerAddressImpl2.setAddress(new AddressImpl());
    customerAddressImpl2.setAddressName("42 Main St");
    customerAddressImpl2.setCustomer(new CustomerImpl());
    customerAddressImpl2.setId(1L);

    // Act and Assert
    assertNotEquals(customerAddressImpl, customerAddressImpl2);
  }

  /**
   * Method under test: {@link CustomerAddressImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    customerAddressImpl.setAddress(new AddressImpl());
    customerAddressImpl.setAddressName("42 Main St");
    customerAddressImpl.setCustomer(mock(CustomerImpl.class));
    customerAddressImpl.setId(null);

    CustomerAddressImpl customerAddressImpl2 = new CustomerAddressImpl();
    customerAddressImpl2.setAddress(new AddressImpl());
    customerAddressImpl2.setAddressName("42 Main St");
    customerAddressImpl2.setCustomer(new CustomerImpl());
    customerAddressImpl2.setId(1L);

    // Act and Assert
    assertNotEquals(customerAddressImpl, customerAddressImpl2);
  }

  /**
   * Method under test: {@link CustomerAddressImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    customerAddressImpl.setAddress(new AddressImpl());
    customerAddressImpl.setAddressName("42 Main St");
    customerAddressImpl.setCustomer(new CustomerImpl());
    customerAddressImpl.setId(1L);

    // Act and Assert
    assertNotEquals(customerAddressImpl, null);
  }

  /**
   * Method under test: {@link CustomerAddressImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    customerAddressImpl.setAddress(new AddressImpl());
    customerAddressImpl.setAddressName("42 Main St");
    customerAddressImpl.setCustomer(new CustomerImpl());
    customerAddressImpl.setId(1L);

    // Act and Assert
    assertNotEquals(customerAddressImpl, "Different type to CustomerAddressImpl");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerAddressImpl#setAddress(Address)}
   *   <li>{@link CustomerAddressImpl#setAddressName(String)}
   *   <li>{@link CustomerAddressImpl#setCustomer(Customer)}
   *   <li>{@link CustomerAddressImpl#setId(Long)}
   *   <li>{@link CustomerAddressImpl#getAddress()}
   *   <li>{@link CustomerAddressImpl#getAddressName()}
   *   <li>{@link CustomerAddressImpl#getCustomer()}
   *   <li>{@link CustomerAddressImpl#getId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    AddressImpl address = new AddressImpl();

    // Act
    customerAddressImpl.setAddress(address);
    customerAddressImpl.setAddressName("42 Main St");
    CustomerImpl customer = new CustomerImpl();
    customerAddressImpl.setCustomer(customer);
    customerAddressImpl.setId(1L);
    Address actualAddress = customerAddressImpl.getAddress();
    String actualAddressName = customerAddressImpl.getAddressName();
    Customer actualCustomer = customerAddressImpl.getCustomer();

    // Assert that nothing has changed
    assertEquals("42 Main St", actualAddressName);
    assertEquals(1L, customerAddressImpl.getId().longValue());
    assertSame(address, actualAddress);
    assertSame(customer, actualCustomer);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link CustomerAddressImpl}
   */
  @Test
  public void testNewCustomerAddressImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    CustomerAddressImpl actualCustomerAddressImpl = new CustomerAddressImpl();

    // Assert
    assertEquals('N', actualCustomerAddressImpl.archiveStatus.getArchived().charValue());
    assertEquals('N', actualCustomerAddressImpl.getArchived().charValue());
    assertNull(actualCustomerAddressImpl.getId());
    assertNull(actualCustomerAddressImpl.getAddressName());
    assertNull(actualCustomerAddressImpl.getAddress());
    assertNull(actualCustomerAddressImpl.getCustomer());
  }
}

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
package org.broadleafcommerce.profile.core.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.profile.core.dao.CustomerAddressDao;
import org.broadleafcommerce.profile.core.dao.CustomerDao;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerAddress;
import org.broadleafcommerce.profile.core.domain.CustomerAddressImpl;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CustomerAddressServiceImplDiffblueTest {
  @Mock private CustomerAddressDao customerAddressDao;

  @InjectMocks private CustomerAddressServiceImpl customerAddressServiceImpl;

  @Mock private CustomerDao customerDao;

  /**
   * Test {@link CustomerAddressServiceImpl#saveCustomerAddress(CustomerAddress)}.
   *
   * <ul>
   *   <li>Then Address return {@link AddressImpl}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerAddressServiceImpl#saveCustomerAddress(CustomerAddress)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CustomerAddress CustomerAddressServiceImpl.saveCustomerAddress(CustomerAddress)"
  })
  public void testSaveCustomerAddress_thenAddressReturnAddressImpl() {
    // Arrange
    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    AddressImpl address = new AddressImpl();
    customerAddressImpl.setAddress(address);
    when(customerAddressDao.readActiveCustomerAddressesByCustomerId(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());
    when(customerAddressDao.save(Mockito.<CustomerAddress>any())).thenReturn(customerAddressImpl);
    doNothing().when(customerDao).refreshCustomer(Mockito.<Customer>any());

    CustomerAddressImpl customerAddress = mock(CustomerAddressImpl.class);
    when(customerAddress.getAddress()).thenReturn(new AddressImpl());
    when(customerAddress.getCustomer()).thenReturn(new CustomerImpl());

    // Act
    CustomerAddress actualSaveCustomerAddressResult =
        customerAddressServiceImpl.saveCustomerAddress(customerAddress);

    // Assert
    verify(customerAddressDao).readActiveCustomerAddressesByCustomerId(isNull());
    verify(customerAddressDao).save(isA(CustomerAddress.class));
    verify(customerDao).refreshCustomer(isNull());
    verify(customerAddress).getAddress();
    verify(customerAddress).getCustomer();
    Address address2 = actualSaveCustomerAddressResult.getAddress();
    assertTrue(address2 instanceof AddressImpl);
    assertTrue(actualSaveCustomerAddressResult instanceof CustomerAddressImpl);
    assertSame(address, address2);
  }

  /**
   * Test {@link CustomerAddressServiceImpl#saveCustomerAddress(CustomerAddress)}.
   *
   * <ul>
   *   <li>Then Address return {@link AddressImpl}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerAddressServiceImpl#saveCustomerAddress(CustomerAddress)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CustomerAddress CustomerAddressServiceImpl.saveCustomerAddress(CustomerAddress)"
  })
  public void testSaveCustomerAddress_thenAddressReturnAddressImpl2() {
    // Arrange
    ArrayList<CustomerAddress> customerAddressList = new ArrayList<>();
    customerAddressList.add(new CustomerAddressImpl());

    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    AddressImpl address = new AddressImpl();
    customerAddressImpl.setAddress(address);
    when(customerAddressDao.readActiveCustomerAddressesByCustomerId(Mockito.<Long>any()))
        .thenReturn(customerAddressList);
    when(customerAddressDao.save(Mockito.<CustomerAddress>any())).thenReturn(customerAddressImpl);
    doNothing().when(customerDao).refreshCustomer(Mockito.<Customer>any());

    CustomerAddressImpl customerAddress = mock(CustomerAddressImpl.class);
    when(customerAddress.getCustomer()).thenReturn(new CustomerImpl());

    // Act
    CustomerAddress actualSaveCustomerAddressResult =
        customerAddressServiceImpl.saveCustomerAddress(customerAddress);

    // Assert
    verify(customerAddressDao).readActiveCustomerAddressesByCustomerId(isNull());
    verify(customerAddressDao).save(isA(CustomerAddress.class));
    verify(customerDao).refreshCustomer(isNull());
    verify(customerAddress).getCustomer();
    Address address2 = actualSaveCustomerAddressResult.getAddress();
    assertTrue(address2 instanceof AddressImpl);
    assertTrue(actualSaveCustomerAddressResult instanceof CustomerAddressImpl);
    assertSame(address, address2);
  }

  /**
   * Test {@link CustomerAddressServiceImpl#saveCustomerAddress(CustomerAddress)}.
   *
   * <ul>
   *   <li>Then return {@link CustomerAddressImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CustomerAddressServiceImpl#saveCustomerAddress(CustomerAddress)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CustomerAddress CustomerAddressServiceImpl.saveCustomerAddress(CustomerAddress)"
  })
  public void testSaveCustomerAddress_thenReturnCustomerAddressImpl() {
    // Arrange
    AddressImpl address = mock(AddressImpl.class);
    when(address.isDefault()).thenReturn(true);

    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    customerAddressImpl.setAddress(address);
    doNothing()
        .when(customerAddressDao)
        .makeCustomerAddressDefault(Mockito.<Long>any(), Mockito.<Long>any());
    when(customerAddressDao.readActiveCustomerAddressesByCustomerId(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());
    when(customerAddressDao.save(Mockito.<CustomerAddress>any())).thenReturn(customerAddressImpl);
    doNothing().when(customerDao).refreshCustomer(Mockito.<Customer>any());

    CustomerAddressImpl customerAddress = mock(CustomerAddressImpl.class);
    when(customerAddress.getAddress()).thenReturn(new AddressImpl());
    when(customerAddress.getCustomer()).thenReturn(new CustomerImpl());

    // Act
    CustomerAddress actualSaveCustomerAddressResult =
        customerAddressServiceImpl.saveCustomerAddress(customerAddress);

    // Assert
    verify(customerAddressDao).makeCustomerAddressDefault(isNull(), isNull());
    verify(customerAddressDao).readActiveCustomerAddressesByCustomerId(isNull());
    verify(customerAddressDao).save(isA(CustomerAddress.class));
    verify(customerDao).refreshCustomer(isNull());
    verify(address).isDefault();
    verify(customerAddress).getAddress();
    verify(customerAddress).getCustomer();
    assertSame(customerAddressImpl, actualSaveCustomerAddressResult);
  }

  /**
   * Test {@link CustomerAddressServiceImpl#readActiveCustomerAddressesByCustomerId(Long)}.
   *
   * <p>Method under test: {@link
   * CustomerAddressServiceImpl#readActiveCustomerAddressesByCustomerId(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List CustomerAddressServiceImpl.readActiveCustomerAddressesByCustomerId(Long)"
  })
  public void testReadActiveCustomerAddressesByCustomerId() {
    // Arrange
    when(customerAddressDao.readActiveCustomerAddressesByCustomerId(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<CustomerAddress> actualReadActiveCustomerAddressesByCustomerIdResult =
        customerAddressServiceImpl.readActiveCustomerAddressesByCustomerId(1L);

    // Assert
    verify(customerAddressDao).readActiveCustomerAddressesByCustomerId(1L);
    assertTrue(actualReadActiveCustomerAddressesByCustomerIdResult.isEmpty());
  }

  /**
   * Test {@link CustomerAddressServiceImpl#readCustomerAddressById(Long)}.
   *
   * <p>Method under test: {@link CustomerAddressServiceImpl#readCustomerAddressById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CustomerAddress CustomerAddressServiceImpl.readCustomerAddressById(Long)"})
  public void testReadCustomerAddressById() {
    // Arrange
    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    when(customerAddressDao.readCustomerAddressById(Mockito.<Long>any()))
        .thenReturn(customerAddressImpl);

    // Act
    CustomerAddress actualReadCustomerAddressByIdResult =
        customerAddressServiceImpl.readCustomerAddressById(1L);

    // Assert
    verify(customerAddressDao).readCustomerAddressById(1L);
    assertSame(customerAddressImpl, actualReadCustomerAddressByIdResult);
  }

  /**
   * Test {@link CustomerAddressServiceImpl#makeCustomerAddressDefault(Long, Long)}.
   *
   * <p>Method under test: {@link CustomerAddressServiceImpl#makeCustomerAddressDefault(Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerAddressServiceImpl.makeCustomerAddressDefault(Long, Long)"})
  public void testMakeCustomerAddressDefault() {
    // Arrange
    doNothing()
        .when(customerAddressDao)
        .makeCustomerAddressDefault(Mockito.<Long>any(), Mockito.<Long>any());

    // Act
    customerAddressServiceImpl.makeCustomerAddressDefault(1L, 1L);

    // Assert
    verify(customerAddressDao).makeCustomerAddressDefault(1L, 1L);
  }

  /**
   * Test {@link CustomerAddressServiceImpl#deleteCustomerAddressById(Long)}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerAddressDao#deleteCustomerAddressById(Long)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerAddressServiceImpl#deleteCustomerAddressById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerAddressServiceImpl.deleteCustomerAddressById(Long)"})
  public void testDeleteCustomerAddressById_thenCallsDeleteCustomerAddressById() {
    // Arrange
    when(customerAddressDao.readCustomerAddressById(Mockito.<Long>any()))
        .thenReturn(new CustomerAddressImpl());
    doNothing().when(customerAddressDao).deleteCustomerAddressById(Mockito.<Long>any());
    doNothing().when(customerDao).refreshCustomer(Mockito.<Customer>any());

    // Act
    customerAddressServiceImpl.deleteCustomerAddressById(1L);

    // Assert
    verify(customerAddressDao).deleteCustomerAddressById(1L);
    verify(customerAddressDao).readCustomerAddressById(1L);
    verify(customerDao).refreshCustomer(isNull());
  }

  /**
   * Test {@link CustomerAddressServiceImpl#findDefaultCustomerAddress(Long)}.
   *
   * <p>Method under test: {@link CustomerAddressServiceImpl#findDefaultCustomerAddress(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CustomerAddress CustomerAddressServiceImpl.findDefaultCustomerAddress(Long)"})
  public void testFindDefaultCustomerAddress() {
    // Arrange
    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    when(customerAddressDao.findDefaultCustomerAddress(Mockito.<Long>any()))
        .thenReturn(customerAddressImpl);

    // Act
    CustomerAddress actualFindDefaultCustomerAddressResult =
        customerAddressServiceImpl.findDefaultCustomerAddress(1L);

    // Assert
    verify(customerAddressDao).findDefaultCustomerAddress(1L);
    assertSame(customerAddressImpl, actualFindDefaultCustomerAddressResult);
  }

  /**
   * Test {@link CustomerAddressServiceImpl#create()}.
   *
   * <p>Method under test: {@link CustomerAddressServiceImpl#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CustomerAddress CustomerAddressServiceImpl.create()"})
  public void testCreate() {
    // Arrange
    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    when(customerAddressDao.create()).thenReturn(customerAddressImpl);

    // Act
    CustomerAddress actualCreateResult = customerAddressServiceImpl.create();

    // Assert
    verify(customerAddressDao).create();
    assertSame(customerAddressImpl, actualCreateResult);
  }

  /**
   * Test {@link CustomerAddressServiceImpl#readBatchAddresses(int, int)}.
   *
   * <p>Method under test: {@link CustomerAddressServiceImpl#readBatchAddresses(int, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CustomerAddressServiceImpl.readBatchAddresses(int, int)"})
  public void testReadBatchAddresses() {
    // Arrange
    when(customerAddressDao.readBatchCustomerAddresses(anyInt(), anyInt()))
        .thenReturn(new ArrayList<>());

    // Act
    List<CustomerAddress> actualReadBatchAddressesResult =
        customerAddressServiceImpl.readBatchAddresses(1, 3);

    // Assert
    verify(customerAddressDao).readBatchCustomerAddresses(1, 3);
    assertTrue(actualReadBatchAddressesResult.isEmpty());
  }

  /**
   * Test {@link CustomerAddressServiceImpl#readNumberOfAddresses()}.
   *
   * <p>Method under test: {@link CustomerAddressServiceImpl#readNumberOfAddresses()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long CustomerAddressServiceImpl.readNumberOfAddresses()"})
  public void testReadNumberOfAddresses() {
    // Arrange
    when(customerAddressDao.readNumberOfAddresses()).thenReturn(1L);

    // Act
    Long actualReadNumberOfAddressesResult = customerAddressServiceImpl.readNumberOfAddresses();

    // Assert
    verify(customerAddressDao).readNumberOfAddresses();
    assertEquals(1L, actualReadNumberOfAddressesResult.longValue());
  }
}

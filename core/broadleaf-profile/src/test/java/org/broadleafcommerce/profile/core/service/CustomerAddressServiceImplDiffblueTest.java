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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.profile.core.dao.CustomerAddressDao;
import org.broadleafcommerce.profile.core.dao.CustomerDao;
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
  @Mock
  private CustomerAddressDao customerAddressDao;

  @InjectMocks
  private CustomerAddressServiceImpl customerAddressServiceImpl;

  @Mock
  private CustomerDao customerDao;

  /**
   * Test {@link CustomerAddressServiceImpl#saveCustomerAddress(CustomerAddress)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CustomerAddressImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerAddressServiceImpl#saveCustomerAddress(CustomerAddress)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CustomerAddress CustomerAddressServiceImpl.saveCustomerAddress(CustomerAddress)"})
  public void testSaveCustomerAddress_givenArrayListAddCustomerAddressImpl() {
    // Arrange
    ArrayList<CustomerAddress> customerAddressList = new ArrayList<>();
    customerAddressList.add(new CustomerAddressImpl());
    AddressImpl addressImpl = mock(AddressImpl.class);
    when(addressImpl.isDefault()).thenReturn(true);
    CustomerAddress customerAddress = mock(CustomerAddress.class);
    when(customerAddress.getId()).thenReturn(1L);
    when(customerAddress.getCustomer()).thenReturn(new CustomerImpl());
    when(customerAddress.getAddress()).thenReturn(addressImpl);
    doNothing().when(customerAddressDao).makeCustomerAddressDefault(Mockito.<Long>any(), Mockito.<Long>any());
    when(customerAddressDao.save(Mockito.<CustomerAddress>any())).thenReturn(customerAddress);
    when(customerAddressDao.readActiveCustomerAddressesByCustomerId(Mockito.<Long>any()))
        .thenReturn(customerAddressList);
    doNothing().when(customerDao).refreshCustomer(Mockito.<Customer>any());
    CustomerAddressImpl customerAddress2 = mock(CustomerAddressImpl.class);
    when(customerAddress2.getCustomer()).thenReturn(new CustomerImpl());

    // Act
    customerAddressServiceImpl.saveCustomerAddress(customerAddress2);

    // Assert
    verify(customerAddressDao).makeCustomerAddressDefault(eq(1L), isNull());
    verify(customerAddressDao).readActiveCustomerAddressesByCustomerId(isNull());
    verify(customerAddressDao).save(isA(CustomerAddress.class));
    verify(customerDao).refreshCustomer(isA(Customer.class));
    verify(addressImpl).isDefault();
    verify(customerAddress).getAddress();
    verify(customerAddress).getCustomer();
    verify(customerAddress).getId();
    verify(customerAddress2).getCustomer();
  }

  /**
   * Test {@link CustomerAddressServiceImpl#saveCustomerAddress(CustomerAddress)}.
   * <ul>
   *   <li>Given {@link CustomerAddress} {@link CustomerAddress#getAddress()} return {@link AddressImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerAddressServiceImpl#saveCustomerAddress(CustomerAddress)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CustomerAddress CustomerAddressServiceImpl.saveCustomerAddress(CustomerAddress)"})
  public void testSaveCustomerAddress_givenCustomerAddressGetAddressReturnAddressImpl() {
    // Arrange
    CustomerAddress customerAddress = mock(CustomerAddress.class);
    when(customerAddress.getCustomer()).thenReturn(new CustomerImpl());
    when(customerAddress.getAddress()).thenReturn(new AddressImpl());
    when(customerAddressDao.save(Mockito.<CustomerAddress>any())).thenReturn(customerAddress);
    when(customerAddressDao.readActiveCustomerAddressesByCustomerId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    doNothing().when(customerDao).refreshCustomer(Mockito.<Customer>any());
    CustomerAddressImpl customerAddress2 = mock(CustomerAddressImpl.class);
    when(customerAddress2.getAddress()).thenReturn(new AddressImpl());
    when(customerAddress2.getCustomer()).thenReturn(new CustomerImpl());

    // Act
    customerAddressServiceImpl.saveCustomerAddress(customerAddress2);

    // Assert
    verify(customerAddressDao).readActiveCustomerAddressesByCustomerId(isNull());
    verify(customerAddressDao).save(isA(CustomerAddress.class));
    verify(customerDao).refreshCustomer(isA(Customer.class));
    verify(customerAddress).getAddress();
    verify(customerAddress).getCustomer();
    verify(customerAddress2).getAddress();
    verify(customerAddress2).getCustomer();
  }

  /**
   * Test {@link CustomerAddressServiceImpl#saveCustomerAddress(CustomerAddress)}.
   * <ul>
   *   <li>Then calls {@link CustomerAddressDao#makeCustomerAddressDefault(Long, Long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerAddressServiceImpl#saveCustomerAddress(CustomerAddress)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CustomerAddress CustomerAddressServiceImpl.saveCustomerAddress(CustomerAddress)"})
  public void testSaveCustomerAddress_thenCallsMakeCustomerAddressDefault() {
    // Arrange
    AddressImpl addressImpl = mock(AddressImpl.class);
    when(addressImpl.isDefault()).thenReturn(true);
    CustomerAddress customerAddress = mock(CustomerAddress.class);
    when(customerAddress.getId()).thenReturn(1L);
    when(customerAddress.getCustomer()).thenReturn(new CustomerImpl());
    when(customerAddress.getAddress()).thenReturn(addressImpl);
    doNothing().when(customerAddressDao).makeCustomerAddressDefault(Mockito.<Long>any(), Mockito.<Long>any());
    when(customerAddressDao.save(Mockito.<CustomerAddress>any())).thenReturn(customerAddress);
    when(customerAddressDao.readActiveCustomerAddressesByCustomerId(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    doNothing().when(customerDao).refreshCustomer(Mockito.<Customer>any());
    CustomerAddressImpl customerAddress2 = mock(CustomerAddressImpl.class);
    when(customerAddress2.getAddress()).thenReturn(new AddressImpl());
    when(customerAddress2.getCustomer()).thenReturn(new CustomerImpl());

    // Act
    customerAddressServiceImpl.saveCustomerAddress(customerAddress2);

    // Assert
    verify(customerAddressDao).makeCustomerAddressDefault(eq(1L), isNull());
    verify(customerAddressDao).readActiveCustomerAddressesByCustomerId(isNull());
    verify(customerAddressDao).save(isA(CustomerAddress.class));
    verify(customerDao).refreshCustomer(isA(Customer.class));
    verify(addressImpl).isDefault();
    verify(customerAddress).getAddress();
    verify(customerAddress).getCustomer();
    verify(customerAddress).getId();
    verify(customerAddress2).getAddress();
    verify(customerAddress2).getCustomer();
  }

  /**
   * Test {@link CustomerAddressServiceImpl#readActiveCustomerAddressesByCustomerId(Long)}.
   * <p>
   * Method under test: {@link CustomerAddressServiceImpl#readActiveCustomerAddressesByCustomerId(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CustomerAddressServiceImpl.readActiveCustomerAddressesByCustomerId(Long)"})
  public void testReadActiveCustomerAddressesByCustomerId() {
    // Arrange
    when(customerAddressDao.readActiveCustomerAddressesByCustomerId(Mockito.<Long>any())).thenReturn(new ArrayList<>());

    // Act
    List<CustomerAddress> actualReadActiveCustomerAddressesByCustomerIdResult = customerAddressServiceImpl
        .readActiveCustomerAddressesByCustomerId(1L);

    // Assert
    verify(customerAddressDao).readActiveCustomerAddressesByCustomerId(eq(1L));
    assertTrue(actualReadActiveCustomerAddressesByCustomerIdResult.isEmpty());
  }

  /**
   * Test {@link CustomerAddressServiceImpl#readCustomerAddressById(Long)}.
   * <p>
   * Method under test: {@link CustomerAddressServiceImpl#readCustomerAddressById(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CustomerAddress CustomerAddressServiceImpl.readCustomerAddressById(Long)"})
  public void testReadCustomerAddressById() {
    // Arrange
    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    when(customerAddressDao.readCustomerAddressById(Mockito.<Long>any())).thenReturn(customerAddressImpl);

    // Act
    CustomerAddress actualReadCustomerAddressByIdResult = customerAddressServiceImpl.readCustomerAddressById(1L);

    // Assert
    verify(customerAddressDao).readCustomerAddressById(eq(1L));
    assertSame(customerAddressImpl, actualReadCustomerAddressByIdResult);
  }

  /**
   * Test {@link CustomerAddressServiceImpl#makeCustomerAddressDefault(Long, Long)}.
   * <p>
   * Method under test: {@link CustomerAddressServiceImpl#makeCustomerAddressDefault(Long, Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CustomerAddressServiceImpl.makeCustomerAddressDefault(Long, Long)"})
  public void testMakeCustomerAddressDefault() {
    // Arrange
    doNothing().when(customerAddressDao).makeCustomerAddressDefault(Mockito.<Long>any(), Mockito.<Long>any());

    // Act
    customerAddressServiceImpl.makeCustomerAddressDefault(1L, 1L);

    // Assert
    verify(customerAddressDao).makeCustomerAddressDefault(eq(1L), eq(1L));
  }

  /**
   * Test {@link CustomerAddressServiceImpl#deleteCustomerAddressById(Long)}.
   * <ul>
   *   <li>Then calls {@link CustomerAddressDao#deleteCustomerAddressById(Long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerAddressServiceImpl#deleteCustomerAddressById(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CustomerAddressServiceImpl.deleteCustomerAddressById(Long)"})
  public void testDeleteCustomerAddressById_thenCallsDeleteCustomerAddressById() {
    // Arrange
    when(customerAddressDao.readCustomerAddressById(Mockito.<Long>any())).thenReturn(new CustomerAddressImpl());
    doNothing().when(customerAddressDao).deleteCustomerAddressById(Mockito.<Long>any());
    doNothing().when(customerDao).refreshCustomer(Mockito.<Customer>any());

    // Act
    customerAddressServiceImpl.deleteCustomerAddressById(1L);

    // Assert
    verify(customerAddressDao).deleteCustomerAddressById(eq(1L));
    verify(customerAddressDao).readCustomerAddressById(eq(1L));
    verify(customerDao).refreshCustomer(isNull());
  }

  /**
   * Test {@link CustomerAddressServiceImpl#findDefaultCustomerAddress(Long)}.
   * <p>
   * Method under test: {@link CustomerAddressServiceImpl#findDefaultCustomerAddress(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CustomerAddress CustomerAddressServiceImpl.findDefaultCustomerAddress(Long)"})
  public void testFindDefaultCustomerAddress() {
    // Arrange
    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    when(customerAddressDao.findDefaultCustomerAddress(Mockito.<Long>any())).thenReturn(customerAddressImpl);

    // Act
    CustomerAddress actualFindDefaultCustomerAddressResult = customerAddressServiceImpl.findDefaultCustomerAddress(1L);

    // Assert
    verify(customerAddressDao).findDefaultCustomerAddress(eq(1L));
    assertSame(customerAddressImpl, actualFindDefaultCustomerAddressResult);
  }

  /**
   * Test {@link CustomerAddressServiceImpl#create()}.
   * <p>
   * Method under test: {@link CustomerAddressServiceImpl#create()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <p>
   * Method under test: {@link CustomerAddressServiceImpl#readBatchAddresses(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CustomerAddressServiceImpl.readBatchAddresses(int, int)"})
  public void testReadBatchAddresses() {
    // Arrange
    when(customerAddressDao.readBatchCustomerAddresses(anyInt(), anyInt())).thenReturn(new ArrayList<>());

    // Act
    List<CustomerAddress> actualReadBatchAddressesResult = customerAddressServiceImpl.readBatchAddresses(1, 3);

    // Assert
    verify(customerAddressDao).readBatchCustomerAddresses(eq(1), eq(3));
    assertTrue(actualReadBatchAddressesResult.isEmpty());
  }

  /**
   * Test {@link CustomerAddressServiceImpl#readNumberOfAddresses()}.
   * <p>
   * Method under test: {@link CustomerAddressServiceImpl#readNumberOfAddresses()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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

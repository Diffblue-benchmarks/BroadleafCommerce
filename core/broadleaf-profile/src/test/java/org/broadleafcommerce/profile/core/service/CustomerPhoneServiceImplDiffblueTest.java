package org.broadleafcommerce.profile.core.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.profile.core.dao.CustomerPhoneDao;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.domain.CustomerPhone;
import org.broadleafcommerce.profile.core.domain.CustomerPhoneImpl;
import org.broadleafcommerce.profile.core.domain.Phone;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CustomerPhoneServiceImplDiffblueTest {
  @Mock private CustomerPhoneDao customerPhoneDao;

  @InjectMocks private CustomerPhoneServiceImpl customerPhoneServiceImpl;

  /**
   * Test {@link CustomerPhoneServiceImpl#saveCustomerPhone(CustomerPhone)}.
   *
   * <ul>
   *   <li>Given {@link CustomerPhoneImpl} {@link CustomerPhoneImpl#getId()} return one.
   *   <li>Then calls {@link CustomerPhoneImpl#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerPhoneServiceImpl#saveCustomerPhone(CustomerPhone)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CustomerPhone CustomerPhoneServiceImpl.saveCustomerPhone(CustomerPhone)"})
  public void testSaveCustomerPhone_givenCustomerPhoneImplGetIdReturnOne_thenCallsGetId() {
    // Arrange
    CustomerPhoneImpl customerPhoneImpl = mock(CustomerPhoneImpl.class);
    when(customerPhoneImpl.getId()).thenReturn(1L);

    ArrayList<CustomerPhone> customerPhoneList = new ArrayList<>();
    customerPhoneList.add(customerPhoneImpl);
    when(customerPhoneDao.readActiveCustomerPhonesByCustomerId(Mockito.<Long>any()))
        .thenReturn(customerPhoneList);
    CustomerPhoneImpl customerPhoneImpl2 = new CustomerPhoneImpl();
    when(customerPhoneDao.save(Mockito.<CustomerPhone>any())).thenReturn(customerPhoneImpl2);

    PhoneImpl phone = new PhoneImpl();
    phone.setActive(true);
    phone.setCountryCode("GB");
    phone.setExtension("Extension");
    phone.setId(1L);
    phone.setPhoneNumber("6625550144");
    phone.setDefault(true);

    CustomerPhoneImpl customerPhone = new CustomerPhoneImpl();
    customerPhone.setCustomer(new CustomerImpl());
    customerPhone.setId(1L);
    customerPhone.setPhoneName("6625550144");
    customerPhone.setPhone(phone);

    // Act
    CustomerPhone actualSaveCustomerPhoneResult =
        customerPhoneServiceImpl.saveCustomerPhone(customerPhone);

    // Assert
    verify(customerPhoneDao).readActiveCustomerPhonesByCustomerId(isNull());
    verify(customerPhoneDao).save(isA(CustomerPhone.class));
    verify(customerPhoneImpl).getId();
    Phone phone2 = customerPhone.getPhone();
    assertTrue(phone2 instanceof PhoneImpl);
    assertTrue(phone2.isDefault());
    assertSame(customerPhoneImpl2, actualSaveCustomerPhoneResult);
  }

  /**
   * Test {@link CustomerPhoneServiceImpl#saveCustomerPhone(CustomerPhone)}.
   *
   * <ul>
   *   <li>Given {@link CustomerPhoneImpl} {@link CustomerPhoneImpl#getPhone()} return {@link
   *       PhoneImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CustomerPhoneServiceImpl#saveCustomerPhone(CustomerPhone)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CustomerPhone CustomerPhoneServiceImpl.saveCustomerPhone(CustomerPhone)"})
  public void testSaveCustomerPhone_givenCustomerPhoneImplGetPhoneReturnPhoneImpl() {
    // Arrange
    CustomerPhoneImpl customerPhoneImpl = mock(CustomerPhoneImpl.class);
    when(customerPhoneImpl.getId()).thenReturn(1L);
    when(customerPhoneImpl.getPhone()).thenReturn(new PhoneImpl());

    ArrayList<CustomerPhone> customerPhoneList = new ArrayList<>();
    customerPhoneList.add(customerPhoneImpl);
    when(customerPhoneDao.readActiveCustomerPhonesByCustomerId(Mockito.<Long>any()))
        .thenReturn(customerPhoneList);
    CustomerPhoneImpl customerPhoneImpl2 = new CustomerPhoneImpl();
    when(customerPhoneDao.save(Mockito.<CustomerPhone>any())).thenReturn(customerPhoneImpl2);

    PhoneImpl phone = new PhoneImpl();
    phone.setActive(true);
    phone.setCountryCode("GB");
    phone.setExtension("Extension");
    phone.setId(1L);
    phone.setPhoneNumber("6625550144");
    phone.setDefault(true);

    CustomerPhoneImpl customerPhone = new CustomerPhoneImpl();
    customerPhone.setCustomer(new CustomerImpl());
    customerPhone.setId(2L);
    customerPhone.setPhoneName("6625550144");
    customerPhone.setPhone(phone);

    // Act
    CustomerPhone actualSaveCustomerPhoneResult =
        customerPhoneServiceImpl.saveCustomerPhone(customerPhone);

    // Assert
    verify(customerPhoneDao).readActiveCustomerPhonesByCustomerId(isNull());
    verify(customerPhoneDao).save(isA(CustomerPhone.class));
    verify(customerPhoneImpl).getId();
    verify(customerPhoneImpl).getPhone();
    Phone phone2 = customerPhone.getPhone();
    assertTrue(phone2 instanceof PhoneImpl);
    assertTrue(phone2.isDefault());
    assertSame(customerPhoneImpl2, actualSaveCustomerPhoneResult);
  }

  /**
   * Test {@link CustomerPhoneServiceImpl#saveCustomerPhone(CustomerPhone)}.
   *
   * <ul>
   *   <li>Given {@link PhoneImpl} (default constructor) Default is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerPhoneServiceImpl#saveCustomerPhone(CustomerPhone)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CustomerPhone CustomerPhoneServiceImpl.saveCustomerPhone(CustomerPhone)"})
  public void testSaveCustomerPhone_givenPhoneImplDefaultIsFalse() {
    // Arrange
    when(customerPhoneDao.readActiveCustomerPhonesByCustomerId(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());
    CustomerPhoneImpl customerPhoneImpl = new CustomerPhoneImpl();
    when(customerPhoneDao.save(Mockito.<CustomerPhone>any())).thenReturn(customerPhoneImpl);

    PhoneImpl phone = new PhoneImpl();
    phone.setActive(true);
    phone.setCountryCode("GB");
    phone.setExtension("Extension");
    phone.setId(1L);
    phone.setPhoneNumber("6625550144");
    phone.setDefault(false);

    CustomerPhoneImpl customerPhone = new CustomerPhoneImpl();
    customerPhone.setCustomer(new CustomerImpl());
    customerPhone.setId(1L);
    customerPhone.setPhoneName("6625550144");
    customerPhone.setPhone(phone);

    // Act
    CustomerPhone actualSaveCustomerPhoneResult =
        customerPhoneServiceImpl.saveCustomerPhone(customerPhone);

    // Assert
    verify(customerPhoneDao).readActiveCustomerPhonesByCustomerId(isNull());
    verify(customerPhoneDao).save(isA(CustomerPhone.class));
    Phone phone2 = customerPhone.getPhone();
    assertTrue(phone2 instanceof PhoneImpl);
    assertTrue(phone2.isDefault());
    assertSame(customerPhoneImpl, actualSaveCustomerPhoneResult);
  }

  /**
   * Test {@link CustomerPhoneServiceImpl#saveCustomerPhone(CustomerPhone)}.
   *
   * <ul>
   *   <li>Given {@link Phone} {@link Phone#setDefault(boolean)} does nothing.
   *   <li>Then calls {@link Phone#isDefault()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerPhoneServiceImpl#saveCustomerPhone(CustomerPhone)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CustomerPhone CustomerPhoneServiceImpl.saveCustomerPhone(CustomerPhone)"})
  public void testSaveCustomerPhone_givenPhoneSetDefaultDoesNothing_thenCallsIsDefault() {
    // Arrange
    Phone phone = mock(Phone.class);
    doNothing().when(phone).setDefault(anyBoolean());
    when(phone.isDefault()).thenReturn(true);

    CustomerPhoneImpl customerPhoneImpl = mock(CustomerPhoneImpl.class);
    when(customerPhoneImpl.getId()).thenReturn(1L);
    when(customerPhoneImpl.getPhone()).thenReturn(phone);

    ArrayList<CustomerPhone> customerPhoneList = new ArrayList<>();
    customerPhoneList.add(customerPhoneImpl);
    when(customerPhoneDao.readActiveCustomerPhonesByCustomerId(Mockito.<Long>any()))
        .thenReturn(customerPhoneList);
    CustomerPhoneImpl customerPhoneImpl2 = new CustomerPhoneImpl();
    when(customerPhoneDao.save(Mockito.<CustomerPhone>any())).thenReturn(customerPhoneImpl2);

    PhoneImpl phone2 = new PhoneImpl();
    phone2.setActive(true);
    phone2.setCountryCode("GB");
    phone2.setExtension("Extension");
    phone2.setId(1L);
    phone2.setPhoneNumber("6625550144");
    phone2.setDefault(true);

    CustomerPhoneImpl customerPhone = new CustomerPhoneImpl();
    customerPhone.setCustomer(new CustomerImpl());
    customerPhone.setId(2L);
    customerPhone.setPhoneName("6625550144");
    customerPhone.setPhone(phone2);

    // Act
    CustomerPhone actualSaveCustomerPhoneResult =
        customerPhoneServiceImpl.saveCustomerPhone(customerPhone);

    // Assert
    verify(customerPhoneDao).readActiveCustomerPhonesByCustomerId(isNull());
    verify(customerPhoneDao, atLeast(1)).save(Mockito.<CustomerPhone>any());
    verify(customerPhoneImpl).getId();
    verify(customerPhoneImpl, atLeast(1)).getPhone();
    verify(phone).isDefault();
    verify(phone).setDefault(false);
    Phone phone3 = customerPhone.getPhone();
    assertTrue(phone3 instanceof PhoneImpl);
    assertTrue(phone3.isDefault());
    assertSame(customerPhoneImpl2, actualSaveCustomerPhoneResult);
  }

  /**
   * Test {@link CustomerPhoneServiceImpl#saveCustomerPhone(CustomerPhone)}.
   *
   * <ul>
   *   <li>Then not {@link CustomerPhoneImpl} (default constructor) Phone Default.
   * </ul>
   *
   * <p>Method under test: {@link CustomerPhoneServiceImpl#saveCustomerPhone(CustomerPhone)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CustomerPhone CustomerPhoneServiceImpl.saveCustomerPhone(CustomerPhone)"})
  public void testSaveCustomerPhone_thenNotCustomerPhoneImplPhoneDefault() {
    // Arrange
    ArrayList<CustomerPhone> customerPhoneList = new ArrayList<>();
    customerPhoneList.add(new CustomerPhoneImpl());
    when(customerPhoneDao.readActiveCustomerPhonesByCustomerId(Mockito.<Long>any()))
        .thenReturn(customerPhoneList);
    CustomerPhoneImpl customerPhoneImpl = new CustomerPhoneImpl();
    when(customerPhoneDao.save(Mockito.<CustomerPhone>any())).thenReturn(customerPhoneImpl);

    PhoneImpl phone = new PhoneImpl();
    phone.setActive(true);
    phone.setCountryCode("GB");
    phone.setExtension("Extension");
    phone.setId(1L);
    phone.setPhoneNumber("6625550144");
    phone.setDefault(false);

    CustomerPhoneImpl customerPhone = new CustomerPhoneImpl();
    customerPhone.setCustomer(new CustomerImpl());
    customerPhone.setId(1L);
    customerPhone.setPhoneName("6625550144");
    customerPhone.setPhone(phone);

    // Act
    CustomerPhone actualSaveCustomerPhoneResult =
        customerPhoneServiceImpl.saveCustomerPhone(customerPhone);

    // Assert
    verify(customerPhoneDao).readActiveCustomerPhonesByCustomerId(isNull());
    verify(customerPhoneDao).save(isA(CustomerPhone.class));
    Phone phone2 = customerPhone.getPhone();
    assertTrue(phone2 instanceof PhoneImpl);
    assertFalse(phone2.isDefault());
    assertSame(customerPhoneImpl, actualSaveCustomerPhoneResult);
  }

  /**
   * Test {@link CustomerPhoneServiceImpl#readActiveCustomerPhonesByCustomerId(Long)}.
   *
   * <p>Method under test: {@link
   * CustomerPhoneServiceImpl#readActiveCustomerPhonesByCustomerId(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CustomerPhoneServiceImpl.readActiveCustomerPhonesByCustomerId(Long)"})
  public void testReadActiveCustomerPhonesByCustomerId() {
    // Arrange
    when(customerPhoneDao.readActiveCustomerPhonesByCustomerId(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<CustomerPhone> actualReadActiveCustomerPhonesByCustomerIdResult =
        customerPhoneServiceImpl.readActiveCustomerPhonesByCustomerId(1L);

    // Assert
    verify(customerPhoneDao).readActiveCustomerPhonesByCustomerId(1L);
    assertTrue(actualReadActiveCustomerPhonesByCustomerIdResult.isEmpty());
  }

  /**
   * Test {@link CustomerPhoneServiceImpl#readCustomerPhoneById(Long)}.
   *
   * <p>Method under test: {@link CustomerPhoneServiceImpl#readCustomerPhoneById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CustomerPhone CustomerPhoneServiceImpl.readCustomerPhoneById(Long)"})
  public void testReadCustomerPhoneById() {
    // Arrange
    CustomerPhoneImpl customerPhoneImpl = new CustomerPhoneImpl();
    when(customerPhoneDao.readCustomerPhoneById(Mockito.<Long>any())).thenReturn(customerPhoneImpl);

    // Act
    CustomerPhone actualReadCustomerPhoneByIdResult =
        customerPhoneServiceImpl.readCustomerPhoneById(1L);

    // Assert
    verify(customerPhoneDao).readCustomerPhoneById(1L);
    assertSame(customerPhoneImpl, actualReadCustomerPhoneByIdResult);
  }

  /**
   * Test {@link CustomerPhoneServiceImpl#makeCustomerPhoneDefault(Long, Long)}.
   *
   * <p>Method under test: {@link CustomerPhoneServiceImpl#makeCustomerPhoneDefault(Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerPhoneServiceImpl.makeCustomerPhoneDefault(Long, Long)"})
  public void testMakeCustomerPhoneDefault() {
    // Arrange
    doNothing()
        .when(customerPhoneDao)
        .makeCustomerPhoneDefault(Mockito.<Long>any(), Mockito.<Long>any());

    // Act
    customerPhoneServiceImpl.makeCustomerPhoneDefault(1L, 1L);

    // Assert
    verify(customerPhoneDao).makeCustomerPhoneDefault(1L, 1L);
  }

  /**
   * Test {@link CustomerPhoneServiceImpl#deleteCustomerPhoneById(Long)}.
   *
   * <p>Method under test: {@link CustomerPhoneServiceImpl#deleteCustomerPhoneById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerPhoneServiceImpl.deleteCustomerPhoneById(Long)"})
  public void testDeleteCustomerPhoneById() {
    // Arrange
    doNothing().when(customerPhoneDao).deleteCustomerPhoneById(Mockito.<Long>any());

    // Act
    customerPhoneServiceImpl.deleteCustomerPhoneById(1L);

    // Assert
    verify(customerPhoneDao).deleteCustomerPhoneById(1L);
  }

  /**
   * Test {@link CustomerPhoneServiceImpl#findDefaultCustomerPhone(Long)}.
   *
   * <p>Method under test: {@link CustomerPhoneServiceImpl#findDefaultCustomerPhone(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CustomerPhone CustomerPhoneServiceImpl.findDefaultCustomerPhone(Long)"})
  public void testFindDefaultCustomerPhone() {
    // Arrange
    CustomerPhoneImpl customerPhoneImpl = new CustomerPhoneImpl();
    when(customerPhoneDao.findDefaultCustomerPhone(Mockito.<Long>any()))
        .thenReturn(customerPhoneImpl);

    // Act
    CustomerPhone actualFindDefaultCustomerPhoneResult =
        customerPhoneServiceImpl.findDefaultCustomerPhone(1L);

    // Assert
    verify(customerPhoneDao).findDefaultCustomerPhone(1L);
    assertSame(customerPhoneImpl, actualFindDefaultCustomerPhoneResult);
  }

  /**
   * Test {@link CustomerPhoneServiceImpl#readAllCustomerPhonesByCustomerId(Long)}.
   *
   * <p>Method under test: {@link CustomerPhoneServiceImpl#readAllCustomerPhonesByCustomerId(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CustomerPhoneServiceImpl.readAllCustomerPhonesByCustomerId(Long)"})
  public void testReadAllCustomerPhonesByCustomerId() {
    // Arrange
    when(customerPhoneDao.readAllCustomerPhonesByCustomerId(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<CustomerPhone> actualReadAllCustomerPhonesByCustomerIdResult =
        customerPhoneServiceImpl.readAllCustomerPhonesByCustomerId(1L);

    // Assert
    verify(customerPhoneDao).readAllCustomerPhonesByCustomerId(1L);
    assertTrue(actualReadAllCustomerPhonesByCustomerIdResult.isEmpty());
  }

  /**
   * Test {@link CustomerPhoneServiceImpl#create()}.
   *
   * <p>Method under test: {@link CustomerPhoneServiceImpl#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CustomerPhone CustomerPhoneServiceImpl.create()"})
  public void testCreate() {
    // Arrange
    CustomerPhoneImpl customerPhoneImpl = new CustomerPhoneImpl();
    when(customerPhoneDao.create()).thenReturn(customerPhoneImpl);

    // Act
    CustomerPhone actualCreateResult = customerPhoneServiceImpl.create();

    // Assert
    verify(customerPhoneDao).create();
    assertSame(customerPhoneImpl, actualCreateResult);
  }
}

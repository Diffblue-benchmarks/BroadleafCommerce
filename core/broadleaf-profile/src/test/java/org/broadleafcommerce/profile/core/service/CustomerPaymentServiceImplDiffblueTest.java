package org.broadleafcommerce.profile.core.service;

import static org.junit.Assert.assertNull;
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
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.profile.core.dao.CustomerPaymentDao;
import org.broadleafcommerce.profile.core.domain.ChallengeQuestionImpl;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.domain.CustomerPayment;
import org.broadleafcommerce.profile.core.domain.CustomerPaymentImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CustomerPaymentServiceImplDiffblueTest {
  @Mock private CustomerPaymentDao customerPaymentDao;

  @InjectMocks private CustomerPaymentServiceImpl customerPaymentServiceImpl;

  @Mock private CustomerService customerService;

  /**
   * Test {@link CustomerPaymentServiceImpl#saveCustomerPayment(CustomerPayment)}.
   *
   * <p>Method under test: {@link CustomerPaymentServiceImpl#saveCustomerPayment(CustomerPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CustomerPayment CustomerPaymentServiceImpl.saveCustomerPayment(CustomerPayment)"
  })
  public void testSaveCustomerPayment() {
    // Arrange
    CustomerPaymentImpl customerPaymentImpl = new CustomerPaymentImpl();
    when(customerPaymentDao.save(Mockito.<CustomerPayment>any())).thenReturn(customerPaymentImpl);

    // Act
    CustomerPayment actualSaveCustomerPaymentResult =
        customerPaymentServiceImpl.saveCustomerPayment(new CustomerPaymentImpl());

    // Assert
    verify(customerPaymentDao).save(isA(CustomerPayment.class));
    assertSame(customerPaymentImpl, actualSaveCustomerPaymentResult);
  }

  /**
   * Test {@link CustomerPaymentServiceImpl#readCustomerPaymentsByCustomerId(Long)}.
   *
   * <p>Method under test: {@link CustomerPaymentServiceImpl#readCustomerPaymentsByCustomerId(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CustomerPaymentServiceImpl.readCustomerPaymentsByCustomerId(Long)"})
  public void testReadCustomerPaymentsByCustomerId() {
    // Arrange
    when(customerPaymentDao.readCustomerPaymentsByCustomerId(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<CustomerPayment> actualReadCustomerPaymentsByCustomerIdResult =
        customerPaymentServiceImpl.readCustomerPaymentsByCustomerId(1L);

    // Assert
    verify(customerPaymentDao).readCustomerPaymentsByCustomerId(1L);
    assertTrue(actualReadCustomerPaymentsByCustomerIdResult.isEmpty());
  }

  /**
   * Test {@link CustomerPaymentServiceImpl#readCustomerPaymentById(Long)}.
   *
   * <p>Method under test: {@link CustomerPaymentServiceImpl#readCustomerPaymentById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CustomerPayment CustomerPaymentServiceImpl.readCustomerPaymentById(Long)"})
  public void testReadCustomerPaymentById() {
    // Arrange
    CustomerPaymentImpl customerPaymentImpl = new CustomerPaymentImpl();
    when(customerPaymentDao.readCustomerPaymentById(Mockito.<Long>any()))
        .thenReturn(customerPaymentImpl);

    // Act
    CustomerPayment actualReadCustomerPaymentByIdResult =
        customerPaymentServiceImpl.readCustomerPaymentById(1L);

    // Assert
    verify(customerPaymentDao).readCustomerPaymentById(1L);
    assertSame(customerPaymentImpl, actualReadCustomerPaymentByIdResult);
  }

  /**
   * Test {@link CustomerPaymentServiceImpl#readCustomerPaymentByToken(String)}.
   *
   * <p>Method under test: {@link CustomerPaymentServiceImpl#readCustomerPaymentByToken(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CustomerPayment CustomerPaymentServiceImpl.readCustomerPaymentByToken(String)"
  })
  public void testReadCustomerPaymentByToken() {
    // Arrange
    CustomerPaymentImpl customerPaymentImpl = new CustomerPaymentImpl();
    when(customerPaymentDao.readCustomerPaymentByToken(Mockito.<String>any()))
        .thenReturn(customerPaymentImpl);

    // Act
    CustomerPayment actualReadCustomerPaymentByTokenResult =
        customerPaymentServiceImpl.readCustomerPaymentByToken("ABC123");

    // Assert
    verify(customerPaymentDao).readCustomerPaymentByToken("ABC123");
    assertSame(customerPaymentImpl, actualReadCustomerPaymentByTokenResult);
  }

  /**
   * Test {@link CustomerPaymentServiceImpl#deleteCustomerPaymentById(Long)}.
   *
   * <p>Method under test: {@link CustomerPaymentServiceImpl#deleteCustomerPaymentById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerPaymentServiceImpl.deleteCustomerPaymentById(Long)"})
  public void testDeleteCustomerPaymentById() {
    // Arrange
    doNothing().when(customerPaymentDao).deleteCustomerPaymentById(Mockito.<Long>any());

    // Act
    customerPaymentServiceImpl.deleteCustomerPaymentById(1L);

    // Assert
    verify(customerPaymentDao).deleteCustomerPaymentById(1L);
  }

  /**
   * Test {@link CustomerPaymentServiceImpl#deleteCustomerPaymentByToken(String)}.
   *
   * <p>Method under test: {@link CustomerPaymentServiceImpl#deleteCustomerPaymentByToken(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerPaymentServiceImpl.deleteCustomerPaymentByToken(String)"})
  public void testDeleteCustomerPaymentByToken() {
    // Arrange
    doNothing().when(customerPaymentDao).deleteCustomerPaymentByToken(Mockito.<String>any());

    // Act
    customerPaymentServiceImpl.deleteCustomerPaymentByToken("ABC123");

    // Assert
    verify(customerPaymentDao).deleteCustomerPaymentByToken("ABC123");
  }

  /**
   * Test {@link CustomerPaymentServiceImpl#create()}.
   *
   * <p>Method under test: {@link CustomerPaymentServiceImpl#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CustomerPayment CustomerPaymentServiceImpl.create()"})
  public void testCreate() {
    // Arrange
    CustomerPaymentImpl customerPaymentImpl = new CustomerPaymentImpl();
    when(customerPaymentDao.create()).thenReturn(customerPaymentImpl);

    // Act
    CustomerPayment actualCreateResult = customerPaymentServiceImpl.create();

    // Assert
    verify(customerPaymentDao).create();
    assertSame(customerPaymentImpl, actualCreateResult);
  }

  /**
   * Test {@link CustomerPaymentServiceImpl#findDefaultPaymentForCustomer(Customer)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CustomerPaymentImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomerPaymentServiceImpl#findDefaultPaymentForCustomer(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CustomerPayment CustomerPaymentServiceImpl.findDefaultPaymentForCustomer(Customer)"
  })
  public void testFindDefaultPaymentForCustomer_givenArrayListAddCustomerPaymentImpl() {
    // Arrange
    ArrayList<CustomerPayment> customerPaymentList = new ArrayList<>();
    customerPaymentList.add(new CustomerPaymentImpl());
    when(customerPaymentDao.readCustomerPaymentsByCustomerId(Mockito.<Long>any()))
        .thenReturn(customerPaymentList);

    // Act
    CustomerPayment actualFindDefaultPaymentForCustomerResult =
        customerPaymentServiceImpl.findDefaultPaymentForCustomer(new CustomerImpl());

    // Assert
    verify(customerPaymentDao).readCustomerPaymentsByCustomerId(isNull());
    assertNull(actualFindDefaultPaymentForCustomerResult);
  }

  /**
   * Test {@link CustomerPaymentServiceImpl#findDefaultPaymentForCustomer(Customer)}.
   *
   * <ul>
   *   <li>Given {@link CustomerPaymentServiceImpl} (default constructor).
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomerPaymentServiceImpl#findDefaultPaymentForCustomer(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CustomerPayment CustomerPaymentServiceImpl.findDefaultPaymentForCustomer(Customer)"
  })
  public void testFindDefaultPaymentForCustomer_givenCustomerPaymentServiceImpl_whenNull() {
    // Arrange, Act and Assert
    assertNull(new CustomerPaymentServiceImpl().findDefaultPaymentForCustomer(null));
  }

  /**
   * Test {@link CustomerPaymentServiceImpl#findDefaultPaymentForCustomer(Customer)}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerPaymentImpl#isDefault()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomerPaymentServiceImpl#findDefaultPaymentForCustomer(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CustomerPayment CustomerPaymentServiceImpl.findDefaultPaymentForCustomer(Customer)"
  })
  public void testFindDefaultPaymentForCustomer_thenCallsIsDefault() {
    // Arrange
    CustomerPaymentImpl customerPaymentImpl = mock(CustomerPaymentImpl.class);
    when(customerPaymentImpl.isDefault()).thenReturn(true);

    ArrayList<CustomerPayment> customerPaymentList = new ArrayList<>();
    customerPaymentList.add(customerPaymentImpl);
    when(customerPaymentDao.readCustomerPaymentsByCustomerId(Mockito.<Long>any()))
        .thenReturn(customerPaymentList);

    // Act
    customerPaymentServiceImpl.findDefaultPaymentForCustomer(new CustomerImpl());

    // Assert
    verify(customerPaymentDao).readCustomerPaymentsByCustomerId(isNull());
    verify(customerPaymentImpl).isDefault();
  }

  /**
   * Test {@link CustomerPaymentServiceImpl#findDefaultPaymentForCustomer(Customer)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomerPaymentServiceImpl#findDefaultPaymentForCustomer(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CustomerPayment CustomerPaymentServiceImpl.findDefaultPaymentForCustomer(Customer)"
  })
  public void testFindDefaultPaymentForCustomer_thenReturnNull() {
    // Arrange
    when(customerPaymentDao.readCustomerPaymentsByCustomerId(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());

    // Act
    CustomerPayment actualFindDefaultPaymentForCustomerResult =
        customerPaymentServiceImpl.findDefaultPaymentForCustomer(new CustomerImpl());

    // Assert
    verify(customerPaymentDao).readCustomerPaymentsByCustomerId(isNull());
    assertNull(actualFindDefaultPaymentForCustomerResult);
  }

  /**
   * Test {@link CustomerPaymentServiceImpl#setAsDefaultPayment(CustomerPayment)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CustomerPaymentImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link CustomerPaymentServiceImpl#setAsDefaultPayment(CustomerPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CustomerPayment CustomerPaymentServiceImpl.setAsDefaultPayment(CustomerPayment)"
  })
  public void testSetAsDefaultPayment_givenArrayListAddCustomerPaymentImpl() {
    // Arrange
    ArrayList<CustomerPayment> customerPaymentList = new ArrayList<>();
    customerPaymentList.add(new CustomerPaymentImpl());
    when(customerPaymentDao.readCustomerPaymentsByCustomerId(Mockito.<Long>any()))
        .thenReturn(customerPaymentList);
    CustomerPaymentImpl customerPaymentImpl = new CustomerPaymentImpl();
    when(customerPaymentDao.save(Mockito.<CustomerPayment>any())).thenReturn(customerPaymentImpl);

    CustomerPaymentImpl payment = mock(CustomerPaymentImpl.class);
    when(payment.getCustomer()).thenReturn(new CustomerImpl());
    doNothing().when(payment).setIsDefault(anyBoolean());

    // Act
    CustomerPayment actualSetAsDefaultPaymentResult =
        customerPaymentServiceImpl.setAsDefaultPayment(payment);

    // Assert
    verify(customerPaymentDao).readCustomerPaymentsByCustomerId(isNull());
    verify(customerPaymentDao).save(isA(CustomerPayment.class));
    verify(payment).getCustomer();
    verify(payment).setIsDefault(true);
    assertSame(customerPaymentImpl, actualSetAsDefaultPaymentResult);
  }

  /**
   * Test {@link CustomerPaymentServiceImpl#setAsDefaultPayment(CustomerPayment)}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerPaymentImpl#isDefault()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerPaymentServiceImpl#setAsDefaultPayment(CustomerPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CustomerPayment CustomerPaymentServiceImpl.setAsDefaultPayment(CustomerPayment)"
  })
  public void testSetAsDefaultPayment_thenCallsIsDefault() {
    // Arrange
    CustomerPaymentImpl customerPaymentImpl = mock(CustomerPaymentImpl.class);
    doNothing().when(customerPaymentImpl).setIsDefault(anyBoolean());
    when(customerPaymentImpl.isDefault()).thenReturn(true);

    ArrayList<CustomerPayment> customerPaymentList = new ArrayList<>();
    customerPaymentList.add(customerPaymentImpl);
    when(customerPaymentDao.readCustomerPaymentsByCustomerId(Mockito.<Long>any()))
        .thenReturn(customerPaymentList);
    CustomerPaymentImpl customerPaymentImpl2 = new CustomerPaymentImpl();
    when(customerPaymentDao.save(Mockito.<CustomerPayment>any())).thenReturn(customerPaymentImpl2);

    CustomerPaymentImpl payment = mock(CustomerPaymentImpl.class);
    when(payment.getCustomer()).thenReturn(new CustomerImpl());
    doNothing().when(payment).setIsDefault(anyBoolean());

    // Act
    CustomerPayment actualSetAsDefaultPaymentResult =
        customerPaymentServiceImpl.setAsDefaultPayment(payment);

    // Assert
    verify(customerPaymentDao).readCustomerPaymentsByCustomerId(isNull());
    verify(customerPaymentDao, atLeast(1)).save(Mockito.<CustomerPayment>any());
    verify(payment).getCustomer();
    verify(customerPaymentImpl).isDefault();
    verify(customerPaymentImpl).setIsDefault(false);
    verify(payment).setIsDefault(true);
    assertSame(customerPaymentImpl2, actualSetAsDefaultPaymentResult);
  }

  /**
   * Test {@link CustomerPaymentServiceImpl#setAsDefaultPayment(CustomerPayment)}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerPaymentDao#readCustomerPaymentsByCustomerId(Long)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerPaymentServiceImpl#setAsDefaultPayment(CustomerPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CustomerPayment CustomerPaymentServiceImpl.setAsDefaultPayment(CustomerPayment)"
  })
  public void testSetAsDefaultPayment_thenCallsReadCustomerPaymentsByCustomerId() {
    // Arrange
    when(customerPaymentDao.readCustomerPaymentsByCustomerId(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());
    CustomerPaymentImpl customerPaymentImpl = new CustomerPaymentImpl();
    when(customerPaymentDao.save(Mockito.<CustomerPayment>any())).thenReturn(customerPaymentImpl);

    CustomerPaymentImpl payment = mock(CustomerPaymentImpl.class);
    when(payment.getCustomer()).thenReturn(new CustomerImpl());
    doNothing().when(payment).setIsDefault(anyBoolean());

    // Act
    CustomerPayment actualSetAsDefaultPaymentResult =
        customerPaymentServiceImpl.setAsDefaultPayment(payment);

    // Assert
    verify(customerPaymentDao).readCustomerPaymentsByCustomerId(isNull());
    verify(customerPaymentDao).save(isA(CustomerPayment.class));
    verify(payment).getCustomer();
    verify(payment).setIsDefault(true);
    assertSame(customerPaymentImpl, actualSetAsDefaultPaymentResult);
  }

  /**
   * Test {@link CustomerPaymentServiceImpl#setAsDefaultPayment(CustomerPayment)}.
   *
   * <ul>
   *   <li>When {@link CustomerPaymentImpl} (default constructor).
   *   <li>Then {@link CustomerPaymentImpl} (default constructor) Default.
   * </ul>
   *
   * <p>Method under test: {@link CustomerPaymentServiceImpl#setAsDefaultPayment(CustomerPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CustomerPayment CustomerPaymentServiceImpl.setAsDefaultPayment(CustomerPayment)"
  })
  public void testSetAsDefaultPayment_whenCustomerPaymentImpl_thenCustomerPaymentImplDefault() {
    // Arrange
    CustomerPaymentImpl customerPaymentImpl = new CustomerPaymentImpl();
    when(customerPaymentDao.save(Mockito.<CustomerPayment>any())).thenReturn(customerPaymentImpl);
    CustomerPaymentImpl payment = new CustomerPaymentImpl();

    // Act
    CustomerPayment actualSetAsDefaultPaymentResult =
        customerPaymentServiceImpl.setAsDefaultPayment(payment);

    // Assert
    verify(customerPaymentDao).save(isA(CustomerPayment.class));
    assertTrue(payment.isDefault());
    assertSame(customerPaymentImpl, actualSetAsDefaultPaymentResult);
  }

  /**
   * Test {@link CustomerPaymentServiceImpl#clearDefaultPaymentStatus(Customer)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CustomerPaymentImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link CustomerPaymentServiceImpl#clearDefaultPaymentStatus(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerPaymentServiceImpl.clearDefaultPaymentStatus(Customer)"})
  public void testClearDefaultPaymentStatus_givenArrayListAddCustomerPaymentImpl() {
    // Arrange
    ArrayList<CustomerPayment> customerPaymentList = new ArrayList<>();
    customerPaymentList.add(new CustomerPaymentImpl());
    when(customerPaymentDao.readCustomerPaymentsByCustomerId(Mockito.<Long>any()))
        .thenReturn(customerPaymentList);

    // Act
    customerPaymentServiceImpl.clearDefaultPaymentStatus(new CustomerImpl());

    // Assert
    verify(customerPaymentDao).readCustomerPaymentsByCustomerId(isNull());
  }

  /**
   * Test {@link CustomerPaymentServiceImpl#clearDefaultPaymentStatus(Customer)}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerPaymentDao#readCustomerPaymentsByCustomerId(Long)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerPaymentServiceImpl#clearDefaultPaymentStatus(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerPaymentServiceImpl.clearDefaultPaymentStatus(Customer)"})
  public void testClearDefaultPaymentStatus_thenCallsReadCustomerPaymentsByCustomerId() {
    // Arrange
    when(customerPaymentDao.readCustomerPaymentsByCustomerId(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());

    // Act
    customerPaymentServiceImpl.clearDefaultPaymentStatus(new CustomerImpl());

    // Assert
    verify(customerPaymentDao).readCustomerPaymentsByCustomerId(isNull());
  }

  /**
   * Test {@link CustomerPaymentServiceImpl#clearDefaultPaymentStatus(Customer)}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerPaymentDao#save(CustomerPayment)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerPaymentServiceImpl#clearDefaultPaymentStatus(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerPaymentServiceImpl.clearDefaultPaymentStatus(Customer)"})
  public void testClearDefaultPaymentStatus_thenCallsSave() {
    // Arrange
    CustomerPaymentImpl customerPaymentImpl = mock(CustomerPaymentImpl.class);
    doNothing().when(customerPaymentImpl).setIsDefault(anyBoolean());
    when(customerPaymentImpl.isDefault()).thenReturn(true);

    ArrayList<CustomerPayment> customerPaymentList = new ArrayList<>();
    customerPaymentList.add(customerPaymentImpl);
    when(customerPaymentDao.save(Mockito.<CustomerPayment>any()))
        .thenReturn(new CustomerPaymentImpl());
    when(customerPaymentDao.readCustomerPaymentsByCustomerId(Mockito.<Long>any()))
        .thenReturn(customerPaymentList);

    // Act
    customerPaymentServiceImpl.clearDefaultPaymentStatus(new CustomerImpl());

    // Assert
    verify(customerPaymentDao).readCustomerPaymentsByCustomerId(isNull());
    verify(customerPaymentDao).save(isA(CustomerPayment.class));
    verify(customerPaymentImpl).isDefault();
    verify(customerPaymentImpl).setIsDefault(false);
  }

  /**
   * Test {@link CustomerPaymentServiceImpl#deleteCustomerPaymentFromCustomer(Customer,
   * CustomerPayment)}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerPaymentImpl#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomerPaymentServiceImpl#deleteCustomerPaymentFromCustomer(Customer, CustomerPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Customer CustomerPaymentServiceImpl.deleteCustomerPaymentFromCustomer(Customer, CustomerPayment)"
  })
  public void testDeleteCustomerPaymentFromCustomer_thenCallsGetId() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerService.saveCustomer(Mockito.<Customer>any())).thenReturn(customerImpl);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    CustomerPaymentImpl customerPaymentImpl = mock(CustomerPaymentImpl.class);
    when(customerPaymentImpl.getId()).thenReturn(1L);

    ArrayList<CustomerPayment> customerPayments = new ArrayList<>();
    customerPayments.add(customerPaymentImpl);

    CustomerImpl customer = new CustomerImpl();
    customer.setAuditable(auditable);
    customer.setChallengeAnswer("Challenge Answer");
    customer.setChallengeQuestion(new ChallengeQuestionImpl());
    customer.setCustomerAddresses(new ArrayList<>());
    customer.setCustomerAttributes(new HashMap<>());
    customer.setCustomerLocale(new LocaleImpl());
    customer.setCustomerPhones(new ArrayList<>());
    customer.setDeactivated(true);
    customer.setEmailAddress("42 Main St");
    customer.setExternalId("42");
    customer.setFirstName("Jane");
    customer.setId(1L);
    customer.setLastName("Doe");
    customer.setPassword("iloveyou");
    customer.setPasswordChangeRequired(true);
    customer.setReceiveEmail(true);
    customer.setRegistered(true);
    customer.setUnencodedChallengeAnswer("secret");
    customer.setUnencodedPassword("secret");
    customer.setUsername("janedoe");
    customer.setCustomerPayments(customerPayments);

    // Act
    Customer actualDeleteCustomerPaymentFromCustomerResult =
        customerPaymentServiceImpl.deleteCustomerPaymentFromCustomer(
            customer, new CustomerPaymentImpl());

    // Assert
    verify(customerPaymentImpl).getId();
    verify(customerService).saveCustomer(isA(Customer.class));
    assertSame(customerImpl, actualDeleteCustomerPaymentFromCustomerResult);
  }

  /**
   * Test {@link CustomerPaymentServiceImpl#deleteCustomerPaymentFromCustomer(Customer,
   * CustomerPayment)}.
   *
   * <ul>
   *   <li>When {@link CustomerImpl} (default constructor).
   *   <li>Then return {@link CustomerImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomerPaymentServiceImpl#deleteCustomerPaymentFromCustomer(Customer, CustomerPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Customer CustomerPaymentServiceImpl.deleteCustomerPaymentFromCustomer(Customer, CustomerPayment)"
  })
  public void testDeleteCustomerPaymentFromCustomer_whenCustomerImpl_thenReturnCustomerImpl() {
    // Arrange
    CustomerImpl customerImpl = new CustomerImpl();
    when(customerService.saveCustomer(Mockito.<Customer>any())).thenReturn(customerImpl);
    CustomerImpl customer = new CustomerImpl();

    // Act
    Customer actualDeleteCustomerPaymentFromCustomerResult =
        customerPaymentServiceImpl.deleteCustomerPaymentFromCustomer(
            customer, new CustomerPaymentImpl());

    // Assert
    verify(customerService).saveCustomer(isA(Customer.class));
    assertSame(customerImpl, actualDeleteCustomerPaymentFromCustomerResult);
  }
}

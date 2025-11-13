package org.broadleafcommerce.profile.core.dao;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import javax.persistence.NoResultException;
import org.broadleafcommerce.common.payment.PaymentGatewayType;
import org.broadleafcommerce.common.payment.PaymentType;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
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
public class CustomerPaymentDaoImplDiffblueTest {
  @InjectMocks private CustomerPaymentDaoImpl customerPaymentDaoImpl;

  @Mock private EntityConfiguration entityConfiguration;

  /**
   * Test {@link CustomerPaymentDaoImpl#create()}.
   *
   * <ul>
   *   <li>Then return {@link CustomerPaymentImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CustomerPaymentDaoImpl#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CustomerPayment CustomerPaymentDaoImpl.create()"})
  public void testCreate_thenReturnCustomerPaymentImpl() {
    // Arrange
    CustomerPaymentImpl customerPaymentImpl = new CustomerPaymentImpl();
    customerPaymentImpl.setAdditionalFields(new HashMap<>());
    customerPaymentImpl.setBillingAddress(new AddressImpl());
    customerPaymentImpl.setCustomer(new CustomerImpl());
    customerPaymentImpl.setId(1L);
    customerPaymentImpl.setIsDefault(true);
    customerPaymentImpl.setPaymentGatewayType(new PaymentGatewayType());
    customerPaymentImpl.setPaymentToken("ABC123");
    customerPaymentImpl.setPaymentType(new PaymentType());
    when(entityConfiguration.createEntityInstance(Mockito.<String>any()))
        .thenReturn(customerPaymentImpl);

    // Act
    CustomerPayment actualCreateResult = customerPaymentDaoImpl.create();

    // Assert
    verify(entityConfiguration)
        .createEntityInstance("org.broadleafcommerce.profile.core.domain.CustomerPayment");
    assertSame(customerPaymentImpl, actualCreateResult);
  }

  /**
   * Test {@link CustomerPaymentDaoImpl#create()}.
   *
   * <ul>
   *   <li>Then throw {@link NoResultException}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerPaymentDaoImpl#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CustomerPayment CustomerPaymentDaoImpl.create()"})
  public void testCreate_thenThrowNoResultException() {
    // Arrange
    when(entityConfiguration.createEntityInstance(Mockito.<String>any()))
        .thenThrow(new NoResultException());

    // Act and Assert
    assertThrows(NoResultException.class, () -> customerPaymentDaoImpl.create());
    verify(entityConfiguration)
        .createEntityInstance("org.broadleafcommerce.profile.core.domain.CustomerPayment");
  }
}

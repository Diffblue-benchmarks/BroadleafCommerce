package org.broadleafcommerce.profile.core.dao;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
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
public class CustomerAddressDaoImplDiffblueTest {
  @InjectMocks private CustomerAddressDaoImpl customerAddressDaoImpl;

  @Mock private EntityConfiguration entityConfiguration;

  /**
   * Test {@link CustomerAddressDaoImpl#create()}.
   *
   * <p>Method under test: {@link CustomerAddressDaoImpl#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CustomerAddress CustomerAddressDaoImpl.create()"})
  public void testCreate() {
    // Arrange
    CustomerAddressImpl customerAddressImpl = new CustomerAddressImpl();
    customerAddressImpl.setAddress(new AddressImpl());
    customerAddressImpl.setAddressName("42 Main St");
    customerAddressImpl.setCustomer(new CustomerImpl());
    customerAddressImpl.setId(1L);
    when(entityConfiguration.createEntityInstance(Mockito.<String>any()))
        .thenReturn(customerAddressImpl);

    // Act
    CustomerAddress actualCreateResult = customerAddressDaoImpl.create();

    // Assert
    verify(entityConfiguration)
        .createEntityInstance("org.broadleafcommerce.profile.core.domain.CustomerAddress");
    assertSame(customerAddressImpl, actualCreateResult);
  }
}

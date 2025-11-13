package org.broadleafcommerce.profile.core.dao;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.domain.CustomerPhone;
import org.broadleafcommerce.profile.core.domain.CustomerPhoneImpl;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CustomerPhoneDaoImplDiffblueTest {
  @InjectMocks private CustomerPhoneDaoImpl customerPhoneDaoImpl;

  @Mock private EntityConfiguration entityConfiguration;

  /**
   * Test {@link CustomerPhoneDaoImpl#create()}.
   *
   * <p>Method under test: {@link CustomerPhoneDaoImpl#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CustomerPhone CustomerPhoneDaoImpl.create()"})
  public void testCreate() {
    // Arrange
    CustomerPhoneImpl customerPhoneImpl = new CustomerPhoneImpl();
    customerPhoneImpl.setCustomer(new CustomerImpl());
    customerPhoneImpl.setId(1L);
    customerPhoneImpl.setPhone(new PhoneImpl());
    customerPhoneImpl.setPhoneName("6625550144");
    when(entityConfiguration.createEntityInstance(Mockito.<String>any()))
        .thenReturn(customerPhoneImpl);

    // Act
    CustomerPhone actualCreateResult = customerPhoneDaoImpl.create();

    // Assert
    verify(entityConfiguration)
        .createEntityInstance("org.broadleafcommerce.profile.core.domain.CustomerPhone");
    assertSame(customerPhoneImpl, actualCreateResult);
  }
}

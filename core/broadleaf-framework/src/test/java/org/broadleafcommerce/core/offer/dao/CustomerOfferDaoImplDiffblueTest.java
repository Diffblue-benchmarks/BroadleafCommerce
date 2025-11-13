package org.broadleafcommerce.core.offer.dao;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.core.offer.domain.CustomerOffer;
import org.broadleafcommerce.core.offer.domain.CustomerOfferImpl;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CustomerOfferDaoImplDiffblueTest {
  @InjectMocks private CustomerOfferDaoImpl customerOfferDaoImpl;

  @Mock private EntityConfiguration entityConfiguration;

  /**
   * Test {@link CustomerOfferDaoImpl#create()}.
   *
   * <p>Method under test: {@link CustomerOfferDaoImpl#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CustomerOffer CustomerOfferDaoImpl.create()"})
  public void testCreate() {
    // Arrange
    CustomerOfferImpl customerOfferImpl = new CustomerOfferImpl();
    customerOfferImpl.setCustomer(new CustomerImpl());
    customerOfferImpl.setId(CustomerOfferImpl.serialVersionUID);
    customerOfferImpl.setOffer(new OfferImpl());
    when(entityConfiguration.createEntityInstance(Mockito.<String>any()))
        .thenReturn(customerOfferImpl);

    // Act
    CustomerOffer actualCreateResult = customerOfferDaoImpl.create();

    // Assert
    verify(entityConfiguration)
        .createEntityInstance("org.broadleafcommerce.core.offer.domain.CustomerOffer");
    assertSame(customerOfferImpl, actualCreateResult);
  }
}

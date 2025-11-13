package org.broadleafcommerce.core.order.dao;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentOptionImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.OrderMultishipOption;
import org.broadleafcommerce.core.order.domain.OrderMultishipOptionImpl;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OrderMultishipOptionDaoImplDiffblueTest {
  @Mock private EntityConfiguration entityConfiguration;

  @InjectMocks private OrderMultishipOptionDaoImpl orderMultishipOptionDaoImpl;

  /**
   * Test {@link OrderMultishipOptionDaoImpl#create()}.
   *
   * <p>Method under test: {@link OrderMultishipOptionDaoImpl#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderMultishipOption OrderMultishipOptionDaoImpl.create()"})
  public void testCreate() {
    // Arrange
    OrderMultishipOptionImpl orderMultishipOptionImpl = new OrderMultishipOptionImpl();
    orderMultishipOptionImpl.setAddress(new AddressImpl());
    orderMultishipOptionImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    orderMultishipOptionImpl.setId(1L);
    orderMultishipOptionImpl.setOrder(new NullOrderImpl());
    orderMultishipOptionImpl.setOrderItem(new BundleOrderItemImpl());
    when(entityConfiguration.createEntityInstance(Mockito.<String>any()))
        .thenReturn(orderMultishipOptionImpl);

    // Act
    OrderMultishipOption actualCreateResult = orderMultishipOptionDaoImpl.create();

    // Assert
    verify(entityConfiguration)
        .createEntityInstance("org.broadleafcommerce.core.order.domain.OrderMultishipOption");
    assertSame(orderMultishipOptionImpl, actualCreateResult);
  }
}

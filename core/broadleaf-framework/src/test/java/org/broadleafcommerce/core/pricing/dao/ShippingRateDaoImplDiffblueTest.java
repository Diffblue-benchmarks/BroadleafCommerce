package org.broadleafcommerce.core.pricing.dao;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.core.pricing.domain.ShippingRate;
import org.broadleafcommerce.core.pricing.domain.ShippingRateImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ShippingRateDaoImplDiffblueTest {
  @Mock private EntityConfiguration entityConfiguration;

  @InjectMocks private ShippingRateDaoImpl shippingRateDaoImpl;

  /**
   * Test {@link ShippingRateDaoImpl#create()}.
   *
   * <p>Method under test: {@link ShippingRateDaoImpl#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ShippingRate ShippingRateDaoImpl.create()"})
  public void testCreate() {
    // Arrange
    ShippingRateImpl shippingRateImpl = new ShippingRateImpl();
    shippingRateImpl.setBandResultPercent(1);
    shippingRateImpl.setBandResultQuantity(new BigDecimal("2.3"));
    shippingRateImpl.setBandUnitQuantity(new BigDecimal("2.3"));
    shippingRateImpl.setFeeBand(1);
    shippingRateImpl.setFeeSubType("Fee Sub Type");
    shippingRateImpl.setFeeType("Fee Type");
    shippingRateImpl.setId(1L);
    when(entityConfiguration.createEntityInstance(Mockito.<String>any()))
        .thenReturn(shippingRateImpl);

    // Act
    ShippingRate actualCreateResult = shippingRateDaoImpl.create();

    // Assert
    verify(entityConfiguration)
        .createEntityInstance("org.broadleafcommerce.core.pricing.domain.ShippingRate");
    assertSame(shippingRateImpl, actualCreateResult);
  }
}

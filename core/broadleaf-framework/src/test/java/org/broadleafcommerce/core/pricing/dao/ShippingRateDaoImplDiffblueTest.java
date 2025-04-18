/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.pricing.dao;

import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
  @Mock
  private EntityConfiguration entityConfiguration;

  @InjectMocks
  private ShippingRateDaoImpl shippingRateDaoImpl;

  /**
   * Test {@link ShippingRateDaoImpl#create()}.
   * <p>
   * Method under test: {@link ShippingRateDaoImpl#create()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    when(entityConfiguration.createEntityInstance(Mockito.<String>any())).thenReturn(shippingRateImpl);

    // Act
    ShippingRate actualCreateResult = shippingRateDaoImpl.create();

    // Assert
    verify(entityConfiguration).createEntityInstance(eq("org.broadleafcommerce.core.pricing.domain.ShippingRate"));
    assertSame(shippingRateImpl, actualCreateResult);
  }
}

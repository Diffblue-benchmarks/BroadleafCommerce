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
package org.broadleafcommerce.core.pricing.service;

import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.broadleafcommerce.core.pricing.dao.ShippingRateDao;
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
public class ShippingRateServiceImplDiffblueTest {
  @Mock private ShippingRateDao shippingRateDao;

  @InjectMocks private ShippingRateServiceImpl shippingRateServiceImpl;

  /**
   * Test {@link ShippingRateServiceImpl#readShippingRateByFeeTypesUnityQty(String, String,
   * BigDecimal)}.
   *
   * <p>Method under test: {@link ShippingRateServiceImpl#readShippingRateByFeeTypesUnityQty(String,
   * String, BigDecimal)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ShippingRate ShippingRateServiceImpl.readShippingRateByFeeTypesUnityQty(String, String, BigDecimal)"
  })
  public void testReadShippingRateByFeeTypesUnityQty() {
    // Arrange
    ShippingRateImpl shippingRateImpl = new ShippingRateImpl();
    when(shippingRateDao.readShippingRateByFeeTypesUnityQty(
            Mockito.<String>any(), Mockito.<String>any(), Mockito.<BigDecimal>any()))
        .thenReturn(shippingRateImpl);

    // Act
    ShippingRate actualReadShippingRateByFeeTypesUnityQtyResult =
        shippingRateServiceImpl.readShippingRateByFeeTypesUnityQty(
            "Fee Type", "Fee Sub Type", new BigDecimal("2.3"));

    // Assert
    verify(shippingRateDao)
        .readShippingRateByFeeTypesUnityQty(
            eq("Fee Type"), eq("Fee Sub Type"), isA(BigDecimal.class));
    assertSame(shippingRateImpl, actualReadShippingRateByFeeTypesUnityQtyResult);
  }

  /**
   * Test {@link ShippingRateServiceImpl#readShippingRateById(Long)}.
   *
   * <p>Method under test: {@link ShippingRateServiceImpl#readShippingRateById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ShippingRate ShippingRateServiceImpl.readShippingRateById(Long)"})
  public void testReadShippingRateById() {
    // Arrange
    ShippingRateImpl shippingRateImpl = new ShippingRateImpl();
    when(shippingRateDao.readShippingRateById(Mockito.<Long>any())).thenReturn(shippingRateImpl);

    // Act
    ShippingRate actualReadShippingRateByIdResult =
        shippingRateServiceImpl.readShippingRateById(1L);

    // Assert
    verify(shippingRateDao).readShippingRateById(1L);
    assertSame(shippingRateImpl, actualReadShippingRateByIdResult);
  }

  /**
   * Test {@link ShippingRateServiceImpl#save(ShippingRate)}.
   *
   * <p>Method under test: {@link ShippingRateServiceImpl#save(ShippingRate)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ShippingRate ShippingRateServiceImpl.save(ShippingRate)"})
  public void testSave() {
    // Arrange
    ShippingRateImpl shippingRateImpl = new ShippingRateImpl();
    when(shippingRateDao.save(Mockito.<ShippingRate>any())).thenReturn(shippingRateImpl);

    // Act
    ShippingRate actualSaveResult = shippingRateServiceImpl.save(new ShippingRateImpl());

    // Assert
    verify(shippingRateDao).save(isA(ShippingRate.class));
    assertSame(shippingRateImpl, actualSaveResult);
  }
}

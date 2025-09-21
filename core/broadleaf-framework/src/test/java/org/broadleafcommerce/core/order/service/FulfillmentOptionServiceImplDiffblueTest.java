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
package org.broadleafcommerce.core.order.service;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.core.order.dao.FulfillmentOptionDao;
import org.broadleafcommerce.core.order.domain.FulfillmentOption;
import org.broadleafcommerce.core.order.domain.FulfillmentOptionImpl;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FulfillmentOptionServiceImplDiffblueTest {
  @Mock private FulfillmentOptionDao fulfillmentOptionDao;

  @InjectMocks private FulfillmentOptionServiceImpl fulfillmentOptionServiceImpl;

  /**
   * Test {@link FulfillmentOptionServiceImpl#readFulfillmentOptionById(Long)}.
   *
   * <p>Method under test: {@link FulfillmentOptionServiceImpl#readFulfillmentOptionById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentOption FulfillmentOptionServiceImpl.readFulfillmentOptionById(Long)"
  })
  public void testReadFulfillmentOptionById() {
    // Arrange
    FulfillmentOptionImpl fulfillmentOptionImpl = new FulfillmentOptionImpl();
    when(fulfillmentOptionDao.readFulfillmentOptionById(Mockito.<Long>any()))
        .thenReturn(fulfillmentOptionImpl);

    // Act
    FulfillmentOption actualReadFulfillmentOptionByIdResult =
        fulfillmentOptionServiceImpl.readFulfillmentOptionById(1L);

    // Assert
    verify(fulfillmentOptionDao).readFulfillmentOptionById(1L);
    assertSame(fulfillmentOptionImpl, actualReadFulfillmentOptionByIdResult);
  }

  /**
   * Test {@link FulfillmentOptionServiceImpl#save(FulfillmentOption)}.
   *
   * <p>Method under test: {@link FulfillmentOptionServiceImpl#save(FulfillmentOption)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FulfillmentOption FulfillmentOptionServiceImpl.save(FulfillmentOption)"})
  public void testSave() {
    // Arrange
    FulfillmentOptionImpl fulfillmentOptionImpl = new FulfillmentOptionImpl();
    when(fulfillmentOptionDao.save(Mockito.<FulfillmentOption>any()))
        .thenReturn(fulfillmentOptionImpl);

    // Act
    FulfillmentOption actualSaveResult =
        fulfillmentOptionServiceImpl.save(new FulfillmentOptionImpl());

    // Assert
    verify(fulfillmentOptionDao).save(isA(FulfillmentOption.class));
    assertSame(fulfillmentOptionImpl, actualSaveResult);
  }

  /**
   * Test {@link FulfillmentOptionServiceImpl#readAllFulfillmentOptions()}.
   *
   * <p>Method under test: {@link FulfillmentOptionServiceImpl#readAllFulfillmentOptions()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List FulfillmentOptionServiceImpl.readAllFulfillmentOptions()"})
  public void testReadAllFulfillmentOptions() {
    // Arrange
    when(fulfillmentOptionDao.readAllFulfillmentOptions()).thenReturn(new ArrayList<>());

    // Act
    List<FulfillmentOption> actualReadAllFulfillmentOptionsResult =
        fulfillmentOptionServiceImpl.readAllFulfillmentOptions();

    // Assert
    verify(fulfillmentOptionDao).readAllFulfillmentOptions();
    assertTrue(actualReadAllFulfillmentOptionsResult.isEmpty());
  }

  /**
   * Test {@link
   * FulfillmentOptionServiceImpl#readAllFulfillmentOptionsByFulfillmentType(FulfillmentType)}.
   *
   * <p>Method under test: {@link
   * FulfillmentOptionServiceImpl#readAllFulfillmentOptionsByFulfillmentType(FulfillmentType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FulfillmentOptionServiceImpl.readAllFulfillmentOptionsByFulfillmentType(FulfillmentType)"
  })
  public void testReadAllFulfillmentOptionsByFulfillmentType() {
    // Arrange
    when(fulfillmentOptionDao.readAllFulfillmentOptionsByFulfillmentType(
            Mockito.<FulfillmentType>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<FulfillmentOption> actualReadAllFulfillmentOptionsByFulfillmentTypeResult =
        fulfillmentOptionServiceImpl.readAllFulfillmentOptionsByFulfillmentType(
            FulfillmentType.DIGITAL);

    // Assert
    verify(fulfillmentOptionDao)
        .readAllFulfillmentOptionsByFulfillmentType(isA(FulfillmentType.class));
    assertTrue(actualReadAllFulfillmentOptionsByFulfillmentTypeResult.isEmpty());
  }
}

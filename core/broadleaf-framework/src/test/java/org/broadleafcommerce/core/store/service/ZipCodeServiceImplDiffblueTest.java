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
package org.broadleafcommerce.core.store.service;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.store.dao.ZipCodeDao;
import org.broadleafcommerce.core.store.domain.ZipCode;
import org.broadleafcommerce.core.store.domain.ZipCodeImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ZipCodeServiceImplDiffblueTest {
  @Mock private ZipCodeDao zipCodeDao;

  @InjectMocks private ZipCodeServiceImpl zipCodeServiceImpl;

  /**
   * Test {@link ZipCodeServiceImpl#findZipCodeByZipCode(Integer)}.
   *
   * <p>Method under test: {@link ZipCodeServiceImpl#findZipCodeByZipCode(Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ZipCode ZipCodeServiceImpl.findZipCodeByZipCode(Integer)"})
  public void testFindZipCodeByZipCode() {
    // Arrange
    ZipCodeImpl zipCodeImpl = new ZipCodeImpl();
    when(zipCodeDao.findZipCodeByZipCode(Mockito.<Integer>any())).thenReturn(zipCodeImpl);

    // Act
    ZipCode actualFindZipCodeByZipCodeResult = zipCodeServiceImpl.findZipCodeByZipCode(1);

    // Assert
    verify(zipCodeDao).findZipCodeByZipCode(1);
    assertSame(zipCodeImpl, actualFindZipCodeByZipCodeResult);
  }
}

/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.enumeration.service;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.enumeration.dao.DataDrivenEnumerationDao;
import org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumeration;
import org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationImpl;
import org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationValue;
import org.broadleafcommerce.common.enumeration.domain.DataDrivenEnumerationValueImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DataDrivenEnumerationServiceImplDiffblueTest {
  @Mock private DataDrivenEnumerationDao dataDrivenEnumerationDao;

  @InjectMocks private DataDrivenEnumerationServiceImpl dataDrivenEnumerationServiceImpl;

  /**
   * Test {@link DataDrivenEnumerationServiceImpl#findEnumByKey(String)}.
   *
   * <p>Method under test: {@link DataDrivenEnumerationServiceImpl#findEnumByKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DataDrivenEnumeration DataDrivenEnumerationServiceImpl.findEnumByKey(String)"
  })
  public void testFindEnumByKey() {
    // Arrange
    DataDrivenEnumerationImpl dataDrivenEnumerationImpl = new DataDrivenEnumerationImpl();
    when(dataDrivenEnumerationDao.readEnumByKey(Mockito.<String>any()))
        .thenReturn(dataDrivenEnumerationImpl);

    // Act
    DataDrivenEnumeration actualFindEnumByKeyResult =
        dataDrivenEnumerationServiceImpl.findEnumByKey("Enum Key");

    // Assert
    verify(dataDrivenEnumerationDao).readEnumByKey("Enum Key");
    assertSame(dataDrivenEnumerationImpl, actualFindEnumByKeyResult);
  }

  /**
   * Test {@link DataDrivenEnumerationServiceImpl#findEnumValueByKey(String, String)}.
   *
   * <p>Method under test: {@link DataDrivenEnumerationServiceImpl#findEnumValueByKey(String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DataDrivenEnumerationValue DataDrivenEnumerationServiceImpl.findEnumValueByKey(String, String)"
  })
  public void testFindEnumValueByKey() {
    // Arrange
    DataDrivenEnumerationValueImpl dataDrivenEnumerationValueImpl =
        new DataDrivenEnumerationValueImpl();
    when(dataDrivenEnumerationDao.readEnumValueByKey(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(dataDrivenEnumerationValueImpl);

    // Act
    DataDrivenEnumerationValue actualFindEnumValueByKeyResult =
        dataDrivenEnumerationServiceImpl.findEnumValueByKey("Enum Key", "42");

    // Assert
    verify(dataDrivenEnumerationDao).readEnumValueByKey("Enum Key", "42");
    assertSame(dataDrivenEnumerationValueImpl, actualFindEnumValueByKeyResult);
  }
}

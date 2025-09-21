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
package org.broadleafcommerce.common.i18n.service;

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
import org.broadleafcommerce.common.i18n.dao.ISODao;
import org.broadleafcommerce.common.i18n.domain.ISOCountry;
import org.broadleafcommerce.common.i18n.domain.ISOCountryImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ISOServiceImplDiffblueTest {
  @Mock private ISODao iSODao;

  @InjectMocks private ISOServiceImpl iSOServiceImpl;

  /**
   * Test {@link ISOServiceImpl#findISOCountries()}.
   *
   * <p>Method under test: {@link ISOServiceImpl#findISOCountries()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List ISOServiceImpl.findISOCountries()"})
  public void testFindISOCountries() {
    // Arrange
    when(iSODao.findISOCountries()).thenReturn(new ArrayList<>());

    // Act
    List<ISOCountry> actualFindISOCountriesResult = iSOServiceImpl.findISOCountries();

    // Assert
    verify(iSODao).findISOCountries();
    assertTrue(actualFindISOCountriesResult.isEmpty());
  }

  /**
   * Test {@link ISOServiceImpl#findISOCountryByAlpha2Code(String)}.
   *
   * <p>Method under test: {@link ISOServiceImpl#findISOCountryByAlpha2Code(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ISOCountry ISOServiceImpl.findISOCountryByAlpha2Code(String)"})
  public void testFindISOCountryByAlpha2Code() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    when(iSODao.findISOCountryByAlpha2Code(Mockito.<String>any())).thenReturn(isoCountryImpl);

    // Act
    ISOCountry actualFindISOCountryByAlpha2CodeResult =
        iSOServiceImpl.findISOCountryByAlpha2Code("Alpha2");

    // Assert
    verify(iSODao).findISOCountryByAlpha2Code("Alpha2");
    assertSame(isoCountryImpl, actualFindISOCountryByAlpha2CodeResult);
  }

  /**
   * Test {@link ISOServiceImpl#save(ISOCountry)}.
   *
   * <p>Method under test: {@link ISOServiceImpl#save(ISOCountry)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ISOCountry ISOServiceImpl.save(ISOCountry)"})
  public void testSave() {
    // Arrange
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    when(iSODao.save(Mockito.<ISOCountry>any())).thenReturn(isoCountryImpl);

    // Act
    ISOCountry actualSaveResult = iSOServiceImpl.save(new ISOCountryImpl());

    // Assert
    verify(iSODao).save(isA(ISOCountry.class));
    assertSame(isoCountryImpl, actualSaveResult);
  }
}

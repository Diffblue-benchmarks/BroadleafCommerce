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
package org.broadleafcommerce.common.locale.service;

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
import org.broadleafcommerce.common.locale.dao.LocaleDao;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LocaleServiceImplDiffblueTest {
  @Mock private LocaleDao localeDao;

  @InjectMocks private LocaleServiceImpl localeServiceImpl;

  /**
   * Test {@link LocaleServiceImpl#findLocaleByCode(String)}.
   *
   * <p>Method under test: {@link LocaleServiceImpl#findLocaleByCode(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Locale LocaleServiceImpl.findLocaleByCode(String)"})
  public void testFindLocaleByCode() {
    // Arrange
    LocaleImpl localeImpl = new LocaleImpl();
    when(localeDao.findLocaleByCode(Mockito.<String>any())).thenReturn(localeImpl);

    // Act
    Locale actualFindLocaleByCodeResult = localeServiceImpl.findLocaleByCode("en");

    // Assert
    verify(localeDao).findLocaleByCode("en");
    assertSame(localeImpl, actualFindLocaleByCodeResult);
  }

  /**
   * Test {@link LocaleServiceImpl#findDefaultLocale()}.
   *
   * <p>Method under test: {@link LocaleServiceImpl#findDefaultLocale()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Locale LocaleServiceImpl.findDefaultLocale()"})
  public void testFindDefaultLocale() {
    // Arrange
    LocaleImpl localeImpl = new LocaleImpl();
    when(localeDao.findDefaultLocale()).thenReturn(localeImpl);

    // Act
    Locale actualFindDefaultLocaleResult = localeServiceImpl.findDefaultLocale();

    // Assert
    verify(localeDao).findDefaultLocale();
    assertSame(localeImpl, actualFindDefaultLocaleResult);
  }

  /**
   * Test {@link LocaleServiceImpl#findAllLocales()}.
   *
   * <p>Method under test: {@link LocaleServiceImpl#findAllLocales()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List LocaleServiceImpl.findAllLocales()"})
  public void testFindAllLocales() {
    // Arrange
    when(localeDao.findAllLocales()).thenReturn(new ArrayList<>());

    // Act
    List<Locale> actualFindAllLocalesResult = localeServiceImpl.findAllLocales();

    // Assert
    verify(localeDao).findAllLocales();
    assertTrue(actualFindAllLocalesResult.isEmpty());
  }

  /**
   * Test {@link LocaleServiceImpl#save(Locale)}.
   *
   * <p>Method under test: {@link LocaleServiceImpl#save(Locale)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Locale LocaleServiceImpl.save(Locale)"})
  public void testSave() {
    // Arrange
    LocaleImpl localeImpl = new LocaleImpl();
    when(localeDao.save(Mockito.<Locale>any())).thenReturn(localeImpl);

    // Act
    Locale actualSaveResult = localeServiceImpl.save(new LocaleImpl());

    // Assert
    verify(localeDao).save(isA(Locale.class));
    assertSame(localeImpl, actualSaveResult);
  }
}

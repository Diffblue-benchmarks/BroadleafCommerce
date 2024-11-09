/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
package org.broadleafcommerce.common.locale.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.junit.Test;

public class LocaleUtilDiffblueTest {
  /**
   * Test {@link LocaleUtil#findLanguageCode(Locale)}.
   * <ul>
   *   <li>Given {@link BroadleafCurrencyImpl} (default constructor).</li>
   *   <li>When {@link LocaleImpl} (default constructor) LocaleCode is
   * {@code en}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocaleUtil#findLanguageCode(Locale)}
   */
  @Test
  public void testFindLanguageCode_givenBroadleafCurrencyImpl_whenLocaleImplLocaleCodeIsEn() {
    // Arrange
    LocaleImpl locale = new LocaleImpl();
    locale.setDefaultCurrency(new BroadleafCurrencyImpl());
    locale.setDefaultFlag(true);
    locale.setFriendlyName("en");
    locale.setUseCountryInSearchIndex(true);
    locale.setLocaleCode("en");

    // Act and Assert
    assertNull(LocaleUtil.findLanguageCode(locale));
  }

  /**
   * Test {@link LocaleUtil#findLanguageCode(Locale)}.
   * <ul>
   *   <li>Given {@code en_}.</li>
   *   <li>When {@link LocaleImpl} (default constructor) LocaleCode is
   * {@code en_}.</li>
   *   <li>Then return {@code en}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocaleUtil#findLanguageCode(Locale)}
   */
  @Test
  public void testFindLanguageCode_givenEn_whenLocaleImplLocaleCodeIsEn_thenReturnEn() {
    // Arrange
    LocaleImpl locale = new LocaleImpl();
    locale.setDefaultCurrency(new BroadleafCurrencyImpl());
    locale.setDefaultFlag(true);
    locale.setFriendlyName("en");
    locale.setUseCountryInSearchIndex(true);
    locale.setLocaleCode("en_");

    // Act and Assert
    assertEquals("en", LocaleUtil.findLanguageCode(locale));
  }

  /**
   * Test {@link LocaleUtil#findLanguageCode(Locale)}.
   * <ul>
   *   <li>When {@link Locale} {@link Locale#getLocaleCode()} return
   * {@code en}.</li>
   *   <li>Then calls {@link Locale#getLocaleCode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocaleUtil#findLanguageCode(Locale)}
   */
  @Test
  public void testFindLanguageCode_whenLocaleGetLocaleCodeReturnEn_thenCallsGetLocaleCode() {
    // Arrange
    Locale locale = mock(Locale.class);
    when(locale.getLocaleCode()).thenReturn("en");

    // Act
    String actualFindLanguageCodeResult = LocaleUtil.findLanguageCode(locale);

    // Assert
    verify(locale, atLeast(1)).getLocaleCode();
    assertNull(actualFindLanguageCodeResult);
  }

  /**
   * Test {@link LocaleUtil#findLanguageCode(Locale)}.
   * <ul>
   *   <li>When {@link LocaleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocaleUtil#findLanguageCode(Locale)}
   */
  @Test
  public void testFindLanguageCode_whenLocaleImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(LocaleUtil.findLanguageCode(new LocaleImpl()));
  }

  /**
   * Test {@link LocaleUtil#findLanguageCode(Locale)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocaleUtil#findLanguageCode(Locale)}
   */
  @Test
  public void testFindLanguageCode_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(LocaleUtil.findLanguageCode(null));
  }
}

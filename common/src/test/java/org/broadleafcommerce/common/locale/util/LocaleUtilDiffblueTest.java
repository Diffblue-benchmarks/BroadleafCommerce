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
package org.broadleafcommerce.common.locale.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class LocaleUtilDiffblueTest {
  /**
   * Test {@link LocaleUtil#findLanguageCode(Locale)}.
   *
   * <ul>
   *   <li>Given {@code en_}.
   *   <li>When {@link LocaleImpl} (default constructor) LocaleCode is {@code en_}.
   *   <li>Then return {@code en}.
   * </ul>
   *
   * <p>Method under test: {@link LocaleUtil#findLanguageCode(Locale)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String LocaleUtil.findLanguageCode(Locale)"})
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
   *
   * <ul>
   *   <li>Given {@code _}.
   *   <li>When {@link LocaleImpl} (default constructor) LocaleCode is {@code _}.
   * </ul>
   *
   * <p>Method under test: {@link LocaleUtil#findLanguageCode(Locale)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String LocaleUtil.findLanguageCode(Locale)"})
  public void testFindLanguageCode_givenUnderscore_whenLocaleImplLocaleCodeIsUnderscore() {
    // Arrange
    LocaleImpl locale = new LocaleImpl();
    locale.setDefaultCurrency(new BroadleafCurrencyImpl());
    locale.setDefaultFlag(true);
    locale.setFriendlyName("en");
    locale.setUseCountryInSearchIndex(true);
    locale.setLocaleCode("_");

    // Act and Assert
    assertNull(LocaleUtil.findLanguageCode(locale));
  }

  /**
   * Test {@link LocaleUtil#findLanguageCode(Locale)}.
   *
   * <ul>
   *   <li>When {@link LocaleImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LocaleUtil#findLanguageCode(Locale)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String LocaleUtil.findLanguageCode(Locale)"})
  public void testFindLanguageCode_whenLocaleImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(LocaleUtil.findLanguageCode(new LocaleImpl()));
  }

  /**
   * Test {@link LocaleUtil#findLanguageCode(Locale)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LocaleUtil#findLanguageCode(Locale)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String LocaleUtil.findLanguageCode(Locale)"})
  public void testFindLanguageCode_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(LocaleUtil.findLanguageCode(null));
  }
}

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
import java.util.Locale;
import java.util.MissingResourceException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {LocaleConverter.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class LocaleConverterDiffblueTest {
  @Autowired private LocaleConverter localeConverter;

  /**
   * Test {@link LocaleConverter#convert(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code en}.
   *   <li>Then return {@link Locale#ENGLISH}.
   * </ul>
   *
   * <p>Method under test: {@link LocaleConverter#convert(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Locale LocaleConverter.convert(String)"})
  public void testConvertWithString_whenEn_thenReturnEnglish() {
    // Arrange, Act and Assert
    assertEquals(Locale.ENGLISH, localeConverter.convert("en"));
  }

  /**
   * Test {@link LocaleConverter#convert(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code foo_bar_baz}.
   *   <li>Then return DisplayVariant is {@code baz}.
   * </ul>
   *
   * <p>Method under test: {@link LocaleConverter#convert(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Locale LocaleConverter.convert(String)"})
  public void testConvertWithString_whenFooBarBaz_thenReturnDisplayVariantIsBaz() {
    // Arrange and Act
    Locale actualConvertResult = localeConverter.convert("foo_bar_baz");

    // Assert
    assertEquals("baz", actualConvertResult.getDisplayVariant());
    assertEquals("baz", actualConvertResult.getVariant());
    assertEquals("foo (BAR, baz)", actualConvertResult.getDisplayName());
  }

  /**
   * Test {@link LocaleConverter#convert(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code foo_bar}.
   *   <li>Then return DisplayVariant is empty string.
   * </ul>
   *
   * <p>Method under test: {@link LocaleConverter#convert(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Locale LocaleConverter.convert(String)"})
  public void testConvertWithString_whenFooBar_thenReturnDisplayVariantIsEmptyString()
      throws MissingResourceException {
    // Arrange and Act
    Locale actualConvertResult = localeConverter.convert("foo_bar");

    // Assert
    assertEquals("", actualConvertResult.getDisplayVariant());
    assertEquals("", actualConvertResult.getVariant());
    assertEquals("BAR", actualConvertResult.getCountry());
    assertEquals("BAR", actualConvertResult.getDisplayCountry());
    assertEquals("foo (BAR)", actualConvertResult.getDisplayName());
    assertEquals("foo", actualConvertResult.getDisplayLanguage());
    assertEquals("foo", actualConvertResult.getISO3Language());
    assertEquals("foo", actualConvertResult.getLanguage());
  }

  /**
   * Test {@link LocaleConverter#convert(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LocaleConverter#convert(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Locale LocaleConverter.convert(String)"})
  public void testConvertWithString_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(localeConverter.convert(null));
  }

  /**
   * Test {@link LocaleConverter#convert(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code _}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LocaleConverter#convert(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Locale LocaleConverter.convert(String)"})
  public void testConvertWithString_whenUnderscore_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(localeConverter.convert("_"));
  }
}

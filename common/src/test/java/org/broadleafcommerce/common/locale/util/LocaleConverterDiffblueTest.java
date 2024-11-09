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
import java.util.Locale;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {LocaleConverter.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class LocaleConverterDiffblueTest {
  @Autowired
  private LocaleConverter localeConverter;

  /**
   * Test {@link LocaleConverter#convert(String)} with {@code String}.
   * <ul>
   *   <li>When {@code _en}.</li>
   *   <li>Then return Country is {@code EN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocaleConverter#convert(String)}
   */
  @Test
  public void testConvertWithString_whenEn_thenReturnCountryIsEn() {
    // Arrange and Act
    Locale actualConvertResult = localeConverter.convert("_en");

    // Assert
    assertEquals("EN", actualConvertResult.getCountry());
    assertEquals("EN", actualConvertResult.getDisplayCountry());
    assertEquals("EN", actualConvertResult.getDisplayName());
  }

  /**
   * Test {@link LocaleConverter#convert(String)} with {@code String}.
   * <ul>
   *   <li>When {@code __en}.</li>
   *   <li>Then return DisplayName is {@code en}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocaleConverter#convert(String)}
   */
  @Test
  public void testConvertWithString_whenEn_thenReturnDisplayNameIsEn() {
    // Arrange and Act
    Locale actualConvertResult = localeConverter.convert("__en");

    // Assert
    assertEquals("en", actualConvertResult.getDisplayName());
    assertEquals("en", actualConvertResult.getDisplayVariant());
    assertEquals("en", actualConvertResult.getVariant());
  }

  /**
   * Test {@link LocaleConverter#convert(String)} with {@code String}.
   * <ul>
   *   <li>When {@code en}.</li>
   *   <li>Then return {@link Locale#ENGLISH}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocaleConverter#convert(String)}
   */
  @Test
  public void testConvertWithString_whenEn_thenReturnEnglish() {
    // Arrange and Act
    Locale actualConvertResult = localeConverter.convert("en");

    // Assert
    assertEquals(actualConvertResult.ENGLISH, actualConvertResult);
  }

  /**
   * Test {@link LocaleConverter#convert(String)} with {@code String}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocaleConverter#convert(String)}
   */
  @Test
  public void testConvertWithString_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(localeConverter.convert(null));
  }

  /**
   * Test {@link LocaleConverter#convert(String)} with {@code String}.
   * <ul>
   *   <li>When {@code _}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocaleConverter#convert(String)}
   */
  @Test
  public void testConvertWithString_whenUnderscore_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(localeConverter.convert("_"));
  }
}

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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Set;
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
   * Method under test: {@link LocaleConverter#convert(String)}
   */
  @Test
  public void testConvert() {
    // Arrange and Act
    Locale actualConvertResult = localeConverter.convert("en");

    // Assert
    assertEquals(actualConvertResult.ENGLISH, actualConvertResult);
  }

  /**
   * Method under test: {@link LocaleConverter#convert(String)}
   */
  @Test
  public void testConvert2() {
    // Arrange, Act and Assert
    assertNull(localeConverter.convert("_"));
  }

  /**
   * Method under test: {@link LocaleConverter#convert(String)}
   */
  @Test
  public void testConvert3() {
    // Arrange, Act and Assert
    assertNull(localeConverter.convert(null));
  }

  /**
   * Method under test: {@link LocaleConverter#convert(String)}
   */
  @Test
  public void testConvert4() throws MissingResourceException {
    // Arrange and Act
    Locale actualConvertResult = localeConverter.convert("_en");

    // Assert
    assertEquals("", actualConvertResult.getDisplayLanguage());
    assertEquals("", actualConvertResult.getDisplayScript());
    assertEquals("", actualConvertResult.getDisplayVariant());
    assertEquals("", actualConvertResult.getISO3Language());
    assertEquals("", actualConvertResult.getLanguage());
    assertEquals("", actualConvertResult.getScript());
    assertEquals("", actualConvertResult.getVariant());
    assertEquals("EN", actualConvertResult.getCountry());
    assertEquals("EN", actualConvertResult.getDisplayCountry());
    assertEquals("EN", actualConvertResult.getDisplayName());
    assertFalse(actualConvertResult.hasExtensions());
    Set<Character> extensionKeys = actualConvertResult.getExtensionKeys();
    assertTrue(extensionKeys.isEmpty());
    assertSame(extensionKeys, actualConvertResult.getUnicodeLocaleAttributes());
    assertSame(extensionKeys, actualConvertResult.getUnicodeLocaleKeys());
  }

  /**
   * Method under test: {@link LocaleConverter#convert(String)}
   */
  @Test
  public void testConvert5() throws MissingResourceException {
    // Arrange and Act
    Locale actualConvertResult = localeConverter.convert("__en");

    // Assert
    assertEquals("", actualConvertResult.getCountry());
    assertEquals("", actualConvertResult.getDisplayCountry());
    assertEquals("", actualConvertResult.getDisplayLanguage());
    assertEquals("", actualConvertResult.getDisplayScript());
    assertEquals("", actualConvertResult.getISO3Country());
    assertEquals("", actualConvertResult.getISO3Language());
    assertEquals("", actualConvertResult.getLanguage());
    assertEquals("", actualConvertResult.getScript());
    assertEquals("en", actualConvertResult.getDisplayName());
    assertEquals("en", actualConvertResult.getDisplayVariant());
    assertEquals("en", actualConvertResult.getVariant());
    assertFalse(actualConvertResult.hasExtensions());
    Set<Character> extensionKeys = actualConvertResult.getExtensionKeys();
    assertTrue(extensionKeys.isEmpty());
    assertSame(extensionKeys, actualConvertResult.getUnicodeLocaleAttributes());
    assertSame(extensionKeys, actualConvertResult.getUnicodeLocaleKeys());
  }
}

/*-
 * #%L
 * BroadleafCommerce Profile
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
package org.broadleafcommerce.profile.core.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Set;
import org.junit.Test;

public class LocaleTypeDiffblueTest {
  /**
   * Method under test: {@link LocaleType#getInstance(String)}
   */
  @Test
  public void testGetInstance() throws MissingResourceException {
    // Arrange and Act
    LocaleType actualInstance = LocaleType.getInstance("en");

    // Assert
    Locale locale = actualInstance.getLocale();
    assertEquals("", locale.getCountry());
    assertEquals("", locale.getDisplayCountry());
    assertEquals("", locale.getDisplayScript());
    assertEquals("", locale.getDisplayVariant());
    assertEquals("", locale.getISO3Country());
    assertEquals("", locale.getScript());
    assertEquals("", locale.getVariant());
    assertEquals("English", locale.getDisplayLanguage());
    assertEquals("English", locale.getDisplayName());
    assertEquals("en", locale.getLanguage());
    assertEquals("en", actualInstance.getFriendlyType());
    assertEquals("en", actualInstance.getType());
    assertEquals("eng", locale.getISO3Language());
    assertFalse(locale.hasExtensions());
    Set<Character> extensionKeys = locale.getExtensionKeys();
    assertTrue(extensionKeys.isEmpty());
    assertSame(extensionKeys, locale.getUnicodeLocaleAttributes());
    assertSame(extensionKeys, locale.getUnicodeLocaleKeys());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LocaleType#equals(Object)}
   *   <li>{@link LocaleType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LocaleType localeType = LocaleType.CANADA;
    LocaleType localeType2 = LocaleType.CANADA;

    // Act and Assert
    assertEquals(localeType, localeType2);
    int expectedHashCodeResult = localeType.hashCode();
    assertEquals(expectedHashCodeResult, localeType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LocaleType#equals(Object)}
   *   <li>{@link LocaleType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    LocaleType localeType = new LocaleType();
    LocaleType localeType2 = new LocaleType();

    // Act and Assert
    assertEquals(localeType, localeType2);
    int expectedHashCodeResult = localeType.hashCode();
    assertEquals(expectedHashCodeResult, localeType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LocaleType#equals(Object)}
   *   <li>{@link LocaleType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LocaleType localeType = LocaleType.CANADA;

    // Act and Assert
    assertEquals(localeType, localeType);
    int expectedHashCodeResult = localeType.hashCode();
    assertEquals(expectedHashCodeResult, localeType.hashCode());
  }

  /**
   * Method under test: {@link LocaleType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(LocaleType.CANADA_FRENCH, LocaleType.CANADA);
    assertNotEquals(new LocaleType(), LocaleType.CANADA);
  }

  /**
   * Method under test: {@link LocaleType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(LocaleType.CANADA, null);
  }

  /**
   * Method under test: {@link LocaleType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(LocaleType.CANADA, "Different type to LocaleType");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LocaleType#LocaleType()}
   *   <li>{@link LocaleType#getFriendlyType()}
   *   <li>{@link LocaleType#getLocale()}
   *   <li>{@link LocaleType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    LocaleType actualLocaleType = new LocaleType();
    String actualFriendlyType = actualLocaleType.getFriendlyType();
    Locale actualLocale = actualLocaleType.getLocale();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualLocaleType.getType());
    assertNull(actualLocale);
  }

  /**
   * Method under test: {@link LocaleType#LocaleType(String, String, Locale)}
   */
  @Test
  public void testNewLocaleType() {
    // Arrange
    Locale locale = Locale.getDefault();

    // Act
    LocaleType actualLocaleType = new LocaleType("en", "en", locale);

    // Assert
    assertEquals("en", actualLocaleType.getFriendlyType());
    assertEquals("en", actualLocaleType.getType());
    Locale expectedLocale = locale.ENGLISH;
    assertSame(expectedLocale, actualLocaleType.getLocale());
  }

  /**
   * Method under test: {@link LocaleType#LocaleType(String, String, Locale)}
   */
  @Test
  public void testNewLocaleType2() {
    // Arrange
    Locale locale = Locale.getDefault();

    // Act
    LocaleType actualLocaleType = new LocaleType("FR", "en", locale);

    // Assert
    assertEquals("FR", actualLocaleType.getType());
    assertEquals("en", actualLocaleType.getFriendlyType());
    Locale expectedLocale = locale.ENGLISH;
    assertSame(expectedLocale, actualLocaleType.getLocale());
  }
}

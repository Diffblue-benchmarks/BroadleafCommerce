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
package org.broadleafcommerce.common.locale.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.Locale;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.junit.Test;

public class LocaleImplDiffblueTest {
  /**
   * Method under test: {@link LocaleImpl#getDefaultFlag()}
   */
  @Test
  public void testGetDefaultFlag() {
    // Arrange, Act and Assert
    assertFalse((new LocaleImpl()).getDefaultFlag());
  }

  /**
   * Method under test: {@link LocaleImpl#getDefaultFlag()}
   */
  @Test
  public void testGetDefaultFlag2() {
    // Arrange
    LocaleImpl localeImpl = new LocaleImpl();
    localeImpl.setDefaultCurrency(new BroadleafCurrencyImpl());
    localeImpl.setFriendlyName("en");
    localeImpl.setLocaleCode("en");
    localeImpl.setUseCountryInSearchIndex(true);
    localeImpl.setDefaultFlag(null);

    // Act and Assert
    assertFalse(localeImpl.getDefaultFlag());
  }

  /**
   * Method under test: {@link LocaleImpl#getDefaultFlag()}
   */
  @Test
  public void testGetDefaultFlag3() {
    // Arrange
    LocaleImpl localeImpl = new LocaleImpl();
    localeImpl.setDefaultCurrency(new BroadleafCurrencyImpl());
    localeImpl.setFriendlyName("en");
    localeImpl.setLocaleCode("en");
    localeImpl.setUseCountryInSearchIndex(true);
    localeImpl.setDefaultFlag(true);

    // Act and Assert
    assertTrue(localeImpl.getDefaultFlag());
  }

  /**
   * Method under test: {@link LocaleImpl#getDefaultFlag()}
   */
  @Test
  public void testGetDefaultFlag4() {
    // Arrange
    LocaleImpl localeImpl = new LocaleImpl();
    localeImpl.setDefaultCurrency(mock(BroadleafCurrency.class));
    localeImpl.setFriendlyName("en");
    localeImpl.setLocaleCode("en");
    localeImpl.setUseCountryInSearchIndex(true);
    localeImpl.setDefaultFlag(null);

    // Act and Assert
    assertFalse(localeImpl.getDefaultFlag());
  }

  /**
   * Method under test: {@link LocaleImpl#getUseCountryInSearchIndex()}
   */
  @Test
  public void testGetUseCountryInSearchIndex() {
    // Arrange, Act and Assert
    assertFalse((new LocaleImpl()).getUseCountryInSearchIndex());
  }

  /**
   * Method under test: {@link LocaleImpl#getUseCountryInSearchIndex()}
   */
  @Test
  public void testGetUseCountryInSearchIndex2() {
    // Arrange
    LocaleImpl localeImpl = new LocaleImpl();
    localeImpl.setDefaultCurrency(new BroadleafCurrencyImpl());
    localeImpl.setDefaultFlag(true);
    localeImpl.setFriendlyName("en");
    localeImpl.setLocaleCode("en");
    localeImpl.setUseCountryInSearchIndex(null);

    // Act and Assert
    assertFalse(localeImpl.getUseCountryInSearchIndex());
  }

  /**
   * Method under test: {@link LocaleImpl#getUseCountryInSearchIndex()}
   */
  @Test
  public void testGetUseCountryInSearchIndex3() {
    // Arrange
    LocaleImpl localeImpl = new LocaleImpl();
    localeImpl.setDefaultCurrency(new BroadleafCurrencyImpl());
    localeImpl.setDefaultFlag(true);
    localeImpl.setFriendlyName("en");
    localeImpl.setLocaleCode("en");
    localeImpl.setUseCountryInSearchIndex(true);

    // Act and Assert
    assertTrue(localeImpl.getUseCountryInSearchIndex());
  }

  /**
   * Method under test: {@link LocaleImpl#getUseCountryInSearchIndex()}
   */
  @Test
  public void testGetUseCountryInSearchIndex4() {
    // Arrange
    LocaleImpl localeImpl = new LocaleImpl();
    localeImpl.setDefaultCurrency(mock(BroadleafCurrency.class));
    localeImpl.setDefaultFlag(true);
    localeImpl.setFriendlyName("en");
    localeImpl.setLocaleCode("en");
    localeImpl.setUseCountryInSearchIndex(null);

    // Act and Assert
    assertFalse(localeImpl.getUseCountryInSearchIndex());
  }

  /**
   * Method under test: {@link LocaleImpl#getJavaLocale()}
   */
  @Test
  public void testGetJavaLocale() {
    // Arrange, Act and Assert
    assertNull((new LocaleImpl()).getJavaLocale());
  }

  /**
   * Method under test: {@link LocaleImpl#getJavaLocale()}
   */
  @Test
  public void testGetJavaLocale2() {
    // Arrange
    LocaleImpl localeImpl = new LocaleImpl();
    localeImpl.setLocaleCode("en");

    // Act
    Locale actualJavaLocale = localeImpl.getJavaLocale();

    // Assert
    assertEquals(actualJavaLocale.ENGLISH, actualJavaLocale);
  }

  /**
   * Method under test: {@link LocaleImpl#getJavaLocale()}
   */
  @Test
  public void testGetJavaLocale3() {
    // Arrange
    LocaleImpl localeImpl = new LocaleImpl();
    localeImpl.setDefaultCurrency(mock(BroadleafCurrency.class));

    // Act and Assert
    assertNull(localeImpl.getJavaLocale());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LocaleImpl#equals(Object)}
   *   <li>{@link LocaleImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LocaleImpl localeImpl = new LocaleImpl();
    localeImpl.setDefaultCurrency(new BroadleafCurrencyImpl());
    localeImpl.setDefaultFlag(true);
    localeImpl.setFriendlyName("en");
    localeImpl.setLocaleCode("en");
    localeImpl.setUseCountryInSearchIndex(true);

    LocaleImpl localeImpl2 = new LocaleImpl();
    localeImpl2.setDefaultCurrency(new BroadleafCurrencyImpl());
    localeImpl2.setDefaultFlag(true);
    localeImpl2.setFriendlyName("en");
    localeImpl2.setLocaleCode("en");
    localeImpl2.setUseCountryInSearchIndex(true);

    // Act and Assert
    assertEquals(localeImpl, localeImpl2);
    int expectedHashCodeResult = localeImpl.hashCode();
    assertEquals(expectedHashCodeResult, localeImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LocaleImpl#equals(Object)}
   *   <li>{@link LocaleImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    LocaleImpl localeImpl = new LocaleImpl();
    localeImpl.setDefaultCurrency(mock(BroadleafCurrency.class));
    localeImpl.setDefaultFlag(true);
    localeImpl.setFriendlyName("en");
    localeImpl.setLocaleCode("en");
    localeImpl.setUseCountryInSearchIndex(true);

    LocaleImpl localeImpl2 = new LocaleImpl();
    localeImpl2.setDefaultCurrency(new BroadleafCurrencyImpl());
    localeImpl2.setDefaultFlag(true);
    localeImpl2.setFriendlyName("en");
    localeImpl2.setLocaleCode("en");
    localeImpl2.setUseCountryInSearchIndex(true);

    // Act and Assert
    assertEquals(localeImpl, localeImpl2);
    int expectedHashCodeResult = localeImpl.hashCode();
    assertEquals(expectedHashCodeResult, localeImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LocaleImpl#equals(Object)}
   *   <li>{@link LocaleImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    LocaleImpl localeImpl = new LocaleImpl();
    localeImpl.setDefaultCurrency(new BroadleafCurrencyImpl());
    localeImpl.setDefaultFlag(true);
    localeImpl.setFriendlyName(null);
    localeImpl.setLocaleCode("en");
    localeImpl.setUseCountryInSearchIndex(true);

    LocaleImpl localeImpl2 = new LocaleImpl();
    localeImpl2.setDefaultCurrency(new BroadleafCurrencyImpl());
    localeImpl2.setDefaultFlag(true);
    localeImpl2.setFriendlyName(null);
    localeImpl2.setLocaleCode("en");
    localeImpl2.setUseCountryInSearchIndex(true);

    // Act and Assert
    assertEquals(localeImpl, localeImpl2);
    int expectedHashCodeResult = localeImpl.hashCode();
    assertEquals(expectedHashCodeResult, localeImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LocaleImpl#equals(Object)}
   *   <li>{@link LocaleImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    LocaleImpl localeImpl = new LocaleImpl();
    localeImpl.setDefaultCurrency(new BroadleafCurrencyImpl());
    localeImpl.setDefaultFlag(true);
    localeImpl.setFriendlyName("en");
    localeImpl.setLocaleCode(null);
    localeImpl.setUseCountryInSearchIndex(true);

    LocaleImpl localeImpl2 = new LocaleImpl();
    localeImpl2.setDefaultCurrency(new BroadleafCurrencyImpl());
    localeImpl2.setDefaultFlag(true);
    localeImpl2.setFriendlyName("en");
    localeImpl2.setLocaleCode(null);
    localeImpl2.setUseCountryInSearchIndex(true);

    // Act and Assert
    assertEquals(localeImpl, localeImpl2);
    int expectedHashCodeResult = localeImpl.hashCode();
    assertEquals(expectedHashCodeResult, localeImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LocaleImpl#equals(Object)}
   *   <li>{@link LocaleImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LocaleImpl localeImpl = new LocaleImpl();
    localeImpl.setDefaultCurrency(new BroadleafCurrencyImpl());
    localeImpl.setDefaultFlag(true);
    localeImpl.setFriendlyName("en");
    localeImpl.setLocaleCode("en");
    localeImpl.setUseCountryInSearchIndex(true);

    // Act and Assert
    assertEquals(localeImpl, localeImpl);
    int expectedHashCodeResult = localeImpl.hashCode();
    assertEquals(expectedHashCodeResult, localeImpl.hashCode());
  }

  /**
   * Method under test: {@link LocaleImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName() {
    // Arrange, Act and Assert
    assertNull((new LocaleImpl()).getMainEntityName());
  }

  /**
   * Method under test: {@link LocaleImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName2() {
    // Arrange
    LocaleImpl localeImpl = new LocaleImpl();
    localeImpl.setDefaultCurrency(mock(BroadleafCurrency.class));

    // Act and Assert
    assertNull(localeImpl.getMainEntityName());
  }

  /**
   * Method under test: {@link LocaleImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LocaleImpl localeImpl = new LocaleImpl();
    localeImpl.setDefaultCurrency(new BroadleafCurrencyImpl());
    localeImpl.setDefaultFlag(true);
    localeImpl.setFriendlyName("Friendly Name");
    localeImpl.setLocaleCode("en");
    localeImpl.setUseCountryInSearchIndex(true);

    LocaleImpl localeImpl2 = new LocaleImpl();
    localeImpl2.setDefaultCurrency(new BroadleafCurrencyImpl());
    localeImpl2.setDefaultFlag(true);
    localeImpl2.setFriendlyName("en");
    localeImpl2.setLocaleCode("en");
    localeImpl2.setUseCountryInSearchIndex(true);

    // Act and Assert
    assertNotEquals(localeImpl, localeImpl2);
  }

  /**
   * Method under test: {@link LocaleImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LocaleImpl localeImpl = new LocaleImpl();
    localeImpl.setDefaultCurrency(new BroadleafCurrencyImpl());
    localeImpl.setDefaultFlag(true);
    localeImpl.setFriendlyName(null);
    localeImpl.setLocaleCode("en");
    localeImpl.setUseCountryInSearchIndex(true);

    LocaleImpl localeImpl2 = new LocaleImpl();
    localeImpl2.setDefaultCurrency(new BroadleafCurrencyImpl());
    localeImpl2.setDefaultFlag(true);
    localeImpl2.setFriendlyName("en");
    localeImpl2.setLocaleCode("en");
    localeImpl2.setUseCountryInSearchIndex(true);

    // Act and Assert
    assertNotEquals(localeImpl, localeImpl2);
  }

  /**
   * Method under test: {@link LocaleImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LocaleImpl localeImpl = new LocaleImpl();
    localeImpl.setDefaultCurrency(new BroadleafCurrencyImpl());
    localeImpl.setDefaultFlag(true);
    localeImpl.setFriendlyName("en");
    localeImpl.setLocaleCode("Locale Code");
    localeImpl.setUseCountryInSearchIndex(true);

    LocaleImpl localeImpl2 = new LocaleImpl();
    localeImpl2.setDefaultCurrency(new BroadleafCurrencyImpl());
    localeImpl2.setDefaultFlag(true);
    localeImpl2.setFriendlyName("en");
    localeImpl2.setLocaleCode("en");
    localeImpl2.setUseCountryInSearchIndex(true);

    // Act and Assert
    assertNotEquals(localeImpl, localeImpl2);
  }

  /**
   * Method under test: {@link LocaleImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    LocaleImpl localeImpl = new LocaleImpl();
    localeImpl.setDefaultCurrency(new BroadleafCurrencyImpl());
    localeImpl.setDefaultFlag(true);
    localeImpl.setFriendlyName("en");
    localeImpl.setLocaleCode(null);
    localeImpl.setUseCountryInSearchIndex(true);

    LocaleImpl localeImpl2 = new LocaleImpl();
    localeImpl2.setDefaultCurrency(new BroadleafCurrencyImpl());
    localeImpl2.setDefaultFlag(true);
    localeImpl2.setFriendlyName("en");
    localeImpl2.setLocaleCode("en");
    localeImpl2.setUseCountryInSearchIndex(true);

    // Act and Assert
    assertNotEquals(localeImpl, localeImpl2);
  }

  /**
   * Method under test: {@link LocaleImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LocaleImpl localeImpl = new LocaleImpl();
    localeImpl.setDefaultCurrency(new BroadleafCurrencyImpl());
    localeImpl.setDefaultFlag(true);
    localeImpl.setFriendlyName("en");
    localeImpl.setLocaleCode("en");
    localeImpl.setUseCountryInSearchIndex(true);

    // Act and Assert
    assertNotEquals(localeImpl, null);
  }

  /**
   * Method under test: {@link LocaleImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LocaleImpl localeImpl = new LocaleImpl();
    localeImpl.setDefaultCurrency(new BroadleafCurrencyImpl());
    localeImpl.setDefaultFlag(true);
    localeImpl.setFriendlyName("en");
    localeImpl.setLocaleCode("en");
    localeImpl.setUseCountryInSearchIndex(true);

    // Act and Assert
    assertNotEquals(localeImpl, "Different type to LocaleImpl");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link LocaleImpl}
   *   <li>{@link LocaleImpl#setDefaultCurrency(BroadleafCurrency)}
   *   <li>{@link LocaleImpl#setDefaultFlag(Boolean)}
   *   <li>{@link LocaleImpl#setFriendlyName(String)}
   *   <li>{@link LocaleImpl#setLocaleCode(String)}
   *   <li>{@link LocaleImpl#setUseCountryInSearchIndex(Boolean)}
   *   <li>{@link LocaleImpl#getDefaultCurrency()}
   *   <li>{@link LocaleImpl#getFriendlyName()}
   *   <li>{@link LocaleImpl#getLocaleCode()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    LocaleImpl actualLocaleImpl = new LocaleImpl();
    BroadleafCurrencyImpl defaultCurrency = new BroadleafCurrencyImpl();
    actualLocaleImpl.setDefaultCurrency(defaultCurrency);
    actualLocaleImpl.setDefaultFlag(true);
    actualLocaleImpl.setFriendlyName("en");
    actualLocaleImpl.setLocaleCode("en");
    actualLocaleImpl.setUseCountryInSearchIndex(true);
    BroadleafCurrency actualDefaultCurrency = actualLocaleImpl.getDefaultCurrency();
    String actualFriendlyName = actualLocaleImpl.getFriendlyName();

    // Assert that nothing has changed
    assertEquals("en", actualFriendlyName);
    assertEquals("en", actualLocaleImpl.getLocaleCode());
    assertSame(defaultCurrency, actualDefaultCurrency);
  }
}

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
   * Test {@link LocaleImpl#getDefaultFlag()}.
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor) DefaultCurrency is
   * {@link BroadleafCurrency}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocaleImpl#getDefaultFlag()}
   */
  @Test
  public void testGetDefaultFlag_givenLocaleImplDefaultCurrencyIsBroadleafCurrency() {
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
   * Test {@link LocaleImpl#getDefaultFlag()}.
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor) DefaultCurrency is
   * {@link BroadleafCurrencyImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link LocaleImpl#getDefaultFlag()}
   */
  @Test
  public void testGetDefaultFlag_givenLocaleImplDefaultCurrencyIsBroadleafCurrencyImpl() {
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
   * Test {@link LocaleImpl#getDefaultFlag()}.
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor) DefaultFlag is
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocaleImpl#getDefaultFlag()}
   */
  @Test
  public void testGetDefaultFlag_givenLocaleImplDefaultFlagIsTrue_thenReturnTrue() {
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
   * Test {@link LocaleImpl#getDefaultFlag()}.
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocaleImpl#getDefaultFlag()}
   */
  @Test
  public void testGetDefaultFlag_givenLocaleImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new LocaleImpl()).getDefaultFlag());
  }

  /**
   * Test {@link LocaleImpl#getUseCountryInSearchIndex()}.
   * <p>
   * Method under test: {@link LocaleImpl#getUseCountryInSearchIndex()}
   */
  @Test
  public void testGetUseCountryInSearchIndex() {
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
   * Test {@link LocaleImpl#getUseCountryInSearchIndex()}.
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor) DefaultCurrency is
   * {@link BroadleafCurrency}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocaleImpl#getUseCountryInSearchIndex()}
   */
  @Test
  public void testGetUseCountryInSearchIndex_givenLocaleImplDefaultCurrencyIsBroadleafCurrency() {
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
   * Test {@link LocaleImpl#getUseCountryInSearchIndex()}.
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocaleImpl#getUseCountryInSearchIndex()}
   */
  @Test
  public void testGetUseCountryInSearchIndex_givenLocaleImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new LocaleImpl()).getUseCountryInSearchIndex());
  }

  /**
   * Test {@link LocaleImpl#getUseCountryInSearchIndex()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocaleImpl#getUseCountryInSearchIndex()}
   */
  @Test
  public void testGetUseCountryInSearchIndex_thenReturnTrue() {
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
   * Test {@link LocaleImpl#getJavaLocale()}.
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor) DefaultCurrency is
   * {@link BroadleafCurrency}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocaleImpl#getJavaLocale()}
   */
  @Test
  public void testGetJavaLocale_givenLocaleImplDefaultCurrencyIsBroadleafCurrency() {
    // Arrange
    LocaleImpl localeImpl = new LocaleImpl();
    localeImpl.setDefaultCurrency(mock(BroadleafCurrency.class));

    // Act and Assert
    assertNull(localeImpl.getJavaLocale());
  }

  /**
   * Test {@link LocaleImpl#getJavaLocale()}.
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor) LocaleCode is
   * {@code en}.</li>
   *   <li>Then return {@link Locale#ENGLISH}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocaleImpl#getJavaLocale()}
   */
  @Test
  public void testGetJavaLocale_givenLocaleImplLocaleCodeIsEn_thenReturnEnglish() {
    // Arrange
    LocaleImpl localeImpl = new LocaleImpl();
    localeImpl.setLocaleCode("en");

    // Act
    Locale actualJavaLocale = localeImpl.getJavaLocale();

    // Assert
    assertEquals(actualJavaLocale.ENGLISH, actualJavaLocale);
  }

  /**
   * Test {@link LocaleImpl#getJavaLocale()}.
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocaleImpl#getJavaLocale()}
   */
  @Test
  public void testGetJavaLocale_givenLocaleImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new LocaleImpl()).getJavaLocale());
  }

  /**
   * Test {@link LocaleImpl#equals(Object)}, and {@link LocaleImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link LocaleImpl#equals(Object)}, and {@link LocaleImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link LocaleImpl#equals(Object)}, and {@link LocaleImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link LocaleImpl#equals(Object)}, and {@link LocaleImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link LocaleImpl#equals(Object)}, and {@link LocaleImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link LocaleImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link LocaleImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link LocaleImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link LocaleImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link LocaleImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link LocaleImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link LocaleImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link LocaleImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenLocaleImpl() {
    // Arrange, Act and Assert
    assertNull((new LocaleImpl()).getMainEntityName());
  }

  /**
   * Test {@link LocaleImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor) DefaultCurrency is
   * {@link BroadleafCurrency}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LocaleImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenLocaleImplDefaultCurrencyIsBroadleafCurrency() {
    // Arrange
    LocaleImpl localeImpl = new LocaleImpl();
    localeImpl.setDefaultCurrency(mock(BroadleafCurrency.class));

    // Act and Assert
    assertNull(localeImpl.getMainEntityName());
  }

  /**
   * Test getters and setters.
   * <p>
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

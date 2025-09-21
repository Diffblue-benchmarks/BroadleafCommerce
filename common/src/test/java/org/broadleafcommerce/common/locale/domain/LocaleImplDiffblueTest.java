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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Locale;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class LocaleImplDiffblueTest {
  /**
   * Test {@link LocaleImpl#getDefaultFlag()}.
   *
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor) DefaultFlag is {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LocaleImpl#getDefaultFlag()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean LocaleImpl.getDefaultFlag()"})
  public void testGetDefaultFlag_givenLocaleImplDefaultFlagIsNull_thenReturnFalse() {
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
   *
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor) DefaultFlag is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LocaleImpl#getDefaultFlag()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean LocaleImpl.getDefaultFlag()"})
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
   *
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LocaleImpl#getDefaultFlag()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean LocaleImpl.getDefaultFlag()"})
  public void testGetDefaultFlag_givenLocaleImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new LocaleImpl().getDefaultFlag());
  }

  /**
   * Test {@link LocaleImpl#getUseCountryInSearchIndex()}.
   *
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor) UseCountryInSearchIndex is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LocaleImpl#getUseCountryInSearchIndex()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean LocaleImpl.getUseCountryInSearchIndex()"})
  public void testGetUseCountryInSearchIndex_givenLocaleImplUseCountryInSearchIndexIsNull() {
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
   *
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LocaleImpl#getUseCountryInSearchIndex()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean LocaleImpl.getUseCountryInSearchIndex()"})
  public void testGetUseCountryInSearchIndex_givenLocaleImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new LocaleImpl().getUseCountryInSearchIndex());
  }

  /**
   * Test {@link LocaleImpl#getUseCountryInSearchIndex()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LocaleImpl#getUseCountryInSearchIndex()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean LocaleImpl.getUseCountryInSearchIndex()"})
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
   *
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LocaleImpl#getJavaLocale()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Locale LocaleImpl.getJavaLocale()"})
  public void testGetJavaLocale_givenLocaleImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new LocaleImpl().getJavaLocale());
  }

  /**
   * Test {@link LocaleImpl#getJavaLocale()}.
   *
   * <ul>
   *   <li>Then return {@link Locale#ENGLISH}.
   * </ul>
   *
   * <p>Method under test: {@link LocaleImpl#getJavaLocale()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Locale LocaleImpl.getJavaLocale()"})
  public void testGetJavaLocale_thenReturnEnglish() {
    // Arrange
    LocaleImpl localeImpl = new LocaleImpl();
    localeImpl.setDefaultCurrency(new BroadleafCurrencyImpl());
    localeImpl.setDefaultFlag(true);
    localeImpl.setFriendlyName("en");
    localeImpl.setLocaleCode("en");
    localeImpl.setUseCountryInSearchIndex(true);

    // Act and Assert
    assertEquals(Locale.ENGLISH, localeImpl.getJavaLocale());
  }

  /**
   * Test {@link LocaleImpl#equals(Object)}, and {@link LocaleImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LocaleImpl#equals(Object)}
   *   <li>{@link LocaleImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LocaleImpl.equals(Object)", "int LocaleImpl.hashCode()"})
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
    assertEquals(localeImpl.hashCode(), localeImpl2.hashCode());
  }

  /**
   * Test {@link LocaleImpl#equals(Object)}, and {@link LocaleImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LocaleImpl#equals(Object)}
   *   <li>{@link LocaleImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LocaleImpl.equals(Object)", "int LocaleImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
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
    assertEquals(localeImpl.hashCode(), localeImpl2.hashCode());
  }

  /**
   * Test {@link LocaleImpl#equals(Object)}, and {@link LocaleImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LocaleImpl#equals(Object)}
   *   <li>{@link LocaleImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LocaleImpl.equals(Object)", "int LocaleImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
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
    assertEquals(localeImpl.hashCode(), localeImpl2.hashCode());
  }

  /**
   * Test {@link LocaleImpl#equals(Object)}, and {@link LocaleImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LocaleImpl#equals(Object)}
   *   <li>{@link LocaleImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LocaleImpl.equals(Object)", "int LocaleImpl.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LocaleImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LocaleImpl.equals(Object)", "int LocaleImpl.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LocaleImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LocaleImpl.equals(Object)", "int LocaleImpl.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LocaleImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LocaleImpl.equals(Object)", "int LocaleImpl.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LocaleImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LocaleImpl.equals(Object)", "int LocaleImpl.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LocaleImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LocaleImpl.equals(Object)", "int LocaleImpl.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LocaleImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LocaleImpl.equals(Object)", "int LocaleImpl.hashCode()"})
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
   *
   * <p>Method under test: {@link LocaleImpl#getMainEntityName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String LocaleImpl.getMainEntityName()"})
  public void testGetMainEntityName() {
    // Arrange, Act and Assert
    assertNull(new LocaleImpl().getMainEntityName());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LocaleImpl.<init>()",
    "BroadleafCurrency LocaleImpl.getDefaultCurrency()",
    "String LocaleImpl.getFriendlyName()",
    "String LocaleImpl.getLocaleCode()",
    "void LocaleImpl.setDefaultCurrency(BroadleafCurrency)",
    "void LocaleImpl.setDefaultFlag(Boolean)",
    "void LocaleImpl.setFriendlyName(String)",
    "void LocaleImpl.setLocaleCode(String)",
    "void LocaleImpl.setUseCountryInSearchIndex(Boolean)"
  })
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

    // Assert
    assertEquals("en", actualFriendlyName);
    assertEquals("en", actualLocaleImpl.getLocaleCode());
    assertSame(defaultCurrency, actualDefaultCurrency);
  }
}

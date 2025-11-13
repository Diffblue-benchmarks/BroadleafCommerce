package org.broadleafcommerce.profile.core.service.type;

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
import java.util.MissingResourceException;
import java.util.Set;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class LocaleTypeDiffblueTest {
  /**
   * Test {@link LocaleType#getInstance(String)}.
   *
   * <p>Method under test: {@link LocaleType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LocaleType LocaleType.getInstance(String)"})
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
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return FriendlyType is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LocaleType#LocaleType()}
   *   <li>{@link LocaleType#getFriendlyType()}
   *   <li>{@link LocaleType#getLocale()}
   *   <li>{@link LocaleType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LocaleType.<init>()",
    "void LocaleType.<init>(String, String, Locale)",
    "String LocaleType.getFriendlyType()",
    "Locale LocaleType.getLocale()",
    "String LocaleType.getType()"
  })
  public void testGettersAndSetters_thenReturnFriendlyTypeIsNull() {
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
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code en}.
   *   <li>Then return FriendlyType is {@code en}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LocaleType#LocaleType(String, String, Locale)}
   *   <li>{@link LocaleType#getFriendlyType()}
   *   <li>{@link LocaleType#getLocale()}
   *   <li>{@link LocaleType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LocaleType.<init>()",
    "void LocaleType.<init>(String, String, Locale)",
    "String LocaleType.getFriendlyType()",
    "Locale LocaleType.getLocale()",
    "String LocaleType.getType()"
  })
  public void testGettersAndSetters_whenEn_thenReturnFriendlyTypeIsEn() {
    // Arrange and Act
    LocaleType actualLocaleType = new LocaleType("en", "en", Locale.getDefault());
    String actualFriendlyType = actualLocaleType.getFriendlyType();
    Locale actualLocale = actualLocaleType.getLocale();

    // Assert
    assertEquals("en", actualFriendlyType);
    assertEquals("en", actualLocaleType.getType());
    assertSame(Locale.ENGLISH, actualLocale);
  }

  /**
   * Test {@link LocaleType#equals(Object)}, and {@link LocaleType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LocaleType#equals(Object)}
   *   <li>{@link LocaleType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LocaleType.equals(Object)", "int LocaleType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LocaleType localeType = LocaleType.CANADA;
    LocaleType localeType2 = LocaleType.CANADA;

    // Act and Assert
    assertEquals(localeType, localeType2);
    assertEquals(localeType.hashCode(), localeType2.hashCode());
  }

  /**
   * Test {@link LocaleType#equals(Object)}, and {@link LocaleType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LocaleType#equals(Object)}
   *   <li>{@link LocaleType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LocaleType.equals(Object)", "int LocaleType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    LocaleType localeType = new LocaleType();
    LocaleType localeType2 = new LocaleType();

    // Act and Assert
    assertEquals(localeType, localeType2);
    assertEquals(localeType.hashCode(), localeType2.hashCode());
  }

  /**
   * Test {@link LocaleType#equals(Object)}, and {@link LocaleType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LocaleType#equals(Object)}
   *   <li>{@link LocaleType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LocaleType.equals(Object)", "int LocaleType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LocaleType localeType = LocaleType.CANADA;

    // Act and Assert
    assertEquals(localeType, localeType);
    int expectedHashCodeResult = localeType.hashCode();
    assertEquals(expectedHashCodeResult, localeType.hashCode());
  }

  /**
   * Test {@link LocaleType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LocaleType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LocaleType.equals(Object)", "int LocaleType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(LocaleType.CANADA_FRENCH, LocaleType.CANADA);
  }

  /**
   * Test {@link LocaleType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LocaleType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LocaleType.equals(Object)", "int LocaleType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new LocaleType(), LocaleType.CANADA);
  }

  /**
   * Test {@link LocaleType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LocaleType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LocaleType.equals(Object)", "int LocaleType.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(LocaleType.CANADA, null);
  }

  /**
   * Test {@link LocaleType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LocaleType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LocaleType.equals(Object)", "int LocaleType.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(LocaleType.CANADA, "Different type to LocaleType");
  }
}

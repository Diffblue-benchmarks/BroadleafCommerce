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
    assertEquals("foo (BAR,baz)", actualConvertResult.getDisplayName());
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

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
package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.TimeZone;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BLCDateUtilsDiffblueTest {
  /**
   * Test {@link BLCDateUtils#convertDateToUTC(Date)}.
   *
   * <ul>
   *   <li>Then return {@code 1970-01-01 00:00:00.0}.
   * </ul>
   *
   * <p>Method under test: {@link BLCDateUtils#convertDateToUTC(Date)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCDateUtils.convertDateToUTC(Date)"})
  public void testConvertDateToUTC_thenReturn197001010000000() {
    // Arrange, Act and Assert
    assertEquals(
        "1970-01-01 00:00:00.0",
        BLCDateUtils.convertDateToUTC(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())));
  }

  /**
   * Test {@link BLCDateUtils#formatDateAsString(Date, TimeZone)} with {@code date}, {@code
   * timeZone}.
   *
   * <ul>
   *   <li>Then return {@code Dec 31, 1970 @ 04:00pm}.
   * </ul>
   *
   * <p>Method under test: {@link BLCDateUtils#formatDateAsString(Date, TimeZone)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCDateUtils.formatDateAsString(Date, TimeZone)"})
  public void testFormatDateAsStringWithDateTimeZone_thenReturnDec3119700400pm() {
    // Arrange, Act and Assert
    assertEquals(
        "Dec 31, 1970 @ 04:00pm",
        BLCDateUtils.formatDateAsString(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()),
            TimeZone.getTimeZone("America/Los_Angeles")));
  }

  /**
   * Test {@link BLCDateUtils#parseStringToDate(String, String)} with {@code dateString}, {@code
   * dateFormat}.
   *
   * <p>Method under test: {@link BLCDateUtils#parseStringToDate(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Date BLCDateUtils.parseStringToDate(String, String)"})
  public void testParseStringToDateWithDateStringDateFormat() {
    // Arrange and Act
    Date actualParseStringToDateResult = BLCDateUtils.parseStringToDate("2020-03-01", "2020-03-01");

    // Assert
    assertEquals(
        "1970-01-01", new SimpleDateFormat("yyyy-MM-dd").format(actualParseStringToDateResult));
  }

  /**
   * Test {@link BLCDateUtils#parseStringToDate(String, String)} with {@code dateString}, {@code
   * dateFormat}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BLCDateUtils#parseStringToDate(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Date BLCDateUtils.parseStringToDate(String, String)"})
  public void testParseStringToDateWithDateStringDateFormat_whenEmptyString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(BLCDateUtils.parseStringToDate("", "2020-03-01"));
  }

  /**
   * Test {@link BLCDateUtils#parseStringToDate(String, String)} with {@code dateString}, {@code
   * dateFormat}.
   *
   * <ul>
   *   <li>When {@code not empty}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BLCDateUtils#parseStringToDate(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Date BLCDateUtils.parseStringToDate(String, String)"})
  public void testParseStringToDateWithDateStringDateFormat_whenNotEmpty_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(BLCDateUtils.parseStringToDate("not empty", "2020-03-01"));
  }

  /**
   * Test {@link BLCDateUtils#parseStringToDate(String, String)} with {@code dateString}, {@code
   * dateFormat}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BLCDateUtils#parseStringToDate(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Date BLCDateUtils.parseStringToDate(String, String)"})
  public void testParseStringToDateWithDateStringDateFormat_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(BLCDateUtils.parseStringToDate(null, "2020-03-01"));
  }

  /**
   * Test {@link BLCDateUtils#parseStringToDate(String)} with {@code dateString}.
   *
   * <ul>
   *   <li>When {@code 2020-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link BLCDateUtils#parseStringToDate(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Date BLCDateUtils.parseStringToDate(String)"})
  public void testParseStringToDateWithDateString_when20200301() {
    // Arrange, Act and Assert
    assertNull(BLCDateUtils.parseStringToDate("2020-03-01"));
  }

  /**
   * Test {@link BLCDateUtils#parseStringToDate(String)} with {@code dateString}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link BLCDateUtils#parseStringToDate(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Date BLCDateUtils.parseStringToDate(String)"})
  public void testParseStringToDateWithDateString_whenEmptyString() {
    // Arrange, Act and Assert
    assertNull(BLCDateUtils.parseStringToDate(""));
  }

  /**
   * Test {@link BLCDateUtils#parseStringToDate(String)} with {@code dateString}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BLCDateUtils#parseStringToDate(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Date BLCDateUtils.parseStringToDate(String)"})
  public void testParseStringToDateWithDateString_whenNull() {
    // Arrange, Act and Assert
    assertNull(BLCDateUtils.parseStringToDate(null));
  }

  /**
   * Test {@link BLCDateUtils#formatSimpleDate(Date)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BLCDateUtils#formatSimpleDate(Date)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCDateUtils.formatSimpleDate(Date)"})
  public void testFormatSimpleDate_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(BLCDateUtils.formatSimpleDate(null));
  }

  /**
   * Test {@link BLCDateUtils#formatDate(Date, String, TimeZone)} with {@code date}, {@code format},
   * {@code timeZone}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link BLCDateUtils#formatDate(Date, String, TimeZone)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCDateUtils.formatDate(Date, String, TimeZone)"})
  public void testFormatDateWithDateFormatTimeZone_when42_thenReturn42() {
    // Arrange and Act
    String actualFormatDateResult =
        BLCDateUtils.formatDate(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()),
            "42",
            TimeZone.getTimeZone("America/Los_Angeles"));

    // Assert
    assertEquals("42", actualFormatDateResult);
  }

  /**
   * Test {@link BLCDateUtils#formatDate(Date, String, TimeZone)} with {@code date}, {@code format},
   * {@code timeZone}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BLCDateUtils#formatDate(Date, String, TimeZone)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCDateUtils.formatDate(Date, String, TimeZone)"})
  public void testFormatDateWithDateFormatTimeZone_whenNull_thenReturnNull() {
    // Arrange and Act
    String actualFormatDateResult =
        BLCDateUtils.formatDate(null, "Format", TimeZone.getTimeZone("America/Los_Angeles"));

    // Assert
    assertNull(actualFormatDateResult);
  }

  /**
   * Test {@link BLCDateUtils#formatDate(Date, String)} with {@code date}, {@code format}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BLCDateUtils#formatDate(Date, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCDateUtils.formatDate(Date, String)"})
  public void testFormatDateWithDateFormat_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(BLCDateUtils.formatDate(null, "Format"));
  }

  /**
   * Test {@link BLCDateUtils#formatDate(Date)} with {@code date}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BLCDateUtils#formatDate(Date)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BLCDateUtils.formatDate(Date)"})
  public void testFormatDateWithDate_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(BLCDateUtils.formatDate(null));
  }
}

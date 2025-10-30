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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
   * <ul>
   *   <li>Then return {@code 1970-01-01 00:00:00.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCDateUtils#convertDateToUTC(Date)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BLCDateUtils.convertDateToUTC(Date)"})
  public void testConvertDateToUTC_thenReturn197001010000000() {
    // Arrange, Act and Assert
    assertEquals("1970-01-01 00:00:00.0", BLCDateUtils
        .convertDateToUTC(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())));
  }

  /**
   * Test {@link BLCDateUtils#formatDateAsString(Date, TimeZone)} with {@code date}, {@code timeZone}.
   * <ul>
   *   <li>Then return {@code Dec 31, 1970 @ 04:00pm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCDateUtils#formatDateAsString(Date, TimeZone)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BLCDateUtils.formatDateAsString(Date, TimeZone)"})
  public void testFormatDateAsStringWithDateTimeZone_thenReturnDec3119700400pm() {
    // Arrange
    Date date = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals("Dec 31, 1970 @ 04:00pm",
        BLCDateUtils.formatDateAsString(date, TimeZone.getTimeZone("America/Los_Angeles")));
  }

  /**
   * Test {@link BLCDateUtils#parseStringToDate(String, String)} with {@code dateString}, {@code dateFormat}.
   * <p>
   * Method under test: {@link BLCDateUtils#parseStringToDate(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Date BLCDateUtils.parseStringToDate(String, String)"})
  public void testParseStringToDateWithDateStringDateFormat() {
    // Arrange and Act
    Date actualParseStringToDateResult = BLCDateUtils.parseStringToDate("2020-03-01", "2020-03-01");

    // Assert
    assertEquals("1970-01-01", (new SimpleDateFormat("yyyy-MM-dd")).format(actualParseStringToDateResult));
  }

  /**
   * Test {@link BLCDateUtils#parseStringToDate(String, String)} with {@code dateString}, {@code dateFormat}.
   * <ul>
   *   <li>When {@code 2020/03/01}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCDateUtils#parseStringToDate(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Date BLCDateUtils.parseStringToDate(String, String)"})
  public void testParseStringToDateWithDateStringDateFormat_when20200301_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(BLCDateUtils.parseStringToDate("2020/03/01", "2020-03-01"));
  }

  /**
   * Test {@link BLCDateUtils#parseStringToDate(String, String)} with {@code dateString}, {@code dateFormat}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCDateUtils#parseStringToDate(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Date BLCDateUtils.parseStringToDate(String, String)"})
  public void testParseStringToDateWithDateStringDateFormat_whenEmptyString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(BLCDateUtils.parseStringToDate("", "2020-03-01"));
  }

  /**
   * Test {@link BLCDateUtils#parseStringToDate(String, String)} with {@code dateString}, {@code dateFormat}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCDateUtils#parseStringToDate(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Date BLCDateUtils.parseStringToDate(String, String)"})
  public void testParseStringToDateWithDateStringDateFormat_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(BLCDateUtils.parseStringToDate(null, "2020-03-01"));
  }

  /**
   * Test {@link BLCDateUtils#parseStringToDate(String)} with {@code dateString}.
   * <ul>
   *   <li>When {@code 2020-03-01}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCDateUtils#parseStringToDate(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Date BLCDateUtils.parseStringToDate(String)"})
  public void testParseStringToDateWithDateString_when20200301() {
    // Arrange, Act and Assert
    assertNull(BLCDateUtils.parseStringToDate("2020-03-01"));
  }

  /**
   * Test {@link BLCDateUtils#parseStringToDate(String)} with {@code dateString}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCDateUtils#parseStringToDate(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Date BLCDateUtils.parseStringToDate(String)"})
  public void testParseStringToDateWithDateString_whenEmptyString() {
    // Arrange, Act and Assert
    assertNull(BLCDateUtils.parseStringToDate(""));
  }

  /**
   * Test {@link BLCDateUtils#parseStringToDate(String)} with {@code dateString}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCDateUtils#parseStringToDate(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Date BLCDateUtils.parseStringToDate(String)"})
  public void testParseStringToDateWithDateString_whenNull() {
    // Arrange, Act and Assert
    assertNull(BLCDateUtils.parseStringToDate(null));
  }

  /**
   * Test {@link BLCDateUtils#formatSimpleDate(Date)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCDateUtils#formatSimpleDate(Date)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BLCDateUtils.formatSimpleDate(Date)"})
  public void testFormatSimpleDate_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(BLCDateUtils.formatSimpleDate(null));
  }

  /**
   * Test {@link BLCDateUtils#formatDate(Date, String, TimeZone)} with {@code date}, {@code format}, {@code timeZone}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCDateUtils#formatDate(Date, String, TimeZone)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BLCDateUtils.formatDate(Date, String, TimeZone)"})
  public void testFormatDateWithDateFormatTimeZone_when42_thenReturn42() {
    // Arrange
    Date date = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals("42", BLCDateUtils.formatDate(date, "42", TimeZone.getTimeZone("America/Los_Angeles")));
  }

  /**
   * Test {@link BLCDateUtils#formatDate(Date, String, TimeZone)} with {@code date}, {@code format}, {@code timeZone}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCDateUtils#formatDate(Date, String, TimeZone)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BLCDateUtils.formatDate(Date, String, TimeZone)"})
  public void testFormatDateWithDateFormatTimeZone_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(BLCDateUtils.formatDate(null, "Format", TimeZone.getTimeZone("America/Los_Angeles")));
  }

  /**
   * Test {@link BLCDateUtils#formatDate(Date, String)} with {@code date}, {@code format}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCDateUtils#formatDate(Date, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BLCDateUtils.formatDate(Date, String)"})
  public void testFormatDateWithDateFormat_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(BLCDateUtils.formatDate(null, "Format"));
  }

  /**
   * Test {@link BLCDateUtils#formatDate(Date)} with {@code date}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCDateUtils#formatDate(Date)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BLCDateUtils.formatDate(Date)"})
  public void testFormatDateWithDate_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(BLCDateUtils.formatDate(null));
  }
}

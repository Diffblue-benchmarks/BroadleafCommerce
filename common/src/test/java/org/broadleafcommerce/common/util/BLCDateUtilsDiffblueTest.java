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
package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.TimeZone;
import org.junit.Test;

public class BLCDateUtilsDiffblueTest {
  /**
   * Test {@link BLCDateUtils#convertDateToUTC(Date)}.
   * <p>
   * Method under test: {@link BLCDateUtils#convertDateToUTC(Date)}
   */
  @Test
  public void testConvertDateToUTC() {
    // Arrange, Act and Assert
    assertEquals("1970-01-01 00:00:00.0", BLCDateUtils
        .convertDateToUTC(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())));
  }

  /**
   * Test {@link BLCDateUtils#convertDateToUTC(Date)}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>When {@link java.sql.Date} {@link java.util.Date#getTime()} return
   * ten.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCDateUtils#convertDateToUTC(java.util.Date)}
   */
  @Test
  public void testConvertDateToUTC_givenTen_whenDateGetTimeReturnTen_thenCallsGetTime() {
    // Arrange
    java.sql.Date date = mock(java.sql.Date.class);
    when(date.getTime()).thenReturn(10L);

    // Act
    String actualConvertDateToUTCResult = BLCDateUtils.convertDateToUTC(date);

    // Assert
    verify(date).getTime();
    assertEquals("1970-01-01 00:00:00.0", actualConvertDateToUTCResult);
  }

  /**
   * Test {@link BLCDateUtils#formatDateAsString(Date, TimeZone)} with
   * {@code date}, {@code timeZone}.
   * <p>
   * Method under test: {@link BLCDateUtils#formatDateAsString(Date, TimeZone)}
   */
  @Test
  public void testFormatDateAsStringWithDateTimeZone() {
    // Arrange
    Date date = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals("Dec 31, 1970 @ 04:00pm",
        BLCDateUtils.formatDateAsString(date, TimeZone.getTimeZone("America/Los_Angeles")));
  }

  /**
   * Test {@link BLCDateUtils#formatDateAsString(Date, TimeZone)} with
   * {@code date}, {@code timeZone}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BLCDateUtils#formatDateAsString(java.util.Date, TimeZone)}
   */
  @Test
  public void testFormatDateAsStringWithDateTimeZone_givenTen_thenCallsGetTime() {
    // Arrange
    java.sql.Date date = mock(java.sql.Date.class);
    when(date.getTime()).thenReturn(10L);

    // Act
    String actualFormatDateAsStringResult = BLCDateUtils.formatDateAsString(date,
        TimeZone.getTimeZone("America/Los_Angeles"));

    // Assert
    verify(date).getTime();
    assertEquals("Dec 31, 1970 @ 04:00pm", actualFormatDateAsStringResult);
  }

  /**
   * Test {@link BLCDateUtils#parseStringToDate(String, String)} with
   * {@code dateString}, {@code dateFormat}.
   * <p>
   * Method under test: {@link BLCDateUtils#parseStringToDate(String, String)}
   */
  @Test
  public void testParseStringToDateWithDateStringDateFormat() {
    // Arrange and Act
    Date actualParseStringToDateResult = BLCDateUtils.parseStringToDate("2020-03-01", "2020-03-01");

    // Assert
    assertEquals("1970-01-01", (new SimpleDateFormat("yyyy-MM-dd")).format(actualParseStringToDateResult));
  }

  /**
   * Test {@link BLCDateUtils#parseStringToDate(String, String)} with
   * {@code dateString}, {@code dateFormat}.
   * <ul>
   *   <li>When {@code 2020/03/01}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCDateUtils#parseStringToDate(String, String)}
   */
  @Test
  public void testParseStringToDateWithDateStringDateFormat_when20200301_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(BLCDateUtils.parseStringToDate("2020/03/01", "2020-03-01"));
  }

  /**
   * Test {@link BLCDateUtils#parseStringToDate(String, String)} with
   * {@code dateString}, {@code dateFormat}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCDateUtils#parseStringToDate(String, String)}
   */
  @Test
  public void testParseStringToDateWithDateStringDateFormat_whenEmptyString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(BLCDateUtils.parseStringToDate("", "2020-03-01"));
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
  public void testParseStringToDateWithDateString_whenEmptyString() {
    // Arrange, Act and Assert
    assertNull(BLCDateUtils.parseStringToDate(""));
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
  public void testFormatSimpleDate_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(BLCDateUtils.formatSimpleDate(null));
  }

  /**
   * Test {@link BLCDateUtils#formatDate(Date, String, TimeZone)} with
   * {@code date}, {@code format}, {@code timeZone}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCDateUtils#formatDate(Date, String, TimeZone)}
   */
  @Test
  public void testFormatDateWithDateFormatTimeZone_when42_thenReturn42() {
    // Arrange
    Date date = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals("42", BLCDateUtils.formatDate(date, "42", TimeZone.getTimeZone("America/Los_Angeles")));
  }

  /**
   * Test {@link BLCDateUtils#formatDate(Date, String, TimeZone)} with
   * {@code date}, {@code format}, {@code timeZone}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCDateUtils#formatDate(Date, String, TimeZone)}
   */
  @Test
  public void testFormatDateWithDateFormatTimeZone_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(BLCDateUtils.formatDate(null, "Format", TimeZone.getTimeZone("America/Los_Angeles")));
  }

  /**
   * Test {@link BLCDateUtils#formatDate(Date, String)} with {@code date},
   * {@code format}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BLCDateUtils#formatDate(Date, String)}
   */
  @Test
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
  public void testFormatDateWithDate_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(BLCDateUtils.formatDate(null));
  }
}

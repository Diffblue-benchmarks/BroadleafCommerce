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
   * Method under test: {@link BLCDateUtils#convertDateToUTC(Date)}
   */
  @Test
  public void testConvertDateToUTC() {
    // Arrange, Act and Assert
    assertEquals("1970-01-01 00:00:00.0", BLCDateUtils
        .convertDateToUTC(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())));
  }

  /**
   * Method under test: {@link BLCDateUtils#convertDateToUTC(java.util.Date)}
   */
  @Test
  public void testConvertDateToUTC2() {
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
   * Method under test: {@link BLCDateUtils#formatDateAsString(Date, TimeZone)}
   */
  @Test
  public void testFormatDateAsString() {
    // Arrange
    Date date = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals("Dec 31, 1970 @ 04:00pm",
        BLCDateUtils.formatDateAsString(date, TimeZone.getTimeZone("America/Los_Angeles")));
  }

  /**
   * Method under test:
   * {@link BLCDateUtils#formatDateAsString(java.util.Date, TimeZone)}
   */
  @Test
  public void testFormatDateAsString2() {
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
   * Method under test: {@link BLCDateUtils#parseStringToDate(String)}
   */
  @Test
  public void testParseStringToDate() {
    // Arrange, Act and Assert
    assertNull(BLCDateUtils.parseStringToDate("2020-03-01"));
    assertNull(BLCDateUtils.parseStringToDate(""));
    assertNull(BLCDateUtils.parseStringToDate("2020/03/01", "2020-03-01"));
    assertNull(BLCDateUtils.parseStringToDate("", "2020-03-01"));
  }

  /**
   * Method under test: {@link BLCDateUtils#parseStringToDate(String, String)}
   */
  @Test
  public void testParseStringToDate2() {
    // Arrange and Act
    Date actualParseStringToDateResult = BLCDateUtils.parseStringToDate("2020-03-01", "2020-03-01");

    // Assert
    assertEquals("1970-01-01", (new SimpleDateFormat("yyyy-MM-dd")).format(actualParseStringToDateResult));
  }

  /**
   * Method under test: {@link BLCDateUtils#formatSimpleDate(Date)}
   */
  @Test
  public void testFormatSimpleDate() {
    // Arrange, Act and Assert
    assertNull(BLCDateUtils.formatSimpleDate(null));
  }

  /**
   * Method under test: {@link BLCDateUtils#formatDate(Date)}
   */
  @Test
  public void testFormatDate() {
    // Arrange, Act and Assert
    assertNull(BLCDateUtils.formatDate(null));
    assertNull(BLCDateUtils.formatDate(null, "Format"));
    assertNull(BLCDateUtils.formatDate(null, "Format", TimeZone.getTimeZone("America/Los_Angeles")));
  }

  /**
   * Method under test: {@link BLCDateUtils#formatDate(Date, String, TimeZone)}
   */
  @Test
  public void testFormatDate2() {
    // Arrange
    Date date = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals("42", BLCDateUtils.formatDate(date, "42", TimeZone.getTimeZone("America/Los_Angeles")));
  }
}

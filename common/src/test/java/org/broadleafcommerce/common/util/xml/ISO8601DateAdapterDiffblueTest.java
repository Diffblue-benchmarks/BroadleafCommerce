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
package org.broadleafcommerce.common.util.xml;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.RoundingMode;
import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ISO8601DateAdapter.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ISO8601DateAdapterDiffblueTest {
  @Autowired
  private ISO8601DateAdapter iSO8601DateAdapter;

  /**
   * Test {@link ISO8601DateAdapter#marshal(Date)} with {@code Date}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>When {@link java.sql.Date} {@link java.util.Date#getTime()} return
   * ten.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ISO8601DateAdapter#marshal(java.util.Date)}
   */
  @Test
  public void testMarshalWithDate_givenTen_whenDateGetTimeReturnTen_thenCallsGetTime() throws Exception {
    // Arrange
    ISO8601DateAdapter iso8601DateAdapter = new ISO8601DateAdapter();
    java.sql.Date arg0 = mock(java.sql.Date.class);
    when(arg0.getTime()).thenReturn(10L);

    // Act
    iso8601DateAdapter.marshal(arg0);

    // Assert
    verify(arg0).getTime();
  }

  /**
   * Test {@link ISO8601DateAdapter#unmarshal(String)} with {@code String}.
   * <p>
   * Method under test: {@link ISO8601DateAdapter#unmarshal(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testUnmarshalWithString() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.text.ParseException: Unparseable date: "Arg0"
    //       at java.base/java.text.DateFormat.parse(DateFormat.java:395)
    //       at org.broadleafcommerce.common.util.xml.ISO8601DateAdapter.unmarshal(ISO8601DateAdapter.java:38)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    iSO8601DateAdapter.unmarshal("Arg0");
  }

  /**
   * Test new {@link ISO8601DateAdapter} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link ISO8601DateAdapter}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNewISO8601DateAdapter() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange, Act and Assert
    SimpleDateFormat simpleDateFormat = (new ISO8601DateAdapter()).isoFormat;
    NumberFormat numberFormat = simpleDateFormat.getNumberFormat();
    assertTrue(numberFormat instanceof DecimalFormat);
    Calendar calendar = simpleDateFormat.getCalendar();
    assertTrue(calendar instanceof GregorianCalendar);
    assertEquals("", ((DecimalFormat) numberFormat).getNegativeSuffix());
    assertEquals("", ((DecimalFormat) numberFormat).getPositivePrefix());
    assertEquals("", ((DecimalFormat) numberFormat).getPositiveSuffix());
    assertEquals("###0", ((DecimalFormat) numberFormat).toLocalizedPattern());
    assertEquals("###0", ((DecimalFormat) numberFormat).toPattern());
    assertEquals("-", ((DecimalFormat) numberFormat).getNegativePrefix());
    Currency currency = numberFormat.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) numberFormat).getDecimalFormatSymbols();
    assertEquals("E", decimalFormatSymbols.getExponentSeparator());
    assertEquals("GBP", decimalFormatSymbols.getInternationalCurrencySymbol());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    DateFormatSymbols dateFormatSymbols = simpleDateFormat.getDateFormatSymbols();
    assertEquals("GyMdkHmsSEDFwWahKzZ", dateFormatSymbols.getLocalPatternChars());
    assertEquals("NaN", decimalFormatSymbols.getNaN());
    assertEquals("£", decimalFormatSymbols.getCurrencySymbol());
    assertEquals("£", currency.getSymbol());
    assertEquals("∞", decimalFormatSymbols.getInfinity());
    assertEquals("gregory", calendar.getCalendarType());
    assertEquals("yyyy-MM-dd'T'HH:mm:ss.SSSZ", simpleDateFormat.toPattern());
    assertEquals('#', decimalFormatSymbols.getDigit());
    assertEquals('%', decimalFormatSymbols.getPercent());
    assertEquals(',', decimalFormatSymbols.getGroupingSeparator());
    assertEquals('-', decimalFormatSymbols.getMinusSign());
    assertEquals('.', decimalFormatSymbols.getDecimalSeparator());
    assertEquals('.', decimalFormatSymbols.getMonetaryDecimalSeparator());
    assertEquals('0', decimalFormatSymbols.getZeroDigit());
    assertEquals(';', decimalFormatSymbols.getPatternSeparator());
    assertEquals('‰', decimalFormatSymbols.getPerMill());
    assertEquals(0, numberFormat.getMaximumFractionDigits());
    assertEquals(0, numberFormat.getMinimumFractionDigits());
    TimeZone timeZone = simpleDateFormat.getTimeZone();
    assertEquals(0, timeZone.getDSTSavings());
    assertEquals(1, ((DecimalFormat) numberFormat).getMultiplier());
    assertEquals(1, numberFormat.getMinimumIntegerDigits());
    assertEquals(1945, calendar.getWeekYear());
    assertEquals(2, calendar.getFirstDayOfWeek());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(3, ((DecimalFormat) numberFormat).getGroupingSize());
    assertEquals(4, calendar.getMinimalDaysInFirstWeek());
    assertEquals(52, calendar.getWeeksInWeekYear());
    String[][] zoneStrings = dateFormatSymbols.getZoneStrings();
    assertEquals(601, zoneStrings.length);
    assertEquals(826, currency.getNumericCode());
    assertEquals(RoundingMode.HALF_EVEN, numberFormat.getRoundingMode());
    assertFalse(((DecimalFormat) numberFormat).isDecimalSeparatorAlwaysShown());
    assertFalse(((DecimalFormat) numberFormat).isParseBigDecimal());
    assertFalse(numberFormat.isGroupingUsed());
    assertTrue(simpleDateFormat.isLenient());
    assertTrue(numberFormat.isParseIntegerOnly());
    assertTrue(calendar.isLenient());
    assertTrue(calendar.isWeekDateSupported());
    assertEquals(Integer.MAX_VALUE, numberFormat.getMaximumIntegerDigits());
    assertSame(timeZone, calendar.getTimeZone());
    assertSame(currency, decimalFormatSymbols.getCurrency());
    assertArrayEquals(new String[]{"BC", "AD"}, dateFormatSymbols.getEras());
    assertArrayEquals(new String[]{"am", "pm"}, dateFormatSymbols.getAmPmStrings());
    assertArrayEquals(new String[]{"Africa/Cairo", "Eastern European Standard Time", "EET",
        "Eastern European Summer Time", "EEST", "Eastern European Time", "EET"}, zoneStrings[9]);
    assertArrayEquals(new String[]{"Africa/Casablanca", "Western European Standard Time", "WET",
        "Western European Summer Time", "WEST", "Western European Time", "WET"}, zoneStrings[1]);
    assertArrayEquals(new String[]{"Africa/El_Aaiun", "Western European Standard Time", "WET",
        "Western European Summer Time", "WEST", "Western European Time", "WET"}, zoneStrings[8]);
    assertArrayEquals(new String[]{"America/Argentina/Buenos_Aires", "Argentina Standard Time", "ART",
        "Argentina Summer Time", "ARST", "Argentina Time", "ART"}, zoneStrings[598]);
    assertArrayEquals(new String[]{"America/Argentina/ComodRivadavia", "Argentina Standard Time", "ART",
        "Argentina Summer Time", "ARST", "Argentina Time", "ART"}, zoneStrings[587]);
    assertArrayEquals(new String[]{"America/Ensenada", "Pacific Standard Time", "GMT-08:00", "Pacific Daylight Time",
        "GMT-07:00", "Pacific Time", "GMT-08:00"}, zoneStrings[581]);
    assertArrayEquals(new String[]{"America/Nuuk", "Western Greenland Time", "WGT", "Western Greenland Summer Time",
        "WGST", "Western Greenland Time", "WGT"}, zoneStrings[590]);
    assertArrayEquals(new String[]{"America/Rosario", "Argentina Standard Time", "ART", "Argentina Summer Time", "ARST",
        "Argentina Time", "ART"}, zoneStrings[595]);
    assertArrayEquals(new String[]{"America/Virgin", "Atlantic Standard Time", "GMT-04:00", "Atlantic Daylight Time",
        "GMT-04:00", "Atlantic Time", "GMT-04:00"}, zoneStrings[582]);
    assertArrayEquals(new String[]{"Asia/Famagusta", "Eastern European Time", "EET", "Eastern European Summer Time",
        "EEST", "Eastern European Time", "EET"}, zoneStrings[588]);
    assertArrayEquals(new String[]{"Asia/Gaza", "Eastern European Standard Time", "EET", "Eastern European Summer Time",
        "EEST", "Eastern European Time", "EET"}, zoneStrings[12]);
    assertArrayEquals(new String[]{"Asia/Nicosia", "Eastern European Standard Time", "EET",
        "Eastern European Summer Time", "EEST", "Eastern European Time", "EET"}, zoneStrings[5]);
    assertArrayEquals(new String[]{"Asia/Srednekolymsk", "Srednekolymsk Time", "SRET", "Srednekolymsk Daylight Time",
        "SREDT", "Srednekolymsk Time", "SRET"}, zoneStrings[597]);
    assertArrayEquals(new String[]{"Asia/Ulaanbaatar", "Ulan Bator Standard Time", "ULAT", "Ulan Bator Summer Time",
        "ULAST", "Ulan Bator Time", "ULAT"}, zoneStrings[17]);
    assertArrayEquals(new String[]{"Atlantic/Canary", "Western European Standard Time", "WET",
        "Western European Summer Time", "WEST", "Western European Time", "WET"}, zoneStrings[20]);
    assertArrayEquals(new String[]{"Atlantic/Faeroe", "Western European Standard Time", "WET",
        "Western European Summer Time", "WEST", "Western European Time", "WET"}, zoneStrings[Short.SIZE]);
    assertArrayEquals(new String[]{"Australia/Darwin", "Australian Central Standard Time", "ACST",
        "Australian Central Daylight Time", "ACDT", "Central Australia Time", "ACT"}, zoneStrings[15]);
    assertArrayEquals(new String[]{"Canada/Saskatchewan", "Central Standard Time", "GMT-06:00", "Central Daylight Time",
        "GMT-06:00", "Central Time", "GMT-06:00"}, zoneStrings[594]);
    assertArrayEquals(new String[]{"EET", "Eastern European Time", "EET", "Eastern European Summer Time", "EEST",
        "Eastern European Time", "EET"}, zoneStrings[593]);
    assertArrayEquals(new String[]{"Egypt", "Eastern European Standard Time", "EET", "Eastern European Summer Time",
        "EEST", "Eastern European Time", "EET"}, zoneStrings[596]);
    assertArrayEquals(new String[]{"Etc/Greenwich", "Greenwich Mean Time", "GMT", "Greenwich Mean Time", "GMT",
        "Greenwich Mean Time", "GMT"}, zoneStrings[580]);
    assertArrayEquals(new String[]{"Europe/Astrakhan", "Astrakhan Standard Time", "GMT+04:00",
        "Astrakhan Standard Time", "GMT+04:00", "Astrakhan Time", "GMT+04:00"}, zoneStrings[579]);
    assertArrayEquals(new String[]{"Europe/Berlin", "Central European Standard Time", "CET",
        "Central European Summer Time", "CEST", "Central European Time", "CET"}, zoneStrings[7]);
    assertArrayEquals(new String[]{"Europe/Bratislava", "Central European Standard Time", "CET",
        "Central European Summer Time", "CEST", "Central European Time", "CET"}, zoneStrings[21]);
    assertArrayEquals(new String[]{"Europe/Bucharest", "Eastern European Standard Time", "EET",
        "Eastern European Summer Time", "EEST", "Eastern European Time", "EET"}, zoneStrings[2]);
    assertArrayEquals(new String[]{"Europe/Budapest", "Central European Standard Time", "CET",
        "Central European Summer Time", "CEST", "Central European Time", "CET"}, zoneStrings[19]);
    assertArrayEquals(new String[]{"Europe/Chisinau", "Eastern European Standard Time", "EET",
        "Eastern European Summer Time", "EEST", "Eastern European Time", "EET"}, zoneStrings[13]);
    assertArrayEquals(new String[]{"Europe/Copenhagen", "Central European Standard Time", "CET",
        "Central European Summer Time", "CEST", "Central European Time", "CET"}, zoneStrings[24]);
    assertArrayEquals(new String[]{"Europe/Kaliningrad", "Eastern European Standard Time", "EET",
        "Eastern European Summer Time", "EEST", "Eastern European Time", "EET"}, zoneStrings[6]);
    assertArrayEquals(new String[]{"Europe/Kyiv", "Eastern European Standard Time", "EET",
        "Eastern European Summer Time", "EEST", "Eastern European Time", "EET"}, zoneStrings[584]);
    assertArrayEquals(new String[]{"Europe/Lisbon", "Western European Standard Time", "WET",
        "Western European Summer Time", "WEST", "Western European Time", "WET"}, zoneStrings[10]);
    assertArrayEquals(new String[]{"Europe/Ljubljana", "Central European Standard Time", "CET",
        "Central European Summer Time", "CEST", "Central European Time", "CET"}, zoneStrings[4]);
    assertArrayEquals(new String[]{"Europe/Nicosia", "Eastern European Standard Time", "EET",
        "Eastern European Summer Time", "EEST", "Eastern European Time", "EET"}, zoneStrings[599]);
    assertArrayEquals(new String[]{"Europe/Oslo", "Central European Standard Time", "CET",
        "Central European Summer Time", "CEST", "Central European Time", "CET"}, zoneStrings[11]);
    assertArrayEquals(new String[]{"Europe/Paris", "Central European Standard Time", "CET",
        "Central European Summer Time", "CEST", "Central European Time", "CET"}, zoneStrings[0]);
    assertArrayEquals(new String[]{"Europe/San_Marino", "Central European Standard Time", "CET",
        "Central European Summer Time", "CEST", "Central European Time", "CET"}, zoneStrings[22]);
    assertArrayEquals(new String[]{"Europe/Stockholm", "Central European Standard Time", "CET",
        "Central European Summer Time", "CEST", "Central European Time", "CET"}, zoneStrings[18]);
    assertArrayEquals(new String[]{"Europe/Ulyanovsk", "Ulyanovsk Standard Time", "GMT+04:00",
        "Ulyanovsk Standard Time", "GMT+04:00", "Ulyanovsk Time", "GMT+04:00"}, zoneStrings[591]);
    assertArrayEquals(new String[]{"Europe/Zagreb", "Central European Standard Time", "CET",
        "Central European Summer Time", "CEST", "Central European Time", "CET"}, zoneStrings[23]);
    assertArrayEquals(new String[]{"Hongkong", "Hong Kong Standard Time", "HKT", "Hong Kong Summer Time", "HKST",
        "Hong Kong Time", "HKT"}, zoneStrings[585]);
    assertArrayEquals(new String[]{"Jamaica", "Eastern Standard Time", "GMT-05:00", "Eastern Daylight Time",
        "GMT-05:00", "Eastern Time", "GMT-05:00"}, zoneStrings[577]);
    assertArrayEquals(
        new String[]{"Japan", "Japan Standard Time", "JST", "Japan Daylight Time", "JDT", "Japan Time", "JT"},
        zoneStrings[589]);
    assertArrayEquals(
        new String[]{"MST", "Mountain Standard Time", "MST", "Mountain Daylight Time", "MDT", "Mountain Time", "MT"},
        zoneStrings[583]);
    assertArrayEquals(new String[]{"Turkey", "Turkey Time", "TRT", "Turkey Summer Time", "TRST", "Turkey Time", "TRT"},
        zoneStrings[576]);
    assertArrayEquals(new String[]{"UCT", "Coordinated Universal Time", "UTC", "Coordinated Universal Time", "UTC",
        "Coordinated Universal Time", "UTC"}, zoneStrings[586]);
    assertArrayEquals(new String[]{"US/Pacific", "Pacific Standard Time", "GMT-08:00", "Pacific Daylight Time",
        "GMT-07:00", "Pacific Time", "GMT-08:00"}, zoneStrings[600]);
    assertArrayEquals(new String[]{"UTC", "Coordinated Universal Time", "UTC", "Coordinated Universal Time", "UTC",
        "Coordinated Universal Time", "UTC"}, zoneStrings[3]);
    assertArrayEquals(
        new String[]{"W-SU", "Moscow Standard Time", "MSK", "Moscow Summer Time", "MSD", "Moscow Time", "MT"},
        zoneStrings[592]);
    assertArrayEquals(new String[]{"WET", "Western European Time", "WET", "Western European Summer Time", "WEST",
        "Western European Time", "WET"}, zoneStrings[578]);
    assertArrayEquals(new String[]{System.getProperty("user.timezone"), "Greenwich Mean Time", "GMT",
        "British Summer Time", "BST", "British Time", "BT"}, zoneStrings[14]);
    assertArrayEquals(new String[]{"", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"},
        dateFormatSymbols.getShortWeekdays());
    assertArrayEquals(new String[]{"", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"},
        dateFormatSymbols.getWeekdays());
    assertArrayEquals(
        new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", ""},
        dateFormatSymbols.getShortMonths());
    assertArrayEquals(new String[]{"January", "February", "March", "April", "May", "June", "July", "August",
        "September", "October", "November", "December", ""}, dateFormatSymbols.getMonths());
  }
}

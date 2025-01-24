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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
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
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.junit.Test;

public class FormatUtilDiffblueTest {
  /**
   * Test {@link FormatUtil#getDateFormat()}.
   * <p>
   * Method under test: {@link FormatUtil#getDateFormat()}
   */
  @Test
  public void testGetDateFormat() {
    // Arrange and Act
    SimpleDateFormat actualDateFormat = FormatUtil.getDateFormat();

    // Assert
    NumberFormat numberFormat = actualDateFormat.getNumberFormat();
    assertTrue(numberFormat instanceof DecimalFormat);
    Calendar calendar = actualDateFormat.getCalendar();
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
    DateFormatSymbols dateFormatSymbols = actualDateFormat.getDateFormatSymbols();
    assertEquals("GyMdkHmsSEDFwWahKzZ", dateFormatSymbols.getLocalPatternChars());
    assertEquals("NaN", decimalFormatSymbols.getNaN());
    assertEquals("£", decimalFormatSymbols.getCurrencySymbol());
    assertEquals("£", currency.getSymbol());
    assertEquals("∞", decimalFormatSymbols.getInfinity());
    assertEquals("gregory", calendar.getCalendarType());
    assertEquals('#', decimalFormatSymbols.getDigit());
    assertEquals('%', decimalFormatSymbols.getPercent());
    assertEquals(',', decimalFormatSymbols.getGroupingSeparator());
    assertEquals('-', decimalFormatSymbols.getMinusSign());
    assertEquals('.', decimalFormatSymbols.getDecimalSeparator());
    assertEquals('.', decimalFormatSymbols.getMonetaryDecimalSeparator());
    assertEquals('0', decimalFormatSymbols.getZeroDigit());
    assertEquals(';', decimalFormatSymbols.getPatternSeparator());
    assertEquals('‰', decimalFormatSymbols.getPerMill());
    assertNull(actualDateFormat.getTimeZone());
    assertNull(calendar.getTimeZone());
    assertEquals(0, numberFormat.getMaximumFractionDigits());
    assertEquals(0, numberFormat.getMinimumFractionDigits());
    assertEquals(1, ((DecimalFormat) numberFormat).getMultiplier());
    assertEquals(1, numberFormat.getMinimumIntegerDigits());
    assertEquals(2, calendar.getFirstDayOfWeek());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(3, ((DecimalFormat) numberFormat).getGroupingSize());
    assertEquals(4, calendar.getMinimalDaysInFirstWeek());
    String[][] zoneStrings = dateFormatSymbols.getZoneStrings();
    assertEquals(601, zoneStrings.length);
    assertEquals(826, currency.getNumericCode());
    assertEquals(RoundingMode.HALF_EVEN, numberFormat.getRoundingMode());
    assertFalse(((DecimalFormat) numberFormat).isDecimalSeparatorAlwaysShown());
    assertFalse(((DecimalFormat) numberFormat).isParseBigDecimal());
    assertFalse(numberFormat.isGroupingUsed());
    assertTrue(actualDateFormat.isLenient());
    assertTrue(numberFormat.isParseIntegerOnly());
    assertTrue(calendar.isLenient());
    assertTrue(calendar.isWeekDateSupported());
    assertEquals(Integer.MAX_VALUE, numberFormat.getMaximumIntegerDigits());
    assertEquals(FormatUtil.DATE_FORMAT, actualDateFormat.toPattern());
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
        "Argentina Time", "ART"}, zoneStrings[594]);
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
        "GMT-06:00", "Central Time", "GMT-06:00"}, zoneStrings[595]);
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

  /**
   * Test {@link FormatUtil#getTimeZoneFormat()}.
   * <p>
   * Method under test: {@link FormatUtil#getTimeZoneFormat()}
   */
  @Test
  public void testGetTimeZoneFormat() {
    // Arrange and Act
    SimpleDateFormat actualTimeZoneFormat = FormatUtil.getTimeZoneFormat();

    // Assert
    NumberFormat numberFormat = actualTimeZoneFormat.getNumberFormat();
    assertTrue(numberFormat instanceof DecimalFormat);
    Calendar calendar = actualTimeZoneFormat.getCalendar();
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
    DateFormatSymbols dateFormatSymbols = actualTimeZoneFormat.getDateFormatSymbols();
    assertEquals("GyMdkHmsSEDFwWahKzZ", dateFormatSymbols.getLocalPatternChars());
    assertEquals("NaN", decimalFormatSymbols.getNaN());
    assertEquals("£", decimalFormatSymbols.getCurrencySymbol());
    assertEquals("£", currency.getSymbol());
    assertEquals("∞", decimalFormatSymbols.getInfinity());
    assertEquals("gregory", calendar.getCalendarType());
    assertEquals('#', decimalFormatSymbols.getDigit());
    assertEquals('%', decimalFormatSymbols.getPercent());
    assertEquals(',', decimalFormatSymbols.getGroupingSeparator());
    assertEquals('-', decimalFormatSymbols.getMinusSign());
    assertEquals('.', decimalFormatSymbols.getDecimalSeparator());
    assertEquals('.', decimalFormatSymbols.getMonetaryDecimalSeparator());
    assertEquals('0', decimalFormatSymbols.getZeroDigit());
    assertEquals(';', decimalFormatSymbols.getPatternSeparator());
    assertEquals('‰', decimalFormatSymbols.getPerMill());
    assertNull(actualTimeZoneFormat.getTimeZone());
    assertNull(calendar.getTimeZone());
    assertEquals(0, numberFormat.getMaximumFractionDigits());
    assertEquals(0, numberFormat.getMinimumFractionDigits());
    assertEquals(1, ((DecimalFormat) numberFormat).getMultiplier());
    assertEquals(1, numberFormat.getMinimumIntegerDigits());
    assertEquals(2, calendar.getFirstDayOfWeek());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(3, ((DecimalFormat) numberFormat).getGroupingSize());
    assertEquals(4, calendar.getMinimalDaysInFirstWeek());
    String[][] zoneStrings = dateFormatSymbols.getZoneStrings();
    assertEquals(601, zoneStrings.length);
    assertEquals(826, currency.getNumericCode());
    assertEquals(RoundingMode.HALF_EVEN, numberFormat.getRoundingMode());
    assertFalse(((DecimalFormat) numberFormat).isDecimalSeparatorAlwaysShown());
    assertFalse(((DecimalFormat) numberFormat).isParseBigDecimal());
    assertFalse(numberFormat.isGroupingUsed());
    assertTrue(actualTimeZoneFormat.isLenient());
    assertTrue(numberFormat.isParseIntegerOnly());
    assertTrue(calendar.isLenient());
    assertTrue(calendar.isWeekDateSupported());
    assertEquals(Integer.MAX_VALUE, numberFormat.getMaximumIntegerDigits());
    assertEquals(FormatUtil.DATE_FORMAT_WITH_TIMEZONE, actualTimeZoneFormat.toPattern());
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
        "Argentina Time", "ART"}, zoneStrings[594]);
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
        "GMT-06:00", "Central Time", "GMT-06:00"}, zoneStrings[595]);
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

  /**
   * Test {@link FormatUtil#formatDateUsingW3C(Date)}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>When {@link java.sql.Date} {@link java.util.Date#getTime()} return
   * ten.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormatUtil#formatDateUsingW3C(java.util.Date)}
   */
  @Test
  public void testFormatDateUsingW3C_givenTen_whenDateGetTimeReturnTen_thenCallsGetTime() {
    // Arrange
    java.sql.Date date = mock(java.sql.Date.class);
    when(date.getTime()).thenReturn(10L);

    // Act
    FormatUtil.formatDateUsingW3C(date);

    // Assert
    verify(date).getTime();
  }

  /**
   * Test {@link FormatUtil#dateToSting(Date, TimeZone)}.
   * <p>
   * Method under test: {@link FormatUtil#dateToSting(Date, TimeZone)}
   */
  @Test
  public void testDateToSting() {
    // Arrange
    Date date = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals("Dec 31, 1969 @ 04:00pm", FormatUtil.dateToSting(date, TimeZone.getTimeZone("America/Los_Angeles")));
  }

  /**
   * Test {@link FormatUtil#dateToSting(Date, TimeZone)}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>When {@link java.sql.Date} {@link java.util.Date#getTime()} return
   * ten.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormatUtil#dateToSting(java.util.Date, TimeZone)}
   */
  @Test
  public void testDateToSting_givenTen_whenDateGetTimeReturnTen_thenCallsGetTime() {
    // Arrange
    java.sql.Date date = mock(java.sql.Date.class);
    when(date.getTime()).thenReturn(10L);

    // Act
    String actualDateToStingResult = FormatUtil.dateToSting(date, TimeZone.getTimeZone("America/Los_Angeles"));

    // Assert
    verify(date).getTime();
    assertEquals("Dec 31, 1969 @ 04:00pm", actualDateToStingResult);
  }
}

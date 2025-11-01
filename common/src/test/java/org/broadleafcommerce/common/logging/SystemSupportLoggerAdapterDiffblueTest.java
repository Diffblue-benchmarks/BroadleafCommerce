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
package org.broadleafcommerce.common.logging;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.junit.Test;

public class SystemSupportLoggerAdapterDiffblueTest {
  /**
   * Method under test: {@link SystemSupportLoggerAdapter#getShowDateTime()}
   */
  @Test
  public void testGetShowDateTime() {
    // Arrange, Act and Assert
    assertTrue((new SystemSupportLoggerAdapter()).getShowDateTime());
  }

  /**
   * Method under test: {@link SystemSupportLoggerAdapter#getDateFormatter()}
   */
  @Test
  public void testGetDateFormatter() {
    // Arrange and Act
    DateFormat actualDateFormatter = (new SystemSupportLoggerAdapter()).getDateFormatter();

    // Assert
    NumberFormat numberFormat = actualDateFormatter.getNumberFormat();
    assertTrue(numberFormat instanceof DecimalFormat);
    assertTrue(actualDateFormatter instanceof SimpleDateFormat);
    Calendar calendar = actualDateFormatter.getCalendar();
    assertTrue(calendar instanceof GregorianCalendar);
    assertEquals("", ((DecimalFormat) numberFormat).getNegativeSuffix());
    assertEquals("", ((DecimalFormat) numberFormat).getPositivePrefix());
    assertEquals("", ((DecimalFormat) numberFormat).getPositiveSuffix());
    assertEquals("###0", ((DecimalFormat) numberFormat).toLocalizedPattern());
    assertEquals("###0", ((DecimalFormat) numberFormat).toPattern());
    assertEquals("-", ((DecimalFormat) numberFormat).getNegativePrefix());
    DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) numberFormat).getDecimalFormatSymbols();
    assertEquals("E", decimalFormatSymbols.getExponentSeparator());
    DateFormatSymbols dateFormatSymbols = ((SimpleDateFormat) actualDateFormatter).getDateFormatSymbols();
    assertEquals("GyMdkHmsSEDFwWahKzZ", dateFormatSymbols.getLocalPatternChars());
    assertEquals("HH:mm:ss", ((SimpleDateFormat) actualDateFormatter).toPattern());
    assertEquals("NaN", decimalFormatSymbols.getNaN());
    Currency currency = numberFormat.getCurrency();
    assertEquals("Unknown Currency", currency.getDisplayName());
    assertEquals("XXX", decimalFormatSymbols.getInternationalCurrencySymbol());
    assertEquals("XXX", currency.getCurrencyCode());
    assertEquals("XXX", currency.toString());
    assertEquals("¤", decimalFormatSymbols.getCurrencySymbol());
    assertEquals("¤", currency.getSymbol());
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
    assertEquals(-1, currency.getDefaultFractionDigits());
    assertEquals(0, numberFormat.getMaximumFractionDigits());
    assertEquals(0, numberFormat.getMinimumFractionDigits());
    TimeZone timeZone = actualDateFormatter.getTimeZone();
    assertEquals(0, timeZone.getDSTSavings());
    assertEquals(1, ((DecimalFormat) numberFormat).getMultiplier());
    assertEquals(1, numberFormat.getMinimumIntegerDigits());
    assertEquals(1, calendar.getFirstDayOfWeek());
    assertEquals(1, calendar.getMinimalDaysInFirstWeek());
    assertEquals(1945, calendar.getWeekYear());
    assertEquals(3, ((DecimalFormat) numberFormat).getGroupingSize());
    assertEquals(52, calendar.getWeeksInWeekYear());
    String[][] zoneStrings = dateFormatSymbols.getZoneStrings();
    assertEquals(602, zoneStrings.length);
    assertEquals(999, currency.getNumericCode());
    assertEquals(RoundingMode.HALF_EVEN, numberFormat.getRoundingMode());
    assertFalse(((DecimalFormat) numberFormat).isDecimalSeparatorAlwaysShown());
    assertFalse(((DecimalFormat) numberFormat).isParseBigDecimal());
    assertFalse(numberFormat.isGroupingUsed());
    assertTrue(actualDateFormatter.isLenient());
    assertTrue(numberFormat.isParseIntegerOnly());
    assertTrue(calendar.isLenient());
    assertTrue(calendar.isWeekDateSupported());
    assertEquals(Integer.MAX_VALUE, numberFormat.getMaximumIntegerDigits());
    assertSame(timeZone, calendar.getTimeZone());
    assertSame(currency, decimalFormatSymbols.getCurrency());
    assertArrayEquals(new String[]{"AM", "PM"}, dateFormatSymbols.getAmPmStrings());
    assertArrayEquals(new String[]{"BC", "AD"}, dateFormatSymbols.getEras());
    assertArrayEquals(new String[]{"ACT", "Australian Central Standard Time", "ACST",
        "Australian Central Daylight Time", "ACDT", "Central Australia Time", "ACT"}, zoneStrings[18]);
    assertArrayEquals(new String[]{"AET", "Australian Eastern Standard Time", "AEST",
        "Australian Eastern Daylight Time", "AEDT", "Eastern Australia Time", "AET"}, zoneStrings[19]);
    assertArrayEquals(new String[]{"ART", "Eastern European Standard Time", "EET", "Eastern European Summer Time",
        "EEST", "Eastern European Time", "EET"}, zoneStrings[AbstractSupportLoggerAdapter.LOG_LEVEL_INFO]);
    assertArrayEquals(
        new String[]{"AST", "Alaska Standard Time", "AKST", "Alaska Daylight Time", "AKDT", "Alaska Time", "AKT"},
        zoneStrings[21]);
    assertArrayEquals(new String[]{"America/Anchorage", "Alaska Standard Time", "AKST", "Alaska Daylight Time", "AKDT",
        "Alaska Time", "AKT"}, zoneStrings[7]);
    assertArrayEquals(new String[]{"America/Argentina/Buenos_Aires", "Argentina Standard Time", "ART",
        "Argentina Summer Time", "ARST", "Argentina Time", "ART"}, zoneStrings[599]);
    assertArrayEquals(new String[]{"America/Argentina/ComodRivadavia", "Argentina Standard Time", "ART",
        "Argentina Summer Time", "ARST", "Argentina Time", "ART"}, zoneStrings[588]);
    assertArrayEquals(new String[]{"America/Chicago", "Central Standard Time", "CST", "Central Daylight Time", "CDT",
        "Central Time", "CT"}, zoneStrings[3]);
    assertArrayEquals(new String[]{"America/Denver", "Mountain Standard Time", "MST", "Mountain Daylight Time", "MDT",
        "Mountain Time", "MT"}, zoneStrings[1]);
    assertArrayEquals(new String[]{"America/Ensenada", "Pacific Standard Time", "PST", "Pacific Daylight Time", "PDT",
        "Pacific Time", "PT"}, zoneStrings[582]);
    assertArrayEquals(new String[]{"America/Halifax", "Atlantic Standard Time", "AST", "Atlantic Daylight Time", "ADT",
        "Atlantic Time", "AT"}, zoneStrings[8]);
    assertArrayEquals(new String[]{"America/Indianapolis", "Eastern Standard Time", "EST", "Eastern Daylight Time",
        "EDT", "Eastern Time", "ET"}, zoneStrings[5]);
    assertArrayEquals(new String[]{"America/Los_Angeles", "Pacific Standard Time", "PST", "Pacific Daylight Time",
        "PDT", "Pacific Time", "PT"}, zoneStrings[0]);
    assertArrayEquals(new String[]{"America/New_York", "Eastern Standard Time", "EST", "Eastern Daylight Time", "EDT",
        "Eastern Time", "ET"}, zoneStrings[4]);
    assertArrayEquals(new String[]{"America/Nuuk", "West Greenland Standard Time", "WGT", "West Greenland Summer Time",
        "WGST", "West Greenland Time", "WGT"}, zoneStrings[591]);
    assertArrayEquals(new String[]{"America/Phoenix", "Mountain Standard Time", "MST", "Mountain Daylight Time", "MDT",
        "Mountain Time", "MT"}, zoneStrings[2]);
    assertArrayEquals(new String[]{"America/Rosario", "Argentina Standard Time", "ART", "Argentina Summer Time", "ARST",
        "Argentina Time", "ART"}, zoneStrings[595]);
    assertArrayEquals(new String[]{"America/Sitka", "Alaska Standard Time", "AKST", "Alaska Daylight Time", "AKDT",
        "Alaska Time", "AKT"}, zoneStrings[9]);
    assertArrayEquals(new String[]{"America/St_Johns", "Newfoundland Standard Time", "NST",
        "Newfoundland Daylight Time", "NDT", "Newfoundland Time", "NT"},
        zoneStrings[AbstractSupportLoggerAdapter.LOG_LEVEL_DEBUG]);
    assertArrayEquals(new String[]{"America/Virgin", "Atlantic Standard Time", "AST", "Atlantic Daylight Time", "ADT",
        "Atlantic Time", "AT"}, zoneStrings[583]);
    assertArrayEquals(new String[]{"Asia/Famagusta", "Eastern European Time", "EET", "Eastern European Summer Time",
        "EEST", "Eastern European Time", "EET"}, zoneStrings[589]);
    assertArrayEquals(new String[]{"Asia/Jerusalem", "Israel Standard Time", "IST", "Israel Daylight Time", "IDT",
        "Israel Time", "IT"}, zoneStrings[13]);
    assertArrayEquals(
        new String[]{"Asia/Shanghai", "China Standard Time", "CST", "China Daylight Time", "CDT", "China Time", "CT"},
        zoneStrings[Short.SIZE]);
    assertArrayEquals(new String[]{"Asia/Srednekolymsk", "Srednekolymsk Time", "SRET", "Srednekolymsk Daylight Time",
        "SREDT", "Srednekolymsk Time", "SRET"}, zoneStrings[598]);
    assertArrayEquals(
        new String[]{"Asia/Tokyo", "Japan Standard Time", "JST", "Japan Daylight Time", "JDT", "Japan Time", "JT"},
        zoneStrings[14]);
    assertArrayEquals(
        new String[]{"BET", "Brasilia Standard Time", "BRT", "Brasilia Summer Time", "BRST", "Brasilia Time", "BRT"},
        zoneStrings[22]);
    assertArrayEquals(new String[]{"BST", "Bangladesh Standard Time", "BDT", "Bangladesh Summer Time", "BDST",
        "Bangladesh Time", "BDT"}, zoneStrings[23]);
    assertArrayEquals(new String[]{"CAT", "Central Africa Time", "CAT", "Central African Summer Time", "CAST",
        "Central Africa Time", "CAT"}, zoneStrings[24]);
    assertArrayEquals(new String[]{"Canada/Saskatchewan", "Central Standard Time", "CST", "Central Daylight Time",
        "CDT", "Central Time", "CT"}, zoneStrings[596]);
    assertArrayEquals(new String[]{"EET", "Eastern European Time", "EET", "Eastern European Summer Time", "EEST",
        "Eastern European Time", "EET"}, zoneStrings[594]);
    assertArrayEquals(new String[]{"Egypt", "Eastern European Standard Time", "EET", "Eastern European Summer Time",
        "EEST", "Eastern European Time", "EET"}, zoneStrings[597]);
    assertArrayEquals(new String[]{"Etc/Greenwich", "Greenwich Mean Time", "GMT", "Greenwich Mean Time", "GMT",
        "Greenwich Mean Time", "GMT"}, zoneStrings[581]);
    assertArrayEquals(new String[]{"Europe/Astrakhan", "Astrakhan Standard Time", "GMT+04:00",
        "Astrakhan Standard Time", "GMT+04:00", "Astrakhan Time", "GMT+04:00"}, zoneStrings[580]);
    assertArrayEquals(new String[]{"Europe/Bucharest", "Eastern European Standard Time", "EET",
        "Eastern European Summer Time", "EEST", "Eastern European Time", "EET"}, zoneStrings[15]);
    assertArrayEquals(new String[]{"Europe/Kyiv", "Eastern European Standard Time", "EET",
        "Eastern European Summer Time", "EEST", "Eastern European Time", "EET"}, zoneStrings[585]);
    assertArrayEquals(new String[]{"Europe/Nicosia", "Eastern European Standard Time", "EET",
        "Eastern European Summer Time", "EEST", "Eastern European Time", "EET"}, zoneStrings[600]);
    assertArrayEquals(new String[]{"Europe/Paris", "Central European Standard Time", "CET",
        "Central European Summer Time", "CEST", "Central European Time", "CET"}, zoneStrings[11]);
    assertArrayEquals(new String[]{"Europe/Ulyanovsk", "Ulyanovsk Standard Time", "GMT+04:00",
        "Ulyanovsk Standard Time", "GMT+04:00", "Ulyanovsk Time", "GMT+04:00"}, zoneStrings[592]);
    assertArrayEquals(
        new String[]{"GMT", "Greenwich Mean Time", "GMT", "Greenwich Mean Time", "GMT", "Greenwich Mean Time", "GMT"},
        zoneStrings[12]);
    assertArrayEquals(new String[]{"Hongkong", "Hong Kong Standard Time", "HKT", "Hong Kong Summer Time", "HKST",
        "Hong Kong Time", "HKT"}, zoneStrings[586]);
    assertArrayEquals(
        new String[]{"Jamaica", "Eastern Standard Time", "EST", "Eastern Daylight Time", "EDT", "Eastern Time", "ET"},
        zoneStrings[578]);
    assertArrayEquals(
        new String[]{"Japan", "Japan Standard Time", "JST", "Japan Daylight Time", "JDT", "Japan Time", "JT"},
        zoneStrings[590]);
    assertArrayEquals(new String[]{"MST", "Mountain Standard Time", "MST", "Mountain Standard Time", "MST",
        "Mountain Standard Time", "MST"}, zoneStrings[584]);
    assertArrayEquals(new String[]{"Pacific/Honolulu", "Hawaii-Aleutian Standard Time", "HST",
        "Hawaii-Aleutian Daylight Time", "HDT", "Hawaii-Aleutian Time", "HST"}, zoneStrings[6]);
    assertArrayEquals(new String[]{"Turkey", "Turkey Time", "TRT", "Turkey Summer Time", "TRST", "Turkey Time", "TRT"},
        zoneStrings[577]);
    assertArrayEquals(new String[]{"UCT", "Coordinated Universal Time", "UTC", "Coordinated Universal Time", "UTC",
        "Coordinated Universal Time", "UTC"}, zoneStrings[587]);
    assertArrayEquals(new String[]{"US/Pacific", "Pacific Standard Time", "PST", "Pacific Daylight Time", "PDT",
        "Pacific Time", "PT"}, zoneStrings[601]);
    assertArrayEquals(new String[]{"UTC", "Coordinated Universal Time", "UTC", "Coordinated Universal Time", "UTC",
        "Coordinated Universal Time", "UTC"}, zoneStrings[17]);
    assertArrayEquals(
        new String[]{"W-SU", "Moscow Standard Time", "MSK", "Moscow Summer Time", "MSD", "Moscow Time", "MT"},
        zoneStrings[593]);
    assertArrayEquals(new String[]{"WET", "Western European Time", "WET", "Western European Summer Time", "WEST",
        "Western European Time", "WET"}, zoneStrings[579]);
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
   * Method under test: {@link SystemSupportLoggerAdapter#getShowThreadName()}
   */
  @Test
  public void testGetShowThreadName() {
    // Arrange, Act and Assert
    assertFalse((new SystemSupportLoggerAdapter()).getShowThreadName());
  }

  /**
   * Method under test: {@link SystemSupportLoggerAdapter#getShowLogName()}
   */
  @Test
  public void testGetShowLogName() {
    // Arrange, Act and Assert
    assertTrue((new SystemSupportLoggerAdapter()).getShowLogName());
  }

  /**
   * Method under test: {@link SystemSupportLoggerAdapter#getLevelInBrackets()}
   */
  @Test
  public void testGetLevelInBrackets() {
    // Arrange, Act and Assert
    assertTrue((new SystemSupportLoggerAdapter()).getLevelInBrackets());
  }

  /**
   * Method under test:
   * {@link SystemSupportLoggerAdapter#getShowNonSupportLevels()}
   */
  @Test
  public void testGetShowNonSupportLevels() {
    // Arrange, Act and Assert
    assertFalse((new SystemSupportLoggerAdapter()).getShowNonSupportLevels());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link SystemSupportLoggerAdapter}
   *   <li>{@link SystemSupportLoggerAdapter#setName(String)}
   *   <li>{@link SystemSupportLoggerAdapter#getName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SystemSupportLoggerAdapter actualSystemSupportLoggerAdapter = new SystemSupportLoggerAdapter();
    actualSystemSupportLoggerAdapter.setName("Name");

    // Assert that nothing has changed
    assertEquals("Name", actualSystemSupportLoggerAdapter.getName());
  }
}

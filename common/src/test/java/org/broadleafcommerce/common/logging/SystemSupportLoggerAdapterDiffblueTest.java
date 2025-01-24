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
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {SystemSupportLoggerAdapter.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SystemSupportLoggerAdapterDiffblueTest {
  @Autowired
  private SystemSupportLoggerAdapter systemSupportLoggerAdapter;

  /**
   * Test {@link SystemSupportLoggerAdapter#support(String)} with {@code message}.
   * <p>
   * Method under test: {@link SystemSupportLoggerAdapter#support(String)}
   */
  @Test
  public void testSupportWithMessage() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    systemSupportLoggerAdapter.support("Not all who wander are lost");
  }

  /**
   * Test {@link SystemSupportLoggerAdapter#support(String, Throwable)} with
   * {@code message}, {@code t}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemSupportLoggerAdapter#support(String, Throwable)}
   */
  @Test
  public void testSupportWithMessageT_whenThrowable() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    systemSupportLoggerAdapter.support("Not all who wander are lost", new Throwable());
  }

  /**
   * Test {@link SystemSupportLoggerAdapter#lifecycle(LifeCycleEvent, String)}.
   * <p>
   * Method under test:
   * {@link SystemSupportLoggerAdapter#lifecycle(LifeCycleEvent, String)}
   */
  @Test
  public void testLifecycle() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    systemSupportLoggerAdapter.lifecycle(LifeCycleEvent.START, "Not all who wander are lost");
  }

  /**
   * Test {@link SystemSupportLoggerAdapter#debug(String)} with {@code message}.
   * <p>
   * Method under test: {@link SystemSupportLoggerAdapter#debug(String)}
   */
  @Test
  public void testDebugWithMessage() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    systemSupportLoggerAdapter.debug("Not all who wander are lost");
  }

  /**
   * Test {@link SystemSupportLoggerAdapter#debug(String, Throwable)} with
   * {@code message}, {@code t}.
   * <p>
   * Method under test:
   * {@link SystemSupportLoggerAdapter#debug(String, Throwable)}
   */
  @Test
  public void testDebugWithMessageT() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    systemSupportLoggerAdapter.debug("Not all who wander are lost", new Throwable());
  }

  /**
   * Test {@link SystemSupportLoggerAdapter#error(String)} with {@code message}.
   * <p>
   * Method under test: {@link SystemSupportLoggerAdapter#error(String)}
   */
  @Test
  public void testErrorWithMessage() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    systemSupportLoggerAdapter.error("Not all who wander are lost");
  }

  /**
   * Test {@link SystemSupportLoggerAdapter#error(String, Throwable)} with
   * {@code message}, {@code t}.
   * <p>
   * Method under test:
   * {@link SystemSupportLoggerAdapter#error(String, Throwable)}
   */
  @Test
  public void testErrorWithMessageT() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    systemSupportLoggerAdapter.error("Not all who wander are lost", new Throwable());
  }

  /**
   * Test {@link SystemSupportLoggerAdapter#fatal(String)} with {@code message}.
   * <p>
   * Method under test: {@link SystemSupportLoggerAdapter#fatal(String)}
   */
  @Test
  public void testFatalWithMessage() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    systemSupportLoggerAdapter.fatal("Not all who wander are lost");
  }

  /**
   * Test {@link SystemSupportLoggerAdapter#fatal(String, Throwable)} with
   * {@code message}, {@code t}.
   * <p>
   * Method under test:
   * {@link SystemSupportLoggerAdapter#fatal(String, Throwable)}
   */
  @Test
  public void testFatalWithMessageT() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    systemSupportLoggerAdapter.fatal("Not all who wander are lost", new Throwable());
  }

  /**
   * Test {@link SystemSupportLoggerAdapter#info(String)} with {@code message}.
   * <p>
   * Method under test: {@link SystemSupportLoggerAdapter#info(String)}
   */
  @Test
  public void testInfoWithMessage() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    systemSupportLoggerAdapter.info("Not all who wander are lost");
  }

  /**
   * Test {@link SystemSupportLoggerAdapter#info(String, Throwable)} with
   * {@code message}, {@code t}.
   * <p>
   * Method under test: {@link SystemSupportLoggerAdapter#info(String, Throwable)}
   */
  @Test
  public void testInfoWithMessageT() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    systemSupportLoggerAdapter.info("Not all who wander are lost", new Throwable());
  }

  /**
   * Test {@link SystemSupportLoggerAdapter#warn(String)} with {@code message}.
   * <p>
   * Method under test: {@link SystemSupportLoggerAdapter#warn(String)}
   */
  @Test
  public void testWarnWithMessage() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    systemSupportLoggerAdapter.warn("Not all who wander are lost");
  }

  /**
   * Test {@link SystemSupportLoggerAdapter#warn(String, Throwable)} with
   * {@code message}, {@code t}.
   * <p>
   * Method under test: {@link SystemSupportLoggerAdapter#warn(String, Throwable)}
   */
  @Test
  public void testWarnWithMessageT() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    systemSupportLoggerAdapter.warn("Not all who wander are lost", new Throwable());
  }

  /**
   * Test {@link SystemSupportLoggerAdapter#log(int, String, Throwable)}.
   * <ul>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemSupportLoggerAdapter#log(int, String, Throwable)}
   */
  @Test
  public void testLog_whenOne() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    systemSupportLoggerAdapter.log(1, "Not all who wander are lost", new Throwable());
  }

  /**
   * Test {@link SystemSupportLoggerAdapter#write(StringBuffer, Throwable)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemSupportLoggerAdapter#write(StringBuffer, Throwable)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testWrite_whenNull() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.logging.SystemSupportLoggerAdapter.write(SystemSupportLoggerAdapter.java:234)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    SystemSupportLoggerAdapter systemSupportLoggerAdapter = new SystemSupportLoggerAdapter();

    // Act
    systemSupportLoggerAdapter.write(null, new Throwable());
  }

  /**
   * Test {@link SystemSupportLoggerAdapter#write(StringBuffer, Throwable)}.
   * <ul>
   *   <li>When {@link StringBuffer#StringBuffer(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemSupportLoggerAdapter#write(StringBuffer, Throwable)}
   */
  @Test
  public void testWrite_whenStringBufferWithFoo() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    SystemSupportLoggerAdapter systemSupportLoggerAdapter = new SystemSupportLoggerAdapter();
    StringBuffer buf = new StringBuffer("foo");

    // Act
    systemSupportLoggerAdapter.write(buf, new Throwable());
  }

  /**
   * Test {@link SystemSupportLoggerAdapter#getFormattedDate()}.
   * <p>
   * Method under test: {@link SystemSupportLoggerAdapter#getFormattedDate()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetFormattedDate() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Method may be time-sensitive.
    //   Diffblue Cover was only able to write tests that are time-sensitive.
    //   The assertions don't pass when run at an alternate date, time, and
    //   timezone. Try refactoring the method to take a 'java.time.Clock' instance so
    //   that the time can be parameterized during testing.
    //   See Working with code R031 (https://diff.blue/R031) for details.

    // Arrange and Act
    (new SystemSupportLoggerAdapter()).getFormattedDate();
  }

  /**
   * Test {@link SystemSupportLoggerAdapter#getShowDateTime()}.
   * <p>
   * Method under test: {@link SystemSupportLoggerAdapter#getShowDateTime()}
   */
  @Test
  public void testGetShowDateTime() {
    // Arrange, Act and Assert
    assertTrue((new SystemSupportLoggerAdapter()).getShowDateTime());
  }

  /**
   * Test {@link SystemSupportLoggerAdapter#getDateFormatter()}.
   * <p>
   * Method under test: {@link SystemSupportLoggerAdapter#getDateFormatter()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetDateFormatter() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

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
    Currency currency = numberFormat.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) numberFormat).getDecimalFormatSymbols();
    assertEquals("E", decimalFormatSymbols.getExponentSeparator());
    assertEquals("GBP", decimalFormatSymbols.getInternationalCurrencySymbol());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    DateFormatSymbols dateFormatSymbols = ((SimpleDateFormat) actualDateFormatter).getDateFormatSymbols();
    assertEquals("GyMdkHmsSEDFwWahKzZ", dateFormatSymbols.getLocalPatternChars());
    assertEquals("HH:mm:ss", ((SimpleDateFormat) actualDateFormatter).toPattern());
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
    assertEquals(0, numberFormat.getMaximumFractionDigits());
    assertEquals(0, numberFormat.getMinimumFractionDigits());
    TimeZone timeZone = actualDateFormatter.getTimeZone();
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
    assertTrue(actualDateFormatter.isLenient());
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
        "Western European Summer Time", "WEST", "Western European Time", "WET"},
        zoneStrings[AbstractSupportLoggerAdapter.LOG_LEVEL_INFO]);
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
        "Western European Summer Time", "WEST", "Western European Time", "WET"},
        zoneStrings[AbstractSupportLoggerAdapter.LOG_LEVEL_DEBUG]);
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
   * Test {@link SystemSupportLoggerAdapter#getShowThreadName()}.
   * <p>
   * Method under test: {@link SystemSupportLoggerAdapter#getShowThreadName()}
   */
  @Test
  public void testGetShowThreadName() {
    // Arrange, Act and Assert
    assertFalse((new SystemSupportLoggerAdapter()).getShowThreadName());
  }

  /**
   * Test {@link SystemSupportLoggerAdapter#getShowLogName()}.
   * <p>
   * Method under test: {@link SystemSupportLoggerAdapter#getShowLogName()}
   */
  @Test
  public void testGetShowLogName() {
    // Arrange, Act and Assert
    assertTrue((new SystemSupportLoggerAdapter()).getShowLogName());
  }

  /**
   * Test {@link SystemSupportLoggerAdapter#getLevelInBrackets()}.
   * <p>
   * Method under test: {@link SystemSupportLoggerAdapter#getLevelInBrackets()}
   */
  @Test
  public void testGetLevelInBrackets() {
    // Arrange, Act and Assert
    assertTrue((new SystemSupportLoggerAdapter()).getLevelInBrackets());
  }

  /**
   * Test {@link SystemSupportLoggerAdapter#getShowNonSupportLevels()}.
   * <p>
   * Method under test:
   * {@link SystemSupportLoggerAdapter#getShowNonSupportLevels()}
   */
  @Test
  public void testGetShowNonSupportLevels() {
    // Arrange, Act and Assert
    assertFalse((new SystemSupportLoggerAdapter()).getShowNonSupportLevels());
  }

  /**
   * Test getters and setters.
   * <p>
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

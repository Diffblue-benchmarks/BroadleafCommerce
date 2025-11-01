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
package org.broadleafcommerce.common.time;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import org.junit.Test;

public class SystemTimeDiffblueTest {
  /**
   * Method under test: {@link SystemTime#getTimeSource()}
   */
  @Test
  public void testGetTimeSource() {
    // Arrange and Act
    TimeSource actualTimeSource = SystemTime.getTimeSource();
    actualTimeSource.timeInMillis();

    // Assert
    assertTrue(actualTimeSource instanceof DefaultTimeSource);
  }

  /**
   * Method under test: {@link SystemTime#asCalendar()}
   */
  @Test
  public void testAsCalendar() {
    // Arrange and Act
    Calendar actualAsCalendarResult = SystemTime.asCalendar();

    // Assert
    assertTrue(actualAsCalendarResult instanceof GregorianCalendar);
    assertEquals("gregory", actualAsCalendarResult.getCalendarType());
    assertEquals(0, actualAsCalendarResult.getTimeZone().getDSTSavings());
    assertEquals(1, actualAsCalendarResult.getFirstDayOfWeek());
    assertEquals(1, actualAsCalendarResult.getMinimalDaysInFirstWeek());
    assertEquals(52, actualAsCalendarResult.getWeeksInWeekYear());
    assertTrue(actualAsCalendarResult.isLenient());
    assertTrue(actualAsCalendarResult.isWeekDateSupported());
  }

  /**
   * Method under test: {@link SystemTime#asCalendar(Locale)}
   */
  @Test
  public void testAsCalendar2() {
    // Arrange and Act
    Calendar actualAsCalendarResult = SystemTime.asCalendar(Locale.getDefault());

    // Assert
    assertTrue(actualAsCalendarResult instanceof GregorianCalendar);
    assertEquals("gregory", actualAsCalendarResult.getCalendarType());
    assertEquals(0, actualAsCalendarResult.getTimeZone().getDSTSavings());
    assertEquals(1, actualAsCalendarResult.getFirstDayOfWeek());
    assertEquals(1, actualAsCalendarResult.getMinimalDaysInFirstWeek());
    assertEquals(52, actualAsCalendarResult.getWeeksInWeekYear());
    assertTrue(actualAsCalendarResult.isLenient());
    assertTrue(actualAsCalendarResult.isWeekDateSupported());
  }

  /**
   * Method under test: {@link SystemTime#asCalendar(Locale, TimeZone, boolean)}
   */
  @Test
  public void testAsCalendar3() {
    // Arrange
    Locale locale = Locale.getDefault();
    TimeZone timeZone = TimeZone.getTimeZone("America/Los_Angeles");

    // Act
    Calendar actualAsCalendarResult = SystemTime.asCalendar(locale, timeZone, true);

    // Assert
    assertTrue(actualAsCalendarResult instanceof GregorianCalendar);
    assertEquals("gregory", actualAsCalendarResult.getCalendarType());
    assertEquals(1, actualAsCalendarResult.getFirstDayOfWeek());
    assertEquals(1, actualAsCalendarResult.getMinimalDaysInFirstWeek());
    assertEquals(52, actualAsCalendarResult.getWeeksInWeekYear());
    assertTrue(actualAsCalendarResult.isLenient());
    assertTrue(actualAsCalendarResult.isWeekDateSupported());
    assertSame(timeZone, actualAsCalendarResult.getTimeZone());
  }

  /**
   * Method under test: {@link SystemTime#asCalendar(Locale, TimeZone, boolean)}
   */
  @Test
  public void testAsCalendar4() {
    // Arrange
    Locale locale = Locale.getDefault();
    TimeZone timeZone = TimeZone.getTimeZone("America/Los_Angeles");

    // Act
    Calendar actualAsCalendarResult = SystemTime.asCalendar(locale, timeZone, false);

    // Assert
    assertTrue(actualAsCalendarResult instanceof GregorianCalendar);
    assertEquals("gregory", actualAsCalendarResult.getCalendarType());
    assertEquals(1, actualAsCalendarResult.getFirstDayOfWeek());
    assertEquals(1, actualAsCalendarResult.getMinimalDaysInFirstWeek());
    assertEquals(52, actualAsCalendarResult.getWeeksInWeekYear());
    assertTrue(actualAsCalendarResult.isLenient());
    assertTrue(actualAsCalendarResult.isWeekDateSupported());
    assertSame(timeZone, actualAsCalendarResult.getTimeZone());
  }

  /**
   * Method under test: {@link SystemTime#asCalendar(TimeZone)}
   */
  @Test
  public void testAsCalendar5() {
    // Arrange
    TimeZone timeZone = TimeZone.getTimeZone("America/Los_Angeles");

    // Act
    Calendar actualAsCalendarResult = SystemTime.asCalendar(timeZone);

    // Assert
    assertTrue(actualAsCalendarResult instanceof GregorianCalendar);
    assertEquals("gregory", actualAsCalendarResult.getCalendarType());
    assertEquals(1, actualAsCalendarResult.getFirstDayOfWeek());
    assertEquals(1, actualAsCalendarResult.getMinimalDaysInFirstWeek());
    assertEquals(52, actualAsCalendarResult.getWeeksInWeekYear());
    assertTrue(actualAsCalendarResult.isLenient());
    assertTrue(actualAsCalendarResult.isWeekDateSupported());
    assertSame(timeZone, actualAsCalendarResult.getTimeZone());
  }

  /**
   * Method under test: {@link SystemTime#asCalendar(boolean)}
   */
  @Test
  public void testAsCalendar6() {
    // Arrange and Act
    Calendar actualAsCalendarResult = SystemTime.asCalendar(true);

    // Assert
    assertTrue(actualAsCalendarResult instanceof GregorianCalendar);
    assertEquals("gregory", actualAsCalendarResult.getCalendarType());
    assertEquals(0, actualAsCalendarResult.getTimeZone().getDSTSavings());
    assertEquals(1, actualAsCalendarResult.getFirstDayOfWeek());
    assertEquals(1, actualAsCalendarResult.getMinimalDaysInFirstWeek());
    assertEquals(52, actualAsCalendarResult.getWeeksInWeekYear());
    assertTrue(actualAsCalendarResult.isLenient());
    assertTrue(actualAsCalendarResult.isWeekDateSupported());
  }

  /**
   * Method under test: {@link SystemTime#asCalendar(boolean)}
   */
  @Test
  public void testAsCalendar7() {
    // Arrange and Act
    Calendar actualAsCalendarResult = SystemTime.asCalendar(false);

    // Assert
    assertTrue(actualAsCalendarResult instanceof GregorianCalendar);
    assertEquals("gregory", actualAsCalendarResult.getCalendarType());
    assertEquals(0, actualAsCalendarResult.getTimeZone().getDSTSavings());
    assertEquals(1, actualAsCalendarResult.getFirstDayOfWeek());
    assertEquals(1, actualAsCalendarResult.getMinimalDaysInFirstWeek());
    assertEquals(52, actualAsCalendarResult.getWeeksInWeekYear());
    assertTrue(actualAsCalendarResult.isLenient());
    assertTrue(actualAsCalendarResult.isWeekDateSupported());
  }

  /**
   * Method under test: {@link SystemTime#shouldCacheDate()}
   */
  @Test
  public void testShouldCacheDate() {
    // Arrange, Act and Assert
    assertTrue(SystemTime.shouldCacheDate());
  }

  /**
   * Method under test:
   * {@link SystemTime#getCurrentDateWithinTimeResolution(java.util.Date, Long)}
   */
  @Test
  public void testGetCurrentDateWithinTimeResolution() {
    // Arrange
    java.sql.Date cachedDate = mock(java.sql.Date.class);
    when(cachedDate.getTime()).thenReturn(10L);

    // Act
    SystemTime.getCurrentDateWithinTimeResolution(cachedDate, 1L);

    // Assert
    verify(cachedDate).getTime();
  }
}

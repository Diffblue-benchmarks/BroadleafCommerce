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
   * Test {@link SystemTime#getTimeSource()}.
   * <p>
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
   * Test {@link SystemTime#asCalendar(Locale, TimeZone, boolean)} with
   * {@code locale}, {@code timeZone}, {@code includeTime}.
   * <ul>
   *   <li>Then return {@link GregorianCalendar}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemTime#asCalendar(Locale, TimeZone, boolean)}
   */
  @Test
  public void testAsCalendarWithLocaleTimeZoneIncludeTime_thenReturnGregorianCalendar() {
    // Arrange
    Locale locale = Locale.getDefault();
    TimeZone timeZone = TimeZone.getTimeZone("America/Los_Angeles");

    // Act
    Calendar actualAsCalendarResult = SystemTime.asCalendar(locale, timeZone, true);

    // Assert
    assertTrue(actualAsCalendarResult instanceof GregorianCalendar);
    assertEquals("gregory", actualAsCalendarResult.getCalendarType());
    assertEquals(2, actualAsCalendarResult.getFirstDayOfWeek());
    assertEquals(4, actualAsCalendarResult.getMinimalDaysInFirstWeek());
    assertTrue(actualAsCalendarResult.isLenient());
    assertTrue(actualAsCalendarResult.isWeekDateSupported());
    assertSame(timeZone, actualAsCalendarResult.getTimeZone());
  }

  /**
   * Test {@link SystemTime#asCalendar(Locale, TimeZone, boolean)} with
   * {@code locale}, {@code timeZone}, {@code includeTime}.
   * <ul>
   *   <li>When {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemTime#asCalendar(Locale, TimeZone, boolean)}
   */
  @Test
  public void testAsCalendarWithLocaleTimeZoneIncludeTime_whenFalse() {
    // Arrange
    Locale locale = Locale.getDefault();
    TimeZone timeZone = TimeZone.getTimeZone("America/Los_Angeles");

    // Act
    Calendar actualAsCalendarResult = SystemTime.asCalendar(locale, timeZone, false);

    // Assert
    assertTrue(actualAsCalendarResult instanceof GregorianCalendar);
    assertEquals("gregory", actualAsCalendarResult.getCalendarType());
    assertEquals(2, actualAsCalendarResult.getFirstDayOfWeek());
    assertEquals(4, actualAsCalendarResult.getMinimalDaysInFirstWeek());
    assertTrue(actualAsCalendarResult.isLenient());
    assertTrue(actualAsCalendarResult.isWeekDateSupported());
    assertSame(timeZone, actualAsCalendarResult.getTimeZone());
  }

  /**
   * Test {@link SystemTime#asCalendar(TimeZone)} with {@code timeZone}.
   * <ul>
   *   <li>Then return {@link GregorianCalendar}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemTime#asCalendar(TimeZone)}
   */
  @Test
  public void testAsCalendarWithTimeZone_thenReturnGregorianCalendar() {
    // Arrange
    TimeZone timeZone = TimeZone.getTimeZone("America/Los_Angeles");

    // Act
    Calendar actualAsCalendarResult = SystemTime.asCalendar(timeZone);

    // Assert
    assertTrue(actualAsCalendarResult instanceof GregorianCalendar);
    assertEquals("gregory", actualAsCalendarResult.getCalendarType());
    assertEquals(2, actualAsCalendarResult.getFirstDayOfWeek());
    assertEquals(4, actualAsCalendarResult.getMinimalDaysInFirstWeek());
    assertTrue(actualAsCalendarResult.isLenient());
    assertTrue(actualAsCalendarResult.isWeekDateSupported());
    assertSame(timeZone, actualAsCalendarResult.getTimeZone());
  }

  /**
   * Test {@link SystemTime#shouldCacheDate()}.
   * <p>
   * Method under test: {@link SystemTime#shouldCacheDate()}
   */
  @Test
  public void testShouldCacheDate() {
    // Arrange, Act and Assert
    assertTrue(SystemTime.shouldCacheDate());
  }

  /**
   * Test {@link SystemTime#getCurrentDateWithinTimeResolution(Date, Long)}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SystemTime#getCurrentDateWithinTimeResolution(java.util.Date, Long)}
   */
  @Test
  public void testGetCurrentDateWithinTimeResolution_givenTen_thenCallsGetTime() {
    // Arrange
    java.sql.Date cachedDate = mock(java.sql.Date.class);
    when(cachedDate.getTime()).thenReturn(10L);

    // Act
    SystemTime.getCurrentDateWithinTimeResolution(cachedDate, 1L);

    // Assert
    verify(cachedDate).getTime();
  }
}

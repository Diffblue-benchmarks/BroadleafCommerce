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
import org.junit.Ignore;
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
   * Test {@link SystemTime#resetGlobalTimeSource()}.
   * <p>
   * Method under test: {@link SystemTime#resetGlobalTimeSource()}
   */
  @Test
  public void testResetGlobalTimeSource() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    SystemTime.resetGlobalTimeSource();
  }

  /**
   * Test {@link SystemTime#setLocalTimeSource(TimeSource)}.
   * <p>
   * Method under test: {@link SystemTime#setLocalTimeSource(TimeSource)}
   */
  @Test
  public void testSetLocalTimeSource() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    SystemTime.setLocalTimeSource(mock(TimeSource.class));
  }

  /**
   * Test {@link SystemTime#resetLocalTimeSource()}.
   * <p>
   * Method under test: {@link SystemTime#resetLocalTimeSource()}
   */
  @Test
  public void testResetLocalTimeSource() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    SystemTime.resetLocalTimeSource();
  }

  /**
   * Test {@link SystemTime#reset()}.
   * <p>
   * Method under test: {@link SystemTime#reset()}
   */
  @Test
  public void testReset() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    SystemTime.reset();
  }

  /**
   * Test {@link SystemTime#asMillis()}.
   * <p>
   * Method under test: {@link SystemTime#asMillis()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAsMillis() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Method may be time-sensitive.
    //   Diffblue Cover was only able to write tests that are time-sensitive.
    //   The assertions don't pass when run at an alternate date, time, and
    //   timezone. Try refactoring the method to take a 'java.time.Clock' instance so
    //   that the time can be parameterized during testing.
    //   See Working with code R031 (https://diff.blue/R031) for details.

    // Arrange and Act
    SystemTime.asMillis();
  }

  /**
   * Test {@link SystemTime#asMillis(boolean)} with {@code boolean}.
   * <ul>
   *   <li>When {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemTime#asMillis(boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAsMillisWithBoolean_whenTrue() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Method may be time-sensitive.
    //   Diffblue Cover was only able to write tests that are time-sensitive.
    //   The assertions don't pass when run at an alternate date, time, and
    //   timezone. Try refactoring the method to take a 'java.time.Clock' instance so
    //   that the time can be parameterized during testing.
    //   See Working with code R031 (https://diff.blue/R031) for details.

    // Arrange and Act
    SystemTime.asMillis(true);
  }

  /**
   * Test {@link SystemTime#asDate()}.
   * <p>
   * Method under test: {@link SystemTime#asDate()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAsDate() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Method may be time-sensitive.
    //   Diffblue Cover was only able to write tests that are time-sensitive.
    //   The assertions don't pass when run at an alternate date, time, and
    //   timezone. Try refactoring the method to take a 'java.time.Clock' instance so
    //   that the time can be parameterized during testing.
    //   See Working with code R031 (https://diff.blue/R031) for details.

    // Arrange and Act
    SystemTime.asDate();
  }

  /**
   * Test {@link SystemTime#asDate(boolean)} with {@code boolean}.
   * <ul>
   *   <li>When {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemTime#asDate(boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAsDateWithBoolean_whenTrue() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Method may be time-sensitive.
    //   Diffblue Cover was only able to write tests that are time-sensitive.
    //   The assertions don't pass when run at an alternate date, time, and
    //   timezone. Try refactoring the method to take a 'java.time.Clock' instance so
    //   that the time can be parameterized during testing.
    //   See Working with code R031 (https://diff.blue/R031) for details.

    // Arrange and Act
    SystemTime.asDate(true);
  }

  /**
   * Test {@link SystemTime#asCalendar()}.
   * <p>
   * Method under test: {@link SystemTime#asCalendar()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAsCalendar() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    Calendar actualAsCalendarResult = SystemTime.asCalendar();

    // Assert
    assertTrue(actualAsCalendarResult instanceof GregorianCalendar);
    assertEquals("gregory", actualAsCalendarResult.getCalendarType());
    assertEquals(0, actualAsCalendarResult.getTimeZone().getDSTSavings());
    assertEquals(2, actualAsCalendarResult.getFirstDayOfWeek());
    assertEquals(4, actualAsCalendarResult.getMinimalDaysInFirstWeek());
    assertTrue(actualAsCalendarResult.isLenient());
    assertTrue(actualAsCalendarResult.isWeekDateSupported());
  }

  /**
   * Test {@link SystemTime#asCalendar(boolean)} with {@code includeTime}.
   * <ul>
   *   <li>When {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemTime#asCalendar(boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAsCalendarWithIncludeTime_whenTrue() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    Calendar actualAsCalendarResult = SystemTime.asCalendar(true);

    // Assert
    assertTrue(actualAsCalendarResult instanceof GregorianCalendar);
    assertEquals("gregory", actualAsCalendarResult.getCalendarType());
    assertEquals(0, actualAsCalendarResult.getTimeZone().getDSTSavings());
    assertEquals(2, actualAsCalendarResult.getFirstDayOfWeek());
    assertEquals(4, actualAsCalendarResult.getMinimalDaysInFirstWeek());
    assertTrue(actualAsCalendarResult.isLenient());
    assertTrue(actualAsCalendarResult.isWeekDateSupported());
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
   * Test {@link SystemTime#asCalendar(Locale)} with {@code locale}.
   * <ul>
   *   <li>When Default.</li>
   *   <li>Then return {@link GregorianCalendar}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemTime#asCalendar(Locale)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAsCalendarWithLocale_whenDefault_thenReturnGregorianCalendar() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    Calendar actualAsCalendarResult = SystemTime.asCalendar(Locale.getDefault());

    // Assert
    assertTrue(actualAsCalendarResult instanceof GregorianCalendar);
    assertEquals("gregory", actualAsCalendarResult.getCalendarType());
    assertEquals(0, actualAsCalendarResult.getTimeZone().getDSTSavings());
    assertEquals(2, actualAsCalendarResult.getFirstDayOfWeek());
    assertEquals(4, actualAsCalendarResult.getMinimalDaysInFirstWeek());
    assertTrue(actualAsCalendarResult.isLenient());
    assertTrue(actualAsCalendarResult.isWeekDateSupported());
  }

  /**
   * Test {@link SystemTime#asCalendar(Locale)} with {@code locale}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemTime#asCalendar(Locale)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAsCalendarWithLocale_whenNull() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at java.base/java.util.concurrent.ConcurrentHashMap.get(ConcurrentHashMap.java:936)
    //       at java.base/sun.util.locale.provider.LocaleProviderAdapter.getAdapter(LocaleProviderAdapter.java:241)
    //       at java.base/java.util.Calendar.createCalendar(Calendar.java:1692)
    //       at java.base/java.util.Calendar.getInstance(Calendar.java:1675)
    //       at org.broadleafcommerce.common.time.SystemTime.asCalendar(SystemTime.java:143)
    //       at org.broadleafcommerce.common.time.SystemTime.asCalendar(SystemTime.java:98)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    SystemTime.asCalendar((Locale) null);
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

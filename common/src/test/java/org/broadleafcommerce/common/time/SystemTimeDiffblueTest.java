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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SystemTimeDiffblueTest {
  /**
   * Test {@link SystemTime#getTimeSource()}.
   * <p>
   * Method under test: {@link SystemTime#getTimeSource()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TimeSource SystemTime.getTimeSource()"})
  public void testGetTimeSource() {
    // Arrange and Act
    TimeSource actualTimeSource = SystemTime.getTimeSource();
    actualTimeSource.timeInMillis();

    // Assert
    assertTrue(actualTimeSource instanceof DefaultTimeSource);
  }

  /**
   * Test {@link SystemTime#asCalendar()}.
   * <p>
   * Method under test: {@link SystemTime#asCalendar()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Calendar SystemTime.asCalendar()"})
  public void testAsCalendar() {
    // Arrange and Act
    Calendar actualAsCalendarResult = SystemTime.asCalendar();

    // Assert
    assertTrue(actualAsCalendarResult instanceof GregorianCalendar);
    assertEquals("gregory", actualAsCalendarResult.getCalendarType());
    assertEquals(2, actualAsCalendarResult.getFirstDayOfWeek());
    assertEquals(4, actualAsCalendarResult.getMinimalDaysInFirstWeek());
    assertTrue(actualAsCalendarResult.isLenient());
    assertTrue(actualAsCalendarResult.isWeekDateSupported());
  }

  /**
   * Test {@link SystemTime#asCalendar(boolean)} with {@code includeTime}.
   * <ul>
   *   <li>When {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemTime#asCalendar(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Calendar SystemTime.asCalendar(boolean)"})
  public void testAsCalendarWithIncludeTime_whenFalse() {
    // Arrange and Act
    Calendar actualAsCalendarResult = SystemTime.asCalendar(false);

    // Assert
    assertTrue(actualAsCalendarResult instanceof GregorianCalendar);
    assertEquals("gregory", actualAsCalendarResult.getCalendarType());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Calendar SystemTime.asCalendar(boolean)"})
  public void testAsCalendarWithIncludeTime_whenTrue() {
    // Arrange and Act
    Calendar actualAsCalendarResult = SystemTime.asCalendar(true);

    // Assert
    assertTrue(actualAsCalendarResult instanceof GregorianCalendar);
    assertEquals("gregory", actualAsCalendarResult.getCalendarType());
    assertEquals(2, actualAsCalendarResult.getFirstDayOfWeek());
    assertEquals(4, actualAsCalendarResult.getMinimalDaysInFirstWeek());
    assertTrue(actualAsCalendarResult.isLenient());
    assertTrue(actualAsCalendarResult.isWeekDateSupported());
  }

  /**
   * Test {@link SystemTime#asCalendar(Locale, TimeZone, boolean)} with {@code locale}, {@code timeZone}, {@code includeTime}.
   * <ul>
   *   <li>Then return {@link GregorianCalendar}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemTime#asCalendar(Locale, TimeZone, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Calendar SystemTime.asCalendar(Locale, TimeZone, boolean)"})
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
   * Test {@link SystemTime#asCalendar(Locale, TimeZone, boolean)} with {@code locale}, {@code timeZone}, {@code includeTime}.
   * <ul>
   *   <li>When {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemTime#asCalendar(Locale, TimeZone, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Calendar SystemTime.asCalendar(Locale, TimeZone, boolean)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Calendar SystemTime.asCalendar(Locale)"})
  public void testAsCalendarWithLocale_whenDefault_thenReturnGregorianCalendar() {
    // Arrange and Act
    Calendar actualAsCalendarResult = SystemTime.asCalendar(Locale.getDefault());

    // Assert
    assertTrue(actualAsCalendarResult instanceof GregorianCalendar);
    assertEquals("gregory", actualAsCalendarResult.getCalendarType());
    assertEquals(2, actualAsCalendarResult.getFirstDayOfWeek());
    assertEquals(4, actualAsCalendarResult.getMinimalDaysInFirstWeek());
    assertTrue(actualAsCalendarResult.isLenient());
    assertTrue(actualAsCalendarResult.isWeekDateSupported());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Calendar SystemTime.asCalendar(TimeZone)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SystemTime.shouldCacheDate()"})
  public void testShouldCacheDate() {
    // Arrange, Act and Assert
    assertTrue(SystemTime.shouldCacheDate());
  }
}

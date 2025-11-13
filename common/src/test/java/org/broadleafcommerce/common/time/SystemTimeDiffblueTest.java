package org.broadleafcommerce.common.time;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   *
   * <p>Method under test: {@link SystemTime#getTimeSource()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link SystemTime#asCalendar()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar SystemTime.asCalendar()"})
  public void testAsCalendar() {
    // Arrange and Act
    Calendar actualAsCalendarResult = SystemTime.asCalendar();

    // Assert
    assertTrue(actualAsCalendarResult instanceof GregorianCalendar);
    assertEquals("gregory", actualAsCalendarResult.getCalendarType());
    assertEquals(1, actualAsCalendarResult.getFirstDayOfWeek());
    assertEquals(1, actualAsCalendarResult.getMinimalDaysInFirstWeek());
    assertEquals(52, actualAsCalendarResult.getWeeksInWeekYear());
    assertTrue(actualAsCalendarResult.isLenient());
    assertTrue(actualAsCalendarResult.isWeekDateSupported());
  }

  /**
   * Test {@link SystemTime#asCalendar(boolean)} with {@code includeTime}.
   *
   * <ul>
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SystemTime#asCalendar(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar SystemTime.asCalendar(boolean)"})
  public void testAsCalendarWithIncludeTime_whenFalse() {
    // Arrange and Act
    Calendar actualAsCalendarResult = SystemTime.asCalendar(false);

    // Assert
    assertTrue(actualAsCalendarResult instanceof GregorianCalendar);
    assertEquals("gregory", actualAsCalendarResult.getCalendarType());
    assertEquals(1, actualAsCalendarResult.getFirstDayOfWeek());
    assertEquals(1, actualAsCalendarResult.getMinimalDaysInFirstWeek());
    assertEquals(52, actualAsCalendarResult.getWeeksInWeekYear());
    assertTrue(actualAsCalendarResult.isLenient());
    assertTrue(actualAsCalendarResult.isWeekDateSupported());
  }

  /**
   * Test {@link SystemTime#asCalendar(boolean)} with {@code includeTime}.
   *
   * <ul>
   *   <li>When {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SystemTime#asCalendar(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar SystemTime.asCalendar(boolean)"})
  public void testAsCalendarWithIncludeTime_whenTrue() {
    // Arrange and Act
    Calendar actualAsCalendarResult = SystemTime.asCalendar(true);

    // Assert
    assertTrue(actualAsCalendarResult instanceof GregorianCalendar);
    assertEquals("gregory", actualAsCalendarResult.getCalendarType());
    assertEquals(1, actualAsCalendarResult.getFirstDayOfWeek());
    assertEquals(1, actualAsCalendarResult.getMinimalDaysInFirstWeek());
    assertEquals(52, actualAsCalendarResult.getWeeksInWeekYear());
    assertTrue(actualAsCalendarResult.isLenient());
    assertTrue(actualAsCalendarResult.isWeekDateSupported());
  }

  /**
   * Test {@link SystemTime#asCalendar(Locale, TimeZone, boolean)} with {@code locale}, {@code
   * timeZone}, {@code includeTime}.
   *
   * <ul>
   *   <li>Then return {@link GregorianCalendar}.
   * </ul>
   *
   * <p>Method under test: {@link SystemTime#asCalendar(Locale, TimeZone, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar SystemTime.asCalendar(Locale, TimeZone, boolean)"})
  public void testAsCalendarWithLocaleTimeZoneIncludeTime_thenReturnGregorianCalendar() {
    // Arrange
    TimeZone timeZone = TimeZone.getTimeZone("America/Los_Angeles");

    // Act
    Calendar actualAsCalendarResult = SystemTime.asCalendar(Locale.getDefault(), timeZone, true);

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
   * Test {@link SystemTime#asCalendar(Locale, TimeZone, boolean)} with {@code locale}, {@code
   * timeZone}, {@code includeTime}.
   *
   * <ul>
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SystemTime#asCalendar(Locale, TimeZone, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar SystemTime.asCalendar(Locale, TimeZone, boolean)"})
  public void testAsCalendarWithLocaleTimeZoneIncludeTime_whenFalse() {
    // Arrange
    TimeZone timeZone = TimeZone.getTimeZone("America/Los_Angeles");

    // Act
    Calendar actualAsCalendarResult = SystemTime.asCalendar(Locale.getDefault(), timeZone, false);

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
   * Test {@link SystemTime#asCalendar(Locale)} with {@code locale}.
   *
   * <ul>
   *   <li>When Default.
   *   <li>Then return {@link GregorianCalendar}.
   * </ul>
   *
   * <p>Method under test: {@link SystemTime#asCalendar(Locale)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar SystemTime.asCalendar(Locale)"})
  public void testAsCalendarWithLocale_whenDefault_thenReturnGregorianCalendar() {
    // Arrange and Act
    Calendar actualAsCalendarResult = SystemTime.asCalendar(Locale.getDefault());

    // Assert
    assertTrue(actualAsCalendarResult instanceof GregorianCalendar);
    assertEquals("gregory", actualAsCalendarResult.getCalendarType());
    assertEquals(1, actualAsCalendarResult.getFirstDayOfWeek());
    assertEquals(1, actualAsCalendarResult.getMinimalDaysInFirstWeek());
    assertEquals(52, actualAsCalendarResult.getWeeksInWeekYear());
    assertTrue(actualAsCalendarResult.isLenient());
    assertTrue(actualAsCalendarResult.isWeekDateSupported());
  }

  /**
   * Test {@link SystemTime#asCalendar(TimeZone)} with {@code timeZone}.
   *
   * <ul>
   *   <li>Then return {@link GregorianCalendar}.
   * </ul>
   *
   * <p>Method under test: {@link SystemTime#asCalendar(TimeZone)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Calendar SystemTime.asCalendar(TimeZone)"})
  public void testAsCalendarWithTimeZone_thenReturnGregorianCalendar() {
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
   * Test {@link SystemTime#shouldCacheDate()}.
   *
   * <p>Method under test: {@link SystemTime#shouldCacheDate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SystemTime.shouldCacheDate()"})
  public void testShouldCacheDate() {
    // Arrange, Act and Assert
    assertTrue(SystemTime.shouldCacheDate());
  }
}

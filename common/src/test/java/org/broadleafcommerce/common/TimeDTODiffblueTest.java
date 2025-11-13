package org.broadleafcommerce.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.broadleafcommerce.common.time.DayOfMonthType;
import org.broadleafcommerce.common.time.DayOfWeekType;
import org.broadleafcommerce.common.time.HourOfDayType;
import org.broadleafcommerce.common.time.MinuteType;
import org.broadleafcommerce.common.time.MonthType;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TimeDTODiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TimeDTO#TimeDTO(Calendar)}
   *   <li>{@link TimeDTO#setCal(Calendar)}
   *   <li>{@link TimeDTO#setDate(Date)}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TimeDTO.<init>(Calendar)",
    "void TimeDTO.setCal(Calendar)",
    "void TimeDTO.setDate(Date)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    TimeDTO actualTimeDTO = new TimeDTO(new GregorianCalendar(1, 1, 1));
    actualTimeDTO.setCal(new GregorianCalendar(1, 1, 1));
    Date date =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualTimeDTO.setDate(date);

    // Assert
    HourOfDayType hour = actualTimeDTO.getHour();
    assertEquals("0", hour.getType());
    MinuteType minute = actualTimeDTO.getMinute();
    assertEquals("0", minute.getType());
    assertEquals("00", hour.getFriendlyType());
    assertEquals("00", minute.getFriendlyType());
    DayOfMonthType dayOfMonth = actualTimeDTO.getDayOfMonth();
    assertEquals("01", dayOfMonth.getFriendlyType());
    assertEquals("1", dayOfMonth.getType());
    MonthType month = actualTimeDTO.getMonth();
    assertEquals("2", month.getType());
    DayOfWeekType dayOfWeek = actualTimeDTO.getDayOfWeek();
    assertEquals("3", dayOfWeek.getType());
    assertEquals("February", month.getFriendlyType());
    assertEquals("Tuesday", dayOfWeek.getFriendlyType());
    assertSame(date, actualTimeDTO.getDate());
  }

  /**
   * Test {@link TimeDTO#getHour()}.
   *
   * <ul>
   *   <li>Given {@link GregorianCalendar#GregorianCalendar(int, int, int)} with one and one and
   *       one.
   *   <li>Then return {@link HourOfDayType#EIGHT}.
   * </ul>
   *
   * <p>Method under test: {@link TimeDTO#getHour()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"HourOfDayType TimeDTO.getHour()"})
  public void testGetHour_givenGregorianCalendarWithOneAndOneAndOne_thenReturnEight() {
    // Arrange
    TimeDTO timeDTO = new TimeDTO(new GregorianCalendar(1, 1, 1));
    timeDTO.setHour(HourOfDayType.EIGHT);

    // Act and Assert
    assertSame(HourOfDayType.EIGHT, timeDTO.getHour());
  }

  /**
   * Test {@link TimeDTO#getDayOfWeek()}.
   *
   * <ul>
   *   <li>Given {@link GregorianCalendar#GregorianCalendar(int, int, int)} with one and one and
   *       one.
   *   <li>Then return {@link DayOfWeekType#FRIDAY}.
   * </ul>
   *
   * <p>Method under test: {@link TimeDTO#getDayOfWeek()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DayOfWeekType TimeDTO.getDayOfWeek()"})
  public void testGetDayOfWeek_givenGregorianCalendarWithOneAndOneAndOne_thenReturnFriday() {
    // Arrange
    TimeDTO timeDTO = new TimeDTO(new GregorianCalendar(1, 1, 1));
    timeDTO.setDayOfWeek(DayOfWeekType.FRIDAY);

    // Act and Assert
    assertSame(DayOfWeekType.FRIDAY, timeDTO.getDayOfWeek());
  }

  /**
   * Test {@link TimeDTO#getDayOfMonth()}.
   *
   * <ul>
   *   <li>Given {@link GregorianCalendar#GregorianCalendar(int, int, int)} with one and one and
   *       one.
   *   <li>Then return {@link DayOfMonthType#EIGHT}.
   * </ul>
   *
   * <p>Method under test: {@link TimeDTO#getDayOfMonth()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DayOfMonthType TimeDTO.getDayOfMonth()"})
  public void testGetDayOfMonth_givenGregorianCalendarWithOneAndOneAndOne_thenReturnEight() {
    // Arrange
    TimeDTO timeDTO = new TimeDTO(new GregorianCalendar(1, 1, 1));
    timeDTO.setDayOfMonth(DayOfMonthType.EIGHT);

    // Act and Assert
    assertSame(DayOfMonthType.EIGHT, timeDTO.getDayOfMonth());
  }

  /**
   * Test {@link TimeDTO#getMonth()}.
   *
   * <ul>
   *   <li>Given {@link GregorianCalendar#GregorianCalendar(int, int, int)} with one and one and
   *       one.
   *   <li>Then return {@link MonthType#APRIL}.
   * </ul>
   *
   * <p>Method under test: {@link TimeDTO#getMonth()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MonthType TimeDTO.getMonth()"})
  public void testGetMonth_givenGregorianCalendarWithOneAndOneAndOne_thenReturnApril() {
    // Arrange
    TimeDTO timeDTO = new TimeDTO(new GregorianCalendar(1, 1, 1));
    timeDTO.setMonth(MonthType.APRIL);

    // Act and Assert
    assertSame(MonthType.APRIL, timeDTO.getMonth());
  }

  /**
   * Test {@link TimeDTO#getMinute()}.
   *
   * <ul>
   *   <li>Given {@link GregorianCalendar#GregorianCalendar(int, int, int)} with one and one and
   *       one.
   *   <li>Then return {@link MinuteType#EIGHT}.
   * </ul>
   *
   * <p>Method under test: {@link TimeDTO#getMinute()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MinuteType TimeDTO.getMinute()"})
  public void testGetMinute_givenGregorianCalendarWithOneAndOneAndOne_thenReturnEight() {
    // Arrange
    TimeDTO timeDTO = new TimeDTO(new GregorianCalendar(1, 1, 1));
    timeDTO.setMinute(MinuteType.EIGHT);

    // Act and Assert
    assertSame(MinuteType.EIGHT, timeDTO.getMinute());
  }

  /**
   * Test {@link TimeDTO#setHour(HourOfDayType)}.
   *
   * <ul>
   *   <li>When {@link HourOfDayType#EIGHT}.
   *   <li>Then {@link TimeDTO#TimeDTO()} Hour is {@link HourOfDayType#EIGHT}.
   * </ul>
   *
   * <p>Method under test: {@link TimeDTO#setHour(HourOfDayType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimeDTO.setHour(HourOfDayType)"})
  public void testSetHour_whenEight_thenTimeDTOHourIsEight() {
    // Arrange
    TimeDTO timeDTO = new TimeDTO();

    // Act
    timeDTO.setHour(HourOfDayType.EIGHT);

    // Assert
    assertSame(HourOfDayType.EIGHT, timeDTO.getHour());
  }

  /**
   * Test {@link TimeDTO#setDayOfWeek(DayOfWeekType)}.
   *
   * <ul>
   *   <li>When {@link DayOfWeekType#FRIDAY}.
   *   <li>Then {@link TimeDTO#TimeDTO()} DayOfWeek is {@link DayOfWeekType#FRIDAY}.
   * </ul>
   *
   * <p>Method under test: {@link TimeDTO#setDayOfWeek(DayOfWeekType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimeDTO.setDayOfWeek(DayOfWeekType)"})
  public void testSetDayOfWeek_whenFriday_thenTimeDTODayOfWeekIsFriday() {
    // Arrange
    TimeDTO timeDTO = new TimeDTO();

    // Act
    timeDTO.setDayOfWeek(DayOfWeekType.FRIDAY);

    // Assert
    assertSame(DayOfWeekType.FRIDAY, timeDTO.getDayOfWeek());
  }

  /**
   * Test {@link TimeDTO#setMonth(MonthType)}.
   *
   * <ul>
   *   <li>When {@link MonthType#APRIL}.
   *   <li>Then {@link TimeDTO#TimeDTO()} Month is {@link MonthType#APRIL}.
   * </ul>
   *
   * <p>Method under test: {@link TimeDTO#setMonth(MonthType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimeDTO.setMonth(MonthType)"})
  public void testSetMonth_whenApril_thenTimeDTOMonthIsApril() {
    // Arrange
    TimeDTO timeDTO = new TimeDTO();

    // Act
    timeDTO.setMonth(MonthType.APRIL);

    // Assert
    assertSame(MonthType.APRIL, timeDTO.getMonth());
  }

  /**
   * Test {@link TimeDTO#setDayOfMonth(DayOfMonthType)}.
   *
   * <ul>
   *   <li>When {@link DayOfMonthType#EIGHT}.
   *   <li>Then {@link TimeDTO#TimeDTO()} DayOfMonth is {@link DayOfMonthType#EIGHT}.
   * </ul>
   *
   * <p>Method under test: {@link TimeDTO#setDayOfMonth(DayOfMonthType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimeDTO.setDayOfMonth(DayOfMonthType)"})
  public void testSetDayOfMonth_whenEight_thenTimeDTODayOfMonthIsEight() {
    // Arrange
    TimeDTO timeDTO = new TimeDTO();

    // Act
    timeDTO.setDayOfMonth(DayOfMonthType.EIGHT);

    // Assert
    assertSame(DayOfMonthType.EIGHT, timeDTO.getDayOfMonth());
  }

  /**
   * Test {@link TimeDTO#setMinute(MinuteType)}.
   *
   * <ul>
   *   <li>When {@link MinuteType#EIGHT}.
   *   <li>Then {@link TimeDTO#TimeDTO()} Minute is {@link MinuteType#EIGHT}.
   * </ul>
   *
   * <p>Method under test: {@link TimeDTO#setMinute(MinuteType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimeDTO.setMinute(MinuteType)"})
  public void testSetMinute_whenEight_thenTimeDTOMinuteIsEight() {
    // Arrange
    TimeDTO timeDTO = new TimeDTO();

    // Act
    timeDTO.setMinute(MinuteType.EIGHT);

    // Assert
    assertSame(MinuteType.EIGHT, timeDTO.getMinute());
  }
}

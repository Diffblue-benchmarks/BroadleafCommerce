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
package org.broadleafcommerce.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
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

public class TimeDTODiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TimeDTO#TimeDTO(Calendar)}
   *   <li>{@link TimeDTO#setCal(Calendar)}
   *   <li>{@link TimeDTO#setDate(Date)}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    TimeDTO actualTimeDTO = new TimeDTO(new GregorianCalendar(1, 1, 1));
    actualTimeDTO.setCal(new GregorianCalendar(1, 1, 1));
    Date date = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
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
   * <ul>
   *   <li>Given {@link TimeDTO#TimeDTO()} Hour is {@link HourOfDayType#EIGHT}.</li>
   *   <li>Then return {@link HourOfDayType#EIGHT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeDTO#getHour()}
   */
  @Test
  public void testGetHour_givenTimeDTOHourIsEight_thenReturnEight() {
    // Arrange
    TimeDTO timeDTO = new TimeDTO();
    timeDTO.setHour(HourOfDayType.EIGHT);

    // Act
    HourOfDayType actualHour = timeDTO.getHour();

    // Assert
    assertSame(actualHour.EIGHT, actualHour);
  }

  /**
   * Test {@link TimeDTO#getDayOfWeek()}.
   * <ul>
   *   <li>Given {@link TimeDTO#TimeDTO()} DayOfWeek is
   * {@link DayOfWeekType#FRIDAY}.</li>
   *   <li>Then return {@link DayOfWeekType#FRIDAY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeDTO#getDayOfWeek()}
   */
  @Test
  public void testGetDayOfWeek_givenTimeDTODayOfWeekIsFriday_thenReturnFriday() {
    // Arrange
    TimeDTO timeDTO = new TimeDTO();
    timeDTO.setDayOfWeek(DayOfWeekType.FRIDAY);

    // Act
    DayOfWeekType actualDayOfWeek = timeDTO.getDayOfWeek();

    // Assert
    assertSame(actualDayOfWeek.FRIDAY, actualDayOfWeek);
  }

  /**
   * Test {@link TimeDTO#getDayOfMonth()}.
   * <ul>
   *   <li>Given {@link TimeDTO#TimeDTO()} DayOfMonth is
   * {@link DayOfMonthType#EIGHT}.</li>
   *   <li>Then return {@link DayOfMonthType#EIGHT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeDTO#getDayOfMonth()}
   */
  @Test
  public void testGetDayOfMonth_givenTimeDTODayOfMonthIsEight_thenReturnEight() {
    // Arrange
    TimeDTO timeDTO = new TimeDTO();
    timeDTO.setDayOfMonth(DayOfMonthType.EIGHT);

    // Act
    DayOfMonthType actualDayOfMonth = timeDTO.getDayOfMonth();

    // Assert
    assertSame(actualDayOfMonth.EIGHT, actualDayOfMonth);
  }

  /**
   * Test {@link TimeDTO#getMonth()}.
   * <ul>
   *   <li>Given {@link TimeDTO#TimeDTO()} Month is {@link MonthType#APRIL}.</li>
   *   <li>Then return {@link MonthType#APRIL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeDTO#getMonth()}
   */
  @Test
  public void testGetMonth_givenTimeDTOMonthIsApril_thenReturnApril() {
    // Arrange
    TimeDTO timeDTO = new TimeDTO();
    timeDTO.setMonth(MonthType.APRIL);

    // Act
    MonthType actualMonth = timeDTO.getMonth();

    // Assert
    assertSame(actualMonth.APRIL, actualMonth);
  }

  /**
   * Test {@link TimeDTO#getMinute()}.
   * <ul>
   *   <li>Given {@link TimeDTO#TimeDTO()} Minute is {@link MinuteType#EIGHT}.</li>
   *   <li>Then return {@link MinuteType#EIGHT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeDTO#getMinute()}
   */
  @Test
  public void testGetMinute_givenTimeDTOMinuteIsEight_thenReturnEight() {
    // Arrange
    TimeDTO timeDTO = new TimeDTO();
    timeDTO.setMinute(MinuteType.EIGHT);

    // Act
    MinuteType actualMinute = timeDTO.getMinute();

    // Assert
    assertSame(actualMinute.EIGHT, actualMinute);
  }

  /**
   * Test {@link TimeDTO#setHour(HourOfDayType)}.
   * <ul>
   *   <li>Given {@link TimeDTO#TimeDTO()} Date is {@link Date}.</li>
   *   <li>When {@link HourOfDayType#EIGHT}.</li>
   *   <li>Then {@link TimeDTO#TimeDTO()} Hour is {@link HourOfDayType#EIGHT}
   * {@link HourOfDayType#EIGHT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeDTO#setHour(HourOfDayType)}
   */
  @Test
  public void testSetHour_givenTimeDTODateIsDate_whenEight_thenTimeDTOHourIsEightEight() {
    // Arrange
    TimeDTO timeDTO = new TimeDTO();
    timeDTO.setDate(mock(java.sql.Date.class));
    HourOfDayType hour = HourOfDayType.EIGHT;

    // Act
    timeDTO.setHour(hour);

    // Assert
    HourOfDayType expectedHour = hour.EIGHT;
    assertSame(expectedHour, timeDTO.getHour());
  }

  /**
   * Test {@link TimeDTO#setHour(HourOfDayType)}.
   * <ul>
   *   <li>Given {@link TimeDTO#TimeDTO()}.</li>
   *   <li>When {@link HourOfDayType#EIGHT}.</li>
   *   <li>Then {@link TimeDTO#TimeDTO()} Hour is {@link HourOfDayType#EIGHT}
   * {@link HourOfDayType#EIGHT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeDTO#setHour(HourOfDayType)}
   */
  @Test
  public void testSetHour_givenTimeDTO_whenEight_thenTimeDTOHourIsEightEight() {
    // Arrange
    TimeDTO timeDTO = new TimeDTO();
    HourOfDayType hour = HourOfDayType.EIGHT;

    // Act
    timeDTO.setHour(hour);

    // Assert
    HourOfDayType expectedHour = hour.EIGHT;
    assertSame(expectedHour, timeDTO.getHour());
  }

  /**
   * Test {@link TimeDTO#setDayOfWeek(DayOfWeekType)}.
   * <ul>
   *   <li>Given {@link TimeDTO#TimeDTO()} Date is {@link Date}.</li>
   *   <li>Then {@link TimeDTO#TimeDTO()} DayOfWeek is {@link DayOfWeekType#FRIDAY}
   * {@link DayOfWeekType#FRIDAY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeDTO#setDayOfWeek(DayOfWeekType)}
   */
  @Test
  public void testSetDayOfWeek_givenTimeDTODateIsDate_thenTimeDTODayOfWeekIsFridayFriday() {
    // Arrange
    TimeDTO timeDTO = new TimeDTO();
    timeDTO.setDate(mock(java.sql.Date.class));
    DayOfWeekType dayOfWeek = DayOfWeekType.FRIDAY;

    // Act
    timeDTO.setDayOfWeek(dayOfWeek);

    // Assert
    DayOfWeekType expectedDayOfWeek = dayOfWeek.FRIDAY;
    assertSame(expectedDayOfWeek, timeDTO.getDayOfWeek());
  }

  /**
   * Test {@link TimeDTO#setDayOfWeek(DayOfWeekType)}.
   * <ul>
   *   <li>Given {@link TimeDTO#TimeDTO()}.</li>
   *   <li>When {@link DayOfWeekType#FRIDAY}.</li>
   *   <li>Then {@link TimeDTO#TimeDTO()} DayOfWeek is {@link DayOfWeekType#FRIDAY}
   * {@link DayOfWeekType#FRIDAY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeDTO#setDayOfWeek(DayOfWeekType)}
   */
  @Test
  public void testSetDayOfWeek_givenTimeDTO_whenFriday_thenTimeDTODayOfWeekIsFridayFriday() {
    // Arrange
    TimeDTO timeDTO = new TimeDTO();
    DayOfWeekType dayOfWeek = DayOfWeekType.FRIDAY;

    // Act
    timeDTO.setDayOfWeek(dayOfWeek);

    // Assert
    DayOfWeekType expectedDayOfWeek = dayOfWeek.FRIDAY;
    assertSame(expectedDayOfWeek, timeDTO.getDayOfWeek());
  }

  /**
   * Test {@link TimeDTO#setMonth(MonthType)}.
   * <ul>
   *   <li>Given {@link TimeDTO#TimeDTO()} Date is {@link Date}.</li>
   *   <li>When {@link MonthType#APRIL}.</li>
   *   <li>Then {@link TimeDTO#TimeDTO()} Month is {@link MonthType#APRIL}
   * {@link MonthType#APRIL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeDTO#setMonth(MonthType)}
   */
  @Test
  public void testSetMonth_givenTimeDTODateIsDate_whenApril_thenTimeDTOMonthIsAprilApril() {
    // Arrange
    TimeDTO timeDTO = new TimeDTO();
    timeDTO.setDate(mock(java.sql.Date.class));
    MonthType month = MonthType.APRIL;

    // Act
    timeDTO.setMonth(month);

    // Assert
    MonthType expectedMonth = month.APRIL;
    assertSame(expectedMonth, timeDTO.getMonth());
  }

  /**
   * Test {@link TimeDTO#setMonth(MonthType)}.
   * <ul>
   *   <li>Given {@link TimeDTO#TimeDTO()}.</li>
   *   <li>When {@link MonthType#APRIL}.</li>
   *   <li>Then {@link TimeDTO#TimeDTO()} Month is {@link MonthType#APRIL}
   * {@link MonthType#APRIL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeDTO#setMonth(MonthType)}
   */
  @Test
  public void testSetMonth_givenTimeDTO_whenApril_thenTimeDTOMonthIsAprilApril() {
    // Arrange
    TimeDTO timeDTO = new TimeDTO();
    MonthType month = MonthType.APRIL;

    // Act
    timeDTO.setMonth(month);

    // Assert
    MonthType expectedMonth = month.APRIL;
    assertSame(expectedMonth, timeDTO.getMonth());
  }

  /**
   * Test {@link TimeDTO#setDayOfMonth(DayOfMonthType)}.
   * <ul>
   *   <li>Given {@link TimeDTO#TimeDTO()} Date is {@link Date}.</li>
   *   <li>Then {@link TimeDTO#TimeDTO()} DayOfMonth is {@link DayOfMonthType#EIGHT}
   * {@link DayOfMonthType#EIGHT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeDTO#setDayOfMonth(DayOfMonthType)}
   */
  @Test
  public void testSetDayOfMonth_givenTimeDTODateIsDate_thenTimeDTODayOfMonthIsEightEight() {
    // Arrange
    TimeDTO timeDTO = new TimeDTO();
    timeDTO.setDate(mock(java.sql.Date.class));
    DayOfMonthType dayOfMonth = DayOfMonthType.EIGHT;

    // Act
    timeDTO.setDayOfMonth(dayOfMonth);

    // Assert
    DayOfMonthType expectedDayOfMonth = dayOfMonth.EIGHT;
    assertSame(expectedDayOfMonth, timeDTO.getDayOfMonth());
  }

  /**
   * Test {@link TimeDTO#setDayOfMonth(DayOfMonthType)}.
   * <ul>
   *   <li>Given {@link TimeDTO#TimeDTO()}.</li>
   *   <li>When {@link DayOfMonthType#EIGHT}.</li>
   *   <li>Then {@link TimeDTO#TimeDTO()} DayOfMonth is {@link DayOfMonthType#EIGHT}
   * {@link DayOfMonthType#EIGHT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeDTO#setDayOfMonth(DayOfMonthType)}
   */
  @Test
  public void testSetDayOfMonth_givenTimeDTO_whenEight_thenTimeDTODayOfMonthIsEightEight() {
    // Arrange
    TimeDTO timeDTO = new TimeDTO();
    DayOfMonthType dayOfMonth = DayOfMonthType.EIGHT;

    // Act
    timeDTO.setDayOfMonth(dayOfMonth);

    // Assert
    DayOfMonthType expectedDayOfMonth = dayOfMonth.EIGHT;
    assertSame(expectedDayOfMonth, timeDTO.getDayOfMonth());
  }

  /**
   * Test {@link TimeDTO#setMinute(MinuteType)}.
   * <ul>
   *   <li>Given {@link TimeDTO#TimeDTO()} Date is {@link Date}.</li>
   *   <li>When {@link MinuteType#EIGHT}.</li>
   *   <li>Then {@link TimeDTO#TimeDTO()} Minute is {@link MinuteType#EIGHT}
   * {@link MinuteType#EIGHT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeDTO#setMinute(MinuteType)}
   */
  @Test
  public void testSetMinute_givenTimeDTODateIsDate_whenEight_thenTimeDTOMinuteIsEightEight() {
    // Arrange
    TimeDTO timeDTO = new TimeDTO();
    timeDTO.setDate(mock(java.sql.Date.class));
    MinuteType minute = MinuteType.EIGHT;

    // Act
    timeDTO.setMinute(minute);

    // Assert
    MinuteType expectedMinute = minute.EIGHT;
    assertSame(expectedMinute, timeDTO.getMinute());
  }

  /**
   * Test {@link TimeDTO#setMinute(MinuteType)}.
   * <ul>
   *   <li>Given {@link TimeDTO#TimeDTO()}.</li>
   *   <li>When {@link MinuteType#EIGHT}.</li>
   *   <li>Then {@link TimeDTO#TimeDTO()} Minute is {@link MinuteType#EIGHT}
   * {@link MinuteType#EIGHT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TimeDTO#setMinute(MinuteType)}
   */
  @Test
  public void testSetMinute_givenTimeDTO_whenEight_thenTimeDTOMinuteIsEightEight() {
    // Arrange
    TimeDTO timeDTO = new TimeDTO();
    MinuteType minute = MinuteType.EIGHT;

    // Act
    timeDTO.setMinute(minute);

    // Assert
    MinuteType expectedMinute = minute.EIGHT;
    assertSame(expectedMinute, timeDTO.getMinute());
  }
}

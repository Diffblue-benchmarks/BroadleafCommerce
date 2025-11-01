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
   * Method under test: {@link TimeDTO#getHour()}
   */
  @Test
  public void testGetHour() {
    // Arrange
    TimeDTO timeDTO = new TimeDTO();
    timeDTO.setHour(HourOfDayType.EIGHT);

    // Act
    HourOfDayType actualHour = timeDTO.getHour();

    // Assert
    assertSame(actualHour.EIGHT, actualHour);
  }

  /**
   * Method under test: {@link TimeDTO#getDayOfWeek()}
   */
  @Test
  public void testGetDayOfWeek() {
    // Arrange
    TimeDTO timeDTO = new TimeDTO();
    timeDTO.setDayOfWeek(DayOfWeekType.FRIDAY);

    // Act
    DayOfWeekType actualDayOfWeek = timeDTO.getDayOfWeek();

    // Assert
    assertSame(actualDayOfWeek.FRIDAY, actualDayOfWeek);
  }

  /**
   * Method under test: {@link TimeDTO#getDayOfMonth()}
   */
  @Test
  public void testGetDayOfMonth() {
    // Arrange
    TimeDTO timeDTO = new TimeDTO();
    timeDTO.setDayOfMonth(DayOfMonthType.EIGHT);

    // Act
    DayOfMonthType actualDayOfMonth = timeDTO.getDayOfMonth();

    // Assert
    assertSame(actualDayOfMonth.EIGHT, actualDayOfMonth);
  }

  /**
   * Method under test: {@link TimeDTO#getMonth()}
   */
  @Test
  public void testGetMonth() {
    // Arrange
    TimeDTO timeDTO = new TimeDTO();
    timeDTO.setMonth(MonthType.APRIL);

    // Act
    MonthType actualMonth = timeDTO.getMonth();

    // Assert
    assertSame(actualMonth.APRIL, actualMonth);
  }

  /**
   * Method under test: {@link TimeDTO#getMinute()}
   */
  @Test
  public void testGetMinute() {
    // Arrange
    TimeDTO timeDTO = new TimeDTO();
    timeDTO.setMinute(MinuteType.EIGHT);

    // Act
    MinuteType actualMinute = timeDTO.getMinute();

    // Assert
    assertSame(actualMinute.EIGHT, actualMinute);
  }

  /**
   * Method under test: {@link TimeDTO#getDate()}
   */
  @Test
  public void testGetDate() {
    // Arrange
    TimeDTO timeDTO = new TimeDTO();
    Date date = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    timeDTO.setDate(date);

    // Act and Assert
    assertSame(date, timeDTO.getDate());
  }

  /**
   * Method under test: {@link TimeDTO#setHour(HourOfDayType)}
   */
  @Test
  public void testSetHour() {
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
   * Method under test: {@link TimeDTO#setHour(HourOfDayType)}
   */
  @Test
  public void testSetHour2() {
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
   * Method under test: {@link TimeDTO#setDayOfWeek(DayOfWeekType)}
   */
  @Test
  public void testSetDayOfWeek() {
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
   * Method under test: {@link TimeDTO#setDayOfWeek(DayOfWeekType)}
   */
  @Test
  public void testSetDayOfWeek2() {
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
   * Method under test: {@link TimeDTO#setMonth(MonthType)}
   */
  @Test
  public void testSetMonth() {
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
   * Method under test: {@link TimeDTO#setMonth(MonthType)}
   */
  @Test
  public void testSetMonth2() {
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
   * Method under test: {@link TimeDTO#setDayOfMonth(DayOfMonthType)}
   */
  @Test
  public void testSetDayOfMonth() {
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
   * Method under test: {@link TimeDTO#setDayOfMonth(DayOfMonthType)}
   */
  @Test
  public void testSetDayOfMonth2() {
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
   * Method under test: {@link TimeDTO#setMinute(MinuteType)}
   */
  @Test
  public void testSetMinute() {
    // Arrange
    TimeDTO timeDTO = new TimeDTO();
    MinuteType minute = MinuteType.EIGHT;

    // Act
    timeDTO.setMinute(minute);

    // Assert
    MinuteType expectedMinute = minute.EIGHT;
    assertSame(expectedMinute, timeDTO.getMinute());
  }

  /**
   * Method under test: {@link TimeDTO#setMinute(MinuteType)}
   */
  @Test
  public void testSetMinute2() {
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
}

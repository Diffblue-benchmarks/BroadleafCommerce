/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import jakarta.mail.internet.MailDateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.Test;
import org.mockito.Mockito;

public class NullAwareDateFilterValueConverterDiffblueTest {
  /**
   * Test {@link NullAwareDateFilterValueConverter#convert(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NullAwareDateFilterValueConverter#convert(String)}
   */
  @Test
  public void testConvert_when42_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new NullAwareDateFilterValueConverter()).convert("42"));
  }

  /**
   * Test {@link NullAwareDateFilterValueConverter#convert(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NullAwareDateFilterValueConverter#convert(String)}
   */
  @Test
  public void testConvert_whenEmptyString_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new NullAwareDateFilterValueConverter()).convert(""));
  }

  /**
   * Test {@link NullAwareDateFilterValueConverter#convert(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NullAwareDateFilterValueConverter#convert(String)}
   */
  @Test
  public void testConvert_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new NullAwareDateFilterValueConverter()).convert(null));
  }

  /**
   * Test
   * {@link NullAwareDateFilterValueConverter#parseDate(String, SimpleDateFormat)}.
   * <p>
   * Method under test:
   * {@link NullAwareDateFilterValueConverter#parseDate(String, SimpleDateFormat)}
   */
  @Test
  public void testParseDate() throws ParseException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NullAwareDateFilterValueConverter nullAwareDateFilterValueConverter = new NullAwareDateFilterValueConverter();
    MailDateFormat dateFormat = mock(MailDateFormat.class);
    when(dateFormat.parse(Mockito.<String>any()))
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    nullAwareDateFilterValueConverter.parseDate("42", dateFormat);

    // Assert
    verify(dateFormat).parse(eq("42"));
  }

  /**
   * Test
   * {@link NullAwareDateFilterValueConverter#parseDate(String, SimpleDateFormat)}.
   * <ul>
   *   <li>Then {@link SimpleDateFormat#SimpleDateFormat(String)} with {@code 42}
   * Calendar {@link GregorianCalendar}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NullAwareDateFilterValueConverter#parseDate(String, SimpleDateFormat)}
   */
  @Test
  public void testParseDate_thenSimpleDateFormatWith42CalendarGregorianCalendar() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NullAwareDateFilterValueConverter nullAwareDateFilterValueConverter = new NullAwareDateFilterValueConverter();
    SimpleDateFormat dateFormat = new SimpleDateFormat("42");

    // Act
    nullAwareDateFilterValueConverter.parseDate("42", dateFormat);

    // Assert
    Calendar calendar = dateFormat.getCalendar();
    assertTrue(calendar instanceof GregorianCalendar);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    assertEquals("1970-01-01", simpleDateFormat.format(calendar.getTime()));
    assertEquals(1970, calendar.getWeekYear());
    assertEquals(53, calendar.getWeeksInWeekYear());
  }

  /**
   * Test
   * {@link NullAwareDateFilterValueConverter#parseDate(String, SimpleDateFormat)}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NullAwareDateFilterValueConverter#parseDate(String, SimpleDateFormat)}
   */
  @Test
  public void testParseDate_whenEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NullAwareDateFilterValueConverter nullAwareDateFilterValueConverter = new NullAwareDateFilterValueConverter();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    Date actualParseDateResult = nullAwareDateFilterValueConverter.parseDate("", dateFormat);

    // Assert
    Calendar calendar = dateFormat.getCalendar();
    assertTrue(calendar instanceof GregorianCalendar);
    assertNull(actualParseDateResult);
    assertEquals(1944, calendar.getWeekYear());
    assertEquals(52, calendar.getWeeksInWeekYear());
  }

  /**
   * Test
   * {@link NullAwareDateFilterValueConverter#parseDate(String, SimpleDateFormat)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link SimpleDateFormat#SimpleDateFormat(String)} with
   * {@code yyyy/mm/dd} Calendar {@link GregorianCalendar}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NullAwareDateFilterValueConverter#parseDate(String, SimpleDateFormat)}
   */
  @Test
  public void testParseDate_whenNull_thenSimpleDateFormatWithYyyyMmDdCalendarGregorianCalendar() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NullAwareDateFilterValueConverter nullAwareDateFilterValueConverter = new NullAwareDateFilterValueConverter();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    Date actualParseDateResult = nullAwareDateFilterValueConverter.parseDate(null, dateFormat);

    // Assert
    Calendar calendar = dateFormat.getCalendar();
    assertTrue(calendar instanceof GregorianCalendar);
    assertNull(actualParseDateResult);
    assertEquals(1944, calendar.getWeekYear());
    assertEquals(52, calendar.getWeeksInWeekYear());
  }

  /**
   * Test
   * {@link NullAwareDateFilterValueConverter#parseDate(String, SimpleDateFormat)}.
   * <ul>
   *   <li>When {@link SimpleDateFormat#SimpleDateFormat(String)} with
   * {@code yyyy/mm/dd}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NullAwareDateFilterValueConverter#parseDate(String, SimpleDateFormat)}
   */
  @Test
  public void testParseDate_whenSimpleDateFormatWithYyyyMmDd_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NullAwareDateFilterValueConverter nullAwareDateFilterValueConverter = new NullAwareDateFilterValueConverter();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> nullAwareDateFilterValueConverter.parseDate("42", new SimpleDateFormat("yyyy/mm/dd")));
  }
}

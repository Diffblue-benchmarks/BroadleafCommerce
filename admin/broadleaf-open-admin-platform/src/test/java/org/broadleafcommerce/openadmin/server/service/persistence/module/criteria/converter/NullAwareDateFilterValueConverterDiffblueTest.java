/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {NullAwareDateFilterValueConverter.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class NullAwareDateFilterValueConverterDiffblueTest {
  @Autowired
  private NullAwareDateFilterValueConverter nullAwareDateFilterValueConverter;

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Date NullAwareDateFilterValueConverter.convert(String)"})
  public void testConvert_when42_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> nullAwareDateFilterValueConverter.convert("42"));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Date NullAwareDateFilterValueConverter.convert(String)"})
  public void testConvert_whenEmptyString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(nullAwareDateFilterValueConverter.convert(""));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Date NullAwareDateFilterValueConverter.convert(String)"})
  public void testConvert_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(nullAwareDateFilterValueConverter.convert(null));
  }

  /**
   * Test {@link NullAwareDateFilterValueConverter#parseDate(String, SimpleDateFormat)}.
   * <ul>
   *   <li>Then {@link SimpleDateFormat#SimpleDateFormat(String)} with {@code 42} Calendar {@link GregorianCalendar}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NullAwareDateFilterValueConverter#parseDate(String, SimpleDateFormat)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Date NullAwareDateFilterValueConverter.parseDate(String, SimpleDateFormat)"})
  public void testParseDate_thenSimpleDateFormatWith42CalendarGregorianCalendar() {
    // Arrange
    SimpleDateFormat dateFormat = new SimpleDateFormat("42");

    // Act
    Date actualParseDateResult = nullAwareDateFilterValueConverter.parseDate("42", dateFormat);

    // Assert
    Calendar calendar = dateFormat.getCalendar();
    assertTrue(calendar instanceof GregorianCalendar);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    assertEquals("1970-01-01", simpleDateFormat.format(calendar.getTime()));
    assertEquals("1970-01-01", (new SimpleDateFormat("yyyy-MM-dd")).format(actualParseDateResult));
    assertEquals(1970, calendar.getWeekYear());
    assertEquals(53, calendar.getWeeksInWeekYear());
  }

  /**
   * Test {@link NullAwareDateFilterValueConverter#parseDate(String, SimpleDateFormat)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NullAwareDateFilterValueConverter#parseDate(String, SimpleDateFormat)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Date NullAwareDateFilterValueConverter.parseDate(String, SimpleDateFormat)"})
  public void testParseDate_when42_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> nullAwareDateFilterValueConverter.parseDate("42", new SimpleDateFormat("yyyy/mm/dd")));
  }

  /**
   * Test {@link NullAwareDateFilterValueConverter#parseDate(String, SimpleDateFormat)}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link NullAwareDateFilterValueConverter#parseDate(String, SimpleDateFormat)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Date NullAwareDateFilterValueConverter.parseDate(String, SimpleDateFormat)"})
  public void testParseDate_whenEmptyString() {
    // Arrange
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    Date actualParseDateResult = nullAwareDateFilterValueConverter.parseDate("", dateFormat);

    // Assert
    Calendar calendar = dateFormat.getCalendar();
    assertTrue(calendar instanceof GregorianCalendar);
    assertNull(actualParseDateResult);
    assertEquals(1945, calendar.getWeekYear());
    assertEquals(52, calendar.getWeeksInWeekYear());
  }

  /**
   * Test {@link NullAwareDateFilterValueConverter#parseDate(String, SimpleDateFormat)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link SimpleDateFormat#SimpleDateFormat(String)} with {@code yyyy/mm/dd} Calendar {@link GregorianCalendar}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NullAwareDateFilterValueConverter#parseDate(String, SimpleDateFormat)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Date NullAwareDateFilterValueConverter.parseDate(String, SimpleDateFormat)"})
  public void testParseDate_whenNull_thenSimpleDateFormatWithYyyyMmDdCalendarGregorianCalendar() {
    // Arrange
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    Date actualParseDateResult = nullAwareDateFilterValueConverter.parseDate(null, dateFormat);

    // Assert
    Calendar calendar = dateFormat.getCalendar();
    assertTrue(calendar instanceof GregorianCalendar);
    assertNull(actualParseDateResult);
    assertEquals(1945, calendar.getWeekYear());
    assertEquals(52, calendar.getWeeksInWeekYear());
  }
}

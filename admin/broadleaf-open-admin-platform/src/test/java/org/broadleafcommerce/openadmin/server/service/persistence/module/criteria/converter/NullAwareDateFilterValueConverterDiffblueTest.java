package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @Autowired private NullAwareDateFilterValueConverter nullAwareDateFilterValueConverter;

  /**
   * Test {@link NullAwareDateFilterValueConverter#convert(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link NullAwareDateFilterValueConverter#convert(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Date NullAwareDateFilterValueConverter.convert(String)"})
  public void testConvert_when42_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> nullAwareDateFilterValueConverter.convert("42"));
  }

  /**
   * Test {@link NullAwareDateFilterValueConverter#convert(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NullAwareDateFilterValueConverter#convert(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Date NullAwareDateFilterValueConverter.convert(String)"})
  public void testConvert_whenEmptyString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(nullAwareDateFilterValueConverter.convert(""));
  }

  /**
   * Test {@link NullAwareDateFilterValueConverter#convert(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NullAwareDateFilterValueConverter#convert(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Date NullAwareDateFilterValueConverter.convert(String)"})
  public void testConvert_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(nullAwareDateFilterValueConverter.convert(null));
  }

  /**
   * Test {@link NullAwareDateFilterValueConverter#parseDate(String, SimpleDateFormat)}.
   *
   * <ul>
   *   <li>Then {@link SimpleDateFormat#SimpleDateFormat(String)} with {@code 42} Calendar {@link
   *       GregorianCalendar}.
   * </ul>
   *
   * <p>Method under test: {@link NullAwareDateFilterValueConverter#parseDate(String,
   * SimpleDateFormat)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Date NullAwareDateFilterValueConverter.parseDate(String, SimpleDateFormat)"})
  public void testParseDate_thenSimpleDateFormatWith42CalendarGregorianCalendar() {
    // Arrange
    SimpleDateFormat dateFormat = new SimpleDateFormat("42");

    // Act
    Date actualParseDateResult = nullAwareDateFilterValueConverter.parseDate("42", dateFormat);

    // Assert
    Calendar calendar = dateFormat.getCalendar();
    assertTrue(calendar instanceof GregorianCalendar);
    String actualFormatResult = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
    assertEquals("1970-01-01", actualFormatResult);
    String actualFormatResult2 = new SimpleDateFormat("yyyy-MM-dd").format(actualParseDateResult);
    assertEquals("1970-01-01", actualFormatResult2);
    assertEquals(1970, calendar.getWeekYear());
  }

  /**
   * Test {@link NullAwareDateFilterValueConverter#parseDate(String, SimpleDateFormat)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link NullAwareDateFilterValueConverter#parseDate(String,
   * SimpleDateFormat)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Date NullAwareDateFilterValueConverter.parseDate(String, SimpleDateFormat)"})
  public void testParseDate_when42_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            nullAwareDateFilterValueConverter.parseDate("42", new SimpleDateFormat("yyyy/mm/dd")));
  }

  /**
   * Test {@link NullAwareDateFilterValueConverter#parseDate(String, SimpleDateFormat)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link NullAwareDateFilterValueConverter#parseDate(String,
   * SimpleDateFormat)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    assertEquals(1946, calendar.getWeekYear());
  }

  /**
   * Test {@link NullAwareDateFilterValueConverter#parseDate(String, SimpleDateFormat)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link SimpleDateFormat#SimpleDateFormat(String)} with {@code yyyy/mm/dd} Calendar
   *       {@link GregorianCalendar}.
   * </ul>
   *
   * <p>Method under test: {@link NullAwareDateFilterValueConverter#parseDate(String,
   * SimpleDateFormat)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    assertEquals(1946, calendar.getWeekYear());
  }
}

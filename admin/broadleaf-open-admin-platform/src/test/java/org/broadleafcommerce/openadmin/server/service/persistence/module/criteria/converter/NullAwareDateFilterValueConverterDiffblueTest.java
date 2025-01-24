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
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml",
    "/bl-open-admin-applicationContext-entity.xml", "/bl-open-admin-contentClient-applicationContext.xml",
    "/bl-open-admin-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class NullAwareDateFilterValueConverterDiffblueTest {
  @Autowired
  private NullAwareDateFilterValueConverter nullAwareDateFilterValueConverter;

  /**
   * Test {@link NullAwareDateFilterValueConverter#convert(String)}.
   * <p>
   * Method under test: {@link NullAwareDateFilterValueConverter#convert(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testConvert() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.converter;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8408 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.converter.NullAwareDateFilterValueConverter nullAwareDateFilterValueConverter;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new NullAwareDateFilterValueConverter()).convert("42");
  }

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
   * <p>
   * Method under test:
   * {@link NullAwareDateFilterValueConverter#parseDate(String, SimpleDateFormat)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testParseDate2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.converter;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8423 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.converter.NullAwareDateFilterValueConverter nullAwareDateFilterValueConverter;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    NullAwareDateFilterValueConverter nullAwareDateFilterValueConverter2 = new NullAwareDateFilterValueConverter();

    // Act
    nullAwareDateFilterValueConverter2.parseDate("42", new SimpleDateFormat("yyyy/mm/dd"));
  }

  /**
   * Test
   * {@link NullAwareDateFilterValueConverter#parseDate(String, SimpleDateFormat)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with
   * {@code foo}.</li>
   *   <li>Then calls {@link SimpleDateFormat#toPattern()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NullAwareDateFilterValueConverter#parseDate(String, SimpleDateFormat)}
   */
  @Test
  public void testParseDate_givenRuntimeExceptionWithFoo_thenCallsToPattern() throws ParseException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NullAwareDateFilterValueConverter nullAwareDateFilterValueConverter = new NullAwareDateFilterValueConverter();
    MailDateFormat dateFormat = mock(MailDateFormat.class);
    when(dateFormat.toPattern()).thenThrow(new RuntimeException("foo"));
    when(dateFormat.parse(Mockito.<String>any())).thenThrow(new ParseException("foo", 1));

    // Act
    nullAwareDateFilterValueConverter.parseDate("42", dateFormat);

    // Assert
    verify(dateFormat).parse(eq("42"));
    verify(dateFormat).toPattern();
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
    assertEquals(1945, calendar.getWeekYear());
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
    assertEquals(1945, calendar.getWeekYear());
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

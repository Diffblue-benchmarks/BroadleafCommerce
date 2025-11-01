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
import static org.junit.Assert.assertSame;
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
   * Method under test: {@link NullAwareDateFilterValueConverter#convert(String)}
   */
  @Test
  public void testConvert() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new NullAwareDateFilterValueConverter()).convert("42"));
    assertNull((new NullAwareDateFilterValueConverter()).convert(null));
    assertNull((new NullAwareDateFilterValueConverter()).convert(""));
  }

  /**
   * Method under test:
   * {@link NullAwareDateFilterValueConverter#parseDate(String, SimpleDateFormat)}
   */
  @Test
  public void testParseDate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NullAwareDateFilterValueConverter nullAwareDateFilterValueConverter = new NullAwareDateFilterValueConverter();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> nullAwareDateFilterValueConverter.parseDate("42", new SimpleDateFormat("yyyy/mm/dd")));
  }

  /**
   * Method under test:
   * {@link NullAwareDateFilterValueConverter#parseDate(String, SimpleDateFormat)}
   */
  @Test
  public void testParseDate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NullAwareDateFilterValueConverter nullAwareDateFilterValueConverter = new NullAwareDateFilterValueConverter();

    // Act and Assert
    assertNull(nullAwareDateFilterValueConverter.parseDate(null, new SimpleDateFormat("yyyy/mm/dd")));
  }

  /**
   * Method under test:
   * {@link NullAwareDateFilterValueConverter#parseDate(String, SimpleDateFormat)}
   */
  @Test
  public void testParseDate3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NullAwareDateFilterValueConverter nullAwareDateFilterValueConverter = new NullAwareDateFilterValueConverter();

    // Act and Assert
    assertNull(nullAwareDateFilterValueConverter.parseDate("", new SimpleDateFormat("yyyy/mm/dd")));
  }

  /**
   * Method under test:
   * {@link NullAwareDateFilterValueConverter#parseDate(String, SimpleDateFormat)}
   */
  @Test
  public void testParseDate4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NullAwareDateFilterValueConverter nullAwareDateFilterValueConverter = new NullAwareDateFilterValueConverter();
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
  }

  /**
   * Method under test:
   * {@link NullAwareDateFilterValueConverter#parseDate(String, SimpleDateFormat)}
   */
  @Test
  public void testParseDate5() throws ParseException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NullAwareDateFilterValueConverter nullAwareDateFilterValueConverter = new NullAwareDateFilterValueConverter();
    MailDateFormat dateFormat = mock(MailDateFormat.class);
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(dateFormat.parse(Mockito.<String>any())).thenReturn(fromResult);

    // Act
    Date actualParseDateResult = nullAwareDateFilterValueConverter.parseDate("42", dateFormat);

    // Assert
    verify(dateFormat).parse(eq("42"));
    assertSame(fromResult, actualParseDateResult);
  }
}

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
package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FormatUtilDiffblueTest {
  /**
   * Test {@link FormatUtil#getDateFormat()}.
   *
   * <p>Method under test: {@link FormatUtil#getDateFormat()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SimpleDateFormat FormatUtil.getDateFormat()"})
  public void testGetDateFormat() {
    // Arrange and Act
    SimpleDateFormat actualDateFormat = FormatUtil.getDateFormat();

    // Assert
    assertTrue(actualDateFormat.getNumberFormat() instanceof DecimalFormat);
    assertTrue(actualDateFormat.getCalendar() instanceof GregorianCalendar);
    assertNull(actualDateFormat.getTimeZone());
    assertTrue(actualDateFormat.isLenient());
    assertEquals(FormatUtil.DATE_FORMAT, actualDateFormat.toPattern());
  }

  /**
   * Test {@link FormatUtil#getTimeZoneFormat()}.
   *
   * <p>Method under test: {@link FormatUtil#getTimeZoneFormat()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SimpleDateFormat FormatUtil.getTimeZoneFormat()"})
  public void testGetTimeZoneFormat() {
    // Arrange and Act
    SimpleDateFormat actualTimeZoneFormat = FormatUtil.getTimeZoneFormat();

    // Assert
    assertTrue(actualTimeZoneFormat.getNumberFormat() instanceof DecimalFormat);
    assertTrue(actualTimeZoneFormat.getCalendar() instanceof GregorianCalendar);
    assertNull(actualTimeZoneFormat.getTimeZone());
    assertTrue(actualTimeZoneFormat.isLenient());
    assertEquals(FormatUtil.DATE_FORMAT_WITH_TIMEZONE, actualTimeZoneFormat.toPattern());
  }

  /**
   * Test {@link FormatUtil#dateToSting(Date, TimeZone)}.
   *
   * <ul>
   *   <li>Then return {@code Dec 31, 1969 @ 04:00pm}.
   * </ul>
   *
   * <p>Method under test: {@link FormatUtil#dateToSting(Date, TimeZone)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String FormatUtil.dateToSting(Date, TimeZone)"})
  public void testDateToSting_thenReturnDec3119690400pm() {
    // Arrange, Act and Assert
    assertEquals(
        "Dec 31, 1969 @ 04:00pm",
        FormatUtil.dateToSting(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()),
            TimeZone.getTimeZone("America/Los_Angeles")));
  }
}

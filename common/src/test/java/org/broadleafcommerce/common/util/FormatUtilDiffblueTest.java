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
package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.TimeZone;
import org.junit.Test;

public class FormatUtilDiffblueTest {
  /**
   * Test {@link FormatUtil#formatDateUsingW3C(Date)}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>When {@link java.sql.Date} {@link java.util.Date#getTime()} return
   * ten.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormatUtil#formatDateUsingW3C(java.util.Date)}
   */
  @Test
  public void testFormatDateUsingW3C_givenTen_whenDateGetTimeReturnTen_thenCallsGetTime() {
    // Arrange
    java.sql.Date date = mock(java.sql.Date.class);
    when(date.getTime()).thenReturn(10L);

    // Act
    FormatUtil.formatDateUsingW3C(date);

    // Assert
    verify(date).getTime();
  }

  /**
   * Test {@link FormatUtil#dateToSting(Date, TimeZone)}.
   * <p>
   * Method under test: {@link FormatUtil#dateToSting(Date, TimeZone)}
   */
  @Test
  public void testDateToSting() {
    // Arrange
    Date date = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertEquals("Dec 31, 1969 @ 04:00pm", FormatUtil.dateToSting(date, TimeZone.getTimeZone("America/Los_Angeles")));
  }

  /**
   * Test {@link FormatUtil#dateToSting(Date, TimeZone)}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>When {@link java.sql.Date} {@link java.util.Date#getTime()} return
   * ten.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormatUtil#dateToSting(java.util.Date, TimeZone)}
   */
  @Test
  public void testDateToSting_givenTen_whenDateGetTimeReturnTen_thenCallsGetTime() {
    // Arrange
    java.sql.Date date = mock(java.sql.Date.class);
    when(date.getTime()).thenReturn(10L);

    // Act
    String actualDateToStingResult = FormatUtil.dateToSting(date, TimeZone.getTimeZone("America/Los_Angeles"));

    // Assert
    verify(date).getTime();
    assertEquals("Dec 31, 1969 @ 04:00pm", actualDateToStingResult);
  }
}

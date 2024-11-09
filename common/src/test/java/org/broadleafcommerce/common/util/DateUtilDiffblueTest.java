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

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.junit.Test;

public class DateUtilDiffblueTest {
  /**
   * Test {@link DateUtil#isActive(Date, Date, boolean)}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>When {@link java.sql.Date} {@link java.util.Date#getTime()} return
   * ten.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DateUtil#isActive(java.util.Date, java.util.Date, boolean)}
   */
  @Test
  public void testIsActive_givenTen_whenDateGetTimeReturnTen_thenCallsGetTime() {
    // Arrange
    java.sql.Date startDate = mock(java.sql.Date.class);
    when(startDate.getTime()).thenReturn(10L);

    // Act
    boolean actualIsActiveResult = DateUtil.isActive(startDate,
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()), true);

    // Assert
    verify(startDate).getTime();
    assertFalse(actualIsActiveResult);
  }

  /**
   * Test {@link DateUtil#isActive(Date, Date, boolean)}.
   * <ul>
   *   <li>When {@link Date#Date()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateUtil#isActive(Date, Date, boolean)}
   */
  @Test
  public void testIsActive_whenDate_thenReturnFalse() {
    // Arrange
    Date startDate = new Date();

    // Act and Assert
    assertFalse(DateUtil.isActive(startDate,
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()), true));
  }

  /**
   * Test {@link DateUtil#isActive(Date, Date, boolean)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateUtil#isActive(Date, Date, boolean)}
   */
  @Test
  public void testIsActive_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(DateUtil.isActive(null, null, false));
  }

  /**
   * Test {@link DateUtil#isActive(Date, Date, boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateUtil#isActive(Date, Date, boolean)}
   */
  @Test
  public void testIsActive_whenTrue_thenReturnFalse() {
    // Arrange
    Date startDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertFalse(DateUtil.isActive(startDate,
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()), true));
  }

  /**
   * Test
   * {@link DateUtil#getCurrentDateAfterFactoringInDateResolution(Date, Long)}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>Then calls {@link java.util.Date#getTime()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DateUtil#getCurrentDateAfterFactoringInDateResolution(java.util.Date, Long)}
   */
  @Test
  public void testGetCurrentDateAfterFactoringInDateResolution_givenTen_thenCallsGetTime() {
    // Arrange
    java.sql.Date cachedDate = mock(java.sql.Date.class);
    when(cachedDate.getTime()).thenReturn(10L);

    // Act
    DateUtil.getCurrentDateAfterFactoringInDateResolution(cachedDate, 1L);

    // Assert
    verify(cachedDate).getTime();
  }
}

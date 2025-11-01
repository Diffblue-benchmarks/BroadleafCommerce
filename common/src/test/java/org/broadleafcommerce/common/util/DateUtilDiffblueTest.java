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
   * Method under test: {@link DateUtil#isActive(Date, Date, boolean)}
   */
  @Test
  public void testIsActive() {
    // Arrange
    Date startDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act and Assert
    assertFalse(DateUtil.isActive(startDate,
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()), true));
  }

  /**
   * Method under test: {@link DateUtil#isActive(Date, Date, boolean)}
   */
  @Test
  public void testIsActive2() {
    // Arrange, Act and Assert
    assertFalse(DateUtil.isActive(null, null, false));
  }

  /**
   * Method under test: {@link DateUtil#isActive(Date, Date, boolean)}
   */
  @Test
  public void testIsActive3() {
    // Arrange
    Date startDate = new Date();

    // Act and Assert
    assertFalse(DateUtil.isActive(startDate,
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()), true));
  }

  /**
   * Method under test:
   * {@link DateUtil#isActive(java.util.Date, java.util.Date, boolean)}
   */
  @Test
  public void testIsActive4() {
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
   * Method under test:
   * {@link DateUtil#getCurrentDateAfterFactoringInDateResolution(java.util.Date, Long)}
   */
  @Test
  public void testGetCurrentDateAfterFactoringInDateResolution() {
    // Arrange
    java.sql.Date cachedDate = mock(java.sql.Date.class);
    when(cachedDate.getTime()).thenReturn(10L);

    // Act
    DateUtil.getCurrentDateAfterFactoringInDateResolution(cachedDate, 1L);

    // Assert
    verify(cachedDate).getTime();
  }
}

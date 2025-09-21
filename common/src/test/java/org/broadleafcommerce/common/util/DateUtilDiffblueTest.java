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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DateUtilDiffblueTest {
  /**
   * Test {@link DateUtil#isActive(Date, Date, boolean)}.
   *
   * <ul>
   *   <li>When {@link Date#Date()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DateUtil#isActive(Date, Date, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DateUtil.isActive(Date, Date, boolean)"})
  public void testIsActive_whenDate_thenReturnFalse() {
    // Arrange
    Date startDate = new Date();

    // Act
    boolean actualIsActiveResult = DateUtil.isActive(startDate, new Date(), true);

    // Assert
    assertFalse(actualIsActiveResult);
  }

  /**
   * Test {@link DateUtil#isActive(Date, Date, boolean)}.
   *
   * <ul>
   *   <li>When from {@link LocalDate} with {@code 1970} and one and one atStartOfDay atZone {@link
   *       ZoneOffset#UTC} toInstant.
   * </ul>
   *
   * <p>Method under test: {@link DateUtil#isActive(Date, Date, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DateUtil.isActive(Date, Date, boolean)"})
  public void testIsActive_whenFromLocalDateWith1970AndOneAndOneAtStartOfDayAtZoneUtcToInstant() {
    // Arrange
    Date startDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    boolean actualIsActiveResult =
        DateUtil.isActive(
            startDate,
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()),
            true);

    // Assert
    assertFalse(actualIsActiveResult);
  }

  /**
   * Test {@link DateUtil#isActive(Date, Date, boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DateUtil#isActive(Date, Date, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DateUtil.isActive(Date, Date, boolean)"})
  public void testIsActive_whenNull_thenReturnFalse() {
    // Arrange and Act
    boolean actualIsActiveResult = DateUtil.isActive(null, null, false);

    // Assert
    assertFalse(actualIsActiveResult);
  }
}

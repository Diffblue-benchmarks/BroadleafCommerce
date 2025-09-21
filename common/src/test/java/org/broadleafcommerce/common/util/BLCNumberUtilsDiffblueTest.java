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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BLCNumberUtilsDiffblueTest {
  /**
   * Test {@link BLCNumberUtils#toLong(Object)}.
   *
   * <p>Method under test: {@link BLCNumberUtils#toLong(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long BLCNumberUtils.toLong(Object)"})
  public void testToLong() {
    // Arrange and Act
    Long actualToLongResult = BLCNumberUtils.toLong(1);

    // Assert
    assertEquals(1L, actualToLongResult.longValue());
  }

  /**
   * Test {@link BLCNumberUtils#toLong(Object)}.
   *
   * <p>Method under test: {@link BLCNumberUtils#toLong(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long BLCNumberUtils.toLong(Object)"})
  public void testToLong2() {
    // Arrange and Act
    Long actualToLongResult = BLCNumberUtils.toLong(1L);

    // Assert
    assertEquals(1L, actualToLongResult.longValue());
  }
}

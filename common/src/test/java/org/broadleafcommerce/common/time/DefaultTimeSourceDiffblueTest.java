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
package org.broadleafcommerce.common.time;

import org.junit.Ignore;
import org.junit.Test;

public class DefaultTimeSourceDiffblueTest {
  /**
   * Test {@link DefaultTimeSource#timeInMillis()}.
   * <p>
   * Method under test: {@link DefaultTimeSource#timeInMillis()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testTimeInMillis() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Method may be time-sensitive.
    //   Diffblue Cover was only able to write tests that are time-sensitive.
    //   The assertions don't pass when run at an alternate date, time, and
    //   timezone. Try refactoring the method to take a 'java.time.Clock' instance so
    //   that the time can be parameterized during testing.
    //   See Working with code R031 (https://diff.blue/R031) for details.

    // Arrange and Act
    (new DefaultTimeSource()).timeInMillis();
  }

  /**
   * Test new {@link DefaultTimeSource} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link DefaultTimeSource}
   */
  @Test
  public void testNewDefaultTimeSource() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   There are no fields that could be asserted on.

    // Arrange and Act
    new DefaultTimeSource();
  }
}

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
package org.broadleafcommerce.common.payment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import java.util.ArrayList;
import org.junit.Test;

public class AccountNumberMaskDiffblueTest {
  /**
   * Test {@link AccountNumberMask#mask(String)}.
   * <ul>
   *   <li>Then return {@code 72}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountNumberMask#mask(String)}
   */
  @Test
  public void testMask_thenReturn72() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<UnmaskRange> ranges = new ArrayList<>();
    ranges.add(new UnmaskRange(1, 1));

    // Act and Assert
    assertEquals("72", (new AccountNumberMask(ranges, '7')).mask("42"));
  }

  /**
   * Test {@link AccountNumberMask#mask(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code 77}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountNumberMask#mask(String)}
   */
  @Test
  public void testMask_when42_thenReturn77() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("77", (new AccountNumberMask(new ArrayList<>(), '7')).mask("42"));
  }

  /**
   * Test {@link AccountNumberMask#mask(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountNumberMask#mask(String)}
   */
  @Test
  public void testMask_whenNull_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new AccountNumberMask(new ArrayList<>(), '7')).mask(null));
  }
}

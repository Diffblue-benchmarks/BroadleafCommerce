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
package org.broadleafcommerce.common.time.domain;

import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {TemporalTimestampListener.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class TemporalTimestampListenerDiffblueTest {
  @Autowired
  private TemporalTimestampListener temporalTimestampListener;

  /**
   * Test {@link TemporalTimestampListener#setTimestamps(Object)} with
   * {@code entity}.
   * <p>
   * Method under test: {@link TemporalTimestampListener#setTimestamps(Object)}
   */
  @Test
  public void testSetTimestampsWithEntity() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new TemporalTimestampListener()).setTimestamps(BLCFieldUtils.NULL_FIELD);
  }

  /**
   * Test new {@link TemporalTimestampListener} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link TemporalTimestampListener}
   */
  @Test
  public void testNewTemporalTimestampListener() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   There are no fields that could be asserted on.

    // Arrange and Act
    new TemporalTimestampListener();
  }
}

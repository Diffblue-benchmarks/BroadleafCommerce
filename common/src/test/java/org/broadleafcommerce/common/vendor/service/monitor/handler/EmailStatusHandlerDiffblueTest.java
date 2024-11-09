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
package org.broadleafcommerce.common.vendor.service.monitor.handler;

import static org.junit.Assert.assertSame;
import org.broadleafcommerce.common.email.domain.EmailTarget;
import org.broadleafcommerce.common.email.domain.EmailTargetImpl;
import org.broadleafcommerce.common.email.service.info.EmailInfo;
import org.junit.Test;

public class EmailStatusHandlerDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link EmailStatusHandler}
   *   <li>{@link EmailStatusHandler#setEmailInfo(EmailInfo)}
   *   <li>{@link EmailStatusHandler#setEmailTarget(EmailTarget)}
   *   <li>{@link EmailStatusHandler#getEmailInfo()}
   *   <li>{@link EmailStatusHandler#getEmailTarget()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    EmailStatusHandler actualEmailStatusHandler = new EmailStatusHandler();
    EmailInfo emailInfo = new EmailInfo();
    actualEmailStatusHandler.setEmailInfo(emailInfo);
    EmailTargetImpl emailTarget = new EmailTargetImpl();
    actualEmailStatusHandler.setEmailTarget(emailTarget);
    EmailInfo actualEmailInfo = actualEmailStatusHandler.getEmailInfo();

    // Assert that nothing has changed
    assertSame(emailTarget, actualEmailStatusHandler.getEmailTarget());
    assertSame(emailInfo, actualEmailInfo);
  }
}

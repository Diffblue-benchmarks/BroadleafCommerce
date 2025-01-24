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
package org.broadleafcommerce.common.vendor.service.monitor.handler;

import static org.junit.Assert.assertSame;
import org.broadleafcommerce.common.email.domain.EmailTarget;
import org.broadleafcommerce.common.email.domain.EmailTargetImpl;
import org.broadleafcommerce.common.email.service.EmailService;
import org.broadleafcommerce.common.email.service.info.EmailInfo;
import org.broadleafcommerce.common.vendor.service.type.ServiceStatusType;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {EmailStatusHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class EmailStatusHandlerDiffblueTest {
  @MockBean
  private EmailService emailService;

  @Autowired
  private EmailStatusHandler emailStatusHandler;

  /**
   * Test {@link EmailStatusHandler#handleStatus(String, ServiceStatusType)}.
   * <p>
   * Method under test:
   * {@link EmailStatusHandler#handleStatus(String, ServiceStatusType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testHandleStatus() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.common.vendor.service.monitor.handler;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.common.vendor.service.monitor.handler.EmailStatusHandler.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass19089 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.email.service.EmailService emailService;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.common.vendor.service.monitor.handler.EmailStatusHandler emailStatusHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    emailStatusHandler.handleStatus("Service Name", ServiceStatusType.DOWN);
  }

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

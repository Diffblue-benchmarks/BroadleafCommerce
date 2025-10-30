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
package org.broadleafcommerce.common.notification.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.notification.service.type.Notification;
import org.broadleafcommerce.common.notification.service.type.SMSNotification;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {DefaultSMSNotificationServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultSMSNotificationServiceImplDiffblueTest {
  @Autowired
  private DefaultSMSNotificationServiceImpl defaultSMSNotificationServiceImpl;

  /**
   * Test {@link DefaultSMSNotificationServiceImpl#canHandle(Class)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultSMSNotificationServiceImpl#canHandle(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DefaultSMSNotificationServiceImpl.canHandle(Class)"})
  public void testCanHandle_thenReturnFalse() {
    // Arrange
    Class<Notification> clazz = Notification.class;

    // Act and Assert
    assertFalse(defaultSMSNotificationServiceImpl.canHandle(clazz));
  }

  /**
   * Test {@link DefaultSMSNotificationServiceImpl#canHandle(Class)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultSMSNotificationServiceImpl#canHandle(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DefaultSMSNotificationServiceImpl.canHandle(Class)"})
  public void testCanHandle_thenReturnTrue() {
    // Arrange
    Class<SMSNotification> clazz = SMSNotification.class;

    // Act and Assert
    assertTrue(defaultSMSNotificationServiceImpl.canHandle(clazz));
  }
}

/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.controller.contact;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.notification.service.NotificationDispatcher;
import org.broadleafcommerce.common.notification.service.type.Notification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {BroadleafContactUsController.class})
@ExtendWith(SpringExtension.class)
class BroadleafContactUsControllerDiffblueTest {
  @Autowired
  private BroadleafContactUsController broadleafContactUsController;

  @MockBean(name = "blNotificationDispatcher")
  private NotificationDispatcher notificationDispatcher;

  /**
   * Test
   * {@link BroadleafContactUsController#sendConfirmationEmail(String, String, String)}.
   * <ul>
   *   <li>Then return {@code contactus/success}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafContactUsController#sendConfirmationEmail(String, String, String)}
   */
  @Test
  @DisplayName("Test sendConfirmationEmail(String, String, String); then return 'contactus/success'")
  void testSendConfirmationEmail_thenReturnContactusSuccess() throws ServiceException {
    // Arrange
    doNothing().when(notificationDispatcher).dispatchNotification(Mockito.<Notification>any());

    // Act
    String actualSendConfirmationEmailResult = broadleafContactUsController.sendConfirmationEmail("Name", "42 Main St",
        "Comments");

    // Assert
    verify(notificationDispatcher).dispatchNotification(isA(Notification.class));
    assertEquals("contactus/success", actualSendConfirmationEmailResult);
  }

  /**
   * Test
   * {@link BroadleafContactUsController#sendConfirmationEmail(String, String, String)}.
   * <ul>
   *   <li>Then return {@code redirect:/contactus}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafContactUsController#sendConfirmationEmail(String, String, String)}
   */
  @Test
  @DisplayName("Test sendConfirmationEmail(String, String, String); then return 'redirect:/contactus'")
  void testSendConfirmationEmail_thenReturnRedirectContactus() throws ServiceException {
    // Arrange
    doThrow(new ServiceException("An error occurred")).when(notificationDispatcher)
        .dispatchNotification(Mockito.<Notification>any());

    // Act
    String actualSendConfirmationEmailResult = broadleafContactUsController.sendConfirmationEmail("Name", "42 Main St",
        "Comments");

    // Assert
    verify(notificationDispatcher).dispatchNotification(isA(Notification.class));
    assertEquals("redirect:/contactus", actualSendConfirmationEmailResult);
  }

  /**
   * Test {@link BroadleafContactUsController#index()}.
   * <p>
   * Method under test: {@link BroadleafContactUsController#index()}
   */
  @Test
  @DisplayName("Test index()")
  void testIndex() {
    // Arrange, Act and Assert
    assertEquals("contactus/contactus", broadleafContactUsController.index());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link BroadleafContactUsController}
   *   <li>{@link BroadleafContactUsController#getPath()}
   *   <li>{@link BroadleafContactUsController#getSuccessView()}
   *   <li>{@link BroadleafContactUsController#getView()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    BroadleafContactUsController actualBroadleafContactUsController = new BroadleafContactUsController();
    String actualPath = actualBroadleafContactUsController.getPath();
    String actualSuccessView = actualBroadleafContactUsController.getSuccessView();

    // Assert
    assertEquals("/contactus", actualPath);
    assertEquals("contactus/contactus", actualBroadleafContactUsController.getView());
    assertEquals("contactus/success", actualSuccessView);
  }
}

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
package org.broadleafcommerce.common.email.service;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.email.domain.EmailTarget;
import org.broadleafcommerce.common.email.domain.EmailTargetImpl;
import org.broadleafcommerce.common.email.service.info.EmailInfo;
import org.broadleafcommerce.common.email.service.info.NullEmailInfo;
import org.broadleafcommerce.common.email.service.info.ServerInfo;
import org.broadleafcommerce.common.email.service.message.EmailServiceProducer;
import org.broadleafcommerce.common.email.service.message.MessageCreator;
import org.broadleafcommerce.common.email.service.message.NullMessageCreator;
import org.junit.Test;
import org.mockito.Mockito;

public class EmailServiceImplDiffblueTest {
  /**
   * Method under test:
   * {@link EmailServiceImpl#sendTemplateEmail(String, EmailInfo, Map)}
   */
  @Test
  public void testSendTemplateEmail() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EmailServiceImpl emailServiceImpl = new EmailServiceImpl();
    NullEmailInfo emailInfo = new NullEmailInfo();

    // Act and Assert
    assertTrue(emailServiceImpl.sendTemplateEmail("42 Main St", emailInfo, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link EmailServiceImpl#sendTemplateEmail(EmailTarget, EmailInfo, Map)}
   */
  @Test
  public void testSendTemplateEmail2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EmailTrackingManagerImpl emailTrackingManager = mock(EmailTrackingManagerImpl.class);
    when(emailTrackingManager.createTrackedEmail(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(1L);

    EmailServiceImpl emailServiceImpl = new EmailServiceImpl();
    emailServiceImpl.setMessageCreator(new NullMessageCreator(new LoggingMailSender()));
    emailServiceImpl.setEmailTrackingManager(emailTrackingManager);
    emailServiceImpl.setEmailServiceProducer(null);

    // Act
    boolean actualSendTemplateEmailResult = emailServiceImpl.sendTemplateEmail(new EmailTargetImpl(), null, null);

    // Assert
    verify(emailTrackingManager).createTrackedEmail(isNull(), isNull(), isNull());
    assertTrue(actualSendTemplateEmailResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EmailServiceImpl#setEmailServiceProducer(EmailServiceProducer)}
   *   <li>{@link EmailServiceImpl#setEmailTrackingManager(EmailTrackingManager)}
   *   <li>{@link EmailServiceImpl#setMessageCreator(MessageCreator)}
   *   <li>{@link EmailServiceImpl#setServerInfo(ServerInfo)}
   *   <li>{@link EmailServiceImpl#getEmailServiceProducer()}
   *   <li>{@link EmailServiceImpl#getEmailTrackingManager()}
   *   <li>{@link EmailServiceImpl#getMessageCreator()}
   *   <li>{@link EmailServiceImpl#getServerInfo()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    EmailServiceImpl emailServiceImpl = new EmailServiceImpl();
    EmailServiceProducer emailServiceProducer = mock(EmailServiceProducer.class);

    // Act
    emailServiceImpl.setEmailServiceProducer(emailServiceProducer);
    EmailTrackingManagerImpl emailTrackingManager = new EmailTrackingManagerImpl();
    emailServiceImpl.setEmailTrackingManager(emailTrackingManager);
    NullMessageCreator messageCreator = new NullMessageCreator(new LoggingMailSender());
    emailServiceImpl.setMessageCreator(messageCreator);
    ServerInfo serverInfo = new ServerInfo();
    serverInfo.setAppName("App Name");
    serverInfo.setSecurePort(8080);
    serverInfo.setServerName("Server Name");
    serverInfo.setServerPort(8080);
    emailServiceImpl.setServerInfo(serverInfo);
    EmailServiceProducer actualEmailServiceProducer = emailServiceImpl.getEmailServiceProducer();
    EmailTrackingManager actualEmailTrackingManager = emailServiceImpl.getEmailTrackingManager();
    MessageCreator actualMessageCreator = emailServiceImpl.getMessageCreator();

    // Assert that nothing has changed
    assertTrue(actualEmailTrackingManager instanceof EmailTrackingManagerImpl);
    assertSame(emailTrackingManager, actualEmailTrackingManager);
    assertSame(serverInfo, emailServiceImpl.getServerInfo());
    assertSame(messageCreator, actualMessageCreator);
    assertSame(emailServiceProducer, actualEmailServiceProducer);
  }

  /**
   * Method under test:
   * {@link EmailServiceImpl#sendBasicEmail(EmailInfo, EmailTarget, Map)}
   */
  @Test
  public void testSendBasicEmail() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EmailServiceImpl emailServiceImpl = new EmailServiceImpl();
    emailServiceImpl.setMessageCreator(new NullMessageCreator(new LoggingMailSender()));
    emailServiceImpl.setEmailServiceProducer(null);

    // Act and Assert
    assertTrue(emailServiceImpl.sendBasicEmail(null, new EmailTargetImpl(), null));
  }
}

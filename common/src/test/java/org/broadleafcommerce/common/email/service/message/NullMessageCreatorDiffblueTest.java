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
package org.broadleafcommerce.common.email.service.message;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.email.service.LoggingMailSender;
import org.broadleafcommerce.common.email.service.info.EmailInfo;
import org.junit.Test;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class NullMessageCreatorDiffblueTest {
  /**
   * Test {@link NullMessageCreator#NullMessageCreator(JavaMailSender)}.
   * <p>
   * Method under test:
   * {@link NullMessageCreator#NullMessageCreator(JavaMailSender)}
   */
  @Test
  public void testNewNullMessageCreator() {
    // Arrange
    LoggingMailSender mailSender = new LoggingMailSender();

    // Act and Assert
    assertSame(mailSender, (new NullMessageCreator(mailSender)).getMailSender());
  }

  /**
   * Test {@link NullMessageCreator#buildMessageBody(EmailInfo, Map)}.
   * <ul>
   *   <li>Given {@link NullMessageCreator#NullMessageCreator(JavaMailSender)} with
   * mailSender is {@link JavaMailSenderImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NullMessageCreator#buildMessageBody(EmailInfo, Map)}
   */
  @Test
  public void testBuildMessageBody_givenNullMessageCreatorWithMailSenderIsJavaMailSenderImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NullMessageCreator nullMessageCreator = new NullMessageCreator(mock(JavaMailSenderImpl.class));
    EmailInfo info = new EmailInfo();

    // Act and Assert
    assertNull(nullMessageCreator.buildMessageBody(info, new HashMap<>()));
  }

  /**
   * Test {@link NullMessageCreator#buildMessageBody(EmailInfo, Map)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NullMessageCreator#buildMessageBody(EmailInfo, Map)}
   */
  @Test
  public void testBuildMessageBody_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NullMessageCreator nullMessageCreator = new NullMessageCreator(new LoggingMailSender());
    EmailInfo info = new EmailInfo();

    // Act and Assert
    assertNull(nullMessageCreator.buildMessageBody(info, new HashMap<>()));
  }
}

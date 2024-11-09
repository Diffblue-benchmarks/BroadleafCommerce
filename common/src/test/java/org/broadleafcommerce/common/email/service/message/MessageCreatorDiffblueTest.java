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

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.common.email.service.LoggingMailSender;
import org.junit.Test;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class MessageCreatorDiffblueTest {
  /**
   * Test {@link MessageCreator#getMailSender()}.
   * <ul>
   *   <li>Then return {@link LoggingMailSender} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MessageCreator#getMailSender()}
   */
  @Test
  public void testGetMailSender_thenReturnLoggingMailSender() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LoggingMailSender mailSender = new LoggingMailSender();

    // Act and Assert
    assertSame(mailSender, (new NullMessageCreator(mailSender)).getMailSender());
  }

  /**
   * Test {@link MessageCreator#setMailSender(JavaMailSender)}.
   * <p>
   * Method under test: {@link MessageCreator#setMailSender(JavaMailSender)}
   */
  @Test
  public void testSetMailSender() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NullMessageCreator nullMessageCreator = new NullMessageCreator(new LoggingMailSender());
    LoggingMailSender mailSender = new LoggingMailSender();

    // Act
    nullMessageCreator.setMailSender(mailSender);

    // Assert
    assertSame(mailSender, nullMessageCreator.getMailSender());
  }

  /**
   * Test {@link MessageCreator#setMailSender(JavaMailSender)}.
   * <p>
   * Method under test: {@link MessageCreator#setMailSender(JavaMailSender)}
   */
  @Test
  public void testSetMailSender2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NullMessageCreator nullMessageCreator = new NullMessageCreator(mock(JavaMailSenderImpl.class));
    LoggingMailSender mailSender = new LoggingMailSender();

    // Act
    nullMessageCreator.setMailSender(mailSender);

    // Assert
    assertSame(mailSender, nullMessageCreator.getMailSender());
  }
}

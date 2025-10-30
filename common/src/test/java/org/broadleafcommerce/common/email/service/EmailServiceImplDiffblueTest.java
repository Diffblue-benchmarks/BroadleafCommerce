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

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.email.dao.EmailReportingDao;
import org.broadleafcommerce.common.email.domain.EmailTarget;
import org.broadleafcommerce.common.email.domain.EmailTargetImpl;
import org.broadleafcommerce.common.email.service.exception.EmailException;
import org.broadleafcommerce.common.email.service.info.EmailInfo;
import org.broadleafcommerce.common.email.service.info.NullEmailInfo;
import org.broadleafcommerce.common.email.service.info.ServerInfo;
import org.broadleafcommerce.common.email.service.message.EmailServiceProducer;
import org.broadleafcommerce.common.email.service.message.MessageCreator;
import org.broadleafcommerce.common.email.service.message.NullMessageCreator;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mail.MailException;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class EmailServiceImplDiffblueTest {
  @InjectMocks
  private EmailServiceImpl emailServiceImpl;

  @Mock
  private MessageCreator messageCreator;

  @Mock
  private EmailReportingDao emailReportingDao;

  @Mock
  private EmailTrackingManager emailTrackingManager;

  /**
   * Test {@link EmailServiceImpl#sendTemplateEmail(String, EmailInfo, Map)} with {@code emailAddress}, {@code emailInfo}, {@code props}.
   * <p>
   * Method under test: {@link EmailServiceImpl#sendTemplateEmail(String, EmailInfo, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EmailServiceImpl.sendTemplateEmail(String, EmailInfo, Map)"})
  public void testSendTemplateEmailWithEmailAddressEmailInfoProps() throws MailException {
    // Arrange
    when(emailReportingDao.createTarget()).thenReturn(new EmailTargetImpl());
    when(emailTrackingManager.createTrackedEmail(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(1L);
    doNothing().when(messageCreator).sendMessage(Mockito.<Map<String, Object>>any());
    EmailInfo emailInfo = new EmailInfo();

    // Act
    boolean actualSendTemplateEmailResult = emailServiceImpl.sendTemplateEmail("42 Main St", emailInfo,
        new HashMap<>());

    // Assert
    verify(emailReportingDao).createTarget();
    verify(emailTrackingManager).createTrackedEmail(eq("42 Main St"), isNull(), isNull());
    verify(messageCreator).sendMessage(isA(Map.class));
    assertTrue(actualSendTemplateEmailResult);
  }

  /**
   * Test {@link EmailServiceImpl#sendTemplateEmail(String, EmailInfo, Map)} with {@code emailAddress}, {@code emailInfo}, {@code props}.
   * <p>
   * Method under test: {@link EmailServiceImpl#sendTemplateEmail(String, EmailInfo, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EmailServiceImpl.sendTemplateEmail(String, EmailInfo, Map)"})
  public void testSendTemplateEmailWithEmailAddressEmailInfoProps2() throws MailException {
    // Arrange
    when(emailReportingDao.createTarget()).thenReturn(new EmailTargetImpl());
    when(emailTrackingManager.createTrackedEmail(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(1L);
    doThrow(new EmailException("emailTrackingId")).when(messageCreator).sendMessage(Mockito.<Map<String, Object>>any());
    EmailInfo emailInfo = new EmailInfo();

    // Act and Assert
    assertThrows(EmailException.class,
        () -> emailServiceImpl.sendTemplateEmail("42 Main St", emailInfo, new HashMap<>()));
    verify(emailReportingDao).createTarget();
    verify(emailTrackingManager).createTrackedEmail(eq("42 Main St"), isNull(), isNull());
    verify(messageCreator).sendMessage(isA(Map.class));
  }

  /**
   * Test {@link EmailServiceImpl#sendTemplateEmail(String, EmailInfo, Map)} with {@code emailAddress}, {@code emailInfo}, {@code props}.
   * <p>
   * Method under test: {@link EmailServiceImpl#sendTemplateEmail(String, EmailInfo, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EmailServiceImpl.sendTemplateEmail(String, EmailInfo, Map)"})
  public void testSendTemplateEmailWithEmailAddressEmailInfoProps3() throws MailException {
    // Arrange
    when(emailReportingDao.createTarget()).thenReturn(new EmailTargetImpl());
    when(emailTrackingManager.createTrackedEmail(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(1L);
    doNothing().when(messageCreator).sendMessage(Mockito.<Map<String, Object>>any());
    emailServiceImpl.setEmailServiceProducer(null);

    // Act
    boolean actualSendTemplateEmailResult = emailServiceImpl.sendTemplateEmail("42 Main St", null, null);

    // Assert
    verify(emailReportingDao).createTarget();
    verify(emailTrackingManager).createTrackedEmail(eq("42 Main St"), isNull(), isNull());
    verify(messageCreator).sendMessage(isA(Map.class));
    assertTrue(actualSendTemplateEmailResult);
  }

  /**
   * Test {@link EmailServiceImpl#sendTemplateEmail(String, EmailInfo, Map)} with {@code emailAddress}, {@code emailInfo}, {@code props}.
   * <ul>
   *   <li>Then calls {@link EmailTarget#setEmailAddress(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailServiceImpl#sendTemplateEmail(String, EmailInfo, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EmailServiceImpl.sendTemplateEmail(String, EmailInfo, Map)"})
  public void testSendTemplateEmailWithEmailAddressEmailInfoProps_thenCallsSetEmailAddress() {
    // Arrange
    EmailTarget emailTarget = mock(EmailTarget.class);
    doThrow(new EmailException("Arg0")).when(emailTarget).setEmailAddress(Mockito.<String>any());
    when(emailReportingDao.createTarget()).thenReturn(emailTarget);
    EmailInfo emailInfo = new EmailInfo();

    // Act and Assert
    assertThrows(EmailException.class,
        () -> emailServiceImpl.sendTemplateEmail("42 Main St", emailInfo, new HashMap<>()));
    verify(emailReportingDao).createTarget();
    verify(emailTarget).setEmailAddress(eq("42 Main St"));
  }

  /**
   * Test {@link EmailServiceImpl#sendTemplateEmail(String, EmailInfo, Map)} with {@code emailAddress}, {@code emailInfo}, {@code props}.
   * <ul>
   *   <li>When {@link NullEmailInfo#NullEmailInfo()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailServiceImpl#sendTemplateEmail(String, EmailInfo, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EmailServiceImpl.sendTemplateEmail(String, EmailInfo, Map)"})
  public void testSendTemplateEmailWithEmailAddressEmailInfoProps_whenNullEmailInfo() throws IOException {
    // Arrange
    NullEmailInfo emailInfo = new NullEmailInfo();

    // Act and Assert
    assertTrue(emailServiceImpl.sendTemplateEmail("42 Main St", emailInfo, new HashMap<>()));
  }

  /**
   * Test {@link EmailServiceImpl#sendTemplateEmail(EmailTarget, EmailInfo, Map)} with {@code emailTarget}, {@code emailInfo}, {@code props}.
   * <p>
   * Method under test: {@link EmailServiceImpl#sendTemplateEmail(EmailTarget, EmailInfo, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EmailServiceImpl.sendTemplateEmail(EmailTarget, EmailInfo, Map)"})
  public void testSendTemplateEmailWithEmailTargetEmailInfoProps() throws MailException {
    // Arrange
    when(emailTrackingManager.createTrackedEmail(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(1L);
    doNothing().when(messageCreator).sendMessage(Mockito.<Map<String, Object>>any());
    emailServiceImpl.setEmailServiceProducer(null);

    // Act
    boolean actualSendTemplateEmailResult = emailServiceImpl.sendTemplateEmail(new EmailTargetImpl(), null, null);

    // Assert
    verify(emailTrackingManager).createTrackedEmail(isNull(), isNull(), isNull());
    verify(messageCreator).sendMessage(isA(Map.class));
    assertTrue(actualSendTemplateEmailResult);
  }

  /**
   * Test {@link EmailServiceImpl#sendTemplateEmail(EmailTarget, EmailInfo, Map)} with {@code emailTarget}, {@code emailInfo}, {@code props}.
   * <ul>
   *   <li>Then throw {@link EmailException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailServiceImpl#sendTemplateEmail(EmailTarget, EmailInfo, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EmailServiceImpl.sendTemplateEmail(EmailTarget, EmailInfo, Map)"})
  public void testSendTemplateEmailWithEmailTargetEmailInfoProps_thenThrowEmailException() throws MailException {
    // Arrange
    when(emailTrackingManager.createTrackedEmail(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(1L);
    doThrow(new EmailException("emailTrackingId")).when(messageCreator).sendMessage(Mockito.<Map<String, Object>>any());
    EmailTargetImpl emailTarget = new EmailTargetImpl();
    EmailInfo emailInfo = new EmailInfo();

    // Act and Assert
    assertThrows(EmailException.class,
        () -> emailServiceImpl.sendTemplateEmail(emailTarget, emailInfo, new HashMap<>()));
    verify(emailTrackingManager).createTrackedEmail(isNull(), isNull(), isNull());
    verify(messageCreator).sendMessage(isA(Map.class));
  }

  /**
   * Test {@link EmailServiceImpl#sendTemplateEmail(EmailTarget, EmailInfo, Map)} with {@code emailTarget}, {@code emailInfo}, {@code props}.
   * <ul>
   *   <li>When {@link EmailInfo} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailServiceImpl#sendTemplateEmail(EmailTarget, EmailInfo, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EmailServiceImpl.sendTemplateEmail(EmailTarget, EmailInfo, Map)"})
  public void testSendTemplateEmailWithEmailTargetEmailInfoProps_whenEmailInfo_thenReturnTrue() throws MailException {
    // Arrange
    when(emailTrackingManager.createTrackedEmail(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(1L);
    doNothing().when(messageCreator).sendMessage(Mockito.<Map<String, Object>>any());
    EmailTargetImpl emailTarget = new EmailTargetImpl();
    EmailInfo emailInfo = new EmailInfo();

    // Act
    boolean actualSendTemplateEmailResult = emailServiceImpl.sendTemplateEmail(emailTarget, emailInfo, new HashMap<>());

    // Assert
    verify(emailTrackingManager).createTrackedEmail(isNull(), isNull(), isNull());
    verify(messageCreator).sendMessage(isA(Map.class));
    assertTrue(actualSendTemplateEmailResult);
  }

  /**
   * Test {@link EmailServiceImpl#sendTemplateEmail(EmailTarget, EmailInfo, Map)} with {@code emailTarget}, {@code emailInfo}, {@code props}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailServiceImpl#sendTemplateEmail(EmailTarget, EmailInfo, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EmailServiceImpl.sendTemplateEmail(EmailTarget, EmailInfo, Map)"})
  public void testSendTemplateEmailWithEmailTargetEmailInfoProps_whenNull_thenReturnTrue() throws MailException {
    // Arrange
    when(emailTrackingManager.createTrackedEmail(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(1L);
    doNothing().when(messageCreator).sendMessage(Mockito.<Map<String, Object>>any());
    EmailTargetImpl emailTarget = new EmailTargetImpl();

    // Act
    boolean actualSendTemplateEmailResult = emailServiceImpl.sendTemplateEmail(emailTarget, null, new HashMap<>());

    // Assert
    verify(emailTrackingManager).createTrackedEmail(isNull(), isNull(), isNull());
    verify(messageCreator).sendMessage(isA(Map.class));
    assertTrue(actualSendTemplateEmailResult);
  }

  /**
   * Test {@link EmailServiceImpl#sendBasicEmail(EmailInfo, EmailTarget, Map)}.
   * <ul>
   *   <li>Given {@link EmailServiceImpl} EmailServiceProducer is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailServiceImpl#sendBasicEmail(EmailInfo, EmailTarget, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EmailServiceImpl.sendBasicEmail(EmailInfo, EmailTarget, Map)"})
  public void testSendBasicEmail_givenEmailServiceImplEmailServiceProducerIsNull() throws MailException {
    // Arrange
    doNothing().when(messageCreator).sendMessage(Mockito.<Map<String, Object>>any());
    emailServiceImpl.setEmailServiceProducer(null);

    // Act
    boolean actualSendBasicEmailResult = emailServiceImpl.sendBasicEmail(null, new EmailTargetImpl(), null);

    // Assert
    verify(messageCreator).sendMessage(isA(Map.class));
    assertTrue(actualSendBasicEmailResult);
  }

  /**
   * Test {@link EmailServiceImpl#sendBasicEmail(EmailInfo, EmailTarget, Map)}.
   * <ul>
   *   <li>Given {@link MessageCreator} {@link MessageCreator#sendMessage(Map)} does nothing.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailServiceImpl#sendBasicEmail(EmailInfo, EmailTarget, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EmailServiceImpl.sendBasicEmail(EmailInfo, EmailTarget, Map)"})
  public void testSendBasicEmail_givenMessageCreatorSendMessageDoesNothing_thenReturnTrue() throws MailException {
    // Arrange
    doNothing().when(messageCreator).sendMessage(Mockito.<Map<String, Object>>any());
    EmailTargetImpl emailTarget = new EmailTargetImpl();

    // Act
    boolean actualSendBasicEmailResult = emailServiceImpl.sendBasicEmail(null, emailTarget, new HashMap<>());

    // Assert
    verify(messageCreator).sendMessage(isA(Map.class));
    assertTrue(actualSendBasicEmailResult);
  }

  /**
   * Test {@link EmailServiceImpl#sendBasicEmail(EmailInfo, EmailTarget, Map)}.
   * <ul>
   *   <li>Then throw {@link EmailException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailServiceImpl#sendBasicEmail(EmailInfo, EmailTarget, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EmailServiceImpl.sendBasicEmail(EmailInfo, EmailTarget, Map)"})
  public void testSendBasicEmail_thenThrowEmailException() throws MailException {
    // Arrange
    doThrow(new EmailException("Arg0")).when(messageCreator).sendMessage(Mockito.<Map<String, Object>>any());
    emailServiceImpl.setEmailServiceProducer(null);

    // Act and Assert
    assertThrows(EmailException.class, () -> emailServiceImpl.sendBasicEmail(null, new EmailTargetImpl(), null));
    verify(messageCreator).sendMessage(isA(Map.class));
  }

  /**
   * Test {@link EmailServiceImpl#sendBasicEmail(EmailInfo, EmailTarget, Map)}.
   * <ul>
   *   <li>When {@link EmailInfo} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailServiceImpl#sendBasicEmail(EmailInfo, EmailTarget, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EmailServiceImpl.sendBasicEmail(EmailInfo, EmailTarget, Map)"})
  public void testSendBasicEmail_whenEmailInfo_thenReturnTrue() throws MailException {
    // Arrange
    doNothing().when(messageCreator).sendMessage(Mockito.<Map<String, Object>>any());
    EmailInfo emailInfo = new EmailInfo();
    EmailTargetImpl emailTarget = new EmailTargetImpl();

    // Act
    boolean actualSendBasicEmailResult = emailServiceImpl.sendBasicEmail(emailInfo, emailTarget, new HashMap<>());

    // Assert
    verify(messageCreator).sendMessage(isA(Map.class));
    assertTrue(actualSendBasicEmailResult);
  }

  /**
   * Test getters and setters.
   * <p>
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EmailServiceProducer EmailServiceImpl.getEmailServiceProducer()",
      "EmailTrackingManager EmailServiceImpl.getEmailTrackingManager()",
      "MessageCreator EmailServiceImpl.getMessageCreator()", "ServerInfo EmailServiceImpl.getServerInfo()",
      "void EmailServiceImpl.setEmailServiceProducer(EmailServiceProducer)",
      "void EmailServiceImpl.setEmailTrackingManager(EmailTrackingManager)",
      "void EmailServiceImpl.setMessageCreator(MessageCreator)", "void EmailServiceImpl.setServerInfo(ServerInfo)"})
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

    // Assert
    assertTrue(actualEmailTrackingManager instanceof EmailTrackingManagerImpl);
    assertNull(((EmailTrackingManagerImpl) actualEmailTrackingManager).emailReportingDao);
    assertSame(emailTrackingManager, actualEmailTrackingManager);
    assertSame(serverInfo, emailServiceImpl.getServerInfo());
    assertSame(messageCreator, actualMessageCreator);
    assertSame(emailServiceProducer, actualEmailServiceProducer);
  }
}

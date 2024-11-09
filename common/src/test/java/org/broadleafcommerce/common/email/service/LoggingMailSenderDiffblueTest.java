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
package org.broadleafcommerce.common.email.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.Map;
import java.util.Properties;
import javax.mail.Provider;
import javax.mail.Session;
import org.junit.Test;
import org.springframework.mail.javamail.ConfigurableMimeFileTypeMap;

public class LoggingMailSenderDiffblueTest {
  /**
   * Test new {@link LoggingMailSender} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link LoggingMailSender}
   */
  @Test
  public void testNewLoggingMailSender() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    LoggingMailSender actualLoggingMailSender = new LoggingMailSender();

    // Assert
    assertTrue(actualLoggingMailSender.getDefaultFileTypeMap() instanceof ConfigurableMimeFileTypeMap);
    Session session = actualLoggingMailSender.getSession();
    Provider[] providers = session.getProviders();
    Provider provider = providers[0];
    assertEquals("Oracle", provider.getVendor());
    Provider provider2 = providers[1];
    assertEquals("Oracle", provider2.getVendor());
    Provider provider3 = providers[2];
    assertEquals("Oracle", provider3.getVendor());
    Provider provider4 = providers[3];
    assertEquals("Oracle", provider4.getVendor());
    Provider provider5 = providers[4];
    assertEquals("Oracle", provider5.getVendor());
    Provider provider6 = providers[5];
    assertEquals("Oracle", provider6.getVendor());
    Provider.Type type = provider.getType();
    assertEquals("STORE", type.toString());
    Provider.Type type2 = provider3.getType();
    assertEquals("TRANSPORT", type2.toString());
    assertEquals("com.sun.mail.imap.IMAPSSLStore", provider2.getClassName());
    assertEquals("com.sun.mail.imap.IMAPStore", provider.getClassName());
    assertEquals("com.sun.mail.pop3.POP3SSLStore", provider6.getClassName());
    assertEquals("com.sun.mail.pop3.POP3Store", provider5.getClassName());
    assertEquals("com.sun.mail.smtp.SMTPSSLTransport", provider4.getClassName());
    assertEquals("com.sun.mail.smtp.SMTPTransport", provider3.getClassName());
    assertEquals("imap", provider.getProtocol());
    assertEquals("imaps", provider2.getProtocol());
    assertEquals("pop3", provider5.getProtocol());
    assertEquals("pop3s", provider6.getProtocol());
    assertEquals("smtp", provider3.getProtocol());
    assertEquals("smtps", provider4.getProtocol());
    assertNull(provider.getVersion());
    assertNull(provider2.getVersion());
    assertNull(provider3.getVersion());
    assertNull(provider4.getVersion());
    assertNull(provider5.getVersion());
    assertNull(provider6.getVersion());
    assertNull(actualLoggingMailSender.getDefaultEncoding());
    assertNull(actualLoggingMailSender.getHost());
    assertNull(actualLoggingMailSender.getPassword());
    assertNull(actualLoggingMailSender.getProtocol());
    assertNull(actualLoggingMailSender.getUsername());
    assertEquals(-1, actualLoggingMailSender.getPort());
    assertEquals(6, providers.length);
    assertFalse(session.getDebug());
    Properties javaMailProperties = actualLoggingMailSender.getJavaMailProperties();
    assertTrue(javaMailProperties.isEmpty());
    assertSame(type, provider2.getType());
    assertSame(type, provider5.getType());
    assertSame(type, provider6.getType());
    assertSame(type2, provider4.getType());
    assertSame(javaMailProperties, session.getProperties());
  }
}

package org.broadleafcommerce.common.email.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Properties;
import javax.mail.Session;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.ConfigurableMimeFileTypeMap;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {LoggingMailSender.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class LoggingMailSenderDiffblueTest {
  @Autowired private LoggingMailSender loggingMailSender;

  /**
   * Test new {@link LoggingMailSender} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link LoggingMailSender}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LoggingMailSender.<init>()"})
  public void testNewLoggingMailSender() {
    // Arrange and Act
    LoggingMailSender actualLoggingMailSender = new LoggingMailSender();

    // Assert
    assertTrue(
        actualLoggingMailSender.getDefaultFileTypeMap() instanceof ConfigurableMimeFileTypeMap);
    assertNull(actualLoggingMailSender.getDefaultEncoding());
    assertNull(actualLoggingMailSender.getHost());
    assertNull(actualLoggingMailSender.getPassword());
    assertNull(actualLoggingMailSender.getProtocol());
    assertNull(actualLoggingMailSender.getUsername());
    assertEquals(-1, actualLoggingMailSender.getPort());
    Session session = actualLoggingMailSender.getSession();
    assertEquals(6, session.getProviders().length);
    assertFalse(session.getDebug());
    Properties javaMailProperties = actualLoggingMailSender.getJavaMailProperties();
    assertTrue(javaMailProperties.isEmpty());
    assertSame(javaMailProperties, session.getProperties());
  }
}

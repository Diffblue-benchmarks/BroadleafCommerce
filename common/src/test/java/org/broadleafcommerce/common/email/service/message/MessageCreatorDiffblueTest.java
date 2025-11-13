package org.broadleafcommerce.common.email.service.message;

import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.email.service.LoggingMailSender;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MessageCreatorDiffblueTest {
  /**
   * Test {@link MessageCreator#getMailSender()}.
   *
   * <p>Method under test: {@link MessageCreator#getMailSender()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.mail.javamail.JavaMailSender MessageCreator.getMailSender()"
  })
  public void testGetMailSender() {
    // Arrange
    LoggingMailSender mailSender = new LoggingMailSender();

    // Act and Assert
    assertSame(mailSender, new NullMessageCreator(mailSender).getMailSender());
  }
}

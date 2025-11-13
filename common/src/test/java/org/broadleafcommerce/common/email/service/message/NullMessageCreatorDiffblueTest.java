package org.broadleafcommerce.common.email.service.message;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.email.service.LoggingMailSender;
import org.broadleafcommerce.common.email.service.info.EmailInfo;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {NullMessageCreator.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class NullMessageCreatorDiffblueTest {
  @MockBean private JavaMailSender javaMailSender;

  @Autowired private NullMessageCreator nullMessageCreator;

  /**
   * Test {@link NullMessageCreator#NullMessageCreator(JavaMailSender)}.
   *
   * <p>Method under test: {@link NullMessageCreator#NullMessageCreator(JavaMailSender)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NullMessageCreator.<init>(JavaMailSender)"})
  public void testNewNullMessageCreator() {
    // Arrange
    LoggingMailSender mailSender = new LoggingMailSender();

    // Act and Assert
    assertSame(mailSender, new NullMessageCreator(mailSender).getMailSender());
  }

  /**
   * Test {@link NullMessageCreator#buildMessageBody(EmailInfo, Map)}.
   *
   * <ul>
   *   <li>When {@link EmailInfo} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NullMessageCreator#buildMessageBody(EmailInfo, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String NullMessageCreator.buildMessageBody(EmailInfo, Map)"})
  public void testBuildMessageBody_whenEmailInfo_thenReturnNull() {
    // Arrange
    EmailInfo info = new EmailInfo();

    // Act and Assert
    assertNull(nullMessageCreator.buildMessageBody(info, new HashMap<>()));
  }
}

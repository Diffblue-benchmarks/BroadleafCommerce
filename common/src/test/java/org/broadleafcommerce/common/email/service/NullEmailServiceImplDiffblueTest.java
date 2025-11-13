package org.broadleafcommerce.common.email.service;

import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.email.domain.EmailTarget;
import org.broadleafcommerce.common.email.domain.EmailTargetImpl;
import org.broadleafcommerce.common.email.service.info.EmailInfo;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {NullEmailServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class NullEmailServiceImplDiffblueTest {
  @Autowired private NullEmailServiceImpl nullEmailServiceImpl;

  /**
   * Test {@link NullEmailServiceImpl#sendTemplateEmail(String, EmailInfo, Map)} with {@code
   * emailAddress}, {@code emailInfo}, {@code props}.
   *
   * <p>Method under test: {@link NullEmailServiceImpl#sendTemplateEmail(String, EmailInfo, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NullEmailServiceImpl.sendTemplateEmail(String, EmailInfo, Map)"})
  public void testSendTemplateEmailWithEmailAddressEmailInfoProps() {
    // Arrange
    EmailInfo emailInfo = new EmailInfo();

    // Act and Assert
    assertTrue(nullEmailServiceImpl.sendTemplateEmail("42 Main St", emailInfo, new HashMap<>()));
  }

  /**
   * Test {@link NullEmailServiceImpl#sendTemplateEmail(EmailTarget, EmailInfo, Map)} with {@code
   * emailTarget}, {@code emailInfo}, {@code props}.
   *
   * <p>Method under test: {@link NullEmailServiceImpl#sendTemplateEmail(EmailTarget, EmailInfo,
   * Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NullEmailServiceImpl.sendTemplateEmail(EmailTarget, EmailInfo, Map)"})
  public void testSendTemplateEmailWithEmailTargetEmailInfoProps() {
    // Arrange
    EmailTargetImpl emailTarget = new EmailTargetImpl();
    EmailInfo emailInfo = new EmailInfo();

    // Act and Assert
    assertTrue(nullEmailServiceImpl.sendTemplateEmail(emailTarget, emailInfo, new HashMap<>()));
  }

  /**
   * Test {@link NullEmailServiceImpl#sendBasicEmail(EmailInfo, EmailTarget, Map)}.
   *
   * <p>Method under test: {@link NullEmailServiceImpl#sendBasicEmail(EmailInfo, EmailTarget, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NullEmailServiceImpl.sendBasicEmail(EmailInfo, EmailTarget, Map)"})
  public void testSendBasicEmail() {
    // Arrange
    EmailInfo emailInfo = new EmailInfo();
    EmailTargetImpl emailTarget = new EmailTargetImpl();

    // Act and Assert
    assertTrue(nullEmailServiceImpl.sendBasicEmail(emailInfo, emailTarget, new HashMap<>()));
  }
}

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
package org.broadleafcommerce.common.email.service.message;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
  @MockBean
  private JavaMailSender javaMailSender;

  @Autowired
  private NullMessageCreator nullMessageCreator;

  /**
   * Test {@link NullMessageCreator#NullMessageCreator(JavaMailSender)}.
   * <p>
   * Method under test: {@link NullMessageCreator#NullMessageCreator(JavaMailSender)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NullMessageCreator.<init>(JavaMailSender)"})
  public void testNewNullMessageCreator() {
    // Arrange
    LoggingMailSender mailSender = new LoggingMailSender();

    // Act and Assert
    assertSame(mailSender, (new NullMessageCreator(mailSender)).getMailSender());
  }

  /**
   * Test {@link NullMessageCreator#buildMessageBody(EmailInfo, Map)}.
   * <ul>
   *   <li>When {@link EmailInfo} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NullMessageCreator#buildMessageBody(EmailInfo, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String NullMessageCreator.buildMessageBody(EmailInfo, Map)"})
  public void testBuildMessageBody_whenEmailInfo_thenReturnNull() {
    // Arrange
    EmailInfo info = new EmailInfo();

    // Act and Assert
    assertNull(nullMessageCreator.buildMessageBody(info, new HashMap<>()));
  }
}

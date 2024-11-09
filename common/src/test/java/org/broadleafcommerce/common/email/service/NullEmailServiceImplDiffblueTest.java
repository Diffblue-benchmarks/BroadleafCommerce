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

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.email.domain.EmailTarget;
import org.broadleafcommerce.common.email.domain.EmailTargetImpl;
import org.broadleafcommerce.common.email.service.info.EmailInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {NullEmailServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class NullEmailServiceImplDiffblueTest {
  @Autowired
  private NullEmailServiceImpl nullEmailServiceImpl;

  /**
   * Test {@link NullEmailServiceImpl#sendTemplateEmail(String, EmailInfo, Map)}
   * with {@code emailAddress}, {@code emailInfo}, {@code props}.
   * <ul>
   *   <li>When {@link EmailInfo} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NullEmailServiceImpl#sendTemplateEmail(String, EmailInfo, Map)}
   */
  @Test
  public void testSendTemplateEmailWithEmailAddressEmailInfoProps_whenEmailInfo() {
    // Arrange
    EmailInfo emailInfo = new EmailInfo();

    // Act and Assert
    assertTrue(nullEmailServiceImpl.sendTemplateEmail("42 Main St", emailInfo, new HashMap<>()));
  }

  /**
   * Test {@link NullEmailServiceImpl#sendTemplateEmail(String, EmailInfo, Map)}
   * with {@code emailAddress}, {@code emailInfo}, {@code props}.
   * <ul>
   *   <li>When {@link EmailInfo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NullEmailServiceImpl#sendTemplateEmail(String, EmailInfo, Map)}
   */
  @Test
  public void testSendTemplateEmailWithEmailAddressEmailInfoProps_whenEmailInfo2() {
    // Arrange
    EmailInfo emailInfo = mock(EmailInfo.class);

    // Act and Assert
    assertTrue(nullEmailServiceImpl.sendTemplateEmail("42 Main St", emailInfo, new HashMap<>()));
  }

  /**
   * Test
   * {@link NullEmailServiceImpl#sendTemplateEmail(EmailTarget, EmailInfo, Map)}
   * with {@code emailTarget}, {@code emailInfo}, {@code props}.
   * <ul>
   *   <li>When {@link EmailTargetImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NullEmailServiceImpl#sendTemplateEmail(EmailTarget, EmailInfo, Map)}
   */
  @Test
  public void testSendTemplateEmailWithEmailTargetEmailInfoProps_whenEmailTargetImpl() {
    // Arrange
    EmailTargetImpl emailTarget = new EmailTargetImpl();
    EmailInfo emailInfo = new EmailInfo();

    // Act and Assert
    assertTrue(nullEmailServiceImpl.sendTemplateEmail(emailTarget, emailInfo, new HashMap<>()));
  }

  /**
   * Test
   * {@link NullEmailServiceImpl#sendTemplateEmail(EmailTarget, EmailInfo, Map)}
   * with {@code emailTarget}, {@code emailInfo}, {@code props}.
   * <ul>
   *   <li>When {@link EmailTargetImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NullEmailServiceImpl#sendTemplateEmail(EmailTarget, EmailInfo, Map)}
   */
  @Test
  public void testSendTemplateEmailWithEmailTargetEmailInfoProps_whenEmailTargetImpl2() {
    // Arrange
    EmailTargetImpl emailTarget = mock(EmailTargetImpl.class);
    EmailInfo emailInfo = new EmailInfo();

    // Act and Assert
    assertTrue(nullEmailServiceImpl.sendTemplateEmail(emailTarget, emailInfo, new HashMap<>()));
  }

  /**
   * Test
   * {@link NullEmailServiceImpl#sendBasicEmail(EmailInfo, EmailTarget, Map)}.
   * <ul>
   *   <li>When {@link EmailInfo} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NullEmailServiceImpl#sendBasicEmail(EmailInfo, EmailTarget, Map)}
   */
  @Test
  public void testSendBasicEmail_whenEmailInfo() {
    // Arrange
    EmailInfo emailInfo = new EmailInfo();
    EmailTargetImpl emailTarget = new EmailTargetImpl();

    // Act and Assert
    assertTrue(nullEmailServiceImpl.sendBasicEmail(emailInfo, emailTarget, new HashMap<>()));
  }

  /**
   * Test
   * {@link NullEmailServiceImpl#sendBasicEmail(EmailInfo, EmailTarget, Map)}.
   * <ul>
   *   <li>When {@link EmailInfo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NullEmailServiceImpl#sendBasicEmail(EmailInfo, EmailTarget, Map)}
   */
  @Test
  public void testSendBasicEmail_whenEmailInfo2() {
    // Arrange
    EmailInfo emailInfo = mock(EmailInfo.class);
    EmailTargetImpl emailTarget = new EmailTargetImpl();

    // Act and Assert
    assertTrue(nullEmailServiceImpl.sendBasicEmail(emailInfo, emailTarget, new HashMap<>()));
  }
}

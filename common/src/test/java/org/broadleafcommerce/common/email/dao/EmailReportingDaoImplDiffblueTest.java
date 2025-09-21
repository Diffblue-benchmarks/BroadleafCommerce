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
package org.broadleafcommerce.common.email.dao;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.email.domain.EmailTarget;
import org.broadleafcommerce.common.email.domain.EmailTargetImpl;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EmailReportingDaoImplDiffblueTest {
  @InjectMocks private EmailReportingDaoImpl emailReportingDaoImpl;

  @Mock private EntityConfiguration entityConfiguration;

  /**
   * Test {@link EmailReportingDaoImpl#createTarget()}.
   *
   * <p>Method under test: {@link EmailReportingDaoImpl#createTarget()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EmailTarget EmailReportingDaoImpl.createTarget()"})
  public void testCreateTarget() {
    // Arrange
    EmailTargetImpl emailTargetImpl = new EmailTargetImpl();
    emailTargetImpl.setBCCAddresses(new String[] {"mary.somerville@example.org"});
    emailTargetImpl.setCCAddresses(new String[] {"42 Main St"});
    emailTargetImpl.setEmailAddress("42 Main St");
    when(entityConfiguration.createEntityInstance(Mockito.<String>any()))
        .thenReturn(emailTargetImpl);

    // Act
    EmailTarget actualCreateTargetResult = emailReportingDaoImpl.createTarget();

    // Assert
    verify(entityConfiguration)
        .createEntityInstance("org.broadleafcommerce.common.email.domain.EmailTarget");
    assertSame(emailTargetImpl, actualCreateTargetResult);
  }
}

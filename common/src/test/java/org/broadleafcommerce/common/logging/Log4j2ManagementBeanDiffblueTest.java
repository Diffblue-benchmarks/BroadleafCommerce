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
package org.broadleafcommerce.common.logging;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {Log4j2ManagementBean.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class Log4j2ManagementBeanDiffblueTest {
  @Autowired private Log4j2ManagementBean log4j2ManagementBean;

  /**
   * Test {@link Log4j2ManagementBean#getLevel(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link AbstractSupportLoggerAdapter#INFO}.
   * </ul>
   *
   * <p>Method under test: {@link Log4j2ManagementBean#getLevel(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Log4j2ManagementBean.getLevel(String)"})
  public void testGetLevel_whenNull_thenReturnInfo() {
    // Arrange, Act and Assert
    assertEquals(AbstractSupportLoggerAdapter.INFO, log4j2ManagementBean.getLevel(null));
  }
}

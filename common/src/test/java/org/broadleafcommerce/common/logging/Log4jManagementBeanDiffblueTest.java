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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {Log4jManagementBean.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class Log4jManagementBeanDiffblueTest {
  @Autowired
  private Log4jManagementBean log4jManagementBean;

  /**
   * Test {@link Log4jManagementBean#activateInfo(String)}.
   * <ul>
   *   <li>When {@code Category}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Log4jManagementBean#activateInfo(String)}
   */
  @Test
  public void testActivateInfo_whenCategory() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    log4jManagementBean.activateInfo("Category");
  }

  /**
   * Test {@link Log4jManagementBean#activateDebug(String)}.
   * <ul>
   *   <li>When {@code Category}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Log4jManagementBean#activateDebug(String)}
   */
  @Test
  public void testActivateDebug_whenCategory() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    log4jManagementBean.activateDebug("Category");
  }

  /**
   * Test {@link Log4jManagementBean#activateWarn(String)}.
   * <ul>
   *   <li>When {@code Category}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Log4jManagementBean#activateWarn(String)}
   */
  @Test
  public void testActivateWarn_whenCategory() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    log4jManagementBean.activateWarn("Category");
  }

  /**
   * Test {@link Log4jManagementBean#activateError(String)}.
   * <ul>
   *   <li>When {@code Category}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Log4jManagementBean#activateError(String)}
   */
  @Test
  public void testActivateError_whenCategory() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    log4jManagementBean.activateError("Category");
  }

  /**
   * Test {@link Log4jManagementBean#activateFatal(String)}.
   * <ul>
   *   <li>When {@code Category}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Log4jManagementBean#activateFatal(String)}
   */
  @Test
  public void testActivateFatal_whenCategory() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    log4jManagementBean.activateFatal("Category");
  }

  /**
   * Test {@link Log4jManagementBean#getLevel(String)}.
   * <p>
   * Method under test: {@link Log4jManagementBean#getLevel(String)}
   */
  @Test
  public void testGetLevel() {
    // Arrange, Act and Assert
    assertEquals(AbstractSupportLoggerAdapter.WARN, log4jManagementBean.getLevel("Category"));
  }

  /**
   * Test new {@link Log4jManagementBean} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link Log4jManagementBean}
   */
  @Test
  public void testNewLog4jManagementBean() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   There are no fields that could be asserted on.

    // Arrange and Act
    new Log4jManagementBean();
  }
}

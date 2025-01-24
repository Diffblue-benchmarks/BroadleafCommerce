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

@ContextConfiguration(classes = {Log4j2ManagementBean.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class Log4j2ManagementBeanDiffblueTest {
  @Autowired
  private Log4j2ManagementBean log4j2ManagementBean;

  /**
   * Test {@link Log4j2ManagementBean#activateInfo(String)}.
   * <ul>
   *   <li>When {@code Category}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Log4j2ManagementBean#activateInfo(String)}
   */
  @Test
  public void testActivateInfo_whenCategory() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    log4j2ManagementBean.activateInfo("Category");
  }

  /**
   * Test {@link Log4j2ManagementBean#activateDebug(String)}.
   * <ul>
   *   <li>When {@code Category}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Log4j2ManagementBean#activateDebug(String)}
   */
  @Test
  public void testActivateDebug_whenCategory() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    log4j2ManagementBean.activateDebug("Category");
  }

  /**
   * Test {@link Log4j2ManagementBean#activateWarn(String)}.
   * <ul>
   *   <li>When {@code Category}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Log4j2ManagementBean#activateWarn(String)}
   */
  @Test
  public void testActivateWarn_whenCategory() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    log4j2ManagementBean.activateWarn("Category");
  }

  /**
   * Test {@link Log4j2ManagementBean#activateError(String)}.
   * <ul>
   *   <li>When {@code Category}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Log4j2ManagementBean#activateError(String)}
   */
  @Test
  public void testActivateError_whenCategory() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    log4j2ManagementBean.activateError("Category");
  }

  /**
   * Test {@link Log4j2ManagementBean#activateFatal(String)}.
   * <ul>
   *   <li>When {@code Category}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Log4j2ManagementBean#activateFatal(String)}
   */
  @Test
  public void testActivateFatal_whenCategory() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    log4j2ManagementBean.activateFatal("Category");
  }

  /**
   * Test {@link Log4j2ManagementBean#getLevel(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Log4j2ManagementBean#getLevel(String)}
   */
  @Test
  public void testGetLevel_when42() {
    // Arrange, Act and Assert
    assertEquals(AbstractSupportLoggerAdapter.WARN, log4j2ManagementBean.getLevel("42"));
  }

  /**
   * Test {@link Log4j2ManagementBean#getLevel(String)}.
   * <ul>
   *   <li>When {@code Category}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Log4j2ManagementBean#getLevel(String)}
   */
  @Test
  public void testGetLevel_whenCategory() {
    // Arrange, Act and Assert
    assertEquals(AbstractSupportLoggerAdapter.WARN, log4j2ManagementBean.getLevel("Category"));
  }

  /**
   * Test new {@link Log4j2ManagementBean} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link Log4j2ManagementBean}
   */
  @Test
  public void testNewLog4j2ManagementBean() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   There are no fields that could be asserted on.

    // Arrange and Act
    new Log4j2ManagementBean();
  }
}

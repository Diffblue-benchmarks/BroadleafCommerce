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

import static org.junit.Assert.assertNull;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {SupportLogger.class, String.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SupportLoggerDiffblueTest {
  @Autowired
  private SupportLogger supportLogger;

  /**
   * Test {@link SupportLogger#SupportLogger(String, String)}.
   * <p>
   * Method under test: {@link SupportLogger#SupportLogger(String, String)}
   */
  @Test
  public void testNewSupportLogger() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    new SupportLogger("Module Name", "Name");

  }

  /**
   * Test {@link SupportLogger#support(Object)} with {@code message}.
   * <p>
   * Method under test: {@link SupportLogger#support(Object)}
   */
  @Test
  public void testSupportWithMessage() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    ProcessDetailLogger.LOGGER.support(BLCFieldUtils.NULL_FIELD);
  }

  /**
   * Test {@link SupportLogger#support(Object, Throwable)} with {@code message},
   * {@code t}.
   * <p>
   * Method under test: {@link SupportLogger#support(Object, Throwable)}
   */
  @Test
  public void testSupportWithMessageT() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    ProcessDetailLogger.LOGGER.support(BLCFieldUtils.NULL_FIELD, new Throwable());
  }

  /**
   * Test {@link SupportLogger#lifecycle(LifeCycleEvent, Object)}.
   * <ul>
   *   <li>When {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SupportLogger#lifecycle(LifeCycleEvent, Object)}
   */
  @Test
  public void testLifecycle_whenNull_field() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    ProcessDetailLogger.LOGGER.lifecycle(LifeCycleEvent.START, BLCFieldUtils.NULL_FIELD);
  }

  /**
   * Test {@link SupportLogger#debug(Object)} with {@code message}.
   * <p>
   * Method under test: {@link SupportLogger#debug(Object)}
   */
  @Test
  public void testDebugWithMessage() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    ProcessDetailLogger.LOGGER.debug(BLCFieldUtils.NULL_FIELD);
  }

  /**
   * Test {@link SupportLogger#debug(Object, Throwable)} with {@code message},
   * {@code t}.
   * <p>
   * Method under test: {@link SupportLogger#debug(Object, Throwable)}
   */
  @Test
  public void testDebugWithMessageT() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    ProcessDetailLogger.LOGGER.debug(BLCFieldUtils.NULL_FIELD, new Throwable());
  }

  /**
   * Test {@link SupportLogger#error(Object)} with {@code message}.
   * <p>
   * Method under test: {@link SupportLogger#error(Object)}
   */
  @Test
  public void testErrorWithMessage() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    ProcessDetailLogger.LOGGER.error(BLCFieldUtils.NULL_FIELD);
  }

  /**
   * Test {@link SupportLogger#error(Object, Throwable)} with {@code message},
   * {@code t}.
   * <p>
   * Method under test: {@link SupportLogger#error(Object, Throwable)}
   */
  @Test
  public void testErrorWithMessageT() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    ProcessDetailLogger.LOGGER.error(BLCFieldUtils.NULL_FIELD, new Throwable());
  }

  /**
   * Test {@link SupportLogger#fatal(Object)} with {@code message}.
   * <p>
   * Method under test: {@link SupportLogger#fatal(Object)}
   */
  @Test
  public void testFatalWithMessage() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    ProcessDetailLogger.LOGGER.fatal(BLCFieldUtils.NULL_FIELD);
  }

  /**
   * Test {@link SupportLogger#fatal(Object, Throwable)} with {@code message},
   * {@code t}.
   * <p>
   * Method under test: {@link SupportLogger#fatal(Object, Throwable)}
   */
  @Test
  public void testFatalWithMessageT() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    ProcessDetailLogger.LOGGER.fatal(BLCFieldUtils.NULL_FIELD, new Throwable());
  }

  /**
   * Test {@link SupportLogger#info(Object)} with {@code message}.
   * <p>
   * Method under test: {@link SupportLogger#info(Object)}
   */
  @Test
  public void testInfoWithMessage() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    ProcessDetailLogger.LOGGER.info(BLCFieldUtils.NULL_FIELD);
  }

  /**
   * Test {@link SupportLogger#info(Object, Throwable)} with {@code message},
   * {@code t}.
   * <p>
   * Method under test: {@link SupportLogger#info(Object, Throwable)}
   */
  @Test
  public void testInfoWithMessageT() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    ProcessDetailLogger.LOGGER.info(BLCFieldUtils.NULL_FIELD, new Throwable());
  }

  /**
   * Test {@link SupportLogger#warn(Object)} with {@code message}.
   * <p>
   * Method under test: {@link SupportLogger#warn(Object)}
   */
  @Test
  public void testWarnWithMessage() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    ProcessDetailLogger.LOGGER.warn(BLCFieldUtils.NULL_FIELD);
  }

  /**
   * Test {@link SupportLogger#warn(Object, Throwable)} with {@code message},
   * {@code t}.
   * <p>
   * Method under test: {@link SupportLogger#warn(Object, Throwable)}
   */
  @Test
  public void testWarnWithMessageT() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    ProcessDetailLogger.LOGGER.warn(BLCFieldUtils.NULL_FIELD, new Throwable());
  }

  /**
   * Test {@link SupportLogger#getSupportLoggerAdapterFQCN()}.
   * <p>
   * Method under test: {@link SupportLogger#getSupportLoggerAdapterFQCN()}
   */
  @Test
  public void testGetSupportLoggerAdapterFQCN() {
    // Arrange, Act and Assert
    assertNull(SupportLogger.getSupportLoggerAdapterFQCN());
  }
}

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

@ContextConfiguration(classes = {SLF4JSupportLoggerAdapter.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SLF4JSupportLoggerAdapterDiffblueTest {
  @Autowired
  private SLF4JSupportLoggerAdapter sLF4JSupportLoggerAdapter;

  /**
   * Test {@link SLF4JSupportLoggerAdapter#support(String)} with {@code message}.
   * <p>
   * Method under test: {@link SLF4JSupportLoggerAdapter#support(String)}
   */
  @Test
  public void testSupportWithMessage() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    sLF4JSupportLoggerAdapter.support("Not all who wander are lost");
  }

  /**
   * Test {@link SLF4JSupportLoggerAdapter#support(String, Throwable)} with
   * {@code message}, {@code t}.
   * <p>
   * Method under test:
   * {@link SLF4JSupportLoggerAdapter#support(String, Throwable)}
   */
  @Test
  public void testSupportWithMessageT() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    sLF4JSupportLoggerAdapter.support("Not all who wander are lost", new Throwable());
  }

  /**
   * Test {@link SLF4JSupportLoggerAdapter#lifecycle(LifeCycleEvent, String)}.
   * <ul>
   *   <li>When {@code START}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SLF4JSupportLoggerAdapter#lifecycle(LifeCycleEvent, String)}
   */
  @Test
  public void testLifecycle_whenStart() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    sLF4JSupportLoggerAdapter.lifecycle(LifeCycleEvent.START, "Not all who wander are lost");
  }

  /**
   * Test {@link SLF4JSupportLoggerAdapter#debug(String, Throwable)} with
   * {@code message}, {@code t}.
   * <p>
   * Method under test: {@link SLF4JSupportLoggerAdapter#debug(String, Throwable)}
   */
  @Test
  public void testDebugWithMessageT() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    sLF4JSupportLoggerAdapter.debug("Not all who wander are lost", new Throwable());
  }

  /**
   * Test {@link SLF4JSupportLoggerAdapter#debug(String)} with {@code message}.
   * <ul>
   *   <li>When {@code Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SLF4JSupportLoggerAdapter#debug(String)}
   */
  @Test
  public void testDebugWithMessage_whenNotAllWhoWanderAreLost() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    sLF4JSupportLoggerAdapter.debug("Not all who wander are lost");
  }

  /**
   * Test {@link SLF4JSupportLoggerAdapter#error(String)} with {@code message}.
   * <p>
   * Method under test: {@link SLF4JSupportLoggerAdapter#error(String)}
   */
  @Test
  public void testErrorWithMessage() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    sLF4JSupportLoggerAdapter.error("Not all who wander are lost");
  }

  /**
   * Test {@link SLF4JSupportLoggerAdapter#error(String, Throwable)} with
   * {@code message}, {@code t}.
   * <p>
   * Method under test: {@link SLF4JSupportLoggerAdapter#error(String, Throwable)}
   */
  @Test
  public void testErrorWithMessageT() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    sLF4JSupportLoggerAdapter.error("Not all who wander are lost", new Throwable());
  }

  /**
   * Test {@link SLF4JSupportLoggerAdapter#fatal(String)} with {@code message}.
   * <p>
   * Method under test: {@link SLF4JSupportLoggerAdapter#fatal(String)}
   */
  @Test
  public void testFatalWithMessage() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    sLF4JSupportLoggerAdapter.fatal("Not all who wander are lost");
  }

  /**
   * Test {@link SLF4JSupportLoggerAdapter#fatal(String, Throwable)} with
   * {@code message}, {@code t}.
   * <p>
   * Method under test: {@link SLF4JSupportLoggerAdapter#fatal(String, Throwable)}
   */
  @Test
  public void testFatalWithMessageT() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    sLF4JSupportLoggerAdapter.fatal("Not all who wander are lost", new Throwable());
  }

  /**
   * Test {@link SLF4JSupportLoggerAdapter#info(String)} with {@code message}.
   * <p>
   * Method under test: {@link SLF4JSupportLoggerAdapter#info(String)}
   */
  @Test
  public void testInfoWithMessage() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    sLF4JSupportLoggerAdapter.info("Not all who wander are lost");
  }

  /**
   * Test {@link SLF4JSupportLoggerAdapter#info(String, Throwable)} with
   * {@code message}, {@code t}.
   * <p>
   * Method under test: {@link SLF4JSupportLoggerAdapter#info(String, Throwable)}
   */
  @Test
  public void testInfoWithMessageT() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    sLF4JSupportLoggerAdapter.info("Not all who wander are lost", new Throwable());
  }

  /**
   * Test {@link SLF4JSupportLoggerAdapter#warn(String)} with {@code message}.
   * <p>
   * Method under test: {@link SLF4JSupportLoggerAdapter#warn(String)}
   */
  @Test
  public void testWarnWithMessage() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    sLF4JSupportLoggerAdapter.warn("Not all who wander are lost");
  }

  /**
   * Test {@link SLF4JSupportLoggerAdapter#warn(String, Throwable)} with
   * {@code message}, {@code t}.
   * <p>
   * Method under test: {@link SLF4JSupportLoggerAdapter#warn(String, Throwable)}
   */
  @Test
  public void testWarnWithMessageT() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    sLF4JSupportLoggerAdapter.warn("Not all who wander are lost", new Throwable());
  }

  /**
   * Test {@link SLF4JSupportLoggerAdapter#mapSupportLevel(String, Throwable)}.
   * <p>
   * Method under test:
   * {@link SLF4JSupportLoggerAdapter#mapSupportLevel(String, Throwable)}
   */
  @Test
  public void testMapSupportLevel() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    sLF4JSupportLoggerAdapter.mapSupportLevel("Not all who wander are lost", new Throwable());
  }

  /**
   * Test {@link SLF4JSupportLoggerAdapter#getSupportLevel()}.
   * <p>
   * Method under test: {@link SLF4JSupportLoggerAdapter#getSupportLevel()}
   */
  @Test
  public void testGetSupportLevel() {
    // Arrange, Act and Assert
    assertEquals(AbstractSupportLoggerAdapter.LOG_LEVEL_WARN, (new SLF4JSupportLoggerAdapter()).getSupportLevel());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SLF4JSupportLoggerAdapter}
   *   <li>{@link SLF4JSupportLoggerAdapter#setName(String)}
   *   <li>{@link SLF4JSupportLoggerAdapter#getName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SLF4JSupportLoggerAdapter actualSlf4jSupportLoggerAdapter = new SLF4JSupportLoggerAdapter();
    actualSlf4jSupportLoggerAdapter.setName("Name");

    // Assert that nothing has changed
    assertEquals("Name", actualSlf4jSupportLoggerAdapter.getName());
  }
}

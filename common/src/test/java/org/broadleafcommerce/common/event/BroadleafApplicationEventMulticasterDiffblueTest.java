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
package org.broadleafcommerce.common.event;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import java.util.concurrent.Executor;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;

public class BroadleafApplicationEventMulticasterDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link BroadleafApplicationEventMulticaster#setApplicationContext(ApplicationContext)}
   *   <li>{@link BroadleafApplicationEventMulticaster#setTaskExecutor(Executor)}
   *   <li>{@link BroadleafApplicationEventMulticaster#getTaskExecutor()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws BeansException {
    // Arrange
    BroadleafApplicationEventMulticaster broadleafApplicationEventMulticaster = new BroadleafApplicationEventMulticaster();

    // Act
    broadleafApplicationEventMulticaster.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());
    Executor taskExecutor = mock(Executor.class);
    broadleafApplicationEventMulticaster.setTaskExecutor(taskExecutor);

    // Assert that nothing has changed
    assertSame(taskExecutor, broadleafApplicationEventMulticaster.getTaskExecutor());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link BroadleafApplicationEventMulticaster#setApplicationContext(ApplicationContext)}
   *   <li>{@link BroadleafApplicationEventMulticaster#setTaskExecutor(Executor)}
   *   <li>{@link BroadleafApplicationEventMulticaster#getTaskExecutor()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() throws BeansException {
    // Arrange
    BroadleafApplicationEventMulticaster broadleafApplicationEventMulticaster = new BroadleafApplicationEventMulticaster();

    // Act
    broadleafApplicationEventMulticaster.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());
    Executor taskExecutor = mock(Executor.class);
    broadleafApplicationEventMulticaster.setTaskExecutor(taskExecutor);

    // Assert that nothing has changed
    assertSame(taskExecutor, broadleafApplicationEventMulticaster.getTaskExecutor());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link BroadleafApplicationEventMulticaster}
   */
  @Test
  public void testNewBroadleafApplicationEventMulticaster() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    BroadleafApplicationEventMulticaster actualBroadleafApplicationEventMulticaster = new BroadleafApplicationEventMulticaster();

    // Assert
    assertNull(actualBroadleafApplicationEventMulticaster.getTaskExecutor());
    assertNull(actualBroadleafApplicationEventMulticaster.ctx);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link BroadleafApplicationEventMulticaster}
   */
  @Test
  public void testNewBroadleafApplicationEventMulticaster2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    BroadleafApplicationEventMulticaster actualBroadleafApplicationEventMulticaster = new BroadleafApplicationEventMulticaster();

    // Assert
    assertNull(actualBroadleafApplicationEventMulticaster.getTaskExecutor());
    assertNull(actualBroadleafApplicationEventMulticaster.ctx);
  }
}
